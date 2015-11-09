package com.pulse.sync.cw;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.DateTimeComparator;
import org.joda.time.Days;
import org.springframework.stereotype.Component;

import com.percero.agents.sync.cw.DerivedValueChangeWatcherHelper;
import com.percero.agents.sync.vo.BaseDataObject;
import com.percero.agents.sync.vo.ClassIDPair;
import com.pulse.mo.Agent;
import com.pulse.mo.Notification;
import com.pulse.mo.ShiftStatusNotification;
import com.pulse.mo.TeamLeader;
import com.pulse.mo.Timecard;

@Component
public class TimecardCWHelper extends DerivedValueChangeWatcherHelper {

    private static final Logger log = Logger.getLogger(TimecardCWHelper.class);


    public static final String SHIFT = "shift";
    public static final String CURRENTSTATUS = "currentStatus";


    @Override
    public Object calculate(String fieldName, ClassIDPair pair) {
        return calculate(fieldName, pair, null);
    }

    @Override
    public Object calculate(String fieldName, ClassIDPair pair, String[] params) {
        Object result = null;
        Object oldValue = null;
        try {
            oldValue = accessManager.getChangeWatcherResult(pair, fieldName, params);
        } catch (Exception e) {
        }

        if (fieldName.equalsIgnoreCase("shiftStatusNotification")) {
            try {
                result = calc_shiftStatusNotification(pair);
                postCalculate(fieldName, pair, params, result, oldValue);
            } catch (Exception e) {
                log.error("Unable to calculate shiftStatusNotification", e);
            }
        } else if (fieldName.equalsIgnoreCase("shift")) {
            try {
                result = calc_shift(pair, SHIFT);
                postCalculate(fieldName, pair, params, result, oldValue);
            } catch (Exception e) {
                log.error("Unable to calculate shift", e);
            }
        } else if (fieldName.equalsIgnoreCase("currentStatus")) {
            try {
                result = calc_currentStatus(pair, CURRENTSTATUS);
                postCalculate(fieldName, pair, params, result, oldValue);
            } catch (Exception e) {
                log.error("Unable to calculate currentStatus", e);
            }
        } else {
            result = super.calculate(fieldName, pair, params);
        }

        return result;
    }

    private Boolean calc_shift(ClassIDPair pair, String derivedValueName) {
        Boolean result = Boolean.FALSE;

        try {
                       Timecard host = (Timecard) syncAgentService.systemGetById(pair);
            if (host == null) {
                log.warn("Unable to calculate shift: Invalid objectId");
                return result;
            }


            // Setup fieldsToWatch.
            Collection<String> fieldsToWatch = new HashSet<String>();

            // We want to re-trigger this change watcher when Timecard.date changes.
            accessManager.addWatcherField(pair, "startDate", fieldsToWatch);
            // We want to re-trigger this change watcher when Timecard.endDate changes.
            accessManager.addWatcherField(pair, "endDate", fieldsToWatch);

            DateTime timecardStartDateTime = new DateTime(host.getStartDate());
            DateTime timecardEndDateTime = new DateTime(host.getEndDate());

            //Business Logic: NO SHIFT -- would be based on the ON_TIME/startDate field and the OFF_TIME/endDate field having dates but 0:00 as the time in both fields

            if (isZeroHourOfDay(timecardStartDateTime) && isZeroHourOfDay(timecardEndDateTime)) {
                //Shift yet not started
                result = Boolean.FALSE;
            }
            else{
                //Shift is started
                result = Boolean.TRUE;
            }

            accessManager.updateWatcherFields(pair, derivedValueName, fieldsToWatch);

            // Store the result for caching, and also for comparing new results to see if there has been a change.
            accessManager.saveChangeWatcherResult(pair, derivedValueName, result);

        } catch (Exception e) {
            log.error("Unable to calculate shift", e);
        }
        return result;
    }

    private String calc_currentStatus(ClassIDPair pair, String derivedValueName) {
        String result = null;

        try {
            Timecard host = (Timecard) syncAgentService.systemGetById(pair);
            if (host == null) {
                log.warn("Unable to calculate currentStatus: Invalid objectId");
                return result;
            }


            // Setup fieldsToWatch.
            Collection<String> fieldsToWatch = new HashSet<String>();

            // We want to re-trigger this change watcher when Timecard.date changes.
            accessManager.addWatcherField(pair, "startDate", fieldsToWatch);
            // We want to re-trigger this change watcher when Timecard.endDate changes.
            accessManager.addWatcherField(pair, "endDate", fieldsToWatch);

            DateTime timecardDateTime = new DateTime(host.getDate());
            DateTime timecardEndDateTime = new DateTime(host.getEndDate());


/*
            UNKNOWN --> NOT STARTED --> IN PROGRESS --> COMPLETED
            
            IN PROGRESS - would be based on the ON_TIME field and the OFF_TIME field for the
            CURRENT DAY, and the actual time it is based on the timezone for that agent.
            For example if it is 14:12 on 11/5 and the OFF_TIME is 14:45 which is Greater than
            the actual time of day it is for the agent (the agent local time), then she's still IN PROGRESS

            COMPLETED - would be based on the reverse of IN PROGRESS, if the time of day is less that the actual
            time of day it is for the agents current time zone, then their shift is complete. For example if
            the OFF_TIME field equals 13:30 on 11/5 and teh current time is 14:12 CST (and that is the agents
            local time), then that agents shift is COMPLETED
*/

            accessManager.updateWatcherFields(pair, derivedValueName, fieldsToWatch);

            // Store the result for caching, and also for comparing new results to see if there has been a change.
            accessManager.saveChangeWatcherResult(pair, derivedValueName, result);

        } catch (Exception e) {
            log.error("Unable to calculate currentStatus", e);
        }
        return result;
    }


    public ClassIDPair calc_shiftStatusNotification(ClassIDPair pair) {
        ClassIDPair result = null;

        try {
            Timecard host = (Timecard) syncAgentService.systemGetById(pair);
            if (host == null) {
                log.warn("Unable to calculate shiftStatusNotification: Invalid objectId");
                return result;
            }

            // Setup fieldsToWatch.
            Collection<String> fieldsToWatch = new HashSet<String>();

            // We want to re-trigger this change watcher when Timecard.date changes.
            accessManager.addWatcherField(pair, "date", fieldsToWatch);
            // We want to re-trigger this change watcher when Timecard.endDate changes.
            accessManager.addWatcherField(pair, "endDate", fieldsToWatch);

            DateTime timecardDateTime = new DateTime(host.getDate());
            DateTime timecardEndDateTime = new DateTime(host.getEndDate());
            int daysBetweem = Math.abs(Days.daysBetween(timecardDateTime, timecardEndDateTime).getDays());

            // If the Timecard.date < 3 days old
            if (daysBetweem < 3) {
                // Re-trigger this change watcher when AgentScorecard.agent changes.
                accessManager.addWatcherField(pair, "agent", fieldsToWatch);

                // Check to see if there is already a coaching notification created.
                Agent agent = syncAgentService.systemGetByObject(host.getAgent());
                if (agent != null) {
                    // Re-trigger this change watcher when Agent.teamLeader changes.
                    accessManager.addWatcherField(BaseDataObject.toClassIdPair(agent), "teamLeader", fieldsToWatch);
                    TeamLeader teamLeader = syncAgentService.systemGetByObject(agent.getTeamLeader());
                    if (teamLeader != null) {
                        ShiftStatusNotification existingShiftStatusNotification = null;

                        // Re-trigger this change watcher when TeamLeader.notifications changes.
                        accessManager.addWatcherField(BaseDataObject.toClassIdPair(teamLeader), "notifications", fieldsToWatch);
                        Iterator<Notification> itrNotifications = teamLeader.getNotifications().iterator();
                        while (itrNotifications.hasNext()) {
                            Notification nextNotification = itrNotifications.next();
                            if (nextNotification != null && nextNotification instanceof ShiftStatusNotification) {
                                ShiftStatusNotification nextShiftStatusNotification = (ShiftStatusNotification) syncAgentService.systemGetByObject(nextNotification);

                                if (nextShiftStatusNotification == null) {
                                    continue;
                                }

                                // Re-trigger this change watcher when ShiftStatusNotification.shiftEndDate changes.
                                accessManager.addWatcherField(BaseDataObject.toClassIdPair(nextShiftStatusNotification), "shiftEndDate", fieldsToWatch);

                                DateTime nextShiftStatusNotificationWeekDate = new DateTime(nextShiftStatusNotification.getShiftEndDate());
                                // If AgentScorecard.weekDate == ShiftStatusNotification.weekDate, we found a match.
                                if (DateTimeComparator.getDateOnlyInstance().compare(timecardDateTime, nextShiftStatusNotificationWeekDate) == 0) {
                                    existingShiftStatusNotification = nextShiftStatusNotification;
                                    break;
                                }
                            }
                        }

                        if (existingShiftStatusNotification == null) {
                            existingShiftStatusNotification = new ShiftStatusNotification();
                            existingShiftStatusNotification.setID(UUID.randomUUID().toString());
                            existingShiftStatusNotification.setCreatedOn(new Date());
                            existingShiftStatusNotification.setName("Shift Status");
                            existingShiftStatusNotification.setType("ShiftStatusNotification");
                            existingShiftStatusNotification.setTeamLeader(teamLeader);
                            existingShiftStatusNotification.setShiftEndDate(host.getEndDate());
                            existingShiftStatusNotification = syncAgentService.systemCreateObject(existingShiftStatusNotification, null);
                        }

                        result = BaseDataObject.toClassIdPair(existingShiftStatusNotification);
                    }
                }
            }

            // Register all the fields to watch for this ChangeWatcher. Whenever
            // ANY of these fields change, this ChangeWatcher will get re-run
            accessManager.updateWatcherFields(pair, "shiftStatusNotification", fieldsToWatch);

            // Store the result for caching, and also for comparing new results to see if there has been a change.
            accessManager.saveChangeWatcherResult(pair, "shiftStatusNotification", result);
        } catch (Exception e) {
            log.error("Unable to calculate shiftStatusNotification", e);
        }

        return result;
    }



    private Boolean isZeroHourOfDay(DateTime dateTime){
        if(dateTime.getHourOfDay()==0 && dateTime.getMinuteOfDay()==0 && dateTime.getSecondOfDay()==0){

            return true;
        }
        return  false;
    }
}
