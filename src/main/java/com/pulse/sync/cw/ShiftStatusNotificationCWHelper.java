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
import com.pulse.mo.CoachingNotification;
import com.pulse.mo.ShiftStatusNotification;
import com.pulse.mo.TeamLeader;
import com.pulse.mo.Timecard;

@Component
public class ShiftStatusNotificationCWHelper extends DerivedValueChangeWatcherHelper {

	private static final Logger log = Logger.getLogger(ShiftStatusNotificationCWHelper.class);

	public static final String TIMECARDS = "timecards";
	public static final String NOT_YET_STARTED_STATE_COUNT = "notYetStartedStateCount";
	public static final String APPROVED_STATE_COUNT = "approvedStateCount";
	public static final String COMPLETED_STATE_COUNT = "completedStateCount";
	public static final String IN_PROGRESS_STATE_COUNT = "inProgressStateCount";
	public static final String UNKNOWN_STATE_COUNT = "unknownStateCount";

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

		if (TIMECARDS.equalsIgnoreCase(fieldName)) {
			try {
				result = calc_timecards(pair, TIMECARDS);
				postCalculate(fieldName, pair, params, result, oldValue);
			} catch(Exception e) {
				log.error("Unable to calculate " + TIMECARDS, e);
			}
		}
		else if (NOT_YET_STARTED_STATE_COUNT.equalsIgnoreCase(fieldName)) {
			try {
				result = calc_notYetStartedStateCount(pair, NOT_YET_STARTED_STATE_COUNT);
				postCalculate(fieldName, pair, params, result, oldValue);
			} catch(Exception e) {
				log.error("Unable to calculate " + NOT_YET_STARTED_STATE_COUNT, e);
			}
		}
		else if (APPROVED_STATE_COUNT.equalsIgnoreCase(fieldName)) {
			try {
				result = calc_approvedStateCount(pair, APPROVED_STATE_COUNT);
				postCalculate(fieldName, pair, params, result, oldValue);
			} catch(Exception e) {
				log.error("Unable to calculate " + APPROVED_STATE_COUNT, e);
			}
		}
		else if (COMPLETED_STATE_COUNT.equalsIgnoreCase(fieldName)) {
			try {
				result = calc_completedStateCount(pair, COMPLETED_STATE_COUNT);
				postCalculate(fieldName, pair, params, result, oldValue);
			} catch(Exception e) {
				log.error("Unable to calculate " + COMPLETED_STATE_COUNT, e);
			}
		}
		else if (IN_PROGRESS_STATE_COUNT.equalsIgnoreCase(fieldName)) {
			try {
				result = calc_inProgressStateCount(pair, IN_PROGRESS_STATE_COUNT);
				postCalculate(fieldName, pair, params, result, oldValue);
			} catch(Exception e) {
				log.error("Unable to calculate " + IN_PROGRESS_STATE_COUNT, e);
			}
		}
		else if (UNKNOWN_STATE_COUNT.equalsIgnoreCase(fieldName)) {
			try {
				result = calc_inProgressStateCount(pair, UNKNOWN_STATE_COUNT);
				postCalculate(fieldName, pair, params, result, oldValue);
			} catch(Exception e) {
				log.error("Unable to calculate " + UNKNOWN_STATE_COUNT, e);
			}
		}
		else {
			result = super.calculate(fieldName, pair, params);
		}

		return result;
	}

	private List<ClassIDPair> calc_timecards(ClassIDPair pair, String derivedValueName) {
		List<ClassIDPair> results = new ArrayList<ClassIDPair>();

//		try {
//			ShiftStatusNotification host = (ShiftStatusNotification) syncAgentService.systemGetById(pair);
//			if (host == null) {
//				log.warn("Unable to calculate " + derivedValueName + ": Invalid objectId");
//				return results;
//			}
//
//			Set<Timecard> timecards = new HashSet<Timecard>();
//
//			// Setup fieldsToWatch.
//			Collection<String> fieldsToWatch = new HashSet<String>();
//
//			// We want to re-trigger this change watcher when AgentScorecard.weekDate changes.
//			accessManager.addWatcherField(pair, "shiftEndDate", fieldsToWatch);
//			Date shiftEndDate = host.getShiftEndDate();
//
//			accessManager.addWatcherField(pair, "teamLeader", fieldsToWatch);
//			TeamLeader teamLeader = syncAgentService.systemGetByObject(host.getTeamLeader());
//
//			if (shiftEndDate != null && shiftEndDate.getTime() > 0 && teamLeader != null) {
//				DateTime shiftStatusNotificationEndDate = new DateTime(shiftEndDate.getTime());
//
//				accessManager.addWatcherField(BaseDataObject.toClassIdPair(teamLeader), "agents", fieldsToWatch);
//				Iterator<Agent> itrAgents = teamLeader.getAgents().iterator();
//				while (itrAgents.hasNext()) {
//					Agent agent = syncAgentService.systemGetByObject(itrAgents.next());
//					if (agent != null) {
//						accessManager.addWatcherField(BaseDataObject.toClassIdPair(agent), "timecards", fieldsToWatch);
//						Iterator<Timecard> itrTimecards = agent.getTimecards().iterator();
//						while (itrTimecards.hasNext()) {
//							Timecard timecard = syncAgentService.systemGetByObject(itrTimecards.next());
//
//							if (timecard != null) {
//								accessManager.addWatcherField(BaseDataObject.toClassIdPair(timecard), "startDate", fieldsToWatch);
//								if (timecard.getStartDate() != null && timecard.getStartDate().getTime() > 0) {
//									DateTime timecardStartDateTime = new DateTime(timecard.getStartDate().getTime());
//									if (DateTimeComparator.getDateOnlyInstance().compare(timecardStartDateTime, shiftStatusNotificationEndDate) == 0) {
//										timecards.add(timecard);
//									}
//								}
//							}
//						}
//					}
//				}
//			}
//
//			Iterator<Timecard> itrTimecards = timecards.iterator();
//			while (itrTimecards.hasNext()) {
//				Timecard nextResult = itrTimecards.next();
//				results.add(BaseDataObject.toClassIdPair(nextResult));
//			}
//
//			// Register all the fields to watch for this ChangeWatcher. Whenever
//			// ANY of these fields change, this ChangeWatcher will get re-run
//			accessManager.updateWatcherFields(pair, derivedValueName, fieldsToWatch);
//
//			// Store the result for caching, and also for comparing new results to see if there has been a change.
//			accessManager.saveChangeWatcherResult(pair, derivedValueName, results);
//		} catch(Exception e) {
//			log.error("Unable to calculate " + derivedValueName, e);
//		}

		return results;
	}

	public Integer calc_notYetStartedStateCount(ClassIDPair pair, String derivedValueName) {
		Integer resultCount = 0;

//		try {
//			ShiftStatusNotification host = (ShiftStatusNotification) syncAgentService.systemGetById(pair);
//			if (host == null) {
//				log.warn("Unable to calculate " + derivedValueName + ": Invalid objectId");
//				return resultCount;
//			}
//
//			// Setup fieldsToWatch.
//			Collection<String> fieldsToWatch = new HashSet<String>();
//
//			// We want to re-trigger this change watcher when AgentScorecard.weekDate changes.
//			accessManager.addWatcherField(pair, "timecards", fieldsToWatch);
//
//			Iterator<Timecard> itrTimecards = host.getTimecards().iterator();
//			while (itrTimecards.hasNext()) {
//				Timecard timecard = itrTimecards.next();
//				ClassIDPair timecardPair = BaseDataObject.toClassIdPair(timecard);
//
//				// Re-trigger this ChangeWatcher if Timecard.timecardEntries changes.
//				accessManager.addWatcherField(timecardPair, "timecardEntries", fieldsToWatch);
//
//				if (timecard.getTimecardEntries().size() <=0 ){
//					resultCount++;
//				}
////				else if (timecard.getTimecardState().equals("Approved")) {
////					existingShiftStatusNotification.setApprovedStateCount(existingShiftStatusNotification.getApprovedStateCount() + 1);
////				}
////				else if (timecard.getTimecardState().equals("Completed")){
////					existingShiftStatusNotification.setCompleteStateCount(existingShiftStatusNotification.getCompleteStateCount() + 1);
////				}
////				else{
////					existingShiftStatusNotification.setInProgressStateCount(existingShiftStatusNotification.getInProgressStateCount());
////				}
//			}
//
//			// Register all the fields to watch for this ChangeWatcher. Whenever
//			// ANY of these fields change, this ChangeWatcher will get re-run
//			accessManager.updateWatcherFields(pair, derivedValueName, fieldsToWatch);
//
//			// Store the result for caching, and also for comparing new results to see if there has been a change.
//			accessManager.saveChangeWatcherResult(pair, derivedValueName, resultCount);
//		} catch(Exception e) {
//			log.error("Unable to calculate " + derivedValueName, e);
//		}

		return resultCount;
	}

	public Integer calc_approvedStateCount(ClassIDPair pair, String derivedValueName) {
		Integer resultCount = 0;

//		try {
//			ShiftStatusNotification host = (ShiftStatusNotification) syncAgentService.systemGetById(pair);
//			if (host == null) {
//				log.warn("Unable to calculate " + derivedValueName + ": Invalid objectId");
//				return resultCount;
//			}
//
//			// Setup fieldsToWatch.
//			Collection<String> fieldsToWatch = new HashSet<String>();
//
//			// We want to re-trigger this change watcher when AgentScorecard.weekDate changes.
//			accessManager.addWatcherField(pair, "timecards", fieldsToWatch);
//
//			Iterator<Timecard> itrTimecards = host.getTimecards().iterator();
//			while (itrTimecards.hasNext()) {
//				Timecard timecard = itrTimecards.next();
//				ClassIDPair timecardPair = BaseDataObject.toClassIdPair(timecard);
//
//				// Re-trigger this ChangeWatcher if Timecard.timecardEntries changes.
//				accessManager.addWatcherField(timecardPair, "timecardEntries", fieldsToWatch);
//
//				if (timecard.getTimecardEntries().size() > 0 ){
//					// Re-trigger this ChangeWatcher if Timecard.timecardState changes.
//					accessManager.addWatcherField(timecardPair, "timecardState", fieldsToWatch);
//
//					if ("Approved".equalsIgnoreCase(timecard.getTimecardState())) {
//						resultCount++;
//					}
//				}
////				else if (timecard.getTimecardState().equals("Completed")){
////					existingShiftStatusNotification.setCompleteStateCount(existingShiftStatusNotification.getCompleteStateCount() + 1);
////				}
////				else{
////					existingShiftStatusNotification.setInProgressStateCount(existingShiftStatusNotification.getInProgressStateCount());
////				}
//			}
//
//			// Register all the fields to watch for this ChangeWatcher. Whenever
//			// ANY of these fields change, this ChangeWatcher will get re-run
//			accessManager.updateWatcherFields(pair, derivedValueName, fieldsToWatch);
//
//			// Store the result for caching, and also for comparing new results to see if there has been a change.
//			accessManager.saveChangeWatcherResult(pair, derivedValueName, resultCount);
//		} catch(Exception e) {
//			log.error("Unable to calculate " + derivedValueName, e);
//		}

		return resultCount;
	}

	public Integer calc_completedStateCount(ClassIDPair pair, String derivedValueName) {
		Integer resultCount = 0;

//		try {
//			ShiftStatusNotification host = (ShiftStatusNotification) syncAgentService.systemGetById(pair);
//			if (host == null) {
//				log.warn("Unable to calculate " + derivedValueName + ": Invalid objectId");
//				return resultCount;
//			}
//
//			// Setup fieldsToWatch.
//			Collection<String> fieldsToWatch = new HashSet<String>();
//
//			// We want to re-trigger this change watcher when AgentScorecard.weekDate changes.
//			accessManager.addWatcherField(pair, "timecards", fieldsToWatch);
//
//			Iterator<Timecard> itrTimecards = host.getTimecards().iterator();
//			while (itrTimecards.hasNext()) {
//				Timecard timecard = itrTimecards.next();
//				ClassIDPair timecardPair = BaseDataObject.toClassIdPair(timecard);
//
//				// Re-trigger this ChangeWatcher if Timecard.timecardEntries changes.
//				accessManager.addWatcherField(timecardPair, "timecardEntries", fieldsToWatch);
//
//				if (timecard.getTimecardEntries().size() > 0 ){
//					// Re-trigger this ChangeWatcher if Timecard.timecardState changes.
//					accessManager.addWatcherField(timecardPair, "timecardState", fieldsToWatch);
//
//					if ("Completed".equalsIgnoreCase(timecard.getTimecardState())) {
//						resultCount++;
//					}
//				}
////				else if (timecard.getTimecardState().equals("Completed")){
////					existingShiftStatusNotification.setCompleteStateCount(existingShiftStatusNotification.getCompleteStateCount() + 1);
////				}
////				else{
////					existingShiftStatusNotification.setInProgressStateCount(existingShiftStatusNotification.getInProgressStateCount());
////				}
//			}
//
//			// Register all the fields to watch for this ChangeWatcher. Whenever
//			// ANY of these fields change, this ChangeWatcher will get re-run
//			accessManager.updateWatcherFields(pair, derivedValueName, fieldsToWatch);
//
//			// Store the result for caching, and also for comparing new results to see if there has been a change.
//			accessManager.saveChangeWatcherResult(pair, derivedValueName, resultCount);
//		} catch(Exception e) {
//			log.error("Unable to calculate " + derivedValueName, e);
//		}

		return resultCount;
	}

	public Integer calc_inProgressStateCount(ClassIDPair pair, String derivedValueName) {
		Integer resultCount = 0;

//		try {
//			ShiftStatusNotification host = (ShiftStatusNotification) syncAgentService.systemGetById(pair);
//			if (host == null) {
//				log.warn("Unable to calculate " + derivedValueName + ": Invalid objectId");
//				return resultCount;
//			}
//
//			// Setup fieldsToWatch.
//			Collection<String> fieldsToWatch = new HashSet<String>();
//
//			// We want to re-trigger this change watcher when AgentScorecard.weekDate changes.
//			accessManager.addWatcherField(pair, "timecards", fieldsToWatch);
//
//			Iterator<Timecard> itrTimecards = host.getTimecards().iterator();
//			while (itrTimecards.hasNext()) {
//				Timecard timecard = itrTimecards.next();
//				ClassIDPair timecardPair = BaseDataObject.toClassIdPair(timecard);
//
//				// Re-trigger this ChangeWatcher if Timecard.timecardEntries changes.
//				accessManager.addWatcherField(timecardPair, "timecardEntries", fieldsToWatch);
//
//				if (timecard.getTimecardEntries().size() > 0 ){
//					// Re-trigger this ChangeWatcher if Timecard.timecardState changes.
//					accessManager.addWatcherField(timecardPair, "timecardState", fieldsToWatch);
//
//					if ("In Progress".equalsIgnoreCase(timecard.getTimecardState())) {
//						resultCount++;
//					}
//				}
////				else if (timecard.getTimecardState().equals("Completed")){
////					existingShiftStatusNotification.setCompleteStateCount(existingShiftStatusNotification.getCompleteStateCount() + 1);
////				}
////				else{
////					existingShiftStatusNotification.setInProgressStateCount(existingShiftStatusNotification.getInProgressStateCount());
////				}
//			}
//
//			// Register all the fields to watch for this ChangeWatcher. Whenever
//			// ANY of these fields change, this ChangeWatcher will get re-run
//			accessManager.updateWatcherFields(pair, derivedValueName, fieldsToWatch);
//
//			// Store the result for caching, and also for comparing new results to see if there has been a change.
//			accessManager.saveChangeWatcherResult(pair, derivedValueName, resultCount);
//		} catch(Exception e) {
//			log.error("Unable to calculate " + derivedValueName, e);
//		}

		return resultCount;
	}

	public Integer calc_unknownStateCount(ClassIDPair pair, String derivedValueName) {
		Integer resultCount = 0;

//		try {
//			ShiftStatusNotification host = (ShiftStatusNotification) syncAgentService.systemGetById(pair);
//			if (host == null) {
//				log.warn("Unable to calculate " + derivedValueName + ": Invalid objectId");
//				return resultCount;
//			}
//
//			// Setup fieldsToWatch.
//			Collection<String> fieldsToWatch = new HashSet<String>();
//
//			// We want to re-trigger this change watcher when AgentScorecard.weekDate changes.
//			accessManager.addWatcherField(pair, "timecards", fieldsToWatch);
//
//			Iterator<Timecard> itrTimecards = host.getTimecards().iterator();
//			while (itrTimecards.hasNext()) {
//				Timecard timecard = itrTimecards.next();
//				ClassIDPair timecardPair = BaseDataObject.toClassIdPair(timecard);
//
//				// Re-trigger this ChangeWatcher if Timecard.timecardEntries changes.
//				accessManager.addWatcherField(timecardPair, "timecardEntries", fieldsToWatch);
//
//				if (timecard.getTimecardEntries().size() > 0 ){
//					// Re-trigger this ChangeWatcher if Timecard.timecardState changes.
//					accessManager.addWatcherField(timecardPair, "timecardState", fieldsToWatch);
//
//					if (!"Approved".equalsIgnoreCase(timecard.getTimecardState()) &&
//							!"Completed".equalsIgnoreCase(timecard.getTimecardState())
//							&& !"In Progress".equalsIgnoreCase(timecard.getTimecardState())) {
//						resultCount++;
//					}
//				}
//			}
//
//			// Register all the fields to watch for this ChangeWatcher. Whenever
//			// ANY of these fields change, this ChangeWatcher will get re-run
//			accessManager.updateWatcherFields(pair, derivedValueName, fieldsToWatch);
//
//			// Store the result for caching, and also for comparing new results to see if there has been a change.
//			accessManager.saveChangeWatcherResult(pair, derivedValueName, resultCount);
//		} catch(Exception e) {
//			log.error("Unable to calculate " + derivedValueName, e);
//		}

		return resultCount;
	}

	public Integer calc_submittedStateCount(ClassIDPair pair) {
		Integer submittedStateCount 			= 0;

//		try {
//			CoachingNotification host = (CoachingNotification) syncAgentService.systemGetById(pair);
//			if (host == null) {
//				log.warn("Unable to calculate submittedStateCount: Invalid objectId");
//				return submittedStateCount;
//			}
//
//			// Setup fieldsToWatch.
//			Collection<String> fieldsToWatch = new HashSet<String>();
//
//			if (host != null) {
//
////				// TODO: Need to get CoachingSessions here.
////				accessManager.addWatcherField(pair, "coachingSessions", fieldsToWatch);
////				Iterator<CoachingSession> itrCoachingSession  = host.getCoachingSessions().iterator();
////
////				while (itrCoachingSession.hasNext()) {
////					CoachingSession nextCoachingSession = itrCoachingSession.next();
////					if (nextCoachingSession != null && nextCoachingSession instanceof CoachingSession) {
////						ClassIDPair coachingSessionPair = BaseDataObject.toClassIdPair(nextCoachingSession);
////						String coachingSessionStateID = nextCoachingSession.getCoachingSessionState().getID();
////
////						accessManager.addWatcherField(coachingSessionPair, "coachingSessionState", fieldsToWatch);
////						if (coachingSessionStateID.equals("2") || coachingSessionStateID.equals("9")) {
////							submittedStateCount++;
////						}
////					}
////				}
//
//			}
//
//			// Register all the fields to watch for this ChangeWatcher. Whenever
//			// ANY of these fields change, this ChangeWatcher will get re-run
//			accessManager.updateWatcherFields(pair, "submittedStateCount", fieldsToWatch);
//
//			// Store the result for caching, and also for comparing new results to see if there has been a change.
//			accessManager.saveChangeWatcherResult(pair, "submittedStateCount", submittedStateCount);
//		} catch(Exception e) {
//			log.error("Unable to calculate submittedStateCount", e);
//		}

		return submittedStateCount;
	}


}
