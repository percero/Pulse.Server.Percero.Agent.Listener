
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
		return "SELECT lobconfigurationnotification.ID FROM LOBConfigurationNotification lobconfigurationnotification WHERE lobconfigurationnotification.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT lobconfigurationnotification.ID,lobconfigurationnotification.externalID,lobconfigurationnotification.type,lobconfigurationnotification.message,lobconfigurationnotification.name,lobconfigurationnotification.date,lobconfigurationnotification.agent_ID,lobconfigurationnotification.lOBConfiguration_ID,lobconfigurationnotification.teamLeader_ID FROM LOBConfigurationNotification lobconfigurationnotification WHERE lobconfigurationnotification.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT lobconfigurationnotification.ID FROM LOBConfigurationNotification lobconfigurationnotification ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT lobconfigurationnotification.ID FROM LOBConfigurationNotification lobconfigurationnotification ORDER BY lobconfigurationnotification.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT lobconfigurationnotification.ID,lobconfigurationnotification.externalID,lobconfigurationnotification.type,lobconfigurationnotification.message,lobconfigurationnotification.name,lobconfigurationnotification.date,lobconfigurationnotification.agent_ID,lobconfigurationnotification.lOBConfiguration_ID,lobconfigurationnotification.teamLeader_ID FROM LOBConfigurationNotification lobconfigurationnotification ORDER BY lobconfigurationnotification.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT lobconfigurationnotification.ID,lobconfigurationnotification.externalID,lobconfigurationnotification.type,lobconfigurationnotification.message,lobconfigurationnotification.name,lobconfigurationnotification.date,lobconfigurationnotification.agent_ID,lobconfigurationnotification.lOBConfiguration_ID,lobconfigurationnotification.teamLeader_ID FROM LOBConfigurationNotification lobconfigurationnotification ORDER BY lobconfigurationnotification.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM LOBConfigurationNotification lobconfigurationnotification";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT lobconfigurationnotification.ID,lobconfigurationnotification.externalID,lobconfigurationnotification.type,lobconfigurationnotification.message,lobconfigurationnotification.name,lobconfigurationnotification.date,lobconfigurationnotification.agent_ID,lobconfigurationnotification.lOBConfiguration_ID,lobconfigurationnotification.teamLeader_ID FROM LOBConfigurationNotification lobconfigurationnotification WHERE lobconfigurationnotification.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT lobconfigurationnotification.ID FROM LOBConfigurationNotification lobconfigurationnotification WHERE lobconfigurationnotification.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT lobconfigurationnotification.ID,lobconfigurationnotification.externalID,lobconfigurationnotification.type,lobconfigurationnotification.message,lobconfigurationnotification.name,lobconfigurationnotification.date,lobconfigurationnotification.agent_ID,lobconfigurationnotification.lOBConfiguration_ID,lobconfigurationnotification.teamLeader_ID FROM LOBConfigurationNotification lobconfigurationnotification WHERE lobconfigurationnotification." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT lobconfigurationnotification.ID FROM LOBConfigurationNotification lobconfigurationnotification WHERE lobconfigurationnotification." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT lobconfigurationnotification.ID FROM LOBConfigurationNotification lobconfigurationnotification ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT lobconfigurationnotification.ID,lobconfigurationnotification.externalID,lobconfigurationnotification.type,lobconfigurationnotification.message,lobconfigurationnotification.name,lobconfigurationnotification.date,lobconfigurationnotification.agent_ID,lobconfigurationnotification.lOBConfiguration_ID,lobconfigurationnotification.teamLeader_ID FROM LOBConfigurationNotification lobconfigurationnotification ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO LOBConfigurationNotification (ID,externalID,type,message,name,date,agent_ID,lOBConfiguration_ID,teamLeader_ID) VALUES (?,?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE LOBConfigurationNotification SET externalID=?,type=?,message=?,name=?,date=?,agent_ID=?,lOBConfiguration_ID=?,teamLeader_ID=? WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM LOBConfigurationNotification WHERE ID=?";
	}
	
	@Override
	protected LOBConfigurationNotification extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	LOBConfigurationNotification nextResult = new LOBConfigurationNotification();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setExternalID(rs.getString("externalID"));

nextResult.setType(rs.getString("type"));

nextResult.setMessage(rs.getString("message"));

nextResult.setName(rs.getString("name"));

nextResult.setDate(rs.getString("date"));

Agent agent = new Agent();
agent.setID(rs.getString("agent_ID"));
nextResult.setAgent(agent);

LOBConfiguration lobconfiguration = new LOBConfiguration();
lobconfiguration.setID(rs.getString("lobconfiguration_ID"));
nextResult.setLOBConfiguration(lobconfiguration);

TeamLeader teamleader = new TeamLeader();
teamleader.setID(rs.getString("teamleader_ID"));
nextResult.setTeamLeader(teamleader);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(LOBConfigurationNotification perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getExternalID());
pstmt.setString(3, perceroObject.getType());
pstmt.setString(4, perceroObject.getMessage());
pstmt.setString(5, perceroObject.getName());
pstmt.setString(6, perceroObject.getDate());

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


		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(LOBConfigurationNotification perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getExternalID());
pstmt.setString(2, perceroObject.getType());
pstmt.setString(3, perceroObject.getMessage());
pstmt.setString(4, perceroObject.getName());
pstmt.setString(5, perceroObject.getDate());

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

pstmt.setString(9, perceroObject.getID());

		
	}

	@Override
	public List<LOBConfigurationNotification> findByExample(LOBConfigurationNotification theQueryObject,
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
