
package com.pulse.mo.dao;

import java.sql.PreparedStatement;
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
	
	
	
	@Override
	protected String getConnectionFactoryName() {
		return UserSessionDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT \"USER_SESSION\".\"ID\" FROM \"USER_SESSION\" \"USER_SESSION\" WHERE \"USER_SESSION\".\"ID\"=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT \"USER_SESSION\".\"ID\",\"USER_SESSION\".\"CONNECTED_STATE\",\"USER_SESSION\".\"DATE\",\"USER_SESSION\".\"IP_ADDRESS\",\"USER_SESSION\".\"PULSE_USER_ID\",\"USER_SESSION\".\"CURRENT_TEAM_LEADER_ID\" FROM \"USER_SESSION\" \"USER_SESSION\" WHERE \"USER_SESSION\".\"ID\"=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT \"USER_SESSION\".\"ID\" FROM \"USER_SESSION\" \"USER_SESSION\" ORDER BY \"ID\"";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT \"USER_SESSION\".\"ID\" FROM \"USER_SESSION\" \"USER_SESSION\" ORDER BY \"USER_SESSION\".\"ID\" LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT \"USER_SESSION\".\"ID\",\"USER_SESSION\".\"CONNECTED_STATE\",\"USER_SESSION\".\"DATE\",\"USER_SESSION\".\"IP_ADDRESS\",\"USER_SESSION\".\"PULSE_USER_ID\",\"USER_SESSION\".\"CURRENT_TEAM_LEADER_ID\" FROM \"USER_SESSION\" \"USER_SESSION\" ORDER BY \"USER_SESSION\".\"ID\"";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT \"USER_SESSION\".\"ID\",\"USER_SESSION\".\"CONNECTED_STATE\",\"USER_SESSION\".\"DATE\",\"USER_SESSION\".\"IP_ADDRESS\",\"USER_SESSION\".\"PULSE_USER_ID\",\"USER_SESSION\".\"CURRENT_TEAM_LEADER_ID\" FROM \"USER_SESSION\" \"USER_SESSION\" ORDER BY \"USER_SESSION\".\"ID\" LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM \"USER_SESSION\" \"USER_SESSION\"";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT \"USER_SESSION\".\"ID\",\"USER_SESSION\".\"CONNECTED_STATE\",\"USER_SESSION\".\"DATE\",\"USER_SESSION\".\"IP_ADDRESS\",\"USER_SESSION\".\"PULSE_USER_ID\",\"USER_SESSION\".\"CURRENT_TEAM_LEADER_ID\" FROM \"USER_SESSION\" \"USER_SESSION\" WHERE \"USER_SESSION\".\"ID\" IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT \"USER_SESSION\".\"ID\" FROM \"USER_SESSION\" \"USER_SESSION\" WHERE \"USER_SESSION\".\"ID\" IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		return "SELECT \"USER_SESSION\".\"ID\",\"USER_SESSION\".\"CONNECTED_STATE\",\"USER_SESSION\".\"DATE\",\"USER_SESSION\".\"IP_ADDRESS\",\"USER_SESSION\".\"PULSE_USER_ID\",\"USER_SESSION\".\"CURRENT_TEAM_LEADER_ID\" FROM \"USER_SESSION\" \"USER_SESSION\" WHERE \"USER_SESSION\"." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT \"USER_SESSION\".\"ID\" FROM \"USER_SESSION\" \"USER_SESSION\" WHERE \"USER_SESSION\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT \"USER_SESSION\".\"ID\" FROM \"USER_SESSION\" \"USER_SESSION\" ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT \"USER_SESSION\".\"ID\",\"USER_SESSION\".\"CONNECTED_STATE\",\"USER_SESSION\".\"DATE\",\"USER_SESSION\".\"IP_ADDRESS\",\"USER_SESSION\".\"PULSE_USER_ID\",\"USER_SESSION\".\"CURRENT_TEAM_LEADER_ID\" FROM \"USER_SESSION\" \"USER_SESSION\" ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO USER_SESSION (\"ID\",\"CONNECTED_STATE\",\"DATE\",\"IP_ADDRESS\",\"PULSE_USER_ID\",\"CURRENT_TEAM_LEADER_ID\") VALUES (?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE \"USER_SESSION\" SET \"CONNECTED_STATE\"=?,\"DATE\"=?,\"IP_ADDRESS\"=?,\"PULSE_USER_ID\"=?,\"CURRENT_TEAM_LEADER_ID\"=? WHERE \"ID\"=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM \"USER_SESSION\" WHERE \"ID\"=?";
	}
	
	@Override
	protected UserSession extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	UserSession nextResult = new UserSession();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setConnectedState(rs.getString("CONNECTED_STATE"));

nextResult.setDate(rs.getDate("DATE"));

nextResult.setIPAddress(rs.getString("IP_ADDRESS"));

PulseUser pulseuser = new PulseUser();
pulseuser.setID(rs.getString("PULSE_USER_ID"));
nextResult.setPulseUser(pulseuser);

TeamLeader teamleader = new TeamLeader();
teamleader.setID(rs.getString("CURRENT_TEAM_LEADER_ID"));
nextResult.setCurrentTeamLeader(teamleader);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(UserSession perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getConnectedState());
pstmt.setDate(3, DateUtils.utilDateToSqlDate(perceroObject.getDate()));
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
	protected void setPreparedStatmentUpdateParams(UserSession perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getConnectedState());
pstmt.setDate(2, DateUtils.utilDateToSqlDate(perceroObject.getDate()));
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
	public List<UserSession> findByExample(UserSession theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useConnectedState = StringUtils.hasText(theQueryObject.getConnectedState()) && (excludeProperties == null || !excludeProperties.contains("connectedState"));

if (useConnectedState)
{
sql += " WHERE ";
sql += " \"CONNECTED_STATE\" =? ";
paramValues.add(theQueryObject.getConnectedState());
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
	
}
