package com.pulse.sync.cw;

import java.util.*;

import com.pulse.mo.*;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.springframework.stereotype.Component;

import com.percero.agents.sync.cw.DerivedValueChangeWatcherHelper;
import com.percero.agents.sync.vo.BaseDataObject;
import com.percero.agents.sync.vo.ClassIDPair;

@Component
public class AgentCWHelper extends DerivedValueChangeWatcherHelper {

    private static final Logger log = Logger.getLogger(AgentCWHelper.class);


    public static final String TIME_ZONE = "agentTimeZone";
    public static final String FIND_CMS_ENTRIES_FOR_DATE = "findCMSEntriesForDate";
    public static final String FIND_TIMECARD_FOR_DATE = "findTimecardForDate";
    public static final String FIND_TIMECARD_ENTRIES_FOR_DATE = "findTimecardEntriesForDate";
    public static final String FIND_SCHEDULE_FOR_DATE = "findScheduleForDate";
    public static final String FIND_SCHEDULE_ENTRIES_FOR_DATE = "findScheduleEntriesForDate";

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

        if (fieldName.equalsIgnoreCase(TIME_ZONE)) {
            try {
                result = calc_timeZone(pair, TIME_ZONE);
                postCalculate(fieldName, pair, params, result, oldValue);
            } catch (Exception e) {
                log.error("Unable to calculate " + TIME_ZONE, e);
            }
        } else if (FIND_CMS_ENTRIES_FOR_DATE.equalsIgnoreCase(fieldName)) {
            try {
                result = calc_findCMSEntriesForDate(pair, FIND_CMS_ENTRIES_FOR_DATE, params[0]);
                postCalculate(fieldName, pair, params, result, oldValue);
            } catch (Exception e) {
                log.error("Unable to calculate " + FIND_CMS_ENTRIES_FOR_DATE, e);
            }
        }
        else if (FIND_TIMECARD_FOR_DATE.equalsIgnoreCase(fieldName)) {
            try {
                result = calc_findTimecardForDate(pair, FIND_TIMECARD_FOR_DATE, params[0]);
                postCalculate(fieldName, pair, params, result, oldValue);
            } catch (Exception e) {
                log.error("Unable to calculate " + FIND_TIMECARD_FOR_DATE, e);
            }
        }
        else if (FIND_TIMECARD_ENTRIES_FOR_DATE.equalsIgnoreCase(fieldName)) {
            try {
                result = calc_findTimecardEntriesForDate(pair, FIND_TIMECARD_ENTRIES_FOR_DATE, params[0]);
                postCalculate(fieldName, pair, params, result, oldValue);
            } catch (Exception e) {
                log.error("Unable to calculate " + FIND_TIMECARD_ENTRIES_FOR_DATE, e);
            }
        }
        else if (FIND_SCHEDULE_ENTRIES_FOR_DATE.equalsIgnoreCase(fieldName)) {
            try {
                result = calc_findScheduleEntriesForDate(pair, FIND_SCHEDULE_ENTRIES_FOR_DATE, params[0]);
                postCalculate(fieldName, pair, params, result, oldValue);
            } catch (Exception e) {
                log.error("Unable to calculate " + FIND_SCHEDULE_ENTRIES_FOR_DATE, e);
            }
        } else if (FIND_SCHEDULE_FOR_DATE.equalsIgnoreCase(fieldName)) {
            try {
                result = calc_findScheduleForDate(pair, FIND_SCHEDULE_FOR_DATE, params[0]);
                postCalculate(fieldName, pair, params, result, oldValue);
            } catch (Exception e) {
                log.error("Unable to calculate " + FIND_SCHEDULE_FOR_DATE, e);
            }
        }
        else {
            result = super.calculate(fieldName, pair, params);
        }

        return result;
    }

    public String calc_timeZone(ClassIDPair pair, String derivedValueName) {
        String result = null;

        try {
            Agent host = (Agent) syncAgentService.systemGetById(pair);
            if (host == null) {
                log.warn("Unable to calculate " + derivedValueName + ": Invalid objectId " + pair.getClassName() + "::" + pair.getID());
                return result;
            }

            // Setup fieldsToWatch.
            Collection<String> fieldsToWatch = new HashSet<String>();

            // We want to re-trigger this change watcher when AgentScorecard.weekDate changes.
            accessManager.addWatcherField(pair, "agentTimeZone", fieldsToWatch);
            AgentTimeZone agentTimeZone = syncAgentService.systemGetByObject(host.getAgentTimeZone());
            if (agentTimeZone != null) {
                accessManager.addWatcherField(BaseDataObject.toClassIdPair(agentTimeZone), "timeZone", fieldsToWatch);
                result = agentTimeZone.getTimeZone();
            } else {
                log.warn("Unable to get AgentTimeZone");
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


    private List<ClassIDPair> calc_findCMSEntriesForDate(ClassIDPair pair, String derivedValueName, String theDate) {
        List<ClassIDPair> results = new ArrayList<ClassIDPair>();

        try {
            Agent host = (Agent) syncAgentService.systemGetById(pair);
            if (host == null) {
                log.warn("Unable to calculate " + derivedValueName + ": Invalid objectId " + pair.getClassName() + "::" + pair.getID());
                return results;
            }

            // Setup params array. If nothing else, this is used to uniquely
            // identify this ChangeWatcher.
            String[] params = new String[1];
            params[0] = theDate;

            // Convert the date String. Since the date string format is completely up to
            // the developer, the build int `parseDateTime` function may or may not be
            // applicable. The point here is to accurately convert the passed in String
            // into a Date object (including its time zone).
            DateTime theDateTime = parseDateTime(theDate);
            LocalDate localDate = theDateTime.toLocalDate(); //Get UTC date for the param date

            // Setup fieldsToWatch.
            Collection<String> fieldsToWatch = new HashSet<String>();


            accessManager.addWatcherField(BaseDataObject.toClassIdPair(host), "cmsEntries", fieldsToWatch);

            String agentTimeZone = host.getTimeZone();


            Iterator<CMSEntry> itrCmsEntries = host.getCMSEntries().iterator();
            while (itrCmsEntries.hasNext()) {
                CMSEntry cmsEntry = syncAgentService.systemGetByObject(itrCmsEntries.next());
                if (cmsEntry != null) {
                    // We want to re-trigger this change watcher when CMSEntry.FromTime changes.
                    accessManager.addWatcherField(BaseDataObject.toClassIdPair(cmsEntry), "fromTime", fieldsToWatch);

                    Date fromTime = cmsEntry.getFromTime();
                    if (fromTime != null) {
                        // Convert the fromTime to the same time zone as the date that was passed in.
                        DateTime fromDateTime = new DateTime(fromTime);

                        fromDateTime = fromDateTime.withZone(theDateTime.getZone());

                        // Check to see if fromTime is the same date as the passed in date.
                        if (fromDateTime.toLocalDate().equals(localDate)) { // Both Date coverted to UTC before comparision
                            // The date matched, so we add this CMSEntry to our set of results.
                            results.add(new ClassIDPair(cmsEntry.getID(), cmsEntry.getClass().getCanonicalName()));
                        }
                    }
                }
            }

            // Register all the fields to watch for this ChangeWatcher. Whenever
            // ANY of these fields change, this ChangeWatcher will get re-run
            // Don't forget to include the params array here, since that is part of what
            // uniquely identifies this ChangeWatcher.
            accessManager.updateWatcherFields(pair, derivedValueName, fieldsToWatch, params);

            // Store the result for caching, and also for comparing new results to see
            // if there has been a change.
            // Don't forget to include the params array here, since that is part of what
            // uniquely identifies this ChangeWatcher.
            accessManager.saveChangeWatcherResult(pair, derivedValueName, results, params);
        } catch (Exception e) {
            log.error("Unable to calculate " + derivedValueName, e);
        }

        return results;
    }

    private ClassIDPair calc_findTimecardForDate(ClassIDPair pair, String derivedValueName, String theDate) {
        ClassIDPair result = null;

        try {
            Agent host = (Agent) syncAgentService.systemGetById(pair);
            if (host == null) {
                log.warn("Unable to calculate " + derivedValueName + ": Invalid objectId " + pair.getClassName() + "::" + pair.getID());
                return result;
            }

            // Setup params array. If nothing else, this is used to uniquely
            // identify this ChangeWatcher.
            String[] params = new String[1];
            params[0] = theDate;

            // Convert the date String. Since the date string format is completely up to
            // the developer, the build int `parseDateTime` function may or may not be
            // applicable. The point here is to accurately convert the passed in String
            // into a Date object (including its time zone).
            DateTime theDateTime = parseDateTime(theDate);
            LocalDate localDate = theDateTime.toLocalDate(); //Date in UTC

            // Setup fieldsToWatch.
            Collection<String> fieldsToWatch = new HashSet<String>();


            accessManager.addWatcherField(BaseDataObject.toClassIdPair(host), "timecards", fieldsToWatch);
            Iterator<Timecard> itrTimecards = host.getTimecards().iterator();
            while (itrTimecards.hasNext()) {
                Timecard timecard = syncAgentService.systemGetByObject(itrTimecards.next());
                if (timecard != null) {
                    // We want to re-trigger this change watcher when CMSEntry.FromTime changes.
                    accessManager.addWatcherField(BaseDataObject.toClassIdPair(timecard), "startDate", fieldsToWatch);

                    Date startDate = timecard.getStartDate();
                    if (startDate != null) {
                        // Convert the fromTime to the same time zone as the date that was passed in.
                        DateTime fromDateTime = new DateTime(startDate);
                        fromDateTime = fromDateTime.withZone(theDateTime.getZone());
                        // Check to see if fromTime is the same date as the passed in date.
                        if (fromDateTime.toLocalDate().equals(localDate)) {
                            // The date matched, so we add this CMSEntry to our set of results.
                            result = new ClassIDPair(timecard.getID(), timecard.getClass().getCanonicalName());
                        }
                    }
                }
            }

            // Register all the fields to watch for this ChangeWatcher. Whenever
            // ANY of these fields change, this ChangeWatcher will get re-run
            // Don't forget to include the params array here, since that is part of what
            // uniquely identifies this ChangeWatcher.
            accessManager.updateWatcherFields(pair, derivedValueName, fieldsToWatch, params);

            // Store the result for caching, and also for comparing new results to see
            // if there has been a change.
            // Don't forget to include the params array here, since that is part of what
            // uniquely identifies this ChangeWatcher.
            accessManager.saveChangeWatcherResult(pair, derivedValueName, result, params);
        } catch (Exception e) {
            log.error("Unable to calculate " + derivedValueName, e);
        }

        return result;
    }

    private List<ClassIDPair> calc_findTimecardEntriesForDate(ClassIDPair pair, String derivedValueName, String theDate) {
        List<ClassIDPair> results = new ArrayList<ClassIDPair>();

        try {
            Agent host = (Agent) syncAgentService.systemGetById(pair);
            if (host == null) {
                log.warn("Unable to calculate " + derivedValueName + ": Invalid objectId " + pair.getClassName() + "::" + pair.getID());
                return results;
            }

            // Setup params array. If nothing else, this is used to uniquely
            // identify this ChangeWatcher.
            String[] params = new String[1];
            params[0] = theDate;

            // Convert the date String. Since the date string format is completely up to
            // the developer, the build int `parseDateTime` function may or may not be
            // applicable. The point here is to accurately convert the passed in String
            // into a Date object (including its time zone).
            DateTime theDateTime = parseDateTime(theDate);
            LocalDate localDate = theDateTime.toLocalDate();

            // Setup fieldsToWatch.
            Collection<String> fieldsToWatch = new HashSet<String>();

            accessManager.addWatcherField(BaseDataObject.toClassIdPair(host), "findTimecardForDate", fieldsToWatch, params);

            Timecard timecard = host.getFindTimecardForDate(theDate);

            Iterator<TimecardEntry> itrTimecardEntries = timecard.getTimecardEntries().iterator();
            while (itrTimecardEntries.hasNext()) {
                TimecardEntry timecardEntry = syncAgentService.systemGetByObject(itrTimecardEntries.next());
                if (timecardEntry != null) {
                    results.add(new ClassIDPair(timecardEntry.getID(), timecardEntry.getClass().getCanonicalName()));
                }
            }

            // Register all the fields to watch for this ChangeWatcher. Whenever
            // ANY of these fields change, this ChangeWatcher will get re-run
            // Don't forget to include the params array here, since that is part of what
            // uniquely identifies this ChangeWatcher.
            accessManager.updateWatcherFields(pair, derivedValueName, fieldsToWatch, params);

            // Store the result for caching, and also for comparing new results to see
            // if there has been a change.
            // Don't forget to include the params array here, since that is part of what
            // uniquely identifies this ChangeWatcher.
            accessManager.saveChangeWatcherResult(pair, derivedValueName, results, params);
        } catch (Exception e) {
            log.error("Unable to calculate " + derivedValueName, e);
        }

        return results;
    }

    private ClassIDPair calc_findScheduleForDate(ClassIDPair pair, String derivedValueName, String theDate) {
        ClassIDPair result = null;

        try {
            Agent host = (Agent) syncAgentService.systemGetById(pair);
            if (host == null) {
                log.warn("Unable to calculate " + derivedValueName + ": Invalid objectId " + pair.getClassName() + "::" + pair.getID());
                return result;
            }

            // Setup params array. If nothing else, this is used to uniquely
            // identify this ChangeWatcher.
            String[] params = new String[1];
            params[0] = theDate;

            // Convert the date String. Since the date string format is completely up to
            // the developer, the build int `parseDateTime` function may or may not be
            // applicable. The point here is to accurately convert the passed in String
            // into a Date object (including its time zone).
            DateTime theDateTime = parseDateTime(theDate);
            LocalDate localDate = theDateTime.toLocalDate();

            // Setup fieldsToWatch.
            Collection<String> fieldsToWatch = new HashSet<String>();

            accessManager.addWatcherField(BaseDataObject.toClassIdPair(host), "schedules", fieldsToWatch);
            Iterator<Schedule> itrSchedules = host.getSchedules().iterator();
            while (itrSchedules.hasNext()) {
                Schedule schedule = syncAgentService.systemGetByObject(itrSchedules.next());
                if (schedule != null) {
                    // We want to re-trigger this change watcher when CMSEntry.FromTime changes.
                    accessManager.addWatcherField(BaseDataObject.toClassIdPair(schedule), "sourceStartTime", fieldsToWatch);

                    Date sourceStartTime = schedule.getSourceStartTime();
                    if (sourceStartTime != null) {
                        // Convert the fromTime to the same time zone as the date that was passed in.
                        DateTime fromDateTime = new DateTime(sourceStartTime);
                        fromDateTime = fromDateTime.withZone(theDateTime.getZone());
                        // Check to see if fromTime is the same date as the passed in date.
                        if (fromDateTime.toLocalDate().equals(localDate)) {//Both time in UTC
                            // The date matched, so we add this CMSEntry to our set of results.
                            result = new ClassIDPair(schedule.getID(), schedule.getClass().getCanonicalName());
                        }
                    }
                }
            }

            // Register all the fields to watch for this ChangeWatcher. Whenever
            // ANY of these fields change, this ChangeWatcher will get re-run
            // Don't forget to include the params array here, since that is part of what
            // uniquely identifies this ChangeWatcher.
            accessManager.updateWatcherFields(pair, derivedValueName, fieldsToWatch, params);

            // Store the result for caching, and also for comparing new results to see
            // if there has been a change.
            // Don't forget to include the params array here, since that is part of what
            // uniquely identifies this ChangeWatcher.
            accessManager.saveChangeWatcherResult(pair, derivedValueName, result, params);
        } catch (Exception e) {
            log.error("Unable to calculate " + derivedValueName, e);
        }

        return result;
    }

    private List<ClassIDPair> calc_findScheduleEntriesForDate(ClassIDPair pair, String derivedValueName, String theDate) {
        List<ClassIDPair> results = new ArrayList<ClassIDPair>();

        try {
            Agent host = (Agent) syncAgentService.systemGetById(pair);
            if (host == null) {
                log.warn("Unable to calculate " + derivedValueName + ": Invalid objectId " + pair.getClassName() + "::" + pair.getID());
                return results;
            }

            // Setup params array. If nothing else, this is used to uniquely
            // identify this ChangeWatcher.
            String[] params = new String[1];
            params[0] = theDate;

            // Convert the date String. Since the date string format is completely up to
            // the developer, the build int `parseDateTime` function may or may not be
            // applicable. The point here is to accurately convert the passed in String
            // into a Date object (including its time zone).
            DateTime theDateTime = parseDateTime(theDate);
            LocalDate localDate = theDateTime.toLocalDate();

            // Setup fieldsToWatch.
            Collection<String> fieldsToWatch = new HashSet<String>();


            accessManager.addWatcherField(BaseDataObject.toClassIdPair(host), "findScheduleForDate", fieldsToWatch, params);
            Schedule schedule = host.getFindScheduleForDate(theDate);

            Iterator<ScheduleEntry> itrScheduleEntries = schedule.getScheduleEntries().iterator();
            while (itrScheduleEntries.hasNext()) {
                ScheduleEntry scheduleEntry = syncAgentService.systemGetByObject(itrScheduleEntries.next());
                if (scheduleEntry != null) {
                    results.add(new ClassIDPair(scheduleEntry.getID(), scheduleEntry.getClass().getCanonicalName()));
                }
            }

            // Register all the fields to watch for this ChangeWatcher. Whenever
            // ANY of these fields change, this ChangeWatcher will get re-run
            // Don't forget to include the params array here, since that is part of what
            // uniquely identifies this ChangeWatcher.
            accessManager.updateWatcherFields(pair, derivedValueName, fieldsToWatch, params);

            // Store the result for caching, and also for comparing new results to see
            // if there has been a change.
            // Don't forget to include the params array here, since that is part of what
            // uniquely identifies this ChangeWatcher.
            accessManager.saveChangeWatcherResult(pair, derivedValueName, results, params);
        } catch (Exception e) {
            log.error("Unable to calculate " + derivedValueName, e);
        }

        return results;
    }
}
