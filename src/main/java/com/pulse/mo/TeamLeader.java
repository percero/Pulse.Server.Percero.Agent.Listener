
package com.pulse.mo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Entity;

import org.springframework.util.StringUtils;

import com.percero.agents.sync.cw.ChangeWatcherHelperFactory;
import com.percero.agents.sync.cw.DerivedValueChangeWatcherHelper;
import com.percero.agents.sync.cw.IChangeWatcherHelperFactory;
import com.percero.agents.sync.metadata.IMappedClassManager;
import com.percero.agents.sync.metadata.MappedClass;
import com.percero.agents.sync.metadata.MappedClassManagerFactory;
import com.percero.agents.sync.services.IDataProvider;
import com.percero.agents.sync.vo.ClassIDPair;
import com.pulse.mo.mo_super._Super_TeamLeader;
import com.pulse.sync.cw.TeamLeaderCWHelper;

@Entity(name="TeamLeader")
public class TeamLeader extends _Super_TeamLeader
{
	@SuppressWarnings("unchecked")
	public List<AgentScorecard> getAgentScorecards() {
		IChangeWatcherHelperFactory cwhf = ChangeWatcherHelperFactory.getInstance();
		
		DerivedValueChangeWatcherHelper cwh = (DerivedValueChangeWatcherHelper) cwhf.getHelper(getClass().getCanonicalName());
		
		List<ClassIDPair> result = (List<ClassIDPair>) cwh.get(TeamLeaderCWHelper.AGENT_SCORECARDS, new ClassIDPair(this.getID(), this.getClass().getCanonicalName()));
		
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

	@SuppressWarnings("unchecked")
	public List<Scorecard> getScorecards() {
		IChangeWatcherHelperFactory cwhf = ChangeWatcherHelperFactory.getInstance();
		
		DerivedValueChangeWatcherHelper cwh = (DerivedValueChangeWatcherHelper) cwhf.getHelper(getClass().getCanonicalName());
		
		List<ClassIDPair> result = (List<ClassIDPair>) cwh.get(TeamLeaderCWHelper.SCORECARDS, new ClassIDPair(this.getID(), this.getClass().getCanonicalName()));
		
		List<Scorecard> results = new ArrayList<Scorecard>();
		if (result != null)
		{
			IMappedClassManager mcm = MappedClassManagerFactory.getMappedClassManager();
			
			Iterator<ClassIDPair> itrResult = result.iterator();
			while(itrResult.hasNext()) {
				ClassIDPair nextResult = itrResult.next();
				
				MappedClass mappedClass = mcm.getMappedClassByClassName(nextResult.getClassName());
				IDataProvider dataProvider = cwh.getDataProviderManager().getDataProviderByName(mappedClass.dataProviderName);
				results.add( (Scorecard) dataProvider.findById(nextResult, null) );
			}
		}
		
		return results;
	}
	
	public AgentTimeZone getTimeZone() {
		IChangeWatcherHelperFactory cwhf = ChangeWatcherHelperFactory.getInstance();
		
		DerivedValueChangeWatcherHelper cwh = (DerivedValueChangeWatcherHelper) cwhf.getHelper(getClass().getCanonicalName());
		
		ClassIDPair result = (ClassIDPair) cwh.get(TeamLeaderCWHelper.TIMEZONE, new ClassIDPair(this.getID(), this.getClass().getCanonicalName()));

		if (result != null && StringUtils.hasText(result.getID())) {
			IMappedClassManager mcm = MappedClassManagerFactory.getMappedClassManager();
			MappedClass mappedClass = mcm.getMappedClassByClassName(result.getClassName());
			IDataProvider dataProvider = cwh.getDataProviderManager().getDataProviderByName(mappedClass.dataProviderName);
			return (AgentTimeZone) dataProvider.findById(result, null);
		}
		
		return null;
	}
	
}
