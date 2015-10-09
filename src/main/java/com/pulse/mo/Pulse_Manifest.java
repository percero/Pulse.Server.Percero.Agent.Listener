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
classList.add(com.pulse.mo.CMSAuxMode.class);
classList.add(com.pulse.mo.CoachingSessionState.class);
classList.add(com.pulse.mo.ConnectedState.class);
classList.add(com.pulse.mo.CorrectiveActionState.class);
classList.add(com.pulse.mo.CorrectiveActionType.class);
classList.add(com.pulse.mo.CVGProject.class);
classList.add(com.pulse.mo.Notification.class);
classList.add(com.pulse.mo.LOB.class);
classList.add(com.pulse.mo.LOBConfiguration.class);
classList.add(com.pulse.mo.Agent.class);
classList.add(com.pulse.mo.LOBConfigurationNotification.class);
classList.add(com.pulse.mo.DiscrepancyDetectedNotification.class);
classList.add(com.pulse.mo.DurationMismatchNotification.class);
classList.add(com.pulse.mo.ThresholdExceededNotification.class);
classList.add(com.pulse.mo.DurationToleranceNotification.class);
classList.add(com.pulse.mo.EmployeeAcknowledgement.class);
classList.add(com.pulse.mo.HRApproval.class);
classList.add(com.pulse.mo.InvalidActivityCodeNotification.class);
classList.add(com.pulse.mo.ManagerApproval.class);
classList.add(com.pulse.mo.NonBillableActivityNotification.class);
classList.add(com.pulse.mo.Alert.class);
classList.add(com.pulse.mo.NotificationAlert.class);
classList.add(com.pulse.mo.NotificationFrequency.class);
classList.add(com.pulse.mo.OccurrenceMismatchNotification.class);
classList.add(com.pulse.mo.OccurrenceToleranceNotification.class);
classList.add(com.pulse.mo.PayrollDetail.class);
classList.add(com.pulse.mo.PerformanceSummary.class);
classList.add(com.pulse.mo.PulseConfiguration.class);
classList.add(com.pulse.mo.Role.class);
classList.add(com.pulse.mo.ScheduledActivityCode.class);
classList.add(com.pulse.mo.ScheduledActivityType.class);
classList.add(com.pulse.mo.ScorecardState.class);
classList.add(com.pulse.mo.Site.class);
classList.add(com.pulse.mo.SupervisorAcknowledgement.class);
classList.add(com.pulse.mo.ThresholdGradeScale.class);
classList.add(com.pulse.mo.ThresholdScale.class);
classList.add(com.pulse.mo.TraceLog.class);
classList.add(com.pulse.mo.WorkDurationNotification.class);
classList.add(com.pulse.mo.WorkModeOccurrenceNotification.class);
classList.add(com.pulse.mo.CMSEntry.class);
classList.add(com.pulse.mo.Timecard.class);
classList.add(com.pulse.mo.TimecardActivity.class);
classList.add(com.pulse.mo.TimecardEntry.class);
classList.add(com.pulse.mo.AdhocCoachingSession.class);
classList.add(com.pulse.mo.AdhocTask.class);
classList.add(com.pulse.mo.Scorecard.class);
classList.add(com.pulse.mo.AgentScorecard.class);
classList.add(com.pulse.mo.Attachment.class);
classList.add(com.pulse.mo.Behavior.class);
classList.add(com.pulse.mo.BehaviorResponse.class);
classList.add(com.pulse.mo.Client.class);
classList.add(com.pulse.mo.CoachingSession.class);
classList.add(com.pulse.mo.CorrectiveAction.class);
classList.add(com.pulse.mo.DevelopmentActivity.class);
classList.add(com.pulse.mo.Email.class);
classList.add(com.pulse.mo.GeneralComment.class);
classList.add(com.pulse.mo.LOBConfigurationEntry.class);
classList.add(com.pulse.mo.Observation.class);
classList.add(com.pulse.mo.TeamLeader.class);
classList.add(com.pulse.mo.PulseUser.class);
classList.add(com.pulse.mo.QualityEvaluation.class);
classList.add(com.pulse.mo.ScheduledTime.class);
classList.add(com.pulse.mo.ScheduledTimeEntry.class);
classList.add(com.pulse.mo.ScorecardMeasure.class);
classList.add(com.pulse.mo.Setting.class);
classList.add(com.pulse.mo.Supervisor.class);
classList.add(com.pulse.mo.TeamLeaderAction.class);
classList.add(com.pulse.mo.TeamLeaderImpersonation.class);
classList.add(com.pulse.mo.ThresholdLevel.class);
classList.add(com.pulse.mo.TraceEntry.class);
classList.add(com.pulse.mo.UserRole.class);
classList.add(com.pulse.mo.UserSession.class);
classList.add(com.pulse.mo.ChangesNotApprovedNotification.class);
classList.add(com.pulse.mo.CoachingNotification.class);

		}
		return classList;
	}

	private List<Object> objectList = null;
	public List<Object> getObjectList() {
		if (objectList == null) {
			objectList = new ArrayList<Object>();
			objectList.add(new com.pulse.mo.AdhocCoachingCategory());
objectList.add(new com.pulse.mo.AdhocTaskState());
objectList.add(new com.pulse.mo.CMSAuxMode());
objectList.add(new com.pulse.mo.CoachingSessionState());
objectList.add(new com.pulse.mo.ConnectedState());
objectList.add(new com.pulse.mo.CorrectiveActionState());
objectList.add(new com.pulse.mo.CorrectiveActionType());
objectList.add(new com.pulse.mo.CVGProject());
objectList.add(new com.pulse.mo.Notification());
objectList.add(new com.pulse.mo.LOB());
objectList.add(new com.pulse.mo.LOBConfiguration());
objectList.add(new com.pulse.mo.Agent());
objectList.add(new com.pulse.mo.LOBConfigurationNotification());
objectList.add(new com.pulse.mo.DiscrepancyDetectedNotification());
objectList.add(new com.pulse.mo.DurationMismatchNotification());
objectList.add(new com.pulse.mo.ThresholdExceededNotification());
objectList.add(new com.pulse.mo.DurationToleranceNotification());
objectList.add(new com.pulse.mo.EmployeeAcknowledgement());
objectList.add(new com.pulse.mo.HRApproval());
objectList.add(new com.pulse.mo.InvalidActivityCodeNotification());
objectList.add(new com.pulse.mo.ManagerApproval());
objectList.add(new com.pulse.mo.NonBillableActivityNotification());
objectList.add(new com.pulse.mo.Alert());
objectList.add(new com.pulse.mo.NotificationAlert());
objectList.add(new com.pulse.mo.NotificationFrequency());
objectList.add(new com.pulse.mo.OccurrenceMismatchNotification());
objectList.add(new com.pulse.mo.OccurrenceToleranceNotification());
objectList.add(new com.pulse.mo.PayrollDetail());
objectList.add(new com.pulse.mo.PerformanceSummary());
objectList.add(new com.pulse.mo.PulseConfiguration());
objectList.add(new com.pulse.mo.Role());
objectList.add(new com.pulse.mo.ScheduledActivityCode());
objectList.add(new com.pulse.mo.ScheduledActivityType());
objectList.add(new com.pulse.mo.ScorecardState());
objectList.add(new com.pulse.mo.Site());
objectList.add(new com.pulse.mo.SupervisorAcknowledgement());
objectList.add(new com.pulse.mo.ThresholdGradeScale());
objectList.add(new com.pulse.mo.ThresholdScale());
objectList.add(new com.pulse.mo.TraceLog());
objectList.add(new com.pulse.mo.WorkDurationNotification());
objectList.add(new com.pulse.mo.WorkModeOccurrenceNotification());
objectList.add(new com.pulse.mo.CMSEntry());
objectList.add(new com.pulse.mo.Timecard());
objectList.add(new com.pulse.mo.TimecardActivity());
objectList.add(new com.pulse.mo.TimecardEntry());
objectList.add(new com.pulse.mo.AdhocCoachingSession());
objectList.add(new com.pulse.mo.AdhocTask());
objectList.add(new com.pulse.mo.Scorecard());
objectList.add(new com.pulse.mo.AgentScorecard());
objectList.add(new com.pulse.mo.Attachment());
objectList.add(new com.pulse.mo.Behavior());
objectList.add(new com.pulse.mo.BehaviorResponse());
objectList.add(new com.pulse.mo.Client());
objectList.add(new com.pulse.mo.CoachingSession());
objectList.add(new com.pulse.mo.CorrectiveAction());
objectList.add(new com.pulse.mo.DevelopmentActivity());
objectList.add(new com.pulse.mo.Email());
objectList.add(new com.pulse.mo.GeneralComment());
objectList.add(new com.pulse.mo.LOBConfigurationEntry());
objectList.add(new com.pulse.mo.Observation());
objectList.add(new com.pulse.mo.TeamLeader());
objectList.add(new com.pulse.mo.PulseUser());
objectList.add(new com.pulse.mo.QualityEvaluation());
objectList.add(new com.pulse.mo.ScheduledTime());
objectList.add(new com.pulse.mo.ScheduledTimeEntry());
objectList.add(new com.pulse.mo.ScorecardMeasure());
objectList.add(new com.pulse.mo.Setting());
objectList.add(new com.pulse.mo.Supervisor());
objectList.add(new com.pulse.mo.TeamLeaderAction());
objectList.add(new com.pulse.mo.TeamLeaderImpersonation());
objectList.add(new com.pulse.mo.ThresholdLevel());
objectList.add(new com.pulse.mo.TraceEntry());
objectList.add(new com.pulse.mo.UserRole());
objectList.add(new com.pulse.mo.UserSession());
objectList.add(new com.pulse.mo.ChangesNotApprovedNotification());
objectList.add(new com.pulse.mo.CoachingNotification());

		}
		return objectList;
	}

	private Map<String, Class> uuidMap = null;
	public Map<String, Class> getUuidMap() {
		if (uuidMap == null) {
			uuidMap = new HashMap<String, Class>();
			uuidMap.put("35780d4a-c93b-4272-88f6-11fed3d7473a", com.pulse.mo.AdhocCoachingCategory.class);
uuidMap.put("e604d5f5-f151-429c-a475-bc4f2e60b414", com.pulse.mo.AdhocTaskState.class);
uuidMap.put("653d04e3-d24c-4d7c-adc5-902faeb8b8a0", com.pulse.mo.CMSAuxMode.class);
uuidMap.put("184f6565-63af-46e7-a32f-8ca37fd5d232", com.pulse.mo.CoachingSessionState.class);
uuidMap.put("dbfada4d-3985-4afd-8c47-568daf7d5edb", com.pulse.mo.ConnectedState.class);
uuidMap.put("4c2cde37-e7df-40ea-b0af-47a712e723e3", com.pulse.mo.CorrectiveActionState.class);
uuidMap.put("47afa1b1-c090-41ef-87d0-6465ed0e302a", com.pulse.mo.CorrectiveActionType.class);
uuidMap.put("c5d267d6-a071-4cfc-a20e-cfe01aa9b677", com.pulse.mo.CVGProject.class);
uuidMap.put("e9e4d149-2aff-4ec0-a1b8-d96c1f6be988", com.pulse.mo.Notification.class);
uuidMap.put("2eed13e6-c55b-4d7a-9506-ae98d7e9af7a", com.pulse.mo.LOB.class);
uuidMap.put("ba10788b-85c5-4919-bb94-d6e325178865", com.pulse.mo.LOBConfiguration.class);
uuidMap.put("60d5d57b-41d2-406d-94cc-120c40071f66", com.pulse.mo.Agent.class);
uuidMap.put("f9d71885-cd0c-4ba4-8a42-79d0d24e08d8", com.pulse.mo.LOBConfigurationNotification.class);
uuidMap.put("3d728044-7ab5-4776-bf4e-8617857ddb34", com.pulse.mo.DiscrepancyDetectedNotification.class);
uuidMap.put("4d838132-dbaa-4c3d-86e6-e674d57c85e3", com.pulse.mo.DurationMismatchNotification.class);
uuidMap.put("8717a2b7-5580-4937-b7b0-9fcfd0043288", com.pulse.mo.ThresholdExceededNotification.class);
uuidMap.put("29833b4e-2f60-4673-bee0-b493f4646593", com.pulse.mo.DurationToleranceNotification.class);
uuidMap.put("18e91454-cdb7-4716-add2-682e5ed840ad", com.pulse.mo.EmployeeAcknowledgement.class);
uuidMap.put("71145515-dccc-438d-8091-5047973f5d48", com.pulse.mo.HRApproval.class);
uuidMap.put("4ccd67b3-0815-48aa-a7bd-223199e93530", com.pulse.mo.InvalidActivityCodeNotification.class);
uuidMap.put("51e414f2-a1d6-41a8-a465-1e672c5be7aa", com.pulse.mo.ManagerApproval.class);
uuidMap.put("e94a4bdd-60e1-4eb7-a9c7-a3e06231760b", com.pulse.mo.NonBillableActivityNotification.class);
uuidMap.put("1d504c35-c1ff-41f1-9876-fd43e78d1faa", com.pulse.mo.Alert.class);
uuidMap.put("dbb5b619-3d4e-4d9c-bcb4-7ee9daf1237d", com.pulse.mo.NotificationAlert.class);
uuidMap.put("b4f9ff88-ac34-4223-84fe-5357837b037e", com.pulse.mo.NotificationFrequency.class);
uuidMap.put("cfcc4c7a-a394-45d4-8678-cdac164c3a94", com.pulse.mo.OccurrenceMismatchNotification.class);
uuidMap.put("d7c88808-dd75-46cf-b0d4-b60ccc3797b1", com.pulse.mo.OccurrenceToleranceNotification.class);
uuidMap.put("c6171956-8eb4-424c-b27a-59bf99f71850", com.pulse.mo.PayrollDetail.class);
uuidMap.put("c35814eb-f742-4228-a7ee-d677724d554f", com.pulse.mo.PerformanceSummary.class);
uuidMap.put("2a4c57f5-3630-4081-8bf9-80ed6072ace5", com.pulse.mo.PulseConfiguration.class);
uuidMap.put("53a6c4a3-60b3-4e01-8fbe-8444adeb6973", com.pulse.mo.Role.class);
uuidMap.put("493a8856-55f8-478f-98b7-fbc7b6641a87", com.pulse.mo.ScheduledActivityCode.class);
uuidMap.put("ed00cfbd-5ffe-4849-ae5a-456bce2f9f64", com.pulse.mo.ScheduledActivityType.class);
uuidMap.put("9c20ce38-dc62-41da-a161-6968891432d2", com.pulse.mo.ScorecardState.class);
uuidMap.put("8fd3add9-4765-45b1-b647-0b5dcf1c1745", com.pulse.mo.Site.class);
uuidMap.put("f63d1aef-2b1a-4a06-b656-ca16be65f251", com.pulse.mo.SupervisorAcknowledgement.class);
uuidMap.put("274d550f-7b4b-4681-9794-6a0c8b72653a", com.pulse.mo.ThresholdGradeScale.class);
uuidMap.put("59eef222-1015-4f7a-b69a-22af75e8a229", com.pulse.mo.ThresholdScale.class);
uuidMap.put("3aee672e-1098-40b1-bdd4-d8d0906fd5c3", com.pulse.mo.TraceLog.class);
uuidMap.put("93e05ef1-e636-42a9-93c4-e8f9a69e0d6d", com.pulse.mo.WorkDurationNotification.class);
uuidMap.put("ae357366-8f87-4acf-ae77-a5838ee779eb", com.pulse.mo.WorkModeOccurrenceNotification.class);
uuidMap.put("cc04219a-f449-416f-80c6-157cf3170304", com.pulse.mo.CMSEntry.class);
uuidMap.put("d64ef247-1627-4552-b7dd-eb0705d4529c", com.pulse.mo.Timecard.class);
uuidMap.put("38e364d7-0e8e-4be4-877b-16408acabbfe", com.pulse.mo.TimecardActivity.class);
uuidMap.put("f7222b39-b5f2-440c-a0fd-13671781acd5", com.pulse.mo.TimecardEntry.class);
uuidMap.put("793137c7-bfd5-45b8-84bc-e7752ccf92e5", com.pulse.mo.AdhocCoachingSession.class);
uuidMap.put("35b29a28-7971-4ea8-9e56-c22fbd74c3d5", com.pulse.mo.AdhocTask.class);
uuidMap.put("4d765770-856b-4e78-9bd6-57e079561ca3", com.pulse.mo.Scorecard.class);
uuidMap.put("13f79019-2ff6-446e-88cc-35eee99255ae", com.pulse.mo.AgentScorecard.class);
uuidMap.put("8a7abf06-8ac1-43e5-b307-a6817db2d86c", com.pulse.mo.Attachment.class);
uuidMap.put("7dbb7b30-62c1-41d3-b892-1dd806a9e52a", com.pulse.mo.Behavior.class);
uuidMap.put("ba074a1b-ec07-4d47-9d06-e4e437f6939b", com.pulse.mo.BehaviorResponse.class);
uuidMap.put("0d343245-49e7-4b47-9240-b0a494abd0bc", com.pulse.mo.Client.class);
uuidMap.put("b54990f3-69bd-444a-8b2e-f00de4c152c3", com.pulse.mo.CoachingSession.class);
uuidMap.put("bc990a84-1472-4164-a303-2a33b34fd975", com.pulse.mo.CorrectiveAction.class);
uuidMap.put("4b71a536-2197-410e-a8f8-da86421d35cd", com.pulse.mo.DevelopmentActivity.class);
uuidMap.put("508293a0-7299-4b45-ad3c-35143a48419d", com.pulse.mo.Email.class);
uuidMap.put("c2ff5843-9613-496f-a76d-d9294fb7adc9", com.pulse.mo.GeneralComment.class);
uuidMap.put("e273998e-3c38-45bb-9428-43abf9b589b7", com.pulse.mo.LOBConfigurationEntry.class);
uuidMap.put("a16f7c2f-6ad9-4b0a-af63-5686d1e9f374", com.pulse.mo.Observation.class);
uuidMap.put("e29b4c6f-7454-48f3-a22f-41601f60462b", com.pulse.mo.TeamLeader.class);
uuidMap.put("4e00b3a0-e45f-41f0-8f98-8fc759b34412", com.pulse.mo.PulseUser.class);
uuidMap.put("27dde243-82c9-4a07-bb4c-36218a5685da", com.pulse.mo.QualityEvaluation.class);
uuidMap.put("5768391e-8bdb-4d62-b669-9faa84ae24da", com.pulse.mo.ScheduledTime.class);
uuidMap.put("e0c0bcbd-8238-439d-8284-3de7d4c3d83f", com.pulse.mo.ScheduledTimeEntry.class);
uuidMap.put("c77ec289-9404-46f6-a742-9bfb37d0c8b3", com.pulse.mo.ScorecardMeasure.class);
uuidMap.put("12c8a90e-afbf-4da5-96f2-083c539fc0b8", com.pulse.mo.Setting.class);
uuidMap.put("546eb630-7e01-4104-a2fb-048c329e5a00", com.pulse.mo.Supervisor.class);
uuidMap.put("7ea3e0d2-2356-46f2-8b44-f8b6839b7672", com.pulse.mo.TeamLeaderAction.class);
uuidMap.put("4facf913-2c3c-42d5-b83b-36c907888d00", com.pulse.mo.TeamLeaderImpersonation.class);
uuidMap.put("223708e2-eb7f-49c4-88cc-c7d1cc3bacf7", com.pulse.mo.ThresholdLevel.class);
uuidMap.put("72fe5f64-73f3-4383-9a83-887a6d39f9f7", com.pulse.mo.TraceEntry.class);
uuidMap.put("ee68e7df-f64b-4f50-b1e5-0ffe76d4af96", com.pulse.mo.UserRole.class);
uuidMap.put("74d13932-b836-40ef-8eed-d9c919127963", com.pulse.mo.UserSession.class);
uuidMap.put("be2e3b31-3592-424d-bbfc-a11fc7de13d3", com.pulse.mo.ChangesNotApprovedNotification.class);
uuidMap.put("f9b4bd26-957c-4fe3-9d9f-325133b1f788", com.pulse.mo.CoachingNotification.class);

		}
		return uuidMap;
	}

}