

package com.pulse.mo;

import java.util.Date;

import javax.persistence.Entity;

import com.percero.agents.sync.cw.ChangeWatcherHelperFactory;
import com.percero.agents.sync.cw.DerivedValueChangeWatcherHelper;
import com.percero.agents.sync.cw.IChangeWatcherHelperFactory;
import com.percero.agents.sync.metadata.IMappedClassManager;
import com.percero.agents.sync.metadata.MappedClass;
import com.percero.agents.sync.metadata.MappedClassManagerFactory;
import com.percero.agents.sync.services.IDataProvider;
import com.percero.agents.sync.vo.ClassIDPair;
import com.pulse.mo.mo_super._Super_Timecard;
import com.pulse.sync.cw.TimecardCWHelper;

@Entity(name = "Timecard")
public class Timecard extends _Super_Timecard {

    public Boolean getShift() {
        IChangeWatcherHelperFactory cwhf = ChangeWatcherHelperFactory.getInstance();
        DerivedValueChangeWatcherHelper cwh = (DerivedValueChangeWatcherHelper) cwhf.getHelper(getClass().getCanonicalName());
        Boolean val = (Boolean) cwh.get(TimecardCWHelper.SHIFT, new ClassIDPair(this.getID(), this.getClass().getCanonicalName()));
        return val;
    }


    public String getCurrentStatus() {
        IChangeWatcherHelperFactory cwhf = ChangeWatcherHelperFactory.getInstance();
        DerivedValueChangeWatcherHelper cwh = (DerivedValueChangeWatcherHelper) cwhf.getHelper(getClass().getCanonicalName());
        String val = (String) cwh.get(TimecardCWHelper.CURRENTSTATUS, new ClassIDPair(this.getID(), this.getClass().getCanonicalName()));
        return val;
    }


    public Date getStartDate() {
        IChangeWatcherHelperFactory cwhf = ChangeWatcherHelperFactory.getInstance();
        DerivedValueChangeWatcherHelper cwh = (DerivedValueChangeWatcherHelper) cwhf.getHelper(getClass().getCanonicalName());
        Date val = (Date) cwh.get(TimecardCWHelper.STARTDATE, new ClassIDPair(this.getID(), this.getClass().getCanonicalName()));
        return val;
    }

    public Date getEndDate() {
        IChangeWatcherHelperFactory cwhf = ChangeWatcherHelperFactory.getInstance();
        DerivedValueChangeWatcherHelper cwh = (DerivedValueChangeWatcherHelper) cwhf.getHelper(getClass().getCanonicalName());
        Date val = (Date) cwh.get(TimecardCWHelper.ENDDATE, new ClassIDPair(this.getID(), this.getClass().getCanonicalName()));
        return val;
    }

	public AgentTimeZone getAgentTimeZone() {
		IChangeWatcherHelperFactory cwhf = ChangeWatcherHelperFactory.getInstance();
		
		DerivedValueChangeWatcherHelper cwh = (DerivedValueChangeWatcherHelper) cwhf.getHelper(getClass().getCanonicalName());
		
		ClassIDPair result = (ClassIDPair) cwh.get(TimecardCWHelper.AGENT_TIME_ZONE, new ClassIDPair(this.getID(), this.getClass().getCanonicalName()));
		
		if (result != null)
		{
			IMappedClassManager mcm = MappedClassManagerFactory.getMappedClassManager();
			
			MappedClass mappedClass = mcm.getMappedClassByClassName(result.getClassName());
			IDataProvider dataProvider = cwh.getDataProviderManager().getDataProviderByName(mappedClass.dataProviderName);
			return (AgentTimeZone) dataProvider.findById(result, null);
		}
		
		return null;
	}
	
	public String getTimeZone() {
		IChangeWatcherHelperFactory cwhf = ChangeWatcherHelperFactory.getInstance();
		
		DerivedValueChangeWatcherHelper cwh = (DerivedValueChangeWatcherHelper) cwhf.getHelper(getClass().getCanonicalName());
		
		String result = (String) cwh.get(TimecardCWHelper.TIME_ZONE, new ClassIDPair(this.getID(), this.getClass().getCanonicalName()));
		return result;
	}
}

