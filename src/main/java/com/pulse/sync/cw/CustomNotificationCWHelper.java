package com.pulse.sync.cw;

import java.text.MessageFormat;
import java.util.*;

import javax.annotation.PostConstruct;

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

    // This is required for CUSTOM change watchers.
    private static final String CATEGORY = "CUSTOM";
    // This is an optional sub category.
    private static final String SUB_CATEGORY = "";

    private boolean watcherEnabled = false;
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
//        if (!watcherEnabled) {
//            return;
//        }
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
                            } else {
                                //Not a Valid scenario for notification
                                // Do not send notification
                                log.info("****** CMS Entry based notification is not generated due to following configuration ******");
                                log.info("Agent : " + agent.getID() + " : CMSEntry : " + cmsEntry.getID() + " having AgentLOB Count (" + agent.getAgentLOBs().size() + ") - But only ONE AgentLOB expected");
                            }
                        }


                        // 2.


                        // 3.


                        // 4.

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

                    // DO NOT CHANGE THE CONDITION, THIS WILL MAKE SYSTEM CRAZY SINCE THERE ARE LOTS OF SYSTEM GENERATED TIMECARD ENTRIES HAVING ESTARTPROEJCTNAME = 'IEX'
                    // This is explicit condition other than NULL timecard, if the timecardEntry's EStartProjectName is "IEX" means the entry is genertaed by system not the one entered by Agent,...
                    // ...hence there is no need to process it.
                    // No notification on system generated Entries.
                    if (timecardEntry != null && !timecardEntry.getEStartProjectName().equals("IEX")) {

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

                                                if (lobConfigurationEntry.getType() != null && lobConfigurationEntry.getESTARTActivityCode() != null) {

                                                    if (lobConfigurationEntry.getType().equals("VALID_ACTIVITY_CODE")) {

                                                        validActivityCodeList.add(lobConfigurationEntry.getESTARTActivityCode());

                                                        if ((lobConfigurationEntry.getESTARTActivityCode() == null && timecarActivity.getCode() == null) ||
                                                                (lobConfigurationEntry.getESTARTActivityCode() != null && timecarActivity.getCode() != null &&
                                                                        lobConfigurationEntry.getESTARTActivityCode().equals(timecarActivity.getCode()))) {

                                                            generateOccurrenceToleranceNotification(timecardEntry, agent, teamLeader,
                                                                    lobConfiguration, lobConfigurationEntry, consecutiveActivityList);

                                                            generateDurationToleranceNotification(timecardEntry, agent, teamLeader,
                                                                    lobConfiguration, lobConfigurationEntry, consecutiveActivityDuration);

                                                        }
                                                    } else if (lobConfigurationEntry.getType().equals("NONBILLABLE_ACTIVITY_CODE")) {

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
                            } else {

                                //Not a Valid scenario for notification
                                // Do not send notification
                                log.info("****** TimeCard Entry based notification is not generated due to following configuration ******");
                                log.info("Agent : " + agent.getID() + " : TimecardEntry : " + timecardEntry.getID() + " having AgentLOB Count (" + agent.getAgentLOBs().size() + ") - But only ONE AgentLOB expected");
                            }
                        }


                        // 3.


                        // 4.

                    }

                }
            }
            }catch(Exception e){
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
        if (lobConfigurationEntry.getMax() != null && (duration.compareTo(DURATION_MIN) < 0 || duration.compareTo(DURATION_MAX) > 0)) {
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
                    if (notification.getType().equals("WorkModeOccurrenceNotification")) {
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
                    if (notification.getType().equals("InvalidActivityCodeNotification")) {
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
                    if (notification.getType().equals("NonBillableActivityNotification")) {
                        nonBillableActivityNotification = new NonBillableActivityNotification();
                        nonBillableActivityNotification.setID(notification.getID());
                        nonBillableActivityNotification.setAgent(notification.getAgent()); //xxxx
                        nonBillableActivityNotification.setTeamLeader(notification.getTeamLeader());
                        isExistingNotif = true;
                    }
                }


                if (nonBillableActivityCodeList == null) {
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
                    if (notification.getType().equals("OccurrenceToleranceNotification")) {
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
                    if (notification.getType().equals("DurationToleranceNotification")) {
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

            if (compareDates(watchedCMSEntry.getFromTime(), cmsEntry.getFromTime()) &&
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

        boolean processData = true;

        for (int cnt = timecardEntryList.size() - 1; cnt >= 0 && processData; cnt--) {
            TimecardEntry timecardEntry = syncAgentService.systemGetByObject(timecardEntryList.get(cnt));

            TimecardActivity timecardActivity = syncAgentService.systemGetByObject(timecardEntry.getTimecardActivity());

            //If code does not have consecutiveness then brk the look
            if (activityCode != null && timecardActivity.getCode() != null && timecardActivity.getCode().equals(activityCode)) {

                activityTimeSpan += timecardEntry.getDuration();
                timecardEntryListOfActivityCode.add(timecardEntry);
            } else {
                processData = false;
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

        if (sourceDate.compareTo(targetDate) == 0) {
            return true;

        }
        return false;

    }
}
