
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
public class BehaviorDAO extends SqlDataAccessObject<Behavior> implements IDataAccessObject<Behavior> {

	static final Logger log = Logger.getLogger(BehaviorDAO.class);

	
	public BehaviorDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(Behavior.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	
	public static final String SQL_VIEW = ",\"BEHAVIOR\".\"UPDATED_BY\",\"BEHAVIOR\".\"IS_REMOVED\",\"BEHAVIOR\".\"CREATED_ON\",\"BEHAVIOR\".\"END_DATE\",\"BEHAVIOR\".\"START_DATE\",\"BEHAVIOR\".\"UPDATED_ON\",\"BEHAVIOR\".\"RANK\",\"BEHAVIOR\".\"CREATED_BY\",\"BEHAVIOR\".\"DESCRIPTION\",\"BEHAVIOR\".\"NAME\",\"BEHAVIOR\".\"SCOPE\",\"BEHAVIOR\".\"SCORECARD_MEASURE_ID\"";
	private String selectFromStatementTableName = " FROM \"BEHAVIOR\" \"BEHAVIOR\"";
	private String whereClause = "  WHERE \"BEHAVIOR\".\"ID\"=?";
	private String whereInClause = "  join table(sys.dbms_debug_vc2coll(?)) SQLLIST on \"BEHAVIOR\".\"ID\"= SQLLIST.column_value";
	private String orderByTableName = "  ORDER BY \"BEHAVIOR\".\"ID\"";
	
	

	
	@Override
	protected String getConnectionFactoryName() {
		return BehaviorDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT \"BEHAVIOR\".\"ID\" " + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT \"BEHAVIOR\".\"ID\"" + SQL_VIEW  + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT \"BEHAVIOR\".\"ID\" " + selectFromStatementTableName +  orderByTableName;
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT \"BEHAVIOR\".\"ID\" " + selectFromStatementTableName  +  orderByTableName  + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT \"BEHAVIOR\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName  + orderByTableName;
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT \"BEHAVIOR\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + orderByTableName + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() 
	{
		return "SELECT COUNT(ID) " + selectFromStatementTableName;
	}
	
	@Override
	protected String getSelectInStarSQL() 
	{
		return "SELECT \"BEHAVIOR\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + whereInClause;
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT \"BEHAVIOR\".\"ID\" " + selectFromStatementTableName + whereInClause;
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		
		return "SELECT \"BEHAVIOR\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + " WHERE \"BEHAVIOR\"." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) 
	{
		
		return "SELECT \"BEHAVIOR\".\"ID\" " + selectFromStatementTableName + " WHERE \"BEHAVIOR\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT \"BEHAVIOR\".\"ID\" " + selectFromStatementTableName;
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT \"BEHAVIOR\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName;
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO TBL_BEHAVIOR (\"ID\",\"UPDATED_BY\",\"IS_REMOVED\",\"CREATED_ON\",\"END_DATE\",\"START_DATE\",\"UPDATED_ON\",\"RANK\",\"CREATED_BY\",\"DESCRIPTION\",\"NAME\",\"SCOPE\",\"SCORECARD_MEASURE_ID\") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE TBL_BEHAVIOR SET \"UPDATED_BY\"=?,\"IS_REMOVED\"=?,\"CREATED_ON\"=?,\"END_DATE\"=?,\"START_DATE\"=?,\"UPDATED_ON\"=?,\"RANK\"=?,\"CREATED_BY\"=?,\"DESCRIPTION\"=?,\"NAME\"=?,\"SCOPE\"=?,\"SCORECARD_MEASURE_ID\"=? WHERE \"ID\"=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM TBL_BEHAVIOR WHERE \"ID\"=?";
	}
	
	@Override
	protected Behavior extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	Behavior nextResult = new Behavior();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setUpdatedBY(rs.getString("UPDATED_BY"));

nextResult.setIsRemoved(rs.getBoolean("IS_REMOVED"));

nextResult.setCreatedOn(rs.getDate("CREATED_ON"));

nextResult.setEndDate(rs.getDate("END_DATE"));

nextResult.setStartDate(rs.getDate("START_DATE"));

nextResult.setUpdatedOn(rs.getDate("UPDATED_ON"));

nextResult.setRank(rs.getInt("RANK"));

nextResult.setCreatedBy(rs.getString("CREATED_BY"));

nextResult.setDescription(rs.getString("DESCRIPTION"));

nextResult.setName(rs.getString("NAME"));

nextResult.setScope(rs.getString("SCOPE"));

ScorecardMeasure scorecardmeasure = new ScorecardMeasure();
scorecardmeasure.setID(rs.getString("SCORECARD_MEASURE_ID"));
nextResult.setScorecardMeasure(scorecardmeasure);


			
    	}
    	
    	return nextResult;
	}
	
	protected void setBaseStatmentInsertParams(Behavior perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getUpdatedBY());
JdbcHelper.setBoolean(pstmt,3, perceroObject.getIsRemoved());
pstmt.setDate(4, DateUtils.utilDateToSqlDate(perceroObject.getCreatedOn()));
pstmt.setDate(5, DateUtils.utilDateToSqlDate(perceroObject.getEndDate()));
pstmt.setDate(6, DateUtils.utilDateToSqlDate(perceroObject.getStartDate()));
pstmt.setDate(7, DateUtils.utilDateToSqlDate(perceroObject.getUpdatedOn()));
JdbcHelper.setInt(pstmt,8, perceroObject.getRank());
pstmt.setString(9, perceroObject.getCreatedBy());
pstmt.setString(10, perceroObject.getDescription());
pstmt.setString(11, perceroObject.getName());
pstmt.setString(12, perceroObject.getScope());

if (perceroObject.getScorecardMeasure() == null)
{
pstmt.setString(13, null);
}
else
{
		pstmt.setString(13, perceroObject.getScorecardMeasure().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(Behavior perceroObject, PreparedStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
		
	}
	
	@Override
	protected void setCallableStatmentInsertParams(Behavior perceroObject, CallableStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	

	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(Behavior perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getUpdatedBY());
JdbcHelper.setBoolean(pstmt,2, perceroObject.getIsRemoved());
pstmt.setDate(3, DateUtils.utilDateToSqlDate(perceroObject.getCreatedOn()));
pstmt.setDate(4, DateUtils.utilDateToSqlDate(perceroObject.getEndDate()));
pstmt.setDate(5, DateUtils.utilDateToSqlDate(perceroObject.getStartDate()));
pstmt.setDate(6, DateUtils.utilDateToSqlDate(perceroObject.getUpdatedOn()));
JdbcHelper.setInt(pstmt,7, perceroObject.getRank());
pstmt.setString(8, perceroObject.getCreatedBy());
pstmt.setString(9, perceroObject.getDescription());
pstmt.setString(10, perceroObject.getName());
pstmt.setString(11, perceroObject.getScope());

if (perceroObject.getScorecardMeasure() == null)
{
pstmt.setString(12, null);
}
else
{
		pstmt.setString(12, perceroObject.getScorecardMeasure().getID());
}

pstmt.setString(13, perceroObject.getID());

		
	}
	
	
	@Override
	protected void setCallableStatmentUpdateParams(Behavior perceroObject, CallableStatement pstmt) throws SQLException 
	{
		
		//must be in same order as insert
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	}
	
	

	@Override
	public List<Behavior> findByExample(Behavior theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useUpdatedBY = StringUtils.hasText(theQueryObject.getUpdatedBY()) && (excludeProperties == null || !excludeProperties.contains("updatedBY"));

if (useUpdatedBY)
{
sql += " WHERE ";
sql += " \"UPDATED_BY\" =? ";
paramValues.add(theQueryObject.getUpdatedBY());
propertyCounter++;
}

boolean useIsRemoved = theQueryObject.getIsRemoved() != null && (excludeProperties == null || !excludeProperties.contains("isRemoved"));

if (useIsRemoved)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"IS_REMOVED\" =? ";
paramValues.add(theQueryObject.getIsRemoved());
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

boolean useScope = StringUtils.hasText(theQueryObject.getScope()) && (excludeProperties == null || !excludeProperties.contains("scope"));

if (useScope)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"SCOPE\" =? ";
paramValues.add(theQueryObject.getScope());
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



		if (propertyCounter == 0) {
			throw new SyncException(SyncException.METHOD_UNSUPPORTED, SyncException.METHOD_UNSUPPORTED_CODE);
		}
		
		return executeSelectWithParams(sql, paramValues.toArray(), shellOnly);		
	}
	
	@Override
	protected String getUpdateCallableStatementSql() {
		return "{call UPDATE_BEHAVIOR(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	}
	@Override
	protected String getInsertCallableStatementSql() {
		return "{call CREATE_BEHAVIOR(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	}
	@Override
	protected String getDeleteCallableStatementSql() {
		return "{call Delete_BEHAVIOR(?)}";
	}
	
	
	
	
}
