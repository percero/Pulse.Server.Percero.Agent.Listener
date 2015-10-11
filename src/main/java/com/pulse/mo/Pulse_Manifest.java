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
			uuidMap.put("39456e88-141c-4e5c-9950-6f8f3ff7473f", com.pulse.mo.CMSAuxMode.class);
uuidMap.put("83b967a9-1971-4c93-870f-f0a812a42c70", com.pulse.mo.AdhocCoachingCategory.class);
uuidMap.put("50baadf9-5414-488b-8e07-1390155091d8", com.pulse.mo.AdhocTaskState.class);
uuidMap.put("3191cbc4-b761-4a40-809d-a04bd6701531", com.pulse.mo.CoachingSessionState.class);
uuidMap.put("bca80933-b003-4f07-9d97-472178db03c8", com.pulse.mo.CorrectiveActionState.class);
uuidMap.put("a24f55ef-8d15-40b9-82a4-ab518c04c6c6", com.pulse.mo.CorrectiveActionType.class);
uuidMap.put("9629865d-4e77-4637-8243-20318d69515c", com.pulse.mo.CVGProject.class);
uuidMap.put("2b207a63-8112-471b-a352-4a68aa643f30", com.pulse.mo.Notification.class);
uuidMap.put("aa5b1fe2-2735-4a47-8805-8115c49dc5ec", com.pulse.mo.Agent.class);
uuidMap.put("d1feba04-3554-4455-b4ac-fc54c3ffedbf", com.pulse.mo.LOB.class);
uuidMap.put("95b9a009-ba32-4e6d-90d8-7d57014ce7e8", com.pulse.mo.LOBConfiguration.class);
uuidMap.put("9df4e58a-597b-4251-afc2-1fe85ffd1805", com.pulse.mo.LOBConfigurationNotification.class);
uuidMap.put("d450bd89-e866-4c79-8cff-5070f0bf9fcb", com.pulse.mo.DiscrepancyDetectedNotification.class);
uuidMap.put("78b31db0-2973-4719-b379-9b64d5282ed5", com.pulse.mo.DurationMismatchNotification.class);
uuidMap.put("471b666a-b2ed-49f0-9100-89fae77bfee2", com.pulse.mo.ThresholdExceededNotification.class);
uuidMap.put("449649e0-eca0-4bf3-a5be-27172a3b7ae1", com.pulse.mo.DurationToleranceNotification.class);
uuidMap.put("c1729cdd-0c28-499c-942a-5a598dea0b86", com.pulse.mo.EmployeeAcknowledgement.class);
uuidMap.put("0418023a-7f29-4050-8869-75bb9fb9a286", com.pulse.mo.HRApproval.class);
uuidMap.put("44930b36-56e2-40ae-bfd6-72b027e5f6c5", com.pulse.mo.InvalidActivityCodeNotification.class);
uuidMap.put("bab9de0d-a1aa-400d-8a05-554992a43c2f", com.pulse.mo.ManagerApproval.class);
uuidMap.put("812ce122-deda-431e-80ff-3390673ff08c", com.pulse.mo.Measure.class);
uuidMap.put("772a5d84-36b2-411c-b7c0-15e423fbdc7e", com.pulse.mo.NonBillableActivityNotification.class);
uuidMap.put("80ce06e4-3795-481d-afa9-2c3165f346e4", com.pulse.mo.Alert.class);
uuidMap.put("860abd02-a742-4c18-8de3-c9da25154ae2", com.pulse.mo.NotificationAlert.class);
uuidMap.put("efece7f5-1949-4a8e-904a-04589ba61491", com.pulse.mo.NotificationFrequency.class);
uuidMap.put("6d6e769e-7b7a-4501-a9f4-130126036767", com.pulse.mo.OccurrenceMismatchNotification.class);
uuidMap.put("50dbbc38-3236-4ab4-bea1-c893283a4b69", com.pulse.mo.OccurrenceToleranceNotification.class);
uuidMap.put("036b0ea8-9afc-4031-976c-04d288504a23", com.pulse.mo.PayrollDetail.class);
uuidMap.put("aa77a602-c3e5-4f95-a94c-7434baef8eb6", com.pulse.mo.PerformanceSummary.class);
uuidMap.put("6540a24f-5a41-47ba-b5a9-b224e0afeb3f", com.pulse.mo.PulseConfiguration.class);
uuidMap.put("03646d88-1402-45b7-91c8-c4a21d893672", com.pulse.mo.Role.class);
uuidMap.put("fecda64a-6f69-4688-839f-0049d9fecc2c", com.pulse.mo.ScheduledActivityCode.class);
uuidMap.put("da643201-00e5-4964-992e-65d33f20f9c8", com.pulse.mo.ScheduledActivityType.class);
uuidMap.put("d11d0181-ea8f-4f96-a874-be573fb78056", com.pulse.mo.Scorecard.class);
uuidMap.put("88622f22-b351-40c0-a4a0-c487d5ce3f59", com.pulse.mo.Site.class);
uuidMap.put("aed367ad-73b6-4af3-aeae-cfd3620dc180", com.pulse.mo.SupervisorAcknowledgement.class);
uuidMap.put("d3a2856d-8aca-4627-a426-d01ec2fbb151", com.pulse.mo.ThresholdGradeScale.class);
uuidMap.put("b78e2980-084c-404c-a5e7-ea9517be8839", com.pulse.mo.ThresholdScale.class);
uuidMap.put("dbec6874-ee17-4016-b62e-094b257cd98f", com.pulse.mo.TraceLog.class);
uuidMap.put("fad3952a-e4cc-4ad7-a295-ad493a16f814", com.pulse.mo.WorkDurationNotification.class);
uuidMap.put("94a723d8-bc81-4ed6-9e0f-ec88482c5c48", com.pulse.mo.WorkModeOccurrenceNotification.class);
uuidMap.put("4407094b-0123-42ce-a587-ec4d3f96a6b4", com.pulse.mo.Client.class);
uuidMap.put("05e2e18f-d19f-4391-a626-9c2164758c7c", com.pulse.mo.CMSEntry.class);
uuidMap.put("da3ceba0-b619-4646-8415-b8f5f83d49b7", com.pulse.mo.Timecard.class);
uuidMap.put("809edaba-91fb-4ab6-afc7-fe50fdf4ff06", com.pulse.mo.TimecardActivity.class);
uuidMap.put("830dc419-468f-4eac-83a7-934db9acf29e", com.pulse.mo.TimecardEntry.class);
uuidMap.put("9f5cf535-6b0c-4d5f-8d0d-ddf28c960cb4", com.pulse.mo.AdhocCoachingSession.class);
uuidMap.put("ecdcb989-5c92-4dc5-99ac-2abf3e62021d", com.pulse.mo.AdhocTask.class);
uuidMap.put("dda5c972-1e62-4e07-b70c-1be80a11cd01", com.pulse.mo.AgentScorecard.class);
uuidMap.put("e1d9c652-bdb7-42bb-b149-5d9e89990891", com.pulse.mo.Behavior.class);
uuidMap.put("044b4b0b-8c94-4cdb-bb32-af6d717467ee", com.pulse.mo.BehaviorResponse.class);
uuidMap.put("e01957cc-4b5a-45c5-bdc1-52c486b11d56", com.pulse.mo.CoachingComment.class);
uuidMap.put("68460fef-d1c5-4f51-b186-167060cb3ca0", com.pulse.mo.CoachingSession.class);
uuidMap.put("9a40ab53-ebc5-421e-a03e-fa809db2c764", com.pulse.mo.CoachingSessionAttachment.class);
uuidMap.put("c56682ac-de35-4665-83cc-5ad36f50542c", com.pulse.mo.CorrectiveAction.class);
uuidMap.put("7993aafe-9f5d-4461-aa44-3eb5c4772ff1", com.pulse.mo.DevelopmentActivity.class);
uuidMap.put("e1cbc2fa-9103-416b-a120-82304d46c1c5", com.pulse.mo.DevelopmentPlan.class);
uuidMap.put("10a2ea8a-824d-4c44-a2ce-f2476ab63e85", com.pulse.mo.Email.class);
uuidMap.put("b54119b6-9ef4-4739-bdff-d272b773fd36", com.pulse.mo.GeneralComment.class);
uuidMap.put("1c2f93ad-e45a-4dee-915a-291c70e6385c", com.pulse.mo.LOBConfigurationEntry.class);
uuidMap.put("f657686f-263f-49ad-9ef2-6c63999c9556", com.pulse.mo.Observation.class);
uuidMap.put("d7b83a8d-356f-4150-bc5e-cecd04385fbb", com.pulse.mo.TeamLeader.class);
uuidMap.put("f60f851e-66a4-4b3e-a0c3-615e4ed41be9", com.pulse.mo.PulseUser.class);
uuidMap.put("836bed48-e2b5-46da-95c6-ddee690bf619", com.pulse.mo.QualityEvaluation.class);
uuidMap.put("88aeaf60-7e0d-46f9-bb91-78c12c65f20b", com.pulse.mo.ScheduledTime.class);
uuidMap.put("64e771f8-c087-4ba8-9f80-668c45b08590", com.pulse.mo.ScheduledTimeEntry.class);
uuidMap.put("c2388624-e35e-44df-9309-eb96d0cd0a1f", com.pulse.mo.ScorecardMeasure.class);
uuidMap.put("5d60e1c2-b881-4724-a46a-8b44e26c9910", com.pulse.mo.Setting.class);
uuidMap.put("9777163a-064c-4aa3-a0e3-0532a8c83def", com.pulse.mo.Supervisor.class);
uuidMap.put("6cceac2a-bda8-4545-9120-4b015029af38", com.pulse.mo.TeamLeaderImpersonation.class);
uuidMap.put("44f1f923-ec0b-4aa6-ad62-4711763b6e34", com.pulse.mo.ThresholdLevel.class);
uuidMap.put("e9a261a4-bcdb-47e2-b80b-a9646e78552a", com.pulse.mo.TraceEntry.class);
uuidMap.put("5186ea2e-42ae-442d-8e54-f1c308fa7641", com.pulse.mo.UserRole.class);
uuidMap.put("eb0221f7-819b-4b5f-8728-ea846ac84cee", com.pulse.mo.UserSession.class);
uuidMap.put("dfb0f37b-4abc-45df-b7c5-2485c7e7dbcf", com.pulse.mo.ChangesNotApprovedNotification.class);
uuidMap.put("5f3ddb2a-51d2-457d-aff3-8d9d515a7ca1", com.pulse.mo.CoachingNotification.class);

		}
		return uuidMap;
	}

}