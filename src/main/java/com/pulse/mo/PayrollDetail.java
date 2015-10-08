
package com.pulse.mo;

import javax.persistence.Entity;

import com.pulse.mo.mo_super._Super_PayrollDetail;

@Entity(name="PayrollDetail")
public class PayrollDetail extends _Super_PayrollDetail
{
	/*
	
	@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@com.percero.agents.sync.metadata.annotations.Externalize
@OneToOne(fetch=FetchType.LAZY, mappedBy="payrollDetail", cascade=javax.persistence.CascadeType.REMOVE)
private Timecard timecard;
public Timecard getTimecard() {
	return this.timecard;
}

public void setTimecard(Timecard value) 
{
	this.timecard = value;
}


	
	*/
}
