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
classList.add(com.pulse.mo.AdhocTaskState.class);
classList.add(com.pulse.mo.Behavior.class);
classList.add(com.pulse.mo.Notification.class);
classList.add(com.pulse.mo.CoachingNotification.class);
classList.add(com.pulse.mo.CoachingSessionState.class);
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
classList.add(com.pulse.mo.PayrollDetail.class);
classList.add(com.pulse.mo.PulseConfiguration.class);
classList.add(com.pulse.mo.Role.class);
classList.add(com.pulse.mo.Scorecard.class);
classList.add(com.pulse.mo.Site.class);
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
classList.add(com.pulse.mo.TimecardEntry.class);
classList.add(com.pulse.mo.AdhocCoachingSession.class);
classList.add(com.pulse.mo.AdhocTask.class);
classList.add(com.pulse.mo.AgentScorecard.class);
classList.add(com.pulse.mo.BehaviorResponse.class);
classList.add(com.pulse.mo.CoachingSession.class);
classList.add(com.pulse.mo.CoachingSessionAttachment.class);
classList.add(com.pulse.mo.Comment.class);
classList.add(com.pulse.mo.Supervisor.class);
classList.add(com.pulse.mo.CorrectiveAction.class);
classList.add(com.pulse.mo.CorrectiveActionAttachment.class);
classList.add(com.pulse.mo.DevelopmentActivity.class);
classList.add(com.pulse.mo.DevelopmentPlan.class);
classList.add(com.pulse.mo.Email.class);
classList.add(com.pulse.mo.LOBConfigurationEntry.class);
classList.add(com.pulse.mo.TeamLeader.class);
classList.add(com.pulse.mo.PulseUser.class);
classList.add(com.pulse.mo.QualityEvaluation.class);
classList.add(com.pulse.mo.ScorecardMeasure.class);
classList.add(com.pulse.mo.ScorecardMeasureMonthlyResult.class);
classList.add(com.pulse.mo.ScorecardMeasureWeeklyResult.class);
classList.add(com.pulse.mo.Setting.class);
classList.add(com.pulse.mo.TeamLeaderImpersonation.class);
classList.add(com.pulse.mo.ThresholdLevel.class);
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
objectList.add(new com.pulse.mo.AdhocTaskState());
objectList.add(new com.pulse.mo.Behavior());
objectList.add(new com.pulse.mo.Notification());
objectList.add(new com.pulse.mo.CoachingNotification());
objectList.add(new com.pulse.mo.CoachingSessionState());
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
objectList.add(new com.pulse.mo.PayrollDetail());
objectList.add(new com.pulse.mo.PulseConfiguration());
objectList.add(new com.pulse.mo.Role());
objectList.add(new com.pulse.mo.Scorecard());
objectList.add(new com.pulse.mo.Site());
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
objectList.add(new com.pulse.mo.TimecardEntry());
objectList.add(new com.pulse.mo.AdhocCoachingSession());
objectList.add(new com.pulse.mo.AdhocTask());
objectList.add(new com.pulse.mo.AgentScorecard());
objectList.add(new com.pulse.mo.BehaviorResponse());
objectList.add(new com.pulse.mo.CoachingSession());
objectList.add(new com.pulse.mo.CoachingSessionAttachment());
objectList.add(new com.pulse.mo.Comment());
objectList.add(new com.pulse.mo.Supervisor());
objectList.add(new com.pulse.mo.CorrectiveAction());
objectList.add(new com.pulse.mo.CorrectiveActionAttachment());
objectList.add(new com.pulse.mo.DevelopmentActivity());
objectList.add(new com.pulse.mo.DevelopmentPlan());
objectList.add(new com.pulse.mo.Email());
objectList.add(new com.pulse.mo.LOBConfigurationEntry());
objectList.add(new com.pulse.mo.TeamLeader());
objectList.add(new com.pulse.mo.PulseUser());
objectList.add(new com.pulse.mo.QualityEvaluation());
objectList.add(new com.pulse.mo.ScorecardMeasure());
objectList.add(new com.pulse.mo.ScorecardMeasureMonthlyResult());
objectList.add(new com.pulse.mo.ScorecardMeasureWeeklyResult());
objectList.add(new com.pulse.mo.Setting());
objectList.add(new com.pulse.mo.TeamLeaderImpersonation());
objectList.add(new com.pulse.mo.ThresholdLevel());
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
			uuidMap.put("3107d521-aa4a-4c16-9e0a-9be2e1651e34", com.pulse.mo.TimecardActivity.class);
uuidMap.put("710aeb67-16f8-4299-ae86-40bd61ef83ae", com.pulse.mo.AdhocCoachingCategory.class);
uuidMap.put("5d7753d4-b2a5-4449-af43-11c6a2cfdcee", com.pulse.mo.AdhocTaskState.class);
uuidMap.put("b347f163-d083-4dc0-9b1c-6c658dcc4ddc", com.pulse.mo.Behavior.class);
uuidMap.put("c2fe8746-4bf9-4bdd-8f23-6d07a081a315", com.pulse.mo.Notification.class);
uuidMap.put("1b2635f8-ce0f-4a31-b4c7-e663f2262b9d", com.pulse.mo.CoachingNotification.class);
uuidMap.put("e2823bd5-58ef-4664-ac97-b75d58fcac91", com.pulse.mo.CoachingSessionState.class);
uuidMap.put("c247a2a6-91f6-4d02-ab93-f7ccaa860f88", com.pulse.mo.CorrectiveActionState.class);
uuidMap.put("b9de1914-ca2f-49bc-b962-df897ed990e2", com.pulse.mo.CorrectiveActionType.class);
uuidMap.put("9a095441-cdae-45d1-9ad3-db20ccb667ef", com.pulse.mo.Agent.class);
uuidMap.put("50f33580-a476-4ddb-8979-2e7d7465454e", com.pulse.mo.LOB.class);
uuidMap.put("9d59dbeb-e455-4995-9b14-795b34b55d1e", com.pulse.mo.LOBConfiguration.class);
uuidMap.put("2c2147dc-4bd9-447b-94bf-a629d703eeae", com.pulse.mo.LOBConfigurationNotification.class);
uuidMap.put("05a7b3d6-755b-43e7-b669-971fbc089a3a", com.pulse.mo.DiscrepancyDetectedNotification.class);
uuidMap.put("fe3d9c4e-2671-4426-a27d-004a47b84a89", com.pulse.mo.DurationMismatchNotification.class);
uuidMap.put("21314a6c-0259-4bdf-97f7-5580d5546426", com.pulse.mo.ThresholdExceededNotification.class);
uuidMap.put("2c54ca22-937c-478b-9a25-c4f47e859102", com.pulse.mo.DurationToleranceNotification.class);
uuidMap.put("8915f68f-56c6-451c-a9dd-091b3838d64e", com.pulse.mo.Employee.class);
uuidMap.put("e36addc3-7014-4757-8f8e-628efdf929a8", com.pulse.mo.InvalidActivityCodeNotification.class);
uuidMap.put("c1420f06-e8c8-4b33-9e42-f31bcb61e213", com.pulse.mo.Measure.class);
uuidMap.put("d78f1f0c-2f45-4926-bd10-f998ed710bb9", com.pulse.mo.NonBillableActivityNotification.class);
uuidMap.put("20c10b8a-50d8-4846-abf6-70c592ffbe60", com.pulse.mo.Alert.class);
uuidMap.put("57553565-620c-416c-a527-b5fa3a5de6cd", com.pulse.mo.NotificationAlert.class);
uuidMap.put("7bb36623-c8ac-4c6f-ac9a-59d0d82017c8", com.pulse.mo.NotificationFrequency.class);
uuidMap.put("3616faf9-e65c-4eef-a0d6-1a6a98008888", com.pulse.mo.OccurrenceMismatchNotification.class);
uuidMap.put("b616aaa2-5a30-4cb4-ab35-df782cf53e03", com.pulse.mo.OccurrenceToleranceNotification.class);
uuidMap.put("fd6a953c-a1a5-4783-89aa-222eec651ea7", com.pulse.mo.PayrollDetail.class);
uuidMap.put("c997d4a0-3b51-415b-9fbf-da97821c5e61", com.pulse.mo.PulseConfiguration.class);
uuidMap.put("f3c085ea-14eb-410b-8902-815d4671e415", com.pulse.mo.Role.class);
uuidMap.put("71c3bfd4-8375-4ce2-bf11-e5fc1775401f", com.pulse.mo.Scorecard.class);
uuidMap.put("53bdd3f6-241f-42fc-b5eb-c5fedfb51983", com.pulse.mo.Site.class);
uuidMap.put("d8cbca42-5ae6-4d4f-b9d4-d8e5734af024", com.pulse.mo.ThresholdGradeScale.class);
uuidMap.put("d3994fa9-7cf0-449d-b041-667f70e72107", com.pulse.mo.ThresholdScale.class);
uuidMap.put("0bbce4f9-ef8f-4ceb-ad3e-01c8bb0d42d8", com.pulse.mo.TraceLog.class);
uuidMap.put("28ab12fa-2b16-4ffa-9bf5-f1f0b3076eb2", com.pulse.mo.WorkDurationNotification.class);
uuidMap.put("f35ad76d-b609-45c1-a863-e7f113b3f17b", com.pulse.mo.WorkModeOccurrenceNotification.class);
uuidMap.put("61e15a03-6e64-4e0a-98ad-7cc4d4129361", com.pulse.mo.Client.class);
uuidMap.put("235c0a59-444f-4fcd-8aa7-885b918f1059", com.pulse.mo.CMSEntry.class);
uuidMap.put("b5826022-c1ab-44bf-bb5f-984bc56a4965", com.pulse.mo.Schedule.class);
uuidMap.put("394471ba-1f9c-460b-bd0b-3db1ad8ecb2a", com.pulse.mo.ScheduleEntry.class);
uuidMap.put("c3bbf785-5b5b-46ae-864d-325ebfdf6b97", com.pulse.mo.Timecard.class);
uuidMap.put("cca124f0-9960-411a-900b-86795668f100", com.pulse.mo.TimecardEntry.class);
uuidMap.put("28743760-d6a9-4780-b8d8-50eacd201516", com.pulse.mo.AdhocCoachingSession.class);
uuidMap.put("97a02be1-5a1b-4548-8801-2d586830ffc3", com.pulse.mo.AdhocTask.class);
uuidMap.put("60904659-dce5-4d94-ba45-282d008fa8c9", com.pulse.mo.AgentScorecard.class);
uuidMap.put("a356ee48-62b7-48eb-b748-d252f987e081", com.pulse.mo.BehaviorResponse.class);
uuidMap.put("9f59f172-6ac0-4a30-a70f-fa5c5ded94ec", com.pulse.mo.CoachingSession.class);
uuidMap.put("bab9adde-6458-446d-9664-7c48db8bfffe", com.pulse.mo.CoachingSessionAttachment.class);
uuidMap.put("e0f2ae71-c576-47b5-a53f-b5dad49e2f69", com.pulse.mo.Comment.class);
uuidMap.put("b15ce4a5-1816-4978-80d0-c96bda6f3e71", com.pulse.mo.Supervisor.class);
uuidMap.put("44661211-859d-4aaf-9ab2-dd44e8caf8b2", com.pulse.mo.CorrectiveAction.class);
uuidMap.put("6103f4e4-2440-4d6f-a315-32e1df898371", com.pulse.mo.CorrectiveActionAttachment.class);
uuidMap.put("e3895853-7e0b-4666-a3ba-33fa62e2bd79", com.pulse.mo.DevelopmentActivity.class);
uuidMap.put("128090bf-ae49-4a28-8cca-8a70116a0b90", com.pulse.mo.DevelopmentPlan.class);
uuidMap.put("d05769ea-a7e1-4c04-9905-93f54cf4475c", com.pulse.mo.Email.class);
uuidMap.put("23aa8535-4853-4971-8188-f0bb56018bd6", com.pulse.mo.LOBConfigurationEntry.class);
uuidMap.put("f64bd04d-02f1-4b5a-837a-7bffe9f5e4f0", com.pulse.mo.TeamLeader.class);
uuidMap.put("1939444a-80aa-4da7-9da5-d163b4d9223a", com.pulse.mo.PulseUser.class);
uuidMap.put("38b632de-751d-4039-a204-20ee1cf6bb66", com.pulse.mo.QualityEvaluation.class);
uuidMap.put("6750a5d5-05b4-49b3-acdf-44e203eef251", com.pulse.mo.ScorecardMeasure.class);
uuidMap.put("0303e216-3647-4cf6-8fec-3c2d40a05fdf", com.pulse.mo.ScorecardMeasureMonthlyResult.class);
uuidMap.put("05e4edc0-d726-46d1-9889-05dde4272f50", com.pulse.mo.ScorecardMeasureWeeklyResult.class);
uuidMap.put("e86b5fe3-2102-409d-bbb2-2fe7b9554424", com.pulse.mo.Setting.class);
uuidMap.put("b7231072-7971-4d41-a4cb-158143a5e0f4", com.pulse.mo.TeamLeaderImpersonation.class);
uuidMap.put("6f1aa048-b0a2-481f-be55-67aac29944f7", com.pulse.mo.ThresholdLevel.class);
uuidMap.put("9e58dc5d-9294-41b0-8082-280fd5351909", com.pulse.mo.TraceEntry.class);
uuidMap.put("8af25012-8db3-47e0-81b6-318fb119db5b", com.pulse.mo.UserRole.class);
uuidMap.put("04560ddd-17e8-4db8-a508-389facf4315c", com.pulse.mo.UserSession.class);
uuidMap.put("c5e23466-9037-44a6-87ad-16ee71643823", com.pulse.mo.ShiftStatusNotification.class);

		}
		return uuidMap;
	}

}