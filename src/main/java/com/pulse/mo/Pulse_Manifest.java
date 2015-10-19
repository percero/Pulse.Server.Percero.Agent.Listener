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
			classList.add(com.pulse.mo.TimecardActivity.class);
classList.add(com.pulse.mo.AdhocCoachingCategory.class);
classList.add(com.pulse.mo.AdhocCoachingSessionAttachment.class);
classList.add(com.pulse.mo.AdhocTaskState.class);
classList.add(com.pulse.mo.Notification.class);
classList.add(com.pulse.mo.CoachingNotification.class);
classList.add(com.pulse.mo.CoachingSessionState.class);
classList.add(com.pulse.mo.Comment.class);
classList.add(com.pulse.mo.CorrectiveActionState.class);
classList.add(com.pulse.mo.CorrectiveActionType.class);
classList.add(com.pulse.mo.Agent.class);
classList.add(com.pulse.mo.LOB.class);
classList.add(com.pulse.mo.LOBConfiguration.class);
classList.add(com.pulse.mo.LOBConfigurationNotification.class);
classList.add(com.pulse.mo.DiscrepancyDetectedNotification.class);
classList.add(com.pulse.mo.DurationMismatchNotification.class);
classList.add(com.pulse.mo.ThresholdExceededNotification.class);
classList.add(com.pulse.mo.DurationToleranceNotification.class);
classList.add(com.pulse.mo.Employee.class);
classList.add(com.pulse.mo.InvalidActivityCodeNotification.class);
classList.add(com.pulse.mo.Measure.class);
classList.add(com.pulse.mo.NonBillableActivityNotification.class);
classList.add(com.pulse.mo.Alert.class);
classList.add(com.pulse.mo.NotificationAlert.class);
classList.add(com.pulse.mo.NotificationFrequency.class);
classList.add(com.pulse.mo.OccurrenceMismatchNotification.class);
classList.add(com.pulse.mo.OccurrenceToleranceNotification.class);
classList.add(com.pulse.mo.PulseConfiguration.class);
classList.add(com.pulse.mo.Role.class);
classList.add(com.pulse.mo.Scorecard.class);
classList.add(com.pulse.mo.Site.class);
classList.add(com.pulse.mo.TraceLog.class);
classList.add(com.pulse.mo.WorkDurationNotification.class);
classList.add(com.pulse.mo.WorkModeOccurrenceNotification.class);
classList.add(com.pulse.mo.Client.class);
classList.add(com.pulse.mo.CMSEntry.class);
classList.add(com.pulse.mo.Schedule.class);
classList.add(com.pulse.mo.ScheduleEntry.class);
classList.add(com.pulse.mo.Timecard.class);
classList.add(com.pulse.mo.TimecardEntry.class);
classList.add(com.pulse.mo.AdhocCoachingSession.class);
classList.add(com.pulse.mo.AdhocTask.class);
classList.add(com.pulse.mo.AgentScorecard.class);
classList.add(com.pulse.mo.Behavior.class);
classList.add(com.pulse.mo.BehaviorResponse.class);
classList.add(com.pulse.mo.CoachingSession.class);
classList.add(com.pulse.mo.CoachingSessionAttachment.class);
classList.add(com.pulse.mo.Supervisor.class);
classList.add(com.pulse.mo.CorrectiveAction.class);
classList.add(com.pulse.mo.CorrectiveActionAttachment.class);
classList.add(com.pulse.mo.DevelopmentActivity.class);
classList.add(com.pulse.mo.DevelopmentPlan.class);
classList.add(com.pulse.mo.Email.class);
classList.add(com.pulse.mo.Goal.class);
classList.add(com.pulse.mo.GradeScale.class);
classList.add(com.pulse.mo.LOBConfigurationEntry.class);
classList.add(com.pulse.mo.TeamLeader.class);
classList.add(com.pulse.mo.PulseUser.class);
classList.add(com.pulse.mo.QualityEvaluation.class);
classList.add(com.pulse.mo.ScorecardMeasure.class);
classList.add(com.pulse.mo.ScorecardMonthlyResult.class);
classList.add(com.pulse.mo.ScorecardWeeklyResult.class);
classList.add(com.pulse.mo.Setting.class);
classList.add(com.pulse.mo.TeamLeaderImpersonation.class);
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
			objectList.add(new com.pulse.mo.TimecardActivity());
objectList.add(new com.pulse.mo.AdhocCoachingCategory());
objectList.add(new com.pulse.mo.AdhocCoachingSessionAttachment());
objectList.add(new com.pulse.mo.AdhocTaskState());
objectList.add(new com.pulse.mo.Notification());
objectList.add(new com.pulse.mo.CoachingNotification());
objectList.add(new com.pulse.mo.CoachingSessionState());
objectList.add(new com.pulse.mo.Comment());
objectList.add(new com.pulse.mo.CorrectiveActionState());
objectList.add(new com.pulse.mo.CorrectiveActionType());
objectList.add(new com.pulse.mo.Agent());
objectList.add(new com.pulse.mo.LOB());
objectList.add(new com.pulse.mo.LOBConfiguration());
objectList.add(new com.pulse.mo.LOBConfigurationNotification());
objectList.add(new com.pulse.mo.DiscrepancyDetectedNotification());
objectList.add(new com.pulse.mo.DurationMismatchNotification());
objectList.add(new com.pulse.mo.ThresholdExceededNotification());
objectList.add(new com.pulse.mo.DurationToleranceNotification());
objectList.add(new com.pulse.mo.Employee());
objectList.add(new com.pulse.mo.InvalidActivityCodeNotification());
objectList.add(new com.pulse.mo.Measure());
objectList.add(new com.pulse.mo.NonBillableActivityNotification());
objectList.add(new com.pulse.mo.Alert());
objectList.add(new com.pulse.mo.NotificationAlert());
objectList.add(new com.pulse.mo.NotificationFrequency());
objectList.add(new com.pulse.mo.OccurrenceMismatchNotification());
objectList.add(new com.pulse.mo.OccurrenceToleranceNotification());
objectList.add(new com.pulse.mo.PulseConfiguration());
objectList.add(new com.pulse.mo.Role());
objectList.add(new com.pulse.mo.Scorecard());
objectList.add(new com.pulse.mo.Site());
objectList.add(new com.pulse.mo.TraceLog());
objectList.add(new com.pulse.mo.WorkDurationNotification());
objectList.add(new com.pulse.mo.WorkModeOccurrenceNotification());
objectList.add(new com.pulse.mo.Client());
objectList.add(new com.pulse.mo.CMSEntry());
objectList.add(new com.pulse.mo.Schedule());
objectList.add(new com.pulse.mo.ScheduleEntry());
objectList.add(new com.pulse.mo.Timecard());
objectList.add(new com.pulse.mo.TimecardEntry());
objectList.add(new com.pulse.mo.AdhocCoachingSession());
objectList.add(new com.pulse.mo.AdhocTask());
objectList.add(new com.pulse.mo.AgentScorecard());
objectList.add(new com.pulse.mo.Behavior());
objectList.add(new com.pulse.mo.BehaviorResponse());
objectList.add(new com.pulse.mo.CoachingSession());
objectList.add(new com.pulse.mo.CoachingSessionAttachment());
objectList.add(new com.pulse.mo.Supervisor());
objectList.add(new com.pulse.mo.CorrectiveAction());
objectList.add(new com.pulse.mo.CorrectiveActionAttachment());
objectList.add(new com.pulse.mo.DevelopmentActivity());
objectList.add(new com.pulse.mo.DevelopmentPlan());
objectList.add(new com.pulse.mo.Email());
objectList.add(new com.pulse.mo.Goal());
objectList.add(new com.pulse.mo.GradeScale());
objectList.add(new com.pulse.mo.LOBConfigurationEntry());
objectList.add(new com.pulse.mo.TeamLeader());
objectList.add(new com.pulse.mo.PulseUser());
objectList.add(new com.pulse.mo.QualityEvaluation());
objectList.add(new com.pulse.mo.ScorecardMeasure());
objectList.add(new com.pulse.mo.ScorecardMonthlyResult());
objectList.add(new com.pulse.mo.ScorecardWeeklyResult());
objectList.add(new com.pulse.mo.Setting());
objectList.add(new com.pulse.mo.TeamLeaderImpersonation());
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
			uuidMap.put("06584054-fc1f-4c0e-b3f2-50a14ec517fa", com.pulse.mo.TimecardActivity.class);
uuidMap.put("ae4cadda-a4e5-4396-b7c8-f4c13a28995c", com.pulse.mo.AdhocCoachingCategory.class);
uuidMap.put("c916b849-ca39-4ee0-a2f6-8ae423bea0e1", com.pulse.mo.AdhocCoachingSessionAttachment.class);
uuidMap.put("aae5c15e-9c93-4a1b-b5b6-d381c2d4fc0b", com.pulse.mo.AdhocTaskState.class);
uuidMap.put("72bfac87-9d94-49cd-bbfb-74942f5b96da", com.pulse.mo.Notification.class);
uuidMap.put("57e8af78-3b06-4d24-aad3-f8a4bac31e90", com.pulse.mo.CoachingNotification.class);
uuidMap.put("e779f6dd-923d-4dc7-a145-f0714c1242f6", com.pulse.mo.CoachingSessionState.class);
uuidMap.put("7d3128ba-3eb3-4871-a3b2-512db16f6f7d", com.pulse.mo.Comment.class);
uuidMap.put("4c3de5e7-51a5-483d-9b6d-93e012b07e74", com.pulse.mo.CorrectiveActionState.class);
uuidMap.put("e98c96c1-9ec7-40a3-9208-155cd40f9f0c", com.pulse.mo.CorrectiveActionType.class);
uuidMap.put("ab90fad7-0982-462b-9add-9c904faa8d7a", com.pulse.mo.Agent.class);
uuidMap.put("2d837e29-3757-42f8-a280-a4e42fe2f907", com.pulse.mo.LOB.class);
uuidMap.put("1ab65e07-c821-4acb-8fc0-02036b5bbd91", com.pulse.mo.LOBConfiguration.class);
uuidMap.put("510a3f35-1a03-473f-8ed4-015864d28ef1", com.pulse.mo.LOBConfigurationNotification.class);
uuidMap.put("463b0b48-bc38-4487-be3e-0b0173f11380", com.pulse.mo.DiscrepancyDetectedNotification.class);
uuidMap.put("5783877d-2fa6-4d86-874c-35bf805d5b5c", com.pulse.mo.DurationMismatchNotification.class);
uuidMap.put("a9a06cf6-acd6-4340-b57c-58b02d95f6a3", com.pulse.mo.ThresholdExceededNotification.class);
uuidMap.put("875bc17c-c635-49ac-8c4b-04501f694fd6", com.pulse.mo.DurationToleranceNotification.class);
uuidMap.put("0ad95104-84af-4a10-bddf-6c6dd9783262", com.pulse.mo.Employee.class);
uuidMap.put("9629ba07-88c2-42cc-89ea-1735376a4a65", com.pulse.mo.InvalidActivityCodeNotification.class);
uuidMap.put("ce1bcd81-ad6c-427a-9be4-77e84fec0383", com.pulse.mo.Measure.class);
uuidMap.put("4f5fd2b2-e5b2-477c-be7f-6730701e64a4", com.pulse.mo.NonBillableActivityNotification.class);
uuidMap.put("e7ed7fa7-212a-4f64-82d3-15d1a337308b", com.pulse.mo.Alert.class);
uuidMap.put("10d06216-40b2-4402-8eb1-6f6f99a9d98e", com.pulse.mo.NotificationAlert.class);
uuidMap.put("b664d9a3-1ed5-497e-8629-524b6acbbaf7", com.pulse.mo.NotificationFrequency.class);
uuidMap.put("6b6e9fd1-702a-4a7e-b1e1-c760a75afd24", com.pulse.mo.OccurrenceMismatchNotification.class);
uuidMap.put("7ca9016d-d2d4-467d-8752-3005af830fd7", com.pulse.mo.OccurrenceToleranceNotification.class);
uuidMap.put("aa775ebe-8843-4180-9900-ecc4c7e6ec7e", com.pulse.mo.PulseConfiguration.class);
uuidMap.put("5fb35386-8dac-4ef6-ba7f-fcdae424394d", com.pulse.mo.Role.class);
uuidMap.put("e35a2a26-86b1-4ba7-b8cd-cb1b71349a2a", com.pulse.mo.Scorecard.class);
uuidMap.put("02fa02b1-2e5f-4c4e-b51f-afa8ddac7b83", com.pulse.mo.Site.class);
uuidMap.put("22b89187-8708-4f22-b93f-7803665de129", com.pulse.mo.TraceLog.class);
uuidMap.put("12a869c0-c24a-4ec5-a55c-eb25d79a52d7", com.pulse.mo.WorkDurationNotification.class);
uuidMap.put("e7a80c12-772d-4cf8-bfe0-1944f2090dbd", com.pulse.mo.WorkModeOccurrenceNotification.class);
uuidMap.put("106f6c9e-911d-4347-a356-e4cdcacffbac", com.pulse.mo.Client.class);
uuidMap.put("3e6beb83-8db8-4be6-b79e-ffaee6907bab", com.pulse.mo.CMSEntry.class);
uuidMap.put("4d57a485-3b12-450a-a20d-0f7b3856641e", com.pulse.mo.Schedule.class);
uuidMap.put("23ba3023-631d-4443-aadf-8f234af87bb0", com.pulse.mo.ScheduleEntry.class);
uuidMap.put("6645f9d8-d26a-4750-981a-0109c93e5b7d", com.pulse.mo.Timecard.class);
uuidMap.put("54db1f56-0aa8-4d40-916d-9f849d61f061", com.pulse.mo.TimecardEntry.class);
uuidMap.put("5048d104-481e-4642-8ade-048c702674cd", com.pulse.mo.AdhocCoachingSession.class);
uuidMap.put("120a12ee-2801-40b8-a990-5ffd3816f760", com.pulse.mo.AdhocTask.class);
uuidMap.put("cf877d01-d984-40d5-8a0f-504f1fd4ac71", com.pulse.mo.AgentScorecard.class);
uuidMap.put("371a9bbd-480e-48eb-bc65-fa44e2dbb483", com.pulse.mo.Behavior.class);
uuidMap.put("742a9be3-f3e2-4c60-9f70-a16b8f975053", com.pulse.mo.BehaviorResponse.class);
uuidMap.put("57f32e59-3bee-49b8-ad9c-76423656a82c", com.pulse.mo.CoachingSession.class);
uuidMap.put("c0e92590-6853-4fc8-b915-3878225f4dc4", com.pulse.mo.CoachingSessionAttachment.class);
uuidMap.put("e49f2f38-7842-4d3e-bd70-ce8de23e26c3", com.pulse.mo.Supervisor.class);
uuidMap.put("1f13a59a-aedd-44b9-9bbc-e59b65f5377e", com.pulse.mo.CorrectiveAction.class);
uuidMap.put("923432fc-6363-4055-ac59-3b9b670821ac", com.pulse.mo.CorrectiveActionAttachment.class);
uuidMap.put("476f8b60-de7d-45b9-95a7-11effceaa6bb", com.pulse.mo.DevelopmentActivity.class);
uuidMap.put("fd480b7c-4864-49fe-92ba-d9d91f55e0d7", com.pulse.mo.DevelopmentPlan.class);
uuidMap.put("87e212b3-3567-4174-acad-f901b9e42ccb", com.pulse.mo.Email.class);
uuidMap.put("bc680c7a-9d5c-4887-8d9a-3c566c556dbf", com.pulse.mo.Goal.class);
uuidMap.put("d11392f4-92c8-449d-a6c8-5cdf664373b1", com.pulse.mo.GradeScale.class);
uuidMap.put("9b5f0e63-819b-4eec-ae84-a276a3f7502f", com.pulse.mo.LOBConfigurationEntry.class);
uuidMap.put("f0cff02b-a7a5-4a6d-af9d-6eba599370f5", com.pulse.mo.TeamLeader.class);
uuidMap.put("cb23b390-c69a-4467-bd44-7aed044a9323", com.pulse.mo.PulseUser.class);
uuidMap.put("817995ab-1d17-48b1-9a7b-62c362f420f7", com.pulse.mo.QualityEvaluation.class);
uuidMap.put("1d155301-af30-4a6c-8327-982a094f4ce8", com.pulse.mo.ScorecardMeasure.class);
uuidMap.put("1649587f-2dcf-46fa-90e5-4e0f56632ddd", com.pulse.mo.ScorecardMonthlyResult.class);
uuidMap.put("ddb2cce1-aae5-476b-a275-84148b26eaca", com.pulse.mo.ScorecardWeeklyResult.class);
uuidMap.put("a27913fd-1c5a-4143-a138-2ab215491b6e", com.pulse.mo.Setting.class);
uuidMap.put("f7f687f6-16d1-4256-a355-ef8a799a186c", com.pulse.mo.TeamLeaderImpersonation.class);
uuidMap.put("f324cf0e-4477-4491-9597-7479966163ee", com.pulse.mo.TraceEntry.class);
uuidMap.put("b340687b-1a7c-48a0-8d79-601020756f88", com.pulse.mo.UserRole.class);
uuidMap.put("cc3b310c-eca7-4d58-9949-47eed182e24e", com.pulse.mo.UserSession.class);
uuidMap.put("207e9bc2-a27d-40cb-8845-a45b824adddf", com.pulse.mo.ShiftStatusNotification.class);

		}
		return uuidMap;
	}

}