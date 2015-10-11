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
			uuidMap.put("5fffafad-2705-4b8c-b2df-afb948db60f3", com.pulse.mo.CMSAuxMode.class);
uuidMap.put("c3929b8b-13a6-41d1-b1cf-a977cb13c88e", com.pulse.mo.AdhocCoachingCategory.class);
uuidMap.put("b36c6e32-18ba-4a01-a71e-41931d0c5fad", com.pulse.mo.AdhocTaskState.class);
uuidMap.put("d4794ebb-edf4-4721-b373-ad32eb816cfb", com.pulse.mo.CoachingSessionState.class);
uuidMap.put("ad19892f-d0f2-49be-84e7-a68e1f0c62e6", com.pulse.mo.CorrectiveActionState.class);
uuidMap.put("6af93964-ebd1-4afc-ae65-54a05195bf20", com.pulse.mo.CorrectiveActionType.class);
uuidMap.put("3c756be8-6a26-405c-8d34-acc160ea0526", com.pulse.mo.CVGProject.class);
uuidMap.put("37c27f3b-e7a4-4fe8-a80d-d9822469c98f", com.pulse.mo.Notification.class);
uuidMap.put("421aefd5-72df-40c6-a634-008d22e6f7e6", com.pulse.mo.Agent.class);
uuidMap.put("95800ba0-591e-4de5-93dc-2491b7ca255a", com.pulse.mo.LOB.class);
uuidMap.put("c3fc7b43-f8d0-4d41-a86b-c4035cd887dc", com.pulse.mo.LOBConfiguration.class);
uuidMap.put("1f0dece3-8815-4847-9dc4-92f91c91db88", com.pulse.mo.LOBConfigurationNotification.class);
uuidMap.put("eeb50674-537b-48ae-afe5-f2eb46566ad8", com.pulse.mo.DiscrepancyDetectedNotification.class);
uuidMap.put("c1d0679d-a753-4e5a-9065-f212f10604b3", com.pulse.mo.DurationMismatchNotification.class);
uuidMap.put("6049fcc9-6cc5-4e3d-9d10-21c249e13b7d", com.pulse.mo.ThresholdExceededNotification.class);
uuidMap.put("347ae6f9-139c-43ad-a34a-0bdc76577ee1", com.pulse.mo.DurationToleranceNotification.class);
uuidMap.put("16240c00-4284-438f-8e77-ad7d719e19cb", com.pulse.mo.EmployeeAcknowledgement.class);
uuidMap.put("33944489-7167-4f1d-8ca9-f5e1dda6d461", com.pulse.mo.HRApproval.class);
uuidMap.put("e2aed0fa-9961-4ffa-867d-e6f2eaf89740", com.pulse.mo.InvalidActivityCodeNotification.class);
uuidMap.put("3600bf7f-7f68-49df-969c-52cbead4e0dd", com.pulse.mo.ManagerApproval.class);
uuidMap.put("e48bf429-05e2-49c1-8d62-a565497df1d4", com.pulse.mo.Measure.class);
uuidMap.put("e2fd818d-de78-42f1-aa72-f3fbc03d2196", com.pulse.mo.NonBillableActivityNotification.class);
uuidMap.put("1934bacb-c6ba-47b3-af19-b5ff207d83ef", com.pulse.mo.Alert.class);
uuidMap.put("e363faf3-0445-4956-a1c7-36db564fe26d", com.pulse.mo.NotificationAlert.class);
uuidMap.put("df05cb4a-6ca2-4b60-a4f1-9789ba316c89", com.pulse.mo.NotificationFrequency.class);
uuidMap.put("218c3aa8-378b-42cb-bed4-6aa15869ef4d", com.pulse.mo.OccurrenceMismatchNotification.class);
uuidMap.put("4fd2e30d-0146-4bcd-b6fe-b13e23cd3eac", com.pulse.mo.OccurrenceToleranceNotification.class);
uuidMap.put("5eff2dc4-364d-40cb-b591-ec97e9411afe", com.pulse.mo.PayrollDetail.class);
uuidMap.put("9d9ed344-d25d-47b5-bc3f-9cb4b5df04aa", com.pulse.mo.PerformanceSummary.class);
uuidMap.put("16a8abe2-51c3-474b-b9a4-7ddd5ddc329c", com.pulse.mo.PulseConfiguration.class);
uuidMap.put("d5588405-e501-4294-84d7-8ba2f3afb17d", com.pulse.mo.Role.class);
uuidMap.put("e4c8f547-969f-4627-9331-432dd57b4a4b", com.pulse.mo.ScheduledActivityCode.class);
uuidMap.put("71baaed4-f20f-4ca5-aa41-fa0a8b2639b2", com.pulse.mo.ScheduledActivityType.class);
uuidMap.put("18e80852-1eef-42d5-9c0b-2b5e98e277f1", com.pulse.mo.Scorecard.class);
uuidMap.put("5ed3c126-763a-4596-b9ed-358058c8d51d", com.pulse.mo.Site.class);
uuidMap.put("cea50366-2991-437a-9546-f7e7addffff6", com.pulse.mo.SupervisorAcknowledgement.class);
uuidMap.put("e7807b3e-c3eb-4eb9-abf6-4be2db967fd0", com.pulse.mo.ThresholdGradeScale.class);
uuidMap.put("dc07d183-ec27-4f32-ba99-d6b64282c26e", com.pulse.mo.ThresholdScale.class);
uuidMap.put("bd34aa64-24e3-441f-bdb1-3b6f41025889", com.pulse.mo.TraceLog.class);
uuidMap.put("fad1756b-9456-4f7c-8f98-b136350b8880", com.pulse.mo.WorkDurationNotification.class);
uuidMap.put("e924d7d2-7f4f-4326-8ffe-9152045d3d42", com.pulse.mo.WorkModeOccurrenceNotification.class);
uuidMap.put("b7fd5fc8-a09f-4a8b-bdf4-547172fd88fd", com.pulse.mo.Client.class);
uuidMap.put("78ecce48-7f26-4562-8a59-fe87b3ae309d", com.pulse.mo.CMSEntry.class);
uuidMap.put("24399344-a0f9-4d4f-894d-0077c43a5605", com.pulse.mo.Timecard.class);
uuidMap.put("582aebd4-6cf1-44c5-a891-71c8d3b00dea", com.pulse.mo.TimecardActivity.class);
uuidMap.put("bf4f2df0-8ae1-46e0-90d9-8705cf3d57e5", com.pulse.mo.TimecardEntry.class);
uuidMap.put("b14835a6-5468-425d-abe5-d490ba89d2a8", com.pulse.mo.AdhocCoachingSession.class);
uuidMap.put("9150f1b0-75bf-4ef2-a1e5-d52a57515cbc", com.pulse.mo.AdhocTask.class);
uuidMap.put("e42c7f19-4d5d-4f67-aa02-33b6993cb0dd", com.pulse.mo.AgentScorecard.class);
uuidMap.put("99b8f045-58fa-4deb-a26b-7530cd54144b", com.pulse.mo.Behavior.class);
uuidMap.put("a361c1a5-c5d1-454c-82ea-87e1ed3ab9c1", com.pulse.mo.BehaviorResponse.class);
uuidMap.put("d14204a2-6edd-486d-89be-9a3d532f5e8f", com.pulse.mo.CoachingComment.class);
uuidMap.put("504f2bce-afdf-40ea-80aa-2734a8a33839", com.pulse.mo.CoachingSession.class);
uuidMap.put("6297f93b-3149-441a-b96a-f50252ceb6e5", com.pulse.mo.CoachingSessionAttachment.class);
uuidMap.put("16b1ef54-90a3-4d05-ace6-7f309639426a", com.pulse.mo.CorrectiveAction.class);
uuidMap.put("d09ca056-bf95-4d77-986a-db73cf501943", com.pulse.mo.DevelopmentActivity.class);
uuidMap.put("8c2f8ea1-bc4a-4ddf-88e1-02929385d13b", com.pulse.mo.DevelopmentPlan.class);
uuidMap.put("ad15d8af-348e-4ffe-8cbe-c4aab475d0f6", com.pulse.mo.Email.class);
uuidMap.put("41db504f-a60e-4f6f-b692-b202a169bcc5", com.pulse.mo.GeneralComment.class);
uuidMap.put("a58bf620-14e7-4b10-b0fb-38a34a442d31", com.pulse.mo.LOBConfigurationEntry.class);
uuidMap.put("3d96a6fa-b879-4588-b171-b4270b33e979", com.pulse.mo.Observation.class);
uuidMap.put("ab0b5886-344c-4716-ad24-ee35168ea414", com.pulse.mo.TeamLeader.class);
uuidMap.put("e5e2ea83-ebdc-43ae-b9f8-ebed90466ef7", com.pulse.mo.PulseUser.class);
uuidMap.put("856727d5-8e5e-4815-9460-0a7f5488f7c6", com.pulse.mo.QualityEvaluation.class);
uuidMap.put("81cbda4c-8895-4558-a230-be778128d075", com.pulse.mo.ScheduledTime.class);
uuidMap.put("cef80f9b-86b7-480e-9f79-83dd060b86cb", com.pulse.mo.ScheduledTimeEntry.class);
uuidMap.put("ab72ea21-fcc3-45ab-9fea-c1ad7ebecdb1", com.pulse.mo.ScorecardMeasure.class);
uuidMap.put("fbfb3a09-a221-40af-8b6c-89637ced3191", com.pulse.mo.Setting.class);
uuidMap.put("dc06dd2e-32f3-42a8-af7a-0bfcaa1b0e69", com.pulse.mo.Supervisor.class);
uuidMap.put("a9a5975c-a418-49b2-8896-ef12ab23c8ff", com.pulse.mo.TeamLeaderImpersonation.class);
uuidMap.put("eec9b144-7eaf-4a91-95cc-86234d820a2c", com.pulse.mo.ThresholdLevel.class);
uuidMap.put("205b9a76-4171-414c-afb8-21caa4a3c861", com.pulse.mo.TraceEntry.class);
uuidMap.put("ade26047-d5ac-48c4-9a15-4d79c7e8726a", com.pulse.mo.UserRole.class);
uuidMap.put("13d6f3d5-ee04-40e4-82b9-82de47de219d", com.pulse.mo.UserSession.class);
uuidMap.put("ab0c6e92-35bc-4e40-a3f3-67446ede268c", com.pulse.mo.ChangesNotApprovedNotification.class);
uuidMap.put("c32fa619-e424-4ce5-a4ae-9394349893d1", com.pulse.mo.CoachingNotification.class);

		}
		return uuidMap;
	}

}