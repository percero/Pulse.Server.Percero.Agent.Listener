package com.pulse.sync.cw;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;

import com.percero.agents.sync.access.RedisKeyUtils;
import com.percero.agents.sync.datastore.ICacheDataStore;
import com.percero.agents.sync.helpers.PostDeleteHelper;
import com.percero.agents.sync.helpers.PostPutHelper;
import com.percero.agents.sync.metadata.IMappedClassManager;
import com.percero.agents.sync.metadata.MappedClass;
import com.percero.agents.sync.metadata.MappedClassManagerFactory;
import com.percero.agents.sync.metadata.MappedField;
import com.percero.agents.sync.services.IDataProvider;
import com.percero.agents.sync.services.IDataProviderManager;
import com.percero.agents.sync.vo.*;
import com.pulse.dataprovider.IConnectionFactory;
import com.pulse.dataprovider.PulseDataConnectionRegistry;
import com.pulse.mo.*;
import com.pulse.mo.dao.LOBConfigurationNotificationDAO;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.percero.agents.sync.cw.ChangeWatcherHelper;
import com.percero.agents.sync.cw.ChangeWatcherHelperFactory;
import com.percero.agents.sync.services.ISyncAgentService;
import com.percero.framework.vo.IPerceroObject;

// This should get picked up by Spring and be auto-wired.
@Component
public class CustomNotificationCWHelper extends ChangeWatcherHelper {


    private static final Logger log = Logger.getLogger(CustomNotificationCWHelper.class);

    public static final String CONNECTION_FACTORY_NAME = "estart";
    public static long LONG_RUNNING_QUERY_TIME = 2000;
    public static int QUERY_TIMEOUT = 10;

    private static final int MS_IN_MIN = 60 * 1000;
    //CMSEntry based Notifications Messages
    private static final String WORK_MODE_DURATION_NOTIIFCATION_MESSAGE = "Duration Tolerance | {0} : System has detected a CMS aux code {1} starting at {2} and ending at {3} for the total duration of {4}  has exceeded the duration tolerance.";
    private static final String WORK_MODE_OCCURRENCE_NOTIIFCATION_MESSAGE = "Occurrence Tolerance | {0} : System has detected a CMS aux code {1} starting at {2} and ending at {3} has occurred more times than the tolerance of {4}.";


    //Timecard based Notifications Messages
    private static final String INVALID_ACTIVITY_CODE_NOTIIFCATION_MESSAGE = "Invalid Activity Code | {0} : System has detected an invalid activity code {1} starting at {2} and ending at {3}";
    private static final String NONBILLABLE_ACTIVITY_CODE_NOTIIFCATION_MESSAGE = "Non-billable Activity | {0} : System has detected a non-billable activity code {1} starting at {2} and ending at {3}";
    private static final String OCCURRENCE_TOLERANCE_NOTIIFCATION_MESSAGE = "Occurrence Tolerance | {0} : System has detected an eStart activity code {1} starting at {2} and ending at {3} has occurred more times than the tolerance of {4}.";
    private static final String DURATION_TOLERANCE_NOTIIFCATION_MESSAGE = "Duration Tolerance | {0} System has detected an eStart activity code {1} starting at {2} and ending at {3} for the total duration of {4}  has exceeded the duration tolerance.";
    private static final String DURATION_MISMATCH_NOTIFICATION_MESSAGE = "Phone Time Variance | {0} : System has detected eStart activity code {1} starting at {2} and ending at {3} does not match CMS duration.";


    private static final String DATE_TIME_FORMAT_WITH_SECONDS = "MM/dd/yyyy HH:mm:ss";
    private static final String DATE_TIME_FORMAT_WITHOUT_SECONDS = "MM/dd/yyyy HH:mm";
    private static final String DATE_TIME_FORMAT_12_HR = "MM/dd/yyyy hh:mm a";

    // This is required for CUSTOM change watchers.
    private static final String CATEGORY = "CUSTOM";
    // This is an optional sub category.
    private static final String SUB_CATEGORY = "";

    @Autowired
    protected ISyncAgentService syncAgentService;

    @Autowired
    ICacheDataStore cacheDataStore;

    @Autowired
    Long cacheTimeout = Long.valueOf(60 * 60 * 24 * 14);    // Two weeks

    @Autowired
    IDataProviderManager dataProviderManager;

    @Autowired
    PostDeleteHelper postDeleteHelper;

    @Autowired
    PostPutHelper postPutHelper;

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
        accessManager.addWatcherField(new ClassIDPair("0", Timecard.class.getCanonicalName()), "", timecardFieldsToWatch);
        // Register the fields. This can always be called again with an updated
        // list of fields to watch, which would overwrite the list of fields
        // that trigger this change watcher code.
        accessManager.updateWatcherFields(CATEGORY, SUB_CATEGORY, "handleCmsEntryNotification", cmsEntryFieldsToWatch);
        accessManager.updateWatcherFields(CATEGORY, SUB_CATEGORY, "handleTimecardEntryNotification", timecardEntryFieldsToWatch);
        accessManager.updateWatcherFields(CATEGORY, SUB_CATEGORY, "handleTimecardUpdate", timecardFieldsToWatch);
//        accessManager.updateWatcherFields(CATEGORY, SUB_CATEGORY, "handleTimecardEntryNotification", timecardFieldsToWatch);
    }

    /* (non-Javadoc)
     * @see com.percero.agents.sync.cw.ChangeWatcherHelper#process(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public Object process(String category, String subCategory, String fieldName, IPerceroObject oldValue) {
        return process(category, subCategory, fieldName, null, oldValue);
    }

    /* (non-Javadoc)
     * @see com.percero.agents.sync.cw.ChangeWatcherHelper#process(java.lang.String, java.lang.String, java.lang.String, java.lang.String[])
     */
    @Override
    public Object process(String category, String subCategory, String fieldName, String[] params, IPerceroObject oldValue) {
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
        } else if (fieldName.equalsIgnoreCase("handleTimecardUpdate")) {
            try {
                handleTimecardUpdate(category, subCategory, fieldName, params, oldValue);
            } catch (Exception e) {
                log.error("Unable to process handleTimecardUpdate", e);
            }
            return null;
        } else {
            return super.process(category, subCategory, fieldName, params, oldValue);
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

                if (updatedObject != null && updatedObject instanceof CMSEntry) {
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

                            //TODO:Test Data : Remove once LOB done
//                            LOB tlob = new LOB();
//                            tlob.setID("13573");
//
//                            AgentLOB agentLOB = new AgentLOB();
//                            agentLOB.setID(agent.getID() + "-" +tlob.getID());
//                            agentLOB.setLOB(tlob);
//                            agentLOB.setAgent(agent);
//
//                            agent.getAgentLOBs().add(agentLOB);

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
//                                log.debug("****** CMS Entry based notification is not generated due to following configuration ******");
//                                log.debug("Agent : " + agent.getID() + " : CMSEntry : " + cmsEntry.getID() + " having AgentLOB Count (" + agent.getAgentLOBs().size() + ") - But only ONE AgentLOB expected");
//                            }
                        }
                    }

                    // 2.


                    // 3.


                    // 4.

                } else {
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

                if (updatedObject != null && updatedObject instanceof TimecardEntry) {
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

                        //For the watched TimecardEntry,
                        //Use the ActivityCode in the Entry and look into the configuration Along with key for "NON-BILLABLE" (Still need to be decided for the key).
                        //If timecardEntry.getTimecardActivity().getCode() is in the list of activitycode retrived from LOBConfig, it is nonbillable activity code
                        //In condition fails, generate notification

                        if (agent == null) {
                            agent = syncAgentService.systemGetByObject(timecardEntry.getAgent());
                        }
//                        LOB tlob = new LOB();
//                        tlob.setID("13573");
//
//                        AgentLOB agentLOB = new AgentLOB();
//                        agentLOB.setID(agent.getID() + "-" +tlob.getID());
//                        agentLOB.setLOB(tlob);
//                        agentLOB.setAgent(agent);
//
//                        agent.getAgentLOBs().add(agentLOB);

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

                                            List<TimecardEntry> sortedTimecartEntries = getSortedTimecardEntries(timecard.getTimecardEntries());
                                            List<TimecardEntry> consecutiveActivityList = new ArrayList<TimecardEntry>();


                                            Double consecutiveActivityDuration = getConsecutiveActivityCodeDetailFromTimecard(agent, sortedTimecartEntries, timecardEntry,
                                                    timecarActivity.getCode(), consecutiveActivityList);

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
//                                log.debug("****** TimeCard Entry based notification is not generated due to following configuration ******");
//                                log.debug("Agent : " + agent.getID() + " : TimecardEntry : " + timecardEntry.getID() + " having AgentLOB Count (" + agent.getAgentLOBs().size() + ") - But only ONE AgentLOB expected");
//                            }
                        }
                    }

                    // 3.


                    // 4.

                } else {
                    //Entry DELETED and Watcher invoked by ActiveStack when UpdateTableProcessor processed it and updated Redis Cache
                    //This is a special case where TimecardEntry is deleted but watched by Watcher since there is change in the Entry/Object.
                    //When try to rerieve using SyncEngine syncAgentService it returns NULL because the object is deleted.
                    //This is a situation where we need to clean the orphaned notifications associated with deleted entry

                    //This code moved to delete Timecard Entry logic
//                    TimecardEntry criteriaTimecardEntry = new TimecardEntry();
//                    criteriaTimecardEntry.setID(classId);
//
//                    LOBConfigurationNotification searchAndDeleteLOBNotification = new LOBConfigurationNotification();
//                    searchAndDeleteLOBNotification.setTimecardEntry(criteriaTimecardEntry);
//
//                    deleteOrphanedNotifications(searchAndDeleteLOBNotification);
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

        Collection<String> fieldsToWatch = new HashSet<String>();
        ClassIDPair agentPair = BaseDataObject.toClassIdPair(agent);
        accessManager.addWatcherField(agentPair, "timeZone", fieldsToWatch);
        //Using this property which extract the timezone string from AgentTimeZone object. Following the general pattern followed in the project
        String timeZone = agent.getTimeZone();
        Date fromDate = null;
        Date toDate = null;
        try {
            DateTimeZone dateTimeZone = DateTimeZone.forID(timeZone);
            if (dateTimeZone != null) {
                //This is requried since the dateTimeZine.getOffset(long time) has dependancy to local time. 
                // ActiveStack server running on CST not in UTC. But the source time in UTC so this will not work.
                // Do not change the code here. Following is the best approach
                int offsetInMs = dateTimeZone.toTimeZone().getRawOffset();

                fromDate = new DateTime(cmsEntry.getFromTime().getTime() + offsetInMs).toDate();
                toDate = new DateTime(cmsEntry.getToTime().getTime() + offsetInMs).toDate();
            } else {
                log.warn("Invalid time zone " + timeZone);
            }
        } catch (Exception e) {
            // Invalid time zone.
            log.error("Invalid time zone " + timeZone, e);
        }

        //Instead of using cmsEntry duration calc from from/to date
//        Double duration = cmsEntry.getDuration();
        int intDuration = calLapsMin(fromDate, toDate);
        // If the duration is > DURATION_MAX, then create the notification.
        //Assumption duration can not be nagative since it is different of two time it will be always 0 or greater than 0.
        //this lobConfigurationEntry.getMax()==null is there to support specific situation where if min/max is null means no all values in duration is valid.

        if (lobConfigurationEntry.getMax() != null && (intDuration < DURATION_MIN || intDuration > DURATION_MAX)) {
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
                        //Instead of creating new object update and save
                        //workDurationNotification = new WorkDurationNotification();
                        workDurationNotification = (WorkDurationNotification) notification;
//                        workDurationNotification.setID(notification.getID());
//                        workDurationNotification.setAgent(notification.getAgent()); //xxxx
//                        workDurationNotification.setTeamLeader(notification.getTeamLeader());
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

//                workDurationNotification.setName("Work Duration Notification" + "-" + cmsEntry.getFromTime() + "-" + cmsEntry.getCMSAuxMode());
                workDurationNotification.setName("Work Duration Notification" + "-" + formatDate(fromDate, DATE_TIME_FORMAT_12_HR) + "-" + cmsEntry.getCMSAuxMode());
                workDurationNotification.setType("WorkDurationNotification");


                //Do not use the duration property of the CMSEntry, since it has decimal value. Customer do not want round half up either hence followed a patterned
                // which was implemented on UI for calculating duration
//                int intDuration = calLapsMin(fromDate, toDate);
//                workDurationNotification.setMessage(MessageFormat.format(WORK_MODE_DURATION_NOTIIFCATION_MESSAGE, agent.getFullName(), cmsEntry.getCMSAuxMode(),
//                        cmsEntry.getFromTime(), cmsEntry.getToTime(), duration)); //xxx
                workDurationNotification.setMessage(MessageFormat.format(WORK_MODE_DURATION_NOTIIFCATION_MESSAGE, agent.getFullName(), cmsEntry.getCMSAuxMode(),
                        formatDate(fromDate, DATE_TIME_FORMAT_12_HR), formatDate(toDate, DATE_TIME_FORMAT_12_HR), intDuration)); //xxx

                workDurationNotification.setLOBConfiguration(lobConfiguration); //xxx
                workDurationNotification.setLOBConfigurationEntry(lobConfigurationEntry);//xxx
                workDurationNotification.setCMSEntry(cmsEntry);
                workDurationNotification.setIsRead(false);

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

//        List<CMSEntry> cmsEntryList = getCurrentShiftCMSEntries(agent, cmsEntry);

        List<CMSEntry> cmsEntryList = new ArrayList<CMSEntry>();
        //Two objectives solved with this method. 1-Get smallest date in the list of entries, and list of entries associdated with the auxcode within shift
        Date beginDate = getCurrentShiftCMSEntries(agent, cmsEntryList, cmsEntry);

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
                        workModeOccurrenceNotification = (WorkModeOccurrenceNotification) notification;
//                        workModeOccurrenceNotification = new WorkModeOccurrenceNotification();
//                        workModeOccurrenceNotification.setID(notification.getID());
//                        workModeOccurrenceNotification.setAgent(notification.getAgent()); //xxxx
//                        workModeOccurrenceNotification.setTeamLeader(notification.getTeamLeader());
                        isExistingNotif = true;
                    }
                }


                if (workModeOccurrenceNotification == null) {
                    workModeOccurrenceNotification = new WorkModeOccurrenceNotification();
                    workModeOccurrenceNotification.setID(UUID.randomUUID().toString());
                    workModeOccurrenceNotification.setAgent(agent);
                    workModeOccurrenceNotification.setTeamLeader(teamLeader);
                }

                Collection<String> fieldsToWatch = new HashSet<String>();
                ClassIDPair agentPair = BaseDataObject.toClassIdPair(agent);
                accessManager.addWatcherField(agentPair, "timeZone", fieldsToWatch);
                //Using this property which extract the timezone string from AgentTimeZone object. Following the general pattern followed in the project
                String timeZone = agent.getTimeZone();
                Date fromDate = null;
                Date toDate = null;
                try {
                    DateTimeZone dateTimeZone = DateTimeZone.forID(timeZone);
                    if (dateTimeZone != null) {
                        //This is requried since the dateTimeZine.getOffset(long time) has dependancy to local time. 
                        // ActiveStack server running on CST not in UTC. But the source time in UTC so this will not work.
                        // Do not change the code here. Following is the best approach
                        int offsetInMs = dateTimeZone.toTimeZone().getRawOffset();

                        fromDate = new DateTime(beginDate.getTime() + offsetInMs).toDate();
                        toDate = new DateTime(cmsEntry.getToTime().getTime() + offsetInMs).toDate();
                    } else {
                        log.warn("Invalid time zone " + timeZone);
                    }
                } catch (Exception e) {
                    // Invalid time zone.
                    log.error("Invalid time zone " + timeZone, e);
                }

                workModeOccurrenceNotification.setCreatedOn(new Date());

                workModeOccurrenceNotification.setName("Work Mode Occurrence Notification" + "-" + formatDate(fromDate, DATE_TIME_FORMAT_12_HR) + "-" + cmsEntry.getCMSAuxMode() + "-" + cmsEntryList.size());
                workModeOccurrenceNotification.setType("WorkModeOccurrenceNotification");

                workModeOccurrenceNotification.setMessage(MessageFormat.format(WORK_MODE_OCCURRENCE_NOTIIFCATION_MESSAGE, agent.getFullName(), cmsEntry.getCMSAuxMode(),
                        formatDate(fromDate, DATE_TIME_FORMAT_12_HR), formatDate(toDate, DATE_TIME_FORMAT_12_HR), OCCURRENCE_MAX));
                workModeOccurrenceNotification.setLOBConfiguration(lobConfiguration);
                workModeOccurrenceNotification.setLOBConfigurationEntry(lobConfigurationEntry);
                workModeOccurrenceNotification.setCMSEntry(cmsEntry);
                workModeOccurrenceNotification.setIsRead(false);
                if (isExistingNotif) {
                    syncAgentService.systemPutObject(workModeOccurrenceNotification, null, null, null, true);
                } else {
                    syncAgentService.systemCreateObject(workModeOccurrenceNotification, null);
                }

            }
        }
    }

    /**
     * @param timecardEntry
     * @param agent
     * @param teamLeader
     * @param validActivityCodeList
     * @param lobConfiguration
     * @throws Exception
     */
    private void generateInvalidActivityCodeNotification(TimecardEntry timecardEntry, Agent agent, TeamLeader teamLeader, List<String> validActivityCodeList,
                                                         LOBConfiguration lobConfiguration) throws Exception {


        TimecardActivity timecardActivity = syncAgentService.systemGetByObject(timecardEntry.getTimecardActivity());

        if (!validActivityCodeList.contains(timecardActivity.getCode())) {

            if (agent == null) {
                agent = syncAgentService.systemGetByObject(timecardEntry.getAgent());
            }
            if (agent != null && teamLeader == null) {
                teamLeader = agent.getTeamLeader();
            }

            if (agent != null && teamLeader != null) {
                InvalidActivityCodeNotification invalidActivityCodeNotification = null;

                boolean isExistingNotif = false;
                timecardEntry = syncAgentService.systemGetByObject(timecardEntry);
                Iterator<LOBConfigurationNotification> itrNotifications = timecardEntry.getNotifications().iterator();
                while (itrNotifications.hasNext()) {
                    LOBConfigurationNotification notification = syncAgentService.systemGetByObject(itrNotifications.next());
                    if ("InvalidActivityCodeNotification".equals(notification.getType())) {
                        invalidActivityCodeNotification = (InvalidActivityCodeNotification) notification;
//                        invalidActivityCodeNotification = new InvalidActivityCodeNotification();
//                        invalidActivityCodeNotification.setID(notification.getID());
//                        invalidActivityCodeNotification.setAgent(notification.getAgent()); //xxxx
//                        invalidActivityCodeNotification.setTeamLeader(notification.getTeamLeader());
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

                invalidActivityCodeNotification.setName("Invalid Activity Code Notification" + "-" + timecardActivity.getCode());
                invalidActivityCodeNotification.setType("InvalidActivityCodeNotification");
                invalidActivityCodeNotification.setMessage(MessageFormat.format(INVALID_ACTIVITY_CODE_NOTIIFCATION_MESSAGE, agent.getFullName(),
                        timecardActivity.getCode(), formatDate(timecardEntry.getSourceFromTime(), DATE_TIME_FORMAT_12_HR), formatDate(timecardEntry.getSourceToTime(), DATE_TIME_FORMAT_12_HR)));
                invalidActivityCodeNotification.setLOBConfiguration(lobConfiguration);
//                invalidActivityCodeNotification.setLOBConfigurationEntry();
                invalidActivityCodeNotification.setTimecardEntry(timecardEntry);
                invalidActivityCodeNotification.setIsRead(false);
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


        TimecardActivity timecardActivity = syncAgentService.systemGetByObject(timecardEntry.getTimecardActivity());

        if (nonBillableActivityCodeList.contains(timecardActivity.getCode())) {

            if (agent == null) {
                agent = syncAgentService.systemGetByObject(timecardEntry.getAgent());
            }
            if (agent != null && teamLeader == null) {
                teamLeader = agent.getTeamLeader();
            }

            if (agent != null && teamLeader != null) {
                NonBillableActivityNotification nonBillableActivityNotification = null;

                boolean isExistingNotif = false;
                timecardEntry = syncAgentService.systemGetByObject(timecardEntry);
                Iterator<LOBConfigurationNotification> itrNotifications = timecardEntry.getNotifications().iterator();
                while (itrNotifications.hasNext()) {
                    LOBConfigurationNotification notification = syncAgentService.systemGetByObject(itrNotifications.next());
                    if ("NonBillableActivityNotification".equals(notification.getType())) {
                        nonBillableActivityNotification = (NonBillableActivityNotification) notification;
//                        nonBillableActivityNotification = new NonBillableActivityNotification();
//                        nonBillableActivityNotification.setID(notification.getID());
//                        nonBillableActivityNotification.setAgent(notification.getAgent()); //xxxx
//                        nonBillableActivityNotification.setTeamLeader(notification.getTeamLeader());
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

                nonBillableActivityNotification.setName("Non-Billable Activity Notification" + "-" + timecardActivity.getCode());
                nonBillableActivityNotification.setType("NonBillableActivityNotification");
                nonBillableActivityNotification.setTimecardActivity(timecardEntry.getTimecardActivity());

                nonBillableActivityNotification.setMessage(MessageFormat.format(NONBILLABLE_ACTIVITY_CODE_NOTIIFCATION_MESSAGE, agent.getFullName(),
                        timecardActivity.getCode(), formatDate(timecardEntry.getSourceFromTime(), DATE_TIME_FORMAT_12_HR), formatDate(timecardEntry.getSourceToTime(), DATE_TIME_FORMAT_12_HR)));
                nonBillableActivityNotification.setLOBConfiguration(lobConfiguration);
//                nonBillableActivityNotification.setLOBConfigurationEntry();
                nonBillableActivityNotification.setTimecardEntry(timecardEntry);
                nonBillableActivityNotification.setIsRead(false);
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
                timecardEntry = syncAgentService.systemGetByObject(timecardEntry);
                Iterator<LOBConfigurationNotification> itrNotifications = timecardEntry.getNotifications().iterator();

                while (itrNotifications.hasNext()) {
                    LOBConfigurationNotification notification = syncAgentService.systemGetByObject(itrNotifications.next());
                    if ("OccurrenceToleranceNotification".equals(notification.getType())) {
                        occurrenceToleranceNotification = (OccurrenceToleranceNotification) notification;
//                        occurrenceToleranceNotification = new OccurrenceToleranceNotification();
//                        occurrenceToleranceNotification.setID(notification.getID());
//                        occurrenceToleranceNotification.setAgent(notification.getAgent()); //xxxx
//                        occurrenceToleranceNotification.setTeamLeader(notification.getTeamLeader());
                        isExistingNotif = true;
                    }
                }


                if (occurrenceToleranceNotification == null) {
                    occurrenceToleranceNotification = new OccurrenceToleranceNotification();
                    occurrenceToleranceNotification.setID(UUID.randomUUID().toString());
                    occurrenceToleranceNotification.setAgent(agent);
                    occurrenceToleranceNotification.setTeamLeader(teamLeader);
                }

                TimecardActivity timecardActivity = syncAgentService.systemGetByObject(timecardEntry.getTimecardActivity());
                occurrenceToleranceNotification.setCreatedOn(new Date());

                occurrenceToleranceNotification.setName("Occurrence Tolerance Notification" + "-" + timecardActivity.getCode() + "-" + consecutiveActivityList.size());
                occurrenceToleranceNotification.setType("OccurrenceToleranceNotification");

                occurrenceToleranceNotification.setMessage(MessageFormat.format(OCCURRENCE_TOLERANCE_NOTIIFCATION_MESSAGE, agent.getFullName(),
                        timecardActivity.getCode(), formatDate(timecardEntry.getSourceFromTime(), DATE_TIME_FORMAT_12_HR), formatDate(timecardEntry.getSourceToTime(), DATE_TIME_FORMAT_12_HR), OCCURRENCE_MAX));
                occurrenceToleranceNotification.setLOBConfiguration(lobConfiguration);
                occurrenceToleranceNotification.setLOBConfigurationEntry(lobConfigurationEntry);
                occurrenceToleranceNotification.setTimecardEntry(timecardEntry);
                occurrenceToleranceNotification.setIsRead(false);
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
                timecardEntry = syncAgentService.systemGetByObject(timecardEntry);
                Iterator<LOBConfigurationNotification> itrNotifications = timecardEntry.getNotifications().iterator();
                while (itrNotifications.hasNext()) {
                    LOBConfigurationNotification notification = syncAgentService.systemGetByObject(itrNotifications.next());
                    if ("DurationToleranceNotification".equals(notification.getType())) {
                        durationToleranceNotification = (DurationToleranceNotification) notification;
//                        durationToleranceNotification = new DurationToleranceNotification();
//                        durationToleranceNotification.setID(notification.getID());
//                        durationToleranceNotification.setAgent(notification.getAgent()); //xxxx
//                        durationToleranceNotification.setTeamLeader(notification.getTeamLeader());
                        isExistingNotif = true;
                    }
                }


                if (durationToleranceNotification == null) {
                    durationToleranceNotification = new DurationToleranceNotification();
                    durationToleranceNotification.setID(UUID.randomUUID().toString());
                    durationToleranceNotification.setAgent(agent);
                    durationToleranceNotification.setTeamLeader(teamLeader);
                }

                TimecardActivity timecardActivity = syncAgentService.systemGetByObject(timecardEntry.getTimecardActivity());
                durationToleranceNotification.setCreatedOn(new Date());

                durationToleranceNotification.setName("Duration Tolerance Notification" + "-" + timecardActivity.getCode() + "-" + totalDuration);
                durationToleranceNotification.setType("DurationToleranceNotification");

                durationToleranceNotification.setMessage(MessageFormat.format(DURATION_TOLERANCE_NOTIIFCATION_MESSAGE, agent.getFullName(),
                        timecardActivity.getCode(), formatDate(timecardEntry.getSourceFromTime(), DATE_TIME_FORMAT_12_HR), formatDate(timecardEntry.getSourceToTime(), DATE_TIME_FORMAT_12_HR), totalDuration));
                durationToleranceNotification.setTimecardEntry(timecardEntry);
                durationToleranceNotification.setLOBConfiguration(lobConfiguration);
                durationToleranceNotification.setLOBConfigurationEntry(lobConfigurationEntry);
                durationToleranceNotification.setIsRead(false);
                if (isExistingNotif) {
                    syncAgentService.systemPutObject(durationToleranceNotification, null, null, null, true);
                } else {
                    syncAgentService.systemCreateObject(durationToleranceNotification, null);
                }
            }
        }
    }


    //Utility methods specific to the notifications
    private Date getCurrentShiftCMSEntries(Agent agent, final List<CMSEntry> cmsEntriesOfTheShift, CMSEntry watchedCMSEntry) {

//        List<CMSEntry> cmsEntriesOfTheShift = new ArrayList<CMSEntry>();

        Date beginDate = watchedCMSEntry.getFromTime();

//        List<CMSEntry> rawList = agent.getCMSEntries();
//
//
//        ;;;;;;;;;;;;;==========
//
//        List<CMSEntry> sortedList = new ArrayList<CMSEntry>();
//
//        for (int index=0 ; index < rawList.size() ; index++ ) {
//
//            CMSEntry cmsEntry = syncAgentService.systemGetByObject(rawList.get(index));
//            sortedList.add(cmsEntry);
//        }

        List<CMSEntry> sortedList = getSortedCMSEntries(agent.getCMSEntries());

//        Collections.sort(sortedList, new CMSEntryDateComparator());

        //Iterator<CMSEntry> itrCMSEntry = agent.getCMSEntries().iterator();
        Date shiftDate = new Date(watchedCMSEntry.getFromTime().getTime());
        CMSEntry lastCMSEntry = null;

        boolean exitCondi = false;
        for (int index = 0; index < sortedList.size() && !exitCondi; index++) {

            CMSEntry cmsEntry = syncAgentService.systemGetByObject(sortedList.get(index));
            //Check the the entry belongs to the current shift

            if (cmsEntry != null) {
                //Laps time bet'n current and last entry is more than 4 hrs means this is new shift entry / first entry of the shift

                if (lastCMSEntry != null && calLapsMin(cmsEntry.getToTime(), lastCMSEntry.getFromTime()) > 120) { //2hrs
                    exitCondi = true;
                } else {

                    lastCMSEntry = cmsEntry;

                    if ((watchedCMSEntry.getCMSAuxMode() == null && cmsEntry.getCMSAuxMode() == null)
                            || (watchedCMSEntry.getCMSAuxMode() != null && cmsEntry.getCMSAuxMode() != null
                            && watchedCMSEntry.getCMSAuxMode().equals(cmsEntry.getCMSAuxMode()))) {
                        cmsEntriesOfTheShift.add(cmsEntry);

                        beginDate = cmsEntry.getFromTime(); // This is the first occurrence of the auxcode for the current shift
                    }
                }
            }
        }

//        for (int index=cmsEntriesOfTheShift.size()-1 ; index>=0 ; index++ ) {
//
//            CMSEntry cmsEntry = syncAgentService.systemGetByObject(cmsEntriesOfTheShift.get(index));
//            //Check the the entry bellongs to
//
//            if (cmsEntry != null && compareDates(watchedCMSEntry.getFromTime(), cmsEntry.getFromTime()) &&
//                    ((watchedCMSEntry.getCMSAuxMode() == null && cmsEntry.getCMSAuxMode() == null)
//                            || (watchedCMSEntry.getCMSAuxMode() != null && cmsEntry.getCMSAuxMode() != null
//                            && watchedCMSEntry.getCMSAuxMode().equals(cmsEntry.getCMSAuxMode())))) {
//                //Get the date/time of the first entry of the day
//                if (cmsEntry.getFromTime().compareTo(beginDate) < 0) {
//                    beginDate = cmsEntry.getFromTime();
//                }
//                cmsEntriesOfTheShift.add(cmsEntry);
//            }
//        }

//        return cmsEntriesOfTheShift;
        return beginDate;
    }

    private Double getConsecutiveActivityCodeDetailFromTimecard(Agent agent, List<TimecardEntry> sortedTimecardEntries, TimecardEntry watchedTimecardEntry,
                                                                String activityCode, final List<TimecardEntry> timecardEntryListOfActivityCode) {

//        Integer consecutiveAcitivityCount = 0;
        Double activityTimeSpan = 0.0;

        Timecard timecard = syncAgentService.systemGetByObject(watchedTimecardEntry.getTimecard());

//        List<TimecardEntry> timecardEntryList = timecard.getTimecardEntries();

        int indexOfWatchedEntry = 0;

        for (int cnt = 0; cnt < sortedTimecardEntries.size(); cnt++) {
            if (sortedTimecardEntries.get(cnt).getID().equals(watchedTimecardEntry.getID())) {
                indexOfWatchedEntry = cnt;
            }
        }

        boolean processData = true;

        //Here the assumption is the TimecardEntres are sorted based on the time. If not this logic may not work/
        //Infact this logic is provided by CVG and they have assumption on this front
//        for (int cnt = timecardEntryList.size() ; cnt >= 0 && processData; cnt--) {
        for (int cnt = indexOfWatchedEntry; cnt >= 0 && processData; cnt--) {
            TimecardEntry timecardEntry = syncAgentService.systemGetByObject(sortedTimecardEntries.get(cnt));

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
        log.debug("********************************** Orphaned Notification Clean Process [Starts] **********************************:");
        log.debug(searchLOBNotification.getCMSEntry());
        log.debug(searchLOBNotification.getTimecardEntry());

        List<IPerceroObject> listOfOrphanedNotifications = syncAgentService.systemFindByExample(searchLOBNotification, null);

        Iterator<IPerceroObject> itrNotifications = listOfOrphanedNotifications.iterator();

        while (itrNotifications.hasNext()) {
            IPerceroObject iPerceroObject = itrNotifications.next();
            ClassIDPair classIdPairLobNotif = BaseDataObject.toClassIdPair(iPerceroObject);

            Notification notification = (Notification) syncAgentService.systemGetById(classIdPairLobNotif);

            if (notification != null) {

                syncAgentService.systemDeleteObject(notification, null, true);
                log.debug("XXXXXXXXX Notification ID:  [ " + notification.getID() + "] DELETED XXXXXXXXX");
            } else {
                log.debug("No Notification found for ID: " + classIdPairLobNotif);
            }
        }
        log.debug("********************************** Orphaned Notification Clean Process [Ends] **********************************:");
    }

    private void deleteTimecardEntryOrphanedNotifications(LOBConfigurationNotification lOBNotification) throws Exception {
        //Get list of LOBConfigurationNotification based on deleted CMSEntry ID
        //TODO:Clean this logs if not required. This is frequent operation and may consume resouces unnecessarily
        log.debug("********************************** TimecardEntry Orphaned Notification Clean Process [Starts] **********************************:");


//        ClassIDPair classIdPairLobNotif = BaseDataObject.toClassIdPair(lOBNotification);

        LOBConfigurationNotification notification = (LOBConfigurationNotification) syncAgentService.systemGetByObject(lOBNotification);

        if (notification != null) {

            syncAgentService.systemDeleteObject(notification, null, true);
            log.debug("XXXXXXXXX Notification ID:  [ " + notification.getID() + "] DELETED XXXXXXXXX");
        } else {
            log.debug("No Notification found for ID: " + lOBNotification.getID());
        }

        log.debug("********************************** Orphaned Notification Clean Process [Ends] **********************************:");
    }

    private void generatePhoneTimeVarianceNotification(TimecardEntry timecardEntry, Agent agent, TeamLeader teamLeader,
                                                       LOBConfiguration lobConfiguration, LOBConfigurationEntry lobConfigurationEntry, List<TimecardEntry> consecutiveActivityList) throws Exception {


        int DURATION_MAX = lobConfigurationEntry.getMax() == null ? 0 : Integer.parseInt(lobConfigurationEntry.getMax());

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
                timecardEntry = syncAgentService.systemGetByObject(timecardEntry);
                Iterator<LOBConfigurationNotification> itrNotifications = timecardEntry.getNotifications().iterator();

                while (itrNotifications.hasNext()) {
                    LOBConfigurationNotification notification = syncAgentService.systemGetByObject(itrNotifications.next());
                    if ("DurationMismatchNotification".equals(notification.getType())) {
                        durationMismatchNotification = (DurationMismatchNotification) notification;
//                        durationMismatchNotification = new DurationMismatchNotification();
//                        durationMismatchNotification.setID(notification.getID());
//                        durationMismatchNotification.setAgent(notification.getAgent()); //xxxx
//                        durationMismatchNotification.setTeamLeader(notification.getTeamLeader());
                        isExistingNotif = true;
                    }
                }


                if (durationMismatchNotification == null) {
                    durationMismatchNotification = new DurationMismatchNotification();
                    durationMismatchNotification.setID(UUID.randomUUID().toString());
                    durationMismatchNotification.setAgent(agent);
                    durationMismatchNotification.setTeamLeader(teamLeader);
                }
                TimecardActivity timecardActivity = syncAgentService.systemGetByObject(timecardEntry.getTimecardActivity());

                durationMismatchNotification.setCreatedOn(new Date());

                durationMismatchNotification.setName("Duration Mismatch Notification" + "-" + timecardActivity.getCode() + "-" + duration);
                durationMismatchNotification.setType("DurationMismatchNotification");

                durationMismatchNotification.setMessage(MessageFormat.format(DURATION_MISMATCH_NOTIFICATION_MESSAGE, agent.getFullName(),
                        timecardActivity.getCode(), formatDate(timecardEntry.getSourceFromTime(), DATE_TIME_FORMAT_12_HR), formatDate(timecardEntry.getSourceToTime(), DATE_TIME_FORMAT_12_HR)));
                durationMismatchNotification.setLOBConfiguration(lobConfiguration);
//                durationMismatchNotification.setLOBConfigurationEntry(lobConfigurationEntry);
                durationMismatchNotification.setTimecardEntry(timecardEntry);
                durationMismatchNotification.setIsRead(false);
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

        if (consecutiveActivityList.size() <= 0) {
            return duration;
        }

        List<CMSEntry> associatedCMSEntries = new ArrayList<CMSEntry>();

        //The consecutiveActivityList gets list of TimecardEntries in reverse order so first is last entry and last is first entry.
        Date timecardEntryStartTime = consecutiveActivityList.get(0).getFromTime();
        Date timecardEntryEndTime = consecutiveActivityList.get(consecutiveActivityList.size() - 1).getToTime();


        List<String> auxCodesForActivity = new ArrayList<String>();
        Iterator<LOBConfigurationActivityAuxCode> itrLOBConfigurationActivityAuxCode = lobConfigurationEntry.getLOBConfigurationActivityAuxCodes().iterator();

        while (itrLOBConfigurationActivityAuxCode.hasNext()) {
            LOBConfigurationActivityAuxCode lobConfigurationActivityAuxCode = syncAgentService.systemGetByObject(itrLOBConfigurationActivityAuxCode.next());
            auxCodesForActivity.add(lobConfigurationActivityAuxCode.getCMSAuxCode());
        }


//        lobConfigurationEntry.getMappedCMSAuxCode()
        List<CMSEntry> agentCMSEntries = getSortedCMSEntries(agent.getCMSEntries());

        int firstClosestCMSEntryIndex = 0;
        int lastClosestCMSEntryIndex = 0;

        long startTimeDiff = timecardEntryStartTime.getTime();//Some large number initialization to have
        long endTimeDiff = timecardEntryEndTime.getTime();//Some large number initialization to have

        for (int index = 0; index < agentCMSEntries.size(); index++) {

            //Do not load data again since sorting function already did it
//            CMSEntry cMSEntry = syncAgentService.systemGetByObject(agentCMSEntries.get(index));

            CMSEntry cMSEntry = agentCMSEntries.get(index);

            if (getTimeDiff(timecardEntryStartTime, cMSEntry.getFromTime()) < startTimeDiff) {
                startTimeDiff = getTimeDiff(timecardEntryStartTime, cMSEntry.getFromTime());
                firstClosestCMSEntryIndex = index;
            }

            if (getTimeDiff(timecardEntryEndTime, cMSEntry.getToTime()) < endTimeDiff) {
                endTimeDiff = getTimeDiff(timecardEntryEndTime, cMSEntry.getToTime());
                lastClosestCMSEntryIndex = index;
            }
        }

//        for (int index = 0; index < agentCMSEntries.size(); index++) {
//            CMSEntry cMSEntry = syncAgentService.systemGetByObject(agentCMSEntries.get(index));
//            if (auxCodesForActivity.contains(cMSEntry.getCMSAuxMode())) {
//                duration += cMSEntry.getDuration();
//            }
//        }
        if (agentCMSEntries.size() > 0) {

            for (int index = firstClosestCMSEntryIndex; index <= lastClosestCMSEntryIndex; index++) {
                CMSEntry cMSEntry = syncAgentService.systemGetByObject(agentCMSEntries.get(index));
                if (auxCodesForActivity.contains(cMSEntry.getCMSAuxMode())) {
                    duration += cMSEntry.getDuration();
                }
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

    private String formatDate(Date date, String dateFormat) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        return simpleDateFormat.format(date);
    }

    private Date stringToDate(String strDate, String dateFormat) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        Date date = null;

        try {
            date = simpleDateFormat.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }

    private int calLapsMin(Date oriFromDate, Date oriToDate) {
        String strFromDate = formatDate(oriFromDate, DATE_TIME_FORMAT_WITHOUT_SECONDS);
        String strToDate = formatDate(oriToDate, DATE_TIME_FORMAT_WITHOUT_SECONDS);

        oriFromDate = stringToDate(strFromDate, DATE_TIME_FORMAT_WITHOUT_SECONDS);
        oriToDate = stringToDate(strToDate, DATE_TIME_FORMAT_WITHOUT_SECONDS);

        return (int) (oriToDate.getTime() / MS_IN_MIN - oriFromDate.getTime() / MS_IN_MIN);
    }

    class CMSEntryDateComparator implements Comparator<CMSEntry> {

        @Override
        public int compare(CMSEntry entry1, CMSEntry entry2) {
            return entry2.getFromTime().compareTo(entry1.getFromTime());
        }
    }

    class TimecardEntryDateComparator implements Comparator<TimecardEntry> {

        @Override
        public int compare(TimecardEntry entry1, TimecardEntry entry2) {
            return entry1.getSourceFromTime().compareTo(entry2.getSourceFromTime());
        }
    }

    private List<CMSEntry> getSortedCMSEntries(List<CMSEntry> cmsEntries) {
        List<CMSEntry> sortedList = new ArrayList<CMSEntry>();

        for (int index = 0; index < cmsEntries.size(); index++) {

            CMSEntry cmsEntry = syncAgentService.systemGetByObject(cmsEntries.get(index));
            sortedList.add(cmsEntry);
        }

        Collections.sort(sortedList, new CMSEntryDateComparator());

        return sortedList;
    }

    private List<TimecardEntry> getSortedTimecardEntries(List<TimecardEntry> entryList) {
        List<TimecardEntry> sortedList = new ArrayList<TimecardEntry>();
        Collection<String> fieldsToWatch = new HashSet<String>();
        for (TimecardEntry timecardEntry : entryList) {
            timecardEntry = syncAgentService.systemGetByObject(timecardEntry);
            //watch derived fields
            accessManager.addWatcherField(BaseDataObject.toClassIdPair(timecardEntry), "fromTime", fieldsToWatch);
            accessManager.addWatcherField(BaseDataObject.toClassIdPair(timecardEntry), "toTime", fieldsToWatch);
            sortedList.add(timecardEntry);
        }

        Collections.sort(sortedList, new TimecardEntryDateComparator());

        return sortedList;

    }

    private void handleTimecardUpdate(String category, String subCategory, String fieldName, String[] params, IPerceroObject oldValue) throws Exception {
        // This is where the logic would go to create a Notification based on when the data requested above changes.
        //
        try {

            if (params != null && params.length >= 2) {
                String className = params[0];
                String classId = params[1];

                ClassIDPair classIdPair = new ClassIDPair(classId, className);
                IPerceroObject updatedObject = syncAgentService.systemGetById(classIdPair);

                if (updatedObject != null && updatedObject instanceof Timecard && oldValue != null) {
                    Timecard timecard = (Timecard) oldValue;

                    if (timecard != null) {

                        Iterator<TimecardEntry> itrTimecardEntries = timecard.getTimecardEntries().iterator();

                        while (itrTimecardEntries.hasNext()) {
//                            insertRecToUpdateTable(itrTimecardEntries.next().getID());
                            TimecardEntry timecardEntry = syncAgentService.systemGetByObject(itrTimecardEntries.next());
                            if (timecardEntry!=null && deleteTimecardEntry(timecardEntry)) {

                                Iterator<LOBConfigurationNotification> itrLobConfigurationNotif = timecardEntry.getNotifications().iterator();
                                while(itrLobConfigurationNotif.hasNext()) {

                                    deleteTimecardEntryOrphanedNotifications(itrLobConfigurationNotif.next());
                                }
//                                LOBConfigurationNotification searchAndDeleteLOBNotification = new LOBConfigurationNotification();
//                                searchAndDeleteLOBNotification.setTimecardEntry(timecardEntry);
//
//                                deleteOrphanedNotifications(searchAndDeleteLOBNotification);
                            }
                        }


                    }


                }


            }
        } catch (Exception e) {
            // Handle exception
            log.error("Error in LOB Notification", e);
        }
    }

    private boolean deleteTimecardEntry(TimecardEntry timecardEntry) {

        try {
            //Delete the object and communicate back to user that the object is deleted.
//            syncAgentService.systemDeleteObject(timecardEntry, null, true);
            return systemDeleteObject(timecardEntry, null, true);
        } catch (Exception e) {
            log.error("Error while deleting Timecard Entry ID : " + timecardEntry.getID(), e);
            return false;
        }


    }
//    private void insertRecToUpdateTable(String timecardEntryId) {
////        String selectQueryString = "SELECT MAX(ID) AS ID FROM UPDATE_TABLE";
//
//        String insertQueryString = "INSERT INTO UPDATE_TABLE (TABLENAME, ROW_ID, TYPE, TIMESTAMP) VALUES (?, ?, ?, sysdate)";
//
//        int updateTableId = 1; // default value
//
//        Connection conn = null;
//        PreparedStatement pstmt = null;
//        try {
//            IConnectionFactory connectionFactory = getConnectionRegistry().getConnectionFactory(CONNECTION_FACTORY_NAME);
//            conn = connectionFactory.getConnection();
//
//
//            //Insert record
//            pstmt = conn.prepareStatement(insertQueryString);
//            pstmt.setQueryTimeout(QUERY_TIMEOUT);
//            pstmt.setString(1, "AGENT_TIME_ENTRY_VW");
//            pstmt.setString(2, timecardEntryId);
//            pstmt.setString(3, "DELETE");
//            // pstmt.setDate(4, (java.sql.Date) new Date());
////            pstmt.setInt(4, ++updateTableId);
//            pstmt.execute();
//
//
//        } catch (Exception e) {
//            log.error("Unable to retrieveObjects\n" + insertQueryString, e);
//
//        } finally {
//            try {
//                if (pstmt != null) {
//                    pstmt.close();
//                }
//                if (conn != null) {
//                    conn.close();
//                }
//            } catch (Exception e) {
//                log.error("Error closing database statement/connection", e);
//            }
//        }
//    }

//    private Date getCreatedOnInAgentTimezone(Agent agent){
//        String timeZone = agent.getTimeZone();
//        Date createdOn = null;
//
//        try {
//            DateTimeZone dateTimeZone = DateTimeZone.forID(timeZone);
//            if (dateTimeZone != null) {
//                //This is requried since the dateTimeZine.getOffset(long time) has dependancy to local time. 
//                // ActiveStack server running on CST not in UTC. But the source time in UTC so this will not work.
//                // Do not change the code here. Following is the best approach
//                int offsetInMs = dateTimeZone.toTimeZone().getRawOffset();
//
//                createdOn = new DateTime((new Date()).getTime() + offsetInMs).toDate();
//
//            } else {
//                log.warn("Invalid time zone " + timeZone);
//            }
//        } catch (Exception e) {
//            // Invalid time zone.
//            log.error("Invalid time zone " + timeZone, e);
//        }
//        return createdOn;
//    }

    PulseDataConnectionRegistry connectionRegistry;

    public PulseDataConnectionRegistry getConnectionRegistry() {
        if (connectionRegistry == null) {
            connectionRegistry = PulseDataConnectionRegistry.getInstance();
        }
        return connectionRegistry;
    }

    private boolean systemDeleteObject(IPerceroObject perceroObject, String clientId, boolean pushToUser) throws Exception {
        boolean result = true;
        if (perceroObject == null)
            return true;

        String userId = accessManager.getClientUserId(clientId);
        IMappedClassManager mcm = MappedClassManagerFactory.getMappedClassManager();
        MappedClass mappedClass = mcm.getMappedClassByClassName(perceroObject.getClass().getName());
        if (mappedClass != null) {
            IDataProvider dataProvider = dataProviderManager.getDataProviderByName(mappedClass.dataProviderName);

            perceroObject = (IPerceroObject) dataProvider.findById(new ClassIDPair(perceroObject.getID(), perceroObject.getClass().getCanonicalName()), null);

            if (perceroObject == null) {
                return true;
            }

            Iterator<Map.Entry<MappedField, MappedField>> itrCascadeRemoveFieldReferencesEntrySet = mappedClass.cascadeRemoveFieldReferences.entrySet().iterator();
            while (itrCascadeRemoveFieldReferencesEntrySet.hasNext()) {
                Map.Entry<MappedField, MappedField> nextEntry = itrCascadeRemoveFieldReferencesEntrySet.next();
                MappedField nextRemoveMappedFieldRef = nextEntry.getKey();
                try {
                    MappedField nextMappedField = nextEntry.getValue();
                    if (nextMappedField == null) {
                        // There is no direct link from mappedClass, so need to get all by example.
                        IPerceroObject tempObject = (IPerceroObject) nextRemoveMappedFieldRef.getMappedClass().clazz.newInstance();
                        nextRemoveMappedFieldRef.getSetter().invoke(tempObject, perceroObject);
                        IDataProvider dataProviderRef = dataProviderManager.getDataProviderByName(nextRemoveMappedFieldRef.getMappedClass().dataProviderName);
                        List<IPerceroObject> referencingObjectsNew = dataProviderRef.findAllRelatedObjects(perceroObject, nextMappedField, false, null);
                        List<IPerceroObject> referencingObjects = dataProviderRef.findByExample(tempObject, null, null, false);
                        Iterator<IPerceroObject> itrReferencingObjects = referencingObjects.iterator();
                        while (itrReferencingObjects.hasNext()) {
                            IPerceroObject nextReferencingObject = itrReferencingObjects.next();
                            systemDeleteObject(nextReferencingObject, clientId, true);
                        }
                    } else {
                        // We have the reverse lookup right here.
                        IPerceroObject tempObject = (IPerceroObject) nextRemoveMappedFieldRef.getMappedClass().clazz.newInstance();
                        nextRemoveMappedFieldRef.getSetter().invoke(tempObject, perceroObject);
                        IDataProvider dataProviderRef = dataProviderManager.getDataProviderByName(nextRemoveMappedFieldRef.getMappedClass().dataProviderName);
                        List<IPerceroObject> referencingObjectsNew = dataProviderRef.findAllRelatedObjects(perceroObject, nextMappedField, false, null);
                        List<IPerceroObject> referencingObjects = dataProviderRef.findByExample(tempObject, null, null, false);
                        Iterator<IPerceroObject> itrReferencingObjects = referencingObjects.iterator();
                        while (itrReferencingObjects.hasNext()) {
                            IPerceroObject nextReferencingObject = itrReferencingObjects.next();
                            systemDeleteObject(nextReferencingObject, clientId, true);
                        }
                    }
                } catch (Exception e) {
                    log.error("Unable to remove referenced object", e);
                    result = false;
                }
            }

//            Object[] nullObject = new Object[1];
//            nullObject[0] = null;
//            Iterator<Map.Entry<MappedField, MappedField>> itrNulledOnRemoveFieldReferencesEntrySet = mappedClass.nulledOnRemoveFieldReferences.entrySet().iterator();
//            while (itrNulledOnRemoveFieldReferencesEntrySet.hasNext()) {
//                Map.Entry<MappedField, MappedField> nextEntry = itrNulledOnRemoveFieldReferencesEntrySet.next();
//                MappedField nextToNullMappedFieldRef = nextEntry.getKey();
//                try {
//                    MappedField nextMappedField = nextEntry.getValue();
//                    if (nextMappedField == null) {
//                        // There is no direct link from mappedClass, so need to get all by example.
//                        IPerceroObject tempObject = (IPerceroObject) nextToNullMappedFieldRef.getMappedClass().clazz.newInstance();
//                        nextToNullMappedFieldRef.getSetter().invoke(tempObject, perceroObject);
//                        IDataProvider dataProviderRef = dataProviderManager.getDataProviderByName(nextToNullMappedFieldRef.getMappedClass().dataProviderName);
//                        List<IPerceroObject> referencingObjectsNew = dataProviderRef.findAllRelatedObjects(perceroObject, nextMappedField, false, null);
//                        List<IPerceroObject> referencingObjects = dataProviderRef.findByExample(tempObject, null, null, false);
//                        Iterator<IPerceroObject> itrReferencingObjects = referencingObjects.iterator();
//                        while (itrReferencingObjects.hasNext()) {
//                            IPerceroObject nextReferencingObject = itrReferencingObjects.next();
//                            nextToNullMappedFieldRef.getSetter().invoke(nextReferencingObject, nullObject);
//                            systemPutObject((IPerceroObject) nextReferencingObject, null, new Date(), userId, true);
//                        }
//                    } else {
//                        // We have the reverse lookup right here.
//                        IPerceroObject tempObject = (IPerceroObject) nextToNullMappedFieldRef.getMappedClass().clazz.newInstance();
//                        nextToNullMappedFieldRef.getSetter().invoke(tempObject, perceroObject);
//                        IDataProvider dataProviderRef = dataProviderManager.getDataProviderByName(nextToNullMappedFieldRef.getMappedClass().dataProviderName);
//                        List<IPerceroObject> referencingObjectsNew = dataProviderRef.findAllRelatedObjects(perceroObject, nextMappedField, false, null);
//                        List<IPerceroObject> referencingObjects = dataProviderRef.findByExample(tempObject, null, null, false);
//                        Iterator<IPerceroObject> itrReferencingObjects = referencingObjects.iterator();
//                        while (itrReferencingObjects.hasNext()) {
//                            IPerceroObject nextReferencingObject = itrReferencingObjects.next();
//                            nextToNullMappedFieldRef.getSetter().invoke(nextReferencingObject, nullObject);
//                            systemPutObject((IPerceroObject) nextReferencingObject, null, new Date(), userId, true);
//                        }
//                    }
//                } catch (Exception e) {
//                    log.error("Unable to remove referenced object", e);
//                    result = false;
//                }
//            }

            Map<ClassIDPair, MappedField> objectsToUpdate = mappedClass.getRelatedClassIdPairMappedFieldMap(perceroObject, false);

            ArrayList objectsToDelete = new ArrayList();
            objectsToDelete.add(BaseDataObject.toClassIdPair(perceroObject));

            // If the result has been set to false, it means that deletion/update of one of the related objects failed.
//            if (result && dataProvider.deleteObject(BaseDataObject.toClassIdPair(perceroObject), null)) {
            if (result && deleteObjectsFromRedisCache(objectsToDelete)) {
                // Also store historical record, if necessary.

                postDeleteHelper.postDeleteObject(perceroObject, userId, clientId, pushToUser);

                Iterator<Entry<ClassIDPair, MappedField>> itrObjectsToUpdate = objectsToUpdate.entrySet().iterator();
                while (itrObjectsToUpdate.hasNext()) {
                    Entry<ClassIDPair, MappedField> nextObjectToUpdate = itrObjectsToUpdate.next();
                    Map<ClassIDPair, Collection<MappedField>> changedFields = new HashMap<ClassIDPair, Collection<MappedField>>();
                    Collection<MappedField> changedMappedFields = new ArrayList<MappedField>(1);
                    changedMappedFields.add(nextObjectToUpdate.getValue());
                    changedFields.put(nextObjectToUpdate.getKey(), changedMappedFields);
                    postPutHelper.postPutObject(nextObjectToUpdate.getKey(), userId, clientId, true, changedFields);
                }

                result = true;
            } else {
                result = false;
            }
        }

        return result;
    }

    private boolean systemPutObject(IPerceroObject perceroObject, String transactionId, Date updateDate, String userId, boolean pushToUser) {
        // Get the MappedClass and determine which DataProvider provides data for this object.
        IMappedClassManager mcm = MappedClassManagerFactory.getMappedClassManager();
        MappedClass mappedClass = mcm.getMappedClassByClassName(perceroObject.getClass().getName());
        IPerceroObject result = null;
        Map<ClassIDPair, Collection<MappedField>> changedFields = null;

        // Check to see if object has a history.
        ObjectModJournal objectModJournal = null;
        try {
            // Get the most recent ObjectModJournal.
            try {
                objectModJournal = (ObjectModJournal) cacheDataStore.listIndex(RedisKeyUtils.objectModJournal(perceroObject.getClass().getName(), perceroObject.getID()));
            } catch (Exception e) {
                log.warn("Unable to retrieve most recent objectModJournal", e);
            }

            boolean isOkToUpdate = true;

            Date currentDate = new Date();
            if (updateDate != null && updateDate.getTime() > currentDate.getTime()) {
                updateDate.setTime(currentDate.getTime());
            }

            // Compare Modification dates.
            if (objectModJournal != null && objectModJournal.getDateModified() != null && updateDate != null) {
                if (objectModJournal.getDateModified().compareTo(updateDate) >= 0) {
                    // The ObjectModJournal is newer, therefore reject this update.
                    isOkToUpdate = false;
                }
            }

            if (updateDate == null)
                updateDate = new Date();

            if (isOkToUpdate) {
                IDataProvider dataProvider = dataProviderManager.getDataProviderByName(mappedClass.dataProviderName);
                changedFields = dataProvider.getChangedMappedFields(perceroObject);
                if (changedFields == null || changedFields.size() > 0) {
                    result = dataProvider.putObject(perceroObject, changedFields, null);

                    if (result != null) {
                        // Now record the updated object.
                        ObjectModJournal newModJournal = new ObjectModJournal();
                        newModJournal.setID(UUID.randomUUID().toString());
                        if (transactionId == null || transactionId.length() == 0)
                            transactionId = UUID.randomUUID().toString();
                        newModJournal.setTransactionId(transactionId);
                        newModJournal.setClassID(result.getID());
                        newModJournal.setClassName(result.getClass().getName());
                        newModJournal.setDateModified(updateDate);

                        cacheDataStore.lpushListValue(RedisKeyUtils.objectModJournal(result.getClass().getCanonicalName(), result.getID()), newModJournal);

                        // Also store historical record, if necessary.
                        // Get the Current object if this is a BaseHistoryObject.
//                        if (storeHistory && (result instanceof IHistoryObject))
//                        {
//                            HistoricalObject historyObject = new HistoricalObject();
//                            historyObject.setObjectVersion(result.classVersion());
//                            historyObject.setID(UUID.randomUUID().toString());
//                            historyObject.setObjectChangeDate(updateDate);
//                            historyObject.setObjectClassName(result.getClass().getName());
//                            historyObject.setObjectId(result.getID());
//                            historyObject.setObjectChangerId(userId);
//                            historyObject.setObjectData(safeObjectMapper.writeValueAsString(result));
//
//                            cacheDataStore.lpushListValue(RedisKeyUtils.historicalObject(result.getClass().getCanonicalName(), result.getID()), historyObject);
//
//                            //syncSession.save(historyObject);
//                        }

//                        if (taskExecutor != null && false) {
//                            taskExecutor.execute(new PostPutTask(postPutHelper, BaseDataObject.toClassIdPair((BaseDataObject) result), userId, null, pushToUser, changedFields));
//                        } else {
                        postPutHelper.postPutObject(BaseDataObject.toClassIdPair((BaseDataObject) result), userId, null, pushToUser, changedFields);
//                        }
                    }
                } else {
                    log.info("Unnecessary PutObject: " + perceroObject.getClass().getCanonicalName() + " (" + perceroObject.getID() + ")");
                    result = perceroObject;
                }
            }

        } catch (Exception e) {
            log.error("Error getting ObjectModJournal", e);
        }

        return (result != null);
    }


    private boolean deleteObjectsFromRedisCache(List<ClassIDPair> results) {
        if (cacheTimeout > 0) {
            Set<String> objectStrings = new HashSet<String>(results.size());
            Map<String, Set<String>> mapJsonClassIdStrings = new HashMap<String, Set<String>>();
            Iterator<ClassIDPair> itrDatabaseObjects = results.iterator();
            while (itrDatabaseObjects.hasNext()) {
                ClassIDPair nextDatabaseObject = itrDatabaseObjects.next();
                String nextCacheKey = RedisKeyUtils.classIdPair(nextDatabaseObject.getClassName(), nextDatabaseObject.getID());
                objectStrings.add(nextCacheKey);

                Set<String> classIdList = mapJsonClassIdStrings.get(RedisKeyUtils.classIds(nextDatabaseObject.getClassName()));
                if (classIdList == null) {
                    classIdList = new HashSet<String>();
                    mapJsonClassIdStrings.put(RedisKeyUtils.classIds(nextDatabaseObject.getClassName()), classIdList);
                }
                classIdList.add(nextDatabaseObject.getID());
            }

            // Store the objects in redis.
            cacheDataStore.deleteKeys(objectStrings);
            // Store the class Id's list in redis.
            cacheDataStore.removeSetsValues(mapJsonClassIdStrings);
        }
        return true;
    }

}