

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
import com.percero.agents.sync.vo.BaseDataObject;

import com.percero.agents.sync.dao.DAORegistry;
import com.percero.agents.sync.dao.IDataAccessObject;
import com.percero.agents.sync.exceptions.SyncException;

import com.pulse.mo.*;


@Component
public class AdhocTaskDAO extends SqlDataAccessObject<AdhocTask> implements IDataAccessObject<AdhocTask> {

	static final Logger log = Logger.getLogger(AdhocTaskDAO.class);

	
	public AdhocTaskDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(AdhocTask.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	
	public static final String SQL_VIEW = ",\"ADHOC_TASK\".\"UPDATED_BY\",\"ADHOC_TASK\".\"CREATED_BY\",\"ADHOC_TASK\".\"TASK_DETAIL\",\"ADHOC_TASK\".\"DUE_DATE\",\"ADHOC_TASK\".\"WEEK_DATE\",\"ADHOC_TASK\".\"COMPLETED_ON\",\"ADHOC_TASK\".\"CREATED_ON\",\"ADHOC_TASK\".\"UPDATED_ON\",\"ADHOC_TASK\".\"PLAN_ID\",\"ADHOC_TASK\".\"TYPE\",\"ADHOC_TASK\".\"ADHOC_TASK_STATE_ID\",\"ADHOC_TASK\".\"AGENT_ID\",\"ADHOC_TASK\".\"TEAM_LEADER_ID\"";
	private String selectFromStatementTableName = " FROM \"ADHOC_TASK\" \"ADHOC_TASK\"";
	private String whereClause = "  WHERE \"ADHOC_TASK\".\"ID\"=?";
	private String whereInClause = "  join table(sys.dbms_debug_vc2coll(?)) SQLLIST on \"ADHOC_TASK\".\"ID\"= SQLLIST.column_value";
	private String orderByTableName = "  ORDER BY \"ADHOC_TASK\".\"ID\"";
	
	private String joinAdhocTaskStateIDAdhocTask = "WHERE ADHOC_TASK.ADHOC_TASK_STATE_ID= ? And WEEK_DATE > Add_months(sysdate,-12)";
private String joinAgentIDAdhocTask = "WHERE ADHOC_TASK.AGENT_ID= ? And WEEK_DATE > Add_months(sysdate,-12)";
private String joinTeamLeaderIDAdhocTask = "WHERE ADHOC_TASK.TEAM_LEADER_ID= ? And WEEK_DATE > Add_months(sysdate,-12)";


	
	@Override
	protected String getConnectionFactoryName() {
		return AdhocTaskDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT \"ADHOC_TASK\".\"ID\" " + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT \"ADHOC_TASK\".\"ID\"" + SQL_VIEW  + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT \"ADHOC_TASK\".\"ID\" " + selectFromStatementTableName +  orderByTableName;
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT \"ADHOC_TASK\".\"ID\" " + selectFromStatementTableName  +  orderByTableName  + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT \"ADHOC_TASK\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName  + orderByTableName;
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT \"ADHOC_TASK\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + orderByTableName + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() 
	{
		return "SELECT COUNT(ID) " + selectFromStatementTableName;
	}
	
	@Override
	protected String getSelectInStarSQL() 
	{
		return "SELECT \"ADHOC_TASK\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + whereInClause;
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT \"ADHOC_TASK\".\"ID\" " + selectFromStatementTableName + whereInClause;
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		if (joinColumnName.equalsIgnoreCase("\"ADHOC_TASK_STATE_ID\""))
{
return "SELECT \"ADHOC_TASK\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + joinAdhocTaskStateIDAdhocTask;
}
if (joinColumnName.equalsIgnoreCase("\"AGENT_ID\""))
{
return "SELECT \"ADHOC_TASK\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + joinAgentIDAdhocTask;
}
if (joinColumnName.equalsIgnoreCase("\"TEAM_LEADER_ID\""))
{
return "SELECT \"ADHOC_TASK\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + joinTeamLeaderIDAdhocTask;
}

		return "SELECT \"ADHOC_TASK\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + " WHERE \"ADHOC_TASK\"." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) 
	{
		if (joinColumnName.equalsIgnoreCase("\"ADHOC_TASK_STATE_ID\""))
{
return "SELECT \"ADHOC_TASK\".\"ID\" " + selectFromStatementTableName + joinAdhocTaskStateIDAdhocTask;
}
if (joinColumnName.equalsIgnoreCase("\"AGENT_ID\""))
{
return "SELECT \"ADHOC_TASK\".\"ID\" " + selectFromStatementTableName + joinAgentIDAdhocTask;
}
if (joinColumnName.equalsIgnoreCase("\"TEAM_LEADER_ID\""))
{
return "SELECT \"ADHOC_TASK\".\"ID\" " + selectFromStatementTableName + joinTeamLeaderIDAdhocTask;
}

		return "SELECT \"ADHOC_TASK\".\"ID\" " + selectFromStatementTableName + " WHERE \"ADHOC_TASK\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT \"ADHOC_TASK\".\"ID\" " + selectFromStatementTableName;
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT \"ADHOC_TASK\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName;
	}

	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO EFC_TASK (\"TASK_DESC\", \"ASSIGNED_TO\", \"DUE_DATE\",  \"STATUS\",\"CREATED_BY\", \"UPDATED_BY\", \"CREATED_ON\", \"UPDATED_ON\", \"WK_DATE\", \"PLAN_ID\", \"TASK_ID\", \"TYPE\") VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE TBL_ADHOC_TASK SET \"UPDATED_BY\"=?,\"CREATED_BY\"=?,\"TASK_DETAIL\"=?,\"DUE_DATE\"=?,\"WEEK_DATE\"=?,\"COMPLETED_ON\"=?,\"CREATED_ON\"=?,\"UPDATED_ON\"=?,\"PLAN_ID\"=?,\"TYPE\"=?,\"ADHOC_TASK_STATE_ID\"=?,\"AGENT_ID\"=?,\"TEAM_LEADER_ID\"=? WHERE \"ID\"=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM TBL_ADHOC_TASK WHERE \"ID\"=?";
	}
	
	@Override
	protected AdhocTask extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	AdhocTask nextResult = new AdhocTask();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setUpdatedBy(rs.getString("UPDATED_BY"));

nextResult.setCreatedBy(rs.getString("CREATED_BY"));

nextResult.setTaskDetail(rs.getString("TASK_DETAIL"));

nextResult.setDueDate(rs.getDate("DUE_DATE"));

nextResult.setWeekDate(rs.getDate("WEEK_DATE"));

nextResult.setCompletedOn(rs.getDate("COMPLETED_ON"));

nextResult.setCreatedOn(rs.getDate("CREATED_ON"));

nextResult.setUpdatedOn(rs.getDate("UPDATED_ON"));

nextResult.setPlanId(rs.getInt("PLAN_ID"));

nextResult.setType(rs.getInt("TYPE"));

AdhocTaskState adhoctaskstate = new AdhocTaskState();
adhoctaskstate.setID(rs.getString("ADHOC_TASK_STATE_ID"));
nextResult.setAdhocTaskState(adhoctaskstate);

Agent agent = new Agent();
agent.setID(rs.getString("AGENT_ID"));
nextResult.setAgent(agent);

TeamLeader teamleader = new TeamLeader();
teamleader.setID(rs.getString("TEAM_LEADER_ID"));
nextResult.setTeamLeader(teamleader);


			
    	}
    	
    	return nextResult;
	}

	protected void setBaseStatmentInsertParams(AdhocTask perceroObject, PreparedStatement pstmt) throws SQLException {

		pstmt.setString(1, perceroObject.getTaskDetail());

		if (perceroObject.getAgent() == null)
		{
			pstmt.setString(2, null);
		}
		else
		{
			pstmt.setString(2, perceroObject.getAgent().getID());
		}

		pstmt.setDate(3, DateUtils.utilDateToSqlDate(perceroObject.getDueDate()));
		pstmt.setString(4, perceroObject.getAdhocTaskState().getID());

		if (perceroObject.getTeamLeader() == null)
		{
			pstmt.setString(5, null);
			pstmt.setString(6, null);
		}
		else
		{
			pstmt.setString(5, perceroObject.getTeamLeader().getID());
			pstmt.setString(6, perceroObject.getTeamLeader().getID());
		}
		pstmt.setDate(7, DateUtils.utilDateToSqlDate(perceroObject.getCreatedOn()));
		pstmt.setDate(8, DateUtils.utilDateToSqlDate(perceroObject.getUpdatedOn()));
		pstmt.setDate(9, DateUtils.utilDateToSqlDate(perceroObject.getWeekDate()));
		pstmt.setString(10, null);
		pstmt.setString(11, perceroObject.getID());
		pstmt.setInt(12, 2); //Adhoc task
	}

	public AdhocTask createObject(AdhocTask perceroObject, String userId)
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
	
	@Override
	protected void setPreparedStatmentInsertParams(AdhocTask perceroObject, PreparedStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
		
	}
	
	@Override
	protected void setCallableStatmentInsertParams(AdhocTask perceroObject, CallableStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	

	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(AdhocTask perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getUpdatedBy());
pstmt.setString(2, perceroObject.getCreatedBy());
pstmt.setString(3, perceroObject.getTaskDetail());
pstmt.setDate(4, DateUtils.utilDateToSqlDate(perceroObject.getDueDate()));
pstmt.setDate(5, DateUtils.utilDateToSqlDate(perceroObject.getWeekDate()));
pstmt.setDate(6, DateUtils.utilDateToSqlDate(perceroObject.getCompletedOn()));
pstmt.setDate(7, DateUtils.utilDateToSqlDate(perceroObject.getCreatedOn()));
pstmt.setDate(8, DateUtils.utilDateToSqlDate(perceroObject.getUpdatedOn()));
pstmt.setInt(9, perceroObject.getPlanId());
pstmt.setInt(10, perceroObject.getType());

if (perceroObject.getAdhocTaskState() == null)
{
pstmt.setString(11, null);
}
else
{
		pstmt.setString(11, perceroObject.getAdhocTaskState().getID());
}


if (perceroObject.getAgent() == null)
{
pstmt.setString(12, null);
}
else
{
		pstmt.setString(12, perceroObject.getAgent().getID());
}


if (perceroObject.getTeamLeader() == null)
{
pstmt.setString(13, null);
}
else
{
		pstmt.setString(13, perceroObject.getTeamLeader().getID());
}

pstmt.setString(14, perceroObject.getID());

		
	}
	
	
	@Override
	protected void setCallableStatmentUpdateParams(AdhocTask perceroObject, CallableStatement pstmt) throws SQLException 
	{
		
		//must be in same order as insert
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	}
	
	

	@Override
	public List<AdhocTask> findByExample(AdhocTask theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useUpdatedBy = StringUtils.hasText(theQueryObject.getUpdatedBy()) && (excludeProperties == null || !excludeProperties.contains("updatedBy"));

if (useUpdatedBy)
{
sql += " WHERE ";
sql += " \"UPDATED_BY\" =? ";
paramValues.add(theQueryObject.getUpdatedBy());
propertyCounter++;
}

boolean useCreatedBy = StringUtils.hasText(theQueryObject.getCreatedBy()) && (excludeProperties == null || !excludeProperties.contains("createdBy"));

if (useCreatedBy)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"CREATED_BY\" =? ";
paramValues.add(theQueryObject.getCreatedBy());
propertyCounter++;
}

boolean useTaskDetail = StringUtils.hasText(theQueryObject.getTaskDetail()) && (excludeProperties == null || !excludeProperties.contains("taskDetail"));

if (useTaskDetail)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"TASK_DETAIL\" =? ";
paramValues.add(theQueryObject.getTaskDetail());
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

boolean usePlanId = theQueryObject.getPlanId() != null && (excludeProperties == null || !excludeProperties.contains("planId"));

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

boolean useType = theQueryObject.getType() != null && (excludeProperties == null || !excludeProperties.contains("type"));

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

boolean useAdhocTaskStateID = theQueryObject.getAdhocTaskState() != null && (excludeProperties == null || !excludeProperties.contains("adhocTaskState"));

if (useAdhocTaskStateID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"ADHOC_TASK_STATE_ID\" =? ";
paramValues.add(theQueryObject.getAdhocTaskState().getID());
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
		return "{call UPDATE_ADHOC_TASK(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	}
	@Override
	protected String getInsertCallableStatementSql() {
		return "{call CREATE_ADHOC_TASK(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	}
	@Override
	protected String getDeleteCallableStatementSql() {
		return "{call Delete_ADHOC_TASK(?)}";
	}
	
	
	
	
}

