
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
		return "SELECT invalidactivitycodenotification.ID FROM InvalidActivityCodeNotification invalidactivitycodenotification WHERE invalidactivitycodenotification.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT invalidactivitycodenotification.ID,invalidactivitycodenotification.externalID,invalidactivitycodenotification.message,invalidactivitycodenotification.name,invalidactivitycodenotification.date,invalidactivitycodenotification.type,invalidactivitycodenotification.agent_ID,invalidactivitycodenotification.lOBConfiguration_ID,invalidactivitycodenotification.teamLeader_ID,invalidactivitycodenotification.lOBConfigurationEntry_ID FROM InvalidActivityCodeNotification invalidactivitycodenotification WHERE invalidactivitycodenotification.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT invalidactivitycodenotification.ID FROM InvalidActivityCodeNotification invalidactivitycodenotification ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT invalidactivitycodenotification.ID FROM InvalidActivityCodeNotification invalidactivitycodenotification ORDER BY invalidactivitycodenotification.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT invalidactivitycodenotification.ID,invalidactivitycodenotification.externalID,invalidactivitycodenotification.message,invalidactivitycodenotification.name,invalidactivitycodenotification.date,invalidactivitycodenotification.type,invalidactivitycodenotification.agent_ID,invalidactivitycodenotification.lOBConfiguration_ID,invalidactivitycodenotification.teamLeader_ID,invalidactivitycodenotification.lOBConfigurationEntry_ID FROM InvalidActivityCodeNotification invalidactivitycodenotification ORDER BY invalidactivitycodenotification.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT invalidactivitycodenotification.ID,invalidactivitycodenotification.externalID,invalidactivitycodenotification.message,invalidactivitycodenotification.name,invalidactivitycodenotification.date,invalidactivitycodenotification.type,invalidactivitycodenotification.agent_ID,invalidactivitycodenotification.lOBConfiguration_ID,invalidactivitycodenotification.teamLeader_ID,invalidactivitycodenotification.lOBConfigurationEntry_ID FROM InvalidActivityCodeNotification invalidactivitycodenotification ORDER BY invalidactivitycodenotification.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM InvalidActivityCodeNotification invalidactivitycodenotification";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT invalidactivitycodenotification.ID,invalidactivitycodenotification.externalID,invalidactivitycodenotification.message,invalidactivitycodenotification.name,invalidactivitycodenotification.date,invalidactivitycodenotification.type,invalidactivitycodenotification.agent_ID,invalidactivitycodenotification.lOBConfiguration_ID,invalidactivitycodenotification.teamLeader_ID,invalidactivitycodenotification.lOBConfigurationEntry_ID FROM InvalidActivityCodeNotification invalidactivitycodenotification WHERE invalidactivitycodenotification.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT invalidactivitycodenotification.ID FROM InvalidActivityCodeNotification invalidactivitycodenotification WHERE invalidactivitycodenotification.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT invalidactivitycodenotification.ID,invalidactivitycodenotification.externalID,invalidactivitycodenotification.message,invalidactivitycodenotification.name,invalidactivitycodenotification.date,invalidactivitycodenotification.type,invalidactivitycodenotification.agent_ID,invalidactivitycodenotification.lOBConfiguration_ID,invalidactivitycodenotification.teamLeader_ID,invalidactivitycodenotification.lOBConfigurationEntry_ID FROM InvalidActivityCodeNotification invalidactivitycodenotification WHERE invalidactivitycodenotification." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT invalidactivitycodenotification.ID FROM InvalidActivityCodeNotification invalidactivitycodenotification WHERE invalidactivitycodenotification." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT invalidactivitycodenotification.ID FROM InvalidActivityCodeNotification invalidactivitycodenotification ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT invalidactivitycodenotification.ID,invalidactivitycodenotification.externalID,invalidactivitycodenotification.message,invalidactivitycodenotification.name,invalidactivitycodenotification.date,invalidactivitycodenotification.type,invalidactivitycodenotification.agent_ID,invalidactivitycodenotification.lOBConfiguration_ID,invalidactivitycodenotification.teamLeader_ID,invalidactivitycodenotification.lOBConfigurationEntry_ID FROM InvalidActivityCodeNotification invalidactivitycodenotification ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO InvalidActivityCodeNotification (ID,externalID,message,name,date,type,agent_ID,lOBConfiguration_ID,teamLeader_ID,lOBConfigurationEntry_ID) VALUES (?,?,?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE InvalidActivityCodeNotification SET externalID=?,message=?,name=?,date=?,type=?,agent_ID=?,lOBConfiguration_ID=?,teamLeader_ID=?,lOBConfigurationEntry_ID=? WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM InvalidActivityCodeNotification WHERE ID=?";
	}
	
	@Override
	protected InvalidActivityCodeNotification extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	InvalidActivityCodeNotification nextResult = new InvalidActivityCodeNotification();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setExternalID(rs.getString("externalID"));

nextResult.setMessage(rs.getString("message"));

nextResult.setName(rs.getString("name"));

nextResult.setDate(rs.getString("date"));

nextResult.setType(rs.getString("type"));

Agent agent = new Agent();
agent.setID(rs.getString("agent_ID"));
nextResult.setAgent(agent);

LOBConfiguration lobconfiguration = new LOBConfiguration();
lobconfiguration.setID(rs.getString("lobconfiguration_ID"));
nextResult.setLOBConfiguration(lobconfiguration);

TeamLeader teamleader = new TeamLeader();
teamleader.setID(rs.getString("teamleader_ID"));
nextResult.setTeamLeader(teamleader);

LOBConfigurationEntry lobconfigurationentry = new LOBConfigurationEntry();
lobconfigurationentry.setID(rs.getString("lobconfigurationentry_ID"));
nextResult.setLOBConfigurationEntry(lobconfigurationentry);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(InvalidActivityCodeNotification perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getExternalID());
pstmt.setString(3, perceroObject.getMessage());
pstmt.setString(4, perceroObject.getName());
pstmt.setString(5, perceroObject.getDate());
pstmt.setString(6, perceroObject.getType());

if (perceroObject.getAgent() == null)
{
pstmt.setString(7, null);
}
else
{
		pstmt.setString(7, perceroObject.getAgent().getID());
}


if (perceroObject.getLOBConfiguration() == null)
{
pstmt.setString(8, null);
}
else
{
		pstmt.setString(8, perceroObject.getLOBConfiguration().getID());
}


if (perceroObject.getTeamLeader() == null)
{
pstmt.setString(9, null);
}
else
{
		pstmt.setString(9, perceroObject.getTeamLeader().getID());
}


if (perceroObject.getLOBConfigurationEntry() == null)
{
pstmt.setString(10, null);
}
else
{
		pstmt.setString(10, perceroObject.getLOBConfigurationEntry().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(InvalidActivityCodeNotification perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getExternalID());
pstmt.setString(2, perceroObject.getMessage());
pstmt.setString(3, perceroObject.getName());
pstmt.setString(4, perceroObject.getDate());
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


if (perceroObject.getTeamLeader() == null)
{
pstmt.setString(8, null);
}
else
{
		pstmt.setString(8, perceroObject.getTeamLeader().getID());
}


if (perceroObject.getLOBConfigurationEntry() == null)
{
pstmt.setString(9, null);
}
else
{
		pstmt.setString(9, perceroObject.getLOBConfigurationEntry().getID());
}

pstmt.setString(10, perceroObject.getID());

		
	}

	@Override
	public List<InvalidActivityCodeNotification> findByExample(InvalidActivityCodeNotification theQueryObject,
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
