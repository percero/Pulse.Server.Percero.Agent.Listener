package com.pulse.sync.cw.workers;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.percero.agents.sync.access.IAccessManager;
import com.percero.agents.sync.cw.IChangeWatcherHelper;
import com.percero.agents.sync.cw.IChangeWatcherHelperFactory;
import com.percero.agents.sync.services.ISyncAgentService;
import com.percero.agents.sync.vo.BaseDataObject;
import com.pulse.mo.Agent;
import com.pulse.mo.PulseUser;
import com.pulse.mo.TeamLeader;
import com.pulse.mo.Timecard;
import com.pulse.mo.dao.AgentScorecardDAO;
import com.pulse.mo.dao.PulseUserDAO;
import com.pulse.sync.cw.TimecardCWHelper;
import com.pulse.sync.cw.task.TeamLeaderPostGetTask;

@Component
public class TimerWorker {
	
	public TimerWorker() {
	}
	
	@Autowired
	PulseUserDAO pulseUserDao;
	
	@Autowired
	AgentScorecardDAO agentScorecardDAO;
	
	@Autowired
	ISyncAgentService syncAgentService;
	
	@Autowired
	IAccessManager accessManager;

	@Autowired
	IChangeWatcherHelperFactory changeWatcherHelperFactory;

	@Autowired
	TaskExecutor taskExecutor;
	public void setTaskExecutor(TaskExecutor value) {
		taskExecutor = value;
	}

	@Scheduled(fixedDelay=300000)	// Every 5 minutes
//	@Scheduled(fixedDelay=10000)	// Every 10 seconds
	public void checkCurrentTime() {
		System.out.println("Running TimerWorker");
		
		try {
			List<PulseUser> pulseUsers = pulseUserDao.getAll(null, null, false, null, true);
			for(PulseUser nextPulseUser : pulseUsers) {
				nextPulseUser = syncAgentService.systemGetByObject(nextPulseUser);
				if (nextPulseUser != null) {
					TeamLeader teamLeader = syncAgentService.systemGetByObject(nextPulseUser.getTeamLeader());
					if (teamLeader != null) {
						taskExecutor.execute(new TeamLeaderPostGetTask(syncAgentService, agentScorecardDAO, BaseDataObject.toClassIdPair(teamLeader)));

						Iterator<Agent> itrAgents = teamLeader.getAgents().iterator();
						while (itrAgents.hasNext()) {
							Agent nextAgent = syncAgentService.systemGetByObject(itrAgents.next());
							if (nextAgent != null) {

								Iterator<Timecard> itrTimecards = nextAgent.getTimecards().iterator();
								while (itrTimecards.hasNext()) {
									Timecard timecard = (Timecard) syncAgentService.systemGetById(Timecard.class.getCanonicalName(), itrTimecards.next().getID());

									if (timecard != null) {
										recalcChangeWatcher(timecard.getClass().getCanonicalName(), timecard.getID(), TimecardCWHelper.CURRENTSTATUS);
									}
								}

							}
						}
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void recalcChangeWatcher(String className, String classId, String fieldName) {
		if (changeWatcherHelperFactory != null) {
			IChangeWatcherHelper cwh = changeWatcherHelperFactory.getHelper(className);
			cwh.reprocess(className, classId, fieldName, null, null, null);
		}
	}
}
