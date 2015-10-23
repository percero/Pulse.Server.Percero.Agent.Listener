package com.pulse.sync.cw;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.DateTimeComparator;
import org.joda.time.Days;
import org.joda.time.Months;
import org.springframework.stereotype.Component;

import com.percero.agents.sync.cw.DerivedValueChangeWatcherHelper;
import com.percero.agents.sync.vo.BaseDataObject;
import com.percero.agents.sync.vo.ClassIDPair;
import com.pulse.mo.Agent;
import com.pulse.mo.AgentScorecard;
import com.pulse.mo.CoachingNotification;
import com.pulse.mo.Notification;
import com.pulse.mo.ScorecardMonthlyResult;
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
		
		if (fieldName.equalsIgnoreCase("scorecardMonthlyResults")) {
			try {
				result = calc_scorecardMonthlyResults(pair);
				postCalculate(fieldName, pair, params, result, oldValue);
			} catch(Exception e) {
				log.error("Unable to calculate scorecardMonthlyResults", e);
			}
		}
		else if (fieldName.equalsIgnoreCase("coachingNotification")) {
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
										log.debug("[CoachingNotification]  Existing CoachingNotification found: " + nextCoachingNotification.getID());
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
//								existingCoachingNotification.setAgentScorecard(host);
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
	
	public List<ClassIDPair> calc_scorecardMonthlyResults(ClassIDPair pair) {
		List<ClassIDPair> results = new ArrayList<ClassIDPair>();
		
		try {
			AgentScorecard host = (AgentScorecard) syncAgentService.systemGetById(pair);
			if (host == null) {
				log.warn("Unable to calculate scorecardMonthlyResults: Invalid objectId");
				return results;
			}
			
			// Setup fieldsToWatch.
			Collection<String> fieldsToWatch = new HashSet<String>();
			
			List<ScorecardMonthlyResult> scorecardMonthlyResults = new ArrayList<ScorecardMonthlyResult>();
			
			// We want to re-trigger this change watcher when AgentScorecard.weekDate changes.
			accessManager.addWatcherField(pair, "weekDate", fieldsToWatch);
			Date weekDate = host.getWeekDate();
			accessManager.addWatcherField(pair, "agent", fieldsToWatch);
			Agent agent = syncAgentService.systemGetByObject(host.getAgent());
			
			if (agent!= null && weekDate != null && weekDate.getTime() > 0) {
				DateTime weekDateTime = new DateTime(weekDate.getTime());
				
				accessManager.addWatcherField(BaseDataObject.toClassIdPair(agent), "scorecardMonthlyResults", fieldsToWatch);
				Iterator<ScorecardMonthlyResult> itrScorecardMonthlyResults = agent.getScorecardMonthlyResults().iterator();
				while (itrScorecardMonthlyResults.hasNext()) {
					ScorecardMonthlyResult scorecardMonthlyResult = syncAgentService.systemGetByObject(itrScorecardMonthlyResults.next());
					if (scorecardMonthlyResult != null) {
						accessManager.addWatcherField(BaseDataObject.toClassIdPair(scorecardMonthlyResult), "endDate", fieldsToWatch);
						Date endDate = scorecardMonthlyResult.getEndDate();
						if (endDate != null && endDate.getTime() > 0) {
							DateTime endDateTime = new DateTime(endDate.getTime());
							
							int monthsBetween = Months.monthsBetween(endDateTime, weekDateTime).getMonths();
							
							if (monthsBetween <= 5 && monthsBetween >= 0) {
								scorecardMonthlyResults.add(scorecardMonthlyResult);
							}
						}
					}
				}
			}
			
			Comparator<ScorecardMonthlyResult> cmp = new Comparator<ScorecardMonthlyResult>() {
				
				@Override
				public int compare(ScorecardMonthlyResult o1, ScorecardMonthlyResult o2) {
					if (o1 == null && o2 == null) {
						return 0;
					}
					else if (o1 == null) {
						return 1;
					}
					else if (o2 == null) {
						return -1;
					}
					else {
						Date endDate1 = o1.getEndDate();
						Date endDate2 = o2.getEndDate();
						
						if (endDate1 == null && endDate2 == null) {
							return 0;
						}
						else if (endDate1 == null) {
							return 1;
						}
						else if (endDate2 == null) {
							return -1;
						}
						else {
							return endDate1.compareTo(endDate2) * -1;
						}
					}
				}
			};
			
			Collections.sort(scorecardMonthlyResults, cmp);
			
			Iterator<ScorecardMonthlyResult> itrScorecardMonthlyResults = scorecardMonthlyResults.iterator();
			while (itrScorecardMonthlyResults.hasNext()) {
				ScorecardMonthlyResult nextResult = itrScorecardMonthlyResults.next();
				results.add(new ClassIDPair(nextResult.getID(), nextResult.getClass().getCanonicalName()));
			}

			// Register all the fields to watch for this ChangeWatcher. Whenever
			// ANY of these fields change, this ChangeWatcher will get re-run
			accessManager.updateWatcherFields(pair, "scorecardMonthlyResults", fieldsToWatch);
			
			// Store the result for caching, and also for comparing new results to see if there has been a change.
			accessManager.saveChangeWatcherResult(pair, "scorecardMonthlyResults", results);
		} catch(Exception e) {
			log.error("Unable to calculate scorecardMonthlyResults", e);
		}
		
		return results;
	}


}
