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
			uuidMap.put("1fa683fd-5efa-4ba7-b273-9077cdafa211", com.pulse.mo.Client.class);
uuidMap.put("4dbeb778-d994-49f3-9b5c-9749634777cc", com.pulse.mo.TimecardActivity.class);
uuidMap.put("1b501ab6-0f8a-4b1e-a72b-300b095448c5", com.pulse.mo.AdhocCoachingCategory.class);
uuidMap.put("50bd1f9e-cc97-4003-aea7-8a56c0338b0d", com.pulse.mo.AdhocTaskState.class);
uuidMap.put("1649ec5f-cd92-47b5-94f1-567c8d366010", com.pulse.mo.Notification.class);
uuidMap.put("a39926c4-0a07-4c25-a40a-93ed396206be", com.pulse.mo.CoachingNotification.class);
uuidMap.put("bddb5da7-4f2f-434b-877a-daee0bb87bd5", com.pulse.mo.CoachingSessionState.class);
uuidMap.put("244605a0-91a1-4838-a66d-4bddc50dbaf1", com.pulse.mo.Comment.class);
uuidMap.put("e05db3d7-8c28-47e2-93ce-f57351a9396a", com.pulse.mo.CorrectiveActionState.class);
uuidMap.put("6a1a4b44-7948-4954-893a-e4abd983b908", com.pulse.mo.CorrectiveActionType.class);
uuidMap.put("40f0e7d0-a221-4eb1-b51a-5c8c27c29c9b", com.pulse.mo.Agent.class);
uuidMap.put("02353fe8-1753-45cb-8183-73b01e3fe032", com.pulse.mo.LOB.class);
uuidMap.put("912b5127-8a41-4dfc-8640-54e266fdf1b8", com.pulse.mo.LOBConfiguration.class);
uuidMap.put("b43db336-2c31-41d4-b461-147d69927402", com.pulse.mo.LOBConfigurationNotification.class);
uuidMap.put("09bd42fe-2ec5-452f-97ad-0d420e37e95f", com.pulse.mo.DiscrepancyDetectedNotification.class);
uuidMap.put("f0d59ed3-fcb8-4507-b2e7-fecdefa4a0ed", com.pulse.mo.DurationMismatchNotification.class);
uuidMap.put("a0eab5c9-d5e3-409b-a027-d0a7bf9fea7e", com.pulse.mo.ThresholdExceededNotification.class);
uuidMap.put("06b533f8-5900-47e6-b4eb-9a3368b67089", com.pulse.mo.DurationToleranceNotification.class);
uuidMap.put("b36b778e-1655-44ca-a656-9d1df65a0115", com.pulse.mo.Employee.class);
uuidMap.put("af269f27-08c6-4040-8b0a-704fcf700c71", com.pulse.mo.InvalidActivityCodeNotification.class);
uuidMap.put("da4f31dc-5752-4298-b6c2-15b0c5bc0c06", com.pulse.mo.Measure.class);
uuidMap.put("e20de746-4c1e-4814-8226-6d8400b08b4c", com.pulse.mo.NonBillableActivityNotification.class);
uuidMap.put("11e9f769-4f77-4b75-b5e9-dfedf1c96bd4", com.pulse.mo.Alert.class);
uuidMap.put("bfa5bca2-983e-450e-92e4-a7fd65564035", com.pulse.mo.NotificationAlert.class);
uuidMap.put("aee56d16-6f7c-43d4-bc3e-a0d06a26f305", com.pulse.mo.NotificationFrequency.class);
uuidMap.put("f6fa8e29-3d78-4ef2-9997-a25e345ce35b", com.pulse.mo.OccurrenceMismatchNotification.class);
uuidMap.put("b0d486bd-09bd-4b94-854c-f2b8f385e3d2", com.pulse.mo.OccurrenceToleranceNotification.class);
uuidMap.put("e27567ce-8ba9-4546-85d7-8e891aa5a97d", com.pulse.mo.PulseConfiguration.class);
uuidMap.put("7898b5fe-9342-4f01-84ed-c613ef33f0a2", com.pulse.mo.Role.class);
uuidMap.put("93c5e00e-d5e0-4652-8a2d-3a9f6602b42f", com.pulse.mo.Scorecard.class);
uuidMap.put("0e9b88f5-025a-4cef-a7e2-83625edebaea", com.pulse.mo.Site.class);
uuidMap.put("605eeaf0-f3c7-46de-9d83-8a305fd6e497", com.pulse.mo.TraceLog.class);
uuidMap.put("80c091ec-a6fc-4f52-b49d-140a3a99a089", com.pulse.mo.WorkDurationNotification.class);
uuidMap.put("8c472437-059f-4cbe-abf6-5c9eef8b9148", com.pulse.mo.WorkModeOccurrenceNotification.class);
uuidMap.put("09c0b872-d108-4ac2-a927-940c7cdab2fa", com.pulse.mo.ClientSite.class);
uuidMap.put("59d6fc8e-bff1-4f1a-98f1-aa948f51e033", com.pulse.mo.CMSEntry.class);
uuidMap.put("6d867190-3ed1-4e77-9063-15ee31012c39", com.pulse.mo.CMSEntryLOB.class);
uuidMap.put("4a53548f-f5bc-480a-a92d-df30512dbfaa", com.pulse.mo.Schedule.class);
uuidMap.put("30735f22-2969-47fe-8e65-dc5fbfbd9ebb", com.pulse.mo.ScheduleEntry.class);
uuidMap.put("37af7ad5-9ed9-43ac-b134-4935cd2a49ac", com.pulse.mo.Timecard.class);
uuidMap.put("c7f2277d-553d-480b-902b-3b7bfaeca1be", com.pulse.mo.TimecardEntry.class);
uuidMap.put("b974209c-e921-4806-afff-8e4af972ec6b", com.pulse.mo.AdhocCoachingSession.class);
uuidMap.put("5079e19d-7596-4e50-9293-294ce4bc4489", com.pulse.mo.AdhocCoachingSessionAttachment.class);
uuidMap.put("0f0cb990-6ad8-4d0f-9fa8-48d0472930be", com.pulse.mo.AdhocTask.class);
uuidMap.put("af00e351-9b47-423b-9806-6644d669ee47", com.pulse.mo.AgentScorecard.class);
uuidMap.put("f3956293-dc66-47db-bd18-7342a8e92306", com.pulse.mo.Behavior.class);
uuidMap.put("ef4b2260-ca69-40db-a210-269c2d16fbac", com.pulse.mo.BehaviorResponse.class);
uuidMap.put("22e31700-8bc8-4d2d-b88a-793ab83af2b4", com.pulse.mo.CoachingSession.class);
uuidMap.put("e8541c0f-1fec-492d-996b-365e2b55543f", com.pulse.mo.CoachingSessionAttachment.class);
uuidMap.put("93beaf0a-66bf-43a1-afe0-4278d678500a", com.pulse.mo.Supervisor.class);
uuidMap.put("2d6b531a-0834-412b-a5ee-c82caec157aa", com.pulse.mo.CorrectiveAction.class);
uuidMap.put("276ff839-ce95-47e9-83f7-4587a01e1896", com.pulse.mo.CorrectiveActionAttachment.class);
uuidMap.put("860f90f2-de55-4b8b-896b-b3c836418664", com.pulse.mo.DevelopmentActivity.class);
uuidMap.put("dca888db-ba18-4fed-9970-e1662cfbcdc8", com.pulse.mo.DevelopmentPlan.class);
uuidMap.put("b94ff2ec-7018-4278-b3c5-d72eaac22a8a", com.pulse.mo.Email.class);
uuidMap.put("9dee8b15-aa70-4481-be1f-7d0641021c41", com.pulse.mo.Goal.class);
uuidMap.put("cd879ebe-8e22-464a-8dc6-8234972b5776", com.pulse.mo.GradeScale.class);
uuidMap.put("9dccca46-c671-4bfd-bbc1-ff7ad404a8f0", com.pulse.mo.LOBConfigurationEntry.class);
uuidMap.put("f17ed974-f0a2-4eaa-9701-55bdb00bc0f9", com.pulse.mo.TeamLeader.class);
uuidMap.put("d4e6ce61-1da2-430e-a978-aa2f8374238f", com.pulse.mo.PulseUser.class);
uuidMap.put("e430ed81-771e-48f5-8e76-8d3b2b2f8a8f", com.pulse.mo.QualityEvaluation.class);
uuidMap.put("7a70a5d5-8bba-4977-84d1-053a300730cc", com.pulse.mo.ScorecardMeasure.class);
uuidMap.put("3bb780e1-5000-46bf-8cc0-b2caa35d4565", com.pulse.mo.ScorecardMonthlyResult.class);
uuidMap.put("51f7681f-4490-4646-8281-3d301663850f", com.pulse.mo.ScorecardWeeklyResult.class);
uuidMap.put("41ff0057-0c2b-4870-a0a0-252de6df443b", com.pulse.mo.Setting.class);
uuidMap.put("b075ce1a-d3e5-480d-8d91-fcd9422307b1", com.pulse.mo.TeamLeaderImpersonation.class);
uuidMap.put("a3cf3fb7-f4d1-4e66-a798-7d5b83b7cd97", com.pulse.mo.TraceEntry.class);
uuidMap.put("06123216-0d44-4af3-8114-a47f3883d975", com.pulse.mo.UserRole.class);
uuidMap.put("0ac45797-a12f-41eb-949b-fa6890f53cad", com.pulse.mo.UserSession.class);
uuidMap.put("c01e67cf-07a1-462a-a318-1d3650330e63", com.pulse.mo.ShiftStatusNotification.class);

		}
		return uuidMap;
	}

}