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
classList.add(com.pulse.mo.Comment.class);
classList.add(com.pulse.mo.CorrectiveActionState.class);
classList.add(com.pulse.mo.CorrectiveActionType.class);
classList.add(com.pulse.mo.Notification.class);
classList.add(com.pulse.mo.LOB.class);
classList.add(com.pulse.mo.LOBConfiguration.class);
classList.add(com.pulse.mo.Agent.class);
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
objectList.add(new com.pulse.mo.Comment());
objectList.add(new com.pulse.mo.CorrectiveActionState());
objectList.add(new com.pulse.mo.CorrectiveActionType());
objectList.add(new com.pulse.mo.Notification());
objectList.add(new com.pulse.mo.LOB());
objectList.add(new com.pulse.mo.LOBConfiguration());
objectList.add(new com.pulse.mo.Agent());
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
			uuidMap.put("d26ad66a-d01c-4b0d-af20-39b2505c3640", com.pulse.mo.Client.class);
uuidMap.put("c578d956-50a2-4a36-8e03-d768ef4770f7", com.pulse.mo.TimecardActivity.class);
uuidMap.put("5d816879-0ac9-431e-90fa-52aa030736ca", com.pulse.mo.AdhocCoachingCategory.class);
uuidMap.put("54ad6efb-8b11-4689-8eaa-969ace363715", com.pulse.mo.AdhocTaskState.class);
uuidMap.put("5a753f2a-950b-462b-97a0-0a24630bcde1", com.pulse.mo.CoachingSessionState.class);
uuidMap.put("66cd13e5-546e-4fc5-94e9-8465c0cea4ad", com.pulse.mo.Comment.class);
uuidMap.put("f70c8b1b-dc54-46b4-a24b-15c991150c98", com.pulse.mo.CorrectiveActionState.class);
uuidMap.put("ecd05123-220e-47dc-aa7c-6c868aa8509d", com.pulse.mo.CorrectiveActionType.class);
uuidMap.put("7dfbd55d-b39f-4445-ac25-26aeb244991e", com.pulse.mo.Notification.class);
uuidMap.put("ff7762d8-4611-4caa-9645-87e94e966ae5", com.pulse.mo.LOB.class);
uuidMap.put("90fab310-ad49-45e8-a9d7-32143084c5ed", com.pulse.mo.LOBConfiguration.class);
uuidMap.put("317610ce-d096-4a0e-bb86-9487e8b9bdf5", com.pulse.mo.Agent.class);
uuidMap.put("b6d395b8-c697-424f-928f-244346e0c87a", com.pulse.mo.LOBConfigurationNotification.class);
uuidMap.put("4c31a4b6-b9c2-476c-9662-6cb90ea1ae46", com.pulse.mo.DiscrepancyDetectedNotification.class);
uuidMap.put("34e36a8c-bf37-455b-ae74-332db49f0929", com.pulse.mo.DurationMismatchNotification.class);
uuidMap.put("e8a6a5d7-44d6-4ca0-abfa-9d06c66a7e85", com.pulse.mo.ThresholdExceededNotification.class);
uuidMap.put("a0a3946f-55f7-46fa-9b73-2cdc66277a00", com.pulse.mo.DurationToleranceNotification.class);
uuidMap.put("fdce4683-ac00-4ba6-ab5f-59026b114044", com.pulse.mo.Employee.class);
uuidMap.put("166c2119-e904-43e5-8098-bfc72b67c298", com.pulse.mo.InvalidActivityCodeNotification.class);
uuidMap.put("58cafb75-5ccd-441f-9366-271ce4c6e734", com.pulse.mo.Measure.class);
uuidMap.put("556bcfe1-a0ac-46fe-911b-d18d54ec0cc5", com.pulse.mo.NonBillableActivityNotification.class);
uuidMap.put("a68dc374-9edc-4604-8114-67c3700715f8", com.pulse.mo.Alert.class);
uuidMap.put("5103f6b3-abc0-454a-81de-6116c89958db", com.pulse.mo.NotificationAlert.class);
uuidMap.put("37e8c7f3-f880-455c-94d1-8b3d1b72e3b3", com.pulse.mo.NotificationFrequency.class);
uuidMap.put("ea1c5714-2f12-4001-8360-c5cdef651673", com.pulse.mo.OccurrenceMismatchNotification.class);
uuidMap.put("9da82a5c-7c98-4a45-965c-222bc1b3b49d", com.pulse.mo.OccurrenceToleranceNotification.class);
uuidMap.put("6a3f2cbe-2471-43e1-be1b-ba96b35d85ad", com.pulse.mo.PulseConfiguration.class);
uuidMap.put("78d9002f-2999-42ca-b4b7-037ece637b6e", com.pulse.mo.Role.class);
uuidMap.put("ddd8e5f1-17f8-4d39-84b7-3df0b3375031", com.pulse.mo.Scorecard.class);
uuidMap.put("c397aa0e-b50d-428c-9095-75051fef3e40", com.pulse.mo.Site.class);
uuidMap.put("a2293ab8-d72b-4f29-8153-ebb1f6e5e09e", com.pulse.mo.TraceLog.class);
uuidMap.put("620103e1-0082-4157-ace8-a77174fc1bfa", com.pulse.mo.WorkDurationNotification.class);
uuidMap.put("66325c21-2c06-4e1b-995b-fd06c8d79131", com.pulse.mo.WorkModeOccurrenceNotification.class);
uuidMap.put("57eb8d1d-0792-4dc5-bf27-1be50cc51d59", com.pulse.mo.AgentTimeZone.class);
uuidMap.put("e403d97d-98e7-4114-bbd8-a89bea96c9bd", com.pulse.mo.ClientSite.class);
uuidMap.put("29d17f5d-da3b-4db5-9a69-3f74d76ebe74", com.pulse.mo.CMSEntry.class);
uuidMap.put("5da3e9f0-95ff-4d81-988c-a56faefade61", com.pulse.mo.CMSEntryLOB.class);
uuidMap.put("6a56a18e-8e2f-461c-8440-aae1b65e1fd4", com.pulse.mo.Schedule.class);
uuidMap.put("0aa2d953-d3a0-4cf6-b085-cfa3401148d2", com.pulse.mo.ScheduleEntry.class);
uuidMap.put("0c0a0069-962e-401c-9aef-0c8ad92a4670", com.pulse.mo.Timecard.class);
uuidMap.put("c14d71fe-3bbf-44b9-9d8c-3632cc29af66", com.pulse.mo.TimecardEntry.class);
uuidMap.put("b899febd-19f5-4fea-8e34-ab868665e26a", com.pulse.mo.AdhocCoachingSession.class);
uuidMap.put("1e991181-f585-4be5-bf7f-a1592d2f6a58", com.pulse.mo.AdhocCoachingSessionAttachment.class);
uuidMap.put("7bd0ab95-71dc-4e20-aac8-bef9cba1f9d9", com.pulse.mo.AdhocTask.class);
uuidMap.put("c9bb65da-c166-442f-b4de-1b1751ad4d82", com.pulse.mo.ScorecardWeeklyScore.class);
uuidMap.put("3443d83b-2c05-46a7-8b0d-33dc01339df4", com.pulse.mo.AgentScorecard.class);
uuidMap.put("23f73638-cdd8-4eb5-a17d-645de93719a8", com.pulse.mo.Behavior.class);
uuidMap.put("56fa5d5f-6f00-4c9a-9e5c-357558e293b5", com.pulse.mo.BehaviorResponse.class);
uuidMap.put("876b9c90-641b-4556-914b-309dd99c5ca5", com.pulse.mo.CoachingSession.class);
uuidMap.put("0a42b673-7c98-488e-9b92-cd3ee3b3e308", com.pulse.mo.CoachingSessionAttachment.class);
uuidMap.put("f6bce224-f7ee-47fd-8d8f-876f9c19549d", com.pulse.mo.CorrectiveAction.class);
uuidMap.put("9481a190-ac71-407b-951e-c083a0f607f2", com.pulse.mo.CorrectiveActionAttachment.class);
uuidMap.put("2307f95d-5b1d-44c5-bb3e-da8202441959", com.pulse.mo.DevelopmentActivity.class);
uuidMap.put("5ad85d0b-efc8-4d0a-821d-c2972da4f467", com.pulse.mo.DevelopmentPlan.class);
uuidMap.put("76df5c0f-a5e2-43f8-ada1-3473918bd801", com.pulse.mo.Email.class);
uuidMap.put("d04fc1b0-1749-4b47-9dbf-f48cc59ccd18", com.pulse.mo.Goal.class);
uuidMap.put("99fae31b-d397-465d-a5aa-9d72c416084b", com.pulse.mo.GradeScale.class);
uuidMap.put("3ad482c3-3717-469b-95a9-02a08eec74d8", com.pulse.mo.LOBConfigurationEntry.class);
uuidMap.put("fbf7766a-96b3-47c5-b47b-eb0f936c99b1", com.pulse.mo.TeamLeader.class);
uuidMap.put("d61cfd93-6200-4f47-bd43-51df0e4ecefe", com.pulse.mo.PulseUser.class);
uuidMap.put("9b481965-aa18-4e54-9d73-5ad4bcd8f1ae", com.pulse.mo.QualityEvaluation.class);
uuidMap.put("a8dc2291-ba05-44d3-8f95-e3578115d521", com.pulse.mo.ScorecardMeasure.class);
uuidMap.put("28ad10ac-529a-41d4-a1d1-6a405dd0743e", com.pulse.mo.ScorecardMonthlyResult.class);
uuidMap.put("67882abe-a281-44dc-b50c-009252c3db31", com.pulse.mo.ScorecardMonthlyScore.class);
uuidMap.put("0e83eaa9-9518-425e-8bf6-9cc3979c83be", com.pulse.mo.ScorecardWeeklyResult.class);
uuidMap.put("5ee7b310-b5ba-4559-b16f-3e524729fd75", com.pulse.mo.Setting.class);
uuidMap.put("7e55a5ad-9cb5-4a3e-9fba-9e7ceb0b4e14", com.pulse.mo.Supervisor.class);
uuidMap.put("7dcae30f-e78a-48f4-9bbb-787e6aaeb3a9", com.pulse.mo.TeamLeaderImpersonation.class);
uuidMap.put("8587aeec-7147-4f72-941d-7758c4607e6e", com.pulse.mo.TraceEntry.class);
uuidMap.put("34e683dc-4b19-467e-87c7-82c1bc420f02", com.pulse.mo.UserRole.class);
uuidMap.put("19861b6d-7df4-4039-a7b8-804ef307ec4e", com.pulse.mo.UserSession.class);
uuidMap.put("7edd7978-6b5a-410f-ae46-a4c3ffe6f4f4", com.pulse.mo.WeeklyDevelopmentActivity.class);
uuidMap.put("818abbd0-4ef3-46ed-9d73-5733a9a75e01", com.pulse.mo.WeeklyDevelopmentPlan.class);
uuidMap.put("da04f2e0-a68d-4a86-8658-59b6fe7d2fba", com.pulse.mo.CoachingNotification.class);
uuidMap.put("ebd65590-1bc9-41af-b475-042e35133910", com.pulse.mo.ShiftStatusNotification.class);

		}
		return uuidMap;
	}

}