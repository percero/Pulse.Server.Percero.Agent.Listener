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
import com.pulse.mo.CoachingNotification;
import com.pulse.mo.Notification;
import com.pulse.mo.TeamLeader;

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
				Date currentDate = new Date();
				DateTime currentDateTime = new DateTime(currentDate);
				DateTime scorecardDateTime = new DateTime(host.getWeekDate());
				int daysBetweem = Math.abs(Days.daysBetween(scorecardDateTime, currentDateTime).getDays());
				
				// If agentScorecard < 4 weeks old
				if ( daysBetweem < 7 * 4 || true) {
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