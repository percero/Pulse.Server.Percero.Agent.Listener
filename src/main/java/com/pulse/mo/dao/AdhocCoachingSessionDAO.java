

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
import com.percero.agents.sync.vo.BaseDataObject;

import com.pulse.mo.*;


@Component
public class AdhocCoachingSessionDAO extends SqlDataAccessObject<AdhocCoachingSession> implements IDataAccessObject<AdhocCoachingSession> {

	static final Logger log = Logger.getLogger(AdhocCoachingSessionDAO.class);

	
	public AdhocCoachingSessionDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(AdhocCoachingSession.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	
	public static final String SQL_VIEW = ",\"ADHOC_COACHING_SESSION\".\"SESSION_TYPE\",\"ADHOC_COACHING_SESSION\".\"STATUS\",\"ADHOC_COACHING_SESSION\".\"WEEK_DATE\",\"ADHOC_COACHING_SESSION\".\"EMPLOYEE_ID\",\"ADHOC_COACHING_SESSION\".\"SCORECARD_ID\",\"ADHOC_COACHING_SESSION\".\"ADHOC_COACHING_CATEGORY_ID\",\"ADHOC_COACHING_SESSION\".\"AGENT_SCORECARD_ID\",\"ADHOC_COACHING_SESSION\".\"COMMENT_ID\"";
	private String selectFromStatementTableName = " FROM \"ADHOC_COACHING_SESSION\" \"ADHOC_COACHING_SESSION\"";
	private String whereClause = "  WHERE \"ADHOC_COACHING_SESSION\".\"ID\"=?";
	private String whereInClause = "  join table(sys.dbms_debug_vc2coll(?)) SQLLIST on \"ADHOC_COACHING_SESSION\".\"ID\"= SQLLIST.column_value";
	private String orderByTableName = "  ORDER BY \"ADHOC_COACHING_SESSION\".\"ID\"";
	
	private String joinAgentScorecardIDAdhocCoachingSession = ",(select ? As SQL_ID From Dual) WHERE ADHOC_COACHING_SESSION.EMPLOYEE_ID= SUBSTR(SQL_ID,0,9) AND ADHOC_COACHING_SESSION.SCORECARD_ID=SUBSTR(SQL_ID,INSTR(SQL_ID,'-', 1, 1) + 1,INSTR(SQL_ID,'-', 1, 2)-INSTR(SQL_ID,'-', 1, 1)-1) AND ADHOC_COACHING_SESSION.WEEK_DATE= SUBSTR(SQL_ID,INSTR(SQL_ID,'-', 1, 2) + 1,10)";


	
	@Override
	protected String getConnectionFactoryName() {
		return AdhocCoachingSessionDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT \"ADHOC_COACHING_SESSION\".\"ID\" " + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT \"ADHOC_COACHING_SESSION\".\"ID\"" + SQL_VIEW  + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT \"ADHOC_COACHING_SESSION\".\"ID\" " + selectFromStatementTableName +  orderByTableName;
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT \"ADHOC_COACHING_SESSION\".\"ID\" " + selectFromStatementTableName  +  orderByTableName  + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT \"ADHOC_COACHING_SESSION\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName  + orderByTableName;
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT \"ADHOC_COACHING_SESSION\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + orderByTableName + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() 
	{
		return "SELECT COUNT(ID) " + selectFromStatementTableName;
	}
	
	@Override
	protected String getSelectInStarSQL() 
	{
		return "SELECT \"ADHOC_COACHING_SESSION\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + whereInClause;
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT \"ADHOC_COACHING_SESSION\".\"ID\" " + selectFromStatementTableName + whereInClause;
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		if (joinColumnName.equalsIgnoreCase("\"AGENT_SCORECARD_ID\""))
{
return "SELECT \"ADHOC_COACHING_SESSION\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + joinAgentScorecardIDAdhocCoachingSession;
}

		return "SELECT \"ADHOC_COACHING_SESSION\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + " WHERE \"ADHOC_COACHING_SESSION\"." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) 
	{
		if (joinColumnName.equalsIgnoreCase("\"AGENT_SCORECARD_ID\""))
{
return "SELECT \"ADHOC_COACHING_SESSION\".\"ID\" " + selectFromStatementTableName + joinAgentScorecardIDAdhocCoachingSession;
}

		return "SELECT \"ADHOC_COACHING_SESSION\".\"ID\" " + selectFromStatementTableName + " WHERE \"ADHOC_COACHING_SESSION\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT \"ADHOC_COACHING_SESSION\".\"ID\" " + selectFromStatementTableName;
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT \"ADHOC_COACHING_SESSION\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName;
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO EFC_SESSION  (\"SESSION_ID\", \"EMPLOYEE_ID\", \"WK_DATE\", \"SCORECARD_ID\", \"TYPE\", \"STATUS\", \"CREATED_BY\", \"UPDATED_BY\", \"CREATED_ON\", \"UPDATED_ON\", \"IS_REQUIRED\",\"RESPONSIBLE_COACH\", \"CATEGORY_ID\") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE TBL_ADHOC_COACHING_SESSION SET \"SESSION_TYPE\"=?,\"STATUS\"=?,\"WEEK_DATE\"=?,\"EMPLOYEE_ID\"=?,\"SCORECARD_ID\"=?,\"ADHOC_COACHING_CATEGORY_ID\"=?,\"AGENT_SCORECARD_ID\"=?,\"COMMENT_ID\"=? WHERE \"ID\"=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM TBL_ADHOC_COACHING_SESSION WHERE \"ID\"=?";
	}
	
	@Override
	protected AdhocCoachingSession extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	AdhocCoachingSession nextResult = new AdhocCoachingSession();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setSessionType(rs.getString("SESSION_TYPE"));

nextResult.setStatus(rs.getString("STATUS"));

nextResult.setWeekDate(rs.getDate("WEEK_DATE"));

nextResult.setEmployeeId(rs.getInt("EMPLOYEE_ID"));

nextResult.setScorecardId(rs.getInt("SCORECARD_ID"));

AdhocCoachingCategory adhoccoachingcategory = new AdhocCoachingCategory();
adhoccoachingcategory.setID(rs.getString("ADHOC_COACHING_CATEGORY_ID"));
nextResult.setAdhocCoachingCategory(adhoccoachingcategory);

AgentScorecard agentscorecard = new AgentScorecard();
agentscorecard.setID(rs.getString("AGENT_SCORECARD_ID"));
nextResult.setAgentScorecard(agentscorecard);

Comment comment = new Comment();
comment.setID(rs.getString("COMMENT_ID"));
nextResult.setComment(comment);


			
    	}
    	
    	return nextResult;
	}

	protected void setBaseStatmentInsertParams(AdhocCoachingSession perceroObject, PreparedStatement pstmt) throws SQLException {
		pstmt.setString(1, perceroObject.getID());  //SESSION_ID
		pstmt.setInt(2, perceroObject.getEmployeeId());  //EMPLOYEE_ID
		pstmt.setDate(3, DateUtils.utilDateToSqlDate(perceroObject.getWeekDate()));  //WK_DATE
		pstmt.setInt(4, 0); // not a follow up  session  SCORECARD_ID
		pstmt.setInt(5, 3); //Adhoc Coaching session - TYPE
		pstmt.setString(6, perceroObject.getStatus());  //STATUS

		pstmt.setInt(7, perceroObject.getEmployeeId());  //CREATED_BY
		pstmt.setInt(8, perceroObject.getEmployeeId());	//UPDATED_BY

		pstmt.setDate(9, DateUtils.utilDateToSqlDate(new java.util.Date()));  //CREATED_ON
		pstmt.setDate(10, DateUtils.utilDateToSqlDate(new java.util.Date()));  //UPDATED_ON
		pstmt.setInt(11, 0); //IS_REQUIRED
		pstmt.setInt(12, perceroObject.getEmployeeId()); //RESPONSIBLE_COACH

		if (perceroObject.getAdhocCoachingCategory() == null)
		{
			pstmt.setString(13, null);  //CATEGORY_ID
		}
		else
		{
			pstmt.setString(13, perceroObject.getAdhocCoachingCategory().getID());  //CATEGORY_ID
		}


	}
	
	@Override
	protected void setPreparedStatmentInsertParams(AdhocCoachingSession perceroObject, PreparedStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
		
	}
	
	@Override
	protected void setCallableStatmentInsertParams(AdhocCoachingSession perceroObject, CallableStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	

	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(AdhocCoachingSession perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getSessionType());
pstmt.setString(2, perceroObject.getStatus());
pstmt.setDate(3, DateUtils.utilDateToSqlDate(perceroObject.getWeekDate()));
JdbcHelper.setInt(pstmt,4, perceroObject.getEmployeeId());
JdbcHelper.setInt(pstmt,5, perceroObject.getScorecardId());

if (perceroObject.getAdhocCoachingCategory() == null)
{
pstmt.setString(6, null);
}
else
{
		pstmt.setString(6, perceroObject.getAdhocCoachingCategory().getID());
}


if (perceroObject.getAgentScorecard() == null)
{
pstmt.setString(7, null);
}
else
{
		pstmt.setString(7, perceroObject.getAgentScorecard().getID());
}


if (perceroObject.getComment() == null)
{
pstmt.setString(8, null);
}
else
{
		pstmt.setString(8, perceroObject.getComment().getID());
}

pstmt.setString(9, perceroObject.getID());

		
	}
	
	
	@Override
	protected void setCallableStatmentUpdateParams(AdhocCoachingSession perceroObject, CallableStatement pstmt) throws SQLException 
	{
		
		//must be in same order as insert
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	}
	
	

	@Override
	public List<AdhocCoachingSession> findByExample(AdhocCoachingSession theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useSessionType = StringUtils.hasText(theQueryObject.getSessionType()) && (excludeProperties == null || !excludeProperties.contains("sessionType"));

if (useSessionType)
{
sql += " WHERE ";
sql += " \"SESSION_TYPE\" =? ";
paramValues.add(theQueryObject.getSessionType());
propertyCounter++;
}

boolean useStatus = StringUtils.hasText(theQueryObject.getStatus()) && (excludeProperties == null || !excludeProperties.contains("status"));

if (useStatus)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"STATUS\" =? ";
paramValues.add(theQueryObject.getStatus());
propertyCounter++;
}

boolean useWeekDate = theQueryObject.getWeekDate() != null && (excludeProperties == null || !excludeProperties.contains("weekDate"));

if (useWeekDate)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"WEEK_DATE\" =? ";
paramValues.add(theQueryObject.getWeekDate());
propertyCounter++;
}

boolean useEmployeeId = theQueryObject.getEmployeeId() != null && (excludeProperties == null || !excludeProperties.contains("employeeId"));

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

boolean useScorecardId = theQueryObject.getScorecardId() != null && (excludeProperties == null || !excludeProperties.contains("scorecardId"));

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

boolean useAdhocCoachingCategoryID = theQueryObject.getAdhocCoachingCategory() != null && (excludeProperties == null || !excludeProperties.contains("adhocCoachingCategory"));

if (useAdhocCoachingCategoryID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"ADHOC_COACHING_CATEGORY_ID\" =? ";
paramValues.add(theQueryObject.getAdhocCoachingCategory().getID());
propertyCounter++;
}

boolean useAgentScorecardID = theQueryObject.getAgentScorecard() != null && (excludeProperties == null || !excludeProperties.contains("agentScorecard"));

if (useAgentScorecardID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"AGENT_SCORECARD_ID\" =? ";
paramValues.add(theQueryObject.getAgentScorecard().getID());
propertyCounter++;
}

boolean useCommentID = theQueryObject.getComment() != null && (excludeProperties == null || !excludeProperties.contains("comment"));

if (useCommentID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"COMMENT_ID\" =? ";
paramValues.add(theQueryObject.getComment().getID());
propertyCounter++;
}



		if (propertyCounter == 0) {
			throw new SyncException(SyncException.METHOD_UNSUPPORTED, SyncException.METHOD_UNSUPPORTED_CODE);
		}
		
		return executeSelectWithParams(sql, paramValues.toArray(), shellOnly);		
	}
	
	@Override
	protected String getUpdateCallableStatementSql() {
		return "{call UPDATE_ADHOC_COACHING_SESSION(?,?,?,?,?,?,?,?,?)}";
	}
	@Override
	protected String getInsertCallableStatementSql() {
		return "{call CREATE_ADHOC_COACHING_SESSION(?,?,?,?,?,?,?,?,?)}";
	}
	@Override
	protected String getDeleteCallableStatementSql() {
		return "{call Delete_ADHOC_COACHING_SESSION(?)}";
	}
	
	
	

	public AdhocCoachingSession createObject(AdhocCoachingSession perceroObject, String userId)
			throws SyncException {
		if ( !hasCreateAccess(BaseDataObject.toClassIdPair(perceroObject), userId) ) {
			return null;
		}

		long timeStart = System.currentTimeMillis();

		Connection conn = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		String query = "Select EFC_SESSION_SEQ.NEXTVAL from dual";
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

