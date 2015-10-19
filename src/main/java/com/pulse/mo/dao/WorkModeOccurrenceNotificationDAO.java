
package com.pulse.mo.dao;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.percero.agents.sync.exceptions.SyncDataException;
import com.percero.util.DateUtils;
import com.pulse.dataprovider.IConnectionFactory;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.percero.agents.sync.dao.DAORegistry;
import com.percero.agents.sync.dao.IDataAccessObject;
import com.percero.agents.sync.exceptions.SyncException;

import com.pulse.mo.*;


@Component
public class WorkModeOccurrenceNotificationDAO extends SqlDataAccessProcObject<WorkModeOccurrenceNotification> implements IDataAccessObject<WorkModeOccurrenceNotification> {

	static final Logger log = Logger.getLogger(WorkModeOccurrenceNotificationDAO.class);

	
	public WorkModeOccurrenceNotificationDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(WorkModeOccurrenceNotification.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	
	public static final String SQL_VIEW = ",\"WORK_MODE_OCCURRENCE_NOTIF\".\"CREATED_ON\",\"WORK_MODE_OCCURRENCE_NOTIF\".\"LOGIN_COUNT\",\"WORK_MODE_OCCURRENCE_NOTIF\".\"LOGOUT_COUNT\",\"WORK_MODE_OCCURRENCE_NOTIF\".\"MESSAGE\",\"WORK_MODE_OCCURRENCE_NOTIF\".\"NAME\",\"WORK_MODE_OCCURRENCE_NOTIF\".\"TYPE\",\"WORK_MODE_OCCURRENCE_NOTIF\".\"AGENT_ID\",\"WORK_MODE_OCCURRENCE_NOTIF\".\"LOB_CONFIGURATION_ID\",\"WORK_MODE_OCCURRENCE_NOTIF\".\"TEAM_LEADER_ID\",\"WORK_MODE_OCCURRENCE_NOTIF\".\"LOB_CONFIGURATION_ENTRY_ID\"";
	private String selectFromStatementTableName = " FROM \"WORK_MODE_OCCURRENCE_NOTIF\" \"WORK_MODE_OCCURRENCE_NOTIF\"";
	private String whereClause = "  WHERE \"WORK_MODE_OCCURRENCE_NOTIF\".\"ID\"=?";
	private String whereInClause = "  join table(sys.dbms_debug_vc2coll(?)) SQLLIST on \"WORK_MODE_OCCURRENCE_NOTIF\".\"ID\"= SQLLIST.column_value";
	private String orderByTableName = "  ORDER BY \"WORK_MODE_OCCURRENCE_NOTIF\".\"ID\"";
	
	

	
	@Override
	protected String getConnectionFactoryName() {
		return WorkModeOccurrenceNotificationDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT \"WORK_MODE_OCCURRENCE_NOTIF\".\"ID\" " + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT \"WORK_MODE_OCCURRENCE_NOTIF\".\"ID\"" + SQL_VIEW  + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT \"WORK_MODE_OCCURRENCE_NOTIF\".\"ID\" " + selectFromStatementTableName +  orderByTableName;
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT \"WORK_MODE_OCCURRENCE_NOTIF\".\"ID\" " + selectFromStatementTableName  +  orderByTableName  + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT \"WORK_MODE_OCCURRENCE_NOTIF\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName  + orderByTableName;
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT \"WORK_MODE_OCCURRENCE_NOTIF\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + orderByTableName + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() 
	{
		return "SELECT COUNT(ID) " + selectFromStatementTableName;
	}
	
	@Override
	protected String getSelectInStarSQL() 
	{
		return "SELECT \"WORK_MODE_OCCURRENCE_NOTIF\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + whereInClause;
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT \"WORK_MODE_OCCURRENCE_NOTIF\".\"ID\" " + selectFromStatementTableName + whereInClause;
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		
		return "SELECT \"WORK_MODE_OCCURRENCE_NOTIF\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + " WHERE \"WORK_MODE_OCCURRENCE_NOTIF\"." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) 
	{
		
		return "SELECT \"WORK_MODE_OCCURRENCE_NOTIF\".\"ID\" " + selectFromStatementTableName + " WHERE \"WORK_MODE_OCCURRENCE_NOTIF\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT \"WORK_MODE_OCCURRENCE_NOTIF\".\"ID\" " + selectFromStatementTableName;
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT \"WORK_MODE_OCCURRENCE_NOTIF\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName;
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO TBL_WORK_MODE_OCCURRENCE_NOTIF (\"ID\",\"CREATED_ON\",\"LOGIN_COUNT\",\"LOGOUT_COUNT\",\"MESSAGE\",\"NAME\",\"TYPE\",\"AGENT_ID\",\"LOB_CONFIGURATION_ID\",\"TEAM_LEADER_ID\",\"LOB_CONFIGURATION_ENTRY_ID\") VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE TBL_WORK_MODE_OCCURRENCE_NOTIF SET \"CREATED_ON\"=?,\"LOGIN_COUNT\"=?,\"LOGOUT_COUNT\"=?,\"MESSAGE\"=?,\"NAME\"=?,\"TYPE\"=?,\"AGENT_ID\"=?,\"LOB_CONFIGURATION_ID\"=?,\"TEAM_LEADER_ID\"=?,\"LOB_CONFIGURATION_ENTRY_ID\"=? WHERE \"ID\"=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM TBL_WORK_MODE_OCCURRENCE_NOTIF WHERE \"ID\"=?";
	}
	
	@Override
	protected WorkModeOccurrenceNotification extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	WorkModeOccurrenceNotification nextResult = new WorkModeOccurrenceNotification();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setCreatedOn(rs.getDate("CREATED_ON"));

nextResult.setLoginCount(rs.getInt("LOGIN_COUNT"));

nextResult.setLogoutCount(rs.getInt("LOGOUT_COUNT"));

nextResult.setMessage(rs.getString("MESSAGE"));

nextResult.setName(rs.getString("NAME"));

nextResult.setType(rs.getString("TYPE"));

Agent agent = new Agent();
agent.setID(rs.getString("AGENT_ID"));
nextResult.setAgent(agent);

LOBConfiguration lobconfiguration = new LOBConfiguration();
lobconfiguration.setID(rs.getString("LOB_CONFIGURATION_ID"));
nextResult.setLOBConfiguration(lobconfiguration);

TeamLeader teamleader = new TeamLeader();
teamleader.setID(rs.getString("TEAM_LEADER_ID"));
nextResult.setTeamLeader(teamleader);

LOBConfigurationEntry lobconfigurationentry = new LOBConfigurationEntry();
lobconfigurationentry.setID(rs.getString("LOB_CONFIGURATION_ENTRY_ID"));
nextResult.setLOBConfigurationEntry(lobconfigurationentry);


			
    	}
    	
    	return nextResult;
	}
	
	protected void setBaseStatmentInsertParams(WorkModeOccurrenceNotification perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setDate(2, DateUtils.utilDateToSqlDate(perceroObject.getCreatedOn()));
JdbcHelper.setInt(pstmt,3, perceroObject.getLoginCount());
JdbcHelper.setInt(pstmt,4, perceroObject.getLogoutCount());
pstmt.setString(5, perceroObject.getMessage());
pstmt.setString(6, perceroObject.getName());
pstmt.setString(7, perceroObject.getType());

if (perceroObject.getAgent() == null)
{
pstmt.setString(8, null);
}
else
{
		pstmt.setString(8, perceroObject.getAgent().getID());
}


if (perceroObject.getLOBConfiguration() == null)
{
pstmt.setString(9, null);
}
else
{
		pstmt.setString(9, perceroObject.getLOBConfiguration().getID());
}


if (perceroObject.getTeamLeader() == null)
{
pstmt.setString(10, null);
}
else
{
		pstmt.setString(10, perceroObject.getTeamLeader().getID());
}


if (perceroObject.getLOBConfigurationEntry() == null)
{
pstmt.setString(11, null);
}
else
{
		pstmt.setString(11, perceroObject.getLOBConfigurationEntry().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(WorkModeOccurrenceNotification perceroObject, PreparedStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
		
	}
	
	@Override
	protected void setCallableStatmentInsertParams(WorkModeOccurrenceNotification perceroObject, CallableStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	

	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(WorkModeOccurrenceNotification perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setDate(1, DateUtils.utilDateToSqlDate(perceroObject.getCreatedOn()));
JdbcHelper.setInt(pstmt,2, perceroObject.getLoginCount());
JdbcHelper.setInt(pstmt,3, perceroObject.getLogoutCount());
pstmt.setString(4, perceroObject.getMessage());
pstmt.setString(5, perceroObject.getName());
pstmt.setString(6, perceroObject.getType());

if (perceroObject.getAgent() == null)
{
pstmt.setString(7, null);
}
else
{
		pstmt.setString(7, perceroObject.getAgent().getID());
}


if (perceroObject.getLOBConfiguration() == null)
{
pstmt.setString(8, null);
}
else
{
		pstmt.setString(8, perceroObject.getLOBConfiguration().getID());
}


if (perceroObject.getTeamLeader() == null)
{
pstmt.setString(9, null);
}
else
{
		pstmt.setString(9, perceroObject.getTeamLeader().getID());
}


if (perceroObject.getLOBConfigurationEntry() == null)
{
pstmt.setString(10, null);
}
else
{
		pstmt.setString(10, perceroObject.getLOBConfigurationEntry().getID());
}

pstmt.setString(11, perceroObject.getID());

		
	}
	
	
	@Override
	protected void setCallableStatmentUpdateParams(WorkModeOccurrenceNotification perceroObject, CallableStatement pstmt) throws SQLException 
	{
		
		//must be in same order as insert
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	}
	
	

	@Override
	public List<WorkModeOccurrenceNotification> findByExample(WorkModeOccurrenceNotification theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useCreatedOn = theQueryObject.getCreatedOn() != null && (excludeProperties == null || !excludeProperties.contains("createdOn"));

if (useCreatedOn)
{
sql += " WHERE ";
sql += " \"CREATED_ON\" =? ";
paramValues.add(theQueryObject.getCreatedOn());
propertyCounter++;
}

boolean useLoginCount = theQueryObject.getLoginCount() != null && (excludeProperties == null || !excludeProperties.contains("loginCount"));

if (useLoginCount)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"LOGIN_COUNT\" =? ";
paramValues.add(theQueryObject.getLoginCount());
propertyCounter++;
}

boolean useLogoutCount = theQueryObject.getLogoutCount() != null && (excludeProperties == null || !excludeProperties.contains("logoutCount"));

if (useLogoutCount)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"LOGOUT_COUNT\" =? ";
paramValues.add(theQueryObject.getLogoutCount());
propertyCounter++;
}

boolean useMessage = StringUtils.hasText(theQueryObject.getMessage()) && (excludeProperties == null || !excludeProperties.contains("message"));

if (useMessage)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"MESSAGE\" =? ";
paramValues.add(theQueryObject.getMessage());
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
sql += " \"NAME\" =? ";
paramValues.add(theQueryObject.getName());
propertyCounter++;
}

boolean useType = StringUtils.hasText(theQueryObject.getType()) && (excludeProperties == null || !excludeProperties.contains("type"));

if (useType)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"TYPE\" =? ";
paramValues.add(theQueryObject.getType());
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
sql += " \"AGENT_ID\" =? ";
paramValues.add(theQueryObject.getAgent().getID());
propertyCounter++;
}

boolean useLOBConfigurationID = theQueryObject.getLOBConfiguration() != null && (excludeProperties == null || !excludeProperties.contains("lOBConfiguration"));

if (useLOBConfigurationID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"LOB_CONFIGURATION_ID\" =? ";
paramValues.add(theQueryObject.getLOBConfiguration().getID());
propertyCounter++;
}

boolean useTeamLeaderID = theQueryObject.getTeamLeader() != null && (excludeProperties == null || !excludeProperties.contains("teamLeader"));

if (useTeamLeaderID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"TEAM_LEADER_ID\" =? ";
paramValues.add(theQueryObject.getTeamLeader().getID());
propertyCounter++;
}

boolean useLOBConfigurationEntryID = theQueryObject.getLOBConfigurationEntry() != null && (excludeProperties == null || !excludeProperties.contains("lOBConfigurationEntry"));

if (useLOBConfigurationEntryID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"LOB_CONFIGURATION_ENTRY_ID\" =? ";
paramValues.add(theQueryObject.getLOBConfigurationEntry().getID());
propertyCounter++;
}



		if (propertyCounter == 0) {
			throw new SyncException(SyncException.METHOD_UNSUPPORTED, SyncException.METHOD_UNSUPPORTED_CODE);
		}
		
		return executeSelectWithParams(sql, paramValues.toArray(), shellOnly);		
	}
	
	@Override
	protected String getUpdateCallableStatementSql() {
		return "{call UPDATE_WORK_MODE_OCCURRENCE_NOTIF(?,?,?,?,?,?,?,?,?,?,?)}";
	}
	@Override
	protected String getInsertCallableStatementSql() {
		return "{call CREATE_WORK_MODE_OCCURRENCE_NOTIF(?,?,?,?,?,?,?,?,?,?,?)}";
	}
	@Override
	protected String getDeleteCallableStatementSql() {
		return "{call Delete_WORK_MODE_OCCURRENCE_NOTIF(?)}";
	}
	
	
	
	
}
