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
classList.add(com.pulse.mo.ScorecardWeeklyScore.class);
classList.add(com.pulse.mo.Setting.class);
classList.add(com.pulse.mo.Supervisor.class);
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
objectList.add(new com.pulse.mo.ScorecardWeeklyScore());
objectList.add(new com.pulse.mo.Setting());
objectList.add(new com.pulse.mo.Supervisor());
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
			uuidMap.put("b8d1c2e6-ed3e-4c55-a3de-a78faa84e5d9", com.pulse.mo.Client.class);
uuidMap.put("9be1d073-c9bd-43b6-8517-af1c2f08d92d", com.pulse.mo.TimecardActivity.class);
uuidMap.put("d6ace31c-0263-4b56-bafc-b3b073cb0194", com.pulse.mo.AdhocCoachingCategory.class);
uuidMap.put("e668d6ad-2a31-423c-9cfe-89e2f51c8a4d", com.pulse.mo.AdhocTaskState.class);
uuidMap.put("81f913b4-e9e6-4747-9305-4cc9186d0809", com.pulse.mo.Notification.class);
uuidMap.put("6bb040f5-b7e0-4c82-b53b-7862c22d45ad", com.pulse.mo.CoachingNotification.class);
uuidMap.put("ab972a6c-d9b0-4e7b-bea4-8005e3d6ec45", com.pulse.mo.CoachingSessionState.class);
uuidMap.put("e06e8250-1cbd-46cb-90be-7de639da358b", com.pulse.mo.Comment.class);
uuidMap.put("643483aa-9588-4813-bec8-2892c70d976b", com.pulse.mo.CorrectiveActionState.class);
uuidMap.put("38722fbd-02a4-49f1-a612-6080622689c0", com.pulse.mo.CorrectiveActionType.class);
uuidMap.put("493234e4-813f-4121-9ecb-1aa6b0f432d3", com.pulse.mo.Agent.class);
uuidMap.put("48c884af-50d5-40b0-96c0-938f328439e2", com.pulse.mo.LOB.class);
uuidMap.put("b5bc2820-dfad-4255-ae67-7747c448e97a", com.pulse.mo.LOBConfiguration.class);
uuidMap.put("f0166e87-37f8-4606-b015-cafaea3da3e8", com.pulse.mo.LOBConfigurationNotification.class);
uuidMap.put("64c7401b-0c3b-4156-b908-d6c7cef8afe9", com.pulse.mo.DiscrepancyDetectedNotification.class);
uuidMap.put("03dd2a40-df28-4dbd-87f9-08242c1a7918", com.pulse.mo.DurationMismatchNotification.class);
uuidMap.put("f1478adc-1c15-4e91-a794-6e8972e551a2", com.pulse.mo.ThresholdExceededNotification.class);
uuidMap.put("d304d7f5-d983-49e2-b104-a93606a26c35", com.pulse.mo.DurationToleranceNotification.class);
uuidMap.put("6cb071c7-7dd1-4236-967f-7fbb6e0cfaee", com.pulse.mo.Employee.class);
uuidMap.put("e899efa2-0c59-4200-9496-5c08926acffc", com.pulse.mo.InvalidActivityCodeNotification.class);
uuidMap.put("d0941028-67f7-4d49-8d5f-d95f4b7dcedf", com.pulse.mo.Measure.class);
uuidMap.put("7f51328f-fef8-4ba6-a338-bc75d54f4849", com.pulse.mo.NonBillableActivityNotification.class);
uuidMap.put("95a39444-3f9f-4f76-b12e-284cd936676c", com.pulse.mo.Alert.class);
uuidMap.put("fa0ffd8c-2525-49a9-8832-3de4d85d4799", com.pulse.mo.NotificationAlert.class);
uuidMap.put("7d078886-7457-48ae-be28-48014a90530e", com.pulse.mo.NotificationFrequency.class);
uuidMap.put("14df4025-0b31-452b-bffe-2b8b00dd3003", com.pulse.mo.OccurrenceMismatchNotification.class);
uuidMap.put("cbaf5477-d3aa-47d6-9dff-ff5169a98649", com.pulse.mo.OccurrenceToleranceNotification.class);
uuidMap.put("1b7e48b7-5a0f-47b7-9093-0727423704a5", com.pulse.mo.PulseConfiguration.class);
uuidMap.put("c5440e31-41ca-4368-8f51-bc3713b39195", com.pulse.mo.Role.class);
uuidMap.put("7dcd1b5b-301e-43f8-a819-8876e99fd997", com.pulse.mo.Scorecard.class);
uuidMap.put("54853446-866d-417a-aeda-407271921539", com.pulse.mo.Site.class);
uuidMap.put("3ce7e13c-ce28-4a38-9a3b-71503818c44e", com.pulse.mo.TraceLog.class);
uuidMap.put("4dec1a1e-887e-4502-9149-401dfe4f5297", com.pulse.mo.WorkDurationNotification.class);
uuidMap.put("1de19161-b287-428d-94b9-8ce51958fab8", com.pulse.mo.WorkModeOccurrenceNotification.class);
uuidMap.put("e36454d9-df4e-4d58-8143-eaa00c40d883", com.pulse.mo.ClientSite.class);
uuidMap.put("da4e2e66-5a97-41c0-aa05-84bccd0a03b3", com.pulse.mo.CMSEntry.class);
uuidMap.put("e1f9cd71-b099-4019-bedc-0731c19d0a56", com.pulse.mo.CMSEntryLOB.class);
uuidMap.put("65e1dbd2-7748-412c-8246-7da6652a9c96", com.pulse.mo.Schedule.class);
uuidMap.put("80ba9d1d-664d-4ebb-960f-503040bcabc5", com.pulse.mo.ScheduleEntry.class);
uuidMap.put("ef6973da-d183-4f9e-9efe-28c777aaa420", com.pulse.mo.Timecard.class);
uuidMap.put("c30d7af6-d2a8-4e26-81ee-2f26e2ef901d", com.pulse.mo.TimecardEntry.class);
uuidMap.put("1fcab33d-0754-488e-a1ea-c74c8561cb77", com.pulse.mo.AdhocCoachingSession.class);
uuidMap.put("5e01cc2c-b745-4daa-8405-ec90a96868a9", com.pulse.mo.AdhocCoachingSessionAttachment.class);
uuidMap.put("f31d4c3d-ccda-454c-b150-426b32835a76", com.pulse.mo.AdhocTask.class);
uuidMap.put("3356ebc6-2589-42ea-958c-19dadb2e1283", com.pulse.mo.AgentScorecard.class);
uuidMap.put("f7b45e5e-b06c-4566-9053-eb063a15e6a9", com.pulse.mo.Behavior.class);
uuidMap.put("1f8bb8e2-a8b0-4552-8c0e-71f45983156b", com.pulse.mo.BehaviorResponse.class);
uuidMap.put("82daf415-380b-4228-8c51-a88cdda78c4a", com.pulse.mo.CoachingSession.class);
uuidMap.put("360d8de7-3798-45da-9928-182f1d6d9fdb", com.pulse.mo.CoachingSessionAttachment.class);
uuidMap.put("17efb125-4ee7-48cc-b505-e8591c8a68c0", com.pulse.mo.CorrectiveAction.class);
uuidMap.put("21c80287-79d0-4e32-a9bc-416562c4c85c", com.pulse.mo.CorrectiveActionAttachment.class);
uuidMap.put("512b866f-c994-478e-aea8-c6f902301377", com.pulse.mo.DevelopmentActivity.class);
uuidMap.put("a9e6f143-a952-4042-9c68-ce6492d0ba9e", com.pulse.mo.DevelopmentPlan.class);
uuidMap.put("7b94cbdf-791a-4c12-a738-9b135c589df6", com.pulse.mo.Email.class);
uuidMap.put("bac94acc-cb7a-4b41-b98f-a2030b43a3d7", com.pulse.mo.Goal.class);
uuidMap.put("570360c7-35d2-4433-be7c-023f31d1a5f3", com.pulse.mo.GradeScale.class);
uuidMap.put("e26615da-1eab-4cbf-a5ff-d78b6ecf1fb9", com.pulse.mo.LOBConfigurationEntry.class);
uuidMap.put("bf9ed6b0-ef0e-4b3d-b5b8-e13ca4268c82", com.pulse.mo.TeamLeader.class);
uuidMap.put("15c5b41f-0480-4448-8344-ee2ca7165e42", com.pulse.mo.PulseUser.class);
uuidMap.put("457117bb-75c3-4884-917c-5615f73f64bf", com.pulse.mo.QualityEvaluation.class);
uuidMap.put("515b00c3-55a5-4bde-a544-0b5612996969", com.pulse.mo.ScorecardMeasure.class);
uuidMap.put("774e6ed8-76af-4bb7-873e-f7c42edb436e", com.pulse.mo.ScorecardMonthlyResult.class);
uuidMap.put("022cc4a7-8efb-4e3b-88d5-75f079ff4223", com.pulse.mo.ScorecardMonthlyScore.class);
uuidMap.put("70d60028-2ac5-4260-b56e-67410a654250", com.pulse.mo.ScorecardWeeklyResult.class);
uuidMap.put("cf727266-32fd-4cc7-b66e-37ed7f6b97c2", com.pulse.mo.ScorecardWeeklyScore.class);
uuidMap.put("ea26ccef-a2de-467e-97d1-76f451c5f9c6", com.pulse.mo.Setting.class);
uuidMap.put("852e7bb0-1e92-4fa2-855b-ef97834319ee", com.pulse.mo.Supervisor.class);
uuidMap.put("c067c5bc-1d3e-45b0-a3b3-c72b012818ac", com.pulse.mo.TeamLeaderImpersonation.class);
uuidMap.put("2922ad92-12ac-4900-b941-dfd5a37c3d16", com.pulse.mo.TraceEntry.class);
uuidMap.put("6bee3d97-6f56-497c-8daa-8f9cf3031b2d", com.pulse.mo.UserRole.class);
uuidMap.put("6cf5919b-c4ac-4db4-9087-1be7acb5a04f", com.pulse.mo.UserSession.class);
uuidMap.put("7193d025-f73c-4f2b-89d7-eb1f920a81e9", com.pulse.mo.ShiftStatusNotification.class);

		}
		return uuidMap;
	}

}