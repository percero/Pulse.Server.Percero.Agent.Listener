

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
public class ScorecardMonthlyResultDAO extends SqlDataAccessObject<ScorecardMonthlyResult> implements IDataAccessObject<ScorecardMonthlyResult> {

	static final Logger log = Logger.getLogger(ScorecardMonthlyResultDAO.class);

	
	public ScorecardMonthlyResultDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(ScorecardMonthlyResult.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	
	public static final String SHELL_ONLY_SELECT = "\"SCARD_MONTHLY_RESULT\".\"ID\"";
	public static final String SQL_VIEW = ",\"SCARD_MONTHLY_RESULT\".\"EMPLOYEE_ID\",\"SCARD_MONTHLY_RESULT\".\"INTERVAL_TYPE\",\"SCARD_MONTHLY_RESULT\".\"METRIC_TYPE\",\"SCARD_MONTHLY_RESULT\".\"METRIC_UNIT\",\"SCARD_MONTHLY_RESULT\".\"END_DATE\",\"SCARD_MONTHLY_RESULT\".\"START_DATE\",\"SCARD_MONTHLY_RESULT\".\"METRIC_RESULT\",\"SCARD_MONTHLY_RESULT\".\"PERCENTAGE_ATTAINMENT\",\"SCARD_MONTHLY_RESULT\".\"POINTS_POSSIBLE\",\"SCARD_MONTHLY_RESULT\".\"POINTS_RECEIVED\",\"SCARD_MONTHLY_RESULT\".\"EXCLUDED\",\"SCARD_MONTHLY_RESULT\".\"GRADE\",\"SCARD_MONTHLY_RESULT\".\"ROLLUP_TYPE\",\"SCARD_MONTHLY_RESULT\".\"TENURE\",\"SCARD_MONTHLY_RESULT\".\"AGENT_ID\",\"SCARD_MONTHLY_RESULT\".\"PREV_SCARD_MONTHLY_RESULT_ID\",\"SCARD_MONTHLY_RESULT\".\"SCORECARD_ID\",\"SCARD_MONTHLY_RESULT\".\"SCORECARD_MEASURE_ID\",\"SCARD_MONTHLY_RESULT\".\"GOAL_ID\"";
	private String selectFromStatementTableName = " FROM \"SCARD_MONTHLY_RESULT\" \"SCARD_MONTHLY_RESULT\"";
	private String whereClause = "  WHERE \"SCARD_MONTHLY_RESULT\".\"ID\"=?";
	private String whereInClause = "  join table(sys.dbms_debug_vc2coll(?)) SQLLIST on \"SCARD_MONTHLY_RESULT\".\"ID\"= SQLLIST.column_value";
	private String orderByTableName = "  ORDER BY \"SCARD_MONTHLY_RESULT\".\"ID\"";
	
	

	
	@Override
	protected String getConnectionFactoryName() {
		return ScorecardMonthlyResultDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT " + SHELL_ONLY_SELECT +  " " + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT \"SCARD_MONTHLY_RESULT\".\"ID\"" + SQL_VIEW  + selectFromStatementTableName + whereClause;
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
		return "SELECT \"SCARD_MONTHLY_RESULT\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName  + orderByTableName;
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT \"SCARD_MONTHLY_RESULT\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + orderByTableName + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() 
	{
		return "SELECT COUNT(ID) " + selectFromStatementTableName;
	}
	
	@Override
	protected String getSelectInStarSQL() 
	{
		return "SELECT \"SCARD_MONTHLY_RESULT\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + whereInClause;
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName + whereInClause;
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		
		return "SELECT \"SCARD_MONTHLY_RESULT\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + " WHERE \"SCARD_MONTHLY_RESULT\"." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) 
	{
		
		return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName + " WHERE \"SCARD_MONTHLY_RESULT\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName;
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT \"SCARD_MONTHLY_RESULT\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName;
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO TBL_SCARD_MONTHLY_RESULT (\"ID\",\"EMPLOYEE_ID\",\"INTERVAL_TYPE\",\"METRIC_TYPE\",\"METRIC_UNIT\",\"END_DATE\",\"START_DATE\",\"METRIC_RESULT\",\"PERCENTAGE_ATTAINMENT\",\"POINTS_POSSIBLE\",\"POINTS_RECEIVED\",\"EXCLUDED\",\"GRADE\",\"ROLLUP_TYPE\",\"TENURE\",\"AGENT_ID\",\"PREV_SCARD_MONTHLY_RESULT_ID\",\"SCORECARD_ID\",\"SCORECARD_MEASURE_ID\",\"GOAL_ID\") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE TBL_SCARD_MONTHLY_RESULT SET \"EMPLOYEE_ID\"=?,\"INTERVAL_TYPE\"=?,\"METRIC_TYPE\"=?,\"METRIC_UNIT\"=?,\"END_DATE\"=?,\"START_DATE\"=?,\"METRIC_RESULT\"=?,\"PERCENTAGE_ATTAINMENT\"=?,\"POINTS_POSSIBLE\"=?,\"POINTS_RECEIVED\"=?,\"EXCLUDED\"=?,\"GRADE\"=?,\"ROLLUP_TYPE\"=?,\"TENURE\"=?,\"AGENT_ID\"=?,\"PREV_SCARD_MONTHLY_RESULT_ID\"=?,\"SCORECARD_ID\"=?,\"SCORECARD_MEASURE_ID\"=?,\"GOAL_ID\"=? WHERE \"ID\"=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM TBL_SCARD_MONTHLY_RESULT WHERE \"ID\"=?";
	}
	
	@Override
	protected ScorecardMonthlyResult extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	
		

ScorecardMonthlyResult nextResult = null;
    	
		    	
    	if (nextResult == null) {
    		nextResult = new ScorecardMonthlyResult();
    	}

		
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setEmployeeId(rs.getString("EMPLOYEE_ID"));


nextResult.setIntervalType(rs.getString("INTERVAL_TYPE"));


nextResult.setMetricType(rs.getString("METRIC_TYPE"));


nextResult.setMetricUnit(rs.getString("METRIC_UNIT"));


nextResult.setEndDate(DateUtils.utilDateFromSqlTimestamp(rs.getTimestamp("END_DATE")));


nextResult.setStartDate(DateUtils.utilDateFromSqlTimestamp(rs.getTimestamp("START_DATE")));


nextResult.setMetricResult(rs.getDouble("METRIC_RESULT"));


nextResult.setPercentageAttainment(rs.getDouble("PERCENTAGE_ATTAINMENT"));


nextResult.setPointsPossible(rs.getDouble("POINTS_POSSIBLE"));


nextResult.setPointsReceived(rs.getDouble("POINTS_RECEIVED"));


nextResult.setExcluded(rs.getInt("EXCLUDED"));


nextResult.setGrade(rs.getInt("GRADE"));


nextResult.setRollupType(rs.getInt("ROLLUP_TYPE"));


nextResult.setTenure(rs.getInt("TENURE"));


String agentID = rs.getString("AGENT_ID");
if (StringUtils.hasText(agentID)) {
Agent agent = new Agent();
agent.setID(agentID);
nextResult.setAgent(agent);
}


String previousscorecardmonthlyresultID = rs.getString("PREV_SCARD_MONTHLY_RESULT_ID");
if (StringUtils.hasText(previousscorecardmonthlyresultID)) {
ScorecardMonthlyResult previousscorecardmonthlyresult = new ScorecardMonthlyResult();
previousscorecardmonthlyresult.setID(previousscorecardmonthlyresultID);
nextResult.setPreviousScorecardMonthlyResult(previousscorecardmonthlyresult);
}


String scorecardID = rs.getString("SCORECARD_ID");
if (StringUtils.hasText(scorecardID)) {
Scorecard scorecard = new Scorecard();
scorecard.setID(scorecardID);
nextResult.setScorecard(scorecard);
}


String scorecardmeasureID = rs.getString("SCORECARD_MEASURE_ID");
if (StringUtils.hasText(scorecardmeasureID)) {
ScorecardMeasure scorecardmeasure = new ScorecardMeasure();
scorecardmeasure.setID(scorecardmeasureID);
nextResult.setScorecardMeasure(scorecardmeasure);
}


String goalID = rs.getString("GOAL_ID");
if (StringUtils.hasText(goalID)) {
Goal goal = new Goal();
goal.setID(goalID);
nextResult.setGoal(goal);
}



			
    	}
		
		
    	return nextResult;
	}
	
	protected void setBaseStatmentInsertParams(ScorecardMonthlyResult perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getEmployeeId());
pstmt.setString(3, perceroObject.getIntervalType());
pstmt.setString(4, perceroObject.getMetricType());
pstmt.setString(5, perceroObject.getMetricUnit());
pstmt.setDate(6, DateUtils.utilDateToSqlDate(perceroObject.getEndDate()));
pstmt.setDate(7, DateUtils.utilDateToSqlDate(perceroObject.getStartDate()));
JdbcHelper.setDouble(pstmt,8, perceroObject.getMetricResult());
JdbcHelper.setDouble(pstmt,9, perceroObject.getPercentageAttainment());
JdbcHelper.setDouble(pstmt,10, perceroObject.getPointsPossible());
JdbcHelper.setDouble(pstmt,11, perceroObject.getPointsReceived());
JdbcHelper.setInt(pstmt,12, perceroObject.getExcluded());
JdbcHelper.setInt(pstmt,13, perceroObject.getGrade());
JdbcHelper.setInt(pstmt,14, perceroObject.getRollupType());
JdbcHelper.setInt(pstmt,15, perceroObject.getTenure());

if (perceroObject.getAgent() == null)
{
pstmt.setString(16, null);
}
else
{
		pstmt.setString(16, perceroObject.getAgent().getID());
}


if (perceroObject.getPreviousScorecardMonthlyResult() == null)
{
pstmt.setString(17, null);
}
else
{
		pstmt.setString(17, perceroObject.getPreviousScorecardMonthlyResult().getID());
}


if (perceroObject.getScorecard() == null)
{
pstmt.setString(18, null);
}
else
{
		pstmt.setString(18, perceroObject.getScorecard().getID());
}


if (perceroObject.getScorecardMeasure() == null)
{
pstmt.setString(19, null);
}
else
{
		pstmt.setString(19, perceroObject.getScorecardMeasure().getID());
}


if (perceroObject.getGoal() == null)
{
pstmt.setString(20, null);
}
else
{
		pstmt.setString(20, perceroObject.getGoal().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(ScorecardMonthlyResult perceroObject, PreparedStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
		
	}
	
	@Override
	protected void setCallableStatmentInsertParams(ScorecardMonthlyResult perceroObject, CallableStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	

	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(ScorecardMonthlyResult perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getEmployeeId());
pstmt.setString(2, perceroObject.getIntervalType());
pstmt.setString(3, perceroObject.getMetricType());
pstmt.setString(4, perceroObject.getMetricUnit());
pstmt.setDate(5, DateUtils.utilDateToSqlDate(perceroObject.getEndDate()));
pstmt.setDate(6, DateUtils.utilDateToSqlDate(perceroObject.getStartDate()));
JdbcHelper.setDouble(pstmt,7, perceroObject.getMetricResult());
JdbcHelper.setDouble(pstmt,8, perceroObject.getPercentageAttainment());
JdbcHelper.setDouble(pstmt,9, perceroObject.getPointsPossible());
JdbcHelper.setDouble(pstmt,10, perceroObject.getPointsReceived());
JdbcHelper.setInt(pstmt,11, perceroObject.getExcluded());
JdbcHelper.setInt(pstmt,12, perceroObject.getGrade());
JdbcHelper.setInt(pstmt,13, perceroObject.getRollupType());
JdbcHelper.setInt(pstmt,14, perceroObject.getTenure());

if (perceroObject.getAgent() == null)
{
pstmt.setString(15, null);
}
else
{
		pstmt.setString(15, perceroObject.getAgent().getID());
}


if (perceroObject.getPreviousScorecardMonthlyResult() == null)
{
pstmt.setString(16, null);
}
else
{
		pstmt.setString(16, perceroObject.getPreviousScorecardMonthlyResult().getID());
}


if (perceroObject.getScorecard() == null)
{
pstmt.setString(17, null);
}
else
{
		pstmt.setString(17, perceroObject.getScorecard().getID());
}


if (perceroObject.getScorecardMeasure() == null)
{
pstmt.setString(18, null);
}
else
{
		pstmt.setString(18, perceroObject.getScorecardMeasure().getID());
}


if (perceroObject.getGoal() == null)
{
pstmt.setString(19, null);
}
else
{
		pstmt.setString(19, perceroObject.getGoal().getID());
}

pstmt.setString(20, perceroObject.getID());

		
	}
	
	
	@Override
	protected void setCallableStatmentUpdateParams(ScorecardMonthlyResult perceroObject, CallableStatement pstmt) throws SQLException 
	{
		
		//must be in same order as insert
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	}
	
	

	@Override
	public List<ScorecardMonthlyResult> findByExample(ScorecardMonthlyResult theQueryObject,
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

boolean useMetricType = StringUtils.hasText(theQueryObject.getMetricType()) && (excludeProperties == null || !excludeProperties.contains("metricType"));

if (useMetricType)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"METRIC_TYPE\" =? ";
paramValues.add(theQueryObject.getMetricType());
propertyCounter++;
}

boolean useMetricUnit = StringUtils.hasText(theQueryObject.getMetricUnit()) && (excludeProperties == null || !excludeProperties.contains("metricUnit"));

if (useMetricUnit)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"METRIC_UNIT\" =? ";
paramValues.add(theQueryObject.getMetricUnit());
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

boolean useMetricResult = theQueryObject.getMetricResult() != null && (excludeProperties == null || !excludeProperties.contains("metricResult"));

if (useMetricResult)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"METRIC_RESULT\" =? ";
paramValues.add(theQueryObject.getMetricResult());
propertyCounter++;
}

boolean usePercentageAttainment = theQueryObject.getPercentageAttainment() != null && (excludeProperties == null || !excludeProperties.contains("percentageAttainment"));

if (usePercentageAttainment)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"PERCENTAGE_ATTAINMENT\" =? ";
paramValues.add(theQueryObject.getPercentageAttainment());
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

boolean useExcluded = theQueryObject.getExcluded() != null && (excludeProperties == null || !excludeProperties.contains("excluded"));

if (useExcluded)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"EXCLUDED\" =? ";
paramValues.add(theQueryObject.getExcluded());
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

boolean useRollupType = theQueryObject.getRollupType() != null && (excludeProperties == null || !excludeProperties.contains("rollupType"));

if (useRollupType)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"ROLLUP_TYPE\" =? ";
paramValues.add(theQueryObject.getRollupType());
propertyCounter++;
}

boolean useTenure = theQueryObject.getTenure() != null && (excludeProperties == null || !excludeProperties.contains("tenure"));

if (useTenure)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"TENURE\" =? ";
paramValues.add(theQueryObject.getTenure());
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

boolean usePreviousScorecardMonthlyResultID = theQueryObject.getPreviousScorecardMonthlyResult() != null && (excludeProperties == null || !excludeProperties.contains("previousScorecardMonthlyResult"));

if (usePreviousScorecardMonthlyResultID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"PREV_SCARD_MONTHLY_RESULT_ID\" =? ";
paramValues.add(theQueryObject.getPreviousScorecardMonthlyResult().getID());
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
		return "{call UPDATE_SCARD_MONTHLY_RESULT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	}
	@Override
	protected String getInsertCallableStatementSql() {
		return "{call CREATE_SCARD_MONTHLY_RESULT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	}
	@Override
	protected String getDeleteCallableStatementSql() {
		return "{call Delete_SCARD_MONTHLY_RESULT(?)}";
	}
	
	

public ScorecardMonthlyResult createObject(ScorecardMonthlyResult perceroObject, String userId)
		throws SyncException {
	if ( !hasCreateAccess(BaseDataObject.toClassIdPair(perceroObject), userId) ) {
		return null;
	}

	long timeStart = System.currentTimeMillis();

	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	String query = "Select SCARD_MONTHLY_RESULT_SEQ.NEXTVAL from dual";
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

