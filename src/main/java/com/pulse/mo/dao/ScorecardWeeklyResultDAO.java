
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
public class ScorecardWeeklyResultDAO extends SqlDataAccessObject<ScorecardWeeklyResult> implements IDataAccessObject<ScorecardWeeklyResult> {

	static final Logger log = Logger.getLogger(ScorecardWeeklyResultDAO.class);

	
	public ScorecardWeeklyResultDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(ScorecardWeeklyResult.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	
	public static final String SQL_VIEW = ",\"SCARD_WEEKLY_RESULT\".\"UPDATED_BY\",\"SCARD_WEEKLY_RESULT\".\"CREATED_BY\",\"SCARD_WEEKLY_RESULT\".\"EMPLOYEE_ID\",\"SCARD_WEEKLY_RESULT\".\"CREATED_ON\",\"SCARD_WEEKLY_RESULT\".\"UPDATED_ON\",\"SCARD_WEEKLY_RESULT\".\"WEEK_DATE\",\"SCARD_WEEKLY_RESULT\".\"PERCENTAGE_ATTAINMENT\",\"SCARD_WEEKLY_RESULT\".\"POINTS_POSSIBLE\",\"SCARD_WEEKLY_RESULT\".\"POINTS_RECEIVED\",\"SCARD_WEEKLY_RESULT\".\"RESULT\",\"SCARD_WEEKLY_RESULT\".\"DURATION_FROM\",\"SCARD_WEEKLY_RESULT\".\"DURATION_TO\",\"SCARD_WEEKLY_RESULT\".\"EXCLUDED\",\"SCARD_WEEKLY_RESULT\".\"GOAL_TYPE\",\"SCARD_WEEKLY_RESULT\".\"GRADE\",\"SCARD_WEEKLY_RESULT\".\"QUARTILE\",\"SCARD_WEEKLY_RESULT\".\"ROLLUP_TYPE\",\"SCARD_WEEKLY_RESULT\".\"AGENT_SCORECARD_ID\",\"SCARD_WEEKLY_RESULT\".\"GOAL_ID\",\"SCARD_WEEKLY_RESULT\".\"PREV1SCRMNTHRESULT\",\"SCARD_WEEKLY_RESULT\".\"PREV2SCRMNTHRESULT\",\"SCARD_WEEKLY_RESULT\".\"PREV3SCRMNTHRESULT\",\"SCARD_WEEKLY_RESULT\".\"SCORECARD_MEASURE_ID\",\"SCARD_WEEKLY_RESULT\".\"CRSCRMNTHRESULT\"";
	private String selectFromStatementTableName = " FROM \"SCARD_WEEKLY_RESULT\" \"SCARD_WEEKLY_RESULT\"";
	private String whereClause = "  WHERE \"SCARD_WEEKLY_RESULT\".\"ID\"=?";
	private String whereInClause = "  join table(sys.dbms_debug_vc2coll(?)) SQLLIST on \"SCARD_WEEKLY_RESULT\".\"ID\"= SQLLIST.column_value";
	private String orderByTableName = "  ORDER BY \"SCARD_WEEKLY_RESULT\".\"ID\"";
	
	private String joinAgentScorecardIDScorecardWeeklyResult = ",(select ? As SQLID From Dual) WHERE SCARD_WEEKLY_RESULT.EMPLOYEE_ID= SUBSTR(SQLID,0,9) AND SCARD_WEEKLY_RESULT.SCORECARD_ID=SUBSTR(SQLID,INSTR(SQLID,'-', 1, 1) + 1,INSTR(SQLID,'-', 1, 2)-INSTR(SQLID,'-', 1, 1)-1) AND SCARD_WEEKLY_RESULT.WEEK_DATE= SUBSTR(SQLID,INSTR(SQLID,'-', 1, 2) + 1,10)";


	
	@Override
	protected String getConnectionFactoryName() {
		return ScorecardWeeklyResultDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT \"SCARD_WEEKLY_RESULT\".\"ID\" " + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT \"SCARD_WEEKLY_RESULT\".\"ID\"" + SQL_VIEW  + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT \"SCARD_WEEKLY_RESULT\".\"ID\" " + selectFromStatementTableName +  orderByTableName;
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT \"SCARD_WEEKLY_RESULT\".\"ID\" " + selectFromStatementTableName  +  orderByTableName  + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT \"SCARD_WEEKLY_RESULT\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName  + orderByTableName;
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT \"SCARD_WEEKLY_RESULT\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + orderByTableName + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() 
	{
		return "SELECT COUNT(ID) " + selectFromStatementTableName;
	}
	
	@Override
	protected String getSelectInStarSQL() 
	{
		return "SELECT \"SCARD_WEEKLY_RESULT\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + whereInClause;
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT \"SCARD_WEEKLY_RESULT\".\"ID\" " + selectFromStatementTableName + whereInClause;
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		if (joinColumnName.equalsIgnoreCase("\"AGENT_SCORECARD_ID\""))
{
return "SELECT \"SCARD_WEEKLY_RESULT\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + joinAgentScorecardIDScorecardWeeklyResult;
}

		return "SELECT \"SCARD_WEEKLY_RESULT\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + " WHERE \"SCARD_WEEKLY_RESULT\"." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) 
	{
		if (joinColumnName.equalsIgnoreCase("\"AGENT_SCORECARD_ID\""))
{
return "SELECT \"SCARD_WEEKLY_RESULT\".\"ID\" " + selectFromStatementTableName + joinAgentScorecardIDScorecardWeeklyResult;
}

		return "SELECT \"SCARD_WEEKLY_RESULT\".\"ID\" " + selectFromStatementTableName + " WHERE \"SCARD_WEEKLY_RESULT\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT \"SCARD_WEEKLY_RESULT\".\"ID\" " + selectFromStatementTableName;
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT \"SCARD_WEEKLY_RESULT\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName;
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO TBL_SCARD_WEEKLY_RESULT (\"ID\",\"UPDATED_BY\",\"CREATED_BY\",\"EMPLOYEE_ID\",\"CREATED_ON\",\"UPDATED_ON\",\"WEEK_DATE\",\"PERCENTAGE_ATTAINMENT\",\"POINTS_POSSIBLE\",\"POINTS_RECEIVED\",\"RESULT\",\"DURATION_FROM\",\"DURATION_TO\",\"EXCLUDED\",\"GOAL_TYPE\",\"GRADE\",\"QUARTILE\",\"ROLLUP_TYPE\",\"AGENT_SCORECARD_ID\",\"GOAL_ID\",\"PREV1SCRMNTHRESULT\",\"PREV2SCRMNTHRESULT\",\"PREV3SCRMNTHRESULT\",\"SCORECARD_MEASURE_ID\",\"CRSCRMNTHRESULT\") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE TBL_SCARD_WEEKLY_RESULT SET \"UPDATED_BY\"=?,\"CREATED_BY\"=?,\"EMPLOYEE_ID\"=?,\"CREATED_ON\"=?,\"UPDATED_ON\"=?,\"WEEK_DATE\"=?,\"PERCENTAGE_ATTAINMENT\"=?,\"POINTS_POSSIBLE\"=?,\"POINTS_RECEIVED\"=?,\"RESULT\"=?,\"DURATION_FROM\"=?,\"DURATION_TO\"=?,\"EXCLUDED\"=?,\"GOAL_TYPE\"=?,\"GRADE\"=?,\"QUARTILE\"=?,\"ROLLUP_TYPE\"=?,\"AGENT_SCORECARD_ID\"=?,\"GOAL_ID\"=?,\"PREV1SCRMNTHRESULT\"=?,\"PREV2SCRMNTHRESULT\"=?,\"PREV3SCRMNTHRESULT\"=?,\"SCORECARD_MEASURE_ID\"=?,\"CRSCRMNTHRESULT\"=? WHERE \"ID\"=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM TBL_SCARD_WEEKLY_RESULT WHERE \"ID\"=?";
	}
	
	@Override
	protected ScorecardWeeklyResult extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	ScorecardWeeklyResult nextResult = new ScorecardWeeklyResult();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setUpdatedBy(rs.getString("UPDATED_BY"));

nextResult.setCreatedBy(rs.getString("CREATED_BY"));

nextResult.setEmployeeId(rs.getString("EMPLOYEE_ID"));

nextResult.setCreatedOn(rs.getDate("CREATED_ON"));

nextResult.setUpdatedOn(rs.getDate("UPDATED_ON"));

nextResult.setWeekDate(rs.getDate("WEEK_DATE"));

nextResult.setPercentageAttainment(rs.getDouble("PERCENTAGE_ATTAINMENT"));

nextResult.setPointsPossible(rs.getDouble("POINTS_POSSIBLE"));

nextResult.setPointsReceived(rs.getDouble("POINTS_RECEIVED"));

nextResult.setResult(rs.getDouble("RESULT"));

nextResult.setDurationFrom(rs.getInt("DURATION_FROM"));

nextResult.setDurationTo(rs.getInt("DURATION_TO"));

nextResult.setExcluded(rs.getInt("EXCLUDED"));

nextResult.setGoalType(rs.getInt("GOAL_TYPE"));

nextResult.setGrade(rs.getInt("GRADE"));

nextResult.setQuartile(rs.getInt("QUARTILE"));

nextResult.setRollupType(rs.getInt("ROLLUP_TYPE"));

AgentScorecard agentscorecard = new AgentScorecard();
agentscorecard.setID(rs.getString("AGENT_SCORECARD_ID"));
nextResult.setAgentScorecard(agentscorecard);

Goal goal = new Goal();
goal.setID(rs.getString("GOAL_ID"));
nextResult.setGoal(goal);

ScorecardMonthlyResult previous1scorecardmonthlyresult = new ScorecardMonthlyResult();
previous1scorecardmonthlyresult.setID(rs.getString("PREV1SCRMNTHRESULT"));
nextResult.setPrevious1ScorecardMonthlyResult(previous1scorecardmonthlyresult);

ScorecardMonthlyResult previous2scorecardmonthlyresult = new ScorecardMonthlyResult();
previous2scorecardmonthlyresult.setID(rs.getString("PREV2SCRMNTHRESULT"));
nextResult.setPrevious2ScorecardMonthlyResult(previous2scorecardmonthlyresult);

ScorecardMonthlyResult previous3scorecardmonthlyresult = new ScorecardMonthlyResult();
previous3scorecardmonthlyresult.setID(rs.getString("PREV3SCRMNTHRESULT"));
nextResult.setPrevious3ScorecardMonthlyResult(previous3scorecardmonthlyresult);

ScorecardMeasure scorecardmeasure = new ScorecardMeasure();
scorecardmeasure.setID(rs.getString("SCORECARD_MEASURE_ID"));
nextResult.setScorecardMeasure(scorecardmeasure);

ScorecardMonthlyResult currentscorecardmonthlyresult = new ScorecardMonthlyResult();
currentscorecardmonthlyresult.setID(rs.getString("CRSCRMNTHRESULT"));
nextResult.setCurrentScorecardMonthlyResult(currentscorecardmonthlyresult);


			
    	}
    	
    	return nextResult;
	}
	
	protected void setBaseStatmentInsertParams(ScorecardWeeklyResult perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getUpdatedBy());
pstmt.setString(3, perceroObject.getCreatedBy());
pstmt.setString(4, perceroObject.getEmployeeId());
pstmt.setDate(5, DateUtils.utilDateToSqlDate(perceroObject.getCreatedOn()));
pstmt.setDate(6, DateUtils.utilDateToSqlDate(perceroObject.getUpdatedOn()));
pstmt.setDate(7, DateUtils.utilDateToSqlDate(perceroObject.getWeekDate()));
JdbcHelper.setDouble(pstmt,8, perceroObject.getPercentageAttainment());
JdbcHelper.setDouble(pstmt,9, perceroObject.getPointsPossible());
JdbcHelper.setDouble(pstmt,10, perceroObject.getPointsReceived());
JdbcHelper.setDouble(pstmt,11, perceroObject.getResult());
JdbcHelper.setInt(pstmt,12, perceroObject.getDurationFrom());
JdbcHelper.setInt(pstmt,13, perceroObject.getDurationTo());
JdbcHelper.setInt(pstmt,14, perceroObject.getExcluded());
JdbcHelper.setInt(pstmt,15, perceroObject.getGoalType());
JdbcHelper.setInt(pstmt,16, perceroObject.getGrade());
JdbcHelper.setInt(pstmt,17, perceroObject.getQuartile());
JdbcHelper.setInt(pstmt,18, perceroObject.getRollupType());

if (perceroObject.getAgentScorecard() == null)
{
pstmt.setString(19, null);
}
else
{
		pstmt.setString(19, perceroObject.getAgentScorecard().getID());
}


if (perceroObject.getGoal() == null)
{
pstmt.setString(20, null);
}
else
{
		pstmt.setString(20, perceroObject.getGoal().getID());
}


if (perceroObject.getPrevious1ScorecardMonthlyResult() == null)
{
pstmt.setString(21, null);
}
else
{
		pstmt.setString(21, perceroObject.getPrevious1ScorecardMonthlyResult().getID());
}


if (perceroObject.getPrevious2ScorecardMonthlyResult() == null)
{
pstmt.setString(22, null);
}
else
{
		pstmt.setString(22, perceroObject.getPrevious2ScorecardMonthlyResult().getID());
}


if (perceroObject.getPrevious3ScorecardMonthlyResult() == null)
{
pstmt.setString(23, null);
}
else
{
		pstmt.setString(23, perceroObject.getPrevious3ScorecardMonthlyResult().getID());
}


if (perceroObject.getScorecardMeasure() == null)
{
pstmt.setString(24, null);
}
else
{
		pstmt.setString(24, perceroObject.getScorecardMeasure().getID());
}


if (perceroObject.getCurrentScorecardMonthlyResult() == null)
{
pstmt.setString(25, null);
}
else
{
		pstmt.setString(25, perceroObject.getCurrentScorecardMonthlyResult().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(ScorecardWeeklyResult perceroObject, PreparedStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
		
	}
	
	@Override
	protected void setCallableStatmentInsertParams(ScorecardWeeklyResult perceroObject, CallableStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	

	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(ScorecardWeeklyResult perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getUpdatedBy());
pstmt.setString(2, perceroObject.getCreatedBy());
pstmt.setString(3, perceroObject.getEmployeeId());
pstmt.setDate(4, DateUtils.utilDateToSqlDate(perceroObject.getCreatedOn()));
pstmt.setDate(5, DateUtils.utilDateToSqlDate(perceroObject.getUpdatedOn()));
pstmt.setDate(6, DateUtils.utilDateToSqlDate(perceroObject.getWeekDate()));
JdbcHelper.setDouble(pstmt,7, perceroObject.getPercentageAttainment());
JdbcHelper.setDouble(pstmt,8, perceroObject.getPointsPossible());
JdbcHelper.setDouble(pstmt,9, perceroObject.getPointsReceived());
JdbcHelper.setDouble(pstmt,10, perceroObject.getResult());
JdbcHelper.setInt(pstmt,11, perceroObject.getDurationFrom());
JdbcHelper.setInt(pstmt,12, perceroObject.getDurationTo());
JdbcHelper.setInt(pstmt,13, perceroObject.getExcluded());
JdbcHelper.setInt(pstmt,14, perceroObject.getGoalType());
JdbcHelper.setInt(pstmt,15, perceroObject.getGrade());
JdbcHelper.setInt(pstmt,16, perceroObject.getQuartile());
JdbcHelper.setInt(pstmt,17, perceroObject.getRollupType());

if (perceroObject.getAgentScorecard() == null)
{
pstmt.setString(18, null);
}
else
{
		pstmt.setString(18, perceroObject.getAgentScorecard().getID());
}


if (perceroObject.getGoal() == null)
{
pstmt.setString(19, null);
}
else
{
		pstmt.setString(19, perceroObject.getGoal().getID());
}


if (perceroObject.getPrevious1ScorecardMonthlyResult() == null)
{
pstmt.setString(20, null);
}
else
{
		pstmt.setString(20, perceroObject.getPrevious1ScorecardMonthlyResult().getID());
}


if (perceroObject.getPrevious2ScorecardMonthlyResult() == null)
{
pstmt.setString(21, null);
}
else
{
		pstmt.setString(21, perceroObject.getPrevious2ScorecardMonthlyResult().getID());
}


if (perceroObject.getPrevious3ScorecardMonthlyResult() == null)
{
pstmt.setString(22, null);
}
else
{
		pstmt.setString(22, perceroObject.getPrevious3ScorecardMonthlyResult().getID());
}


if (perceroObject.getScorecardMeasure() == null)
{
pstmt.setString(23, null);
}
else
{
		pstmt.setString(23, perceroObject.getScorecardMeasure().getID());
}


if (perceroObject.getCurrentScorecardMonthlyResult() == null)
{
pstmt.setString(24, null);
}
else
{
		pstmt.setString(24, perceroObject.getCurrentScorecardMonthlyResult().getID());
}

pstmt.setString(25, perceroObject.getID());

		
	}
	
	
	@Override
	protected void setCallableStatmentUpdateParams(ScorecardWeeklyResult perceroObject, CallableStatement pstmt) throws SQLException 
	{
		
		//must be in same order as insert
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	}
	
	

	@Override
	public List<ScorecardWeeklyResult> findByExample(ScorecardWeeklyResult theQueryObject,
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

boolean useEmployeeId = StringUtils.hasText(theQueryObject.getEmployeeId()) && (excludeProperties == null || !excludeProperties.contains("employeeId"));

if (useEmployeeId)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"EMPLOYEE_ID\" =? ";
paramValues.add(theQueryObject.getEmployeeId());
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

boolean useResult = theQueryObject.getResult() != null && (excludeProperties == null || !excludeProperties.contains("result"));

if (useResult)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"RESULT\" =? ";
paramValues.add(theQueryObject.getResult());
propertyCounter++;
}

boolean useDurationFrom = theQueryObject.getDurationFrom() != null && (excludeProperties == null || !excludeProperties.contains("durationFrom"));

if (useDurationFrom)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"DURATION_FROM\" =? ";
paramValues.add(theQueryObject.getDurationFrom());
propertyCounter++;
}

boolean useDurationTo = theQueryObject.getDurationTo() != null && (excludeProperties == null || !excludeProperties.contains("durationTo"));

if (useDurationTo)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"DURATION_TO\" =? ";
paramValues.add(theQueryObject.getDurationTo());
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

boolean useGoalType = theQueryObject.getGoalType() != null && (excludeProperties == null || !excludeProperties.contains("goalType"));

if (useGoalType)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"GOAL_TYPE\" =? ";
paramValues.add(theQueryObject.getGoalType());
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

boolean useQuartile = theQueryObject.getQuartile() != null && (excludeProperties == null || !excludeProperties.contains("quartile"));

if (useQuartile)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"QUARTILE\" =? ";
paramValues.add(theQueryObject.getQuartile());
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

boolean usePrevious1ScorecardMonthlyResultID = theQueryObject.getPrevious1ScorecardMonthlyResult() != null && (excludeProperties == null || !excludeProperties.contains("previous1ScorecardMonthlyResult"));

if (usePrevious1ScorecardMonthlyResultID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"PREV1SCRMNTHRESULT\" =? ";
paramValues.add(theQueryObject.getPrevious1ScorecardMonthlyResult().getID());
propertyCounter++;
}

boolean usePrevious2ScorecardMonthlyResultID = theQueryObject.getPrevious2ScorecardMonthlyResult() != null && (excludeProperties == null || !excludeProperties.contains("previous2ScorecardMonthlyResult"));

if (usePrevious2ScorecardMonthlyResultID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"PREV2SCRMNTHRESULT\" =? ";
paramValues.add(theQueryObject.getPrevious2ScorecardMonthlyResult().getID());
propertyCounter++;
}

boolean usePrevious3ScorecardMonthlyResultID = theQueryObject.getPrevious3ScorecardMonthlyResult() != null && (excludeProperties == null || !excludeProperties.contains("previous3ScorecardMonthlyResult"));

if (usePrevious3ScorecardMonthlyResultID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"PREV3SCRMNTHRESULT\" =? ";
paramValues.add(theQueryObject.getPrevious3ScorecardMonthlyResult().getID());
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

boolean useCurrentScorecardMonthlyResultID = theQueryObject.getCurrentScorecardMonthlyResult() != null && (excludeProperties == null || !excludeProperties.contains("currentScorecardMonthlyResult"));

if (useCurrentScorecardMonthlyResultID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"CRSCRMNTHRESULT\" =? ";
paramValues.add(theQueryObject.getCurrentScorecardMonthlyResult().getID());
propertyCounter++;
}



		if (propertyCounter == 0) {
			throw new SyncException(SyncException.METHOD_UNSUPPORTED, SyncException.METHOD_UNSUPPORTED_CODE);
		}
		
		return executeSelectWithParams(sql, paramValues.toArray(), shellOnly);		
	}
	
	@Override
	protected String getUpdateCallableStatementSql() {
		return "{call UPDATE_SCARD_WEEKLY_RESULT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	}
	@Override
	protected String getInsertCallableStatementSql() {
		return "{call CREATE_SCARD_WEEKLY_RESULT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	}
	@Override
	protected String getDeleteCallableStatementSql() {
		return "{call Delete_SCARD_WEEKLY_RESULT(?)}";
	}
	
	
	
	
}
