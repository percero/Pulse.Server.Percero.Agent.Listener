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
			uuidMap.put("8229e618-d3fa-4436-b759-71faed6e1fbd", com.pulse.mo.Client.class);
uuidMap.put("d07ef2b1-c85f-415a-917d-d64935d9e22e", com.pulse.mo.TimecardActivity.class);
uuidMap.put("317d7030-85d7-42f8-be94-f5c7d7155a37", com.pulse.mo.AdhocCoachingCategory.class);
uuidMap.put("5c6ee44a-cf9d-489d-917a-166b2700eccd", com.pulse.mo.AdhocTaskState.class);
uuidMap.put("d854117b-9359-4428-83f3-1223d853d56c", com.pulse.mo.Notification.class);
uuidMap.put("3432beef-fc05-4907-a9f3-949f2da52d5c", com.pulse.mo.CoachingNotification.class);
uuidMap.put("6564058c-8837-428b-b77f-59be89337817", com.pulse.mo.CoachingSessionState.class);
uuidMap.put("56acc7c2-c8a7-427e-a9b2-8e798ee8d664", com.pulse.mo.Comment.class);
uuidMap.put("c2982158-295a-446a-a3fc-0eed16f5336c", com.pulse.mo.CorrectiveActionState.class);
uuidMap.put("5c540bad-d5f7-47df-99c2-8a2b33e13b6b", com.pulse.mo.CorrectiveActionType.class);
uuidMap.put("0a590b70-200f-4952-9060-f4539bcf0819", com.pulse.mo.Agent.class);
uuidMap.put("19d28433-6fc6-424b-9c1b-efc5a900e5b8", com.pulse.mo.LOB.class);
uuidMap.put("dde3bea4-6802-467b-b8ad-106a859dcb7a", com.pulse.mo.LOBConfiguration.class);
uuidMap.put("99b7e592-f6ef-415f-8198-b0a5482ceef2", com.pulse.mo.LOBConfigurationNotification.class);
uuidMap.put("24657096-5978-4afb-8f9d-436586b8fa9e", com.pulse.mo.DiscrepancyDetectedNotification.class);
uuidMap.put("b0a40dc4-97fb-4bfd-bf01-3999f8dc40f6", com.pulse.mo.DurationMismatchNotification.class);
uuidMap.put("4a48193c-f1f8-4e1b-8e94-58ab681045d6", com.pulse.mo.ThresholdExceededNotification.class);
uuidMap.put("b2b550da-4ae2-48fd-a525-92a732721076", com.pulse.mo.DurationToleranceNotification.class);
uuidMap.put("deb705e6-7a5f-44d1-9a68-66a0667d23d3", com.pulse.mo.Employee.class);
uuidMap.put("bad0c23f-f72e-48e8-ac36-ba2dd5be8ccf", com.pulse.mo.InvalidActivityCodeNotification.class);
uuidMap.put("8d1fd805-cb36-4f50-9700-a0b12e39d1ec", com.pulse.mo.Measure.class);
uuidMap.put("77133500-3ea3-4727-82fb-23d6ff0201d7", com.pulse.mo.NonBillableActivityNotification.class);
uuidMap.put("ee587f21-0e6d-45e8-9f6a-448e8f7a2c79", com.pulse.mo.Alert.class);
uuidMap.put("f62b8464-79f8-43bb-96a5-44f0e3311dd4", com.pulse.mo.NotificationAlert.class);
uuidMap.put("8a38fd04-5f13-490b-9b5e-8b8ef6fc0258", com.pulse.mo.NotificationFrequency.class);
uuidMap.put("bd5d34e6-4189-4196-aa2d-02bc3ea59d84", com.pulse.mo.OccurrenceMismatchNotification.class);
uuidMap.put("c86f5320-9ed1-48a8-ac1f-603523bfe5d0", com.pulse.mo.OccurrenceToleranceNotification.class);
uuidMap.put("a603fee9-465b-4b86-a479-b2f3ccf5463d", com.pulse.mo.PulseConfiguration.class);
uuidMap.put("eb3ede76-187c-43c3-bff3-0b400173ca02", com.pulse.mo.Role.class);
uuidMap.put("f0c0ecff-5a9e-42ae-bbdc-e62f82e6e384", com.pulse.mo.Scorecard.class);
uuidMap.put("35028ce6-40b1-4488-a542-eafe405bc7e0", com.pulse.mo.Site.class);
uuidMap.put("ff2f03a9-f321-4bcb-9a06-5e700afc733a", com.pulse.mo.TraceLog.class);
uuidMap.put("9aafb52b-407f-4d38-b357-6748db3b1cf8", com.pulse.mo.WorkDurationNotification.class);
uuidMap.put("a29f4695-ecf9-4ad3-a1fe-0789a55d31d0", com.pulse.mo.WorkModeOccurrenceNotification.class);
uuidMap.put("08d90207-78aa-4d06-b7dc-3cdc80e998a5", com.pulse.mo.ClientSite.class);
uuidMap.put("81a287b9-6e03-4a0c-81ff-335a3b7ecf1c", com.pulse.mo.CMSEntry.class);
uuidMap.put("bf65414c-590b-4738-8fc3-c4ae3fa09a01", com.pulse.mo.CMSEntryLOB.class);
uuidMap.put("04885008-a620-45d8-bf9b-58b394feae1d", com.pulse.mo.Schedule.class);
uuidMap.put("0c70def4-ecb2-4f55-8604-8e318f7fcd85", com.pulse.mo.ScheduleEntry.class);
uuidMap.put("d4ca2134-08bb-42a6-9fd8-60c6940ece88", com.pulse.mo.Timecard.class);
uuidMap.put("5c5dd451-304c-416e-ae16-cac7a604b372", com.pulse.mo.TimecardEntry.class);
uuidMap.put("1f92955e-8e41-4134-bab1-c4db7b6f2ab0", com.pulse.mo.AdhocCoachingSession.class);
uuidMap.put("07a5d3a8-4e8a-49aa-b9ef-1880a61ec15f", com.pulse.mo.AdhocCoachingSessionAttachment.class);
uuidMap.put("61504d3e-2f3c-4852-8533-f24e13c8b9a2", com.pulse.mo.AdhocTask.class);
uuidMap.put("2746fa8d-360a-4515-a9ff-f9e4897e49b8", com.pulse.mo.AgentScorecard.class);
uuidMap.put("142932ab-f77b-4442-8f8b-020fc5a9f30a", com.pulse.mo.Behavior.class);
uuidMap.put("62cd0697-a2f4-497c-a6eb-782faa09181a", com.pulse.mo.BehaviorResponse.class);
uuidMap.put("f9e0821a-e12c-43cb-970c-a2102e83d798", com.pulse.mo.CoachingSession.class);
uuidMap.put("84e21691-2917-4cd3-945c-961077630979", com.pulse.mo.CoachingSessionAttachment.class);
uuidMap.put("10ca64da-8132-4bb2-aebf-6e87aca3ded1", com.pulse.mo.CorrectiveAction.class);
uuidMap.put("9efa84f7-84d7-4c6e-bd1d-504638ca0765", com.pulse.mo.CorrectiveActionAttachment.class);
uuidMap.put("cfe9d170-f3d8-4039-b7b9-d47be5e7f9c9", com.pulse.mo.DevelopmentActivity.class);
uuidMap.put("1723cd78-254d-4484-ac89-6817ae2023f4", com.pulse.mo.DevelopmentPlan.class);
uuidMap.put("03d9c886-797d-44ab-871c-481bc7b02884", com.pulse.mo.Email.class);
uuidMap.put("a2e92fbb-0d02-4222-a4d3-e36898348822", com.pulse.mo.Goal.class);
uuidMap.put("2c4cfda3-3c5b-4af5-b379-907eaf2d6609", com.pulse.mo.GradeScale.class);
uuidMap.put("70b6ec9f-613f-4719-a75b-f503aed3dda4", com.pulse.mo.LOBConfigurationEntry.class);
uuidMap.put("35979c9b-c6e0-47c7-8bf9-022393e7b0c0", com.pulse.mo.TeamLeader.class);
uuidMap.put("3b0f8592-bc50-4950-8d15-f0d3eff0a718", com.pulse.mo.PulseUser.class);
uuidMap.put("1efc6db8-9945-4c1b-9e15-4715648ca71f", com.pulse.mo.QualityEvaluation.class);
uuidMap.put("a63a13f0-0f10-466b-850b-fb8d9bf354d6", com.pulse.mo.ScorecardMeasure.class);
uuidMap.put("afe068a7-1691-49d4-a2cc-4a3581c1845e", com.pulse.mo.ScorecardMonthlyResult.class);
uuidMap.put("5d048d35-3300-4386-9468-689f1d8a16d0", com.pulse.mo.ScorecardMonthlyScore.class);
uuidMap.put("65094bdd-2009-4957-ae67-0bf66cec7e82", com.pulse.mo.ScorecardWeeklyResult.class);
uuidMap.put("1c67f358-d35c-4fc1-bb18-7e00dfddf7ca", com.pulse.mo.ScorecardWeeklyScore.class);
uuidMap.put("5ef57da9-7683-42b1-8027-15966a2495b6", com.pulse.mo.Setting.class);
uuidMap.put("7afa2926-d4b8-49bc-a336-2257e4044e9f", com.pulse.mo.Supervisor.class);
uuidMap.put("0c186e45-f700-4824-b2db-a9b7a6272c1b", com.pulse.mo.TeamLeaderImpersonation.class);
uuidMap.put("0d0a0183-04c7-4580-adf1-93f76a19b8fd", com.pulse.mo.TraceEntry.class);
uuidMap.put("14a3b479-8bd2-4577-adf1-9db713b99f24", com.pulse.mo.UserRole.class);
uuidMap.put("77fb0e43-9ea5-4444-ae5c-2002ac10ba36", com.pulse.mo.UserSession.class);
uuidMap.put("4132dd6d-15f0-41b1-a565-d02306ad1566", com.pulse.mo.ShiftStatusNotification.class);

		}
		return uuidMap;
	}

}