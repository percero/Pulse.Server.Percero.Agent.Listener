
package com.pulse.mo;

import javax.persistence.Entity;

import com.pulse.mo.mo_super._Super_PulseUser;

@Entity(name="PulseUser")
public class PulseUser extends _Super_PulseUser
{
	/*
	
	@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@OneToMany(fetch=FetchType.LAZY, targetEntity=TeamLeader.class, mappedBy="pulseUser", cascade=javax.persistence.CascadeType.REMOVE)
private List<TeamLeader> availableTeamLeaders;
public List<TeamLeader> getAvailableTeamLeaders() {
	return this.availableTeamLeaders;
}

public void setAvailableTeamLeaders(List<TeamLeader> value) {
	this.availableTeamLeaders = value;
}


	
	*/
}
