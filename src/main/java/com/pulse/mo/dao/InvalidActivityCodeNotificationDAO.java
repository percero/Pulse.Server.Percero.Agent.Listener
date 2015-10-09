
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
import com.pulse.mo.InvalidActivityCodeNotification;

*/

@Component
public class InvalidActivityCodeNotificationDAO extends SqlDataAccessObject<InvalidActivityCodeNotification> implements IDataAccessObject<InvalidActivityCodeNotification> {

	static final Logger log = Logger.getLogger(InvalidActivityCodeNotificationDAO.class);

	
	public InvalidActivityCodeNotificationDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(InvalidActivityCodeNotification.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	@Override
	protected String getConnectionFactoryName() {
		return InvalidActivityCodeNotificationDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT INVALID_ACTIVITY_CODE_NOTIFICATION.ID FROM INVALID_ACTIVITY_CODE_NOTIFICATION INVALID_ACTIVITY_CODE_NOTIFICATION WHERE INVALID_ACTIVITY_CODE_NOTIFICATION.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT INVALID_ACTIVITY_CODE_NOTIFICATION.ID,INVALID_ACTIVITY_CODE_NOTIFICATION.DATE,INVALID_ACTIVITY_CODE_NOTIFICATION.MESSAGE,INVALID_ACTIVITY_CODE_NOTIFICATION.NAME,INVALID_ACTIVITY_CODE_NOTIFICATION.TYPE,INVALID_ACTIVITY_CODE_NOTIFICATION.LOB_CONFIGURATION_ID,INVALID_ACTIVITY_CODE_NOTIFICATION.AGENT_ID,INVALID_ACTIVITY_CODE_NOTIFICATION.LOB_CONFIGURATION_ENTRY_ID,INVALID_ACTIVITY_CODE_NOTIFICATION.TEAM_LEADER_ID FROM INVALID_ACTIVITY_CODE_NOTIFICATION INVALID_ACTIVITY_CODE_NOTIFICATION WHERE INVALID_ACTIVITY_CODE_NOTIFICATION.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT INVALID_ACTIVITY_CODE_NOTIFICATION.ID FROM INVALID_ACTIVITY_CODE_NOTIFICATION INVALID_ACTIVITY_CODE_NOTIFICATION ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT INVALID_ACTIVITY_CODE_NOTIFICATION.ID FROM INVALID_ACTIVITY_CODE_NOTIFICATION INVALID_ACTIVITY_CODE_NOTIFICATION ORDER BY INVALID_ACTIVITY_CODE_NOTIFICATION.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT INVALID_ACTIVITY_CODE_NOTIFICATION.ID,INVALID_ACTIVITY_CODE_NOTIFICATION.DATE,INVALID_ACTIVITY_CODE_NOTIFICATION.MESSAGE,INVALID_ACTIVITY_CODE_NOTIFICATION.NAME,INVALID_ACTIVITY_CODE_NOTIFICATION.TYPE,INVALID_ACTIVITY_CODE_NOTIFICATION.LOB_CONFIGURATION_ID,INVALID_ACTIVITY_CODE_NOTIFICATION.AGENT_ID,INVALID_ACTIVITY_CODE_NOTIFICATION.LOB_CONFIGURATION_ENTRY_ID,INVALID_ACTIVITY_CODE_NOTIFICATION.TEAM_LEADER_ID FROM INVALID_ACTIVITY_CODE_NOTIFICATION INVALID_ACTIVITY_CODE_NOTIFICATION ORDER BY INVALID_ACTIVITY_CODE_NOTIFICATION.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT INVALID_ACTIVITY_CODE_NOTIFICATION.ID,INVALID_ACTIVITY_CODE_NOTIFICATION.DATE,INVALID_ACTIVITY_CODE_NOTIFICATION.MESSAGE,INVALID_ACTIVITY_CODE_NOTIFICATION.NAME,INVALID_ACTIVITY_CODE_NOTIFICATION.TYPE,INVALID_ACTIVITY_CODE_NOTIFICATION.LOB_CONFIGURATION_ID,INVALID_ACTIVITY_CODE_NOTIFICATION.AGENT_ID,INVALID_ACTIVITY_CODE_NOTIFICATION.LOB_CONFIGURATION_ENTRY_ID,INVALID_ACTIVITY_CODE_NOTIFICATION.TEAM_LEADER_ID FROM INVALID_ACTIVITY_CODE_NOTIFICATION INVALID_ACTIVITY_CODE_NOTIFICATION ORDER BY INVALID_ACTIVITY_CODE_NOTIFICATION.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM INVALID_ACTIVITY_CODE_NOTIFICATION INVALID_ACTIVITY_CODE_NOTIFICATION";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT INVALID_ACTIVITY_CODE_NOTIFICATION.ID,INVALID_ACTIVITY_CODE_NOTIFICATION.DATE,INVALID_ACTIVITY_CODE_NOTIFICATION.MESSAGE,INVALID_ACTIVITY_CODE_NOTIFICATION.NAME,INVALID_ACTIVITY_CODE_NOTIFICATION.TYPE,INVALID_ACTIVITY_CODE_NOTIFICATION.LOB_CONFIGURATION_ID,INVALID_ACTIVITY_CODE_NOTIFICATION.AGENT_ID,INVALID_ACTIVITY_CODE_NOTIFICATION.LOB_CONFIGURATION_ENTRY_ID,INVALID_ACTIVITY_CODE_NOTIFICATION.TEAM_LEADER_ID FROM INVALID_ACTIVITY_CODE_NOTIFICATION INVALID_ACTIVITY_CODE_NOTIFICATION WHERE INVALID_ACTIVITY_CODE_NOTIFICATION.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT INVALID_ACTIVITY_CODE_NOTIFICATION.ID FROM INVALID_ACTIVITY_CODE_NOTIFICATION INVALID_ACTIVITY_CODE_NOTIFICATION WHERE INVALID_ACTIVITY_CODE_NOTIFICATION.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT INVALID_ACTIVITY_CODE_NOTIFICATION.ID,INVALID_ACTIVITY_CODE_NOTIFICATION.DATE,INVALID_ACTIVITY_CODE_NOTIFICATION.MESSAGE,INVALID_ACTIVITY_CODE_NOTIFICATION.NAME,INVALID_ACTIVITY_CODE_NOTIFICATION.TYPE,INVALID_ACTIVITY_CODE_NOTIFICATION.LOB_CONFIGURATION_ID,INVALID_ACTIVITY_CODE_NOTIFICATION.AGENT_ID,INVALID_ACTIVITY_CODE_NOTIFICATION.LOB_CONFIGURATION_ENTRY_ID,INVALID_ACTIVITY_CODE_NOTIFICATION.TEAM_LEADER_ID FROM INVALID_ACTIVITY_CODE_NOTIFICATION INVALID_ACTIVITY_CODE_NOTIFICATION WHERE INVALID_ACTIVITY_CODE_NOTIFICATION." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT INVALID_ACTIVITY_CODE_NOTIFICATION.ID FROM INVALID_ACTIVITY_CODE_NOTIFICATION INVALID_ACTIVITY_CODE_NOTIFICATION WHERE INVALID_ACTIVITY_CODE_NOTIFICATION." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT INVALID_ACTIVITY_CODE_NOTIFICATION.ID FROM INVALID_ACTIVITY_CODE_NOTIFICATION INVALID_ACTIVITY_CODE_NOTIFICATION ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT INVALID_ACTIVITY_CODE_NOTIFICATION.ID,INVALID_ACTIVITY_CODE_NOTIFICATION.DATE,INVALID_ACTIVITY_CODE_NOTIFICATION.MESSAGE,INVALID_ACTIVITY_CODE_NOTIFICATION.NAME,INVALID_ACTIVITY_CODE_NOTIFICATION.TYPE,INVALID_ACTIVITY_CODE_NOTIFICATION.LOB_CONFIGURATION_ID,INVALID_ACTIVITY_CODE_NOTIFICATION.AGENT_ID,INVALID_ACTIVITY_CODE_NOTIFICATION.LOB_CONFIGURATION_ENTRY_ID,INVALID_ACTIVITY_CODE_NOTIFICATION.TEAM_LEADER_ID FROM INVALID_ACTIVITY_CODE_NOTIFICATION INVALID_ACTIVITY_CODE_NOTIFICATION ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO INVALID_ACTIVITY_CODE_NOTIFICATION (ID,DATE,MESSAGE,NAME,TYPE,LOB_CONFIGURATION_ID,AGENT_ID,LOB_CONFIGURATION_ENTRY_ID,TEAM_LEADER_ID) VALUES (?,?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE INVALID_ACTIVITY_CODE_NOTIFICATION SET DATE=?,MESSAGE=?,NAME=?,TYPE=?,LOB_CONFIGURATION_ID=?,AGENT_ID=?,LOB_CONFIGURATION_ENTRY_ID=?,TEAM_LEADER_ID=? WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM INVALID_ACTIVITY_CODE_NOTIFICATION WHERE ID=?";
	}
	
	@Override
	protected InvalidActivityCodeNotification extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	InvalidActivityCodeNotification nextResult = new InvalidActivityCodeNotification();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setDate(rs.getString("DATE"));

nextResult.setMessage(rs.getString("MESSAGE"));

nextResult.setName(rs.getString("NAME"));

nextResult.setType(rs.getString("TYPE"));

LOBConfiguration lobconfiguration = new LOBConfiguration();
lobconfiguration.setID(rs.getString("LOB_CONFIGURATION_ID"));
nextResult.setLOBConfiguration(lobconfiguration);

Agent agent = new Agent();
agent.setID(rs.getString("AGENT_ID"));
nextResult.setAgent(agent);

LOBConfigurationEntry lobconfigurationentry = new LOBConfigurationEntry();
lobconfigurationentry.setID(rs.getString("LOB_CONFIGURATION_ENTRY_ID"));
nextResult.setLOBConfigurationEntry(lobconfigurationentry);

TeamLeader teamleader = new TeamLeader();
teamleader.setID(rs.getString("TEAM_LEADER_ID"));
nextResult.setTeamLeader(teamleader);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(InvalidActivityCodeNotification perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getDate());
pstmt.setString(3, perceroObject.getMessage());
pstmt.setString(4, perceroObject.getName());
pstmt.setString(5, perceroObject.getType());

if (perceroObject.getLOBConfiguration() == null)
{
pstmt.setString(6, null);
}
else
{
		pstmt.setString(6, perceroObject.getLOBConfiguration().getID());
}


if (perceroObject.getAgent() == null)
{
pstmt.setString(7, null);
}
else
{
		pstmt.setString(7, perceroObject.getAgent().getID());
}


if (perceroObject.getLOBConfigurationEntry() == null)
{
pstmt.setString(8, null);
}
else
{
		pstmt.setString(8, perceroObject.getLOBConfigurationEntry().getID());
}


if (perceroObject.getTeamLeader() == null)
{
pstmt.setString(9, null);
}
else
{
		pstmt.setString(9, perceroObject.getTeamLeader().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(InvalidActivityCodeNotification perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getDate());
pstmt.setString(2, perceroObject.getMessage());
pstmt.setString(3, perceroObject.getName());
pstmt.setString(4, perceroObject.getType());

if (perceroObject.getLOBConfiguration() == null)
{
pstmt.setString(5, null);
}
else
{
		pstmt.setString(5, perceroObject.getLOBConfiguration().getID());
}


if (perceroObject.getAgent() == null)
{
pstmt.setString(6, null);
}
else
{
		pstmt.setString(6, perceroObject.getAgent().getID());
}


if (perceroObject.getLOBConfigurationEntry() == null)
{
pstmt.setString(7, null);
}
else
{
		pstmt.setString(7, perceroObject.getLOBConfigurationEntry().getID());
}


if (perceroObject.getTeamLeader() == null)
{
pstmt.setString(8, null);
}
else
{
		pstmt.setString(8, perceroObject.getTeamLeader().getID());
}

pstmt.setString(9, perceroObject.getID());

		
	}

	@Override
	public List<InvalidActivityCodeNotification> findByExample(InvalidActivityCodeNotification theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useDate = StringUtils.hasText(theQueryObject.getDate()) && (excludeProperties == null || !excludeProperties.contains("date"));

if (useDate)
{
sql += " WHERE ";
sql += " DATE=? ";
paramValues.add(theQueryObject.getDate());
propertyCounter++;
}

boolean useMessage = StringUtils.hasText(theQueryObject.getMessage()) && (excludeProperties == null || !excludeProperties.contains("message"));

if (useMessage)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " MESSAGE=? ";
paramValues.add(theQueryObject.getMessage());
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
sql += " NAME=? ";
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
sql += " TYPE=? ";
paramValues.add(theQueryObject.getType());
propertyCounter++;
}

boolean useLOBConfigurationID = theQueryObject.getLOBConfiguration() != null && (excludeProperties == null || !excludeProperties.contains("lOBConfiguration"));

if (useLOBConfigurationID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " LOB_CONFIGURATION_ID=? ";
paramValues.add(theQueryObject.getLOBConfiguration().getID());
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
sql += " AGENT_ID=? ";
paramValues.add(theQueryObject.getAgent().getID());
propertyCounter++;
}

boolean useLOBConfigurationEntryID = theQueryObject.getLOBConfigurationEntry() != null && (excludeProperties == null || !excludeProperties.contains("lOBConfigurationEntry"));

if (useLOBConfigurationEntryID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " LOB_CONFIGURATION_ENTRY_ID=? ";
paramValues.add(theQueryObject.getLOBConfigurationEntry().getID());
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
sql += " TEAM_LEADER_ID=? ";
paramValues.add(theQueryObject.getTeamLeader().getID());
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
