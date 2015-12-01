package com.pulse.sync.cw;

import java.util.Collection;
import java.util.HashSet;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.percero.agents.sync.cw.DerivedValueChangeWatcherHelper;
import com.percero.agents.sync.vo.BaseDataObject;
import com.percero.agents.sync.vo.ClassIDPair;
import com.pulse.mo.Agent;
import com.pulse.mo.AgentTimeZone;

@Component
public class AgentCWHelper extends DerivedValueChangeWatcherHelper {

    private static final Logger log = Logger.getLogger(AgentCWHelper.class);


	public static final String TIME_ZONE = "agenttTimeZone";



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
			}
			else {
				log.warn("Unable to get AgentTimeZone");
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
