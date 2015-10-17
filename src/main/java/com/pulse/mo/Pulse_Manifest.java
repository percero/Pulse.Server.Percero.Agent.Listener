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
classList.add(com.pulse.mo.AdhocTaskState.class);
classList.add(com.pulse.mo.Behavior.class);
classList.add(com.pulse.mo.Notification.class);
classList.add(com.pulse.mo.CoachingNotification.class);
classList.add(com.pulse.mo.CoachingSessionState.class);
classList.add(com.pulse.mo.CorrectiveActionState.class);
classList.add(com.pulse.mo.CorrectiveActionType.class);
classList.add(com.pulse.mo.DevelopmentPlan.class);
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
classList.add(com.pulse.mo.PayrollDetail.class);
classList.add(com.pulse.mo.PerformanceSummary.class);
classList.add(com.pulse.mo.PulseConfiguration.class);
classList.add(com.pulse.mo.Role.class);
classList.add(com.pulse.mo.Scorecard.class);
classList.add(com.pulse.mo.Site.class);
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
classList.add(com.pulse.mo.TimecardEntry.class);
classList.add(com.pulse.mo.AdhocCoachingSession.class);
classList.add(com.pulse.mo.AdhocTask.class);
classList.add(com.pulse.mo.AgentScorecard.class);
classList.add(com.pulse.mo.BehaviorResponse.class);
classList.add(com.pulse.mo.CoachingSession.class);
classList.add(com.pulse.mo.CoachingSessionAttachment.class);
classList.add(com.pulse.mo.Comment.class);
classList.add(com.pulse.mo.Supervisor.class);
classList.add(com.pulse.mo.CorrectiveAction.class);
classList.add(com.pulse.mo.DevelopmentActivity.class);
classList.add(com.pulse.mo.Email.class);
classList.add(com.pulse.mo.LOBConfigurationEntry.class);
classList.add(com.pulse.mo.TeamLeader.class);
classList.add(com.pulse.mo.PulseUser.class);
classList.add(com.pulse.mo.QualityEvaluation.class);
classList.add(com.pulse.mo.ScorecardMeasure.class);
classList.add(com.pulse.mo.ScorecardMeasureMonthlyResult.class);
classList.add(com.pulse.mo.ScorecardMeasureWeeklyResult.class);
classList.add(com.pulse.mo.Setting.class);
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
			objectList.add(new com.pulse.mo.TimecardActivity());
objectList.add(new com.pulse.mo.AdhocCoachingCategory());
objectList.add(new com.pulse.mo.AdhocTaskState());
objectList.add(new com.pulse.mo.Behavior());
objectList.add(new com.pulse.mo.Notification());
objectList.add(new com.pulse.mo.CoachingNotification());
objectList.add(new com.pulse.mo.CoachingSessionState());
objectList.add(new com.pulse.mo.CorrectiveActionState());
objectList.add(new com.pulse.mo.CorrectiveActionType());
objectList.add(new com.pulse.mo.DevelopmentPlan());
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
objectList.add(new com.pulse.mo.PayrollDetail());
objectList.add(new com.pulse.mo.PerformanceSummary());
objectList.add(new com.pulse.mo.PulseConfiguration());
objectList.add(new com.pulse.mo.Role());
objectList.add(new com.pulse.mo.Scorecard());
objectList.add(new com.pulse.mo.Site());
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
objectList.add(new com.pulse.mo.TimecardEntry());
objectList.add(new com.pulse.mo.AdhocCoachingSession());
objectList.add(new com.pulse.mo.AdhocTask());
objectList.add(new com.pulse.mo.AgentScorecard());
objectList.add(new com.pulse.mo.BehaviorResponse());
objectList.add(new com.pulse.mo.CoachingSession());
objectList.add(new com.pulse.mo.CoachingSessionAttachment());
objectList.add(new com.pulse.mo.Comment());
objectList.add(new com.pulse.mo.Supervisor());
objectList.add(new com.pulse.mo.CorrectiveAction());
objectList.add(new com.pulse.mo.DevelopmentActivity());
objectList.add(new com.pulse.mo.Email());
objectList.add(new com.pulse.mo.LOBConfigurationEntry());
objectList.add(new com.pulse.mo.TeamLeader());
objectList.add(new com.pulse.mo.PulseUser());
objectList.add(new com.pulse.mo.QualityEvaluation());
objectList.add(new com.pulse.mo.ScorecardMeasure());
objectList.add(new com.pulse.mo.ScorecardMeasureMonthlyResult());
objectList.add(new com.pulse.mo.ScorecardMeasureWeeklyResult());
objectList.add(new com.pulse.mo.Setting());
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
			uuidMap.put("aed2699d-210e-42c2-b46d-3e1c067b918b", com.pulse.mo.TimecardActivity.class);
uuidMap.put("69e76405-56d3-4e7c-91a4-e7233c92fbfe", com.pulse.mo.AdhocCoachingCategory.class);
uuidMap.put("ce748316-15b0-40a2-b8d4-a94920b1ad54", com.pulse.mo.AdhocTaskState.class);
uuidMap.put("a96d5d35-7251-45da-87f9-72bdc16891cd", com.pulse.mo.Behavior.class);
uuidMap.put("5f81f0c5-c207-4566-9b26-5f7171303f47", com.pulse.mo.Notification.class);
uuidMap.put("cd697760-4338-4873-b412-2375d132daeb", com.pulse.mo.CoachingNotification.class);
uuidMap.put("0c9e2db1-ba3f-4935-ad4a-15ae4a5a9c5c", com.pulse.mo.CoachingSessionState.class);
uuidMap.put("6c4c84b6-8182-4366-b39c-1c54568adaed", com.pulse.mo.CorrectiveActionState.class);
uuidMap.put("d62e3450-431a-4691-aaee-b4b7f3c00796", com.pulse.mo.CorrectiveActionType.class);
uuidMap.put("5f9c1524-df63-4964-9cec-9df9458dc915", com.pulse.mo.DevelopmentPlan.class);
uuidMap.put("242a4405-9bc3-45d2-b61a-75f070fa3924", com.pulse.mo.Agent.class);
uuidMap.put("d3694356-7290-41e9-9273-eda8e423f076", com.pulse.mo.LOB.class);
uuidMap.put("77e6e153-4a7a-49d5-b97a-da454ae728d6", com.pulse.mo.LOBConfiguration.class);
uuidMap.put("aa79adbd-66a4-4d2b-9987-bc84955d9011", com.pulse.mo.LOBConfigurationNotification.class);
uuidMap.put("9582c6a0-bb76-4215-9368-f516adca4b00", com.pulse.mo.DiscrepancyDetectedNotification.class);
uuidMap.put("79dfc012-634d-43cb-85b8-6263afd77c41", com.pulse.mo.DurationMismatchNotification.class);
uuidMap.put("f1c6fc20-de46-448b-88b1-33094b7ef414", com.pulse.mo.ThresholdExceededNotification.class);
uuidMap.put("09250ff1-e737-4066-be1e-e7287997c508", com.pulse.mo.DurationToleranceNotification.class);
uuidMap.put("e59a1199-d64c-4a20-a112-f31be281536a", com.pulse.mo.Employee.class);
uuidMap.put("4632475d-4663-443b-bd18-1a8b79ee4adf", com.pulse.mo.InvalidActivityCodeNotification.class);
uuidMap.put("1476992e-e67d-4842-a463-5b143b784aa8", com.pulse.mo.Measure.class);
uuidMap.put("c7242f64-4d14-4173-a162-c7d3bb6ec322", com.pulse.mo.NonBillableActivityNotification.class);
uuidMap.put("75c8c9c9-2a82-41af-94f6-cfe9c4f86d78", com.pulse.mo.Alert.class);
uuidMap.put("99e3dc42-042e-483f-8625-43f98acd7c7f", com.pulse.mo.NotificationAlert.class);
uuidMap.put("09f99963-7657-4a71-8ebf-2083b7a402bc", com.pulse.mo.NotificationFrequency.class);
uuidMap.put("08df1c1e-d367-43f9-82d7-8f84ca7c5e6d", com.pulse.mo.OccurrenceMismatchNotification.class);
uuidMap.put("2fdf70f0-0998-40a6-90c8-67e41d45e7db", com.pulse.mo.OccurrenceToleranceNotification.class);
uuidMap.put("260cb5d7-6a87-40fc-a506-141dcac5a9ce", com.pulse.mo.PayrollDetail.class);
uuidMap.put("838464ee-40ce-4aa5-98e0-944bb41556b7", com.pulse.mo.PerformanceSummary.class);
uuidMap.put("bf823e14-5bc1-4751-b4c5-bb8afd783e67", com.pulse.mo.PulseConfiguration.class);
uuidMap.put("ce4eadfa-c3a5-4b2d-84c0-cc07955f15b9", com.pulse.mo.Role.class);
uuidMap.put("62892d61-2004-4f3d-9348-c13629f6aff5", com.pulse.mo.Scorecard.class);
uuidMap.put("11fc91c0-fc34-4852-85bb-67e2ec113469", com.pulse.mo.Site.class);
uuidMap.put("d51c27e5-0a25-4c55-8624-a4a3c63814c7", com.pulse.mo.ThresholdGradeScale.class);
uuidMap.put("05a5ef0d-8110-47c2-b5b4-db3023c2ecf1", com.pulse.mo.ThresholdScale.class);
uuidMap.put("720503f0-a0ed-4b4f-8c13-bb0e349191de", com.pulse.mo.TraceLog.class);
uuidMap.put("c9152b23-c522-4dbb-9884-9dd400d145d1", com.pulse.mo.WorkDurationNotification.class);
uuidMap.put("bbb21bff-5194-4c3c-88e1-b6d34b597fe7", com.pulse.mo.WorkModeOccurrenceNotification.class);
uuidMap.put("c3e1db94-d877-48bb-9850-b71be1c744ad", com.pulse.mo.Client.class);
uuidMap.put("3f2d9db9-78d9-4afb-98d7-2b335207ba75", com.pulse.mo.CMSEntry.class);
uuidMap.put("17cb7e2a-6ec1-4d9a-a417-e9f65b77be48", com.pulse.mo.Schedule.class);
uuidMap.put("60482f78-4026-40af-a208-870b29ba3892", com.pulse.mo.ScheduleEntry.class);
uuidMap.put("699ba224-d939-4284-b03b-49a12059e663", com.pulse.mo.Timecard.class);
uuidMap.put("9f58f5a6-298a-4f7a-9d37-c3c1c36b1d38", com.pulse.mo.TimecardEntry.class);
uuidMap.put("38d56bdd-05df-442b-a5e1-7400a262dd4d", com.pulse.mo.AdhocCoachingSession.class);
uuidMap.put("30f20a0b-8af6-46c8-9ce1-b3fbb71f81ee", com.pulse.mo.AdhocTask.class);
uuidMap.put("c81a2843-3b26-4e71-9197-bac00803bc89", com.pulse.mo.AgentScorecard.class);
uuidMap.put("929dbe3a-9c57-4222-a16c-f48e4b0185ec", com.pulse.mo.BehaviorResponse.class);
uuidMap.put("14c9d95f-48ca-4b8a-ade2-10e7aa0aac4e", com.pulse.mo.CoachingSession.class);
uuidMap.put("e5b61e16-daf7-4b48-b30d-0711e344b34f", com.pulse.mo.CoachingSessionAttachment.class);
uuidMap.put("a89c7c79-f8b0-4f6e-84f0-8f0c83f7d988", com.pulse.mo.Comment.class);
uuidMap.put("777fe875-853c-487a-8817-763553ecfde8", com.pulse.mo.Supervisor.class);
uuidMap.put("a4443400-515b-4f4a-8d91-920c7873467a", com.pulse.mo.CorrectiveAction.class);
uuidMap.put("45b28062-a48a-43a8-b5d1-c1e8c3085fc0", com.pulse.mo.DevelopmentActivity.class);
uuidMap.put("0d87cd6f-8a0e-4a59-bea1-43c40d7b9913", com.pulse.mo.Email.class);
uuidMap.put("fd3847fe-7ce2-4cb4-8f19-47eadb5d9f59", com.pulse.mo.LOBConfigurationEntry.class);
uuidMap.put("cd4eb775-62b5-459a-a4a4-9563f50c8dfd", com.pulse.mo.TeamLeader.class);
uuidMap.put("10423eb1-a979-4f0b-ac1f-fcd65bafc657", com.pulse.mo.PulseUser.class);
uuidMap.put("aeb8d928-80d0-4c70-b0a9-d1e495179c43", com.pulse.mo.QualityEvaluation.class);
uuidMap.put("04076ce8-2feb-4cf6-9ad3-6bdf970377c9", com.pulse.mo.ScorecardMeasure.class);
uuidMap.put("073c2275-915d-407d-9fea-7f6ee31690c2", com.pulse.mo.ScorecardMeasureMonthlyResult.class);
uuidMap.put("859e44bf-32ac-4fd4-8576-4369715f78dd", com.pulse.mo.ScorecardMeasureWeeklyResult.class);
uuidMap.put("e8ea5db7-1e55-4bc4-9c07-c255f0cf7811", com.pulse.mo.Setting.class);
uuidMap.put("7358fcba-ef06-461b-a877-38c80faab910", com.pulse.mo.TeamLeaderImpersonation.class);
uuidMap.put("c503c880-fe35-4cdf-9ac2-852a02d6b98f", com.pulse.mo.ThresholdLevel.class);
uuidMap.put("dbf2d702-5b91-4de7-8e28-240069ebdadd", com.pulse.mo.TraceEntry.class);
uuidMap.put("96117679-b37e-41fb-a29f-b3ca3bd51509", com.pulse.mo.UserRole.class);
uuidMap.put("b0f697d5-bb43-47b1-bd89-18c481ea9012", com.pulse.mo.UserSession.class);
uuidMap.put("6e95f281-367a-4960-9c72-fe046a712019", com.pulse.mo.ShiftStatusNotification.class);

		}
		return uuidMap;
	}

}