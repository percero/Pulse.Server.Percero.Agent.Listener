package com.pulse.sync.cw;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.UUID;

import javax.activity.ActivityRequiredException;
import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.hibernate.mapping.AuxiliaryDatabaseObject;
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
import com.pulse.mo.DurationToleranceNotification;
import com.pulse.mo.Notification;
import com.pulse.mo.ShiftStatusNotification;
import com.pulse.mo.TeamLeader;
import com.pulse.mo.Timecard;

// This should get picked up by Spring and be auto-wired.
@Component
public class CustomNotificationCWHelper extends ChangeWatcherHelper {

	private static final Logger log = Logger.getLogger(CustomNotificationCWHelper.class);

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
		
		// CMS Entry Notification
		Collection<String> cmsEntryFieldsToWatch = new HashSet<String>();
		// Listen for changes on ALL CMSEntry records.
		accessManager.addWatcherField(new ClassIDPair("0", CMSEntry.class.getCanonicalName()), "", cmsEntryFieldsToWatch);
		// Register the fields. This can always be called again with an updated
		// list of fields to watch, which would overwrite the list of fields
		// that trigger this change watcher code.
		accessManager.updateWatcherFields(CATEGORY, SUB_CATEGORY, "handleCmsEntryNotification", cmsEntryFieldsToWatch);
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
		if (fieldName.equalsIgnoreCase("handleCmsEntryNotification")) {
			try {
				handleCmsEntryNotification(category, subCategory, fieldName, params);
			} catch(Exception e) {
				log.error("Unable to process handleCmsEntryNotification", e);
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
	private void handleCmsEntryNotification(String category, String subCategory, String fieldName, String[] params) throws Exception {
		// This is where the logic would go to create a Notification based on when the data requested above changes.
		try {
			
			if (params != null && params.length >= 2) {
				String className = params[0];
				String classId = params[1];
				
				ClassIDPair classIdPair = new ClassIDPair(classId, className);
				IPerceroObject updatedObject = syncAgentService.systemGetById(classIdPair);
				
				if (updatedObject instanceof CMSEntry) {
					CMSEntry cmsEntry = (CMSEntry) updatedObject;
					Agent agent = null;
					TeamLeader teamLeader = null;

					if (cmsEntry != null) {
						
						// 1. Check for DURATION Tolerance
						Double DURATION_MAX = new Double(15.0 * 60.0);	// TODO: Should be set to 15 minutes.
						Double duration = cmsEntry.getDuration();
						// If the duration is > DURATION_MAX, then create the notification.
						if (duration.compareTo(DURATION_MAX) > 0) {
							if (agent == null) {
								agent = syncAgentService.systemGetByObject(cmsEntry.getAgent());
							}
							if (teamLeader == null) {
								teamLeader = agent.getTeamLeader();
							}
							
							if (agent != null && teamLeader != null) {
								DurationToleranceNotification durationToleranceNotification = new DurationToleranceNotification();
								durationToleranceNotification.setID(UUID.randomUUID().toString());
								durationToleranceNotification.setAgent(agent);
								durationToleranceNotification.setDate(new Date());
								durationToleranceNotification.setTeamLeader(teamLeader);
								syncAgentService.systemCreateObject(durationToleranceNotification, null);
							}
						}
						
						// 2.
						
						
						// 3.
						
						
						// 4.

					}

				}
			}
		} catch(Exception e) {
			// Handle exception
		}
	}
	
	

}
