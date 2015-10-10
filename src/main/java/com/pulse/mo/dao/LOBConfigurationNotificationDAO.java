
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
import com.pulse.mo.LOBConfigurationNotification;
import com.pulse.mo.Agent;
import com.pulse.mo.LOBConfiguration;

*/

@Component
public class LOBConfigurationNotificationDAO extends SqlDataAccessObject<LOBConfigurationNotification> implements IDataAccessObject<LOBConfigurationNotification> {

	static final Logger log = Logger.getLogger(LOBConfigurationNotificationDAO.class);

	
	public LOBConfigurationNotificationDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(LOBConfigurationNotification.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	
	
	
	@Override
	protected String getConnectionFactoryName() {
		return LOBConfigurationNotificationDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT \"LOB_CONFIGURATION_NOTIF\".\"ID\" FROM \"LOB_CONFIGURATION_NOTIF\" \"LOB_CONFIGURATION_NOTIF\" WHERE \"LOB_CONFIGURATION_NOTIF\".\"ID\"=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT \"LOB_CONFIGURATION_NOTIF\".\"ID\",\"LOB_CONFIGURATION_NOTIF\".\"DATE\",\"LOB_CONFIGURATION_NOTIF\".\"MESSAGE\",\"LOB_CONFIGURATION_NOTIF\".\"NAME\",\"LOB_CONFIGURATION_NOTIF\".\"TYPE\",\"LOB_CONFIGURATION_NOTIF\".\"AGENT_ID\",\"LOB_CONFIGURATION_NOTIF\".\"LOB_CONFIGURATION_ID\",\"LOB_CONFIGURATION_NOTIF\".\"TEAM_LEADER_ID\" FROM \"LOB_CONFIGURATION_NOTIF\" \"LOB_CONFIGURATION_NOTIF\" WHERE \"LOB_CONFIGURATION_NOTIF\".\"ID\"=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT \"LOB_CONFIGURATION_NOTIF\".\"ID\" FROM \"LOB_CONFIGURATION_NOTIF\" \"LOB_CONFIGURATION_NOTIF\" ORDER BY \"ID\"";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT \"LOB_CONFIGURATION_NOTIF\".\"ID\" FROM \"LOB_CONFIGURATION_NOTIF\" \"LOB_CONFIGURATION_NOTIF\" ORDER BY \"LOB_CONFIGURATION_NOTIF\".\"ID\" LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT \"LOB_CONFIGURATION_NOTIF\".\"ID\",\"LOB_CONFIGURATION_NOTIF\".\"DATE\",\"LOB_CONFIGURATION_NOTIF\".\"MESSAGE\",\"LOB_CONFIGURATION_NOTIF\".\"NAME\",\"LOB_CONFIGURATION_NOTIF\".\"TYPE\",\"LOB_CONFIGURATION_NOTIF\".\"AGENT_ID\",\"LOB_CONFIGURATION_NOTIF\".\"LOB_CONFIGURATION_ID\",\"LOB_CONFIGURATION_NOTIF\".\"TEAM_LEADER_ID\" FROM \"LOB_CONFIGURATION_NOTIF\" \"LOB_CONFIGURATION_NOTIF\" ORDER BY \"LOB_CONFIGURATION_NOTIF\".\"ID\"";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT \"LOB_CONFIGURATION_NOTIF\".\"ID\",\"LOB_CONFIGURATION_NOTIF\".\"DATE\",\"LOB_CONFIGURATION_NOTIF\".\"MESSAGE\",\"LOB_CONFIGURATION_NOTIF\".\"NAME\",\"LOB_CONFIGURATION_NOTIF\".\"TYPE\",\"LOB_CONFIGURATION_NOTIF\".\"AGENT_ID\",\"LOB_CONFIGURATION_NOTIF\".\"LOB_CONFIGURATION_ID\",\"LOB_CONFIGURATION_NOTIF\".\"TEAM_LEADER_ID\" FROM \"LOB_CONFIGURATION_NOTIF\" \"LOB_CONFIGURATION_NOTIF\" ORDER BY \"LOB_CONFIGURATION_NOTIF\".\"ID\" LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM \"LOB_CONFIGURATION_NOTIF\" \"LOB_CONFIGURATION_NOTIF\"";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT \"LOB_CONFIGURATION_NOTIF\".\"ID\",\"LOB_CONFIGURATION_NOTIF\".\"DATE\",\"LOB_CONFIGURATION_NOTIF\".\"MESSAGE\",\"LOB_CONFIGURATION_NOTIF\".\"NAME\",\"LOB_CONFIGURATION_NOTIF\".\"TYPE\",\"LOB_CONFIGURATION_NOTIF\".\"AGENT_ID\",\"LOB_CONFIGURATION_NOTIF\".\"LOB_CONFIGURATION_ID\",\"LOB_CONFIGURATION_NOTIF\".\"TEAM_LEADER_ID\" FROM \"LOB_CONFIGURATION_NOTIF\" \"LOB_CONFIGURATION_NOTIF\" WHERE \"LOB_CONFIGURATION_NOTIF\".\"ID\" IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT \"LOB_CONFIGURATION_NOTIF\".\"ID\" FROM \"LOB_CONFIGURATION_NOTIF\" \"LOB_CONFIGURATION_NOTIF\" WHERE \"LOB_CONFIGURATION_NOTIF\".\"ID\" IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		return "SELECT \"LOB_CONFIGURATION_NOTIF\".\"ID\",\"LOB_CONFIGURATION_NOTIF\".\"DATE\",\"LOB_CONFIGURATION_NOTIF\".\"MESSAGE\",\"LOB_CONFIGURATION_NOTIF\".\"NAME\",\"LOB_CONFIGURATION_NOTIF\".\"TYPE\",\"LOB_CONFIGURATION_NOTIF\".\"AGENT_ID\",\"LOB_CONFIGURATION_NOTIF\".\"LOB_CONFIGURATION_ID\",\"LOB_CONFIGURATION_NOTIF\".\"TEAM_LEADER_ID\" FROM \"LOB_CONFIGURATION_NOTIF\" \"LOB_CONFIGURATION_NOTIF\" WHERE \"LOB_CONFIGURATION_NOTIF\"." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT \"LOB_CONFIGURATION_NOTIF\".\"ID\" FROM \"LOB_CONFIGURATION_NOTIF\" \"LOB_CONFIGURATION_NOTIF\" WHERE \"LOB_CONFIGURATION_NOTIF\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT \"LOB_CONFIGURATION_NOTIF\".\"ID\" FROM \"LOB_CONFIGURATION_NOTIF\" \"LOB_CONFIGURATION_NOTIF\" ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT \"LOB_CONFIGURATION_NOTIF\".\"ID\",\"LOB_CONFIGURATION_NOTIF\".\"DATE\",\"LOB_CONFIGURATION_NOTIF\".\"MESSAGE\",\"LOB_CONFIGURATION_NOTIF\".\"NAME\",\"LOB_CONFIGURATION_NOTIF\".\"TYPE\",\"LOB_CONFIGURATION_NOTIF\".\"AGENT_ID\",\"LOB_CONFIGURATION_NOTIF\".\"LOB_CONFIGURATION_ID\",\"LOB_CONFIGURATION_NOTIF\".\"TEAM_LEADER_ID\" FROM \"LOB_CONFIGURATION_NOTIF\" \"LOB_CONFIGURATION_NOTIF\" ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO LOB_CONFIGURATION_NOTIF (\"ID\",\"DATE\",\"MESSAGE\",\"NAME\",\"TYPE\",\"AGENT_ID\",\"LOB_CONFIGURATION_ID\",\"TEAM_LEADER_ID\") VALUES (?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE \"LOB_CONFIGURATION_NOTIF\" SET \"DATE\"=?,\"MESSAGE\"=?,\"NAME\"=?,\"TYPE\"=?,\"AGENT_ID\"=?,\"LOB_CONFIGURATION_ID\"=?,\"TEAM_LEADER_ID\"=? WHERE \"ID\"=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM \"LOB_CONFIGURATION_NOTIF\" WHERE \"ID\"=?";
	}
	
	@Override
	protected LOBConfigurationNotification extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	LOBConfigurationNotification nextResult = new LOBConfigurationNotification();
    	
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

TeamLeader teamleader = new TeamLeader();
teamleader.setID(rs.getString("TEAM_LEADER_ID"));
nextResult.setTeamLeader(teamleader);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(LOBConfigurationNotification perceroObject, PreparedStatement pstmt) throws SQLException {
		
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


if (perceroObject.getTeamLeader() == null)
{
pstmt.setString(8, null);
}
else
{
		pstmt.setString(8, perceroObject.getTeamLeader().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(LOBConfigurationNotification perceroObject, PreparedStatement pstmt) throws SQLException {
		
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


if (perceroObject.getTeamLeader() == null)
{
pstmt.setString(7, null);
}
else
{
		pstmt.setString(7, perceroObject.getTeamLeader().getID());
}

pstmt.setString(8, perceroObject.getID());

		
	}

	@Override
	public List<LOBConfigurationNotification> findByExample(LOBConfigurationNotification theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useDate = StringUtils.hasText(theQueryObject.getDate()) && (excludeProperties == null || !excludeProperties.contains("date"));

if (useDate)
{
sql += " WHERE ";
sql += " \"DATE\" =? ";
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
sql += " \"MESSAGE\" =? ";
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
sql += " \"NAME\" =? ";
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
sql += " \"TYPE\" =? ";
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
sql += " \"AGENT_ID\" =? ";
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
sql += " \"LOB_CONFIGURATION_ID\" =? ";
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
sql += " \"TEAM_LEADER_ID\" =? ";
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
