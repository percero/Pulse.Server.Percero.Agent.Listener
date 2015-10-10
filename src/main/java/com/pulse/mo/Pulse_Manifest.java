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
			classList.add(com.pulse.mo.CMSAuxMode.class);
classList.add(com.pulse.mo.AdhocCoachingCategory.class);
classList.add(com.pulse.mo.AdhocTaskState.class);
classList.add(com.pulse.mo.CoachingSessionState.class);
classList.add(com.pulse.mo.CorrectiveActionState.class);
classList.add(com.pulse.mo.CorrectiveActionType.class);
classList.add(com.pulse.mo.CVGProject.class);
classList.add(com.pulse.mo.Notification.class);
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
classList.add(com.pulse.mo.OccurrenceMismatchNotification.class);
classList.add(com.pulse.mo.OccurrenceToleranceNotification.class);
classList.add(com.pulse.mo.PayrollDetail.class);
classList.add(com.pulse.mo.PerformanceSummary.class);
classList.add(com.pulse.mo.PulseConfiguration.class);
classList.add(com.pulse.mo.Role.class);
classList.add(com.pulse.mo.ScheduledActivityCode.class);
classList.add(com.pulse.mo.ScheduledActivityType.class);
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
classList.add(com.pulse.mo.Timecard.class);
classList.add(com.pulse.mo.TimecardActivity.class);
classList.add(com.pulse.mo.TimecardEntry.class);
classList.add(com.pulse.mo.AdhocCoachingSession.class);
classList.add(com.pulse.mo.AdhocTask.class);
classList.add(com.pulse.mo.AgentScorecard.class);
classList.add(com.pulse.mo.Behavior.class);
classList.add(com.pulse.mo.BehaviorResponse.class);
classList.add(com.pulse.mo.CoachingComment.class);
classList.add(com.pulse.mo.CoachingSession.class);
classList.add(com.pulse.mo.CoachingSessionAttachment.class);
classList.add(com.pulse.mo.CorrectiveAction.class);
classList.add(com.pulse.mo.DevelopmentActivity.class);
classList.add(com.pulse.mo.DevelopmentPlan.class);
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
			objectList.add(new com.pulse.mo.CMSAuxMode());
objectList.add(new com.pulse.mo.AdhocCoachingCategory());
objectList.add(new com.pulse.mo.AdhocTaskState());
objectList.add(new com.pulse.mo.CoachingSessionState());
objectList.add(new com.pulse.mo.CorrectiveActionState());
objectList.add(new com.pulse.mo.CorrectiveActionType());
objectList.add(new com.pulse.mo.CVGProject());
objectList.add(new com.pulse.mo.Notification());
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
objectList.add(new com.pulse.mo.OccurrenceMismatchNotification());
objectList.add(new com.pulse.mo.OccurrenceToleranceNotification());
objectList.add(new com.pulse.mo.PayrollDetail());
objectList.add(new com.pulse.mo.PerformanceSummary());
objectList.add(new com.pulse.mo.PulseConfiguration());
objectList.add(new com.pulse.mo.Role());
objectList.add(new com.pulse.mo.ScheduledActivityCode());
objectList.add(new com.pulse.mo.ScheduledActivityType());
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
objectList.add(new com.pulse.mo.Timecard());
objectList.add(new com.pulse.mo.TimecardActivity());
objectList.add(new com.pulse.mo.TimecardEntry());
objectList.add(new com.pulse.mo.AdhocCoachingSession());
objectList.add(new com.pulse.mo.AdhocTask());
objectList.add(new com.pulse.mo.AgentScorecard());
objectList.add(new com.pulse.mo.Behavior());
objectList.add(new com.pulse.mo.BehaviorResponse());
objectList.add(new com.pulse.mo.CoachingComment());
objectList.add(new com.pulse.mo.CoachingSession());
objectList.add(new com.pulse.mo.CoachingSessionAttachment());
objectList.add(new com.pulse.mo.CorrectiveAction());
objectList.add(new com.pulse.mo.DevelopmentActivity());
objectList.add(new com.pulse.mo.DevelopmentPlan());
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
			uuidMap.put("3786c892-4055-4292-94e1-4779b54fbc12", com.pulse.mo.CMSAuxMode.class);
uuidMap.put("f01f1713-5948-422a-a9ad-e76af610e347", com.pulse.mo.AdhocCoachingCategory.class);
uuidMap.put("f09c38ef-983e-40d9-80ae-312a9dd8f9bf", com.pulse.mo.AdhocTaskState.class);
uuidMap.put("14ffe391-62cf-4229-881c-7be74845d5b7", com.pulse.mo.CoachingSessionState.class);
uuidMap.put("f5fa80da-95f0-42d2-9093-870718165116", com.pulse.mo.CorrectiveActionState.class);
uuidMap.put("197cbb96-02c8-4eb9-8da4-bf0761c23d40", com.pulse.mo.CorrectiveActionType.class);
uuidMap.put("dff68676-22f6-451c-83db-e07d55f35bee", com.pulse.mo.CVGProject.class);
uuidMap.put("4ae7ca7c-e7bd-4fcd-9add-2e709c9b1d9c", com.pulse.mo.Notification.class);
uuidMap.put("638b2ce0-f343-48c9-a85e-e6cf45d358e4", com.pulse.mo.Agent.class);
uuidMap.put("41814d71-e561-47f6-a6ee-3c3bfa99bb91", com.pulse.mo.LOB.class);
uuidMap.put("b5219f7f-c08e-4189-bb54-4f89ccd1a24c", com.pulse.mo.LOBConfiguration.class);
uuidMap.put("4738f80f-f134-405d-88ca-8f7ce192d8d5", com.pulse.mo.LOBConfigurationNotification.class);
uuidMap.put("2e5a1446-586e-489f-8b96-2f175cc623fb", com.pulse.mo.DiscrepancyDetectedNotification.class);
uuidMap.put("052f66eb-c087-453e-80c1-e7df09da8799", com.pulse.mo.DurationMismatchNotification.class);
uuidMap.put("694b712f-199a-4ba8-aeca-00172975d60d", com.pulse.mo.ThresholdExceededNotification.class);
uuidMap.put("9218591d-e9fc-4bb8-b329-f0fec4aab652", com.pulse.mo.DurationToleranceNotification.class);
uuidMap.put("ec250f53-ad17-447c-9cab-e9d321e6cbe8", com.pulse.mo.EmployeeAcknowledgement.class);
uuidMap.put("bb2d85c9-b7fc-47a7-9a29-82817c02fe75", com.pulse.mo.HRApproval.class);
uuidMap.put("efc090b8-028f-4f33-ad53-f9416d52b434", com.pulse.mo.InvalidActivityCodeNotification.class);
uuidMap.put("f0ceb120-fb68-4431-85be-17ede7573c4f", com.pulse.mo.ManagerApproval.class);
uuidMap.put("57d56d9f-e9a4-42a2-abf7-a648d9a957e6", com.pulse.mo.Measure.class);
uuidMap.put("47a3b692-30fd-4912-8454-fa12ae060ab9", com.pulse.mo.NonBillableActivityNotification.class);
uuidMap.put("1b43949c-b3d6-42b1-acdb-9be723d446ad", com.pulse.mo.Alert.class);
uuidMap.put("344f984a-9c2b-4eee-abc8-0ec95a9698f2", com.pulse.mo.NotificationAlert.class);
uuidMap.put("5ab4008e-bf69-46df-8675-ea4618ba31c0", com.pulse.mo.NotificationFrequency.class);
uuidMap.put("2fa436e7-7345-4ac9-bd7b-8a7b6807e46f", com.pulse.mo.OccurrenceMismatchNotification.class);
uuidMap.put("7c1f962e-dab3-4637-93b3-73e073cfe144", com.pulse.mo.OccurrenceToleranceNotification.class);
uuidMap.put("e0409b01-357c-4d49-ab12-edbbd9501bb5", com.pulse.mo.PayrollDetail.class);
uuidMap.put("813bc42d-07cb-404d-b0aa-34cc604789da", com.pulse.mo.PerformanceSummary.class);
uuidMap.put("385bf462-32bf-4f49-94bd-b04080537532", com.pulse.mo.PulseConfiguration.class);
uuidMap.put("9ccbcdd6-d257-4af5-ab79-95e9087a3115", com.pulse.mo.Role.class);
uuidMap.put("99e700bb-08b9-4553-9661-facb35902a12", com.pulse.mo.ScheduledActivityCode.class);
uuidMap.put("ed7bf9e2-eb5b-4933-acc4-5a1fe367c73a", com.pulse.mo.ScheduledActivityType.class);
uuidMap.put("3361fae8-abb7-44b2-88df-6686b4d2b6a5", com.pulse.mo.Scorecard.class);
uuidMap.put("d3cb7592-a1c8-4416-bab5-9e341591b221", com.pulse.mo.Site.class);
uuidMap.put("e81d9b17-a09b-4f35-af0b-3556e61b1189", com.pulse.mo.SupervisorAcknowledgement.class);
uuidMap.put("1632a2c7-5454-4d16-b5c4-d0f2a52f2b31", com.pulse.mo.ThresholdGradeScale.class);
uuidMap.put("6cd8a63b-4e68-4a8c-a1a8-3d0347fa3339", com.pulse.mo.ThresholdScale.class);
uuidMap.put("6820d109-c236-42ae-8e4d-79ce97b2db37", com.pulse.mo.TraceLog.class);
uuidMap.put("c327df3a-357b-4bc7-ba93-ee22d16f9bf2", com.pulse.mo.WorkDurationNotification.class);
uuidMap.put("de778fc0-4994-481c-8e16-ae157358f12f", com.pulse.mo.WorkModeOccurrenceNotification.class);
uuidMap.put("e34259c8-418f-4f40-8648-0e0575f29330", com.pulse.mo.Client.class);
uuidMap.put("638ad474-545e-4032-b5bc-9d1c4cb1a51a", com.pulse.mo.CMSEntry.class);
uuidMap.put("7383581f-9b18-40c8-8d3c-e9e139ed17c2", com.pulse.mo.Timecard.class);
uuidMap.put("316a77d4-bec6-4474-9a64-87a867130cd9", com.pulse.mo.TimecardActivity.class);
uuidMap.put("5dd19f53-9a48-479e-b12d-04c9dbacfae5", com.pulse.mo.TimecardEntry.class);
uuidMap.put("20fea5f6-ac06-4aa3-8413-126721cb723c", com.pulse.mo.AdhocCoachingSession.class);
uuidMap.put("47ccddb9-bef2-4ff7-9ed5-ab1d09ea0be2", com.pulse.mo.AdhocTask.class);
uuidMap.put("b13dfe03-7db1-4723-ab55-93def26310d3", com.pulse.mo.AgentScorecard.class);
uuidMap.put("841657f9-f9af-4616-bf2e-13b32a55fa62", com.pulse.mo.Behavior.class);
uuidMap.put("f96fc88d-661c-48f5-8f67-8c5989e3b17d", com.pulse.mo.BehaviorResponse.class);
uuidMap.put("c1545a72-62fd-45f8-b028-f38b3a0400a3", com.pulse.mo.CoachingComment.class);
uuidMap.put("92e56766-84ab-48c6-a4b4-864da6c1f4d2", com.pulse.mo.CoachingSession.class);
uuidMap.put("68a8d0e5-1f34-4cfa-9f82-cabe84cadbc7", com.pulse.mo.CoachingSessionAttachment.class);
uuidMap.put("759ffe77-e0ba-4657-a868-6428486b83e8", com.pulse.mo.CorrectiveAction.class);
uuidMap.put("27e6536d-a44f-4322-8719-c291b7d503b7", com.pulse.mo.DevelopmentActivity.class);
uuidMap.put("924c5eb2-ddf6-45c8-9d1f-82378b72698e", com.pulse.mo.DevelopmentPlan.class);
uuidMap.put("1a06dfb9-1262-4fb3-922b-ad7d8d78e4b3", com.pulse.mo.Email.class);
uuidMap.put("325ef2ab-68a1-48d1-ae45-33c9b83b1f7c", com.pulse.mo.GeneralComment.class);
uuidMap.put("47dd190c-1c38-4b84-90de-3f3d5ed49fba", com.pulse.mo.LOBConfigurationEntry.class);
uuidMap.put("6d0c5bd3-5925-46c6-a87d-8354a03238ee", com.pulse.mo.Observation.class);
uuidMap.put("4e674262-ef91-4085-a218-0df8dfce8226", com.pulse.mo.TeamLeader.class);
uuidMap.put("885fb191-59f5-481c-9b91-bc6eb84bfe61", com.pulse.mo.PulseUser.class);
uuidMap.put("bb4504a3-0353-43fa-b2e1-e597118d246a", com.pulse.mo.QualityEvaluation.class);
uuidMap.put("ff27be5f-9b8b-4d9b-94e0-1a9318e76226", com.pulse.mo.ScheduledTime.class);
uuidMap.put("738b9a41-886a-4d15-96d6-4d1c6beee081", com.pulse.mo.ScheduledTimeEntry.class);
uuidMap.put("efd2ea81-3658-47eb-ac7b-7e0d71f0fcf6", com.pulse.mo.ScorecardMeasure.class);
uuidMap.put("e851b870-b44c-4650-b81c-9aa0f004abdd", com.pulse.mo.Setting.class);
uuidMap.put("8f8c3145-8108-4e23-9aab-8ddae0af6120", com.pulse.mo.Supervisor.class);
uuidMap.put("0f37d014-ad45-4c53-baff-266368058c34", com.pulse.mo.TeamLeaderImpersonation.class);
uuidMap.put("317967b4-ceec-437b-ada7-3f3aa5d6b3ef", com.pulse.mo.ThresholdLevel.class);
uuidMap.put("b7a56895-50d3-4d36-b5e3-789ca932561e", com.pulse.mo.TraceEntry.class);
uuidMap.put("66a4a000-626a-478a-ad86-2c2806163f0b", com.pulse.mo.UserRole.class);
uuidMap.put("05b87455-80ba-4111-b666-b77b82ed2259", com.pulse.mo.UserSession.class);
uuidMap.put("e0e73cae-8170-4da7-ab2b-ff90f8c86600", com.pulse.mo.ChangesNotApprovedNotification.class);
uuidMap.put("7257ee32-0948-46ca-a412-711c7575acb7", com.pulse.mo.CoachingNotification.class);

		}
		return uuidMap;
	}

}