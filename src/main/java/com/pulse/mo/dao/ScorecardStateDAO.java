
package com.pulse.mo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.percero.agents.sync.dao.DAORegistry;
import com.percero.agents.sync.exceptions.SyncException;
import com.pulse.mo.ScorecardState;

/*
import com.pulse.mo.ScorecardState;
import com.pulse.mo.Scorecard;

*/

@Component
public class ScorecardStateDAO extends SqlDataAccessObject<ScorecardState> {// implements IDataAccessObject<ScorecardState> {

	static final Logger log = Logger.getLogger(ScorecardStateDAO.class);

	
	public ScorecardStateDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(ScorecardState.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	@Override
	protected String getConnectionFactoryName() {
		return ScorecardStateDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT scorecardstate.ID FROM ScorecardState scorecardstate WHERE scorecardstate.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT scorecardstate.ID,scorecardstate.name,scorecardstate.externalID FROM ScorecardState scorecardstate WHERE scorecardstate.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT scorecardstate.ID FROM ScorecardState scorecardstate ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT scorecardstate.ID FROM ScorecardState scorecardstate ORDER BY scorecardstate.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT scorecardstate.ID,scorecardstate.name,scorecardstate.externalID FROM ScorecardState scorecardstate ORDER BY scorecardstate.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT scorecardstate.ID,scorecardstate.name,scorecardstate.externalID FROM ScorecardState scorecardstate ORDER BY scorecardstate.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM ScorecardState scorecardstate";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT scorecardstate.ID,scorecardstate.name,scorecardstate.externalID FROM ScorecardState scorecardstate WHERE scorecardstate.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT scorecardstate.ID FROM ScorecardState scorecardstate WHERE scorecardstate.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT scorecardstate.ID,scorecardstate.name,scorecardstate.externalID FROM ScorecardState scorecardstate WHERE scorecardstate." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT scorecardstate.ID FROM ScorecardState scorecardstate WHERE scorecardstate." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT scorecardstate.ID FROM ScorecardState scorecardstate ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT scorecardstate.ID,scorecardstate.name,scorecardstate.externalID FROM ScorecardState scorecardstate ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO ScorecardState (ID,name,externalID) VALUES (?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE ScorecardState SET name=?,externalID=? WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM ScorecardState WHERE ID=?";
	}
	
	@Override
	protected ScorecardState extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	ScorecardState nextResult = new ScorecardState();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setName(rs.getString("name"));

nextResult.setExternalID(rs.getString("externalID"));


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(ScorecardState perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getName());
pstmt.setString(3, perceroObject.getExternalID());

		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(ScorecardState perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getName());
pstmt.setString(2, perceroObject.getExternalID());
pstmt.setString(3, perceroObject.getID());

		
	}

	@Override
	public List<ScorecardState> findByExample(ScorecardState theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useName = StringUtils.hasText(theQueryObject.getName()) && (excludeProperties == null || !excludeProperties.contains("name"));

if (useName)
{
sql += " WHERE ";
paramValues.add(theQueryObject.getName());
propertyCounter++;
}

boolean useExternalID = StringUtils.hasText(theQueryObject.getExternalID()) && (excludeProperties == null || !excludeProperties.contains("externalID"));

if (useExternalID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " externalID=? ";
paramValues.add(theQueryObject.getExternalID());
propertyCounter++;
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
		
		return executeSelectWithParams(sql, paramValues.toArray(), shellOnly);		
	}
	
}
