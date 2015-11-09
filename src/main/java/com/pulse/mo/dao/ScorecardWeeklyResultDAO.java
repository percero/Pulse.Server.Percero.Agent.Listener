

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
	
	public static final String SHELL_ONLY_SELECT = "DISTINCT \"SCARD_WEEKLY_RESULT\".\"ID\"";
	public static final String SQL_VIEW = ",\"SCARD_WEEKLY_RESULT\".\"IS_COACHABLE\",\"SCARD_WEEKLY_RESULT\".\"UPDATED_ON\",\"SCARD_WEEKLY_RESULT\".\"TENURE\",\"SCARD_WEEKLY_RESULT\".\"EMPLOYEE_ID\",\"SCARD_WEEKLY_RESULT\".\"IS_REQUIRED\",\"SCARD_WEEKLY_RESULT\".\"CREATED_ON\",\"SCARD_WEEKLY_RESULT\".\"END_DATE\",\"SCARD_WEEKLY_RESULT\".\"START_DATE\",\"SCARD_WEEKLY_RESULT\".\"WEEK_DATE\",\"SCARD_WEEKLY_RESULT\".\"PERCENTAGE_ATTAINMENT\",\"SCARD_WEEKLY_RESULT\".\"POINTS_POSSIBLE\",\"SCARD_WEEKLY_RESULT\".\"POINTS_RECEIVED\",\"SCARD_WEEKLY_RESULT\".\"RESULT\",\"SCARD_WEEKLY_RESULT\".\"DURATION_FROM\",\"SCARD_WEEKLY_RESULT\".\"DURATION_TO\",\"SCARD_WEEKLY_RESULT\".\"EXCLUDED\",\"SCARD_WEEKLY_RESULT\".\"GOAL_TYPE\",\"SCARD_WEEKLY_RESULT\".\"GRADE\",\"SCARD_WEEKLY_RESULT\".\"ROLLUP_TYPE\",\"SCARD_WEEKLY_RESULT\".\"GOAL_ID\",\"SCARD_WEEKLY_RESULT\".\"PREV_SCARD_WEEKLY_RESULT_ID\",\"SCARD_WEEKLY_RESULT\".\"SCORECARD_ID\",\"SCARD_WEEKLY_RESULT\".\"SCORECARD_MEASURE_ID\",\"SCARD_WEEKLY_RESULT\".\"SCORECARD_MONTHLY_RESULT_ID\",\"SCARD_WEEKLY_RESULT\".\"AGENT_ID\",\"SCARD_WEEKLY_RESULT\".\"AGENT_SCORECARD_ID\"";
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
		return "SELECT " + SHELL_ONLY_SELECT +  " " + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT \"SCARD_WEEKLY_RESULT\".\"ID\"" + SQL_VIEW  + selectFromStatementTableName + whereClause;
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
		return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName + whereInClause;
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

		return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName + " WHERE \"SCARD_WEEKLY_RESULT\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName;
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT \"SCARD_WEEKLY_RESULT\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName;
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO TBL_SCARD_WEEKLY_RESULT (\"ID\",\"IS_COACHABLE\",\"UPDATED_ON\",\"TENURE\",\"EMPLOYEE_ID\",\"IS_REQUIRED\",\"CREATED_ON\",\"END_DATE\",\"START_DATE\",\"WEEK_DATE\",\"PERCENTAGE_ATTAINMENT\",\"POINTS_POSSIBLE\",\"POINTS_RECEIVED\",\"RESULT\",\"DURATION_FROM\",\"DURATION_TO\",\"EXCLUDED\",\"GOAL_TYPE\",\"GRADE\",\"ROLLUP_TYPE\",\"GOAL_ID\",\"PREV_SCARD_WEEKLY_RESULT_ID\",\"SCORECARD_ID\",\"SCORECARD_MEASURE_ID\",\"SCORECARD_MONTHLY_RESULT_ID\",\"AGENT_ID\",\"AGENT_SCORECARD_ID\") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE TBL_SCARD_WEEKLY_RESULT SET \"IS_COACHABLE\"=?,\"UPDATED_ON\"=?,\"TENURE\"=?,\"EMPLOYEE_ID\"=?,\"IS_REQUIRED\"=?,\"CREATED_ON\"=?,\"END_DATE\"=?,\"START_DATE\"=?,\"WEEK_DATE\"=?,\"PERCENTAGE_ATTAINMENT\"=?,\"POINTS_POSSIBLE\"=?,\"POINTS_RECEIVED\"=?,\"RESULT\"=?,\"DURATION_FROM\"=?,\"DURATION_TO\"=?,\"EXCLUDED\"=?,\"GOAL_TYPE\"=?,\"GRADE\"=?,\"ROLLUP_TYPE\"=?,\"GOAL_ID\"=?,\"PREV_SCARD_WEEKLY_RESULT_ID\"=?,\"SCORECARD_ID\"=?,\"SCORECARD_MEASURE_ID\"=?,\"SCORECARD_MONTHLY_RESULT_ID\"=?,\"AGENT_ID\"=?,\"AGENT_SCORECARD_ID\"=? WHERE \"ID\"=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM TBL_SCARD_WEEKLY_RESULT WHERE \"ID\"=?";
	}
	
	@Override
	protected ScorecardWeeklyResult extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	
		

ScorecardWeeklyResult nextResult = null;
    	
		    	
    	if (nextResult == null) {
    		nextResult = new ScorecardWeeklyResult();
    	}

		
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setIsCoachable(rs.getBoolean("IS_COACHABLE"));


nextResult.setUpdatedOn(rs.getString("UPDATED_ON"));


nextResult.setTenure(rs.getInt("TENURE"));


nextResult.setEmployeeId(rs.getString("EMPLOYEE_ID"));


nextResult.setIsRequired(rs.getBoolean("IS_REQUIRED"));


nextResult.setCreatedOn(DateUtils.utilDateFromSqlTimestamp(rs.getTimestamp("CREATED_ON")));


nextResult.setEndDate(DateUtils.utilDateFromSqlTimestamp(rs.getTimestamp("END_DATE")));


nextResult.setStartDate(DateUtils.utilDateFromSqlTimestamp(rs.getTimestamp("START_DATE")));


nextResult.setWeekDate(DateUtils.utilDateFromSqlTimestamp(rs.getTimestamp("WEEK_DATE")));


nextResult.setPercentageAttainment(rs.getDouble("PERCENTAGE_ATTAINMENT"));


nextResult.setPointsPossible(rs.getDouble("POINTS_POSSIBLE"));


nextResult.setPointsReceived(rs.getDouble("POINTS_RECEIVED"));


nextResult.setResult(rs.getDouble("RESULT"));


nextResult.setDurationFrom(rs.getInt("DURATION_FROM"));


nextResult.setDurationTo(rs.getInt("DURATION_TO"));


nextResult.setExcluded(rs.getInt("EXCLUDED"));


nextResult.setGoalType(rs.getInt("GOAL_TYPE"));


nextResult.setGrade(rs.getInt("GRADE"));


nextResult.setRollupType(rs.getInt("ROLLUP_TYPE"));


String goalID = rs.getString("GOAL_ID");
if (StringUtils.hasText(goalID)) {
Goal goal = new Goal();
goal.setID(goalID);
nextResult.setGoal(goal);
}


String previousscorecardweeklyresultID = rs.getString("PREV_SCARD_WEEKLY_RESULT_ID");
if (StringUtils.hasText(previousscorecardweeklyresultID)) {
ScorecardWeeklyResult previousscorecardweeklyresult = new ScorecardWeeklyResult();
previousscorecardweeklyresult.setID(previousscorecardweeklyresultID);
nextResult.setPreviousScorecardWeeklyResult(previousscorecardweeklyresult);
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


String scorecardmonthlyresultID = rs.getString("SCORECARD_MONTHLY_RESULT_ID");
if (StringUtils.hasText(scorecardmonthlyresultID)) {
ScorecardMonthlyResult scorecardmonthlyresult = new ScorecardMonthlyResult();
scorecardmonthlyresult.setID(scorecardmonthlyresultID);
nextResult.setScorecardMonthlyResult(scorecardmonthlyresult);
}


String agentID = rs.getString("AGENT_ID");
if (StringUtils.hasText(agentID)) {
Agent agent = new Agent();
agent.setID(agentID);
nextResult.setAgent(agent);
}


String agentscorecardID = rs.getString("AGENT_SCORECARD_ID");
if (StringUtils.hasText(agentscorecardID)) {
AgentScorecard agentscorecard = new AgentScorecard();
agentscorecard.setID(agentscorecardID);
nextResult.setAgentScorecard(agentscorecard);
}



			
    	}
		
		
    	return nextResult;
	}
	
	protected void setBaseStatmentInsertParams(ScorecardWeeklyResult perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
JdbcHelper.setBoolean(pstmt,2, perceroObject.getIsCoachable());
pstmt.setString(3, perceroObject.getUpdatedOn());
JdbcHelper.setInt(pstmt,4, perceroObject.getTenure());
pstmt.setString(5, perceroObject.getEmployeeId());
JdbcHelper.setBoolean(pstmt,6, perceroObject.getIsRequired());
pstmt.setDate(7, DateUtils.utilDateToSqlDate(perceroObject.getCreatedOn()));
pstmt.setDate(8, DateUtils.utilDateToSqlDate(perceroObject.getEndDate()));
pstmt.setDate(9, DateUtils.utilDateToSqlDate(perceroObject.getStartDate()));
pstmt.setDate(10, DateUtils.utilDateToSqlDate(perceroObject.getWeekDate()));
JdbcHelper.setDouble(pstmt,11, perceroObject.getPercentageAttainment());
JdbcHelper.setDouble(pstmt,12, perceroObject.getPointsPossible());
JdbcHelper.setDouble(pstmt,13, perceroObject.getPointsReceived());
JdbcHelper.setDouble(pstmt,14, perceroObject.getResult());
JdbcHelper.setInt(pstmt,15, perceroObject.getDurationFrom());
JdbcHelper.setInt(pstmt,16, perceroObject.getDurationTo());
JdbcHelper.setInt(pstmt,17, perceroObject.getExcluded());
JdbcHelper.setInt(pstmt,18, perceroObject.getGoalType());
JdbcHelper.setInt(pstmt,19, perceroObject.getGrade());
JdbcHelper.setInt(pstmt,20, perceroObject.getRollupType());

if (perceroObject.getGoal() == null)
{
pstmt.setString(21, null);
}
else
{
		pstmt.setString(21, perceroObject.getGoal().getID());
}


if (perceroObject.getPreviousScorecardWeeklyResult() == null)
{
pstmt.setString(22, null);
}
else
{
		pstmt.setString(22, perceroObject.getPreviousScorecardWeeklyResult().getID());
}


if (perceroObject.getScorecard() == null)
{
pstmt.setString(23, null);
}
else
{
		pstmt.setString(23, perceroObject.getScorecard().getID());
}


if (perceroObject.getScorecardMeasure() == null)
{
pstmt.setString(24, null);
}
else
{
		pstmt.setString(24, perceroObject.getScorecardMeasure().getID());
}


if (perceroObject.getScorecardMonthlyResult() == null)
{
pstmt.setString(25, null);
}
else
{
		pstmt.setString(25, perceroObject.getScorecardMonthlyResult().getID());
}


if (perceroObject.getAgent() == null)
{
pstmt.setString(26, null);
}
else
{
		pstmt.setString(26, perceroObject.getAgent().getID());
}


if (perceroObject.getAgentScorecard() == null)
{
pstmt.setString(27, null);
}
else
{
		pstmt.setString(27, perceroObject.getAgentScorecard().getID());
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
		
		JdbcHelper.setBoolean(pstmt,1, perceroObject.getIsCoachable());
pstmt.setString(2, perceroObject.getUpdatedOn());
JdbcHelper.setInt(pstmt,3, perceroObject.getTenure());
pstmt.setString(4, perceroObject.getEmployeeId());
JdbcHelper.setBoolean(pstmt,5, perceroObject.getIsRequired());
pstmt.setDate(6, DateUtils.utilDateToSqlDate(perceroObject.getCreatedOn()));
pstmt.setDate(7, DateUtils.utilDateToSqlDate(perceroObject.getEndDate()));
pstmt.setDate(8, DateUtils.utilDateToSqlDate(perceroObject.getStartDate()));
pstmt.setDate(9, DateUtils.utilDateToSqlDate(perceroObject.getWeekDate()));
JdbcHelper.setDouble(pstmt,10, perceroObject.getPercentageAttainment());
JdbcHelper.setDouble(pstmt,11, perceroObject.getPointsPossible());
JdbcHelper.setDouble(pstmt,12, perceroObject.getPointsReceived());
JdbcHelper.setDouble(pstmt,13, perceroObject.getResult());
JdbcHelper.setInt(pstmt,14, perceroObject.getDurationFrom());
JdbcHelper.setInt(pstmt,15, perceroObject.getDurationTo());
JdbcHelper.setInt(pstmt,16, perceroObject.getExcluded());
JdbcHelper.setInt(pstmt,17, perceroObject.getGoalType());
JdbcHelper.setInt(pstmt,18, perceroObject.getGrade());
JdbcHelper.setInt(pstmt,19, perceroObject.getRollupType());

if (perceroObject.getGoal() == null)
{
pstmt.setString(20, null);
}
else
{
		pstmt.setString(20, perceroObject.getGoal().getID());
}


if (perceroObject.getPreviousScorecardWeeklyResult() == null)
{
pstmt.setString(21, null);
}
else
{
		pstmt.setString(21, perceroObject.getPreviousScorecardWeeklyResult().getID());
}


if (perceroObject.getScorecard() == null)
{
pstmt.setString(22, null);
}
else
{
		pstmt.setString(22, perceroObject.getScorecard().getID());
}


if (perceroObject.getScorecardMeasure() == null)
{
pstmt.setString(23, null);
}
else
{
		pstmt.setString(23, perceroObject.getScorecardMeasure().getID());
}


if (perceroObject.getScorecardMonthlyResult() == null)
{
pstmt.setString(24, null);
}
else
{
		pstmt.setString(24, perceroObject.getScorecardMonthlyResult().getID());
}


if (perceroObject.getAgent() == null)
{
pstmt.setString(25, null);
}
else
{
		pstmt.setString(25, perceroObject.getAgent().getID());
}


if (perceroObject.getAgentScorecard() == null)
{
pstmt.setString(26, null);
}
else
{
		pstmt.setString(26, perceroObject.getAgentScorecard().getID());
}

pstmt.setString(27, perceroObject.getID());

		
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
		
		boolean useIsCoachable = theQueryObject.getIsCoachable() != null && (excludeProperties == null || !excludeProperties.contains("isCoachable"));

if (useIsCoachable)
{
sql += " WHERE ";
sql += " \"IS_COACHABLE\" =? ";
paramValues.add(theQueryObject.getIsCoachable());
propertyCounter++;
}

boolean useUpdatedOn = StringUtils.hasText(theQueryObject.getUpdatedOn()) && (excludeProperties == null || !excludeProperties.contains("updatedOn"));

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

boolean useIsRequired = theQueryObject.getIsRequired() != null && (excludeProperties == null || !excludeProperties.contains("isRequired"));

if (useIsRequired)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"IS_REQUIRED\" =? ";
paramValues.add(theQueryObject.getIsRequired());
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

boolean usePreviousScorecardWeeklyResultID = theQueryObject.getPreviousScorecardWeeklyResult() != null && (excludeProperties == null || !excludeProperties.contains("previousScorecardWeeklyResult"));

if (usePreviousScorecardWeeklyResultID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"PREV_SCARD_WEEKLY_RESULT_ID\" =? ";
paramValues.add(theQueryObject.getPreviousScorecardWeeklyResult().getID());
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

boolean useScorecardMonthlyResultID = theQueryObject.getScorecardMonthlyResult() != null && (excludeProperties == null || !excludeProperties.contains("scorecardMonthlyResult"));

if (useScorecardMonthlyResultID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"SCORECARD_MONTHLY_RESULT_ID\" =? ";
paramValues.add(theQueryObject.getScorecardMonthlyResult().getID());
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



		if (propertyCounter == 0) {
			throw new SyncException(SyncException.METHOD_UNSUPPORTED, SyncException.METHOD_UNSUPPORTED_CODE);
		}
		
		return executeSelectWithParams(sql, paramValues.toArray(), shellOnly);		
	}
	
	@Override
	protected String getUpdateCallableStatementSql() {
		return "{call UPDATE_SCARD_WEEKLY_RESULT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	}
	@Override
	protected String getInsertCallableStatementSql() {
		return "{call CREATE_SCARD_WEEKLY_RESULT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	}
	@Override
	protected String getDeleteCallableStatementSql() {
		return "{call Delete_SCARD_WEEKLY_RESULT(?)}";
	}
	
	

public ScorecardWeeklyResult createObject(ScorecardWeeklyResult perceroObject, String userId)
		throws SyncException {
	if ( !hasCreateAccess(BaseDataObject.toClassIdPair(perceroObject), userId) ) {
		return null;
	}

	long timeStart = System.currentTimeMillis();

	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	String query = "Select SCARD_WEEKLY_RESULT_SEQ.NEXTVAL from dual";
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

