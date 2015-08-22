package com.pulse.auth.helpers;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.percero.agents.auth.helpers.AccountHelper;
import com.percero.agents.auth.vo.IUserAnchor;
import com.percero.agents.auth.vo.ServiceUser;
import com.pulse.mo.Pulse_Manifest;
import com.percero.framework.bl.ManifestHelper;

@Component
public class Pulse_AccountHelper extends AccountHelper {

	private static final Logger log = Logger.getLogger(Pulse_AccountHelper.class);
	
	public static final String ROLE_ADMIN = "ADMIN";
	public static final String ROLE_BASIC = "BASIC";
	
	public Pulse_AccountHelper() {
		super();
		manifest = new Pulse_Manifest();
		ManifestHelper.setManifest(manifest);
		
		log.debug("Pulse_AccountHelper instantiated.");
	}

	@Override
	protected IUserAnchor addOrUpdateUserAnchorFromServiceUserList(String userId,
			List<ServiceUser> serviceUserList, IUserAnchor result) {
		return super.addOrUpdateUserAnchorFromServiceUserList(userId, serviceUserList, result);
	}
}
