
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
import com.pulse.mo.mo_super._Super_ScorecardWeeklyScore;
import com.pulse.sync.cw.ScorecardWeeklyScoreCWHelper;

@Entity(name="ScorecardWeeklyScore")
public class ScorecardWeeklyScore extends _Super_ScorecardWeeklyScore
{
	public ScorecardWeeklyScore getPreviousScorecardWeeklyScore() {
		IChangeWatcherHelperFactory cwhf = ChangeWatcherHelperFactory.getInstance();
		
		DerivedValueChangeWatcherHelper cwh = (DerivedValueChangeWatcherHelper) cwhf.getHelper(getClass().getCanonicalName());
		
		ClassIDPair result = (ClassIDPair) cwh.get(ScorecardWeeklyScoreCWHelper.PREVIOUS_SCORECARD_WEEKLY_SCORE, new ClassIDPair(this.getID(), this.getClass().getCanonicalName()));
		
		if (result != null)
		{
			IMappedClassManager mcm = MappedClassManagerFactory.getMappedClassManager();
			
			MappedClass mappedClass = mcm.getMappedClassByClassName(result.getClassName());
			IDataProvider dataProvider = cwh.getDataProviderManager().getDataProviderByName(mappedClass.dataProviderName);
			return (ScorecardWeeklyScore) dataProvider.findById(result, null);
		}
		
		return null;
	}
}
