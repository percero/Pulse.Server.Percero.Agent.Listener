package com.pulse.sync.cw;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.percero.agents.sync.cw.DerivedValueChangeWatcherHelper;
import com.percero.agents.sync.vo.BaseDataObject;
import com.percero.agents.sync.vo.ClassIDPair;
import com.pulse.mo.Agent;
import com.pulse.mo.AgentScorecard;
import com.pulse.mo.ScorecardMonthlyScore;
import com.pulse.mo.ScorecardWeeklyScore;

@Component
public class ScorecardMonthlyScoreCWHelper extends DerivedValueChangeWatcherHelper {

	private static final Logger log = Logger.getLogger(ScorecardMonthlyScoreCWHelper.class);

	public static final String PREVIOUS_SCORECARD_MONTHLY_SCORE = "previousScorecardMonthlyScore";

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

		if (PREVIOUS_SCORECARD_MONTHLY_SCORE.equalsIgnoreCase(fieldName)) {
			try {
				result = calc_previousScorecardMonthlyScore(pair, PREVIOUS_SCORECARD_MONTHLY_SCORE);
				postCalculate(fieldName, pair, params, result, oldValue);
			} catch(Exception e) {
				log.error("Unable to calculate " + PREVIOUS_SCORECARD_MONTHLY_SCORE, e);
			}
		}
		else {
			result = super.calculate(fieldName, pair, params);
		}

		return result;
	}

	private ClassIDPair calc_previousScorecardMonthlyScore(ClassIDPair pair, String derivedValueName) {
		ClassIDPair result = null;

		try {
			ScorecardMonthlyScore host = (ScorecardMonthlyScore) syncAgentService.systemGetById(pair);
			if (host == null) {
				log.warn("Unable to calculate " + derivedValueName + ": Invalid objectId");
				return result;
			}

			// Setup fieldsToWatch.
			Collection<String> fieldsToWatch = new HashSet<String>();

			// We want to re-trigger this change watcher when AgentScorecard.weekDate changes.
			accessManager.addWatcherField(pair, "agent", fieldsToWatch);
			Agent agent = syncAgentService.systemGetByObject(host.getAgent());
			accessManager.addWatcherField(pair, "startDate", fieldsToWatch);
			Date startDate = host.getStartDate();
			
			ScorecardMonthlyScore previousScorecardMonthlyScore = null;
			Date previousEndDate = null;

			if (agent != null && startDate != null && startDate.getTime() > 0) {
				accessManager.addWatcherField(BaseDataObject.toClassIdPair(agent), "agentScorecards", fieldsToWatch);
				Iterator<AgentScorecard> itrAgentScorecards = agent.getAgentScorecards().iterator();
				while (itrAgentScorecards.hasNext()) {
					AgentScorecard nextAgentScorecard = syncAgentService.systemGetByObject(itrAgentScorecards.next());

					if (nextAgentScorecard != null) {
						accessManager.addWatcherField(BaseDataObject.toClassIdPair(nextAgentScorecard), "scorecardWeeklyScores", fieldsToWatch);
						Iterator<ScorecardWeeklyScore> itrScorecardWeeklyScores = nextAgentScorecard.getScorecardWeeklyScores().iterator();
						
						while (itrScorecardWeeklyScores.hasNext()) {
							ScorecardWeeklyScore nextScorecardWeeklyScore = syncAgentService.systemGetByObject(itrScorecardWeeklyScores.next());

							if (nextScorecardWeeklyScore != null) {
								accessManager.addWatcherField(BaseDataObject.toClassIdPair(nextScorecardWeeklyScore), "scorecardMonthlyScore", fieldsToWatch);
								ScorecardMonthlyScore scorecardMonthlyScore = syncAgentService.systemGetByObject(nextScorecardWeeklyScore.getScorecardMonthlyScore());
								
								if (scorecardMonthlyScore != null) {
									accessManager.addWatcherField(BaseDataObject.toClassIdPair(scorecardMonthlyScore), "endDate", fieldsToWatch);
									Date nextEndDate = scorecardMonthlyScore.getEndDate();

									if (nextEndDate != null && nextEndDate.getTime() > 0 && nextEndDate.getTime() <= startDate.getTime()) {
										if (previousEndDate == null || nextEndDate.getTime() > previousEndDate.getTime()) {
											// Found a more recent WeeklyScore for the ScorecardMeasure.
											previousScorecardMonthlyScore = scorecardMonthlyScore;
											previousEndDate = previousScorecardMonthlyScore.getEndDate();
										}
									}
								}
							}
							
						}
					}
				}
			}
			
			if (previousScorecardMonthlyScore != null) {
				result = BaseDataObject.toClassIdPair(previousScorecardMonthlyScore);
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
