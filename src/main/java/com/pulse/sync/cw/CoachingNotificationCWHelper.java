package com.pulse.sync.cw;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.DateTimeComparator;
import org.springframework.stereotype.Component;

import com.percero.agents.sync.cw.DerivedValueChangeWatcherHelper;
import com.percero.agents.sync.vo.BaseDataObject;
import com.percero.agents.sync.vo.ClassIDPair;
import com.pulse.mo.Agent;
import com.pulse.mo.AgentScorecard;
import com.pulse.mo.CoachingNotification;
import com.pulse.mo.CoachingSession;
import com.pulse.mo.TeamLeader;

@Component
public class CoachingNotificationCWHelper extends DerivedValueChangeWatcherHelper {

	private static final Logger log = Logger.getLogger(CoachingNotificationCWHelper.class);

	@Override
	public Object calculate(String fieldName, ClassIDPair pair) {
		return calculate(fieldName, pair, null);
	}
	
	private static final String AGENT_SCORECARDS = "agentScorecards";
	
	@Override
	public Object calculate(String fieldName, ClassIDPair pair, String[] params) {
		Object result = null;
		Object oldValue = null;
		try {
			oldValue = accessManager.getChangeWatcherResult(pair, fieldName, params);
		} catch(Exception e) {}
		
		if (AGENT_SCORECARDS.equalsIgnoreCase(fieldName)) {
			try {
				result = calc_agentScorecards(pair, AGENT_SCORECARDS);
				postCalculate(fieldName, pair, params, result, oldValue);
			} catch(Exception e) {
				log.error("Unable to calculate " + AGENT_SCORECARDS, e);
			}
		}
		else if (fieldName.equalsIgnoreCase("pendingStateCount")) {
			try {
				result = calc_pendingStateCount(pair);
				postCalculate(fieldName, pair, params, result, oldValue);
			} catch(Exception e) {
				log.error("Unable to calculate pendingStateCount", e);
			}
		}
		else if (fieldName.equalsIgnoreCase("submittedStateCount")) {
			try {
				result = calc_submittedStateCount(pair);
				postCalculate(fieldName, pair, params, result, oldValue);
			} catch(Exception e) {
				log.error("Unable to calculate submittedStateCount", e);
			}
		}
		else if (fieldName.equalsIgnoreCase("pendingCoachStateCount")) {
			try {
				result = calc_pendingCoachStateCount(pair);
				postCalculate(fieldName, pair, params, result, oldValue);
			} catch(Exception e) {
				log.error("Unable to calculate pendingCoachStateCount", e);
			}
		}
		else if (fieldName.equalsIgnoreCase("pendingEmployeeStateCount")) {
			try {
				result = calc_pendingEmployeeStateCount(pair);
				postCalculate(fieldName, pair, params, result, oldValue);
			} catch(Exception e) {
				log.error("Unable to calculate pendingEmployeeStateCount", e);
			}
		}
		else if (fieldName.equalsIgnoreCase("acknowledgementStateCount")) {
			try {
				result = calc_acknowledgementStateCount(pair);
				postCalculate(fieldName, pair, params, result, oldValue);
			} catch(Exception e) {
				log.error("Unable to calculate acknowledgementStateCount", e);
			}
		}
		else if (fieldName.equalsIgnoreCase("skippedStateCount")) {
			try {
				result = calc_skippedStateCount(pair);
				postCalculate(fieldName, pair, params, result, oldValue);
			} catch(Exception e) {
				log.error("Unable to calculate skippedStateCount", e);
			}
		}
		else {
			result = super.calculate(fieldName, pair, params);
		}
		
		return result;
	}
	
//	private Object calc_skippedStateCount(ClassIDPair pair) {
//		Integer skippedStateCount = 0;
//
//		try {
//			CoachingNotification host = (CoachingNotification) syncAgentService.systemGetById(pair);
//			if (host == null) {
//				log.warn("Unable to calculate pendingStateCount: Invalid objectId");
//				return skippedStateCount;
//			}
//
//			// Setup fieldsToWatch.
//			Collection<String> fieldsToWatch = new HashSet<String>();
//
//			// We want to re-trigger this change watcher when AgentScorecard.weekDate changes.
//			accessManager.addWatcherField(pair, "weekDate", fieldsToWatch);
//			Date weekDate = host.getWeekDate();
//
//			accessManager.addWatcherField(pair, "teamLeader", fieldsToWatch);
//			TeamLeader teamLeader = syncAgentService.systemGetByObject(host.getTeamLeader());
//			
//			if (weekDate != null && weekDate.getTime() > 0 && teamLeader != null) {
//				DateTime coachingNotificationWeekDate = new DateTime(host.getWeekDate().getTime());
//
//				accessManager.addWatcherField(BaseDataObject.toClassIdPair(teamLeader), "agents", fieldsToWatch);
//				Iterator<Agent> itrAgents = teamLeader.getAgents().iterator();
//				while (itrAgents.hasNext()) {
//					Agent agent = syncAgentService.systemGetByObject(itrAgents.next());
//					if (agent != null) {
//						accessManager.addWatcherField(BaseDataObject.toClassIdPair(agent), "agentScorecards", fieldsToWatch);
//						Iterator<AgentScorecard> itrAgentScorecards = agent.getAgentScorecards().iterator();
//						while (itrAgentScorecards.hasNext()) {
//							AgentScorecard agentScorecard = syncAgentService.systemGetByObject(itrAgentScorecards.next());
//							
//							if (agentScorecard != null) {
//								accessManager.addWatcherField(BaseDataObject.toClassIdPair(agentScorecard), "weekDate", fieldsToWatch);
//								if (agentScorecard.getWeekDate() != null && agentScorecard.getWeekDate().getTime() > 0) {
//									DateTime scorecardDateTime = new DateTime(agentScorecard.getWeekDate().getTime());
//									
//									if (DateTimeComparator.getDateOnlyInstance().compare(scorecardDateTime, coachingNotificationWeekDate) == 0) {
//										accessManager.addWatcherField(BaseDataObject.toClassIdPair(agentScorecard), "coachingSessions", fieldsToWatch);
//										Iterator<CoachingSession> itrCoachingSession  = agentScorecard.getCoachingSessions().iterator();
//						
//										while (itrCoachingSession.hasNext()) {
//											CoachingSession nextCoachingSession = syncAgentService.systemGetByObject(itrCoachingSession.next());
//											if (nextCoachingSession != null && nextCoachingSession instanceof CoachingSession) {
//												ClassIDPair coachingSessionPair = BaseDataObject.toClassIdPair(nextCoachingSession);
//												accessManager.addWatcherField(coachingSessionPair, "coachingSessionState", fieldsToWatch);
//						
//												String coachingSessionStateID = nextCoachingSession.getCoachingSessionState().getID();
//												if (coachingSessionStateID.equals("7")) {
//													skippedStateCount++;
//												}
//											}
//										}
//									}
//								}
//							}
//						}
//					}
//				}
//			}
//
//			// Register all the fields to watch for this ChangeWatcher. Whenever
//			// ANY of these fields change, this ChangeWatcher will get re-run
//			accessManager.updateWatcherFields(pair, "skippedStateCount", fieldsToWatch);
//
//			// Store the result for caching, and also for comparing new results to see if there has been a change.
//			accessManager.saveChangeWatcherResult(pair, "skippedStateCount", skippedStateCount);
//		} catch(Exception e) {
//			log.error("Unable to calculate skippedStateCount", e);
//		}
//
//		return skippedStateCount;
//	}

	
	public Integer calc_skippedStateCount(ClassIDPair pair) {
		Set<String> ids = new HashSet<String>(2);
		ids.add("7");
		return calcCounter(pair, "skippedStateCount", ids);
	}
	
	public Integer calc_acknowledgementStateCount(ClassIDPair pair) {
		Set<String> ids = new HashSet<String>(2);
		ids.add("4");
		ids.add("6");
		return calcCounter(pair, "acknowledgementStateCount", ids);
	}
	
	public Integer calc_pendingEmployeeStateCount(ClassIDPair pair) {
		Set<String> ids = new HashSet<String>(2);
		ids.add("3");
		ids.add("10");
		return calcCounter(pair, "pendingEmployeeStateCount", ids);
	}

	public Integer calc_pendingCoachStateCount(ClassIDPair pair) {
		Set<String> ids = new HashSet<String>(2);
		ids.add("5");
		ids.add("11");
		return calcCounter(pair, "pendingCoachStateCount", ids);
	}
	
	public Integer calc_pendingStateCount(ClassIDPair pair) {
		Set<String> ids = new HashSet<String>(2);
		ids.add("1");
		ids.add("8");
		return calcCounter(pair, "pendingStateCount", ids);
	}
	
	public Integer calc_submittedStateCount(ClassIDPair pair) {
		Set<String> ids = new HashSet<String>(2);
		ids.add("2");
		ids.add("9");
		return calcCounter(pair, "submittedStateCount", ids);
	}
	
	
	private List<ClassIDPair> calc_agentScorecards(ClassIDPair pair, String derivedValueName) {
		List<ClassIDPair> results = new ArrayList<ClassIDPair>();
		
		try {
			CoachingNotification host = (CoachingNotification) syncAgentService.systemGetById(pair);
			if (host == null) {
				log.warn("Unable to calculate " + derivedValueName + ": Invalid objectId");
				return results;
			}
			
			Set<AgentScorecard> agentScorecards = new HashSet<AgentScorecard>();
			
			// Setup fieldsToWatch.
			Collection<String> fieldsToWatch = new HashSet<String>();
			
			// We want to re-trigger this change watcher when AgentScorecard.weekDate changes.
			accessManager.addWatcherField(pair, "weekDate", fieldsToWatch);
			Date weekDate = host.getWeekDate();
			
			accessManager.addWatcherField(pair, "teamLeader", fieldsToWatch);
			TeamLeader teamLeader = syncAgentService.systemGetByObject(host.getTeamLeader());
			
			if (weekDate != null && weekDate.getTime() > 0 && teamLeader != null) {
				DateTime coachingNotificationWeekDate = new DateTime(host.getWeekDate().getTime());
				
				accessManager.addWatcherField(BaseDataObject.toClassIdPair(teamLeader), "agents", fieldsToWatch);
				Iterator<Agent> itrAgents = teamLeader.getAgents().iterator();
				while (itrAgents.hasNext()) {
					Agent agent = syncAgentService.systemGetByObject(itrAgents.next());
					if (agent != null) {
						accessManager.addWatcherField(BaseDataObject.toClassIdPair(agent), "agentScorecards", fieldsToWatch);
						Iterator<AgentScorecard> itrAgentScorecards = agent.getAgentScorecards().iterator();
						while (itrAgentScorecards.hasNext()) {
							AgentScorecard agentScorecard = syncAgentService.systemGetByObject(itrAgentScorecards.next());
							
							if (agentScorecard != null) {
								accessManager.addWatcherField(BaseDataObject.toClassIdPair(agentScorecard), "weekDate", fieldsToWatch);
								if (agentScorecard.getWeekDate() != null && agentScorecard.getWeekDate().getTime() > 0) {
									DateTime scorecardDateTime = new DateTime(agentScorecard.getWeekDate().getTime());
									
									if (DateTimeComparator.getDateOnlyInstance().compare(scorecardDateTime, coachingNotificationWeekDate) == 0) {
										agentScorecards.add(agentScorecard);
									}
								}
							}
						}
					}
				}
			}
			
			Iterator<AgentScorecard> itrAgentScorecards = agentScorecards.iterator();
			while (itrAgentScorecards.hasNext()) {
				AgentScorecard nextResult = itrAgentScorecards.next();
				results.add(BaseDataObject.toClassIdPair(nextResult));
			}
			
			// Register all the fields to watch for this ChangeWatcher. Whenever
			// ANY of these fields change, this ChangeWatcher will get re-run
			accessManager.updateWatcherFields(pair, derivedValueName, fieldsToWatch);
			
			// Store the result for caching, and also for comparing new results to see if there has been a change.
			accessManager.saveChangeWatcherResult(pair, derivedValueName, results);
		} catch(Exception e) {
			log.error("Unable to calculate " + derivedValueName, e);
		}
		
		return results;
	}

	private Integer calcCounter(ClassIDPair pair, String countName, Set<String> coachingSessionStateIds) {
		Integer totalCount = 0;

		try {
			CoachingNotification host = (CoachingNotification) syncAgentService.systemGetById(pair);
			if (host == null) {
				log.warn("Unable to calculate " + countName + ": Invalid objectId");
				return totalCount;
			}

			// Setup fieldsToWatch.
			Collection<String> fieldsToWatch = new HashSet<String>();

			// We want to re-trigger this change watcher when AgentScorecard.weekDate changes.
			accessManager.addWatcherField(pair, "agentScorecards", fieldsToWatch);

			Iterator<AgentScorecard> itrAgentScorecards = host.getAgentScorecards().iterator();
			while (itrAgentScorecards.hasNext()) {
				// Because this is a derived collection, it contains full objects --> no need to re-retrieve from database.
				AgentScorecard agentScorecard = itrAgentScorecards.next();
				
				if (agentScorecard != null) {
					accessManager.addWatcherField(BaseDataObject.toClassIdPair(agentScorecard), "coachingSessions", fieldsToWatch);
					Iterator<CoachingSession> itrCoachingSession  = agentScorecard.getCoachingSessions().iterator();
	
					while (itrCoachingSession.hasNext()) {
						CoachingSession nextCoachingSession = syncAgentService.systemGetByObject(itrCoachingSession.next());
						if (nextCoachingSession != null && nextCoachingSession instanceof CoachingSession) {
							ClassIDPair coachingSessionPair = BaseDataObject.toClassIdPair(nextCoachingSession);
							accessManager.addWatcherField(coachingSessionPair, "coachingSessionState", fieldsToWatch);
	
							String coachingSessionStateID = nextCoachingSession.getCoachingSessionState().getID();
							if (coachingSessionStateIds.contains(coachingSessionStateID)) {
								totalCount++;
							}
						}
					}
				}
			}

//			
//			Date weekDate = host.getWeekDate();
//
//			accessManager.addWatcherField(pair, "teamLeader", fieldsToWatch);
//			TeamLeader teamLeader = syncAgentService.systemGetByObject(host.getTeamLeader());
//			
//			if (weekDate != null && weekDate.getTime() > 0 && teamLeader != null) {
//				DateTime coachingNotificationWeekDate = new DateTime(host.getWeekDate().getTime());
//
//				accessManager.addWatcherField(BaseDataObject.toClassIdPair(teamLeader), "agents", fieldsToWatch);
//				Iterator<Agent> itrAgents = teamLeader.getAgents().iterator();
//				while (itrAgents.hasNext()) {
//					Agent agent = syncAgentService.systemGetByObject(itrAgents.next());
//					if (agent != null) {
//						accessManager.addWatcherField(BaseDataObject.toClassIdPair(agent), "agentScorecards", fieldsToWatch);
//						Iterator<AgentScorecard> itrAgentScorecards = agent.getAgentScorecards().iterator();
//						while (itrAgentScorecards.hasNext()) {
//							AgentScorecard agentScorecard = syncAgentService.systemGetByObject(itrAgentScorecards.next());
//							
//							if (agentScorecard != null) {
//								accessManager.addWatcherField(BaseDataObject.toClassIdPair(agentScorecard), "weekDate", fieldsToWatch);
//								if (agentScorecard.getWeekDate() != null && agentScorecard.getWeekDate().getTime() > 0) {
//									DateTime scorecardDateTime = new DateTime(agentScorecard.getWeekDate().getTime());
//									
//									if (DateTimeComparator.getDateOnlyInstance().compare(scorecardDateTime, coachingNotificationWeekDate) == 0) {
//										accessManager.addWatcherField(BaseDataObject.toClassIdPair(agentScorecard), "coachingSessions", fieldsToWatch);
//										Iterator<CoachingSession> itrCoachingSession  = agentScorecard.getCoachingSessions().iterator();
//						
//										while (itrCoachingSession.hasNext()) {
//											CoachingSession nextCoachingSession = syncAgentService.systemGetByObject(itrCoachingSession.next());
//											if (nextCoachingSession != null && nextCoachingSession instanceof CoachingSession) {
//												ClassIDPair coachingSessionPair = BaseDataObject.toClassIdPair(nextCoachingSession);
//												accessManager.addWatcherField(coachingSessionPair, "coachingSessionState", fieldsToWatch);
//						
//												String coachingSessionStateID = nextCoachingSession.getCoachingSessionState().getID();
//												if (coachingSessionStateIds.contains(coachingSessionStateID)) {
//													totalCount++;
//												}
//											}
//										}
//									}
//								}
//							}
//						}
//					}
//				}
//			}

			// Register all the fields to watch for this ChangeWatcher. Whenever
			// ANY of these fields change, this ChangeWatcher will get re-run
			accessManager.updateWatcherFields(pair, countName, fieldsToWatch);

			// Store the result for caching, and also for comparing new results to see if there has been a change.
			accessManager.saveChangeWatcherResult(pair, countName, totalCount);
		} catch(Exception e) {
			log.error("Unable to calculate " + countName, e);
		}

		return totalCount;
	}

}
