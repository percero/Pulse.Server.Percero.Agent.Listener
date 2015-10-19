package com.pulse.sync.cw;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.UUID;

import com.pulse.mo.*;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.DateTimeComparator;
import org.joda.time.Days;
import org.springframework.stereotype.Component;

import com.percero.agents.sync.cw.DerivedValueChangeWatcherHelper;
import com.percero.agents.sync.vo.BaseDataObject;
import com.percero.agents.sync.vo.ClassIDPair;

@Component
public class AgentScorecardCWHelper extends DerivedValueChangeWatcherHelper {

	private static final Logger log = Logger.getLogger(AgentScorecardCWHelper.class);

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
		
		if (fieldName.equalsIgnoreCase("coachingNotification")) {
			try {
				result = calc_coachingNotification(pair);
				postCalculate(fieldName, pair, params, result, oldValue);
			} catch(Exception e) {
				log.error("Unable to calculate coachingNotification", e);
			}
		}
		else {
			result = super.calculate(fieldName, pair, params);
		}
		
		return result;
	}
	
	public ClassIDPair calc_coachingNotification(ClassIDPair pair) {
		ClassIDPair result = null;

		try {
			AgentScorecard host = (AgentScorecard) syncAgentService.systemGetById(pair);
			if (host == null) {
				log.warn("Unable to calculate coachingNotification: Invalid objectId");
				return result;
			}
			
			// Setup fieldsToWatch.
			Collection<String> fieldsToWatch = new HashSet<String>();
			
			// We want to re-trigger this change watcher when AgentScorecard.weekDate changes.
			accessManager.addWatcherField(pair, "weekDate", fieldsToWatch);
			
			if (host != null) {
				log.debug("[CoachingNotification]");
				Date currentDate = new Date();
				DateTime currentDateTime = new DateTime(currentDate);
				DateTime scorecardDateTime = new DateTime(host.getWeekDate());
				int daysBetween = Math.abs(Days.daysBetween(scorecardDateTime, currentDateTime).getDays());
				
				// If agentScorecard < 4 weeks old
				log.debug("[CoachingNotification]  daysBetween" + daysBetween);
				if ( daysBetween < 7 * 4) {
					// Re-trigger this change watcher when AgentScorecard.agent changes.
					accessManager.addWatcherField(pair, "agent", fieldsToWatch);

					// Check to see if there is already a coaching notification created.
					Agent agent = syncAgentService.systemGetByObject(host.getAgent());
					if (agent != null) {
						// Re-trigger this change watcher when Agent.teamLeader changes.
						accessManager.addWatcherField(BaseDataObject.toClassIdPair(agent), "teamLeader", fieldsToWatch);
						TeamLeader teamLeader = syncAgentService.systemGetByObject(agent.getTeamLeader());
						if (teamLeader != null) {
							CoachingNotification existingCoachingNotification = null;

							// Re-trigger this change watcher when TeamLeader.notifications changes.
							accessManager.addWatcherField(BaseDataObject.toClassIdPair(teamLeader), "notifications", fieldsToWatch);
							Iterator<Notification> itrNotifications = teamLeader.getNotifications().iterator();
							while (itrNotifications.hasNext()) {
								Notification nextNotification = itrNotifications.next();
								if (nextNotification != null && nextNotification instanceof CoachingNotification) {
									CoachingNotification nextCoachingNotification = (CoachingNotification) syncAgentService.systemGetByObject(nextNotification);
									
									if (nextCoachingNotification == null) {
										continue;
									}
									
									// Re-trigger this change watcher when CoachingNotification.weekDate changes.
									accessManager.addWatcherField(BaseDataObject.toClassIdPair(nextCoachingNotification), "weekDate", fieldsToWatch);

									DateTime nextCoachingNotificationWeekDate = new DateTime(nextCoachingNotification.getWeekDate());
									log.debug("[CoachingNotification]  CoachingNotification id - " + nextCoachingNotification.getID());
									log.debug("[CoachingNotification]  nextCoachingNotificationWeekDate" + nextCoachingNotificationWeekDate);
									log.debug("[CoachingNotification]  AgentScoreCard DateTime" + scorecardDateTime);
									log.debug("[CoachingNotification]  AgentScoreCard id" + host.getID());
									// If AgentScorecard.weekDate == CoachingNotification.weekDate, we found a match.
									if (DateTimeComparator.getDateOnlyInstance().compare(scorecardDateTime, nextCoachingNotificationWeekDate) == 0) {
										existingCoachingNotification = nextCoachingNotification;
										break;
									}
								}
							}
							
							if (existingCoachingNotification == null) {
								existingCoachingNotification = new CoachingNotification();
								existingCoachingNotification.setID(UUID.randomUUID().toString());
								existingCoachingNotification.setCreatedOn(new Date());
								existingCoachingNotification.setName("Available for Coaching");
								existingCoachingNotification.setType("CoachingNotification");
								existingCoachingNotification.setTeamLeader(teamLeader);
								existingCoachingNotification.setWeekDate(host.getWeekDate());
								existingCoachingNotification = syncAgentService.systemCreateObject(existingCoachingNotification, null);
							}

							Integer pendingStateCount 			= null;
							Integer submittedStateCount			= null;
							Integer pendingCoachStateCount		= null;
							Integer pendingEmployeeStateCount	= null;
							Integer acknowledgementStateCount	= null;
							Integer skippedStateCount			= null;

							Iterator<CoachingSession> itrCoachingSession  = host.getCoachingSessions().iterator();

							while (itrCoachingSession.hasNext()) {
								CoachingSession nextCoachingSession = itrCoachingSession.next();
								if (nextCoachingSession != null && nextCoachingSession instanceof CoachingSession) {
									String coachingSessionStateID = nextCoachingSession.getCoachingSessionState().getID();

									if (coachingSessionStateID.equals("1") || coachingSessionStateID.equals("8")) {
										pendingStateCount =  existingCoachingNotification.getPendingStateCount();
										if (pendingStateCount == null) {
											pendingStateCount = 0;
										}
										existingCoachingNotification.setPendingStateCount(pendingStateCount + 1);
									} else if (coachingSessionStateID.equals("2") || coachingSessionStateID.equals("9")) {
										submittedStateCount = existingCoachingNotification.getSubmittedStateCount();
										if (submittedStateCount == null) {
											submittedStateCount = 0;
										}
										existingCoachingNotification.setSubmittedStateCount(submittedStateCount + 1);
									} else if (coachingSessionStateID.equals("5") || coachingSessionStateID.equals("11")) {
										pendingCoachStateCount =  existingCoachingNotification.getPendingCoachStateCount();
										if (pendingCoachStateCount == null) {
											pendingCoachStateCount = 0;
										}
										existingCoachingNotification.setPendingCoachStateCount(pendingCoachStateCount + 1);
									} else if (coachingSessionStateID.equals("3") || coachingSessionStateID.equals("10")) {
										pendingEmployeeStateCount = existingCoachingNotification.getPendingEmployeeStateCount();
										if (pendingEmployeeStateCount == null) {
											pendingEmployeeStateCount = 0;
										}
										existingCoachingNotification.setPendingEmployeeStateCount(pendingEmployeeStateCount + 1);

									} else if (coachingSessionStateID.equals("4") || coachingSessionStateID.equals("6")) {
										acknowledgementStateCount = existingCoachingNotification.getAcknowledgementStateCount();
										if (acknowledgementStateCount == null) {
											acknowledgementStateCount = 0;
										}
										existingCoachingNotification.setAcknowledgementStateCount(acknowledgementStateCount + 1);
									} else if (coachingSessionStateID.equals("7")) {
										skippedStateCount = existingCoachingNotification.getSkippedStateCount();
										if (skippedStateCount == null) {
											skippedStateCount = 0;
										}
										existingCoachingNotification.setSkippedStateCount(skippedStateCount + 1);
									}
								}
							}

							// Save the ExistingCoachingNotification.
							syncAgentService.systemPutObject(existingCoachingNotification, null, null, null, true);

							result = BaseDataObject.toClassIdPair(existingCoachingNotification);
						}
					}
				}
			}
			
			// Register all the fields to watch for this ChangeWatcher. Whenever
			// ANY of these fields change, this ChangeWatcher will get re-run
			accessManager.updateWatcherFields(pair, "coachingNotification", fieldsToWatch);
			
			// Store the result for caching, and also for comparing new results to see if there has been a change.
			accessManager.saveChangeWatcherResult(pair, "coachingNotification", result);
		} catch(Exception e) {
			log.error("Unable to calculate coachingNotification", e);
		}
		
		return result;
	}


}
