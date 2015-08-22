package com.pulse.mo;

import javax.persistence.Entity;

import com.percero.agents.sync.cw.ChangeWatcherHelperFactory;
import com.percero.agents.sync.cw.IChangeWatcherHelperFactory;
import com.percero.agents.sync.cw.IChangeWatcherValueHelper;
import com.percero.agents.sync.vo.ClassIDPair;
import com.pulse.mo.mo_super._Super_Person;

@Entity(name="Person")
public class Person extends _Super_Person
{
	public String fullName() {
		IChangeWatcherHelperFactory cwhf = ChangeWatcherHelperFactory.getInstance();
		
		IChangeWatcherValueHelper cwh = (IChangeWatcherValueHelper) cwhf.getHelper(getClass().getCanonicalName());
		String result = (String) cwh.get("fullName", new ClassIDPair(this.getID(), this.getClass().getCanonicalName()));

		return result;
	}
	
}
