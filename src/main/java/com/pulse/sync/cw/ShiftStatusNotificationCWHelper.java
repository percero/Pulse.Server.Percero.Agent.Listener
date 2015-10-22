package com.pulse.sync.cw;

import java.util.Collection;
import java.util.HashSet;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.percero.agents.sync.cw.DerivedValueChangeWatcherHelper;
import com.percero.agents.sync.vo.ClassIDPair;
import com.pulse.mo.CoachingNotification;
import com.pulse.mo.ShiftStatusNotification;
import com.pulse.mo.Timecard;

@Component
public class ShiftStatusNotificationCWHelper extends DerivedValueChangeWatcherHelper {

	private static final Logger log = Logger.getLogger(ShiftStatusNotificationCWHelper.class);

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
		
		if (fieldName.equalsIgnoreCase("notYetStartedStateCount")) {
			try {
				result = calc_notYetStartedStateCount(pair);
				postCalculate(fieldName, pair, params, result, oldValue);
			} catch(Exception e) {
				log.error("Unable to calculate notYetStartedStateCount", e);
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

	public Integer calc_notYetStartedStateCount(ClassIDPair pair) {
		Integer notYetStartedStateCount = 0;

		try {
			ShiftStatusNotification host = (ShiftStatusNotification) syncAgentService.systemGetById(pair);
			if (host == null) {
				log.warn("Unable to calculate notYetStartedStateCount: Invalid objectId");
				return notYetStartedStateCount;
			}
			
			// Setup fieldsToWatch.
			Collection<String> fieldsToWatch = new HashSet<String>();
			
			// We want to re-trigger this change watcher when AgentScorecard.weekDate changes.
			accessManager.addWatcherField(pair, "weekDate", fieldsToWatch);
			
			if (host != null) {

				// Re-trigger this ChangeWatcher if Timecard.timecardEntries changes.
				accessManager.addWatcherField(pair, "timecardEntries", fieldsToWatch);
				// Re-trigger this ChangeWatcher if Timecard.timecardState changes.
				accessManager.addWatcherField(pair, "timecardState", fieldsToWatch);
				
//				Timecard timecard;
//				
//				if (timecard.getTimecardEntries().size() <=0 ){
//					notYetStartedStateCount(existingShiftStatusNotification.getNotYetStartedStateCount() + 1);
//				}
//				else if (timecard.getTimecardState().equals("Approved")) {
//					existingShiftStatusNotification.setApprovedStateCount(existingShiftStatusNotification.getApprovedStateCount() + 1);
//				}
//				else if (timecard.getTimecardState().equals("Completed")){
//					existingShiftStatusNotification.setCompleteStateCount(existingShiftStatusNotification.getCompleteStateCount() + 1);
//				}
//				else{
//					existingShiftStatusNotification.setInProgressStateCount(existingShiftStatusNotification.getInProgressStateCount());
//				}
			}
			
			// Register all the fields to watch for this ChangeWatcher. Whenever
			// ANY of these fields change, this ChangeWatcher will get re-run
			accessManager.updateWatcherFields(pair, "notYetStartedStateCount", fieldsToWatch);
			
			// Store the result for caching, and also for comparing new results to see if there has been a change.
			accessManager.saveChangeWatcherResult(pair, "notYetStartedStateCount", notYetStartedStateCount);
		} catch(Exception e) {
			log.error("Unable to calculate notYetStartedStateCount", e);
		}
		
		return notYetStartedStateCount;
	}
	
	public Integer calc_submittedStateCount(ClassIDPair pair) {
		Integer submittedStateCount 			= 0;
		
		try {
			CoachingNotification host = (CoachingNotification) syncAgentService.systemGetById(pair);
			if (host == null) {
				log.warn("Unable to calculate submittedStateCount: Invalid objectId");
				return submittedStateCount;
			}
			
			// Setup fieldsToWatch.
			Collection<String> fieldsToWatch = new HashSet<String>();
			
			if (host != null) {
				
//				// TODO: Need to get CoachingSessions here.
//				accessManager.addWatcherField(pair, "coachingSessions", fieldsToWatch);
//				Iterator<CoachingSession> itrCoachingSession  = host.getCoachingSessions().iterator();
//
//				while (itrCoachingSession.hasNext()) {
//					CoachingSession nextCoachingSession = itrCoachingSession.next();
//					if (nextCoachingSession != null && nextCoachingSession instanceof CoachingSession) {
//						ClassIDPair coachingSessionPair = BaseDataObject.toClassIdPair(nextCoachingSession);
//						String coachingSessionStateID = nextCoachingSession.getCoachingSessionState().getID();
//
//						accessManager.addWatcherField(coachingSessionPair, "coachingSessionState", fieldsToWatch);
//						if (coachingSessionStateID.equals("2") || coachingSessionStateID.equals("9")) {
//							submittedStateCount++;
//						}
//					}
//				}
				
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


}
