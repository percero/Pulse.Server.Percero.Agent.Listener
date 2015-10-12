
package com.pulse.mo;

import javax.persistence.Entity;

import com.pulse.mo.mo_super._Super_Agent;

@Entity(name="Agent")
public class Agent extends _Super_Agent
{
	/*
	
	@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@OneToMany(fetch=FetchType.LAZY, targetEntity=DiscrepancyDetectedNotification.class, mappedBy="agent", cascade=javax.persistence.CascadeType.REMOVE)
private List<DiscrepancyDetectedNotification> recentDiscrepancyDetectedNotifications;
public List<DiscrepancyDetectedNotification> getRecentDiscrepancyDetectedNotifications() {
	return this.recentDiscrepancyDetectedNotifications;
}

public void setRecentDiscrepancyDetectedNotifications(List<DiscrepancyDetectedNotification> value) {
	this.recentDiscrepancyDetectedNotifications = value;
}


	
	*/
}
