
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
import com.pulse.mo.ScorecardMeasureMonthlyResult;
import com.pulse.mo.ScorecardMeasure;

*/

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
	
	public static final String SQL_VIEW = ",\"SCARD_MEASURE_MONTHLY_RESULT\".\"UPDATED_BY\",\"SCARD_MEASURE_MONTHLY_RESULT\".\"CREATED_ON\",\"SCARD_MEASURE_MONTHLY_RESULT\".\"END_DATE\",\"SCARD_MEASURE_MONTHLY_RESULT\".\"START_DATE\",\"SCARD_MEASURE_MONTHLY_RESULT\".\"UPDATED_ON\",\"SCARD_MEASURE_MONTHLY_RESULT\".\"METRIC_RESULT\",\"SCARD_MEASURE_MONTHLY_RESULT\".\"PERCENTAGE_ATTAINMENT\",\"SCARD_MEASURE_MONTHLY_RESULT\".\"POINTS_POSSIBLE\",\"SCARD_MEASURE_MONTHLY_RESULT\".\"POINTS_RECEIVED\",\"SCARD_MEASURE_MONTHLY_RESULT\".\"EXCLUDED\",\"SCARD_MEASURE_MONTHLY_RESULT\".\"GRADE\",\"SCARD_MEASURE_MONTHLY_RESULT\".\"ROLLUP_TYPE\",\"SCARD_MEASURE_MONTHLY_RESULT\".\"SCM_GOAL_ID\",\"SCARD_MEASURE_MONTHLY_RESULT\".\"TENURE\",\"SCARD_MEASURE_MONTHLY_RESULT\".\"CREATED_BY\",\"SCARD_MEASURE_MONTHLY_RESULT\".\"EMPLOYEE_ID\",\"SCARD_MEASURE_MONTHLY_RESULT\".\"INTERVAL_TYPE\",\"SCARD_MEASURE_MONTHLY_RESULT\".\"METRIC_TYPE\",\"SCARD_MEASURE_MONTHLY_RESULT\".\"METRIC_UNIT\",\"SCARD_MEASURE_MONTHLY_RESULT\".\"SCORECARD_ID\",\"SCARD_MEASURE_MONTHLY_RESULT\".\"SCORECARD_MEASURE_ID\"";
	private String selectFromStatementTableName = " FROM \"SCARD_MEASURE_MONTHLY_RESULT\" \"SCARD_MEASURE_MONTHLY_RESULT\"";
	private String whereClause = " WHERE \"SCARD_MEASURE_MONTHLY_RESULT\".\"ID\"=?";
	private String whereInClause = " join table(sys.dbms_debug_vc2coll(?)) SQLLIST on \"SCARD_MEASURE_MONTHLY_RESULT\".\"ID\"= SQLLIST.column_value";
	private String orderByTableName = " ORDER BY \"SCARD_MEASURE_MONTHLY_RESULT\".\"ID\"";
	
	

	
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
		
		return "SELECT \"SCARD_MEASURE_MONTHLY_RESULT\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + " WHERE \"SCARD_MEASURE_MONTHLY_RESULT\"." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) 
	{
		
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
		return "INSERT INTO SCARD_MEASURE_MONTHLY_RESULT (\"ID\",\"UPDATED_BY\",\"CREATED_ON\",\"END_DATE\",\"START_DATE\",\"UPDATED_ON\",\"METRIC_RESULT\",\"PERCENTAGE_ATTAINMENT\",\"POINTS_POSSIBLE\",\"POINTS_RECEIVED\",\"EXCLUDED\",\"GRADE\",\"ROLLUP_TYPE\",\"SCM_GOAL_ID\",\"TENURE\",\"CREATED_BY\",\"EMPLOYEE_ID\",\"INTERVAL_TYPE\",\"METRIC_TYPE\",\"METRIC_UNIT\",\"SCORECARD_ID\",\"SCORECARD_MEASURE_ID\") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE \"SCARD_MEASURE_MONTHLY_RESULT\" SET \"UPDATED_BY\"=?,\"CREATED_ON\"=?,\"END_DATE\"=?,\"START_DATE\"=?,\"UPDATED_ON\"=?,\"METRIC_RESULT\"=?,\"PERCENTAGE_ATTAINMENT\"=?,\"POINTS_POSSIBLE\"=?,\"POINTS_RECEIVED\"=?,\"EXCLUDED\"=?,\"GRADE\"=?,\"ROLLUP_TYPE\"=?,\"SCM_GOAL_ID\"=?,\"TENURE\"=?,\"CREATED_BY\"=?,\"EMPLOYEE_ID\"=?,\"INTERVAL_TYPE\"=?,\"METRIC_TYPE\"=?,\"METRIC_UNIT\"=?,\"SCORECARD_ID\"=?,\"SCORECARD_MEASURE_ID\"=? WHERE \"ID\"=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM \"SCARD_MEASURE_MONTHLY_RESULT\" WHERE \"ID\"=?";
	}
	
	@Override
	protected ScorecardMeasureMonthlyResult extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	ScorecardMeasureMonthlyResult nextResult = new ScorecardMeasureMonthlyResult();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setUpdatedBy(rs.getString("UPDATED_BY"));

nextResult.setCreatedOn(rs.getDate("CREATED_ON"));

nextResult.setEndDate(rs.getDate("END_DATE"));

nextResult.setStartDate(rs.getDate("START_DATE"));

nextResult.setUpdatedOn(rs.getDate("UPDATED_ON"));

nextResult.setMetricResult(rs.getDouble("METRIC_RESULT"));

nextResult.setPercentageAttainment(rs.getDouble("PERCENTAGE_ATTAINMENT"));

nextResult.setPointsPossible(rs.getDouble("POINTS_POSSIBLE"));

nextResult.setPointsReceived(rs.getDouble("POINTS_RECEIVED"));

nextResult.setExcluded(rs.getInt("EXCLUDED"));

nextResult.setGrade(rs.getInt("GRADE"));

nextResult.setRollupType(rs.getInt("ROLLUP_TYPE"));

nextResult.setSCMGoalId(rs.getInt("SCM_GOAL_ID"));

nextResult.setTenure(rs.getInt("TENURE"));

nextResult.setCreatedBy(rs.getString("CREATED_BY"));

nextResult.setEmployeeId(rs.getString("EMPLOYEE_ID"));

nextResult.setIntervalType(rs.getString("INTERVAL_TYPE"));

nextResult.setMetricType(rs.getString("METRIC_TYPE"));

nextResult.setMetricUnit(rs.getString("METRIC_UNIT"));

nextResult.setScorecardId(rs.getString("SCORECARD_ID"));

ScorecardMeasure scorecardmeasure = new ScorecardMeasure();
scorecardmeasure.setID(rs.getString("SCORECARD_MEASURE_ID"));
nextResult.setScorecardMeasure(scorecardmeasure);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(ScorecardMeasureMonthlyResult perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getUpdatedBy());
pstmt.setDate(3, DateUtils.utilDateToSqlDate(perceroObject.getCreatedOn()));
pstmt.setDate(4, DateUtils.utilDateToSqlDate(perceroObject.getEndDate()));
pstmt.setDate(5, DateUtils.utilDateToSqlDate(perceroObject.getStartDate()));
pstmt.setDate(6, DateUtils.utilDateToSqlDate(perceroObject.getUpdatedOn()));
pstmt.setDouble(7, perceroObject.getMetricResult());
pstmt.setDouble(8, perceroObject.getPercentageAttainment());
pstmt.setDouble(9, perceroObject.getPointsPossible());
pstmt.setDouble(10, perceroObject.getPointsReceived());
pstmt.setInt(11, perceroObject.getExcluded());
pstmt.setInt(12, perceroObject.getGrade());
pstmt.setInt(13, perceroObject.getRollupType());
pstmt.setInt(14, perceroObject.getSCMGoalId());
pstmt.setInt(15, perceroObject.getTenure());
pstmt.setString(16, perceroObject.getCreatedBy());
pstmt.setString(17, perceroObject.getEmployeeId());
pstmt.setString(18, perceroObject.getIntervalType());
pstmt.setString(19, perceroObject.getMetricType());
pstmt.setString(20, perceroObject.getMetricUnit());
pstmt.setString(21, perceroObject.getScorecardId());

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
	protected void setPreparedStatmentUpdateParams(ScorecardMeasureMonthlyResult perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getUpdatedBy());
pstmt.setDate(2, DateUtils.utilDateToSqlDate(perceroObject.getCreatedOn()));
pstmt.setDate(3, DateUtils.utilDateToSqlDate(perceroObject.getEndDate()));
pstmt.setDate(4, DateUtils.utilDateToSqlDate(perceroObject.getStartDate()));
pstmt.setDate(5, DateUtils.utilDateToSqlDate(perceroObject.getUpdatedOn()));
pstmt.setDouble(6, perceroObject.getMetricResult());
pstmt.setDouble(7, perceroObject.getPercentageAttainment());
pstmt.setDouble(8, perceroObject.getPointsPossible());
pstmt.setDouble(9, perceroObject.getPointsReceived());
pstmt.setInt(10, perceroObject.getExcluded());
pstmt.setInt(11, perceroObject.getGrade());
pstmt.setInt(12, perceroObject.getRollupType());
pstmt.setInt(13, perceroObject.getSCMGoalId());
pstmt.setInt(14, perceroObject.getTenure());
pstmt.setString(15, perceroObject.getCreatedBy());
pstmt.setString(16, perceroObject.getEmployeeId());
pstmt.setString(17, perceroObject.getIntervalType());
pstmt.setString(18, perceroObject.getMetricType());
pstmt.setString(19, perceroObject.getMetricUnit());
pstmt.setString(20, perceroObject.getScorecardId());

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
	public List<ScorecardMeasureMonthlyResult> findByExample(ScorecardMeasureMonthlyResult theQueryObject,
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
