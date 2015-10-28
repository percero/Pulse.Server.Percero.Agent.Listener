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
import com.pulse.mo.ScorecardMeasure;
import com.pulse.mo.ScorecardMonthlyResult;

@Component
public class ScorecardMonthlyResultCWHelper extends DerivedValueChangeWatcherHelper {

	private static final Logger log = Logger.getLogger(ScorecardMonthlyResultCWHelper.class);

	public static final String PREVIOUS_SCORECARD_MONTHLY_RESULT = "previousScorecardMonthlyResult";

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

		if (PREVIOUS_SCORECARD_MONTHLY_RESULT.equalsIgnoreCase(fieldName)) {
			try {
				result = calc_previousScorecardMonthlyResult(pair, PREVIOUS_SCORECARD_MONTHLY_RESULT);
				postCalculate(fieldName, pair, params, result, oldValue);
			} catch(Exception e) {
				log.error("Unable to calculate " + PREVIOUS_SCORECARD_MONTHLY_RESULT, e);
			}
		}
		else {
			result = super.calculate(fieldName, pair, params);
		}

		return result;
	}

	private ClassIDPair calc_previousScorecardMonthlyResult(ClassIDPair pair, String derivedValueName) {
		ClassIDPair result = null;

//		try {
//			ScorecardMonthlyResult host = (ScorecardMonthlyResult) syncAgentService.systemGetById(pair);
//			if (host == null) {
//				log.warn("Unable to calculate " + derivedValueName + ": Invalid objectId");
//				return result;
//			}
//
//			// Setup fieldsToWatch.
//			Collection<String> fieldsToWatch = new HashSet<String>();
//
//			// We want to re-trigger this change watcher when AgentScorecard.weekDate changes.
//			accessManager.addWatcherField(pair, "scorecardMeasure", fieldsToWatch);
//			ScorecardMeasure scorecardMeasure = syncAgentService.systemGetByObject(host.getScorecardMeasure());
//			accessManager.addWatcherField(pair, "agent", fieldsToWatch);
//			Agent agent = syncAgentService.systemGetByObject(host.getAgent());
//			accessManager.addWatcherField(pair, "startDate", fieldsToWatch);
//			Date startDate = host.getStartDate();
//
//			ScorecardMonthlyResult previousScorecardMonthlyResult = null;
//			Date previousEndDate = null;
//
//			if (startDate != null && startDate.getTime() > 0 && scorecardMeasure != null && agent!= null) {
//
//				accessManager.addWatcherField(BaseDataObject.toClassIdPair(agent), "scorecardMonthlyResults", fieldsToWatch);
//				Iterator<ScorecardMonthlyResult> itrScorecardMonthlyResults = agent.getScorecardMonthlyResults().iterator();
//				while (itrScorecardMonthlyResults.hasNext()) {
//					ScorecardMonthlyResult nextScorecardMonthlyResult = syncAgentService.systemGetByObject(itrScorecardMonthlyResults.next());
//
//					if (nextScorecardMonthlyResult != null) {
//						accessManager.addWatcherField(BaseDataObject.toClassIdPair(nextScorecardMonthlyResult), "scorecardMeasure", fieldsToWatch);
//						ScorecardMeasure nextScorecardMeasure = nextScorecardMonthlyResult.getScorecardMeasure();
//
//						if (nextScorecardMeasure != null && nextScorecardMeasure.getID() != null && nextScorecardMeasure.getID().equalsIgnoreCase(scorecardMeasure.getID())) {
//							// Found a matching ScorecardMeasure.
//							accessManager.addWatcherField(BaseDataObject.toClassIdPair(nextScorecardMonthlyResult), "endDate", fieldsToWatch);
//							Date nextEndDate = nextScorecardMonthlyResult.getEndDate();
//
//							if (nextEndDate != null && nextEndDate.getTime() > 0 && nextEndDate.getTime() <= startDate.getTime()) {
//								if (previousEndDate == null || nextEndDate.getTime() > previousEndDate.getTime()) {
//									// Found a more recent WeeklyResult for the ScorecardMeasure.
//									previousScorecardMonthlyResult = nextScorecardMonthlyResult;
//									previousEndDate = previousScorecardMonthlyResult.getEndDate();
//								}
//							}
//						}
//					}
//				}
//			}
//
//			if (previousScorecardMonthlyResult != null) {
//				result = BaseDataObject.toClassIdPair(previousScorecardMonthlyResult);
//			}
//
//			// Register all the fields to watch for this ChangeWatcher. Whenever
//			// ANY of these fields change, this ChangeWatcher will get re-run
//			accessManager.updateWatcherFields(pair, derivedValueName, fieldsToWatch);
//
//			// Store the result for caching, and also for comparing new results to see if there has been a change.
//			accessManager.saveChangeWatcherResult(pair, derivedValueName, result);
//		} catch(Exception e) {
//			log.error("Unable to calculate " + derivedValueName, e);
//		}

		return result;
	}


}
