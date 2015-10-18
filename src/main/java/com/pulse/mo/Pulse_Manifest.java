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
classList.add(com.pulse.mo.AdhocCoachingSessionAttachment.class);
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
classList.add(com.pulse.mo.Goal.class);
classList.add(com.pulse.mo.GradeScale.class);
classList.add(com.pulse.mo.LOBConfigurationEntry.class);
classList.add(com.pulse.mo.TeamLeader.class);
classList.add(com.pulse.mo.PulseUser.class);
classList.add(com.pulse.mo.QualityEvaluation.class);
classList.add(com.pulse.mo.ScorecardMeasure.class);
classList.add(com.pulse.mo.ScorecardMeasureMonthlyResult.class);
classList.add(com.pulse.mo.ScorecardMeasureWeeklyResult.class);
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
objectList.add(new com.pulse.mo.AdhocCoachingSessionAttachment());
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
objectList.add(new com.pulse.mo.Goal());
objectList.add(new com.pulse.mo.GradeScale());
objectList.add(new com.pulse.mo.LOBConfigurationEntry());
objectList.add(new com.pulse.mo.TeamLeader());
objectList.add(new com.pulse.mo.PulseUser());
objectList.add(new com.pulse.mo.QualityEvaluation());
objectList.add(new com.pulse.mo.ScorecardMeasure());
objectList.add(new com.pulse.mo.ScorecardMeasureMonthlyResult());
objectList.add(new com.pulse.mo.ScorecardMeasureWeeklyResult());
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
			uuidMap.put("2127f179-1e1f-468f-94f7-3d606f29b7b2", com.pulse.mo.TimecardActivity.class);
uuidMap.put("c0b21a08-4afd-466c-98e3-a87579700160", com.pulse.mo.AdhocCoachingCategory.class);
uuidMap.put("e25b2e98-7b6d-420f-81f2-8e9300a56ebc", com.pulse.mo.AdhocTaskState.class);
uuidMap.put("fcbb9f6b-e9bb-4817-9eb9-ca4aaefb7f78", com.pulse.mo.Behavior.class);
uuidMap.put("a7f4cd90-b79e-439f-ab86-88b05801e990", com.pulse.mo.Notification.class);
uuidMap.put("c5ea40bc-9ab5-4e7b-9750-8c0c08fe4093", com.pulse.mo.CoachingNotification.class);
uuidMap.put("b61b89c6-518e-4463-af9f-14eb26d829ef", com.pulse.mo.CoachingSessionState.class);
uuidMap.put("9b19e7f2-3e53-4934-bd1c-1262d0cf1056", com.pulse.mo.CorrectiveActionState.class);
uuidMap.put("06ac35a3-7120-45c2-aa32-63c2456a6880", com.pulse.mo.CorrectiveActionType.class);
uuidMap.put("fe4baa88-cc28-453a-9d61-a553436a9ddf", com.pulse.mo.Agent.class);
uuidMap.put("b439dcf7-5856-45c8-a195-a14226207ff0", com.pulse.mo.LOB.class);
uuidMap.put("9c66e119-3996-4688-b03b-81949ee8701c", com.pulse.mo.LOBConfiguration.class);
uuidMap.put("97170d44-35f7-4d51-9b86-0c8df2c73721", com.pulse.mo.LOBConfigurationNotification.class);
uuidMap.put("d5c5cbce-4d91-4e80-b620-3b0255a28000", com.pulse.mo.DiscrepancyDetectedNotification.class);
uuidMap.put("8904cf8f-4e21-45d5-b1e7-3e05bf144e9b", com.pulse.mo.DurationMismatchNotification.class);
uuidMap.put("7d6bdbd1-ce26-423d-b489-97ead12e0eb2", com.pulse.mo.ThresholdExceededNotification.class);
uuidMap.put("47bf936b-23a7-4be8-a2c8-f430eae2015a", com.pulse.mo.DurationToleranceNotification.class);
uuidMap.put("4a976641-18f1-4353-aaa7-87c7c411d27b", com.pulse.mo.Employee.class);
uuidMap.put("10a2f70c-926b-4dd0-a75e-4ddb870539c1", com.pulse.mo.InvalidActivityCodeNotification.class);
uuidMap.put("3be3c547-5478-456e-9012-472e0491c2f1", com.pulse.mo.Measure.class);
uuidMap.put("0956f340-7322-4e00-bd71-836afeab7478", com.pulse.mo.NonBillableActivityNotification.class);
uuidMap.put("df096295-bdb3-4cd0-bfc7-a9e7ad382a88", com.pulse.mo.Alert.class);
uuidMap.put("d6fc3211-8bf1-4cb1-b48b-aa577cf3bc11", com.pulse.mo.NotificationAlert.class);
uuidMap.put("eb3bacd8-f218-4c85-a1e2-72c087d6cd79", com.pulse.mo.NotificationFrequency.class);
uuidMap.put("85fefd56-5056-4a58-91e9-aaeca9d418d1", com.pulse.mo.OccurrenceMismatchNotification.class);
uuidMap.put("b496d8bd-b72a-4581-95ff-bbb5781449ce", com.pulse.mo.OccurrenceToleranceNotification.class);
uuidMap.put("b4055900-083c-4f0b-9b77-7cd1310b1281", com.pulse.mo.PulseConfiguration.class);
uuidMap.put("8ceaeb41-2f9c-4ffc-8a40-f28dabbe060d", com.pulse.mo.Role.class);
uuidMap.put("89be4583-cc24-4750-aef3-64fb1f4da17b", com.pulse.mo.Scorecard.class);
uuidMap.put("1eac0819-f25f-4030-a7df-9b3bc97be582", com.pulse.mo.Site.class);
uuidMap.put("d45934b1-dd45-4738-bcd9-516bcf13abb7", com.pulse.mo.TraceLog.class);
uuidMap.put("b630da9a-958e-4972-9f83-9c643c81e682", com.pulse.mo.WorkDurationNotification.class);
uuidMap.put("b96a82a2-2208-4277-ac7a-f7779850326c", com.pulse.mo.WorkModeOccurrenceNotification.class);
uuidMap.put("dab84867-e941-4ffc-98d1-bbee4fc4ca0f", com.pulse.mo.Client.class);
uuidMap.put("7d35b796-f93f-40f9-99a8-61ed34ad7c27", com.pulse.mo.CMSEntry.class);
uuidMap.put("a42254dd-f1bc-45d8-a129-fdae93bc5496", com.pulse.mo.Schedule.class);
uuidMap.put("35a19c6e-7c0f-4b52-83c4-c9f9fd83e19c", com.pulse.mo.ScheduleEntry.class);
uuidMap.put("30f4e828-9770-4658-a1ae-41b287f85b0e", com.pulse.mo.Timecard.class);
uuidMap.put("727119e3-69a7-4872-ae65-4cad75483230", com.pulse.mo.TimecardEntry.class);
uuidMap.put("1563ad44-ecdf-4e3e-96eb-96c7358cb9b7", com.pulse.mo.AdhocCoachingSession.class);
uuidMap.put("10dc7e9e-777a-467a-8d2a-9b08eeab6d20", com.pulse.mo.AdhocCoachingSessionAttachment.class);
uuidMap.put("3c49f9d5-1fef-4ed0-9114-38b065f97ec8", com.pulse.mo.AdhocTask.class);
uuidMap.put("05153aca-b715-4775-8ec0-0969ac64aea7", com.pulse.mo.AgentScorecard.class);
uuidMap.put("bff14b2f-05e4-4d3e-90b2-38d5e7fa26f0", com.pulse.mo.BehaviorResponse.class);
uuidMap.put("19c01a49-6bb2-40ac-850c-42d8046cda84", com.pulse.mo.CoachingSession.class);
uuidMap.put("b90688bb-a91f-4f3c-9bbf-2797e38cc655", com.pulse.mo.CoachingSessionAttachment.class);
uuidMap.put("9eb17d4d-4e2a-4783-87ed-64c2c6867c30", com.pulse.mo.Comment.class);
uuidMap.put("5004ed48-0988-4727-b9fa-c8ee428602d3", com.pulse.mo.Supervisor.class);
uuidMap.put("4adf8970-28a9-4f00-b3bd-e62cd7b31ea7", com.pulse.mo.CorrectiveAction.class);
uuidMap.put("9af2604f-178e-4c72-9719-e6ec3dd813ae", com.pulse.mo.CorrectiveActionAttachment.class);
uuidMap.put("f9d376e7-43a6-464e-b476-4ec2e741b773", com.pulse.mo.DevelopmentActivity.class);
uuidMap.put("5d146ecd-f220-42df-9224-f1698ecccec1", com.pulse.mo.DevelopmentPlan.class);
uuidMap.put("303180b0-b646-4079-bf75-774612d9ad73", com.pulse.mo.Email.class);
uuidMap.put("01a00d77-df51-4878-90b4-95d8fa7bf9af", com.pulse.mo.Goal.class);
uuidMap.put("84a111f3-7306-4927-a3d2-a7cbe6d99ec1", com.pulse.mo.GradeScale.class);
uuidMap.put("33a02369-fd9e-4407-9590-85d8786af678", com.pulse.mo.LOBConfigurationEntry.class);
uuidMap.put("4085c660-c091-4389-8a71-59556d86a00e", com.pulse.mo.TeamLeader.class);
uuidMap.put("192f9709-6726-4a9d-8cda-738482bad8d9", com.pulse.mo.PulseUser.class);
uuidMap.put("0d663183-efb0-4382-9a39-9993594fa5d5", com.pulse.mo.QualityEvaluation.class);
uuidMap.put("a5125a1f-7fb0-41a5-97c2-66fb2edbd6a3", com.pulse.mo.ScorecardMeasure.class);
uuidMap.put("9b0d29bf-aeb5-4bd0-8638-0f4fb1296e02", com.pulse.mo.ScorecardMeasureMonthlyResult.class);
uuidMap.put("dc8a0a82-f09f-46b4-8959-625cd7e7a0cd", com.pulse.mo.ScorecardMeasureWeeklyResult.class);
uuidMap.put("20869f39-f5f1-4964-8f62-2d279f428d14", com.pulse.mo.Setting.class);
uuidMap.put("8977ec4a-7e6b-4538-b97c-02b2650b07ad", com.pulse.mo.TeamLeaderImpersonation.class);
uuidMap.put("c7d80db4-cf61-41b6-893b-00b6b0a65ae0", com.pulse.mo.TraceEntry.class);
uuidMap.put("becf8fa4-75c5-45e5-80c4-322bc3be8f64", com.pulse.mo.UserRole.class);
uuidMap.put("707a9c81-2738-42ad-a8ed-1b2a08945b3c", com.pulse.mo.UserSession.class);
uuidMap.put("cd64f557-b387-4853-b996-19825f9b7ad9", com.pulse.mo.ShiftStatusNotification.class);

		}
		return uuidMap;
	}

}