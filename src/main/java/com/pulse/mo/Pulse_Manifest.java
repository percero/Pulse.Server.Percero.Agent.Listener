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
			classList.add(com.pulse.mo.ActivityType.class);
classList.add(com.pulse.mo.Admin.class);
classList.add(com.pulse.mo.Notification.class);
classList.add(com.pulse.mo.Agent.class);
classList.add(com.pulse.mo.LOB.class);
classList.add(com.pulse.mo.LOBConfiguration.class);
classList.add(com.pulse.mo.LOBConfigurationNotification.class);
classList.add(com.pulse.mo.DiscrepancyDetectedNotification.class);
classList.add(com.pulse.mo.DurationMismatchNotification.class);
classList.add(com.pulse.mo.ThresholdExceededNotification.class);
classList.add(com.pulse.mo.DurationToleranceNotification.class);
classList.add(com.pulse.mo.InvalidActivityCodeNotification.class);
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
classList.add(com.pulse.mo.ScorecardState.class);
classList.add(com.pulse.mo.ServerCall.class);
classList.add(com.pulse.mo.ThresholdScale.class);
classList.add(com.pulse.mo.TraceLog.class);
classList.add(com.pulse.mo.WorkDurationNotification.class);
classList.add(com.pulse.mo.WorkModeOccurrenceNotification.class);
classList.add(com.pulse.mo.ActualTime.class);
classList.add(com.pulse.mo.ActualTimeEntry.class);
classList.add(com.pulse.mo.AdhocCoachingCategory.class);
classList.add(com.pulse.mo.AdhocCoachingSession.class);
classList.add(com.pulse.mo.AdhocTask.class);
classList.add(com.pulse.mo.AdhocTaskState.class);
classList.add(com.pulse.mo.AgentTime.class);
classList.add(com.pulse.mo.AgentTimeEntry.class);
classList.add(com.pulse.mo.AppAction.class);
classList.add(com.pulse.mo.Attachment.class);
classList.add(com.pulse.mo.AuxMode.class);
classList.add(com.pulse.mo.Behavior.class);
classList.add(com.pulse.mo.Client.class);
classList.add(com.pulse.mo.CoachingSession.class);
classList.add(com.pulse.mo.CoachingSessionMeasure.class);
classList.add(com.pulse.mo.CoachingSessionState.class);
classList.add(com.pulse.mo.ConnectedState.class);
classList.add(com.pulse.mo.ManagerApproval.class);
classList.add(com.pulse.mo.SupervisorAcknowledgement.class);
classList.add(com.pulse.mo.HRApproval.class);
classList.add(com.pulse.mo.EmployeeAcknowledgement.class);
classList.add(com.pulse.mo.CorrectiveAction.class);
classList.add(com.pulse.mo.CorrectiveActionState.class);
classList.add(com.pulse.mo.CorrectiveActionType.class);
classList.add(com.pulse.mo.Credential.class);
classList.add(com.pulse.mo.CVGProject.class);
classList.add(com.pulse.mo.Dashboard.class);
classList.add(com.pulse.mo.DevelopmentActivity.class);
classList.add(com.pulse.mo.Email.class);
classList.add(com.pulse.mo.EStartActivityCode.class);
classList.add(com.pulse.mo.GeneralComment.class);
classList.add(com.pulse.mo.LOBConfigurationEntry.class);
classList.add(com.pulse.mo.Observation.class);
classList.add(com.pulse.mo.TeamLeader.class);
classList.add(com.pulse.mo.PulseUser.class);
classList.add(com.pulse.mo.QualityEvaluation.class);
classList.add(com.pulse.mo.ScheduledActivityCode.class);
classList.add(com.pulse.mo.ScheduledTime.class);
classList.add(com.pulse.mo.ScheduledTimeEntry.class);
classList.add(com.pulse.mo.Scorecard.class);
classList.add(com.pulse.mo.Setting.class);
classList.add(com.pulse.mo.Site.class);
classList.add(com.pulse.mo.Supervisor.class);
classList.add(com.pulse.mo.TeamLeaderAction.class);
classList.add(com.pulse.mo.TeamLeaderImpersonation.class);
classList.add(com.pulse.mo.ThresholdGradeScale.class);
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
			objectList.add(new com.pulse.mo.ActivityType());
objectList.add(new com.pulse.mo.Admin());
objectList.add(new com.pulse.mo.Notification());
objectList.add(new com.pulse.mo.Agent());
objectList.add(new com.pulse.mo.LOB());
objectList.add(new com.pulse.mo.LOBConfiguration());
objectList.add(new com.pulse.mo.LOBConfigurationNotification());
objectList.add(new com.pulse.mo.DiscrepancyDetectedNotification());
objectList.add(new com.pulse.mo.DurationMismatchNotification());
objectList.add(new com.pulse.mo.ThresholdExceededNotification());
objectList.add(new com.pulse.mo.DurationToleranceNotification());
objectList.add(new com.pulse.mo.InvalidActivityCodeNotification());
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
objectList.add(new com.pulse.mo.ScorecardState());
objectList.add(new com.pulse.mo.ServerCall());
objectList.add(new com.pulse.mo.ThresholdScale());
objectList.add(new com.pulse.mo.TraceLog());
objectList.add(new com.pulse.mo.WorkDurationNotification());
objectList.add(new com.pulse.mo.WorkModeOccurrenceNotification());
objectList.add(new com.pulse.mo.ActualTime());
objectList.add(new com.pulse.mo.ActualTimeEntry());
objectList.add(new com.pulse.mo.AdhocCoachingCategory());
objectList.add(new com.pulse.mo.AdhocCoachingSession());
objectList.add(new com.pulse.mo.AdhocTask());
objectList.add(new com.pulse.mo.AdhocTaskState());
objectList.add(new com.pulse.mo.AgentTime());
objectList.add(new com.pulse.mo.AgentTimeEntry());
objectList.add(new com.pulse.mo.AppAction());
objectList.add(new com.pulse.mo.Attachment());
objectList.add(new com.pulse.mo.AuxMode());
objectList.add(new com.pulse.mo.Behavior());
objectList.add(new com.pulse.mo.Client());
objectList.add(new com.pulse.mo.CoachingSession());
objectList.add(new com.pulse.mo.CoachingSessionMeasure());
objectList.add(new com.pulse.mo.CoachingSessionState());
objectList.add(new com.pulse.mo.ConnectedState());
objectList.add(new com.pulse.mo.ManagerApproval());
objectList.add(new com.pulse.mo.SupervisorAcknowledgement());
objectList.add(new com.pulse.mo.HRApproval());
objectList.add(new com.pulse.mo.EmployeeAcknowledgement());
objectList.add(new com.pulse.mo.CorrectiveAction());
objectList.add(new com.pulse.mo.CorrectiveActionState());
objectList.add(new com.pulse.mo.CorrectiveActionType());
objectList.add(new com.pulse.mo.Credential());
objectList.add(new com.pulse.mo.CVGProject());
objectList.add(new com.pulse.mo.Dashboard());
objectList.add(new com.pulse.mo.DevelopmentActivity());
objectList.add(new com.pulse.mo.Email());
objectList.add(new com.pulse.mo.EStartActivityCode());
objectList.add(new com.pulse.mo.GeneralComment());
objectList.add(new com.pulse.mo.LOBConfigurationEntry());
objectList.add(new com.pulse.mo.Observation());
objectList.add(new com.pulse.mo.TeamLeader());
objectList.add(new com.pulse.mo.PulseUser());
objectList.add(new com.pulse.mo.QualityEvaluation());
objectList.add(new com.pulse.mo.ScheduledActivityCode());
objectList.add(new com.pulse.mo.ScheduledTime());
objectList.add(new com.pulse.mo.ScheduledTimeEntry());
objectList.add(new com.pulse.mo.Scorecard());
objectList.add(new com.pulse.mo.Setting());
objectList.add(new com.pulse.mo.Site());
objectList.add(new com.pulse.mo.Supervisor());
objectList.add(new com.pulse.mo.TeamLeaderAction());
objectList.add(new com.pulse.mo.TeamLeaderImpersonation());
objectList.add(new com.pulse.mo.ThresholdGradeScale());
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
			uuidMap.put("5d44164a-6f5a-4185-9ac8-961fbfc7c60c", com.pulse.mo.ActivityType.class);
uuidMap.put("4e3d5dac-671d-45c8-b824-5d7fcb1bca2f", com.pulse.mo.Admin.class);
uuidMap.put("ec20861d-1022-41cc-a469-4ff21814f55a", com.pulse.mo.Notification.class);
uuidMap.put("93d492f7-a5ec-4ed2-888c-85a5e22c5043", com.pulse.mo.Agent.class);
uuidMap.put("6611512a-17e0-4482-bc84-69e611af741e", com.pulse.mo.LOB.class);
uuidMap.put("e9e11b0d-7862-4515-b5e9-7799d0df63aa", com.pulse.mo.LOBConfiguration.class);
uuidMap.put("8dc8285c-8ee7-417c-897c-aafec2303f06", com.pulse.mo.LOBConfigurationNotification.class);
uuidMap.put("7753cf5e-1754-45df-899b-7c68ff07ca7b", com.pulse.mo.DiscrepancyDetectedNotification.class);
uuidMap.put("586c4b46-a413-43fa-97a8-b7f53341d807", com.pulse.mo.DurationMismatchNotification.class);
uuidMap.put("d1f570ff-5a47-4c25-9a6c-3520f3c1c0dd", com.pulse.mo.ThresholdExceededNotification.class);
uuidMap.put("01a5b62e-5727-4e80-890e-fdd56d52883b", com.pulse.mo.DurationToleranceNotification.class);
uuidMap.put("c57cf091-cea2-4ec6-a47c-1f30993e1f76", com.pulse.mo.InvalidActivityCodeNotification.class);
uuidMap.put("52635b24-94f2-4421-830a-fc1620bb0ba6", com.pulse.mo.NonBillableActivityNotification.class);
uuidMap.put("269b42bf-d386-4b05-a72e-24454c8e0e0c", com.pulse.mo.Alert.class);
uuidMap.put("ac5760a8-fb06-4b38-8377-bbd9fcbcdb43", com.pulse.mo.NotificationAlert.class);
uuidMap.put("6c456d89-d5ac-46a0-9a9b-93b70e5f38f3", com.pulse.mo.NotificationFrequency.class);
uuidMap.put("ee0103f5-30fa-42e0-8258-8a54f3d19d84", com.pulse.mo.OccurrenceMismatchNotification.class);
uuidMap.put("5946faf0-7ea9-4192-a7e9-1676b438c2e8", com.pulse.mo.OccurrenceToleranceNotification.class);
uuidMap.put("f096eaec-77f4-4e40-98d2-fa95638af3b4", com.pulse.mo.PayrollDetail.class);
uuidMap.put("9a61465c-0d4d-4ecc-b196-ad3df7afa26b", com.pulse.mo.PerformanceSummary.class);
uuidMap.put("e6376bb3-8418-45f6-a784-5deaf1222698", com.pulse.mo.PulseConfiguration.class);
uuidMap.put("2074d43f-ba94-41ea-8539-4bb10209af43", com.pulse.mo.Role.class);
uuidMap.put("e9cdbf0b-508d-4fec-b6db-4e0526bc43f2", com.pulse.mo.ScorecardState.class);
uuidMap.put("d8e61f3b-0247-4061-8b4d-8b840ea2cadf", com.pulse.mo.ServerCall.class);
uuidMap.put("4cb2412c-44e0-4da0-af03-11266a21808f", com.pulse.mo.ThresholdScale.class);
uuidMap.put("78da24c6-1250-454c-9455-9f80e39b424d", com.pulse.mo.TraceLog.class);
uuidMap.put("c7e4e753-e1a6-44f6-8d1e-6192120e39a6", com.pulse.mo.WorkDurationNotification.class);
uuidMap.put("87232955-d878-4249-a443-ddc15946f7cc", com.pulse.mo.WorkModeOccurrenceNotification.class);
uuidMap.put("7b8f7f47-3c31-4d85-b74e-3580d5cb62d4", com.pulse.mo.ActualTime.class);
uuidMap.put("16d31580-e218-42bc-8f90-2ac1455a3b0b", com.pulse.mo.ActualTimeEntry.class);
uuidMap.put("5ec27cf2-6ae9-4dc3-94e3-122bc2282478", com.pulse.mo.AdhocCoachingCategory.class);
uuidMap.put("92e02ae7-cda2-473e-8429-82b222a8f26a", com.pulse.mo.AdhocCoachingSession.class);
uuidMap.put("1daeef1d-bda0-4adc-864e-1c17d283024f", com.pulse.mo.AdhocTask.class);
uuidMap.put("7e8f7fb2-3cb5-4d54-99cb-0888c0af464f", com.pulse.mo.AdhocTaskState.class);
uuidMap.put("0590d82a-21ba-4fb9-8224-fa00e97c9c51", com.pulse.mo.AgentTime.class);
uuidMap.put("1f5df635-d6d9-4c1b-b11d-06d122deb5cb", com.pulse.mo.AgentTimeEntry.class);
uuidMap.put("eee80efe-f21e-4549-a52d-31132c661f55", com.pulse.mo.AppAction.class);
uuidMap.put("8115bb26-2af7-428a-b450-be4db93155b9", com.pulse.mo.Attachment.class);
uuidMap.put("f2b506ee-d546-4616-8249-21074742831b", com.pulse.mo.AuxMode.class);
uuidMap.put("349680f2-8441-4cf6-92b4-84338bcf49e7", com.pulse.mo.Behavior.class);
uuidMap.put("a3eed438-2e42-4708-b512-66f0da09c844", com.pulse.mo.Client.class);
uuidMap.put("abb8a1c1-f4b9-44a7-be57-69f7a0360da7", com.pulse.mo.CoachingSession.class);
uuidMap.put("718aa868-546b-4e6d-ad3f-1fb032568ec4", com.pulse.mo.CoachingSessionMeasure.class);
uuidMap.put("39b8fbcd-98c1-4f79-8f46-b4e036183f6a", com.pulse.mo.CoachingSessionState.class);
uuidMap.put("9def290e-a773-4c4b-9433-1d21a083dc2b", com.pulse.mo.ConnectedState.class);
uuidMap.put("8f55c314-f7b0-44a9-9d6a-178112aa8c4b", com.pulse.mo.ManagerApproval.class);
uuidMap.put("471dc1f4-1e7c-421b-b9bf-b4961802bc6f", com.pulse.mo.SupervisorAcknowledgement.class);
uuidMap.put("b12a91cb-cd0e-4392-a1d9-f99e05266578", com.pulse.mo.HRApproval.class);
uuidMap.put("6d236a15-1609-401b-9dc2-32a08909351b", com.pulse.mo.EmployeeAcknowledgement.class);
uuidMap.put("5e268989-5697-4c9a-8462-67064ea48541", com.pulse.mo.CorrectiveAction.class);
uuidMap.put("9a9ffb5f-ca80-47ad-a367-e88783f25b66", com.pulse.mo.CorrectiveActionState.class);
uuidMap.put("8f17df5a-d939-4318-b29b-b967d64bb84e", com.pulse.mo.CorrectiveActionType.class);
uuidMap.put("ed5f9cfe-423c-4a9e-b8b1-83610c05d74a", com.pulse.mo.Credential.class);
uuidMap.put("c88ad69b-ea8c-4d7f-9b3f-eae7fed6e128", com.pulse.mo.CVGProject.class);
uuidMap.put("158244eb-dc3d-4e44-b8b5-21465b260837", com.pulse.mo.Dashboard.class);
uuidMap.put("76473c2e-a804-4ac3-a499-c4b8a25f14a3", com.pulse.mo.DevelopmentActivity.class);
uuidMap.put("961c5cd6-2292-47d2-a3b0-ca78efe7813f", com.pulse.mo.Email.class);
uuidMap.put("baca77be-8240-49cf-be5b-175560484f57", com.pulse.mo.EStartActivityCode.class);
uuidMap.put("1f28a4b0-0dfb-4536-9c2b-68a64c581e45", com.pulse.mo.GeneralComment.class);
uuidMap.put("810c7c63-80d9-4a35-b0e0-e86f331915de", com.pulse.mo.LOBConfigurationEntry.class);
uuidMap.put("ca47fad8-c20e-48df-ad59-d7c28e86fc39", com.pulse.mo.Observation.class);
uuidMap.put("f4990919-3995-4bfd-a3d2-16f70b955590", com.pulse.mo.TeamLeader.class);
uuidMap.put("4e430da3-04f1-47f8-a044-0d4133432d54", com.pulse.mo.PulseUser.class);
uuidMap.put("704bf861-a5b3-46a2-a747-b693a7b206fe", com.pulse.mo.QualityEvaluation.class);
uuidMap.put("a569ca6f-49af-4c74-bd82-54c58fa43170", com.pulse.mo.ScheduledActivityCode.class);
uuidMap.put("99c79842-71d4-4df3-9fdd-835460f43d66", com.pulse.mo.ScheduledTime.class);
uuidMap.put("e26bcdae-6b23-43da-a438-0d497841c230", com.pulse.mo.ScheduledTimeEntry.class);
uuidMap.put("d1dd5489-afbb-47bc-8df8-4af8b5a57055", com.pulse.mo.Scorecard.class);
uuidMap.put("de60375b-1442-439b-af3a-db7d455e7ed7", com.pulse.mo.Setting.class);
uuidMap.put("39753975-f9d9-4d8e-b3f7-6d63154b04ab", com.pulse.mo.Site.class);
uuidMap.put("b904a9d1-6887-4f3d-8bf4-df62b32aca29", com.pulse.mo.Supervisor.class);
uuidMap.put("8df52fed-7e3d-45b7-b581-1c1a1a07324c", com.pulse.mo.TeamLeaderAction.class);
uuidMap.put("1d3e7753-87b8-4524-8123-f705127ba0a6", com.pulse.mo.TeamLeaderImpersonation.class);
uuidMap.put("9c9b761b-e66c-45ea-b2f1-892788872fd6", com.pulse.mo.ThresholdGradeScale.class);
uuidMap.put("1833960b-0145-4a30-bf61-7a0ec6bf5090", com.pulse.mo.ThresholdLevel.class);
uuidMap.put("999e5ed8-5ed0-46b6-8b15-6c6a48794903", com.pulse.mo.TraceEntry.class);
uuidMap.put("d1761494-fbd3-4b59-a6a5-2c308c40640a", com.pulse.mo.UserRole.class);
uuidMap.put("d76dbc27-543f-4bcd-9f49-6b24b7a95019", com.pulse.mo.UserSession.class);
uuidMap.put("88f40fd9-d0f3-4e6d-8e50-7fda06a9031e", com.pulse.mo.ChangesNotApprovedNotification.class);
uuidMap.put("c2984b7d-cc61-4333-9d0c-7f481b00c9a0", com.pulse.mo.CoachingNotification.class);

		}
		return uuidMap;
	}

}