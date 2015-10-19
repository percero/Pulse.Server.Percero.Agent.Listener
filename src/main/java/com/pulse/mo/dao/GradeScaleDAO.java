
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
public class GradeScaleDAO extends SqlDataAccessObject<GradeScale> implements IDataAccessObject<GradeScale> {

	static final Logger log = Logger.getLogger(GradeScaleDAO.class);

	
	public GradeScaleDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(GradeScale.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	
	public static final String SQL_VIEW = ",\"GRADE_SCALE\".\"SCM_GOAL_ID\",\"GRADE_SCALE\".\"START_EXP\",\"GRADE_SCALE\".\"UPDATED_BY\",\"GRADE_SCALE\".\"CREATED_ON\",\"GRADE_SCALE\".\"END_DATE\",\"GRADE_SCALE\".\"START_DATE\",\"GRADE_SCALE\".\"UPDATED_ON\",\"GRADE_SCALE\".\"CUSTOM\",\"GRADE_SCALE\".\"END_VALUE\",\"GRADE_SCALE\".\"GRADE\",\"GRADE_SCALE\".\"AND_OR\",\"GRADE_SCALE\".\"COLOR\",\"GRADE_SCALE\".\"CREATED_BY\",\"GRADE_SCALE\".\"END_EXPRESSION\",\"GRADE_SCALE\".\"GOAL_ID\"";
	private String selectFromStatementTableName = " FROM \"GRADE_SCALE\" \"GRADE_SCALE\"";
	private String whereClause = "  WHERE \"GRADE_SCALE\".\"ID\"=?";
	private String whereInClause = "  join table(sys.dbms_debug_vc2coll(?)) SQLLIST on \"GRADE_SCALE\".\"ID\"= SQLLIST.column_value";
	private String orderByTableName = "  ORDER BY \"GRADE_SCALE\".\"ID\"";
	
	

	
	@Override
	protected String getConnectionFactoryName() {
		return GradeScaleDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT \"GRADE_SCALE\".\"ID\" " + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT \"GRADE_SCALE\".\"ID\"" + SQL_VIEW  + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT \"GRADE_SCALE\".\"ID\" " + selectFromStatementTableName +  orderByTableName;
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT \"GRADE_SCALE\".\"ID\" " + selectFromStatementTableName  +  orderByTableName  + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT \"GRADE_SCALE\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName  + orderByTableName;
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT \"GRADE_SCALE\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + orderByTableName + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() 
	{
		return "SELECT COUNT(ID) " + selectFromStatementTableName;
	}
	
	@Override
	protected String getSelectInStarSQL() 
	{
		return "SELECT \"GRADE_SCALE\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + whereInClause;
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT \"GRADE_SCALE\".\"ID\" " + selectFromStatementTableName + whereInClause;
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		
		return "SELECT \"GRADE_SCALE\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + " WHERE \"GRADE_SCALE\"." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) 
	{
		
		return "SELECT \"GRADE_SCALE\".\"ID\" " + selectFromStatementTableName + " WHERE \"GRADE_SCALE\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT \"GRADE_SCALE\".\"ID\" " + selectFromStatementTableName;
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT \"GRADE_SCALE\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName;
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO TBL_GRADE_SCALE (\"ID\",\"SCM_GOAL_ID\",\"START_EXP\",\"UPDATED_BY\",\"CREATED_ON\",\"END_DATE\",\"START_DATE\",\"UPDATED_ON\",\"CUSTOM\",\"END_VALUE\",\"GRADE\",\"AND_OR\",\"COLOR\",\"CREATED_BY\",\"END_EXPRESSION\",\"GOAL_ID\") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE TBL_GRADE_SCALE SET \"SCM_GOAL_ID\"=?,\"START_EXP\"=?,\"UPDATED_BY\"=?,\"CREATED_ON\"=?,\"END_DATE\"=?,\"START_DATE\"=?,\"UPDATED_ON\"=?,\"CUSTOM\"=?,\"END_VALUE\"=?,\"GRADE\"=?,\"AND_OR\"=?,\"COLOR\"=?,\"CREATED_BY\"=?,\"END_EXPRESSION\"=?,\"GOAL_ID\"=? WHERE \"ID\"=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM TBL_GRADE_SCALE WHERE \"ID\"=?";
	}
	
	@Override
	protected GradeScale extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	GradeScale nextResult = new GradeScale();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setSCMGoalId(rs.getString("SCM_GOAL_ID"));

nextResult.setStartExp(rs.getString("START_EXP"));

nextResult.setUpdatedBy(rs.getString("UPDATED_BY"));

nextResult.setCreatedOn(rs.getDate("CREATED_ON"));

nextResult.setEndDate(rs.getDate("END_DATE"));

nextResult.setStartDate(rs.getDate("START_DATE"));

nextResult.setUpdatedOn(rs.getDate("UPDATED_ON"));

nextResult.setCustom(rs.getInt("CUSTOM"));

nextResult.setEndValue(rs.getInt("END_VALUE"));

nextResult.setGrade(rs.getInt("GRADE"));

nextResult.setANDOR(rs.getString("AND_OR"));

nextResult.setColor(rs.getString("COLOR"));

nextResult.setCreatedBy(rs.getString("CREATED_BY"));

nextResult.setEndExpression(rs.getString("END_EXPRESSION"));

Goal goal = new Goal();
goal.setID(rs.getString("GOAL_ID"));
nextResult.setGoal(goal);


			
    	}
    	
    	return nextResult;
	}
	
	protected void setBaseStatmentInsertParams(GradeScale perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getSCMGoalId());
pstmt.setString(3, perceroObject.getStartExp());
pstmt.setString(4, perceroObject.getUpdatedBy());
pstmt.setDate(5, DateUtils.utilDateToSqlDate(perceroObject.getCreatedOn()));
pstmt.setDate(6, DateUtils.utilDateToSqlDate(perceroObject.getEndDate()));
pstmt.setDate(7, DateUtils.utilDateToSqlDate(perceroObject.getStartDate()));
pstmt.setDate(8, DateUtils.utilDateToSqlDate(perceroObject.getUpdatedOn()));
JdbcHelper.setInt(pstmt,9, perceroObject.getCustom());
JdbcHelper.setInt(pstmt,10, perceroObject.getEndValue());
JdbcHelper.setInt(pstmt,11, perceroObject.getGrade());
pstmt.setString(12, perceroObject.getANDOR());
pstmt.setString(13, perceroObject.getColor());
pstmt.setString(14, perceroObject.getCreatedBy());
pstmt.setString(15, perceroObject.getEndExpression());

if (perceroObject.getGoal() == null)
{
pstmt.setString(16, null);
}
else
{
		pstmt.setString(16, perceroObject.getGoal().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(GradeScale perceroObject, PreparedStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
		
	}
	
	@Override
	protected void setCallableStatmentInsertParams(GradeScale perceroObject, CallableStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	

	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(GradeScale perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getSCMGoalId());
pstmt.setString(2, perceroObject.getStartExp());
pstmt.setString(3, perceroObject.getUpdatedBy());
pstmt.setDate(4, DateUtils.utilDateToSqlDate(perceroObject.getCreatedOn()));
pstmt.setDate(5, DateUtils.utilDateToSqlDate(perceroObject.getEndDate()));
pstmt.setDate(6, DateUtils.utilDateToSqlDate(perceroObject.getStartDate()));
pstmt.setDate(7, DateUtils.utilDateToSqlDate(perceroObject.getUpdatedOn()));
JdbcHelper.setInt(pstmt,8, perceroObject.getCustom());
JdbcHelper.setInt(pstmt,9, perceroObject.getEndValue());
JdbcHelper.setInt(pstmt,10, perceroObject.getGrade());
pstmt.setString(11, perceroObject.getANDOR());
pstmt.setString(12, perceroObject.getColor());
pstmt.setString(13, perceroObject.getCreatedBy());
pstmt.setString(14, perceroObject.getEndExpression());

if (perceroObject.getGoal() == null)
{
pstmt.setString(15, null);
}
else
{
		pstmt.setString(15, perceroObject.getGoal().getID());
}

pstmt.setString(16, perceroObject.getID());

		
	}
	
	
	@Override
	protected void setCallableStatmentUpdateParams(GradeScale perceroObject, CallableStatement pstmt) throws SQLException 
	{
		
		//must be in same order as insert
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	}
	
	

	@Override
	public List<GradeScale> findByExample(GradeScale theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useSCMGoalId = StringUtils.hasText(theQueryObject.getSCMGoalId()) && (excludeProperties == null || !excludeProperties.contains("sCMGoalId"));

if (useSCMGoalId)
{
sql += " WHERE ";
sql += " \"SCM_GOAL_ID\" =? ";
paramValues.add(theQueryObject.getSCMGoalId());
propertyCounter++;
}

boolean useStartExp = StringUtils.hasText(theQueryObject.getStartExp()) && (excludeProperties == null || !excludeProperties.contains("startExp"));

if (useStartExp)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"START_EXP\" =? ";
paramValues.add(theQueryObject.getStartExp());
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

boolean useCustom = theQueryObject.getCustom() != null && (excludeProperties == null || !excludeProperties.contains("custom"));

if (useCustom)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"CUSTOM\" =? ";
paramValues.add(theQueryObject.getCustom());
propertyCounter++;
}

boolean useEndValue = theQueryObject.getEndValue() != null && (excludeProperties == null || !excludeProperties.contains("endValue"));

if (useEndValue)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"END_VALUE\" =? ";
paramValues.add(theQueryObject.getEndValue());
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

boolean useANDOR = StringUtils.hasText(theQueryObject.getANDOR()) && (excludeProperties == null || !excludeProperties.contains("aNDOR"));

if (useANDOR)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"AND_OR\" =? ";
paramValues.add(theQueryObject.getANDOR());
propertyCounter++;
}

boolean useColor = StringUtils.hasText(theQueryObject.getColor()) && (excludeProperties == null || !excludeProperties.contains("color"));

if (useColor)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"COLOR\" =? ";
paramValues.add(theQueryObject.getColor());
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

boolean useEndExpression = StringUtils.hasText(theQueryObject.getEndExpression()) && (excludeProperties == null || !excludeProperties.contains("endExpression"));

if (useEndExpression)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"END_EXPRESSION\" =? ";
paramValues.add(theQueryObject.getEndExpression());
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
		return "{call UPDATE_GRADE_SCALE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	}
	@Override
	protected String getInsertCallableStatementSql() {
		return "{call CREATE_GRADE_SCALE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	}
	@Override
	protected String getDeleteCallableStatementSql() {
		return "{call Delete_GRADE_SCALE(?)}";
	}
	
	
	
	
}
