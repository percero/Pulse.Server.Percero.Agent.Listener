
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
	
	public static final String SQL_VIEW = ",\"SCORECARD_MEASURE\".\"NAME\",\"SCORECARD_MEASURE\".\"REWARD_ACTIVE\",\"SCORECARD_MEASURE\".\"SCORECARD_ID\",\"SCORECARD_MEASURE\".\"MEASURE_ID\"";
	private String selectFromStatementTableName = " FROM \"SCORECARD_MEASURE\" \"SCORECARD_MEASURE\"";
	private String whereClause = "  WHERE \"SCORECARD_MEASURE\".\"ID\"=?";
	private String whereInClause = "  join table(sys.dbms_debug_vc2coll(?)) SQLLIST on \"SCORECARD_MEASURE\".\"ID\"= SQLLIST.column_value";
	private String orderByTableName = "  ORDER BY \"SCORECARD_MEASURE\".\"ID\"";
	
	

	
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
		return "INSERT INTO TBL_SCORECARD_MEASURE (\"ID\",\"NAME\",\"REWARD_ACTIVE\",\"SCORECARD_ID\",\"MEASURE_ID\") VALUES (?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE TBL_SCORECARD_MEASURE SET \"NAME\"=?,\"REWARD_ACTIVE\"=?,\"SCORECARD_ID\"=?,\"MEASURE_ID\"=? WHERE \"ID\"=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM TBL_SCORECARD_MEASURE WHERE \"ID\"=?";
	}
	
	@Override
	protected ScorecardMeasure extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	ScorecardMeasure nextResult = new ScorecardMeasure();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setName(rs.getString("NAME"));

nextResult.setRewardActive(rs.getString("REWARD_ACTIVE"));

Scorecard scorecard = new Scorecard();
scorecard.setID(rs.getString("SCORECARD_ID"));
nextResult.setScorecard(scorecard);

Measure measure = new Measure();
measure.setID(rs.getString("MEASURE_ID"));
nextResult.setMeasure(measure);


			
    	}
    	
    	return nextResult;
	}
	
	protected void setBaseStatmentInsertParams(ScorecardMeasure perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getName());
pstmt.setString(3, perceroObject.getRewardActive());

if (perceroObject.getScorecard() == null)
{
pstmt.setString(4, null);
}
else
{
		pstmt.setString(4, perceroObject.getScorecard().getID());
}


if (perceroObject.getMeasure() == null)
{
pstmt.setString(5, null);
}
else
{
		pstmt.setString(5, perceroObject.getMeasure().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(ScorecardMeasure perceroObject, PreparedStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
		
	}
	
	@Override
	protected void setCallableStatmentInsertParams(ScorecardMeasure perceroObject, CallableStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	

	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(ScorecardMeasure perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getName());
pstmt.setString(2, perceroObject.getRewardActive());

if (perceroObject.getScorecard() == null)
{
pstmt.setString(3, null);
}
else
{
		pstmt.setString(3, perceroObject.getScorecard().getID());
}


if (perceroObject.getMeasure() == null)
{
pstmt.setString(4, null);
}
else
{
		pstmt.setString(4, perceroObject.getMeasure().getID());
}

pstmt.setString(5, perceroObject.getID());

		
	}
	
	
	@Override
	protected void setCallableStatmentUpdateParams(ScorecardMeasure perceroObject, CallableStatement pstmt) throws SQLException 
	{
		
		//must be in same order as insert
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	}
	
	

	@Override
	public List<ScorecardMeasure> findByExample(ScorecardMeasure theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useName = StringUtils.hasText(theQueryObject.getName()) && (excludeProperties == null || !excludeProperties.contains("name"));

if (useName)
{
sql += " WHERE ";
sql += " \"NAME\" =? ";
paramValues.add(theQueryObject.getName());
propertyCounter++;
}

boolean useRewardActive = StringUtils.hasText(theQueryObject.getRewardActive()) && (excludeProperties == null || !excludeProperties.contains("rewardActive"));

if (useRewardActive)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"REWARD_ACTIVE\" =? ";
paramValues.add(theQueryObject.getRewardActive());
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



		if (propertyCounter == 0) {
			throw new SyncException(SyncException.METHOD_UNSUPPORTED, SyncException.METHOD_UNSUPPORTED_CODE);
		}
		
		return executeSelectWithParams(sql, paramValues.toArray(), shellOnly);		
	}
	
	@Override
	protected String getUpdateCallableStatementSql() {
		return "{call UPDATE_SCORECARD_MEASURE(?,?,?,?,?)}";
	}
	@Override
	protected String getInsertCallableStatementSql() {
		return "{call CREATE_SCORECARD_MEASURE(?,?,?,?,?)}";
	}
	@Override
	protected String getDeleteCallableStatementSql() {
		return "{call Delete_SCORECARD_MEASURE(?)}";
	}
	
	
	
	
}
