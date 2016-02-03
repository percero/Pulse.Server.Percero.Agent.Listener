package com.pulse.sync.cw.task;

import com.percero.agents.sync.exceptions.SyncException;
import com.percero.agents.sync.services.ISyncAgentService;
import com.percero.agents.sync.vo.BaseDataObject;
import com.percero.agents.sync.vo.ClassIDPair;
import com.pulse.mo.*;
import com.pulse.mo.dao.AgentScorecardDAO;
import com.pulse.mo.dao.CoachingNotificationDAO;
import com.pulse.mo.dao.ShiftStatusNotificationDAO;
import com.pulse.sync.cw.CustomNotificationCWHelper;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class TimecardPostGetTask implements Runnable {

	private static final Logger log = Logger.getLogger(TimecardPostGetTask.class);


	private CustomNotificationCWHelper customNotificationCWHelper ;
	private ISyncAgentService syncAgentService;
	private ClassIDPair classIdPair;

	public TimecardPostGetTask(ISyncAgentService syncAgentService, CustomNotificationCWHelper customNotificationCWHelper, ClassIDPair classIdPair) {
		this.syncAgentService = syncAgentService;
		this.customNotificationCWHelper = customNotificationCWHelper;
		this.classIdPair = classIdPair;
	}
	

	public void run() {
		try {
			processTimecardForTimecarEntryNotifications(classIdPair);

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
	private void processTimecardForTimecarEntryNotifications(ClassIDPair classIdPair) throws SyncException {
		Timecard host = (Timecard) syncAgentService.systemGetById(classIdPair);

		if (host.getDataSource().equals(BaseDataObject.DATA_SOURCE_DATA_STORE)){
			customNotificationCWHelper.processTimecard(host);
		}
		else{
			log.warn("Timecard.dataSource : " + host.getDataSource());
		}

	}
}
