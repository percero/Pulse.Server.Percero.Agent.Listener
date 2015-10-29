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
			classList.add(com.pulse.mo.Client.class);
classList.add(com.pulse.mo.TimecardActivity.class);
classList.add(com.pulse.mo.AdhocCoachingCategory.class);
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
classList.add(com.pulse.mo.ClientSite.class);
classList.add(com.pulse.mo.CMSEntry.class);
classList.add(com.pulse.mo.CMSEntryLOB.class);
classList.add(com.pulse.mo.Schedule.class);
classList.add(com.pulse.mo.ScheduleEntry.class);
classList.add(com.pulse.mo.Timecard.class);
classList.add(com.pulse.mo.TimecardEntry.class);
classList.add(com.pulse.mo.AdhocCoachingSession.class);
classList.add(com.pulse.mo.AdhocCoachingSessionAttachment.class);
classList.add(com.pulse.mo.AdhocTask.class);
classList.add(com.pulse.mo.AgentScorecard.class);
classList.add(com.pulse.mo.Behavior.class);
classList.add(com.pulse.mo.BehaviorResponse.class);
classList.add(com.pulse.mo.CoachingSession.class);
classList.add(com.pulse.mo.CoachingSessionAttachment.class);
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
classList.add(com.pulse.mo.ScorecardMonthlyScore.class);
classList.add(com.pulse.mo.ScorecardWeeklyResult.class);
classList.add(com.pulse.mo.ScorecardWeeklyScore.class);
classList.add(com.pulse.mo.Setting.class);
classList.add(com.pulse.mo.Supervisor.class);
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
			objectList.add(new com.pulse.mo.Client());
objectList.add(new com.pulse.mo.TimecardActivity());
objectList.add(new com.pulse.mo.AdhocCoachingCategory());
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
objectList.add(new com.pulse.mo.ClientSite());
objectList.add(new com.pulse.mo.CMSEntry());
objectList.add(new com.pulse.mo.CMSEntryLOB());
objectList.add(new com.pulse.mo.Schedule());
objectList.add(new com.pulse.mo.ScheduleEntry());
objectList.add(new com.pulse.mo.Timecard());
objectList.add(new com.pulse.mo.TimecardEntry());
objectList.add(new com.pulse.mo.AdhocCoachingSession());
objectList.add(new com.pulse.mo.AdhocCoachingSessionAttachment());
objectList.add(new com.pulse.mo.AdhocTask());
objectList.add(new com.pulse.mo.AgentScorecard());
objectList.add(new com.pulse.mo.Behavior());
objectList.add(new com.pulse.mo.BehaviorResponse());
objectList.add(new com.pulse.mo.CoachingSession());
objectList.add(new com.pulse.mo.CoachingSessionAttachment());
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
objectList.add(new com.pulse.mo.ScorecardMonthlyScore());
objectList.add(new com.pulse.mo.ScorecardWeeklyResult());
objectList.add(new com.pulse.mo.ScorecardWeeklyScore());
objectList.add(new com.pulse.mo.Setting());
objectList.add(new com.pulse.mo.Supervisor());
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
			uuidMap.put("630b87bb-65e2-4b50-bbef-03c2914c538b", com.pulse.mo.Client.class);
uuidMap.put("4739fa40-c21c-409f-a2e3-4551bce62569", com.pulse.mo.TimecardActivity.class);
uuidMap.put("c40ee468-a0c3-44c7-b8ed-0cb675eb6878", com.pulse.mo.AdhocCoachingCategory.class);
uuidMap.put("3e41e1ca-b0d1-493a-872d-e50197467167", com.pulse.mo.AdhocTaskState.class);
uuidMap.put("7c9a240a-e7b0-499f-bdcf-982cfe5471ac", com.pulse.mo.Notification.class);
uuidMap.put("7e502a24-5b45-4b9a-996a-2345ce6ab917", com.pulse.mo.CoachingNotification.class);
uuidMap.put("229dbeaa-fc5e-490e-96b1-64971bc28f94", com.pulse.mo.CoachingSessionState.class);
uuidMap.put("eb55e50d-c998-4269-a89d-2154c7ca804a", com.pulse.mo.Comment.class);
uuidMap.put("211e6037-2303-4998-bbbe-98af731b89ea", com.pulse.mo.CorrectiveActionState.class);
uuidMap.put("d234a9b6-d2ca-4ba4-b453-f0d26254d321", com.pulse.mo.CorrectiveActionType.class);
uuidMap.put("ddf00489-fc46-4596-9109-11deaeb08c4c", com.pulse.mo.Agent.class);
uuidMap.put("3fa74169-fe07-4ccf-9dae-d0ad12838120", com.pulse.mo.LOB.class);
uuidMap.put("7e0a2fb3-a42a-4ccd-afc4-b272c431db29", com.pulse.mo.LOBConfiguration.class);
uuidMap.put("cd96fc2f-c94c-4597-b622-7817b1644c77", com.pulse.mo.LOBConfigurationNotification.class);
uuidMap.put("0607af0c-f945-4e04-b986-0075e57cb1e0", com.pulse.mo.DiscrepancyDetectedNotification.class);
uuidMap.put("53339b1c-c868-4ca4-ae7d-c314d7dcb228", com.pulse.mo.DurationMismatchNotification.class);
uuidMap.put("c933fa87-e8d4-4e8e-825f-373e6dbe0a5a", com.pulse.mo.ThresholdExceededNotification.class);
uuidMap.put("894bbf56-a02c-4551-9307-63ade5c93318", com.pulse.mo.DurationToleranceNotification.class);
uuidMap.put("0a0ff0e7-396b-4fd1-8d86-64df1081b715", com.pulse.mo.Employee.class);
uuidMap.put("acda5ba1-5239-420e-a3d9-2a1707152090", com.pulse.mo.InvalidActivityCodeNotification.class);
uuidMap.put("06e73243-35a8-4339-a264-193ee5bb1052", com.pulse.mo.Measure.class);
uuidMap.put("c6c38a99-9d1f-4f51-98e1-dfc7a0f423c0", com.pulse.mo.NonBillableActivityNotification.class);
uuidMap.put("4b8514df-ac0a-4c3d-ab68-a22f8421647d", com.pulse.mo.Alert.class);
uuidMap.put("097a2532-a936-45ac-b422-1a1f90c30630", com.pulse.mo.NotificationAlert.class);
uuidMap.put("de8f52fe-7834-49c9-bdb5-b1761a5ae40c", com.pulse.mo.NotificationFrequency.class);
uuidMap.put("156a09ff-b191-46b8-a831-d5301cccd928", com.pulse.mo.OccurrenceMismatchNotification.class);
uuidMap.put("27c1a61e-6ac2-48c9-94e3-472e53dacc10", com.pulse.mo.OccurrenceToleranceNotification.class);
uuidMap.put("ed864095-da54-4639-9e8d-d9f7bb09fd82", com.pulse.mo.PulseConfiguration.class);
uuidMap.put("662d8a95-4af3-48ff-a45f-ad3c947b221f", com.pulse.mo.Role.class);
uuidMap.put("f786d826-c475-44d3-be43-01391f6b1d40", com.pulse.mo.Scorecard.class);
uuidMap.put("6104d540-6a81-4f1b-8d0c-f10b6e1f0098", com.pulse.mo.Site.class);
uuidMap.put("d03e7307-dffc-46fb-a094-e3a2117fb92e", com.pulse.mo.TraceLog.class);
uuidMap.put("9c13050f-a78e-4315-aac4-9fa31466ff04", com.pulse.mo.WorkDurationNotification.class);
uuidMap.put("6e3a23cb-6777-425d-bb72-78f974adaa84", com.pulse.mo.WorkModeOccurrenceNotification.class);
uuidMap.put("b380619f-8da4-4cd0-a4ec-5ced927bbae7", com.pulse.mo.ClientSite.class);
uuidMap.put("dfc7bcaf-785f-4b27-ad48-dd98f8a98422", com.pulse.mo.CMSEntry.class);
uuidMap.put("2fa34eef-91ff-4223-928a-c4a6785fd3a4", com.pulse.mo.CMSEntryLOB.class);
uuidMap.put("e9818462-b441-467e-b29c-38f92c9480e9", com.pulse.mo.Schedule.class);
uuidMap.put("a748739c-fc46-4918-8263-492924d0e98c", com.pulse.mo.ScheduleEntry.class);
uuidMap.put("bcf2b4b2-55b4-4264-b679-235cd7d46440", com.pulse.mo.Timecard.class);
uuidMap.put("60966c69-e454-4690-997f-c1d044d35578", com.pulse.mo.TimecardEntry.class);
uuidMap.put("b013aa31-1473-4208-8cb9-ab042964ba60", com.pulse.mo.AdhocCoachingSession.class);
uuidMap.put("128c2f0d-7574-44d7-a512-03d9f9d526d6", com.pulse.mo.AdhocCoachingSessionAttachment.class);
uuidMap.put("25bde1f4-c46a-48d9-adc1-d192a954b686", com.pulse.mo.AdhocTask.class);
uuidMap.put("c2cc3510-3208-40ca-bbf6-cec6b4e269d0", com.pulse.mo.AgentScorecard.class);
uuidMap.put("ed6909ac-5ac8-44e1-a5b4-506e6d69ff73", com.pulse.mo.Behavior.class);
uuidMap.put("60684757-cdc2-4bc1-a9df-0de7047042e5", com.pulse.mo.BehaviorResponse.class);
uuidMap.put("bc6f6e88-d924-40dd-a736-1233bb721db1", com.pulse.mo.CoachingSession.class);
uuidMap.put("ca3514e6-aede-429f-958e-ec62dc7be98b", com.pulse.mo.CoachingSessionAttachment.class);
uuidMap.put("8c14c7c9-643f-4491-b12e-707bb8b8f201", com.pulse.mo.CorrectiveAction.class);
uuidMap.put("201b4526-4c9b-4ec6-9942-20364cf15859", com.pulse.mo.CorrectiveActionAttachment.class);
uuidMap.put("aab071c9-e62d-4bb7-b0d2-abe3335c9bd0", com.pulse.mo.DevelopmentActivity.class);
uuidMap.put("b6d4956d-7d96-4ad6-ad87-313e24448a46", com.pulse.mo.DevelopmentPlan.class);
uuidMap.put("b18096d8-3fcf-4fd1-bc82-e8173dab2b88", com.pulse.mo.Email.class);
uuidMap.put("c063b0db-0370-4223-bef1-667a57636321", com.pulse.mo.Goal.class);
uuidMap.put("36a0bd08-d4aa-44ec-b91e-843b2f404590", com.pulse.mo.GradeScale.class);
uuidMap.put("a4a48aee-3516-4404-88b1-4cc76b0da8b2", com.pulse.mo.LOBConfigurationEntry.class);
uuidMap.put("77e428b2-aede-426a-9dd8-a895c396bf9c", com.pulse.mo.TeamLeader.class);
uuidMap.put("386e7099-fde7-4e05-813b-306cdf96fac5", com.pulse.mo.PulseUser.class);
uuidMap.put("b58bdcea-f4a1-460c-b9c3-ef2458655ecf", com.pulse.mo.QualityEvaluation.class);
uuidMap.put("a8ea4cbc-4440-4472-86d5-a07aa4ac0ebd", com.pulse.mo.ScorecardMeasure.class);
uuidMap.put("15e8a366-c662-4b11-ad92-bca05bd8fec8", com.pulse.mo.ScorecardMonthlyResult.class);
uuidMap.put("e444d0ff-85b2-465e-8b1d-6684e753d7a8", com.pulse.mo.ScorecardMonthlyScore.class);
uuidMap.put("43062ca5-2021-48ed-b14f-8c25ecba8059", com.pulse.mo.ScorecardWeeklyResult.class);
uuidMap.put("717b9f02-5d64-4f8d-bda2-75885015f648", com.pulse.mo.ScorecardWeeklyScore.class);
uuidMap.put("ce068f9e-ff90-4923-b48f-cce28303dc01", com.pulse.mo.Setting.class);
uuidMap.put("8ef68cff-be19-46a2-a590-f2bb35c80976", com.pulse.mo.Supervisor.class);
uuidMap.put("2ac9f1c6-a2f1-4ada-b034-8508c8d4385a", com.pulse.mo.TeamLeaderImpersonation.class);
uuidMap.put("95aaf614-7838-428d-a655-3468e9fbb2d5", com.pulse.mo.TraceEntry.class);
uuidMap.put("9d0133f7-fcd8-4ed4-844e-db74293abc40", com.pulse.mo.UserRole.class);
uuidMap.put("a47ffece-0b0a-4e2b-988d-211c01b22b4e", com.pulse.mo.UserSession.class);
uuidMap.put("0c229730-6549-4e9c-8314-495e164d540f", com.pulse.mo.ShiftStatusNotification.class);

		}
		return uuidMap;
	}

}