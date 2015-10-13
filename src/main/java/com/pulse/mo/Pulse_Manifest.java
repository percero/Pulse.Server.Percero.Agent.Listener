package com.pulse.mo;

import com.percero.framework.bl.IManifest;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.springframework.stereotype.Component;

@SuppressWarnings("rawtypes")
@Component
public class Pulse_Manifest implements IManifest
{

	private List<Class> classList = null;
	public List<Class> getClassList() {
		if (classList == null) {
			classList = new ArrayList<Class>();
			classList.add(com.pulse.mo.CMSAuxMode.class);
classList.add(com.pulse.mo.AdhocCoachingCategory.class);
classList.add(com.pulse.mo.AdhocTaskState.class);
classList.add(com.pulse.mo.CoachingSessionState.class);
classList.add(com.pulse.mo.CorrectiveActionState.class);
classList.add(com.pulse.mo.CorrectiveActionType.class);
classList.add(com.pulse.mo.CVGProject.class);
classList.add(com.pulse.mo.Notification.class);
classList.add(com.pulse.mo.Agent.class);
classList.add(com.pulse.mo.LOB.class);
classList.add(com.pulse.mo.LOBConfiguration.class);
classList.add(com.pulse.mo.LOBConfigurationNotification.class);
classList.add(com.pulse.mo.DiscrepancyDetectedNotification.class);
classList.add(com.pulse.mo.DurationMismatchNotification.class);
classList.add(com.pulse.mo.ThresholdExceededNotification.class);
classList.add(com.pulse.mo.DurationToleranceNotification.class);
classList.add(com.pulse.mo.EmployeeAcknowledgement.class);
classList.add(com.pulse.mo.HRApproval.class);
classList.add(com.pulse.mo.InvalidActivityCodeNotification.class);
classList.add(com.pulse.mo.ManagerApproval.class);
classList.add(com.pulse.mo.Measure.class);
classList.add(com.pulse.mo.NonBillableActivityNotification.class);
classList.add(com.pulse.mo.Alert.class);
classList.add(com.pulse.mo.NotificationAlert.class);
classList.add(com.pulse.mo.NotificationFrequency.class);
classList.add(com.pulse.mo.OccurrenceMismatchNotification.class);
classList.add(com.pulse.mo.OccurrenceToleranceNotification.class);
classList.add(com.pulse.mo.PayrollDetail.class);
classList.add(com.pulse.mo.PerformanceSummary.class);
classList.add(com.pulse.mo.PulseConfiguration.class);
classList.add(com.pulse.mo.Role.class);
classList.add(com.pulse.mo.Scorecard.class);
classList.add(com.pulse.mo.Site.class);
classList.add(com.pulse.mo.SupervisorAcknowledgement.class);
classList.add(com.pulse.mo.ThresholdGradeScale.class);
classList.add(com.pulse.mo.ThresholdScale.class);
classList.add(com.pulse.mo.TraceLog.class);
classList.add(com.pulse.mo.WorkDurationNotification.class);
classList.add(com.pulse.mo.WorkModeOccurrenceNotification.class);
classList.add(com.pulse.mo.Client.class);
classList.add(com.pulse.mo.CMSEntry.class);
classList.add(com.pulse.mo.Schedule.class);
classList.add(com.pulse.mo.ScheduleEntry.class);
classList.add(com.pulse.mo.Timecard.class);
classList.add(com.pulse.mo.TimecardActivity.class);
classList.add(com.pulse.mo.TimecardEntry.class);
classList.add(com.pulse.mo.AdhocCoachingSession.class);
classList.add(com.pulse.mo.AdhocTask.class);
classList.add(com.pulse.mo.AgentScorecard.class);
classList.add(com.pulse.mo.Behavior.class);
classList.add(com.pulse.mo.BehaviorResponse.class);
classList.add(com.pulse.mo.CoachingComment.class);
classList.add(com.pulse.mo.CoachingSession.class);
classList.add(com.pulse.mo.CoachingSessionAttachment.class);
classList.add(com.pulse.mo.CorrectiveAction.class);
classList.add(com.pulse.mo.DevelopmentActivity.class);
classList.add(com.pulse.mo.DevelopmentPlan.class);
classList.add(com.pulse.mo.Email.class);
classList.add(com.pulse.mo.GeneralComment.class);
classList.add(com.pulse.mo.LOBConfigurationEntry.class);
classList.add(com.pulse.mo.Observation.class);
classList.add(com.pulse.mo.TeamLeader.class);
classList.add(com.pulse.mo.PulseUser.class);
classList.add(com.pulse.mo.QualityEvaluation.class);
classList.add(com.pulse.mo.ScorecardMeasure.class);
classList.add(com.pulse.mo.ScorecardMeasureMonthlyResult.class);
classList.add(com.pulse.mo.ScorecardMeasureWeeklyResult.class);
classList.add(com.pulse.mo.Setting.class);
classList.add(com.pulse.mo.Supervisor.class);
classList.add(com.pulse.mo.TeamLeaderImpersonation.class);
classList.add(com.pulse.mo.ThresholdLevel.class);
classList.add(com.pulse.mo.TraceEntry.class);
classList.add(com.pulse.mo.UserRole.class);
classList.add(com.pulse.mo.UserSession.class);
classList.add(com.pulse.mo.ChangesNotApprovedNotification.class);
classList.add(com.pulse.mo.CoachingNotification.class);

		}
		return classList;
	}

	private List<Object> objectList = null;
	public List<Object> getObjectList() {
		if (objectList == null) {
			objectList = new ArrayList<Object>();
			objectList.add(new com.pulse.mo.CMSAuxMode());
objectList.add(new com.pulse.mo.AdhocCoachingCategory());
objectList.add(new com.pulse.mo.AdhocTaskState());
objectList.add(new com.pulse.mo.CoachingSessionState());
objectList.add(new com.pulse.mo.CorrectiveActionState());
objectList.add(new com.pulse.mo.CorrectiveActionType());
objectList.add(new com.pulse.mo.CVGProject());
objectList.add(new com.pulse.mo.Notification());
objectList.add(new com.pulse.mo.Agent());
objectList.add(new com.pulse.mo.LOB());
objectList.add(new com.pulse.mo.LOBConfiguration());
objectList.add(new com.pulse.mo.LOBConfigurationNotification());
objectList.add(new com.pulse.mo.DiscrepancyDetectedNotification());
objectList.add(new com.pulse.mo.DurationMismatchNotification());
objectList.add(new com.pulse.mo.ThresholdExceededNotification());
objectList.add(new com.pulse.mo.DurationToleranceNotification());
objectList.add(new com.pulse.mo.EmployeeAcknowledgement());
objectList.add(new com.pulse.mo.HRApproval());
objectList.add(new com.pulse.mo.InvalidActivityCodeNotification());
objectList.add(new com.pulse.mo.ManagerApproval());
objectList.add(new com.pulse.mo.Measure());
objectList.add(new com.pulse.mo.NonBillableActivityNotification());
objectList.add(new com.pulse.mo.Alert());
objectList.add(new com.pulse.mo.NotificationAlert());
objectList.add(new com.pulse.mo.NotificationFrequency());
objectList.add(new com.pulse.mo.OccurrenceMismatchNotification());
objectList.add(new com.pulse.mo.OccurrenceToleranceNotification());
objectList.add(new com.pulse.mo.PayrollDetail());
objectList.add(new com.pulse.mo.PerformanceSummary());
objectList.add(new com.pulse.mo.PulseConfiguration());
objectList.add(new com.pulse.mo.Role());
objectList.add(new com.pulse.mo.Scorecard());
objectList.add(new com.pulse.mo.Site());
objectList.add(new com.pulse.mo.SupervisorAcknowledgement());
objectList.add(new com.pulse.mo.ThresholdGradeScale());
objectList.add(new com.pulse.mo.ThresholdScale());
objectList.add(new com.pulse.mo.TraceLog());
objectList.add(new com.pulse.mo.WorkDurationNotification());
objectList.add(new com.pulse.mo.WorkModeOccurrenceNotification());
objectList.add(new com.pulse.mo.Client());
objectList.add(new com.pulse.mo.CMSEntry());
objectList.add(new com.pulse.mo.Schedule());
objectList.add(new com.pulse.mo.ScheduleEntry());
objectList.add(new com.pulse.mo.Timecard());
objectList.add(new com.pulse.mo.TimecardActivity());
objectList.add(new com.pulse.mo.TimecardEntry());
objectList.add(new com.pulse.mo.AdhocCoachingSession());
objectList.add(new com.pulse.mo.AdhocTask());
objectList.add(new com.pulse.mo.AgentScorecard());
objectList.add(new com.pulse.mo.Behavior());
objectList.add(new com.pulse.mo.BehaviorResponse());
objectList.add(new com.pulse.mo.CoachingComment());
objectList.add(new com.pulse.mo.CoachingSession());
objectList.add(new com.pulse.mo.CoachingSessionAttachment());
objectList.add(new com.pulse.mo.CorrectiveAction());
objectList.add(new com.pulse.mo.DevelopmentActivity());
objectList.add(new com.pulse.mo.DevelopmentPlan());
objectList.add(new com.pulse.mo.Email());
objectList.add(new com.pulse.mo.GeneralComment());
objectList.add(new com.pulse.mo.LOBConfigurationEntry());
objectList.add(new com.pulse.mo.Observation());
objectList.add(new com.pulse.mo.TeamLeader());
objectList.add(new com.pulse.mo.PulseUser());
objectList.add(new com.pulse.mo.QualityEvaluation());
objectList.add(new com.pulse.mo.ScorecardMeasure());
objectList.add(new com.pulse.mo.ScorecardMeasureMonthlyResult());
objectList.add(new com.pulse.mo.ScorecardMeasureWeeklyResult());
objectList.add(new com.pulse.mo.Setting());
objectList.add(new com.pulse.mo.Supervisor());
objectList.add(new com.pulse.mo.TeamLeaderImpersonation());
objectList.add(new com.pulse.mo.ThresholdLevel());
objectList.add(new com.pulse.mo.TraceEntry());
objectList.add(new com.pulse.mo.UserRole());
objectList.add(new com.pulse.mo.UserSession());
objectList.add(new com.pulse.mo.ChangesNotApprovedNotification());
objectList.add(new com.pulse.mo.CoachingNotification());

		}
		return objectList;
	}

	private Map<String, Class> uuidMap = null;
	public Map<String, Class> getUuidMap() {
		if (uuidMap == null) {
			uuidMap = new HashMap<String, Class>();
			uuidMap.put("c6471b9d-bbaa-44cb-9d2a-4e244919c7e6", com.pulse.mo.CMSAuxMode.class);
uuidMap.put("3f1d80b6-447e-4d5b-b8bc-867e4b1ce885", com.pulse.mo.AdhocCoachingCategory.class);
uuidMap.put("d8ade6e0-6744-4255-9213-d722c1d00fb1", com.pulse.mo.AdhocTaskState.class);
uuidMap.put("6f574c87-981a-4ea1-982c-e1303f51621e", com.pulse.mo.CoachingSessionState.class);
uuidMap.put("d839579e-e401-44ef-8a4c-589c1b771def", com.pulse.mo.CorrectiveActionState.class);
uuidMap.put("16765953-2322-4144-9ed5-efe6b33ac398", com.pulse.mo.CorrectiveActionType.class);
uuidMap.put("f0080fbf-cda4-4ba2-9b4c-31ed49d8399c", com.pulse.mo.CVGProject.class);
uuidMap.put("1d415b72-ecee-4522-9b4a-5e241407ce4e", com.pulse.mo.Notification.class);
uuidMap.put("2167e737-0b59-4a25-aba0-f1c0eb71042c", com.pulse.mo.Agent.class);
uuidMap.put("d3cc535f-f8d6-4f0a-8ff9-91be75e78cc3", com.pulse.mo.LOB.class);
uuidMap.put("67a49d89-db99-40d7-b8bb-dcba94681b1e", com.pulse.mo.LOBConfiguration.class);
uuidMap.put("e7154949-2bc9-44f7-b86d-71e6bfb0c606", com.pulse.mo.LOBConfigurationNotification.class);
uuidMap.put("4b14bc58-783c-4236-b656-6bc48661aa77", com.pulse.mo.DiscrepancyDetectedNotification.class);
uuidMap.put("66a4bfd3-8e40-4ea1-925f-0d4087b50f02", com.pulse.mo.DurationMismatchNotification.class);
uuidMap.put("a0deb854-e5a2-4b5d-9f0d-1eda5c4f4efb", com.pulse.mo.ThresholdExceededNotification.class);
uuidMap.put("69f5da86-863a-4112-b8df-d4005c271b42", com.pulse.mo.DurationToleranceNotification.class);
uuidMap.put("825a8e8f-6edb-46f0-a915-e02777279b87", com.pulse.mo.EmployeeAcknowledgement.class);
uuidMap.put("135b5a51-e686-4b29-8106-acb79d43b19c", com.pulse.mo.HRApproval.class);
uuidMap.put("5ffec0d5-2661-4412-9480-6400f5960cd4", com.pulse.mo.InvalidActivityCodeNotification.class);
uuidMap.put("0ce9eb35-a2e9-4df7-9a0e-f696eec81030", com.pulse.mo.ManagerApproval.class);
uuidMap.put("86333263-b3c4-433e-8bc2-4baecf368f74", com.pulse.mo.Measure.class);
uuidMap.put("c354341a-abbe-46b2-bd90-66b3ce65ef2c", com.pulse.mo.NonBillableActivityNotification.class);
uuidMap.put("d4b876b3-c752-40a9-a3f3-13fb1625421a", com.pulse.mo.Alert.class);
uuidMap.put("5b4f321e-1cd3-48e5-9516-601c74ca4e0f", com.pulse.mo.NotificationAlert.class);
uuidMap.put("cfe624d3-c9e2-46c9-9291-7f3db4af3a30", com.pulse.mo.NotificationFrequency.class);
uuidMap.put("5790f1b1-edd7-4824-ab78-798b0c03ceb5", com.pulse.mo.OccurrenceMismatchNotification.class);
uuidMap.put("03e790bc-434e-43ee-9b20-4cf33b292784", com.pulse.mo.OccurrenceToleranceNotification.class);
uuidMap.put("0e1eb1a3-620d-4ea3-9b06-db31210639b3", com.pulse.mo.PayrollDetail.class);
uuidMap.put("0b2c78d4-6fca-4908-90df-5cec4d9a7dd2", com.pulse.mo.PerformanceSummary.class);
uuidMap.put("d8ae6d54-cb98-4c3f-ab65-e1026bff0d89", com.pulse.mo.PulseConfiguration.class);
uuidMap.put("0d42a0ba-79dd-41d2-bd1e-3c01c9c183d7", com.pulse.mo.Role.class);
uuidMap.put("da40912e-4f11-47e2-b033-1f16b1c380c0", com.pulse.mo.Scorecard.class);
uuidMap.put("9832716f-2c1f-48ff-8807-f63aca6d9b01", com.pulse.mo.Site.class);
uuidMap.put("67538b98-3ae9-4a21-b174-60bd6d842baa", com.pulse.mo.SupervisorAcknowledgement.class);
uuidMap.put("df352a0a-fcf6-44a6-bb5e-4e41d1b4ab9d", com.pulse.mo.ThresholdGradeScale.class);
uuidMap.put("6d3bd006-631d-42fd-ac4b-2f3bc53ca9de", com.pulse.mo.ThresholdScale.class);
uuidMap.put("70ee204a-8a3d-4dc1-8d0d-78c58d60fe21", com.pulse.mo.TraceLog.class);
uuidMap.put("074a5afa-acc1-457c-9058-a3c322761c05", com.pulse.mo.WorkDurationNotification.class);
uuidMap.put("7d48984a-f6a8-4895-ab31-034a43c3ae65", com.pulse.mo.WorkModeOccurrenceNotification.class);
uuidMap.put("db04a9e9-3219-4f30-8edf-f54380ce157a", com.pulse.mo.Client.class);
uuidMap.put("b4658c55-dbb2-4f8c-8f1a-68c0a2ba56fa", com.pulse.mo.CMSEntry.class);
uuidMap.put("f3aa958d-10a5-4525-af02-c60efbab69a8", com.pulse.mo.Schedule.class);
uuidMap.put("13022245-f2a8-42c0-aaf7-45112101f566", com.pulse.mo.ScheduleEntry.class);
uuidMap.put("5ddd60db-f933-4a0c-8264-a8538fc01466", com.pulse.mo.Timecard.class);
uuidMap.put("9ac4185e-dc57-4193-80e6-2110c42124d4", com.pulse.mo.TimecardActivity.class);
uuidMap.put("16882a96-0ee5-4511-8379-57193ecd80ea", com.pulse.mo.TimecardEntry.class);
uuidMap.put("b0773aee-4145-4b04-a246-e76743b68d31", com.pulse.mo.AdhocCoachingSession.class);
uuidMap.put("334c124a-4fbc-43d1-beeb-564875dde90f", com.pulse.mo.AdhocTask.class);
uuidMap.put("0ab30bd8-9503-4967-9d71-8065038b95d9", com.pulse.mo.AgentScorecard.class);
uuidMap.put("e81b3071-bb81-4c8e-958d-2a9c64ff02b8", com.pulse.mo.Behavior.class);
uuidMap.put("beca6867-ea42-47ac-a4bf-3f25aa1da0c8", com.pulse.mo.BehaviorResponse.class);
uuidMap.put("ae05d80b-c3c1-493f-9e4f-333f1836689d", com.pulse.mo.CoachingComment.class);
uuidMap.put("2329a9c1-447f-452a-9016-993ae493af20", com.pulse.mo.CoachingSession.class);
uuidMap.put("69a71a0e-cfb6-485b-8ca6-05815c89e2cb", com.pulse.mo.CoachingSessionAttachment.class);
uuidMap.put("05b402d6-8326-4700-ab6c-ebb142e6d2a3", com.pulse.mo.CorrectiveAction.class);
uuidMap.put("4a892be1-8a73-4279-a318-46f386839742", com.pulse.mo.DevelopmentActivity.class);
uuidMap.put("a21d2bc9-f52a-49c3-bc1c-dd7d376029ed", com.pulse.mo.DevelopmentPlan.class);
uuidMap.put("c73d9951-4c5b-417a-a335-ae64d002a36d", com.pulse.mo.Email.class);
uuidMap.put("51304a21-35f5-42d6-ae8b-f16b92c6c935", com.pulse.mo.GeneralComment.class);
uuidMap.put("31d933b2-1125-46c5-8c47-f7e0c6720c11", com.pulse.mo.LOBConfigurationEntry.class);
uuidMap.put("18947c38-87cc-40de-978d-27d65dbf7ba2", com.pulse.mo.Observation.class);
uuidMap.put("da12c0bb-f347-4225-8878-29b18fdab06c", com.pulse.mo.TeamLeader.class);
uuidMap.put("f1116d35-3a56-402f-ba2c-eaa3959ef16d", com.pulse.mo.PulseUser.class);
uuidMap.put("453c6856-fee2-4cd2-ad31-4393a7c0ea20", com.pulse.mo.QualityEvaluation.class);
uuidMap.put("9cdb77fe-2733-490d-a531-6575be6849a5", com.pulse.mo.ScorecardMeasure.class);
uuidMap.put("f70c2a03-0ad1-4222-8f6f-554de9cb1d79", com.pulse.mo.ScorecardMeasureMonthlyResult.class);
uuidMap.put("2b4a237d-43d5-4651-93cc-bf48ecbbb71a", com.pulse.mo.ScorecardMeasureWeeklyResult.class);
uuidMap.put("7a75de59-323d-49ae-b945-e131e27a07d7", com.pulse.mo.Setting.class);
uuidMap.put("0204eee2-df77-4e52-9d4e-4f8cbfb09c54", com.pulse.mo.Supervisor.class);
uuidMap.put("9ef3106e-46e6-4196-a981-05c4b4f926f1", com.pulse.mo.TeamLeaderImpersonation.class);
uuidMap.put("7065ca66-2e78-49b0-aa1c-4aa92700aeed", com.pulse.mo.ThresholdLevel.class);
uuidMap.put("fa4f2481-8748-450d-8b27-f70e7adf62d0", com.pulse.mo.TraceEntry.class);
uuidMap.put("bf1e14ec-3670-4de9-b5ac-b05f40ee87b9", com.pulse.mo.UserRole.class);
uuidMap.put("21ec6c27-47a5-45b9-8659-830dd25fb254", com.pulse.mo.UserSession.class);
uuidMap.put("703538c0-68ff-4289-b39e-5c850a29e762", com.pulse.mo.ChangesNotApprovedNotification.class);
uuidMap.put("3b79c3d4-a71c-4001-bab7-737581e70b7f", com.pulse.mo.CoachingNotification.class);

		}
		return uuidMap;
	}

}