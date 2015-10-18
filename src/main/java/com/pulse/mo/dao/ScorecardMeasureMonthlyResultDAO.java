

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
public class ScorecardMeasureMonthlyResultDAO extends SqlDataAccessObject<ScorecardMeasureMonthlyResult> implements IDataAccessObject<ScorecardMeasureMonthlyResult> {

	static final Logger log = Logger.getLogger(ScorecardMeasureMonthlyResultDAO.class);

	
	public ScorecardMeasureMonthlyResultDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(ScorecardMeasureMonthlyResult.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	
	public static final String SQL_VIEW = ",\"SCARD_MEASURE_MONTHLY_RESULT\".\"EMPLOYEE_ID\",\"SCARD_MEASURE_MONTHLY_RESULT\".\"INTERVAL_TYPE\",\"SCARD_MEASURE_MONTHLY_RESULT\".\"METRIC_TYPE\",\"SCARD_MEASURE_MONTHLY_RESULT\".\"METRIC_UNIT\",\"SCARD_MEASURE_MONTHLY_RESULT\".\"SCORECARD_ID\",\"SCARD_MEASURE_MONTHLY_RESULT\".\"END_DATE\",\"SCARD_MEASURE_MONTHLY_RESULT\".\"START_DATE\",\"SCARD_MEASURE_MONTHLY_RESULT\".\"METRIC_RESULT\",\"SCARD_MEASURE_MONTHLY_RESULT\".\"PERCENTAGE_ATTAINMENT\",\"SCARD_MEASURE_MONTHLY_RESULT\".\"POINTS_POSSIBLE\",\"SCARD_MEASURE_MONTHLY_RESULT\".\"POINTS_RECEIVED\",\"SCARD_MEASURE_MONTHLY_RESULT\".\"EXCLUDED\",\"SCARD_MEASURE_MONTHLY_RESULT\".\"GRADE\",\"SCARD_MEASURE_MONTHLY_RESULT\".\"ROLLUP_TYPE\",\"SCARD_MEASURE_MONTHLY_RESULT\".\"SCM_GOAL_ID\",\"SCARD_MEASURE_MONTHLY_RESULT\".\"TENURE\",\"SCARD_MEASURE_MONTHLY_RESULT\".\"AGENT_SCORECARD_ID\",\"SCARD_MEASURE_MONTHLY_RESULT\".\"SCORECARD_MEASURE_ID\"";
	private String selectFromStatementTableName = " FROM \"SCARD_MEASURE_MONTHLY_RESULT\" \"SCARD_MEASURE_MONTHLY_RESULT\"";
	private String whereClause = "  WHERE \"SCARD_MEASURE_MONTHLY_RESULT\".\"ID\"=?";
	private String whereInClause = "  join table(sys.dbms_debug_vc2coll(?)) SQLLIST on \"SCARD_MEASURE_MONTHLY_RESULT\".\"ID\"= SQLLIST.column_value";
	private String orderByTableName = "  ORDER BY \"SCARD_MEASURE_MONTHLY_RESULT\".\"ID\"";
	
	private String joinAgentScorecardIDScorecardMeasureMonthlyResult = ",(select ? As SQLID From Dual) WHERE SCARD_MEASURE_MONTHLY_RESULT.EMPLOYEE_ID= SUBSTR(SQLID,0,9) AND SCARD_MEASURE_MONTHLY_RESULT.SCORECARD_ID=SUBSTR(SQLID,INSTR(SQLID,'-', 1, 1) + 1,INSTR(SQLID,'-', 1, 2)-INSTR(SQLID,'-', 1, 1)-1)AND SCARD_MEASURE_MONTHLY_RESULT.END_DATE<= SUBSTR(SQLID,INSTR(SQLID,'-', 1, 2) + 1,10) AND SCARD_MEASURE_MONTHLY_RESULT.START_DATE>= SUBSTR(SQLID,INSTR(SQLID,'-', 1, 2) + 1,10)";


	
	@Override
	protected String getConnectionFactoryName() {
		return ScorecardMeasureMonthlyResultDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT \"SCARD_MEASURE_MONTHLY_RESULT\".\"ID\" " + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT \"SCARD_MEASURE_MONTHLY_RESULT\".\"ID\"" + SQL_VIEW  + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT \"SCARD_MEASURE_MONTHLY_RESULT\".\"ID\" " + selectFromStatementTableName +  orderByTableName;
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT \"SCARD_MEASURE_MONTHLY_RESULT\".\"ID\" " + selectFromStatementTableName  +  orderByTableName  + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT \"SCARD_MEASURE_MONTHLY_RESULT\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName  + orderByTableName;
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT \"SCARD_MEASURE_MONTHLY_RESULT\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + orderByTableName + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() 
	{
		return "SELECT COUNT(ID) " + selectFromStatementTableName;
	}
	
	@Override
	protected String getSelectInStarSQL() 
	{
		return "SELECT \"SCARD_MEASURE_MONTHLY_RESULT\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + whereInClause;
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT \"SCARD_MEASURE_MONTHLY_RESULT\".\"ID\" " + selectFromStatementTableName + whereInClause;
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		if (joinColumnName.equalsIgnoreCase("\"AGENT_SCORECARD_ID\""))
{
return "SELECT \"SCARD_MEASURE_MONTHLY_RESULT\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + joinAgentScorecardIDScorecardMeasureMonthlyResult;
}

		return "SELECT \"SCARD_MEASURE_MONTHLY_RESULT\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + " WHERE \"SCARD_MEASURE_MONTHLY_RESULT\"." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) 
	{
		if (joinColumnName.equalsIgnoreCase("\"AGENT_SCORECARD_ID\""))
{
return "SELECT \"SCARD_MEASURE_MONTHLY_RESULT\".\"ID\" " + selectFromStatementTableName + joinAgentScorecardIDScorecardMeasureMonthlyResult;
}

		return "SELECT \"SCARD_MEASURE_MONTHLY_RESULT\".\"ID\" " + selectFromStatementTableName + " WHERE \"SCARD_MEASURE_MONTHLY_RESULT\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT \"SCARD_MEASURE_MONTHLY_RESULT\".\"ID\" " + selectFromStatementTableName;
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT \"SCARD_MEASURE_MONTHLY_RESULT\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName;
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO TBL_SCARD_MEASURE_MONTHLY_RESULT (\"ID\",\"EMPLOYEE_ID\",\"INTERVAL_TYPE\",\"METRIC_TYPE\",\"METRIC_UNIT\",\"SCORECARD_ID\",\"END_DATE\",\"START_DATE\",\"METRIC_RESULT\",\"PERCENTAGE_ATTAINMENT\",\"POINTS_POSSIBLE\",\"POINTS_RECEIVED\",\"EXCLUDED\",\"GRADE\",\"ROLLUP_TYPE\",\"SCM_GOAL_ID\",\"TENURE\",\"AGENT_SCORECARD_ID\",\"SCORECARD_MEASURE_ID\") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE TBL_SCARD_MEASURE_MONTHLY_RESULT SET \"EMPLOYEE_ID\"=?,\"INTERVAL_TYPE\"=?,\"METRIC_TYPE\"=?,\"METRIC_UNIT\"=?,\"SCORECARD_ID\"=?,\"END_DATE\"=?,\"START_DATE\"=?,\"METRIC_RESULT\"=?,\"PERCENTAGE_ATTAINMENT\"=?,\"POINTS_POSSIBLE\"=?,\"POINTS_RECEIVED\"=?,\"EXCLUDED\"=?,\"GRADE\"=?,\"ROLLUP_TYPE\"=?,\"SCM_GOAL_ID\"=?,\"TENURE\"=?,\"AGENT_SCORECARD_ID\"=?,\"SCORECARD_MEASURE_ID\"=? WHERE \"ID\"=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM TBL_SCARD_MEASURE_MONTHLY_RESULT WHERE \"ID\"=?";
	}
	
	@Override
	protected ScorecardMeasureMonthlyResult extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	ScorecardMeasureMonthlyResult nextResult = new ScorecardMeasureMonthlyResult();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setEmployeeId(rs.getString("EMPLOYEE_ID"));

nextResult.setIntervalType(rs.getString("INTERVAL_TYPE"));

nextResult.setMetricType(rs.getString("METRIC_TYPE"));

nextResult.setMetricUnit(rs.getString("METRIC_UNIT"));

nextResult.setScorecardId(rs.getString("SCORECARD_ID"));

nextResult.setEndDate(rs.getDate("END_DATE"));

nextResult.setStartDate(rs.getDate("START_DATE"));

nextResult.setMetricResult(rs.getDouble("METRIC_RESULT"));

nextResult.setPercentageAttainment(rs.getDouble("PERCENTAGE_ATTAINMENT"));

nextResult.setPointsPossible(rs.getDouble("POINTS_POSSIBLE"));

nextResult.setPointsReceived(rs.getDouble("POINTS_RECEIVED"));

nextResult.setExcluded(rs.getInt("EXCLUDED"));

nextResult.setGrade(rs.getInt("GRADE"));

nextResult.setRollupType(rs.getInt("ROLLUP_TYPE"));

nextResult.setSCMGoalId(rs.getInt("SCM_GOAL_ID"));

nextResult.setTenure(rs.getInt("TENURE"));

AgentScorecard agentscorecard = new AgentScorecard();
agentscorecard.setID(rs.getString("AGENT_SCORECARD_ID"));
nextResult.setAgentScorecard(agentscorecard);

ScorecardMeasure scorecardmeasure = new ScorecardMeasure();
scorecardmeasure.setID(rs.getString("SCORECARD_MEASURE_ID"));
nextResult.setScorecardMeasure(scorecardmeasure);


			
    	}
    	
    	return nextResult;
	}
	
	protected void setBaseStatmentInsertParams(ScorecardMeasureMonthlyResult perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getEmployeeId());
pstmt.setString(3, perceroObject.getIntervalType());
pstmt.setString(4, perceroObject.getMetricType());
pstmt.setString(5, perceroObject.getMetricUnit());
pstmt.setString(6, perceroObject.getScorecardId());
pstmt.setDate(7, DateUtils.utilDateToSqlDate(perceroObject.getEndDate()));
pstmt.setDate(8, DateUtils.utilDateToSqlDate(perceroObject.getStartDate()));
pstmt.setDouble(9, perceroObject.getMetricResult());
pstmt.setDouble(10, perceroObject.getPercentageAttainment());
pstmt.setDouble(11, perceroObject.getPointsPossible());
pstmt.setDouble(12, perceroObject.getPointsReceived());
pstmt.setInt(13, perceroObject.getExcluded());
pstmt.setInt(14, perceroObject.getGrade());
pstmt.setInt(15, perceroObject.getRollupType());
pstmt.setInt(16, perceroObject.getSCMGoalId());
pstmt.setInt(17, perceroObject.getTenure());

if (perceroObject.getAgentScorecard() == null)
{
pstmt.setString(18, null);
}
else
{
		pstmt.setString(18, perceroObject.getAgentScorecard().getID());
}


if (perceroObject.getScorecardMeasure() == null)
{
pstmt.setString(19, null);
}
else
{
		pstmt.setString(19, perceroObject.getScorecardMeasure().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(ScorecardMeasureMonthlyResult perceroObject, PreparedStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
		
	}
	
	@Override
	protected void setCallableStatmentInsertParams(ScorecardMeasureMonthlyResult perceroObject, CallableStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	

	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(ScorecardMeasureMonthlyResult perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getEmployeeId());
pstmt.setString(2, perceroObject.getIntervalType());
pstmt.setString(3, perceroObject.getMetricType());
pstmt.setString(4, perceroObject.getMetricUnit());
pstmt.setString(5, perceroObject.getScorecardId());
pstmt.setDate(6, DateUtils.utilDateToSqlDate(perceroObject.getEndDate()));
pstmt.setDate(7, DateUtils.utilDateToSqlDate(perceroObject.getStartDate()));
pstmt.setDouble(8, perceroObject.getMetricResult());
pstmt.setDouble(9, perceroObject.getPercentageAttainment());
pstmt.setDouble(10, perceroObject.getPointsPossible());
pstmt.setDouble(11, perceroObject.getPointsReceived());
pstmt.setInt(12, perceroObject.getExcluded());
pstmt.setInt(13, perceroObject.getGrade());
pstmt.setInt(14, perceroObject.getRollupType());
pstmt.setInt(15, perceroObject.getSCMGoalId());
pstmt.setInt(16, perceroObject.getTenure());

if (perceroObject.getAgentScorecard() == null)
{
pstmt.setString(17, null);
}
else
{
		pstmt.setString(17, perceroObject.getAgentScorecard().getID());
}


if (perceroObject.getScorecardMeasure() == null)
{
pstmt.setString(18, null);
}
else
{
		pstmt.setString(18, perceroObject.getScorecardMeasure().getID());
}

pstmt.setString(19, perceroObject.getID());

		
	}
	
	
	@Override
	protected void setCallableStatmentUpdateParams(ScorecardMeasureMonthlyResult perceroObject, CallableStatement pstmt) throws SQLException 
	{
		
		//must be in same order as insert
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	}
	
	

	@Override
	public List<ScorecardMeasureMonthlyResult> findByExample(ScorecardMeasureMonthlyResult theQueryObject,
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

boolean useScorecardId = StringUtils.hasText(theQueryObject.getScorecardId()) && (excludeProperties == null || !excludeProperties.contains("scorecardId"));

if (useScorecardId)
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
paramValues.add(theQueryObject.getScorecardId());
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

boolean useSCMGoalId = theQueryObject.getSCMGoalId() != null && (excludeProperties == null || !excludeProperties.contains("sCMGoalId"));

if (useSCMGoalId)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"SCM_GOAL_ID\" =? ";
paramValues.add(theQueryObject.getSCMGoalId());
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

boolean useAgentScorecardID = theQueryObject.getAgentScorecard() != null && (excludeProperties == null || !excludeProperties.contains("agentScorecard"));

if (useAgentScorecardID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"AGENT_SCORECARD_ID\" =? ";
paramValues.add(theQueryObject.getAgentScorecard().getID());
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



		if (propertyCounter == 0) {
			throw new SyncException(SyncException.METHOD_UNSUPPORTED, SyncException.METHOD_UNSUPPORTED_CODE);
		}
		
		return executeSelectWithParams(sql, paramValues.toArray(), shellOnly);		
	}
	
	@Override
	protected String getUpdateCallableStatementSql() {
		return "{call UPDATE_SCARD_MEASURE_MONTHLY_RESULT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	}
	@Override
	protected String getInsertCallableStatementSql() {
		return "{call CREATE_SCARD_MEASURE_MONTHLY_RESULT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	}
	@Override
	protected String getDeleteCallableStatementSql() {
		return "{call Delete_SCARD_MEASURE_MONTHLY_RESULT(?)}";
	}
	
	
	
	
}

