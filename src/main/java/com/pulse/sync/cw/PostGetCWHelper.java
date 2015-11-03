package com.pulse.sync.cw;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.DateTimeComparator;
import org.joda.time.Days;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.percero.agents.sync.cw.ChangeWatcherHelper;
import com.percero.agents.sync.cw.ChangeWatcherHelperFactory;
import com.percero.agents.sync.exceptions.SyncException;
import com.percero.agents.sync.services.ISyncAgentService;
import com.percero.agents.sync.vo.BaseDataObject;
import com.percero.agents.sync.vo.ClassIDPair;
import com.percero.framework.vo.IPerceroObject;
import com.pulse.mo.Agent;
import com.pulse.mo.AgentScorecard;
import com.pulse.mo.CoachingNotification;
import com.pulse.mo.CoachingSession;
import com.pulse.mo.Notification;
import com.pulse.mo.Scorecard;
import com.pulse.mo.ShiftStatusNotification;
import com.pulse.mo.TeamLeader;
import com.pulse.mo.Timecard;
import com.pulse.mo.dao.AgentScorecardDAO;

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

	@Autowired
	AgentScorecardDAO agentScorecardDAO;

	@PostConstruct
	public void initialize() {
		ChangeWatcherHelperFactory.getInstance().registerChangeWatcherHelper(CATEGORY, this);
	}

	/* (non-Javadoc)
	 * @see com.percero.agents.sync.cw.ChangeWatcherHelper#process(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Object process(String category, String subCategory, String fieldName) {
		return process(category, subCategory, fieldName, null);
	}

	/* (non-Javadoc)
	 * @see com.percero.agents.sync.cw.ChangeWatcherHelper#process(java.lang.String, java.lang.String, java.lang.String, java.lang.String[])
	 */
	@Override
	public Object process(String category, String subCategory, String fieldName, String[] params) {
		String className = subCategory;
		String classId = fieldName;

		// Switch on the class name.
		if (TeamLeader.class.getCanonicalName().equalsIgnoreCase(className)) {
			return handleTeamLeader(new ClassIDPair(classId, className), params);
		}

		return null;
	}


	private IPerceroObject handleTeamLeader(ClassIDPair classIdPair, String[] params) {
		try {
			boolean shiftStatusResult = checkForOrCreateShiftStatusNotification(classIdPair);
			boolean coachingResult = checkForOrCreateCoachingNotification(classIdPair);
			if (shiftStatusResult || coachingResult) {
				// If notifications have been created, then we need to return the updated TeamLeader ouject.
				return syncAgentService.systemGetById(classIdPair);
			}

		} catch(Exception e) {
			log.error(e.getMessage(), e);
		}

		return null;
	}


	private boolean checkForOrCreateCoachingNotification(ClassIDPair classIdPair) throws SyncException {

		TeamLeader host = (TeamLeader) syncAgentService.systemGetById(classIdPair);

		log.debug("[PostGetCWHelper] [AgentScorecard] [CoachingNotification]");

		// Get the most recent WeekDates from AgentScorecard.
		List<Date> mostRecentWeekDates = agentScorecardDAO.findCurrentWeekDates();

		List<Notification> createdNotifications = new ArrayList<Notification>();

		// For each week date, make sure we have a corresponding CoachingNotification.
		Iterator<Date> itrWeekDates = mostRecentWeekDates.iterator();
		while ( itrWeekDates.hasNext() ) {
			Date nextWeekDate = itrWeekDates.next();
			DateTime nextWeekDateTime = new DateTime(nextWeekDate);
			CoachingNotification existingCoachingNotification = null;

			Iterator<Notification> itrNotifications = host.getNotifications().iterator();
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
					log.debug("[CoachingNotification]  AgentScoreCard DateTime" + nextWeekDateTime);
					log.debug("[CoachingNotification]  AgentScoreCard id" + host.getID());
					// If AgentScorecard.weekDate == CoachingNotification.weekDate, we found a match.
					if (DateTimeComparator.getDateOnlyInstance().compare(nextWeekDateTime, nextCoachingNotificationWeekDate) == 0) {
						log.debug("[CoachingNotification]  Existing CoachingNotification found: " + nextCoachingNotification.getID());
						existingCoachingNotification = nextCoachingNotification;
						break;
					}
				}
			}

			itrNotifications = createdNotifications.iterator();
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
					log.debug("[CoachingNotification]  AgentScoreCard DateTime" + nextWeekDateTime);
					log.debug("[CoachingNotification]  AgentScoreCard id" + host.getID());
					// If AgentScorecard.weekDate == CoachingNotification.weekDate, we found a match.
					if (DateTimeComparator.getDateOnlyInstance().compare(nextWeekDateTime, nextCoachingNotificationWeekDate) == 0) {
						log.debug("[CoachingNotification]  Existing CoachingNotification found: " + nextCoachingNotification.getID());
						existingCoachingNotification = nextCoachingNotification;
						break;
					}
				}
			}

			if (existingCoachingNotification == null) {
				existingCoachingNotification = new CoachingNotification();
				existingCoachingNotification.setID(UUID.randomUUID().toString());
				existingCoachingNotification.setCreatedOn(nextWeekDate);
				existingCoachingNotification.setName("Available for Coaching");
				existingCoachingNotification.setType("CoachingNotification");
				existingCoachingNotification.setTeamLeader(host);
				existingCoachingNotification.setWeekDate(nextWeekDate);
				existingCoachingNotification = syncAgentService.systemCreateObject(existingCoachingNotification, null);
				
				Iterator<AgentScorecard> itrAgentScorecards = existingCoachingNotification.getAgentScorecards().iterator();
				while (itrAgentScorecards.hasNext()) {
					AgentScorecard nextAgentScorecard = itrAgentScorecards.next();
					if (nextAgentScorecard != null) {
						Scorecard scorecard = syncAgentService.systemGetByObject(nextAgentScorecard.getScorecard());
						if (scorecard != null && StringUtils.hasText(scorecard.getName())) {
							existingCoachingNotification.setName(scorecard.getName());
							syncAgentService.systemPutObject(existingCoachingNotification, null, null, null, true);
							break;
						}
					}
				}

				createdNotifications.add(existingCoachingNotification);

			}
		}

		return !createdNotifications.isEmpty();
	}

	private boolean checkForOrCreateShiftStatusNotification(ClassIDPair classIdPair)
			throws SyncException {
		TeamLeader host = (TeamLeader) syncAgentService
				.systemGetById(classIdPair);

		log.debug("[PostGetCWHelper] [Timecard] [ShiftStatusNotification]");
		DateTime currentDateTime = new DateTime(new Date());
		DateTime shiftDateTime = new DateTime(new Date());
		int daysBetween = Math.abs(Days.daysBetween(currentDateTime, shiftDateTime).getDays());
		log.debug("[PostGetCWHelper] [Timecard] [ShiftStatusNotification]  daysBetween"
				+ daysBetween);

		List<Notification> createdNotifications = new ArrayList<Notification>();

		// If the Timecard.date < 3 days old
		while ( daysBetween < 3) {
			// Check to see if there is already a coaching notification created.
			ShiftStatusNotification existingShiftStatusNotification = null;

			Iterator<Notification> itrNotifications = host.getNotifications().iterator();
			while (itrNotifications.hasNext()) {
				Notification nextNotification = itrNotifications.next();
				if (nextNotification != null && nextNotification instanceof ShiftStatusNotification) {
					ShiftStatusNotification nextShiftStatusNotification = (ShiftStatusNotification) syncAgentService.systemGetByObject(nextNotification);

					if (nextShiftStatusNotification == null) {
						continue;
					}

					log.debug("[ShiftStatusNotification]  ShiftStatusNotification id - "
							+ nextShiftStatusNotification.getID());
					log.debug("[ShiftStatusNotification]  Timecard id"
							+ host.getID());
					DateTime nextShiftStatusNotificationWeekDate = new DateTime(nextShiftStatusNotification.getShiftEndDate());
					// If AgentScorecard.weekDate == ShiftStatusNotification.weekDate, we found a match.
					if (DateTimeComparator.getDateOnlyInstance().compare(shiftDateTime, nextShiftStatusNotificationWeekDate) == 0) {
						existingShiftStatusNotification = nextShiftStatusNotification;
						log.debug("[ShiftStatusNotification]  Existing ShiftStatusNotification found: "
								+ nextShiftStatusNotification.getID());
						break;
					}
				}
			}

			if (existingShiftStatusNotification == null) {
				existingShiftStatusNotification = new ShiftStatusNotification();
				existingShiftStatusNotification.setID(UUID.randomUUID().toString());
				existingShiftStatusNotification.setResolved(false);
				existingShiftStatusNotification.setCreatedOn(shiftDateTime.toDate());
				existingShiftStatusNotification.setName("Shift Status");
				existingShiftStatusNotification.setType("ShiftStatusNotification");
				existingShiftStatusNotification.setTeamLeader(host);
				existingShiftStatusNotification.setShiftEndDate(shiftDateTime.toDate());
				try {
					existingShiftStatusNotification = syncAgentService.systemCreateObject(existingShiftStatusNotification, null);
					createdNotifications.add(existingShiftStatusNotification);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}

			shiftDateTime = shiftDateTime.minusDays(1);
			daysBetween = Math.abs(Days.daysBetween(currentDateTime, shiftDateTime).getDays());

		}

		return !createdNotifications.isEmpty();
	}
}
