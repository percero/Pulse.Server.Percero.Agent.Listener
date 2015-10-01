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
uuidMap.put("93d492f7-a5ec-4ed2-888c-85a5e22c5043", com.pulse.mo.Agent.class);
uuidMap.put("961c5cd6-2292-47d2-a3b0-ca78efe7813f", com.pulse.mo.Email.class);
uuidMap.put("f4990919-3995-4bfd-a3d2-16f70b955590", com.pulse.mo.TeamLeader.class);
uuidMap.put("4e430da3-04f1-47f8-a044-0d4133432d54", com.pulse.mo.PulseUser.class);
uuidMap.put("d1761494-fbd3-4b59-a6a5-2c308c40640a", com.pulse.mo.UserRole.class);
uuidMap.put("d76dbc27-543f-4bcd-9f49-6b24b7a95019", com.pulse.mo.UserSession.class);

		}
		return uuidMap;
	}

}