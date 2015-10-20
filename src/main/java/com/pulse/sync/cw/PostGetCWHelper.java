package com.pulse.sync.cw;

import java.util.Date;
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
import com.percero.agents.sync.exceptions.SyncException;
import com.percero.agents.sync.services.ISyncAgentService;
import com.percero.agents.sync.vo.ClassIDPair;
import com.pulse.mo.Agent;
import com.pulse.mo.AgentScorecard;
import com.pulse.mo.CoachingNotification;
import com.pulse.mo.CoachingSession;
import com.pulse.mo.Notification;
import com.pulse.mo.TeamLeader;

// This should get picked up by Spring and be auto-wired.
@Component
public class PostGetCWHelper extends ChangeWatcherHelper {

	private static final Logger log = Logger.getLogger(PostGetCWHelper.class);

	// This is required for CUSTOM change watchers.
	private static final String CATEGORY = "POST_GET";
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
		String className = subCategory;
		String classId = fieldName;
		
		// Switch on the class name.
		if (AgentScorecard.class.getCanonicalName().equalsIgnoreCase(className)) {
			handleAgentScorecard(new ClassIDPair(classId, className), params);
		}
	}
	
	
	private void handleAgentScorecard(ClassIDPair classIdPair, String[] params) {
		try {
			 checkForOrCreateCoachingNotification(classIdPair);
		} catch(Exception e) {
			log.error(e.getMessage(), e);
		}
	}
	

	private void checkForOrCreateCoachingNotification(ClassIDPair classIdPair) throws SyncException {
		AgentScorecard host = (AgentScorecard) syncAgentService.systemGetById(classIdPair);
		
		log.debug("[PostGetCWHelper] [AgentScorecard] [CoachingNotification]");
		Date currentDate = new Date();
		DateTime currentDateTime = new DateTime(currentDate);
		DateTime scorecardDateTime = new DateTime(host.getWeekDate());
		int daysBetween = Math.abs(Days.daysBetween(scorecardDateTime, currentDateTime).getDays());
		
		// If agentScorecard < 4 weeks old
		log.debug("[PostGetCWHelper] [AgentScorecard] [CoachingNotification]  daysBetween" + daysBetween);
		if ( daysBetween < 7 * 4) {
			// Check to see if there is already a coaching notification created.
			Agent agent = syncAgentService.systemGetByObject(host.getAgent());
			if (agent != null) {
				TeamLeader teamLeader = syncAgentService.systemGetByObject(agent.getTeamLeader());
				if (teamLeader != null) {
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
						existingCoachingNotification = syncAgentService.systemCreateObject(existingCoachingNotification, null);
					}

//					Integer pendingStateCount 			= null;
//					Integer submittedStateCount			= null;
//					Integer pendingCoachStateCount		= null;
//					Integer pendingEmployeeStateCount	= null;
//					Integer acknowledgementStateCount	= null;
//					Integer skippedStateCount			= null;
//
//					Iterator<CoachingSession> itrCoachingSession  = host.getCoachingSessions().iterator();
//
//					while (itrCoachingSession.hasNext()) {
//						CoachingSession nextCoachingSession = itrCoachingSession.next();
//						if (nextCoachingSession != null && nextCoachingSession instanceof CoachingSession) {
//							String coachingSessionStateID = nextCoachingSession.getCoachingSessionState().getID();
//
//							if (coachingSessionStateID.equals("1") || coachingSessionStateID.equals("8")) {
//								pendingStateCount =  existingCoachingNotification.getPendingStateCount();
//								if (pendingStateCount == null) {
//									pendingStateCount = 0;
//								}
//								existingCoachingNotification.setPendingStateCount(pendingStateCount + 1);
//							} else if (coachingSessionStateID.equals("2") || coachingSessionStateID.equals("9")) {
//								submittedStateCount = existingCoachingNotification.getSubmittedStateCount();
//								if (submittedStateCount == null) {
//									submittedStateCount = 0;
//								}
//								existingCoachingNotification.setSubmittedStateCount(submittedStateCount + 1);
//							} else if (coachingSessionStateID.equals("5") || coachingSessionStateID.equals("11")) {
//								pendingCoachStateCount =  existingCoachingNotification.getPendingCoachStateCount();
//								if (pendingCoachStateCount == null) {
//									pendingCoachStateCount = 0;
//								}
//								existingCoachingNotification.setPendingCoachStateCount(pendingCoachStateCount + 1);
//							} else if (coachingSessionStateID.equals("3") || coachingSessionStateID.equals("10")) {
//								pendingEmployeeStateCount = existingCoachingNotification.getPendingEmployeeStateCount();
//								if (pendingEmployeeStateCount == null) {
//									pendingEmployeeStateCount = 0;
//								}
//								existingCoachingNotification.setPendingEmployeeStateCount(pendingEmployeeStateCount + 1);
//
//							} else if (coachingSessionStateID.equals("4") || coachingSessionStateID.equals("6")) {
//								acknowledgementStateCount = existingCoachingNotification.getAcknowledgementStateCount();
//								if (acknowledgementStateCount == null) {
//									acknowledgementStateCount = 0;
//								}
//								existingCoachingNotification.setAcknowledgementStateCount(acknowledgementStateCount + 1);
//							} else if (coachingSessionStateID.equals("7")) {
//								skippedStateCount = existingCoachingNotification.getSkippedStateCount();
//								if (skippedStateCount == null) {
//									skippedStateCount = 0;
//								}
//								existingCoachingNotification.setSkippedStateCount(skippedStateCount + 1);
//							}
//						}
//					}
//
//					// Save the ExistingCoachingNotification.
//					syncAgentService.systemPutObject(existingCoachingNotification, null, null, null, true);
				}
			}
		}
	}

}
