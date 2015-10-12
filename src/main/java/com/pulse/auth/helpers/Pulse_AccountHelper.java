package com.pulse.auth.helpers;

import com.percero.agents.auth.helpers.AccountHelper;
import com.percero.agents.auth.vo.IUserAnchor;
import com.percero.agents.auth.vo.ServiceUser;
import com.percero.agents.sync.dao.DAORegistry;
import com.percero.agents.sync.dao.IDataAccessObject;
import com.percero.framework.bl.ManifestHelper;
import com.pulse.mo.Email;
import com.pulse.mo.PulseUser;
import com.pulse.mo.Pulse_Manifest;
import com.pulse.mo.TeamLeader;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.List;

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
			List<ServiceUser> serviceUserList, IUserAnchor userAnchor) {
		IUserAnchor result = super.addOrUpdateUserAnchorFromServiceUserList(userId, serviceUserList, userAnchor);
		PulseUser pulseUser = (PulseUser) result;
		DAORegistry daoRegistry = DAORegistry.getInstance();
		IDataAccessObject<Email> dao = (IDataAccessObject<Email>)daoRegistry.getDataAccessObject(Email.class.getName());
		Email example = new Email();
		example.setPulseUser((PulseUser) userAnchor);
		try {
			List<Email> emails = dao.findByExample(example, null, null, false);
			if(emails.size() > 0){
				Email email = emails.get(0);
				// Now find the TeamLeader that has this email (because that is where it came from in the first place
				// see PulseHttpAuthProvider for proof.
				IDataAccessObject<TeamLeader> teamLeaderDAO = (IDataAccessObject<TeamLeader>)daoRegistry.getDataAccessObject(TeamLeader.class.getName());
				TeamLeader exampleTeamLeader = new TeamLeader();
				exampleTeamLeader.setEmailAddress(email.getEmailAddress());
				List<TeamLeader> teamLeaders = teamLeaderDAO.findByExample(exampleTeamLeader, null, null, false);
				if(teamLeaders.size() > 0){
					TeamLeader theChosenOne = teamLeaders.get(0);
					pulseUser.setTeamLeader(theChosenOne);
					IDataAccessObject<PulseUser> pulseUserDAO = (IDataAccessObject<PulseUser>)daoRegistry.getDataAccessObject(PulseUser.class.getName());
					pulseUserDAO.updateObject(pulseUser, null, null);
				}
			}
		}catch(Exception e){}
		return result;
	}
}
