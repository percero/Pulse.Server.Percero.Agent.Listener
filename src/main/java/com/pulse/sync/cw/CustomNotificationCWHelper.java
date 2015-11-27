package com.pulse.sync.cw;

import java.util.*;

import javax.annotation.PostConstruct;

import com.pulse.mo.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.percero.agents.sync.cw.ChangeWatcherHelper;
import com.percero.agents.sync.cw.ChangeWatcherHelperFactory;
import com.percero.agents.sync.services.ISyncAgentService;
import com.percero.agents.sync.vo.ClassIDPair;
import com.percero.framework.vo.IPerceroObject;

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
        Collection<String> timecardEntryFieldsToWatch = new HashSet<String>();
        // Listen for changes on ALL CMSEntry records.
        accessManager.addWatcherField(new ClassIDPair("0", CMSEntry.class.getCanonicalName()), "", cmsEntryFieldsToWatch);
        accessManager.addWatcherField(new ClassIDPair("0", TimecardEntry.class.getCanonicalName()), "", timecardEntryFieldsToWatch);
        // Register the fields. This can always be called again with an updated
        // list of fields to watch, which would overwrite the list of fields
        // that trigger this change watcher code.
        accessManager.updateWatcherFields(CATEGORY, SUB_CATEGORY, "handleCmsEntryNotification", cmsEntryFieldsToWatch);
        accessManager.updateWatcherFields(CATEGORY, SUB_CATEGORY, "handleTimecardEntryNotification", timecardEntryFieldsToWatch);
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
        if (fieldName.equalsIgnoreCase("handleCmsEntryNotification")) {
            try {
                handleCmsEntryNotification(category, subCategory, fieldName, params);
            } catch (Exception e) {
                log.error("Unable to process handleCmsEntryNotification", e);
            }
            return null;
        } else if (fieldName.equalsIgnoreCase("handleTimecardEntryNotification")) {
            try {
                handleTimecardEntryNotification(category, subCategory, fieldName, params);
            } catch (Exception e) {
                log.error("Unable to process handleTimecardEntryNotification", e);
            }
            return null;
        } else {
            return super.process(category, subCategory, fieldName, params);
        }
    }


    /**
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

                        // 1. Check for Work Mode DURATION Tolerance

                        /**
                         * Examples on how to retrieve an object by Example AND by ID
                         LOBConfiguration lobConfig = (LOBConfiguration) syncAgentService.systemGetById(LOBConfiguration.class.getCanonicalName(), "LOB_CONFIG_ID_GOES_HERE");

                         LOB exampleLob = new LOB();
                         exampleLob.setName("LOB NAME");
                         List<IPerceroObject> exampleLobResults = syncAgentService.systemFindByExample(exampleLob, null);
                         if (exampleLobResults != null && exampleLobResults.size() > 0) {
                         LOB foundLob = (LOB) exampleLobResults.get(0);

                         LOBConfiguration exampleLobConfiguration = new LOBConfiguration();
                         exampleLobConfiguration.setLOB(foundLob);
                         List<IPerceroObject> exampleLobConfigurationResults = syncAgentService.systemFindByExample(exampleLobConfiguration, null);
                         if (exampleLobConfigurationResults != null && exampleLobConfigurationResults.size() > 0) {
                         LOBConfiguration foundLobConfiguration = (LOBConfiguration) exampleLobConfigurationResults.get(0);
                         }

                         LOBConfiguration lobConfig = (LOBConfiguration) syncAgentService.systemGetById(LOBConfiguration.class.getCanonicalName(), "LOB_CONFIG_ID_GOES_HERE");
                         */

                        //Work Mode Duration
                        //For the watched CMSEntry,
                        //Use the AuxCode in the Entry and look into the configuration.
                        //Use min and max value associated with it to check the duration is within the allowed range.
                        //In condition fails, generate notification
                        //For now AuxCode look-up is assumed and possible retrived min/max is hard-coded in the logic.

//                        cmsEntry.getCMSAuxMode()

                     
                        Double DURATION_MIN = new Double(5.0 * 60.0);    // TODO: Should be set to 5 minutes.
                        Double DURATION_MAX = new Double(15.0 * 60.0);    // TODO: Should be set to 15 minutes.
                        Double duration = cmsEntry.getDuration();
                        // If the duration is > DURATION_MAX, then create the notification.
                        if (duration.compareTo(DURATION_MIN) < 0 || duration.compareTo(DURATION_MAX) > 0) {
                            if (agent == null) {
                                agent = syncAgentService.systemGetByObject(cmsEntry.getAgent());
                            }
                            if (agent != null && teamLeader == null) {
                                teamLeader = agent.getTeamLeader();
                            }

                            if (agent != null && teamLeader != null) {
                                WorkDurationNotification workDurationNotification = new WorkDurationNotification();
                                workDurationNotification.setID(UUID.randomUUID().toString());
                                workDurationNotification.setAgent(agent);
                                workDurationNotification.setCreatedOn(new Date());
                                workDurationNotification.setTeamLeader(teamLeader);
                                workDurationNotification.setName(WorkDurationNotification.class.getName() + "-" + cmsEntry.getFromTime() + "-" + cmsEntry.getCMSAuxMode());
                                workDurationNotification.setType(WorkDurationNotification.class.getName());
//								workModeOccurrenceNotification.setMessage();
//								workModeOccurrenceNotification.setLOBConfiguration();
//								workModeOccurrenceNotification.setLOBConfigurationEntry();
                                syncAgentService.systemCreateObject(workDurationNotification, null);
                            }
                        }

                        // 2.


                        // 3.


                        // 4.

                    }

                }
            }
        } catch (Exception e) {
            // Handle exception
            log.error("Error in LOB Notification", e);
        }
    }

    /**
     * @param category
     * @param subCategory
     * @param fieldName
     * @throws Exception
     */
    private void handleTimecardEntryNotification(String category, String subCategory, String fieldName, String[] params) throws Exception {
        // This is where the logic would go to create a Notification based on when the data requested above changes.
        try {

            if (params != null && params.length >= 2) {
                String className = params[0];
                String classId = params[1];

                ClassIDPair classIdPair = new ClassIDPair(classId, className);
                IPerceroObject updatedObject = syncAgentService.systemGetById(classIdPair);

                if (updatedObject instanceof TimecardEntry) {
                    TimecardEntry timecardEntry = (TimecardEntry) updatedObject;
                    Agent agent = null;
                    TeamLeader teamLeader = null;

                    if (timecardEntry != null) {

                        // 1. eStart Valid Activity code

                        /**
                         * Examples on how to retrieve an object by Example AND by ID
                         LOBConfiguration lobConfig = (LOBConfiguration) syncAgentService.systemGetById(LOBConfiguration.class.getCanonicalName(), "LOB_CONFIG_ID_GOES_HERE");

                         LOB exampleLob = new LOB();
                         exampleLob.setName("LOB NAME");
                         List<IPerceroObject> exampleLobResults = syncAgentService.systemFindByExample(exampleLob, null);
                         if (exampleLobResults != null && exampleLobResults.size() > 0) {
                         LOB foundLob = (LOB) exampleLobResults.get(0);

                         LOBConfiguration exampleLobConfiguration = new LOBConfiguration();
                         exampleLobConfiguration.setLOB(foundLob);
                         List<IPerceroObject> exampleLobConfigurationResults = syncAgentService.systemFindByExample(exampleLobConfiguration, null);
                         if (exampleLobConfigurationResults != null && exampleLobConfigurationResults.size() > 0) {
                         LOBConfiguration foundLobConfiguration = (LOBConfiguration) exampleLobConfigurationResults.get(0);
                         }

                         LOBConfiguration lobConfig = (LOBConfiguration) syncAgentService.systemGetById(LOBConfiguration.class.getCanonicalName(), "LOB_CONFIG_ID_GOES_HERE");
                         */


                        //For the watched TimecarEntry,
                        //Use the ActivityCode in the Entry and look into the configuration Along with key for "NON-BILLABLE" (Still need to be decided for the key).
                        //If timecardEntry.getTimecardActivity().getCode() is in the list of activitycode retrived from LOBConfig, it is nonbillable activity code
                        //In condition fails, generate notification

                        String validActivityCodeArray[] =
                                new String[]{"01-001", "11-001", "17-003", "26-001", "30-001", "35-004", "35-003", "31-003", "42-001",
                                        "01-001", "11-001", "16-001", "16-002", "16-005", "26-001", "30-001", "31-003", "35-003", "42-001", "86-004", "86-006", "99-001"};


                        List<String> validActivityCodeList = Arrays.asList(validActivityCodeArray);

                        if (!validActivityCodeList.contains(timecardEntry.getTimecardActivity().getCode())) {

                            if (agent == null) {
                                agent = syncAgentService.systemGetByObject(timecardEntry.getAgent());
                            }
                            if (agent != null && teamLeader == null) {
                                teamLeader = agent.getTeamLeader();
                            }

                            if (agent != null && teamLeader != null) {
                                InvalidActivityCodeNotification invalidActivityCodeNotification = new InvalidActivityCodeNotification();
                                invalidActivityCodeNotification.setID(UUID.randomUUID().toString());
                                invalidActivityCodeNotification.setAgent(agent);
                                invalidActivityCodeNotification.setCreatedOn(new Date());
                                invalidActivityCodeNotification.setTeamLeader(teamLeader);
                                invalidActivityCodeNotification.setName(InvalidActivityCodeNotification.class.getName() + "-" + timecardEntry.getTimecardActivity().getCode());
                                invalidActivityCodeNotification.setType(InvalidActivityCodeNotification.class.getName());
//								nonBillableActivityNotification.setMessage();
//								workModeOccurrenceNotification.setLOBConfiguration();
//								workModeOccurrenceNotification.setLOBConfigurationEntry();
                                syncAgentService.systemCreateObject(invalidActivityCodeNotification, null);
                            }
                        }

                        // 2. eStart Non-billable Activity code
                        //For the watched TimecarEntry,
                        //Use the ActivityCode in the Entry and look into the configuration Along with key for "NON-BILLABLE" (Still need to be decided for the key).
                        //If timecardEntry.getTimecardActivity().getCode() is in the list of activitycode retrived from LOBConfig, it is nonbillable activity code
                        //In condition fails, generate notification

                        String nonBillableActivityCodeArray[] = new String[]{"30-001", "31-003", "35-003"};

                        List<String> nonBillableActivityCodeList = Arrays.asList(nonBillableActivityCodeArray);

                        if (nonBillableActivityCodeList.contains(timecardEntry.getTimecardActivity().getCode())) {

                            if (agent == null) {
                                agent = syncAgentService.systemGetByObject(timecardEntry.getAgent());
                            }
                            if (agent != null && teamLeader == null) {
                                teamLeader = agent.getTeamLeader();
                            }

                            if (agent != null && teamLeader != null) {
                                NonBillableActivityNotification nonBillableActivityNotification = new NonBillableActivityNotification();
                                nonBillableActivityNotification.setID(UUID.randomUUID().toString());
                                nonBillableActivityNotification.setAgent(agent);
                                nonBillableActivityNotification.setCreatedOn(new Date());
                                nonBillableActivityNotification.setTeamLeader(teamLeader);
                                nonBillableActivityNotification.setName(NonBillableActivityNotification.class.getName() + "-" + timecardEntry.getTimecardActivity().getCode());
                                nonBillableActivityNotification.setType(NonBillableActivityNotification.class.getName());
                                nonBillableActivityNotification.setTimecardActivity(timecardEntry.getTimecardActivity());
//								nonBillableActivityNotification.setMessage();
//								workModeOccurrenceNotification.setLOBConfiguration();
//								workModeOccurrenceNotification.setLOBConfigurationEntry();
                                syncAgentService.systemCreateObject(nonBillableActivityNotification, null);
                            }
                        }

                        // 3.


                        // 4.

                    }

                }
            }
        } catch (Exception e) {
            // Handle exception
            log.error("Error in LOB Notification", e);
        }
    }

}
