package com.pulse.amqp;

import java.text.MessageFormat;
import java.util.*;

import com.percero.framework.vo.IPerceroObject;
import com.pulse.mo.dao.LOBConfigurationDAO;
import com.sun.corba.se.impl.orbutil.concurrent.Sync;
import org.apache.log4j.Logger;
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
    private static Logger logger = Logger.getLogger(Main.class);

    private static final String WORK_MODE_DURATION_NOTIIFCATION_MESSAGE = "Duration Tolerance | {0} : System has detected a CMS aux code {1} starting at {2} and ending at {3} for the total duration of {4}  has exceeded the durration tolerance.";
    private static final String WORK_MODE_OCCURRENCE_NOTIIFCATION_MESSAGE = "Occurrence Tolerance | {0} : System has detected a CMS aux code {1} starting at {2} and ending at {3} has occurred more times than the tolerance of {4}.";


    //Timecard based Notifications Messages
    private static final String INVALID_ACTIVITY_CODE_NOTIIFCATION_MESSAGE = "Invalid Activity Code | {0} : System has detected an invalid activity code {1} starting at {2} and ending at {3}";
    private static final String NONBILLABLE_ACTIVITY_CODE_NOTIIFCATION_MESSAGE = "Non-billable Activity | {0} : System has detected a non-billable activity code {1} starting at {2} and ending at {3}";
    private static final String OCCURRENCE_TOLERANCE_NOTIIFCATION_MESSAGE = "Occurrence Tolerance | {0} : System has detected an eStart activity code {1} starting at {2} and ending at {3} has occurred more times than the tolerance of {4}.";
    private static final String DURATION_TOLERANCE_NOTIIFCATION_MESSAGE = "Duration Tolerance | {0} System has detected an eStart activity code {1} starting at {2} and ending at {3} for the total duration of {4}  has exceeded the durration tolerance.";


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

        logger.info("Using config: " + config);
        ApplicationContext context =
                new ClassPathXmlApplicationContext(new String[]{config, "spring/*.xml"});
        logger.debug(context.toString());

        logger.info("\n\n****************************************\nApplication Started\n****************************************\n\n");


//        unitTestOnMain(context);
    }

    private static void unitTestOnMain(ApplicationContext context) {
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


        ISyncAgentService syncAgentService = context.getBean(ISyncAgentService.class);
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
                Agent nextAgent = syncAgentService.systemGetByObject(itrAgents.next());

                Iterator<CMSEntry> itrCMSEntries = nextAgent.getCMSEntries().iterator();
                while (itrCMSEntries.hasNext()) {
                    CMSEntry cMSEntry = syncAgentService.systemGetByObject(itrCMSEntries.next());
//                    simulateCMSEntryDelete(syncAgentService, cMSEntry);
                    //9th dec entry process
                    //if (cMSEntry != null && cMSEntry.getFromTime().getDay() == 9 && cMSEntry.getFromTime().getMonth()==11){
                    processCMSEntry(syncAgentService, cMSEntry);
                    //}
                }

//                Iterator<Timecard> itrTimecard = nextAgent.getTimecards().iterator();
//                while(itrTimecard.hasNext()) {
//                    Timecard timecard = syncAgentService.systemGetByObject(itrTimecard.next());
//
//                    System.out.println("timecard start date : " + timecard.getStartDate());
//                    //9th dec entry process
//                    if (timecard != null){ //&& timecard.getStartDate().getDay() == 9 && timecard.getStartDate().getMonth()==11){
//
//                        Iterator<TimecardEntry> itrTimecardEntries = timecard.getTimecardEntries().iterator();
//                        while(itrTimecardEntries.hasNext()) {
//                            TimecardEntry timecardEntry = syncAgentService.systemGetByObject(itrTimecardEntries.next());
//                            if (timecardEntry != null){// && timecardEntry.getFromTime().getDay() == 9 && timecardEntry.getFromTime().getMonth()==11) {
//                                processTimecarEntry(syncAgentService, timecardEntry);
//                            }
//
//                        }
//                    }
//                }
            }
//
            System.out.println("done");
//            Iterator<Notification> notificationsItr = teamLeader.getNotifications().iterator();
//
//            while(notificationsItr.hasNext()){
//                Notification notification = syncAgentService.systemGetByObject(notificationsItr.next());
//
//                System.out.println(notification);
//            }


//            Iterator<Agent> itrAgents = teamLeader.getAgents().iterator();
//            while (itrAgents.hasNext()) {
//                Agent nextAgent = syncAgentService.systemGetByObject(itrAgents.next());
//                AgentLOB agentLOB = new AgentLOB();

//                if (nextAgent != null && nextAgent.getID().equals("100477867")) {//
//                    findAgentLOB.setAgent(nextAgent);

//                    List<IPerceroObject> exampleLobResults = syncAgentService.systemFindByExample(findAgentLOB, null);
//                    if (exampleLobResults != null && exampleLobResults.size() > 0) {
//                        findAgentLOB = (AgentLOB) exampleLobResults.get(0);
//                        nextAgent.getAgentLOBs().add(findAgentLOB);
//                    }


//                    System.out.println("Agent ID :" + nextAgent.getID());
//                    System.out.println("AgentLOB  :" + nextAgent.getAgentLOBs());
////					nextAgent.getAgentLOBs()
//                    if (nextAgent.getAgentLOBs() != null) {
//                        Iterator<AgentLOB> itrAgentLOB = nextAgent.getAgentLOBs().iterator();
//                        System.out.println("****************************************");
//                        System.out.println("AgentLOB Size :" + nextAgent.getAgentLOBs().size());
//                        System.out.println("****************************************");
//                        while (itrAgentLOB.hasNext()) {
//                            AgentLOB agentLOB = syncAgentService.systemGetByObject(itrAgentLOB.next());
//                            if (agentLOB != null && agentLOB.getLOB() != null) {
//                                System.out.println("****************************************");
//                                System.out.println("AgentLOB ID :" + agentLOB.getID());
//                                System.out.println("AgentLOB LOB :" + agentLOB.getLOB());
//                                System.out.println("****************************************");
//
//                                LOB lob = syncAgentService.systemGetByObject(agentLOB.getLOB());
//                                if (lob != null) {
//                                    System.out.println("****************************************");
//                                    System.out.println("AgentLOB LOB ID :" + agentLOB.getLOB().getID());
//                                    System.out.println("****************************************");
//                                    if (lob.getLOBConfigurations() != null) {
//                                        System.out.println("****************************************");
//                                        System.out.println("AgentLOB LOB.LOBCOnfiguration size :" + lob.getLOBConfigurations().size());
//                                        System.out.println("****************************************");
//                                        Iterator<LOBConfiguration> itrLobConfiguration = lob.getLOBConfigurations().iterator();
//
//                                        while (itrLobConfiguration.hasNext()) {
//                                            LOBConfiguration lobConfiguration = (LOBConfiguration) syncAgentService.systemGetByObject(itrLobConfiguration.next());
//
//                                            if (lobConfiguration != null) {
//                                                System.out.println("****************************************");
//                                                System.out.println("AgentLOB lobConfiguration :" + lobConfiguration.getID());
//                                                System.out.println("****************************************");
//                                                Iterator<LOBConfigurationEntry> itrLobConfigurationEntry = lobConfiguration.getLOBConfigurationEntries().iterator();
//                                                while (itrLobConfigurationEntry.hasNext()) {
//
//                                                    LOBConfigurationEntry lobConfigurationEntry = (LOBConfigurationEntry) syncAgentService.systemGetByObject(itrLobConfigurationEntry.next());
//                                                    if (lobConfigurationEntry != null) {
//                                                        System.out.println("****************************************");
//                                                        System.out.println("AgentLOB lobConfigurationentry_id :" + lobConfigurationEntry.getID());
//                                                        System.out.println("****************************************");
//                                                    }
//                                                }
//                                            }
//                                        }
//                                    }
//                                }
//                            }
//                        }
//
//                    }

//					Iterator<CMSEntry> itrCmsEntries = nextAgent.getCMSEntries().iterator();
//					while (itrCmsEntries.hasNext()) {
//						CMSEntry cmsEntry = syncAgentService.systemGetByObject(itrCmsEntries.next());
//						System.out.println(cmsEntry);
//						if (cmsEntry != null && cmsEntry.getCMSEntryLOBs() != null) {
//							Iterator<CMSEntryLOB> itrCmsEntryLobs = cmsEntry.getCMSEntryLOBs().iterator();
//							while (itrCmsEntryLobs.hasNext()) {
//								CMSEntryLOB cmsEntryLob = syncAgentService.systemGetByObject(itrCmsEntryLobs.next());
//								System.out.println(cmsEntryLob);
//							}
//						}
//
//					}
//
//					Iterator<Schedule> itrSchedules = nextAgent.getSchedules().iterator();
//					while (itrSchedules.hasNext()) {
//						Schedule schedule = syncAgentService.systemGetByObject(itrSchedules.next());
//						Iterator<ScheduleEntry> itrScheduleEntries = schedule.getScheduleEntries().iterator();
//						while (itrScheduleEntries.hasNext()) {
//							ScheduleEntry scheduleEntry = syncAgentService.systemGetByObject(itrScheduleEntries.next());
//							System.out.println(scheduleEntry);
//						}
//					}

//					Iterator<DevelopmentActivity> itrDevelopmentActivities = nextAgent.getDevelopmentActivities().iterator();
//					while (itrDevelopmentActivities.hasNext()) {
//						DevelopmentActivity nextDevelopmentActivity = syncAgentService.systemGetByObject(itrDevelopmentActivities.next());
//
//						if (nextDevelopmentActivity != null) {
//							DevelopmentActivity prevDevelopmentActivity = nextDevelopmentActivity.getPreviousDevelopmentActivity();
//							System.out.println(prevDevelopmentActivity);
//						}
//					}
//
//					List<Timecard> timecards = nextAgent.getTimecards();
//
//					Iterator<AgentScorecard> itrAgentScorecards = nextAgent.getAgentScorecards().iterator();
//					while (itrAgentScorecards.hasNext()) {
//						AgentScorecard agentScorecard = (AgentScorecard) syncAgentService.systemGetById(AgentScorecard.class.getCanonicalName(), itrAgentScorecards.next().getID());
//						System.out.println(agentScorecard);
//
//						if (agentScorecard != null) {
//							Iterator<CoachingSession> itrCoachingSessions = agentScorecard.getCoachingSessions().iterator();
//							while (itrCoachingSessions.hasNext()) {
//								CoachingSession nextCoachingSession = syncAgentService.systemGetByObject(itrCoachingSessions.next());
//
//								if (nextCoachingSession != null) {
//									Iterator<BehaviorResponse> itrBehaviorResponses = nextCoachingSession.getBehaviorResponses().iterator();
//
//									while (itrBehaviorResponses.hasNext()) {
//										BehaviorResponse nextBehaviorResponse = syncAgentService.systemGetByObject(itrBehaviorResponses.next());
//
//										if (nextBehaviorResponse != null) {
//											BehaviorResponse prevBehaviorResponse = nextBehaviorResponse.getPreviousBehaviorResponse();
//											System.out.println(prevBehaviorResponse);
//										}
//									}
//								}
//							}

//							Iterator<ScorecardWeeklyScore> itrScorecardWeeklyScores = agentScorecard.getScorecardWeeklyScores().iterator();
//							while (itrScorecardWeeklyScores.hasNext()) {
//								ScorecardWeeklyScore nextWeeklyScore = syncAgentService.systemGetByObject(itrScorecardWeeklyScores.next());
//								ScorecardMonthlyScore currentMonthlyScore = syncAgentService.systemGetByObject(nextWeeklyScore.getScorecardMonthlyScore());
////								ScorecardMonthlyScore currentMonthlyScore2 = nextWeeklyScore.getCurrentScorecardMonthlyScore();
//								System.out.println(currentMonthlyScore);
//								if (currentMonthlyScore != null) {
//									ScorecardMonthlyScore previousMonthlyScore = currentMonthlyScore.getPreviousScorecardMonthlyScore();
//									System.out.println(previousMonthlyScore);
//								}
//								ScorecardWeeklyScore previousWeeklyScore = nextWeeklyScore.getPreviousScorecardWeeklyScore();
//								System.out.println(previousWeeklyScore);
//							}

//							Iterator<ScorecardWeeklyResult> itrScorecardWeeklyResults = agentScorecard.getScorecardWeeklyResults().iterator();
//							while (itrScorecardWeeklyResults.hasNext()) {
//								ScorecardWeeklyResult nextWeeklyResult = itrScorecardWeeklyResults.next();
//								ScorecardMonthlyResult currentMonthlyResult = nextWeeklyResult.getScorecardMonthlyResult();
////								ScorecardMonthlyResult currentMonthlyResult2 = nextWeeklyResult.getCurrentScorecardMonthlyResult();
//								System.out.println(currentMonthlyResult);
//								nextWeeklyResult.getWeeklyDevelopmentPlans();
//								if (currentMonthlyResult != null) {
//									ScorecardMonthlyResult previousMonthlyResult = currentMonthlyResult.getPreviousScorecardMonthlyResult();
//									System.out.println(previousMonthlyResult);
//								}
//								ScorecardWeeklyResult previousWeeklyResult = nextWeeklyResult.getPreviousScorecardWeeklyResult();
//								System.out.println(previousWeeklyResult);
//							}
//
//							CoachingNotification coachingNotification = agentScorecard.getCoachingNotification();
//							if (coachingNotification != null) {
//								Integer stateCount = coachingNotification.getAcknowledgementStateCount();
//								System.out.println("AcknowledgedStateCount: " + stateCount);
//								stateCount = coachingNotification.getPendingCoachStateCount();
//								System.out.println("PendingCoachStateCount: " + stateCount);
//								stateCount = coachingNotification.getPendingEmployeeStateCount();
//								System.out.println("PendingEmployeedStateCount: " + stateCount);
//								Integer pendingStateCount = coachingNotification.getPendingStateCount();
//								System.out.println("PendingStateCount: " + pendingStateCount);
//								Integer submittedStateCount = coachingNotification.getSubmittedStateCount();
//								System.out.println("SubmittedStateCount: " + submittedStateCount);
//								Integer skippedStateCount = coachingNotification.getSkippedStateCount();
//								System.out.println("SkippedStateCount: " + skippedStateCount);
//							}
//
//							Scorecard scorecard = syncAgentService.systemGetByObject(agentScorecard.getScorecard());
//							System.out.println(scorecard);
//						}
//					}

//					Iterator<Timecard> itrTimecards = nextAgent.getTimecards().iterator();
//					while (itrTimecards.hasNext()) {
//						Timecard timecard = (Timecard) syncAgentService.systemGetById(Timecard.class.getCanonicalName(), itrTimecards.next().getID());
//						System.out.println(timecard);
//
//						if (timecard != null) {
//							Iterator<TimecardEntry> itrTimecardEntries = timecard.getTimecardEntries().iterator();
//							while (itrTimecardEntries.hasNext()) {
//								TimecardEntry timecardEntry = syncAgentService.systemGetByObject(itrTimecardEntries.next());
//								System.out.println(timecardEntry);
//							}
//						}
//					}

//                }
//            }
//			}
        } catch (Exception e) {
            e.printStackTrace();

        }
//		System.out.println("HERE");
//
//		Timecard timecard;
//		timecard.getTimecardEntries();

//		DevelopmentPlan developmentPlan = new DevelopmentPlan();
//		developmentPlan.setID("2");
//		
//		DevelopmentActivity developmentActivity = new DevelopmentActivity();
//		developmentActivity.setDevelopmentPlan(developmentPlan);
//		developmentActivity.setName("test task 123");
//		developmentActivity.setTeamLeader(teamLeader);
//		developmentActivity.setDueDate(new Date());
//		developmentActivity.setStatus("2");
//		developmentActivity.setAgent(agent);
//		developmentActivity.setCreatedOn(new Date());
//		developmentActivity.setType("DevelopmentActivity");
//		developmentActivity.setUpdatedBy(teamLeader.getID());
//		developmentActivity.setUpdatedOn(new Date());
//		try {
//			syncAgentService.systemCreateObject(developmentActivity, null);
//		} catch(Exception e) {
//			e.printStackTrace();
//		}

//		// 100521449
//		try {
//			ClassIDPair cip = new ClassIDPair("100521449", TeamLeader.class.getCanonicalName());
//			teamLeader = new TeamLeader();
//			teamLeader.setID("100521449");
//			
//			agent = new Agent();
//			agent.setID("100521449");
//			
//			AgentScorecard agentScorecard = new AgentScorecard();
//			Scorecard scorecard = new Scorecard();
//			scorecard.setID("123");
//			agentScorecard.setScorecard(scorecard);
//			agentScorecard.setAgent(agent);
//			agentScorecard.setGrade(0);
//			agentScorecard.setWeekDate(new Date());
//			syncAgentService.systemCreateObject(agentScorecard, null);
////			
////			LOBConfiguration lobConfiguration = new LOBConfiguration();
////			lobConfiguration.setID("ALE");
////			
////			ThresholdExceededNotification dtn = new ThresholdExceededNotification();
////			dtn.setAgent(agent);
////			dtn.setTeamLeader(teamLeader);
////			dtn.setDate(new Date());
////			dtn.setMessage("This only a test. Please ignore.");
////			dtn.setType("TEST");
////			dtn.setID(UUID.randomUUID().toString());
////			dtn.setName("TEST");
////			dtn.setLOBConfiguration(lobConfiguration);
////			try {
////				syncAgentService.systemCreateObject(dtn, null);
////			} catch(Exception e) {
////				e.printStackTrace();
////			}
////			
////			dtn.setName("My Other Name");
////			syncAgentService.systemPutObject(dtn, null, null, null, false);
//		} catch(Exception e1) {
//			e1.printStackTrace();
//		}

//		ISyncAgentService syncAgentService = context.getBean(ISyncAgentService.class);
//
//		Agent agent = new Agent();
//		agent.setID("100796870");
//
//		TeamLeader teamLeader = new TeamLeader();
//		teamLeader.setID("100147959");
//
//
//		AdhocTask adhocTask= new AdhocTask();
//		adhocTask.setTaskDetail("new adhock task 123567");
//		adhocTask.setTeamLeader(teamLeader);
//		adhocTask.setWeekDate(new Date());
//		adhocTask.setAgent(agent);
//		adhocTask.setDueDate(new Date());
//		adhocTask.setUpdatedBy(teamLeader.getID());
//		adhocTask.setCreatedBy(teamLeader.getID());
//		try {
//			System.out.println("==================================");
//			syncAgentService.systemCreateObject(adhocTask, null);
//
//		} catch(Exception e) {
//			e.printStackTrace();
//		}

//		Date jdkDate = new java.sql.Date();
//		System.out.println(jdkDate);

//		ISyncAgentService syncAgentService = context.getBean(ISyncAgentService.class);
//
//		Agent agent = new Agent();
//		agent.setID("RANDOM_ID");
//
//		TeamLeader teamLeader = new TeamLeader();
//		teamLeader.setID("100351667");
//
//		DevelopmentPlan developmentPlan = new DevelopmentPlan();
//		developmentPlan.setID("2");
//
//		DevelopmentActivity developmentActivity = new DevelopmentActivity();
//		developmentActivity.setDevelopmentPlan(developmentPlan);
//		developmentActivity.setName("test task 123");
//		developmentActivity.setTeamLeader(teamLeader);
//		developmentActivity.setDueDate(new Date());
//		developmentActivity.setStatus("2");
//		developmentActivity.setAgent(agent);
//		developmentActivity.setCreatedOn(new Date());
//		developmentActivity.setType("DevelopmentActivity");
//		developmentActivity.setUpdatedBy(teamLeader.getID());
//		developmentActivity.setUpdatedOn(new Date());
//		try {
//			syncAgentService.systemCreateObject(developmentActivity, null);
//		} catch(Exception e) {
//			e.printStackTrace();
//		}


    }

    public static void simulateCMSEntryDelete(ISyncAgentService syncAgentService, CMSEntry cmsEntry) throws Exception {

        //Entry DELETED and Watcher invoked by ActiveStack when UpdateTableProcessor processed it and updated Redis Cache
        //This is a special case where CMSEntry is deleted but watched by Watcher since there is change in the Entry/Object.
        //When try to rerieve using SyncEngine syncAgentService it returns NULL because the object is deleted.
        //This is a situation where we need to clean the orphaned notifications associated with deleted entry

        CMSEntry criteriaCMSEntry = new CMSEntry();
        criteriaCMSEntry.setID("31475638");

        LOBConfigurationNotification searchAndDeleteLOBNotification = new LOBConfigurationNotification();
        searchAndDeleteLOBNotification.setCMSEntry(criteriaCMSEntry);

        deleteOrphanedNotifications(syncAgentService, searchAndDeleteLOBNotification);


    }

    public static void processCMSEntry(ISyncAgentService syncAgentService, CMSEntry cmsEntry) throws Exception {
//        if (updatedObject instanceof CMSEntry) {
//            CMSEntry cmsEntry = (CMSEntry) updatedObject;
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
                                                generateWorkDurationNotification(syncAgentService, cmsEntry, agent, teamLeader, lobConfiguration, lobConfigurationEntry);
                                                generateWorkModeOccurrenceNotification(syncAgentService, cmsEntry, agent, teamLeader, lobConfiguration, lobConfigurationEntry);

                                            }

                                        }
                                    }

                                }
                            }
                        }
                    } else {
                        //Not a Valid scenario for notification
                        // Do not send notification
                        System.out.println("****** CMS Entry based notification is not generated due to following configuration ******");
                        System.out.println("Agent : " + agent.getID() + " : CMSEntry : " + cmsEntry.getID() + " having AgentLOB Count (" + agent.getAgentLOBs().size() + ") - But only ONE AgentLOB expected");
                    }
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
                criteriaCMSEntry.setID(cmsEntry.getID());

                LOBConfigurationNotification searchAndDeleteLOBNotification = new LOBConfigurationNotification();
                searchAndDeleteLOBNotification.setCMSEntry(criteriaCMSEntry);

                deleteOrphanedNotifications(syncAgentService, searchAndDeleteLOBNotification);


            }


//        }
    }


    private static void generateWorkDurationNotification(ISyncAgentService syncAgentService, CMSEntry cmsEntry, Agent agent, TeamLeader teamLeader, LOBConfiguration lobConfiguration,
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

    private static void generateWorkModeOccurrenceNotification(ISyncAgentService syncAgentService, CMSEntry cmsEntry, Agent agent, TeamLeader teamLeader, LOBConfiguration lobConfiguration,
                                                               LOBConfigurationEntry lobConfigurationEntry) throws Exception {

        Integer OCCURRENCE_MAX = lobConfigurationEntry.getOccurrence() == null ? 0 : Integer.parseInt(lobConfigurationEntry.getOccurrence());

        List<CMSEntry> cmsEntryList = getCurrentShiftCMSEntries(syncAgentService, agent, cmsEntry);

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

    private static List<CMSEntry> getCurrentShiftCMSEntries(ISyncAgentService syncAgentService, Agent agent, CMSEntry watchedCMSEntry) {

        List<CMSEntry> cmsEntriesOfTheShift = new ArrayList<CMSEntry>();

        Iterator<CMSEntry> itrCMSEntry = agent.getCMSEntries().iterator();
        Date shiftDate = new Date(watchedCMSEntry.getFromTime().getTime());

        while (itrCMSEntry.hasNext()) {
            CMSEntry cmsEntry = syncAgentService.systemGetByObject(itrCMSEntry.next());
            //Check the the entry bellongs to

            if (cmsEntry != null &&
                    compareDates(watchedCMSEntry.getFromTime(), cmsEntry.getFromTime()) &&
                    ((watchedCMSEntry.getCMSAuxMode() == null && cmsEntry.getCMSAuxMode() == null)
                            || (watchedCMSEntry.getCMSAuxMode() != null && cmsEntry.getCMSAuxMode() != null && watchedCMSEntry.getCMSAuxMode().equals(cmsEntry.getCMSAuxMode())))) {
                cmsEntriesOfTheShift.add(cmsEntry);
            }
        }

        return cmsEntriesOfTheShift;
    }

    private static boolean compareDates(Date sourceDate, Date targetDate) {

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

    private static void processTimecarEntry(ISyncAgentService syncAgentService, TimecardEntry timecardEntry) throws Exception {

        Agent agent = null;
        TeamLeader teamLeader = null;

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

                                Double consecutiveActivityDuration = getConsecutiveActivityCodeDetailFromTimecard(syncAgentService, agent, timecardEntry, timecarActivity.getCode(), consecutiveActivityList);

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

                                                generateOccurrenceToleranceNotification(syncAgentService, timecardEntry, agent, teamLeader,
                                                        lobConfiguration, lobConfigurationEntry, consecutiveActivityList);

                                                generateDurationToleranceNotification(syncAgentService, timecardEntry, agent, teamLeader,
                                                        lobConfiguration, lobConfigurationEntry, consecutiveActivityDuration);

                                            }
                                        } else if (lobConfigurationEntry.getType().equals("NONBILLABLE_ACTIVITY_CODE")) {

                                            nonBillableActivityCodeList.add(lobConfigurationEntry.getESTARTActivityCode());

                                        }
                                    }
                                }


                                //Generate Invalid Activity Code Notification if TimecardEntry Activity's activity code is not in the list of valid code
                                generateInvalidActivityCodeNotification(syncAgentService, timecardEntry, agent, teamLeader, validActivityCodeList, lobConfiguration);

                                //Generate NonBillable Activity Code Notification if TimecardEntry Activity's activity code is in the list of NonBillable code
                                generateNonBillableActivityCodeNotification(syncAgentService, timecardEntry, agent, teamLeader, nonBillableActivityCodeList, lobConfiguration);


                            }

                        }
                    }
                }
            } else {

                //Not a Valid scenario for notification
                // Do not send notification
                System.out.println("****** TimeCard Entry based notification is not generated due to following configuration ******");
                System.out.println("Agent : " + agent.getID() + " : TimecardEntry : " + timecardEntry.getID() + " having AgentLOB Count (" + agent.getAgentLOBs().size() + ") - But only ONE AgentLOB expected");
            }
        }

        // 3.


        // 4.

    }

    private static Double getConsecutiveActivityCodeDetailFromTimecard(ISyncAgentService syncAgentService, Agent agent, TimecardEntry watchedTimecardEntry, String activityCode, List<TimecardEntry> timecardEntryListOfActivityCode) {

//        Integer consecutiveAcitivityCount = 0;
        Double activityTimeSpan = 0.0;

        Timecard timecard = syncAgentService.systemGetByObject(watchedTimecardEntry.getTimecard());

        List<TimecardEntry> timecardEntryList = timecard.getTimecardEntries();

        boolean processData = true;

        for (int cnt = timecardEntryList.size() - 1; cnt >= 0 && processData; cnt--) {
            TimecardEntry timecardEntry = syncAgentService.systemGetByObject(timecardEntryList.get(cnt));

            TimecardActivity timecardActivity = syncAgentService.systemGetByObject(timecardEntry.getTimecardActivity());

            //If code does not have consecutiveness then brk the look
            if (timecardActivity.getCode().equals(activityCode)) {

                activityTimeSpan += timecardEntry.getDuration();
                timecardEntryListOfActivityCode.add(timecardEntry);
            } else {
                processData = false;
            }

        }

        return activityTimeSpan;
    }

    private static void generateOccurrenceToleranceNotification(ISyncAgentService syncAgentService, TimecardEntry timecardEntry, Agent agent, TeamLeader teamLeader,
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

    private static void generateDurationToleranceNotification(ISyncAgentService syncAgentService, TimecardEntry timecardEntry, Agent agent, TeamLeader teamLeader,
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

    private static void generateInvalidActivityCodeNotification(ISyncAgentService syncAgentService, TimecardEntry timecardEntry, Agent agent, TeamLeader teamLeader, List<String> validActivityCodeList,
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

    private static void generateNonBillableActivityCodeNotification(ISyncAgentService syncAgentService, TimecardEntry timecardEntry, Agent agent, TeamLeader teamLeader, List<String> nonBillableActivityCodeList,
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


    private static void deleteOrphanedNotifications(ISyncAgentService syncAgentService, LOBConfigurationNotification searchLOBNotification) throws Exception {
        //Get list of LOBConfigurationNotification based on deleted CMSEntry ID
        System.out.println("********************************** Orphaned Notification Clean Process [Starts] **********************************:");
        System.out.println(searchLOBNotification.getCMSEntry());
        System.out.println(searchLOBNotification.getTimecardEntry());

        List<IPerceroObject> listOfOrphanedNotifications = syncAgentService.systemFindByExample(searchLOBNotification, null);

        Iterator<IPerceroObject> itrNotifications = listOfOrphanedNotifications.iterator();

        while (itrNotifications.hasNext()) {
            IPerceroObject iPerceroObject = itrNotifications.next();
            ClassIDPair classIdPairLobNotif = BaseDataObject.toClassIdPair(iPerceroObject);

            Notification notification = (Notification) syncAgentService.systemGetById(classIdPairLobNotif);
            if (notification != null) {

                syncAgentService.systemDeleteObject(notification, null, true);
                System.out.println("XXXXXXXXX Notification ID:  [ " + notification.getID() + "] DELETED XXXXXXXXX");
            } else {
                System.out.println("No Notification found for ID: " + classIdPairLobNotif);
            }
        }
        System.out.println("********************************** Orphaned Notification Clean Process [Ends] **********************************:");


    }
}