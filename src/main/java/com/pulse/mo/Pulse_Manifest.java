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
			classList.add(com.pulse.mo.DBConfigurationNotification.class);
			classList.add(com.pulse.mo.CoachingNotification.class);
			classList.add(com.pulse.mo.ShiftStatusNotification.class);
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
			objectList.add(new com.pulse.mo.DBConfigurationNotification());
			objectList.add(new com.pulse.mo.CoachingNotification());
			objectList.add(new com.pulse.mo.ShiftStatusNotification());
		}
		return objectList;
	}

	private Map<String, Class> uuidMap = null;
	public Map<String, Class> getUuidMap() {
		if (uuidMap == null) {
			uuidMap = new HashMap<String, Class>();
			uuidMap.put("f77695ce-300b-464d-ba58-d2c549bee6ce", com.pulse.mo.PulseUser.class);
			uuidMap.put("526495d6-c607-4ce6-952c-cf247237ae7f", com.pulse.mo.UserRole.class);
			uuidMap.put("567811af-7da4-43e8-8f3a-d0993ae9ec7d", com.pulse.mo.Email.class);
			uuidMap.put("9a5088cb-8bee-4ff8-b0c4-2e5e884ad142", com.pulse.mo.TeamLeader.class);
			uuidMap.put("e07a44d6-107d-4cdc-9ece-c4c6b1d71ccb", com.pulse.mo.Alert.class);
			uuidMap.put("ba2cabad-174d-4801-a336-49f3911a3d51", com.pulse.mo.Notification.class);
			uuidMap.put("71ca26d0-c129-484c-b853-c754e4757774", com.pulse.mo.Agent.class);
			uuidMap.put("4d59c720-db71-43b6-b0e5-610d98426bf9", com.pulse.mo.Client.class);
			uuidMap.put("26c1ae21-5718-4b3a-b77f-99af4f7e37ba", com.pulse.mo.Scorecard.class);
			uuidMap.put("15317f71-0e1c-44f6-8dc9-00d90be72139", com.pulse.mo.LOB.class);
			uuidMap.put("8dce5cf5-3fd5-4023-9993-37b6105c835f", com.pulse.mo.DBConfigurationNotification.class);
			uuidMap.put("a8fe19a3-774d-4a09-a9e2-1c7c3e5db24f", com.pulse.mo.CoachingNotification.class);
			uuidMap.put("d1c62f81-354f-483e-b2b1-4eb6617beea5", com.pulse.mo.ShiftStatusNotification.class);
		}
		return uuidMap;
	}

}

