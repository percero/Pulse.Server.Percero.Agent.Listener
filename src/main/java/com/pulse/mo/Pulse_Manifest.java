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
			uuidMap.put("849fef0e-d5c2-4bc2-82bb-2848ec773d24", com.pulse.mo.CMSAuxMode.class);
uuidMap.put("d2fffb0d-0074-4c68-ba31-7d4e481a89ac", com.pulse.mo.AdhocCoachingCategory.class);
uuidMap.put("fd0d7075-927c-480c-a23e-9ab6074b11db", com.pulse.mo.AdhocTaskState.class);
uuidMap.put("0f32f6db-2c85-4867-9754-5ee00d95eb3b", com.pulse.mo.CoachingSessionState.class);
uuidMap.put("17e54fb6-cd39-45e8-83b5-fd01a044e0d6", com.pulse.mo.CorrectiveActionState.class);
uuidMap.put("23f0b13f-7dee-4e82-be41-6c29c473a597", com.pulse.mo.CorrectiveActionType.class);
uuidMap.put("fc3593c4-bc17-46c1-90ea-a44985a42d0d", com.pulse.mo.CVGProject.class);
uuidMap.put("c1ad8b88-5ea6-45eb-af97-11f970fb29ac", com.pulse.mo.Notification.class);
uuidMap.put("c9456e6b-64e0-40f1-99eb-c8903f91ad83", com.pulse.mo.Agent.class);
uuidMap.put("d7ddfe70-530b-4c1b-89f9-7f040ce95cde", com.pulse.mo.LOB.class);
uuidMap.put("c73981bc-e89b-490c-8139-02493669a9ff", com.pulse.mo.LOBConfiguration.class);
uuidMap.put("41c12f0b-16d4-4f15-bdd8-aee9eb938cbc", com.pulse.mo.LOBConfigurationNotification.class);
uuidMap.put("60ad0ec8-5802-473a-9ecf-7c84356c7193", com.pulse.mo.DiscrepancyDetectedNotification.class);
uuidMap.put("35c4a3dd-4afb-4737-847a-6cda20de0766", com.pulse.mo.DurationMismatchNotification.class);
uuidMap.put("c8c098b6-f6d0-43da-bdc0-f7b546867372", com.pulse.mo.ThresholdExceededNotification.class);
uuidMap.put("a7815c9b-b9c6-4881-af8e-1c5ebae53f08", com.pulse.mo.DurationToleranceNotification.class);
uuidMap.put("388f12b5-5d79-4713-bf2b-c4d3e0cbef23", com.pulse.mo.EmployeeAcknowledgement.class);
uuidMap.put("ab959ec2-ff8a-4d9b-850c-8f1c37f240c1", com.pulse.mo.HRApproval.class);
uuidMap.put("58863bb4-b51c-4fdb-9710-72e67c6f75ef", com.pulse.mo.InvalidActivityCodeNotification.class);
uuidMap.put("1167aa69-3074-4b64-9464-f0bf008cb88a", com.pulse.mo.ManagerApproval.class);
uuidMap.put("4b9a90c9-b433-4b4c-b180-65e46d6833b8", com.pulse.mo.Measure.class);
uuidMap.put("9ce4395e-98f9-4983-91fd-c0b159f88486", com.pulse.mo.NonBillableActivityNotification.class);
uuidMap.put("e9e2e9a7-c554-4682-9a45-29e97c975220", com.pulse.mo.Alert.class);
uuidMap.put("d4e01520-988f-4198-8053-b13d261bf3f3", com.pulse.mo.NotificationAlert.class);
uuidMap.put("0856c6d6-6f47-48b7-922f-c8b849dcf373", com.pulse.mo.NotificationFrequency.class);
uuidMap.put("893116f1-4ec6-42f4-925c-f0c77653c73f", com.pulse.mo.OccurrenceMismatchNotification.class);
uuidMap.put("aa80b9f8-dabb-43c5-ad2e-886e2e82970d", com.pulse.mo.OccurrenceToleranceNotification.class);
uuidMap.put("f6de8ceb-9964-4efb-8485-c51abe46fa86", com.pulse.mo.PayrollDetail.class);
uuidMap.put("28bdd44e-819d-43c2-80d7-6a6657707ff4", com.pulse.mo.PerformanceSummary.class);
uuidMap.put("d7479e91-97de-46be-9ab1-ce69dcd0660f", com.pulse.mo.PulseConfiguration.class);
uuidMap.put("d72331f4-4f28-46f7-8de9-0cf426f159e3", com.pulse.mo.Role.class);
uuidMap.put("cb310089-154d-4ab2-a442-b6bbf5454b52", com.pulse.mo.Scorecard.class);
uuidMap.put("362fdb5c-5474-459b-a173-26736a378303", com.pulse.mo.Site.class);
uuidMap.put("51fd4317-b2f2-4d5e-b9f6-ab42f14d6882", com.pulse.mo.SupervisorAcknowledgement.class);
uuidMap.put("f51e754c-af74-48cf-9219-540cbd74c0fb", com.pulse.mo.ThresholdGradeScale.class);
uuidMap.put("74b9c273-0262-4962-9444-a41f85ebfde1", com.pulse.mo.ThresholdScale.class);
uuidMap.put("161542de-dff1-43f7-82a4-117fe6483dca", com.pulse.mo.TraceLog.class);
uuidMap.put("bc92cb74-703b-446e-9a6c-acd962aa5fec", com.pulse.mo.WorkDurationNotification.class);
uuidMap.put("7bd8b5d5-1103-46ba-88d0-9380b091c982", com.pulse.mo.WorkModeOccurrenceNotification.class);
uuidMap.put("1c2420e7-3609-425e-a950-5ced2b86de58", com.pulse.mo.Client.class);
uuidMap.put("ef2357b0-33e7-4cda-a00e-5c1b9c13fc83", com.pulse.mo.CMSEntry.class);
uuidMap.put("3bd1fed6-0f68-40c8-897c-0f5b0b29daf2", com.pulse.mo.Schedule.class);
uuidMap.put("4deefd74-cab6-46f5-8988-8136e54e43f9", com.pulse.mo.ScheduleEntry.class);
uuidMap.put("3a8ca35d-cb0d-43ca-9965-0442e4f35222", com.pulse.mo.Timecard.class);
uuidMap.put("f4fc81f7-bfa7-44df-8aa6-963625039644", com.pulse.mo.TimecardActivity.class);
uuidMap.put("145b1026-75f1-441a-a070-4ff9955aa017", com.pulse.mo.TimecardEntry.class);
uuidMap.put("7daa5592-cfa2-4e47-899f-8ebd5875cc28", com.pulse.mo.AdhocCoachingSession.class);
uuidMap.put("9433ad16-7efa-46ea-85a8-84599350c18c", com.pulse.mo.AdhocTask.class);
uuidMap.put("8e32752e-c955-46aa-8a12-fb66b4345399", com.pulse.mo.AgentScorecard.class);
uuidMap.put("a0353460-bc33-47ac-b278-ec3bed2894bd", com.pulse.mo.Behavior.class);
uuidMap.put("c55b5f08-6fe3-4c20-aede-060da420747d", com.pulse.mo.BehaviorResponse.class);
uuidMap.put("b2dcb16b-c677-4616-a905-7906a422d515", com.pulse.mo.CoachingComment.class);
uuidMap.put("51f4fa98-a176-4278-b0e7-cb97b4bf4f91", com.pulse.mo.CoachingSession.class);
uuidMap.put("73df50b1-bd3d-465e-9bb6-1c2c769046b2", com.pulse.mo.CoachingSessionAttachment.class);
uuidMap.put("9aaee8d7-e4ee-4bb5-ab19-1c0d4751849b", com.pulse.mo.CorrectiveAction.class);
uuidMap.put("ecb53fef-6407-4bee-aca0-2ecd5a6d2ef9", com.pulse.mo.DevelopmentActivity.class);
uuidMap.put("193eca60-b34d-44e5-b44a-6645c274b6c9", com.pulse.mo.DevelopmentPlan.class);
uuidMap.put("831635b1-908f-4cb9-91c4-037c8a49c8e5", com.pulse.mo.Email.class);
uuidMap.put("62f6d441-9a93-48c3-a15f-d9176b510e76", com.pulse.mo.GeneralComment.class);
uuidMap.put("20a0045b-c2ef-4fed-8770-f4fc610c4a4c", com.pulse.mo.LOBConfigurationEntry.class);
uuidMap.put("82131afb-dab1-4512-b84e-afd86cde9705", com.pulse.mo.Observation.class);
uuidMap.put("83f79040-3760-4823-a9ce-4b4f32f30f59", com.pulse.mo.TeamLeader.class);
uuidMap.put("f25374e3-004d-4a89-990e-eb1a140a8caf", com.pulse.mo.PulseUser.class);
uuidMap.put("1a534193-ede3-4980-b218-b495894816d7", com.pulse.mo.QualityEvaluation.class);
uuidMap.put("2a116673-26cb-4a90-b045-d7e4ddfd60b7", com.pulse.mo.ScorecardMeasure.class);
uuidMap.put("345eb565-4eb7-4046-949e-b1adabcf3dbf", com.pulse.mo.Setting.class);
uuidMap.put("96f4cd1b-61d0-4152-be56-8094ede87bcf", com.pulse.mo.Supervisor.class);
uuidMap.put("55911696-47fa-407c-b78b-ce0404a78352", com.pulse.mo.TeamLeaderImpersonation.class);
uuidMap.put("971986eb-0fcd-44a5-97e1-28551dbdd20c", com.pulse.mo.ThresholdLevel.class);
uuidMap.put("2fd5eb5d-c2ba-49f4-bf90-31287666f0b2", com.pulse.mo.TraceEntry.class);
uuidMap.put("595a0cb3-b2de-45d3-9e25-2d74ec72d754", com.pulse.mo.UserRole.class);
uuidMap.put("747ba606-05d9-43fd-89cf-054e84d90267", com.pulse.mo.UserSession.class);
uuidMap.put("b5a88596-7e28-41c3-a4d2-bd3297ade178", com.pulse.mo.ChangesNotApprovedNotification.class);
uuidMap.put("3801af28-6ca0-4a3b-9608-33254824ed2d", com.pulse.mo.CoachingNotification.class);

		}
		return uuidMap;
	}

}