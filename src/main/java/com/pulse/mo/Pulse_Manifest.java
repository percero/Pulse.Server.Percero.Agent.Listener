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
			classList.add(com.pulse.mo.AdhocCoachingCategory.class);
classList.add(com.pulse.mo.AdhocTaskState.class);
classList.add(com.pulse.mo.Behavior.class);
classList.add(com.pulse.mo.Notification.class);
classList.add(com.pulse.mo.CoachingNotification.class);
classList.add(com.pulse.mo.CoachingSessionState.class);
classList.add(com.pulse.mo.CorrectiveActionState.class);
classList.add(com.pulse.mo.CorrectiveActionType.class);
classList.add(com.pulse.mo.CVGProject.class);
classList.add(com.pulse.mo.DevelopmentPlan.class);
classList.add(com.pulse.mo.Agent.class);
classList.add(com.pulse.mo.LOB.class);
classList.add(com.pulse.mo.LOBConfiguration.class);
classList.add(com.pulse.mo.LOBConfigurationNotification.class);
classList.add(com.pulse.mo.DiscrepancyDetectedNotification.class);
classList.add(com.pulse.mo.DurationMismatchNotification.class);
classList.add(com.pulse.mo.ThresholdExceededNotification.class);
classList.add(com.pulse.mo.DurationToleranceNotification.class);
classList.add(com.pulse.mo.EmployeeAcknowledgement.class);
classList.add(com.pulse.mo.HRApproval.class);
classList.add(com.pulse.mo.InvalidActivityCodeNotification.class);
classList.add(com.pulse.mo.ManagerApproval.class);
classList.add(com.pulse.mo.Measure.class);
classList.add(com.pulse.mo.NonBillableActivityNotification.class);
classList.add(com.pulse.mo.Alert.class);
classList.add(com.pulse.mo.NotificationAlert.class);
classList.add(com.pulse.mo.NotificationFrequency.class);
classList.add(com.pulse.mo.Observation.class);
classList.add(com.pulse.mo.OccurrenceMismatchNotification.class);
classList.add(com.pulse.mo.OccurrenceToleranceNotification.class);
classList.add(com.pulse.mo.PayrollDetail.class);
classList.add(com.pulse.mo.PerformanceSummary.class);
classList.add(com.pulse.mo.PulseConfiguration.class);
classList.add(com.pulse.mo.Role.class);
classList.add(com.pulse.mo.Scorecard.class);
classList.add(com.pulse.mo.Site.class);
classList.add(com.pulse.mo.SupervisorAcknowledgement.class);
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
classList.add(com.pulse.mo.TimecardActivity.class);
classList.add(com.pulse.mo.TimecardEntry.class);
classList.add(com.pulse.mo.AdhocCoachingSession.class);
classList.add(com.pulse.mo.AdhocTask.class);
classList.add(com.pulse.mo.AgentScorecard.class);
classList.add(com.pulse.mo.BehaviorResponse.class);
classList.add(com.pulse.mo.CoachingComment.class);
classList.add(com.pulse.mo.CoachingSession.class);
classList.add(com.pulse.mo.CoachingSessionAttachment.class);
classList.add(com.pulse.mo.CorrectiveAction.class);
classList.add(com.pulse.mo.DevelopmentActivity.class);
classList.add(com.pulse.mo.Email.class);
classList.add(com.pulse.mo.GeneralComment.class);
classList.add(com.pulse.mo.LOBConfigurationEntry.class);
classList.add(com.pulse.mo.TeamLeader.class);
classList.add(com.pulse.mo.PulseUser.class);
classList.add(com.pulse.mo.QualityEvaluation.class);
classList.add(com.pulse.mo.ScorecardMeasure.class);
classList.add(com.pulse.mo.ScorecardMeasureMonthlyResult.class);
classList.add(com.pulse.mo.ScorecardMeasureWeeklyResult.class);
classList.add(com.pulse.mo.Setting.class);
classList.add(com.pulse.mo.Supervisor.class);
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
			objectList.add(new com.pulse.mo.AdhocCoachingCategory());
objectList.add(new com.pulse.mo.AdhocTaskState());
objectList.add(new com.pulse.mo.Behavior());
objectList.add(new com.pulse.mo.Notification());
objectList.add(new com.pulse.mo.CoachingNotification());
objectList.add(new com.pulse.mo.CoachingSessionState());
objectList.add(new com.pulse.mo.CorrectiveActionState());
objectList.add(new com.pulse.mo.CorrectiveActionType());
objectList.add(new com.pulse.mo.CVGProject());
objectList.add(new com.pulse.mo.DevelopmentPlan());
objectList.add(new com.pulse.mo.Agent());
objectList.add(new com.pulse.mo.LOB());
objectList.add(new com.pulse.mo.LOBConfiguration());
objectList.add(new com.pulse.mo.LOBConfigurationNotification());
objectList.add(new com.pulse.mo.DiscrepancyDetectedNotification());
objectList.add(new com.pulse.mo.DurationMismatchNotification());
objectList.add(new com.pulse.mo.ThresholdExceededNotification());
objectList.add(new com.pulse.mo.DurationToleranceNotification());
objectList.add(new com.pulse.mo.EmployeeAcknowledgement());
objectList.add(new com.pulse.mo.HRApproval());
objectList.add(new com.pulse.mo.InvalidActivityCodeNotification());
objectList.add(new com.pulse.mo.ManagerApproval());
objectList.add(new com.pulse.mo.Measure());
objectList.add(new com.pulse.mo.NonBillableActivityNotification());
objectList.add(new com.pulse.mo.Alert());
objectList.add(new com.pulse.mo.NotificationAlert());
objectList.add(new com.pulse.mo.NotificationFrequency());
objectList.add(new com.pulse.mo.Observation());
objectList.add(new com.pulse.mo.OccurrenceMismatchNotification());
objectList.add(new com.pulse.mo.OccurrenceToleranceNotification());
objectList.add(new com.pulse.mo.PayrollDetail());
objectList.add(new com.pulse.mo.PerformanceSummary());
objectList.add(new com.pulse.mo.PulseConfiguration());
objectList.add(new com.pulse.mo.Role());
objectList.add(new com.pulse.mo.Scorecard());
objectList.add(new com.pulse.mo.Site());
objectList.add(new com.pulse.mo.SupervisorAcknowledgement());
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
objectList.add(new com.pulse.mo.TimecardActivity());
objectList.add(new com.pulse.mo.TimecardEntry());
objectList.add(new com.pulse.mo.AdhocCoachingSession());
objectList.add(new com.pulse.mo.AdhocTask());
objectList.add(new com.pulse.mo.AgentScorecard());
objectList.add(new com.pulse.mo.BehaviorResponse());
objectList.add(new com.pulse.mo.CoachingComment());
objectList.add(new com.pulse.mo.CoachingSession());
objectList.add(new com.pulse.mo.CoachingSessionAttachment());
objectList.add(new com.pulse.mo.CorrectiveAction());
objectList.add(new com.pulse.mo.DevelopmentActivity());
objectList.add(new com.pulse.mo.Email());
objectList.add(new com.pulse.mo.GeneralComment());
objectList.add(new com.pulse.mo.LOBConfigurationEntry());
objectList.add(new com.pulse.mo.TeamLeader());
objectList.add(new com.pulse.mo.PulseUser());
objectList.add(new com.pulse.mo.QualityEvaluation());
objectList.add(new com.pulse.mo.ScorecardMeasure());
objectList.add(new com.pulse.mo.ScorecardMeasureMonthlyResult());
objectList.add(new com.pulse.mo.ScorecardMeasureWeeklyResult());
objectList.add(new com.pulse.mo.Setting());
objectList.add(new com.pulse.mo.Supervisor());
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
			uuidMap.put("f8cfb4ce-54b5-4559-aa97-efa0f54cf475", com.pulse.mo.AdhocCoachingCategory.class);
uuidMap.put("a05c6e12-01a8-4d2d-994a-f138ec805782", com.pulse.mo.AdhocTaskState.class);
uuidMap.put("e20ce088-00a7-4673-bb33-1d8d007ad0ac", com.pulse.mo.Behavior.class);
uuidMap.put("d6d40546-9a48-49e2-b6f2-ae6e4bb2265d", com.pulse.mo.Notification.class);
uuidMap.put("ae6c7d16-0d72-46b6-8385-0a78e8017e4f", com.pulse.mo.CoachingNotification.class);
uuidMap.put("6feecc3e-249e-462d-b71b-912aab801804", com.pulse.mo.CoachingSessionState.class);
uuidMap.put("048aae3a-a69f-4253-bd31-6ec2cc38912a", com.pulse.mo.CorrectiveActionState.class);
uuidMap.put("97d3fcea-1b7d-4d72-8a7e-6cf66709f7d6", com.pulse.mo.CorrectiveActionType.class);
uuidMap.put("83a9e363-178d-4cc7-bf42-0a74319e18cf", com.pulse.mo.CVGProject.class);
uuidMap.put("4b2ac655-f9d9-4058-a5f6-81e0678687aa", com.pulse.mo.DevelopmentPlan.class);
uuidMap.put("3ad6eb82-98c0-4277-ab76-474aaf4df283", com.pulse.mo.Agent.class);
uuidMap.put("90a43c8c-e8f7-45cd-b1ef-347432f47942", com.pulse.mo.LOB.class);
uuidMap.put("efa5de6a-0890-4baa-869c-edc547f0fd0d", com.pulse.mo.LOBConfiguration.class);
uuidMap.put("32b5edb2-27f3-4956-8d69-91043b9455e6", com.pulse.mo.LOBConfigurationNotification.class);
uuidMap.put("35682bae-fe81-4b71-b48c-792190e61cf0", com.pulse.mo.DiscrepancyDetectedNotification.class);
uuidMap.put("2f746cb8-0ba6-4c2a-9255-fa6a6a6d8b50", com.pulse.mo.DurationMismatchNotification.class);
uuidMap.put("4a1edf9d-e5fc-4d4a-a094-8eba5352daf9", com.pulse.mo.ThresholdExceededNotification.class);
uuidMap.put("c2529412-5773-4325-ae7e-4cef65e217c6", com.pulse.mo.DurationToleranceNotification.class);
uuidMap.put("445bbc29-46f8-40ca-ad14-2fc35e426072", com.pulse.mo.EmployeeAcknowledgement.class);
uuidMap.put("498a6f77-2838-48fe-8dae-385255519fd1", com.pulse.mo.HRApproval.class);
uuidMap.put("68e52b39-bce9-40b0-8463-15746b57bebd", com.pulse.mo.InvalidActivityCodeNotification.class);
uuidMap.put("7ce5d83e-fbbd-401c-8e71-902e99fe9f74", com.pulse.mo.ManagerApproval.class);
uuidMap.put("3b96c63a-8911-4056-b3db-f9906beaf3f2", com.pulse.mo.Measure.class);
uuidMap.put("edbd1216-c485-4788-8deb-2d1b8d642a98", com.pulse.mo.NonBillableActivityNotification.class);
uuidMap.put("0024a435-68e2-4ff4-be41-f65e1883850c", com.pulse.mo.Alert.class);
uuidMap.put("5d8ca112-8ecc-4a3d-9ccb-e783f5b94d38", com.pulse.mo.NotificationAlert.class);
uuidMap.put("7a6f9efa-e3c8-45db-83ef-f92cf89d375a", com.pulse.mo.NotificationFrequency.class);
uuidMap.put("cad96f2b-59b3-49e1-8c69-b427b2c65f2e", com.pulse.mo.Observation.class);
uuidMap.put("06ed6c28-a993-4b5d-a41c-7fd1bc477559", com.pulse.mo.OccurrenceMismatchNotification.class);
uuidMap.put("589eb97f-b53b-4bc2-ab7d-636c55240eac", com.pulse.mo.OccurrenceToleranceNotification.class);
uuidMap.put("e0bdce18-5ae4-4756-8a7f-3828ada16c5c", com.pulse.mo.PayrollDetail.class);
uuidMap.put("b2a7e1a7-59bf-486c-8d70-d6a4ec442c09", com.pulse.mo.PerformanceSummary.class);
uuidMap.put("a8afc727-1661-4935-ae13-e87b0cb5ff9d", com.pulse.mo.PulseConfiguration.class);
uuidMap.put("b82912d5-a95e-40d8-8072-367450fad9a6", com.pulse.mo.Role.class);
uuidMap.put("3d73b796-b56b-4d44-8e78-f3f6139c345e", com.pulse.mo.Scorecard.class);
uuidMap.put("17d16629-6183-4239-bca2-74c2047f56d1", com.pulse.mo.Site.class);
uuidMap.put("1ed2b62a-9d69-4a10-b466-348fc6601a6a", com.pulse.mo.SupervisorAcknowledgement.class);
uuidMap.put("64fae81e-fd31-4083-880f-2fbaf64ff017", com.pulse.mo.ThresholdGradeScale.class);
uuidMap.put("54384655-66ca-489b-a8dc-e6a86aebde3f", com.pulse.mo.ThresholdScale.class);
uuidMap.put("34a1d59e-a0ae-44ee-adc4-2c762724251b", com.pulse.mo.TraceLog.class);
uuidMap.put("784a3b57-cb91-4f55-ab73-0d331d855efd", com.pulse.mo.WorkDurationNotification.class);
uuidMap.put("d8a096d2-d32a-445c-93aa-dd64b898ddad", com.pulse.mo.WorkModeOccurrenceNotification.class);
uuidMap.put("9d68373b-3b67-4e4b-bcd3-a8078fb55cf1", com.pulse.mo.Client.class);
uuidMap.put("4b43d163-6c12-412a-a325-73f47257d7af", com.pulse.mo.CMSEntry.class);
uuidMap.put("c7d42c92-9ad8-4aa6-852c-e9be656882cb", com.pulse.mo.Schedule.class);
uuidMap.put("fb532ba4-bc8a-41f0-ab3c-6e19df0dba0d", com.pulse.mo.ScheduleEntry.class);
uuidMap.put("ab97bba7-ca76-40b8-bf65-0c29a77d39f5", com.pulse.mo.Timecard.class);
uuidMap.put("f7f7fada-c3dc-4c6d-a8a5-60294bb88f74", com.pulse.mo.TimecardActivity.class);
uuidMap.put("ca617033-3116-4486-94c6-05b0c8c96d5a", com.pulse.mo.TimecardEntry.class);
uuidMap.put("2851f5e2-97f7-4961-955d-79d22e86a538", com.pulse.mo.AdhocCoachingSession.class);
uuidMap.put("a86f7301-bfab-4f12-afa7-697299f41a2f", com.pulse.mo.AdhocTask.class);
uuidMap.put("a0719004-0972-4648-b8fc-aa6c9338dc6b", com.pulse.mo.AgentScorecard.class);
uuidMap.put("2a014e02-6386-44c2-b738-46939690907c", com.pulse.mo.BehaviorResponse.class);
uuidMap.put("71b31711-8e2e-4e0c-8ec5-4ef22032aa8c", com.pulse.mo.CoachingComment.class);
uuidMap.put("cd6fa503-8930-4f1e-ae72-3991f5f34b7b", com.pulse.mo.CoachingSession.class);
uuidMap.put("fd5fc002-a9cf-424d-9c8b-6036178cd7b7", com.pulse.mo.CoachingSessionAttachment.class);
uuidMap.put("eab5353d-4629-4c12-b3aa-6c111b4fd819", com.pulse.mo.CorrectiveAction.class);
uuidMap.put("517e50b6-4375-467e-b9f2-f47b7e5e41df", com.pulse.mo.DevelopmentActivity.class);
uuidMap.put("b556ba9b-e549-4f8a-88e5-f7d205580bd5", com.pulse.mo.Email.class);
uuidMap.put("c30b7135-93e9-45d2-9e35-bf577df2639a", com.pulse.mo.GeneralComment.class);
uuidMap.put("38aee688-c3cf-4ea4-a845-677b94ea1e27", com.pulse.mo.LOBConfigurationEntry.class);
uuidMap.put("2c8b6af9-03f8-403e-aed2-e759e0e6cc23", com.pulse.mo.TeamLeader.class);
uuidMap.put("936dc1f5-ad00-4544-b463-f49476348df7", com.pulse.mo.PulseUser.class);
uuidMap.put("eaa6ccce-0c50-45fd-890c-4132ff0816ec", com.pulse.mo.QualityEvaluation.class);
uuidMap.put("1bf960ea-31e8-4c31-9d2c-01b2535f910b", com.pulse.mo.ScorecardMeasure.class);
uuidMap.put("fa4f198b-b9c1-4ac5-ac67-7e45b163aa39", com.pulse.mo.ScorecardMeasureMonthlyResult.class);
uuidMap.put("1a85d39f-bed5-4d71-ba69-e54a4c88d47b", com.pulse.mo.ScorecardMeasureWeeklyResult.class);
uuidMap.put("9be1db29-c207-4aca-8cf7-a65c053901f2", com.pulse.mo.Setting.class);
uuidMap.put("490607e7-98c5-4e01-b973-92dd8c8b11c2", com.pulse.mo.Supervisor.class);
uuidMap.put("b26a45a9-05f5-4573-8e00-df6583b8e0ee", com.pulse.mo.TeamLeaderImpersonation.class);
uuidMap.put("cfafd5b3-649a-495a-8dcc-0bbb52c8ae71", com.pulse.mo.ThresholdLevel.class);
uuidMap.put("9d659e11-e893-4540-8d41-8a71a4d05539", com.pulse.mo.TraceEntry.class);
uuidMap.put("0377f971-8133-4c10-a759-b8dec5b0df73", com.pulse.mo.UserRole.class);
uuidMap.put("798d9ecf-5344-496a-ba65-abcb9adb2d62", com.pulse.mo.UserSession.class);
uuidMap.put("007660ab-1216-43c1-99de-43e718dcd38e", com.pulse.mo.ShiftStatusNotification.class);

		}
		return uuidMap;
	}

}