package com.pulse.sync.cw;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.percero.agents.sync.cw.DerivedValueChangeWatcherHelper;
import com.percero.agents.sync.vo.BaseDataObject;
import com.percero.agents.sync.vo.ClassIDPair;
import com.pulse.mo.AgentScorecard;
import com.pulse.mo.CoachingNotification;
import com.pulse.mo.CoachingSession;

@Component
public class CoachingNotificationCWHelper extends DerivedValueChangeWatcherHelper {

	private static final Logger log = Logger.getLogger(CoachingNotificationCWHelper.class);

	@Override
	public Object calculate(String fieldName, ClassIDPair pair) {
		return calculate(fieldName, pair, null);
	}
	
	@Override
	public Object calculate(String fieldName, ClassIDPair pair, String[] params) {
		Object result = null;
		Object oldValue = null;
		try {
			oldValue = accessManager.getChangeWatcherResult(pair, fieldName, params);
		} catch(Exception e) {}
		
		if (fieldName.equalsIgnoreCase("pendingStateCount")) {
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
	
	private Object calc_skippedStateCount(ClassIDPair pair) {
		// TODO Auto-generated method stub
		return null;
	}

	private Object calc_acknowledgementStateCount(ClassIDPair pair) {
		// TODO Auto-generated method stub
		return null;
	}

	private Object calc_pendingEmployeeStateCount(ClassIDPair pair) {
		// TODO Auto-generated method stub
		return null;
	}

	private Object calc_pendingCoachStateCount(ClassIDPair pair) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer calc_pendingStateCount(ClassIDPair pair) {
		Integer pendingStateCount 			= 0;

		try {
			CoachingNotification host = (CoachingNotification) syncAgentService.systemGetById(pair);
			if (host == null) {
				log.warn("Unable to calculate pendingStateCount: Invalid objectId");
				return pendingStateCount;
			}
			
			// Setup fieldsToWatch.
			Collection<String> fieldsToWatch = new HashSet<String>();
			
			// We want to re-trigger this change watcher when AgentScorecard.weekDate changes.
			accessManager.addWatcherField(pair, "weekDate", fieldsToWatch);
			
			if (host != null) {

				accessManager.addWatcherField(pair, "agentScorecard", fieldsToWatch);
				AgentScorecard agentScorecard = syncAgentService.systemGetByObject(host.getAgentScorecard());
				
				if (agentScorecard != null) {
					accessManager.addWatcherField(BaseDataObject.toClassIdPair(agentScorecard), "coachingSessions", fieldsToWatch);
					Iterator<CoachingSession> itrCoachingSession  = agentScorecard.getCoachingSessions().iterator();
	
					while (itrCoachingSession.hasNext()) {
						CoachingSession nextCoachingSession = syncAgentService.systemGetByObject(itrCoachingSession.next());
						if (nextCoachingSession != null && nextCoachingSession instanceof CoachingSession) {
							ClassIDPair coachingSessionPair = BaseDataObject.toClassIdPair(nextCoachingSession);
							accessManager.addWatcherField(coachingSessionPair, "coachingSessionState", fieldsToWatch);
							
							String coachingSessionStateID = nextCoachingSession.getCoachingSessionState().getID();
							if (coachingSessionStateID.equals("1") || coachingSessionStateID.equals("8")) {
								pendingStateCount++;
							}
						}
					}
				}
			}
			
			// Register all the fields to watch for this ChangeWatcher. Whenever
			// ANY of these fields change, this ChangeWatcher will get re-run
			accessManager.updateWatcherFields(pair, "pendingStateCount", fieldsToWatch);
			
			// Store the result for caching, and also for comparing new results to see if there has been a change.
			accessManager.saveChangeWatcherResult(pair, "pendingStateCount", pendingStateCount);
		} catch(Exception e) {
			log.error("Unable to calculate pendingStateCount", e);
		}
		
		return pendingStateCount;
	}
	
	
	public Integer calc_submittedStateCount(ClassIDPair pair) {
		Integer submittedStateCount = 0;
		
		try {
			CoachingNotification host = (CoachingNotification) syncAgentService.systemGetById(pair);
			if (host == null) {
				log.warn("Unable to calculate submittedStateCount: Invalid objectId");
				return submittedStateCount;
			}
			
			// Setup fieldsToWatch.
			Collection<String> fieldsToWatch = new HashSet<String>();
			
			// We want to re-trigger this change watcher when AgentScorecard.weekDate changes.
			accessManager.addWatcherField(pair, "weekDate", fieldsToWatch);
			
			if (host != null) {
				
				accessManager.addWatcherField(pair, "agentScorecard", fieldsToWatch);
				AgentScorecard agentScorecard = syncAgentService.systemGetByObject(host.getAgentScorecard());
				
				if (agentScorecard != null) {
					accessManager.addWatcherField(BaseDataObject.toClassIdPair(agentScorecard), "coachingSessions", fieldsToWatch);
					Iterator<CoachingSession> itrCoachingSession  = agentScorecard.getCoachingSessions().iterator();
					
					while (itrCoachingSession.hasNext()) {
						CoachingSession nextCoachingSession = syncAgentService.systemGetByObject(itrCoachingSession.next());
						if (nextCoachingSession != null && nextCoachingSession instanceof CoachingSession) {
							ClassIDPair coachingSessionPair = BaseDataObject.toClassIdPair(nextCoachingSession);
							accessManager.addWatcherField(coachingSessionPair, "coachingSessionState", fieldsToWatch);
							
							String coachingSessionStateID = nextCoachingSession.getCoachingSessionState().getID();
							if (coachingSessionStateID.equals("2") || coachingSessionStateID.equals("9")) {
								submittedStateCount++;
							}
						}
					}
				}
			}
			
			// Register all the fields to watch for this ChangeWatcher. Whenever
			// ANY of these fields change, this ChangeWatcher will get re-run
			accessManager.updateWatcherFields(pair, "submittedStateCount", fieldsToWatch);
			
			// Store the result for caching, and also for comparing new results to see if there has been a change.
			accessManager.saveChangeWatcherResult(pair, "submittedStateCount", submittedStateCount);
		} catch(Exception e) {
			log.error("Unable to calculate submittedStateCount", e);
		}
		
		return submittedStateCount;
	}
	
//	public Integer calc_submittedStateCount(ClassIDPair pair) {
//		Integer pendingStateCount 			= 0;
//		
//		try {
//			CoachingNotification host = (CoachingNotification) syncAgentService.systemGetById(pair);
//			if (host == null) {
//				log.warn("Unable to calculate pendingStateCount: Invalid objectId");
//				return pendingStateCount;
//			}
//			
//			// Setup fieldsToWatch.
//			Collection<String> fieldsToWatch = new HashSet<String>();
//			
//			// We want to re-trigger this change watcher when AgentScorecard.weekDate changes.
//			accessManager.addWatcherField(pair, "weekDate", fieldsToWatch);
//			
//			if (host != null) {
//				
////				Integer submittedStateCount			= null;
////				Integer pendingCoachStateCount		= null;
////				Integer pendingEmployeeStateCount	= null;
////				Integer acknowledgementStateCount	= null;
////				Integer skippedStateCount			= null;
//				
//				accessManager.addWatcherField(pair, "agentScorecard", fieldsToWatch);
//				AgentScorecard agentScorecard = syncAgentService.systemGetByObject(host.getAgentScorecard());
//				
//				if (agentScorecard != null) {
//					accessManager.addWatcherField(BaseDataObject.toClassIdPair(agentScorecard), "coachingSessions", fieldsToWatch);
//					Iterator<CoachingSession> itrCoachingSession  = agentScorecard.getCoachingSessions().iterator();
//					
//					while (itrCoachingSession.hasNext()) {
//						CoachingSession nextCoachingSession = syncAgentService.systemGetByObject(itrCoachingSession.next());
//						if (nextCoachingSession != null && nextCoachingSession instanceof CoachingSession) {
//							ClassIDPair coachingSessionPair = BaseDataObject.toClassIdPair(nextCoachingSession);
//							accessManager.addWatcherField(coachingSessionPair, "coachingSessionState", fieldsToWatch);
//							
//							String coachingSessionStateID = nextCoachingSession.getCoachingSessionState().getID();
//							if (coachingSessionStateID.equals("1") || coachingSessionStateID.equals("8")) {
//								pendingStateCount++;
//							}
////							else if (coachingSessionStateID.equals("2") || coachingSessionStateID.equals("9")) {
////								submittedStateCount = host.getSubmittedStateCount();
////								if (submittedStateCount == null) {
////									submittedStateCount = 0;
////								}
////								host.setSubmittedStateCount(submittedStateCount + 1);
////							}
////							else if (coachingSessionStateID.equals("5") || coachingSessionStateID.equals("11")) {
////								pendingCoachStateCount =  host.getPendingCoachStateCount();
////								if (pendingCoachStateCount == null) {
////									pendingCoachStateCount = 0;
////								}
////								host.setPendingCoachStateCount(pendingCoachStateCount + 1);
////							}
////							else if (coachingSessionStateID.equals("3") || coachingSessionStateID.equals("10")) {
////								pendingEmployeeStateCount = host.getPendingEmployeeStateCount();
////								if (pendingEmployeeStateCount == null) {
////									pendingEmployeeStateCount = 0;
////								}
////								host.setPendingEmployeeStateCount(pendingEmployeeStateCount + 1);
////	
////							} else if (coachingSessionStateID.equals("4") || coachingSessionStateID.equals("6")) {
////								acknowledgementStateCount = host.getAcknowledgementStateCount();
////								if (acknowledgementStateCount == null) {
////									acknowledgementStateCount = 0;
////								}
////								host.setAcknowledgementStateCount(acknowledgementStateCount + 1);
////							} else if (coachingSessionStateID.equals("7")) {
////								skippedStateCount = host.getSkippedStateCount();
////								if (skippedStateCount == null) {
////									skippedStateCount = 0;
////								}
////								host.setSkippedStateCount(skippedStateCount + 1);
////							}
//						}
//					}
//				}
//			}
//			
//			// Register all the fields to watch for this ChangeWatcher. Whenever
//			// ANY of these fields change, this ChangeWatcher will get re-run
//			accessManager.updateWatcherFields(pair, "pendingStateCount", fieldsToWatch);
//			
//			// Store the result for caching, and also for comparing new results to see if there has been a change.
//			accessManager.saveChangeWatcherResult(pair, "pendingStateCount", pendingStateCount);
//		} catch(Exception e) {
//			log.error("Unable to calculate pendingStateCount", e);
//		}
//		
//		return pendingStateCount;
//	}
	

}
