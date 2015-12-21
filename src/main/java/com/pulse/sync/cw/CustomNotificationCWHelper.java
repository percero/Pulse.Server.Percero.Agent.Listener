package com.pulse.sync.cw;

import java.text.MessageFormat;
import java.util.*;

import javax.annotation.PostConstruct;

import com.percero.agents.sync.exceptions.SyncException;
import com.percero.agents.sync.vo.BaseDataObject;
import com.pulse.mo.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.percero.agents.sync.cw.ChangeWatcherHelper;
import com.percero.agents.sync.cw.ChangeWatcherHelperFactory;
import com.percero.agents.sync.services.ISyncAgentService;
import com.percero.agents.sync.vo.ClassIDPair;
import com.percero.framework.vo.IPerceroObject;

// This should get picked up by Spring and be auto-wired.
@Component
public class CustomNotificationCWHelper extends ChangeWatcherHelper {


    private static final Logger log = Logger.getLogger(CustomNotificationCWHelper.class);

    //CMSEntry based Notifications Messages
    private static final String WORK_MODE_DURATION_NOTIIFCATION_MESSAGE = "Duration Tolerance | {0} : System has detected a CMS aux code {1} starting at {2} and ending at {3} for the total duration of {4}  has exceeded the durration tolerance.";
    private static final String WORK_MODE_OCCURRENCE_NOTIIFCATION_MESSAGE = "Occurrence Tolerance | {0} : System has detected a CMS aux code {1} starting at {2} and ending at {3} has occurred more times than the tolerance of {4}.";


    //Timecard based Notifications Messages
    private static final String INVALID_ACTIVITY_CODE_NOTIIFCATION_MESSAGE = "Invalid Activity Code | {0} : System has detected an invalid activity code {1} starting at {2} and ending at {3}";
    private static final String NONBILLABLE_ACTIVITY_CODE_NOTIIFCATION_MESSAGE = "Non-billable Activity | {0} : System has detected a non-billable activity code {1} starting at {2} and ending at {3}";
    private static final String OCCURRENCE_TOLERANCE_NOTIIFCATION_MESSAGE = "Occurrence Tolerance | {0} : System has detected an eStart activity code {1} starting at {2} and ending at {3} has occurred more times than the tolerance of {4}.";
    private static final String DURATION_TOLERANCE_NOTIIFCATION_MESSAGE = "Duration Tolerance | {0} System has detected an eStart activity code {1} starting at {2} and ending at {3} for the total duration of {4}  has exceeded the durration tolerance.";
    private static final String DURATION_MISMATCH_NOTIFICATION_MESSAGE = "Phone Time Variance | {0} : System has detected eStart activity code {1} starting at {2} and ending at {3} does not match CMS duration.";



    // This is required for CUSTOM change watchers.
    private static final String CATEGORY = "CUSTOM";
    // This is an optional sub category.
    private static final String SUB_CATEGORY = "";

    @Autowired
    protected ISyncAgentService syncAgentService;

    public void setSyncAgentService(ISyncAgentService value) {
        syncAgentService = value;
    }

    public ISyncAgentService getSyncAgentService() {
        return syncAgentService;
    }

    @PostConstruct
    public void initialize() {
        ChangeWatcherHelperFactory.getInstance().registerChangeWatcherHelper(CATEGORY, this);
        registerChangeWatchers();
    }

    /**
     * Registers the Objects that this Change Watcher cares about. To register
     * for all objects of a particular type, use the ID "0".
     */
    public void registerChangeWatchers() {
        //Do not register watcher to avoid lots activity in local instance and avoid log.

        // CMS Entry Notification
        Collection<String> cmsEntryFieldsToWatch = new HashSet<String>();

        Collection<String> timecardEntryFieldsToWatch = new HashSet<String>();
        Collection<String> timecardFieldsToWatch = new HashSet<String>();
        // Listen for changes on ALL CMSEntry records.
        accessManager.addWatcherField(new ClassIDPair("0", CMSEntry.class.getCanonicalName()), "", cmsEntryFieldsToWatch);
        accessManager.addWatcherField(new ClassIDPair("0", TimecardEntry.class.getCanonicalName()), "", timecardEntryFieldsToWatch);
//        accessManager.addWatcherField(new ClassIDPair("0", Timecard.class.getCanonicalName()), "", timecardFieldsToWatch);
        // Register the fields. This can always be called again with an updated
        // list of fields to watch, which would overwrite the list of fields
        // that trigger this change watcher code.
        accessManager.updateWatcherFields(CATEGORY, SUB_CATEGORY, "handleCmsEntryNotification", cmsEntryFieldsToWatch);
        accessManager.updateWatcherFields(CATEGORY, SUB_CATEGORY, "handleTimecardEntryNotification", timecardEntryFieldsToWatch);
//        accessManager.updateWatcherFields(CATEGORY, SUB_CATEGORY, "handleTimecardEntryNotification", timecardFieldsToWatch);
    }

    /* (non-Javadoc)
     * @see com.percero.agents.sync.cw.ChangeWatcherHelper#process(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public Object process(String category, String subCategory, String fieldName) {
        return process(category, subCategory, fieldName, null);
    }

    /* (non-Javadoc)
     * @see com.percero.agents.sync.cw.ChangeWatcherHelper#process(java.lang.String, java.lang.String, java.lang.String, java.lang.String[])
     */
    @Override
    public Object process(String category, String subCategory, String fieldName, String[] params) {
        if (fieldName.equalsIgnoreCase("handleCmsEntryNotification")) {
            try {
                handleCmsEntryNotification(category, subCategory, fieldName, params);
            } catch (Exception e) {
                log.error("Unable to process handleCmsEntryNotification", e);
            }
            return null;
        } else if (fieldName.equalsIgnoreCase("handleTimecardEntryNotification")) {
            try {
                handleTimecardEntryNotification(category, subCategory, fieldName, params);
            } catch (Exception e) {
                log.error("Unable to process handleTimecardEntryNotification", e);
            }
            return null;
        } else {
            return super.process(category, subCategory, fieldName, params);
        }
    }


    /**
     * @param category
     * @param subCategory
     * @param fieldName
     * @throws Exception
     */
    private void handleCmsEntryNotification(String category, String subCategory, String fieldName, String[] params) throws Exception {
        // This is where the logic would go to create a Notification based on when the data requested above changes.
        try {

            if (params != null && params.length >= 2) {
                String className = params[0];
                String classId = params[1];

                ClassIDPair classIdPair = new ClassIDPair(classId, className);
                IPerceroObject updatedObject = syncAgentService.systemGetById(classIdPair);

                if (updatedObject instanceof CMSEntry) {
                    CMSEntry cmsEntry = (CMSEntry) updatedObject;
                    Agent agent = null;
                    TeamLeader teamLeader = null;

                    if (cmsEntry != null) {
                        //Entry Inserted/Updated and Watcher invoked by ActiveStack when UpdateTableProcessor processed it and updated Redis Cache

                        // 1. Check for Work Mode DURATION Tolerance

                        //Work Mode Duration
                        //For the watched CMSEntry,
                        //Use the AuxCode in the Entry and look into the configuration.
                        //Use min and max value associated with it to check the duration is within the allowed range.
                        //In condition fails, generate notification
                        //For now AuxCode look-up is assumed and possible retrived min/max is hard-coded in the logic.

//                        cmsEntry.getCMSAuxMode()
                        if (agent == null) {
                            agent = syncAgentService.systemGetByObject(cmsEntry.getAgent());
                        }

                        if (agent != null) {

                            if (agent.getAgentLOBs().size() == 1) {

                                //Valid scenario for notification
                                AgentLOB agentLOB = syncAgentService.systemGetByObject(agent.getAgentLOBs().get(0));

                                if (agentLOB != null) {

                                    LOB lob = syncAgentService.systemGetByObject(agentLOB.getLOB());

                                    if (lob != null) {

                                        List<LOBConfiguration> lobConfigurationList = lob.getLOBConfigurations();

                                        if (lobConfigurationList != null && lobConfigurationList.size() > 0) {

                                            LOBConfiguration lobConfiguration = syncAgentService.systemGetByObject(lobConfigurationList.get(0));
                                            Iterator<LOBConfigurationEntry> itrLobConfigurationEntry = lobConfiguration.getLOBConfigurationEntries().iterator();

                                            while (itrLobConfigurationEntry.hasNext()) {

                                                LOBConfigurationEntry lobConfigurationEntry = syncAgentService.systemGetByObject(itrLobConfigurationEntry.next());

                                                if ("CMS_AUX_CODE".equals(lobConfigurationEntry.getType())) {
                                                    if ((lobConfigurationEntry.getCMSAuxCode() == null && cmsEntry.getCMSAuxMode() == null) ||
                                                            (lobConfigurationEntry.getCMSAuxCode() != null &&
                                                                    cmsEntry.getCMSAuxMode() != null &&
                                                                    lobConfigurationEntry.getCMSAuxCode().equals(cmsEntry.getCMSAuxMode()))) {
                                                        //valid logic
                                                        //Logically there will be only one entry per AuxCode so this condition will be invoked only once
                                                        //This implies that only one notiifcation of each type can be generated.
                                                        generateWorkDurationNotification(cmsEntry, agent, teamLeader, lobConfiguration, lobConfigurationEntry);
                                                        generateWorkModeOccurrenceNotification(cmsEntry, agent, teamLeader, lobConfiguration, lobConfigurationEntry);

                                                    }

                                                }
                                            }

                                        }
                                    }
                                }
                            }
//                            else {
//                                //Not a Valid scenario for notification
//                                // Do not send notification
//                                log.info("****** CMS Entry based notification is not generated due to following configuration ******");
//                                log.info("Agent : " + agent.getID() + " : CMSEntry : " + cmsEntry.getID() + " having AgentLOB Count (" + agent.getAgentLOBs().size() + ") - But only ONE AgentLOB expected");
//                            }
                        }


                        // 2.


                        // 3.


                        // 4.

                    }
                    else{
                        //Entry DELETED and Watcher invoked by ActiveStack when UpdateTableProcessor processed it and updated Redis Cache
                        //This is a special case where CMSEntry is deleted but watched by Watcher since there is change in the Entry/Object.
                        //When try to rerieve using SyncEngine syncAgentService it returns NULL because the object is deleted.
                        //This is a situation where we need to clean the orphaned notifications associated with deleted entry

                        CMSEntry criteriaCMSEntry = new CMSEntry();
                        criteriaCMSEntry.setID(classId);

                        LOBConfigurationNotification searchAndDeleteLOBNotification = new LOBConfigurationNotification();
                        searchAndDeleteLOBNotification.setCMSEntry(criteriaCMSEntry);

                        deleteOrphanedNotifications(searchAndDeleteLOBNotification);


                    }

                }
            }
        } catch (Exception e) {
            // Handle exception
            log.error("Error in LOB Notification", e);
        }
    }

    /**
     * @param category
     * @param subCategory
     * @param fieldName
     * @throws Exception
     */
    private void handleTimecardEntryNotification(String category, String subCategory, String fieldName, String[] params) throws Exception {
        // This is where the logic would go to create a Notification based on when the data requested above changes.
        try {

            if (params != null && params.length >= 2) {
                String className = params[0];
                String classId = params[1];

                ClassIDPair classIdPair = new ClassIDPair(classId, className);
                IPerceroObject updatedObject = syncAgentService.systemGetById(classIdPair);

                if (updatedObject instanceof TimecardEntry) {
                    TimecardEntry timecardEntry = (TimecardEntry) updatedObject;
                    Agent agent = null;
                    TeamLeader teamLeader = null;

                    // DO NOT CHANGE THE CONDITION, THIS WILL MAKE SYSTEM CRAZY SINCE THERE ARE LOTS OF SYSTEM GENERATED TIMECARD ENTRIES HAVING EStartProjectName = 'IEX'
                    // This is explicit condition other than NULL timecard, if the timecardEntry's EStartProjectName is "IEX"
                    // means the entry is genertaed by system not the one entered by Agent, hence there is no need to process it.
                    // No notification on system generated Entries.
                    if (timecardEntry != null && !timecardEntry.getEStartProjectName().equalsIgnoreCase("IEX")) {
                        //Entry Inserted/Updated and Watcher invoked by ActiveStack when UpdateTableProcessor processed it and updated Redis Cache

                        // 1. eStart InValid Activity code

                        //For the watched TimecarEntry,
                        //Use the ActivityCode in the Entry and look into the configuration Along with key for "NON-BILLABLE" (Still need to be decided for the key).
                        //If timecardEntry.getTimecardActivity().getCode() is in the list of activitycode retrived from LOBConfig, it is nonbillable activity code
                        //In condition fails, generate notification

                        if (agent == null) {
                            agent = syncAgentService.systemGetByObject(timecardEntry.getAgent());
                        }

                        if (agent != null) {
                            if (agent.getAgentLOBs().size() == 1) {
                                //Valid scenario for notification
                                //Pick up the first AgentLOB because it is assumed that if Agent has other than 1 AgentLOB it is invalid scenario for Notification
                                AgentLOB agentLOB = syncAgentService.systemGetByObject(agent.getAgentLOBs().get(0));

                                if (agentLOB != null) {

                                    LOB lob = syncAgentService.systemGetByObject(agentLOB.getLOB());

                                    if (lob != null) {

                                        List<LOBConfiguration> lobConfigurationList = lob.getLOBConfigurations();

                                        if (lobConfigurationList != null & lobConfigurationList.size() > 0) {

                                            //Preloading objects inorder do code duplication in subsequent calls.
                                            //Not passing them due to avoid long signatures. This will not make performance impact because rest
                                            //is in memory operations
                                            Timecard timecard = syncAgentService.systemGetByObject(timecardEntry.getTimecard());
                                            TimecardActivity timecarActivity = syncAgentService.systemGetByObject(timecardEntry.getTimecardActivity());

                                            List<TimecardEntry> consecutiveActivityList = new ArrayList<TimecardEntry>();

                                            Double consecutiveActivityDuration = getConsecutiveActivityCodeDetailFromTimecard(agent, timecardEntry, timecarActivity.getCode(), consecutiveActivityList);

                                            //Since the AgentLOB is associative entity between Agent and LOB it is always one to one relation.
                                            // LobConfiguration has lob Id which support the 1 to 1 relationship hence it is assumed to have only one recode and always pick
                                            // the first record.
                                            // TODO: TO BE CONFIRMED WITH RICHARD.
                                            LOBConfiguration lobConfiguration = syncAgentService.systemGetByObject(lobConfigurationList.get(0));

                                            List<String> validActivityCodeList = new ArrayList<String>();
                                            List<String> nonBillableActivityCodeList = new ArrayList<String>();

                                            Iterator<LOBConfigurationEntry> itrLobConfigurationEntry = lobConfiguration.getLOBConfigurationEntries().iterator();

                                            while (itrLobConfigurationEntry.hasNext()) {

                                                LOBConfigurationEntry lobConfigurationEntry = syncAgentService.systemGetByObject(itrLobConfigurationEntry.next());

                                                if (lobConfigurationEntry != null && lobConfigurationEntry.getType() != null && lobConfigurationEntry.getESTARTActivityCode() != null) {

                                                    if ("VALID_ACTIVITY_CODE".equals(lobConfigurationEntry.getType())) {


                                                        validActivityCodeList.add(lobConfigurationEntry.getESTARTActivityCode());


                                                        if ((lobConfigurationEntry.getESTARTActivityCode() == null && timecarActivity.getCode() == null) ||
                                                                (lobConfigurationEntry.getESTARTActivityCode() != null && timecarActivity.getCode() != null &&
                                                                        lobConfigurationEntry.getESTARTActivityCode().equals(timecarActivity.getCode()))) {

                                                            generateOccurrenceToleranceNotification(timecardEntry, agent, teamLeader,
                                                                    lobConfiguration, lobConfigurationEntry, consecutiveActivityList);

                                                            generateDurationToleranceNotification(timecardEntry, agent, teamLeader,
                                                                    lobConfiguration, lobConfigurationEntry, consecutiveActivityDuration);

                                                            generatePhoneTimeVarianceNotification(timecardEntry, agent, teamLeader,
                                                                    lobConfiguration, lobConfigurationEntry, consecutiveActivityList);

                                                        }
                                                    } else if ("NONBILLABLE_ACTIVITY_CODE".equals(lobConfigurationEntry.getType())) {


                                                        nonBillableActivityCodeList.add(lobConfigurationEntry.getESTARTActivityCode());

                                                    }
                                                }
                                            }


                                            //Generate Invalid Activity Code Notification if TimecardEntry Activity's activity code is not in the list of valid code
                                            generateInvalidActivityCodeNotification(timecardEntry, agent, teamLeader, validActivityCodeList, lobConfiguration);

                                            //Generate NonBillable Activity Code Notification if TimecardEntry Activity's activity code is in the list of NonBillable code
                                            generateNonBillableActivityCodeNotification(timecardEntry, agent, teamLeader, nonBillableActivityCodeList, lobConfiguration);


                                        }

                                    }
                                }
                            }
//                            else {
//
//                                //Not a Valid scenario for notification
//                                // Do not send notification
//                                log.info("****** TimeCard Entry based notification is not generated due to following configuration ******");
//                                log.info("Agent : " + agent.getID() + " : TimecardEntry : " + timecardEntry.getID() + " having AgentLOB Count (" + agent.getAgentLOBs().size() + ") - But only ONE AgentLOB expected");
//                            }
                        }


                        // 3.


                        // 4.

                    }
                    else{
                        //Entry DELETED and Watcher invoked by ActiveStack when UpdateTableProcessor processed it and updated Redis Cache
                        //This is a special case where TimecarEntry is deleted but watched by Watcher since there is change in the Entry/Object.
                        //When try to rerieve using SyncEngine syncAgentService it returns NULL because the object is deleted.
                        //This is a situation where we need to clean the orphaned notifications associated with deleted entry
                        TimecardEntry criteriaTimecardEntry = new TimecardEntry();
                        criteriaTimecardEntry.setID(classId);

                        LOBConfigurationNotification searchAndDeleteLOBNotification = new LOBConfigurationNotification();
                        searchAndDeleteLOBNotification.setTimecardEntry(criteriaTimecardEntry);

                        deleteOrphanedNotifications(searchAndDeleteLOBNotification);
                    }
                }
            }
        } catch (Exception e) {
            // Handle exception
            log.error("Error in LOB Notification", e);
        }
    }

    private void generateWorkDurationNotification(CMSEntry cmsEntry, Agent agent, TeamLeader teamLeader, LOBConfiguration lobConfiguration,
                                                  LOBConfigurationEntry lobConfigurationEntry) throws Exception {

        Double DURATION_MIN = lobConfigurationEntry.getMin() == null ? 0.0 : Double.valueOf(lobConfigurationEntry.getMin());
        Double DURATION_MAX = lobConfigurationEntry.getMax() == null ? 0.0 : Double.valueOf(lobConfigurationEntry.getMax());

        Double duration = cmsEntry.getDuration();
        // If the duration is > DURATION_MAX, then create the notification.
        //Assumption duration can not be nagative since it is different of two time it will be always 0 or greater than 0.
        //this lobConfigurationEntry.getMax()==null is there to support specific situation where if min/max is null means no all values in duration is valid.
        if (duration != null && lobConfigurationEntry.getMax() != null && (duration.compareTo(DURATION_MIN) < 0 || duration.compareTo(DURATION_MAX) > 0)) {
            if (agent == null) {
                agent = syncAgentService.systemGetByObject(cmsEntry.getAgent());
            }
            if (agent != null && teamLeader == null) {
                teamLeader = agent.getTeamLeader();
            }

            if (agent != null && teamLeader != null) {
                WorkDurationNotification workDurationNotification = null;
                boolean isExistingNotif = false;
                Iterator<LOBConfigurationNotification> itrNotifications = cmsEntry.getNotifications().iterator();
                while (itrNotifications.hasNext()) {
                    LOBConfigurationNotification notification = syncAgentService.systemGetByObject(itrNotifications.next());
                    if (notification.getType().equals("WorkDurationNotification")) {
                        workDurationNotification = new WorkDurationNotification();
                        workDurationNotification.setID(notification.getID());
                        workDurationNotification.setAgent(notification.getAgent()); //xxxx
                        workDurationNotification.setTeamLeader(notification.getTeamLeader());
                        isExistingNotif = true;
                    }
                }

                if (workDurationNotification == null) {
                    workDurationNotification = new WorkDurationNotification();
                    workDurationNotification.setID(UUID.randomUUID().toString());
                    workDurationNotification.setAgent(agent); //xxxx
                    workDurationNotification.setTeamLeader(teamLeader);
                }

                workDurationNotification.setCreatedOn(new Date());
                workDurationNotification.setName("Work Duration Notification" + "-" + cmsEntry.getFromTime() + "-" + cmsEntry.getCMSAuxMode());
                workDurationNotification.setType("WorkDurationNotification");

                workDurationNotification.setMessage(MessageFormat.format(WORK_MODE_DURATION_NOTIIFCATION_MESSAGE, agent.getFullName(), cmsEntry.getCMSAuxMode(),
                        cmsEntry.getFromTime(), cmsEntry.getToTime(), duration)); //xxx
                workDurationNotification.setLOBConfiguration(lobConfiguration); //xxx
                workDurationNotification.setLOBConfigurationEntry(lobConfigurationEntry);//xxx
                workDurationNotification.setCMSEntry(cmsEntry);

                if (isExistingNotif) {
                    syncAgentService.systemPutObject(workDurationNotification, null, null, null, true);
                } else {
                    syncAgentService.systemCreateObject(workDurationNotification, null);
                }
            }
        }
    }

    private void generateWorkModeOccurrenceNotification(CMSEntry cmsEntry, Agent agent, TeamLeader teamLeader, LOBConfiguration lobConfiguration,
                                                        LOBConfigurationEntry lobConfigurationEntry) throws Exception {

        Integer OCCURRENCE_MAX = lobConfigurationEntry.getOccurrence() == null ? 0 : Integer.parseInt(lobConfigurationEntry.getOccurrence());

        List<CMSEntry> cmsEntryList = getCurrentShiftCMSEntries(agent, cmsEntry);

        // If the duration is > DURATION_MAX, then create the notification.
        //lobConfigurationEntry.getOccurrence() == nul - that means no threshold set hence no notification should be generated
        if (lobConfigurationEntry.getOccurrence() != null && cmsEntryList.size() > OCCURRENCE_MAX) {
            if (agent == null) {
                agent = syncAgentService.systemGetByObject(cmsEntry.getAgent());
            }
            if (agent != null && teamLeader == null) {
                teamLeader = agent.getTeamLeader();
            }

            if (agent != null && teamLeader != null) {

                WorkModeOccurrenceNotification workModeOccurrenceNotification = null;

                boolean isExistingNotif = false;
                Iterator<LOBConfigurationNotification> itrNotifications = cmsEntry.getNotifications().iterator();
                while (itrNotifications.hasNext()) {
                    LOBConfigurationNotification notification = syncAgentService.systemGetByObject(itrNotifications.next());
                    if ("WorkModeOccurrenceNotification".equals(notification.getType())) {
                        workModeOccurrenceNotification = new WorkModeOccurrenceNotification();
                        workModeOccurrenceNotification.setID(notification.getID());
                        workModeOccurrenceNotification.setAgent(notification.getAgent()); //xxxx
                        workModeOccurrenceNotification.setTeamLeader(notification.getTeamLeader());
                        isExistingNotif = true;
                    }
                }


                if (workModeOccurrenceNotification == null) {
                    workModeOccurrenceNotification = new WorkModeOccurrenceNotification();
                    workModeOccurrenceNotification.setID(UUID.randomUUID().toString());
                    workModeOccurrenceNotification.setAgent(agent);
                    workModeOccurrenceNotification.setTeamLeader(teamLeader);

                }

                workModeOccurrenceNotification.setCreatedOn(new Date());
                workModeOccurrenceNotification.setName("Work Mode Occurrence Notification" + "-" + cmsEntry.getFromTime() + "-" + cmsEntry.getCMSAuxMode() + "-" + cmsEntryList.size());
                workModeOccurrenceNotification.setType("WorkModeOccurrenceNotification");

                workModeOccurrenceNotification.setMessage(MessageFormat.format(WORK_MODE_OCCURRENCE_NOTIIFCATION_MESSAGE, agent.getFullName(), cmsEntry.getCMSAuxMode(),
                        cmsEntry.getFromTime(), cmsEntry.getToTime(), OCCURRENCE_MAX));
                workModeOccurrenceNotification.setLOBConfiguration(lobConfiguration);
                workModeOccurrenceNotification.setLOBConfigurationEntry(lobConfigurationEntry);
                workModeOccurrenceNotification.setCMSEntry(cmsEntry);

                if (isExistingNotif) {
                    syncAgentService.systemPutObject(workModeOccurrenceNotification, null, null, null, true);
                } else {
                    syncAgentService.systemCreateObject(workModeOccurrenceNotification, null);
                }

            }
        }
    }

    /**
     *
     * @param timecardEntry
     * @param agent
     * @param teamLeader
     * @param validActivityCodeList
     * @param lobConfiguration
     * @throws Exception
     */
    private void generateInvalidActivityCodeNotification(TimecardEntry timecardEntry, Agent agent, TeamLeader teamLeader, List<String> validActivityCodeList,
                                                         LOBConfiguration lobConfiguration) throws Exception {


        if (!validActivityCodeList.contains(timecardEntry.getTimecardActivity().getCode())) {

            if (agent == null) {
                agent = syncAgentService.systemGetByObject(timecardEntry.getAgent());
            }
            if (agent != null && teamLeader == null) {
                teamLeader = agent.getTeamLeader();
            }

            if (agent != null && teamLeader != null) {
                InvalidActivityCodeNotification invalidActivityCodeNotification = null;

                boolean isExistingNotif = false;
                Iterator<LOBConfigurationNotification> itrNotifications = timecardEntry.getNotifications().iterator();
                while (itrNotifications.hasNext()) {
                    LOBConfigurationNotification notification = syncAgentService.systemGetByObject(itrNotifications.next());
                    if ("InvalidActivityCodeNotification".equals(notification.getType())) {
                        invalidActivityCodeNotification = new InvalidActivityCodeNotification();
                        invalidActivityCodeNotification.setID(notification.getID());
                        invalidActivityCodeNotification.setAgent(notification.getAgent()); //xxxx
                        invalidActivityCodeNotification.setTeamLeader(notification.getTeamLeader());
                        isExistingNotif = true;
                    }
                }


                if (invalidActivityCodeNotification == null) {
                    invalidActivityCodeNotification = new InvalidActivityCodeNotification();
                    invalidActivityCodeNotification.setID(UUID.randomUUID().toString());
                    invalidActivityCodeNotification.setAgent(agent);
                    invalidActivityCodeNotification.setTeamLeader(teamLeader);
                }

                invalidActivityCodeNotification.setCreatedOn(new Date());
                invalidActivityCodeNotification.setName("Invalid Activity Code Notification" + "-" + timecardEntry.getTimecardActivity().getCode());
                invalidActivityCodeNotification.setType("InvalidActivityCodeNotification");
                invalidActivityCodeNotification.setMessage(MessageFormat.format(INVALID_ACTIVITY_CODE_NOTIIFCATION_MESSAGE, agent.getFullName(),
                        timecardEntry.getTimecardActivity().getCode(), timecardEntry.getFromTime(), timecardEntry.getToTime()));
                invalidActivityCodeNotification.setLOBConfiguration(lobConfiguration);
//                invalidActivityCodeNotification.setLOBConfigurationEntry();
                invalidActivityCodeNotification.setTimecardEntry(timecardEntry);

                if (isExistingNotif) {
                    syncAgentService.systemPutObject(invalidActivityCodeNotification, null, null, null, true);
                } else {
                    syncAgentService.systemCreateObject(invalidActivityCodeNotification, null);
                }
            }
        }
    }

    private void generateNonBillableActivityCodeNotification(TimecardEntry timecardEntry, Agent agent, TeamLeader teamLeader, List<String> nonBillableActivityCodeList,
                                                             LOBConfiguration lobConfiguration) throws Exception {


        if (!nonBillableActivityCodeList.contains(timecardEntry.getTimecardActivity().getCode())) {

            if (agent == null) {
                agent = syncAgentService.systemGetByObject(timecardEntry.getAgent());
            }
            if (agent != null && teamLeader == null) {
                teamLeader = agent.getTeamLeader();
            }

            if (agent != null && teamLeader != null) {
                NonBillableActivityNotification nonBillableActivityNotification = null;

                boolean isExistingNotif = false;
                Iterator<LOBConfigurationNotification> itrNotifications = timecardEntry.getNotifications().iterator();
                while (itrNotifications.hasNext()) {
                    LOBConfigurationNotification notification = syncAgentService.systemGetByObject(itrNotifications.next());
                    if ("NonBillableActivityNotification".equals(notification.getType())) {
                        nonBillableActivityNotification = new NonBillableActivityNotification();
                        nonBillableActivityNotification.setID(notification.getID());
                        nonBillableActivityNotification.setAgent(notification.getAgent()); //xxxx
                        nonBillableActivityNotification.setTeamLeader(notification.getTeamLeader());
                        isExistingNotif = true;
                    }
                }


                if (nonBillableActivityNotification == null) {
                    nonBillableActivityNotification = new NonBillableActivityNotification();
                    nonBillableActivityNotification.setID(UUID.randomUUID().toString());
                    nonBillableActivityNotification.setAgent(agent);
                    nonBillableActivityNotification.setTeamLeader(teamLeader);
                }

                nonBillableActivityNotification.setCreatedOn(new Date());
                nonBillableActivityNotification.setName("Non-Billable Activity Notification" + "-" + timecardEntry.getTimecardActivity().getCode());
                nonBillableActivityNotification.setType("NonBillableActivityNotification");
                nonBillableActivityNotification.setTimecardActivity(timecardEntry.getTimecardActivity());

                nonBillableActivityNotification.setMessage(MessageFormat.format(NONBILLABLE_ACTIVITY_CODE_NOTIIFCATION_MESSAGE, agent.getFullName(),
                        timecardEntry.getTimecardActivity().getCode(), timecardEntry.getFromTime(), timecardEntry.getToTime()));
                nonBillableActivityNotification.setLOBConfiguration(lobConfiguration);
//                nonBillableActivityNotification.setLOBConfigurationEntry();
                nonBillableActivityNotification.setTimecardEntry(timecardEntry);

                if (isExistingNotif) {
                    syncAgentService.systemPutObject(nonBillableActivityNotification, null, null, null, true);
                } else {
                    syncAgentService.systemCreateObject(nonBillableActivityNotification, null);
                }
            }
        }
    }

    private void generateOccurrenceToleranceNotification(TimecardEntry timecardEntry, Agent agent, TeamLeader teamLeader,
                                                         LOBConfiguration lobConfiguration, LOBConfigurationEntry lobConfigurationEntry, List<TimecardEntry> consecutiveActivityList) throws Exception {


        int OCCURRENCE_MAX = lobConfigurationEntry.getOccurrence() == null ? 0 : Integer.parseInt(lobConfigurationEntry.getOccurrence());

        if (lobConfigurationEntry.getOccurrence() != null && consecutiveActivityList.size() > OCCURRENCE_MAX) {


            if (agent == null) {
                agent = syncAgentService.systemGetByObject(timecardEntry.getAgent());
            }
            if (agent != null && teamLeader == null) {
                teamLeader = agent.getTeamLeader();
            }

            if (agent != null && teamLeader != null) {
                OccurrenceToleranceNotification occurrenceToleranceNotification = null;

                boolean isExistingNotif = false;
                Iterator<LOBConfigurationNotification> itrNotifications = timecardEntry.getNotifications().iterator();

                while (itrNotifications.hasNext()) {
                    LOBConfigurationNotification notification = syncAgentService.systemGetByObject(itrNotifications.next());
                    if ("OccurrenceToleranceNotification".equals(notification.getType())) {
                        occurrenceToleranceNotification = new OccurrenceToleranceNotification();
                        occurrenceToleranceNotification.setID(notification.getID());
                        occurrenceToleranceNotification.setAgent(notification.getAgent()); //xxxx
                        occurrenceToleranceNotification.setTeamLeader(notification.getTeamLeader());
                        isExistingNotif = true;
                    }
                }


                if (occurrenceToleranceNotification == null) {
                    occurrenceToleranceNotification = new OccurrenceToleranceNotification();
                    occurrenceToleranceNotification.setID(UUID.randomUUID().toString());
                    occurrenceToleranceNotification.setAgent(agent);
                    occurrenceToleranceNotification.setTeamLeader(teamLeader);
                }

                occurrenceToleranceNotification.setCreatedOn(new Date());
                occurrenceToleranceNotification.setName("Occurrence Tolerance Notification" + "-" + timecardEntry.getTimecardActivity().getCode() + "-" + OCCURRENCE_MAX);
                occurrenceToleranceNotification.setType("OccurrenceToleranceNotification");

                occurrenceToleranceNotification.setMessage(MessageFormat.format(OCCURRENCE_TOLERANCE_NOTIIFCATION_MESSAGE, agent.getFullName(),
                        timecardEntry.getTimecardActivity().getCode(), timecardEntry.getFromTime(), timecardEntry.getToTime(), OCCURRENCE_MAX));
                occurrenceToleranceNotification.setLOBConfiguration(lobConfiguration);
                occurrenceToleranceNotification.setLOBConfigurationEntry(lobConfigurationEntry);
                occurrenceToleranceNotification.setTimecardEntry(timecardEntry);

                if (isExistingNotif) {
                    syncAgentService.systemPutObject(occurrenceToleranceNotification, null, null, null, true);
                } else {
                    syncAgentService.systemCreateObject(occurrenceToleranceNotification, null);
                }
            }
        }
    }

    private void generateDurationToleranceNotification(TimecardEntry timecardEntry, Agent agent, TeamLeader teamLeader,
                                                       LOBConfiguration lobConfiguration, LOBConfigurationEntry lobConfigurationEntry,
                                                       Double totalDuration) throws Exception {

        Double DURATION_MIN = lobConfigurationEntry.getMin() == null ? 0.0 : Double.parseDouble(lobConfigurationEntry.getMin());
        Double DURATION_MAX = lobConfigurationEntry.getMax() == null ? 0.0 : Double.parseDouble(lobConfigurationEntry.getMax());

        //if max is null than no threshold required which is based on config data
        if (lobConfigurationEntry.getMax() != null && (totalDuration.compareTo(DURATION_MIN) < 0 || totalDuration.compareTo(DURATION_MAX) > 0)) {
            if (agent == null) {
                agent = syncAgentService.systemGetByObject(timecardEntry.getAgent());
            }
            if (agent != null && teamLeader == null) {
                teamLeader = agent.getTeamLeader();
            }

            if (agent != null && teamLeader != null) {
                DurationToleranceNotification durationToleranceNotification = null;
                boolean isExistingNotif = false;
                Iterator<LOBConfigurationNotification> itrNotifications = timecardEntry.getNotifications().iterator();
                while (itrNotifications.hasNext()) {
                    LOBConfigurationNotification notification = syncAgentService.systemGetByObject(itrNotifications.next());
                    if ("DurationToleranceNotification".equals(notification.getType())) {
                        durationToleranceNotification = new DurationToleranceNotification();
                        durationToleranceNotification.setID(notification.getID());
                        durationToleranceNotification.setAgent(notification.getAgent()); //xxxx
                        durationToleranceNotification.setTeamLeader(notification.getTeamLeader());
                        isExistingNotif = true;
                    }
                }


                if (durationToleranceNotification == null) {
                    durationToleranceNotification = new DurationToleranceNotification();
                    durationToleranceNotification.setID(UUID.randomUUID().toString());
                    durationToleranceNotification.setAgent(agent);
                    durationToleranceNotification.setTeamLeader(teamLeader);
                }

                durationToleranceNotification.setCreatedOn(new Date());
                durationToleranceNotification.setName("Duration Tolerance Notification" + "-" + timecardEntry.getTimecardActivity().getCode() + "-" + DURATION_MAX);
                durationToleranceNotification.setType("DurationToleranceNotification");

                durationToleranceNotification.setMessage(MessageFormat.format(DURATION_TOLERANCE_NOTIIFCATION_MESSAGE, agent.getFullName(),
                        timecardEntry.getTimecardActivity().getCode(), timecardEntry.getFromTime(), timecardEntry.getToTime(), DURATION_MAX));
                durationToleranceNotification.setLOBConfiguration(lobConfiguration);
                durationToleranceNotification.setLOBConfigurationEntry(lobConfigurationEntry);
                durationToleranceNotification.setTimecardEntry(timecardEntry);

                if (isExistingNotif) {
                    syncAgentService.systemPutObject(durationToleranceNotification, null, null, null, true);
                } else {
                    syncAgentService.systemCreateObject(durationToleranceNotification, null);
                }
            }
        }
    }


    //Utility methods specific to the notifications
    private List<CMSEntry> getCurrentShiftCMSEntries(Agent agent, CMSEntry watchedCMSEntry) {

        List<CMSEntry> cmsEntriesOfTheShift = new ArrayList<CMSEntry>();

        Iterator<CMSEntry> itrCMSEntry = agent.getCMSEntries().iterator();
        Date shiftDate = new Date(watchedCMSEntry.getFromTime().getTime());

        while (itrCMSEntry.hasNext()) {
            CMSEntry cmsEntry = syncAgentService.systemGetByObject(itrCMSEntry.next());
            //Check the the entry bellongs to

            if (cmsEntry != null && compareDates(watchedCMSEntry.getFromTime(), cmsEntry.getFromTime()) &&
                    ((watchedCMSEntry.getCMSAuxMode() == null && cmsEntry.getCMSAuxMode() == null)
                            || (watchedCMSEntry.getCMSAuxMode() != null && cmsEntry.getCMSAuxMode() != null
                            && watchedCMSEntry.getCMSAuxMode().equals(cmsEntry.getCMSAuxMode())))) {
                cmsEntriesOfTheShift.add(cmsEntry);
            }
        }

        return cmsEntriesOfTheShift;
    }

    private Double getConsecutiveActivityCodeDetailFromTimecard(Agent agent, TimecardEntry watchedTimecardEntry, String activityCode, List<TimecardEntry> timecardEntryListOfActivityCode) {

//        Integer consecutiveAcitivityCount = 0;
        Double activityTimeSpan = 0.0;

        Timecard timecard = syncAgentService.systemGetByObject(watchedTimecardEntry.getTimecard());

        List<TimecardEntry> timecardEntryList = timecard.getTimecardEntries();

        int indexOfWatchedEntry = timecardEntryList.indexOf(watchedTimecardEntry);

        boolean processData = true;

        //Here the assumption is the TimecardEntres are sorted based on the time. If not this logic may not work/
        //Infact this logic is provided by CVG and they have assumption on this front
//        for (int cnt = timecardEntryList.size() ; cnt >= 0 && processData; cnt--) {
        for (int cnt = indexOfWatchedEntry; cnt >= 0 && processData; cnt--) {
            TimecardEntry timecardEntry = syncAgentService.systemGetByObject(timecardEntryList.get(cnt));

            if (timecardEntry != null) {

                TimecardActivity timecardActivity = syncAgentService.systemGetByObject(timecardEntry.getTimecardActivity());

                //If code does not have consecutiveness then brk the loop
                if (timecardActivity != null && activityCode != null && timecardActivity.getCode() != null && timecardActivity.getCode().equals(activityCode)) {

                    activityTimeSpan += timecardEntry.getDuration();
                    timecardEntryListOfActivityCode.add(timecardEntry);
                } else {
                    processData = false;
                }
            }
        }

        return activityTimeSpan;
    }

    private boolean compareDates(Date sourceDate, Date targetDate) {

        sourceDate.setHours(0);
        sourceDate.setMinutes(0);
        sourceDate.setSeconds(0);

        targetDate.setHours(0);
        targetDate.setMinutes(0);
        targetDate.setSeconds(0);

        if (sourceDate != null && targetDate != null && sourceDate.compareTo(targetDate) == 0) {
            return true;

        }
        return false;

    }


    private void deleteOrphanedNotifications(LOBConfigurationNotification searchLOBNotification) throws Exception {
        //Get list of LOBConfigurationNotification based on deleted CMSEntry ID
        //TODO:Clean this logs if not required. This is frequent operation and may consume resouces unnecessarily
        log.info("********************************** Orphaned Notification Clean Process [Starts] **********************************:");
        log.info(searchLOBNotification.getCMSEntry());
        log.info(searchLOBNotification.getTimecardEntry());

        List<IPerceroObject> listOfOrphanedNotifications = syncAgentService.systemFindByExample(searchLOBNotification, null);

        Iterator<IPerceroObject> itrNotifications = listOfOrphanedNotifications.iterator();

        while (itrNotifications.hasNext()) {
            IPerceroObject iPerceroObject = itrNotifications.next();
            ClassIDPair classIdPairLobNotif = BaseDataObject.toClassIdPair(iPerceroObject);

            Notification notification = (Notification) syncAgentService.systemGetById(classIdPairLobNotif);

            if (notification != null) {

                syncAgentService.systemDeleteObject(notification, null, true);
                log.info("XXXXXXXXX Notification ID:  [ " + notification.getID() + "] DELETED XXXXXXXXX");
            } else {
                log.info("No Notification found for ID: " + classIdPairLobNotif);
            }
        }
        log.info("********************************** Orphaned Notification Clean Process [Ends] **********************************:");
    }

    private void generatePhoneTimeVarianceNotification(TimecardEntry timecardEntry, Agent agent, TeamLeader teamLeader,
                                                       LOBConfiguration lobConfiguration, LOBConfigurationEntry lobConfigurationEntry, List<TimecardEntry> consecutiveActivityList) throws Exception {


        int DURATION_MAX = lobConfigurationEntry.getOccurrence() == null ? 0 : Integer.parseInt(lobConfigurationEntry.getOccurrence());

        Double duration = getDurationOfAccociatedCMSEntries(timecardEntry, agent, teamLeader, lobConfiguration, lobConfigurationEntry, consecutiveActivityList);


        if (lobConfigurationEntry.getMax() != null && duration > DURATION_MAX) {


            if (agent == null) {
                agent = syncAgentService.systemGetByObject(timecardEntry.getAgent());
            }
            if (agent != null && teamLeader == null) {
                teamLeader = agent.getTeamLeader();
            }

            if (agent != null && teamLeader != null) {

                DurationMismatchNotification durationMismatchNotification = null;

                boolean isExistingNotif = false;
                Iterator<LOBConfigurationNotification> itrNotifications = timecardEntry.getNotifications().iterator();

                while (itrNotifications.hasNext()) {
                    LOBConfigurationNotification notification = syncAgentService.systemGetByObject(itrNotifications.next());
                    if ("DurationMismatchNotification".equals(notification.getType())) {
                        durationMismatchNotification = new DurationMismatchNotification();
                        durationMismatchNotification.setID(notification.getID());
                        durationMismatchNotification.setAgent(notification.getAgent()); //xxxx
                        durationMismatchNotification.setTeamLeader(notification.getTeamLeader());
                        isExistingNotif = true;
                    }
                }


                if (durationMismatchNotification == null) {
                    durationMismatchNotification = new DurationMismatchNotification();
                    durationMismatchNotification.setID(UUID.randomUUID().toString());
                    durationMismatchNotification.setAgent(agent);
                    durationMismatchNotification.setTeamLeader(teamLeader);
                }

                durationMismatchNotification.setCreatedOn(new Date());
                durationMismatchNotification.setName("Duration Mismatch Notification" + "-" + timecardEntry.getTimecardActivity().getCode() + "-" + DURATION_MAX);
                durationMismatchNotification.setType("DurationMismatchNotification");

                durationMismatchNotification.setMessage(MessageFormat.format(DURATION_MISMATCH_NOTIFICATION_MESSAGE, agent.getFullName(),
                        timecardEntry.getTimecardActivity().getCode(), timecardEntry.getFromTime(), timecardEntry.getToTime()));
                durationMismatchNotification.setLOBConfiguration(lobConfiguration);
//                durationMismatchNotification.setLOBConfigurationEntry(lobConfigurationEntry);
                durationMismatchNotification.setTimecardEntry(timecardEntry);

                if (isExistingNotif) {
                    syncAgentService.systemPutObject(durationMismatchNotification, null, null, null, true);
                } else {
                    syncAgentService.systemCreateObject(durationMismatchNotification, null);
                }
            }
        }
    }


    private Double getDurationOfAccociatedCMSEntries(TimecardEntry timecardEntry, Agent agent, TeamLeader teamLeader,
                                                     LOBConfiguration lobConfiguration, LOBConfigurationEntry lobConfigurationEntry, List<TimecardEntry> consecutiveActivityList) throws Exception {

        Double duration = 0.0;

        if (consecutiveActivityList.size() < 1) {
            return duration;
        }

        List<CMSEntry> associatedCMSEntries = new ArrayList<CMSEntry>();

        //The consecutiveActivityList gets list of TimecardEntries in reverse order so first is last entry and last is first entry.
        Date timecarEntryEndTime = consecutiveActivityList.get(0).getToTime();
        Date timecarEntryStartTime = consecutiveActivityList.get(consecutiveActivityList.size() - 1).getFromTime();


        List<String> auxCodesForActivity = new ArrayList<String>();
        Iterator<LOBConfigurationActivityAuxCode> itrLOBConfigurationActivityAuxCode =  lobConfigurationEntry.getLOBConfigurationActivityAuxCodes().iterator();

        while(itrLOBConfigurationActivityAuxCode.hasNext()) {
            LOBConfigurationActivityAuxCode lobConfigurationActivityAuxCode = syncAgentService.systemGetByObject(itrLOBConfigurationActivityAuxCode.next());
            auxCodesForActivity.add(lobConfigurationActivityAuxCode.getCMSAuxCode());
        }


//        lobConfigurationEntry.getMappedCMSAuxCode()
        List<CMSEntry> agentCMSEntries = agent.getCMSEntries();

        int firstClosestCMSEntryIndex = 0;
        int lastClosestCMSEntryIndex = 0;

        long startTimeDiff = timecarEntryStartTime.getTime();//Some large number initialization to have
        long endTimeDiff = timecarEntryEndTime.getTime();//Some large number initialization to have

        for (int index = 0; index < agentCMSEntries.size(); index++) {

            CMSEntry cMSEntry = syncAgentService.systemGetByObject(agentCMSEntries.get(index));

            if (getTimeDiff(timecarEntryStartTime, cMSEntry.getFromTime()) <= startTimeDiff) {
                firstClosestCMSEntryIndex = index;
            }

            if (getTimeDiff(timecarEntryEndTime, cMSEntry.getToTime()) <= endTimeDiff) {
                lastClosestCMSEntryIndex = index;
            }
        }

        for (int index = 0; index < agentCMSEntries.size(); index++) {
            CMSEntry cMSEntry = syncAgentService.systemGetByObject(agentCMSEntries.get(index));
            if (auxCodesForActivity.contains(cMSEntry.getCMSAuxMode())) {
                duration += cMSEntry.getDuration();
            }
        }

        return duration;
    }


    private long getTimeDiff(Date date1, Date date2) {
        if (date1.getTime() > date1.getTime()) {
            return date1.getTime() - date2.getTime();
        } else {
            return date2.getTime() - date1.getTime();
        }

    }
}
