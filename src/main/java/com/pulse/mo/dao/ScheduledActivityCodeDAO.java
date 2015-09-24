
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
import com.pulse.mo.ScheduledActivityCode;
import com.pulse.mo.ScheduledTimeEntry;

*/

@Component
public class ScheduledActivityCodeDAO extends SqlDataAccessObject<ScheduledActivityCode> implements IDataAccessObject<ScheduledActivityCode> {

	static final Logger log = Logger.getLogger(ScheduledActivityCodeDAO.class);

	
	public ScheduledActivityCodeDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(ScheduledActivityCode.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	@Override
	protected String getConnectionFactoryName() {
		return ScheduledActivityCodeDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT scheduledactivitycode.ID FROM ScheduledActivityCode scheduledactivitycode WHERE scheduledactivitycode.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT scheduledactivitycode.ID,scheduledactivitycode.externalID,scheduledactivitycode.name FROM ScheduledActivityCode scheduledactivitycode WHERE scheduledactivitycode.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT scheduledactivitycode.ID FROM ScheduledActivityCode scheduledactivitycode ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT scheduledactivitycode.ID FROM ScheduledActivityCode scheduledactivitycode ORDER BY scheduledactivitycode.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT scheduledactivitycode.ID,scheduledactivitycode.externalID,scheduledactivitycode.name FROM ScheduledActivityCode scheduledactivitycode ORDER BY scheduledactivitycode.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT scheduledactivitycode.ID,scheduledactivitycode.externalID,scheduledactivitycode.name FROM ScheduledActivityCode scheduledactivitycode ORDER BY scheduledactivitycode.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM ScheduledActivityCode scheduledactivitycode";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT scheduledactivitycode.ID,scheduledactivitycode.externalID,scheduledactivitycode.name FROM ScheduledActivityCode scheduledactivitycode WHERE scheduledactivitycode.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT scheduledactivitycode.ID FROM ScheduledActivityCode scheduledactivitycode WHERE scheduledactivitycode.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT scheduledactivitycode.ID,scheduledactivitycode.externalID,scheduledactivitycode.name FROM ScheduledActivityCode scheduledactivitycode WHERE scheduledactivitycode." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT scheduledactivitycode.ID FROM ScheduledActivityCode scheduledactivitycode WHERE scheduledactivitycode." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT scheduledactivitycode.ID FROM ScheduledActivityCode scheduledactivitycode ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT scheduledactivitycode.ID,scheduledactivitycode.externalID,scheduledactivitycode.name FROM ScheduledActivityCode scheduledactivitycode ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO ScheduledActivityCode (ID,externalID,name) VALUES (?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE ScheduledActivityCode SET externalID=?,name=? WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM ScheduledActivityCode WHERE ID=?";
	}
	
	@Override
	protected ScheduledActivityCode extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	ScheduledActivityCode nextResult = new ScheduledActivityCode();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setExternalID(rs.getString("externalID"));

nextResult.setName(rs.getString("name"));


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(ScheduledActivityCode perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getExternalID());
pstmt.setString(3, perceroObject.getName());

		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(ScheduledActivityCode perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getExternalID());
pstmt.setString(2, perceroObject.getName());
pstmt.setString(3, perceroObject.getID());

		
	}

	@Override
	public List<ScheduledActivityCode> findByExample(ScheduledActivityCode theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useExternalID = StringUtils.hasText(theQueryObject.getExternalID()) && (excludeProperties == null || !excludeProperties.contains("externalID"));

if (useExternalID)
{
sql += " WHERE ";
paramValues.add(theQueryObject.getExternalID());
propertyCounter++;
}

boolean useName = StringUtils.hasText(theQueryObject.getName()) && (excludeProperties == null || !excludeProperties.contains("name"));

if (useName)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " name=? ";
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
