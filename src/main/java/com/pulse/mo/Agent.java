

package com.pulse.mo;

import javax.persistence.Entity;

import com.percero.agents.sync.cw.ChangeWatcherHelperFactory;
import com.percero.agents.sync.cw.DerivedValueChangeWatcherHelper;
import com.percero.agents.sync.cw.IChangeWatcherHelperFactory;
import com.percero.agents.sync.metadata.IMappedClassManager;
import com.percero.agents.sync.metadata.MappedClass;
import com.percero.agents.sync.metadata.MappedClassManagerFactory;
import com.percero.agents.sync.services.IDataProvider;
import com.percero.agents.sync.vo.ClassIDPair;
import com.pulse.mo.mo_super._Super_Agent;
import com.pulse.sync.cw.AgentCWHelper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Entity(name="Agent")
public class Agent extends _Super_Agent
{
	
	public String getTimeZone() {
		IChangeWatcherHelperFactory cwhf = ChangeWatcherHelperFactory.getInstance();
		
		DerivedValueChangeWatcherHelper cwh = (DerivedValueChangeWatcherHelper) cwhf.getHelper(getClass().getCanonicalName());
		
		String result = (String) cwh.get(AgentCWHelper.TIME_ZONE, new ClassIDPair(this.getID(), this.getClass().getCanonicalName()));
		return result;
	}

	@SuppressWarnings("unchecked")
	public List<CMSEntry> getFindCMSEntriesForDate(String theDate) {
		IChangeWatcherHelperFactory cwhf = ChangeWatcherHelperFactory.getInstance();

		String[] params = new String[1];
		params[0] = theDate;

		DerivedValueChangeWatcherHelper cwh = (DerivedValueChangeWatcherHelper) cwhf.getHelper(getClass().getCanonicalName());

		List<ClassIDPair> result = (List<ClassIDPair>) cwh.get(AgentCWHelper.FIND_CMS_ENTRIES_FOR_DATE, new ClassIDPair(this.getID(), this.getClass().getCanonicalName()), params);

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
	public Timecard getFindTimecardForDate(String theDate) {
		IChangeWatcherHelperFactory cwhf = ChangeWatcherHelperFactory.getInstance();

		String[] params = new String[1];
		params[0] = theDate;

		DerivedValueChangeWatcherHelper cwh = (DerivedValueChangeWatcherHelper) cwhf.getHelper(getClass().getCanonicalName());

		ClassIDPair result = (ClassIDPair) cwh.get(AgentCWHelper.FIND_TIMECARD_FOR_DATE, new ClassIDPair(this.getID(), this.getClass().getCanonicalName()), params);

		IMappedClassManager mcm = MappedClassManagerFactory.getMappedClassManager();
		MappedClass mappedClass = mcm.getMappedClassByClassName(result.getClassName());
		IDataProvider dataProvider = cwh.getDataProviderManager().getDataProviderByName(mappedClass.dataProviderName);

		return (Timecard) dataProvider.findById(result, null) ;

	}

	@SuppressWarnings("unchecked")
	public List<TimecardEntry> getFindTimecardEntriesForDate(String theDate) {
		IChangeWatcherHelperFactory cwhf = ChangeWatcherHelperFactory.getInstance();

		String[] params = new String[1];
		params[0] = theDate;

		DerivedValueChangeWatcherHelper cwh = (DerivedValueChangeWatcherHelper) cwhf.getHelper(getClass().getCanonicalName());

		List<ClassIDPair> result = (List<ClassIDPair>) cwh.get(AgentCWHelper.FIND_TIMECARD_ENTRIES_FOR_DATE, new ClassIDPair(this.getID(), this.getClass().getCanonicalName()), params);

		List<TimecardEntry> results = new ArrayList<TimecardEntry>();
		if (result != null)
		{
			IMappedClassManager mcm = MappedClassManagerFactory.getMappedClassManager();

			Iterator<ClassIDPair> itrResult = result.iterator();
			while(itrResult.hasNext()) {
				ClassIDPair nextResult = itrResult.next();

				MappedClass mappedClass = mcm.getMappedClassByClassName(nextResult.getClassName());
				IDataProvider dataProvider = cwh.getDataProviderManager().getDataProviderByName(mappedClass.dataProviderName);
				results.add( (TimecardEntry) dataProvider.findById(nextResult, null) );
			}
		}

		return results;
	}

	@SuppressWarnings("unchecked")
	public Schedule getFindScheduleForDate(String theDate) {
		IChangeWatcherHelperFactory cwhf = ChangeWatcherHelperFactory.getInstance();

		String[] params = new String[1];
		params[0] = theDate;

		DerivedValueChangeWatcherHelper cwh = (DerivedValueChangeWatcherHelper) cwhf.getHelper(getClass().getCanonicalName());

		ClassIDPair result = (ClassIDPair) cwh.get(AgentCWHelper.FIND_SCHEDULE_FOR_DATE, new ClassIDPair(this.getID(), this.getClass().getCanonicalName()), params);

		IMappedClassManager mcm = MappedClassManagerFactory.getMappedClassManager();
		MappedClass mappedClass = mcm.getMappedClassByClassName(result.getClassName());
		IDataProvider dataProvider = cwh.getDataProviderManager().getDataProviderByName(mappedClass.dataProviderName);

		return (Schedule) dataProvider.findById(result, null) ;

	}

	@SuppressWarnings("unchecked")
	public List<ScheduleEntry> getFindScheduleEntriesForDate(String theDate) {
		IChangeWatcherHelperFactory cwhf = ChangeWatcherHelperFactory.getInstance();

		String[] params = new String[1];
		params[0] = theDate;

		DerivedValueChangeWatcherHelper cwh = (DerivedValueChangeWatcherHelper) cwhf.getHelper(getClass().getCanonicalName());

		List<ClassIDPair> result = (List<ClassIDPair>) cwh.get(AgentCWHelper.FIND_SCHEDULE_ENTRIES_FOR_DATE, new ClassIDPair(this.getID(), this.getClass().getCanonicalName()), params);

		List<ScheduleEntry> results = new ArrayList<ScheduleEntry>();
		if (result != null)
		{
			IMappedClassManager mcm = MappedClassManagerFactory.getMappedClassManager();

			Iterator<ClassIDPair> itrResult = result.iterator();
			while(itrResult.hasNext()) {
				ClassIDPair nextResult = itrResult.next();

				MappedClass mappedClass = mcm.getMappedClassByClassName(nextResult.getClassName());
				IDataProvider dataProvider = cwh.getDataProviderManager().getDataProviderByName(mappedClass.dataProviderName);
				results.add( (ScheduleEntry) dataProvider.findById(nextResult, null) );
			}
		}

		return results;
	}
}

