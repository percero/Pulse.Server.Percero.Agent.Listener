

package com.pulse.mo.dao;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
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
public class DevelopmentActivityDAO extends SqlDataAccessObject<DevelopmentActivity> implements IDataAccessObject<DevelopmentActivity> {

	static final Logger log = Logger.getLogger(DevelopmentActivityDAO.class);

	
	public DevelopmentActivityDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(DevelopmentActivity.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	
	public static final String SHELL_ONLY_SELECT = "\"DEVELOPMENT_ACTIVITY\".\"ID\"";
	public static final String SQL_VIEW = ",\"DEVELOPMENT_ACTIVITY\".\"CREATED_BY\",\"DEVELOPMENT_ACTIVITY\".\"TYPE\",\"DEVELOPMENT_ACTIVITY\".\"UPDATED_BY\",\"DEVELOPMENT_ACTIVITY\".\"WEEK_DATE\",\"DEVELOPMENT_ACTIVITY\".\"COMPLETED_ON\",\"DEVELOPMENT_ACTIVITY\".\"CREATED_ON\",\"DEVELOPMENT_ACTIVITY\".\"DUE_DATE\",\"DEVELOPMENT_ACTIVITY\".\"UPDATED_ON\",\"DEVELOPMENT_ACTIVITY\".\"NAME\",\"DEVELOPMENT_ACTIVITY\".\"PLAN_ID\",\"DEVELOPMENT_ACTIVITY\".\"STATUS\",\"DEVELOPMENT_ACTIVITY\".\"TEAM_LEADER_ID\",\"DEVELOPMENT_ACTIVITY\".\"AGENT_ID\",\"DEVELOPMENT_ACTIVITY\".\"DEVELOPMENT_PLAN_ID\"";
	private String selectFromStatementTableName = " FROM \"DEVELOPMENT_ACTIVITY\" \"DEVELOPMENT_ACTIVITY\"";
	private String whereClause = "  WHERE \"DEVELOPMENT_ACTIVITY\".\"ID\"=?";
	private String whereInClause = "  join table(sys.dbms_debug_vc2coll(?)) SQLLIST on \"DEVELOPMENT_ACTIVITY\".\"ID\"= SQLLIST.column_value";
	private String orderByTableName = "  ORDER BY \"DEVELOPMENT_ACTIVITY\".\"ID\"";
	
	

	
	@Override
	protected String getConnectionFactoryName() {
		return DevelopmentActivityDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT " + SHELL_ONLY_SELECT +  " " + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT \"DEVELOPMENT_ACTIVITY\".\"ID\"" + SQL_VIEW  + selectFromStatementTableName + whereClause;
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
		return "SELECT \"DEVELOPMENT_ACTIVITY\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName  + orderByTableName;
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT \"DEVELOPMENT_ACTIVITY\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + orderByTableName + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() 
	{
		return "SELECT COUNT(ID) " + selectFromStatementTableName;
	}
	
	@Override
	protected String getSelectInStarSQL() 
	{
		return "SELECT \"DEVELOPMENT_ACTIVITY\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + whereInClause;
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName + whereInClause;
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		
		return "SELECT \"DEVELOPMENT_ACTIVITY\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + " WHERE \"DEVELOPMENT_ACTIVITY\"." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) 
	{
		
		return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName + " WHERE \"DEVELOPMENT_ACTIVITY\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName;
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT \"DEVELOPMENT_ACTIVITY\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName;
	}

	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO EFC_TASK (\"PLAN_ID\",  \"TASK_DESC\",  \"ASSIGNED_TO\", \"DUE_DATE\",  \"STATUS\",\"CREATED_BY\", \"UPDATED_BY\",\"CREATED_ON\",\"UPDATED_ON\", \"WK_DATE\", \"TASK_ID\", \"TYPE\") VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
	}

	@Override
	protected String getUpdateSet() {
		return "UPDATE \"EFC_TASK\" SET \"CREATED_BY\"=?,\"TYPE\"=?,\"UPDATED_BY\"=?,\"WEEK_DATE\"=?,\"COMPLETED_ON\"=?,\"CREATED_ON\"=?,\"DUE_DATE\"=?,\"UPDATED_ON\"=?,\"NAME\"=?,\"PLAN_ID\"=?,\"STATUS\"=?,\"TEAM_LEADER_ID\"=?,\"AGENT_ID\"=?,\"DEVELOPMENT_PLAN_ID\"=? WHERE \"ID\"=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM TBL_DEVELOPMENT_ACTIVITY WHERE \"ID\"=?";
	}
	
	@Override
	protected DevelopmentActivity extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	
		

DevelopmentActivity nextResult = null;
    	
		    	
    	if (nextResult == null) {
    		nextResult = new DevelopmentActivity();
    	}

		
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setCreatedBy(rs.getString("CREATED_BY"));


nextResult.setType(rs.getString("TYPE"));


nextResult.setUpdatedBy(rs.getString("UPDATED_BY"));


nextResult.setWeekDate(DateUtils.utilDateFromSqlTimestamp(rs.getTimestamp("WEEK_DATE")));


nextResult.setCompletedOn(DateUtils.utilDateFromSqlTimestamp(rs.getTimestamp("COMPLETED_ON")));


nextResult.setCreatedOn(DateUtils.utilDateFromSqlTimestamp(rs.getTimestamp("CREATED_ON")));


nextResult.setDueDate(DateUtils.utilDateFromSqlTimestamp(rs.getTimestamp("DUE_DATE")));


nextResult.setUpdatedOn(DateUtils.utilDateFromSqlTimestamp(rs.getTimestamp("UPDATED_ON")));


nextResult.setName(rs.getString("NAME"));


nextResult.setPlanId(rs.getString("PLAN_ID"));


nextResult.setStatus(rs.getString("STATUS"));


String teamleaderID = rs.getString("TEAM_LEADER_ID");
if (StringUtils.hasText(teamleaderID) && !"null".equalsIgnoreCase(teamleaderID) ){
TeamLeader teamleader = new TeamLeader();
teamleader.setID(teamleaderID);
nextResult.setTeamLeader(teamleader);
}


String agentID = rs.getString("AGENT_ID");
if (StringUtils.hasText(agentID) && !"null".equalsIgnoreCase(agentID) ){
Agent agent = new Agent();
agent.setID(agentID);
nextResult.setAgent(agent);
}


String developmentplanID = rs.getString("DEVELOPMENT_PLAN_ID");
if (StringUtils.hasText(developmentplanID) && !"null".equalsIgnoreCase(developmentplanID) ){
DevelopmentPlan developmentplan = new DevelopmentPlan();
developmentplan.setID(developmentplanID);
nextResult.setDevelopmentPlan(developmentplan);
}



			
    	}
		
		
    	return nextResult;
	}

	protected void setBaseStatmentInsertParams(DevelopmentActivity perceroObject, PreparedStatement pstmt) throws SQLException {

		if (perceroObject.getDevelopmentPlan() == null) //PLAN_ID
		{
			pstmt.setString(1, null);
		}
		else
		{
			pstmt.setString(1, perceroObject.getDevelopmentPlan().getID());
		}

		pstmt.setString(2, perceroObject.getName()); //TASK_DESC

		if (perceroObject.getAgent() == null)  //ASSIGNED_TO
		{
			pstmt.setString(3, null);
		}
		else
		{
			pstmt.setString(3, perceroObject.getAgent().getID());
		}

		pstmt.setDate(4, DateUtils.utilDateToSqlDate(perceroObject.getDueDate())); //DUE_DATE
		pstmt.setString(5, perceroObject.getStatus()); //STATUS
		pstmt.setString(6, perceroObject.getCreatedBy());  //CREATED_BY
		pstmt.setString(7, perceroObject.getUpdatedBy()); //UPDATED_BY

		pstmt.setDate(8, DateUtils.utilDateToSqlDate(new java.util.Date())); //CREATED_ON
		pstmt.setDate(9, DateUtils.utilDateToSqlDate(new java.util.Date())); //UPDATED_ON
		pstmt.setDate(10, DateUtils.utilDateToSqlDate(perceroObject.getWeekDate())); //WK_DATE
		pstmt.setString(11, perceroObject.getID()); //TASK_ID
		pstmt.setInt(12, 1); //TYPE  - Development Activity
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(DevelopmentActivity perceroObject, PreparedStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
		
	}
	
	@Override
	protected void setCallableStatmentInsertParams(DevelopmentActivity perceroObject, CallableStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	

	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(DevelopmentActivity perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getCreatedBy());
pstmt.setString(2, perceroObject.getType());
pstmt.setString(3, perceroObject.getUpdatedBy());
pstmt.setDate(4, DateUtils.utilDateToSqlDate(perceroObject.getWeekDate()));
pstmt.setDate(5, DateUtils.utilDateToSqlDate(perceroObject.getCompletedOn()));
pstmt.setDate(6, DateUtils.utilDateToSqlDate(perceroObject.getCreatedOn()));
pstmt.setDate(7, DateUtils.utilDateToSqlDate(perceroObject.getDueDate()));
pstmt.setDate(8, DateUtils.utilDateToSqlDate(perceroObject.getUpdatedOn()));
pstmt.setString(9, perceroObject.getName());
pstmt.setString(10, perceroObject.getPlanId());
pstmt.setString(11, perceroObject.getStatus());

if (perceroObject.getTeamLeader() == null)
{
pstmt.setString(12, null);
}
else
{
		pstmt.setString(12, perceroObject.getTeamLeader().getID());
}


if (perceroObject.getAgent() == null)
{
pstmt.setString(13, null);
}
else
{
		pstmt.setString(13, perceroObject.getAgent().getID());
}


if (perceroObject.getDevelopmentPlan() == null)
{
pstmt.setString(14, null);
}
else
{
		pstmt.setString(14, perceroObject.getDevelopmentPlan().getID());
}

pstmt.setString(15, perceroObject.getID());

		
	}
	
	
	@Override
	protected void setCallableStatmentUpdateParams(DevelopmentActivity perceroObject, CallableStatement pstmt) throws SQLException 
	{
		
		//must be in same order as insert
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	}
	
	

	@Override
	public List<DevelopmentActivity> findByExample(DevelopmentActivity theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useCreatedBy = StringUtils.hasText(theQueryObject.getCreatedBy()) && (excludeProperties == null || !excludeProperties.contains("createdBy"));

if (useCreatedBy)
{
sql += " WHERE ";
sql += " \"CREATED_BY\" =? ";
paramValues.add(theQueryObject.getCreatedBy());
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

boolean useUpdatedBy = StringUtils.hasText(theQueryObject.getUpdatedBy()) && (excludeProperties == null || !excludeProperties.contains("updatedBy"));

if (useUpdatedBy)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"UPDATED_BY\" =? ";
paramValues.add(theQueryObject.getUpdatedBy());
propertyCounter++;
}

boolean useWeekDate = theQueryObject.getWeekDate() != null && (excludeProperties == null || !excludeProperties.contains("weekDate"));

if (useWeekDate)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"WEEK_DATE\" =? ";
paramValues.add(theQueryObject.getWeekDate());
propertyCounter++;
}

boolean useCompletedOn = theQueryObject.getCompletedOn() != null && (excludeProperties == null || !excludeProperties.contains("completedOn"));

if (useCompletedOn)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"COMPLETED_ON\" =? ";
paramValues.add(theQueryObject.getCompletedOn());
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

boolean useDueDate = theQueryObject.getDueDate() != null && (excludeProperties == null || !excludeProperties.contains("dueDate"));

if (useDueDate)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"DUE_DATE\" =? ";
paramValues.add(theQueryObject.getDueDate());
propertyCounter++;
}

boolean useUpdatedOn = theQueryObject.getUpdatedOn() != null && (excludeProperties == null || !excludeProperties.contains("updatedOn"));

if (useUpdatedOn)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"UPDATED_ON\" =? ";
paramValues.add(theQueryObject.getUpdatedOn());
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

boolean usePlanId = StringUtils.hasText(theQueryObject.getPlanId()) && (excludeProperties == null || !excludeProperties.contains("planId"));

if (usePlanId)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"PLAN_ID\" =? ";
paramValues.add(theQueryObject.getPlanId());
propertyCounter++;
}

boolean useStatus = StringUtils.hasText(theQueryObject.getStatus()) && (excludeProperties == null || !excludeProperties.contains("status"));

if (useStatus)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"STATUS\" =? ";
paramValues.add(theQueryObject.getStatus());
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

boolean useDevelopmentPlanID = theQueryObject.getDevelopmentPlan() != null && (excludeProperties == null || !excludeProperties.contains("developmentPlan"));

if (useDevelopmentPlanID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"DEVELOPMENT_PLAN_ID\" =? ";
paramValues.add(theQueryObject.getDevelopmentPlan().getID());
propertyCounter++;
}



		if (propertyCounter == 0) {
			throw new SyncException(SyncException.METHOD_UNSUPPORTED, SyncException.METHOD_UNSUPPORTED_CODE);
		}
		
		return executeSelectWithParams(sql, paramValues.toArray(), shellOnly);		
	}
	
	@Override
	protected String getUpdateCallableStatementSql() {
		return "{call UPDATE_DEVELOPMENT_ACTIVITY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	}
	@Override
	protected String getInsertCallableStatementSql() {
		return "{call CREATE_DEVELOPMENT_ACTIVITY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	}
	@Override
	protected String getDeleteCallableStatementSql() {
		return "{call Delete_DEVELOPMENT_ACTIVITY(?)}";
	}
	
	

public DevelopmentActivity createObject(DevelopmentActivity perceroObject, String userId)
		throws SyncException {
	if ( !hasCreateAccess(BaseDataObject.toClassIdPair(perceroObject), userId) ) {
		return null;
	}

	long timeStart = System.currentTimeMillis();

	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	String query = "Select EFC_TASK_SEQ.NEXTVAL from dual";
	String sql = null;
	String insertedId = "0";
	int result = 0;
	try {
		IConnectionFactory connectionFactory = getConnectionRegistry().getConnectionFactory(getConnectionFactoryName());
		conn = connectionFactory.getConnection();
		conn.setAutoCommit(false);
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			insertedId = rs.getString(1);
		}

		perceroObject.setID(insertedId);
		sql = getInsertIntoSQL();
		pstmt = conn.prepareStatement(sql);


		setPreparedStatmentInsertParams(perceroObject, pstmt);
		result = pstmt.executeUpdate();
		conn.commit();
	} catch(Exception e) {
		log.error("Unable to executeUpdate\n" + sql, e);
		throw new SyncDataException(e);
	} finally {
		try {
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.setAutoCommit(true);
				conn.close();
			}
		} catch (Exception e) {
			log.error("Error closing database statement/connection", e);
		}
	}

	long timeEnd = System.currentTimeMillis();
	long totalTime = timeEnd - timeStart;
	if (totalTime > LONG_RUNNING_QUERY_TIME) {
		log.warn("LONG RUNNING QUERY: " + totalTime + "ms\n" + sql);
	}

	if (result > 0) {
		return retrieveObject(BaseDataObject.toClassIdPair(perceroObject), userId, false);
	}
	else {
		return null;
	}
}



	
	
}

