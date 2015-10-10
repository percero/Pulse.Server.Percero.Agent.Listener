
package com.pulse.mo;

import javax.persistence.Entity;

import com.pulse.mo.mo_super._Super_CoachingSession;

@Entity(name="CoachingSession")
public class CoachingSession extends _Super_CoachingSession
{
	/*
	
	@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@OneToMany(fetch=FetchType.LAZY, targetEntity=CoachingSessionAttachment.class, mappedBy="coachingSession", cascade=javax.persistence.CascadeType.REMOVE)
private List<CoachingSessionAttachment> coachingSessionAttachments;
public List<CoachingSessionAttachment> getCoachingSessionAttachments() {
	return this.coachingSessionAttachments;
}

public void setCoachingSessionAttachments(List<CoachingSessionAttachment> value) {
	this.coachingSessionAttachments = value;
}


	
	*/
}
