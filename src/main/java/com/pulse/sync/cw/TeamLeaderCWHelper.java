package com.pulse.sync.cw;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.percero.agents.sync.cw.DerivedValueChangeWatcherHelper;
import com.percero.agents.sync.vo.BaseDataObject;
import com.percero.agents.sync.vo.ClassIDPair;
import com.pulse.mo.Agent;
import com.pulse.mo.AgentScorecard;
import com.pulse.mo.Scorecard;
import com.pulse.mo.TeamLeader;

@Component
public class TeamLeaderCWHelper extends DerivedValueChangeWatcherHelper {

	private static final Logger log = Logger.getLogger(TeamLeaderCWHelper.class);

	@Override
	public Object calculate(String fieldName, ClassIDPair pair) {
		return calculate(fieldName, pair, null);
	}

	public static final String SCORECARDS = "scorecards";
	public static final String AGENT_SCORECARDS = "agentScorecards";

	@Override
	public Object calculate(String fieldName, ClassIDPair pair, String[] params) {
		Object result = null;
		Object oldValue = null;
		try {
			oldValue = accessManager.getChangeWatcherResult(pair, fieldName, params);
		} catch(Exception e) {}

		if (SCORECARDS.equalsIgnoreCase(fieldName)) {
			try {
				result = calc_scorecards(pair, SCORECARDS);
				postCalculate(fieldName, pair, params, result, oldValue);
			} catch(Exception e) {
				log.error("Unable to calculate " + SCORECARDS, e);
			}
		}
		else if (AGENT_SCORECARDS.equalsIgnoreCase(fieldName)) {
			try {
				result = calc_agentScorecards(pair, AGENT_SCORECARDS);
				postCalculate(fieldName, pair, params, result, oldValue);
			} catch(Exception e) {
				log.error("Unable to calculate " + AGENT_SCORECARDS, e);
			}
		}
		else {
			result = super.calculate(fieldName, pair, params);
		}

		return result;
	}


	private List<ClassIDPair> calc_agentScorecards(ClassIDPair pair, String derivedValueName) {
		List<ClassIDPair> results = new ArrayList<ClassIDPair>();

		try {
			TeamLeader host = (TeamLeader) syncAgentService.systemGetById(pair);
			if (host == null) {
				log.warn("Unable to calculate " + derivedValueName + ": Invalid objectId");
				return results;
			}

			Set<AgentScorecard> agentScorecards = new HashSet<AgentScorecard>();

			// Setup fieldsToWatch.
			Collection<String> fieldsToWatch = new HashSet<String>();

			// We want to re-trigger this change watcher when TeamLeader.Agents changes.
			accessManager.addWatcherField(pair, "agents", fieldsToWatch);
			Iterator<Agent> itrAgents = host.getAgents().iterator();
			while (itrAgents.hasNext()) {
				Agent agent = syncAgentService.systemGetByObject(itrAgents.next());
				if (agent != null) {
					// We want to re-trigger this change watcher when Agent.AgentScorecards changes.
					accessManager.addWatcherField(BaseDataObject.toClassIdPair(agent), "agentScorecards", fieldsToWatch);
					Iterator<AgentScorecard> itrAgentScorecards = agent.getAgentScorecards().iterator();
					while (itrAgentScorecards.hasNext()) {
						AgentScorecard agentScorecard = syncAgentService.systemGetByObject(itrAgentScorecards.next());

						if (agentScorecard != null) {
							agentScorecards.add(agentScorecard);
						}
					}
				}
			}

			Iterator<AgentScorecard> itrAgentScorecards = agentScorecards.iterator();
			while (itrAgentScorecards.hasNext()) {
				AgentScorecard nextResult = itrAgentScorecards.next();
				results.add(BaseDataObject.toClassIdPair(nextResult));
			}

			// Register all the fields to watch for this ChangeWatcher. Whenever
			// ANY of these fields change, this ChangeWatcher will get re-run
			accessManager.updateWatcherFields(pair, derivedValueName, fieldsToWatch);

			// Store the result for caching, and also for comparing new results to see if there has been a change.
			accessManager.saveChangeWatcherResult(pair, derivedValueName, results);
		} catch(Exception e) {
			log.error("Unable to calculate " + derivedValueName, e);
		}

		return results;
	}
	
	private List<ClassIDPair> calc_scorecards(ClassIDPair pair, String derivedValueName) {
		List<ClassIDPair> results = new ArrayList<ClassIDPair>();
		
		try {
			TeamLeader host = (TeamLeader) syncAgentService.systemGetById(pair);
			if (host == null) {
				log.warn("Unable to calculate " + derivedValueName + ": Invalid objectId");
				return results;
			}
			
			Set<String> scorecardIds = new HashSet<String>();
			
			// Setup fieldsToWatch.
			Collection<String> fieldsToWatch = new HashSet<String>();
			
			// We want to re-trigger this change watcher when
			// TeamLeader.AgentScorecards changes.
			// NOTE: Since TeamLeader.AgentScorecards is a Derived Collection,
			// we know that it's objects have already been fully retrieved from
			// the database (ie. they are NOT "shell" objects)
			accessManager.addWatcherField(pair, "agentScorecards", fieldsToWatch);
			Iterator<AgentScorecard> itrAgentScorecards = host.getAgentScorecards().iterator();
			while (itrAgentScorecards.hasNext()) {
				AgentScorecard agentScorecard = itrAgentScorecards.next();
				if (agentScorecard != null) {
					// We want to re-trigger this change watcher when AgentScorecard.Scorecard changes.
					accessManager.addWatcherField(BaseDataObject.toClassIdPair(agentScorecard), "scorecard", fieldsToWatch);
					
					// Since we only return ClassIDPair objects and don't do any
					// sorting, we can just retrieve the "shell" object here,
					// rather than loading the full thing from the database.
					Scorecard scorecard = agentScorecard.getScorecard();
					
					if (scorecard != null && StringUtils.hasText(scorecard.getID())) {
						// Make sure the Scorecard has a valid id.
						scorecardIds.add(scorecard.getID());
					}
				}
			}
			
			Iterator<String> itrScorecardIds = scorecardIds.iterator();
			while (itrScorecardIds.hasNext()) {
				String nextResult = itrScorecardIds.next();
				results.add(new ClassIDPair(nextResult, Scorecard.class.getCanonicalName()));
			}
			
			// Register all the fields to watch for this ChangeWatcher. Whenever
			// ANY of these fields change, this ChangeWatcher will get re-run
			accessManager.updateWatcherFields(pair, derivedValueName, fieldsToWatch);
			
			// Store the result for caching, and also for comparing new results to see if there has been a change.
			accessManager.saveChangeWatcherResult(pair, derivedValueName, results);
		} catch(Exception e) {
			log.error("Unable to calculate " + derivedValueName, e);
		}
		
		return results;
	}

}
