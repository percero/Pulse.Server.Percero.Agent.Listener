package com.pulse.mo;

import com.percero.framework.bl.IManifest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
classList.add(com.pulse.mo.CMSAuxMode.class);
classList.add(com.pulse.mo.CoachingSessionState.class);
classList.add(com.pulse.mo.ConnectedState.class);
classList.add(com.pulse.mo.CorrectiveActionState.class);
classList.add(com.pulse.mo.CorrectiveActionType.class);
classList.add(com.pulse.mo.CVGProject.class);
classList.add(com.pulse.mo.Notification.class);
classList.add(com.pulse.mo.LOB.class);
classList.add(com.pulse.mo.LOBConfiguration.class);
classList.add(com.pulse.mo.Agent.class);
classList.add(com.pulse.mo.LOBConfigurationNotification.class);
classList.add(com.pulse.mo.DiscrepancyDetectedNotification.class);
classList.add(com.pulse.mo.DurationMismatchNotification.class);
classList.add(com.pulse.mo.ThresholdExceededNotification.class);
classList.add(com.pulse.mo.DurationToleranceNotification.class);
classList.add(com.pulse.mo.EmployeeAcknowledgement.class);
classList.add(com.pulse.mo.HRApproval.class);
classList.add(com.pulse.mo.InvalidActivityCodeNotification.class);
classList.add(com.pulse.mo.ManagerApproval.class);
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
classList.add(com.pulse.mo.ScorecardState.class);
classList.add(com.pulse.mo.Site.class);
classList.add(com.pulse.mo.SupervisorAcknowledgement.class);
classList.add(com.pulse.mo.ThresholdGradeScale.class);
classList.add(com.pulse.mo.ThresholdScale.class);
classList.add(com.pulse.mo.TraceLog.class);
classList.add(com.pulse.mo.WorkDurationNotification.class);
classList.add(com.pulse.mo.WorkModeOccurrenceNotification.class);
classList.add(com.pulse.mo.CMSEntry.class);
classList.add(com.pulse.mo.Timecard.class);
classList.add(com.pulse.mo.AdhocCoachingSession.class);
classList.add(com.pulse.mo.AdhocTask.class);
classList.add(com.pulse.mo.Scorecard.class);
classList.add(com.pulse.mo.AgentScorecard.class);
classList.add(com.pulse.mo.Attachment.class);
classList.add(com.pulse.mo.Behavior.class);
classList.add(com.pulse.mo.Client.class);
classList.add(com.pulse.mo.CoachingSession.class);
classList.add(com.pulse.mo.CoachingSessionMeasure.class);
classList.add(com.pulse.mo.CorrectiveAction.class);
classList.add(com.pulse.mo.DevelopmentActivity.class);
classList.add(com.pulse.mo.Email.class);
classList.add(com.pulse.mo.GeneralComment.class);
classList.add(com.pulse.mo.TimecardActivity.class);
classList.add(com.pulse.mo.LOBConfigurationEntry.class);
classList.add(com.pulse.mo.Observation.class);
classList.add(com.pulse.mo.TeamLeader.class);
classList.add(com.pulse.mo.PulseUser.class);
classList.add(com.pulse.mo.QualityEvaluation.class);
classList.add(com.pulse.mo.ScheduledTime.class);
classList.add(com.pulse.mo.ScheduledTimeEntry.class);
classList.add(com.pulse.mo.Setting.class);
classList.add(com.pulse.mo.Supervisor.class);
classList.add(com.pulse.mo.TeamLeaderAction.class);
classList.add(com.pulse.mo.TeamLeaderImpersonation.class);
classList.add(com.pulse.mo.ThresholdLevel.class);
classList.add(com.pulse.mo.TimecardEntry.class);
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
			objectList.add(new com.pulse.mo.AdhocCoachingCategory());
objectList.add(new com.pulse.mo.AdhocTaskState());
objectList.add(new com.pulse.mo.CMSAuxMode());
objectList.add(new com.pulse.mo.CoachingSessionState());
objectList.add(new com.pulse.mo.ConnectedState());
objectList.add(new com.pulse.mo.CorrectiveActionState());
objectList.add(new com.pulse.mo.CorrectiveActionType());
objectList.add(new com.pulse.mo.CVGProject());
objectList.add(new com.pulse.mo.Notification());
objectList.add(new com.pulse.mo.LOB());
objectList.add(new com.pulse.mo.LOBConfiguration());
objectList.add(new com.pulse.mo.Agent());
objectList.add(new com.pulse.mo.LOBConfigurationNotification());
objectList.add(new com.pulse.mo.DiscrepancyDetectedNotification());
objectList.add(new com.pulse.mo.DurationMismatchNotification());
objectList.add(new com.pulse.mo.ThresholdExceededNotification());
objectList.add(new com.pulse.mo.DurationToleranceNotification());
objectList.add(new com.pulse.mo.EmployeeAcknowledgement());
objectList.add(new com.pulse.mo.HRApproval());
objectList.add(new com.pulse.mo.InvalidActivityCodeNotification());
objectList.add(new com.pulse.mo.ManagerApproval());
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
objectList.add(new com.pulse.mo.ScorecardState());
objectList.add(new com.pulse.mo.Site());
objectList.add(new com.pulse.mo.SupervisorAcknowledgement());
objectList.add(new com.pulse.mo.ThresholdGradeScale());
objectList.add(new com.pulse.mo.ThresholdScale());
objectList.add(new com.pulse.mo.TraceLog());
objectList.add(new com.pulse.mo.WorkDurationNotification());
objectList.add(new com.pulse.mo.WorkModeOccurrenceNotification());
objectList.add(new com.pulse.mo.CMSEntry());
objectList.add(new com.pulse.mo.Timecard());
objectList.add(new com.pulse.mo.AdhocCoachingSession());
objectList.add(new com.pulse.mo.AdhocTask());
objectList.add(new com.pulse.mo.Scorecard());
objectList.add(new com.pulse.mo.AgentScorecard());
objectList.add(new com.pulse.mo.Attachment());
objectList.add(new com.pulse.mo.Behavior());
objectList.add(new com.pulse.mo.Client());
objectList.add(new com.pulse.mo.CoachingSession());
objectList.add(new com.pulse.mo.CoachingSessionMeasure());
objectList.add(new com.pulse.mo.CorrectiveAction());
objectList.add(new com.pulse.mo.DevelopmentActivity());
objectList.add(new com.pulse.mo.Email());
objectList.add(new com.pulse.mo.GeneralComment());
objectList.add(new com.pulse.mo.TimecardActivity());
objectList.add(new com.pulse.mo.LOBConfigurationEntry());
objectList.add(new com.pulse.mo.Observation());
objectList.add(new com.pulse.mo.TeamLeader());
objectList.add(new com.pulse.mo.PulseUser());
objectList.add(new com.pulse.mo.QualityEvaluation());
objectList.add(new com.pulse.mo.ScheduledTime());
objectList.add(new com.pulse.mo.ScheduledTimeEntry());
objectList.add(new com.pulse.mo.Setting());
objectList.add(new com.pulse.mo.Supervisor());
objectList.add(new com.pulse.mo.TeamLeaderAction());
objectList.add(new com.pulse.mo.TeamLeaderImpersonation());
objectList.add(new com.pulse.mo.ThresholdLevel());
objectList.add(new com.pulse.mo.TimecardEntry());
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
			uuidMap.put("603caa1d-d5e4-4aeb-be28-8a3bac89c2be", com.pulse.mo.AdhocCoachingCategory.class);
uuidMap.put("1595e101-fffc-40eb-a1ef-df6083f58253", com.pulse.mo.AdhocTaskState.class);
uuidMap.put("a7466463-5d6c-4e2b-8b2b-d2079cbf1bc4", com.pulse.mo.CMSAuxMode.class);
uuidMap.put("bef107a0-d744-4646-a6fd-3cf5f0a07cd3", com.pulse.mo.CoachingSessionState.class);
uuidMap.put("a3b559fd-6d03-4d5e-b87d-4dc8c1b1c651", com.pulse.mo.ConnectedState.class);
uuidMap.put("76d21a23-d38d-48d8-b326-f4d0d3e496cb", com.pulse.mo.CorrectiveActionState.class);
uuidMap.put("1d277b25-5666-47f6-975b-980538f65d27", com.pulse.mo.CorrectiveActionType.class);
uuidMap.put("d2195320-4f0a-404e-b4fa-d3ac5f50b945", com.pulse.mo.CVGProject.class);
uuidMap.put("67427554-f07c-49fb-804c-a89a79ec6e4c", com.pulse.mo.Notification.class);
uuidMap.put("480ef2a2-2b81-460e-96a7-66e5e968c1b2", com.pulse.mo.LOB.class);
uuidMap.put("f70cd675-fb3f-4d54-a1b6-ba3d3f6f472d", com.pulse.mo.LOBConfiguration.class);
uuidMap.put("94dc4574-38d0-4f78-9e9c-8d71a2eccbb5", com.pulse.mo.Agent.class);
uuidMap.put("aab3f12f-dfd1-4ee4-bec5-6bed16a4515c", com.pulse.mo.LOBConfigurationNotification.class);
uuidMap.put("41415e16-f841-4a3a-8074-12eb25ee8610", com.pulse.mo.DiscrepancyDetectedNotification.class);
uuidMap.put("fc6cef14-3a4a-4285-91e0-d437f39f1e9f", com.pulse.mo.DurationMismatchNotification.class);
uuidMap.put("0f3aaf63-9775-413a-8d08-a8356a04ee8e", com.pulse.mo.ThresholdExceededNotification.class);
uuidMap.put("02c0c5a1-565c-4f1b-864b-b7e49c831fc6", com.pulse.mo.DurationToleranceNotification.class);
uuidMap.put("674db933-50c6-4f64-9c25-5b238189623c", com.pulse.mo.EmployeeAcknowledgement.class);
uuidMap.put("e8d1f7bc-d09e-426f-99be-9985e1bc4fd7", com.pulse.mo.HRApproval.class);
uuidMap.put("dd8ebc91-67dc-4feb-9b5b-cf25b462d3b0", com.pulse.mo.InvalidActivityCodeNotification.class);
uuidMap.put("59aad5cd-fee4-4297-a0f7-6d483717c44e", com.pulse.mo.ManagerApproval.class);
uuidMap.put("70309762-1365-43d1-af95-f31794b3105f", com.pulse.mo.NonBillableActivityNotification.class);
uuidMap.put("103d16be-892c-4460-bace-a84f938b0c11", com.pulse.mo.Alert.class);
uuidMap.put("6b9270e2-3157-4e87-a29e-0ef5e10fa444", com.pulse.mo.NotificationAlert.class);
uuidMap.put("889cc895-b855-480e-907e-476f5d8ad631", com.pulse.mo.NotificationFrequency.class);
uuidMap.put("c9167973-11a5-4c85-8e6e-086a41aa361f", com.pulse.mo.OccurrenceMismatchNotification.class);
uuidMap.put("cafd0eb4-9745-4149-a9f6-5ba9f01e0f68", com.pulse.mo.OccurrenceToleranceNotification.class);
uuidMap.put("d7a0d9b6-c86e-4d60-a47d-b5bbf0fc774d", com.pulse.mo.PayrollDetail.class);
uuidMap.put("fa78232e-5c3f-4b8d-9f89-2ed52058c473", com.pulse.mo.PerformanceSummary.class);
uuidMap.put("98b44a3d-1201-4075-bc53-0e655beaf8c1", com.pulse.mo.PulseConfiguration.class);
uuidMap.put("3350b2f1-c300-457b-b9f2-6273a4cbe74d", com.pulse.mo.Role.class);
uuidMap.put("8008fd6c-7bc5-410f-aa17-6285c57ffd38", com.pulse.mo.ScheduledActivityCode.class);
uuidMap.put("d5ad6a7f-17c1-4a77-891c-7ef59324051b", com.pulse.mo.ScheduledActivityType.class);
uuidMap.put("a1d454ca-c193-4880-ba10-2f02abef3aca", com.pulse.mo.ScorecardState.class);
uuidMap.put("459e6dd5-7848-4ad7-bb27-58a4ba6a4fe3", com.pulse.mo.Site.class);
uuidMap.put("1b4ffc89-44b1-46fa-8d76-20e79ed416af", com.pulse.mo.SupervisorAcknowledgement.class);
uuidMap.put("be7e83a8-cc2f-42da-a852-240da612bfb8", com.pulse.mo.ThresholdGradeScale.class);
uuidMap.put("b67489a1-115b-4472-bf95-80b9db2e258a", com.pulse.mo.ThresholdScale.class);
uuidMap.put("13dcaf7d-5647-4ba6-be9e-8858c482d923", com.pulse.mo.TraceLog.class);
uuidMap.put("1760ba0f-cd38-4979-986a-40ca54175c3c", com.pulse.mo.WorkDurationNotification.class);
uuidMap.put("b3385c0b-5eae-4c25-98ef-51211a1173e1", com.pulse.mo.WorkModeOccurrenceNotification.class);
uuidMap.put("e68429c0-0a6b-4c9e-a02f-c82908914628", com.pulse.mo.CMSEntry.class);
uuidMap.put("d5fb966e-89aa-4eb8-9b1e-899a3781e9ed", com.pulse.mo.Timecard.class);
uuidMap.put("f44a088a-dc6d-4080-b0d9-dbd3a7769b6b", com.pulse.mo.AdhocCoachingSession.class);
uuidMap.put("b6428eff-e9ff-489b-8366-d8b3d65cbfdf", com.pulse.mo.AdhocTask.class);
uuidMap.put("3690d10b-f02d-40d4-b7bd-e40502d56283", com.pulse.mo.Scorecard.class);
uuidMap.put("0a248280-be0d-4df0-850d-afbf6175b861", com.pulse.mo.AgentScorecard.class);
uuidMap.put("4c1ee1ac-b081-4e8a-8c4a-3dd9c219349d", com.pulse.mo.Attachment.class);
uuidMap.put("52b21dd5-ae2d-4eca-83ab-bee0dc598ec1", com.pulse.mo.Behavior.class);
uuidMap.put("a57e9f14-c85f-49f0-9567-2c3c73e3ffbd", com.pulse.mo.Client.class);
uuidMap.put("49f02919-c672-4eef-a419-61cbc4278acc", com.pulse.mo.CoachingSession.class);
uuidMap.put("4479cc2b-7aa5-4d5b-aac5-9bdd2bab2cb3", com.pulse.mo.CoachingSessionMeasure.class);
uuidMap.put("8c202515-d37b-4211-841e-305d88f35737", com.pulse.mo.CorrectiveAction.class);
uuidMap.put("e1b354da-ca40-4709-9e08-8af0b9df982d", com.pulse.mo.DevelopmentActivity.class);
uuidMap.put("651cbf7e-c670-46c9-bc73-acc0b8df5ba6", com.pulse.mo.Email.class);
uuidMap.put("2da154a7-eed2-4108-a436-ca79a5bbeb5b", com.pulse.mo.GeneralComment.class);
uuidMap.put("8a3e411a-a55e-4635-9962-f956fa293418", com.pulse.mo.TimecardActivity.class);
uuidMap.put("48e50afe-8c08-4e7e-b095-9e2631bcc1f1", com.pulse.mo.LOBConfigurationEntry.class);
uuidMap.put("73aab702-ab12-44e8-a902-4a738a97f53e", com.pulse.mo.Observation.class);
uuidMap.put("f40e5c4d-da87-4880-9b17-f1b52dfa2fb7", com.pulse.mo.TeamLeader.class);
uuidMap.put("40f6396b-5152-4bcd-8301-669b9147265c", com.pulse.mo.PulseUser.class);
uuidMap.put("7eda6201-0d73-47b5-b702-2d7835676c09", com.pulse.mo.QualityEvaluation.class);
uuidMap.put("26b36114-38b9-420a-aa48-df78917ab94b", com.pulse.mo.ScheduledTime.class);
uuidMap.put("1c7eb75a-85c2-4f14-b68d-6da488712db2", com.pulse.mo.ScheduledTimeEntry.class);
uuidMap.put("93bca5e5-384b-4a9e-b6a7-99e892697faf", com.pulse.mo.Setting.class);
uuidMap.put("ac78d0bd-73a2-4964-8694-264ddd28eb7c", com.pulse.mo.Supervisor.class);
uuidMap.put("24e06120-8625-49ba-b36f-df2d047caf68", com.pulse.mo.TeamLeaderAction.class);
uuidMap.put("7e7db308-a0c3-463a-aaf5-9628be2073c5", com.pulse.mo.TeamLeaderImpersonation.class);
uuidMap.put("604aca31-6c30-4aaa-8e9f-17417b9a2df1", com.pulse.mo.ThresholdLevel.class);
uuidMap.put("af488056-b71f-436e-99b3-9151984576d9", com.pulse.mo.TimecardEntry.class);
uuidMap.put("31672814-60b1-471b-956f-0a3c26dca430", com.pulse.mo.TraceEntry.class);
uuidMap.put("89addfe2-d39d-42e1-b59f-a97d0b75274e", com.pulse.mo.UserRole.class);
uuidMap.put("8cfaa3ca-5bdc-4254-8b5e-df295fcef34a", com.pulse.mo.UserSession.class);
uuidMap.put("ce96b7b0-2faa-4796-93bd-531d5da1d00b", com.pulse.mo.ChangesNotApprovedNotification.class);
uuidMap.put("02bb8db8-b9de-4350-b126-7e960ae66d0d", com.pulse.mo.CoachingNotification.class);

		}
		return uuidMap;
	}

}