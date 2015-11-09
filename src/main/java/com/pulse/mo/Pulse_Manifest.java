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
classList.add(com.pulse.mo.CoachingSessionState.class);
classList.add(com.pulse.mo.Comment.class);
classList.add(com.pulse.mo.CorrectiveActionState.class);
classList.add(com.pulse.mo.CorrectiveActionType.class);
classList.add(com.pulse.mo.Notification.class);
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
classList.add(com.pulse.mo.ScorecardWeeklyScore.class);
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
classList.add(com.pulse.mo.Setting.class);
classList.add(com.pulse.mo.Supervisor.class);
classList.add(com.pulse.mo.TeamLeaderImpersonation.class);
classList.add(com.pulse.mo.TraceEntry.class);
classList.add(com.pulse.mo.UserRole.class);
classList.add(com.pulse.mo.UserSession.class);
classList.add(com.pulse.mo.WeeklyDevelopmentActivity.class);
classList.add(com.pulse.mo.WeeklyDevelopmentPlan.class);
classList.add(com.pulse.mo.CoachingNotification.class);
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
objectList.add(new com.pulse.mo.CoachingSessionState());
objectList.add(new com.pulse.mo.Comment());
objectList.add(new com.pulse.mo.CorrectiveActionState());
objectList.add(new com.pulse.mo.CorrectiveActionType());
objectList.add(new com.pulse.mo.Notification());
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
objectList.add(new com.pulse.mo.ScorecardWeeklyScore());
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
objectList.add(new com.pulse.mo.Setting());
objectList.add(new com.pulse.mo.Supervisor());
objectList.add(new com.pulse.mo.TeamLeaderImpersonation());
objectList.add(new com.pulse.mo.TraceEntry());
objectList.add(new com.pulse.mo.UserRole());
objectList.add(new com.pulse.mo.UserSession());
objectList.add(new com.pulse.mo.WeeklyDevelopmentActivity());
objectList.add(new com.pulse.mo.WeeklyDevelopmentPlan());
objectList.add(new com.pulse.mo.CoachingNotification());
objectList.add(new com.pulse.mo.ShiftStatusNotification());

		}
		return objectList;
	}

	private Map<String, Class> uuidMap = null;
	public Map<String, Class> getUuidMap() {
		if (uuidMap == null) {
			uuidMap = new HashMap<String, Class>();
			uuidMap.put("30e17a68-d9a0-4b07-9b6d-64fc84dc9cf8", com.pulse.mo.Client.class);
uuidMap.put("b25612ea-5578-4000-b76d-c1182b91082a", com.pulse.mo.TimecardActivity.class);
uuidMap.put("5da065af-414d-4119-8dc9-667bbaae5e05", com.pulse.mo.AdhocCoachingCategory.class);
uuidMap.put("5eda7030-1918-4ec2-b8ee-05d1704ff233", com.pulse.mo.AdhocTaskState.class);
uuidMap.put("7890da03-c34d-4b64-9735-873d84279582", com.pulse.mo.CoachingSessionState.class);
uuidMap.put("4cad8949-80c1-4f8d-9d7e-2e9697bdf466", com.pulse.mo.Comment.class);
uuidMap.put("b48fa655-c797-431b-b5ce-a8ff463fe4f1", com.pulse.mo.CorrectiveActionState.class);
uuidMap.put("64dd9146-1022-4b9d-9d76-65889410a91d", com.pulse.mo.CorrectiveActionType.class);
uuidMap.put("0818e3fc-c549-4fe2-8967-19b0b0e4c1bf", com.pulse.mo.Notification.class);
uuidMap.put("d4296f93-d692-4d52-88a1-f2806cdc8f3a", com.pulse.mo.Agent.class);
uuidMap.put("e3f5325b-e8e8-472b-83f5-1728d24a7c22", com.pulse.mo.LOB.class);
uuidMap.put("a13a0757-26a6-43eb-9ee9-651cb900764c", com.pulse.mo.LOBConfiguration.class);
uuidMap.put("4948305d-5549-4674-8390-1c73ed7ba177", com.pulse.mo.LOBConfigurationNotification.class);
uuidMap.put("e107bf79-d5ae-4fd7-b0e3-2abcec7d1c50", com.pulse.mo.DiscrepancyDetectedNotification.class);
uuidMap.put("641fcdd0-cd94-4e79-a3ff-3aa68ad9420a", com.pulse.mo.DurationMismatchNotification.class);
uuidMap.put("2c4e4656-4269-40fe-9f79-29391e297c07", com.pulse.mo.ThresholdExceededNotification.class);
uuidMap.put("b84c87fb-101e-4524-a879-e1853ca1d819", com.pulse.mo.DurationToleranceNotification.class);
uuidMap.put("d285f37a-8745-4bea-860c-372c981ba09c", com.pulse.mo.Employee.class);
uuidMap.put("a2a54b0c-c13a-4f9e-ac23-196ece2a007e", com.pulse.mo.InvalidActivityCodeNotification.class);
uuidMap.put("7c3dd887-160d-4d44-a719-d3d016978f41", com.pulse.mo.Measure.class);
uuidMap.put("87a6111f-48aa-4420-8521-4b92c65dc8c7", com.pulse.mo.NonBillableActivityNotification.class);
uuidMap.put("0a5c1bc4-4840-4356-b03c-438ad765866a", com.pulse.mo.Alert.class);
uuidMap.put("afe3a29a-bf7b-45cf-af54-618d6780da2a", com.pulse.mo.NotificationAlert.class);
uuidMap.put("b4d3800f-144b-492d-ad85-202bd151a110", com.pulse.mo.NotificationFrequency.class);
uuidMap.put("b6519aaf-1fbf-420c-9ba1-0e96c9a3a314", com.pulse.mo.OccurrenceMismatchNotification.class);
uuidMap.put("c86e0d71-a0ef-4800-a987-c3a31c5dd4c6", com.pulse.mo.OccurrenceToleranceNotification.class);
uuidMap.put("bd7285f7-4666-4293-b013-43d263a85772", com.pulse.mo.PulseConfiguration.class);
uuidMap.put("bdb02824-f8bc-4ffd-9f7f-06040ba36863", com.pulse.mo.Role.class);
uuidMap.put("6e84b6f9-cfe1-404f-826e-db810e7b44a4", com.pulse.mo.Scorecard.class);
uuidMap.put("16f19210-9506-4a51-8930-da0adc484c62", com.pulse.mo.Site.class);
uuidMap.put("4a8bb098-97fd-46e6-9aff-df7afc35d031", com.pulse.mo.TraceLog.class);
uuidMap.put("2d25a1a0-cfc7-4de3-a237-fcbda5687924", com.pulse.mo.WorkDurationNotification.class);
uuidMap.put("0d79c7a6-6284-4f6e-a629-1d46afaf4de7", com.pulse.mo.WorkModeOccurrenceNotification.class);
uuidMap.put("611e686a-1487-4e20-8ddb-50f2fe92fc2e", com.pulse.mo.ClientSite.class);
uuidMap.put("46f51b16-26f6-46db-8fc6-534e68b1b09d", com.pulse.mo.CMSEntry.class);
uuidMap.put("8cf02ecc-5bb3-4660-8712-4152c7905b72", com.pulse.mo.CMSEntryLOB.class);
uuidMap.put("00af6929-faee-4991-bb39-bd14d98d18ef", com.pulse.mo.Schedule.class);
uuidMap.put("01cc8dfb-4fee-4cfe-8e69-bf5b5f224e19", com.pulse.mo.ScheduleEntry.class);
uuidMap.put("b36dea11-b556-4965-99d8-19bcdde8404a", com.pulse.mo.Timecard.class);
uuidMap.put("4e3852d6-60f6-4e47-913a-f3613888fbcd", com.pulse.mo.TimecardEntry.class);
uuidMap.put("95aa2a10-d7b8-47a6-a5da-197c9f3ef440", com.pulse.mo.AdhocCoachingSession.class);
uuidMap.put("9eafae84-6f7c-4ba4-a8e8-cf9568564fab", com.pulse.mo.AdhocCoachingSessionAttachment.class);
uuidMap.put("3e2f8805-7d49-4e9b-b893-09fcf861bdc4", com.pulse.mo.AdhocTask.class);
uuidMap.put("334a6e0c-8f81-4bbe-9b4c-e1d65bf66490", com.pulse.mo.ScorecardWeeklyScore.class);
uuidMap.put("70725fdb-9908-4e4a-981a-9e7f4eed9568", com.pulse.mo.AgentScorecard.class);
uuidMap.put("6454d4c2-a26f-40ad-b733-d373f5647c54", com.pulse.mo.Behavior.class);
uuidMap.put("ffab6f7b-412a-427b-ad13-c177e2e3217b", com.pulse.mo.BehaviorResponse.class);
uuidMap.put("493a8a97-acd5-436e-a83a-04125bfb4418", com.pulse.mo.CoachingSession.class);
uuidMap.put("ae7b94e0-2e8e-4d81-ae24-e733fbb35ee3", com.pulse.mo.CoachingSessionAttachment.class);
uuidMap.put("5fe9d71b-fb6b-4ac1-846a-b8c030cabd98", com.pulse.mo.CorrectiveAction.class);
uuidMap.put("1c97ae42-1723-4045-be79-19ec326436fb", com.pulse.mo.CorrectiveActionAttachment.class);
uuidMap.put("53c8c650-ce4e-4466-937e-65bdf0c7df02", com.pulse.mo.DevelopmentActivity.class);
uuidMap.put("1df89617-8801-4d15-b6a1-93392d448b62", com.pulse.mo.DevelopmentPlan.class);
uuidMap.put("244b7ba1-d5ec-4ae4-8df7-49f52a458414", com.pulse.mo.Email.class);
uuidMap.put("7aab94ca-84fe-4e23-94f1-5882bbf8f19e", com.pulse.mo.Goal.class);
uuidMap.put("11c07f15-0806-4974-97fa-5dcfc46f734f", com.pulse.mo.GradeScale.class);
uuidMap.put("50923e9c-ef25-4983-92f9-155b9f11152e", com.pulse.mo.LOBConfigurationEntry.class);
uuidMap.put("80b7c96c-3090-47db-a98b-c04b580b7e26", com.pulse.mo.TeamLeader.class);
uuidMap.put("08d3ab3f-3909-4116-8e20-2f5ee0c6687c", com.pulse.mo.PulseUser.class);
uuidMap.put("b09289ac-7061-4152-bd97-221bb87bfdc6", com.pulse.mo.QualityEvaluation.class);
uuidMap.put("8c717dac-4570-4868-9dda-97be088e1d25", com.pulse.mo.ScorecardMeasure.class);
uuidMap.put("4598d469-bd6e-49a1-bb4c-52570cf8c312", com.pulse.mo.ScorecardMonthlyResult.class);
uuidMap.put("f4d39236-d7bc-4eff-aac2-ed3201961940", com.pulse.mo.ScorecardMonthlyScore.class);
uuidMap.put("b9d1a710-182b-48ea-8c4d-060fce2c2174", com.pulse.mo.ScorecardWeeklyResult.class);
uuidMap.put("3652c445-1414-4516-95c9-0515975126cc", com.pulse.mo.Setting.class);
uuidMap.put("32b5c5c2-d95f-49f9-9a92-6d6b7c46a4f9", com.pulse.mo.Supervisor.class);
uuidMap.put("29242fcd-f8d2-428d-bb5b-bdaa4d21a5f0", com.pulse.mo.TeamLeaderImpersonation.class);
uuidMap.put("d8487931-fb65-4e40-91a4-cb5b14501fd3", com.pulse.mo.TraceEntry.class);
uuidMap.put("2f48cb22-7dcc-4fee-811b-fc19cc13f868", com.pulse.mo.UserRole.class);
uuidMap.put("cc032d7a-ce7c-4121-b6e1-a91ce7ef43e2", com.pulse.mo.UserSession.class);
uuidMap.put("b18c4dde-c026-4642-bf79-5c97c71e33f4", com.pulse.mo.WeeklyDevelopmentActivity.class);
uuidMap.put("1d0cf121-d540-4520-963b-c6fb928c632e", com.pulse.mo.WeeklyDevelopmentPlan.class);
uuidMap.put("135816c6-760e-48a2-aaed-7dcc9ebce2b3", com.pulse.mo.CoachingNotification.class);
uuidMap.put("b65ebaf0-8496-483c-993f-46e283901153", com.pulse.mo.ShiftStatusNotification.class);

		}
		return uuidMap;
	}

}