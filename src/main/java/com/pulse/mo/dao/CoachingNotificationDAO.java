
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
public class CoachingNotificationDAO extends SqlDataAccessProcObject<CoachingNotification> implements IDataAccessObject<CoachingNotification> {

	static final Logger log = Logger.getLogger(CoachingNotificationDAO.class);

	
	public CoachingNotificationDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(CoachingNotification.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	
	public static final String SQL_VIEW = ",\"COACHING_NOTIFICATION\".\"DATE\",\"COACHING_NOTIFICATION\".\"WEEK_DATE\",\"COACHING_NOTIFICATION\".\"ACKNOWLEDGEMENT_STATE_COUNT\",\"COACHING_NOTIFICATION\".\"PENDING_COACH_STATE_COUNT\",\"COACHING_NOTIFICATION\".\"PENDING_EMPLOYEE_STATE_COUNT\",\"COACHING_NOTIFICATION\".\"PENDING_STATE_COUNT\",\"COACHING_NOTIFICATION\".\"SKIPPED_STATE_COUNT\",\"COACHING_NOTIFICATION\".\"SUBMITTED_STATE_COUNT\",\"COACHING_NOTIFICATION\".\"NAME\",\"COACHING_NOTIFICATION\".\"TYPE\",\"COACHING_NOTIFICATION\".\"TEAM_LEADER_ID\"";
	private String selectFromStatementTableName = " FROM \"COACHING_NOTIFICATION\" \"COACHING_NOTIFICATION\"";
	private String whereClause = "  WHERE \"COACHING_NOTIFICATION\".\"ID\"=?";
	private String whereInClause = "  join table(sys.dbms_debug_vc2coll(?)) SQLLIST on \"COACHING_NOTIFICATION\".\"ID\"= SQLLIST.column_value";
	private String orderByTableName = "  ORDER BY \"COACHING_NOTIFICATION\".\"ID\"";
	
	

	
	@Override
	protected String getConnectionFactoryName() {
		return CoachingNotificationDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT \"COACHING_NOTIFICATION\".\"ID\" " + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT \"COACHING_NOTIFICATION\".\"ID\"" + SQL_VIEW  + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT \"COACHING_NOTIFICATION\".\"ID\" " + selectFromStatementTableName +  orderByTableName;
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT \"COACHING_NOTIFICATION\".\"ID\" " + selectFromStatementTableName  +  orderByTableName  + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT \"COACHING_NOTIFICATION\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName  + orderByTableName;
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT \"COACHING_NOTIFICATION\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + orderByTableName + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() 
	{
		return "SELECT COUNT(ID) " + selectFromStatementTableName;
	}
	
	@Override
	protected String getSelectInStarSQL() 
	{
		return "SELECT \"COACHING_NOTIFICATION\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + whereInClause;
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT \"COACHING_NOTIFICATION\".\"ID\" " + selectFromStatementTableName + whereInClause;
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		
		return "SELECT \"COACHING_NOTIFICATION\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + " WHERE \"COACHING_NOTIFICATION\"." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) 
	{
		
		return "SELECT \"COACHING_NOTIFICATION\".\"ID\" " + selectFromStatementTableName + " WHERE \"COACHING_NOTIFICATION\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT \"COACHING_NOTIFICATION\".\"ID\" " + selectFromStatementTableName;
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT \"COACHING_NOTIFICATION\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName;
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO TBL_COACHING_NOTIFICATION (\"ID\",\"DATE\",\"WEEK_DATE\",\"ACKNOWLEDGEMENT_STATE_COUNT\",\"PENDING_COACH_STATE_COUNT\",\"PENDING_EMPLOYEE_STATE_COUNT\",\"PENDING_STATE_COUNT\",\"SKIPPED_STATE_COUNT\",\"SUBMITTED_STATE_COUNT\",\"NAME\",\"TYPE\",\"TEAM_LEADER_ID\") VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE TBL_COACHING_NOTIFICATION SET \"DATE\"=?,\"WEEK_DATE\"=?,\"ACKNOWLEDGEMENT_STATE_COUNT\"=?,\"PENDING_COACH_STATE_COUNT\"=?,\"PENDING_EMPLOYEE_STATE_COUNT\"=?,\"PENDING_STATE_COUNT\"=?,\"SKIPPED_STATE_COUNT\"=?,\"SUBMITTED_STATE_COUNT\"=?,\"NAME\"=?,\"TYPE\"=?,\"TEAM_LEADER_ID\"=? WHERE \"ID\"=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM TBL_COACHING_NOTIFICATION WHERE \"ID\"=?";
	}
	
	@Override
	protected CoachingNotification extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	CoachingNotification nextResult = new CoachingNotification();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setDate(rs.getDate("DATE"));

nextResult.setWeekDate(rs.getDate("WEEK_DATE"));

nextResult.setAcknowledgementStateCount(rs.getInt("ACKNOWLEDGEMENT_STATE_COUNT"));

nextResult.setPendingCoachStateCount(rs.getInt("PENDING_COACH_STATE_COUNT"));

nextResult.setPendingEmployeeStateCount(rs.getInt("PENDING_EMPLOYEE_STATE_COUNT"));

nextResult.setPendingStateCount(rs.getInt("PENDING_STATE_COUNT"));

nextResult.setSkippedStateCount(rs.getInt("SKIPPED_STATE_COUNT"));

nextResult.setSubmittedStateCount(rs.getInt("SUBMITTED_STATE_COUNT"));

nextResult.setName(rs.getString("NAME"));

nextResult.setType(rs.getString("TYPE"));

TeamLeader teamleader = new TeamLeader();
teamleader.setID(rs.getString("TEAM_LEADER_ID"));
nextResult.setTeamLeader(teamleader);


			
    	}
    	
    	return nextResult;
	}
	
	protected void setBaseStatmentInsertParams(CoachingNotification perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setDate(2, DateUtils.utilDateToSqlDate(perceroObject.getDate()));
pstmt.setDate(3, DateUtils.utilDateToSqlDate(perceroObject.getWeekDate()));
pstmt.setInt(4, perceroObject.getAcknowledgementStateCount());
pstmt.setInt(5, perceroObject.getPendingCoachStateCount());
pstmt.setInt(6, perceroObject.getPendingEmployeeStateCount());
pstmt.setInt(7, perceroObject.getPendingStateCount());
pstmt.setInt(8, perceroObject.getSkippedStateCount());
pstmt.setInt(9, perceroObject.getSubmittedStateCount());
pstmt.setString(10, perceroObject.getName());
pstmt.setString(11, perceroObject.getType());

if (perceroObject.getTeamLeader() == null)
{
pstmt.setString(12, null);
}
else
{
		pstmt.setString(12, perceroObject.getTeamLeader().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(CoachingNotification perceroObject, PreparedStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
		
	}
	
	@Override
	protected void setCallableStatmentInsertParams(CoachingNotification perceroObject, CallableStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	

	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(CoachingNotification perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setDate(1, DateUtils.utilDateToSqlDate(perceroObject.getDate()));
pstmt.setDate(2, DateUtils.utilDateToSqlDate(perceroObject.getWeekDate()));
pstmt.setInt(3, perceroObject.getAcknowledgementStateCount());
pstmt.setInt(4, perceroObject.getPendingCoachStateCount());
pstmt.setInt(5, perceroObject.getPendingEmployeeStateCount());
pstmt.setInt(6, perceroObject.getPendingStateCount());
pstmt.setInt(7, perceroObject.getSkippedStateCount());
pstmt.setInt(8, perceroObject.getSubmittedStateCount());
pstmt.setString(9, perceroObject.getName());
pstmt.setString(10, perceroObject.getType());

if (perceroObject.getTeamLeader() == null)
{
pstmt.setString(11, null);
}
else
{
		pstmt.setString(11, perceroObject.getTeamLeader().getID());
}

pstmt.setString(12, perceroObject.getID());

		
	}
	
	
	@Override
	protected void setCallableStatmentUpdateParams(CoachingNotification perceroObject, CallableStatement pstmt) throws SQLException 
	{
		
		//must be in same order as insert
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	}
	
	

	@Override
	public List<CoachingNotification> findByExample(CoachingNotification theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useDate = theQueryObject.getDate() != null && (excludeProperties == null || !excludeProperties.contains("date"));

if (useDate)
{
sql += " WHERE ";
sql += " \"DATE\" =? ";
paramValues.add(theQueryObject.getDate());
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

boolean useAcknowledgementStateCount = theQueryObject.getAcknowledgementStateCount() != null && (excludeProperties == null || !excludeProperties.contains("acknowledgementStateCount"));

if (useAcknowledgementStateCount)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"ACKNOWLEDGEMENT_STATE_COUNT\" =? ";
paramValues.add(theQueryObject.getAcknowledgementStateCount());
propertyCounter++;
}

boolean usePendingCoachStateCount = theQueryObject.getPendingCoachStateCount() != null && (excludeProperties == null || !excludeProperties.contains("pendingCoachStateCount"));

if (usePendingCoachStateCount)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"PENDING_COACH_STATE_COUNT\" =? ";
paramValues.add(theQueryObject.getPendingCoachStateCount());
propertyCounter++;
}

boolean usePendingEmployeeStateCount = theQueryObject.getPendingEmployeeStateCount() != null && (excludeProperties == null || !excludeProperties.contains("pendingEmployeeStateCount"));

if (usePendingEmployeeStateCount)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"PENDING_EMPLOYEE_STATE_COUNT\" =? ";
paramValues.add(theQueryObject.getPendingEmployeeStateCount());
propertyCounter++;
}

boolean usePendingStateCount = theQueryObject.getPendingStateCount() != null && (excludeProperties == null || !excludeProperties.contains("pendingStateCount"));

if (usePendingStateCount)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"PENDING_STATE_COUNT\" =? ";
paramValues.add(theQueryObject.getPendingStateCount());
propertyCounter++;
}

boolean useSkippedStateCount = theQueryObject.getSkippedStateCount() != null && (excludeProperties == null || !excludeProperties.contains("skippedStateCount"));

if (useSkippedStateCount)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"SKIPPED_STATE_COUNT\" =? ";
paramValues.add(theQueryObject.getSkippedStateCount());
propertyCounter++;
}

boolean useSubmittedStateCount = theQueryObject.getSubmittedStateCount() != null && (excludeProperties == null || !excludeProperties.contains("submittedStateCount"));

if (useSubmittedStateCount)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"SUBMITTED_STATE_COUNT\" =? ";
paramValues.add(theQueryObject.getSubmittedStateCount());
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

boolean useTeamLeaderID = theQueryObject.getTeamLeader() != null && (excludeProperties == null || !excludeProperties.contains("teamLeader"));

if (useTeamLeaderID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"TEAM_LEADER_ID\" =? ";
paramValues.add(theQueryObject.getTeamLeader().getID());
propertyCounter++;
}



		if (propertyCounter == 0) {
			throw new SyncException(SyncException.METHOD_UNSUPPORTED, SyncException.METHOD_UNSUPPORTED_CODE);
		}
		
		return executeSelectWithParams(sql, paramValues.toArray(), shellOnly);		
	}
	
	@Override
	protected String getUpdateCallableStatementSql() {
		return "{call UPDATE_COACHING_NOTIFICATION(?,?,?,?,?,?,?,?,?,?,?,?)}";
	}
	@Override
	protected String getInsertCallableStatementSql() {
		return "{call CREATE_COACHING_NOTIFICATION(?,?,?,?,?,?,?,?,?,?,?,?)}";
	}
	@Override
	protected String getDeleteCallableStatementSql() {
		return "{call Delete_COACHING_NOTIFICATION(?)}";
	}
	
	
	
	
}
