
package com.pulse.mo.dao;

import java.sql.PreparedStatement;
import java.sql.CallableStatement;
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
import com.pulse.mo.PerformanceSummary;
import com.pulse.mo.QualityEvaluation;

*/

@Component
public class PerformanceSummaryDAO extends SqlDataAccessObject<PerformanceSummary> implements IDataAccessObject<PerformanceSummary> {

	static final Logger log = Logger.getLogger(PerformanceSummaryDAO.class);

	
	public PerformanceSummaryDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(PerformanceSummary.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	
	public static final String SQL_VIEW = ",\"PERFORMANCE_SUMMARY\".\"WEEK_DATE\",\"PERFORMANCE_SUMMARY\".\"CURRENT_MTD_SCORE\",\"PERFORMANCE_SUMMARY\".\"CURRENT_MTD_TREND\",\"PERFORMANCE_SUMMARY\".\"PREVIOUS_MTD_SCORE\",\"PERFORMANCE_SUMMARY\".\"PREVIOUS_MTD_TREND\",\"PERFORMANCE_SUMMARY\".\"WEEKLY_OVERVIEW_SCORE\",\"PERFORMANCE_SUMMARY\".\"WEEKLY_TREND\"";
	private String selectFromStatementTableName = " FROM \"PERFORMANCE_SUMMARY\" \"PERFORMANCE_SUMMARY\"";
	private String whereClause = " WHERE \"PERFORMANCE_SUMMARY\".\"ID\"=?";
	private String whereInClause = " join table(sys.dbms_debug_vc2coll(?)) SQLLIST on \"PERFORMANCE_SUMMARY\".\"ID\"= SQLLIST.column_value";
	private String orderByTableName = " ORDER BY \"PERFORMANCE_SUMMARY\".\"ID\"";
	
	

	
	@Override
	protected String getConnectionFactoryName() {
		return PerformanceSummaryDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT \"PERFORMANCE_SUMMARY\".\"ID\" " + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT \"PERFORMANCE_SUMMARY\".\"ID\"" + SQL_VIEW  + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT \"PERFORMANCE_SUMMARY\".\"ID\" " + selectFromStatementTableName +  orderByTableName;
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT \"PERFORMANCE_SUMMARY\".\"ID\" " + selectFromStatementTableName  +  orderByTableName  + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT \"PERFORMANCE_SUMMARY\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName  + orderByTableName;
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT \"PERFORMANCE_SUMMARY\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + orderByTableName + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() 
	{
		return "SELECT COUNT(ID) " + selectFromStatementTableName;
	}
	
	@Override
	protected String getSelectInStarSQL() 
	{
		return "SELECT \"PERFORMANCE_SUMMARY\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + whereInClause;
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT \"PERFORMANCE_SUMMARY\".\"ID\" " + selectFromStatementTableName + whereInClause;
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		
		return "SELECT \"PERFORMANCE_SUMMARY\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + " WHERE \"PERFORMANCE_SUMMARY\"." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) 
	{
		
		return "SELECT \"PERFORMANCE_SUMMARY\".\"ID\" " + selectFromStatementTableName + " WHERE \"PERFORMANCE_SUMMARY\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT \"PERFORMANCE_SUMMARY\".\"ID\" " + selectFromStatementTableName;
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT \"PERFORMANCE_SUMMARY\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName;
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO PERFORMANCE_SUMMARY (\"ID\",\"WEEK_DATE\",\"CURRENT_MTD_SCORE\",\"CURRENT_MTD_TREND\",\"PREVIOUS_MTD_SCORE\",\"PREVIOUS_MTD_TREND\",\"WEEKLY_OVERVIEW_SCORE\",\"WEEKLY_TREND\") VALUES (?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE \"TBL_PERFORMANCE_SUMMARY\" SET \"WEEK_DATE\"=?,\"CURRENT_MTD_SCORE\"=?,\"CURRENT_MTD_TREND\"=?,\"PREVIOUS_MTD_SCORE\"=?,\"PREVIOUS_MTD_TREND\"=?,\"WEEKLY_OVERVIEW_SCORE\"=?,\"WEEKLY_TREND\"=? WHERE \"ID\"=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM \"TBL_PERFORMANCE_SUMMARY\" WHERE \"ID\"=?";
	}
	
	@Override
	protected PerformanceSummary extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	PerformanceSummary nextResult = new PerformanceSummary();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setWeekDate(rs.getDate("WEEK_DATE"));

nextResult.setCurrentMTDScore(rs.getString("CURRENT_MTD_SCORE"));

nextResult.setCurrentMTDTrend(rs.getString("CURRENT_MTD_TREND"));

nextResult.setPreviousMTDScore(rs.getString("PREVIOUS_MTD_SCORE"));

nextResult.setPreviousMTDTrend(rs.getString("PREVIOUS_MTD_TREND"));

nextResult.setWeeklyOverviewScore(rs.getString("WEEKLY_OVERVIEW_SCORE"));

nextResult.setWeeklyTrend(rs.getString("WEEKLY_TREND"));


			
    	}
    	
    	return nextResult;
	}
	
	protected void setBaseStatmentInsertParams(PerformanceSummary perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setDate(2, DateUtils.utilDateToSqlDate(perceroObject.getWeekDate()));
pstmt.setString(3, perceroObject.getCurrentMTDScore());
pstmt.setString(4, perceroObject.getCurrentMTDTrend());
pstmt.setString(5, perceroObject.getPreviousMTDScore());
pstmt.setString(6, perceroObject.getPreviousMTDTrend());
pstmt.setString(7, perceroObject.getWeeklyOverviewScore());
pstmt.setString(8, perceroObject.getWeeklyTrend());

		
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(PerformanceSummary perceroObject, PreparedStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
		
	}
	
	@Override
	protected void setCallableStatmentInsertParams(PerformanceSummary perceroObject, CallableStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	

	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(PerformanceSummary perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setDate(1, DateUtils.utilDateToSqlDate(perceroObject.getWeekDate()));
pstmt.setString(2, perceroObject.getCurrentMTDScore());
pstmt.setString(3, perceroObject.getCurrentMTDTrend());
pstmt.setString(4, perceroObject.getPreviousMTDScore());
pstmt.setString(5, perceroObject.getPreviousMTDTrend());
pstmt.setString(6, perceroObject.getWeeklyOverviewScore());
pstmt.setString(7, perceroObject.getWeeklyTrend());
pstmt.setString(8, perceroObject.getID());

		
	}
	
	
	@Override
	protected void setCallableStatmentUpdateParams(PerformanceSummary perceroObject, CallableStatement pstmt) throws SQLException 
	{
		
		//must be in same order as insert
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	}
	
	

	@Override
	public List<PerformanceSummary> findByExample(PerformanceSummary theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useWeekDate = theQueryObject.getWeekDate() != null && (excludeProperties == null || !excludeProperties.contains("weekDate"));

if (useWeekDate)
{
sql += " WHERE ";
sql += " \"WEEK_DATE\" =? ";
paramValues.add(theQueryObject.getWeekDate());
propertyCounter++;
}

boolean useCurrentMTDScore = StringUtils.hasText(theQueryObject.getCurrentMTDScore()) && (excludeProperties == null || !excludeProperties.contains("currentMTDScore"));

if (useCurrentMTDScore)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"CURRENT_MTD_SCORE\" =? ";
paramValues.add(theQueryObject.getCurrentMTDScore());
propertyCounter++;
}

boolean useCurrentMTDTrend = StringUtils.hasText(theQueryObject.getCurrentMTDTrend()) && (excludeProperties == null || !excludeProperties.contains("currentMTDTrend"));

if (useCurrentMTDTrend)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"CURRENT_MTD_TREND\" =? ";
paramValues.add(theQueryObject.getCurrentMTDTrend());
propertyCounter++;
}

boolean usePreviousMTDScore = StringUtils.hasText(theQueryObject.getPreviousMTDScore()) && (excludeProperties == null || !excludeProperties.contains("previousMTDScore"));

if (usePreviousMTDScore)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"PREVIOUS_MTD_SCORE\" =? ";
paramValues.add(theQueryObject.getPreviousMTDScore());
propertyCounter++;
}

boolean usePreviousMTDTrend = StringUtils.hasText(theQueryObject.getPreviousMTDTrend()) && (excludeProperties == null || !excludeProperties.contains("previousMTDTrend"));

if (usePreviousMTDTrend)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"PREVIOUS_MTD_TREND\" =? ";
paramValues.add(theQueryObject.getPreviousMTDTrend());
propertyCounter++;
}

boolean useWeeklyOverviewScore = StringUtils.hasText(theQueryObject.getWeeklyOverviewScore()) && (excludeProperties == null || !excludeProperties.contains("weeklyOverviewScore"));

if (useWeeklyOverviewScore)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"WEEKLY_OVERVIEW_SCORE\" =? ";
paramValues.add(theQueryObject.getWeeklyOverviewScore());
propertyCounter++;
}

boolean useWeeklyTrend = StringUtils.hasText(theQueryObject.getWeeklyTrend()) && (excludeProperties == null || !excludeProperties.contains("weeklyTrend"));

if (useWeeklyTrend)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"WEEKLY_TREND\" =? ";
paramValues.add(theQueryObject.getWeeklyTrend());
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
	
	@Override
	protected String getUpdateCallableStatementSql() {
		return "{call UPDATE_PERFORMANCE_SUMMARY(?,?,?,?,?,?,?,?)}";
	}
	@Override
	protected String getInsertCallableStatementSql() {
		return "{call CREATE_PERFORMANCE_SUMMARY(?,?,?,?,?,?,?,?)}";
	}
	@Override
	protected String getDeleteCallableStatementSql() {
		return "{call Delete_PERFORMANCE_SUMMARY(?)}";
	}
	
	
	
	
}
