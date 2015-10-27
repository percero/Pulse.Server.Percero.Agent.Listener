//package com.pulse.sync.cw;
//
//import java.util.Collection;
//import java.util.Date;
//import java.util.HashSet;
//import java.util.Iterator;
//
//import org.apache.log4j.Logger;
//import org.joda.time.DateTime;
//import org.springframework.stereotype.Component;
//
//import com.percero.agents.sync.cw.DerivedValueChangeWatcherHelper;
//import com.percero.agents.sync.vo.BaseDataObject;
//import com.percero.agents.sync.vo.ClassIDPair;
//import com.pulse.mo.Agent;
//import com.pulse.mo.AgentScorecard;
//import com.pulse.mo.ScorecardMeasure;
//import com.pulse.mo.ScorecardMonthlyResult;
//import com.pulse.mo.ScorecardWeeklyResult;
//
//@Component
//public class ScorecardWeeklyResultCWHelper extends DerivedValueChangeWatcherHelper {
//
//	private static final Logger log = Logger.getLogger(ScorecardWeeklyResultCWHelper.class);
//
//	public static final String CURRENT_SCORECARD_MONTHLY_RESULT = "currentScorecardMonthlyResult";
//	public static final String PREVIOUS_SCORECARD_WEEKLY_RESULT = "previousScorecardWeeklyResult";
//
//	@Override
//	public Object calculate(String fieldName, ClassIDPair pair) {
//		return calculate(fieldName, pair, null);
//	}
//
//	@Override
//	public Object calculate(String fieldName, ClassIDPair pair, String[] params) {
//		Object result = null;
//		Object oldValue = null;
//		try {
//			oldValue = accessManager.getChangeWatcherResult(pair, fieldName, params);
//		} catch(Exception e) {}
//
//		if (CURRENT_SCORECARD_MONTHLY_RESULT.equalsIgnoreCase(fieldName)) {
//			try {
//				result = calc_currentScorecardMonthlyResult(pair, CURRENT_SCORECARD_MONTHLY_RESULT);
//				postCalculate(fieldName, pair, params, result, oldValue);
//			} catch(Exception e) {
//				log.error("Unable to calculate " + CURRENT_SCORECARD_MONTHLY_RESULT, e);
//			}
//		}
//		else if (PREVIOUS_SCORECARD_WEEKLY_RESULT.equalsIgnoreCase(fieldName)) {
//			try {
//				result = calc_previousScorecardWeeklyResult(pair, PREVIOUS_SCORECARD_WEEKLY_RESULT);
//				postCalculate(fieldName, pair, params, result, oldValue);
//			} catch(Exception e) {
//				log.error("Unable to calculate " + PREVIOUS_SCORECARD_WEEKLY_RESULT, e);
//			}
//		}
//		else {
//			result = super.calculate(fieldName, pair, params);
//		}
//
//		return result;
//	}
//
//	private ClassIDPair calc_currentScorecardMonthlyResult(ClassIDPair pair, String derivedValueName) {
//		ClassIDPair result = null;
//
//		try {
//			ScorecardWeeklyResult host = (ScorecardWeeklyResult) syncAgentService.systemGetById(pair);
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
//			accessManager.addWatcherField(pair, "agentScorecard", fieldsToWatch);
//			AgentScorecard agentScorecard = syncAgentService.systemGetByObject(host.getAgentScorecard());
//			accessManager.addWatcherField(pair, "weekDate", fieldsToWatch);
//			Date weekDate = host.getWeekDate();
//
//			if (weekDate != null && weekDate.getTime() > 0 && scorecardMeasure != null && agentScorecard != null) {
//				DateTime weekDateTime = new DateTime(weekDate.getTime());
//
//				accessManager.addWatcherField(BaseDataObject.toClassIdPair(agentScorecard), "scorecardMonthlyResults", fieldsToWatch);
//				Iterator<ScorecardMonthlyResult> itrMonthlyResults = agentScorecard.getScorecardMonthlyResults().iterator();
//				while (itrMonthlyResults.hasNext()) {
//					ScorecardMonthlyResult nextMonthlyResult = itrMonthlyResults.next();
//
//					if (nextMonthlyResult != null) {
//						accessManager.addWatcherField(BaseDataObject.toClassIdPair(nextMonthlyResult), "startDate", fieldsToWatch);
//						Date startDate = nextMonthlyResult.getStartDate();
//						accessManager.addWatcherField(BaseDataObject.toClassIdPair(nextMonthlyResult), "endDate", fieldsToWatch);
//						Date endDate = nextMonthlyResult.getEndDate();
//
//						if (startDate != null && startDate.getTime() > 0 && endDate != null && endDate.getTime() > 0) {
//							DateTime startDateTime = new DateTime(startDate.getTime());
//							DateTime endDateTime = new DateTime(endDate.getTime());
//
//							if (startDateTime.compareTo(weekDateTime) <= 0 && endDateTime.compareTo(weekDateTime) >= 0) {
//								// Found a matching Month, now check the scorecard measure.
//								accessManager.addWatcherField(BaseDataObject.toClassIdPair(nextMonthlyResult), "scorecardMeasure", fieldsToWatch);
//								ScorecardMeasure monthScorecardMeasure = nextMonthlyResult.getScorecardMeasure();
//								if (monthScorecardMeasure != null && monthScorecardMeasure.getID() != null && monthScorecardMeasure.getID().equalsIgnoreCase(scorecardMeasure.getID())) {
//									// We have found the matching scorecard measure as well, thus we have found our match.
//									result = BaseDataObject.toClassIdPair(nextMonthlyResult);
//									break;
//								}
//							}
//
//						}
//
//					}
//				}
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
//
//		return result;
//	}
//
//	private ClassIDPair calc_previousScorecardWeeklyResult(ClassIDPair pair, String derivedValueName) {
//		ClassIDPair result = null;
//
//		try {
//			ScorecardWeeklyResult host = (ScorecardWeeklyResult) syncAgentService.systemGetById(pair);
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
//			accessManager.addWatcherField(pair, "agentScorecard", fieldsToWatch);
//			AgentScorecard agentScorecard = syncAgentService.systemGetByObject(host.getAgentScorecard());
//			accessManager.addWatcherField(pair, "weekDate", fieldsToWatch);
//			Date weekDate = host.getWeekDate();
//
//			ScorecardWeeklyResult previousScorecardWeeklyResult = null;
//			Date previousWeekDate = null;
//
//			if (weekDate != null && weekDate.getTime() > 0 && scorecardMeasure != null && agentScorecard != null) {
//				accessManager.addWatcherField(pair, "agent", fieldsToWatch);
//				Agent agent = syncAgentService.systemGetByObject(agentScorecard.getAgent());
//
//				if (agent != null) {
//					accessManager.addWatcherField(BaseDataObject.toClassIdPair(agent), "agentScorecards", fieldsToWatch);
//					Iterator<AgentScorecard> itrAgentScorecards = agent.getAgentScorecards().iterator();
//					while (itrAgentScorecards.hasNext()) {
//						AgentScorecard nextAgentScorecard = syncAgentService.systemGetByObject(itrAgentScorecards.next());
//
//						if (nextAgentScorecard != null) {
//							accessManager.addWatcherField(BaseDataObject.toClassIdPair(nextAgentScorecard), "scorecardWeeklyResults", fieldsToWatch);
//							Iterator<ScorecardWeeklyResult> itrScorecardWeeklyResults = nextAgentScorecard.getScorecardWeeklyResults().iterator();
//							while (itrScorecardWeeklyResults.hasNext()) {
//								ScorecardWeeklyResult nextScorecardWeeklyResult = syncAgentService.systemGetByObject(itrScorecardWeeklyResults.next());
//
//								if (nextScorecardWeeklyResult != null) {
//									accessManager.addWatcherField(BaseDataObject.toClassIdPair(nextScorecardWeeklyResult), "scorecardMeasure", fieldsToWatch);
//									ScorecardMeasure nextScorecardMeasure = nextScorecardWeeklyResult.getScorecardMeasure();
//
//									if (nextScorecardMeasure != null && nextScorecardMeasure.getID() != null && nextScorecardMeasure.getID().equalsIgnoreCase(scorecardMeasure.getID())) {
//										// Found a matching ScorecardMeasure.
//										accessManager.addWatcherField(BaseDataObject.toClassIdPair(nextScorecardWeeklyResult), "weekDate", fieldsToWatch);
//										Date nextWeekDate = nextScorecardWeeklyResult.getWeekDate();
//
//										if (nextWeekDate != null && nextWeekDate.getTime() > 0 && nextWeekDate.getTime() < weekDate.getTime()) {
//											if (previousWeekDate == null || nextWeekDate.getTime() > previousWeekDate.getTime()) {
//												// Found a more recent WeeklyResult for the ScorecardMeasure.
//												previousScorecardWeeklyResult = nextScorecardWeeklyResult;
//												previousWeekDate = previousScorecardWeeklyResult.getWeekDate();
//											}
//										}
//									}
//								}
//							}
//						}
//					}
//				}
//			}
//
//			if (previousScorecardWeeklyResult != null) {
//				result = BaseDataObject.toClassIdPair(previousScorecardWeeklyResult);
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
//
//		return result;
//	}
//
//
//}
