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
			uuidMap.put("b498efab-9f82-4747-8b28-2d41a6a6d4bf", com.pulse.mo.Client.class);
uuidMap.put("629fbbd3-a658-40eb-8c04-ffbc5b261deb", com.pulse.mo.TimecardActivity.class);
uuidMap.put("1fd57323-4ca3-4766-8aea-1d8d7635196a", com.pulse.mo.AdhocCoachingCategory.class);
uuidMap.put("b82cadd2-0375-4a5d-8040-ebbca136fa3d", com.pulse.mo.AdhocTaskState.class);
uuidMap.put("0b8e1eb0-228f-4ecf-a4ca-f782d3b8cfdc", com.pulse.mo.Notification.class);
uuidMap.put("2b78826e-76da-422e-a0e8-12dfee7165ba", com.pulse.mo.CoachingNotification.class);
uuidMap.put("0a761c2d-e67b-4238-ac8f-24fdb1527f7c", com.pulse.mo.CoachingSessionState.class);
uuidMap.put("62c11aa4-7f76-42dd-855f-cfa2baad1c0f", com.pulse.mo.Comment.class);
uuidMap.put("28ad0690-cd76-4773-8e12-c98eae4aea1d", com.pulse.mo.CorrectiveActionState.class);
uuidMap.put("7a2659ad-6950-4842-abd0-c740c771cecf", com.pulse.mo.CorrectiveActionType.class);
uuidMap.put("2e6bd1ec-0808-40f8-ba48-f593649cfe44", com.pulse.mo.Agent.class);
uuidMap.put("4702ad1c-7c33-4246-87ad-9b590550b408", com.pulse.mo.LOB.class);
uuidMap.put("b28a2cb6-0849-46ad-a232-001182b2255b", com.pulse.mo.LOBConfiguration.class);
uuidMap.put("ecaff81b-c2dd-40fb-8b3c-1f1c129fcb65", com.pulse.mo.LOBConfigurationNotification.class);
uuidMap.put("155473d8-3ed0-4fd2-b30f-00010e3e0049", com.pulse.mo.DiscrepancyDetectedNotification.class);
uuidMap.put("f464e336-4819-43c8-b15e-4f42dda310bc", com.pulse.mo.DurationMismatchNotification.class);
uuidMap.put("894c8cc4-b233-4b51-958d-b41783fac0f3", com.pulse.mo.ThresholdExceededNotification.class);
uuidMap.put("359229dc-5b4c-431f-a6ab-93b04642791c", com.pulse.mo.DurationToleranceNotification.class);
uuidMap.put("b22323a0-dce6-441e-ae1d-1a7007da4a86", com.pulse.mo.Employee.class);
uuidMap.put("a0e28a5a-cd52-4f69-909f-cec2aa104f55", com.pulse.mo.InvalidActivityCodeNotification.class);
uuidMap.put("347cddea-42d8-42a1-84aa-161bd3014da5", com.pulse.mo.Measure.class);
uuidMap.put("640a7e84-6b30-4fd6-a485-51339bee8dde", com.pulse.mo.NonBillableActivityNotification.class);
uuidMap.put("02ec037f-45a4-4c47-8aee-2768e582cdea", com.pulse.mo.Alert.class);
uuidMap.put("dfdee1e7-37de-41a2-a709-ac3ff8a41575", com.pulse.mo.NotificationAlert.class);
uuidMap.put("c63e9804-b4ba-4233-9be0-3080912018b9", com.pulse.mo.NotificationFrequency.class);
uuidMap.put("91d66558-2a69-44fc-b666-f594a97222c2", com.pulse.mo.OccurrenceMismatchNotification.class);
uuidMap.put("aae991d5-4e3b-4764-b2f7-8668dc10d554", com.pulse.mo.OccurrenceToleranceNotification.class);
uuidMap.put("9c869ef9-c678-42dc-8e64-9ed67322c55a", com.pulse.mo.PulseConfiguration.class);
uuidMap.put("d1358da3-932e-412f-ac78-5be08dbaeced", com.pulse.mo.Role.class);
uuidMap.put("34ff744b-0678-4b0b-bf67-69a5f6c6260a", com.pulse.mo.Scorecard.class);
uuidMap.put("650c8874-9e8f-4a7e-a7cd-680c0743242c", com.pulse.mo.Site.class);
uuidMap.put("4af1e72c-5e79-4300-907d-aa32fb1bf85a", com.pulse.mo.TraceLog.class);
uuidMap.put("38494e05-5ade-4c29-bf93-3005cc0ee6d6", com.pulse.mo.WorkDurationNotification.class);
uuidMap.put("efb6df02-2761-472d-869b-402679d0d882", com.pulse.mo.WorkModeOccurrenceNotification.class);
uuidMap.put("a9444c75-30b5-4aa3-938c-919279eee8a4", com.pulse.mo.ClientSite.class);
uuidMap.put("b8b0797b-7cf5-4bd1-83ee-0c2796b4ee3b", com.pulse.mo.CMSEntry.class);
uuidMap.put("9829891a-fb5b-4c3f-9957-c74ea0381795", com.pulse.mo.CMSEntryLOB.class);
uuidMap.put("e695f3ce-53d3-46f8-8620-4a4520c2df9b", com.pulse.mo.Schedule.class);
uuidMap.put("790deab9-2a25-481d-a480-b08612abcaab", com.pulse.mo.ScheduleEntry.class);
uuidMap.put("60e14210-4d12-4259-a60b-0712e2102fa2", com.pulse.mo.Timecard.class);
uuidMap.put("c88ea139-6526-4a34-a609-fd4a0fd566f2", com.pulse.mo.TimecardEntry.class);
uuidMap.put("e89d49e8-b14b-4bea-9212-929eeb9a4ab3", com.pulse.mo.AdhocCoachingSession.class);
uuidMap.put("52b3016a-6c05-4a6a-b15b-7f3a633844ed", com.pulse.mo.AdhocCoachingSessionAttachment.class);
uuidMap.put("236c2a96-20d6-41d6-9c45-606ddb03d3e8", com.pulse.mo.AdhocTask.class);
uuidMap.put("7f2e552d-2fd3-4f1a-8bee-a8aacab8598f", com.pulse.mo.ScorecardWeeklyScore.class);
uuidMap.put("5429d9da-eab4-4f38-a0c5-bec8f8e9b82d", com.pulse.mo.AgentScorecard.class);
uuidMap.put("b4ccdf0f-edea-4cf8-9527-0d9d2c4145f7", com.pulse.mo.Behavior.class);
uuidMap.put("1655d544-eeac-4859-ac73-47016bd180e3", com.pulse.mo.BehaviorResponse.class);
uuidMap.put("bcd915f3-e2ef-4cc6-aec3-fb72dda5a34b", com.pulse.mo.CoachingSession.class);
uuidMap.put("c1cb32a5-9fa9-41c4-87c8-d237f483e176", com.pulse.mo.CoachingSessionAttachment.class);
uuidMap.put("d694fe5f-58aa-4fa6-ba45-8ccba8a672a1", com.pulse.mo.CorrectiveAction.class);
uuidMap.put("8a64c459-0a25-4666-9af2-d750deb4878d", com.pulse.mo.CorrectiveActionAttachment.class);
uuidMap.put("7e2b0400-05a2-49bb-8a60-5bfcadb1a6d1", com.pulse.mo.DevelopmentActivity.class);
uuidMap.put("59db446d-d2da-472c-be1e-0b8e0c86034b", com.pulse.mo.DevelopmentPlan.class);
uuidMap.put("9e6744b4-1dc6-4727-ab2d-097cefa95cef", com.pulse.mo.Email.class);
uuidMap.put("5ee65a46-e9ce-456e-9066-58f0b3e55916", com.pulse.mo.Goal.class);
uuidMap.put("e1ec774e-5165-45ef-9266-5ab1419eaa4d", com.pulse.mo.GradeScale.class);
uuidMap.put("5ab2539e-3051-4962-9812-205523561d69", com.pulse.mo.LOBConfigurationEntry.class);
uuidMap.put("ce6102ca-6dc5-451f-8d3c-efe7f0722edb", com.pulse.mo.TeamLeader.class);
uuidMap.put("94a185ed-ee3d-4511-a5ba-98b68742271c", com.pulse.mo.PulseUser.class);
uuidMap.put("47501f84-9895-4442-8c61-0e5be65de872", com.pulse.mo.QualityEvaluation.class);
uuidMap.put("f71ef3af-1a73-4557-85a6-b10f737133f1", com.pulse.mo.ScorecardMeasure.class);
uuidMap.put("b02c8eb3-d9c0-4874-80a9-ee1a45545a99", com.pulse.mo.ScorecardMonthlyResult.class);
uuidMap.put("a23c65f4-5619-4ae2-a0a6-5f551c4ffe1d", com.pulse.mo.ScorecardMonthlyScore.class);
uuidMap.put("afedf94a-e233-4803-aec1-52c4d7a47be4", com.pulse.mo.ScorecardWeeklyResult.class);
uuidMap.put("e8ae474f-4650-4c80-8619-fec4424e2f35", com.pulse.mo.Setting.class);
uuidMap.put("69c183d6-ef17-4c87-949a-9996816527c5", com.pulse.mo.Supervisor.class);
uuidMap.put("ab681d34-26fe-4d85-abb2-bfef973de7d5", com.pulse.mo.TeamLeaderImpersonation.class);
uuidMap.put("ffe94092-62c2-4e24-93e1-e22af3b68627", com.pulse.mo.TraceEntry.class);
uuidMap.put("f9311b1d-2895-43c4-abec-c06d8ac67438", com.pulse.mo.UserRole.class);
uuidMap.put("e17853ce-476e-44e0-8e80-5154480aa127", com.pulse.mo.UserSession.class);
uuidMap.put("8e73d4a6-e10d-40bc-ac74-c15ed73395b8", com.pulse.mo.ShiftStatusNotification.class);

		}
		return uuidMap;
	}

}