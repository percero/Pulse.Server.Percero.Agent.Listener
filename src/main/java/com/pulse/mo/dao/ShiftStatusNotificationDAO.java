

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
import com.percero.agents.sync.metadata.MappedClass;

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
	
	public static final String SQL_VIEW = ",\"SHIFT_STATUS_NOTIFICATION\".\"RESOLVED\",\"SHIFT_STATUS_NOTIFICATION\".\"CREATED_ON\",\"SHIFT_STATUS_NOTIFICATION\".\"TYPE\",\"SHIFT_STATUS_NOTIFICATION\".\"SHIFT_END_DATE\",\"SHIFT_STATUS_NOTIFICATION\".\"NAME\",\"SHIFT_STATUS_NOTIFICATION\".\"TEAM_LEADER_ID\"";
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
		return "INSERT INTO TBL_SHIFT_STATUS_NOTIFICATION (\"ID\",\"RESOLVED\",\"CREATED_ON\",\"TYPE\",\"SHIFT_END_DATE\",\"NAME\",\"TEAM_LEADER_ID\") VALUES (?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE TBL_SHIFT_STATUS_NOTIFICATION SET \"RESOLVED\"=?,\"CREATED_ON\"=?,\"TYPE\"=?,\"SHIFT_END_DATE\"=?,\"NAME\"=?,\"TEAM_LEADER_ID\"=? WHERE \"ID\"=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM TBL_SHIFT_STATUS_NOTIFICATION WHERE \"ID\"=?";
	}
	
	@Override
	protected ShiftStatusNotification extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {

		ShiftStatusNotification nextResult = null;
		String type = rs.getString("TYPE");
		String className = type;
		if (className.indexOf("com.pulse.mo.") != 0) {
			className = "com.pulse.mo." + className;
		}
		try {
			nextResult = (ShiftStatusNotification) MappedClass.forName(className).newInstance();
		} catch(Exception e) {
			// Do nothing.
		}


		if (nextResult == null) {
			nextResult = new ShiftStatusNotification();
		}


    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setResolved(rs.getBoolean("RESOLVED"));

nextResult.setCreatedOn(rs.getDate("CREATED_ON"));

nextResult.setType(rs.getString("TYPE"));

nextResult.setShiftEndDate(rs.getDate("SHIFT_END_DATE"));

nextResult.setName(rs.getString("NAME"));

TeamLeader teamleader = new TeamLeader();
teamleader.setID(rs.getString("TEAM_LEADER_ID"));
nextResult.setTeamLeader(teamleader);


			
    	}
    	
    	return nextResult;
	}
	
	protected void setBaseStatmentInsertParams(ShiftStatusNotification perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
JdbcHelper.setBoolean(pstmt,2, perceroObject.getResolved());
pstmt.setDate(3, DateUtils.utilDateToSqlDate(perceroObject.getCreatedOn()));
pstmt.setString(4, perceroObject.getType());
pstmt.setDate(5, DateUtils.utilDateToSqlDate(perceroObject.getShiftEndDate()));
pstmt.setString(6, perceroObject.getName());

if (perceroObject.getTeamLeader() == null)
{
pstmt.setString(7, null);
}
else
{
		pstmt.setString(7, perceroObject.getTeamLeader().getID());
}
		if (perceroObject.getTimecardActivity() == null)
		{
			pstmt.setString(8, null);
		}
		else
		{
			pstmt.setString(8, perceroObject.getTimecardActivity().getID());
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
		
		JdbcHelper.setBoolean(pstmt,1, perceroObject.getResolved());
pstmt.setDate(2, DateUtils.utilDateToSqlDate(perceroObject.getCreatedOn()));
pstmt.setString(3, perceroObject.getType());
pstmt.setDate(4, DateUtils.utilDateToSqlDate(perceroObject.getShiftEndDate()));
pstmt.setString(5, perceroObject.getName());

if (perceroObject.getTeamLeader() == null)
{
pstmt.setString(6, null);
}
else
{
		pstmt.setString(6, perceroObject.getTeamLeader().getID());
}

pstmt.setString(7, perceroObject.getID());
		if (perceroObject.getTimecardActivity() == null)
		{
			pstmt.setString(8, null);
		}
		else
		{
			pstmt.setString(8, perceroObject.getTimecardActivity().getID());
		}

		
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
		return "{call UPDATE_SHIFT_STATUS_NOTIFY(?,?,?,?,?,?,?)}";
	}
	@Override
	protected String getInsertCallableStatementSql() {
		return "{call CREATE_SHIFT_STATUS_NOTIFY(?,?,?,?,?,?,?)}";
	}
	@Override
	protected String getDeleteCallableStatementSql() {
		return "{call Delete_SHIFT_STATUS_NOTIFICATION(?)}";
	}
	
	
	
	
}

