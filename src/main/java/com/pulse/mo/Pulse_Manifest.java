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
classList.add(com.pulse.mo.WeeklyDevelopmentPlan.class);
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
objectList.add(new com.pulse.mo.WeeklyDevelopmentPlan());
objectList.add(new com.pulse.mo.ShiftStatusNotification());

		}
		return objectList;
	}

	private Map<String, Class> uuidMap = null;
	public Map<String, Class> getUuidMap() {
		if (uuidMap == null) {
			uuidMap = new HashMap<String, Class>();
			uuidMap.put("7b385cdf-1d8a-48f1-830b-cd7332791a22", com.pulse.mo.Client.class);
uuidMap.put("d929be3b-f9b6-4060-96fd-3239b088a047", com.pulse.mo.TimecardActivity.class);
uuidMap.put("cfc98d51-3e28-4d89-9f10-d2fd26f32872", com.pulse.mo.AdhocCoachingCategory.class);
uuidMap.put("491c52d3-e5ba-4a9e-8cef-fd18b0a0f300", com.pulse.mo.AdhocTaskState.class);
uuidMap.put("b57eefa5-3c09-48b0-95d7-1ccc200d2d26", com.pulse.mo.Notification.class);
uuidMap.put("a027b96f-6d50-49b0-aa1e-c522f910df3e", com.pulse.mo.CoachingNotification.class);
uuidMap.put("9838691b-2e12-4075-81a5-557f784499e3", com.pulse.mo.CoachingSessionState.class);
uuidMap.put("7299195b-75be-47d1-9c98-bf2ce63ac7ec", com.pulse.mo.Comment.class);
uuidMap.put("347636b6-5adc-4e6c-9a2d-efb3fde08841", com.pulse.mo.CorrectiveActionState.class);
uuidMap.put("4a78a7ab-1067-4283-bb0a-07bbea519592", com.pulse.mo.CorrectiveActionType.class);
uuidMap.put("36ae3766-c60a-4540-81bd-109fc2cb93ab", com.pulse.mo.Agent.class);
uuidMap.put("fcf9f43d-c1b7-4712-8382-1dbae878b823", com.pulse.mo.LOB.class);
uuidMap.put("d1e48c38-a65f-4026-afa6-a70245864f0b", com.pulse.mo.LOBConfiguration.class);
uuidMap.put("655a0c65-5af3-49be-9ed7-89131ef9ea6a", com.pulse.mo.LOBConfigurationNotification.class);
uuidMap.put("08fab8e1-e914-4272-a39e-f3e74b935115", com.pulse.mo.DiscrepancyDetectedNotification.class);
uuidMap.put("dcbdcb2e-e87f-477a-95c6-7e1c0743fa7e", com.pulse.mo.DurationMismatchNotification.class);
uuidMap.put("602a730e-0f26-42c2-94a2-b3b4bec2ee61", com.pulse.mo.ThresholdExceededNotification.class);
uuidMap.put("de1a70aa-944b-4cc2-8f61-020a69a802b9", com.pulse.mo.DurationToleranceNotification.class);
uuidMap.put("5e052eee-21fd-4fae-9aa3-7e6f7a4ecc0d", com.pulse.mo.Employee.class);
uuidMap.put("c3ade5c5-278e-46cb-8318-c99c0001d231", com.pulse.mo.InvalidActivityCodeNotification.class);
uuidMap.put("62fe4d61-e2c5-4c04-9762-f63393bf87bc", com.pulse.mo.Measure.class);
uuidMap.put("4b0e7456-47d0-4e18-89b1-82a08f021b04", com.pulse.mo.NonBillableActivityNotification.class);
uuidMap.put("82e642e4-1124-4568-8b76-c6da87958e6c", com.pulse.mo.Alert.class);
uuidMap.put("ab1b0c77-6d90-4a9c-bfb8-18658bc1d296", com.pulse.mo.NotificationAlert.class);
uuidMap.put("03673bac-d471-462c-a0d2-60b98518c33a", com.pulse.mo.NotificationFrequency.class);
uuidMap.put("8861638d-3d04-4691-a4aa-a07776668632", com.pulse.mo.OccurrenceMismatchNotification.class);
uuidMap.put("f6708377-4654-4882-a418-37407672bef2", com.pulse.mo.OccurrenceToleranceNotification.class);
uuidMap.put("81ecdca2-1655-4333-bf76-ba0b9f8044c3", com.pulse.mo.PulseConfiguration.class);
uuidMap.put("79c55807-d03e-4848-8cfa-1e79c2e31985", com.pulse.mo.Role.class);
uuidMap.put("f7e1b795-8e94-4666-ad83-3cb8d082b076", com.pulse.mo.Scorecard.class);
uuidMap.put("4dca8f3a-efa8-4061-973b-287cf11ceef2", com.pulse.mo.Site.class);
uuidMap.put("bce65a14-d76f-4aef-8240-14e9764f316a", com.pulse.mo.TraceLog.class);
uuidMap.put("9cdbec56-cbe6-4fa4-9df6-8c9415382aa8", com.pulse.mo.WorkDurationNotification.class);
uuidMap.put("8e4b80bd-6f3a-40c0-bf12-2441d7294f98", com.pulse.mo.WorkModeOccurrenceNotification.class);
uuidMap.put("38baa37b-bd32-415e-9a1a-df77f27cbc9f", com.pulse.mo.ClientSite.class);
uuidMap.put("eedb1b37-2027-47df-af81-1eec5c33477e", com.pulse.mo.CMSEntry.class);
uuidMap.put("586f76b3-9304-47bf-b7d5-65647eea51dd", com.pulse.mo.CMSEntryLOB.class);
uuidMap.put("e898b179-c951-4f02-844a-fa1a55d1d4ef", com.pulse.mo.Schedule.class);
uuidMap.put("4f44fcfe-cd96-489d-a619-12914a4e19a2", com.pulse.mo.ScheduleEntry.class);
uuidMap.put("5b35da83-1a8a-4d9c-b4ec-015ac97ae56e", com.pulse.mo.Timecard.class);
uuidMap.put("ac8e9be7-d64e-4d70-901f-b6a11d620afd", com.pulse.mo.TimecardEntry.class);
uuidMap.put("8e24b111-311e-4726-881a-ec0e632e081f", com.pulse.mo.AdhocCoachingSession.class);
uuidMap.put("d05aa178-725b-45fb-ba36-e6223ae19065", com.pulse.mo.AdhocCoachingSessionAttachment.class);
uuidMap.put("d0060fd3-5606-48cc-b445-43b0859e5a0a", com.pulse.mo.AdhocTask.class);
uuidMap.put("258967f4-64d2-474c-a5f4-cd5b1c5f74a3", com.pulse.mo.ScorecardWeeklyScore.class);
uuidMap.put("d9797d9b-0c23-4573-8e41-3d612b1bbe7f", com.pulse.mo.AgentScorecard.class);
uuidMap.put("db07cc26-55e9-4ba7-be8e-795052198ce9", com.pulse.mo.Behavior.class);
uuidMap.put("22387104-4845-4842-b40c-3d2c1d51a276", com.pulse.mo.BehaviorResponse.class);
uuidMap.put("5f381ce1-3589-49b5-bd7e-6b4977c57479", com.pulse.mo.CoachingSession.class);
uuidMap.put("6f4d0315-f3ea-4fc5-a935-66cdcbcb3325", com.pulse.mo.CoachingSessionAttachment.class);
uuidMap.put("59e0e7c5-9118-482d-a7db-af11c7210803", com.pulse.mo.CorrectiveAction.class);
uuidMap.put("4c5a9158-9886-43e8-a06d-ea95ff6287b9", com.pulse.mo.CorrectiveActionAttachment.class);
uuidMap.put("5dda540b-adcb-4d75-a68e-fb9838355532", com.pulse.mo.DevelopmentActivity.class);
uuidMap.put("fe3dc92e-a4f3-4149-bb1b-2518a299092e", com.pulse.mo.DevelopmentPlan.class);
uuidMap.put("b42e3a6d-e92e-4b05-ae40-3cb9fcb19ce6", com.pulse.mo.Email.class);
uuidMap.put("2621ee0d-1b63-487a-ba76-31dfd9eabd24", com.pulse.mo.Goal.class);
uuidMap.put("b253c4de-7830-451a-bf8c-77a718f51498", com.pulse.mo.GradeScale.class);
uuidMap.put("c3b44ef9-576a-4b49-9dab-becf3c45acf8", com.pulse.mo.LOBConfigurationEntry.class);
uuidMap.put("1123d741-8ec6-410e-9d22-373c742becab", com.pulse.mo.TeamLeader.class);
uuidMap.put("5d6a6973-eb54-43d5-ae92-d7fbf58c7151", com.pulse.mo.PulseUser.class);
uuidMap.put("d4b959cd-9f46-41e8-8aae-02defa5b3d55", com.pulse.mo.QualityEvaluation.class);
uuidMap.put("56ed9a20-0677-4f67-bb4d-8118b99938b8", com.pulse.mo.ScorecardMeasure.class);
uuidMap.put("6dfae709-cc24-4034-86ef-2c2e14ff77b5", com.pulse.mo.ScorecardMonthlyResult.class);
uuidMap.put("94c532f6-720c-4bae-943b-ee18a6c97805", com.pulse.mo.ScorecardMonthlyScore.class);
uuidMap.put("bab4d6db-0a8d-4ef7-9ac8-57a2ef18c953", com.pulse.mo.ScorecardWeeklyResult.class);
uuidMap.put("99c0b5f8-e69b-4c6e-84fe-c1dcd1c2c3b7", com.pulse.mo.Setting.class);
uuidMap.put("de7e3957-0e75-4a1f-8b5e-d8362cc9c02e", com.pulse.mo.Supervisor.class);
uuidMap.put("8f8caf7f-a81c-4ca0-8dd8-eb439eab116d", com.pulse.mo.TeamLeaderImpersonation.class);
uuidMap.put("82d28950-3898-4b14-909e-36f251fa336d", com.pulse.mo.TraceEntry.class);
uuidMap.put("601a5eff-4284-4820-915b-392d2fa15161", com.pulse.mo.UserRole.class);
uuidMap.put("f76d379d-dad5-4ea5-9713-9dde88ab5e08", com.pulse.mo.UserSession.class);
uuidMap.put("207ed39b-b0a3-400c-9f86-f7723c6fc7a2", com.pulse.mo.WeeklyDevelopmentPlan.class);
uuidMap.put("a37578c4-2486-49e6-af62-30b7a4d31b39", com.pulse.mo.ShiftStatusNotification.class);

		}
		return uuidMap;
	}

}