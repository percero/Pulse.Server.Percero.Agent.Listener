package com.pulse.sync.cw;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.percero.agents.sync.cw.ChangeWatcherHelper;
import com.percero.agents.sync.cw.ChangeWatcherHelperFactory;
import com.percero.agents.sync.services.ISyncAgentService;
import com.percero.agents.sync.vo.ClassIDPair;
import com.pulse.mo.Agent;
import com.pulse.mo.Notification;
import com.pulse.mo.TeamLeader;

// This should get picked up by Spring and be auto-wired.
@Component
public class CustomCWHelper extends ChangeWatcherHelper {

	private static final Logger log = Logger.getLogger(CustomCWHelper.class);

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
		// Listen for changes on ALL TeamLeaders.
		accessManager.addWatcherField(new ClassIDPair("0", TeamLeader.class.getCanonicalName()), "", fieldsToWatch);
		// Listen for changes on Agent AGENT_1_ID.
		accessManager.addWatcherField(new ClassIDPair("AGENT_1_ID", Agent.class.getCanonicalName()), "", fieldsToWatch);

		// Register the fields. This can always be called again with an updated
		// list of fields to watch, which would overwrite the list of fields
		// that trigger this change watcher code.
		accessManager.updateWatcherFields(CATEGORY, SUB_CATEGORY, "runMyTest", fieldsToWatch);
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
		if (fieldName.equalsIgnoreCase("runMyTest")) {
			try {
				runMyTestCode(category, subCategory, fieldName);
			} catch(Exception e) {
				log.error("Unable to process runMyTestCode", e);
			}
		}
		else {
			super.process(category, subCategory, fieldName, params);
		}
	}
	
	/**
	 * Sample method that runs some logic when the data, registered for above, changes.
	 * 
	 * @param category
	 * @param subCategory
	 * @param fieldName
	 * @throws Exception
	 */
	public void runMyTestCode(String category, String subCategory, String fieldName) throws Exception {
		// This is where the logic would go to create a Notification based on when the data requested above changes.
		try {
			TeamLeader teamLeader = (TeamLeader) syncAgentService.systemGetById(new ClassIDPair("TEAM_LEADER_1_ID", TeamLeader.class.getCanonicalName()));
			if (teamLeader != null && teamLeader.getFullName().equals("Team Leader Name")) {
				Notification sampleNotification = new Notification();
				sampleNotification.setTeamLeader(teamLeader);
				sampleNotification.setDate(new Date());
				sampleNotification.setID(UUID.randomUUID().toString());
				sampleNotification.setType("NOTIFICATION_TYPE");
				sampleNotification.setName("This is only a test");
				syncAgentService.systemCreateObject(sampleNotification, null);
			}
		} catch(Exception e) {
			// Handle any exception here.
		}
	}


}
