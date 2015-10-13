
package com.pulse.mo.dao;

import java.sql.PreparedStatement;
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
import com.pulse.mo.ScorecardMeasureWeeklyResult;
import com.pulse.mo.AgentScorecard;
import com.pulse.mo.ScorecardMeasure;

*/

@Component
public class ScorecardMeasureWeeklyResultDAO extends SqlDataAccessObject<ScorecardMeasureWeeklyResult> implements IDataAccessObject<ScorecardMeasureWeeklyResult> {

	static final Logger log = Logger.getLogger(ScorecardMeasureWeeklyResultDAO.class);

	
	public ScorecardMeasureWeeklyResultDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(ScorecardMeasureWeeklyResult.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	
	
	
	@Override
	protected String getConnectionFactoryName() {
		return ScorecardMeasureWeeklyResultDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT \"SCARD_MEASURE_WEEKLY_RESULT\".\"ID\" FROM \"SCARD_MEASURE_WEEKLY_RESULT\" \"SCARD_MEASURE_WEEKLY_RESULT\" WHERE \"SCARD_MEASURE_WEEKLY_RESULT\".\"ID\"=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT \"SCARD_MEASURE_WEEKLY_RESULT\".\"ID\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"PERCENTAGE_ATTAINMENT\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"POINTS_POSSIBLE\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"POINTS_RECEIVED\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"QUARTILE\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"RESULT\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"ROLLUP_TYPE\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"CREATED_BY\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"CREATED_ON\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"DURATION_FROM\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"DURATION_TO\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"EMPLOYEE_ID\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"EXCLUDED\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"GOAL\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"GOAL_ID\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"GOAL_TYPE\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"GRADE\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"UPDATED_BY\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"UPDATED_ON\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"WEEK_DATE\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"AGENT_SCORECARD_ID\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"SCORECARD_MEASURE_ID\" FROM \"SCARD_MEASURE_WEEKLY_RESULT\" \"SCARD_MEASURE_WEEKLY_RESULT\" WHERE \"SCARD_MEASURE_WEEKLY_RESULT\".\"ID\"=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT \"SCARD_MEASURE_WEEKLY_RESULT\".\"ID\" FROM \"SCARD_MEASURE_WEEKLY_RESULT\" \"SCARD_MEASURE_WEEKLY_RESULT\" ORDER BY \"ID\"";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT \"SCARD_MEASURE_WEEKLY_RESULT\".\"ID\" FROM \"SCARD_MEASURE_WEEKLY_RESULT\" \"SCARD_MEASURE_WEEKLY_RESULT\" ORDER BY \"SCARD_MEASURE_WEEKLY_RESULT\".\"ID\" LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT \"SCARD_MEASURE_WEEKLY_RESULT\".\"ID\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"PERCENTAGE_ATTAINMENT\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"POINTS_POSSIBLE\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"POINTS_RECEIVED\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"QUARTILE\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"RESULT\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"ROLLUP_TYPE\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"CREATED_BY\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"CREATED_ON\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"DURATION_FROM\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"DURATION_TO\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"EMPLOYEE_ID\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"EXCLUDED\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"GOAL\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"GOAL_ID\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"GOAL_TYPE\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"GRADE\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"UPDATED_BY\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"UPDATED_ON\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"WEEK_DATE\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"AGENT_SCORECARD_ID\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"SCORECARD_MEASURE_ID\" FROM \"SCARD_MEASURE_WEEKLY_RESULT\" \"SCARD_MEASURE_WEEKLY_RESULT\" ORDER BY \"SCARD_MEASURE_WEEKLY_RESULT\".\"ID\"";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT \"SCARD_MEASURE_WEEKLY_RESULT\".\"ID\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"PERCENTAGE_ATTAINMENT\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"POINTS_POSSIBLE\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"POINTS_RECEIVED\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"QUARTILE\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"RESULT\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"ROLLUP_TYPE\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"CREATED_BY\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"CREATED_ON\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"DURATION_FROM\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"DURATION_TO\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"EMPLOYEE_ID\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"EXCLUDED\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"GOAL\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"GOAL_ID\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"GOAL_TYPE\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"GRADE\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"UPDATED_BY\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"UPDATED_ON\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"WEEK_DATE\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"AGENT_SCORECARD_ID\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"SCORECARD_MEASURE_ID\" FROM \"SCARD_MEASURE_WEEKLY_RESULT\" \"SCARD_MEASURE_WEEKLY_RESULT\" ORDER BY \"SCARD_MEASURE_WEEKLY_RESULT\".\"ID\" LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM \"SCARD_MEASURE_WEEKLY_RESULT\" \"SCARD_MEASURE_WEEKLY_RESULT\"";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT \"SCARD_MEASURE_WEEKLY_RESULT\".\"ID\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"PERCENTAGE_ATTAINMENT\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"POINTS_POSSIBLE\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"POINTS_RECEIVED\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"QUARTILE\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"RESULT\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"ROLLUP_TYPE\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"CREATED_BY\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"CREATED_ON\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"DURATION_FROM\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"DURATION_TO\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"EMPLOYEE_ID\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"EXCLUDED\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"GOAL\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"GOAL_ID\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"GOAL_TYPE\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"GRADE\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"UPDATED_BY\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"UPDATED_ON\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"WEEK_DATE\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"AGENT_SCORECARD_ID\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"SCORECARD_MEASURE_ID\" FROM \"SCARD_MEASURE_WEEKLY_RESULT\" \"SCARD_MEASURE_WEEKLY_RESULT\" WHERE \"SCARD_MEASURE_WEEKLY_RESULT\".\"ID\" IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT \"SCARD_MEASURE_WEEKLY_RESULT\".\"ID\" FROM \"SCARD_MEASURE_WEEKLY_RESULT\" \"SCARD_MEASURE_WEEKLY_RESULT\" WHERE \"SCARD_MEASURE_WEEKLY_RESULT\".\"ID\" IN (?)";
	}

	private String selectAgentScorecardRelationshipFrom = " FROM \"SCARD_MEASURE_WEEKLY_RESULT\" \"SCARD_MEASURE_WEEKLY_RESULT\",(select ? as \"SQL_ID\" from dual) WHERE \"SCARD_MEASURE_WEEKLY_RESULT\".\"EMPLOYEE_ID\"= SUBSTR(\"SQL_ID\",0,9)   AND \"SCARD_MEASURE_WEEKLY_RESULT\".\"SCORECARD_ID\"=SUBSTR(\"SQL_ID\",INSTR(\"SQL_ID\",'-', 1, 1) + 1,INSTR(\"SQL_ID\",'-', 1, 2)-INSTR(\"SQL_ID\",'-', 1, 1)-1) AND \"SCARD_MEASURE_WEEKLY_RESULT\".\"WEEK_DATE\"= SUBSTR(\"SQL_ID\",INSTR(\"SQL_ID\",'-', 1, 2) + 1,10) ";
	
	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		if (joinColumnName.equalsIgnoreCase("\"AGENT_SCORECARD_ID\"")) {
			return "SELECT \"SCARD_MEASURE_WEEKLY_RESULT\".\"ID\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"PERCENTAGE_ATTAINMENT\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"POINTS_POSSIBLE\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"POINTS_RECEIVED\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"QUARTILE\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"RESULT\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"ROLLUP_TYPE\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"CREATED_BY\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"CREATED_ON\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"DURATION_FROM\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"DURATION_TO\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"EMPLOYEE_ID\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"EXCLUDED\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"GOAL\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"GOAL_ID\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"GOAL_TYPE\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"GRADE\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"UPDATED_BY\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"UPDATED_ON\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"WEEK_DATE\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"AGENT_SCORECARD_ID\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"SCORECARD_MEASURE_ID\" " + selectAgentScorecardRelationshipFrom ;
		}
		else {
			return "SELECT \"SCARD_MEASURE_WEEKLY_RESULT\".\"ID\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"PERCENTAGE_ATTAINMENT\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"POINTS_POSSIBLE\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"POINTS_RECEIVED\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"QUARTILE\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"RESULT\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"ROLLUP_TYPE\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"CREATED_BY\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"CREATED_ON\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"DURATION_FROM\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"DURATION_TO\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"EMPLOYEE_ID\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"EXCLUDED\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"GOAL\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"GOAL_ID\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"GOAL_TYPE\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"GRADE\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"UPDATED_BY\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"UPDATED_ON\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"WEEK_DATE\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"AGENT_SCORECARD_ID\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"SCORECARD_MEASURE_ID\" FROM \"SCARD_MEASURE_WEEKLY_RESULT\" \"SCARD_MEASURE_WEEKLY_RESULT\" WHERE \"SCARD_MEASURE_WEEKLY_RESULT\"." + joinColumnName + "=?";
		}
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		if (joinColumnName.equalsIgnoreCase("\"AGENT_SCORECARD_ID\"")) {
			return "SELECT \"SCARD_MEASURE_WEEKLY_RESULT\".\"ID\" " + selectAgentScorecardRelationshipFrom;
		}
		else {
			return "SELECT \"SCARD_MEASURE_WEEKLY_RESULT\".\"ID\" FROM \"SCARD_MEASURE_WEEKLY_RESULT\" \"SCARD_MEASURE_WEEKLY_RESULT\" WHERE \"SCARD_MEASURE_WEEKLY_RESULT\"." + joinColumnName + "=?";
		}
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT \"SCARD_MEASURE_WEEKLY_RESULT\".\"ID\" FROM \"SCARD_MEASURE_WEEKLY_RESULT\" \"SCARD_MEASURE_WEEKLY_RESULT\" ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT \"SCARD_MEASURE_WEEKLY_RESULT\".\"ID\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"PERCENTAGE_ATTAINMENT\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"POINTS_POSSIBLE\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"POINTS_RECEIVED\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"QUARTILE\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"RESULT\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"ROLLUP_TYPE\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"CREATED_BY\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"CREATED_ON\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"DURATION_FROM\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"DURATION_TO\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"EMPLOYEE_ID\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"EXCLUDED\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"GOAL\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"GOAL_ID\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"GOAL_TYPE\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"GRADE\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"UPDATED_BY\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"UPDATED_ON\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"WEEK_DATE\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"AGENT_SCORECARD_ID\",\"SCARD_MEASURE_WEEKLY_RESULT\".\"SCORECARD_MEASURE_ID\" FROM \"SCARD_MEASURE_WEEKLY_RESULT\" \"SCARD_MEASURE_WEEKLY_RESULT\" ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO SCARD_MEASURE_WEEKLY_RESULT (\"ID\",\"PERCENTAGE_ATTAINMENT\",\"POINTS_POSSIBLE\",\"POINTS_RECEIVED\",\"QUARTILE\",\"RESULT\",\"ROLLUP_TYPE\",\"CREATED_BY\",\"CREATED_ON\",\"DURATION_FROM\",\"DURATION_TO\",\"EMPLOYEE_ID\",\"EXCLUDED\",\"GOAL\",\"GOAL_ID\",\"GOAL_TYPE\",\"GRADE\",\"UPDATED_BY\",\"UPDATED_ON\",\"WEEK_DATE\",\"AGENT_SCORECARD_ID\",\"SCORECARD_MEASURE_ID\") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE \"SCARD_MEASURE_WEEKLY_RESULT\" SET \"PERCENTAGE_ATTAINMENT\"=?,\"POINTS_POSSIBLE\"=?,\"POINTS_RECEIVED\"=?,\"QUARTILE\"=?,\"RESULT\"=?,\"ROLLUP_TYPE\"=?,\"CREATED_BY\"=?,\"CREATED_ON\"=?,\"DURATION_FROM\"=?,\"DURATION_TO\"=?,\"EMPLOYEE_ID\"=?,\"EXCLUDED\"=?,\"GOAL\"=?,\"GOAL_ID\"=?,\"GOAL_TYPE\"=?,\"GRADE\"=?,\"UPDATED_BY\"=?,\"UPDATED_ON\"=?,\"WEEK_DATE\"=?,\"AGENT_SCORECARD_ID\"=?,\"SCORECARD_MEASURE_ID\"=? WHERE \"ID\"=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM \"SCARD_MEASURE_WEEKLY_RESULT\" WHERE \"ID\"=?";
	}
	
	@Override
	protected ScorecardMeasureWeeklyResult extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	ScorecardMeasureWeeklyResult nextResult = new ScorecardMeasureWeeklyResult();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setPercentageAttainment(rs.getDouble("PERCENTAGE_ATTAINMENT"));

nextResult.setPointsPossible(rs.getDouble("POINTS_POSSIBLE"));

nextResult.setPointsReceived(rs.getDouble("POINTS_RECEIVED"));

nextResult.setQuartile(rs.getInt("QUARTILE"));

nextResult.setResult(rs.getDouble("RESULT"));

nextResult.setRollupType(rs.getInt("ROLLUP_TYPE"));

nextResult.setCreatedBy(rs.getString("CREATED_BY"));

nextResult.setCreatedOn(rs.getDate("CREATED_ON"));

nextResult.setDurationFrom(rs.getInt("DURATION_FROM"));

nextResult.setDurationTo(rs.getInt("DURATION_TO"));

nextResult.setEmployeeId(rs.getString("EMPLOYEE_ID"));

nextResult.setExcluded(rs.getInt("EXCLUDED"));

nextResult.setGoal(rs.getDouble("GOAL"));

nextResult.setGoalId(rs.getInt("GOAL_ID"));

nextResult.setGoalType(rs.getInt("GOAL_TYPE"));

nextResult.setGrade(rs.getInt("GRADE"));

nextResult.setUpdatedBy(rs.getString("UPDATED_BY"));

nextResult.setUpdatedOn(rs.getDate("UPDATED_ON"));

nextResult.setWeekDate(rs.getDate("WEEK_DATE"));

AgentScorecard agentscorecard = new AgentScorecard();
agentscorecard.setID(rs.getString("AGENT_SCORECARD_ID"));
nextResult.setAgentScorecard(agentscorecard);

ScorecardMeasure scorecardmeasure = new ScorecardMeasure();
scorecardmeasure.setID(rs.getString("SCORECARD_MEASURE_ID"));
nextResult.setScorecardMeasure(scorecardmeasure);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(ScorecardMeasureWeeklyResult perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setDouble(2, perceroObject.getPercentageAttainment());
pstmt.setDouble(3, perceroObject.getPointsPossible());
pstmt.setDouble(4, perceroObject.getPointsReceived());
pstmt.setInt(5, perceroObject.getQuartile());
pstmt.setDouble(6, perceroObject.getResult());
pstmt.setInt(7, perceroObject.getRollupType());
pstmt.setString(8, perceroObject.getCreatedBy());
pstmt.setDate(9, DateUtils.utilDateToSqlDate(perceroObject.getCreatedOn()));
pstmt.setInt(10, perceroObject.getDurationFrom());
pstmt.setInt(11, perceroObject.getDurationTo());
pstmt.setString(12, perceroObject.getEmployeeId());
pstmt.setInt(13, perceroObject.getExcluded());
pstmt.setDouble(14, perceroObject.getGoal());
pstmt.setInt(15, perceroObject.getGoalId());
pstmt.setInt(16, perceroObject.getGoalType());
pstmt.setInt(17, perceroObject.getGrade());
pstmt.setString(18, perceroObject.getUpdatedBy());
pstmt.setDate(19, DateUtils.utilDateToSqlDate(perceroObject.getUpdatedOn()));
pstmt.setDate(20, DateUtils.utilDateToSqlDate(perceroObject.getWeekDate()));

if (perceroObject.getAgentScorecard() == null)
{
pstmt.setString(21, null);
}
else
{
		pstmt.setString(21, perceroObject.getAgentScorecard().getID());
}


if (perceroObject.getScorecardMeasure() == null)
{
pstmt.setString(22, null);
}
else
{
		pstmt.setString(22, perceroObject.getScorecardMeasure().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(ScorecardMeasureWeeklyResult perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setDouble(1, perceroObject.getPercentageAttainment());
pstmt.setDouble(2, perceroObject.getPointsPossible());
pstmt.setDouble(3, perceroObject.getPointsReceived());
pstmt.setInt(4, perceroObject.getQuartile());
pstmt.setDouble(5, perceroObject.getResult());
pstmt.setInt(6, perceroObject.getRollupType());
pstmt.setString(7, perceroObject.getCreatedBy());
pstmt.setDate(8, DateUtils.utilDateToSqlDate(perceroObject.getCreatedOn()));
pstmt.setInt(9, perceroObject.getDurationFrom());
pstmt.setInt(10, perceroObject.getDurationTo());
pstmt.setString(11, perceroObject.getEmployeeId());
pstmt.setInt(12, perceroObject.getExcluded());
pstmt.setDouble(13, perceroObject.getGoal());
pstmt.setInt(14, perceroObject.getGoalId());
pstmt.setInt(15, perceroObject.getGoalType());
pstmt.setInt(16, perceroObject.getGrade());
pstmt.setString(17, perceroObject.getUpdatedBy());
pstmt.setDate(18, DateUtils.utilDateToSqlDate(perceroObject.getUpdatedOn()));
pstmt.setDate(19, DateUtils.utilDateToSqlDate(perceroObject.getWeekDate()));

if (perceroObject.getAgentScorecard() == null)
{
pstmt.setString(20, null);
}
else
{
		pstmt.setString(20, perceroObject.getAgentScorecard().getID());
}


if (perceroObject.getScorecardMeasure() == null)
{
pstmt.setString(21, null);
}
else
{
		pstmt.setString(21, perceroObject.getScorecardMeasure().getID());
}

pstmt.setString(22, perceroObject.getID());

		
	}

	@Override
	public List<ScorecardMeasureWeeklyResult> findByExample(ScorecardMeasureWeeklyResult theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean usePercentageAttainment = theQueryObject.getPercentageAttainment() != null && (excludeProperties == null || !excludeProperties.contains("percentageAttainment"));

if (usePercentageAttainment)
{
sql += " WHERE ";
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

boolean useGoal = theQueryObject.getGoal() != null && (excludeProperties == null || !excludeProperties.contains("goal"));

if (useGoal)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"GOAL\" =? ";
paramValues.add(theQueryObject.getGoal());
propertyCounter++;
}

boolean useGoalId = theQueryObject.getGoalId() != null && (excludeProperties == null || !excludeProperties.contains("goalId"));

if (useGoalId)
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
paramValues.add(theQueryObject.getGoalId());
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
	
}
