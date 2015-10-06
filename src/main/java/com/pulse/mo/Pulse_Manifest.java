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
classList.add(com.pulse.mo.Agent.class);
classList.add(com.pulse.mo.Email.class);
classList.add(com.pulse.mo.TeamLeader.class);
classList.add(com.pulse.mo.PulseUser.class);
classList.add(com.pulse.mo.UserRole.class);
classList.add(com.pulse.mo.UserSession.class);

		}
		return classList;
	}

	private List<Object> objectList = null;
	public List<Object> getObjectList() {
		if (objectList == null) {
			objectList = new ArrayList<Object>();
objectList.add(new com.pulse.mo.Agent());
objectList.add(new com.pulse.mo.Email());
objectList.add(new com.pulse.mo.TeamLeader());
objectList.add(new com.pulse.mo.PulseUser());
objectList.add(new com.pulse.mo.UserRole());
objectList.add(new com.pulse.mo.UserSession());

		}
		return objectList;
	}

	private Map<String, Class> uuidMap = null;
	public Map<String, Class> getUuidMap() {
		if (uuidMap == null) {
			uuidMap = new HashMap<String, Class>();
uuidMap.put("0123ae3a-3295-47d1-8d39-7ae56737af67", com.pulse.mo.Agent.class);
uuidMap.put("5939b4c9-e2f1-43c3-b352-82a1a130a0d6", com.pulse.mo.Email.class);
uuidMap.put("16fd3b8e-e0d0-44d1-bbac-97f4a3c5a114", com.pulse.mo.TeamLeader.class);
uuidMap.put("6474d8b9-4754-49b6-a5be-7fc70608ea6b", com.pulse.mo.PulseUser.class);
uuidMap.put("13cb71d3-6907-4715-a31e-a1099e672065", com.pulse.mo.UserRole.class);
uuidMap.put("37c9ce25-26cd-48cf-b551-7b3839f39165", com.pulse.mo.UserSession.class);

		}
		return uuidMap;
	}

}