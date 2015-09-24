
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
import com.pulse.mo.NotificationFrequency;
import com.pulse.mo.LOBConfigurationEntry;

*/

@Component
public class NotificationFrequencyDAO extends SqlDataAccessObject<NotificationFrequency> implements IDataAccessObject<NotificationFrequency> {

	static final Logger log = Logger.getLogger(NotificationFrequencyDAO.class);

	
	public NotificationFrequencyDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(NotificationFrequency.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	@Override
	protected String getConnectionFactoryName() {
		return NotificationFrequencyDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT notificationfrequency.ID FROM NotificationFrequency notificationfrequency WHERE notificationfrequency.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT notificationfrequency.ID,notificationfrequency.externalID,notificationfrequency.name FROM NotificationFrequency notificationfrequency WHERE notificationfrequency.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT notificationfrequency.ID FROM NotificationFrequency notificationfrequency ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT notificationfrequency.ID FROM NotificationFrequency notificationfrequency ORDER BY notificationfrequency.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT notificationfrequency.ID,notificationfrequency.externalID,notificationfrequency.name FROM NotificationFrequency notificationfrequency ORDER BY notificationfrequency.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT notificationfrequency.ID,notificationfrequency.externalID,notificationfrequency.name FROM NotificationFrequency notificationfrequency ORDER BY notificationfrequency.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM NotificationFrequency notificationfrequency";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT notificationfrequency.ID,notificationfrequency.externalID,notificationfrequency.name FROM NotificationFrequency notificationfrequency WHERE notificationfrequency.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT notificationfrequency.ID FROM NotificationFrequency notificationfrequency WHERE notificationfrequency.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT notificationfrequency.ID,notificationfrequency.externalID,notificationfrequency.name FROM NotificationFrequency notificationfrequency WHERE notificationfrequency." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT notificationfrequency.ID FROM NotificationFrequency notificationfrequency WHERE notificationfrequency." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT notificationfrequency.ID FROM NotificationFrequency notificationfrequency ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT notificationfrequency.ID,notificationfrequency.externalID,notificationfrequency.name FROM NotificationFrequency notificationfrequency ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO NotificationFrequency (ID,externalID,name) VALUES (?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE NotificationFrequency SET externalID=?,name=? WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM NotificationFrequency WHERE ID=?";
	}
	
	@Override
	protected NotificationFrequency extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	NotificationFrequency nextResult = new NotificationFrequency();
    	
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
	protected void setPreparedStatmentInsertParams(NotificationFrequency perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getExternalID());
pstmt.setString(3, perceroObject.getName());

		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(NotificationFrequency perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getExternalID());
pstmt.setString(2, perceroObject.getName());
pstmt.setString(3, perceroObject.getID());

		
	}

	@Override
	public List<NotificationFrequency> findByExample(NotificationFrequency theQueryObject,
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
