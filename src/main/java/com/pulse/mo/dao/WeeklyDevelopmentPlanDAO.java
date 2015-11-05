
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
public class WeeklyDevelopmentPlanDAO extends SqlDataAccessObject<WeeklyDevelopmentPlan> implements IDataAccessObject<WeeklyDevelopmentPlan> {

	static final Logger log = Logger.getLogger(WeeklyDevelopmentPlanDAO.class);

	
	public WeeklyDevelopmentPlanDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(WeeklyDevelopmentPlan.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	
	public static final String SHELL_ONLY_SELECT = "\"WEEKLY_DEVELOPMENT_PLAN\".\"ID\"";
	public static final String SQL_VIEW = ",\"WEEKLY_DEVELOPMENT_PLAN\".\"WEEK_DATE\",\"WEEKLY_DEVELOPMENT_PLAN\".\"DEVELOPMENT_PLAN_ID\",\"WEEKLY_DEVELOPMENT_PLAN\".\"SCORECARD_ID\",\"WEEKLY_DEVELOPMENT_PLAN\".\"SCORECARD_MEASURE_ID\",\"WEEKLY_DEVELOPMENT_PLAN\".\"SCORECARD_WEEKLY_RESULT_ID\"";
	private String selectFromStatementTableName = " FROM \"WEEKLY_DEVELOPMENT_PLAN\" \"WEEKLY_DEVELOPMENT_PLAN\"";
//	private String whereClause = "  WHERE \"WEEKLY_DEVELOPMENT_PLAN\".\"ID\"=?";
	private String whereClause = " ,(select ? As SQLID From Dual) WHERE \"WEEKLY_DEVELOPMENT_PLAN\".\"SCORECARD_WEEKLY_RESULT_ID\"= SUBSTR(SQLID,0,9) AND \"WEEKLY_DEVELOPMENT_PLAN\".\"DEVELOPMENT_PLAN_ID\"=SUBSTR(SQLID,INSTR(SQLID,'-', 1, 1) + 1,4) ";
	private String whereInClause = "  join table(sys.dbms_debug_vc2coll(?)) SQLLIST on \"WEEKLY_DEVELOPMENT_PLAN\".\"ID\"= SQLLIST.column_value";
	private String orderByTableName = "  ORDER BY \"WEEKLY_DEVELOPMENT_PLAN\".\"ID\"";
	
	

	
	@Override
	protected String getConnectionFactoryName() {
		return WeeklyDevelopmentPlanDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT " + SHELL_ONLY_SELECT +  " " + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT \"WEEKLY_DEVELOPMENT_PLAN\".\"ID\"" + SQL_VIEW  + selectFromStatementTableName + whereClause;
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
		return "SELECT \"WEEKLY_DEVELOPMENT_PLAN\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName  + orderByTableName;
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT \"WEEKLY_DEVELOPMENT_PLAN\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + orderByTableName + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() 
	{
		return "SELECT COUNT(ID) " + selectFromStatementTableName;
	}
	
	@Override
	protected String getSelectInStarSQL() 
	{
		return "SELECT \"WEEKLY_DEVELOPMENT_PLAN\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + whereInClause;
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName + whereInClause;
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		
		return "SELECT \"WEEKLY_DEVELOPMENT_PLAN\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + " WHERE \"WEEKLY_DEVELOPMENT_PLAN\"." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) 
	{
		
		return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName + " WHERE \"WEEKLY_DEVELOPMENT_PLAN\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName;
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT \"WEEKLY_DEVELOPMENT_PLAN\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName;
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO TBL_WEEKLY_DEVELOPMENT_PLAN (\"ID\",\"WEEK_DATE\",\"DEVELOPMENT_PLAN_ID\",\"SCORECARD_ID\",\"SCORECARD_MEASURE_ID\",\"SCORECARD_WEEKLY_RESULT_ID\") VALUES (?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE TBL_WEEKLY_DEVELOPMENT_PLAN SET \"WEEK_DATE\"=?,\"DEVELOPMENT_PLAN_ID\"=?,\"SCORECARD_ID\"=?,\"SCORECARD_MEASURE_ID\"=?,\"SCORECARD_WEEKLY_RESULT_ID\"=? WHERE \"ID\"=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM TBL_WEEKLY_DEVELOPMENT_PLAN WHERE \"ID\"=?";
	}
	
	@Override
	protected WeeklyDevelopmentPlan extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	
		
WeeklyDevelopmentPlan nextResult = null;
    	
		    	
    	if (nextResult == null) {
    		nextResult = new WeeklyDevelopmentPlan();
    	}

		
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setWeekDate(DateUtils.utilDateFromSqlTimestamp(rs.getTimestamp("WEEK_DATE")));


DevelopmentPlan developmentplan = new DevelopmentPlan();
developmentplan.setID(rs.getString("DEVELOPMENT_PLAN_ID"));
nextResult.setDevelopmentPlan(developmentplan);


Scorecard scorecard = new Scorecard();
scorecard.setID(rs.getString("SCORECARD_ID"));
nextResult.setScorecard(scorecard);


ScorecardMeasure scorecardmeasure = new ScorecardMeasure();
scorecardmeasure.setID(rs.getString("SCORECARD_MEASURE_ID"));
nextResult.setScorecardMeasure(scorecardmeasure);


ScorecardWeeklyResult scorecardweeklyresult = new ScorecardWeeklyResult();
scorecardweeklyresult.setID(rs.getString("SCORECARD_WEEKLY_RESULT_ID"));
nextResult.setScorecardWeeklyResult(scorecardweeklyresult);



			
    	}
		
		
    	return nextResult;
	}
	
	protected void setBaseStatmentInsertParams(WeeklyDevelopmentPlan perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setDate(2, DateUtils.utilDateToSqlDate(perceroObject.getWeekDate()));

if (perceroObject.getDevelopmentPlan() == null)
{
pstmt.setString(3, null);
}
else
{
		pstmt.setString(3, perceroObject.getDevelopmentPlan().getID());
}


if (perceroObject.getScorecard() == null)
{
pstmt.setString(4, null);
}
else
{
		pstmt.setString(4, perceroObject.getScorecard().getID());
}


if (perceroObject.getScorecardMeasure() == null)
{
pstmt.setString(5, null);
}
else
{
		pstmt.setString(5, perceroObject.getScorecardMeasure().getID());
}


if (perceroObject.getScorecardWeeklyResult() == null)
{
pstmt.setString(6, null);
}
else
{
		pstmt.setString(6, perceroObject.getScorecardWeeklyResult().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(WeeklyDevelopmentPlan perceroObject, PreparedStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
		
	}
	
	@Override
	protected void setCallableStatmentInsertParams(WeeklyDevelopmentPlan perceroObject, CallableStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	

	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(WeeklyDevelopmentPlan perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setDate(1, DateUtils.utilDateToSqlDate(perceroObject.getWeekDate()));

if (perceroObject.getDevelopmentPlan() == null)
{
pstmt.setString(2, null);
}
else
{
		pstmt.setString(2, perceroObject.getDevelopmentPlan().getID());
}


if (perceroObject.getScorecard() == null)
{
pstmt.setString(3, null);
}
else
{
		pstmt.setString(3, perceroObject.getScorecard().getID());
}


if (perceroObject.getScorecardMeasure() == null)
{
pstmt.setString(4, null);
}
else
{
		pstmt.setString(4, perceroObject.getScorecardMeasure().getID());
}


if (perceroObject.getScorecardWeeklyResult() == null)
{
pstmt.setString(5, null);
}
else
{
		pstmt.setString(5, perceroObject.getScorecardWeeklyResult().getID());
}

pstmt.setString(6, perceroObject.getID());

		
	}
	
	
	@Override
	protected void setCallableStatmentUpdateParams(WeeklyDevelopmentPlan perceroObject, CallableStatement pstmt) throws SQLException 
	{
		
		//must be in same order as insert
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	}
	
	

	@Override
	public List<WeeklyDevelopmentPlan> findByExample(WeeklyDevelopmentPlan theQueryObject,
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

boolean useDevelopmentPlanID = theQueryObject.getDevelopmentPlan() != null && (excludeProperties == null || !excludeProperties.contains("developmentPlan"));

if (useDevelopmentPlanID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"DEVELOPMENT_PLAN_ID\" =? ";
paramValues.add(theQueryObject.getDevelopmentPlan().getID());
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

boolean useScorecardWeeklyResultID = theQueryObject.getScorecardWeeklyResult() != null && (excludeProperties == null || !excludeProperties.contains("scorecardWeeklyResult"));

if (useScorecardWeeklyResultID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"SCORECARD_WEEKLY_RESULT_ID\" =? ";
paramValues.add(theQueryObject.getScorecardWeeklyResult().getID());
propertyCounter++;
}



		if (propertyCounter == 0) {
			throw new SyncException(SyncException.METHOD_UNSUPPORTED, SyncException.METHOD_UNSUPPORTED_CODE);
		}
		
		return executeSelectWithParams(sql, paramValues.toArray(), shellOnly);		
	}
	
	@Override
	protected String getUpdateCallableStatementSql() {
		return "{call UPDATE_WEEKLY_DEVELOPMENT_PLAN(?,?,?,?,?,?)}";
	}
	@Override
	protected String getInsertCallableStatementSql() {
		return "{call CREATE_WEEKLY_DEVELOPMENT_PLAN(?,?,?,?,?,?)}";
	}
	@Override
	protected String getDeleteCallableStatementSql() {
		return "{call Delete_WEEKLY_DEVELOPMENT_PLAN(?)}";
	}
	
	
	
	
}
