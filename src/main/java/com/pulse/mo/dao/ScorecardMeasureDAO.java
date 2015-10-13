
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
import com.pulse.mo.ScorecardMeasure;
import com.pulse.mo.ScorecardMeasureMonthlyResult;
import com.pulse.mo.ScorecardMeasureWeeklyResult;
import com.pulse.mo.Measure;

*/

@Component
public class ScorecardMeasureDAO extends SqlDataAccessObject<ScorecardMeasure> implements IDataAccessObject<ScorecardMeasure> {

	static final Logger log = Logger.getLogger(ScorecardMeasureDAO.class);

	
	public ScorecardMeasureDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(ScorecardMeasure.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	
	public static final String SQL_VIEW = ",\"SCORECARD_MEASURE\".\"COACHABLE\",\"SCORECARD_MEASURE\".\"NAME\",\"SCORECARD_MEASURE\".\"WEEKLY_TREND\",\"SCORECARD_MEASURE\".\"WEIGHT\",\"SCORECARD_MEASURE\".\"MEASURE_ID\"";
	private String selectFromStatementTableName = " FROM \"SCORECARD_MEASURE\" \"SCORECARD_MEASURE\"";
	private String whereClause = " WHERE \"SCORECARD_MEASURE\".\"ID\"=?";
	private String whereInClause = " join table(sys.dbms_debug_vc2coll(?)) SQLLIST on \"SCORECARD_MEASURE\".\"ID\"= SQLLIST.column_value";
	private String orderByTableName = " ORDER BY \"SCORECARD_MEASURE\".\"ID\"";
	
	

	
	@Override
	protected String getConnectionFactoryName() {
		return ScorecardMeasureDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT \"SCORECARD_MEASURE\".\"ID\" " + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT \"SCORECARD_MEASURE\".\"ID\"" + SQL_VIEW  + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT \"SCORECARD_MEASURE\".\"ID\" " + selectFromStatementTableName +  orderByTableName;
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT \"SCORECARD_MEASURE\".\"ID\" " + selectFromStatementTableName  +  orderByTableName  + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT \"SCORECARD_MEASURE\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName  + orderByTableName;
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT \"SCORECARD_MEASURE\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + orderByTableName + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() 
	{
		return "SELECT COUNT(ID) " + selectFromStatementTableName;
	}
	
	@Override
	protected String getSelectInStarSQL() 
	{
		return "SELECT \"SCORECARD_MEASURE\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + whereInClause;
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT \"SCORECARD_MEASURE\".\"ID\" " + selectFromStatementTableName + whereInClause;
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		
		return "SELECT \"SCORECARD_MEASURE\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + " WHERE \"SCORECARD_MEASURE\"." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) 
	{
		
		return "SELECT \"SCORECARD_MEASURE\".\"ID\" " + selectFromStatementTableName + " WHERE \"SCORECARD_MEASURE\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT \"SCORECARD_MEASURE\".\"ID\" " + selectFromStatementTableName;
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT \"SCORECARD_MEASURE\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName;
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO SCORECARD_MEASURE (\"ID\",\"COACHABLE\",\"NAME\",\"WEEKLY_TREND\",\"WEIGHT\",\"MEASURE_ID\") VALUES (?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE \"SCORECARD_MEASURE\" SET \"COACHABLE\"=?,\"NAME\"=?,\"WEEKLY_TREND\"=?,\"WEIGHT\"=?,\"MEASURE_ID\"=? WHERE \"ID\"=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM \"SCORECARD_MEASURE\" WHERE \"ID\"=?";
	}
	
	@Override
	protected ScorecardMeasure extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	ScorecardMeasure nextResult = new ScorecardMeasure();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setCoachable(rs.getBoolean("COACHABLE"));

nextResult.setName(rs.getString("NAME"));

nextResult.setWeeklyTrend(rs.getString("WEEKLY_TREND"));

nextResult.setWeight(rs.getString("WEIGHT"));

Measure measure = new Measure();
measure.setID(rs.getString("MEASURE_ID"));
nextResult.setMeasure(measure);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(ScorecardMeasure perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setBoolean(2, perceroObject.getCoachable());
pstmt.setString(3, perceroObject.getName());
pstmt.setString(4, perceroObject.getWeeklyTrend());
pstmt.setString(5, perceroObject.getWeight());

if (perceroObject.getMeasure() == null)
{
pstmt.setString(6, null);
}
else
{
		pstmt.setString(6, perceroObject.getMeasure().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(ScorecardMeasure perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setBoolean(1, perceroObject.getCoachable());
pstmt.setString(2, perceroObject.getName());
pstmt.setString(3, perceroObject.getWeeklyTrend());
pstmt.setString(4, perceroObject.getWeight());

if (perceroObject.getMeasure() == null)
{
pstmt.setString(5, null);
}
else
{
		pstmt.setString(5, perceroObject.getMeasure().getID());
}

pstmt.setString(6, perceroObject.getID());

		
	}

	@Override
	public List<ScorecardMeasure> findByExample(ScorecardMeasure theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useCoachable = theQueryObject.getCoachable() != null && (excludeProperties == null || !excludeProperties.contains("coachable"));

if (useCoachable)
{
sql += " WHERE ";
sql += " \"COACHABLE\" =? ";
paramValues.add(theQueryObject.getCoachable());
propertyCounter++;
}

boolean useName = StringUtils.hasText(theQueryObject.getName()) && (excludeProperties == null || !excludeProperties.contains("name"));

if (useName)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"NAME\" =? ";
paramValues.add(theQueryObject.getName());
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

boolean useWeight = StringUtils.hasText(theQueryObject.getWeight()) && (excludeProperties == null || !excludeProperties.contains("weight"));

if (useWeight)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"WEIGHT\" =? ";
paramValues.add(theQueryObject.getWeight());
propertyCounter++;
}

boolean useMeasureID = theQueryObject.getMeasure() != null && (excludeProperties == null || !excludeProperties.contains("measure"));

if (useMeasureID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"MEASURE_ID\" =? ";
paramValues.add(theQueryObject.getMeasure().getID());
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
