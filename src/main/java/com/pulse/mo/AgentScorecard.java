

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
import com.pulse.mo.mo_super._Super_AgentScorecard;

@Entity(name="AgentScorecard")
public class AgentScorecard extends _Super_AgentScorecard
{
	public CoachingNotification getCoachingNotification() {
		IChangeWatcherHelperFactory cwhf = ChangeWatcherHelperFactory.getInstance();

		DerivedValueChangeWatcherHelper cwh = (DerivedValueChangeWatcherHelper) cwhf.getHelper(getClass().getCanonicalName());
		ClassIDPair result = (ClassIDPair) cwh.get("coachingNotification", new ClassIDPair(this.getID(), this.getClass().getCanonicalName()));

		CoachingNotification coachingNotification = null;
		if (result != null)
		{
			IMappedClassManager mcm = MappedClassManagerFactory.getMappedClassManager();
			MappedClass mappedClass = mcm.getMappedClassByClassName(result.getClassName());

			IDataProvider dataProvider = cwh.getDataProviderManager().getDataProviderByName(mappedClass.dataProviderName);
			coachingNotification = (CoachingNotification) dataProvider.findById(result, null);
		}

		return coachingNotification;
	}

//	@SuppressWarnings("unchecked")
//	public List<ScorecardMonthlyResult> getScorecardMonthlyResults() {
//		IChangeWatcherHelperFactory cwhf = ChangeWatcherHelperFactory.getInstance();
//
//		DerivedValueChangeWatcherHelper cwh = (DerivedValueChangeWatcherHelper) cwhf.getHelper(getClass().getCanonicalName());
//
//		List<ClassIDPair> result = (List<ClassIDPair>) cwh.get("scorecardMonthlyResults", new ClassIDPair(this.getID(), this.getClass().getCanonicalName()));
//
//		List<ScorecardMonthlyResult> results = new ArrayList<ScorecardMonthlyResult>();
//		if (result != null)
//		{
//			IMappedClassManager mcm = MappedClassManagerFactory.getMappedClassManager();
//
//			Iterator<ClassIDPair> itrResult = result.iterator();
//			while(itrResult.hasNext()) {
//				ClassIDPair nextResult = itrResult.next();
//
//				MappedClass mappedClass = mcm.getMappedClassByClassName(nextResult.getClassName());
//				IDataProvider dataProvider = cwh.getDataProviderManager().getDataProviderByName(mappedClass.dataProviderName);
//				results.add( (ScorecardMonthlyResult) dataProvider.findById(nextResult, null) );
//			}
//		}
//
//		return results;
//	}

}

