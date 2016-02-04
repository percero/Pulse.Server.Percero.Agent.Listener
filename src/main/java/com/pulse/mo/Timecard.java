

package com.pulse.mo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

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
import com.pulse.sync.cw.AgentCWHelper;
import com.pulse.sync.cw.TimecardCWHelper;
import org.springframework.scheduling.annotation.Scheduled;

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

    @SuppressWarnings("unchecked")
    public List<CMSEntry> getRelatedCMSEntries() {
        IChangeWatcherHelperFactory cwhf = ChangeWatcherHelperFactory.getInstance();

        DerivedValueChangeWatcherHelper cwh = (DerivedValueChangeWatcherHelper) cwhf.getHelper(getClass().getCanonicalName());

        List<ClassIDPair> result = (List<ClassIDPair>) cwh.get(TimecardCWHelper.RELATED_CMS_ENTRIES, new ClassIDPair(this.getID(), this.getClass().getCanonicalName()));

        List<CMSEntry> results = new ArrayList<CMSEntry>();
        if (result != null)
        {
            IMappedClassManager mcm = MappedClassManagerFactory.getMappedClassManager();

            Iterator<ClassIDPair> itrResult = result.iterator();
            while(itrResult.hasNext()) {
                ClassIDPair nextResult = itrResult.next();

                MappedClass mappedClass = mcm.getMappedClassByClassName(nextResult.getClassName());
                IDataProvider dataProvider = cwh.getDataProviderManager().getDataProviderByName(mappedClass.dataProviderName);
                results.add( (CMSEntry) dataProvider.findById(nextResult, null) );
            }
        }

        return results;
    }

    @SuppressWarnings("unchecked")
    public List<Schedule> getRelatedSchedule() {
        IChangeWatcherHelperFactory cwhf = ChangeWatcherHelperFactory.getInstance();

        DerivedValueChangeWatcherHelper cwh = (DerivedValueChangeWatcherHelper) cwhf.getHelper(getClass().getCanonicalName());

        List<ClassIDPair> result = (List<ClassIDPair>) cwh.get(TimecardCWHelper.RELATED_SCHEDULE, new ClassIDPair(this.getID(), this.getClass().getCanonicalName()));

        List<Schedule> results = new ArrayList<Schedule>();
        if (result != null)
        {
            IMappedClassManager mcm = MappedClassManagerFactory.getMappedClassManager();

            Iterator<ClassIDPair> itrResult = result.iterator();
            while(itrResult.hasNext()) {
                ClassIDPair nextResult = itrResult.next();

                MappedClass mappedClass = mcm.getMappedClassByClassName(nextResult.getClassName());
                IDataProvider dataProvider = cwh.getDataProviderManager().getDataProviderByName(mappedClass.dataProviderName);
                results.add( (Schedule) dataProvider.findById(nextResult, null) );
            }
        }

        return results;
    }


}

