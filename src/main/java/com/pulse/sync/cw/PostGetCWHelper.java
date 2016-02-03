package com.pulse.sync.cw;

import javax.annotation.PostConstruct;

import com.percero.agents.sync.datastore.ICacheDataStore;
import com.pulse.mo.Timecard;
import com.pulse.sync.cw.task.TimecardPostGetTask;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
import com.pulse.mo.dao.ShiftStatusNotificationDAO;
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

	@Autowired @Qualifier("executorWithCallerRunsPolicy")
	TaskExecutor taskExecutor;
	public void setTaskExecutor(TaskExecutor value) {
		taskExecutor = value;
	}

	@Autowired
	AgentScorecardDAO agentScorecardDAO;

	@Autowired
	CoachingNotificationDAO coachingNotificationDAO;
	
	@Autowired
	ShiftStatusNotificationDAO shiftStatusNotificationDAO;

	@Autowired
	CustomNotificationCWHelper customNotificationCWHelper;

	@Autowired
	ICacheDataStore cacheDataStore;

	@PostConstruct
	public void initialize() {
		ChangeWatcherHelperFactory.getInstance().registerChangeWatcherHelper(CATEGORY, this);
	}

	/* (non-Javadoc)
	 * @see com.percero.agents.sync.cw.ChangeWatcherHelper#process(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Object process(String category, String subCategory, String fieldName, IPerceroObject oldValue) {
		return process(category, subCategory, fieldName, null, oldValue);
	}

	/* (non-Javadoc)
	 * @see com.percero.agents.sync.cw.ChangeWatcherHelper#process(java.lang.String, java.lang.String, java.lang.String, java.lang.String[])
	 */
	@Override
	public Object process(String category, String subCategory, String fieldName, String[] params, IPerceroObject oldValue) {
		String className = subCategory;
		String classId = fieldName;

		// Switch on the class name.
		if (TeamLeader.class.getCanonicalName().equalsIgnoreCase(className)) {
			return handleTeamLeader(new ClassIDPair(classId, className), params);
		}
		else if (Timecard.class.getCanonicalName().equalsIgnoreCase(className)) {
			return handleTimecard(new ClassIDPair(classId, className), params);
		}

		return null;
	}


	private IPerceroObject handleTeamLeader(ClassIDPair classIdPair, String[] params) {
		try {
			taskExecutor.execute(new TeamLeaderPostGetTask(syncAgentService, agentScorecardDAO, coachingNotificationDAO, shiftStatusNotificationDAO, classIdPair));
		} catch(Exception e) {
			log.error(e.getMessage(), e);
		}

		return null;
	}

	private IPerceroObject handleTimecard(ClassIDPair classIdPair, String[] params) {
		try {
			final String redisKey = composeTimecardProcessRedisKey(classIdPair.getID());
			final String jsonObjectString = (String) cacheDataStore.getValue(redisKey);
			//If the Timecard is not processed ever with the given redisKey do this proessing else competely ignore
			if (jsonObjectString == null) {
				taskExecutor.execute(new TimecardPostGetTask(syncAgentService, customNotificationCWHelper, classIdPair));
			}


		} catch(Exception e) {
			log.error(e.getMessage(), e);
		}

		return null;
	}

	private static String composeTimecardProcessRedisKey(final String objectId) {
		return (new StringBuilder("pulse.timecard.process:").append(objectId)).toString();
	}
}
