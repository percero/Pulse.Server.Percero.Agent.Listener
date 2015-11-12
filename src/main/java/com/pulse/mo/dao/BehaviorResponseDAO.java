
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
public class BehaviorResponseDAO extends SqlDataAccessObject<BehaviorResponse> implements IDataAccessObject<BehaviorResponse> {

	static final Logger log = Logger.getLogger(BehaviorResponseDAO.class);

	
	public BehaviorResponseDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(BehaviorResponse.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	
	public static final String SHELL_ONLY_SELECT = "\"BEHAVIOR_RESPONSE\".\"ID\"";
	public static final String SQL_VIEW = ",\"BEHAVIOR_RESPONSE\".\"UPDATED_BY\",\"BEHAVIOR_RESPONSE\".\"CREATED_BY\",\"BEHAVIOR_RESPONSE\".\"WEEK_DATE\",\"BEHAVIOR_RESPONSE\".\"CREATED_ON\",\"BEHAVIOR_RESPONSE\".\"UPDATED_ON\",\"BEHAVIOR_RESPONSE\".\"RESPONSE\",\"BEHAVIOR_RESPONSE\".\"AGENT_ID\",\"BEHAVIOR_RESPONSE\".\"BEHAVIOR_ID\",\"BEHAVIOR_RESPONSE\".\"COACHING_SESSION_ID\",\"BEHAVIOR_RESPONSE\".\"SCORECARD_MEASURE_ID\",\"BEHAVIOR_RESPONSE\".\"SCARD_WEEKLY_RESULT_ID\"";
	private String selectFromStatementTableName = " FROM \"BEHAVIOR_RESPONSE\" \"BEHAVIOR_RESPONSE\"";
	private String whereClause = "  WHERE \"BEHAVIOR_RESPONSE\".\"ID\"=?";
	private String whereInClause = "  join table(sys.dbms_debug_vc2coll(?)) SQLLIST on \"BEHAVIOR_RESPONSE\".\"ID\"= SQLLIST.column_value";
	private String orderByTableName = "  ORDER BY \"BEHAVIOR_RESPONSE\".\"ID\"";
	
	

	
	@Override
	protected String getConnectionFactoryName() {
		return BehaviorResponseDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT " + SHELL_ONLY_SELECT +  " " + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT \"BEHAVIOR_RESPONSE\".\"ID\"" + SQL_VIEW  + selectFromStatementTableName + whereClause;
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
		return "SELECT \"BEHAVIOR_RESPONSE\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName  + orderByTableName;
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT \"BEHAVIOR_RESPONSE\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + orderByTableName + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() 
	{
		return "SELECT COUNT(ID) " + selectFromStatementTableName;
	}
	
	@Override
	protected String getSelectInStarSQL() 
	{
		return "SELECT \"BEHAVIOR_RESPONSE\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + whereInClause;
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName + whereInClause;
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		
		return "SELECT \"BEHAVIOR_RESPONSE\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + " WHERE \"BEHAVIOR_RESPONSE\"." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) 
	{
		
		return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName + " WHERE \"BEHAVIOR_RESPONSE\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName;
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT \"BEHAVIOR_RESPONSE\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName;
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO TBL_BEHAVIOR_RESPONSE (\"ID\",\"UPDATED_BY\",\"CREATED_BY\",\"WEEK_DATE\",\"CREATED_ON\",\"UPDATED_ON\",\"RESPONSE\",\"AGENT_ID\",\"BEHAVIOR_ID\",\"COACHING_SESSION_ID\",\"SCORECARD_MEASURE_ID\",\"SCARD_WEEKLY_RESULT_ID\") VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE TBL_BEHAVIOR_RESPONSE SET \"UPDATED_BY\"=?,\"CREATED_BY\"=?,\"WEEK_DATE\"=?,\"CREATED_ON\"=?,\"UPDATED_ON\"=?,\"RESPONSE\"=?,\"AGENT_ID\"=?,\"BEHAVIOR_ID\"=?,\"COACHING_SESSION_ID\"=?,\"SCORECARD_MEASURE_ID\"=?,\"SCARD_WEEKLY_RESULT_ID\"=? WHERE \"ID\"=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM TBL_BEHAVIOR_RESPONSE WHERE \"ID\"=?";
	}
	
	@Override
	protected BehaviorResponse extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	
		
BehaviorResponse nextResult = null;
    	
		    	
    	if (nextResult == null) {
    		nextResult = new BehaviorResponse();
    	}

		
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setUpdatedBy(rs.getString("UPDATED_BY"));


nextResult.setCreatedBy(rs.getString("CREATED_BY"));


nextResult.setWeekDate(DateUtils.utilDateFromSqlTimestamp(rs.getTimestamp("WEEK_DATE")));


nextResult.setCreatedOn(DateUtils.utilDateFromSqlTimestamp(rs.getTimestamp("CREATED_ON")));


nextResult.setUpdatedOn(DateUtils.utilDateFromSqlTimestamp(rs.getTimestamp("UPDATED_ON")));


nextResult.setResponse(rs.getInt("RESPONSE"));


String agentID = rs.getString("AGENT_ID");
if (StringUtils.hasText(agentID)) {
Agent agent = new Agent();
agent.setID(agentID);
nextResult.setAgent(agent);
}


String behaviorID = rs.getString("BEHAVIOR_ID");
if (StringUtils.hasText(behaviorID)) {
Behavior behavior = new Behavior();
behavior.setID(behaviorID);
nextResult.setBehavior(behavior);
}


String coachingsessionID = rs.getString("COACHING_SESSION_ID");
if (StringUtils.hasText(coachingsessionID)) {
CoachingSession coachingsession = new CoachingSession();
coachingsession.setID(coachingsessionID);
nextResult.setCoachingSession(coachingsession);
}


String scorecardmeasureID = rs.getString("SCORECARD_MEASURE_ID");
if (StringUtils.hasText(scorecardmeasureID)) {
ScorecardMeasure scorecardmeasure = new ScorecardMeasure();
scorecardmeasure.setID(scorecardmeasureID);
nextResult.setScorecardMeasure(scorecardmeasure);
}


String scorecardweeklyresultID = rs.getString("SCARD_WEEKLY_RESULT_ID");
if (StringUtils.hasText(scorecardweeklyresultID)) {
ScorecardWeeklyResult scorecardweeklyresult = new ScorecardWeeklyResult();
scorecardweeklyresult.setID(scorecardweeklyresultID);
nextResult.setScorecardWeeklyResult(scorecardweeklyresult);
}



			
    	}
		
		
    	return nextResult;
	}
	
	protected void setBaseStatmentInsertParams(BehaviorResponse perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getUpdatedBy());
pstmt.setString(3, perceroObject.getCreatedBy());
pstmt.setDate(4, DateUtils.utilDateToSqlDate(perceroObject.getWeekDate()));
pstmt.setDate(5, DateUtils.utilDateToSqlDate(perceroObject.getCreatedOn()));
pstmt.setDate(6, DateUtils.utilDateToSqlDate(perceroObject.getUpdatedOn()));
JdbcHelper.setInt(pstmt,7, perceroObject.getResponse());

if (perceroObject.getAgent() == null)
{
pstmt.setString(8, null);
}
else
{
		pstmt.setString(8, perceroObject.getAgent().getID());
}


if (perceroObject.getBehavior() == null)
{
pstmt.setString(9, null);
}
else
{
		pstmt.setString(9, perceroObject.getBehavior().getID());
}


if (perceroObject.getCoachingSession() == null)
{
pstmt.setString(10, null);
}
else
{
		pstmt.setString(10, perceroObject.getCoachingSession().getID());
}


if (perceroObject.getScorecardMeasure() == null)
{
pstmt.setString(11, null);
}
else
{
		pstmt.setString(11, perceroObject.getScorecardMeasure().getID());
}


if (perceroObject.getScorecardWeeklyResult() == null)
{
pstmt.setString(12, null);
}
else
{
		pstmt.setString(12, perceroObject.getScorecardWeeklyResult().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(BehaviorResponse perceroObject, PreparedStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
		
	}
	
	@Override
	protected void setCallableStatmentInsertParams(BehaviorResponse perceroObject, CallableStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	

	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(BehaviorResponse perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getUpdatedBy());
pstmt.setString(2, perceroObject.getCreatedBy());
pstmt.setDate(3, DateUtils.utilDateToSqlDate(perceroObject.getWeekDate()));
pstmt.setDate(4, DateUtils.utilDateToSqlDate(perceroObject.getCreatedOn()));
pstmt.setDate(5, DateUtils.utilDateToSqlDate(perceroObject.getUpdatedOn()));
JdbcHelper.setInt(pstmt,6, perceroObject.getResponse());

if (perceroObject.getAgent() == null)
{
pstmt.setString(7, null);
}
else
{
		pstmt.setString(7, perceroObject.getAgent().getID());
}


if (perceroObject.getBehavior() == null)
{
pstmt.setString(8, null);
}
else
{
		pstmt.setString(8, perceroObject.getBehavior().getID());
}


if (perceroObject.getCoachingSession() == null)
{
pstmt.setString(9, null);
}
else
{
		pstmt.setString(9, perceroObject.getCoachingSession().getID());
}


if (perceroObject.getScorecardMeasure() == null)
{
pstmt.setString(10, null);
}
else
{
		pstmt.setString(10, perceroObject.getScorecardMeasure().getID());
}


if (perceroObject.getScorecardWeeklyResult() == null)
{
pstmt.setString(11, null);
}
else
{
		pstmt.setString(11, perceroObject.getScorecardWeeklyResult().getID());
}

pstmt.setString(12, perceroObject.getID());

		
	}
	
	
	@Override
	protected void setCallableStatmentUpdateParams(BehaviorResponse perceroObject, CallableStatement pstmt) throws SQLException 
	{
		
		//must be in same order as insert
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	}
	
	

	@Override
	public List<BehaviorResponse> findByExample(BehaviorResponse theQueryObject,
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

boolean useResponse = theQueryObject.getResponse() != null && (excludeProperties == null || !excludeProperties.contains("response"));

if (useResponse)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"RESPONSE\" =? ";
paramValues.add(theQueryObject.getResponse());
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

boolean useBehaviorID = theQueryObject.getBehavior() != null && (excludeProperties == null || !excludeProperties.contains("behavior"));

if (useBehaviorID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"BEHAVIOR_ID\" =? ";
paramValues.add(theQueryObject.getBehavior().getID());
propertyCounter++;
}

boolean useCoachingSessionID = theQueryObject.getCoachingSession() != null && (excludeProperties == null || !excludeProperties.contains("coachingSession"));

if (useCoachingSessionID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"COACHING_SESSION_ID\" =? ";
paramValues.add(theQueryObject.getCoachingSession().getID());
propertyCounter++;
}

boolean useScorecardMeasureID = theQueryObject.getScorecardMeasure() != null && (excludeProperties == null || !excludeProperties.contains("scorecardMeasure"));

if (useScorecardMeasureID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"SCORECARD_MEASURE_ID\" =? ";
paramValues.add(theQueryObject.getScorecardMeasure().getID());
propertyCounter++;
}

boolean useScorecardWeeklyResultID = theQueryObject.getScorecardWeeklyResult() != null && (excludeProperties == null || !excludeProperties.contains("scorecardWeeklyResult"));

if (useScorecardWeeklyResultID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"SCARD_WEEKLY_RESULT_ID\" =? ";
paramValues.add(theQueryObject.getScorecardWeeklyResult().getID());
propertyCounter++;
}



		if (propertyCounter == 0) {
			throw new SyncException(SyncException.METHOD_UNSUPPORTED, SyncException.METHOD_UNSUPPORTED_CODE);
		}
		
		return executeSelectWithParams(sql, paramValues.toArray(), shellOnly);		
	}
	
	@Override
	protected String getUpdateCallableStatementSql() {
		return "{call UPDATE_BEHAVIOR_RESPONSE(?,?,?,?,?,?,?,?,?,?,?,?)}";
	}
	@Override
	protected String getInsertCallableStatementSql() {
		return "{call CREATE_BEHAVIOR_RESPONSE(?,?,?,?,?,?,?,?,?,?,?,?)}";
	}
	@Override
	protected String getDeleteCallableStatementSql() {
		return "{call Delete_BEHAVIOR_RESPONSE(?)}";
	}
	
	
public BehaviorResponse createObject(BehaviorResponse perceroObject, String userId)
		throws SyncException {
	if ( !hasCreateAccess(BaseDataObject.toClassIdPair(perceroObject), userId) ) {
		return null;
	}

	long timeStart = System.currentTimeMillis();

	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	String query = "Select BEHAVIOR_RESPONSE_SEQ.NEXTVAL from dual";
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
