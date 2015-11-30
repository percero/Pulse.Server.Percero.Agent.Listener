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
			classList.add(com.pulse.mo.Site.class);
			classList.add(com.pulse.mo.TraceLog.class);
			classList.add(com.pulse.mo.WorkDurationNotification.class);
			classList.add(com.pulse.mo.WorkModeOccurrenceNotification.class);
			classList.add(com.pulse.mo.AgentLOB.class);
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
			classList.add(com.pulse.mo.SessionComment.class);
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
			objectList.add(new com.pulse.mo.Site());
			objectList.add(new com.pulse.mo.TraceLog());
			objectList.add(new com.pulse.mo.WorkDurationNotification());
			objectList.add(new com.pulse.mo.WorkModeOccurrenceNotification());
			objectList.add(new com.pulse.mo.AgentLOB());
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
			objectList.add(new com.pulse.mo.SessionComment());
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
			uuidMap.put("91863937-9dc9-4e8d-ba03-03877257d490", com.pulse.mo.Client.class);
			uuidMap.put("7cce575a-79b5-47cd-a5c3-340897405470", com.pulse.mo.TimecardActivity.class);
			uuidMap.put("156590f0-7811-4a07-a50a-f065e9718251", com.pulse.mo.AdhocCoachingCategory.class);
			uuidMap.put("69083f5f-426a-449d-9bf0-05c45cb95739", com.pulse.mo.AdhocTaskState.class);
			uuidMap.put("4e37b5bb-31c2-4cef-b979-230aec76eaa1", com.pulse.mo.CoachingSessionState.class);
			uuidMap.put("445ec8da-a735-46e1-ba27-b1e71209aa3e", com.pulse.mo.CorrectiveActionState.class);
			uuidMap.put("5466e6a3-66a5-4796-9694-41ab9cb6c3b9", com.pulse.mo.CorrectiveActionType.class);
			uuidMap.put("2b330bac-11bc-44e1-ae2b-dd40fb9eb865", com.pulse.mo.Notification.class);
			uuidMap.put("d483f5e1-7082-4fd7-92e3-e1a84c5e93e8", com.pulse.mo.Agent.class);
			uuidMap.put("d3f26925-c07a-4976-b136-f2c1b2393b86", com.pulse.mo.LOB.class);
			uuidMap.put("364c1485-7cb9-4f81-ba5f-659c0e50b0ac", com.pulse.mo.LOBConfiguration.class);
			uuidMap.put("06c76063-ee1c-4390-9a1c-8ff83475e4aa", com.pulse.mo.LOBConfigurationNotification.class);
			uuidMap.put("f576aac4-2178-41ef-9c36-669b8e29596d", com.pulse.mo.DiscrepancyDetectedNotification.class);
			uuidMap.put("455ca202-7af7-42d8-8568-8a529347b632", com.pulse.mo.DurationMismatchNotification.class);
			uuidMap.put("c1f33a86-7e6d-4f05-b08a-b9a8c2d804d8", com.pulse.mo.ThresholdExceededNotification.class);
			uuidMap.put("0b6adb69-56ca-47ac-bba0-5c4c57565e9e", com.pulse.mo.DurationToleranceNotification.class);
			uuidMap.put("2f6c8626-9a68-411f-9855-f77884f48994", com.pulse.mo.Employee.class);
			uuidMap.put("e0e9010a-2b50-45a8-8b05-5e39feee2966", com.pulse.mo.InvalidActivityCodeNotification.class);
			uuidMap.put("a7749125-e1c6-4dea-a648-dcdc57176f1d", com.pulse.mo.Measure.class);
			uuidMap.put("9f29bda9-45cf-4ad5-859f-74fd3e4d64d9", com.pulse.mo.NonBillableActivityNotification.class);
			uuidMap.put("2ca0c733-0559-4b4a-afd5-e643ca9fff14", com.pulse.mo.Alert.class);
			uuidMap.put("d3a6841f-2a61-48eb-bb73-814ca416f048", com.pulse.mo.NotificationAlert.class);
			uuidMap.put("4cb2edf0-03cb-4c59-887d-8330762493b9", com.pulse.mo.NotificationFrequency.class);
			uuidMap.put("270656e1-04a5-4368-97eb-f0bb2a037479", com.pulse.mo.OccurrenceMismatchNotification.class);
			uuidMap.put("606132e7-86ca-4f5e-8e31-776d66f9dbf6", com.pulse.mo.OccurrenceToleranceNotification.class);
			uuidMap.put("347d9bd4-366d-4fcf-9a06-8d8f87e14cc5", com.pulse.mo.PulseConfiguration.class);
			uuidMap.put("1f87c9a8-c685-4a29-a208-6992d67024e6", com.pulse.mo.Role.class);
			uuidMap.put("0524bdad-8a07-4a5e-90f8-8d31ab9d7d8d", com.pulse.mo.Scorecard.class);
			uuidMap.put("5bffce6e-c890-416d-96eb-90808de139f9", com.pulse.mo.Site.class);
			uuidMap.put("e421a8c0-3d6a-491c-8e09-59deb5225d59", com.pulse.mo.TraceLog.class);
			uuidMap.put("c18b8e02-3b52-4194-8b36-158872261e31", com.pulse.mo.WorkDurationNotification.class);
			uuidMap.put("0b32c759-a103-4da5-9907-dbb19c40320e", com.pulse.mo.WorkModeOccurrenceNotification.class);
			uuidMap.put("69865f9b-fa15-4dec-b1a5-aebd0cb7ba94", com.pulse.mo.AgentLOB.class);
			uuidMap.put("d20d59f7-7c63-4cc6-a216-71cbc902cc85", com.pulse.mo.AgentTimeZone.class);
			uuidMap.put("f5cd2e53-5745-4505-a05b-89dc318a40e9", com.pulse.mo.ClientSite.class);
			uuidMap.put("8647874c-1dd9-468e-89fc-4b5b0fe2dd3c", com.pulse.mo.CMSEntry.class);
			uuidMap.put("a1af76e4-4be6-4cee-9ee5-5182bd765673", com.pulse.mo.CMSEntryLOB.class);
			uuidMap.put("c49f576d-7e22-4b9b-8195-0641f2f5b5fc", com.pulse.mo.Schedule.class);
			uuidMap.put("951b5f97-c740-4485-bf43-2b316b6d742d", com.pulse.mo.ScheduleEntry.class);
			uuidMap.put("1bd1a391-615b-412a-beb3-856d9db9453f", com.pulse.mo.Timecard.class);
			uuidMap.put("38d7bbb5-7f5b-4df5-b390-7efbdbac4dc0", com.pulse.mo.TimecardEntry.class);
			uuidMap.put("097c0d1a-0d02-4240-9eb6-cfbf3a798f3c", com.pulse.mo.AdhocCoachingSession.class);
			uuidMap.put("b90687d9-4a2d-422d-aeb6-4617b7983849", com.pulse.mo.AdhocCoachingSessionAttachment.class);
			uuidMap.put("393dd64b-7ec8-4baf-b79c-12cd6e0b6d2c", com.pulse.mo.AdhocTask.class);
			uuidMap.put("0db7a491-a25f-432b-96f5-2ae08f0657b4", com.pulse.mo.ScorecardWeeklyScore.class);
			uuidMap.put("f2d17ad4-8bad-4a3c-b752-a56dcdcd6b8f", com.pulse.mo.AgentScorecard.class);
			uuidMap.put("03217ee6-648f-4d41-b9af-d6d62089a82a", com.pulse.mo.Behavior.class);
			uuidMap.put("4a4cce59-3040-4576-92c5-d5893596717e", com.pulse.mo.BehaviorResponse.class);
			uuidMap.put("9aa081cd-bd1c-4f42-94b6-1e360e840cff", com.pulse.mo.CoachingSession.class);
			uuidMap.put("85cb863d-d97b-48ba-a161-c3787c225038", com.pulse.mo.CoachingSessionAttachment.class);
			uuidMap.put("7d29073e-afd4-409d-aee1-ea8b4b51524d", com.pulse.mo.CorrectiveAction.class);
			uuidMap.put("0ff09c90-687d-4052-b4af-a436b0f8a53c", com.pulse.mo.CorrectiveActionAttachment.class);
			uuidMap.put("576025d2-d007-44cf-ba95-71c7d6d972cc", com.pulse.mo.DevelopmentActivity.class);
			uuidMap.put("31f8807a-bfc8-4c23-83bd-0fb7efea96d6", com.pulse.mo.DevelopmentPlan.class);
			uuidMap.put("324ca08c-2f7c-4f80-9c3d-52d53c0b9b76", com.pulse.mo.Email.class);
			uuidMap.put("7706640b-5085-4b9d-b919-c710c707b366", com.pulse.mo.Goal.class);
			uuidMap.put("ed3718d0-d92e-4983-87a3-a8d4afe90184", com.pulse.mo.GradeScale.class);
			uuidMap.put("ea7a3511-df0d-4a7a-961e-e58b7defc7c6", com.pulse.mo.LOBConfigurationEntry.class);
			uuidMap.put("0afc6c8a-0ef4-4093-b2d5-c2fd2309b442", com.pulse.mo.TeamLeader.class);
			uuidMap.put("64e357fe-9904-48b9-bf0e-af0891e7d7df", com.pulse.mo.PulseUser.class);
			uuidMap.put("fde248b0-160d-49af-a212-b27f77f22ca7", com.pulse.mo.QualityEvaluation.class);
			uuidMap.put("c91ac4f4-797a-4c54-af4e-19b674d41243", com.pulse.mo.ScorecardMeasure.class);
			uuidMap.put("3401a62c-d904-40ba-a4fd-ca03edd893c0", com.pulse.mo.ScorecardMonthlyResult.class);
			uuidMap.put("bdaa41b3-0f1b-4eb9-91d5-43d4d025ff58", com.pulse.mo.ScorecardMonthlyScore.class);
			uuidMap.put("d735c4d9-9ad1-4053-8289-83fd34c00a25", com.pulse.mo.ScorecardWeeklyResult.class);
			uuidMap.put("5b35a653-f948-4ba9-94f9-1df1208d6fb3", com.pulse.mo.SessionComment.class);
			uuidMap.put("34ea215a-22f9-4452-8a0f-06ac5f0ff6a2", com.pulse.mo.Setting.class);
			uuidMap.put("7eaf946e-6823-4901-bc07-f4d913ee1e5b", com.pulse.mo.Supervisor.class);
			uuidMap.put("e0c33136-a9a9-4a76-b6ed-aef8252a23db", com.pulse.mo.TeamLeaderImpersonation.class);
			uuidMap.put("8c69d44e-799f-449f-968d-03ef049d583b", com.pulse.mo.TraceEntry.class);
			uuidMap.put("a6b06b80-4d84-48fb-bdbb-fb1b32e70fbc", com.pulse.mo.UserRole.class);
			uuidMap.put("edd47f14-7a93-48ca-9e6d-b0757b5c6935", com.pulse.mo.UserSession.class);
			uuidMap.put("9f852c46-29a0-499a-8a74-10ad249ddd06", com.pulse.mo.WeeklyDevelopmentActivity.class);
			uuidMap.put("7890c9c3-c835-4e26-9c86-24ce8825ea1f", com.pulse.mo.WeeklyDevelopmentPlan.class);
			uuidMap.put("b0297cee-b5af-4917-b318-7321a976a503", com.pulse.mo.CoachingNotification.class);
			uuidMap.put("426ab2be-33f3-4ec3-8826-ec3c283de198", com.pulse.mo.ShiftStatusNotification.class);

		}
		return uuidMap;
	}

}