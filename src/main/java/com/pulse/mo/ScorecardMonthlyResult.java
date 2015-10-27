
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
import com.pulse.mo.mo_super._Super_ScorecardMonthlyResult;
import com.pulse.sync.cw.ScorecardMonthlyResultCWHelper;

@Entity(name="ScorecardMonthlyResult")
public class ScorecardMonthlyResult extends _Super_ScorecardMonthlyResult
{

	public ScorecardMonthlyResult getPreviousScorecardMonthlyResult() {
		IChangeWatcherHelperFactory cwhf = ChangeWatcherHelperFactory.getInstance();
		
		DerivedValueChangeWatcherHelper cwh = (DerivedValueChangeWatcherHelper) cwhf.getHelper(getClass().getCanonicalName());
		
		ClassIDPair result = (ClassIDPair) cwh.get(ScorecardMonthlyResultCWHelper.PREVIOUS_SCORECARD_MONTHLY_RESULT, new ClassIDPair(this.getID(), this.getClass().getCanonicalName()));
		
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
