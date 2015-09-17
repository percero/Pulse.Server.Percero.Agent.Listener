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
			classList.add(com.pulse.mo.PulseUser.class);
			classList.add(com.pulse.mo.UserRole.class);
			classList.add(com.pulse.mo.Email.class);
			classList.add(com.pulse.mo.TeamLeader.class);
			classList.add(com.pulse.mo.Alert.class);
			classList.add(com.pulse.mo.Notification.class);
			classList.add(com.pulse.mo.Agent.class);
			classList.add(com.pulse.mo.Client.class);
			classList.add(com.pulse.mo.Scorecard.class);
			classList.add(com.pulse.mo.LOB.class);
			classList.add(com.pulse.mo.LOBConfigurationNotification.class);
			classList.add(com.pulse.mo.CoachingNotification.class);
			classList.add(com.pulse.mo.ShiftStatusNotification.class);
			classList.add(com.pulse.mo.TeamLeaderImpersonation.class);
			classList.add(com.pulse.mo.UserSession.class);
			classList.add(com.pulse.mo.ConnectedState.class);
			classList.add(com.pulse.mo.AgentTime.class);
			classList.add(com.pulse.mo.AgentTimeState.class);
			classList.add(com.pulse.mo.AdhocTask.class);
			classList.add(com.pulse.mo.AdhocCoachingSession.class);
			classList.add(com.pulse.mo.CorrectiveAction.class);
			classList.add(com.pulse.mo.CoachingSession.class);
			classList.add(com.pulse.mo.AgentCoachingSessions.class);
			classList.add(com.pulse.mo.CoachingSessionState.class);
			classList.add(com.pulse.mo.ScorecardState.class);
		}
		return classList;
	}

	private List<Object> objectList = null;
	public List<Object> getObjectList() {
		if (objectList == null) {
			objectList = new ArrayList<Object>();
			objectList.add(new com.pulse.mo.PulseUser());
			objectList.add(new com.pulse.mo.UserRole());
			objectList.add(new com.pulse.mo.Email());
			objectList.add(new com.pulse.mo.TeamLeader());
			objectList.add(new com.pulse.mo.Alert());
			objectList.add(new com.pulse.mo.Notification());
			objectList.add(new com.pulse.mo.Agent());
			objectList.add(new com.pulse.mo.Client());
			objectList.add(new com.pulse.mo.Scorecard());
			objectList.add(new com.pulse.mo.LOB());
			objectList.add(new com.pulse.mo.LOBConfigurationNotification());
			objectList.add(new com.pulse.mo.CoachingNotification());
			objectList.add(new com.pulse.mo.ShiftStatusNotification());
			objectList.add(new com.pulse.mo.TeamLeaderImpersonation());
			objectList.add(new com.pulse.mo.UserSession());
			objectList.add(new com.pulse.mo.ConnectedState());
			objectList.add(new com.pulse.mo.AgentTime());
			objectList.add(new com.pulse.mo.AgentTimeState());
			objectList.add(new com.pulse.mo.AdhocTask());
			objectList.add(new com.pulse.mo.AdhocCoachingSession());
			objectList.add(new com.pulse.mo.CorrectiveAction());
			objectList.add(new com.pulse.mo.CoachingSession());
			objectList.add(new com.pulse.mo.AgentCoachingSessions());
			objectList.add(new com.pulse.mo.CoachingSessionState());
			objectList.add(new com.pulse.mo.ScorecardState());
		}
		return objectList;
	}

	private Map<String, Class> uuidMap = null;
	public Map<String, Class> getUuidMap() {
		if (uuidMap == null) {
			uuidMap = new HashMap<String, Class>();
			uuidMap.put("7711780b-d3fb-49b1-961c-1dd7bdaeab15", com.pulse.mo.PulseUser.class);
			uuidMap.put("aaeed152-da42-4a9f-956a-1f4f781db200", com.pulse.mo.UserRole.class);
			uuidMap.put("02ac584b-e727-4ce3-8fba-4c63df6b877f", com.pulse.mo.Email.class);
			uuidMap.put("399bec97-2761-4062-97ac-47e22dc88edd", com.pulse.mo.TeamLeader.class);
			uuidMap.put("6f7790ad-6672-4a41-9e6f-6d58d36fbafa", com.pulse.mo.Alert.class);
			uuidMap.put("49c09d45-372b-41d4-a464-e7bf02ee24bf", com.pulse.mo.Notification.class);
			uuidMap.put("66d91c14-1cff-420f-8aaa-97d7d92237d0", com.pulse.mo.Agent.class);
			uuidMap.put("8fd3f4fb-0c81-4bc3-b487-7e93b2cc39a3", com.pulse.mo.Client.class);
			uuidMap.put("694e1048-cc2f-40a4-9bb1-bc1ad0edcfd7", com.pulse.mo.Scorecard.class);
			uuidMap.put("e4709116-fe70-4489-ad8e-a7b1b2f63777", com.pulse.mo.LOB.class);
			uuidMap.put("48b501dc-75b5-49bd-98a2-57d001c03477", com.pulse.mo.LOBConfigurationNotification.class);
			uuidMap.put("30a85bd8-ac9c-4f52-ba90-1be1138bcd4c", com.pulse.mo.CoachingNotification.class);
			uuidMap.put("f9f21773-f66f-468a-a661-d3529657b3d1", com.pulse.mo.ShiftStatusNotification.class);
			uuidMap.put("8349fdc0-7067-4540-af14-b53827123254", com.pulse.mo.TeamLeaderImpersonation.class);
			uuidMap.put("6757d7d7-9e13-41a3-aa5f-cbac1ecdf7c1", com.pulse.mo.UserSession.class);
			uuidMap.put("730305b8-f337-41da-8598-0cb8ee897b5a", com.pulse.mo.ConnectedState.class);
			uuidMap.put("ff86b51d-e5c9-47ca-ae51-28671bbde336", com.pulse.mo.AgentTime.class);
			uuidMap.put("c5c8e0c7-3df4-4cd3-adde-c8b23bd91b90", com.pulse.mo.AgentTimeState.class);
			uuidMap.put("e81f4489-d143-4864-932e-a442b867d416", com.pulse.mo.AdhocTask.class);
			uuidMap.put("25895379-5984-45cc-bbc0-74599e669585", com.pulse.mo.AdhocCoachingSession.class);
			uuidMap.put("69d7a407-9edc-41f5-bb27-76c324a9e2fd", com.pulse.mo.CorrectiveAction.class);
			uuidMap.put("1ff6e8c4-417b-41f3-abd5-1de403d5a376", com.pulse.mo.CoachingSession.class);
			uuidMap.put("103065ad-634a-44fd-afbc-c3904409072f", com.pulse.mo.AgentCoachingSessions.class);
			uuidMap.put("3d228058-c128-4757-a9f1-a63e4648c870", com.pulse.mo.CoachingSessionState.class);
			uuidMap.put("a72a34f6-e203-4566-9e21-4dbb05074ce0", com.pulse.mo.ScorecardState.class);
		}
		return uuidMap;
	}

}

