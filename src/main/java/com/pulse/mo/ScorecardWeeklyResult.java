
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
import com.pulse.mo.mo_super._Super_ScorecardWeeklyResult;
import com.pulse.sync.cw.ScorecardWeeklyResultCWHelper;

@Entity(name="ScorecardWeeklyResult")
public class ScorecardWeeklyResult extends _Super_ScorecardWeeklyResult
{
	public ScorecardMonthlyResult getCurrentScorecardMonthlyResult() {
		IChangeWatcherHelperFactory cwhf = ChangeWatcherHelperFactory.getInstance();
		
		DerivedValueChangeWatcherHelper cwh = (DerivedValueChangeWatcherHelper) cwhf.getHelper(getClass().getCanonicalName());
		
		ClassIDPair result = (ClassIDPair) cwh.get(ScorecardWeeklyResultCWHelper.CURRENT_SCORECARD_MONTHLY_RESULT, new ClassIDPair(this.getID(), this.getClass().getCanonicalName()));
		
		if (result != null)
		{
			IMappedClassManager mcm = MappedClassManagerFactory.getMappedClassManager();
			
			MappedClass mappedClass = mcm.getMappedClassByClassName(result.getClassName());
			IDataProvider dataProvider = cwh.getDataProviderManager().getDataProviderByName(mappedClass.dataProviderName);
			return (ScorecardMonthlyResult) dataProvider.findById(result, null);
		}
		
		return null;
	}
}
