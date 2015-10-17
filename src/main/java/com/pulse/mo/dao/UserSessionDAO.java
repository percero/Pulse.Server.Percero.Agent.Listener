
package com.pulse.mo.dao;

import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.percero.util.DateUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.percero.agents.sync.dao.DAORegistry;
import com.percero.agents.sync.dao.IDataAccessObject;
import com.percero.agents.sync.exceptions.SyncException;

import com.pulse.mo.*;

/*
import com.pulse.mo.UserSession;
import com.pulse.mo.TeamLeader;
import com.pulse.mo.PulseUser;

*/

@Component
public class UserSessionDAO extends SqlDataAccessObject<UserSession> implements IDataAccessObject<UserSession> {

	static final Logger log = Logger.getLogger(UserSessionDAO.class);

	
	public UserSessionDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(UserSession.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	
	public static final String SQL_VIEW = ",\"USER_SESSION\".\"DATE\",\"USER_SESSION\".\"CONNECTED_STATE\",\"USER_SESSION\".\"IP_ADDRESS\",\"USER_SESSION\".\"PULSE_USER_ID\",\"USER_SESSION\".\"CURRENT_TEAM_LEADER_ID\"";
	private String selectFromStatementTableName = " FROM \"USER_SESSION\" \"USER_SESSION\"";
	private String whereClause = "  WHERE \"USER_SESSION\".\"ID\"=?";
	private String whereInClause = "  join table(sys.dbms_debug_vc2coll(?)) SQLLIST on \"USER_SESSION\".\"ID\"= SQLLIST.column_value";
	private String orderByTableName = "  ORDER BY \"USER_SESSION\".\"ID\"";
	
	

	
	@Override
	protected String getConnectionFactoryName() {
		return UserSessionDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT \"USER_SESSION\".\"ID\" " + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT \"USER_SESSION\".\"ID\"" + SQL_VIEW  + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT \"USER_SESSION\".\"ID\" " + selectFromStatementTableName +  orderByTableName;
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT \"USER_SESSION\".\"ID\" " + selectFromStatementTableName  +  orderByTableName  + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT \"USER_SESSION\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName  + orderByTableName;
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT \"USER_SESSION\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + orderByTableName + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() 
	{
		return "SELECT COUNT(ID) " + selectFromStatementTableName;
	}
	
	@Override
	protected String getSelectInStarSQL() 
	{
		return "SELECT \"USER_SESSION\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + whereInClause;
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT \"USER_SESSION\".\"ID\" " + selectFromStatementTableName + whereInClause;
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		
		return "SELECT \"USER_SESSION\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + " WHERE \"USER_SESSION\"." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) 
	{
		
		return "SELECT \"USER_SESSION\".\"ID\" " + selectFromStatementTableName + " WHERE \"USER_SESSION\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT \"USER_SESSION\".\"ID\" " + selectFromStatementTableName;
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT \"USER_SESSION\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName;
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO USER_SESSION (\"ID\",\"DATE\",\"CONNECTED_STATE\",\"IP_ADDRESS\",\"PULSE_USER_ID\",\"CURRENT_TEAM_LEADER_ID\") VALUES (?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE \"TBL_USER_SESSION\" SET \"DATE\"=?,\"CONNECTED_STATE\"=?,\"IP_ADDRESS\"=?,\"PULSE_USER_ID\"=?,\"CURRENT_TEAM_LEADER_ID\"=? WHERE \"ID\"=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM \"TBL_USER_SESSION\" WHERE \"ID\"=?";
	}
	
	@Override
	protected UserSession extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	UserSession nextResult = new UserSession();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setDate(rs.getDate("DATE"));

nextResult.setConnectedState(rs.getString("CONNECTED_STATE"));

nextResult.setIPAddress(rs.getString("IP_ADDRESS"));

PulseUser pulseuser = new PulseUser();
pulseuser.setID(rs.getString("PULSE_USER_ID"));
nextResult.setPulseUser(pulseuser);

TeamLeader currentteamleader = new TeamLeader();
currentteamleader.setID(rs.getString("CURRENT_TEAM_LEADER_ID"));
nextResult.setCurrentTeamLeader(currentteamleader);


			
    	}
    	
    	return nextResult;
	}
	
	protected void setBaseStatmentInsertParams(UserSession perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setDate(2, DateUtils.utilDateToSqlDate(perceroObject.getDate()));
pstmt.setString(3, perceroObject.getConnectedState());
pstmt.setString(4, perceroObject.getIPAddress());

if (perceroObject.getPulseUser() == null)
{
pstmt.setString(5, null);
}
else
{
		pstmt.setString(5, perceroObject.getPulseUser().getID());
}


if (perceroObject.getCurrentTeamLeader() == null)
{
pstmt.setString(6, null);
}
else
{
		pstmt.setString(6, perceroObject.getCurrentTeamLeader().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(UserSession perceroObject, PreparedStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
		
	}
	
	@Override
	protected void setCallableStatmentInsertParams(UserSession perceroObject, CallableStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	

	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(UserSession perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setDate(1, DateUtils.utilDateToSqlDate(perceroObject.getDate()));
pstmt.setString(2, perceroObject.getConnectedState());
pstmt.setString(3, perceroObject.getIPAddress());

if (perceroObject.getPulseUser() == null)
{
pstmt.setString(4, null);
}
else
{
		pstmt.setString(4, perceroObject.getPulseUser().getID());
}


if (perceroObject.getCurrentTeamLeader() == null)
{
pstmt.setString(5, null);
}
else
{
		pstmt.setString(5, perceroObject.getCurrentTeamLeader().getID());
}

pstmt.setString(6, perceroObject.getID());

		
	}
	
	
	@Override
	protected void setCallableStatmentUpdateParams(UserSession perceroObject, CallableStatement pstmt) throws SQLException 
	{
		
		//must be in same order as insert
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	}
	
	

	@Override
	public List<UserSession> findByExample(UserSession theQueryObject,
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

boolean useConnectedState = StringUtils.hasText(theQueryObject.getConnectedState()) && (excludeProperties == null || !excludeProperties.contains("connectedState"));

if (useConnectedState)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"CONNECTED_STATE\" =? ";
paramValues.add(theQueryObject.getConnectedState());
propertyCounter++;
}

boolean useIPAddress = StringUtils.hasText(theQueryObject.getIPAddress()) && (excludeProperties == null || !excludeProperties.contains("iPAddress"));

if (useIPAddress)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"IP_ADDRESS\" =? ";
paramValues.add(theQueryObject.getIPAddress());
propertyCounter++;
}

boolean usePulseUserID = theQueryObject.getPulseUser() != null && (excludeProperties == null || !excludeProperties.contains("pulseUser"));

if (usePulseUserID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"PULSE_USER_ID\" =? ";
paramValues.add(theQueryObject.getPulseUser().getID());
propertyCounter++;
}

boolean useCurrentTeamLeaderID = theQueryObject.getCurrentTeamLeader() != null && (excludeProperties == null || !excludeProperties.contains("currentTeamLeader"));

if (useCurrentTeamLeaderID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"CURRENT_TEAM_LEADER_ID\" =? ";
paramValues.add(theQueryObject.getCurrentTeamLeader().getID());
propertyCounter++;
}


		/*
		boolean useValue = StringUtils.hasText(theQueryObject.getValue()) && (excludeProperties == null || !excludeProperties.contains("value"));
		
		if (useValue) {
			sql += " WHERE value=? ";
			paramValues.add(theQueryObject.getValue());
			propertyCounter++;
		}
		
		boolean usePersonId = theQueryObject.getPerson() != null && (excludeProperties == null || !excludeProperties.contains("person"));
		
		if (usePersonId) {
			if (propertyCounter > 0) {
				sql += " AND ";
			}
			else {
				sql += " WHERE ";
			}
			sql += " person_ID=? ";
			paramValues.add(theQueryObject.getPerson().getID());
			propertyCounter++;
		}
		
		*/
		
		return executeSelectWithParams(sql, paramValues.toArray(), shellOnly);		
	}
	
	@Override
	protected String getUpdateCallableStatementSql() {
		return "{call UPDATE_USER_SESSION(?,?,?,?,?,?)}";
	}
	@Override
	protected String getInsertCallableStatementSql() {
		return "{call CREATE_USER_SESSION(?,?,?,?,?,?)}";
	}
	@Override
	protected String getDeleteCallableStatementSql() {
		return "{call Delete_USER_SESSION(?)}";
	}
	
	
	
	
}
