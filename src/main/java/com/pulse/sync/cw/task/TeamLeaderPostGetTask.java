package com.pulse.sync.cw.task;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
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
import com.pulse.mo.dao.ShiftStatusNotificationDAO;

public class TeamLeaderPostGetTask implements Runnable {

	private static final Logger log = Logger.getLogger(TeamLeaderPostGetTask.class);

	public TeamLeaderPostGetTask(ISyncAgentService syncAgentService, AgentScorecardDAO agentScorecardDAO, CoachingNotificationDAO coachingNotificationDAO, ShiftStatusNotificationDAO shiftStatusNotificationDAO, ClassIDPair classIdPair) {
		this.syncAgentService = syncAgentService;
		this.agentScorecardDAO = agentScorecardDAO;
		this.coachingNotificationDAO = coachingNotificationDAO;
		this.shiftStatusNotificationDAO = shiftStatusNotificationDAO;
		this.classIdPair = classIdPair;
	}
	
	private ISyncAgentService syncAgentService;
	private AgentScorecardDAO agentScorecardDAO;
	private CoachingNotificationDAO coachingNotificationDAO;
	private ShiftStatusNotificationDAO shiftStatusNotificationDAO;
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
	 * @throws SyncException
	 */
	private void checkForOrCreateCoachingNotification(ClassIDPair classIdPair) throws SyncException {
		TeamLeader host = (TeamLeader) syncAgentService.systemGetById(classIdPair);

		log.debug("[PostGetCWHelper] [AgentScorecard] [CoachingNotification]");
		
		// Get the most recent WeekDates from AgentScorecard.
		List<Date> mostRecentWeekDates = agentScorecardDAO.findCurrentWeekDates(classIdPair.getID());

		// Since we also need to match on Scorecard, we need to retrieve and loop through ALL Scorecards for this TeamLeader.
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
	}

	public CoachingNotification validateOrCreateCoachingNotificationForTeamLeaderScorecardAndWeekDate(TeamLeader teamLeader, Scorecard scorecard, Date weekDate) {
		
		if (teamLeader == null || scorecard == null || weekDate == null || weekDate.getTime() <= 0) {
			log.warn("Invalid data in validateOrCreateCoachingNotificationForTeamLeaderScorecardAndWeekDate, ignoring request.");
			return null;
		}
		
		CoachingNotification result = null;
		
		List<CoachingNotification> existing = coachingNotificationDAO.fetchCoachingNotificationForTeamLeaderAndScorecardAndWeekDate(teamLeader.getID(), scorecard.getID(), weekDate);
		if (existing == null || existing.isEmpty()) {
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
				result = syncAgentService.systemCreateObject(newCoachingNotification, null);
				
			} catch (SyncException e) {
				log.debug("Unable to create CoachingNotification: " + e.getMessage());
			}
		}
		
		// There is a race condition here where we may create multiple records.  Because the unique index
		// here spans multiple tables in the underlying database, we can't enforce the unique constraints at a 
		// database level.  So we use this hack to remove any duplicate records.
		existing = coachingNotificationDAO.fetchCoachingNotificationForTeamLeaderAndScorecardAndWeekDate(teamLeader.getID(), scorecard.getID(), weekDate);
		if (existing != null) {
			Iterator<CoachingNotification> itr = existing.iterator();
			int countDown = existing.size();
			while (itr.hasNext()) {
				if (countDown <= 1) {
					// We have our result.
					result = itr.next();
					break;
				}
				else {
					// We have dups, need to delete this record.
					try {
						syncAgentService.systemDeleteObject(itr.next(), null, true);
					} catch (Exception e) {
						// This may mean that we have already deleted this dup in another process.
					}
				}
				countDown--;
			}
		}
		
		return result;
	}
	
	private void checkForOrCreateShiftStatusNotification(ClassIDPair classIdPair)
			throws SyncException {
		TeamLeader host = (TeamLeader) syncAgentService
				.systemGetById(classIdPair);

		log.debug("[PostGetCWHelper] [Timecard] [ShiftStatusNotification]");
		DateTime currentDateTime = new DateTime(new Date());
		DateTime shiftDateTime = new DateTime(new Date());
		int daysBetween = Math.abs(Days.daysBetween(currentDateTime, shiftDateTime).getDays());
		log.debug("[PostGetCWHelper] [Timecard] [ShiftStatusNotification]  daysBetween"
				+ daysBetween);

		// If the Timecard.date < 3 days old
		while ( daysBetween < 3) {
			validateOrCreateShiftStatusNotificationForTeamLeaderAndShiftDate(host, shiftDateTime.toDate());

			shiftDateTime = shiftDateTime.minusDays(1);
			daysBetween = Math.abs(Days.daysBetween(currentDateTime, shiftDateTime).getDays());

		}

		Iterator<Notification> itrNotifications = host.getNotifications().iterator();
		while (itrNotifications.hasNext()) {
			Notification nextNotification = itrNotifications.next();
			if (nextNotification != null && nextNotification instanceof ShiftStatusNotification) {
				ShiftStatusNotification nextShiftStatusNotification = (ShiftStatusNotification) syncAgentService.systemGetByObject(nextNotification);

				if (nextShiftStatusNotification == null) {
					continue;
				}
				
				log.debug("ApprovedStateCount: " + nextShiftStatusNotification.getApprovedStateCount());
				log.debug("CompletedStateCount: " + nextShiftStatusNotification.getCompletedStateCount());
				log.debug("InProgressStateCount: " + nextShiftStatusNotification.getInProgressStateCount());
				log.debug("UnknownStateCount: " + nextShiftStatusNotification.getNotYetStartedStateCount());
				log.debug("NotYetStartedStateCount: " + nextShiftStatusNotification.getUnknownStateCount());
			}
		}
	}
	
	public ShiftStatusNotification validateOrCreateShiftStatusNotificationForTeamLeaderAndShiftDate(TeamLeader teamLeader, Date shiftDate) {
		
		if (teamLeader == null || shiftDate == null || shiftDate.getTime() <= 0) {
			log.warn("Invalid data in validateOrCreateShiftStatusNotificationForTeamLeaderAndShiftDate, ignoring request.");
			return null;
		}
		
		ShiftStatusNotification result = null;
		List<ShiftStatusNotification> existing = shiftStatusNotificationDAO.fetchShiftStatusNotificationForTeamLeaderAndShiftEndDate(teamLeader.getID(), shiftDate);
		if (existing == null || existing.isEmpty()) {
			try {
				// No matching ShiftStatusNotification, so let's create one.
				result = new ShiftStatusNotification();
				result.setID(UUID.randomUUID().toString());
				result.setResolved(false);
				result.setCreatedOn(shiftDate);
				result.setName("Shift Status");
				result.setType("ShiftStatusNotification");
				result.setTeamLeader(teamLeader);
				result.setShiftEndDate(shiftDate);
				result = syncAgentService.systemCreateObject(result, null);
			} catch (SyncException e) {
				log.debug("Unable to create ShiftStatusNotification: " + e.getMessage());
			}
		}
		
		// There is a race condition here where we may create multiple records.  Because the unique index
		// here spans multiple tables in the underlying database, we can't enforce the unique constraints at a 
		// database level.  So we use this hack to remove any duplicate records.
		existing = shiftStatusNotificationDAO.fetchShiftStatusNotificationForTeamLeaderAndShiftEndDate(teamLeader.getID(), shiftDate);
		if (existing != null) {
			Iterator<ShiftStatusNotification> itr = existing.iterator();
			int countDown = existing.size();
			while (itr.hasNext()) {
				if (countDown <= 1) {
					// We have our result.
					result = itr.next();
					break;
				}
				else {
					// We have dups, need to delete this record.
					try {
						syncAgentService.systemDeleteObject(itr.next(), null, true);
					} catch (Exception e) {
						// This may mean that we have already deleted this dup in another process.
					}
				}
				countDown--;
			}
		}
		
		return result;
	}
}
