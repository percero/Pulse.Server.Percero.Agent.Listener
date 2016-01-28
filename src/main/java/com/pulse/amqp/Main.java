package com.pulse.amqp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.percero.agents.sync.access.IAccessManager;
import com.percero.agents.sync.access.RedisKeyUtils;
import com.percero.agents.sync.helpers.PostPutHelper;
import com.percero.agents.sync.metadata.IMappedClassManager;
import com.percero.agents.sync.metadata.MappedClass;
import com.percero.agents.sync.metadata.MappedClassManagerFactory;
import com.percero.agents.sync.metadata.MappedField;
import com.percero.agents.sync.services.IDataProvider;
import com.percero.agents.sync.vo.ObjectModJournal;
import com.percero.framework.vo.IPerceroObject;
import com.pulse.dataprovider.IConnectionFactory;
import com.pulse.dataprovider.PulseDataConnectionRegistry;
import com.pulse.mo.dao.LOBConfigurationDAO;
import com.sun.corba.se.impl.orbutil.concurrent.Sync;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.percero.agents.sync.services.ISyncAgentService;
import com.percero.agents.sync.services.SyncAgentService;
import com.percero.agents.sync.vo.ClassIDPair;
import com.pulse.mo.Agent;
import com.pulse.mo.AgentScorecard;
import com.pulse.mo.DevelopmentActivity;
import com.pulse.mo.DevelopmentPlan;
import com.pulse.mo.LOBConfiguration;
import com.pulse.mo.Scorecard;
import com.pulse.mo.TeamLeader;
import com.pulse.mo.ThresholdExceededNotification;
import com.percero.agents.sync.vo.BaseDataObject;

import com.pulse.mo.*;

/**
 * This class supplies the main method that creates the spring context
 * and then all processing is invoked asynchronously by messaging.
 *
 * @author Percero
 */
public class Main {
    private static final Logger log = Logger.getLogger(Main.class);


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


    protected static ISyncAgentService syncAgentService;

    @Autowired
    protected static  IAccessManager accessManager;

    /**
     * Main function for starting the process
     */
    @SuppressWarnings("resource")
    public static void main(String[] args) {

        String config = "spring/percero-spring-config.xml"; // Default
//        String config = "custom_spring/updateTable-estart-spring-config.xml";
//          String config = "custom_spring/updateTable-cms-spring-config.xml";
        if (args.length > 0)
            config = args[0];

        log.info("Using config: " + config);
        ApplicationContext context =
                new ClassPathXmlApplicationContext(new String[]{config, "spring/*.xml"});
        log.debug(context.toString());

        log.info("\n\n****************************************\nApplication Started\n****************************************\n\n");

//        getNotificationFromTimecardEntry(context);
//        doUnitTestsOnMain(context);
//        testNewNotificationsUnReads(context);
//        try {
//            ghostDeletionByTimecardId(context);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    private static void ghostDeletionByTimecardId(ApplicationContext context) throws Exception {

//        223598983

        syncAgentService = context.getBean(ISyncAgentService.class);
        accessManager = context.getBean(IAccessManager.class);

        LOBConfigurationNotification findLOBConfigurationNotificaiton = new LOBConfigurationNotification();
        findLOBConfigurationNotificaiton.setTimecardId("223598983");

        deleteOrphanedNotifications(findLOBConfigurationNotificaiton);

    }

    private static void doUnitTestsOnMain(ApplicationContext context) {
//        testEnqueueCheckChangeWatcher(context);
        testNotifications(context);
    }

    private static void testNewNotificationsUnReads(ApplicationContext context){
        syncAgentService = context.getBean(ISyncAgentService.class);
        accessManager = context.getBean(IAccessManager.class);

        TeamLeader teamLeader = new TeamLeader();
        teamLeader.setID("100500731");//100139921
//        teamLeader.setID("100544696");
        try {
            teamLeader = (TeamLeader) syncAgentService.systemGetById(BaseDataObject.toClassIdPair(teamLeader));
//			Iterator<TeamLeader> itrTeamLeaders = (Iterator<TeamLeader>) syncAgentService.getAllByName(TeamLeader.class.getCanonicalName(), false, null).iterator();
//			while (itrTeamLeaders.hasNext()) {
//			teamLeader = (TeamLeader) syncAgentService.systemGetById(BaseDataObject.toClassIdPair(itrTeamLeaders.next()));

//			teamLeader = (TeamLeader) syncAgentService.findById(BaseDataObject.toClassIdPair(teamLeader), null);
//			Iterator<Notification> itrNotifications = teamLeader.getNotifications().iterator();
//			while (itrNotifications.hasNext()) {
//				Notification nextNotification = itrNotifications.next();
//				if (nextNotification instanceof ShiftStatusNotification) {
//					ShiftStatusNotification shiftStatusNotification = (ShiftStatusNotification) nextNotification;
//					System.out.println(ShiftStatusNotificationCWHelper.NOT_YET_STARTED_STATE_COUNT + ": " + shiftStatusNotification.getNotYetStartedStateCount());
//					System.out.println(ShiftStatusNotificationCWHelper.APPROVED_STATE_COUNT + ": " + shiftStatusNotification.getApprovedStateCount());
//					System.out.println(ShiftStatusNotificationCWHelper.COMPLETED_STATE_COUNT + ": " + shiftStatusNotification.getCompletedStateCount());
//					System.out.println(ShiftStatusNotificationCWHelper.IN_PROGRESS_STATE_COUNT + ": " + shiftStatusNotification.getInProgressStateCount());
////					System.out.println(shiftStatusNotification.getPendingCoachStateCount());
////					System.out.println(shiftStatusNotification.getPendingEmployeeStateCount());
////					System.out.println(shiftStatusNotification.getPendingStateCount());
////					System.out.println(shiftStatusNotification.getSkippedStateCount());
////					System.out.println(shiftStatusNotification.getSubmittedStateCount());
//				}
//				else if (nextNotification instanceof CoachingNotification) {
//					CoachingNotification coachingNotification = (CoachingNotification) nextNotification;
//					System.out.println(coachingNotification.getAcknowledgementStateCount());
//					System.out.println(coachingNotification.getPendingCoachStateCount());
//					System.out.println(coachingNotification.getPendingEmployeeStateCount());
//					System.out.println(coachingNotification.getPendingStateCount());
//					System.out.println(coachingNotification.getSkippedStateCount());
//					System.out.println(coachingNotification.getSubmittedStateCount());
//				}
//			}
//
            Iterator<Notification> itrNotifications = teamLeader.getNotificationsUnRead().iterator();
            while (itrNotifications.hasNext()) {
                Notification notification = syncAgentService.systemGetByObject(itrNotifications.next());

                System.out.println(notification.getCreatedOn());
            }
//
            System.out.println("done");

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
    private static void getNotificationFromTimecardEntry(ApplicationContext context) {
        syncAgentService = context.getBean(ISyncAgentService.class);
//
//		Agent agent = new Agent();
//		agent.setID("RANDOM_ID");
////		teamLeader.setID("100458644");
//

        TimecardEntry timecardEntry = new TimecardEntry();
        timecardEntry.setID("1007493393");

        try {
            timecardEntry = (TimecardEntry) syncAgentService.systemGetByObject(timecardEntry);

            Iterator<LOBConfigurationNotification> itrNotifications = timecardEntry.getNotifications().iterator();

            while (itrNotifications.hasNext()) {

                LOBConfigurationNotification notification = itrNotifications.next();

                System.out.println(notification.getID() + "-" + notification.getType());


            }

//
            System.out.println("done");

        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    private static void testEnqueueCheckChangeWatcher(ApplicationContext context) {
        PostPutHelper postPutHelper = context.getBean(PostPutHelper.class);
        TeamLeader teamLeader = new TeamLeader();
        teamLeader.setID("asdf");

        Setting setting = new Setting();
        setting.setID("setting");
        teamLeader.setSettings(new ArrayList<Setting>());
        teamLeader.getSettings().add(setting);

        postPutHelper.enqueueCheckChangeWatcher(BaseDataObject.toClassIdPair(teamLeader), null, null, teamLeader);
    }

    private static void testNotifications(ApplicationContext context) {
        // Test Login

        //Uncomment this to run the test
//        if (1==1){
//            return ;
//        }
//		Map<String, Object> componentBeans = context.getBeansWithAnnotation(Component.class);
//		PerceroAgentListener percero = PerceroAgentListener.getInstance();
//		AuthenticationRequest authRequest = new AuthenticationRequest();
//		authRequest.setClientId("TEST");
//		authRequest.setAuthProvider(PulseHttpAuthProvider.ID);
//		authRequest.setClientType("NP");
//		authRequest.setCredential("cbro3302@na.convergys.com:vavubKeifojCin0!");
//
//		percero.handleAuthRequest(authRequest, "authenticate", "TEST");

//		// Test HTTP Connectors
//		Map<String, Object> root = new HashMap<String, Object>();
//		root.put("clientName", "CONVERGYS");
//		root.put("userName", "mobileapp");
//		root.put("password", "mobile");
//		root.put("value", "10851886002");
//
//		SyncAgentService syncAgentService = context.getBean(SyncAgentService.class);
//		try {
//			System.out.println(syncAgentService.runProcess("HTTP:EmployeeAccruals", root, null));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

//		// Test HTTP Connectors
//		Map<String, Object> root = new HashMap<String, Object>();
//		root.put("query", "hello siri");
//
//		SyncAgentService syncAgentService = context.getBean(SyncAgentService.class);
//		try {
//			System.out.println(syncAgentService.runProcess("HTTP:AskGoogle", root, null));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		
//		// Test StoredProc's Connectors
//		Map<String, Object> storedProcParams = new HashMap<String, Object>();
//		storedProcParams.put("lock_id", 12345);
//		storedProcParams.put("lock_date", "2015-09-23 23:12:01");
//
////		SyncAgentService syncAgentService = context.getBean(SyncAgentService.class);
//		try {
//			System.out.println(syncAgentService.runProcess("SQL_PROC:PULSE.MYTESTPROC", storedProcParams, null));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		try {
//			PerceroList<IPerceroObject> allPulseUsers = syncAgentService.getAllByName(PulseUser.class.getCanonicalName(), true, null);
//			System.out.println(allPulseUsers.getTotalLength());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}


        syncAgentService = context.getBean(ISyncAgentService.class);
//
//		Agent agent = new Agent();
//		agent.setID("RANDOM_ID");
////		teamLeader.setID("100458644");
//
        TeamLeader teamLeader = new TeamLeader();
        teamLeader.setID("100500731");//100139921
//        teamLeader.setID("100544696");
        try {
            teamLeader = (TeamLeader) syncAgentService.systemGetById(BaseDataObject.toClassIdPair(teamLeader));
//			Iterator<TeamLeader> itrTeamLeaders = (Iterator<TeamLeader>) syncAgentService.getAllByName(TeamLeader.class.getCanonicalName(), false, null).iterator();
//			while (itrTeamLeaders.hasNext()) {
//			teamLeader = (TeamLeader) syncAgentService.systemGetById(BaseDataObject.toClassIdPair(itrTeamLeaders.next()));

//			teamLeader = (TeamLeader) syncAgentService.findById(BaseDataObject.toClassIdPair(teamLeader), null);
//			Iterator<Notification> itrNotifications = teamLeader.getNotifications().iterator();
//			while (itrNotifications.hasNext()) {
//				Notification nextNotification = itrNotifications.next();
//				if (nextNotification instanceof ShiftStatusNotification) {
//					ShiftStatusNotification shiftStatusNotification = (ShiftStatusNotification) nextNotification;
//					System.out.println(ShiftStatusNotificationCWHelper.NOT_YET_STARTED_STATE_COUNT + ": " + shiftStatusNotification.getNotYetStartedStateCount());
//					System.out.println(ShiftStatusNotificationCWHelper.APPROVED_STATE_COUNT + ": " + shiftStatusNotification.getApprovedStateCount());
//					System.out.println(ShiftStatusNotificationCWHelper.COMPLETED_STATE_COUNT + ": " + shiftStatusNotification.getCompletedStateCount());
//					System.out.println(ShiftStatusNotificationCWHelper.IN_PROGRESS_STATE_COUNT + ": " + shiftStatusNotification.getInProgressStateCount());
////					System.out.println(shiftStatusNotification.getPendingCoachStateCount());
////					System.out.println(shiftStatusNotification.getPendingEmployeeStateCount());
////					System.out.println(shiftStatusNotification.getPendingStateCount());
////					System.out.println(shiftStatusNotification.getSkippedStateCount());
////					System.out.println(shiftStatusNotification.getSubmittedStateCount());
//				}
//				else if (nextNotification instanceof CoachingNotification) {
//					CoachingNotification coachingNotification = (CoachingNotification) nextNotification;
//					System.out.println(coachingNotification.getAcknowledgementStateCount());
//					System.out.println(coachingNotification.getPendingCoachStateCount());
//					System.out.println(coachingNotification.getPendingEmployeeStateCount());
//					System.out.println(coachingNotification.getPendingStateCount());
//					System.out.println(coachingNotification.getSkippedStateCount());
//					System.out.println(coachingNotification.getSubmittedStateCount());
//				}
//			}
//
            Iterator<Agent> itrAgents = teamLeader.getAgents().iterator();
            while (itrAgents.hasNext()) {
//                if (itrAgents.next().getID().equals("101007468")) {
                Agent nextAgent = syncAgentService.systemGetByObject(itrAgents.next());
//                extractConfiguration(syncAgentService);
//                Iterator<CMSEntry> itrCMSEntries = nextAgent.getCMSEntries().iterator();
//                while (itrCMSEntries.hasNext()) {
//                    CMSEntry cMSEntry = syncAgentService.systemGetByObject(itrCMSEntries.next());
////                    simulateCMSEntryDelete(syncAgentService, cMSEntry);
//                    //9th dec entry process
//                    //if (cMSEntry != null && cMSEntry.getFromTime().getDay() == 9 && cMSEntry.getFromTime().getMonth()==11){
//                    processCMSEntry(syncAgentService, cMSEntry);
//                    //}
//                }



                Iterator<Timecard> itrTimecard = nextAgent.getTimecards().iterator();

//                Iterator<CMSEntry> itrCMSEntries = nextAgent.getCMSEntries().iterator();
//                while (itrCMSEntries.hasNext()) {
//                    CMSEntry cmsEntry = syncAgentService.systemGetByObject(itrCMSEntries.next());
//
////                        System.out.println("timecard start date : " + timecard.getStartDate());
//                    //9th dec entry process
//                    if (cmsEntry != null) { //&& timecard.getStartDate().getDay() == 9 && timecard.getStartDate().getMonth()==11){
//
//                        handleCmsEntryNotification(cmsEntry);
//                    }
//                }

                while (itrTimecard.hasNext()) {
                    Timecard timecard = syncAgentService.systemGetByObject(itrTimecard.next());

//                        System.out.println("timecard start date : " + timecard.getStartDate());
                    //9th dec entry process
                    if (timecard != null) { //&& timecard.getStartDate().getDay() == 9 && timecard.getStartDate().getMonth()==11){

                        Iterator<TimecardEntry> itrTimecardEntries = timecard.getTimecardEntries().iterator();
                        while (itrTimecardEntries.hasNext()) {
                            TimecardEntry timecardEntry = syncAgentService.systemGetByObject(itrTimecardEntries.next());
                            if (timecardEntry != null) {// && timecardEntry.getFromTime().getDay() == 9 && timecardEntry.getFromTime().getMonth()==11) {
                                handleTimecardEntryNotification(timecardEntry);
                            }

                        }
                    }
                }

//                }
            }
//
            System.out.println("done");

        } catch (Exception e) {
            e.printStackTrace();

        }


    }


    private void handleCmsEntryNotification(CMSEntry updatedObject) throws Exception {
        // This is where the logic would go to create a Notification based on when the data requested above changes.
        try {



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
                            LOB tlob = new LOB();
                            tlob.setID("13573");

                            AgentLOB agentLOB = new AgentLOB();
                            agentLOB.setID(agent.getID() + "-" +tlob.getID());
                            agentLOB.setLOB(tlob);
                            agentLOB.setAgent(agent);

                            agent.getAgentLOBs().add(agentLOB);

                            if (agent.getAgentLOBs().size() == 1) {

                                //Valid scenario for notification
//                                AgentLOB agentLOB = syncAgentService.systemGetByObject(agent.getAgentLOBs().get(0));

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
                    criteriaCMSEntry.setID(updatedObject.getID());

                    LOBConfigurationNotification searchAndDeleteLOBNotification = new LOBConfigurationNotification();
                    searchAndDeleteLOBNotification.setCMSEntry(criteriaCMSEntry);

                    deleteOrphanedNotifications(searchAndDeleteLOBNotification);





            }
        } catch (Exception e) {
            // Handle exception
            log.error("Error in LOB Notification", e);
        }
    }

    private static void handleTimecardEntryNotification(TimecardEntry updatedObject) throws Exception {
        // This is where the logic would go to create a Notification based on when the data requested above changes.
        try {


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
                        LOB tlob = new LOB();
                        tlob.setID("13573");

                        AgentLOB agentLOB = new AgentLOB();
                        agentLOB.setID(agent.getID() + "-" +tlob.getID());
                        agentLOB.setLOB(tlob);
                        agentLOB.setAgent(agent);

                        agent.getAgentLOBs().add(agentLOB);

                        if (agent != null) {
                            if (agent.getAgentLOBs().size() == 1) {


                                //Valid scenario for notification
                                //Pick up the first AgentLOB because it is assumed that if Agent has other than 1 AgentLOB it is invalid scenario for Notification
//                                AgentLOB agentLOB = syncAgentService.systemGetByObject(agent.getAgentLOBs().get(0));

                                if (agentLOB != null) {

                                    LOB lob = syncAgentService.systemGetByObject(agentLOB.getLOB());

                                    if (lob != null) {

                                        List<LOBConfiguration> lobConfigurationList = lob.getLOBConfigurations();

                                        if (lobConfigurationList != null && lobConfigurationList.size() > 0) {

                                            //Preloading objects inorder do code duplication in subsequent calls.
                                            //Not passing them due to avoid long signatures. This will not make performance impact because rest
                                            //is in memory operations
                                            Timecard timecard = syncAgentService.systemGetByObject(timecardEntry.getTimecard());
                                            TimecardActivity timecarActivity = syncAgentService.systemGetByObject(timecardEntry.getTimecardActivity());

                                            List<TimecardEntry> sortedTimecardEntries = getSortedTimecardEntries(timecard.getTimecardEntries());
                                            List<TimecardEntry> consecutiveActivityList = new ArrayList<TimecardEntry>();


                                            Double consecutiveActivityDuration = getConsecutiveActivityCodeDetailFromTimecard(agent, sortedTimecardEntries, timecardEntry,
                                                    timecarActivity.getCode(), consecutiveActivityList);
                                            int activityCodeOccurrenceCount = getOccurrenceOfActivityCode(agent, sortedTimecardEntries, timecardEntry,
                                                    timecarActivity.getCode());

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
                                                                    lobConfiguration, lobConfigurationEntry, activityCodeOccurrenceCount);

                                                            if (consecutiveActivityList.size() > 0) {
                                                                generateDurationToleranceNotification(timecardEntry, agent, teamLeader,
                                                                        lobConfiguration, lobConfigurationEntry, consecutiveActivityDuration, consecutiveActivityList);
                                                            }

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
                accessManager.addWatcherField(BaseDataObject.toClassIdPair(cmsEntry), "notifications", fieldsToWatch);
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


//                workDurationNotification.setCreatedOn(new Date());
                workDurationNotification.setCreatedOn(cmsEntry.getFromTime());


//                workDurationNotification.setName("Work Duration Notification" + "-" + cmsEntry.getFromTime() + "-" + cmsEntry.getCMSAuxMode());
                workDurationNotification.setName("Work Duration Notification" + " - " + formatDate(fromDate, DATE_TIME_FORMAT_12_HR) + " - " + cmsEntry.getCMSAuxMode());
                workDurationNotification.setType("WorkDurationNotification");


                //Do not use the duration property of the CMSEntry, since it has decimal value. Customer do not want round half up either hence followed a patterned
                // which was implemented on UI for calculating duration
//                int intDuration = calLapsMin(fromDate, toDate);
//                workDurationNotification.setMessage(MessageFormat.format(WORK_MODE_DURATION_NOTIIFCATION_MESSAGE, agent.getFullName(), cmsEntry.getCMSAuxMode(),
//                        cmsEntry.getFromTime(), cmsEntry.getToTime(), duration)); //xxx
                workDurationNotification.setMessage(MessageFormat.format(WORK_MODE_DURATION_NOTIIFCATION_MESSAGE, agent.getFullName(), cmsEntry.getCMSAuxMode(),
                        formatDate(fromDate, DATE_TIME_FORMAT_12_HR), formatDate(toDate, DATE_TIME_FORMAT_12_HR), String.valueOf(intDuration), DURATION_MAX)); //xxx

                workDurationNotification.setLOBConfiguration(lobConfiguration); //xxx
                workDurationNotification.setLOBConfigurationEntry(lobConfigurationEntry);//xxx
                workDurationNotification.setCMSEntry(cmsEntry);
                workDurationNotification.setIsRead(false);

//                if (isExistingNotif) {
//                    syncAgentService.systemPutObject(workDurationNotification, null, null, null, true);
//                } else {
//                    syncAgentService.systemCreateObject(workDurationNotification, null);
//                }
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
                Collection<String> fieldsToWatch = new HashSet<String>();
                boolean isExistingNotif = false;
                accessManager.addWatcherField(BaseDataObject.toClassIdPair(cmsEntry), "notifications", fieldsToWatch);
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

//                workModeOccurrenceNotification.setCreatedOn(new Date());

                workModeOccurrenceNotification.setCreatedOn(cmsEntry.getFromTime());
                workModeOccurrenceNotification.setName("Work Mode Occurrence Notification" + " - " + formatDate(fromDate, DATE_TIME_FORMAT_12_HR) + " - " + cmsEntry.getCMSAuxMode() + " - " + cmsEntryList.size());
                workModeOccurrenceNotification.setType("WorkModeOccurrenceNotification");

                workModeOccurrenceNotification.setMessage(MessageFormat.format(WORK_MODE_OCCURRENCE_NOTIIFCATION_MESSAGE, agent.getFullName(), cmsEntry.getCMSAuxMode(),
                        formatDate(fromDate, DATE_TIME_FORMAT_12_HR), formatDate(toDate, DATE_TIME_FORMAT_12_HR), OCCURRENCE_MAX));
                workModeOccurrenceNotification.setLOBConfiguration(lobConfiguration);
                workModeOccurrenceNotification.setLOBConfigurationEntry(lobConfigurationEntry);
                workModeOccurrenceNotification.setCMSEntry(cmsEntry);
                workModeOccurrenceNotification.setIsRead(false);
//                if (isExistingNotif) {
//                    syncAgentService.systemPutObject(workModeOccurrenceNotification, null, null, null, true);
//                } else {
//                    syncAgentService.systemCreateObject(workModeOccurrenceNotification, null);
//                }

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
    private static void generateInvalidActivityCodeNotification(TimecardEntry timecardEntry, Agent agent, TeamLeader teamLeader, List<String> validActivityCodeList,
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

//                boolean isExistingNotif = false;
                timecardEntry = syncAgentService.systemGetByObject(timecardEntry);

//                Logic to get timecardEntry based notifications and check the this type already exists. If exists --> update else create.
//                Collection<String> fieldsToWatch = new HashSet<String>();
//                accessManager.addWatcherField(BaseDataObject.toClassIdPair(timecardEntry), "notifications", fieldsToWatch);
//                Iterator<LOBConfigurationNotification> itrNotifications = timecardEntry.getNotifications().iterator();
//                while (itrNotifications.hasNext()) {
//                    LOBConfigurationNotification notification = syncAgentService.systemGetByObject(itrNotifications.next());
//                    if ("InvalidActivityCodeNotification".equals(notification.getType())) {
//                        invalidActivityCodeNotification = (InvalidActivityCodeNotification) notification;
////                        invalidActivityCodeNotification = new InvalidActivityCodeNotification();
////                        invalidActivityCodeNotification.setID(notification.getID());
////                        invalidActivityCodeNotification.setAgent(notification.getAgent()); //xxxx
////                        invalidActivityCodeNotification.setTeamLeader(notification.getTeamLeader());
//                        isExistingNotif = true;
//                    }
//                }


                if (invalidActivityCodeNotification == null) {
                    invalidActivityCodeNotification = new InvalidActivityCodeNotification();
                    invalidActivityCodeNotification.setID(UUID.randomUUID().toString());
                    invalidActivityCodeNotification.setAgent(agent);
                    invalidActivityCodeNotification.setTeamLeader(teamLeader);
                }


//                invalidActivityCodeNotification.setCreatedOn(new Date());

                invalidActivityCodeNotification.setCreatedOn(timecardEntry.getSourceFromTime());
                invalidActivityCodeNotification.setName("Invalid Activity Code Notification" + " - " + timecardActivity.getCode());
                invalidActivityCodeNotification.setType("InvalidActivityCodeNotification");
                invalidActivityCodeNotification.setMessage(MessageFormat.format(INVALID_ACTIVITY_CODE_NOTIIFCATION_MESSAGE, agent.getFullName(),
                        timecardActivity.getCode(), formatDate(timecardEntry.getSourceFromTime(), DATE_TIME_FORMAT_12_HR), formatDate(timecardEntry.getSourceToTime(), DATE_TIME_FORMAT_12_HR)));
                invalidActivityCodeNotification.setLOBConfiguration(lobConfiguration);
//                invalidActivityCodeNotification.setLOBConfigurationEntry();
                invalidActivityCodeNotification.setTimecardEntry(timecardEntry);
                invalidActivityCodeNotification.setIsRead(false);

//                if (isExistingNotif) {
//                    //Update notification
//                    syncAgentService.systemPutObject(invalidActivityCodeNotification, null, null, null, true);
//                } else {
//                  //Create notification
//                syncAgentService.systemCreateObject(invalidActivityCodeNotification, null);
//                }
            }
        }
    }

    private static void generateNonBillableActivityCodeNotification(TimecardEntry timecardEntry, Agent agent, TeamLeader teamLeader, List<String> nonBillableActivityCodeList,
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

//                boolean isExistingNotif = false;
                timecardEntry = syncAgentService.systemGetByObject(timecardEntry);

//                Logic to get timecardEntry based notifications and check the this type already exists. If exists --> update else create.
//                Collection<String> fieldsToWatch = new HashSet<String>();
//                accessManager.addWatcherField(BaseDataObject.toClassIdPair(timecardEntry), "notifications", fieldsToWatch);
//                Iterator<LOBConfigurationNotification> itrNotifications = timecardEntry.getNotifications().iterator();
//                while (itrNotifications.hasNext()) {
//                    LOBConfigurationNotification notification = syncAgentService.systemGetByObject(itrNotifications.next());
//                    if ("NonBillableActivityNotification".equals(notification.getType())) {
//                        nonBillableActivityNotification = (NonBillableActivityNotification) notification;
////                        nonBillableActivityNotification = new NonBillableActivityNotification();
////                        nonBillableActivityNotification.setID(notification.getID());
////                        nonBillableActivityNotification.setAgent(notification.getAgent()); //xxxx
////                        nonBillableActivityNotification.setTeamLeader(notification.getTeamLeader());
//                        isExistingNotif = true;
//                    }
//                }


                if (nonBillableActivityNotification == null) {
                    nonBillableActivityNotification = new NonBillableActivityNotification();
                    nonBillableActivityNotification.setID(UUID.randomUUID().toString());
                    nonBillableActivityNotification.setAgent(agent);
                    nonBillableActivityNotification.setTeamLeader(teamLeader);
                }


//                nonBillableActivityNotification.setCreatedOn(new Date());

                nonBillableActivityNotification.setCreatedOn(timecardEntry.getSourceFromTime());
                nonBillableActivityNotification.setName("Non-Billable Activity Notification" + " - " + timecardActivity.getCode());
                nonBillableActivityNotification.setType("NonBillableActivityNotification");
                nonBillableActivityNotification.setTimecardActivity(timecardEntry.getTimecardActivity());

                nonBillableActivityNotification.setMessage(MessageFormat.format(NONBILLABLE_ACTIVITY_CODE_NOTIIFCATION_MESSAGE, agent.getFullName(),
                        timecardActivity.getCode(), formatDate(timecardEntry.getSourceFromTime(), DATE_TIME_FORMAT_12_HR), formatDate(timecardEntry.getSourceToTime(), DATE_TIME_FORMAT_12_HR)));
                nonBillableActivityNotification.setLOBConfiguration(lobConfiguration);
//                nonBillableActivityNotification.setLOBConfigurationEntry();
                nonBillableActivityNotification.setTimecardEntry(timecardEntry);
                nonBillableActivityNotification.setIsRead(false);

//                if (isExistingNotif) {
//                   //update notification
//                    syncAgentService.systemPutObject(nonBillableActivityNotification, null, null, null, true);
//                } else {
//                  //create notification
//                syncAgentService.systemCreateObject(nonBillableActivityNotification, null);
//                }
            }
        }
    }

    private static void generateOccurrenceToleranceNotification(TimecardEntry timecardEntry, Agent agent, TeamLeader teamLeader,
                                                                LOBConfiguration lobConfiguration, LOBConfigurationEntry lobConfigurationEntry,
                                                                int activityCodeOccurrenceCount) throws Exception {


        int OCCURRENCE_MAX = lobConfigurationEntry.getOccurrence() == null ? 0 : Integer.parseInt(lobConfigurationEntry.getOccurrence());

        if (lobConfigurationEntry.getOccurrence() != null && activityCodeOccurrenceCount > OCCURRENCE_MAX) {


            if (agent == null) {
                agent = syncAgentService.systemGetByObject(timecardEntry.getAgent());
            }
            if (agent != null && teamLeader == null) {
                teamLeader = agent.getTeamLeader();
            }

            if (agent != null && teamLeader != null) {
                OccurrenceToleranceNotification occurrenceToleranceNotification = null;


//                boolean isExistingNotif = false;
                timecardEntry = syncAgentService.systemGetByObject(timecardEntry);

//                Logic to get timecardEntry based notifications and check the this type already exists. If exists --> update else create.
//                Collection<String> fieldsToWatch = new HashSet<String>();
//                accessManager.addWatcherField(BaseDataObject.toClassIdPair(timecardEntry), "notifications", fieldsToWatch);
//                Iterator<LOBConfigurationNotification> itrNotifications = timecardEntry.getNotifications().iterator();
//
//                while (itrNotifications.hasNext()) {
//                    LOBConfigurationNotification notification = syncAgentService.systemGetByObject(itrNotifications.next());
//                    if ("OccurrenceToleranceNotification".equals(notification.getType())) {
//                        occurrenceToleranceNotification = (OccurrenceToleranceNotification) notification;
////                        occurrenceToleranceNotification = new OccurrenceToleranceNotification();
////                        occurrenceToleranceNotification.setID(notification.getID());
////                        occurrenceToleranceNotification.setAgent(notification.getAgent()); //xxxx
////                        occurrenceToleranceNotification.setTeamLeader(notification.getTeamLeader());
//                        isExistingNotif = true;
//                    }
//                }


                if (occurrenceToleranceNotification == null) {
                    occurrenceToleranceNotification = new OccurrenceToleranceNotification();
                    occurrenceToleranceNotification.setID(UUID.randomUUID().toString());
                    occurrenceToleranceNotification.setAgent(agent);
                    occurrenceToleranceNotification.setTeamLeader(teamLeader);
                }

                TimecardActivity timecardActivity = syncAgentService.systemGetByObject(timecardEntry.getTimecardActivity());
//                occurrenceToleranceNotification.setCreatedOn(new Date());

                occurrenceToleranceNotification.setCreatedOn(timecardEntry.getSourceFromTime());
                occurrenceToleranceNotification.setName("Occurrence Tolerance Notification" + " - " + timecardActivity.getCode() + " - " + activityCodeOccurrenceCount);
                occurrenceToleranceNotification.setType("OccurrenceToleranceNotification");

                occurrenceToleranceNotification.setMessage(MessageFormat.format(OCCURRENCE_TOLERANCE_NOTIIFCATION_MESSAGE, agent.getFullName(),
                        timecardActivity.getCode(), formatDate(timecardEntry.getSourceFromTime(), DATE_TIME_FORMAT_12_HR), formatDate(timecardEntry.getSourceToTime(), DATE_TIME_FORMAT_12_HR), OCCURRENCE_MAX));
                occurrenceToleranceNotification.setLOBConfiguration(lobConfiguration);
                occurrenceToleranceNotification.setLOBConfigurationEntry(lobConfigurationEntry);
                occurrenceToleranceNotification.setTimecardEntry(timecardEntry);
                occurrenceToleranceNotification.setIsRead(false);
//                if (isExistingNotif) {
//                    Notification already exists hence call update
//                    syncAgentService.systemPutObject(occurrenceToleranceNotification, null, null, null, true);
//                } else {
//                      Create notification
//                syncAgentService.systemCreateObject(occurrenceToleranceNotification, null);
//                }
            }
        }
    }

    private static void generateDurationToleranceNotification(TimecardEntry timecardEntry, Agent agent, TeamLeader teamLeader,
                                                              LOBConfiguration lobConfiguration, LOBConfigurationEntry lobConfigurationEntry,
                                                              Double totalDuration, List<TimecardEntry> consecutiveActivityList) throws Exception {

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

//                boolean isExistingNotif = false;

                timecardEntry = syncAgentService.systemGetByObject(timecardEntry);

//                Logic to get timecardEntry based notifications and check the this type already exists. If exists --> update else create.
//                Collection<String> fieldsToWatch = new HashSet<String>();
//                accessManager.addWatcherField(BaseDataObject.toClassIdPair(timecardEntry), "notifications", fieldsToWatch);
//
//                Iterator<LOBConfigurationNotification> itrNotifications = timecardEntry.getNotifications().iterator();
//                while (itrNotifications.hasNext()) {
//                    LOBConfigurationNotification notification = syncAgentService.systemGetByObject(itrNotifications.next());
//                    if ("DurationToleranceNotification".equals(notification.getType())) {
//                        durationToleranceNotification = (DurationToleranceNotification) notification;
////                        durationToleranceNotification = new DurationToleranceNotification();
////                        durationToleranceNotification.setID(notification.getID());
////                        durationToleranceNotification.setAgent(notification.getAgent()); //xxxx
////                        durationToleranceNotification.setTeamLeader(notification.getTeamLeader());
//                        isExistingNotif = true;
//                    }
//                }


                if (durationToleranceNotification == null) {
                    durationToleranceNotification = new DurationToleranceNotification();
                    durationToleranceNotification.setID(UUID.randomUUID().toString());
                    durationToleranceNotification.setAgent(agent);
                    durationToleranceNotification.setTeamLeader(teamLeader);
                }

//                Date startTimeOfActivity = timecardEntry.getSourceFromTime();
//                Date endTimeOfActivity = timecardEntry.getSourceToTime();
//
//                if (consecutiveActivityList.size() > 0 ) {
                //Since the list is in the reverse order with respect to time
                Date startTimeOfActivity = consecutiveActivityList.get(consecutiveActivityList.size() - 1).getSourceFromTime();
                Date endTimeOfActivity = consecutiveActivityList.get(0).getSourceToTime();
//                }

                TimecardActivity timecardActivity = syncAgentService.systemGetByObject(timecardEntry.getTimecardActivity());
//                durationToleranceNotification.setCreatedOn(new Date());
                durationToleranceNotification.setCreatedOn(timecardEntry.getSourceFromTime());
                durationToleranceNotification.setName("Duration Tolerance Notification" + " - " + timecardActivity.getCode() + " - " + totalDuration);
                durationToleranceNotification.setType("DurationToleranceNotification");

//                durationToleranceNotification.setMessage(MessageFormat.format(DURATION_TOLERANCE_NOTIIFCATION_MESSAGE, agent.getFullName(),
//                        timecardActivity.getCode(), formatDate(timecardEntry.getSourceFromTime(), DATE_TIME_FORMAT_12_HR), formatDate(timecardEntry.getSourceToTime(), DATE_TIME_FORMAT_12_HR), totalDuration));
                durationToleranceNotification.setMessage(MessageFormat.format(DURATION_TOLERANCE_NOTIIFCATION_MESSAGE, agent.getFullName(),
                        timecardActivity.getCode(), formatDate(startTimeOfActivity, DATE_TIME_FORMAT_12_HR), formatDate(endTimeOfActivity, DATE_TIME_FORMAT_12_HR), totalDuration, DURATION_MAX));
                durationToleranceNotification.setTimecardEntry(timecardEntry);
                durationToleranceNotification.setLOBConfiguration(lobConfiguration);
                durationToleranceNotification.setLOBConfigurationEntry(lobConfigurationEntry);
                durationToleranceNotification.setIsRead(false);
//                if (isExistingNotif) {
//                 // update notification
//                    syncAgentService.systemPutObject(durationToleranceNotification, null, null, null, true);
//                } else {
//                 // create notification
//                syncAgentService.systemCreateObject(durationToleranceNotification, null);
//                }
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

    private static Double getConsecutiveActivityCodeDetailFromTimecard(Agent agent, List<TimecardEntry> sortedTimecardEntries, TimecardEntry watchedTimecardEntry,
                                                                       String activityCode, List<TimecardEntry> timecardEntryListOfActivityCode) {

//        Integer consecutiveAcitivityCount = 0;
        boolean ignoreThisRecord = false;
        Double activityTimeSpan = 0.0;

        Timecard timecard = syncAgentService.systemGetByObject(watchedTimecardEntry.getTimecard());

//        List<TimecardEntry> timecardEntryList = timecard.getTimecardEntries();

        int indexOfWatchedEntry = 0;

        for (int cnt = 0; cnt < sortedTimecardEntries.size(); cnt++) {
            if (sortedTimecardEntries.get(cnt).getID().equals(watchedTimecardEntry.getID())) {
                indexOfWatchedEntry = cnt;
            }
        }

        //This is a special condition added to avoid unnecessary notifications for consecutive group of activities having same activiyt code.
        //This condition will avoide creation of notification for it self if its successor available.
        if (sortedTimecardEntries.size() - 1 > indexOfWatchedEntry){ //If this condition fails means this is the last watched entry is the last record.
            //Get the next entry
            TimecardEntry timecardEntry = syncAgentService.systemGetByObject(sortedTimecardEntries.get(indexOfWatchedEntry+1));
            //Get the activity code
            TimecardActivity timecardActivity = syncAgentService.systemGetByObject(timecardEntry.getTimecardActivity());
            //Check the similarity
            if (timecardActivity != null && activityCode != null && timecardActivity.getCode() != null && timecardActivity.getCode().equals(activityCode)) {
                ignoreThisRecord = true;
            }
        }

        //Assmuption is that it is the single entry having activity code at the position
//        TimecardEntry endTimecardActivity = watchedTimecardEntry;
//        TimecardEntry startTimecardActivity = watchedTimecardEntry;

        boolean processData = true;

        if (!ignoreThisRecord) {
            //Here the assumption is the TimecardEntres are sorted based on the time. If not this logic may not work/
            //Infact this logic is provided by CVG and they have assumption on this front
//        for (int cnt = timecardEntryList.size() ; cnt >= 0 && processData; cnt--) {
            for (int cnt = indexOfWatchedEntry; cnt >= 0 && processData; cnt--) {
                TimecardEntry timecardEntry = syncAgentService.systemGetByObject(sortedTimecardEntries.get(cnt));

                if (timecardEntry != null) {

                    TimecardActivity timecardActivity = syncAgentService.systemGetByObject(timecardEntry.getTimecardActivity());

                    //If code does not have consecutiveness then brk the loop
                    if (timecardActivity != null && activityCode != null && timecardActivity.getCode() != null && timecardActivity.getCode().equals(activityCode)) {

//                    activityTimeSpan += timecardEntry.getDuration();
                        timecardEntryListOfActivityCode.add(timecardEntry);
                    } else {
                        processData = false;
                    }
                }
            }

            if (timecardEntryListOfActivityCode.size() > 0) {
                //Entries are in reverse order due to last loop
                TimecardEntry endTimecardActivity = timecardEntryListOfActivityCode.get(0);
                TimecardEntry startTimecardActivity = timecardEntryListOfActivityCode.get(timecardEntryListOfActivityCode.size() - 1);

                activityTimeSpan = (double) calLapsMin(startTimecardActivity.getSourceFromTime(), endTimecardActivity.getSourceToTime());

                //Incase if there laps time in nagative this will cover it up
                if (activityTimeSpan < 0) {
                    activityTimeSpan *= -1;
                }
            }
        }
        return activityTimeSpan;
    }

    private static int getOccurrenceOfActivityCode(Agent agent, List<TimecardEntry> sortedTimecardEntries, TimecardEntry watchedTimecardEntry,
                                                   String activityCode) {


        boolean ignoreThisRecord = false;

        int activityCodeOccurrenceCount = 0;

        Timecard timecard = syncAgentService.systemGetByObject(watchedTimecardEntry.getTimecard());

        int indexOfWatchedEntry = 0;

        for (int cnt = 0; cnt < sortedTimecardEntries.size(); cnt++) {
            if (sortedTimecardEntries.get(cnt).getID().equals(watchedTimecardEntry.getID())) {
                indexOfWatchedEntry = cnt;
            }
        }

        //This is a special condition added to avoid unnecessary notifications for consecutive group of activities having same activiyt code.
        //This condition will avoide creation of notification for it self if its successor available.
        if (sortedTimecardEntries.size() - 1 > indexOfWatchedEntry){ //If this condition fails means this is the last watched entry is the last record.
            //Get the next entry
            TimecardEntry timecardEntry = syncAgentService.systemGetByObject(sortedTimecardEntries.get(indexOfWatchedEntry+1));
            //Get the activity code
            TimecardActivity timecardActivity = syncAgentService.systemGetByObject(timecardEntry.getTimecardActivity());
            //Check the similarity
            if (timecardActivity != null && activityCode != null && timecardActivity.getCode() != null && timecardActivity.getCode().equals(activityCode)) {
                ignoreThisRecord = true;
            }
        }

        if (!ignoreThisRecord) {
            //Here the assumption is the TimecardEntres are sorted based on the time. If not this logic may not work/
            //Infact this logic is provided by CVG and they have assumption on this front
//        for (int cnt = timecardEntryList.size() ; cnt >= 0 && processData; cnt--) {
            String previousActivityCode = "";
            for (int cnt = indexOfWatchedEntry; cnt >= 0; cnt--) {
                TimecardEntry timecardEntry = syncAgentService.systemGetByObject(sortedTimecardEntries.get(cnt));

                if (timecardEntry != null) {

                    TimecardActivity timecardActivity = syncAgentService.systemGetByObject(timecardEntry.getTimecardActivity());

                    //If code does not have consecutiveness then brk the loop
                    if (timecardActivity != null && activityCode != null && timecardActivity.getCode() != null
                            && timecardActivity.getCode().equals(activityCode)
                            && !previousActivityCode.equals(timecardActivity.getCode())) {
                        activityCodeOccurrenceCount++;
                    }

                    previousActivityCode = timecardActivity.getCode();
                }
            }
        }

        return activityCodeOccurrenceCount;
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


    private static void deleteOrphanedNotifications(LOBConfigurationNotification searchLOBNotification) throws Exception {
        //Get list of LOBConfigurationNotification based on deleted CMSEntry ID
        //TODO:Clean this logs if not required. This is frequent operation and may consume resouces unnecessarily
        log.warn("********************************** Orphaned Notification Clean Process [Starts] **********************************:");
        log.warn(searchLOBNotification.getCMSEntry());
        log.warn(searchLOBNotification.getTimecardEntry());

        List<IPerceroObject> listOfOrphanedNotifications = syncAgentService.systemFindByExample(searchLOBNotification, null);

        Iterator<IPerceroObject> itrNotifications = listOfOrphanedNotifications.iterator();

        if (listOfOrphanedNotifications.size() <= 0 && searchLOBNotification.getTimecardEntry() != null){
            log.warn("No Notifications Found for TimecardEntry ID :  [ " + searchLOBNotification.getTimecardEntry().getID() + " ]");
        }

        while (itrNotifications.hasNext()) {
            IPerceroObject iPerceroObject = itrNotifications.next();
//            ClassIDPair classIdPairLobNotif = BaseDataObject.toClassIdPair(iPerceroObject);

            //Do not retrive object since the relationship might be broken due to removal of TimecardEntry and Timecard
//            Notification notification = (Notification) syncAgentService.systemGetById(classIdPairLobNotif);
            log.warn("Notification ID:  [ " + iPerceroObject.getID() + "]");

            if (iPerceroObject != null) {
                boolean deleteStatus = syncAgentService.systemDeleteObject(iPerceroObject, null, true);
                log.warn("XXXXXXXXX Notification ID:  [ " + iPerceroObject.getID() + "] DELETED [ " + deleteStatus + " ] XXXXXXXXX");
            } else {
                log.warn("No Notification found for ID: " + iPerceroObject.getID());
            }
        }
        log.warn("********************************** Orphaned Notification Clean Process [Ends] **********************************:");
    }

    private static void deleteTimecardEntryOrphanedNotifications(LOBConfigurationNotification lOBNotification) throws Exception {
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

    private static void generatePhoneTimeVarianceNotification(TimecardEntry timecardEntry, Agent agent, TeamLeader teamLeader,
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

//                boolean isExistingNotif = false;

                timecardEntry = syncAgentService.systemGetByObject(timecardEntry);

//                Logic to get timecardEntry based notifications and check the this type already exists. If exists --> update else create.
//                Collection<String> fieldsToWatch = new HashSet<String>();
//                accessManager.addWatcherField(BaseDataObject.toClassIdPair(timecardEntry), "notifications", fieldsToWatch);
//                Iterator<LOBConfigurationNotification> itrNotifications = timecardEntry.getNotifications().iterator();
//
//                while (itrNotifications.hasNext()) {
//                    LOBConfigurationNotification notification = syncAgentService.systemGetByObject(itrNotifications.next());
//                    if ("DurationMismatchNotification".equals(notification.getType())) {
//                        durationMismatchNotification = (DurationMismatchNotification) notification;
////                        durationMismatchNotification = new DurationMismatchNotification();
////                        durationMismatchNotification.setID(notification.getID());
////                        durationMismatchNotification.setAgent(notification.getAgent()); //xxxx
////                        durationMismatchNotification.setTeamLeader(notification.getTeamLeader());
//                        isExistingNotif = true;
//                    }
//                }


                if (durationMismatchNotification == null) {
                    durationMismatchNotification = new DurationMismatchNotification();
                    durationMismatchNotification.setID(UUID.randomUUID().toString());
                    durationMismatchNotification.setAgent(agent);
                    durationMismatchNotification.setTeamLeader(teamLeader);
                }
                TimecardActivity timecardActivity = syncAgentService.systemGetByObject(timecardEntry.getTimecardActivity());

//                durationMismatchNotification.setCreatedOn(new Date());
                durationMismatchNotification.setCreatedOn(timecardEntry.getSourceFromTime());
                durationMismatchNotification.setName("Duration Mismatch Notification" + " - " + timecardActivity.getCode() + " - "  + duration);
                durationMismatchNotification.setType("DurationMismatchNotification");

                durationMismatchNotification.setMessage(MessageFormat.format(DURATION_MISMATCH_NOTIFICATION_MESSAGE, agent.getFullName(),
                        timecardActivity.getCode(), formatDate(timecardEntry.getSourceFromTime(), DATE_TIME_FORMAT_12_HR), formatDate(timecardEntry.getSourceToTime(), DATE_TIME_FORMAT_12_HR)));
                durationMismatchNotification.setLOBConfiguration(lobConfiguration);
//                durationMismatchNotification.setLOBConfigurationEntry(lobConfigurationEntry);
                durationMismatchNotification.setTimecardEntry(timecardEntry);
                durationMismatchNotification.setIsRead(false);
//                if (isExistingNotif) {
//                    //Update Notification
//                    syncAgentService.systemPutObject(durationMismatchNotification, null, null, null, true);
//                } else {
//                   //Create Notification
//                syncAgentService.systemCreateObject(durationMismatchNotification, null);
//                }
            }
        }
    }


    private static Double getDurationOfAccociatedCMSEntries(TimecardEntry timecardEntry, Agent agent, TeamLeader teamLeader,
                                                     LOBConfiguration lobConfiguration, LOBConfigurationEntry lobConfigurationEntry, List<TimecardEntry> consecutiveActivityList) throws Exception {

        Double duration = 0.0;

        if (consecutiveActivityList.size() <= 0) {
            return duration;
        }

        List<CMSEntry> associatedCMSEntries = new ArrayList<CMSEntry>();

        //The consecutiveActivityList gets list of TimecardEntries in reverse order so first is last entry and last is first entry.
        Date timecardEntryStartTime = consecutiveActivityList.get(consecutiveActivityList.size() - 1).getToTime();
        Date timecardEntryEndTime = consecutiveActivityList.get(0).getFromTime();


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


    private static long getTimeDiff(Date date1, Date date2) {
        if (date1.getTime() > date1.getTime()) {
            return date1.getTime() - date2.getTime();
        } else {
            return date2.getTime() - date1.getTime();
        }

    }

    private static String formatDate(Date date, String dateFormat) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        return simpleDateFormat.format(date);
    }

    private static Date stringToDate(String strDate, String dateFormat) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        Date date = null;

        try {
            date = simpleDateFormat.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }

    private static int calLapsMin(Date oriFromDate, Date oriToDate) {
        String strFromDate = formatDate(oriFromDate, DATE_TIME_FORMAT_WITHOUT_SECONDS);
        String strToDate = formatDate(oriToDate, DATE_TIME_FORMAT_WITHOUT_SECONDS);

        oriFromDate = stringToDate(strFromDate, DATE_TIME_FORMAT_WITHOUT_SECONDS);
        oriToDate = stringToDate(strToDate, DATE_TIME_FORMAT_WITHOUT_SECONDS);

        return (int) (oriToDate.getTime() / MS_IN_MIN - oriFromDate.getTime() / MS_IN_MIN);
    }

    static class CMSEntryDateComparator implements Comparator<CMSEntry> {

        @Override
        public int compare(CMSEntry entry1, CMSEntry entry2) {
            return entry2.getFromTime().compareTo(entry1.getFromTime());
        }
    }

    static class TimecardEntryDateComparator implements Comparator<TimecardEntry> {

        @Override
        public int compare(TimecardEntry entry1, TimecardEntry entry2) {
            return entry1.getSourceFromTime().compareTo(entry2.getSourceFromTime());
        }
    }

    private static List<CMSEntry> getSortedCMSEntries(List<CMSEntry> cmsEntries) {
        List<CMSEntry> sortedList = new ArrayList<CMSEntry>();

        for (int index = 0; index < cmsEntries.size(); index++) {

            CMSEntry cmsEntry = syncAgentService.systemGetByObject(cmsEntries.get(index));
            sortedList.add(cmsEntry);
        }

        Collections.sort(sortedList, new CMSEntryDateComparator());

        return sortedList;
    }

    private static List<TimecardEntry> getSortedTimecardEntries(List<TimecardEntry> entryList) {
        List<TimecardEntry> sortedList = new ArrayList<TimecardEntry>();
        Collection<String> fieldsToWatch = new HashSet<String>();
        for (TimecardEntry timecardEntry : entryList) {
            timecardEntry = syncAgentService.systemGetByObject(timecardEntry);
            //watch derived fields
//            accessManager.addWatcherField(BaseDataObject.toClassIdPair(timecardEntry), "sourceFromTime", fieldsToWatch);
//            accessManager.addWatcherField(BaseDataObject.toClassIdPair(timecardEntry), "sourceToTime", fieldsToWatch);
            sortedList.add(timecardEntry);
        }

        Collections.sort(sortedList, new TimecardEntryDateComparator());

        return sortedList;

    }

    private static void handleTimecardUpdate(String category, String subCategory, String fieldName, String[] params, IPerceroObject oldValue) throws Exception {
        // This is where the logic would go to create a Notification based on when the data requested above changes.
        //
        try {

            if (params != null && params.length >= 2) {
                String className = params[0];
                String classId = params[1];

                ClassIDPair classIdPair = new ClassIDPair(classId, className);
                IPerceroObject updatedObject = syncAgentService.systemGetById(classIdPair);


                if (updatedObject != null && updatedObject instanceof Timecard && oldValue != null) {

                    Timecard newTimecard = (Timecard) updatedObject;

                    for (TimecardEntry timecardEntry: newTimecard.getTimecardEntries()){
                        log.warn("Updated Timecard ID : [ " + updatedObject.getID() + " ] - TimecardEntry ID: [ " + timecardEntry.getID() + " ]");
                    }

                    Timecard oldTimecard = (Timecard) oldValue;

                    boolean ignoreTheUpdate = false;

                    //Check that first TimecardEntry of old and new Timecard should not be same
                    if (newTimecard.getTimecardEntries().size() > 0 && oldTimecard.getTimecardEntries().size() > 0){
                        TimecardEntry newTimecardEntry = newTimecard.getTimecardEntries().get(0);
                        TimecardEntry oldTimecardEntry = oldTimecard.getTimecardEntries().get(0);

                        if (newTimecardEntry.getID().equalsIgnoreCase(oldTimecardEntry.getID())){
                            //Do not process futher
                            ignoreTheUpdate = true;
                        }
                    }


                    //Print list of timecard entries of Old Timecard
//                    getAndPrintTimecardEntries(updatedObject.getID());

//                    oldTimecard = (Timecard) syncAgentService.systemGetById(BaseDataObject.toClassIdPair(oldValue));

//                    if (oldTimecard != null) {
                    if (!ignoreTheUpdate) {

                        //TODO: Check to see if old timecard entry ids are still on on new timecard value. If they are do not process

                        for (TimecardEntry timecardEntry: oldTimecard.getTimecardEntries()){
                            log.warn("Old Timecard ID : [ " + oldTimecard.getID() + " ] - TimecardEntry ID: [ " + timecardEntry.getID() + " ]");
                        }

                        Iterator<TimecardEntry> itrTimecardEntries = oldTimecard.getTimecardEntries().iterator();

                        while (itrTimecardEntries.hasNext()) {
                            TimecardEntry timecardEntry = itrTimecardEntries.next();

                            String timecardEntryId = timecardEntry.getID();

//                            timecardEntry = syncAgentService.systemGetByObject(timecardEntry);


                            if (timecardEntry != null) {
                                log.warn("Inside HandleTimecardUpdate Method Calling InsertRecToUpdateTable With Param TimecardEntries - " + timecardEntry.getID());

                                LOBConfigurationNotification findLOBConfigurationNotificaiton = new LOBConfigurationNotification();
                                findLOBConfigurationNotificaiton.setTimecardEntry(timecardEntry);

                                deleteOrphanedNotifications(findLOBConfigurationNotificaiton);
//
//                                for (LOBConfigurationNotification lobConfigurationNotification : timecardEntry.getNotifications()) {
//
//                                    log.warn(" inside handleTimecardUpdate method calling scanning LOB Notification ID : " + lobConfigurationNotification.getID());
//
//                                    LOBConfigurationNotification notificationToDelete = syncAgentService.systemGetByObject(lobConfigurationNotification);
//
//                                    if (notificationToDelete != null) {
//                                        log.warn(" inside handleTimecardUpdate method calling systemDeleteObject with param - " + lobConfigurationNotification.getID());
//                                        syncAgentService.systemDeleteObject(notificationToDelete, null, true);
//                                    }
//                                    else{
//                                        log.warn("inside handleTimecardUpdate method OOPS : notificationToDelete (ID : "+lobConfigurationNotification.getID() + "  ) Cound not retrieve");
//                                    }
//
//                                }
                            } else {

                                log.warn("inside handleTimecardUpdate method OOPS : TimecardEntry ( ID : " + timecardEntryId + " ) : Cound not retrieve");

                            }

                            insertRecToUpdateTable(timecardEntryId);

//                            TimecardEntry timecardEntry = syncAgentService.systemGetByObject(itrTimecardEntries.next());
//                            if (timecardEntry != null && deleteTimecardEntry(timecardEntry)) {
//
//                                Iterator<LOBConfigurationNotification> itrLobConfigurationNotif = timecardEntry.getNotifications().iterator();
//                                while (itrLobConfigurationNotif.hasNext()) {
//
//                                    deleteTimecardEntryOrphanedNotifications(itrLobConfigurationNotif.next());
//                                }
////                                LOBConfigurationNotification searchAndDeleteLOBNotification = new LOBConfigurationNotification();
////                                searchAndDeleteLOBNotification.setTimecardEntry(timecardEntry);
////
////                                deleteOrphanedNotifications(searchAndDeleteLOBNotification);
//                            }
                        }


                    }
                    else{
                        log.warn("handleTimecardUpdate Ignored : Timecard ID : [  " + newTimecard.getID() + " ] : Old Timecard ID : [ "  + oldTimecard.getID() + " ] ");
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
            return syncAgentService.systemDeleteObject(timecardEntry, null, true);
            //return systemDeleteObject(timecardEntry, null, true);
        } catch (Exception e) {
            log.error("Error while deleting Timecard Entry ID : " + timecardEntry.getID(), e);
            return false;
        }
    }

    private void getAndPrintTimecardEntries(String timecardId){

        log.warn("Invoked getAndPrintTimecardEntries for Timecard ID : [ " + timecardId + " ] ");

        final String selectSql = "SELECT ID, WORKED_ID FROM AGENT_TIME_ENTRY_VW WHERE ID = ?";

        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            IConnectionFactory connectionFactory = getConnectionRegistry().getConnectionFactory(CONNECTION_FACTORY_NAME);
            conn = connectionFactory.getConnection();

            pstmt = conn.prepareStatement(selectSql);
            pstmt.setQueryTimeout(QUERY_TIMEOUT);
            pstmt.setString(1, timecardId);
            ResultSet rs = pstmt.executeQuery();

            if (rs!=null){

                String tcId = null;
                String tceId = null;

                while(rs.next()){

                    tcId = rs.getString("ID");
                    tceId = rs.getString("WORKED_ID");

                    log.warn("Database state of Timecard ID [ " + tcId + " ] - TimecardEntry ID [ " + tceId + " ]");

                }

            }
            else{
                log.error("OOPS Resultset is NULL Timecard ID : " + timecardId );
            }

        } catch (Exception e) {
            log.error("Unable to retrieveObjects\n" + selectSql, e);

        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                log.error("Error closing database statement/connection", e);
            }
        }
    }
    private static void insertRecToUpdateTable(String timecardEntryId) {
//        String selectQueryString = "SELECT MAX(ID) AS ID FROM UPDATE_TABLE";

        String insertQueryString = "INSERT INTO UPDATE_TABLE (TABLENAME, ROW_ID, TYPE, TIMESTAMP) VALUES (?, ?, ?, sysdate)";

        int updateTableId = 1; // default value

        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            IConnectionFactory connectionFactory = getConnectionRegistry().getConnectionFactory(CONNECTION_FACTORY_NAME);
            conn = connectionFactory.getConnection();


            //Insert record
            pstmt = conn.prepareStatement(insertQueryString);
            pstmt.setQueryTimeout(QUERY_TIMEOUT);
            pstmt.setString(1, "AGENT_TIME_ENTRY_VW");
            pstmt.setString(2, timecardEntryId);
            pstmt.setString(3, "DELETE");
            // pstmt.setDate(4, (java.sql.Date) new Date());
//            pstmt.setInt(4, ++updateTableId);
            pstmt.execute();


        } catch (Exception e) {
            log.error("Unable to retrieveObjects\n" + insertQueryString, e);

        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                log.error("Error closing database statement/connection", e);
            }
        }
    }

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

    static PulseDataConnectionRegistry connectionRegistry;

    public static PulseDataConnectionRegistry getConnectionRegistry() {
        if (connectionRegistry == null) {
            connectionRegistry = PulseDataConnectionRegistry.getInstance();
        }
        return connectionRegistry;
    }

}