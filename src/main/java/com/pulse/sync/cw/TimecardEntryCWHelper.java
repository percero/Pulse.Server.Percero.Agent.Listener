package com.pulse.sync.cw;

import com.percero.agents.sync.cw.DerivedValueChangeWatcherHelper;
import com.percero.agents.sync.vo.BaseDataObject;
import com.percero.agents.sync.vo.ClassIDPair;
import com.pulse.mo.*;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.DateTimeComparator;
import org.joda.time.Days;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class TimecardEntryCWHelper extends DerivedValueChangeWatcherHelper {

    private static final Logger log = Logger.getLogger(TimecardEntryCWHelper.class);
    public static final String FROMTIME = "fromTime";
    public static final String TOTIME = "toTime";

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



        if (fieldName.equalsIgnoreCase("fromTime")) {
            try {
                result = calc_fromTime(pair, fieldName);
                postCalculate(fieldName, pair, params, result, oldValue);
            } catch(Exception e) {
                log.error("Unable to calculate fromTime", e);
            }
        }
        else if (fieldName.equalsIgnoreCase("toTime")) {
            try {
                result = calc_toTime(pair, fieldName);
                postCalculate(fieldName, pair, params, result, oldValue);
            } catch(Exception e) {
                log.error("Unable to calculate toTime", e);
            }
        }

        else {
            result = super.calculate(fieldName, pair, params);
        }

        return result;
    }

    public Date calc_fromTime(ClassIDPair pair, String derivedValueName) {
        Date result = null;

        try {
            TimecardEntry host = (TimecardEntry) syncAgentService.systemGetById(pair);
            if (host == null) {
                log.warn("Unable to calculate " + derivedValueName + ": Invalid objectId");
                return result;
            }

            // Setup fieldsToWatch.
            Collection<String> fieldsToWatch = new HashSet<String>();

            // We want to re-trigger this change watcher when AgentScorecard.weekDate changes.
            accessManager.addWatcherField(pair, "sourceFromTime", fieldsToWatch);

            result = host.getSourceFromTime();

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

    public Date calc_toTime(ClassIDPair pair, String derivedValueName) {
        Date result = null;

        try {
            TimecardEntry host = (TimecardEntry) syncAgentService.systemGetById(pair);
            if (host == null) {
                log.warn("Unable to calculate " + derivedValueName + ": Invalid objectId");
                return result;
            }

            // Setup fieldsToWatch.
            Collection<String> fieldsToWatch = new HashSet<String>();

            // We want to re-trigger this change watcher when AgentScorecard.weekDate changes.
            accessManager.addWatcherField(pair, "sourceToTime", fieldsToWatch);

            result = host.getSourceToTime();

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
