
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
import com.pulse.mo.ConnectedState;
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
		return "SELECT usersession.ID FROM UserSession usersession WHERE usersession.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT usersession.ID,usersession.date,usersession.externalID,usersession.connectedStateName,usersession.iPAddress,usersession.pulseUser_ID,usersession.currentTeamLeader_ID FROM UserSession usersession WHERE usersession.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT usersession.ID FROM UserSession usersession ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT usersession.ID FROM UserSession usersession ORDER BY usersession.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT usersession.ID,usersession.date,usersession.externalID,usersession.connectedStateName,usersession.iPAddress,usersession.pulseUser_ID,usersession.currentTeamLeader_ID FROM UserSession usersession ORDER BY usersession.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT usersession.ID,usersession.date,usersession.externalID,usersession.connectedStateName,usersession.iPAddress,usersession.pulseUser_ID,usersession.currentTeamLeader_ID FROM UserSession usersession ORDER BY usersession.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM UserSession usersession";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT usersession.ID,usersession.date,usersession.externalID,usersession.connectedStateName,usersession.iPAddress,usersession.pulseUser_ID,usersession.currentTeamLeader_ID FROM UserSession usersession WHERE usersession.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT usersession.ID FROM UserSession usersession WHERE usersession.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT usersession.ID,usersession.date,usersession.externalID,usersession.connectedStateName,usersession.iPAddress,usersession.pulseUser_ID,usersession.currentTeamLeader_ID FROM UserSession usersession WHERE usersession." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT usersession.ID FROM UserSession usersession WHERE usersession." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT usersession.ID FROM UserSession usersession ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT usersession.ID,usersession.date,usersession.externalID,usersession.connectedStateName,usersession.iPAddress,usersession.pulseUser_ID,usersession.currentTeamLeader_ID FROM UserSession usersession ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO UserSession (ID,date,externalID,connectedStateName,iPAddress,pulseUser_ID,currentTeamLeader_ID) VALUES (?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE UserSession SET date=?,externalID=?,connectedStateName=?,iPAddress=?,pulseUser_ID=?,currentTeamLeader_ID=? WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM UserSession WHERE ID=?";
	}
	
	@Override
	protected UserSession extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	UserSession nextResult = new UserSession();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setDate(rs.getDate("date"));

nextResult.setExternalID(rs.getString("externalID"));

nextResult.setConnectedStateName(rs.getString("connectedStateName"));

nextResult.setIPAddress(rs.getString("iPAddress"));

PulseUser pulseuser = new PulseUser();
pulseuser.setID(rs.getString("pulseuser_ID"));
nextResult.setPulseUser(pulseuser);

TeamLeader teamleader = new TeamLeader();
teamleader.setID(rs.getString("teamleader_ID"));
nextResult.setCurrentTeamLeader(teamleader);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(UserSession perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setDate(2, DateUtils.utilDateToSqlDate(perceroObject.getDate()));
pstmt.setString(3, perceroObject.getExternalID());
pstmt.setString(4, perceroObject.getConnectedStateName());
pstmt.setString(5, perceroObject.getIPAddress());

if (perceroObject.getPulseUser() == null)
{
pstmt.setString(6, null);
}
else
{
		pstmt.setString(6, perceroObject.getPulseUser().getID());
}


if (perceroObject.getCurrentTeamLeader() == null)
{
pstmt.setString(7, null);
}
else
{
		pstmt.setString(7, perceroObject.getCurrentTeamLeader().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(UserSession perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setDate(1, DateUtils.utilDateToSqlDate(perceroObject.getDate()));
pstmt.setString(2, perceroObject.getExternalID());
pstmt.setString(3, perceroObject.getConnectedStateName());
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

pstmt.setString(7, perceroObject.getID());

		
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
paramValues.add(theQueryObject.getDate());
propertyCounter++;
}

boolean useExternalID = StringUtils.hasText(theQueryObject.getExternalID()) && (excludeProperties == null || !excludeProperties.contains("externalID"));

if (useExternalID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " externalID=? ";
paramValues.add(theQueryObject.getExternalID());
propertyCounter++;
}

boolean useConnectedStateName = StringUtils.hasText(theQueryObject.getConnectedStateName()) && (excludeProperties == null || !excludeProperties.contains("connectedStateName"));

if (useConnectedStateName)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " connectedStateName=? ";
paramValues.add(theQueryObject.getConnectedStateName());
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
sql += " iPAddress=? ";
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
sql += " pulseUserID=? ";
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
sql += " currentTeamLeaderID=? ";
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
