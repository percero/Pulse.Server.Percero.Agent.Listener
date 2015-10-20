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
			classList.add(com.pulse.mo.TimecardActivity.class);
classList.add(com.pulse.mo.AdhocCoachingCategory.class);
classList.add(com.pulse.mo.AdhocCoachingSessionAttachment.class);
classList.add(com.pulse.mo.AdhocTaskState.class);
classList.add(com.pulse.mo.Notification.class);
classList.add(com.pulse.mo.CoachingNotification.class);
classList.add(com.pulse.mo.CoachingSessionState.class);
classList.add(com.pulse.mo.Comment.class);
classList.add(com.pulse.mo.CorrectiveActionState.class);
classList.add(com.pulse.mo.CorrectiveActionType.class);
classList.add(com.pulse.mo.Agent.class);
classList.add(com.pulse.mo.LOB.class);
classList.add(com.pulse.mo.LOBConfiguration.class);
classList.add(com.pulse.mo.LOBConfigurationNotification.class);
classList.add(com.pulse.mo.DiscrepancyDetectedNotification.class);
classList.add(com.pulse.mo.DurationMismatchNotification.class);
classList.add(com.pulse.mo.ThresholdExceededNotification.class);
classList.add(com.pulse.mo.DurationToleranceNotification.class);
classList.add(com.pulse.mo.Employee.class);
classList.add(com.pulse.mo.InvalidActivityCodeNotification.class);
classList.add(com.pulse.mo.Measure.class);
classList.add(com.pulse.mo.NonBillableActivityNotification.class);
classList.add(com.pulse.mo.Alert.class);
classList.add(com.pulse.mo.NotificationAlert.class);
classList.add(com.pulse.mo.NotificationFrequency.class);
classList.add(com.pulse.mo.OccurrenceMismatchNotification.class);
classList.add(com.pulse.mo.OccurrenceToleranceNotification.class);
classList.add(com.pulse.mo.PulseConfiguration.class);
classList.add(com.pulse.mo.Role.class);
classList.add(com.pulse.mo.Scorecard.class);
classList.add(com.pulse.mo.Site.class);
classList.add(com.pulse.mo.TraceLog.class);
classList.add(com.pulse.mo.WorkDurationNotification.class);
classList.add(com.pulse.mo.WorkModeOccurrenceNotification.class);
classList.add(com.pulse.mo.Client.class);
classList.add(com.pulse.mo.CMSEntry.class);
classList.add(com.pulse.mo.Schedule.class);
classList.add(com.pulse.mo.ScheduleEntry.class);
classList.add(com.pulse.mo.Timecard.class);
classList.add(com.pulse.mo.TimecardEntry.class);
classList.add(com.pulse.mo.AdhocCoachingSession.class);
classList.add(com.pulse.mo.AdhocTask.class);
classList.add(com.pulse.mo.AgentScorecard.class);
classList.add(com.pulse.mo.Behavior.class);
classList.add(com.pulse.mo.BehaviorResponse.class);
classList.add(com.pulse.mo.CoachingSession.class);
classList.add(com.pulse.mo.CoachingSessionAttachment.class);
classList.add(com.pulse.mo.Supervisor.class);
classList.add(com.pulse.mo.CorrectiveAction.class);
classList.add(com.pulse.mo.CorrectiveActionAttachment.class);
classList.add(com.pulse.mo.DevelopmentActivity.class);
classList.add(com.pulse.mo.DevelopmentPlan.class);
classList.add(com.pulse.mo.Email.class);
classList.add(com.pulse.mo.Goal.class);
classList.add(com.pulse.mo.GradeScale.class);
classList.add(com.pulse.mo.LOBConfigurationEntry.class);
classList.add(com.pulse.mo.TeamLeader.class);
classList.add(com.pulse.mo.PulseUser.class);
classList.add(com.pulse.mo.QualityEvaluation.class);
classList.add(com.pulse.mo.ScorecardMeasure.class);
classList.add(com.pulse.mo.ScorecardMonthlyResult.class);
classList.add(com.pulse.mo.ScorecardWeeklyResult.class);
classList.add(com.pulse.mo.Setting.class);
classList.add(com.pulse.mo.TeamLeaderImpersonation.class);
classList.add(com.pulse.mo.TraceEntry.class);
classList.add(com.pulse.mo.UserRole.class);
classList.add(com.pulse.mo.UserSession.class);
classList.add(com.pulse.mo.ShiftStatusNotification.class);

		}
		return classList;
	}

	private List<Object> objectList = null;
	public List<Object> getObjectList() {
		if (objectList == null) {
			objectList = new ArrayList<Object>();
			objectList.add(new com.pulse.mo.TimecardActivity());
objectList.add(new com.pulse.mo.AdhocCoachingCategory());
objectList.add(new com.pulse.mo.AdhocCoachingSessionAttachment());
objectList.add(new com.pulse.mo.AdhocTaskState());
objectList.add(new com.pulse.mo.Notification());
objectList.add(new com.pulse.mo.CoachingNotification());
objectList.add(new com.pulse.mo.CoachingSessionState());
objectList.add(new com.pulse.mo.Comment());
objectList.add(new com.pulse.mo.CorrectiveActionState());
objectList.add(new com.pulse.mo.CorrectiveActionType());
objectList.add(new com.pulse.mo.Agent());
objectList.add(new com.pulse.mo.LOB());
objectList.add(new com.pulse.mo.LOBConfiguration());
objectList.add(new com.pulse.mo.LOBConfigurationNotification());
objectList.add(new com.pulse.mo.DiscrepancyDetectedNotification());
objectList.add(new com.pulse.mo.DurationMismatchNotification());
objectList.add(new com.pulse.mo.ThresholdExceededNotification());
objectList.add(new com.pulse.mo.DurationToleranceNotification());
objectList.add(new com.pulse.mo.Employee());
objectList.add(new com.pulse.mo.InvalidActivityCodeNotification());
objectList.add(new com.pulse.mo.Measure());
objectList.add(new com.pulse.mo.NonBillableActivityNotification());
objectList.add(new com.pulse.mo.Alert());
objectList.add(new com.pulse.mo.NotificationAlert());
objectList.add(new com.pulse.mo.NotificationFrequency());
objectList.add(new com.pulse.mo.OccurrenceMismatchNotification());
objectList.add(new com.pulse.mo.OccurrenceToleranceNotification());
objectList.add(new com.pulse.mo.PulseConfiguration());
objectList.add(new com.pulse.mo.Role());
objectList.add(new com.pulse.mo.Scorecard());
objectList.add(new com.pulse.mo.Site());
objectList.add(new com.pulse.mo.TraceLog());
objectList.add(new com.pulse.mo.WorkDurationNotification());
objectList.add(new com.pulse.mo.WorkModeOccurrenceNotification());
objectList.add(new com.pulse.mo.Client());
objectList.add(new com.pulse.mo.CMSEntry());
objectList.add(new com.pulse.mo.Schedule());
objectList.add(new com.pulse.mo.ScheduleEntry());
objectList.add(new com.pulse.mo.Timecard());
objectList.add(new com.pulse.mo.TimecardEntry());
objectList.add(new com.pulse.mo.AdhocCoachingSession());
objectList.add(new com.pulse.mo.AdhocTask());
objectList.add(new com.pulse.mo.AgentScorecard());
objectList.add(new com.pulse.mo.Behavior());
objectList.add(new com.pulse.mo.BehaviorResponse());
objectList.add(new com.pulse.mo.CoachingSession());
objectList.add(new com.pulse.mo.CoachingSessionAttachment());
objectList.add(new com.pulse.mo.Supervisor());
objectList.add(new com.pulse.mo.CorrectiveAction());
objectList.add(new com.pulse.mo.CorrectiveActionAttachment());
objectList.add(new com.pulse.mo.DevelopmentActivity());
objectList.add(new com.pulse.mo.DevelopmentPlan());
objectList.add(new com.pulse.mo.Email());
objectList.add(new com.pulse.mo.Goal());
objectList.add(new com.pulse.mo.GradeScale());
objectList.add(new com.pulse.mo.LOBConfigurationEntry());
objectList.add(new com.pulse.mo.TeamLeader());
objectList.add(new com.pulse.mo.PulseUser());
objectList.add(new com.pulse.mo.QualityEvaluation());
objectList.add(new com.pulse.mo.ScorecardMeasure());
objectList.add(new com.pulse.mo.ScorecardMonthlyResult());
objectList.add(new com.pulse.mo.ScorecardWeeklyResult());
objectList.add(new com.pulse.mo.Setting());
objectList.add(new com.pulse.mo.TeamLeaderImpersonation());
objectList.add(new com.pulse.mo.TraceEntry());
objectList.add(new com.pulse.mo.UserRole());
objectList.add(new com.pulse.mo.UserSession());
objectList.add(new com.pulse.mo.ShiftStatusNotification());

		}
		return objectList;
	}

	private Map<String, Class> uuidMap = null;
	public Map<String, Class> getUuidMap() {
		if (uuidMap == null) {
			uuidMap = new HashMap<String, Class>();
			uuidMap.put("4c6950a1-fa5f-4d42-95ba-ad5feab6672f", com.pulse.mo.TimecardActivity.class);
uuidMap.put("fd1d85ee-2e35-4971-b7e8-b9b7dd0a2fd5", com.pulse.mo.AdhocCoachingCategory.class);
uuidMap.put("5ac5b506-1d2b-4bc7-a03c-a8aa53a99956", com.pulse.mo.AdhocCoachingSessionAttachment.class);
uuidMap.put("52ab55f3-b364-4e32-a1cc-2fdd5581b964", com.pulse.mo.AdhocTaskState.class);
uuidMap.put("9aca5f7d-f8a9-4399-8696-969f08707648", com.pulse.mo.Notification.class);
uuidMap.put("0a3c43a8-4c09-4aff-a05e-31110764bcce", com.pulse.mo.CoachingNotification.class);
uuidMap.put("8ef6bd3b-1820-4918-ae21-ba5ab90cbccc", com.pulse.mo.CoachingSessionState.class);
uuidMap.put("d531c2f3-153c-4a98-ad6c-dc595a2e8ecd", com.pulse.mo.Comment.class);
uuidMap.put("eb5fd9c0-7d90-40f7-9d9e-3bf40085db71", com.pulse.mo.CorrectiveActionState.class);
uuidMap.put("dfa26c2d-3eea-477e-9d15-0096ac901096", com.pulse.mo.CorrectiveActionType.class);
uuidMap.put("11b9b446-eb31-4805-bc5b-4ec894a5eecf", com.pulse.mo.Agent.class);
uuidMap.put("98026a4f-ba2d-4a61-a1cf-f18284ee3bf7", com.pulse.mo.LOB.class);
uuidMap.put("8065c176-8bf1-437c-9c39-7d4fed05239a", com.pulse.mo.LOBConfiguration.class);
uuidMap.put("4209cf35-bba6-4d2c-9927-c2a4f09e010f", com.pulse.mo.LOBConfigurationNotification.class);
uuidMap.put("50936e8c-275b-4f8b-8bea-aac6458db276", com.pulse.mo.DiscrepancyDetectedNotification.class);
uuidMap.put("1f108a00-1548-42aa-bd9e-fbaa331186a7", com.pulse.mo.DurationMismatchNotification.class);
uuidMap.put("05e0a6bb-d512-4e19-9e6b-2d34b3bdae24", com.pulse.mo.ThresholdExceededNotification.class);
uuidMap.put("c6362079-7be0-4360-b4e0-bcdd84482725", com.pulse.mo.DurationToleranceNotification.class);
uuidMap.put("2afc336e-5fe2-47e8-af64-fe7bf4f3bef8", com.pulse.mo.Employee.class);
uuidMap.put("1bbf8389-ff2c-4e3e-bd34-0b771097ad01", com.pulse.mo.InvalidActivityCodeNotification.class);
uuidMap.put("134de589-ebd1-4977-90e5-51dbad82f815", com.pulse.mo.Measure.class);
uuidMap.put("84b71b6d-99b4-477d-858e-1cf3a557f856", com.pulse.mo.NonBillableActivityNotification.class);
uuidMap.put("384fdd06-07eb-4203-8067-d4f4982dcb39", com.pulse.mo.Alert.class);
uuidMap.put("19f75fe7-e070-49dd-ac3f-c9efb2a19d3f", com.pulse.mo.NotificationAlert.class);
uuidMap.put("399ad79a-e4d6-4209-95d4-ceb7131acc3b", com.pulse.mo.NotificationFrequency.class);
uuidMap.put("660c3898-f76f-4f2b-a662-0a4702452727", com.pulse.mo.OccurrenceMismatchNotification.class);
uuidMap.put("1ad19b4c-a32c-4741-b343-1798bccb2027", com.pulse.mo.OccurrenceToleranceNotification.class);
uuidMap.put("ada7c90b-eb78-4ad3-89b7-73f2b49d0250", com.pulse.mo.PulseConfiguration.class);
uuidMap.put("dbe23c46-a749-453c-b8f8-c03bfcf29d9d", com.pulse.mo.Role.class);
uuidMap.put("c1b7bffc-ba0b-42be-b2dc-06a0b59ec4ec", com.pulse.mo.Scorecard.class);
uuidMap.put("a3356818-f697-495d-a670-6eacbf9db858", com.pulse.mo.Site.class);
uuidMap.put("6eeb5723-ca5a-4f79-a322-42359a87212b", com.pulse.mo.TraceLog.class);
uuidMap.put("f2772c4c-d6a4-4c94-bb03-980ccdcdb282", com.pulse.mo.WorkDurationNotification.class);
uuidMap.put("1588937d-9c76-49ae-bb2d-a64a055474c5", com.pulse.mo.WorkModeOccurrenceNotification.class);
uuidMap.put("ef84f60e-5e37-45df-856f-73cdfb7e9b62", com.pulse.mo.Client.class);
uuidMap.put("34476702-09c3-4358-af92-400f30fe19ec", com.pulse.mo.CMSEntry.class);
uuidMap.put("5241b757-774c-406d-9987-9d64b815441a", com.pulse.mo.Schedule.class);
uuidMap.put("996de987-38d0-4e8b-b551-97b9a1f314e7", com.pulse.mo.ScheduleEntry.class);
uuidMap.put("19258484-9cb3-4a0b-8253-a9d58a1c4c3e", com.pulse.mo.Timecard.class);
uuidMap.put("1fb51b02-bce3-4d9f-911d-3c2a75daafcc", com.pulse.mo.TimecardEntry.class);
uuidMap.put("1eeb2a0b-924d-44ff-b274-062e43b40ba8", com.pulse.mo.AdhocCoachingSession.class);
uuidMap.put("975fd86e-3eb2-4c6c-8443-b4d9787be183", com.pulse.mo.AdhocTask.class);
uuidMap.put("4e970182-b8a1-4f23-b38b-985d9d80f362", com.pulse.mo.AgentScorecard.class);
uuidMap.put("0db92c75-bb5e-4f69-aa59-dec6d2192c4f", com.pulse.mo.Behavior.class);
uuidMap.put("a5f9c113-05ac-483a-8bd6-194786632bbe", com.pulse.mo.BehaviorResponse.class);
uuidMap.put("1e0b3e48-e780-4d4d-b693-cbea2d059e8e", com.pulse.mo.CoachingSession.class);
uuidMap.put("58e6bf2a-4ef6-4fe8-a368-60812e917d22", com.pulse.mo.CoachingSessionAttachment.class);
uuidMap.put("275bd008-16d9-4c0d-99b1-4c4482722109", com.pulse.mo.Supervisor.class);
uuidMap.put("b7e38084-af5d-47e2-9556-5d48b547a999", com.pulse.mo.CorrectiveAction.class);
uuidMap.put("12e226be-121c-4ac3-9759-9968bf59d31b", com.pulse.mo.CorrectiveActionAttachment.class);
uuidMap.put("2d07eeca-86f4-4117-8574-c858854e7e77", com.pulse.mo.DevelopmentActivity.class);
uuidMap.put("ad14a994-13db-410f-8e06-7b4342cf51aa", com.pulse.mo.DevelopmentPlan.class);
uuidMap.put("4260abf1-03f3-40f9-a1f8-252ae924de8d", com.pulse.mo.Email.class);
uuidMap.put("e334b02c-d088-451b-83c5-a3052434e703", com.pulse.mo.Goal.class);
uuidMap.put("c5baed9a-ca36-44d4-9640-ebd66cd2e2ef", com.pulse.mo.GradeScale.class);
uuidMap.put("ddeaf7a5-fc35-4e1a-8b02-1f55d30c2a60", com.pulse.mo.LOBConfigurationEntry.class);
uuidMap.put("1d10a1c4-b84e-4711-8c15-3ca95fc08f82", com.pulse.mo.TeamLeader.class);
uuidMap.put("c7581e15-c1ed-4e3a-b384-b6c10fa5a31f", com.pulse.mo.PulseUser.class);
uuidMap.put("ee91865e-2862-47e5-9357-b543b873b910", com.pulse.mo.QualityEvaluation.class);
uuidMap.put("2848f8c8-a562-420a-8a1a-be1be4e40932", com.pulse.mo.ScorecardMeasure.class);
uuidMap.put("cb755a6e-97c2-41a4-8a3c-54728ac294a1", com.pulse.mo.ScorecardMonthlyResult.class);
uuidMap.put("b084aef8-312f-4e7f-a6e1-7effd995fc5d", com.pulse.mo.ScorecardWeeklyResult.class);
uuidMap.put("3439049a-5ede-46a2-bac8-d33975f757bd", com.pulse.mo.Setting.class);
uuidMap.put("417479c9-0858-4aa7-8090-dd92a0a3c0c6", com.pulse.mo.TeamLeaderImpersonation.class);
uuidMap.put("448bb8f7-fb38-4b70-b2d5-875cbe89c2f8", com.pulse.mo.TraceEntry.class);
uuidMap.put("09e5d7f9-6dca-4cd5-83e4-cd2fa19f1438", com.pulse.mo.UserRole.class);
uuidMap.put("5305f1e0-e36a-4b54-aa70-bcb3ffc9f0c9", com.pulse.mo.UserSession.class);
uuidMap.put("d89330c7-1dfd-448b-be13-595db9077d06", com.pulse.mo.ShiftStatusNotification.class);

		}
		return uuidMap;
	}

}