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
			classList.add(com.pulse.mo.Client.class);
classList.add(com.pulse.mo.TimecardActivity.class);
classList.add(com.pulse.mo.AdhocCoachingCategory.class);
classList.add(com.pulse.mo.AdhocTaskState.class);
classList.add(com.pulse.mo.CoachingSessionState.class);
classList.add(com.pulse.mo.CorrectiveActionState.class);
classList.add(com.pulse.mo.CorrectiveActionType.class);
classList.add(com.pulse.mo.Notification.class);
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
classList.add(com.pulse.mo.SessionComment.class);
classList.add(com.pulse.mo.Site.class);
classList.add(com.pulse.mo.TraceLog.class);
classList.add(com.pulse.mo.WorkDurationNotification.class);
classList.add(com.pulse.mo.WorkModeOccurrenceNotification.class);
classList.add(com.pulse.mo.AgentTimeZone.class);
classList.add(com.pulse.mo.ClientSite.class);
classList.add(com.pulse.mo.CMSEntry.class);
classList.add(com.pulse.mo.CMSEntryLOB.class);
classList.add(com.pulse.mo.Schedule.class);
classList.add(com.pulse.mo.ScheduleEntry.class);
classList.add(com.pulse.mo.Timecard.class);
classList.add(com.pulse.mo.TimecardEntry.class);
classList.add(com.pulse.mo.AdhocCoachingSession.class);
classList.add(com.pulse.mo.AdhocCoachingSessionAttachment.class);
classList.add(com.pulse.mo.AdhocTask.class);
classList.add(com.pulse.mo.ScorecardWeeklyScore.class);
classList.add(com.pulse.mo.AgentScorecard.class);
classList.add(com.pulse.mo.Behavior.class);
classList.add(com.pulse.mo.BehaviorResponse.class);
classList.add(com.pulse.mo.CoachingSession.class);
classList.add(com.pulse.mo.CoachingSessionAttachment.class);
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
classList.add(com.pulse.mo.ScorecardMonthlyScore.class);
classList.add(com.pulse.mo.ScorecardWeeklyResult.class);
classList.add(com.pulse.mo.Setting.class);
classList.add(com.pulse.mo.Supervisor.class);
classList.add(com.pulse.mo.TeamLeaderImpersonation.class);
classList.add(com.pulse.mo.TraceEntry.class);
classList.add(com.pulse.mo.UserRole.class);
classList.add(com.pulse.mo.UserSession.class);
classList.add(com.pulse.mo.WeeklyDevelopmentActivity.class);
classList.add(com.pulse.mo.WeeklyDevelopmentPlan.class);
classList.add(com.pulse.mo.CoachingNotification.class);
classList.add(com.pulse.mo.ShiftStatusNotification.class);

		}
		return classList;
	}

	private List<Object> objectList = null;
	public List<Object> getObjectList() {
		if (objectList == null) {
			objectList = new ArrayList<Object>();
			objectList.add(new com.pulse.mo.Client());
objectList.add(new com.pulse.mo.TimecardActivity());
objectList.add(new com.pulse.mo.AdhocCoachingCategory());
objectList.add(new com.pulse.mo.AdhocTaskState());
objectList.add(new com.pulse.mo.CoachingSessionState());
objectList.add(new com.pulse.mo.CorrectiveActionState());
objectList.add(new com.pulse.mo.CorrectiveActionType());
objectList.add(new com.pulse.mo.Notification());
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
objectList.add(new com.pulse.mo.SessionComment());
objectList.add(new com.pulse.mo.Site());
objectList.add(new com.pulse.mo.TraceLog());
objectList.add(new com.pulse.mo.WorkDurationNotification());
objectList.add(new com.pulse.mo.WorkModeOccurrenceNotification());
objectList.add(new com.pulse.mo.AgentTimeZone());
objectList.add(new com.pulse.mo.ClientSite());
objectList.add(new com.pulse.mo.CMSEntry());
objectList.add(new com.pulse.mo.CMSEntryLOB());
objectList.add(new com.pulse.mo.Schedule());
objectList.add(new com.pulse.mo.ScheduleEntry());
objectList.add(new com.pulse.mo.Timecard());
objectList.add(new com.pulse.mo.TimecardEntry());
objectList.add(new com.pulse.mo.AdhocCoachingSession());
objectList.add(new com.pulse.mo.AdhocCoachingSessionAttachment());
objectList.add(new com.pulse.mo.AdhocTask());
objectList.add(new com.pulse.mo.ScorecardWeeklyScore());
objectList.add(new com.pulse.mo.AgentScorecard());
objectList.add(new com.pulse.mo.Behavior());
objectList.add(new com.pulse.mo.BehaviorResponse());
objectList.add(new com.pulse.mo.CoachingSession());
objectList.add(new com.pulse.mo.CoachingSessionAttachment());
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
objectList.add(new com.pulse.mo.ScorecardMonthlyScore());
objectList.add(new com.pulse.mo.ScorecardWeeklyResult());
objectList.add(new com.pulse.mo.Setting());
objectList.add(new com.pulse.mo.Supervisor());
objectList.add(new com.pulse.mo.TeamLeaderImpersonation());
objectList.add(new com.pulse.mo.TraceEntry());
objectList.add(new com.pulse.mo.UserRole());
objectList.add(new com.pulse.mo.UserSession());
objectList.add(new com.pulse.mo.WeeklyDevelopmentActivity());
objectList.add(new com.pulse.mo.WeeklyDevelopmentPlan());
objectList.add(new com.pulse.mo.CoachingNotification());
objectList.add(new com.pulse.mo.ShiftStatusNotification());

		}
		return objectList;
	}

	private Map<String, Class> uuidMap = null;
	public Map<String, Class> getUuidMap() {
		if (uuidMap == null) {
			uuidMap = new HashMap<String, Class>();
			uuidMap.put("18a662c5-44fa-4bc8-b4a8-f446302c84c4", com.pulse.mo.Client.class);
uuidMap.put("4a88fc25-3956-45a6-ae1a-4b79990f2282", com.pulse.mo.TimecardActivity.class);
uuidMap.put("819653b6-a463-4d76-a5d5-c2a600da0b5d", com.pulse.mo.AdhocCoachingCategory.class);
uuidMap.put("5dccec37-5bcf-47f4-b563-e07626b5da18", com.pulse.mo.AdhocTaskState.class);
uuidMap.put("ffbae916-8571-495a-9512-d4b9378c8f87", com.pulse.mo.CoachingSessionState.class);
uuidMap.put("3ead7106-cfa4-4c6f-a16b-d453aebdecf8", com.pulse.mo.CorrectiveActionState.class);
uuidMap.put("ba0ce9eb-a7b6-411a-8a5d-c10f93286301", com.pulse.mo.CorrectiveActionType.class);
uuidMap.put("2565bee0-c9db-4666-9193-067e024f1e52", com.pulse.mo.Notification.class);
uuidMap.put("364b0433-55b1-442f-ab52-d86fd5a530ff", com.pulse.mo.Agent.class);
uuidMap.put("84943032-4752-4789-a61e-f9c5434b5393", com.pulse.mo.LOB.class);
uuidMap.put("19a795a6-3cd2-46d2-83c2-6d3e5b94e750", com.pulse.mo.LOBConfiguration.class);
uuidMap.put("b04b5c10-3e7a-4f82-9aa0-43243f0ecb03", com.pulse.mo.LOBConfigurationNotification.class);
uuidMap.put("840abe1d-a680-4ac6-a0f3-b279fd21f054", com.pulse.mo.DiscrepancyDetectedNotification.class);
uuidMap.put("f38b3595-bf04-4579-bebb-d21e1ed6c3c4", com.pulse.mo.DurationMismatchNotification.class);
uuidMap.put("eaf52c30-c96f-4693-9b3c-72e708623414", com.pulse.mo.ThresholdExceededNotification.class);
uuidMap.put("7653f494-82ec-4784-8d03-0ca869f91ffd", com.pulse.mo.DurationToleranceNotification.class);
uuidMap.put("daeb6410-1ba5-47a8-a06f-016d0156173a", com.pulse.mo.Employee.class);
uuidMap.put("4ae5e8c6-d182-4dc1-b2d0-616713cd02f3", com.pulse.mo.InvalidActivityCodeNotification.class);
uuidMap.put("77580c74-b212-46a2-b5c6-9d24fe2fc83c", com.pulse.mo.Measure.class);
uuidMap.put("2a95d136-f046-4c85-a5a8-ade5fd6fb6bb", com.pulse.mo.NonBillableActivityNotification.class);
uuidMap.put("77d7d2b8-4811-46c7-82ed-e4d54307c3a8", com.pulse.mo.Alert.class);
uuidMap.put("9d9e641d-5357-49aa-a0f4-136c929fdf40", com.pulse.mo.NotificationAlert.class);
uuidMap.put("1a3f9b4a-7fe9-4d04-9951-2d315bcde8eb", com.pulse.mo.NotificationFrequency.class);
uuidMap.put("79643a5e-30c3-4228-8ec5-e45ce0d6b214", com.pulse.mo.OccurrenceMismatchNotification.class);
uuidMap.put("f8bb16aa-5530-4ba6-ac47-5b913923e342", com.pulse.mo.OccurrenceToleranceNotification.class);
uuidMap.put("a99d4fd8-aadb-4f1c-bd92-ab8bdd3ff282", com.pulse.mo.PulseConfiguration.class);
uuidMap.put("8c6eb88f-c058-4478-b5ef-f19f80721350", com.pulse.mo.Role.class);
uuidMap.put("7946ceef-a14e-4a40-8372-4eaaba735a76", com.pulse.mo.Scorecard.class);
uuidMap.put("8a9c24f3-675e-4e26-bcf0-0fe3b75d858b", com.pulse.mo.SessionComment.class);
uuidMap.put("aa51dbe0-8025-4e61-9148-852ca9c26180", com.pulse.mo.Site.class);
uuidMap.put("386d7ac1-a5ba-400a-b60e-22b48f8f620d", com.pulse.mo.TraceLog.class);
uuidMap.put("7e6b07a5-7be0-408c-b1c6-178684bdcd16", com.pulse.mo.WorkDurationNotification.class);
uuidMap.put("196d90f7-4ab5-40da-95c1-9ab1a66b1791", com.pulse.mo.WorkModeOccurrenceNotification.class);
uuidMap.put("a8721614-82e6-4bb5-b046-cee9a0363153", com.pulse.mo.AgentTimeZone.class);
uuidMap.put("d2eba33d-4ad8-416b-8159-b38a96a49c46", com.pulse.mo.ClientSite.class);
uuidMap.put("08d8b1a8-3c9d-4d1d-8fee-da00bafa4bb1", com.pulse.mo.CMSEntry.class);
uuidMap.put("e427a8b7-c7c5-4e00-b56b-9aa97ec92e74", com.pulse.mo.CMSEntryLOB.class);
uuidMap.put("a346ecfb-2db4-423c-9db6-774f2b43a308", com.pulse.mo.Schedule.class);
uuidMap.put("1c5e599d-10f7-47e8-a5e4-eac109d6a62d", com.pulse.mo.ScheduleEntry.class);
uuidMap.put("6dc75fd4-296f-4020-916c-d134866ab4f8", com.pulse.mo.Timecard.class);
uuidMap.put("c56a6d54-9923-42b9-b329-003fe203735e", com.pulse.mo.TimecardEntry.class);
uuidMap.put("d6183c1b-34ba-41f9-b874-d4a3166385f5", com.pulse.mo.AdhocCoachingSession.class);
uuidMap.put("0e50cf8c-0785-41c1-95e6-7564c6911a4c", com.pulse.mo.AdhocCoachingSessionAttachment.class);
uuidMap.put("2a315655-1c49-47e2-b61f-f5c2302fd383", com.pulse.mo.AdhocTask.class);
uuidMap.put("cff1cb94-2db6-41e8-83b2-795b057fb1dd", com.pulse.mo.ScorecardWeeklyScore.class);
uuidMap.put("ef874158-b4de-4933-a349-fe78adb15fc0", com.pulse.mo.AgentScorecard.class);
uuidMap.put("cb69d997-d7e7-44fd-9eac-09724f9aec14", com.pulse.mo.Behavior.class);
uuidMap.put("b056ae23-0d0b-476f-8d91-06a518598271", com.pulse.mo.BehaviorResponse.class);
uuidMap.put("dbd93a2e-bad6-4eb6-8b69-13b8b267078d", com.pulse.mo.CoachingSession.class);
uuidMap.put("71c0caae-504c-4485-abff-12a82e62718f", com.pulse.mo.CoachingSessionAttachment.class);
uuidMap.put("e43d96ac-659f-49c7-ae64-dcef0ad2ba1b", com.pulse.mo.CorrectiveAction.class);
uuidMap.put("de2177a2-ca07-4f9b-a54e-759b1e51f31e", com.pulse.mo.CorrectiveActionAttachment.class);
uuidMap.put("2a813706-90c3-4724-823d-e4219a3d9840", com.pulse.mo.DevelopmentActivity.class);
uuidMap.put("8ad21005-db8d-4df4-9928-d3e2f402fc07", com.pulse.mo.DevelopmentPlan.class);
uuidMap.put("b1534b32-0878-4441-b35d-bad85e87caad", com.pulse.mo.Email.class);
uuidMap.put("fe6475b2-6603-468a-861f-9a6335865c2d", com.pulse.mo.Goal.class);
uuidMap.put("8dc1c440-8a93-48cc-9071-d8d39a2a5aed", com.pulse.mo.GradeScale.class);
uuidMap.put("7072dc9b-4dc0-43d4-9324-2fb2eff5f1c3", com.pulse.mo.LOBConfigurationEntry.class);
uuidMap.put("ed959ff5-7471-493e-84e0-a3d08622dadb", com.pulse.mo.TeamLeader.class);
uuidMap.put("1c152469-06e7-49cd-885e-4d72611f4422", com.pulse.mo.PulseUser.class);
uuidMap.put("0305d5e2-1290-40da-8693-fd350b050c7b", com.pulse.mo.QualityEvaluation.class);
uuidMap.put("c9793215-0799-4596-a3af-2c835474f5bc", com.pulse.mo.ScorecardMeasure.class);
uuidMap.put("4853a380-9973-4e15-9a4c-a4e71a4379ca", com.pulse.mo.ScorecardMonthlyResult.class);
uuidMap.put("b4887d99-8b3d-4f9b-bdfa-c87e2586b14f", com.pulse.mo.ScorecardMonthlyScore.class);
uuidMap.put("ae680408-90f3-4caa-8a28-fa62eb2749dc", com.pulse.mo.ScorecardWeeklyResult.class);
uuidMap.put("8da794a4-6c5d-4594-85b4-999613e8282c", com.pulse.mo.Setting.class);
uuidMap.put("ce26ea44-37d5-42fa-8c96-75ca2fd588b4", com.pulse.mo.Supervisor.class);
uuidMap.put("eaa2ebc5-a5c3-48f7-b0ab-7d7509d3e785", com.pulse.mo.TeamLeaderImpersonation.class);
uuidMap.put("e7763acf-2fb9-4f53-8eb0-4e2b563fdea7", com.pulse.mo.TraceEntry.class);
uuidMap.put("049653b2-ceab-4ed1-b27a-1cf4325f3178", com.pulse.mo.UserRole.class);
uuidMap.put("4c83256d-f0ae-4a60-a416-8839f845b319", com.pulse.mo.UserSession.class);
uuidMap.put("21a8ece1-9750-4b44-905a-814886332a93", com.pulse.mo.WeeklyDevelopmentActivity.class);
uuidMap.put("0e0d6856-3c61-49bc-bc26-1235bbfaa21e", com.pulse.mo.WeeklyDevelopmentPlan.class);
uuidMap.put("a7ccea95-26a5-45cc-a1d7-5a52392ab97b", com.pulse.mo.CoachingNotification.class);
uuidMap.put("6c71c0d1-626b-43ef-829f-0a29d10c8f7f", com.pulse.mo.ShiftStatusNotification.class);

		}
		return uuidMap;
	}

}