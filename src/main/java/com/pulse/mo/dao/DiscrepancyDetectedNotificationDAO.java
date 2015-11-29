

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
import com.percero.agents.sync.metadata.MappedClass;
import com.percero.agents.sync.dao.DAORegistry;
import com.percero.agents.sync.dao.IDataAccessObject;
import com.percero.agents.sync.exceptions.SyncException;
import com.percero.agents.sync.vo.BaseDataObject;
import java.sql.Connection;
import java.sql.Statement;
import com.pulse.dataprovider.IConnectionFactory;
import com.percero.agents.sync.exceptions.SyncDataException;
import com.pulse.mo.*;

@Component
public class DiscrepancyDetectedNotificationDAO extends SqlDataAccessProcObject<DiscrepancyDetectedNotification> implements IDataAccessObject<DiscrepancyDetectedNotification> {

	static final Logger log = Logger.getLogger(DiscrepancyDetectedNotificationDAO.class);

	
	public DiscrepancyDetectedNotificationDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(DiscrepancyDetectedNotification.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	
	public static final String SHELL_ONLY_SELECT = "\"DISCREPANCY_DETECTED_NOTIF\".\"ID\",\"DISCREPANCY_DETECTED_NOTIF\".\"TYPE\"";
	public static final String SQL_VIEW = ",\"DISCREPANCY_DETECTED_NOTIF\".\"TYPE\",\"DISCREPANCY_DETECTED_NOTIF\".\"CREATED_ON\",\"DISCREPANCY_DETECTED_NOTIF\".\"AUX_CODE_ENTRY_NAME\",\"DISCREPANCY_DETECTED_NOTIF\".\"MESSAGE\",\"DISCREPANCY_DETECTED_NOTIF\".\"NAME\",\"DISCREPANCY_DETECTED_NOTIF\".\"AGENT_ID\",\"DISCREPANCY_DETECTED_NOTIF\".\"LOB_CONFIGURATION_ID\",\"DISCREPANCY_DETECTED_NOTIF\".\"TEAM_LEADER_ID\",\"DISCREPANCY_DETECTED_NOTIF\".\"TIMECARD_ACTIVITY_ID\"";
	private String selectFromStatementTableName = " FROM \"DISCREPANCY_DETECTED_NOTIF\" \"DISCREPANCY_DETECTED_NOTIF\"";
	private String whereClause = "  WHERE \"DISCREPANCY_DETECTED_NOTIF\".\"ID\"=?";
	private String whereInClause = "  join table(sys.dbms_debug_vc2coll(?)) SQLLIST on \"DISCREPANCY_DETECTED_NOTIF\".\"ID\"= SQLLIST.column_value";
	private String orderByTableName = "  ORDER BY \"DISCREPANCY_DETECTED_NOTIF\".\"ID\"";
	
	

	
	@Override
	protected String getConnectionFactoryName() {
		return DiscrepancyDetectedNotificationDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT " + SHELL_ONLY_SELECT +  " " + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT \"DISCREPANCY_DETECTED_NOTIF\".\"ID\"" + SQL_VIEW  + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName +  orderByTableName;
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName  +  orderByTableName  + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT \"DISCREPANCY_DETECTED_NOTIF\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName  + orderByTableName;
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT \"DISCREPANCY_DETECTED_NOTIF\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + orderByTableName + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() 
	{
		return "SELECT COUNT(ID) " + selectFromStatementTableName;
	}
	
	@Override
	protected String getSelectInStarSQL() 
	{
		return "SELECT \"DISCREPANCY_DETECTED_NOTIF\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + whereInClause;
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName + whereInClause;
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		
		return "SELECT \"DISCREPANCY_DETECTED_NOTIF\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + " WHERE \"DISCREPANCY_DETECTED_NOTIF\"." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) 
	{
		
		return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName + " WHERE \"DISCREPANCY_DETECTED_NOTIF\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName;
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT \"DISCREPANCY_DETECTED_NOTIF\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName;
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO TBL_DISCREPANCY_DETECTED_NOTIF (\"ID\",\"TYPE\",\"CREATED_ON\",\"AUX_CODE_ENTRY_NAME\",\"MESSAGE\",\"NAME\",\"AGENT_ID\",\"LOB_CONFIGURATION_ID\",\"TEAM_LEADER_ID\",\"TIMECARD_ACTIVITY_ID\") VALUES (?,?,?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE TBL_DISCREPANCY_DETECTED_NOTIF SET \"TYPE\"=?,\"CREATED_ON\"=?,\"AUX_CODE_ENTRY_NAME\"=?,\"MESSAGE\"=?,\"NAME\"=?,\"AGENT_ID\"=?,\"LOB_CONFIGURATION_ID\"=?,\"TEAM_LEADER_ID\"=?,\"TIMECARD_ACTIVITY_ID\"=? WHERE \"ID\"=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM TBL_DISCREPANCY_DETECTED_NOTIF WHERE \"ID\"=?";
	}
	
	@Override
	protected DiscrepancyDetectedNotification extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	
		

DiscrepancyDetectedNotification nextResult = null;
    	
		String type = rs.getString("TYPE");
		
    	String className = type;
		
    	if (className.indexOf("com.pulse.mo.") != 0) {
    		className = "com.pulse.mo." + className;
    	}
    	try {
    		nextResult = (DiscrepancyDetectedNotification) MappedClass.forName(className).newInstance();
    	} catch(Exception e) {
    		// Do nothing.
    	}
    	
    	if (nextResult == null) {
    		nextResult = new DiscrepancyDetectedNotification();
    	}

		
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setType(rs.getString("TYPE"));


nextResult.setCreatedOn(DateUtils.utilDateFromSqlTimestamp(rs.getTimestamp("CREATED_ON")));


nextResult.setAuxCodeEntryName(rs.getString("AUX_CODE_ENTRY_NAME"));


nextResult.setMessage(rs.getString("MESSAGE"));


nextResult.setName(rs.getString("NAME"));


String agentID = rs.getString("AGENT_ID");
if (StringUtils.hasText(agentID) && !"null".equalsIgnoreCase(agentID) ){
Agent agent = new Agent();
agent.setID(agentID);
nextResult.setAgent(agent);
}


String lobconfigurationID = rs.getString("LOB_CONFIGURATION_ID");
if (StringUtils.hasText(lobconfigurationID) && !"null".equalsIgnoreCase(lobconfigurationID) ){
LOBConfiguration lobconfiguration = new LOBConfiguration();
lobconfiguration.setID(lobconfigurationID);
nextResult.setLOBConfiguration(lobconfiguration);
}


String teamleaderID = rs.getString("TEAM_LEADER_ID");
if (StringUtils.hasText(teamleaderID) && !"null".equalsIgnoreCase(teamleaderID) ){
TeamLeader teamleader = new TeamLeader();
teamleader.setID(teamleaderID);
nextResult.setTeamLeader(teamleader);
}


String timecardactivityID = rs.getString("TIMECARD_ACTIVITY_ID");
if (StringUtils.hasText(timecardactivityID) && !"null".equalsIgnoreCase(timecardactivityID) ){
TimecardActivity timecardactivity = new TimecardActivity();
timecardactivity.setID(timecardactivityID);
nextResult.setTimecardActivity(timecardactivity);
}



			
    	}
		
		
    	return nextResult;
	}
	
	protected void setBaseStatmentInsertParams(DiscrepancyDetectedNotification perceroObject, PreparedStatement pstmt) throws SQLException {

		pstmt.setString(1, perceroObject.getID());
		pstmt.setString(2, perceroObject.getType());
		pstmt.setDate(3, DateUtils.utilDateToSqlDate(perceroObject.getCreatedOn()));
		pstmt.setString(4, perceroObject.getName());

		if (perceroObject.getTeamLeader() == null)
		{
			pstmt.setString(5, null);
		}
		else
		{
			pstmt.setString(5, perceroObject.getTeamLeader().getID());
		}
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(DiscrepancyDetectedNotification perceroObject, PreparedStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
		
	}
	
	@Override
	protected void setCallableStatmentInsertParams(DiscrepancyDetectedNotification perceroObject, CallableStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	

	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(DiscrepancyDetectedNotification perceroObject, PreparedStatement pstmt) throws SQLException {

		pstmt.setString(1, perceroObject.getID());
		pstmt.setString(2, perceroObject.getType());
		pstmt.setDate(3, DateUtils.utilDateToSqlDate(perceroObject.getCreatedOn()));
		pstmt.setString(4, perceroObject.getName());

		if (perceroObject.getTeamLeader() == null)
		{
			pstmt.setString(5, null);
		}
		else
		{
			pstmt.setString(5, perceroObject.getTeamLeader().getID());
		}
	}
	
	
	@Override
	protected void setCallableStatmentUpdateParams(DiscrepancyDetectedNotification perceroObject, CallableStatement pstmt) throws SQLException 
	{
		
		//must be in same order as insert
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	}
	
	

	@Override
	public List<DiscrepancyDetectedNotification> findByExample(DiscrepancyDetectedNotification theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useType = StringUtils.hasText(theQueryObject.getType()) && (excludeProperties == null || !excludeProperties.contains("type"));

if (useType)
{
sql += " WHERE ";
sql += " \"TYPE\" =? ";
paramValues.add(theQueryObject.getType());
propertyCounter++;
}

boolean useCreatedOn = theQueryObject.getCreatedOn() != null && (excludeProperties == null || !excludeProperties.contains("createdOn"));

if (useCreatedOn)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"CREATED_ON\" =? ";
paramValues.add(theQueryObject.getCreatedOn());
propertyCounter++;
}

boolean useAuxCodeEntryName = StringUtils.hasText(theQueryObject.getAuxCodeEntryName()) && (excludeProperties == null || !excludeProperties.contains("auxCodeEntryName"));

if (useAuxCodeEntryName)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"AUX_CODE_ENTRY_NAME\" =? ";
paramValues.add(theQueryObject.getAuxCodeEntryName());
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

boolean useTimecardActivityID = theQueryObject.getTimecardActivity() != null && (excludeProperties == null || !excludeProperties.contains("timecardActivity"));

if (useTimecardActivityID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"TIMECARD_ACTIVITY_ID\" =? ";
paramValues.add(theQueryObject.getTimecardActivity().getID());
propertyCounter++;
}



		if (propertyCounter == 0) {
			throw new SyncException(SyncException.METHOD_UNSUPPORTED, SyncException.METHOD_UNSUPPORTED_CODE);
		}
		
		return executeSelectWithParams(sql, paramValues.toArray(), shellOnly);		
	}
	
	@Override
	protected String getUpdateCallableStatementSql() {
		return "{call UPDATE_DISCREPANCY_DETECT_NOTI(?,?,?,?,?)}";
	}
	@Override
	protected String getInsertCallableStatementSql() {
		return "{call CREATE_DISCREPANCY_DETECT_NOTI(?,?,?,?,?)}";
	}
	@Override
	protected String getDeleteCallableStatementSql() {
		return "{call Delete_DISCREPANCY_DETECT_NOTI(?)}";
	}
	
	
	
	
}

