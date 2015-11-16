
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
public class WeeklyDevelopmentActivityDAO extends SqlDataAccessObject<WeeklyDevelopmentActivity> implements IDataAccessObject<WeeklyDevelopmentActivity> {

	static final Logger log = Logger.getLogger(WeeklyDevelopmentActivityDAO.class);

	
	public WeeklyDevelopmentActivityDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(WeeklyDevelopmentActivity.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	
	public static final String SHELL_ONLY_SELECT = "\"WEEKLY_DEVELOPMENT_ACTIVITY\".\"ID\"";
	public static final String SQL_VIEW = ",\"WEEKLY_DEVELOPMENT_ACTIVITY\".\"DEVELOPMENT_ACTIVITY_ID\",\"WEEKLY_DEVELOPMENT_ACTIVITY\".\"SCORECARD_WEEKLY_RESULT_ID\"";
	private String selectFromStatementTableName = " FROM \"WEEKLY_DEVELOPMENT_ACTIVITY\" \"WEEKLY_DEVELOPMENT_ACTIVITY\"";
	private String whereClause = "  WHERE \"WEEKLY_DEVELOPMENT_ACTIVITY\".\"ID\"=?";
	private String whereInClause = "  join table(sys.dbms_debug_vc2coll(?)) SQLLIST on \"WEEKLY_DEVELOPMENT_ACTIVITY\".\"ID\"= SQLLIST.column_value";
	private String orderByTableName = "  ORDER BY \"WEEKLY_DEVELOPMENT_ACTIVITY\".\"ID\"";
	
	

	
	@Override
	protected String getConnectionFactoryName() {
		return WeeklyDevelopmentActivityDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT " + SHELL_ONLY_SELECT +  " " + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT \"WEEKLY_DEVELOPMENT_ACTIVITY\".\"ID\"" + SQL_VIEW  + selectFromStatementTableName + whereClause;
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
		return "SELECT \"WEEKLY_DEVELOPMENT_ACTIVITY\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName  + orderByTableName;
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT \"WEEKLY_DEVELOPMENT_ACTIVITY\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + orderByTableName + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() 
	{
		return "SELECT COUNT(ID) " + selectFromStatementTableName;
	}
	
	@Override
	protected String getSelectInStarSQL() 
	{
		return "SELECT \"WEEKLY_DEVELOPMENT_ACTIVITY\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + whereInClause;
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName + whereInClause;
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		
		return "SELECT \"WEEKLY_DEVELOPMENT_ACTIVITY\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + " WHERE \"WEEKLY_DEVELOPMENT_ACTIVITY\"." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) 
	{
		
		return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName + " WHERE \"WEEKLY_DEVELOPMENT_ACTIVITY\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName;
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT \"WEEKLY_DEVELOPMENT_ACTIVITY\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName;
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO TBL_WEEKLY_DEVELOPMENT_ACTIVITY (\"ID\",\"DEVELOPMENT_ACTIVITY_ID\",\"SCORECARD_WEEKLY_RESULT_ID\") VALUES (?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE TBL_WEEKLY_DEVELOPMENT_ACTIVITY SET \"DEVELOPMENT_ACTIVITY_ID\"=?,\"SCORECARD_WEEKLY_RESULT_ID\"=? WHERE \"ID\"=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM TBL_WEEKLY_DEVELOPMENT_ACTIVITY WHERE \"ID\"=?";
	}
	
	@Override
	protected WeeklyDevelopmentActivity extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	
		
WeeklyDevelopmentActivity nextResult = null;
    	
		    	
    	if (nextResult == null) {
    		nextResult = new WeeklyDevelopmentActivity();
    	}

		
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			String developmentactivityID = rs.getString("DEVELOPMENT_ACTIVITY_ID");
if (StringUtils.hasText(developmentactivityID) && !"null".equalsIgnoreCase(developmentactivityID) ){
DevelopmentActivity developmentactivity = new DevelopmentActivity();
developmentactivity.setID(developmentactivityID);
nextResult.setDevelopmentActivity(developmentactivity);
}


String scorecardweeklyresultID = rs.getString("SCORECARD_WEEKLY_RESULT_ID");
if (StringUtils.hasText(scorecardweeklyresultID) && !"null".equalsIgnoreCase(scorecardweeklyresultID) ){
ScorecardWeeklyResult scorecardweeklyresult = new ScorecardWeeklyResult();
scorecardweeklyresult.setID(scorecardweeklyresultID);
nextResult.setScorecardWeeklyResult(scorecardweeklyresult);
}



			
    	}
		
		
    	return nextResult;
	}
	
	protected void setBaseStatmentInsertParams(WeeklyDevelopmentActivity perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());

if (perceroObject.getDevelopmentActivity() == null)
{
pstmt.setString(2, null);
}
else
{
		pstmt.setString(2, perceroObject.getDevelopmentActivity().getID());
}


if (perceroObject.getScorecardWeeklyResult() == null)
{
pstmt.setString(3, null);
}
else
{
		pstmt.setString(3, perceroObject.getScorecardWeeklyResult().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(WeeklyDevelopmentActivity perceroObject, PreparedStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
		
	}
	
	@Override
	protected void setCallableStatmentInsertParams(WeeklyDevelopmentActivity perceroObject, CallableStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	

	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(WeeklyDevelopmentActivity perceroObject, PreparedStatement pstmt) throws SQLException {
		
		
if (perceroObject.getDevelopmentActivity() == null)
{
pstmt.setString(1, null);
}
else
{
		pstmt.setString(1, perceroObject.getDevelopmentActivity().getID());
}


if (perceroObject.getScorecardWeeklyResult() == null)
{
pstmt.setString(2, null);
}
else
{
		pstmt.setString(2, perceroObject.getScorecardWeeklyResult().getID());
}

pstmt.setString(3, perceroObject.getID());

		
	}
	
	
	@Override
	protected void setCallableStatmentUpdateParams(WeeklyDevelopmentActivity perceroObject, CallableStatement pstmt) throws SQLException 
	{
		
		//must be in same order as insert
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	}
	
	

	@Override
	public List<WeeklyDevelopmentActivity> findByExample(WeeklyDevelopmentActivity theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useDevelopmentActivityID = theQueryObject.getDevelopmentActivity() != null && (excludeProperties == null || !excludeProperties.contains("developmentActivity"));

if (useDevelopmentActivityID)
{
sql += " WHERE ";
sql += " \"DEVELOPMENT_ACTIVITY_ID\" =? ";
paramValues.add(theQueryObject.getDevelopmentActivity().getID());
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
		return "{call UPDATE_WEEKLY_DEVELOPMENT_ACTIVITY(?,?,?)}";
	}
	@Override
	protected String getInsertCallableStatementSql() {
		return "{call CREATE_WEEKLY_DEVELOPMENT_ACTIVITY(?,?,?)}";
	}
	@Override
	protected String getDeleteCallableStatementSql() {
		return "{call Delete_WEEKLY_DEVELOPMENT_ACTIVITY(?)}";
	}
	
	
public WeeklyDevelopmentActivity createObject(WeeklyDevelopmentActivity perceroObject, String userId)
		throws SyncException {
	if ( !hasCreateAccess(BaseDataObject.toClassIdPair(perceroObject), userId) ) {
		return null;
	}

	long timeStart = System.currentTimeMillis();

	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	String query = "Select WEEKLY_DEVELOPMENT_ACTIVITY_SEQ.NEXTVAL from dual";
	String sql = null;
	String insertedId = "0";
	int result = 0;
	try {
		IConnectionFactory connectionFactory = getConnectionRegistry().getConnectionFactory(getConnectionFactoryName());
		conn = connectionFactory.getConnection();
		conn.setAutoCommit(false);
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			insertedId = rs.getString(1);
		}

		perceroObject.setID(insertedId);
		sql = getInsertIntoSQL();
		pstmt = conn.prepareStatement(sql);


		setPreparedStatmentInsertParams(perceroObject, pstmt);
		result = pstmt.executeUpdate();
		conn.commit();
	} catch(Exception e) {
		log.error("Unable to executeUpdate\n" + sql, e);
		throw new SyncDataException(e);
	} finally {
		try {
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.setAutoCommit(true);
				conn.close();
			}
		} catch (Exception e) {
			log.error("Error closing database statement/connection", e);
		}
	}

	long timeEnd = System.currentTimeMillis();
	long totalTime = timeEnd - timeStart;
	if (totalTime > LONG_RUNNING_QUERY_TIME) {
		log.warn("LONG RUNNING QUERY: " + totalTime + "ms\n" + sql);
	}

	if (result > 0) {
		return retrieveObject(BaseDataObject.toClassIdPair(perceroObject), userId, false);
	}
	else {
		return null;
	}
}


	
	
}
