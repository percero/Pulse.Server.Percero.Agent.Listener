
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
import com.pulse.mo.WorkModeOccurrenceNotification;

*/

@Component
public class WorkModeOccurrenceNotificationDAO extends SqlDataAccessObject<WorkModeOccurrenceNotification> implements IDataAccessObject<WorkModeOccurrenceNotification> {

	static final Logger log = Logger.getLogger(WorkModeOccurrenceNotificationDAO.class);

	
	public WorkModeOccurrenceNotificationDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(WorkModeOccurrenceNotification.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	@Override
	protected String getConnectionFactoryName() {
		return WorkModeOccurrenceNotificationDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT workmodeoccurrencenotification.ID FROM WorkModeOccurrenceNotification workmodeoccurrencenotification WHERE workmodeoccurrencenotification.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT workmodeoccurrencenotification.ID,workmodeoccurrencenotification.externalID,workmodeoccurrencenotification.type,workmodeoccurrencenotification.date,workmodeoccurrencenotification.loginCount,workmodeoccurrencenotification.logoutCount,workmodeoccurrencenotification.message,workmodeoccurrencenotification.name,workmodeoccurrencenotification.agent_ID,workmodeoccurrencenotification.lOBConfiguration_ID,workmodeoccurrencenotification.lOBConfigurationEntry_ID,workmodeoccurrencenotification.teamLeader_ID FROM WorkModeOccurrenceNotification workmodeoccurrencenotification WHERE workmodeoccurrencenotification.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT workmodeoccurrencenotification.ID FROM WorkModeOccurrenceNotification workmodeoccurrencenotification ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT workmodeoccurrencenotification.ID FROM WorkModeOccurrenceNotification workmodeoccurrencenotification ORDER BY workmodeoccurrencenotification.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT workmodeoccurrencenotification.ID,workmodeoccurrencenotification.externalID,workmodeoccurrencenotification.type,workmodeoccurrencenotification.date,workmodeoccurrencenotification.loginCount,workmodeoccurrencenotification.logoutCount,workmodeoccurrencenotification.message,workmodeoccurrencenotification.name,workmodeoccurrencenotification.agent_ID,workmodeoccurrencenotification.lOBConfiguration_ID,workmodeoccurrencenotification.lOBConfigurationEntry_ID,workmodeoccurrencenotification.teamLeader_ID FROM WorkModeOccurrenceNotification workmodeoccurrencenotification ORDER BY workmodeoccurrencenotification.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT workmodeoccurrencenotification.ID,workmodeoccurrencenotification.externalID,workmodeoccurrencenotification.type,workmodeoccurrencenotification.date,workmodeoccurrencenotification.loginCount,workmodeoccurrencenotification.logoutCount,workmodeoccurrencenotification.message,workmodeoccurrencenotification.name,workmodeoccurrencenotification.agent_ID,workmodeoccurrencenotification.lOBConfiguration_ID,workmodeoccurrencenotification.lOBConfigurationEntry_ID,workmodeoccurrencenotification.teamLeader_ID FROM WorkModeOccurrenceNotification workmodeoccurrencenotification ORDER BY workmodeoccurrencenotification.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM WorkModeOccurrenceNotification workmodeoccurrencenotification";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT workmodeoccurrencenotification.ID,workmodeoccurrencenotification.externalID,workmodeoccurrencenotification.type,workmodeoccurrencenotification.date,workmodeoccurrencenotification.loginCount,workmodeoccurrencenotification.logoutCount,workmodeoccurrencenotification.message,workmodeoccurrencenotification.name,workmodeoccurrencenotification.agent_ID,workmodeoccurrencenotification.lOBConfiguration_ID,workmodeoccurrencenotification.lOBConfigurationEntry_ID,workmodeoccurrencenotification.teamLeader_ID FROM WorkModeOccurrenceNotification workmodeoccurrencenotification WHERE workmodeoccurrencenotification.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT workmodeoccurrencenotification.ID FROM WorkModeOccurrenceNotification workmodeoccurrencenotification WHERE workmodeoccurrencenotification.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT workmodeoccurrencenotification.ID,workmodeoccurrencenotification.externalID,workmodeoccurrencenotification.type,workmodeoccurrencenotification.date,workmodeoccurrencenotification.loginCount,workmodeoccurrencenotification.logoutCount,workmodeoccurrencenotification.message,workmodeoccurrencenotification.name,workmodeoccurrencenotification.agent_ID,workmodeoccurrencenotification.lOBConfiguration_ID,workmodeoccurrencenotification.lOBConfigurationEntry_ID,workmodeoccurrencenotification.teamLeader_ID FROM WorkModeOccurrenceNotification workmodeoccurrencenotification WHERE workmodeoccurrencenotification." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT workmodeoccurrencenotification.ID FROM WorkModeOccurrenceNotification workmodeoccurrencenotification WHERE workmodeoccurrencenotification." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT workmodeoccurrencenotification.ID FROM WorkModeOccurrenceNotification workmodeoccurrencenotification ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT workmodeoccurrencenotification.ID,workmodeoccurrencenotification.externalID,workmodeoccurrencenotification.type,workmodeoccurrencenotification.date,workmodeoccurrencenotification.loginCount,workmodeoccurrencenotification.logoutCount,workmodeoccurrencenotification.message,workmodeoccurrencenotification.name,workmodeoccurrencenotification.agent_ID,workmodeoccurrencenotification.lOBConfiguration_ID,workmodeoccurrencenotification.lOBConfigurationEntry_ID,workmodeoccurrencenotification.teamLeader_ID FROM WorkModeOccurrenceNotification workmodeoccurrencenotification ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO WorkModeOccurrenceNotification (ID,externalID,type,date,loginCount,logoutCount,message,name,agent_ID,lOBConfiguration_ID,lOBConfigurationEntry_ID,teamLeader_ID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE WorkModeOccurrenceNotification SET externalID=?,type=?,date=?,loginCount=?,logoutCount=?,message=?,name=?,agent_ID=?,lOBConfiguration_ID=?,lOBConfigurationEntry_ID=?,teamLeader_ID=? WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM WorkModeOccurrenceNotification WHERE ID=?";
	}
	
	@Override
	protected WorkModeOccurrenceNotification extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	WorkModeOccurrenceNotification nextResult = new WorkModeOccurrenceNotification();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setExternalID(rs.getString("externalID"));

nextResult.setType(rs.getString("type"));

nextResult.setDate(rs.getString("date"));

nextResult.setLoginCount(rs.getInt("loginCount"));

nextResult.setLogoutCount(rs.getInt("logoutCount"));

nextResult.setMessage(rs.getString("message"));

nextResult.setName(rs.getString("name"));

Agent agent = new Agent();
agent.setID(rs.getString("agent_ID"));
nextResult.setAgent(agent);

LOBConfiguration lobconfiguration = new LOBConfiguration();
lobconfiguration.setID(rs.getString("lobconfiguration_ID"));
nextResult.setLOBConfiguration(lobconfiguration);

LOBConfigurationEntry lobconfigurationentry = new LOBConfigurationEntry();
lobconfigurationentry.setID(rs.getString("lobconfigurationentry_ID"));
nextResult.setLOBConfigurationEntry(lobconfigurationentry);

TeamLeader teamleader = new TeamLeader();
teamleader.setID(rs.getString("teamleader_ID"));
nextResult.setTeamLeader(teamleader);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(WorkModeOccurrenceNotification perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getExternalID());
pstmt.setString(3, perceroObject.getType());
pstmt.setString(4, perceroObject.getDate());
pstmt.setInt(5, perceroObject.getLoginCount());
pstmt.setInt(6, perceroObject.getLogoutCount());
pstmt.setString(7, perceroObject.getMessage());
pstmt.setString(8, perceroObject.getName());

if (perceroObject.getAgent() == null)
{
pstmt.setString(9, null);
}
else
{
		pstmt.setString(9, perceroObject.getAgent().getID());
}


if (perceroObject.getLOBConfiguration() == null)
{
pstmt.setString(10, null);
}
else
{
		pstmt.setString(10, perceroObject.getLOBConfiguration().getID());
}


if (perceroObject.getLOBConfigurationEntry() == null)
{
pstmt.setString(11, null);
}
else
{
		pstmt.setString(11, perceroObject.getLOBConfigurationEntry().getID());
}


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
	protected void setPreparedStatmentUpdateParams(WorkModeOccurrenceNotification perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getExternalID());
pstmt.setString(2, perceroObject.getType());
pstmt.setString(3, perceroObject.getDate());
pstmt.setInt(4, perceroObject.getLoginCount());
pstmt.setInt(5, perceroObject.getLogoutCount());
pstmt.setString(6, perceroObject.getMessage());
pstmt.setString(7, perceroObject.getName());

if (perceroObject.getAgent() == null)
{
pstmt.setString(8, null);
}
else
{
		pstmt.setString(8, perceroObject.getAgent().getID());
}


if (perceroObject.getLOBConfiguration() == null)
{
pstmt.setString(9, null);
}
else
{
		pstmt.setString(9, perceroObject.getLOBConfiguration().getID());
}


if (perceroObject.getLOBConfigurationEntry() == null)
{
pstmt.setString(10, null);
}
else
{
		pstmt.setString(10, perceroObject.getLOBConfigurationEntry().getID());
}


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
	public List<WorkModeOccurrenceNotification> findByExample(WorkModeOccurrenceNotification theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useExternalID = StringUtils.hasText(theQueryObject.getExternalID()) && (excludeProperties == null || !excludeProperties.contains("externalID"));

if (useExternalID)
{
sql += " WHERE ";
paramValues.add(theQueryObject.getExternalID());
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
sql += " type=? ";
paramValues.add(theQueryObject.getType());
propertyCounter++;
}

boolean useDate = StringUtils.hasText(theQueryObject.getDate()) && (excludeProperties == null || !excludeProperties.contains("date"));

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
sql += " date=? ";
paramValues.add(theQueryObject.getDate());
propertyCounter++;
}

boolean useLoginCount = theQueryObject.getLoginCount() != null && (excludeProperties == null || !excludeProperties.contains("loginCount"));

if (useLoginCount)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " loginCount=? ";
paramValues.add(theQueryObject.getLoginCount());
propertyCounter++;
}

boolean useLogoutCount = theQueryObject.getLogoutCount() != null && (excludeProperties == null || !excludeProperties.contains("logoutCount"));

if (useLogoutCount)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " logoutCount=? ";
paramValues.add(theQueryObject.getLogoutCount());
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
sql += " message=? ";
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
sql += " name=? ";
paramValues.add(theQueryObject.getName());
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
sql += " agentID=? ";
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
sql += " lOBConfigurationID=? ";
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
sql += " lOBConfigurationEntryID=? ";
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
sql += " teamLeaderID=? ";
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
