
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
public class ShiftStatusNotificationDAO extends SqlDataAccessProcObject<ShiftStatusNotification> implements IDataAccessObject<ShiftStatusNotification> {

	static final Logger log = Logger.getLogger(ShiftStatusNotificationDAO.class);

	
	public ShiftStatusNotificationDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(ShiftStatusNotification.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	
	public static final String SQL_VIEW = ",\"SHIFT_STATUS_NOTIFICATION\".\"RESOLVED\",\"SHIFT_STATUS_NOTIFICATION\".\"TYPE\",\"SHIFT_STATUS_NOTIFICATION\".\"DATE\",\"SHIFT_STATUS_NOTIFICATION\".\"SHIFT_END_DATE\",\"SHIFT_STATUS_NOTIFICATION\".\"APPROVED_STATE_COUNT\",\"SHIFT_STATUS_NOTIFICATION\".\"COMPLETE_STATE_COUNT\",\"SHIFT_STATUS_NOTIFICATION\".\"IN_PROGRESS_STATE_COUNT\",\"SHIFT_STATUS_NOTIFICATION\".\"NOT_YET_STARTED_STATE_COUNT\",\"SHIFT_STATUS_NOTIFICATION\".\"NAME\",\"SHIFT_STATUS_NOTIFICATION\".\"TEAM_LEADER_ID\"";
	private String selectFromStatementTableName = " FROM \"SHIFT_STATUS_NOTIFICATION\" \"SHIFT_STATUS_NOTIFICATION\"";
	private String whereClause = "  WHERE \"SHIFT_STATUS_NOTIFICATION\".\"ID\"=?";
	private String whereInClause = "  join table(sys.dbms_debug_vc2coll(?)) SQLLIST on \"SHIFT_STATUS_NOTIFICATION\".\"ID\"= SQLLIST.column_value";
	private String orderByTableName = "  ORDER BY \"SHIFT_STATUS_NOTIFICATION\".\"ID\"";
	
	

	
	@Override
	protected String getConnectionFactoryName() {
		return ShiftStatusNotificationDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT \"SHIFT_STATUS_NOTIFICATION\".\"ID\" " + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT \"SHIFT_STATUS_NOTIFICATION\".\"ID\"" + SQL_VIEW  + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT \"SHIFT_STATUS_NOTIFICATION\".\"ID\" " + selectFromStatementTableName +  orderByTableName;
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT \"SHIFT_STATUS_NOTIFICATION\".\"ID\" " + selectFromStatementTableName  +  orderByTableName  + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT \"SHIFT_STATUS_NOTIFICATION\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName  + orderByTableName;
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT \"SHIFT_STATUS_NOTIFICATION\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + orderByTableName + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() 
	{
		return "SELECT COUNT(ID) " + selectFromStatementTableName;
	}
	
	@Override
	protected String getSelectInStarSQL() 
	{
		return "SELECT \"SHIFT_STATUS_NOTIFICATION\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + whereInClause;
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT \"SHIFT_STATUS_NOTIFICATION\".\"ID\" " + selectFromStatementTableName + whereInClause;
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		
		return "SELECT \"SHIFT_STATUS_NOTIFICATION\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + " WHERE \"SHIFT_STATUS_NOTIFICATION\"." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) 
	{
		
		return "SELECT \"SHIFT_STATUS_NOTIFICATION\".\"ID\" " + selectFromStatementTableName + " WHERE \"SHIFT_STATUS_NOTIFICATION\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT \"SHIFT_STATUS_NOTIFICATION\".\"ID\" " + selectFromStatementTableName;
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT \"SHIFT_STATUS_NOTIFICATION\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName;
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO TBL_SHIFT_STATUS_NOTIFICATION (\"ID\",\"RESOLVED\",\"TYPE\",\"DATE\",\"SHIFT_END_DATE\",\"APPROVED_STATE_COUNT\",\"COMPLETE_STATE_COUNT\",\"IN_PROGRESS_STATE_COUNT\",\"NOT_YET_STARTED_STATE_COUNT\",\"NAME\",\"TEAM_LEADER_ID\") VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE TBL_SHIFT_STATUS_NOTIFICATION SET \"RESOLVED\"=?,\"TYPE\"=?,\"DATE\"=?,\"SHIFT_END_DATE\"=?,\"APPROVED_STATE_COUNT\"=?,\"COMPLETE_STATE_COUNT\"=?,\"IN_PROGRESS_STATE_COUNT\"=?,\"NOT_YET_STARTED_STATE_COUNT\"=?,\"NAME\"=?,\"TEAM_LEADER_ID\"=? WHERE \"ID\"=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM TBL_SHIFT_STATUS_NOTIFICATION WHERE \"ID\"=?";
	}
	
	@Override
	protected ShiftStatusNotification extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	ShiftStatusNotification nextResult = new ShiftStatusNotification();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setResolved(rs.getBoolean("RESOLVED"));

nextResult.setType(rs.getString("TYPE"));

nextResult.setDate(rs.getDate("DATE"));

nextResult.setShiftEndDate(rs.getDate("SHIFT_END_DATE"));

nextResult.setApprovedStateCount(rs.getInt("APPROVED_STATE_COUNT"));

nextResult.setCompleteStateCount(rs.getInt("COMPLETE_STATE_COUNT"));

nextResult.setInProgressStateCount(rs.getInt("IN_PROGRESS_STATE_COUNT"));

nextResult.setNotYetStartedStateCount(rs.getInt("NOT_YET_STARTED_STATE_COUNT"));

nextResult.setName(rs.getString("NAME"));

TeamLeader teamleader = new TeamLeader();
teamleader.setID(rs.getString("TEAM_LEADER_ID"));
nextResult.setTeamLeader(teamleader);


			
    	}
    	
    	return nextResult;
	}
	
	protected void setBaseStatmentInsertParams(ShiftStatusNotification perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setBoolean(2, perceroObject.getResolved());
pstmt.setString(3, perceroObject.getType());
pstmt.setDate(4, DateUtils.utilDateToSqlDate(perceroObject.getDate()));
pstmt.setDate(5, DateUtils.utilDateToSqlDate(perceroObject.getShiftEndDate()));
pstmt.setInt(6, perceroObject.getApprovedStateCount());
pstmt.setInt(7, perceroObject.getCompleteStateCount());
pstmt.setInt(8, perceroObject.getInProgressStateCount());
pstmt.setInt(9, perceroObject.getNotYetStartedStateCount());
pstmt.setString(10, perceroObject.getName());

if (perceroObject.getTeamLeader() == null)
{
pstmt.setString(11, null);
}
else
{
		pstmt.setString(11, perceroObject.getTeamLeader().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(ShiftStatusNotification perceroObject, PreparedStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
		
	}
	
	@Override
	protected void setCallableStatmentInsertParams(ShiftStatusNotification perceroObject, CallableStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	

	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(ShiftStatusNotification perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setBoolean(1, perceroObject.getResolved());
pstmt.setString(2, perceroObject.getType());
pstmt.setDate(3, DateUtils.utilDateToSqlDate(perceroObject.getDate()));
pstmt.setDate(4, DateUtils.utilDateToSqlDate(perceroObject.getShiftEndDate()));
pstmt.setInt(5, perceroObject.getApprovedStateCount());
pstmt.setInt(6, perceroObject.getCompleteStateCount());
pstmt.setInt(7, perceroObject.getInProgressStateCount());
pstmt.setInt(8, perceroObject.getNotYetStartedStateCount());
pstmt.setString(9, perceroObject.getName());

if (perceroObject.getTeamLeader() == null)
{
pstmt.setString(10, null);
}
else
{
		pstmt.setString(10, perceroObject.getTeamLeader().getID());
}

pstmt.setString(11, perceroObject.getID());

		
	}
	
	
	@Override
	protected void setCallableStatmentUpdateParams(ShiftStatusNotification perceroObject, CallableStatement pstmt) throws SQLException 
	{
		
		//must be in same order as insert
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	}
	
	

	@Override
	public List<ShiftStatusNotification> findByExample(ShiftStatusNotification theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useResolved = theQueryObject.getResolved() != null && (excludeProperties == null || !excludeProperties.contains("resolved"));

if (useResolved)
{
sql += " WHERE ";
sql += " \"RESOLVED\" =? ";
paramValues.add(theQueryObject.getResolved());
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

boolean useDate = theQueryObject.getDate() != null && (excludeProperties == null || !excludeProperties.contains("date"));

if (useDate)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"DATE\" =? ";
paramValues.add(theQueryObject.getDate());
propertyCounter++;
}

boolean useShiftEndDate = theQueryObject.getShiftEndDate() != null && (excludeProperties == null || !excludeProperties.contains("shiftEndDate"));

if (useShiftEndDate)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"SHIFT_END_DATE\" =? ";
paramValues.add(theQueryObject.getShiftEndDate());
propertyCounter++;
}

boolean useApprovedStateCount = theQueryObject.getApprovedStateCount() != null && (excludeProperties == null || !excludeProperties.contains("approvedStateCount"));

if (useApprovedStateCount)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"APPROVED_STATE_COUNT\" =? ";
paramValues.add(theQueryObject.getApprovedStateCount());
propertyCounter++;
}

boolean useCompleteStateCount = theQueryObject.getCompleteStateCount() != null && (excludeProperties == null || !excludeProperties.contains("completeStateCount"));

if (useCompleteStateCount)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"COMPLETE_STATE_COUNT\" =? ";
paramValues.add(theQueryObject.getCompleteStateCount());
propertyCounter++;
}

boolean useInProgressStateCount = theQueryObject.getInProgressStateCount() != null && (excludeProperties == null || !excludeProperties.contains("inProgressStateCount"));

if (useInProgressStateCount)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"IN_PROGRESS_STATE_COUNT\" =? ";
paramValues.add(theQueryObject.getInProgressStateCount());
propertyCounter++;
}

boolean useNotYetStartedStateCount = theQueryObject.getNotYetStartedStateCount() != null && (excludeProperties == null || !excludeProperties.contains("notYetStartedStateCount"));

if (useNotYetStartedStateCount)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"NOT_YET_STARTED_STATE_COUNT\" =? ";
paramValues.add(theQueryObject.getNotYetStartedStateCount());
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
		return "{call UPDATE_SHIFT_STATUS_NOTIFICATION(?,?,?,?,?,?,?,?,?,?,?)}";
	}
	@Override
	protected String getInsertCallableStatementSql() {
		return "{call CREATE_SHIFT_STATUS_NOTIFICATION(?,?,?,?,?,?,?,?,?,?,?)}";
	}
	@Override
	protected String getDeleteCallableStatementSql() {
		return "{call Delete_SHIFT_STATUS_NOTIFICATION(?)}";
	}
	
	
	
	
}
