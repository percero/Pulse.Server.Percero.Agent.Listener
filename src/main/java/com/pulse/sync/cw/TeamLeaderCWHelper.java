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
import org.joda.time.LocalDate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.percero.agents.sync.cw.DerivedValueChangeWatcherHelper;
import com.percero.agents.sync.vo.BaseDataObject;
import com.percero.agents.sync.vo.ClassIDPair;
import com.pulse.mo.Agent;
import com.pulse.mo.AgentScorecard;
import com.pulse.mo.AgentTimeZone;
import com.pulse.mo.CMSEntry;
import com.pulse.mo.CoachingNotification;
import com.pulse.mo.LOBConfigurationNotification;
import com.pulse.mo.Notification;
import com.pulse.mo.Scorecard;
import com.pulse.mo.ShiftStatusNotification;
import com.pulse.mo.TeamLeader;

@Component
public class TeamLeaderCWHelper extends DerivedValueChangeWatcherHelper {

    private static final Logger log = Logger.getLogger(TeamLeaderCWHelper.class);

    @Override
    public Object calculate(String fieldName, ClassIDPair pair) {
        return calculate(fieldName, pair, null);
    }

    public static final String SCORECARDS = "scorecards";
    public static final String TIMEZONE = "timeZone";
    public static final String AGENT_SCORECARDS = "agentScorecards";
    public static final String NOTIFICATIONS_UNREADS = "notificationsUnReads";
    public static final String NOTIFICATIONS_COACHINGS = "notificationsCoachings";
    public static final String NOTIFICATIONS_SHIFTSTATUS = "notificationsShiftStatus";
    public static final String NOTIFICATIONS_TIME_DISCREPANCIES = "notificationsTimeDiscrepancies";
    public static final String FIND_CMS_ENTRIES_FOR_DATE = "findCMSEntriesForDate";

    @Override
    public Object calculate(String fieldName, ClassIDPair pair, String[] params) {
        Object result = null;
        Object oldValue = null;
        try {
            oldValue = accessManager.getChangeWatcherResult(pair, fieldName, params);
        } catch (Exception e) {
        }

        if (SCORECARDS.equalsIgnoreCase(fieldName)) {
            try {
                result = calc_scorecards(pair, SCORECARDS);
                postCalculate(fieldName, pair, params, result, oldValue);
            } catch (Exception e) {
                log.error("Unable to calculate " + SCORECARDS, e);
            }
        } else if (AGENT_SCORECARDS.equalsIgnoreCase(fieldName)) {
            try {
                result = calc_agentScorecards(pair, AGENT_SCORECARDS);
                postCalculate(fieldName, pair, params, result, oldValue);
            } catch (Exception e) {
                log.error("Unable to calculate " + AGENT_SCORECARDS, e);
            }
        } else if (TIMEZONE.equalsIgnoreCase(fieldName)) {
            try {
                result = calc_timeZone(pair, TIMEZONE);
                postCalculate(fieldName, pair, params, result, oldValue);
            } catch (Exception e) {
                log.error("Unable to calculate " + TIMEZONE, e);
            }
        } else if (NOTIFICATIONS_UNREADS.equalsIgnoreCase(fieldName)) {
            try {
                result = calc_notificationsUnReads(pair, NOTIFICATIONS_UNREADS);
                postCalculate(fieldName, pair, params, result, oldValue);
            } catch (Exception e) {
                log.error("Unable to calculate " + NOTIFICATIONS_UNREADS, e);
            }
        } else if (NOTIFICATIONS_COACHINGS.equalsIgnoreCase(fieldName)) {
            try {
                result = calc_notificationsCoachings(pair, NOTIFICATIONS_COACHINGS);
                postCalculate(fieldName, pair, params, result, oldValue);
            } catch (Exception e) {
                log.error("Unable to calculate " + NOTIFICATIONS_COACHINGS, e);
            }
        }
        else if (NOTIFICATIONS_SHIFTSTATUS.equalsIgnoreCase(fieldName)) {
            try {
                result = calc_notificationsShiftStatus(pair, NOTIFICATIONS_SHIFTSTATUS);
                postCalculate(fieldName, pair, params, result, oldValue);
            } catch (Exception e) {
                log.error("Unable to calculate " + NOTIFICATIONS_SHIFTSTATUS, e);
            }
        }
        else if (NOTIFICATIONS_TIME_DISCREPANCIES.equalsIgnoreCase(fieldName)) {
            try {
                result = calc_notificationsTimeDiscrepancies(pair, NOTIFICATIONS_TIME_DISCREPANCIES);
                postCalculate(fieldName, pair, params, result, oldValue);
            } catch (Exception e) {
                log.error("Unable to calculate " + NOTIFICATIONS_TIME_DISCREPANCIES, e);
            }
        }
        else if (FIND_CMS_ENTRIES_FOR_DATE.equalsIgnoreCase(fieldName)) {
        	try {
        		result = calc_findCMSEntriesForDate(pair, FIND_CMS_ENTRIES_FOR_DATE, params[0]);
        		postCalculate(fieldName, pair, params, result, oldValue);
        	} catch (Exception e) {
        		log.error("Unable to calculate " + FIND_CMS_ENTRIES_FOR_DATE, e);
        	}
        } else {
            result = super.calculate(fieldName, pair, params);
        }

        return result;
    }


    private List<ClassIDPair> calc_agentScorecards(ClassIDPair pair, String derivedValueName) {
        List<ClassIDPair> results = new ArrayList<ClassIDPair>();

        try {
            TeamLeader host = (TeamLeader) syncAgentService.systemGetById(pair);
            if (host == null) {
                log.warn("Unable to calculate " + derivedValueName + ": Invalid objectId " + pair.getClassName() + "::" + pair.getID());
                return results;
            }

            Set<String> agentScorecardIds = new HashSet<String>();

            // Setup fieldsToWatch.
            Collection<String> fieldsToWatch = new HashSet<String>();

            // We want to re-trigger this change watcher when TeamLeader.Agents changes.
            accessManager.addWatcherField(pair, "agents", fieldsToWatch);
            Iterator<Agent> itrAgents = host.getAgents().iterator();
            while (itrAgents.hasNext()) {
                Agent agent = syncAgentService.systemGetByObject(itrAgents.next());
                if (agent != null) {
                    // We want to re-trigger this change watcher when Agent.AgentScorecards changes.
                    accessManager.addWatcherField(BaseDataObject.toClassIdPair(agent), "agentScorecards", fieldsToWatch);
                    Iterator<AgentScorecard> itrAgentScorecards = agent.getAgentScorecards().iterator();
                    while (itrAgentScorecards.hasNext()) {
                        // Since we only return a list of ClassIDPair's AND we are not doing any sorting, we only need to retrieve the ID here.
                        AgentScorecard agentScorecard = itrAgentScorecards.next();

                        if (agentScorecard != null && StringUtils.hasText(agentScorecard.getID())) {
                            agentScorecardIds.add(agentScorecard.getID());
                        }
                    }
                }
            }

            Iterator<String> itrAgentScorecardIds = agentScorecardIds.iterator();
            while (itrAgentScorecardIds.hasNext()) {
                String nextResult = itrAgentScorecardIds.next();
                results.add(new ClassIDPair(nextResult, AgentScorecard.class.getCanonicalName()));
            }

            // Register all the fields to watch for this ChangeWatcher. Whenever
            // ANY of these fields change, this ChangeWatcher will get re-run
            accessManager.updateWatcherFields(pair, derivedValueName, fieldsToWatch);

            // Store the result for caching, and also for comparing new results to see if there has been a change.
            accessManager.saveChangeWatcherResult(pair, derivedValueName, results);
        } catch (Exception e) {
            log.error("Unable to calculate " + derivedValueName, e);
        }

        return results;
    }

    private List<ClassIDPair> calc_scorecards(ClassIDPair pair, String derivedValueName) {
        List<ClassIDPair> results = new ArrayList<ClassIDPair>();

        try {
            TeamLeader host = (TeamLeader) syncAgentService.systemGetById(pair);
            if (host == null) {
                log.warn("Unable to calculate " + derivedValueName + ": Invalid objectId " + pair.getClassName() + "::" + pair.getID());
                return results;
            }

            Set<String> scorecardIds = new HashSet<String>();

            // Setup fieldsToWatch.
            Collection<String> fieldsToWatch = new HashSet<String>();

            // We want to re-trigger this change watcher when
            // TeamLeader.AgentScorecards changes.
            // NOTE: Since TeamLeader.AgentScorecards is a Derived Collection,
            // we know that it's objects have already been fully retrieved from
            // the database (ie. they are NOT "shell" objects)
            accessManager.addWatcherField(pair, "agentScorecards", fieldsToWatch);
            Iterator<AgentScorecard> itrAgentScorecards = host.getAgentScorecards().iterator();
            while (itrAgentScorecards.hasNext()) {
                AgentScorecard agentScorecard = itrAgentScorecards.next();
                if (agentScorecard != null) {
                    // We want to re-trigger this change watcher when AgentScorecard.Scorecard changes.
                    accessManager.addWatcherField(BaseDataObject.toClassIdPair(agentScorecard), "scorecard", fieldsToWatch);

                    // Since we only return ClassIDPair objects and don't do any
                    // sorting, we can just retrieve the "shell" object here,
                    // rather than loading the full thing from the database.
                    Scorecard scorecard = agentScorecard.getScorecard();

                    if (scorecard != null && StringUtils.hasText(scorecard.getID())) {
                        // Make sure the Scorecard has a valid id.
                        scorecardIds.add(scorecard.getID());
                    }
                }
            }

            Iterator<String> itrScorecardIds = scorecardIds.iterator();
            while (itrScorecardIds.hasNext()) {
                String nextResult = itrScorecardIds.next();
                results.add(new ClassIDPair(nextResult, Scorecard.class.getCanonicalName()));
            }

            // Register all the fields to watch for this ChangeWatcher. Whenever
            // ANY of these fields change, this ChangeWatcher will get re-run
            accessManager.updateWatcherFields(pair, derivedValueName, fieldsToWatch);

            // Store the result for caching, and also for comparing new results to see if there has been a change.
            accessManager.saveChangeWatcherResult(pair, derivedValueName, results);
        } catch (Exception e) {
            log.error("Unable to calculate " + derivedValueName, e);
        }

        return results;
    }

    private ClassIDPair calc_timeZone(ClassIDPair pair, String derivedValueName) {
        ClassIDPair result = null;

        try {
            TeamLeader host = (TeamLeader) syncAgentService.systemGetById(pair);
            if (host == null) {
                log.warn("Unable to calculate " + derivedValueName + ": Invalid objectId " + pair.getClassName() + "::" + pair.getID());
                return result;
            }

            // Setup fieldsToWatch.
            Collection<String> fieldsToWatch = new HashSet<String>();

            // We want to re-trigger this change watcher when TeamLeader.Agents changes.
            accessManager.addWatcherField(pair, "agents", fieldsToWatch);
            Iterator<Agent> itrAgents = host.getAgents().iterator();
            while (itrAgents.hasNext()) {
                Agent agent = syncAgentService.systemGetByObject(itrAgents.next());
                if (agent != null) {
                    // We want to re-trigger this change watcher when Agent.AgentScorecards changes.
                    accessManager.addWatcherField(BaseDataObject.toClassIdPair(agent), "agentTimeZone", fieldsToWatch);
                    AgentTimeZone agentTimeZone = agent.getAgentTimeZone();

                    if (agentTimeZone != null) {
                        result = BaseDataObject.toClassIdPair(agentTimeZone);
                        break;
                    }
                }
            }

            // Register all the fields to watch for this ChangeWatcher. Whenever
            // ANY of these fields change, this ChangeWatcher will get re-run
            accessManager.updateWatcherFields(pair, derivedValueName, fieldsToWatch);

            // Store the result for caching, and also for comparing new results to see if there has been a change.
            accessManager.saveChangeWatcherResult(pair, derivedValueName, result);
        } catch (Exception e) {
            log.error("Unable to calculate " + derivedValueName, e);
        }

        return result;
    }

    private List<ClassIDPair> calc_notificationsUnReads(ClassIDPair pair, String derivedValueName) {
        List<ClassIDPair> results = new ArrayList<ClassIDPair>();

        try {
            TeamLeader host = (TeamLeader) syncAgentService.systemGetById(pair);
            if (host == null) {
                log.warn("Unable to calculate " + derivedValueName + ": Invalid objectId " + pair.getClassName() + "::" + pair.getID());
                return results;
            }

//			List<Notification> notifications  = new ArrayList<Notification>();

            // Setup fieldsToWatch.
            Collection<String> fieldsToWatch = new HashSet<String>();

            // We want to re-trigger this change watcher when TeamLeader.Agents changes.
            accessManager.addWatcherField(pair, "notifications", fieldsToWatch);
            Iterator<Notification> itrNotifications = host.getNotifications().iterator();
            while (itrNotifications.hasNext()) {
                Notification notification = syncAgentService.systemGetByObject(itrNotifications.next());
                if (notification != null) {
                    // We want to re-trigger this change watcher when Agent.AgentScorecards changes.
                    accessManager.addWatcherField(BaseDataObject.toClassIdPair(notification), "isRead", fieldsToWatch);
                    if (notification.getIsRead() == null || notification.getIsRead().equals(Boolean.FALSE)) {
//						notifications.add(notification);
                        results.add(new ClassIDPair(notification.getID(), notification.getClass().getCanonicalName()));
                    }

                }
            }

//			Iterator<Notification> itrNotifications = notifications.iterator();
//			while (itrNotifications.hasNext()) {
//				String nextResult = itrNotifications.next().getID();
//				results.add(new ClassIDPair(nextResult, ));
//			}

            // Register all the fields to watch for this ChangeWatcher. Whenever
            // ANY of these fields change, this ChangeWatcher will get re-run
            accessManager.updateWatcherFields(pair, derivedValueName, fieldsToWatch);

            // Store the result for caching, and also for comparing new results to see if there has been a change.
            accessManager.saveChangeWatcherResult(pair, derivedValueName, results);
        } catch (Exception e) {
            log.error("Unable to calculate " + derivedValueName, e);
        }

        return results;
    }


    private List<ClassIDPair> calc_notificationsCoachings(ClassIDPair pair, String derivedValueName) {
        List<ClassIDPair> results = new ArrayList<ClassIDPair>();

        try {
            TeamLeader host = (TeamLeader) syncAgentService.systemGetById(pair);
            if (host == null) {
                log.warn("Unable to calculate " + derivedValueName + ": Invalid objectId " + pair.getClassName() + "::" + pair.getID());
                return results;
            }


            // Setup fieldsToWatch.
            Collection<String> fieldsToWatch = new HashSet<String>();

            // We want to re-trigger this change watcher when TeamLeader.Agents changes.
            accessManager.addWatcherField(pair, "notifications", fieldsToWatch);
            Iterator<Notification> itrNotifications = host.getNotifications().iterator();
            while (itrNotifications.hasNext()) {
                Notification notification = syncAgentService.systemGetByObject(itrNotifications.next());
                if (notification != null) {
                    // We want to re-trigger this change watcher when Agent.AgentScorecards changes.
                    if (notification instanceof CoachingNotification) {
                        results.add(new ClassIDPair(notification.getID(), notification.getClass().getCanonicalName()));
                    }
                }
            }

            // Register all the fields to watch for this ChangeWatcher. Whenever
            // ANY of these fields change, this ChangeWatcher will get re-run
            accessManager.updateWatcherFields(pair, derivedValueName, fieldsToWatch);

            // Store the result for caching, and also for comparing new results to see if there has been a change.
            accessManager.saveChangeWatcherResult(pair, derivedValueName, results);
        } catch (Exception e) {
            log.error("Unable to calculate " + derivedValueName, e);
        }

        return results;
    }

    private List<ClassIDPair> calc_notificationsShiftStatus(ClassIDPair pair, String derivedValueName) {
        List<ClassIDPair> results = new ArrayList<ClassIDPair>();

        try {
            TeamLeader host = (TeamLeader) syncAgentService.systemGetById(pair);
            if (host == null) {
                log.warn("Unable to calculate " + derivedValueName + ": Invalid objectId " + pair.getClassName() + "::" + pair.getID());
                return results;
            }


            // Setup fieldsToWatch.
            Collection<String> fieldsToWatch = new HashSet<String>();

            // We want to re-trigger this change watcher when TeamLeader.Agents changes.
            accessManager.addWatcherField(pair, "notifications", fieldsToWatch);
            Iterator<Notification> itrNotifications = host.getNotifications().iterator();
            while (itrNotifications.hasNext()) {
                Notification notification = syncAgentService.systemGetByObject(itrNotifications.next());
                if (notification != null) {
                    // We want to re-trigger this change watcher when Agent.AgentScorecards changes.
                    if (notification instanceof ShiftStatusNotification) {
                        results.add(new ClassIDPair(notification.getID(), notification.getClass().getCanonicalName()));
                    }
                }
            }

            // Register all the fields to watch for this ChangeWatcher. Whenever
            // ANY of these fields change, this ChangeWatcher will get re-run
            accessManager.updateWatcherFields(pair, derivedValueName, fieldsToWatch);

            // Store the result for caching, and also for comparing new results to see if there has been a change.
            accessManager.saveChangeWatcherResult(pair, derivedValueName, results);
        } catch (Exception e) {
            log.error("Unable to calculate " + derivedValueName, e);
        }

        return results;
    }
    private List<ClassIDPair> calc_notificationsTimeDiscrepancies(ClassIDPair pair, String derivedValueName) {
        List<ClassIDPair> results = new ArrayList<ClassIDPair>();

        try {
            TeamLeader host = (TeamLeader) syncAgentService.systemGetById(pair);
            if (host == null) {
                log.warn("Unable to calculate " + derivedValueName + ": Invalid objectId " + pair.getClassName() + "::" + pair.getID());
                return results;
            }

//			List<Notification> notifications  = new ArrayList<Notification>();

            // Setup fieldsToWatch.
            Collection<String> fieldsToWatch = new HashSet<String>();

            // We want to re-trigger this change watcher when TeamLeader.Agents changes.
            accessManager.addWatcherField(pair, "notifications", fieldsToWatch);
            Iterator<Notification> itrNotifications = host.getNotifications().iterator();
            while (itrNotifications.hasNext()) {
                Notification notification = syncAgentService.systemGetByObject(itrNotifications.next());
                if (notification != null) {
                    // We want to re-trigger this change watcher when Agent.AgentScorecards changes.
                    accessManager.addWatcherField(BaseDataObject.toClassIdPair(notification), "isRead", fieldsToWatch);
                    if (notification.getIsRead() == null || notification.getIsRead().equals(Boolean.FALSE)) {
//						notifications.add(notification);
                        if (notification instanceof LOBConfigurationNotification) {
                            results.add(new ClassIDPair(notification.getID(), notification.getClass().getCanonicalName()));
                        }
                    }

                }
            }

//			Iterator<Notification> itrNotifications = notifications.iterator();
//			while (itrNotifications.hasNext()) {
//				String nextResult = itrNotifications.next().getID();
//				results.add(new ClassIDPair(nextResult, ));
//			}

            // Register all the fields to watch for this ChangeWatcher. Whenever
            // ANY of these fields change, this ChangeWatcher will get re-run
            accessManager.updateWatcherFields(pair, derivedValueName, fieldsToWatch);

            // Store the result for caching, and also for comparing new results to see if there has been a change.
            accessManager.saveChangeWatcherResult(pair, derivedValueName, results);
        } catch (Exception e) {
            log.error("Unable to calculate " + derivedValueName, e);
        }

        return results;
    }

    private List<ClassIDPair> calc_findCMSEntriesForDate(ClassIDPair pair, String derivedValueName, String theDate) {
    	List<ClassIDPair> results = new ArrayList<ClassIDPair>();
    	
    	try {
    		TeamLeader host = (TeamLeader) syncAgentService.systemGetById(pair);
    		if (host == null) {
    			log.warn("Unable to calculate " + derivedValueName + ": Invalid objectId " + pair.getClassName() + "::" + pair.getID());
    			return results;
    		}
    		
			// Setup params array. If nothing else, this is used to uniquely
    		// identify this ChangeWatcher.
			String[] params = new String[1];
			params[0] = theDate;
			
			// Convert the date String. Since the date string format is completely up to
			// the developer, the build int `parseDateTime` function may or may not be
			// applicable. The point here is to accurately convert the passed in String
			// into a Date object (including its time zone).
			DateTime theDateTime = parseDateTime(theDate);
			LocalDate localDate = theDateTime.toLocalDate();
			
    		// Setup fieldsToWatch.
    		Collection<String> fieldsToWatch = new HashSet<String>();
    		
    		// We want to re-trigger this change watcher when TeamLeader.Agents changes.
    		accessManager.addWatcherField(pair, "agents", fieldsToWatch);
    		Iterator<Agent> itrAgents = host.getAgents().iterator();
    		while (itrAgents.hasNext()) {
    			Agent agent = syncAgentService.systemGetByObject(itrAgents.next());
    			if (agent != null) {
    				// We want to re-trigger this change watcher when Agent.CMSEntries changes.
    				accessManager.addWatcherField(BaseDataObject.toClassIdPair(agent), "cmsEntries", fieldsToWatch);
    				Iterator<CMSEntry> itrCmsEntries = agent.getCMSEntries().iterator();
    				while (itrCmsEntries.hasNext()) {
    					CMSEntry cmsEntry = syncAgentService.systemGetByObject(itrCmsEntries.next());
    					if (cmsEntry != null) {
    						// We want to re-trigger this change watcher when CMSEntry.FromTime changes.
    						accessManager.addWatcherField(BaseDataObject.toClassIdPair(cmsEntry), "fromTime", fieldsToWatch);
    						
    						Date fromTime = cmsEntry.getFromTime();
    						if (fromTime != null) {
    							// Convert the fromTime to the same time zone as the date that was passed in.
    							DateTime fromDateTime = new DateTime(fromTime);
    							fromDateTime = fromDateTime.withZone(theDateTime.getZone());
    							
    							// Check to see if fromTime is the same date as the passed in date.
								if (fromDateTime.toLocalDate().equals(localDate)) {
									// The date matched, so we add this CMSEntry to our set of results.
									results.add(new ClassIDPair(agent.getID(), agent.getClass().getCanonicalName()));
								}
    						}
    					}
    				}
    			}
    		}
    		
    		// Register all the fields to watch for this ChangeWatcher. Whenever
    		// ANY of these fields change, this ChangeWatcher will get re-run
    		// Don't forget to include the params array here, since that is part of what
    		// uniquely identifies this ChangeWatcher.
    		accessManager.updateWatcherFields(pair, derivedValueName, fieldsToWatch, params);
    		
    		// Store the result for caching, and also for comparing new results to see
    		// if there has been a change.
    		// Don't forget to include the params array here, since that is part of what
    		// uniquely identifies this ChangeWatcher.
    		accessManager.saveChangeWatcherResult(pair, derivedValueName, results, params);
    	} catch (Exception e) {
    		log.error("Unable to calculate " + derivedValueName, e);
    	}
    	
    	return results;
    }
    
}
