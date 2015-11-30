package com.pulse.sync.cw;

import java.util.*;

import javax.annotation.PostConstruct;

import com.pulse.mo.*;
import org.apache.commons.codec.language.DoubleMetaphone;
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

    private boolean watcherEnabled = false;
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
        //Do not register watcher to avoid lots activity in local instance and avoid log.
        if (!watcherEnabled){
            return;
        }
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

                        //Work Mode Duration
                        //For the watched CMSEntry,
                        //Use the AuxCode in the Entry and look into the configuration.
                        //Use min and max value associated with it to check the duration is within the allowed range.
                        //In condition fails, generate notification
                        //For now AuxCode look-up is assumed and possible retrived min/max is hard-coded in the logic.

//                        cmsEntry.getCMSAuxMode()
                        if (agent == null) {
                            agent = syncAgentService.systemGetByObject(cmsEntry.getAgent());
                        }

                        if (agent != null) {
                            if (agent.getAgentLOBs().size() == 1) {
                                //Valid scenario for notification
                                AgentLOB agentLOB = syncAgentService.systemGetByObject(agent.getAgentLOBs().get(0));
                                if (agentLOB != null) {
                                    LOB lob = syncAgentService.systemGetByObject(agentLOB.getLOB());
                                    if (lob != null) {
                                        List<LOBConfiguration> lobConfigurationList = lob.getLOBConfigurations();
                                        if (lobConfigurationList != null) {
                                            LOBConfiguration lobConfiguration = syncAgentService.systemGetByObject(lobConfigurationList.get(0));
                                            Iterator<LOBConfigurationEntry> itrLobConfigurationEntry = lobConfiguration.getLOBConfigurationEntries().iterator();
                                            while (itrLobConfigurationEntry.hasNext()) {
                                                LOBConfigurationEntry lobConfigurationEntry = syncAgentService.systemGetByObject(itrLobConfigurationEntry.next());
                                                if (lobConfigurationEntry.getCMSAuxCode() != null &&
                                                        cmsEntry.getCMSAuxMode() != null &&
                                                        lobConfigurationEntry.getCMSAuxCode().equals(cmsEntry.getCMSAuxMode())) {

                                                    generateWorkDurationNotification(cmsEntry, agent, teamLeader, lobConfigurationEntry);
                                                }
                                            }

                                        }
                                    }
                                }
                            } else {
                                //Not a Valid scenario for notification
                                // Do not send notification
                                log.info("****** CMS Entry based notification is not generated due to following configuration ******");
                                log.info("Agent : " + agent.getID() + " : CMSEntry : " + cmsEntry.getID() + " having AgentLOB Count (" + agent.getAgentLOBs().size() + ") - But only ONE AgentLOB expected" );
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

                        // 1. eStart InValid Activity code

                        //For the watched TimecarEntry,
                        //Use the ActivityCode in the Entry and look into the configuration Along with key for "NON-BILLABLE" (Still need to be decided for the key).
                        //If timecardEntry.getTimecardActivity().getCode() is in the list of activitycode retrived from LOBConfig, it is nonbillable activity code
                        //In condition fails, generate notification


                        if (agent != null) {
                            if (agent.getAgentLOBs().size() == 1) {
                                //Valid scenario for notification
                                //Pick up the first AgentLOB because it is assumed that if Agent has other than 1 AgentLOB it is invalid scenario for Notification
                                AgentLOB agentLOB = syncAgentService.systemGetByObject(agent.getAgentLOBs().get(0));

                                if (agentLOB != null) {

                                    LOB lob = syncAgentService.systemGetByObject(agentLOB.getLOB());

                                    if (lob != null) {

                                        List<LOBConfiguration> lobConfigurationList = lob.getLOBConfigurations();

                                        if (lobConfigurationList != null & lobConfigurationList.size() > 0) {

                                            //Since the AgentLOB is associative entity between Agent and LOB it is always one to one relation.
                                            // LobConfiguration has lob Id which support the 1 to 1 relationship hence it is assumed to have only one recode and always pick
                                            // the first record.
                                            // TODO: TO BE CONFIRMED WITH RICHARD.
                                            LOBConfiguration lobConfiguration = syncAgentService.systemGetByObject(lobConfigurationList.get(0));

                                            List<String> validActivityCodeList = new ArrayList<String>();
                                            List<String> nonBillableActivityCodeList = new ArrayList<String>();

                                            Iterator<LOBConfigurationEntry> itrLobConfigurationEntry = lobConfiguration.getLOBConfigurationEntries().iterator();

                                            while (itrLobConfigurationEntry.hasNext()) {

                                                LOBConfigurationEntry lobConfigurationEntry = syncAgentService.systemGetByObject(itrLobConfigurationEntry.next());

                                                if (lobConfigurationEntry.getType() != null && lobConfigurationEntry.getEStartActivityCode() != null) {

                                                    if (lobConfigurationEntry.getType().equals("VALID_ACTIVITY_CODE")) {

                                                        validActivityCodeList.add(lobConfigurationEntry.getType());

                                                    } else if (lobConfigurationEntry.getType().equals("NONBILLABLE_ACTIVITY_CODE")) {

                                                        nonBillableActivityCodeList.add(lobConfigurationEntry.getType());

                                                    }

                                                }
                                            }

                                            //Generate Invalid Activity Code Notification if TimecardEntry Activity's activity code is not in the list of valid code
                                            generateInvalidActivityCodeNotification(timecardEntry, agent, teamLeader, validActivityCodeList);

                                            //Generate NonBillable Activity Code Notification if TimecardEntry Activity's activity code is in the list of NonBillable code
                                            generateNonBillableActivityCodeNotification(timecardEntry, agent, teamLeader, nonBillableActivityCodeList);

                                        }

                                    }
                                }
                            }
                        } else {

                            //Not a Valid scenario for notification
                            // Do not send notification
                            log.info("****** TimeCard Entry based notification is not generated due to following configuration ******");
                            log.info("Agent : " + agent.getID() + " : TimecardEntry : " + timecardEntry.getID() + " having AgentLOB Count (" + agent.getAgentLOBs().size() + ") - But only ONE AgentLOB expected" );
                        }
                    }


                    // 3.


                    // 4.

                }

            }
        } catch (Exception e) {
            // Handle exception
            log.error("Error in LOB Notification", e);
        }
    }


    private void generateWorkDurationNotification(CMSEntry cmsEntry, Agent agent, TeamLeader teamLeader, LOBConfigurationEntry lobConfigurationEntry) throws Exception {

        Double DURATION_MIN = Double.valueOf(lobConfigurationEntry.getMin());
        Double DURATION_MAX = Double.valueOf(lobConfigurationEntry.getMax());

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
    }

    private void generateInvalidActivityCodeNotification(TimecardEntry timecardEntry, Agent agent, TeamLeader teamLeader, List<String> validActivityCodeList) throws Exception {


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


//								invalidActivityCodeNotification.setMessage();
//								invalidActivityCodeNotification.setLOBConfiguration();
//								invalidActivityCodeNotification.setLOBConfigurationEntry();
                syncAgentService.systemCreateObject(invalidActivityCodeNotification, null);
            }
        }
    }

    private void generateNonBillableActivityCodeNotification(TimecardEntry timecardEntry, Agent agent, TeamLeader teamLeader, List<String> nonBillableActivityCodeList) throws Exception {


        if (!nonBillableActivityCodeList.contains(timecardEntry.getTimecardActivity().getCode())) {

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
//								nonBillableActivityNotification.setLOBConfiguration();
//								nonBillableActivityNotification.setLOBConfigurationEntry();
                syncAgentService.systemCreateObject(nonBillableActivityNotification, null);
            }
        }
    }
}
