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
			classList.add(com.pulse.mo.Person.class);
			classList.add(com.pulse.mo.PersonRole.class);
			classList.add(com.pulse.mo.Email.class);
			classList.add(com.pulse.mo.Scorecard.class);
			classList.add(com.pulse.mo.CoachingSession.class);
			classList.add(com.pulse.mo.CoachingSessionState.class);
			classList.add(com.pulse.mo.Notification.class);
			classList.add(com.pulse.mo.Alert.class);
			classList.add(com.pulse.mo.EStartActivityCode.class);
			classList.add(com.pulse.mo.DiscrepancyDetectedNotification.class);
			classList.add(com.pulse.mo.AuxEntry.class);
			classList.add(com.pulse.mo.LOBConfigurationEntry.class);
			classList.add(com.pulse.mo.NotificationFrequency.class);
			classList.add(com.pulse.mo.ThresholdExceededNotification.class);
			classList.add(com.pulse.mo.DurationTolerance.class);
			classList.add(com.pulse.mo.InvalidActivityCode.class);
			classList.add(com.pulse.mo.OccurrenceTolerance.class);
			classList.add(com.pulse.mo.WorkDuration.class);
			classList.add(com.pulse.mo.WorkModeOccurrence.class);
			classList.add(com.pulse.mo.CoachingNotification.class);
			classList.add(com.pulse.mo.ChangesNotApproved.class);
		}
		return classList;
	}

	private List<Object> objectList = null;
	public List<Object> getObjectList() {
		if (objectList == null) {
			objectList = new ArrayList<Object>();
			objectList.add(new com.pulse.mo.Person());
			objectList.add(new com.pulse.mo.PersonRole());
			objectList.add(new com.pulse.mo.Email());
			objectList.add(new com.pulse.mo.Scorecard());
			objectList.add(new com.pulse.mo.CoachingSession());
			objectList.add(new com.pulse.mo.CoachingSessionState());
			objectList.add(new com.pulse.mo.Notification());
			objectList.add(new com.pulse.mo.Alert());
			objectList.add(new com.pulse.mo.EStartActivityCode());
			objectList.add(new com.pulse.mo.DiscrepancyDetectedNotification());
			objectList.add(new com.pulse.mo.AuxEntry());
			objectList.add(new com.pulse.mo.LOBConfigurationEntry());
			objectList.add(new com.pulse.mo.NotificationFrequency());
			objectList.add(new com.pulse.mo.ThresholdExceededNotification());
			objectList.add(new com.pulse.mo.DurationTolerance());
			objectList.add(new com.pulse.mo.InvalidActivityCode());
			objectList.add(new com.pulse.mo.OccurrenceTolerance());
			objectList.add(new com.pulse.mo.WorkDuration());
			objectList.add(new com.pulse.mo.WorkModeOccurrence());
			objectList.add(new com.pulse.mo.CoachingNotification());
			objectList.add(new com.pulse.mo.ChangesNotApproved());
		}
		return objectList;
	}

	private Map<String, Class> uuidMap = null;
	public Map<String, Class> getUuidMap() {
		if (uuidMap == null) {
			uuidMap = new HashMap<String, Class>();
			uuidMap.put("11a9b850-55c0-41c3-ab3f-7f03238d3d76", com.pulse.mo.Person.class);
			uuidMap.put("583f23bb-d096-49b4-aa02-c2ad056643ee", com.pulse.mo.PersonRole.class);
			uuidMap.put("18a07df8-8d6b-41df-8633-dfeda171e7eb", com.pulse.mo.Email.class);
			uuidMap.put("0e010953-5800-477b-b61e-fda37c3856ea", com.pulse.mo.Scorecard.class);
			uuidMap.put("95758885-8c9f-4160-9b18-a53b86cfea6d", com.pulse.mo.CoachingSession.class);
			uuidMap.put("f66b80bc-03aa-4f89-b8e8-cf7ca54fedd9", com.pulse.mo.CoachingSessionState.class);
			uuidMap.put("3739ad78-72a4-46ad-8098-de6df28fde7a", com.pulse.mo.Notification.class);
			uuidMap.put("e2a51a7b-6ec5-477a-b60b-9d2eeaf6a4c8", com.pulse.mo.Alert.class);
			uuidMap.put("ec10a685-7157-406f-9c08-07e271855616", com.pulse.mo.EStartActivityCode.class);
			uuidMap.put("d1b637f8-ed98-4c08-8abb-b6c0d1183bc2", com.pulse.mo.DiscrepancyDetectedNotification.class);
			uuidMap.put("cc3dfc59-a171-4777-b955-51bc26b72b93", com.pulse.mo.AuxEntry.class);
			uuidMap.put("c6049c4f-7e34-4e94-91be-e23e2a107931", com.pulse.mo.LOBConfigurationEntry.class);
			uuidMap.put("f81cbc7f-8c9a-4f91-9ee6-0353c0701e28", com.pulse.mo.NotificationFrequency.class);
			uuidMap.put("612d741b-6c50-4028-9e64-a1cd58becfbb", com.pulse.mo.ThresholdExceededNotification.class);
			uuidMap.put("b428dfa6-96f5-4f1b-8cae-e8dceafa9653", com.pulse.mo.DurationTolerance.class);
			uuidMap.put("07386706-3fec-4da9-903c-d378a56f3ef3", com.pulse.mo.InvalidActivityCode.class);
			uuidMap.put("3b12695d-f673-4805-ba1b-615433b552cd", com.pulse.mo.OccurrenceTolerance.class);
			uuidMap.put("3263b6ed-6620-4d94-a0c1-ecceaa722cda", com.pulse.mo.WorkDuration.class);
			uuidMap.put("33766023-4724-489f-8ffa-816c6dc2ea64", com.pulse.mo.WorkModeOccurrence.class);
			uuidMap.put("d4537dd5-6071-4d4e-ac61-92e49be32fe0", com.pulse.mo.CoachingNotification.class);
			uuidMap.put("8893919f-c8e2-4393-ab5e-5cbfe8a61577", com.pulse.mo.ChangesNotApproved.class);
		}
		return uuidMap;
	}

}

