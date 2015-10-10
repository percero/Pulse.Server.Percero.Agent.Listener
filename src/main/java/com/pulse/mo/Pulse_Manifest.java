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
			uuidMap.put("f3860cac-8018-44dd-93dc-68367f833b17", com.pulse.mo.CMSAuxMode.class);
uuidMap.put("0c82a9d9-4eb2-4cd1-936c-070b5839d42c", com.pulse.mo.AdhocCoachingCategory.class);
uuidMap.put("0e8d85bc-c31d-469f-82a1-7db3fbeb2c2a", com.pulse.mo.AdhocTaskState.class);
uuidMap.put("623dacd6-b59f-4836-be92-840fb26f8f94", com.pulse.mo.CoachingSessionState.class);
uuidMap.put("be1ea358-e039-4ad9-805d-7a021c7bcea6", com.pulse.mo.CorrectiveActionState.class);
uuidMap.put("12d21fae-265c-4933-80a4-1ecd6f25fa66", com.pulse.mo.CorrectiveActionType.class);
uuidMap.put("28d7f46d-a70b-47de-a016-eb5db89d503a", com.pulse.mo.CVGProject.class);
uuidMap.put("9ea278a6-8f1d-42d1-8db6-db08ec261a3b", com.pulse.mo.Notification.class);
uuidMap.put("15b874ab-022f-43d9-bb77-42fee9876797", com.pulse.mo.Agent.class);
uuidMap.put("c1b220a7-f66f-42ec-97a3-362373ce4ade", com.pulse.mo.LOB.class);
uuidMap.put("9a163ea3-180d-4829-87ba-ab281e59d41c", com.pulse.mo.LOBConfiguration.class);
uuidMap.put("ac80f596-1968-449a-b410-67be2a524949", com.pulse.mo.LOBConfigurationNotification.class);
uuidMap.put("cd1989e7-f0eb-4d9c-a537-a2fc3b245a63", com.pulse.mo.DiscrepancyDetectedNotification.class);
uuidMap.put("ca8b90ad-687b-4221-af8e-80529a947f58", com.pulse.mo.DurationMismatchNotification.class);
uuidMap.put("a24de213-427a-40d7-980f-eacc072da3fc", com.pulse.mo.ThresholdExceededNotification.class);
uuidMap.put("299e7cd0-f79b-48a1-81c1-0dadffe90cb5", com.pulse.mo.DurationToleranceNotification.class);
uuidMap.put("92505e80-44dc-4e43-baa6-0dd2aedffbaf", com.pulse.mo.EmployeeAcknowledgement.class);
uuidMap.put("d0cd7475-f8d5-4cec-b3b4-d93f598fdfd1", com.pulse.mo.HRApproval.class);
uuidMap.put("710972be-e683-4ab1-a11a-68de9ec80982", com.pulse.mo.InvalidActivityCodeNotification.class);
uuidMap.put("00fa5411-0a9e-4f58-80ab-7fb99240533e", com.pulse.mo.ManagerApproval.class);
uuidMap.put("4ce09bde-7500-4778-b07e-cb18e21aa159", com.pulse.mo.Measure.class);
uuidMap.put("60a87951-f093-48b9-8b8a-617272cb0d9b", com.pulse.mo.NonBillableActivityNotification.class);
uuidMap.put("8555cf03-f3af-494d-ad5f-54965d051191", com.pulse.mo.Alert.class);
uuidMap.put("00be15de-57e7-4db2-8131-ddd6a68c3fd5", com.pulse.mo.NotificationAlert.class);
uuidMap.put("7eaf2111-e3e7-469f-8cbd-0e9f834efe33", com.pulse.mo.NotificationFrequency.class);
uuidMap.put("2900b840-5119-4804-b54b-31ba36c127df", com.pulse.mo.OccurrenceMismatchNotification.class);
uuidMap.put("653b026d-f1ce-4c5a-a269-a858e4fc347a", com.pulse.mo.OccurrenceToleranceNotification.class);
uuidMap.put("f545b122-088c-4ba2-b595-36c94c275c27", com.pulse.mo.PayrollDetail.class);
uuidMap.put("f276fd47-202e-469c-9e45-5f0424a331c0", com.pulse.mo.PerformanceSummary.class);
uuidMap.put("c7881d8f-7300-4bb0-ad1b-b40e267a07fa", com.pulse.mo.PulseConfiguration.class);
uuidMap.put("cc211d04-fb2b-4fd4-a3ae-cc220f49d543", com.pulse.mo.Role.class);
uuidMap.put("d7a36fa4-c99e-47bf-8c5a-fcffc19be8e1", com.pulse.mo.ScheduledActivityCode.class);
uuidMap.put("7de22743-2a24-4e5e-8239-84cf1d3d3e7f", com.pulse.mo.ScheduledActivityType.class);
uuidMap.put("af341dbc-0e44-430b-83d5-bdac738c9b61", com.pulse.mo.Scorecard.class);
uuidMap.put("19e4afa3-e4e9-4a50-8d9b-cfe4579ea862", com.pulse.mo.Site.class);
uuidMap.put("d4c697f4-7a70-41fe-8613-5f09796f037f", com.pulse.mo.SupervisorAcknowledgement.class);
uuidMap.put("46990369-e587-4e08-902d-ed3e7302ae52", com.pulse.mo.ThresholdGradeScale.class);
uuidMap.put("5b3b12e6-dbaa-43ed-b35c-e2109f6139fc", com.pulse.mo.ThresholdScale.class);
uuidMap.put("a482d8b9-bef6-49c8-86fc-cdbd77bafdce", com.pulse.mo.TraceLog.class);
uuidMap.put("abff369a-8296-4d64-ab6d-687a4662d749", com.pulse.mo.WorkDurationNotification.class);
uuidMap.put("884c2f4b-3703-4548-9e38-74c24c22e5ba", com.pulse.mo.WorkModeOccurrenceNotification.class);
uuidMap.put("742ed5ca-8708-4592-b5ce-172c051ff7c3", com.pulse.mo.Client.class);
uuidMap.put("730e30ba-76d4-442d-ba3f-e704af375085", com.pulse.mo.CMSEntry.class);
uuidMap.put("3a153e2a-bda4-4c5e-b227-1bb52d3566c5", com.pulse.mo.Timecard.class);
uuidMap.put("84e47c90-49af-4928-99ae-8e21fe16229a", com.pulse.mo.TimecardActivity.class);
uuidMap.put("9e235215-2c00-4991-bdfd-31caec4e6bb7", com.pulse.mo.TimecardEntry.class);
uuidMap.put("9e83eba4-9daa-4e00-a6c1-467bd3b6a9dd", com.pulse.mo.AdhocCoachingSession.class);
uuidMap.put("b1275784-8279-43eb-ba09-09726de893bc", com.pulse.mo.AdhocTask.class);
uuidMap.put("35e87d85-7cb2-465a-82a8-0348aaa92ca3", com.pulse.mo.AgentScorecard.class);
uuidMap.put("4610049e-31a8-4a76-aa1c-59d99e9fe305", com.pulse.mo.Behavior.class);
uuidMap.put("90982938-f09d-466c-8ee1-725c388a8fba", com.pulse.mo.BehaviorResponse.class);
uuidMap.put("a07873ee-e1b9-47a2-966c-be46c696ddb3", com.pulse.mo.CoachingComment.class);
uuidMap.put("672fd9f3-7e57-4008-a196-944eaf63e140", com.pulse.mo.CoachingSession.class);
uuidMap.put("3dbbb5e6-b75b-4271-886f-1e2b284a8b21", com.pulse.mo.CoachingSessionAttachment.class);
uuidMap.put("94bb6a70-9651-4e39-bf9b-67f8b37d190b", com.pulse.mo.CorrectiveAction.class);
uuidMap.put("cc16eeec-daed-405f-9350-57602177d3f8", com.pulse.mo.DevelopmentActivity.class);
uuidMap.put("ba9f8b8a-6dd7-40de-80c2-b22fe0989713", com.pulse.mo.DevelopmentPlan.class);
uuidMap.put("7583a7c1-ca7d-4022-982d-c875f9cc270a", com.pulse.mo.Email.class);
uuidMap.put("9f7e9530-5fee-458d-b2ec-d952eab2847c", com.pulse.mo.GeneralComment.class);
uuidMap.put("564229cb-36de-4b55-8f70-e11cb795a451", com.pulse.mo.LOBConfigurationEntry.class);
uuidMap.put("5de8fda3-7b5a-48f4-b908-d991961e645d", com.pulse.mo.Observation.class);
uuidMap.put("613721b9-4a96-4f38-9a03-5c0845c92af4", com.pulse.mo.TeamLeader.class);
uuidMap.put("8fe35748-99a1-4f14-bcbb-3f863627ab1c", com.pulse.mo.PulseUser.class);
uuidMap.put("c0f24b60-4d63-4a40-a32d-acab7c81b9ff", com.pulse.mo.QualityEvaluation.class);
uuidMap.put("7dea517d-2688-416c-9fda-9b093f7c1875", com.pulse.mo.ScheduledTime.class);
uuidMap.put("2f388df3-fc14-4c4b-9f93-684925c3d028", com.pulse.mo.ScheduledTimeEntry.class);
uuidMap.put("afa3d143-8cee-4dbd-9401-7e24b31c8aed", com.pulse.mo.ScorecardMeasure.class);
uuidMap.put("0b3a1ab3-aa17-41f2-a38d-eec970535d92", com.pulse.mo.Setting.class);
uuidMap.put("eecea880-44e4-4136-a764-f003eb06b2a4", com.pulse.mo.Supervisor.class);
uuidMap.put("088c463d-bb68-4c97-9a4d-bd00b2d0b029", com.pulse.mo.TeamLeaderImpersonation.class);
uuidMap.put("753ee749-71d4-4213-b2f9-c367a294dedb", com.pulse.mo.ThresholdLevel.class);
uuidMap.put("a14e6b2b-62ba-45bc-b210-4572a5af9249", com.pulse.mo.TraceEntry.class);
uuidMap.put("93cf288d-1920-49f3-89e4-c1c5535a5e87", com.pulse.mo.UserRole.class);
uuidMap.put("f092f559-c161-4012-a730-ea6632553e24", com.pulse.mo.UserSession.class);
uuidMap.put("3e2d48d3-16c7-44b5-96c0-451b9b016942", com.pulse.mo.ChangesNotApprovedNotification.class);
uuidMap.put("735f98a5-eb6b-42da-9c1a-c305c2adad39", com.pulse.mo.CoachingNotification.class);

		}
		return uuidMap;
	}

}