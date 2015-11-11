package com.pulse.sync.cw;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Component;

import com.percero.agents.sync.cw.ChangeWatcherHelper;
import com.percero.agents.sync.cw.ChangeWatcherHelperFactory;
import com.percero.agents.sync.services.ISyncAgentService;
import com.percero.agents.sync.vo.ClassIDPair;
import com.percero.framework.vo.IPerceroObject;
import com.pulse.mo.TeamLeader;
import com.pulse.mo.dao.AgentScorecardDAO;
import com.pulse.mo.dao.CoachingNotificationDAO;
import com.pulse.sync.cw.task.TeamLeaderPostGetTask;

// This should get picked up by Spring and be auto-wired.
@Component
public class PostGetCWHelper extends ChangeWatcherHelper {

	private static final Logger log = Logger.getLogger(PostGetCWHelper.class);

	// This is required for POST_GET change watchers.
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
	TaskExecutor taskExecutor;
	public void setTaskExecutor(TaskExecutor value) {
		taskExecutor = value;
	}

	@Autowired
	AgentScorecardDAO agentScorecardDAO;

	@Autowired
	CoachingNotificationDAO coachingNotificationDAO;
	
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
			taskExecutor.execute(new TeamLeaderPostGetTask(syncAgentService, agentScorecardDAO, coachingNotificationDAO, classIdPair));
//			boolean shiftStatusResult = checkForOrCreateShiftStatusNotification(classIdPair);
//			boolean coachingResult = checkForOrCreateCoachingNotification(classIdPair);
//			if (shiftStatusResult || coachingResult) {
//				// If notifications have been created, then we need to return the updated TeamLeader ouject.
//				return syncAgentService.systemGetById(classIdPair);
//			}
			return null;

		} catch(Exception e) {
			log.error(e.getMessage(), e);
		}

		return null;
	}

}
