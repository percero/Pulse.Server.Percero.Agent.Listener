

package com.pulse.mo.dao;

import com.percero.agents.sync.dao.DAORegistry;
import com.percero.agents.sync.dao.IDataAccessObject;
import com.percero.agents.sync.exceptions.SyncException;
import com.pulse.mo.Agent;
import com.pulse.mo.TimecardEntry;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
import com.pulse.mo.TimecardEntry;
import com.pulse.mo.Agent;
import com.pulse.mo.Timecard;
import com.pulse.mo.TimecardActivity;

*/

@Component
public class TimecardEntryDAO extends SqlDataAccessObject<TimecardEntry> implements IDataAccessObject<TimecardEntry> {

	static final Logger log = Logger.getLogger(TimecardEntryDAO.class);

	
	public TimecardEntryDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(TimecardEntry.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "estart";
	
	//TODO:For use refactoring, so we set it once
	public static final String SQL_VIEW = "SELECT  \"TIMECARD_ENTRY\".\"ID\" as \"ID\", \"TIMECARD_ENTRY\".\"ON_TIME\" as \"FROM_TIME\", '' as \"NOTIFICATION_RESOLVED\", \"TIMECARD_ENTRY\".\"OFF_TIME\" as \"TO_TIME\", \"TIMECARD_ENTRY\".\"CENTRE\" as \"ESTART_PROJECT_NAME\", \"TIMECARD_ENTRY\".\"MINUTES\" as \"DURATION\", '' as \"ACTION_NAME\", \"TIMECARD_ENTRY\".\"POS\" as \"ACTIVITY_NAME\", '' as \"NOTIFICATION_DETECTED\", \"TIMECARD_ENTRY\".\"CODE\" as \"ACTION_CODE\", \"TIMECARD_ENTRY\".\"PAYROLL\" as \"AGENT_ID\", '' as \"TIMECARD_ACTIVITY_ID\", \"TIMECARD_ENTRY\".\"WORKED_ID\" as \"TIMECARD_ID\" FROM \"AGENT_TIME_ENTRY_VW\" \"TIMECARD_ENTRY\" ";
	
	@Override
	protected String getConnectionFactoryName() {
		return TimecardEntryDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT \"TIMECARD_ENTRY\".\"ID\" as \"ID\" FROM \"CONVERGYS\".\"AGENT_TIME_ENTRY_VW\" \"TIMECARD_ENTRY\" WHERE \"TIMECARD_ENTRY\".\"ID\"=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return SQL_VIEW + " where \"TIMECARD_ENTRY\".ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT \"TIMECARD_ENTRY\".\"ID\" as \"ID\" FROM \"CONVERGYS\".\"AGENT_TIME_ENTRY_VW\" \"TIMECARD_ENTRY\" ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT \"TIMECARD_ENTRY\".\"ID\" as \"ID\" FROM \"CONVERGYS\".\"AGENT_TIME_ENTRY_VW\" \"TIMECARD_ENTRY\" ORDER BY \"TIMECARD_ENTRY\".ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return SQL_VIEW + " ORDER BY \"TIMECARD_ENTRY\".ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return SQL_VIEW + " ORDER BY \"TIMECARD_ENTRY\".ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM \"CONVERGYS\".\"AGENT_TIME_ENTRY_VW\" \"TIMECARD_ENTRY\"";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return SQL_VIEW + " where \"TIMECARD_ENTRY\".ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT \"TIMECARD_ENTRY\".\"ID\" as \"ID\" FROM \"CONVERGYS\".\"AGENT_TIME_ENTRY_VW\" \"TIMECARD_ENTRY\" WHERE \"TIMECARD_ENTRY\".ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return SQL_VIEW + "  \"TIMECARD_ENTRY\"." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT \"TIMECARD_ENTRY\".\"ID\" as \"ID\" FROM \"CONVERGYS\".\"AGENT_TIME_ENTRY_VW\" \"TIMECARD_ENTRY\" WHERE \"TIMECARD_ENTRY\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT \"TIMECARD_ENTRY\".\"ID\" as \"ID\" FROM \"CONVERGYS\".\"AGENT_TIME_ENTRY_VW\" \"TIMECARD_ENTRY\" ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return SQL_VIEW;
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "";//"INSERT INTO TIMECARD_ENTRY (ID) VALUES (?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "";//"UPDATE TIMECARD_ENTRY SET  WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() 
	{
		return "";//"DELETE FROM TIMECARD_ENTRY WHERE ID=?";
	}
	
	@Override
	protected TimecardEntry extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	TimecardEntry nextResult = new TimecardEntry();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setNotificationDetected(rs.getBoolean("NOTIFICATION_DETECTED"));

nextResult.setNotificationResolved(rs.getBoolean("NOTIFICATION_RESOLVED"));

nextResult.setActionCode(rs.getString("ACTION_CODE"));

nextResult.setActionName(rs.getString("ACTION_NAME"));

nextResult.setActivityName(rs.getString("ACTIVITY_NAME"));

nextResult.setDuration(rs.getInt("DURATION"));

nextResult.setEStartProjectName(rs.getString("ESTART_PROJECT_NAME"));

nextResult.setFromTime(rs.getDate("FROM_TIME"));

nextResult.setToTime(rs.getDate("TO_TIME"));

Agent agent = new Agent();
agent.setID(rs.getString("AGENT_ID"));
nextResult.setAgent(agent);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(TimecardEntry perceroObject, PreparedStatement pstmt) throws SQLException {
		
		
		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(TimecardEntry perceroObject, PreparedStatement pstmt) throws SQLException {
		
	
		
	}

	@Override
	public List<TimecardEntry> findByExample(TimecardEntry theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useNotificationDetected = theQueryObject.getNotificationDetected() != null && (excludeProperties == null || !excludeProperties.contains("notificationDetected"));

if (useNotificationDetected)
{
sql += " WHERE ";
sql += " NOTIFICATION_DETECTED=? ";
paramValues.add(theQueryObject.getNotificationDetected());
propertyCounter++;
}

boolean useNotificationResolved = theQueryObject.getNotificationResolved() != null && (excludeProperties == null || !excludeProperties.contains("notificationResolved"));

if (useNotificationResolved)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " NOTIFICATION_RESOLVED=? ";
paramValues.add(theQueryObject.getNotificationResolved());
propertyCounter++;
}

boolean useActionCode = StringUtils.hasText(theQueryObject.getActionCode()) && (excludeProperties == null || !excludeProperties.contains("actionCode"));

if (useActionCode)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " ACTION_CODE=? ";
paramValues.add(theQueryObject.getActionCode());
propertyCounter++;
}

boolean useActionName = StringUtils.hasText(theQueryObject.getActionName()) && (excludeProperties == null || !excludeProperties.contains("actionName"));

if (useActionName)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " ACTION_NAME=? ";
paramValues.add(theQueryObject.getActionName());
propertyCounter++;
}

boolean useActivityName = StringUtils.hasText(theQueryObject.getActivityName()) && (excludeProperties == null || !excludeProperties.contains("activityName"));

if (useActivityName)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " ACTIVITY_NAME=? ";
paramValues.add(theQueryObject.getActivityName());
propertyCounter++;
}

boolean useDuration = theQueryObject.getDuration() != null && (excludeProperties == null || !excludeProperties.contains("duration"));

if (useDuration)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " DURATION=? ";
paramValues.add(theQueryObject.getDuration());
propertyCounter++;
}

boolean useEStartProjectName = StringUtils.hasText(theQueryObject.getEStartProjectName()) && (excludeProperties == null || !excludeProperties.contains("eStartProjectName"));

if (useEStartProjectName)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " ESTART_PROJECT_NAME=? ";
paramValues.add(theQueryObject.getEStartProjectName());
propertyCounter++;
}

boolean useFromTime = theQueryObject.getFromTime() != null && (excludeProperties == null || !excludeProperties.contains("fromTime"));

if (useFromTime)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " FROM_TIME=? ";
paramValues.add(theQueryObject.getFromTime());
propertyCounter++;
}

boolean useToTime = theQueryObject.getToTime() != null && (excludeProperties == null || !excludeProperties.contains("toTime"));

if (useToTime)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " TO_TIME=? ";
paramValues.add(theQueryObject.getToTime());
propertyCounter++;
}

boolean useAgentID = theQueryObject.getAgent() != null && (excludeProperties == null || !excludeProperties.contains("agent"));

if (useAgentID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " AGENT_ID=? ";
paramValues.add(theQueryObject.getAgent().getID());
propertyCounter++;
}


		
		
		return executeSelectWithParams(sql, paramValues.toArray(), shellOnly);		
	}
	
}

