
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
import com.pulse.mo.ScheduledActivityType;
import com.pulse.mo.ScheduledTimeEntry;

*/

@Component
public class ScheduledActivityTypeDAO extends SqlDataAccessObject<ScheduledActivityType> implements IDataAccessObject<ScheduledActivityType> {

	static final Logger log = Logger.getLogger(ScheduledActivityTypeDAO.class);

	
	public ScheduledActivityTypeDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(ScheduledActivityType.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	
	
	
	@Override
	protected String getConnectionFactoryName() {
		return ScheduledActivityTypeDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT \"SCHEDULED_ACTIVITY_TYPE\".\"ID\" FROM \"SCHEDULED_ACTIVITY_TYPE\" \"SCHEDULED_ACTIVITY_TYPE\" WHERE \"SCHEDULED_ACTIVITY_TYPE\".\"ID\"=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT \"SCHEDULED_ACTIVITY_TYPE\".\"ID\",\"SCHEDULED_ACTIVITY_TYPE\".\"NAME\" FROM \"SCHEDULED_ACTIVITY_TYPE\" \"SCHEDULED_ACTIVITY_TYPE\" WHERE \"SCHEDULED_ACTIVITY_TYPE\".\"ID\"=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT \"SCHEDULED_ACTIVITY_TYPE\".\"ID\" FROM \"SCHEDULED_ACTIVITY_TYPE\" \"SCHEDULED_ACTIVITY_TYPE\" ORDER BY \"ID\"";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT \"SCHEDULED_ACTIVITY_TYPE\".\"ID\" FROM \"SCHEDULED_ACTIVITY_TYPE\" \"SCHEDULED_ACTIVITY_TYPE\" ORDER BY \"SCHEDULED_ACTIVITY_TYPE\".\"ID\" LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT \"SCHEDULED_ACTIVITY_TYPE\".\"ID\",\"SCHEDULED_ACTIVITY_TYPE\".\"NAME\" FROM \"SCHEDULED_ACTIVITY_TYPE\" \"SCHEDULED_ACTIVITY_TYPE\" ORDER BY \"SCHEDULED_ACTIVITY_TYPE\".\"ID\"";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT \"SCHEDULED_ACTIVITY_TYPE\".\"ID\",\"SCHEDULED_ACTIVITY_TYPE\".\"NAME\" FROM \"SCHEDULED_ACTIVITY_TYPE\" \"SCHEDULED_ACTIVITY_TYPE\" ORDER BY \"SCHEDULED_ACTIVITY_TYPE\".\"ID\" LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM \"SCHEDULED_ACTIVITY_TYPE\" \"SCHEDULED_ACTIVITY_TYPE\"";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT \"SCHEDULED_ACTIVITY_TYPE\".\"ID\",\"SCHEDULED_ACTIVITY_TYPE\".\"NAME\" FROM \"SCHEDULED_ACTIVITY_TYPE\" \"SCHEDULED_ACTIVITY_TYPE\" WHERE \"SCHEDULED_ACTIVITY_TYPE\".\"ID\" IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT \"SCHEDULED_ACTIVITY_TYPE\".\"ID\" FROM \"SCHEDULED_ACTIVITY_TYPE\" \"SCHEDULED_ACTIVITY_TYPE\" WHERE \"SCHEDULED_ACTIVITY_TYPE\".\"ID\" IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		return "SELECT \"SCHEDULED_ACTIVITY_TYPE\".\"ID\",\"SCHEDULED_ACTIVITY_TYPE\".\"NAME\" FROM \"SCHEDULED_ACTIVITY_TYPE\" \"SCHEDULED_ACTIVITY_TYPE\" WHERE \"SCHEDULED_ACTIVITY_TYPE\"." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT \"SCHEDULED_ACTIVITY_TYPE\".\"ID\" FROM \"SCHEDULED_ACTIVITY_TYPE\" \"SCHEDULED_ACTIVITY_TYPE\" WHERE \"SCHEDULED_ACTIVITY_TYPE\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT \"SCHEDULED_ACTIVITY_TYPE\".\"ID\" FROM \"SCHEDULED_ACTIVITY_TYPE\" \"SCHEDULED_ACTIVITY_TYPE\" ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT \"SCHEDULED_ACTIVITY_TYPE\".\"ID\",\"SCHEDULED_ACTIVITY_TYPE\".\"NAME\" FROM \"SCHEDULED_ACTIVITY_TYPE\" \"SCHEDULED_ACTIVITY_TYPE\" ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO SCHEDULED_ACTIVITY_TYPE (\"ID\",\"NAME\") VALUES (?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE \"SCHEDULED_ACTIVITY_TYPE\" SET \"NAME\"=? WHERE \"ID\"=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM \"SCHEDULED_ACTIVITY_TYPE\" WHERE \"ID\"=?";
	}
	
	@Override
	protected ScheduledActivityType extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	ScheduledActivityType nextResult = new ScheduledActivityType();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setName(rs.getString("NAME"));


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(ScheduledActivityType perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getName());

		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(ScheduledActivityType perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getName());
pstmt.setString(2, perceroObject.getID());

		
	}

	@Override
	public List<ScheduledActivityType> findByExample(ScheduledActivityType theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useName = StringUtils.hasText(theQueryObject.getName()) && (excludeProperties == null || !excludeProperties.contains("name"));

if (useName)
{
sql += " WHERE ";
sql += " \"NAME\" =? ";
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
