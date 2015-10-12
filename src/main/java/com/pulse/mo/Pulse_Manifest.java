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
			uuidMap.put("3d6fd5e7-0da4-4eed-91d8-8a6f5d299ac0", com.pulse.mo.CMSAuxMode.class);
uuidMap.put("3d8e8368-a177-4f6e-8980-e6e8361e72f3", com.pulse.mo.AdhocCoachingCategory.class);
uuidMap.put("0ddeefca-7542-468a-8a95-90e2ca57ae6f", com.pulse.mo.AdhocTaskState.class);
uuidMap.put("83c567f9-7e9c-45b7-ba12-f70ecd4ba913", com.pulse.mo.CoachingSessionState.class);
uuidMap.put("49199321-0782-4ca3-beae-344d579d21df", com.pulse.mo.CorrectiveActionState.class);
uuidMap.put("f0752258-b4f7-4585-8ac6-fdebaf3bc7dc", com.pulse.mo.CorrectiveActionType.class);
uuidMap.put("b103fbc7-76b3-4317-9b52-78b26e97aa14", com.pulse.mo.CVGProject.class);
uuidMap.put("b1ab5142-77f2-4d24-b395-849e43b07bcf", com.pulse.mo.Notification.class);
uuidMap.put("c5707705-dbd9-4c59-8a7f-b7fa9fdecd67", com.pulse.mo.Agent.class);
uuidMap.put("99ab5993-028c-4c5d-b018-33e95f08b2b7", com.pulse.mo.LOB.class);
uuidMap.put("7755655c-692b-4e82-b197-40b6fe87e3e0", com.pulse.mo.LOBConfiguration.class);
uuidMap.put("792e4a9c-c009-44a4-a110-4c065b30fc01", com.pulse.mo.LOBConfigurationNotification.class);
uuidMap.put("f37e5a34-41aa-4ca1-8d81-23c1de2c3c0d", com.pulse.mo.DiscrepancyDetectedNotification.class);
uuidMap.put("5dccf785-f9f0-4f53-b879-b4925a939dbd", com.pulse.mo.DurationMismatchNotification.class);
uuidMap.put("e230bda4-956e-41e4-8bfd-1263f9a2c34f", com.pulse.mo.ThresholdExceededNotification.class);
uuidMap.put("40f28a68-08ce-4952-8ad3-56aae3a249fd", com.pulse.mo.DurationToleranceNotification.class);
uuidMap.put("1e89625e-fa1f-481d-a345-f5bf159fef9d", com.pulse.mo.EmployeeAcknowledgement.class);
uuidMap.put("2be259e2-25b2-4daa-9af0-d341a59642ea", com.pulse.mo.HRApproval.class);
uuidMap.put("ab8ac7db-f7b6-41a2-abc0-4cfccc4f2829", com.pulse.mo.InvalidActivityCodeNotification.class);
uuidMap.put("d8040bd6-2759-481e-a23a-f0fd356a82e8", com.pulse.mo.ManagerApproval.class);
uuidMap.put("c965f089-783d-4d41-bf2d-994f75b5adc7", com.pulse.mo.Measure.class);
uuidMap.put("20278506-4db9-4e8d-a1d2-8bdf45d81834", com.pulse.mo.NonBillableActivityNotification.class);
uuidMap.put("a9c202c9-e385-4b55-99ec-4824bbc24ce5", com.pulse.mo.Alert.class);
uuidMap.put("c93269c1-e3ad-4be5-865c-857739a11da5", com.pulse.mo.NotificationAlert.class);
uuidMap.put("53ae2832-0170-4bba-92d6-9e9782fe3e86", com.pulse.mo.NotificationFrequency.class);
uuidMap.put("5cf9800d-eb87-449a-8624-4507acc72333", com.pulse.mo.OccurrenceMismatchNotification.class);
uuidMap.put("ac7750c3-e41e-4ac4-9e0a-2993415cad01", com.pulse.mo.OccurrenceToleranceNotification.class);
uuidMap.put("9c3a89e2-5f51-441a-9fb3-98ac23ae673a", com.pulse.mo.PayrollDetail.class);
uuidMap.put("6bdcf2af-6822-4025-a780-cabcf5181f9a", com.pulse.mo.PerformanceSummary.class);
uuidMap.put("614a99c6-e347-4d82-bf14-b17d56dfc6a4", com.pulse.mo.PulseConfiguration.class);
uuidMap.put("ac84b133-985f-4ad7-9361-3c730e0b0dae", com.pulse.mo.Role.class);
uuidMap.put("0e469a83-67df-49af-b97e-0acdc15f893d", com.pulse.mo.Scorecard.class);
uuidMap.put("238a83ad-df8a-4b5a-99cd-0a96a644e2f0", com.pulse.mo.Site.class);
uuidMap.put("886df88d-f6ba-48ad-aa41-843898fec342", com.pulse.mo.SupervisorAcknowledgement.class);
uuidMap.put("5fce359c-03d7-44d5-a15f-785733c3891e", com.pulse.mo.ThresholdGradeScale.class);
uuidMap.put("1031b98f-57cf-4b89-8cdc-461781dd1ab1", com.pulse.mo.ThresholdScale.class);
uuidMap.put("ef7d3efd-f0be-4c01-88ab-2d38378f475f", com.pulse.mo.TraceLog.class);
uuidMap.put("353018f0-5754-41e8-85be-1de1c4c65654", com.pulse.mo.WorkDurationNotification.class);
uuidMap.put("4d57ad5b-a17b-4a03-850c-829bbbcc97c1", com.pulse.mo.WorkModeOccurrenceNotification.class);
uuidMap.put("0b3b4a5c-a651-44e4-b637-c90d4fa066e4", com.pulse.mo.Client.class);
uuidMap.put("f199f2a8-8cb8-4db6-a53e-1fe5eef617ef", com.pulse.mo.CMSEntry.class);
uuidMap.put("e30d1c82-8584-419e-a207-47bc1da1c44d", com.pulse.mo.Schedule.class);
uuidMap.put("79755a05-406d-4dcd-bb54-c48e45e53535", com.pulse.mo.ScheduleEntry.class);
uuidMap.put("41204c6c-de13-4e03-b713-c39c3deee989", com.pulse.mo.Timecard.class);
uuidMap.put("88f9cd3c-c5da-4e01-bbb4-cf2a9b2ab183", com.pulse.mo.TimecardActivity.class);
uuidMap.put("1e6d9f20-89ff-4101-a6ed-a9761be39505", com.pulse.mo.TimecardEntry.class);
uuidMap.put("8b2c1d4f-502e-4214-8d15-64b76c86dbd1", com.pulse.mo.AdhocCoachingSession.class);
uuidMap.put("ea5f772a-c442-4f13-a83f-21ab18be0eee", com.pulse.mo.AdhocTask.class);
uuidMap.put("23d4bb67-8df0-450d-b17b-185b3dc9a0c7", com.pulse.mo.AgentScorecard.class);
uuidMap.put("798f3a1d-bce1-4c17-8eba-684cb29791a7", com.pulse.mo.Behavior.class);
uuidMap.put("e8a039ea-fdbd-4cda-94e1-86157dd2e3a3", com.pulse.mo.BehaviorResponse.class);
uuidMap.put("2e515076-6bfe-4bec-98c3-b6886cae0715", com.pulse.mo.CoachingComment.class);
uuidMap.put("c04d8649-2f16-4690-8712-841d3c32baec", com.pulse.mo.CoachingSession.class);
uuidMap.put("1a929eaa-7866-45a8-ab1d-c958fdd5cac3", com.pulse.mo.CoachingSessionAttachment.class);
uuidMap.put("8db2b123-7c6f-42f8-a42e-c73aafe8a0f0", com.pulse.mo.CorrectiveAction.class);
uuidMap.put("c8c3d490-c071-48bc-ba2f-243c6c6964ee", com.pulse.mo.DevelopmentActivity.class);
uuidMap.put("421eec6a-ac1a-41a8-bf33-2b1ed2b607db", com.pulse.mo.DevelopmentPlan.class);
uuidMap.put("bcbf7b70-e109-4438-9573-68c459cd2ab8", com.pulse.mo.Email.class);
uuidMap.put("0b499e48-9b1c-49ab-9539-cc679e47df18", com.pulse.mo.GeneralComment.class);
uuidMap.put("9b8a470d-45cf-42aa-822c-dddddbc100c3", com.pulse.mo.LOBConfigurationEntry.class);
uuidMap.put("c494e16b-d6a5-42a2-8e2a-a98144b5b7b6", com.pulse.mo.Observation.class);
uuidMap.put("724a6e38-2e24-4cb5-a313-7f88745eb9be", com.pulse.mo.TeamLeader.class);
uuidMap.put("feaa5643-801a-4322-9c50-cfb6d518cabc", com.pulse.mo.PulseUser.class);
uuidMap.put("bd743a5f-b710-4935-b31d-0a17979b9129", com.pulse.mo.QualityEvaluation.class);
uuidMap.put("51dd613f-5b63-4085-9cc3-2535c0be9f05", com.pulse.mo.ScorecardMeasure.class);
uuidMap.put("785670e9-d44f-488c-bc5a-334f4343bcff", com.pulse.mo.Setting.class);
uuidMap.put("d9ca2b58-1e47-4516-9b2f-9fc0617d03e3", com.pulse.mo.Supervisor.class);
uuidMap.put("7929e072-d3a0-40ab-a197-b851b751942a", com.pulse.mo.TeamLeaderImpersonation.class);
uuidMap.put("66e5a6a6-4b0d-41f7-86cd-1be5245db0d0", com.pulse.mo.ThresholdLevel.class);
uuidMap.put("a5a9182d-b4ee-42d3-8f48-c756e5edd135", com.pulse.mo.TraceEntry.class);
uuidMap.put("b1a3037d-29ce-437b-a94f-8fa6bd88de9b", com.pulse.mo.UserRole.class);
uuidMap.put("071db063-ea94-43a8-bff6-5182ec7b458b", com.pulse.mo.UserSession.class);
uuidMap.put("7fa8e128-d28c-4e0c-a377-c893faa0957a", com.pulse.mo.ChangesNotApprovedNotification.class);
uuidMap.put("9ef600ab-da8b-49ad-ae33-1096b4386c47", com.pulse.mo.CoachingNotification.class);

		}
		return uuidMap;
	}

}