
package com.pulse.mo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.percero.util.DateUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.percero.agents.sync.dao.DAORegistry;
import com.percero.agents.sync.dao.IDataAccessObject;
import com.percero.agents.sync.exceptions.SyncException;

import com.pulse.mo.*;

/*
import com.pulse.mo.CoachingSessionState;

*/

@Component
public class CoachingSessionStateDAO extends SqlDataAccessObject<CoachingSessionState> implements IDataAccessObject<CoachingSessionState> {

	static final Logger log = Logger.getLogger(CoachingSessionStateDAO.class);

	
	public CoachingSessionStateDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(CoachingSessionState.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	@Override
	protected String getConnectionFactoryName() {
		return CoachingSessionStateDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT COACHING_SESSION_STATE.ID FROM COACHING_SESSION_STATE COACHING_SESSION_STATE WHERE COACHING_SESSION_STATE.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT COACHING_SESSION_STATE.ID,COACHING_SESSION_STATE.NAME FROM COACHING_SESSION_STATE COACHING_SESSION_STATE WHERE COACHING_SESSION_STATE.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT COACHING_SESSION_STATE.ID FROM COACHING_SESSION_STATE COACHING_SESSION_STATE ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT COACHING_SESSION_STATE.ID FROM COACHING_SESSION_STATE COACHING_SESSION_STATE ORDER BY COACHING_SESSION_STATE.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT COACHING_SESSION_STATE.ID,COACHING_SESSION_STATE.NAME FROM COACHING_SESSION_STATE COACHING_SESSION_STATE ORDER BY COACHING_SESSION_STATE.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT COACHING_SESSION_STATE.ID,COACHING_SESSION_STATE.NAME FROM COACHING_SESSION_STATE COACHING_SESSION_STATE ORDER BY COACHING_SESSION_STATE.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM COACHING_SESSION_STATE COACHING_SESSION_STATE";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT COACHING_SESSION_STATE.ID,COACHING_SESSION_STATE.NAME FROM COACHING_SESSION_STATE COACHING_SESSION_STATE WHERE COACHING_SESSION_STATE.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT COACHING_SESSION_STATE.ID FROM COACHING_SESSION_STATE COACHING_SESSION_STATE WHERE COACHING_SESSION_STATE.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT COACHING_SESSION_STATE.ID,COACHING_SESSION_STATE.NAME FROM COACHING_SESSION_STATE COACHING_SESSION_STATE WHERE COACHING_SESSION_STATE." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT COACHING_SESSION_STATE.ID FROM COACHING_SESSION_STATE COACHING_SESSION_STATE WHERE COACHING_SESSION_STATE." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT COACHING_SESSION_STATE.ID FROM COACHING_SESSION_STATE COACHING_SESSION_STATE ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT COACHING_SESSION_STATE.ID,COACHING_SESSION_STATE.NAME FROM COACHING_SESSION_STATE COACHING_SESSION_STATE ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO COACHING_SESSION_STATE (ID,NAME) VALUES (?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE COACHING_SESSION_STATE SET NAME=? WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM COACHING_SESSION_STATE WHERE ID=?";
	}
	
	@Override
	protected CoachingSessionState extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	CoachingSessionState nextResult = new CoachingSessionState();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setName(rs.getString("NAME"));


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(CoachingSessionState perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getName());

		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(CoachingSessionState perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getName());
pstmt.setString(2, perceroObject.getID());

		
	}

	@Override
	public List<CoachingSessionState> findByExample(CoachingSessionState theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useName = StringUtils.hasText(theQueryObject.getName()) && (excludeProperties == null || !excludeProperties.contains("name"));

if (useName)
{
sql += " WHERE ";
sql += " NAME=? ";
paramValues.add(theQueryObject.getName());
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
