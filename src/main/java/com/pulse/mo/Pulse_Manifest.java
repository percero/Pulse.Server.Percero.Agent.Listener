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
			uuidMap.put("1764caf2-f09a-4edf-91a9-1da73ee3edfe", com.pulse.mo.AdhocCoachingCategory.class);
uuidMap.put("65d6731e-a694-4136-913a-a6778fac4318", com.pulse.mo.AdhocTaskState.class);
uuidMap.put("f7dd8c8d-f630-46e1-9a5a-a566310ee807", com.pulse.mo.Behavior.class);
uuidMap.put("48bc53c6-075f-4dd6-9be1-201f1692606b", com.pulse.mo.Notification.class);
uuidMap.put("220c4ee4-de22-4729-ab6c-c28138aec723", com.pulse.mo.CoachingNotification.class);
uuidMap.put("0e444839-d9b4-46f4-af2b-4b3ea42b733e", com.pulse.mo.CoachingSessionState.class);
uuidMap.put("8b5787d8-971d-42d1-84dd-91ed8e45833b", com.pulse.mo.CorrectiveActionState.class);
uuidMap.put("329ae96e-92c7-4a0f-84bc-07f37bebb8be", com.pulse.mo.CorrectiveActionType.class);
uuidMap.put("3d4896c7-995f-47d9-9173-e8836dc1d1d5", com.pulse.mo.CVGProject.class);
uuidMap.put("50fba013-91be-444a-8eff-281f660832f6", com.pulse.mo.DevelopmentPlan.class);
uuidMap.put("6681dae5-444a-402b-ad43-ec49cc11a138", com.pulse.mo.Agent.class);
uuidMap.put("ecc111dd-1ab9-40db-921d-7c6755abaacf", com.pulse.mo.LOB.class);
uuidMap.put("93659961-8835-43f2-a167-771e0ccadfdf", com.pulse.mo.LOBConfiguration.class);
uuidMap.put("b34666ce-80cc-4d46-8379-1bfd03540ec1", com.pulse.mo.LOBConfigurationNotification.class);
uuidMap.put("f26906c5-a655-4ae4-ad16-1243feb40525", com.pulse.mo.DiscrepancyDetectedNotification.class);
uuidMap.put("6ac02fe2-79ff-4bbc-8a5d-bce6cf6b93a9", com.pulse.mo.DurationMismatchNotification.class);
uuidMap.put("9dd3c77a-5d7d-4047-9ffe-7cb20e6992fc", com.pulse.mo.ThresholdExceededNotification.class);
uuidMap.put("7693cba8-e202-4562-b90f-42ff3b884684", com.pulse.mo.DurationToleranceNotification.class);
uuidMap.put("0e22cfae-2eb1-481b-808d-7964baaa8ee9", com.pulse.mo.EmployeeAcknowledgement.class);
uuidMap.put("538d65cb-d681-418f-a887-035c72dfb6f9", com.pulse.mo.HRApproval.class);
uuidMap.put("0e141303-9521-464e-8747-032c030c45b4", com.pulse.mo.InvalidActivityCodeNotification.class);
uuidMap.put("6b6deb87-79c0-4c14-9697-e86ec144354b", com.pulse.mo.ManagerApproval.class);
uuidMap.put("052e5bbf-698c-404e-85fe-1ad30528762c", com.pulse.mo.Measure.class);
uuidMap.put("86c83f97-db62-4481-93f1-72f7194b9a91", com.pulse.mo.NonBillableActivityNotification.class);
uuidMap.put("d5ba000c-2aa9-4de3-8342-c867747bde82", com.pulse.mo.Alert.class);
uuidMap.put("299eaf93-0e27-4333-9e7d-77c7ba028aff", com.pulse.mo.NotificationAlert.class);
uuidMap.put("b522198e-8225-44f3-812c-05f5bd2a20ee", com.pulse.mo.NotificationFrequency.class);
uuidMap.put("e6ec4f3d-1df9-48dd-84eb-f83c44a68f16", com.pulse.mo.Observation.class);
uuidMap.put("b56d04a1-ea74-40fd-9127-7a4d8fdf3461", com.pulse.mo.OccurrenceMismatchNotification.class);
uuidMap.put("9245b860-9277-4a91-934e-5ed60d09840e", com.pulse.mo.OccurrenceToleranceNotification.class);
uuidMap.put("492a4a83-2ce6-41ee-98ff-21401efa565b", com.pulse.mo.PayrollDetail.class);
uuidMap.put("88943447-871d-4719-9684-928b73727981", com.pulse.mo.PerformanceSummary.class);
uuidMap.put("0a4f364a-32cf-408b-8e2e-5e66dfb37dd7", com.pulse.mo.PulseConfiguration.class);
uuidMap.put("9963178d-9710-43f1-b53e-db6875253cbf", com.pulse.mo.Role.class);
uuidMap.put("24351f29-31fc-4cad-aaae-04a4afab48dd", com.pulse.mo.Scorecard.class);
uuidMap.put("ea43df0c-98d7-408b-abdd-9e4a98b38f15", com.pulse.mo.Site.class);
uuidMap.put("81aaa995-3524-4840-b389-c8ee36eef4f6", com.pulse.mo.SupervisorAcknowledgement.class);
uuidMap.put("342740c2-e979-4156-92ca-b20cd07f8f6f", com.pulse.mo.ThresholdGradeScale.class);
uuidMap.put("e5e01cf5-8a5c-4e86-b5ef-d4eb1bf74302", com.pulse.mo.ThresholdScale.class);
uuidMap.put("062eebe8-61cb-4cde-a597-e3bc8716e73c", com.pulse.mo.TraceLog.class);
uuidMap.put("37cc1fad-0ba4-40c2-babf-d181e6b0bc5f", com.pulse.mo.WorkDurationNotification.class);
uuidMap.put("ffde84f4-5c03-40e6-b8a3-f473bf4d691b", com.pulse.mo.WorkModeOccurrenceNotification.class);
uuidMap.put("6be90dd3-24da-4fd1-ad93-323698d84af2", com.pulse.mo.Client.class);
uuidMap.put("e9c44703-9f4e-411a-a6a8-23b6e1beb04e", com.pulse.mo.CMSEntry.class);
uuidMap.put("e2d5a603-91ad-4d00-ada0-6627374589c1", com.pulse.mo.Schedule.class);
uuidMap.put("92bfc8b2-4e02-412a-9c88-6ac8d4f2dcc0", com.pulse.mo.ScheduleEntry.class);
uuidMap.put("1ea13727-c589-4928-a789-5db16fbe6623", com.pulse.mo.Timecard.class);
uuidMap.put("5ee68ce4-d757-470a-b6da-232405ea8f03", com.pulse.mo.TimecardActivity.class);
uuidMap.put("5663f790-3cc1-4967-a074-bfe6848e2b20", com.pulse.mo.TimecardEntry.class);
uuidMap.put("6ba76181-8c29-4f74-be4f-901a9bef4505", com.pulse.mo.AdhocCoachingSession.class);
uuidMap.put("3d56df52-159a-4dff-99de-8a4289d7a763", com.pulse.mo.AdhocTask.class);
uuidMap.put("219fd684-c126-45eb-b496-b84a152b0870", com.pulse.mo.AgentScorecard.class);
uuidMap.put("8898e856-c335-429e-bac5-75fd6819383e", com.pulse.mo.BehaviorResponse.class);
uuidMap.put("e48d5a2e-f885-4609-93b3-b76cd8b2bc86", com.pulse.mo.CoachingComment.class);
uuidMap.put("bb9bd7e7-a6db-493b-bb87-4c7eb785de3d", com.pulse.mo.CoachingSession.class);
uuidMap.put("8c75e452-9776-4792-ab6a-3ade7b87a606", com.pulse.mo.CoachingSessionAttachment.class);
uuidMap.put("adabe7dd-2401-4fcf-82ed-ce6dc3e000d3", com.pulse.mo.CorrectiveAction.class);
uuidMap.put("c6872263-879f-4a5b-9ccd-b5ec78488f6f", com.pulse.mo.DevelopmentActivity.class);
uuidMap.put("2005cdc6-a03c-478c-abfe-2ed38ec22476", com.pulse.mo.Email.class);
uuidMap.put("fa3dd28b-d25f-4770-a0bb-9e61b65dc0b1", com.pulse.mo.GeneralComment.class);
uuidMap.put("557d7b30-e023-4441-9945-edd2b000e669", com.pulse.mo.LOBConfigurationEntry.class);
uuidMap.put("8a7a05d3-ec50-4398-91d8-4a8d6ff8ca0c", com.pulse.mo.TeamLeader.class);
uuidMap.put("748a8653-254d-4e4e-b66c-ed31aa1a7398", com.pulse.mo.PulseUser.class);
uuidMap.put("66436c92-04c0-473a-a503-9c37c21850bb", com.pulse.mo.QualityEvaluation.class);
uuidMap.put("eceaa899-e1d0-4573-bc16-12bfbb8dbf00", com.pulse.mo.ScorecardMeasure.class);
uuidMap.put("6e5da956-1cd9-4ce2-81c5-580a2feb662d", com.pulse.mo.ScorecardMeasureMonthlyResult.class);
uuidMap.put("3e5da515-d4d0-4cb5-bf65-6f3dc0fdd077", com.pulse.mo.ScorecardMeasureWeeklyResult.class);
uuidMap.put("751ece3a-1ddb-4913-990a-522dd6a4f5ae", com.pulse.mo.Setting.class);
uuidMap.put("1c7d7fd2-42cc-4c21-a2f5-9b17fafb6973", com.pulse.mo.Supervisor.class);
uuidMap.put("bc24639d-f41f-40da-9cc4-2e107df343e1", com.pulse.mo.TeamLeaderImpersonation.class);
uuidMap.put("8ddfd91c-864c-44c9-8871-97379518a331", com.pulse.mo.ThresholdLevel.class);
uuidMap.put("589f8fbf-933f-4143-9ad8-425a8a5c62e1", com.pulse.mo.TraceEntry.class);
uuidMap.put("4ee0d0e1-5276-4d23-ab2c-a0b0ec7c5eac", com.pulse.mo.UserRole.class);
uuidMap.put("a375fdd8-b4d7-473e-b4bc-113a02afa86b", com.pulse.mo.UserSession.class);
uuidMap.put("aee96e51-703b-4c39-a2c8-7c0989f7dee8", com.pulse.mo.ShiftStatusNotification.class);

		}
		return uuidMap;
	}

}