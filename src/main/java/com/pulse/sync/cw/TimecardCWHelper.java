package com.pulse.sync.cw;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.DateTimeComparator;
import org.joda.time.Days;
import org.springframework.stereotype.Component;

import com.percero.agents.sync.cw.DerivedValueChangeWatcherHelper;
import com.percero.agents.sync.vo.BaseDataObject;
import com.percero.agents.sync.vo.ClassIDPair;
import com.pulse.mo.Agent;
import com.pulse.mo.AgentScorecard;
import com.pulse.mo.Notification;
import com.pulse.mo.ShiftStatusNotification;
import com.pulse.mo.TeamLeader;
import com.pulse.mo.Timecard;

@Component
public class TimecardCWHelper extends DerivedValueChangeWatcherHelper {

	private static final Logger log = Logger.getLogger(TimecardCWHelper.class);

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

		if (fieldName.equalsIgnoreCase("shiftStatusNotification")) {
			try {
				result = calc_shiftStatusNotification(pair);
				postCalculate(fieldName, pair, params, result, oldValue);
			} catch(Exception e) {
				log.error("Unable to calculate shiftStatusNotification", e);
			}
		}
		else {
			result = super.calculate(fieldName, pair, params);
		}

		return result;
	}

	public ClassIDPair calc_shiftStatusNotification(ClassIDPair pair) {
		ClassIDPair result = null;

//		try {
//			Timecard host = (Timecard) syncAgentService.systemGetById(pair);
//			if (host == null) {
//				log.warn("Unable to calculate shiftStatusNotification: Invalid objectId");
//				return result;
//			}
//
//			// Setup fieldsToWatch.
//			Collection<String> fieldsToWatch = new HashSet<String>();
//
//			// We want to re-trigger this change watcher when Timecard.date changes.
//			accessManager.addWatcherField(pair, "date", fieldsToWatch);
//			// We want to re-trigger this change watcher when Timecard.endDate changes.
//			accessManager.addWatcherField(pair, "endDate", fieldsToWatch);
//
//			DateTime timecardDateTime = new DateTime(host.getDate());
//			DateTime timecardEndDateTime = new DateTime(host.getEndDate());
//			int daysBetweem = Math.abs(Days.daysBetween(timecardDateTime, timecardEndDateTime).getDays());
//
//			// If the Timecard.date < 3 days old
//			if ( daysBetweem < 3) {
//				// Re-trigger this change watcher when AgentScorecard.agent changes.
//				accessManager.addWatcherField(pair, "agent", fieldsToWatch);
//
//				// Check to see if there is already a coaching notification created.
//				Agent agent = syncAgentService.systemGetByObject(host.getAgent());
//				if (agent != null) {
//					// Re-trigger this change watcher when Agent.teamLeader changes.
//					accessManager.addWatcherField(BaseDataObject.toClassIdPair(agent), "teamLeader", fieldsToWatch);
//					TeamLeader teamLeader = syncAgentService.systemGetByObject(agent.getTeamLeader());
//					if (teamLeader != null) {
//						ShiftStatusNotification existingShiftStatusNotification = null;
//
//						// Re-trigger this change watcher when TeamLeader.notifications changes.
//						accessManager.addWatcherField(BaseDataObject.toClassIdPair(teamLeader), "notifications", fieldsToWatch);
//						Iterator<Notification> itrNotifications = teamLeader.getNotifications().iterator();
//						while (itrNotifications.hasNext()) {
//							Notification nextNotification = itrNotifications.next();
//							if (nextNotification != null && nextNotification instanceof ShiftStatusNotification) {
//								ShiftStatusNotification nextShiftStatusNotification = (ShiftStatusNotification) syncAgentService.systemGetByObject(nextNotification);
//
//								if (nextShiftStatusNotification == null) {
//									continue;
//								}
//
//								// Re-trigger this change watcher when ShiftStatusNotification.shiftEndDate changes.
//								accessManager.addWatcherField(BaseDataObject.toClassIdPair(nextShiftStatusNotification), "shiftEndDate", fieldsToWatch);
//
//								DateTime nextShiftStatusNotificationWeekDate = new DateTime(nextShiftStatusNotification.getShiftEndDate());
//								// If AgentScorecard.weekDate == ShiftStatusNotification.weekDate, we found a match.
//								if (DateTimeComparator.getDateOnlyInstance().compare(timecardDateTime, nextShiftStatusNotificationWeekDate) == 0) {
//									existingShiftStatusNotification = nextShiftStatusNotification;
//									break;
//								}
//							}
//						}
//
//						if (existingShiftStatusNotification == null) {
//							existingShiftStatusNotification = new ShiftStatusNotification();
//							existingShiftStatusNotification.setID(UUID.randomUUID().toString());
//							existingShiftStatusNotification.setCreatedOn(new Date());
//							existingShiftStatusNotification.setName("Shift Status");
//							existingShiftStatusNotification.setType("ShiftStatusNotification");
//							existingShiftStatusNotification.setTeamLeader(teamLeader);
//							existingShiftStatusNotification.setShiftEndDate(host.getEndDate());
////							existingShiftStatusNotification.setTimecardActivity(value)
//							existingShiftStatusNotification = syncAgentService.systemCreateObject(existingShiftStatusNotification, null);
//						}
//
////							// Re-trigger this ChangeWatcher if Timecard.timecardEntries changes.
////							accessManager.addWatcherField(pair, "timecardEntries", fieldsToWatch);
////							// Re-trigger this ChangeWatcher if Timecard.timecardState changes.
////							accessManager.addWatcherField(pair, "timecardState", fieldsToWatch);
////
////							if (host.getTimecardEntries().size() <=0 ){
////								existingShiftStatusNotification.setNotYetStartedStateCount(existingShiftStatusNotification.getNotYetStartedStateCount() + 1);
////							}
////							else if (host.getTimecardState().equals("Approved")) {
////								existingShiftStatusNotification.setApprovedStateCount(existingShiftStatusNotification.getApprovedStateCount() + 1);
////							}
////							else if (host.getTimecardState().equals("Completed")){
////								existingShiftStatusNotification.setCompleteStateCount(existingShiftStatusNotification.getCompleteStateCount() + 1);
////							}
////							else{
////								existingShiftStatusNotification.setInProgressStateCount(existingShiftStatusNotification.getInProgressStateCount());
////							}
////
////							// Save the ExistingShiftStatusNotification.
////							syncAgentService.systemPutObject(existingShiftStatusNotification, null, null, null, true);
//
//						result = BaseDataObject.toClassIdPair(existingShiftStatusNotification);
//					}
//				}
//			}
//
//			// Register all the fields to watch for this ChangeWatcher. Whenever
//			// ANY of these fields change, this ChangeWatcher will get re-run
//			accessManager.updateWatcherFields(pair, "shiftStatusNotification", fieldsToWatch);
//
//			// Store the result for caching, and also for comparing new results to see if there has been a change.
//			accessManager.saveChangeWatcherResult(pair, "shiftStatusNotification", result);
//		} catch(Exception e) {
//			log.error("Unable to calculate shiftStatusNotification", e);
//		}

		return result;
	}


}
