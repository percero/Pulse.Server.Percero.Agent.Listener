package com.pulse.amqp;

import java.util.Date;
import java.util.Iterator;
import java.util.UUID;

import com.pulse.mo.dao.LOBConfigurationDAO;
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

    /**
     * Main function for starting the process
     */
    @SuppressWarnings("resource")
    public static void main(String[] args) {

        String config = "spring/percero-spring-config.xml"; // Default
        if (args.length > 0)
            config = args[0];

        logger.info("Using config: " + config);
        ApplicationContext context =
                new ClassPathXmlApplicationContext(new String[]{config, "spring/*.xml"});
        logger.debug(context.toString());

        logger.info("\n\n****************************************\nApplication Started\n****************************************\n\n");

        // Test Login
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
        teamLeader.setID("100139921");
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
//
            Iterator<Agent> itrAgents = teamLeader.getAgents().iterator();
            while (itrAgents.hasNext()) {
                Agent nextAgent = syncAgentService.systemGetByObject(itrAgents.next());
                AgentLOB findAgentLOB = new AgentLOB();

                if (nextAgent != null ) {//&& nextAgent.getID().equals("100625110")
                    findAgentLOB.setID(nextAgent.getID());
                    findAgentLOB = (AgentLOB) syncAgentService.systemGetById(BaseDataObject.toClassIdPair(findAgentLOB));
                    nextAgent.getAgentLOBs().add(findAgentLOB);
                    System.out.println("Agent ID :" + nextAgent.getID());
                    System.out.println("AgentLOB  :" + nextAgent.getAgentLOBs());
//					nextAgent.getAgentLOBs()
                    if (nextAgent.getAgentLOBs() != null) {
                        Iterator<AgentLOB> itrAgentLob = nextAgent.getAgentLOBs().iterator();
                        System.out.println("****************************************");
                        System.out.println("AgentLOB Size :" + nextAgent.getAgentLOBs().size());
                        System.out.println("****************************************");
                        while (itrAgentLob.hasNext()) {
                            AgentLOB agentLOB = syncAgentService.systemGetByObject(itrAgentLob.next());
                            if (agentLOB != null && agentLOB.getLOB() != null) {
                                System.out.println("****************************************");
                                System.out.println("AgentLOB ID :" + agentLOB.getID());
                                System.out.println("AgentLOB LOB :" + agentLOB.getLOB());
                                System.out.println("****************************************");

                                LOB lob = syncAgentService.systemGetByObject(agentLOB.getLOB());
                                if (lob != null) {
                                    System.out.println("****************************************");
                                    System.out.println("AgentLOB LOB ID :" + agentLOB.getLOB().getID());
                                    System.out.println("****************************************");
                                    if (lob.getLOBConfigurations() != null) {
                                        System.out.println("****************************************");
                                        System.out.println("AgentLOB LOB.LOBCOnfiguration size :" + lob.getLOBConfigurations().size());
                                        System.out.println("****************************************");
                                        Iterator<LOBConfiguration> itrLobConfiguration = lob.getLOBConfigurations().iterator();

                                        while (itrLobConfiguration.hasNext()) {
                                            LOBConfiguration lobConfiguration = (LOBConfiguration) syncAgentService.systemGetByObject(itrLobConfiguration.next());

                                            if (lobConfiguration != null) {
                                                System.out.println("****************************************");
                                                System.out.println("AgentLOB lobConfiguration :" + lobConfiguration.getID());
                                                System.out.println("****************************************");
                                                Iterator<LOBConfigurationEntry> itrLobConfigurationEntry = lobConfiguration.getLOBConfigurationEntries().iterator();
                                                while (itrLobConfigurationEntry.hasNext()) {

                                                    LOBConfigurationEntry lobConfigurationEntry = (LOBConfigurationEntry) syncAgentService.systemGetByObject(itrLobConfigurationEntry.next());
                                                    if (lobConfigurationEntry != null) {
                                                        System.out.println("****************************************");
                                                        System.out.println("AgentLOB lobConfigurationentry_id :" + lobConfigurationEntry.getID());
                                                        System.out.println("****************************************");
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }

                    }

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

                }
            }
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
}
