package com.pulse.sync.cw;

import java.util.*;

import com.pulse.mo.*;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.DateTimeComparator;
import org.joda.time.DateTimeZone;
import org.joda.time.Days;
import org.springframework.stereotype.Component;

import com.percero.agents.sync.cw.DerivedValueChangeWatcherHelper;
import com.percero.agents.sync.vo.BaseDataObject;
import com.percero.agents.sync.vo.ClassIDPair;
import com.pulse.sync.enums.TimecardStatus;

@Component
public class TimecardCWHelper extends DerivedValueChangeWatcherHelper {

    private static final Logger log = Logger.getLogger(TimecardCWHelper.class);


    public static final String SHIFT_STATUS_NOTIFICATION = "shiftStatusNotification";
    public static final String SHIFT = "shift";
    public static final String CURRENTSTATUS = "currentStatus";
    public static final String STARTDATE = "startDate";
    public static final String ENDDATE = "endDate";
    public static final String AGENT_TIME_ZONE = "agentTimeZone";
    public static final String TIME_ZONE = "agenttTimeZone";
    public static final String IEX = "iEX";


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

        if (fieldName.equalsIgnoreCase(SHIFT_STATUS_NOTIFICATION)) {
            try {
                result = calc_shiftStatusNotification(pair);
                postCalculate(fieldName, pair, params, result, oldValue);
            } catch (Exception e) {
                log.error("Unable to calculate " + SHIFT_STATUS_NOTIFICATION, e);
            }
        } else if (fieldName.equalsIgnoreCase(TIME_ZONE)) {
            try {
                result = calc_timeZone(pair, TIME_ZONE);
                postCalculate(fieldName, pair, params, result, oldValue);
            } catch (Exception e) {
                log.error("Unable to calculate " + TIME_ZONE, e);
            }
        } else if (fieldName.equalsIgnoreCase(AGENT_TIME_ZONE)) {
            try {
                result = calc_agentTimeZone(pair, AGENT_TIME_ZONE);
                postCalculate(fieldName, pair, params, result, oldValue);
            } catch (Exception e) {
                log.error("Unable to calculate " + AGENT_TIME_ZONE, e);
            }
        } else if (SHIFT.equalsIgnoreCase(fieldName)) {
            try {
                result = calc_shift(pair, SHIFT);
                postCalculate(fieldName, pair, params, result, oldValue);
            } catch (Exception e) {
                log.error("Unable to calculate " + SHIFT, e);
            }
        } else if (fieldName.equalsIgnoreCase(CURRENTSTATUS)) {
            try {
                result = calc_currentStatus(pair, CURRENTSTATUS);
                postCalculate(fieldName, pair, params, result, oldValue);
            } catch (Exception e) {
                log.error("Unable to calculate " + CURRENTSTATUS, e);
            }
        } else if (fieldName.equalsIgnoreCase(STARTDATE)) {
            try {
                result = calc_startDate(pair, fieldName);
                postCalculate(fieldName, pair, params, result, oldValue);
            } catch (Exception e) {
                log.error("Unable to calculate " + STARTDATE, e);
            }
        } else if (fieldName.equalsIgnoreCase(ENDDATE)) {
            try {
                result = calc_endDate(pair, fieldName);
                postCalculate(fieldName, pair, params, result, oldValue);
            } catch (Exception e) {
                log.error("Unable to calculate " + ENDDATE, e);
            }
        } else if (fieldName.equalsIgnoreCase(IEX)) {
            try {
                result = calc_iEX(pair, fieldName);
                postCalculate(fieldName, pair, params, result, oldValue);
            } catch (Exception e) {
                log.error("Unable to calculate " + IEX, e);
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
                log.warn("Unable to calculate " + derivedValueName + ": Invalid objectId " + pair.getClassName() + "::" + pair.getID());
                return result;
            }


            // Setup fieldsToWatch.
            Collection<String> fieldsToWatch = new HashSet<String>();

            // We want to re-trigger this change watcher when Timecard.date changes.
            accessManager.addWatcherField(pair, "startDate", fieldsToWatch);
            // We want to re-trigger this change watcher when Timecard.endDate changes.
            accessManager.addWatcherField(pair, "endDate", fieldsToWatch);

            accessManager.addWatcherField(pair, "iEX", fieldsToWatch);

            DateTime timecardStartDateTime = new DateTime(host.getStartDate());
            DateTime timecardEndDateTime = new DateTime(host.getEndDate());
            Boolean iEXForForTheShiftExists = host.getIEX();
            // Business Logic: NO SHIFT -- would be based on the
            // ON_TIME/startDate field and the OFF_TIME/endDate field having
            // dates but 0:00 as the time in both fields
            // OR ON_TIME/startDate >= OFF_TIME/endDate

//            if ((isZeroHourOfDay(timecardStartDateTime) && isZeroHourOfDay(timecardEndDateTime)) || timecardEndDateTime.isBefore(timecardStartDateTime) || timecardEndDateTime.isEqual(timecardStartDateTime)) {
            //Logic to determine
            //NO_SHIFT means : If IEX schedule for the agent for the day DOES NOT EXIST. Additional condition (but not mendatory) If startDateTime and endDateTime is 00:00
            //SHIFT_NOT_STARTED : If IEX schedule for the agent for the day EXISTS. Additional condition (but not mendatory) If startDateTime and endDateTime is 00:00
            //


            if (!iEXForForTheShiftExists && isZeroHourOfDay(timecardStartDateTime) && isZeroHourOfDay(timecardEndDateTime)) {
//            if (isZeroHourOfDay(timecardStartDateTime) && isZeroHourOfDay(timecardEndDateTime)) {
//            if (!iEXForForTheShiftExists) {
                //No Shift
                result = Boolean.FALSE;
            } else {
                //Shift there a shift
                result = Boolean.TRUE;
            }


            accessManager.updateWatcherFields(pair, derivedValueName, fieldsToWatch);

            // Store the result for caching, and also for comparing new results to see if there has been a change.
            accessManager.saveChangeWatcherResult(pair, derivedValueName, result);

        } catch (Exception e) {
            log.error("Unable to calculate " + derivedValueName, e);
        }
        return result;
    }

    private String calc_currentStatus(ClassIDPair pair, String derivedValueName) {
        String result = null;

        try {
            Timecard host = (Timecard) syncAgentService.systemGetById(pair);
            if (host == null) {
                log.warn("Unable to calculate " + derivedValueName + ": Invalid objectId " + pair.getClassName() + "::" + pair.getID());
                return result;
            }


            // Setup fieldsToWatch.
            Collection<String> fieldsToWatch = new HashSet<String>();

            /**
             UNKNOWN --> NOT STARTED --> IN PROGRESS --> COMPLETED --> APPROVED
             IN PROGRESS - would be based on the ON_TIME field and the OFF_TIME field for the
             CURRENT DAY, and the actual time it is based on the timezone for that agent.
             For example if it is 14:12 on 11/5 and the OFF_TIME is 14:45 which is Greater than
             the actual time of day it is for the agent (the agent local time), then she's still IN PROGRESS
             COMPLETED - would be based on the reverse of IN PROGRESS, if the time of day is less that the actual
             time of day it is for the agents current time zone, then their shift is complete. For example if
             the OFF_TIME field equals 13:30 on 11/5 and teh current time is 14:12 CST (and that is the agents
             local time), then that agents shift is COMPLETED
             */

            accessManager.addWatcherField(pair, "approved", fieldsToWatch);
            String approved = host.getApproved();
            if ("t".equalsIgnoreCase(approved)
                    || "true".equalsIgnoreCase(approved)
                    || "y".equalsIgnoreCase(approved)
                    || "yes".equalsIgnoreCase(approved)) {
                // Timecard has been APPROVED
                result = TimecardStatus.APPROVED.getValue();
            } else {
                // We want to re-trigger this change watcher when Timecard.shift changes.
                accessManager.addWatcherField(pair, "shift", fieldsToWatch);
                Boolean shift = host.getShift();

                if (!shift) {
                    // The Timecard does NOT have a shift.
                    result = TimecardStatus.NO_SHIFT.getValue();
                } else {
                    // The Timecard DOES have a shift.
                    // We want to re-trigger this change watcher when Timecard.date changes.
                    accessManager.addWatcherField(pair, "startDate", fieldsToWatch);
                    // We want to re-trigger this change watcher when Timecard.endDate changes.
                    accessManager.addWatcherField(pair, "endDate", fieldsToWatch);

                    accessManager.addWatcherField(pair, "iEX", fieldsToWatch);
                    // Timecard.StartDate and Timecard.EndDate appear to also carry
                    // the timezone. We can compare
                    // to the current time using milliseconds since 0 (ie. compare
                    // UTC time) using the Joda DateTime object.
                    // http://www.joda.org/joda-time/


                    Boolean iEXForForTheShiftExists = host.getIEX();

                    DateTime timecardStartDateTime = new DateTime(host.getStartDate());
                    DateTime timecardEndDateTime = new DateTime(host.getEndDate());

                    DateTime currentTime = new DateTime(System.currentTimeMillis());

                    //SHIFT_NOT_STARTED : If IEX schedule for the agent for the day EXISTS. Additional condition (but not mendatory) If startDateTime and endDateTime is 00:00
//                    if (currentTime.isBefore(timecardStartDateTime)) {
                    //Source date should be used in this first condition because we need 00:00:00 from the date, if we apply any change to it using timezone it is incorrect
                    if (iEXForForTheShiftExists && isZeroHourOfDay(new DateTime(host.getSourceStartDate())) && isZeroHourOfDay(new DateTime(host.getSourceEndDate()))) {
                        // Local time is BEFORE the time card start date, so status is NOT_STARTED
                        result = TimecardStatus.NOT_STARTED.getValue();
                    } else if (currentTime.isBefore(timecardEndDateTime)) {
                        // Local time is AFTER the time card start date and BEFORE the timecard end date, so status is IN_PROGRESS
                        result = TimecardStatus.IN_PROGRESS.getValue();
                    } else {
                        // Local time is AFTER the timecard end dtae, so status is COMPLETED
                        result = TimecardStatus.COMPLETED.getValue();
                    }
                }
            }


            accessManager.updateWatcherFields(pair, derivedValueName, fieldsToWatch);

            // Store the result for caching, and also for comparing new results to see if there has been a change.
            accessManager.saveChangeWatcherResult(pair, derivedValueName, result);

        } catch (Exception e) {
            log.error("Unable to calculate " + derivedValueName, e);
        }
        return result;
    }


    public ClassIDPair calc_shiftStatusNotification(ClassIDPair pair) {
        ClassIDPair result = null;

        try {
            Timecard host = (Timecard) syncAgentService.systemGetById(pair);
            if (host == null) {
                log.warn("Unable to calculate shiftStatusNotification: Invalid objectId " + pair.getClassName() + "::" + pair.getID());
                return result;
            }

            // Setup fieldsToWatch.
            Collection<String> fieldsToWatch = new HashSet<String>();

            // We want to re-trigger this change watcher when Timecard.date changes.
            accessManager.addWatcherField(pair, "date", fieldsToWatch);
            // We want to re-trigger this change watcher when Timecard.endDate changes.
            accessManager.addWatcherField(pair, "endDate", fieldsToWatch);

            DateTime timecardDateTime = new DateTime(host.getDate());
            DateTime timecardEndDateTime = new DateTime(host.getSourceEndDate());
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


    private Boolean isZeroHourOfDay(DateTime dateTime) {
        if (dateTime.getHourOfDay() == 0 && dateTime.getMinuteOfDay() == 0 && dateTime.getSecondOfDay() == 0) {

            return true;
        }
        return false;
    }


    public ClassIDPair calc_agentTimeZone(ClassIDPair pair, String derivedValueName) {
        ClassIDPair result = null;

        try {
            Timecard host = (Timecard) syncAgentService.systemGetById(pair);
            if (host == null) {
                log.warn("Unable to calculate " + derivedValueName + ": Invalid objectId " + pair.getClassName() + "::" + pair.getID());
                return result;
            }

            // Setup fieldsToWatch.
            Collection<String> fieldsToWatch = new HashSet<String>();

            // We want to re-trigger this change watcher when AgentScorecard.weekDate changes.
            accessManager.addWatcherField(pair, "agent", fieldsToWatch);
            Agent agent = syncAgentService.systemGetByObject(host.getAgent());
            if (agent != null) {
                accessManager.addWatcherField(BaseDataObject.toClassIdPair(agent), "agentTimeZone", fieldsToWatch);
                AgentTimeZone agentTimeZone = agent.getAgentTimeZone();    // We only need the ID here, so don't load from the database.
                if (agentTimeZone != null) {
                    result = BaseDataObject.toClassIdPair(agentTimeZone);
                } else {
                    log.warn("Unable to get AgentTimeZone, using SourceStartDate as StartDate");
                }
            } else {
                log.warn("Unable to get AgentTimeZone, using SourceStartDate as StartDate");
            }

            // Register all the fields to watch for this ChangeWatcher. Whenever
            // ANY of these fields change, this ChangeWatcher will get re-run
            accessManager.updateWatcherFields(pair, derivedValueName, fieldsToWatch);

            // Store the result for caching, and also for comparing new results to see if there has been a change.
            accessManager.saveChangeWatcherResult(pair, derivedValueName, result);
        } catch (Exception e) {
            log.error("Unable to calculate " + derivedValueName, e);
        }

        return result;
    }

    public String calc_timeZone(ClassIDPair pair, String derivedValueName) {
        String result = null;

        try {
            Timecard host = (Timecard) syncAgentService.systemGetById(pair);
            if (host == null) {
                log.warn("Unable to calculate " + derivedValueName + ": Invalid objectId " + pair.getClassName() + "::" + pair.getID());
                return result;
            }

            // Setup fieldsToWatch.
            Collection<String> fieldsToWatch = new HashSet<String>();

            // We want to re-trigger this change watcher when AgentScorecard.weekDate changes.
            accessManager.addWatcherField(pair, "agentTimeZone", fieldsToWatch);
            AgentTimeZone agentTimeZone = host.getAgentTimeZone();
            if (agentTimeZone != null) {
                accessManager.addWatcherField(BaseDataObject.toClassIdPair(agentTimeZone), "timeZone", fieldsToWatch);
                try {
                    result = agentTimeZone.getTimeZone();
                } catch (Exception e) {
                    // Invalid time zone.
                    log.error("Invalid time zone " + agentTimeZone.getTimeZone(), e);
                }
            } else {
                log.warn("Unable to get AgentTimeZone, using SourceStartDate as StartDate");
            }

            // Register all the fields to watch for this ChangeWatcher. Whenever
            // ANY of these fields change, this ChangeWatcher will get re-run
            accessManager.updateWatcherFields(pair, derivedValueName, fieldsToWatch);

            // Store the result for caching, and also for comparing new results to see if there has been a change.
            accessManager.saveChangeWatcherResult(pair, derivedValueName, result);
        } catch (Exception e) {
            log.error("Unable to calculate " + derivedValueName, e);
        }

        return result;
    }

    public Date calc_startDate(ClassIDPair pair, String derivedValueName) {
        Date result = null;

        try {
            Timecard host = (Timecard) syncAgentService.systemGetById(pair);
            if (host == null) {
                log.warn("Unable to calculate " + derivedValueName + ": Invalid objectId " + pair.getClassName() + "::" + pair.getID());
                return result;
            }

            // Setup fieldsToWatch.
            Collection<String> fieldsToWatch = new HashSet<String>();

            // We want to re-trigger this change watcher when AgentScorecard.weekDate changes.
            accessManager.addWatcherField(pair, "sourceStartDate", fieldsToWatch);
            Date sourceStartDate = host.getSourceStartDate();

            if (sourceStartDate != null && sourceStartDate.getTime() > 0) {
                accessManager.addWatcherField(pair, TIME_ZONE, fieldsToWatch);
                try {
                    DateTimeZone dateTimeZone = DateTimeZone.forID(host.getTimeZone());
                    if (dateTimeZone != null) {
                        int offsetInMs = dateTimeZone.getOffset(System.currentTimeMillis());

                        // The Source Time MINUS the Offset gives us UTC.
                        DateTime startDate = new DateTime(sourceStartDate.getTime() - offsetInMs);
                        result = startDate.toDate();
                    } else {
                        log.warn("Invalid time zone " + host.getTimeZone());
                    }
                } catch (Exception e) {
                    // Invalid time zone.
                    log.error("Invalid time zone " + host.getTimeZone(), e);
                }
            }

            if (result == null) {
                result = sourceStartDate;
            }

            // Register all the fields to watch for this ChangeWatcher. Whenever
            // ANY of these fields change, this ChangeWatcher will get re-run
            accessManager.updateWatcherFields(pair, derivedValueName, fieldsToWatch);

            // Store the result for caching, and also for comparing new results to see if there has been a change.
            accessManager.saveChangeWatcherResult(pair, derivedValueName, result);
        } catch (Exception e) {
            log.error("Unable to calculate " + derivedValueName, e);
        }

        return result;
    }

    public Date calc_endDate(ClassIDPair pair, String derivedValueName) {
        Date result = null;

        try {
            Timecard host = (Timecard) syncAgentService.systemGetById(pair);
            if (host == null) {
                log.warn("Unable to calculate " + derivedValueName + ": Invalid objectId " + pair.getClassName() + "::" + pair.getID());
                return result;
            }

            // Setup fieldsToWatch.
            Collection<String> fieldsToWatch = new HashSet<String>();

            // We want to re-trigger this change watcher when AgentScorecard.weekDate changes.
            accessManager.addWatcherField(pair, "sourceEndDate", fieldsToWatch);
            Date sourceEndDate = host.getSourceEndDate();

            if (sourceEndDate != null && sourceEndDate.getTime() > 0) {
                accessManager.addWatcherField(pair, TIME_ZONE, fieldsToWatch);
                try {
                    DateTimeZone dateTimeZone = DateTimeZone.forID(host.getTimeZone());
                    if (dateTimeZone != null) {
                        int offsetInMs = dateTimeZone.getOffset(System.currentTimeMillis());

                        // The Source Time MINUS the Offset gives us UTC.
                        DateTime endDate = new DateTime(sourceEndDate.getTime() - offsetInMs);
                        result = endDate.toDate();
                    } else {
                        log.warn("Invalid time zone " + host.getTimeZone());
                    }
                } catch (Exception e) {
                    // Invalid time zone.
                    log.error("Invalid time zone " + host.getTimeZone(), e);
                }
            }

            if (result == null) {
                result = sourceEndDate;
            }

            // Register all the fields to watch for this ChangeWatcher. Whenever
            // ANY of these fields change, this ChangeWatcher will get re-run
            accessManager.updateWatcherFields(pair, derivedValueName, fieldsToWatch);

            // Store the result for caching, and also for comparing new results to see if there has been a change.
            accessManager.saveChangeWatcherResult(pair, derivedValueName, result);
        } catch (Exception e) {
            log.error("Unable to calculate " + derivedValueName, e);
        }

        return result;
    }

    private Boolean calc_iEX(ClassIDPair pair, String derivedValueName) {
        Boolean result = Boolean.FALSE; // It is considered that there is no IEX entry for the Agent for the Agent

        try {
            Timecard host = (Timecard) syncAgentService.systemGetById(pair);
            if (host == null) {
                log.warn("Unable to calculate " + derivedValueName + ": Invalid objectId " + pair.getClassName() + "::" + pair.getID());
                return result;
            }

            // Setup fieldsToWatch.
            Collection<String> fieldsToWatch = new HashSet<String>();

            // We want to re-trigger this change watcher when AgentScorecard.weekDate changes.
            accessManager.addWatcherField(pair, "agent", fieldsToWatch);
            Agent agent = syncAgentService.systemGetByObject(host.getAgent());
            if (agent != null) {
                accessManager.addWatcherField(BaseDataObject.toClassIdPair(agent), "schedules", fieldsToWatch);
                Iterator<Schedule> itrSchedule = agent.getSchedules().iterator();

                while (itrSchedule.hasNext()) {
                    Schedule schedule = syncAgentService.systemGetByObject(itrSchedule.next());

                    if (schedule.getStartDate().getDay() == host.getStartDate().getDay() &&
                            schedule.getStartDate().getMonth() == host.getStartDate().getMonth() &&
                            schedule.getStartDate().getYear() == host.getStartDate().getYear()) {

                        result = Boolean.TRUE;
                    }
                }


            } else {
                log.warn("Unable to get Agent / schedules");
            }

            // Register all the fields to watch for this ChangeWatcher. Whenever
            // ANY of these fields change, this ChangeWatcher will get re-run
            accessManager.updateWatcherFields(pair, derivedValueName, fieldsToWatch);

            // Store the result for caching, and also for comparing new results to see if there has been a change.
            accessManager.saveChangeWatcherResult(pair, derivedValueName, result);

        } catch (Exception e) {
            log.error("Unable to calculate " + derivedValueName, e);
        }
        return result;
    }

}
