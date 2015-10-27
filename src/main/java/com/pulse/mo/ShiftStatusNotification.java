
package com.pulse.mo;

import java.util.ArrayList;
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
import com.pulse.mo.mo_super._Super_ShiftStatusNotification;
import com.pulse.sync.cw.ShiftStatusNotificationCWHelper;

@Entity(name="ShiftStatusNotification")
public class ShiftStatusNotification extends _Super_ShiftStatusNotification
{
	@SuppressWarnings("unchecked")
	public List<Timecard> getTimecards() {
		IChangeWatcherHelperFactory cwhf = ChangeWatcherHelperFactory.getInstance();
		
		DerivedValueChangeWatcherHelper cwh = (DerivedValueChangeWatcherHelper) cwhf.getHelper(getClass().getCanonicalName());
		
		List<ClassIDPair> result = (List<ClassIDPair>) cwh.get(ShiftStatusNotificationCWHelper.TIMECARDS, new ClassIDPair(this.getID(), this.getClass().getCanonicalName()));
		
		List<Timecard> results = new ArrayList<Timecard>();
		if (result != null)
		{
			IMappedClassManager mcm = MappedClassManagerFactory.getMappedClassManager();
			
			Iterator<ClassIDPair> itrResult = result.iterator();
			while(itrResult.hasNext()) {
				ClassIDPair nextResult = itrResult.next();
				
				MappedClass mappedClass = mcm.getMappedClassByClassName(nextResult.getClassName());
				IDataProvider dataProvider = cwh.getDataProviderManager().getDataProviderByName(mappedClass.dataProviderName);
				results.add( (Timecard) dataProvider.findById(nextResult, null) );
			}
		}
		
		return results;
	}

	public Integer getNotYetStartedStateCount() {
		IChangeWatcherHelperFactory cwhf = ChangeWatcherHelperFactory.getInstance();
		DerivedValueChangeWatcherHelper cwh = (DerivedValueChangeWatcherHelper) cwhf.getHelper(getClass().getCanonicalName());
		Integer result = (Integer) cwh.get(ShiftStatusNotificationCWHelper.NOT_YET_STARTED_STATE_COUNT, new ClassIDPair(this.getID(), this.getClass().getCanonicalName()));
		return result;
	}
	
	public Integer getApprovedStateCount() {
		IChangeWatcherHelperFactory cwhf = ChangeWatcherHelperFactory.getInstance();
		DerivedValueChangeWatcherHelper cwh = (DerivedValueChangeWatcherHelper) cwhf.getHelper(getClass().getCanonicalName());
		Integer result = (Integer) cwh.get(ShiftStatusNotificationCWHelper.APPROVED_STATE_COUNT, new ClassIDPair(this.getID(), this.getClass().getCanonicalName()));
		return result;
	}
	
	public Integer getCompletedStateCount() {
		IChangeWatcherHelperFactory cwhf = ChangeWatcherHelperFactory.getInstance();
		DerivedValueChangeWatcherHelper cwh = (DerivedValueChangeWatcherHelper) cwhf.getHelper(getClass().getCanonicalName());
		Integer result = (Integer) cwh.get(ShiftStatusNotificationCWHelper.COMPLETED_STATE_COUNT, new ClassIDPair(this.getID(), this.getClass().getCanonicalName()));
		return result;
	}
	
	public Integer getInProgressStateCount() {
		IChangeWatcherHelperFactory cwhf = ChangeWatcherHelperFactory.getInstance();
		DerivedValueChangeWatcherHelper cwh = (DerivedValueChangeWatcherHelper) cwhf.getHelper(getClass().getCanonicalName());
		Integer result = (Integer) cwh.get(ShiftStatusNotificationCWHelper.IN_PROGRESS_STATE_COUNT, new ClassIDPair(this.getID(), this.getClass().getCanonicalName()));
		return result;
	}
	
	public Integer getUnknownStateCount() {
		IChangeWatcherHelperFactory cwhf = ChangeWatcherHelperFactory.getInstance();
		DerivedValueChangeWatcherHelper cwh = (DerivedValueChangeWatcherHelper) cwhf.getHelper(getClass().getCanonicalName());
		Integer result = (Integer) cwh.get(ShiftStatusNotificationCWHelper.UNKNOWN_STATE_COUNT, new ClassIDPair(this.getID(), this.getClass().getCanonicalName()));
		return result;
	}
}
