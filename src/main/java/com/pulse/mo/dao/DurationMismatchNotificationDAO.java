

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
import com.percero.agents.sync.metadata.MappedClass;

import com.pulse.mo.*;


@Component
public class DurationMismatchNotificationDAO extends SqlDataAccessProcObject<DurationMismatchNotification> implements IDataAccessObject<DurationMismatchNotification> {

	static final Logger log = Logger.getLogger(DurationMismatchNotificationDAO.class);

	
	public DurationMismatchNotificationDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(DurationMismatchNotification.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	
	public static final String SQL_VIEW = ",\"DURATION_MISMATCH_NOTIF\".\"TYPE\",\"DURATION_MISMATCH_NOTIF\".\"CREATED_ON\",\"DURATION_MISMATCH_NOTIF\".\"END_TIME\",\"DURATION_MISMATCH_NOTIF\".\"DURATION\",\"DURATION_MISMATCH_NOTIF\".\"AUX_CODE_ENTRY_NAME\",\"DURATION_MISMATCH_NOTIF\".\"MESSAGE\",\"DURATION_MISMATCH_NOTIF\".\"NAME\",\"DURATION_MISMATCH_NOTIF\".\"AGENT_ID\",\"DURATION_MISMATCH_NOTIF\".\"LOB_CONFIGURATION_ID\",\"DURATION_MISMATCH_NOTIF\".\"TEAM_LEADER_ID\"";
	private String selectFromStatementTableName = " FROM \"DURATION_MISMATCH_NOTIF\" \"DURATION_MISMATCH_NOTIF\"";
	private String whereClause = "  WHERE \"DURATION_MISMATCH_NOTIF\".\"ID\"=?";
	private String whereInClause = "  join table(sys.dbms_debug_vc2coll(?)) SQLLIST on \"DURATION_MISMATCH_NOTIF\".\"ID\"= SQLLIST.column_value";
	private String orderByTableName = "  ORDER BY \"DURATION_MISMATCH_NOTIF\".\"ID\"";
	
	

	
	@Override
	protected String getConnectionFactoryName() {
		return DurationMismatchNotificationDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT \"DURATION_MISMATCH_NOTIF\".\"ID\" " + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT \"DURATION_MISMATCH_NOTIF\".\"ID\"" + SQL_VIEW  + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT \"DURATION_MISMATCH_NOTIF\".\"ID\" " + selectFromStatementTableName +  orderByTableName;
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT \"DURATION_MISMATCH_NOTIF\".\"ID\" " + selectFromStatementTableName  +  orderByTableName  + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT \"DURATION_MISMATCH_NOTIF\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName  + orderByTableName;
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT \"DURATION_MISMATCH_NOTIF\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + orderByTableName + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() 
	{
		return "SELECT COUNT(ID) " + selectFromStatementTableName;
	}
	
	@Override
	protected String getSelectInStarSQL() 
	{
		return "SELECT \"DURATION_MISMATCH_NOTIF\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + whereInClause;
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT \"DURATION_MISMATCH_NOTIF\".\"ID\" " + selectFromStatementTableName + whereInClause;
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		
		return "SELECT \"DURATION_MISMATCH_NOTIF\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + " WHERE \"DURATION_MISMATCH_NOTIF\"." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) 
	{
		
		return "SELECT \"DURATION_MISMATCH_NOTIF\".\"ID\" " + selectFromStatementTableName + " WHERE \"DURATION_MISMATCH_NOTIF\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT \"DURATION_MISMATCH_NOTIF\".\"ID\" " + selectFromStatementTableName;
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT \"DURATION_MISMATCH_NOTIF\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName;
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO TBL_DURATION_MISMATCH_NOTIF (\"ID\",\"TYPE\",\"CREATED_ON\",\"END_TIME\",\"DURATION\",\"AUX_CODE_ENTRY_NAME\",\"MESSAGE\",\"NAME\",\"AGENT_ID\",\"LOB_CONFIGURATION_ID\",\"TEAM_LEADER_ID\") VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE TBL_DURATION_MISMATCH_NOTIF SET \"TYPE\"=?,\"CREATED_ON\"=?,\"END_TIME\"=?,\"DURATION\"=?,\"AUX_CODE_ENTRY_NAME\"=?,\"MESSAGE\"=?,\"NAME\"=?,\"AGENT_ID\"=?,\"LOB_CONFIGURATION_ID\"=?,\"TEAM_LEADER_ID\"=? WHERE \"ID\"=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM TBL_DURATION_MISMATCH_NOTIF WHERE \"ID\"=?";
	}
	
	@Override
	protected DurationMismatchNotification extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {

		DurationMismatchNotification nextResult = null;
		String type = rs.getString("TYPE");
		String className = type;
		if (className.indexOf("com.pulse.mo.") != 0) {
			className = "com.pulse.mo." + className;
		}
		try {
			nextResult = (DurationMismatchNotification) MappedClass.forName(className).newInstance();
		} catch(Exception e) {
			// Do nothing.
		}


		if (nextResult == null) {
			nextResult = new DurationMismatchNotification();
		}


    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setType(rs.getString("TYPE"));

nextResult.setCreatedOn(rs.getDate("CREATED_ON"));

nextResult.setEndTime(rs.getDate("END_TIME"));

nextResult.setDuration(rs.getDouble("DURATION"));

nextResult.setAuxCodeEntryName(rs.getString("AUX_CODE_ENTRY_NAME"));

nextResult.setMessage(rs.getString("MESSAGE"));

nextResult.setName(rs.getString("NAME"));

Agent agent = new Agent();
agent.setID(rs.getString("AGENT_ID"));
nextResult.setAgent(agent);

LOBConfiguration lobconfiguration = new LOBConfiguration();
lobconfiguration.setID(rs.getString("LOB_CONFIGURATION_ID"));
nextResult.setLOBConfiguration(lobconfiguration);

TeamLeader teamleader = new TeamLeader();
teamleader.setID(rs.getString("TEAM_LEADER_ID"));
nextResult.setTeamLeader(teamleader);


			
    	}
    	
    	return nextResult;
	}
	
	protected void setBaseStatmentInsertParams(DurationMismatchNotification perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getType());
pstmt.setDate(3, DateUtils.utilDateToSqlDate(perceroObject.getCreatedOn()));
pstmt.setDate(4, DateUtils.utilDateToSqlDate(perceroObject.getEndTime()));
JdbcHelper.setDouble(pstmt,5, perceroObject.getDuration());
pstmt.setString(6, perceroObject.getAuxCodeEntryName());
pstmt.setString(7, perceroObject.getMessage());
pstmt.setString(8, perceroObject.getName());

if (perceroObject.getAgent() == null)
{
pstmt.setString(9, null);
}
else
{
		pstmt.setString(9, perceroObject.getAgent().getID());
}


if (perceroObject.getLOBConfiguration() == null)
{
pstmt.setString(10, null);
}
else
{
		pstmt.setString(10, perceroObject.getLOBConfiguration().getID());
}


if (perceroObject.getTeamLeader() == null)
{
pstmt.setString(11, null);
}
else
{
		pstmt.setString(11, perceroObject.getTeamLeader().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(DurationMismatchNotification perceroObject, PreparedStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
		
	}
	
	@Override
	protected void setCallableStatmentInsertParams(DurationMismatchNotification perceroObject, CallableStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	

	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(DurationMismatchNotification perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getType());
pstmt.setDate(2, DateUtils.utilDateToSqlDate(perceroObject.getCreatedOn()));
pstmt.setDate(3, DateUtils.utilDateToSqlDate(perceroObject.getEndTime()));
JdbcHelper.setDouble(pstmt,4, perceroObject.getDuration());
pstmt.setString(5, perceroObject.getAuxCodeEntryName());
pstmt.setString(6, perceroObject.getMessage());
pstmt.setString(7, perceroObject.getName());

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

pstmt.setString(11, perceroObject.getID());

		
	}
	
	
	@Override
	protected void setCallableStatmentUpdateParams(DurationMismatchNotification perceroObject, CallableStatement pstmt) throws SQLException 
	{
		
		//must be in same order as insert
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	}
	
	

	@Override
	public List<DurationMismatchNotification> findByExample(DurationMismatchNotification theQueryObject,
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

boolean useEndTime = theQueryObject.getEndTime() != null && (excludeProperties == null || !excludeProperties.contains("endTime"));

if (useEndTime)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"END_TIME\" =? ";
paramValues.add(theQueryObject.getEndTime());
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
sql += " \"DURATION\" =? ";
paramValues.add(theQueryObject.getDuration());
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



		if (propertyCounter == 0) {
			throw new SyncException(SyncException.METHOD_UNSUPPORTED, SyncException.METHOD_UNSUPPORTED_CODE);
		}
		
		return executeSelectWithParams(sql, paramValues.toArray(), shellOnly);		
	}
	
	@Override
	protected String getUpdateCallableStatementSql() {
		return "{call UPDATE_DURATION_MISMATCH_NOTIF(?,?,?,?,?,?,?,?,?,?,?)}";
	}
	@Override
	protected String getInsertCallableStatementSql() {
		return "{call CREATE_DURATION_MISMATCH_NOTIF(?,?,?,?,?,?,?,?,?,?,?)}";
	}
	@Override
	protected String getDeleteCallableStatementSql() {
		return "{call Delete_DURATION_MISMATCH_NOTIF(?)}";
	}
	
	
	
	
}

