package com.pulse.sync.cw.task;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.DateTimeComparator;
import org.joda.time.Days;

import com.percero.agents.sync.exceptions.SyncException;
import com.percero.agents.sync.services.ISyncAgentService;
import com.percero.agents.sync.vo.ClassIDPair;
import com.pulse.mo.CoachingNotification;
import com.pulse.mo.Notification;
import com.pulse.mo.Scorecard;
import com.pulse.mo.ShiftStatusNotification;
import com.pulse.mo.TeamLeader;
import com.pulse.mo.dao.AgentScorecardDAO;
import com.pulse.mo.dao.CoachingNotificationDAO;

public class TeamLeaderPostGetTask implements Runnable {

	private static final Logger log = Logger.getLogger(TeamLeaderPostGetTask.class);

	public TeamLeaderPostGetTask(ISyncAgentService syncAgentService, AgentScorecardDAO agentScorecardDAO, CoachingNotificationDAO coachingNotificationDAO, ClassIDPair classIdPair) {
		this.syncAgentService = syncAgentService;
		this.agentScorecardDAO = agentScorecardDAO;
		this.coachingNotificationDAO = coachingNotificationDAO;
		this.classIdPair = classIdPair;
	}
	
	private ISyncAgentService syncAgentService;
	private AgentScorecardDAO agentScorecardDAO;
	private CoachingNotificationDAO coachingNotificationDAO;
	private ClassIDPair classIdPair;
	
	public void run() {
		try {
			checkForOrCreateCoachingNotification(classIdPair);
			checkForOrCreateShiftStatusNotification(classIdPair);
		} catch(Exception e) {
			log.error("Error running process", e);
		}
	}

	/**
	 * Grabbing the Week Dates of the AgentScorecards for the last 30 days (@see
	 * com.pulse.mo.dao.AgentScorecardDAO.findCurrentWeekDates()), for each
	 * Scorecard of the TeamLeader (@see
	 * com.pulse.mo.TeamLeader.getScorecards()), checks for a
	 * CoachingNotification for the Week Date and Scorecard. If one does NOT
	 * exist, creates a new CoachingNotification for the Week Date and
	 * Scorecard.
	 * 
	 * @param classIdPair
	 * @return
	 * @throws SyncException
	 */
	private boolean checkForOrCreateCoachingNotification(ClassIDPair classIdPair) throws SyncException {
		TeamLeader host = (TeamLeader) syncAgentService.systemGetById(classIdPair);

		log.debug("[PostGetCWHelper] [AgentScorecard] [CoachingNotification]");
		
		// Get the most recent WeekDates from AgentScorecard.
		List<Date> mostRecentWeekDates = agentScorecardDAO.findCurrentWeekDates(classIdPair.getID());

		List<Notification> createdNotifications = new ArrayList<Notification>();

		// TODO: Since we also need to match on Scorecard, we need to retrieve and loop through ALL Scorecards for this TeamLeader.
		List<Scorecard> teamLeaderScorecards = host.getScorecards();

		// For each week date, make sure we have a corresponding CoachingNotification.
		Iterator<Date> itrWeekDates = mostRecentWeekDates.iterator();
		while ( itrWeekDates.hasNext() ) {
			Date nextWeekDate = itrWeekDates.next();
//			DateTime nextWeekDateTime = new DateTime(nextWeekDate);
//			CoachingNotification existingCoachingNotification = null;
			
			// Since we also need to match on Scorecard, we need to retrieve and loop through ALL Scorecards for this TeamLeader.
			Iterator<Scorecard> itrTeamLeaderScorecards = teamLeaderScorecards.iterator();
			while (itrTeamLeaderScorecards.hasNext()) {
				// Since this was retrieved from a DerivedCollection, we know
				// that thse objects have been fully retrieved from the database
				// (ie. these Scorecards are NOT "shell" objects). However, we
				// don't really need a fully loaded Scorecard object here
				// anyways since we will only be comparing object ID's.
				Scorecard nextTeamLeaderScorecard = itrTeamLeaderScorecards.next();
				if (nextTeamLeaderScorecard == null) {
					// Double-check that we have a valid TeamLeader Scorecard.
					continue;
				}
				
				validateOrCreateCoachingNotificationForTeamLeaderScorecardAndWeekDate(host, nextTeamLeaderScorecard, nextWeekDate);
			}
		}

		return !createdNotifications.isEmpty();
	}

	public CoachingNotification validateOrCreateCoachingNotificationForTeamLeaderScorecardAndWeekDate(TeamLeader teamLeader, Scorecard scorecard, Date weekDate) {
		
		if (teamLeader == null || scorecard == null || weekDate == null || weekDate.getTime() <= 0) {
			log.warn("Invalid data in validateOrCreateCoachingNotificationForTeamLeaderScorecardAndWeekDate, ignoring request.");
			return null;
		}
		
		CoachingNotification existingCoachingNotification = coachingNotificationDAO.fetchCoachingNotificationForTeamLeaderAndScorecardAndWeekDate(teamLeader.getID(), scorecard.getID(), weekDate);
		if (existingCoachingNotification == null) {
			try {
				// No matching CoachingNotification, so let's create one.
				CoachingNotification newCoachingNotification = new CoachingNotification();
				newCoachingNotification.setID(UUID.randomUUID().toString());
				newCoachingNotification.setCreatedOn(weekDate);
				newCoachingNotification.setName(scorecard.getName());
				newCoachingNotification.setType("CoachingNotification");
				newCoachingNotification.setTeamLeader(teamLeader);
				newCoachingNotification.setWeekDate(weekDate);
				newCoachingNotification.setScorecard(scorecard);
				existingCoachingNotification = syncAgentService.systemCreateObject(newCoachingNotification, null);
			} catch (SyncException e) {
				log.error("Unable to query for existing CoachingNotification: " + e.getMessage(), e);
			}
		}
		
		return existingCoachingNotification;
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
