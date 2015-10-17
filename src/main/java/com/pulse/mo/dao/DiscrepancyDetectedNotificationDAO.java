
package com.pulse.mo.dao;

import java.sql.PreparedStatement;
import java.sql.CallableStatement;
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
import com.pulse.mo.DiscrepancyDetectedNotification;
import com.pulse.mo.TimecardActivity;

*/

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
	
	public static final String SQL_VIEW = ",\"DISCREPANCY_DETECTED_NOTIF\".\"DATE\",\"DISCREPANCY_DETECTED_NOTIF\".\"AUX_CODE_ENTRY_NAME\",\"DISCREPANCY_DETECTED_NOTIF\".\"MESSAGE\",\"DISCREPANCY_DETECTED_NOTIF\".\"NAME\",\"DISCREPANCY_DETECTED_NOTIF\".\"TIMECARD_ACTIVITY_NAME\",\"DISCREPANCY_DETECTED_NOTIF\".\"TYPE\",\"DISCREPANCY_DETECTED_NOTIF\".\"AGENT_ID\",\"DISCREPANCY_DETECTED_NOTIF\".\"LOB_CONFIGURATION_ID\",\"DISCREPANCY_DETECTED_NOTIF\".\"TEAM_LEADER_ID\"";
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
		return "SELECT \"DISCREPANCY_DETECTED_NOTIF\".\"ID\" " + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT \"DISCREPANCY_DETECTED_NOTIF\".\"ID\"" + SQL_VIEW  + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT \"DISCREPANCY_DETECTED_NOTIF\".\"ID\" " + selectFromStatementTableName +  orderByTableName;
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT \"DISCREPANCY_DETECTED_NOTIF\".\"ID\" " + selectFromStatementTableName  +  orderByTableName  + " LIMIT ? OFFSET ?";
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
		return "SELECT \"DISCREPANCY_DETECTED_NOTIF\".\"ID\" " + selectFromStatementTableName + whereInClause;
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		
		return "SELECT \"DISCREPANCY_DETECTED_NOTIF\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + " WHERE \"DISCREPANCY_DETECTED_NOTIF\"." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) 
	{
		
		return "SELECT \"DISCREPANCY_DETECTED_NOTIF\".\"ID\" " + selectFromStatementTableName + " WHERE \"DISCREPANCY_DETECTED_NOTIF\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT \"DISCREPANCY_DETECTED_NOTIF\".\"ID\" " + selectFromStatementTableName;
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT \"DISCREPANCY_DETECTED_NOTIF\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName;
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO DISCREPANCY_DETECTED_NOTIF (\"ID\",\"DATE\",\"AUX_CODE_ENTRY_NAME\",\"MESSAGE\",\"NAME\",\"TIMECARD_ACTIVITY_NAME\",\"TYPE\",\"AGENT_ID\",\"LOB_CONFIGURATION_ID\",\"TEAM_LEADER_ID\") VALUES (?,?,?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE \"TBL_DISCREPANCY_DETECTED_NOTIF\" SET \"DATE\"=?,\"AUX_CODE_ENTRY_NAME\"=?,\"MESSAGE\"=?,\"NAME\"=?,\"TIMECARD_ACTIVITY_NAME\"=?,\"TYPE\"=?,\"AGENT_ID\"=?,\"LOB_CONFIGURATION_ID\"=?,\"TEAM_LEADER_ID\"=? WHERE \"ID\"=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM \"TBL_DISCREPANCY_DETECTED_NOTIF\" WHERE \"ID\"=?";
	}
	
	@Override
	protected DiscrepancyDetectedNotification extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	DiscrepancyDetectedNotification nextResult = new DiscrepancyDetectedNotification();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setDate(rs.getDate("DATE"));

nextResult.setAuxCodeEntryName(rs.getString("AUX_CODE_ENTRY_NAME"));

nextResult.setMessage(rs.getString("MESSAGE"));

nextResult.setName(rs.getString("NAME"));

nextResult.setTimecardActivityName(rs.getString("TIMECARD_ACTIVITY_NAME"));

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


			
    	}
    	
    	return nextResult;
	}
	
	protected void setBaseStatmentInsertParams(DiscrepancyDetectedNotification perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setDate(2, DateUtils.utilDateToSqlDate(perceroObject.getDate()));
pstmt.setString(3, perceroObject.getAuxCodeEntryName());
pstmt.setString(4, perceroObject.getMessage());
pstmt.setString(5, perceroObject.getName());
pstmt.setString(6, perceroObject.getTimecardActivityName());
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
		
		pstmt.setDate(1, DateUtils.utilDateToSqlDate(perceroObject.getDate()));
pstmt.setString(2, perceroObject.getAuxCodeEntryName());
pstmt.setString(3, perceroObject.getMessage());
pstmt.setString(4, perceroObject.getName());
pstmt.setString(5, perceroObject.getTimecardActivityName());
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

pstmt.setString(10, perceroObject.getID());

		
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
		
		boolean useDate = theQueryObject.getDate() != null && (excludeProperties == null || !excludeProperties.contains("date"));

if (useDate)
{
sql += " WHERE ";
sql += " \"DATE\" =? ";
paramValues.add(theQueryObject.getDate());
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

boolean useTimecardActivityName = StringUtils.hasText(theQueryObject.getTimecardActivityName()) && (excludeProperties == null || !excludeProperties.contains("timecardActivityName"));

if (useTimecardActivityName)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"TIMECARD_ACTIVITY_NAME\" =? ";
paramValues.add(theQueryObject.getTimecardActivityName());
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
	
	@Override
	protected String getUpdateCallableStatementSql() {
		return "{call UPDATE_DISCREPANCY_DETECTED_NOTIF(?,?,?,?,?,?,?,?,?,?)}";
	}
	@Override
	protected String getInsertCallableStatementSql() {
		return "{call CREATE_DISCREPANCY_DETECTED_NOTIF(?,?,?,?,?,?,?,?,?,?)}";
	}
	@Override
	protected String getDeleteCallableStatementSql() {
		return "{call Delete_DISCREPANCY_DETECTED_NOTIF(?)}";
	}
	
	
	
	
}
