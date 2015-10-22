
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
import com.pulse.mo.mo_super._Super_CoachingNotification;

@Entity(name="CoachingNotification")
public class CoachingNotification extends _Super_CoachingNotification
{
	@SuppressWarnings("unchecked")
	public List<AgentScorecard> getAgentScorecards() {
		IChangeWatcherHelperFactory cwhf = ChangeWatcherHelperFactory.getInstance();
		
		DerivedValueChangeWatcherHelper cwh = (DerivedValueChangeWatcherHelper) cwhf.getHelper(getClass().getCanonicalName());
		
		List<ClassIDPair> result = (List<ClassIDPair>) cwh.get("agentScorecards", new ClassIDPair(this.getID(), this.getClass().getCanonicalName()));
		
		List<AgentScorecard> results = new ArrayList<AgentScorecard>();
		if (result != null)
		{
			IMappedClassManager mcm = MappedClassManagerFactory.getMappedClassManager();
			
			Iterator<ClassIDPair> itrResult = result.iterator();
			while(itrResult.hasNext()) {
				ClassIDPair nextResult = itrResult.next();
				
				MappedClass mappedClass = mcm.getMappedClassByClassName(nextResult.getClassName());
				IDataProvider dataProvider = cwh.getDataProviderManager().getDataProviderByName(mappedClass.dataProviderName);
				results.add( (AgentScorecard) dataProvider.findById(nextResult, null) );
			}
		}
		
		return results;
	}

	public Integer getPendingStateCount() {
		IChangeWatcherHelperFactory cwhf = ChangeWatcherHelperFactory.getInstance();
		DerivedValueChangeWatcherHelper cwh = (DerivedValueChangeWatcherHelper) cwhf.getHelper(getClass().getCanonicalName());
		Integer result = (Integer) cwh.get("pendingStateCount", new ClassIDPair(this.getID(), this.getClass().getCanonicalName()));
		return result;
	}
 
	public Integer getPendingEmployeeStateCount() {
		IChangeWatcherHelperFactory cwhf = ChangeWatcherHelperFactory.getInstance();
		DerivedValueChangeWatcherHelper cwh = (DerivedValueChangeWatcherHelper) cwhf.getHelper(getClass().getCanonicalName());
		Integer result = (Integer) cwh.get("pendingEmployeeStateCount", new ClassIDPair(this.getID(), this.getClass().getCanonicalName()));
		return result;
	}
	
	public Integer getSubmittedStateCount() {
		IChangeWatcherHelperFactory cwhf = ChangeWatcherHelperFactory.getInstance();
		DerivedValueChangeWatcherHelper cwh = (DerivedValueChangeWatcherHelper) cwhf.getHelper(getClass().getCanonicalName());
		Integer result = (Integer) cwh.get("submittedStateCount", new ClassIDPair(this.getID(), this.getClass().getCanonicalName()));
		return result;
	}
 
	public Integer getPendingCoachStateCount() {
		IChangeWatcherHelperFactory cwhf = ChangeWatcherHelperFactory.getInstance();
		DerivedValueChangeWatcherHelper cwh = (DerivedValueChangeWatcherHelper) cwhf.getHelper(getClass().getCanonicalName());
		Integer result = (Integer) cwh.get("pendingCoachStateCount", new ClassIDPair(this.getID(), this.getClass().getCanonicalName()));
		return result;
	}
 
	public Integer getSkippedStateCount() {
		IChangeWatcherHelperFactory cwhf = ChangeWatcherHelperFactory.getInstance();
		DerivedValueChangeWatcherHelper cwh = (DerivedValueChangeWatcherHelper) cwhf.getHelper(getClass().getCanonicalName());
		Integer result = (Integer) cwh.get("skippedStateCount", new ClassIDPair(this.getID(), this.getClass().getCanonicalName()));
		return result;
	}
 
	public Integer getAcknowledgementStateCount() {
		IChangeWatcherHelperFactory cwhf = ChangeWatcherHelperFactory.getInstance();
		DerivedValueChangeWatcherHelper cwh = (DerivedValueChangeWatcherHelper) cwhf.getHelper(getClass().getCanonicalName());
		Integer result = (Integer) cwh.get("acknowledgementStateCount", new ClassIDPair(this.getID(), this.getClass().getCanonicalName()));
		return result;
	}
}
