package com.pulse.sync.cw;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.stereotype.Component;

import com.percero.agents.sync.cw.DerivedValueChangeWatcherHelper;
import com.percero.agents.sync.vo.BaseDataObject;
import com.percero.agents.sync.vo.ClassIDPair;
import com.pulse.mo.Agent;
import com.pulse.mo.ScheduleEntry;

@Component
public class ScheduleEntryCWHelper extends DerivedValueChangeWatcherHelper {

    private static final Logger log = Logger.getLogger(TimecardEntryCWHelper.class);
    public static final String STARTTIME = "startTime";
    public static final String ENDTIME = "endTime";

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
        } catch(Exception e) {}



        if (fieldName.equalsIgnoreCase(STARTTIME)) {
            try {
                result = calc_startTime(pair, fieldName);
                postCalculate(fieldName, pair, params, result, oldValue);
            } catch(Exception e) {
                log.error("Unable to calculate " + STARTTIME, e);
            }
        }
        else if (fieldName.equalsIgnoreCase(ENDTIME)) {
            try {
                result = calc_endTime(pair, fieldName);
                postCalculate(fieldName, pair, params, result, oldValue);
            } catch(Exception e) {
                log.error("Unable to calculate " + ENDTIME, e);
            }
        }

        else {
            result = super.calculate(fieldName, pair, params);
        }

        return result;
    }

    public Date calc_startTime(ClassIDPair pair, String derivedValueName) {
        Date result = null;

        try {
            ScheduleEntry host = (ScheduleEntry) syncAgentService.systemGetById(pair);
            if (host == null) {
                log.warn("Unable to calculate " + derivedValueName + ": Invalid objectId " + pair.getClassName() + "::" + pair.getID());
                return result;
            }

            // Setup fieldsToWatch.
            Collection<String> fieldsToWatch = new HashSet<String>();

            // We want to re-trigger this change watcher when AgentScorecard.weekDate changes.
            accessManager.addWatcherField(pair, "sourceStartTime", fieldsToWatch);
            Date sourceStartTime  = host.getSourceStartTime();

			if (sourceStartTime != null && sourceStartTime.getTime() > 0) {
				accessManager.addWatcherField(pair, "agent", fieldsToWatch);
				Agent agent = host.getAgent();
				
				if (agent != null) {
					accessManager.addWatcherField(BaseDataObject.toClassIdPair(agent), "timeZone", fieldsToWatch);
					String timeZone = agent.getTimeZone();
					if (timeZone != null) {
						try {
							DateTimeZone dateTimeZone = DateTimeZone.forID(timeZone);
							if (dateTimeZone != null) {
								int offsetInMs = dateTimeZone.getOffset(System.currentTimeMillis());
								
								// The Source Time MINUS the Offset gives us UTC.
								DateTime startDate = new DateTime(sourceStartTime.getTime() - offsetInMs);
								result = startDate.toDate();
							}
							else {
								log.warn("Invalid time zone " + timeZone);
							}
						} catch(Exception e) {
							// Invalid time zone.
							log.error("Invalid time zone " + timeZone, e);
						}
					}
					else {
						log.warn("Unable to get TimeZone, using SourceStartTime as StartTime");
					}
				}
				else {
					log.warn("Unable to get Timecard, using SourceStartTime as StartTime");
				}
			}

            // Register all the fields to watch for this ChangeWatcher. Whenever
            // ANY of these fields change, this ChangeWatcher will get re-run
            accessManager.updateWatcherFields(pair, derivedValueName, fieldsToWatch);

            // Store the result for caching, and also for comparing new results to see if there has been a change.
            accessManager.saveChangeWatcherResult(pair, derivedValueName, result);
        } catch(Exception e) {
            log.error("Unable to calculate " + derivedValueName, e);
        }

        return result;
    }

    public Date calc_endTime(ClassIDPair pair, String derivedValueName) {
        Date result = null;

        try {
            ScheduleEntry host = (ScheduleEntry) syncAgentService.systemGetById(pair);
            if (host == null) {
                log.warn("Unable to calculate " + derivedValueName + ": Invalid objectId " + pair.getClassName() + "::" + pair.getID());
                return result;
            }

            // Setup fieldsToWatch.
            Collection<String> fieldsToWatch = new HashSet<String>();

            // We want to re-trigger this change watcher when AgentScorecard.weekDate changes.
            accessManager.addWatcherField(pair, "sourceEndTime", fieldsToWatch);
            Date sourceEndTime = host.getSourceEndTime();

			if (sourceEndTime != null && sourceEndTime.getTime() > 0) {
				accessManager.addWatcherField(pair, "agent", fieldsToWatch);
				Agent agent = host.getAgent();
				
				if (agent != null) {
					accessManager.addWatcherField(BaseDataObject.toClassIdPair(agent), "timeZone", fieldsToWatch);
					String timeZone = agent.getTimeZone();
					if (timeZone != null) {
						try {
							DateTimeZone dateTimeZone = DateTimeZone.forID(timeZone);
							if (dateTimeZone != null) {
								int offsetInMs = dateTimeZone.getOffset(System.currentTimeMillis());
								
								// The Source Time MINUS the Offset gives us UTC.
								DateTime endDate = new DateTime(sourceEndTime.getTime() - offsetInMs);
								result = endDate.toDate();
							}
							else {
								log.warn("Invalid time zone " + timeZone);
							}
						} catch(Exception e) {
							// Invalid time zone.
							log.error("Invalid time zone " + timeZone, e);
						}
					}
					else {
						log.warn("Unable to get TimeZone, using SourceEndTime as EndTime");
					}
				}
				else {
					log.warn("Unable to get Timecard, using SourceEndTime as EndTime");
				}
			}

            // Register all the fields to watch for this ChangeWatcher. Whenever
            // ANY of these fields change, this ChangeWatcher will get re-run
            accessManager.updateWatcherFields(pair, derivedValueName, fieldsToWatch);

            // Store the result for caching, and also for comparing new results to see if there has been a change.
            accessManager.saveChangeWatcherResult(pair, derivedValueName, result);
        } catch(Exception e) {
            log.error("Unable to calculate " + derivedValueName, e);
        }

        return result;
    }

}
