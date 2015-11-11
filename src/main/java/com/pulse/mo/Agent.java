

package com.pulse.mo;

import javax.persistence.Entity;

import com.percero.agents.sync.cw.ChangeWatcherHelperFactory;
import com.percero.agents.sync.cw.DerivedValueChangeWatcherHelper;
import com.percero.agents.sync.cw.IChangeWatcherHelperFactory;
import com.percero.agents.sync.vo.ClassIDPair;
import com.pulse.mo.mo_super._Super_Agent;
import com.pulse.sync.cw.AgentCWHelper;

@Entity(name="Agent")
public class Agent extends _Super_Agent
{
	
	public String getTimeZone() {
		IChangeWatcherHelperFactory cwhf = ChangeWatcherHelperFactory.getInstance();
		
		DerivedValueChangeWatcherHelper cwh = (DerivedValueChangeWatcherHelper) cwhf.getHelper(getClass().getCanonicalName());
		
		String result = (String) cwh.get(AgentCWHelper.TIME_ZONE, new ClassIDPair(this.getID(), this.getClass().getCanonicalName()));
		return result;
	}
}

