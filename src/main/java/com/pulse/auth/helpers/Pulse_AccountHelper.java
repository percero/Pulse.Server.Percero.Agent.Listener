package com.pulse.auth.helpers;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.percero.agents.auth.helpers.AccountHelper;
import com.percero.agents.auth.vo.IUserAnchor;
import com.percero.agents.auth.vo.ServiceUser;
import com.percero.agents.sync.services.IDataProvider;
import com.percero.framework.bl.ManifestHelper;
import com.percero.framework.vo.IPerceroObject;
import com.pulse.mo.Email;
import com.pulse.mo.PulseUser;
import com.pulse.mo.Pulse_Manifest;
import com.pulse.mo.TeamLeader;

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
	
	public PulseUser setupPulseUser(String userId, PulseUser pulseUser, List<ServiceUser> serviceUsers) {
		return (PulseUser) addOrUpdateUserAnchorFromServiceUserList(userId, serviceUsers, pulseUser);
	}

	@Override
	protected IUserAnchor addOrUpdateUserAnchorFromServiceUserList(String userId,
			List<ServiceUser> serviceUserList, IUserAnchor userAnchor) {
		log.debug("[Pulse_AccountHelper] Add/Update UserAnchor " + userId);
		IUserAnchor result = super.addOrUpdateUserAnchorFromServiceUserList(userId, serviceUserList, userAnchor);

		PulseUser pulseUser = (PulseUser) result;
		if (pulseUser.getTeamLeader() != null) {
			log.debug("[Pulse_AccountHelper] PulseUser.TeamLeader " + pulseUser.getTeamLeader().getID());
		}
		else {
			log.debug("[Pulse_AccountHelper] PulseUser.TeamLeader NO TEAM LEADER");
		}
//		DAORegistry daoRegistry = DAORegistry.getInstance();
//		IDataAccessObject<Email> dao = (IDataAccessObject<Email>)daoRegistry.getDataAccessObject(Email.class.getName());
		IDataProvider emailDataProvider = dataProviderManager.getDataProviderByName(Email.class.getCanonicalName());
		Email example = new Email();
		example.setPulseUser((PulseUser) userAnchor);
		try {
			List<IPerceroObject> emails = emailDataProvider.findByExample(example, null, null, false);
			if(emails.size() > 0){
				Email email = (Email) emails.get(0);
				log.debug("[Pulse_AccountHelper] PulseUser.Email " + email.getID() + " (" + email.getEmailAddress() + ")");
				
				// Now find the TeamLeader that has this email (because that is where it came from in the first place
				// see PulseHttpAuthProvider for proof.
//				IDataAccessObject<TeamLeader> teamLeaderDAO = (IDataAccessObject<TeamLeader>)daoRegistry.getDataAccessObject(TeamLeader.class.getName());
				TeamLeader exampleTeamLeader = new TeamLeader();
				exampleTeamLeader.setEmailAddress(email.getEmailAddress());
				IDataProvider teamLeaderDataProvider = dataProviderManager.getDataProviderByName(TeamLeader.class.getCanonicalName());
				List<IPerceroObject> teamLeaders = teamLeaderDataProvider.findByExample(exampleTeamLeader, null, null, false);
				if(teamLeaders.size() > 0){
					TeamLeader theChosenOne = (TeamLeader) teamLeaders.get(0);
					
					if (pulseUser.getTeamLeader() == null
							|| !StringUtils.hasText(pulseUser.getTeamLeader()
									.getID())
							|| !pulseUser.getTeamLeader().getID()
									.equalsIgnoreCase(theChosenOne.getID())) {
						log.debug("[Pulse_AccountHelper] Updating the PulseUser::" + pulseUser.getID() + " TeamLeader to " + theChosenOne.getID());
						pulseUser.setTeamLeader(theChosenOne);
	//					IDataAccessObject<PulseUser> pulseUserDAO = (IDataAccessObject<PulseUser>)daoRegistry.getDataAccessObject(PulseUser.class.getName());
						try {
							syncAgentService.systemPutObject(pulseUser, null, null, null, true);
						} catch(Exception e) {
							log.error("[Pulse_AccountHelper] Unable to set TeamLeader " + theChosenOne.getID() + " on PulseUser " + pulseUser.getID(), e);
						}
					}
					else {
						// The PulseUser TeamLeader is already set to the correct TeamLeader.
					}
				}
				else {
					log.warn("[Pulse_AccountHelper] NO TEAM LEADER FOUND for PulseUser " + pulseUser.getID());
				}
			}
			else {
				log.warn("[Pulse_AccountHelper] NO EMAIL FOUND for PulseUser " + pulseUser.getID());
			}
		}
		catch(Exception e){
			log.error("[Pulse_AccountHelper] Error authenticating PulseUser " + pulseUser.getID(), e);
		}
		return result;
	}
}
