

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
	
	public static final String SHELL_ONLY_SELECT = "\"COACHING_NOTIFICATION\".\"ID\"";
	public static final String SQL_VIEW = ",\"COACHING_NOTIFICATION\".\"TYPE\",\"COACHING_NOTIFICATION\".\"CREATED_ON\",\"COACHING_NOTIFICATION\".\"WEEK_DATE\",\"COACHING_NOTIFICATION\".\"NAME\",\"COACHING_NOTIFICATION\".\"TEAM_LEADER_ID\"";
	private String selectFromStatementTableName = " FROM \"COACHING_NOTIFICATION\" \"COACHING_NOTIFICATION\"";
	private String whereClause = "  WHERE \"COACHING_NOTIFICATION\".\"ID\"=?";
	private String whereInClause = "  join table(sys.dbms_debug_vc2coll(?)) SQLLIST on \"COACHING_NOTIFICATION\".\"ID\"= SQLLIST.column_value";
	private String orderByTableName = "  ORDER BY \"COACHING_NOTIFICATION\".\"WEEK_DATE\" DESC";
	
	

	
	@Override
	protected String getConnectionFactoryName() {
		return CoachingNotificationDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT " + SHELL_ONLY_SELECT +  " " + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT \"COACHING_NOTIFICATION\".\"ID\"" + SQL_VIEW  + selectFromStatementTableName + whereClause;
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
		return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName + whereInClause;
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		
		return "SELECT \"COACHING_NOTIFICATION\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + " WHERE \"COACHING_NOTIFICATION\"." + joinColumnName + "=?" +  orderByTableName;
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) 
	{
		
		return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName + " WHERE \"COACHING_NOTIFICATION\"." + joinColumnName + "=?" + orderByTableName;
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName;
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT \"COACHING_NOTIFICATION\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName;
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO TBL_COACHING_NOTIFICATION (\"ID\",\"TYPE\",\"CREATED_ON\",\"WEEK_DATE\",\"NAME\",\"TEAM_LEADER_ID\") VALUES (?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE TBL_COACHING_NOTIFICATION SET \"TYPE\"=?,\"CREATED_ON\"=?,\"WEEK_DATE\"=?,\"NAME\"=?,\"TEAM_LEADER_ID\"=? WHERE \"ID\"=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM TBL_COACHING_NOTIFICATION WHERE \"ID\"=?";
	}
	
	@Override
	protected CoachingNotification extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	
		

CoachingNotification nextResult = null;
    	
		    	
    	if (nextResult == null) {
    		nextResult = new CoachingNotification();
    	}

		
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setType(rs.getString("TYPE"));


nextResult.setCreatedOn(DateUtils.utilDateFromSqlTimestamp(rs.getTimestamp("CREATED_ON")));


nextResult.setWeekDate(DateUtils.utilDateFromSqlTimestamp(rs.getTimestamp("WEEK_DATE")));


nextResult.setName(rs.getString("NAME"));


TeamLeader teamleader = new TeamLeader();
teamleader.setID(rs.getString("TEAM_LEADER_ID"));
nextResult.setTeamLeader(teamleader);



			
    	}
		
		
    	return nextResult;
	}
	
	protected void setBaseStatmentInsertParams(CoachingNotification perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getType());
pstmt.setDate(3, DateUtils.utilDateToSqlDate(perceroObject.getCreatedOn()));
pstmt.setDate(4, DateUtils.utilDateToSqlDate(perceroObject.getWeekDate()));
pstmt.setString(5, perceroObject.getName());

if (perceroObject.getTeamLeader() == null)
{
pstmt.setString(6, null);
}
else
{
		pstmt.setString(6, perceroObject.getTeamLeader().getID());
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
		
		pstmt.setString(1, perceroObject.getType());
pstmt.setDate(2, DateUtils.utilDateToSqlDate(perceroObject.getCreatedOn()));
pstmt.setDate(3, DateUtils.utilDateToSqlDate(perceroObject.getWeekDate()));
pstmt.setString(4, perceroObject.getName());

if (perceroObject.getTeamLeader() == null)
{
pstmt.setString(5, null);
}
else
{
		pstmt.setString(5, perceroObject.getTeamLeader().getID());
}

pstmt.setString(6, perceroObject.getID());

		
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
		
		boolean useType = StringUtils.hasText(theQueryObject.getType()) && (excludeProperties == null || !excludeProperties.contains("type"));

if (useType)
{
sql += " WHERE ";
sql += " \"TYPE\" =? ";
paramValues.add(theQueryObject.getType());
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
		return "{call UPDATE_COACHING_NOTIFICATION(?,?,?,?,?,?)}";
	}
	@Override
	protected String getInsertCallableStatementSql() {
		return "{call CREATE_COACHING_NOTIFICATION(?,?,?,?,?,?)}";
	}
	@Override
	protected String getDeleteCallableStatementSql() {
		return "{call Delete_COACHING_NOTIFICATION(?)}";
	}
	
	
	
	
}

