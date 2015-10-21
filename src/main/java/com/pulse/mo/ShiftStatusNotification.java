
package com.pulse.mo;

import javax.persistence.Entity;

import com.percero.agents.sync.cw.ChangeWatcherHelperFactory;
import com.percero.agents.sync.cw.DerivedValueChangeWatcherHelper;
import com.percero.agents.sync.cw.IChangeWatcherHelperFactory;
import com.percero.agents.sync.vo.ClassIDPair;
import com.pulse.mo.mo_super._Super_ShiftStatusNotification;

@Entity(name="ShiftStatusNotification")
public class ShiftStatusNotification extends _Super_ShiftStatusNotification
{
	public Integer getNotYetStartedStateCount() {
		IChangeWatcherHelperFactory cwhf = ChangeWatcherHelperFactory.getInstance();
		DerivedValueChangeWatcherHelper cwh = (DerivedValueChangeWatcherHelper) cwhf.getHelper(getClass().getCanonicalName());
		Integer result = (Integer) cwh.get("notYetStartedStateCount", new ClassIDPair(this.getID(), this.getClass().getCanonicalName()));
		return result;
	}
}
