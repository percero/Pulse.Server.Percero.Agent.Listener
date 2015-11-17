

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
public class CoachingSessionDAO extends SqlDataAccessObject<CoachingSession> implements IDataAccessObject<CoachingSession> {

	static final Logger log = Logger.getLogger(CoachingSessionDAO.class);

	
	public CoachingSessionDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(CoachingSession.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	
	public static final String SHELL_ONLY_SELECT = "\"COACHING_SESSION\".\"ID\"";
	public static final String SQL_VIEW = ",\"COACHING_SESSION\".\"IS_REQUIRED\",\"COACHING_SESSION\".\"CREATED_BY\",\"COACHING_SESSION\".\"TYPE\",\"COACHING_SESSION\".\"UPDATED_BY\",\"COACHING_SESSION\".\"CLOSED_ON\",\"COACHING_SESSION\".\"CREATED_ON\",\"COACHING_SESSION\".\"UPDATED_ON\",\"COACHING_SESSION\".\"WEEK_DATE\",\"COACHING_SESSION\".\"EMPLOYEE_ID\",\"COACHING_SESSION\".\"AGENT_ID\",\"COACHING_SESSION\".\"AGENT_SCORECARD_ID\",\"COACHING_SESSION\".\"COACHING_SESSION_STATE_ID\",\"COACHING_SESSION\".\"SCORECARD_ID\"";
	private String selectFromStatementTableName = " FROM \"COACHING_SESSION\" \"COACHING_SESSION\"";
	private String whereClause = "  WHERE \"COACHING_SESSION\".\"ID\"=?";
	private String whereInClause = "  join table(sys.dbms_debug_vc2coll(?)) SQLLIST on \"COACHING_SESSION\".\"ID\"= SQLLIST.column_value";
	private String orderByTableName = "  ORDER BY \"COACHING_SESSION\".\"ID\"";
	
	private String joinAgentScorecardIDCoachingSession = ",(select ? As SQL_ID From Dual) WHERE COACHING_SESSION.EMPLOYEE_ID= SUBSTR(SQL_ID,0,9) AND COACHING_SESSION.SCORECARD_ID=SUBSTR(SQL_ID,INSTR(SQL_ID,'-', 1, 1) + 1,INSTR(SQL_ID,'-', 1, 2)-INSTR(SQL_ID,'-', 1, 1)-1) AND COACHING_SESSION.WEEK_DATE= SUBSTR(SQL_ID,INSTR(SQL_ID,'-', 1, 2) + 1,10)";


	
	@Override
	protected String getConnectionFactoryName() {
		return CoachingSessionDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT " + SHELL_ONLY_SELECT +  " " + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT \"COACHING_SESSION\".\"ID\"" + SQL_VIEW  + selectFromStatementTableName + whereClause;
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
		return "SELECT \"COACHING_SESSION\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName  + orderByTableName;
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT \"COACHING_SESSION\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + orderByTableName + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() 
	{
		return "SELECT COUNT(ID) " + selectFromStatementTableName;
	}
	
	@Override
	protected String getSelectInStarSQL() 
	{
		return "SELECT \"COACHING_SESSION\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + whereInClause;
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName + whereInClause;
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		if (joinColumnName.equalsIgnoreCase("\"AGENT_SCORECARD_ID\""))
{
return "SELECT \"COACHING_SESSION\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + joinAgentScorecardIDCoachingSession;
}

		return "SELECT \"COACHING_SESSION\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + " WHERE \"COACHING_SESSION\"." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) 
	{
		if (joinColumnName.equalsIgnoreCase("\"AGENT_SCORECARD_ID\""))
{
return "SELECT \"COACHING_SESSION\".\"ID\" " + selectFromStatementTableName + joinAgentScorecardIDCoachingSession;
}

		return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName + " WHERE \"COACHING_SESSION\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName;
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT \"COACHING_SESSION\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName;
	}

	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO EFC_SESSION  (\"SESSION_ID\", \"EMPLOYEE_ID\", \"WK_DATE\", \"SCORECARD_ID\", \"TYPE\", \"STATUS\", \"CREATED_BY\", \"UPDATED_BY\", \"CREATED_ON\", \"UPDATED_ON\", \"IS_REQUIRED\",\"RESPONSIBLE_COACH\", \"CATEGORY_ID\") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE TBL_COACHING_SESSION SET \"IS_REQUIRED\"=?,\"CREATED_BY\"=?,\"TYPE\"=?,\"UPDATED_BY\"=?,\"CLOSED_ON\"=?,\"CREATED_ON\"=?,\"UPDATED_ON\"=?,\"WEEK_DATE\"=?,\"EMPLOYEE_ID\"=?,\"AGENT_ID\"=?,\"AGENT_SCORECARD_ID\"=?,\"COACHING_SESSION_STATE_ID\"=?,\"SCORECARD_ID\"=? WHERE \"ID\"=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM TBL_COACHING_SESSION WHERE \"ID\"=?";
	}
	
	@Override
	protected CoachingSession extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	
		

CoachingSession nextResult = null;
    	
		    	
    	if (nextResult == null) {
    		nextResult = new CoachingSession();
    	}

		
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setIsRequired(rs.getBoolean("IS_REQUIRED"));


nextResult.setCreatedBy(rs.getString("CREATED_BY"));


nextResult.setType(rs.getString("TYPE"));


nextResult.setUpdatedBy(rs.getString("UPDATED_BY"));


nextResult.setClosedOn(DateUtils.utilDateFromSqlTimestamp(rs.getTimestamp("CLOSED_ON")));


nextResult.setCreatedOn(DateUtils.utilDateFromSqlTimestamp(rs.getTimestamp("CREATED_ON")));


nextResult.setUpdatedOn(DateUtils.utilDateFromSqlTimestamp(rs.getTimestamp("UPDATED_ON")));


nextResult.setWeekDate(DateUtils.utilDateFromSqlTimestamp(rs.getTimestamp("WEEK_DATE")));


nextResult.setEmployeeId(rs.getInt("EMPLOYEE_ID"));


String agentID = rs.getString("AGENT_ID");
if (StringUtils.hasText(agentID) && !"null".equalsIgnoreCase(agentID) ){
Agent agent = new Agent();
agent.setID(agentID);
nextResult.setAgent(agent);
}


String agentscorecardID = rs.getString("AGENT_SCORECARD_ID");
if (StringUtils.hasText(agentscorecardID) && !"null".equalsIgnoreCase(agentscorecardID) ){
AgentScorecard agentscorecard = new AgentScorecard();
agentscorecard.setID(agentscorecardID);
nextResult.setAgentScorecard(agentscorecard);
}


String coachingsessionstateID = rs.getString("COACHING_SESSION_STATE_ID");
if (StringUtils.hasText(coachingsessionstateID) && !"null".equalsIgnoreCase(coachingsessionstateID) ){
CoachingSessionState coachingsessionstate = new CoachingSessionState();
coachingsessionstate.setID(coachingsessionstateID);
nextResult.setCoachingSessionState(coachingsessionstate);
}


String scorecardID = rs.getString("SCORECARD_ID");
if (StringUtils.hasText(scorecardID) && !"null".equalsIgnoreCase(scorecardID) ){
Scorecard scorecard = new Scorecard();
scorecard.setID(scorecardID);
nextResult.setScorecard(scorecard);
}



			
    	}
		
		
    	return nextResult;
	}

	protected void setBaseStatmentInsertParams(CoachingSession perceroObject, PreparedStatement pstmt) throws SQLException {

		pstmt.setString(1, perceroObject.getID());  //SESSION_ID
		pstmt.setInt(2, perceroObject.getEmployeeId());  //EMPLOYEE_ID
		pstmt.setDate(3, DateUtils.utilDateToSqlDate(perceroObject.getWeekDate()));  //WK_DATE
		if (perceroObject.getAgentScorecard() == null)  // follow up  session  SCORECARD_ID
		{
			pstmt.setString(4, null);
		}
		else
		{
			pstmt.setString(4, perceroObject.getAgentScorecard().getID());
		}

		pstmt.setInt(5, 2); //Followup Coaching session - TYPE

		pstmt.setString(6, perceroObject.getCoachingSessionState().getID());  //STATUS

		pstmt.setString(7, perceroObject.getCreatedBy());  //CREATED_BY
		pstmt.setString(8, perceroObject.getUpdatedBy());    //UPDATED_BY

		pstmt.setDate(9, DateUtils.utilDateToSqlDate(perceroObject.getCreatedOn()));  //CREATED_ON
		pstmt.setDate(10, DateUtils.utilDateToSqlDate(perceroObject.getUpdatedOn()));  //UPDATED_ON
		pstmt.setInt(11, 0); //IS_REQUIRED
		pstmt.setInt(12, perceroObject.getEmployeeId()); //RESPONSIBLE_COACH     TODO Fix this

		pstmt.setInt(13, 0);  //CATEGORY_ID  - For follow up it is 0.


	}
	
	@Override
	protected void setPreparedStatmentInsertParams(CoachingSession perceroObject, PreparedStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
		
	}
	
	@Override
	protected void setCallableStatmentInsertParams(CoachingSession perceroObject, CallableStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	

	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(CoachingSession perceroObject, PreparedStatement pstmt) throws SQLException {
		
		JdbcHelper.setBoolean(pstmt,1, perceroObject.getIsRequired());
pstmt.setString(2, perceroObject.getCreatedBy());
pstmt.setString(3, perceroObject.getType());
pstmt.setString(4, perceroObject.getUpdatedBy());
pstmt.setDate(5, DateUtils.utilDateToSqlDate(perceroObject.getClosedOn()));
pstmt.setDate(6, DateUtils.utilDateToSqlDate(perceroObject.getCreatedOn()));
pstmt.setDate(7, DateUtils.utilDateToSqlDate(perceroObject.getUpdatedOn()));
pstmt.setDate(8, DateUtils.utilDateToSqlDate(perceroObject.getWeekDate()));
JdbcHelper.setInt(pstmt,9, perceroObject.getEmployeeId());

if (perceroObject.getAgent() == null)
{
pstmt.setString(10, null);
}
else
{
		pstmt.setString(10, perceroObject.getAgent().getID());
}


if (perceroObject.getAgentScorecard() == null)
{
pstmt.setString(11, null);
}
else
{
		pstmt.setString(11, perceroObject.getAgentScorecard().getID());
}


if (perceroObject.getCoachingSessionState() == null)
{
pstmt.setString(12, null);
}
else
{
		pstmt.setString(12, perceroObject.getCoachingSessionState().getID());
}


if (perceroObject.getScorecard() == null)
{
pstmt.setString(13, null);
}
else
{
		pstmt.setString(13, perceroObject.getScorecard().getID());
}

pstmt.setString(14, perceroObject.getID());

		
	}
	
	
	@Override
	protected void setCallableStatmentUpdateParams(CoachingSession perceroObject, CallableStatement pstmt) throws SQLException 
	{
		
		//must be in same order as insert
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	}
	
	

	@Override
	public List<CoachingSession> findByExample(CoachingSession theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useIsRequired = theQueryObject.getIsRequired() != null && (excludeProperties == null || !excludeProperties.contains("isRequired"));

if (useIsRequired)
{
sql += " WHERE ";
sql += " \"IS_REQUIRED\" =? ";
paramValues.add(theQueryObject.getIsRequired());
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

boolean useType = StringUtils.hasText(theQueryObject.getType()) && (excludeProperties == null || !excludeProperties.contains("type"));

if (useType)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"TYPE\" =? ";
paramValues.add(theQueryObject.getType());
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

boolean useClosedOn = theQueryObject.getClosedOn() != null && (excludeProperties == null || !excludeProperties.contains("closedOn"));

if (useClosedOn)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"CLOSED_ON\" =? ";
paramValues.add(theQueryObject.getClosedOn());
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

boolean useAgentID = theQueryObject.getAgent() != null && (excludeProperties == null || !excludeProperties.contains("agent"));

if (useAgentID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"AGENT_ID\" =? ";
paramValues.add(theQueryObject.getAgent().getID());
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

boolean useCoachingSessionStateID = theQueryObject.getCoachingSessionState() != null && (excludeProperties == null || !excludeProperties.contains("coachingSessionState"));

if (useCoachingSessionStateID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"COACHING_SESSION_STATE_ID\" =? ";
paramValues.add(theQueryObject.getCoachingSessionState().getID());
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



		if (propertyCounter == 0) {
			throw new SyncException(SyncException.METHOD_UNSUPPORTED, SyncException.METHOD_UNSUPPORTED_CODE);
		}
		
		return executeSelectWithParams(sql, paramValues.toArray(), shellOnly);		
	}
	
	@Override
	protected String getUpdateCallableStatementSql() {
		return "{call UPDATE_COACHING_SESSION(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	}
	@Override
	protected String getInsertCallableStatementSql() {
		return "{call CREATE_COACHING_SESSION(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	}
	@Override
	protected String getDeleteCallableStatementSql() {
		return "{call Delete_COACHING_SESSION(?)}";
	}
	
	

public CoachingSession createObject(CoachingSession perceroObject, String userId)
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

