
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
import com.pulse.mo.CorrectiveActionType;
import com.pulse.mo.CorrectiveAction;

*/

@Component
public class CorrectiveActionTypeDAO extends SqlDataAccessObject<CorrectiveActionType> implements IDataAccessObject<CorrectiveActionType> {

	static final Logger log = Logger.getLogger(CorrectiveActionTypeDAO.class);

	
	public CorrectiveActionTypeDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(CorrectiveActionType.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	@Override
	protected String getConnectionFactoryName() {
		return CorrectiveActionTypeDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT correctiveactiontype.ID FROM CorrectiveActionType correctiveactiontype WHERE correctiveactiontype.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT correctiveactiontype.ID,correctiveactiontype.name,correctiveactiontype.externalID FROM CorrectiveActionType correctiveactiontype WHERE correctiveactiontype.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT correctiveactiontype.ID FROM CorrectiveActionType correctiveactiontype ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT correctiveactiontype.ID FROM CorrectiveActionType correctiveactiontype ORDER BY correctiveactiontype.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT correctiveactiontype.ID,correctiveactiontype.name,correctiveactiontype.externalID FROM CorrectiveActionType correctiveactiontype ORDER BY correctiveactiontype.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT correctiveactiontype.ID,correctiveactiontype.name,correctiveactiontype.externalID FROM CorrectiveActionType correctiveactiontype ORDER BY correctiveactiontype.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM CorrectiveActionType correctiveactiontype";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT correctiveactiontype.ID,correctiveactiontype.name,correctiveactiontype.externalID FROM CorrectiveActionType correctiveactiontype WHERE correctiveactiontype.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT correctiveactiontype.ID FROM CorrectiveActionType correctiveactiontype WHERE correctiveactiontype.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT correctiveactiontype.ID,correctiveactiontype.name,correctiveactiontype.externalID FROM CorrectiveActionType correctiveactiontype WHERE correctiveactiontype." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT correctiveactiontype.ID FROM CorrectiveActionType correctiveactiontype WHERE correctiveactiontype." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT correctiveactiontype.ID FROM CorrectiveActionType correctiveactiontype ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT correctiveactiontype.ID,correctiveactiontype.name,correctiveactiontype.externalID FROM CorrectiveActionType correctiveactiontype ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO CorrectiveActionType (ID,name,externalID) VALUES (?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE CorrectiveActionType SET name=?,externalID=? WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM CorrectiveActionType WHERE ID=?";
	}
	
	@Override
	protected CorrectiveActionType extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	CorrectiveActionType nextResult = new CorrectiveActionType();
    	
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
	protected void setPreparedStatmentInsertParams(CorrectiveActionType perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getName());
pstmt.setString(3, perceroObject.getExternalID());

		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(CorrectiveActionType perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getName());
pstmt.setString(2, perceroObject.getExternalID());
pstmt.setString(3, perceroObject.getID());

		
	}

	@Override
	public List<CorrectiveActionType> findByExample(CorrectiveActionType theQueryObject,
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
