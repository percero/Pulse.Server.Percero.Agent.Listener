
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
	
	public static final String SQL_VIEW = ",\"COACHING_SESSION\".\"IS_REQUIRED\",\"COACHING_SESSION\".\"CLOSED_ON\",\"COACHING_SESSION\".\"CREATED_ON\",\"COACHING_SESSION\".\"UPDATED_ON\",\"COACHING_SESSION\".\"WEEK_DATE\",\"COACHING_SESSION\".\"CURRENT_MTD_THRESHOLD_GRADE\",\"COACHING_SESSION\".\"PREVIOUS_MTD_THRESHOLD_GRADE\",\"COACHING_SESSION\".\"EMPLOYEE_ID\",\"COACHING_SESSION\".\"SCORECARD_ID\",\"COACHING_SESSION\".\"CREATED_BY\",\"COACHING_SESSION\".\"TYPE\",\"COACHING_SESSION\".\"UPDATED_BY\",\"COACHING_SESSION\".\"WEEKLY_OVERALL_SCORE\",\"COACHING_SESSION\".\"WKLY_OVRALL_SCORE_STATE_NAME\",\"COACHING_SESSION\".\"AGENT_SCORECARD_ID\",\"COACHING_SESSION\".\"COACHING_SESSION_STATE_ID\"";
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
		return "SELECT \"COACHING_SESSION\".\"ID\" " + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT \"COACHING_SESSION\".\"ID\"" + SQL_VIEW  + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT \"COACHING_SESSION\".\"ID\" " + selectFromStatementTableName +  orderByTableName;
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT \"COACHING_SESSION\".\"ID\" " + selectFromStatementTableName  +  orderByTableName  + " LIMIT ? OFFSET ?";
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
		return "SELECT \"COACHING_SESSION\".\"ID\" " + selectFromStatementTableName + whereInClause;
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

		return "SELECT \"COACHING_SESSION\".\"ID\" " + selectFromStatementTableName + " WHERE \"COACHING_SESSION\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT \"COACHING_SESSION\".\"ID\" " + selectFromStatementTableName;
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT \"COACHING_SESSION\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName;
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO TBL_COACHING_SESSION (\"ID\",\"IS_REQUIRED\",\"CLOSED_ON\",\"CREATED_ON\",\"UPDATED_ON\",\"WEEK_DATE\",\"CURRENT_MTD_THRESHOLD_GRADE\",\"PREVIOUS_MTD_THRESHOLD_GRADE\",\"EMPLOYEE_ID\",\"SCORECARD_ID\",\"CREATED_BY\",\"TYPE\",\"UPDATED_BY\",\"WEEKLY_OVERALL_SCORE\",\"WKLY_OVRALL_SCORE_STATE_NAME\",\"AGENT_SCORECARD_ID\",\"COACHING_SESSION_STATE_ID\") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE TBL_COACHING_SESSION SET \"IS_REQUIRED\"=?,\"CLOSED_ON\"=?,\"CREATED_ON\"=?,\"UPDATED_ON\"=?,\"WEEK_DATE\"=?,\"CURRENT_MTD_THRESHOLD_GRADE\"=?,\"PREVIOUS_MTD_THRESHOLD_GRADE\"=?,\"EMPLOYEE_ID\"=?,\"SCORECARD_ID\"=?,\"CREATED_BY\"=?,\"TYPE\"=?,\"UPDATED_BY\"=?,\"WEEKLY_OVERALL_SCORE\"=?,\"WKLY_OVRALL_SCORE_STATE_NAME\"=?,\"AGENT_SCORECARD_ID\"=?,\"COACHING_SESSION_STATE_ID\"=? WHERE \"ID\"=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM TBL_COACHING_SESSION WHERE \"ID\"=?";
	}
	
	@Override
	protected CoachingSession extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	CoachingSession nextResult = new CoachingSession();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setIsRequired(rs.getBoolean("IS_REQUIRED"));

nextResult.setClosedOn(rs.getDate("CLOSED_ON"));

nextResult.setCreatedOn(rs.getDate("CREATED_ON"));

nextResult.setUpdatedOn(rs.getDate("UPDATED_ON"));

nextResult.setWeekDate(rs.getDate("WEEK_DATE"));

nextResult.setCurrentMTDThresholdGrade(rs.getDouble("CURRENT_MTD_THRESHOLD_GRADE"));

nextResult.setPreviousMTDThresholdGrade(rs.getDouble("PREVIOUS_MTD_THRESHOLD_GRADE"));

nextResult.setEmployeeId(rs.getInt("EMPLOYEE_ID"));

nextResult.setScorecardId(rs.getInt("SCORECARD_ID"));

nextResult.setCreatedBy(rs.getString("CREATED_BY"));

nextResult.setType(rs.getString("TYPE"));

nextResult.setUpdatedBy(rs.getString("UPDATED_BY"));

nextResult.setWeeklyOverallScore(rs.getString("WEEKLY_OVERALL_SCORE"));

nextResult.setWeeklyOverallScoreStateName(rs.getString("WKLY_OVRALL_SCORE_STATE_NAME"));

AgentScorecard agentscorecard = new AgentScorecard();
agentscorecard.setID(rs.getString("AGENT_SCORECARD_ID"));
nextResult.setAgentScorecard(agentscorecard);

CoachingSessionState coachingsessionstate = new CoachingSessionState();
coachingsessionstate.setID(rs.getString("COACHING_SESSION_STATE_ID"));
nextResult.setCoachingSessionState(coachingsessionstate);


			
    	}
    	
    	return nextResult;
	}
	
	protected void setBaseStatmentInsertParams(CoachingSession perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setBoolean(2, perceroObject.getIsRequired());
pstmt.setDate(3, DateUtils.utilDateToSqlDate(perceroObject.getClosedOn()));
pstmt.setDate(4, DateUtils.utilDateToSqlDate(perceroObject.getCreatedOn()));
pstmt.setDate(5, DateUtils.utilDateToSqlDate(perceroObject.getUpdatedOn()));
pstmt.setDate(6, DateUtils.utilDateToSqlDate(perceroObject.getWeekDate()));
pstmt.setDouble(7, perceroObject.getCurrentMTDThresholdGrade());
pstmt.setDouble(8, perceroObject.getPreviousMTDThresholdGrade());
pstmt.setInt(9, perceroObject.getEmployeeId());
pstmt.setInt(10, perceroObject.getScorecardId());
pstmt.setString(11, perceroObject.getCreatedBy());
pstmt.setString(12, perceroObject.getType());
pstmt.setString(13, perceroObject.getUpdatedBy());
pstmt.setString(14, perceroObject.getWeeklyOverallScore());
pstmt.setString(15, perceroObject.getWeeklyOverallScoreStateName());

if (perceroObject.getAgentScorecard() == null)
{
pstmt.setString(16, null);
}
else
{
		pstmt.setString(16, perceroObject.getAgentScorecard().getID());
}


if (perceroObject.getCoachingSessionState() == null)
{
pstmt.setString(17, null);
}
else
{
		pstmt.setString(17, perceroObject.getCoachingSessionState().getID());
}


		
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
		
		pstmt.setBoolean(1, perceroObject.getIsRequired());
pstmt.setDate(2, DateUtils.utilDateToSqlDate(perceroObject.getClosedOn()));
pstmt.setDate(3, DateUtils.utilDateToSqlDate(perceroObject.getCreatedOn()));
pstmt.setDate(4, DateUtils.utilDateToSqlDate(perceroObject.getUpdatedOn()));
pstmt.setDate(5, DateUtils.utilDateToSqlDate(perceroObject.getWeekDate()));
pstmt.setDouble(6, perceroObject.getCurrentMTDThresholdGrade());
pstmt.setDouble(7, perceroObject.getPreviousMTDThresholdGrade());
pstmt.setInt(8, perceroObject.getEmployeeId());
pstmt.setInt(9, perceroObject.getScorecardId());
pstmt.setString(10, perceroObject.getCreatedBy());
pstmt.setString(11, perceroObject.getType());
pstmt.setString(12, perceroObject.getUpdatedBy());
pstmt.setString(13, perceroObject.getWeeklyOverallScore());
pstmt.setString(14, perceroObject.getWeeklyOverallScoreStateName());

if (perceroObject.getAgentScorecard() == null)
{
pstmt.setString(15, null);
}
else
{
		pstmt.setString(15, perceroObject.getAgentScorecard().getID());
}


if (perceroObject.getCoachingSessionState() == null)
{
pstmt.setString(16, null);
}
else
{
		pstmt.setString(16, perceroObject.getCoachingSessionState().getID());
}

pstmt.setString(17, perceroObject.getID());

		
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

boolean useCurrentMTDThresholdGrade = theQueryObject.getCurrentMTDThresholdGrade() != null && (excludeProperties == null || !excludeProperties.contains("currentMTDThresholdGrade"));

if (useCurrentMTDThresholdGrade)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"CURRENT_MTD_THRESHOLD_GRADE\" =? ";
paramValues.add(theQueryObject.getCurrentMTDThresholdGrade());
propertyCounter++;
}

boolean usePreviousMTDThresholdGrade = theQueryObject.getPreviousMTDThresholdGrade() != null && (excludeProperties == null || !excludeProperties.contains("previousMTDThresholdGrade"));

if (usePreviousMTDThresholdGrade)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"PREVIOUS_MTD_THRESHOLD_GRADE\" =? ";
paramValues.add(theQueryObject.getPreviousMTDThresholdGrade());
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

boolean useWeeklyOverallScore = StringUtils.hasText(theQueryObject.getWeeklyOverallScore()) && (excludeProperties == null || !excludeProperties.contains("weeklyOverallScore"));

if (useWeeklyOverallScore)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"WEEKLY_OVERALL_SCORE\" =? ";
paramValues.add(theQueryObject.getWeeklyOverallScore());
propertyCounter++;
}

boolean useWeeklyOverallScoreStateName = StringUtils.hasText(theQueryObject.getWeeklyOverallScoreStateName()) && (excludeProperties == null || !excludeProperties.contains("weeklyOverallScoreStateName"));

if (useWeeklyOverallScoreStateName)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"WKLY_OVRALL_SCORE_STATE_NAME\" =? ";
paramValues.add(theQueryObject.getWeeklyOverallScoreStateName());
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



		if (propertyCounter == 0) {
			throw new SyncException(SyncException.METHOD_UNSUPPORTED, SyncException.METHOD_UNSUPPORTED_CODE);
		}
		
		return executeSelectWithParams(sql, paramValues.toArray(), shellOnly);		
	}
	
	@Override
	protected String getUpdateCallableStatementSql() {
		return "{call UPDATE_COACHING_SESSION(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	}
	@Override
	protected String getInsertCallableStatementSql() {
		return "{call CREATE_COACHING_SESSION(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	}
	@Override
	protected String getDeleteCallableStatementSql() {
		return "{call Delete_COACHING_SESSION(?)}";
	}
	
	
	
	
}
