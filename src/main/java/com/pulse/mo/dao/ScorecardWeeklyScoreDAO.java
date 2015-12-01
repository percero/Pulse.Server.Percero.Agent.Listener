
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
public class ScorecardWeeklyScoreDAO extends SqlDataAccessObject<ScorecardWeeklyScore> implements IDataAccessObject<ScorecardWeeklyScore> {

	static final Logger log = Logger.getLogger(ScorecardWeeklyScoreDAO.class);

	
	public ScorecardWeeklyScoreDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(ScorecardWeeklyScore.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	
	public static final String SHELL_ONLY_SELECT = "\"SCORECARD_WEEKLY_SCORE\".\"ID\"";
	public static final String SQL_VIEW = ",\"SCORECARD_WEEKLY_SCORE\".\"EMPLOYEE_ID\",\"SCORECARD_WEEKLY_SCORE\".\"INTERVAL_TYPE\",\"SCORECARD_WEEKLY_SCORE\".\"CREATED_ON\",\"SCORECARD_WEEKLY_SCORE\".\"END_DATE\",\"SCORECARD_WEEKLY_SCORE\".\"START_DATE\",\"SCORECARD_WEEKLY_SCORE\".\"UPDATED_ON\",\"SCORECARD_WEEKLY_SCORE\".\"POINTS_POSSIBLE\",\"SCORECARD_WEEKLY_SCORE\".\"POINTS_RECEIVED\",\"SCORECARD_WEEKLY_SCORE\".\"SCORE\",\"SCORECARD_WEEKLY_SCORE\".\"GRADE\",\"SCORECARD_WEEKLY_SCORE\".\"AGENT_ID\",\"SCORECARD_WEEKLY_SCORE\".\"PREV_SCARD_WEEKLY_SCORE_ID\",\"SCORECARD_WEEKLY_SCORE\".\"SCORECARD_ID\",\"SCORECARD_WEEKLY_SCORE\".\"SCORECARD_MEASURE_ID\",\"SCORECARD_WEEKLY_SCORE\".\"SCORECARD_MONTHLY_SCORE_ID\",\"SCORECARD_WEEKLY_SCORE\".\"GOAL_ID\"";
	private String selectFromStatementTableName = " FROM \"SCORECARD_WEEKLY_SCORE\" \"SCORECARD_WEEKLY_SCORE\"";
	private String whereClause = "  WHERE \"SCORECARD_WEEKLY_SCORE\".\"ID\"=?";
	private String whereInClause = "  join table(sys.dbms_debug_vc2coll(?)) SQLLIST on \"SCORECARD_WEEKLY_SCORE\".\"ID\"= SQLLIST.column_value";
	private String orderByTableName = "  ORDER BY \"SCORECARD_WEEKLY_SCORE\".\"ID\"";
	
	

	
	@Override
	protected String getConnectionFactoryName() {
		return ScorecardWeeklyScoreDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT " + SHELL_ONLY_SELECT +  " " + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT \"SCORECARD_WEEKLY_SCORE\".\"ID\"" + SQL_VIEW  + selectFromStatementTableName + whereClause;
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
		return "SELECT \"SCORECARD_WEEKLY_SCORE\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName  + orderByTableName;
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT \"SCORECARD_WEEKLY_SCORE\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + orderByTableName + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() 
	{
		return "SELECT COUNT(ID) " + selectFromStatementTableName;
	}
	
	@Override
	protected String getSelectInStarSQL() 
	{
		return "SELECT \"SCORECARD_WEEKLY_SCORE\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + whereInClause;
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName + whereInClause;
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		
		return "SELECT \"SCORECARD_WEEKLY_SCORE\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + " WHERE \"SCORECARD_WEEKLY_SCORE\"." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) 
	{
		
		return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName + " WHERE \"SCORECARD_WEEKLY_SCORE\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName;
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT \"SCORECARD_WEEKLY_SCORE\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName;
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO TBL_SCORECARD_WEEKLY_SCORE (\"ID\",\"EMPLOYEE_ID\",\"INTERVAL_TYPE\",\"CREATED_ON\",\"END_DATE\",\"START_DATE\",\"UPDATED_ON\",\"POINTS_POSSIBLE\",\"POINTS_RECEIVED\",\"SCORE\",\"GRADE\",\"AGENT_ID\",\"PREV_SCARD_WEEKLY_SCORE_ID\",\"SCORECARD_ID\",\"SCORECARD_MEASURE_ID\",\"SCORECARD_MONTHLY_SCORE_ID\",\"GOAL_ID\") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE TBL_SCORECARD_WEEKLY_SCORE SET \"EMPLOYEE_ID\"=?,\"INTERVAL_TYPE\"=?,\"CREATED_ON\"=?,\"END_DATE\"=?,\"START_DATE\"=?,\"UPDATED_ON\"=?,\"POINTS_POSSIBLE\"=?,\"POINTS_RECEIVED\"=?,\"SCORE\"=?,\"GRADE\"=?,\"AGENT_ID\"=?,\"PREV_SCARD_WEEKLY_SCORE_ID\"=?,\"SCORECARD_ID\"=?,\"SCORECARD_MEASURE_ID\"=?,\"SCORECARD_MONTHLY_SCORE_ID\"=?,\"GOAL_ID\"=? WHERE \"ID\"=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM TBL_SCORECARD_WEEKLY_SCORE WHERE \"ID\"=?";
	}
	
	@Override
	protected ScorecardWeeklyScore extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	
		
ScorecardWeeklyScore nextResult = null;
    	
		    	
    	if (nextResult == null) {
    		nextResult = new ScorecardWeeklyScore();
    	}

		
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setEmployeeId(rs.getString("EMPLOYEE_ID"));


nextResult.setIntervalType(rs.getString("INTERVAL_TYPE"));


nextResult.setCreatedOn(DateUtils.utilDateFromSqlTimestamp(rs.getTimestamp("CREATED_ON")));


nextResult.setEndDate(DateUtils.utilDateFromSqlTimestamp(rs.getTimestamp("END_DATE")));


nextResult.setStartDate(DateUtils.utilDateFromSqlTimestamp(rs.getTimestamp("START_DATE")));


nextResult.setUpdatedOn(DateUtils.utilDateFromSqlTimestamp(rs.getTimestamp("UPDATED_ON")));


nextResult.setPointsPossible(rs.getDouble("POINTS_POSSIBLE"));


nextResult.setPointsReceived(rs.getDouble("POINTS_RECEIVED"));


nextResult.setScore(rs.getDouble("SCORE"));


nextResult.setGrade(rs.getInt("GRADE"));


String agentID = rs.getString("AGENT_ID");
if (StringUtils.hasText(agentID) && !"null".equalsIgnoreCase(agentID) ){
Agent agent = new Agent();
agent.setID(agentID);
nextResult.setAgent(agent);
}


String previousscorecardweeklyscoreID = rs.getString("PREV_SCARD_WEEKLY_SCORE_ID");
if (StringUtils.hasText(previousscorecardweeklyscoreID) && !"null".equalsIgnoreCase(previousscorecardweeklyscoreID) ){
ScorecardWeeklyScore previousscorecardweeklyscore = new ScorecardWeeklyScore();
previousscorecardweeklyscore.setID(previousscorecardweeklyscoreID);
nextResult.setPreviousScorecardWeeklyScore(previousscorecardweeklyscore);
}


String scorecardID = rs.getString("SCORECARD_ID");
if (StringUtils.hasText(scorecardID) && !"null".equalsIgnoreCase(scorecardID) ){
Scorecard scorecard = new Scorecard();
scorecard.setID(scorecardID);
nextResult.setScorecard(scorecard);
}


String scorecardmeasureID = rs.getString("SCORECARD_MEASURE_ID");
if (StringUtils.hasText(scorecardmeasureID) && !"null".equalsIgnoreCase(scorecardmeasureID) ){
ScorecardMeasure scorecardmeasure = new ScorecardMeasure();
scorecardmeasure.setID(scorecardmeasureID);
nextResult.setScorecardMeasure(scorecardmeasure);
}


String scorecardmonthlyscoreID = rs.getString("SCORECARD_MONTHLY_SCORE_ID");
if (StringUtils.hasText(scorecardmonthlyscoreID) && !"null".equalsIgnoreCase(scorecardmonthlyscoreID) ){
ScorecardMonthlyScore scorecardmonthlyscore = new ScorecardMonthlyScore();
scorecardmonthlyscore.setID(scorecardmonthlyscoreID);
nextResult.setScorecardMonthlyScore(scorecardmonthlyscore);
}


String goalID = rs.getString("GOAL_ID");
if (StringUtils.hasText(goalID) && !"null".equalsIgnoreCase(goalID) ){
Goal goal = new Goal();
goal.setID(goalID);
nextResult.setGoal(goal);
}



			
    	}
		
		
    	return nextResult;
	}
	
	protected void setBaseStatmentInsertParams(ScorecardWeeklyScore perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getEmployeeId());
pstmt.setString(3, perceroObject.getIntervalType());
pstmt.setDate(4, DateUtils.utilDateToSqlDate(perceroObject.getCreatedOn()));
pstmt.setDate(5, DateUtils.utilDateToSqlDate(perceroObject.getEndDate()));
pstmt.setDate(6, DateUtils.utilDateToSqlDate(perceroObject.getStartDate()));
pstmt.setDate(7, DateUtils.utilDateToSqlDate(perceroObject.getUpdatedOn()));
JdbcHelper.setDouble(pstmt,8, perceroObject.getPointsPossible());
JdbcHelper.setDouble(pstmt,9, perceroObject.getPointsReceived());
JdbcHelper.setDouble(pstmt,10, perceroObject.getScore());
JdbcHelper.setInt(pstmt,11, perceroObject.getGrade());

if (perceroObject.getAgent() == null)
{
pstmt.setString(12, null);
}
else
{
		pstmt.setString(12, perceroObject.getAgent().getID());
}


if (perceroObject.getPreviousScorecardWeeklyScore() == null)
{
pstmt.setString(13, null);
}
else
{
		pstmt.setString(13, perceroObject.getPreviousScorecardWeeklyScore().getID());
}


if (perceroObject.getScorecard() == null)
{
pstmt.setString(14, null);
}
else
{
		pstmt.setString(14, perceroObject.getScorecard().getID());
}


if (perceroObject.getScorecardMeasure() == null)
{
pstmt.setString(15, null);
}
else
{
		pstmt.setString(15, perceroObject.getScorecardMeasure().getID());
}


if (perceroObject.getScorecardMonthlyScore() == null)
{
pstmt.setString(16, null);
}
else
{
		pstmt.setString(16, perceroObject.getScorecardMonthlyScore().getID());
}


if (perceroObject.getGoal() == null)
{
pstmt.setString(17, null);
}
else
{
		pstmt.setString(17, perceroObject.getGoal().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(ScorecardWeeklyScore perceroObject, PreparedStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
		
	}
	
	@Override
	protected void setCallableStatmentInsertParams(ScorecardWeeklyScore perceroObject, CallableStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	

	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(ScorecardWeeklyScore perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getEmployeeId());
pstmt.setString(2, perceroObject.getIntervalType());
pstmt.setDate(3, DateUtils.utilDateToSqlDate(perceroObject.getCreatedOn()));
pstmt.setDate(4, DateUtils.utilDateToSqlDate(perceroObject.getEndDate()));
pstmt.setDate(5, DateUtils.utilDateToSqlDate(perceroObject.getStartDate()));
pstmt.setDate(6, DateUtils.utilDateToSqlDate(perceroObject.getUpdatedOn()));
JdbcHelper.setDouble(pstmt,7, perceroObject.getPointsPossible());
JdbcHelper.setDouble(pstmt,8, perceroObject.getPointsReceived());
JdbcHelper.setDouble(pstmt,9, perceroObject.getScore());
JdbcHelper.setInt(pstmt,10, perceroObject.getGrade());

if (perceroObject.getAgent() == null)
{
pstmt.setString(11, null);
}
else
{
		pstmt.setString(11, perceroObject.getAgent().getID());
}


if (perceroObject.getPreviousScorecardWeeklyScore() == null)
{
pstmt.setString(12, null);
}
else
{
		pstmt.setString(12, perceroObject.getPreviousScorecardWeeklyScore().getID());
}


if (perceroObject.getScorecard() == null)
{
pstmt.setString(13, null);
}
else
{
		pstmt.setString(13, perceroObject.getScorecard().getID());
}


if (perceroObject.getScorecardMeasure() == null)
{
pstmt.setString(14, null);
}
else
{
		pstmt.setString(14, perceroObject.getScorecardMeasure().getID());
}


if (perceroObject.getScorecardMonthlyScore() == null)
{
pstmt.setString(15, null);
}
else
{
		pstmt.setString(15, perceroObject.getScorecardMonthlyScore().getID());
}


if (perceroObject.getGoal() == null)
{
pstmt.setString(16, null);
}
else
{
		pstmt.setString(16, perceroObject.getGoal().getID());
}

pstmt.setString(17, perceroObject.getID());

		
	}
	
	
	@Override
	protected void setCallableStatmentUpdateParams(ScorecardWeeklyScore perceroObject, CallableStatement pstmt) throws SQLException 
	{
		
		//must be in same order as insert
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	}
	
	

	@Override
	public List<ScorecardWeeklyScore> findByExample(ScorecardWeeklyScore theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useEmployeeId = StringUtils.hasText(theQueryObject.getEmployeeId()) && (excludeProperties == null || !excludeProperties.contains("employeeId"));

if (useEmployeeId)
{
sql += " WHERE ";
sql += " \"EMPLOYEE_ID\" =? ";
paramValues.add(theQueryObject.getEmployeeId());
propertyCounter++;
}

boolean useIntervalType = StringUtils.hasText(theQueryObject.getIntervalType()) && (excludeProperties == null || !excludeProperties.contains("intervalType"));

if (useIntervalType)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"INTERVAL_TYPE\" =? ";
paramValues.add(theQueryObject.getIntervalType());
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

boolean useEndDate = theQueryObject.getEndDate() != null && (excludeProperties == null || !excludeProperties.contains("endDate"));

if (useEndDate)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"END_DATE\" =? ";
paramValues.add(theQueryObject.getEndDate());
propertyCounter++;
}

boolean useStartDate = theQueryObject.getStartDate() != null && (excludeProperties == null || !excludeProperties.contains("startDate"));

if (useStartDate)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"START_DATE\" =? ";
paramValues.add(theQueryObject.getStartDate());
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

boolean usePointsPossible = theQueryObject.getPointsPossible() != null && (excludeProperties == null || !excludeProperties.contains("pointsPossible"));

if (usePointsPossible)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"POINTS_POSSIBLE\" =? ";
paramValues.add(theQueryObject.getPointsPossible());
propertyCounter++;
}

boolean usePointsReceived = theQueryObject.getPointsReceived() != null && (excludeProperties == null || !excludeProperties.contains("pointsReceived"));

if (usePointsReceived)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"POINTS_RECEIVED\" =? ";
paramValues.add(theQueryObject.getPointsReceived());
propertyCounter++;
}

boolean useScore = theQueryObject.getScore() != null && (excludeProperties == null || !excludeProperties.contains("score"));

if (useScore)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"SCORE\" =? ";
paramValues.add(theQueryObject.getScore());
propertyCounter++;
}

boolean useGrade = theQueryObject.getGrade() != null && (excludeProperties == null || !excludeProperties.contains("grade"));

if (useGrade)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"GRADE\" =? ";
paramValues.add(theQueryObject.getGrade());
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

boolean usePreviousScorecardWeeklyScoreID = theQueryObject.getPreviousScorecardWeeklyScore() != null && (excludeProperties == null || !excludeProperties.contains("previousScorecardWeeklyScore"));

if (usePreviousScorecardWeeklyScoreID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"PREV_SCARD_WEEKLY_SCORE_ID\" =? ";
paramValues.add(theQueryObject.getPreviousScorecardWeeklyScore().getID());
propertyCounter++;
}

boolean useScorecardID = theQueryObject.getScorecard() != null && (excludeProperties == null || !excludeProperties.contains("scorecard"));

if (useScorecardID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"SCORECARD_ID\" =? ";
paramValues.add(theQueryObject.getScorecard().getID());
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

boolean useScorecardMonthlyScoreID = theQueryObject.getScorecardMonthlyScore() != null && (excludeProperties == null || !excludeProperties.contains("scorecardMonthlyScore"));

if (useScorecardMonthlyScoreID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"SCORECARD_MONTHLY_SCORE_ID\" =? ";
paramValues.add(theQueryObject.getScorecardMonthlyScore().getID());
propertyCounter++;
}

boolean useGoalID = theQueryObject.getGoal() != null && (excludeProperties == null || !excludeProperties.contains("goal"));

if (useGoalID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"GOAL_ID\" =? ";
paramValues.add(theQueryObject.getGoal().getID());
propertyCounter++;
}



		if (propertyCounter == 0) {
			throw new SyncException(SyncException.METHOD_UNSUPPORTED, SyncException.METHOD_UNSUPPORTED_CODE);
		}
		
		return executeSelectWithParams(sql, paramValues.toArray(), shellOnly);		
	}
	
	@Override
	protected String getUpdateCallableStatementSql() {
		return "{call UPDATE_SCORECARD_WEEKLY_SCORE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	}
	@Override
	protected String getInsertCallableStatementSql() {
		return "{call CREATE_SCORECARD_WEEKLY_SCORE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	}
	@Override
	protected String getDeleteCallableStatementSql() {
		return "{call Delete_SCORECARD_WEEKLY_SCORE(?)}";
	}
	
	
public ScorecardWeeklyScore createObject(ScorecardWeeklyScore perceroObject, String userId)
		throws SyncException {
	if ( !hasCreateAccess(BaseDataObject.toClassIdPair(perceroObject), userId) ) {
		return null;
	}

	long timeStart = System.currentTimeMillis();

	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	String query = "Select SCORECARD_WEEKLY_SCORE_SEQ.NEXTVAL from dual";
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
