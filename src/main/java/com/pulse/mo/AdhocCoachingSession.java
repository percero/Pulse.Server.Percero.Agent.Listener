
package com.pulse.mo;

import javax.persistence.Entity;

import com.pulse.mo.mo_super._Super_AdhocCoachingSession;

@Entity(name="AdhocCoachingSession")
public class AdhocCoachingSession extends _Super_AdhocCoachingSession
{
	/*
	
	@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@com.percero.agents.sync.metadata.annotations.Externalize
@OneToOne(fetch=FetchType.LAZY, mappedBy="adhocCoachingSession", cascade=javax.persistence.CascadeType.REMOVE)
private AdhocCoachingSessionAttachment adhocCoachingSessionAttachment;
public AdhocCoachingSessionAttachment getAdhocCoachingSessionAttachment() {
	return this.adhocCoachingSessionAttachment;
}

public void setAdhocCoachingSessionAttachment(AdhocCoachingSessionAttachment value) 
{
	this.adhocCoachingSessionAttachment = value;
}


	
	*/
}
