

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
public class GoalDAO extends SqlDataAccessObject<Goal> implements IDataAccessObject<Goal> {

	static final Logger log = Logger.getLogger(GoalDAO.class);

	
	public GoalDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(Goal.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	
	public static final String SQL_VIEW = ",\"GOAL\".\"UPDATED_BY\",\"GOAL\".\"CREATED_ON\",\"GOAL\".\"END_DATE\",\"GOAL\".\"START_DATE\",\"GOAL\".\"UPDATED_ON\",\"GOAL\".\"DURATION_FROM\",\"GOAL\".\"DURATION_TO\",\"GOAL\".\"GOAL_TYPE\",\"GOAL\".\"GOAL_VALUE\",\"GOAL\".\"CREATED_BY\",\"GOAL\".\"GOAL_TYPE_NAME\",\"GOAL\".\"SCORECARD_MEASURE_ID\"";
	private String selectFromStatementTableName = " FROM \"GOAL\" \"GOAL\"";
	private String whereClause = "  WHERE \"GOAL\".\"ID\"=?";
	private String whereInClause = "  join table(sys.dbms_debug_vc2coll(?)) SQLLIST on \"GOAL\".\"ID\"= SQLLIST.column_value";
	private String orderByTableName = "  ORDER BY \"GOAL\".\"ID\"";
	
	

	
	@Override
	protected String getConnectionFactoryName() {
		return GoalDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT \"GOAL\".\"ID\" " + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT \"GOAL\".\"ID\"" + SQL_VIEW  + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT \"GOAL\".\"ID\" " + selectFromStatementTableName +  orderByTableName;
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT \"GOAL\".\"ID\" " + selectFromStatementTableName  +  orderByTableName  + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT \"GOAL\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName  + orderByTableName;
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT \"GOAL\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + orderByTableName + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() 
	{
		return "SELECT COUNT(ID) " + selectFromStatementTableName;
	}
	
	@Override
	protected String getSelectInStarSQL() 
	{
		return "SELECT \"GOAL\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + whereInClause;
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT \"GOAL\".\"ID\" " + selectFromStatementTableName + whereInClause;
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		
		return "SELECT \"GOAL\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + " WHERE \"GOAL\"." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) 
	{
		
		return "SELECT \"GOAL\".\"ID\" " + selectFromStatementTableName + " WHERE \"GOAL\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT \"GOAL\".\"ID\" " + selectFromStatementTableName;
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT \"GOAL\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName;
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO TBL_GOAL (\"ID\",\"UPDATED_BY\",\"CREATED_ON\",\"END_DATE\",\"START_DATE\",\"UPDATED_ON\",\"DURATION_FROM\",\"DURATION_TO\",\"GOAL_TYPE\",\"GOAL_VALUE\",\"CREATED_BY\",\"GOAL_TYPE_NAME\",\"SCORECARD_MEASURE_ID\") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE TBL_GOAL SET \"UPDATED_BY\"=?,\"CREATED_ON\"=?,\"END_DATE\"=?,\"START_DATE\"=?,\"UPDATED_ON\"=?,\"DURATION_FROM\"=?,\"DURATION_TO\"=?,\"GOAL_TYPE\"=?,\"GOAL_VALUE\"=?,\"CREATED_BY\"=?,\"GOAL_TYPE_NAME\"=?,\"SCORECARD_MEASURE_ID\"=? WHERE \"ID\"=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM TBL_GOAL WHERE \"ID\"=?";
	}
	
	@Override
	protected Goal extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	Goal nextResult = new Goal();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setUpdatedBy(rs.getString("UPDATED_BY"));

nextResult.setCreatedOn(rs.getDate("CREATED_ON"));

nextResult.setEndDate(rs.getDate("END_DATE"));

nextResult.setStartDate(rs.getDate("START_DATE"));

nextResult.setUpdatedOn(rs.getDate("UPDATED_ON"));

nextResult.setDurationFrom(rs.getInt("DURATION_FROM"));

nextResult.setDurationTo(rs.getInt("DURATION_TO"));

nextResult.setGoalType(rs.getInt("GOAL_TYPE"));

nextResult.setGoalValue(rs.getInt("GOAL_VALUE"));

nextResult.setCreatedBy(rs.getString("CREATED_BY"));

nextResult.setGoalTypeName(rs.getString("GOAL_TYPE_NAME"));

//ScorecardMeasure scorecardmeasure = new ScorecardMeasure();
//scorecardmeasure.setID(rs.getString("SCORECARD_MEASURE_ID"));
//nextResult.setScorecardMeasure(scorecardmeasure);


			
    	}
    	
    	return nextResult;
	}
	
	protected void setBaseStatmentInsertParams(Goal perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getUpdatedBy());
pstmt.setDate(3, DateUtils.utilDateToSqlDate(perceroObject.getCreatedOn()));
pstmt.setDate(4, DateUtils.utilDateToSqlDate(perceroObject.getEndDate()));
pstmt.setDate(5, DateUtils.utilDateToSqlDate(perceroObject.getStartDate()));
pstmt.setDate(6, DateUtils.utilDateToSqlDate(perceroObject.getUpdatedOn()));
pstmt.setInt(7, perceroObject.getDurationFrom());
pstmt.setInt(8, perceroObject.getDurationTo());
pstmt.setInt(9, perceroObject.getGoalType());
pstmt.setInt(10, perceroObject.getGoalValue());
pstmt.setString(11, perceroObject.getCreatedBy());
pstmt.setString(12, perceroObject.getGoalTypeName());

//if (perceroObject.getScorecardMeasure() == null)
//{
//pstmt.setString(13, null);
//}
//else
//{
//		pstmt.setString(13, perceroObject.getScorecardMeasure().getID());
//}


		
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(Goal perceroObject, PreparedStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
		
	}
	
	@Override
	protected void setCallableStatmentInsertParams(Goal perceroObject, CallableStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	

	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(Goal perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getUpdatedBy());
pstmt.setDate(2, DateUtils.utilDateToSqlDate(perceroObject.getCreatedOn()));
pstmt.setDate(3, DateUtils.utilDateToSqlDate(perceroObject.getEndDate()));
pstmt.setDate(4, DateUtils.utilDateToSqlDate(perceroObject.getStartDate()));
pstmt.setDate(5, DateUtils.utilDateToSqlDate(perceroObject.getUpdatedOn()));
pstmt.setInt(6, perceroObject.getDurationFrom());
pstmt.setInt(7, perceroObject.getDurationTo());
pstmt.setInt(8, perceroObject.getGoalType());
pstmt.setInt(9, perceroObject.getGoalValue());
pstmt.setString(10, perceroObject.getCreatedBy());
pstmt.setString(11, perceroObject.getGoalTypeName());

//if (perceroObject.getScorecardMeasure() == null)
//{
//pstmt.setString(12, null);
//}
//else
//{
//		pstmt.setString(12, perceroObject.getScorecardMeasure().getID());
//}

pstmt.setString(13, perceroObject.getID());

		
	}
	
	
	@Override
	protected void setCallableStatmentUpdateParams(Goal perceroObject, CallableStatement pstmt) throws SQLException 
	{
		
		//must be in same order as insert
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	}
	
	

	@Override
	public List<Goal> findByExample(Goal theQueryObject,
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

boolean useGoalValue = theQueryObject.getGoalValue() != null && (excludeProperties == null || !excludeProperties.contains("goalValue"));

if (useGoalValue)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"GOAL_VALUE\" =? ";
paramValues.add(theQueryObject.getGoalValue());
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

boolean useGoalTypeName = StringUtils.hasText(theQueryObject.getGoalTypeName()) && (excludeProperties == null || !excludeProperties.contains("goalTypeName"));

if (useGoalTypeName)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"GOAL_TYPE_NAME\" =? ";
paramValues.add(theQueryObject.getGoalTypeName());
propertyCounter++;
}

//boolean useScorecardMeasureID = theQueryObject.getScorecardMeasure() != null && (excludeProperties == null || !excludeProperties.contains("scorecardMeasure"));
//
//if (useScorecardMeasureID)
//{
//if (propertyCounter > 0)
//{
//sql += " AND ";
//}
//else
//{
//sql += " WHERE ";
//}
//sql += " \"SCORECARD_MEASURE_ID\" =? ";
////paramValues.add(theQueryObject.getScorecardMeasure().getID());
//propertyCounter++;
//}



		if (propertyCounter == 0) {
			throw new SyncException(SyncException.METHOD_UNSUPPORTED, SyncException.METHOD_UNSUPPORTED_CODE);
		}
		
		return executeSelectWithParams(sql, paramValues.toArray(), shellOnly);		
	}
	
	@Override
	protected String getUpdateCallableStatementSql() {
		return "{call UPDATE_GOAL(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	}
	@Override
	protected String getInsertCallableStatementSql() {
		return "{call CREATE_GOAL(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	}
	@Override
	protected String getDeleteCallableStatementSql() {
		return "{call Delete_GOAL(?)}";
	}
	
	
	
	
}

