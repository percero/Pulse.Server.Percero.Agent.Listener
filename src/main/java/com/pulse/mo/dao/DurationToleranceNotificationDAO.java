
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
import com.pulse.mo.DurationToleranceNotification;

*/

@Component
public class DurationToleranceNotificationDAO extends SqlDataAccessObject<DurationToleranceNotification> implements IDataAccessObject<DurationToleranceNotification> {

	static final Logger log = Logger.getLogger(DurationToleranceNotificationDAO.class);

	
	public DurationToleranceNotificationDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(DurationToleranceNotification.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	@Override
	protected String getConnectionFactoryName() {
		return DurationToleranceNotificationDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT DURATION_TOLERANCE_NOTIFICATION.ID FROM DURATION_TOLERANCE_NOTIFICATION DURATION_TOLERANCE_NOTIFICATION WHERE DURATION_TOLERANCE_NOTIFICATION.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT DURATION_TOLERANCE_NOTIFICATION.ID,DURATION_TOLERANCE_NOTIFICATION.DATE,DURATION_TOLERANCE_NOTIFICATION.MESSAGE,DURATION_TOLERANCE_NOTIFICATION.NAME,DURATION_TOLERANCE_NOTIFICATION.TYPE,DURATION_TOLERANCE_NOTIFICATION.AGENT_ID,DURATION_TOLERANCE_NOTIFICATION.LOB_CONFIGURATION_ID,DURATION_TOLERANCE_NOTIFICATION.LOB_CONFIGURATION_ENTRY_ID,DURATION_TOLERANCE_NOTIFICATION.TEAM_LEADER_ID FROM DURATION_TOLERANCE_NOTIFICATION DURATION_TOLERANCE_NOTIFICATION WHERE DURATION_TOLERANCE_NOTIFICATION.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT DURATION_TOLERANCE_NOTIFICATION.ID FROM DURATION_TOLERANCE_NOTIFICATION DURATION_TOLERANCE_NOTIFICATION ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT DURATION_TOLERANCE_NOTIFICATION.ID FROM DURATION_TOLERANCE_NOTIFICATION DURATION_TOLERANCE_NOTIFICATION ORDER BY DURATION_TOLERANCE_NOTIFICATION.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT DURATION_TOLERANCE_NOTIFICATION.ID,DURATION_TOLERANCE_NOTIFICATION.DATE,DURATION_TOLERANCE_NOTIFICATION.MESSAGE,DURATION_TOLERANCE_NOTIFICATION.NAME,DURATION_TOLERANCE_NOTIFICATION.TYPE,DURATION_TOLERANCE_NOTIFICATION.AGENT_ID,DURATION_TOLERANCE_NOTIFICATION.LOB_CONFIGURATION_ID,DURATION_TOLERANCE_NOTIFICATION.LOB_CONFIGURATION_ENTRY_ID,DURATION_TOLERANCE_NOTIFICATION.TEAM_LEADER_ID FROM DURATION_TOLERANCE_NOTIFICATION DURATION_TOLERANCE_NOTIFICATION ORDER BY DURATION_TOLERANCE_NOTIFICATION.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT DURATION_TOLERANCE_NOTIFICATION.ID,DURATION_TOLERANCE_NOTIFICATION.DATE,DURATION_TOLERANCE_NOTIFICATION.MESSAGE,DURATION_TOLERANCE_NOTIFICATION.NAME,DURATION_TOLERANCE_NOTIFICATION.TYPE,DURATION_TOLERANCE_NOTIFICATION.AGENT_ID,DURATION_TOLERANCE_NOTIFICATION.LOB_CONFIGURATION_ID,DURATION_TOLERANCE_NOTIFICATION.LOB_CONFIGURATION_ENTRY_ID,DURATION_TOLERANCE_NOTIFICATION.TEAM_LEADER_ID FROM DURATION_TOLERANCE_NOTIFICATION DURATION_TOLERANCE_NOTIFICATION ORDER BY DURATION_TOLERANCE_NOTIFICATION.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM DURATION_TOLERANCE_NOTIFICATION DURATION_TOLERANCE_NOTIFICATION";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT DURATION_TOLERANCE_NOTIFICATION.ID,DURATION_TOLERANCE_NOTIFICATION.DATE,DURATION_TOLERANCE_NOTIFICATION.MESSAGE,DURATION_TOLERANCE_NOTIFICATION.NAME,DURATION_TOLERANCE_NOTIFICATION.TYPE,DURATION_TOLERANCE_NOTIFICATION.AGENT_ID,DURATION_TOLERANCE_NOTIFICATION.LOB_CONFIGURATION_ID,DURATION_TOLERANCE_NOTIFICATION.LOB_CONFIGURATION_ENTRY_ID,DURATION_TOLERANCE_NOTIFICATION.TEAM_LEADER_ID FROM DURATION_TOLERANCE_NOTIFICATION DURATION_TOLERANCE_NOTIFICATION WHERE DURATION_TOLERANCE_NOTIFICATION.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT DURATION_TOLERANCE_NOTIFICATION.ID FROM DURATION_TOLERANCE_NOTIFICATION DURATION_TOLERANCE_NOTIFICATION WHERE DURATION_TOLERANCE_NOTIFICATION.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT DURATION_TOLERANCE_NOTIFICATION.ID,DURATION_TOLERANCE_NOTIFICATION.DATE,DURATION_TOLERANCE_NOTIFICATION.MESSAGE,DURATION_TOLERANCE_NOTIFICATION.NAME,DURATION_TOLERANCE_NOTIFICATION.TYPE,DURATION_TOLERANCE_NOTIFICATION.AGENT_ID,DURATION_TOLERANCE_NOTIFICATION.LOB_CONFIGURATION_ID,DURATION_TOLERANCE_NOTIFICATION.LOB_CONFIGURATION_ENTRY_ID,DURATION_TOLERANCE_NOTIFICATION.TEAM_LEADER_ID FROM DURATION_TOLERANCE_NOTIFICATION DURATION_TOLERANCE_NOTIFICATION WHERE DURATION_TOLERANCE_NOTIFICATION." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT DURATION_TOLERANCE_NOTIFICATION.ID FROM DURATION_TOLERANCE_NOTIFICATION DURATION_TOLERANCE_NOTIFICATION WHERE DURATION_TOLERANCE_NOTIFICATION." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT DURATION_TOLERANCE_NOTIFICATION.ID FROM DURATION_TOLERANCE_NOTIFICATION DURATION_TOLERANCE_NOTIFICATION ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT DURATION_TOLERANCE_NOTIFICATION.ID,DURATION_TOLERANCE_NOTIFICATION.DATE,DURATION_TOLERANCE_NOTIFICATION.MESSAGE,DURATION_TOLERANCE_NOTIFICATION.NAME,DURATION_TOLERANCE_NOTIFICATION.TYPE,DURATION_TOLERANCE_NOTIFICATION.AGENT_ID,DURATION_TOLERANCE_NOTIFICATION.LOB_CONFIGURATION_ID,DURATION_TOLERANCE_NOTIFICATION.LOB_CONFIGURATION_ENTRY_ID,DURATION_TOLERANCE_NOTIFICATION.TEAM_LEADER_ID FROM DURATION_TOLERANCE_NOTIFICATION DURATION_TOLERANCE_NOTIFICATION ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO DURATION_TOLERANCE_NOTIFICATION (ID,DATE,MESSAGE,NAME,TYPE,AGENT_ID,LOB_CONFIGURATION_ID,LOB_CONFIGURATION_ENTRY_ID,TEAM_LEADER_ID) VALUES (?,?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE DURATION_TOLERANCE_NOTIFICATION SET DATE=?,MESSAGE=?,NAME=?,TYPE=?,AGENT_ID,LOB_CONFIGURATION_ID,LOB_CONFIGURATION_ENTRY_ID,TEAM_LEADER_ID WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM DURATION_TOLERANCE_NOTIFICATION WHERE ID=?";
	}
	
	@Override
	protected DurationToleranceNotification extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	DurationToleranceNotification nextResult = new DurationToleranceNotification();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setDate(rs.getString("DATE"));

nextResult.setMessage(rs.getString("MESSAGE"));

nextResult.setName(rs.getString("NAME"));

nextResult.setType(rs.getString("TYPE"));

Agent agent = new Agent();
agent.setID(rs.getString("AGENT_ID"));
nextResult.setAgent(agent);

LOBConfiguration lobconfiguration = new LOBConfiguration();
lobconfiguration.setID(rs.getString("LOB_CONFIGURATION_ID"));
nextResult.setLOBConfiguration(lobconfiguration);

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
	protected void setPreparedStatmentInsertParams(DurationToleranceNotification perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getDate());
pstmt.setString(3, perceroObject.getMessage());
pstmt.setString(4, perceroObject.getName());
pstmt.setString(5, perceroObject.getType());

if (perceroObject.getAgent() == null)
{
pstmt.setString(6, null);
}
else
{
		pstmt.setString(6, perceroObject.getAgent().getID());
}


if (perceroObject.getLOBConfiguration() == null)
{
pstmt.setString(7, null);
}
else
{
		pstmt.setString(7, perceroObject.getLOBConfiguration().getID());
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
	protected void setPreparedStatmentUpdateParams(DurationToleranceNotification perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getDate());
pstmt.setString(2, perceroObject.getMessage());
pstmt.setString(3, perceroObject.getName());
pstmt.setString(4, perceroObject.getType());

if (perceroObject.getAgent() == null)
{
pstmt.setString(5, null);
}
else
{
		pstmt.setString(5, perceroObject.getAgent().getID());
}


if (perceroObject.getLOBConfiguration() == null)
{
pstmt.setString(6, null);
}
else
{
		pstmt.setString(6, perceroObject.getLOBConfiguration().getID());
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
	public List<DurationToleranceNotification> findByExample(DurationToleranceNotification theQueryObject,
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
