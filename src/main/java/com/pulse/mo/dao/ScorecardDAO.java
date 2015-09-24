
package com.pulse.mo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.percero.agents.sync.dao.DAORegistry;
import com.percero.agents.sync.dao.IDataAccessObject;
import com.percero.agents.sync.exceptions.SyncException;
import com.pulse.mo.Scorecard;
import com.pulse.mo.ScorecardState;

/*
import com.pulse.mo.Scorecard;
import com.pulse.mo.Agent;
import com.pulse.mo.CoachingSession;
import com.pulse.mo.CoachingNotification;
import com.pulse.mo.ScorecardState;

*/

@Component
public class ScorecardDAO extends HybridSqlDataAccessObject<Scorecard> implements IDataAccessObject<Scorecard> {

	static final Logger log = Logger.getLogger(ScorecardDAO.class);

	
	public ScorecardDAO() {
		super();
		
		externalPropertyNames = new HashSet<String>(10);
		externalPropertyNames.add("ID");
		externalPropertyNames.add("skippedCoachingSessionCount");
		externalPropertyNames.add("submittedCoachingSessionCount");
		externalPropertyNames.add("totalCoachingSessionCount");
		externalPropertyNames.add("name");
		externalPropertyNames.add("pendingCoachCoachingSessionCount");
		externalPropertyNames.add("pendingCoachingSessionCount");
		externalPropertyNames.add("pendingEmployeeCoachingSessionCount");
		externalPropertyNames.add("scorecardName");
		externalPropertyNames.add("acknowledgedCoachingSessionCount");

		internalPropertyNames = new HashSet<String>(2);
		internalPropertyNames.add("ID");
		internalPropertyNames.add("scorecardState");
		
		DAORegistry.getInstance().registerDataAccessObject(Scorecard.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
	
	public static final String INTERNAL_CONNECTION_FACTORY_NAME = "default";
	public static final String EXTERNAL_CONNECTION_FACTORY_NAME = "external";
	
	@Override
	public String getExternalConnectionFactoryName() {
		return ScorecardDAO.EXTERNAL_CONNECTION_FACTORY_NAME;
	}

	@Override
	public String getInternalConnectionFactoryName() {
		return ScorecardDAO.INTERNAL_CONNECTION_FACTORY_NAME;
	}
	
	private Set<String> externalPropertyNames = null;
	@Override
	public Set<String> getExternalPropertyNames() {
		return externalPropertyNames;
	}

	private Set<String> internalPropertyNames = null;
	@Override
	public Set<String> getInternalPropertyNames() {
		return internalPropertyNames;
	}

	
	@Override
	public String getExternalSelectShellOnlySQL() {
		return "SELECT scorecard.ID FROM Scorecard scorecard WHERE scorecard.ID=?";
	}
	
	@Override
	public String getInternalSelectShellOnlySQL() {
		return "SELECT scorecard.ID FROM Scorecard scorecard WHERE scorecard.ID=?";
	}
	
	@Override
	public String getExternalSelectStarSQL() {
		return "SELECT scorecard.ID,scorecard.skippedCoachingSessionCount,scorecard.submittedCoachingSessionCount,scorecard.totalCoachingSessionCount,scorecard.name,scorecard.pendingCoachCoachingSessionCount,scorecard.pendingCoachingSessionCount,scorecard.pendingEmployeeCoachingSessionCount,scorecard.scorecardName,scorecard.acknowledgedCoachingSessionCount FROM Scorecard scorecard WHERE scorecard.ID=?";
	}
	
	@Override
	public String getInternalSelectStarSQL() {
		return "SELECT scorecard.ID,scorecard.scorecardState_ID FROM Scorecard scorecard WHERE scorecard.ID=?";
	}
	
	@Override
	public String getExternalSelectAllShellOnlySQL() {
		return "SELECT scorecard.ID FROM Scorecard scorecard ORDER BY ID";
	}
	
	@Override
	public String getInternalSelectAllShellOnlySQL() {
		return "SELECT scorecard.ID FROM Scorecard scorecard ORDER BY ID";
	}
	
	@Override
	public String getExternalSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT scorecard.ID FROM Scorecard scorecard ORDER BY scorecard.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	public String getInternalSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT scorecard.ID FROM Scorecard scorecard ORDER BY scorecard.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	public String getExternalSelectAllStarSQL() {
		return "SELECT scorecard.ID,scorecard.skippedCoachingSessionCount,scorecard.submittedCoachingSessionCount,scorecard.totalCoachingSessionCount,scorecard.name,scorecard.pendingCoachCoachingSessionCount,scorecard.pendingCoachingSessionCount,scorecard.pendingEmployeeCoachingSessionCount,scorecard.scorecardName,scorecard.acknowledgedCoachingSessionCount FROM Scorecard scorecard ORDER BY scorecard.ID";
	}
	
	@Override
	public String getInternalSelectAllStarSQL() {
		return "SELECT scorecard.ID,scorecard.scorecardState_ID FROM Scorecard scorecard ORDER BY scorecard.ID";
	}
	
	@Override
	public String getExternalSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT scorecard.ID,scorecard.skippedCoachingSessionCount,scorecard.submittedCoachingSessionCount,scorecard.totalCoachingSessionCount,scorecard.name,scorecard.pendingCoachCoachingSessionCount,scorecard.pendingCoachingSessionCount,scorecard.pendingEmployeeCoachingSessionCount,scorecard.scorecardName,scorecard.acknowledgedCoachingSessionCount,scorecard.scorecardState_ID FROM Scorecard scorecard ORDER BY scorecard.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	public String getInternalSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT scorecard.ID,scorecard.skippedCoachingSessionCount,scorecard.submittedCoachingSessionCount,scorecard.totalCoachingSessionCount,scorecard.name,scorecard.pendingCoachCoachingSessionCount,scorecard.pendingCoachingSessionCount,scorecard.pendingEmployeeCoachingSessionCount,scorecard.scorecardName,scorecard.acknowledgedCoachingSessionCount,scorecard.scorecardState_ID FROM Scorecard scorecard ORDER BY scorecard.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	public String getExternalCountAllSQL() {
		return "SELECT COUNT(ID) FROM Scorecard scorecard";
	}
	
	@Override
	public String getInternalCountAllSQL() {
		return "SELECT COUNT(ID) FROM Scorecard scorecard";
	}
	
	@Override
	public String getExternalSelectInStarSQL() {
		return "SELECT scorecard.ID,scorecard.skippedCoachingSessionCount,scorecard.submittedCoachingSessionCount,scorecard.totalCoachingSessionCount,scorecard.name,scorecard.pendingCoachCoachingSessionCount,scorecard.pendingCoachingSessionCount,scorecard.pendingEmployeeCoachingSessionCount,scorecard.scorecardName,scorecard.acknowledgedCoachingSessionCount FROM Scorecard scorecard WHERE scorecard.ID IN (?)";
	}
	
	@Override
	public String getInternalSelectInStarSQL() {
		return "SELECT scorecard.ID,scorecard.scorecardState_ID FROM Scorecard scorecard WHERE scorecard.ID IN (?)";
	}
	
	@Override
	public String getExternalSelectInShellOnlySQL() {
		return "SELECT scorecard.ID FROM Scorecard scorecard WHERE scorecard.ID IN (?)";
	}

	@Override
	public String getInternalSelectInShellOnlySQL() {
		return "SELECT scorecard.ID FROM Scorecard scorecard WHERE scorecard.ID IN (?)";
	}
	
	@Override
	public String getExternalSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT scorecard.ID,scorecard.skippedCoachingSessionCount,scorecard.submittedCoachingSessionCount,scorecard.totalCoachingSessionCount,scorecard.name,scorecard.pendingCoachCoachingSessionCount,scorecard.pendingCoachingSessionCount,scorecard.pendingEmployeeCoachingSessionCount,scorecard.scorecardName,scorecard.acknowledgedCoachingSessionCount FROM Scorecard scorecard WHERE scorecard." + joinColumnName + "=?";
	}
	
	@Override
	public String getInternalSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT scorecard.ID,scorecard.scorecardState_ID FROM Scorecard scorecard WHERE scorecard." + joinColumnName + "=?";
	}
	
	@Override
	public String getExternalSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT scorecard.ID FROM Scorecard scorecard WHERE scorecard." + joinColumnName + "=?";
	}

	@Override
	public String getInternalSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT scorecard.ID FROM Scorecard scorecard WHERE scorecard." + joinColumnName + "=?";
	}
	
	@Override
	public String getExternalFindByExampleSelectShellOnlySQL() {
		return "SELECT scorecard.ID FROM Scorecard scorecard ";
	}

	@Override
	public String getInternalFindByExampleSelectShellOnlySQL() {
		return "SELECT scorecard.ID FROM Scorecard scorecard ";
	}
	
	@Override
	public String getExternalFindByExampleSelectAllStarSQL() {
		return "SELECT scorecard.ID,scorecard.skippedCoachingSessionCount,scorecard.submittedCoachingSessionCount,scorecard.totalCoachingSessionCount,scorecard.name,scorecard.pendingCoachCoachingSessionCount,scorecard.pendingCoachingSessionCount,scorecard.pendingEmployeeCoachingSessionCount,scorecard.scorecardName,scorecard.acknowledgedCoachingSessionCount FROM Scorecard scorecard ";
	}
	
	@Override
	public String getInternalFindByExampleSelectAllStarSQL() {
		return "SELECT scorecard.ID,scorecard.scorecardState_ID FROM Scorecard scorecard ";
	}
	
	@Override
	public String getInsertInto() {
		return "INSERT INTO Scorecard (ID,scorecardState_ID) VALUES (?,?)";
	}
	
	@Override
	public String getUpdateSet() {
		return "UPDATE Scorecard SET scorecardState_ID=? WHERE ID=?";
	}

	@Override
	public void setPreparedStatmentInsertParams(
			Scorecard perceroObject, PreparedStatement pstmt)
			throws SQLException {
		pstmt.setString(1, perceroObject.getID());
		if (perceroObject.getScorecardState() == null)
		{
			pstmt.setString(2, null);
		}
		else
		{
			pstmt.setString(2, perceroObject.getScorecardState().getID());
		}
	}
	
	@Override
	public void setPreparedStatmentUpdateParams(Scorecard perceroObject, PreparedStatement pstmt) throws SQLException {
		
		if (perceroObject.getScorecardState() == null)
		{
			pstmt.setString(1, null);
		}
		else
		{
			pstmt.setString(1, perceroObject.getScorecardState().getID());
		}
		
		pstmt.setString(2, perceroObject.getID());
	}
	
	@Override
	public List<Scorecard> findByExample(Scorecard theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
		
		// External	
		String externalSql = getExternalFindByExampleSelectSql(shellOnly);
		int externalPropertyCounter = 0;
		List<Object> externalParamValues = new ArrayList<Object>();
		
		boolean useSkippedCoachingSessionCount = theQueryObject
				.getSkippedCoachingSessionCount() != null
				&& (excludeProperties == null || !excludeProperties
						.contains("skippedCoachingSessionCount"));
		if (useSkippedCoachingSessionCount) {
			if (externalPropertyCounter > 0) {
				externalSql += " AND ";
			} else {
				externalSql += " WHERE ";
			}
			externalSql += " skippedCoachingSessionCount=? ";
			externalParamValues.add(theQueryObject.getSkippedCoachingSessionCount());
			externalPropertyCounter++;
		}

		boolean useSubmittedCoachingSessionCount = theQueryObject
				.getSubmittedCoachingSessionCount() != null
				&& (excludeProperties == null || !excludeProperties
						.contains("submittedCoachingSessionCount"));

		if (useSubmittedCoachingSessionCount) {
			if (externalPropertyCounter > 0) {
				externalSql += " AND ";
			} else {
				externalSql += " WHERE ";
			}
			externalSql += " submittedCoachingSessionCount=? ";
			externalParamValues.add(theQueryObject
					.getSubmittedCoachingSessionCount());
			externalPropertyCounter++;
		}

		boolean useTotalCoachingSessionCount = theQueryObject
				.getTotalCoachingSessionCount() != null
				&& (excludeProperties == null || !excludeProperties
						.contains("totalCoachingSessionCount"));

		if (useTotalCoachingSessionCount) {
			if (externalPropertyCounter > 0) {
				externalSql += " AND ";
			} else {
				externalSql += " WHERE ";
			}
			externalSql += " totalCoachingSessionCount=? ";
			externalParamValues.add(theQueryObject
					.getTotalCoachingSessionCount());
			externalPropertyCounter++;
		}

		boolean useName = StringUtils.hasText(theQueryObject.getName())
				&& (excludeProperties == null || !excludeProperties
						.contains("name"));

		if (useName) {
			if (externalPropertyCounter > 0) {
				externalSql += " AND ";
			} else {
				externalSql += " WHERE ";
			}
			externalSql += " name=? ";
			externalParamValues.add(theQueryObject.getName());
			externalPropertyCounter++;
		}

		boolean usePendingCoachCoachingSessionCount = theQueryObject
				.getPendingCoachCoachingSessionCount() != null
				&& (excludeProperties == null || !excludeProperties
						.contains("pendingCoachCoachingSessionCount"));

		if (usePendingCoachCoachingSessionCount) {
			if (externalPropertyCounter > 0) {
				externalSql += " AND ";
			} else {
				externalSql += " WHERE ";
			}
			externalSql += " pendingCoachCoachingSessionCount=? ";
			externalParamValues.add(theQueryObject
					.getPendingCoachCoachingSessionCount());
			externalPropertyCounter++;
		}

		boolean usePendingCoachingSessionCount = theQueryObject
				.getPendingCoachingSessionCount() != null
				&& (excludeProperties == null || !excludeProperties
						.contains("pendingCoachingSessionCount"));

		if (usePendingCoachingSessionCount) {
			if (externalPropertyCounter > 0) {
				externalSql += " AND ";
			} else {
				externalSql += " WHERE ";
			}
			externalSql += " pendingCoachingSessionCount=? ";
			externalParamValues.add(theQueryObject
					.getPendingCoachingSessionCount());
			externalPropertyCounter++;
		}

		boolean usePendingEmployeeCoachingSessionCount = theQueryObject
				.getPendingEmployeeCoachingSessionCount() != null
				&& (excludeProperties == null || !excludeProperties
						.contains("pendingEmployeeCoachingSessionCount"));

		if (usePendingEmployeeCoachingSessionCount) {
			if (externalPropertyCounter > 0) {
				externalSql += " AND ";
			} else {
				externalSql += " WHERE ";
			}
			externalSql += " pendingEmployeeCoachingSessionCount=? ";
			externalParamValues.add(theQueryObject
					.getPendingEmployeeCoachingSessionCount());
			externalPropertyCounter++;
		}

		boolean useScorecardName = StringUtils.hasText(theQueryObject
				.getScorecardName())
				&& (excludeProperties == null || !excludeProperties
						.contains("scorecardName"));

		if (useScorecardName) {
			if (externalPropertyCounter > 0) {
				externalSql += " AND ";
			} else {
				externalSql += " WHERE ";
			}
			externalSql += " scorecardName=? ";
			externalParamValues.add(theQueryObject.getScorecardName());
			externalPropertyCounter++;
		}

		boolean useAcknowledgedCoachingSessionCount = theQueryObject
				.getAcknowledgedCoachingSessionCount() != null
				&& (excludeProperties == null || !excludeProperties
						.contains("acknowledgedCoachingSessionCount"));

		if (useAcknowledgedCoachingSessionCount) {
			if (externalPropertyCounter > 0) {
				externalSql += " AND ";
			} else {
				externalSql += " WHERE ";
			}
			externalSql += " acknowledgedCoachingSessionCount=? ";
			externalParamValues.add(theQueryObject
					.getAcknowledgedCoachingSessionCount());
			externalPropertyCounter++;
		}

		//Internal
		String internalSql = getInternalFindByExampleSelectSql(shellOnly);
		int internalPropertyCounter = 0;
		List<Object> internalParamValues = new ArrayList<Object>();
		
		boolean useScorecardStateID = theQueryObject.getScorecardState() != null
				&& (excludeProperties == null || !excludeProperties
						.contains("scorecardState"));

		if (useScorecardStateID) {
			if (internalPropertyCounter > 0) {
				internalSql += " AND ";
			} else {
				internalSql += " WHERE ";
			}
			internalSql += " scorecardStateID=? ";
			internalParamValues.add(theQueryObject.getScorecardState().getID());
			internalPropertyCounter++;
		}

		/*
		boolean useValue = StringUtils.hasText(theQueryObject.getValue()) && (excludeProperties == null || !excludeProperties.contains("value"));
		
		if (useValue) {
			sql += " WHERE value=? ";
			paramValues.add(theQueryObject.getValue());
			propertyCounter++;
		}
		
		boolean usePersonId = theQueryObject.getPerson() != null && (excludeProperties == null || !excludeProperties.contains("person"));
		
		if (usePersonId) {
			if (propertyCounter > 0) {
				sql += " AND ";
			}
			else {
				sql += " WHERE ";
			}
			sql += " person_ID=? ";
			paramValues.add(theQueryObject.getPerson().getID());
			propertyCounter++;
		}
		
		*/
		
		return executeSelectWithParams(externalSql, externalParamValues.toArray(), internalSql, internalParamValues.toArray(), shellOnly);		
	}
	

	@Override
	public Scorecard extractObjectFromExternalResultSet(ResultSet rs, Boolean shellOnly, Scorecard nextResult) throws SQLException {
		if (nextResult == null) {
			nextResult = new Scorecard();
			// ID
			nextResult.setID(rs.getString("ID"));
		}
    	
    	if (!shellOnly) 
		{
			nextResult.setSkippedCoachingSessionCount(rs.getInt("skippedCoachingSessionCount"));
			
			nextResult.setSubmittedCoachingSessionCount(rs.getInt("submittedCoachingSessionCount"));
			
			nextResult.setTotalCoachingSessionCount(rs.getInt("totalCoachingSessionCount"));
			
			nextResult.setName(rs.getString("name"));
			
			nextResult.setPendingCoachCoachingSessionCount(rs.getInt("pendingCoachCoachingSessionCount"));
			
			nextResult.setPendingCoachingSessionCount(rs.getInt("pendingCoachingSessionCount"));
			
			nextResult.setPendingEmployeeCoachingSessionCount(rs.getInt("pendingEmployeeCoachingSessionCount"));
			
			nextResult.setScorecardName(rs.getString("scorecardName"));
			
			nextResult.setAcknowledgedCoachingSessionCount(rs.getInt("acknowledgedCoachingSessionCount"));
    	}
    	
    	return nextResult;
	}

	@Override
	public Scorecard extractObjectFromInternalResultSet(ResultSet rs, Boolean shellOnly, Scorecard nextResult) throws SQLException {
		if (nextResult == null) {
			nextResult = new Scorecard();
			// ID
			nextResult.setID(rs.getString("ID"));
		}
		
		if (!shellOnly) 
		{
			ScorecardState scorecardstate = new ScorecardState();
			scorecardstate.setID(rs.getString("scorecardstate_ID"));
			nextResult.setScorecardState(scorecardstate);
		}
		
		return nextResult;
	}

}
