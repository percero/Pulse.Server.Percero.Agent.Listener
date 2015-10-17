package com.pulse.sync.cw;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.DateTimeComparator;
import org.joda.time.Days;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.percero.agents.sync.cw.ChangeWatcherHelper;
import com.percero.agents.sync.cw.ChangeWatcherHelperFactory;
import com.percero.agents.sync.services.ISyncAgentService;
import com.percero.agents.sync.vo.ClassIDPair;
import com.percero.framework.vo.IPerceroObject;
import com.pulse.mo.Agent;
import com.pulse.mo.AgentScorecard;
import com.pulse.mo.CMSEntry;
import com.pulse.mo.CoachingNotification;
import com.pulse.mo.Notification;
import com.pulse.mo.TeamLeader;
import com.pulse.mo.ThresholdExceededNotification;

// This should get picked up by Spring and be auto-wired.
@Component
public class CoachingNotificationCWHelper extends ChangeWatcherHelper {

	private static final Logger log = Logger.getLogger(CoachingNotificationCWHelper.class);

	// This is required for CUSTOM change watchers.
	private static final String CATEGORY = "CUSTOM";
	// This is an optional sub category.
	private static final String SUB_CATEGORY = "";
	
	@Autowired
	protected ISyncAgentService syncAgentService;
	public void setSyncAgentService(ISyncAgentService value) {
		syncAgentService = value;
	}
	public ISyncAgentService getSyncAgentService() {
		return syncAgentService;
	}

	@PostConstruct
	public void initialize() {
		ChangeWatcherHelperFactory.getInstance().registerChangeWatcherHelper(CATEGORY, this);
		registerChangeWatchers();
	}
	
	/**
	 * Registers the Objects that this Change Watcher cares about. To register
	 * for all objects of a particular type, use the ID "0".
	 */
	public void registerChangeWatchers() {
		Collection<String> fieldsToWatch = new HashSet<String>();
		// Listen for changes on ALL AgentScorecard records.
		accessManager.addWatcherField(new ClassIDPair("0", AgentScorecard.class.getCanonicalName()), "", fieldsToWatch);

		// Register the fields. This can always be called again with an updated
		// list of fields to watch, which would overwrite the list of fields
		// that trigger this change watcher code.
		accessManager.updateWatcherFields(CATEGORY, SUB_CATEGORY, "agentScorecard", fieldsToWatch);
	}

	/* (non-Javadoc)
	 * @see com.percero.agents.sync.cw.ChangeWatcherHelper#process(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void process(String category, String subCategory, String fieldName) {
		process(category, subCategory, fieldName, null);
	}
	
	/* (non-Javadoc)
	 * @see com.percero.agents.sync.cw.ChangeWatcherHelper#process(java.lang.String, java.lang.String, java.lang.String, java.lang.String[])
	 */
	@Override
	public void process(String category, String subCategory, String fieldName, String[] params) {
		if (fieldName.equalsIgnoreCase("agentScorecard")) {
			try {
				handleNewAgentScorecard(category, subCategory, fieldName, params);
			} catch(Exception e) {
				log.error("Unable to process handleNewAgentScorecard", e);
			}
		}
		else {
			super.process(category, subCategory, fieldName, params);
		}
	}
	
	/**
	 * 
	 * @param category
	 * @param subCategory
	 * @param fieldName
	 * @throws Exception
	 */
	private void handleNewAgentScorecard(String category, String subCategory, String fieldName, String[] params) throws Exception {
		// This is where the logic would go to create a Notification based on when the data requested above changes.
		try {
			
			if (params != null && params.length >= 2) {
				String className = params[0];
				String classId = params[1];
				
				ClassIDPair classIdPair = new ClassIDPair(classId, className);
				IPerceroObject updatedObject = syncAgentService.systemGetById(classIdPair);
				
				if (updatedObject instanceof AgentScorecard) {
					AgentScorecard agentScorecard = (AgentScorecard) updatedObject;
					
					if (agentScorecard != null) {
						Date currentDate = new Date();
						DateTime currentDateTime = new DateTime(currentDate);
						DateTime scorecardDateTime = new DateTime(agentScorecard.getWeekDate());
						int daysBetweem = Math.abs(Days.daysBetween(scorecardDateTime, currentDateTime).getDays());
						
						// If agentScorecard < 4 weeks old
						if ( daysBetweem < 7 * 4) {
							// Check to see if there is already a coaching notification created.
							Agent agent = syncAgentService.systemGetByObject(agentScorecard.getAgent());
							if (agent == null) return;
							
							TeamLeader teamLeader = syncAgentService.systemGetByObject(agent.getTeamLeader());
							if (teamLeader == null) {
								return;
							}
							
							CoachingNotification existingCoachingNotification = null;
							Iterator<Notification> itrNotifications = teamLeader.getNotifications().iterator();
							while (itrNotifications.hasNext()) {
								Notification nextNotification = itrNotifications.next();
								if (nextNotification != null && nextNotification instanceof CoachingNotification) {
									CoachingNotification nextCoachingNotification = (CoachingNotification) syncAgentService.systemGetByObject(nextNotification);
									
									if (nextCoachingNotification == null) {
										continue;
									}
									
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
								existingCoachingNotification.setDate(new Date());
								existingCoachingNotification.setName("Available for Coaching");
								existingCoachingNotification.setType("CoachingNotification");
								existingCoachingNotification.setTeamLeader(teamLeader);
								existingCoachingNotification.setWeekDate(agentScorecard.getWeekDate());
								existingCoachingNotification = syncAgentService.systemCreateObject(existingCoachingNotification, null);
							}
							
//							agentScorecard.setCoachingNotification(existingCoachingNotification);
							syncAgentService.systemPutObject(agentScorecard, null, null, null, true);
						}
					}
				}
			}
		} catch(Exception e) {
			// Handle any exception here.
		}
	}
	
	
	
	

}
