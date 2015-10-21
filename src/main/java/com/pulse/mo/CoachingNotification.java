
package com.pulse.mo;

import javax.persistence.Entity;

import com.percero.agents.sync.cw.ChangeWatcherHelperFactory;
import com.percero.agents.sync.cw.DerivedValueChangeWatcherHelper;
import com.percero.agents.sync.cw.IChangeWatcherHelperFactory;
import com.percero.agents.sync.vo.ClassIDPair;
import com.pulse.mo.mo_super._Super_CoachingNotification;

@Entity(name="CoachingNotification")
public class CoachingNotification extends _Super_CoachingNotification
{
	public Integer getPendingStateCount() {
		IChangeWatcherHelperFactory cwhf = ChangeWatcherHelperFactory.getInstance();
		DerivedValueChangeWatcherHelper cwh = (DerivedValueChangeWatcherHelper) cwhf.getHelper(getClass().getCanonicalName());
		Integer result = (Integer) cwh.get("pendingStateCount", new ClassIDPair(this.getID(), this.getClass().getCanonicalName()));
		return result;
	}
 
	public Integer getPendingEmployeeStateCount() {
		IChangeWatcherHelperFactory cwhf = ChangeWatcherHelperFactory.getInstance();
		DerivedValueChangeWatcherHelper cwh = (DerivedValueChangeWatcherHelper) cwhf.getHelper(getClass().getCanonicalName());
		Integer result = (Integer) cwh.get("pendingEmployeeStateCount", new ClassIDPair(this.getID(), this.getClass().getCanonicalName()));
		return result;
	}
	
	public Integer getSubmittedStateCount() {
		IChangeWatcherHelperFactory cwhf = ChangeWatcherHelperFactory.getInstance();
		DerivedValueChangeWatcherHelper cwh = (DerivedValueChangeWatcherHelper) cwhf.getHelper(getClass().getCanonicalName());
		Integer result = (Integer) cwh.get("submittedStateCount", new ClassIDPair(this.getID(), this.getClass().getCanonicalName()));
		return result;
	}
 
	public Integer getPendingCoachStateCount() {
		IChangeWatcherHelperFactory cwhf = ChangeWatcherHelperFactory.getInstance();
		DerivedValueChangeWatcherHelper cwh = (DerivedValueChangeWatcherHelper) cwhf.getHelper(getClass().getCanonicalName());
		Integer result = (Integer) cwh.get("pendingCoachStateCount", new ClassIDPair(this.getID(), this.getClass().getCanonicalName()));
		return result;
	}
 
	public Integer getSkippedStateCount() {
		IChangeWatcherHelperFactory cwhf = ChangeWatcherHelperFactory.getInstance();
		DerivedValueChangeWatcherHelper cwh = (DerivedValueChangeWatcherHelper) cwhf.getHelper(getClass().getCanonicalName());
		Integer result = (Integer) cwh.get("skippedStateCount", new ClassIDPair(this.getID(), this.getClass().getCanonicalName()));
		return result;
	}
 
	public Integer getAcknowledgementStateCount() {
		IChangeWatcherHelperFactory cwhf = ChangeWatcherHelperFactory.getInstance();
		DerivedValueChangeWatcherHelper cwh = (DerivedValueChangeWatcherHelper) cwhf.getHelper(getClass().getCanonicalName());
		Integer result = (Integer) cwh.get("acknowledgementStateCount", new ClassIDPair(this.getID(), this.getClass().getCanonicalName()));
		return result;
	}
}
