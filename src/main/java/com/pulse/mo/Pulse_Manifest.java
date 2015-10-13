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
			objectList.add(new com.pulse.mo.CMSAuxMode());
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
			uuidMap.put("325de20e-cd2a-4033-973b-99d3d0cbc0fa", com.pulse.mo.CMSAuxMode.class);
uuidMap.put("3404d4d1-be5b-4daf-ba38-282ea337d689", com.pulse.mo.AdhocCoachingCategory.class);
uuidMap.put("b31ef789-ed69-4810-b19f-1754ff039610", com.pulse.mo.AdhocTaskState.class);
uuidMap.put("d29df30c-2b48-4acf-af33-7263a311ddc2", com.pulse.mo.Behavior.class);
uuidMap.put("ddd29e9a-1a98-49ba-90ee-d3fa98633cde", com.pulse.mo.Notification.class);
uuidMap.put("6e77a228-0f4d-4421-ab51-b33cf6f9dd36", com.pulse.mo.CoachingNotification.class);
uuidMap.put("f29943f1-8190-41bf-98a3-45ee79b78582", com.pulse.mo.CoachingSessionState.class);
uuidMap.put("bd8384fd-0889-4d24-9b31-b412b467811b", com.pulse.mo.CorrectiveActionState.class);
uuidMap.put("0940f3cc-d418-47c4-bfe3-dfd2e3058734", com.pulse.mo.CorrectiveActionType.class);
uuidMap.put("45a4cb94-8f04-40d2-a7e9-220d1b9ee60f", com.pulse.mo.CVGProject.class);
uuidMap.put("0e75ccf8-a9e6-4ff8-9316-c4bfc937db1a", com.pulse.mo.DevelopmentPlan.class);
uuidMap.put("0ee53d41-8df1-4434-891e-d36cff4cf075", com.pulse.mo.Agent.class);
uuidMap.put("cb522e0b-e2ff-48ad-8844-8414667efd3e", com.pulse.mo.LOB.class);
uuidMap.put("702dc3fe-68d5-4b15-ae21-8d15214a8f16", com.pulse.mo.LOBConfiguration.class);
uuidMap.put("1a83dcf2-c0b1-4cd2-9718-f7617c359b1b", com.pulse.mo.LOBConfigurationNotification.class);
uuidMap.put("a61ece65-aa1e-44c6-a5cb-f6dbba693fae", com.pulse.mo.DiscrepancyDetectedNotification.class);
uuidMap.put("dc79cb88-56db-44c2-9d7e-79a812dd55ef", com.pulse.mo.DurationMismatchNotification.class);
uuidMap.put("871a9054-ea5f-4fdd-8da2-54f0cd90d891", com.pulse.mo.ThresholdExceededNotification.class);
uuidMap.put("0b0e8aad-df0f-4818-8b1b-8765b3d81424", com.pulse.mo.DurationToleranceNotification.class);
uuidMap.put("00ab7825-d403-4891-8f6e-a90f3cde511b", com.pulse.mo.EmployeeAcknowledgement.class);
uuidMap.put("d85f8bb9-3a3f-4d1c-bbb3-0c4ca4a9df1d", com.pulse.mo.HRApproval.class);
uuidMap.put("d6405867-bfd4-4f05-98c9-1185686a1bcb", com.pulse.mo.InvalidActivityCodeNotification.class);
uuidMap.put("2cd8573d-eb12-49ed-82c3-737128019dbb", com.pulse.mo.ManagerApproval.class);
uuidMap.put("2f474346-1753-4a67-8b71-f8fffb7622b0", com.pulse.mo.Measure.class);
uuidMap.put("8e246032-176e-410e-9f90-7e3f760c7079", com.pulse.mo.NonBillableActivityNotification.class);
uuidMap.put("e092a2d1-45e2-484d-8ecf-3974baa19427", com.pulse.mo.Alert.class);
uuidMap.put("4f9df393-34a1-49c2-b323-9ccf1a8fc599", com.pulse.mo.NotificationAlert.class);
uuidMap.put("91173771-3305-4f25-9ec6-c3d700476d0f", com.pulse.mo.NotificationFrequency.class);
uuidMap.put("fd491dd8-d2b9-40a4-970c-437468295dc9", com.pulse.mo.Observation.class);
uuidMap.put("6e1ed51e-e10e-4a31-b0b6-e51c004afc21", com.pulse.mo.OccurrenceMismatchNotification.class);
uuidMap.put("d6cd67ff-ab0f-4f9e-a931-2c98b04bc067", com.pulse.mo.OccurrenceToleranceNotification.class);
uuidMap.put("94dcc769-00e9-4282-b234-d0912c4fb88e", com.pulse.mo.PayrollDetail.class);
uuidMap.put("9b4c3242-3469-4ebc-be62-bd59c69a19a8", com.pulse.mo.PerformanceSummary.class);
uuidMap.put("58551992-1fd2-48fb-acec-3144bc1dcbcb", com.pulse.mo.PulseConfiguration.class);
uuidMap.put("1449bb1f-3b79-4b62-be90-7f288f37df50", com.pulse.mo.Role.class);
uuidMap.put("835bbf54-de41-4181-aad8-747c58b1f962", com.pulse.mo.Scorecard.class);
uuidMap.put("0b59422f-4690-466c-acfa-ec9998bfe1a3", com.pulse.mo.Site.class);
uuidMap.put("d7e7da19-36ef-418b-bcc9-616640c57e36", com.pulse.mo.SupervisorAcknowledgement.class);
uuidMap.put("6efe91b9-2834-419d-8da0-8df911fb322d", com.pulse.mo.ThresholdGradeScale.class);
uuidMap.put("46d32555-bcc0-45b9-a5ca-41f02166aaa2", com.pulse.mo.ThresholdScale.class);
uuidMap.put("559aa2c9-57d2-44f9-99f3-2c5ccac624a6", com.pulse.mo.TraceLog.class);
uuidMap.put("b32e0739-9792-4af3-9537-1d0283e441d1", com.pulse.mo.WorkDurationNotification.class);
uuidMap.put("e3ba99f5-ee72-489c-9fdf-516d9b518a57", com.pulse.mo.WorkModeOccurrenceNotification.class);
uuidMap.put("bb516c1c-75cf-4b61-8a65-0219ac5af84f", com.pulse.mo.Client.class);
uuidMap.put("a338d094-9744-41f9-b82b-7c7ab9ea9fe3", com.pulse.mo.CMSEntry.class);
uuidMap.put("e171691f-a962-4a31-966d-b69031b525de", com.pulse.mo.Schedule.class);
uuidMap.put("d3d3d02d-c757-4de9-97d3-a2ba37b03dea", com.pulse.mo.ScheduleEntry.class);
uuidMap.put("f6850ee2-fa2b-4072-9b9e-67988ca5f724", com.pulse.mo.Timecard.class);
uuidMap.put("72a508bc-90ec-47d2-b33c-e06f0bfbc822", com.pulse.mo.TimecardActivity.class);
uuidMap.put("ef01117a-282b-4bb5-858d-2aa316827beb", com.pulse.mo.TimecardEntry.class);
uuidMap.put("e2807d5b-d2cc-471e-8a3f-12226a55b53b", com.pulse.mo.AdhocCoachingSession.class);
uuidMap.put("c4d7e029-b734-41b6-afb6-7c1a06e1dd26", com.pulse.mo.AdhocTask.class);
uuidMap.put("2807bc83-b1fe-4d3a-b401-a38c9d3b2fc3", com.pulse.mo.AgentScorecard.class);
uuidMap.put("60cae7f4-2e34-4890-9a43-702c40e1d570", com.pulse.mo.BehaviorResponse.class);
uuidMap.put("fbf4f89d-d0a9-461a-bdcf-2bcfec54e110", com.pulse.mo.CoachingComment.class);
uuidMap.put("d4ff9309-3206-4a24-a45b-76a90435250a", com.pulse.mo.CoachingSession.class);
uuidMap.put("b1057381-10ab-44f4-a2b2-f98a18c33508", com.pulse.mo.CoachingSessionAttachment.class);
uuidMap.put("51e8b92c-7b17-415c-97f6-c1a7cccade38", com.pulse.mo.CorrectiveAction.class);
uuidMap.put("4872f6fa-761c-43bf-a40d-5b43f67fc1dc", com.pulse.mo.DevelopmentActivity.class);
uuidMap.put("786b5717-6516-401c-bbf9-651ba07b5572", com.pulse.mo.Email.class);
uuidMap.put("a924a068-12c6-488f-9805-d7c1f643b6e5", com.pulse.mo.GeneralComment.class);
uuidMap.put("a92e4670-4bf6-4f88-8c1a-611d6ec8a67e", com.pulse.mo.LOBConfigurationEntry.class);
uuidMap.put("a401d2fc-793b-449d-8bdf-3eeeaa1d996a", com.pulse.mo.TeamLeader.class);
uuidMap.put("17848900-bb5a-41cc-831a-7ab9c9f61eb1", com.pulse.mo.PulseUser.class);
uuidMap.put("ff1d40a6-2236-4934-a83e-72c953dd4ef0", com.pulse.mo.QualityEvaluation.class);
uuidMap.put("244abd9a-c9ac-4056-90b5-260d7930b578", com.pulse.mo.ScorecardMeasure.class);
uuidMap.put("1e2b9fe3-bf28-46e3-8c2d-d1341065c485", com.pulse.mo.ScorecardMeasureMonthlyResult.class);
uuidMap.put("8810d2ef-9e98-4064-bb5a-ee5c794165ff", com.pulse.mo.ScorecardMeasureWeeklyResult.class);
uuidMap.put("f452a2c5-43df-4811-95bf-2dbfb3eaed63", com.pulse.mo.Setting.class);
uuidMap.put("c65fea00-8209-4371-87d3-624cf7a0a34d", com.pulse.mo.Supervisor.class);
uuidMap.put("e81ac0e7-93d2-4d31-9c79-7fecc4701b4f", com.pulse.mo.TeamLeaderImpersonation.class);
uuidMap.put("1b584bbb-5476-4442-86a5-dc61de11866a", com.pulse.mo.ThresholdLevel.class);
uuidMap.put("514c36d0-9189-4986-98b3-a3648622ad70", com.pulse.mo.TraceEntry.class);
uuidMap.put("d64796d7-274e-4def-b9dc-304b3e96c86c", com.pulse.mo.UserRole.class);
uuidMap.put("d3acfddc-2910-470f-9855-af2c8c9066a4", com.pulse.mo.UserSession.class);
uuidMap.put("4c72fe00-a02e-49f7-b3c9-67d625474b97", com.pulse.mo.ShiftStatusNotification.class);

		}
		return uuidMap;
	}

}