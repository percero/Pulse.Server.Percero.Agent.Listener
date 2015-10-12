
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
import com.pulse.mo.DevelopmentPlan;
import com.pulse.mo.DevelopmentActivity;
import com.pulse.mo.ScorecardMeasure;

*/

@Component
public class DevelopmentPlanDAO extends SqlDataAccessObject<DevelopmentPlan> implements IDataAccessObject<DevelopmentPlan> {

	static final Logger log = Logger.getLogger(DevelopmentPlanDAO.class);

	
	public DevelopmentPlanDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(DevelopmentPlan.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	
	
	
	@Override
	protected String getConnectionFactoryName() {
		return DevelopmentPlanDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT \"DEVELOPMENT_PLAN\".\"ID\" FROM \"DEVELOPMENT_PLAN\" \"DEVELOPMENT_PLAN\" WHERE \"DEVELOPMENT_PLAN\".\"ID\"=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT \"DEVELOPMENT_PLAN\".\"ID\",\"DEVELOPMENT_PLAN\".\"CREATED_ON\",\"DEVELOPMENT_PLAN\".\"END_DATE\",\"DEVELOPMENT_PLAN\".\"START_DATE\",\"DEVELOPMENT_PLAN\".\"UPDATED_ON\",\"DEVELOPMENT_PLAN\".\"RANK\",\"DEVELOPMENT_PLAN\".\"CREATED_BY\",\"DEVELOPMENT_PLAN\".\"DESCRIPTION\",\"DEVELOPMENT_PLAN\".\"NAME\",\"DEVELOPMENT_PLAN\".\"UPDATED_BY\",\"DEVELOPMENT_PLAN\".\"SCORECARD_MEASURE_ID\" FROM \"DEVELOPMENT_PLAN\" \"DEVELOPMENT_PLAN\" WHERE \"DEVELOPMENT_PLAN\".\"ID\"=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT \"DEVELOPMENT_PLAN\".\"ID\" FROM \"DEVELOPMENT_PLAN\" \"DEVELOPMENT_PLAN\" ORDER BY \"ID\"";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT \"DEVELOPMENT_PLAN\".\"ID\" FROM \"DEVELOPMENT_PLAN\" \"DEVELOPMENT_PLAN\" ORDER BY \"DEVELOPMENT_PLAN\".\"ID\" LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT \"DEVELOPMENT_PLAN\".\"ID\",\"DEVELOPMENT_PLAN\".\"CREATED_ON\",\"DEVELOPMENT_PLAN\".\"END_DATE\",\"DEVELOPMENT_PLAN\".\"START_DATE\",\"DEVELOPMENT_PLAN\".\"UPDATED_ON\",\"DEVELOPMENT_PLAN\".\"RANK\",\"DEVELOPMENT_PLAN\".\"CREATED_BY\",\"DEVELOPMENT_PLAN\".\"DESCRIPTION\",\"DEVELOPMENT_PLAN\".\"NAME\",\"DEVELOPMENT_PLAN\".\"UPDATED_BY\",\"DEVELOPMENT_PLAN\".\"SCORECARD_MEASURE_ID\" FROM \"DEVELOPMENT_PLAN\" \"DEVELOPMENT_PLAN\" ORDER BY \"DEVELOPMENT_PLAN\".\"ID\"";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT \"DEVELOPMENT_PLAN\".\"ID\",\"DEVELOPMENT_PLAN\".\"CREATED_ON\",\"DEVELOPMENT_PLAN\".\"END_DATE\",\"DEVELOPMENT_PLAN\".\"START_DATE\",\"DEVELOPMENT_PLAN\".\"UPDATED_ON\",\"DEVELOPMENT_PLAN\".\"RANK\",\"DEVELOPMENT_PLAN\".\"CREATED_BY\",\"DEVELOPMENT_PLAN\".\"DESCRIPTION\",\"DEVELOPMENT_PLAN\".\"NAME\",\"DEVELOPMENT_PLAN\".\"UPDATED_BY\",\"DEVELOPMENT_PLAN\".\"SCORECARD_MEASURE_ID\" FROM \"DEVELOPMENT_PLAN\" \"DEVELOPMENT_PLAN\" ORDER BY \"DEVELOPMENT_PLAN\".\"ID\" LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM \"DEVELOPMENT_PLAN\" \"DEVELOPMENT_PLAN\"";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT \"DEVELOPMENT_PLAN\".\"ID\",\"DEVELOPMENT_PLAN\".\"CREATED_ON\",\"DEVELOPMENT_PLAN\".\"END_DATE\",\"DEVELOPMENT_PLAN\".\"START_DATE\",\"DEVELOPMENT_PLAN\".\"UPDATED_ON\",\"DEVELOPMENT_PLAN\".\"RANK\",\"DEVELOPMENT_PLAN\".\"CREATED_BY\",\"DEVELOPMENT_PLAN\".\"DESCRIPTION\",\"DEVELOPMENT_PLAN\".\"NAME\",\"DEVELOPMENT_PLAN\".\"UPDATED_BY\",\"DEVELOPMENT_PLAN\".\"SCORECARD_MEASURE_ID\" FROM \"DEVELOPMENT_PLAN\" \"DEVELOPMENT_PLAN\" WHERE \"DEVELOPMENT_PLAN\".\"ID\" IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT \"DEVELOPMENT_PLAN\".\"ID\" FROM \"DEVELOPMENT_PLAN\" \"DEVELOPMENT_PLAN\" WHERE \"DEVELOPMENT_PLAN\".\"ID\" IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		return "SELECT \"DEVELOPMENT_PLAN\".\"ID\",\"DEVELOPMENT_PLAN\".\"CREATED_ON\",\"DEVELOPMENT_PLAN\".\"END_DATE\",\"DEVELOPMENT_PLAN\".\"START_DATE\",\"DEVELOPMENT_PLAN\".\"UPDATED_ON\",\"DEVELOPMENT_PLAN\".\"RANK\",\"DEVELOPMENT_PLAN\".\"CREATED_BY\",\"DEVELOPMENT_PLAN\".\"DESCRIPTION\",\"DEVELOPMENT_PLAN\".\"NAME\",\"DEVELOPMENT_PLAN\".\"UPDATED_BY\",\"DEVELOPMENT_PLAN\".\"SCORECARD_MEASURE_ID\" FROM \"DEVELOPMENT_PLAN\" \"DEVELOPMENT_PLAN\" WHERE \"DEVELOPMENT_PLAN\"." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT \"DEVELOPMENT_PLAN\".\"ID\" FROM \"DEVELOPMENT_PLAN\" \"DEVELOPMENT_PLAN\" WHERE \"DEVELOPMENT_PLAN\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT \"DEVELOPMENT_PLAN\".\"ID\" FROM \"DEVELOPMENT_PLAN\" \"DEVELOPMENT_PLAN\" ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT \"DEVELOPMENT_PLAN\".\"ID\",\"DEVELOPMENT_PLAN\".\"CREATED_ON\",\"DEVELOPMENT_PLAN\".\"END_DATE\",\"DEVELOPMENT_PLAN\".\"START_DATE\",\"DEVELOPMENT_PLAN\".\"UPDATED_ON\",\"DEVELOPMENT_PLAN\".\"RANK\",\"DEVELOPMENT_PLAN\".\"CREATED_BY\",\"DEVELOPMENT_PLAN\".\"DESCRIPTION\",\"DEVELOPMENT_PLAN\".\"NAME\",\"DEVELOPMENT_PLAN\".\"UPDATED_BY\",\"DEVELOPMENT_PLAN\".\"SCORECARD_MEASURE_ID\" FROM \"DEVELOPMENT_PLAN\" \"DEVELOPMENT_PLAN\" ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO DEVELOPMENT_PLAN (\"ID\",\"CREATED_ON\",\"END_DATE\",\"START_DATE\",\"UPDATED_ON\",\"RANK\",\"CREATED_BY\",\"DESCRIPTION\",\"NAME\",\"UPDATED_BY\",\"SCORECARD_MEASURE_ID\") VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE \"DEVELOPMENT_PLAN\" SET \"CREATED_ON\"=?,\"END_DATE\"=?,\"START_DATE\"=?,\"UPDATED_ON\"=?,\"RANK\"=?,\"CREATED_BY\"=?,\"DESCRIPTION\"=?,\"NAME\"=?,\"UPDATED_BY\"=?,\"SCORECARD_MEASURE_ID\"=? WHERE \"ID\"=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM \"DEVELOPMENT_PLAN\" WHERE \"ID\"=?";
	}
	
	@Override
	protected DevelopmentPlan extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	DevelopmentPlan nextResult = new DevelopmentPlan();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setCreatedOn(rs.getDate("CREATED_ON"));

nextResult.setEndDate(rs.getDate("END_DATE"));

nextResult.setStartDate(rs.getDate("START_DATE"));

nextResult.setUpdatedOn(rs.getDate("UPDATED_ON"));

nextResult.setRank(rs.getInt("RANK"));

nextResult.setCreatedBy(rs.getString("CREATED_BY"));

nextResult.setDescription(rs.getString("DESCRIPTION"));

nextResult.setName(rs.getString("NAME"));

nextResult.setUpdatedBy(rs.getString("UPDATED_BY"));

ScorecardMeasure scorecardmeasure = new ScorecardMeasure();
scorecardmeasure.setID(rs.getString("SCORECARD_MEASURE_ID"));
nextResult.setScorecardMeasure(scorecardmeasure);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(DevelopmentPlan perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setDate(2, DateUtils.utilDateToSqlDate(perceroObject.getCreatedOn()));
pstmt.setDate(3, DateUtils.utilDateToSqlDate(perceroObject.getEndDate()));
pstmt.setDate(4, DateUtils.utilDateToSqlDate(perceroObject.getStartDate()));
pstmt.setDate(5, DateUtils.utilDateToSqlDate(perceroObject.getUpdatedOn()));
pstmt.setInt(6, perceroObject.getRank());
pstmt.setString(7, perceroObject.getCreatedBy());
pstmt.setString(8, perceroObject.getDescription());
pstmt.setString(9, perceroObject.getName());
pstmt.setString(10, perceroObject.getUpdatedBy());

if (perceroObject.getScorecardMeasure() == null)
{
pstmt.setString(11, null);
}
else
{
		pstmt.setString(11, perceroObject.getScorecardMeasure().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(DevelopmentPlan perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setDate(1, DateUtils.utilDateToSqlDate(perceroObject.getCreatedOn()));
pstmt.setDate(2, DateUtils.utilDateToSqlDate(perceroObject.getEndDate()));
pstmt.setDate(3, DateUtils.utilDateToSqlDate(perceroObject.getStartDate()));
pstmt.setDate(4, DateUtils.utilDateToSqlDate(perceroObject.getUpdatedOn()));
pstmt.setInt(5, perceroObject.getRank());
pstmt.setString(6, perceroObject.getCreatedBy());
pstmt.setString(7, perceroObject.getDescription());
pstmt.setString(8, perceroObject.getName());
pstmt.setString(9, perceroObject.getUpdatedBy());

if (perceroObject.getScorecardMeasure() == null)
{
pstmt.setString(10, null);
}
else
{
		pstmt.setString(10, perceroObject.getScorecardMeasure().getID());
}

pstmt.setString(11, perceroObject.getID());

		
	}

	@Override
	public List<DevelopmentPlan> findByExample(DevelopmentPlan theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useCreatedOn = theQueryObject.getCreatedOn() != null && (excludeProperties == null || !excludeProperties.contains("createdOn"));

if (useCreatedOn)
{
sql += " WHERE ";
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

boolean useRank = theQueryObject.getRank() != null && (excludeProperties == null || !excludeProperties.contains("rank"));

if (useRank)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"RANK\" =? ";
paramValues.add(theQueryObject.getRank());
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

boolean useDescription = StringUtils.hasText(theQueryObject.getDescription()) && (excludeProperties == null || !excludeProperties.contains("description"));

if (useDescription)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"DESCRIPTION\" =? ";
paramValues.add(theQueryObject.getDescription());
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
