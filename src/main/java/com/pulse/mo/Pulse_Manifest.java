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
objectList.add(new com.pulse.mo.ShiftStatusNotification());

		}
		return objectList;
	}

	private Map<String, Class> uuidMap = null;
	public Map<String, Class> getUuidMap() {
		if (uuidMap == null) {
			uuidMap = new HashMap<String, Class>();
			uuidMap.put("f03225a0-6c44-400a-bd4e-bb85e257ff56", com.pulse.mo.Client.class);
uuidMap.put("3da31385-63de-4228-9f56-bde0084add73", com.pulse.mo.TimecardActivity.class);
uuidMap.put("d6707bd7-fc9c-44a4-82b3-1ad5c27bcf4c", com.pulse.mo.AdhocCoachingCategory.class);
uuidMap.put("88ad50c6-5809-4b44-9fc5-1d0467658ccb", com.pulse.mo.AdhocTaskState.class);
uuidMap.put("db937d21-7edf-4a36-857b-889e4adfa85d", com.pulse.mo.Notification.class);
uuidMap.put("75380340-7f4a-4c31-97f7-11fe05c133e7", com.pulse.mo.CoachingNotification.class);
uuidMap.put("b5f484df-ca48-4eeb-9077-dd0e809224f8", com.pulse.mo.CoachingSessionState.class);
uuidMap.put("fe18ef6d-d8a4-40cf-89ab-b2f2f957a7d0", com.pulse.mo.Comment.class);
uuidMap.put("6f11bf0a-6028-4187-9e45-799767261691", com.pulse.mo.CorrectiveActionState.class);
uuidMap.put("3cb70127-96ce-4f5b-bfcb-0f7715be1f77", com.pulse.mo.CorrectiveActionType.class);
uuidMap.put("9133cb57-bcf8-4848-b834-429737698c08", com.pulse.mo.Agent.class);
uuidMap.put("809741bf-143c-46f1-a246-d976e9051973", com.pulse.mo.LOB.class);
uuidMap.put("e9436275-2fe6-4cf8-bab5-ec99f3df3a7b", com.pulse.mo.LOBConfiguration.class);
uuidMap.put("364d251f-3cff-4b39-a4b5-fca14856eb3d", com.pulse.mo.LOBConfigurationNotification.class);
uuidMap.put("7f9269fc-f1cd-4fae-84cf-bb5e4f56c72b", com.pulse.mo.DiscrepancyDetectedNotification.class);
uuidMap.put("b8bd6316-1285-4011-a1fd-0f9bd25cdcb5", com.pulse.mo.DurationMismatchNotification.class);
uuidMap.put("68386c4d-8cf3-4911-8334-d17a0462593e", com.pulse.mo.ThresholdExceededNotification.class);
uuidMap.put("a99d1a06-6ede-47c8-ba79-c9d77b4c0ae0", com.pulse.mo.DurationToleranceNotification.class);
uuidMap.put("b018309d-6f41-4d37-a32f-3a5c1d9bef89", com.pulse.mo.Employee.class);
uuidMap.put("e611abf6-f265-4d25-a652-0a02947f3c16", com.pulse.mo.InvalidActivityCodeNotification.class);
uuidMap.put("af64ff59-ce87-4b4b-b203-08d7c2f7bf44", com.pulse.mo.Measure.class);
uuidMap.put("edbdc195-dee9-4c04-a1d4-8e761d86ca40", com.pulse.mo.NonBillableActivityNotification.class);
uuidMap.put("3c15b34d-e30f-4f96-ad70-0e12c005fcae", com.pulse.mo.Alert.class);
uuidMap.put("329b37db-beb1-481d-b135-4488c71605bf", com.pulse.mo.NotificationAlert.class);
uuidMap.put("52ff8246-204b-4d7b-9592-ad3ea3f81477", com.pulse.mo.NotificationFrequency.class);
uuidMap.put("73d8540e-2da7-4ba0-a2c0-25688f9d18d2", com.pulse.mo.OccurrenceMismatchNotification.class);
uuidMap.put("caff494a-57d5-4696-ac45-88ad895f2de4", com.pulse.mo.OccurrenceToleranceNotification.class);
uuidMap.put("30057675-b745-4900-be5b-d28dc6e18682", com.pulse.mo.PulseConfiguration.class);
uuidMap.put("8b00cf88-da69-4078-b5a7-4bc9a0a3d0d5", com.pulse.mo.Role.class);
uuidMap.put("23cd3b72-1b06-445b-b888-40a7a7db1b1b", com.pulse.mo.Scorecard.class);
uuidMap.put("ae921987-30f2-4038-b8b8-78d6d2dd44aa", com.pulse.mo.Site.class);
uuidMap.put("23017f13-189d-4bf7-8f9c-d2665d84a326", com.pulse.mo.TraceLog.class);
uuidMap.put("c51016fe-34d7-457a-ad03-66403d70112b", com.pulse.mo.WorkDurationNotification.class);
uuidMap.put("9c3c3336-c084-4f4c-9900-e75b9377398c", com.pulse.mo.WorkModeOccurrenceNotification.class);
uuidMap.put("bec06e38-d148-4631-8873-6358c81d048c", com.pulse.mo.ClientSite.class);
uuidMap.put("4e3c7529-fc26-4413-9b2c-6186ce89a0e5", com.pulse.mo.CMSEntry.class);
uuidMap.put("8acb66ea-9f0e-4aae-b518-b77e193e8a3e", com.pulse.mo.CMSEntryLOB.class);
uuidMap.put("8a54bffb-bff0-4fb1-85e9-f758b2ea8cfa", com.pulse.mo.Schedule.class);
uuidMap.put("90c7ecc6-48e3-4d15-bad8-e6b8e02d14fc", com.pulse.mo.ScheduleEntry.class);
uuidMap.put("38aabbca-0015-4199-b978-aee8da85e131", com.pulse.mo.Timecard.class);
uuidMap.put("3c6a1b1b-48fa-4c50-8d90-9f0aec281460", com.pulse.mo.TimecardEntry.class);
uuidMap.put("3849f341-3cb3-406d-8b77-668780a68c2e", com.pulse.mo.AdhocCoachingSession.class);
uuidMap.put("fe0525cb-567b-46ea-9f50-7bee7e82c35b", com.pulse.mo.AdhocCoachingSessionAttachment.class);
uuidMap.put("4e5f4a21-b456-47c9-92a9-494c1d65f4c8", com.pulse.mo.AdhocTask.class);
uuidMap.put("f6846db3-4f67-48ea-87d8-f2a5a0f8dd3e", com.pulse.mo.ScorecardWeeklyScore.class);
uuidMap.put("855cb2b1-9f08-43ae-9608-899594818061", com.pulse.mo.AgentScorecard.class);
uuidMap.put("8adae7cc-f744-4f8c-9aa6-815b3f68ff99", com.pulse.mo.Behavior.class);
uuidMap.put("e3f735a8-ed2d-4f9f-a493-dee45988b810", com.pulse.mo.BehaviorResponse.class);
uuidMap.put("be6a2d9e-8921-499c-b727-9a60f02393f3", com.pulse.mo.CoachingSession.class);
uuidMap.put("0ddcfb35-d66b-4aff-9de3-8deb7d302f71", com.pulse.mo.CoachingSessionAttachment.class);
uuidMap.put("da8cb7b2-e223-439c-a385-2b86a2a33977", com.pulse.mo.CorrectiveAction.class);
uuidMap.put("9a3644a1-af73-474f-a540-c76fb786e176", com.pulse.mo.CorrectiveActionAttachment.class);
uuidMap.put("f8cf926d-29bd-460e-a5b7-3a791bfc1e25", com.pulse.mo.DevelopmentActivity.class);
uuidMap.put("6f70e2b3-90b8-4bb9-8c1a-3c923ba3d552", com.pulse.mo.DevelopmentPlan.class);
uuidMap.put("1dc33f05-f0a6-4fef-bf1b-610873df6516", com.pulse.mo.Email.class);
uuidMap.put("8b0cb6d9-1161-494a-8e84-26dc5a2db1e8", com.pulse.mo.Goal.class);
uuidMap.put("250e50f3-197b-402b-b20c-bbfbb9c3eebc", com.pulse.mo.GradeScale.class);
uuidMap.put("20257bfc-649e-4de3-a30b-bbd5814eaaa2", com.pulse.mo.LOBConfigurationEntry.class);
uuidMap.put("df27bfb0-ba5e-4733-9f36-c379beb72da4", com.pulse.mo.TeamLeader.class);
uuidMap.put("f295161a-4e1a-4a22-ab9c-577006901f6b", com.pulse.mo.PulseUser.class);
uuidMap.put("d7800ed6-525f-4aa3-b1cb-44159bfbb944", com.pulse.mo.QualityEvaluation.class);
uuidMap.put("cdcfa960-6116-4566-86f1-c81d696629e1", com.pulse.mo.ScorecardMeasure.class);
uuidMap.put("e1701b62-d2c1-41c8-9783-e3b48212a7cb", com.pulse.mo.ScorecardMonthlyResult.class);
uuidMap.put("bb6f9c6c-8197-41ac-a3c8-429e863b096b", com.pulse.mo.ScorecardMonthlyScore.class);
uuidMap.put("cdcdf145-8e77-406c-8461-ed19c0c61986", com.pulse.mo.ScorecardWeeklyResult.class);
uuidMap.put("a4c3113a-0ae8-4383-ac3f-6dc1357fe125", com.pulse.mo.Setting.class);
uuidMap.put("79bbfc85-aad2-46f3-80a1-1b0ce9235b53", com.pulse.mo.Supervisor.class);
uuidMap.put("c516324e-2a10-418e-a097-8206fa951575", com.pulse.mo.TeamLeaderImpersonation.class);
uuidMap.put("b257462f-5c43-4101-83d0-adcd85a938c6", com.pulse.mo.TraceEntry.class);
uuidMap.put("a0bcb645-707c-44f9-99bb-f7b7d53551ee", com.pulse.mo.UserRole.class);
uuidMap.put("6ddab181-a832-4319-abb1-9fa01e9af30a", com.pulse.mo.UserSession.class);
uuidMap.put("720bc7b7-cc05-4c40-a66a-acc5b64da23c", com.pulse.mo.ShiftStatusNotification.class);

		}
		return uuidMap;
	}

}