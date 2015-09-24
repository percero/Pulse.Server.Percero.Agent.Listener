
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
import com.pulse.mo.DiscrepancyDetectedNotification;
import com.pulse.mo.AuxMode;
import com.pulse.mo.EStartActivityCode;

*/

@Component
public class DiscrepancyDetectedNotificationDAO extends SqlDataAccessObject<DiscrepancyDetectedNotification> implements IDataAccessObject<DiscrepancyDetectedNotification> {

	static final Logger log = Logger.getLogger(DiscrepancyDetectedNotificationDAO.class);

	
	public DiscrepancyDetectedNotificationDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(DiscrepancyDetectedNotification.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	@Override
	protected String getConnectionFactoryName() {
		return DiscrepancyDetectedNotificationDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT discrepancydetectednotification.ID FROM DiscrepancyDetectedNotification discrepancydetectednotification WHERE discrepancydetectednotification.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT discrepancydetectednotification.ID,discrepancydetectednotification.externalID,discrepancydetectednotification.type,discrepancydetectednotification.message,discrepancydetectednotification.name,discrepancydetectednotification.eStartActivityCodeName,discrepancydetectednotification.auxCodeEntryName,discrepancydetectednotification.date,discrepancydetectednotification.agent_ID,discrepancydetectednotification.lOBConfiguration_ID,discrepancydetectednotification.eStartActivityCode_ID,discrepancydetectednotification.auxMode_ID,discrepancydetectednotification.teamLeader_ID FROM DiscrepancyDetectedNotification discrepancydetectednotification WHERE discrepancydetectednotification.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT discrepancydetectednotification.ID FROM DiscrepancyDetectedNotification discrepancydetectednotification ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT discrepancydetectednotification.ID FROM DiscrepancyDetectedNotification discrepancydetectednotification ORDER BY discrepancydetectednotification.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT discrepancydetectednotification.ID,discrepancydetectednotification.externalID,discrepancydetectednotification.type,discrepancydetectednotification.message,discrepancydetectednotification.name,discrepancydetectednotification.eStartActivityCodeName,discrepancydetectednotification.auxCodeEntryName,discrepancydetectednotification.date,discrepancydetectednotification.agent_ID,discrepancydetectednotification.lOBConfiguration_ID,discrepancydetectednotification.eStartActivityCode_ID,discrepancydetectednotification.auxMode_ID,discrepancydetectednotification.teamLeader_ID FROM DiscrepancyDetectedNotification discrepancydetectednotification ORDER BY discrepancydetectednotification.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT discrepancydetectednotification.ID,discrepancydetectednotification.externalID,discrepancydetectednotification.type,discrepancydetectednotification.message,discrepancydetectednotification.name,discrepancydetectednotification.eStartActivityCodeName,discrepancydetectednotification.auxCodeEntryName,discrepancydetectednotification.date,discrepancydetectednotification.agent_ID,discrepancydetectednotification.lOBConfiguration_ID,discrepancydetectednotification.eStartActivityCode_ID,discrepancydetectednotification.auxMode_ID,discrepancydetectednotification.teamLeader_ID FROM DiscrepancyDetectedNotification discrepancydetectednotification ORDER BY discrepancydetectednotification.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM DiscrepancyDetectedNotification discrepancydetectednotification";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT discrepancydetectednotification.ID,discrepancydetectednotification.externalID,discrepancydetectednotification.type,discrepancydetectednotification.message,discrepancydetectednotification.name,discrepancydetectednotification.eStartActivityCodeName,discrepancydetectednotification.auxCodeEntryName,discrepancydetectednotification.date,discrepancydetectednotification.agent_ID,discrepancydetectednotification.lOBConfiguration_ID,discrepancydetectednotification.eStartActivityCode_ID,discrepancydetectednotification.auxMode_ID,discrepancydetectednotification.teamLeader_ID FROM DiscrepancyDetectedNotification discrepancydetectednotification WHERE discrepancydetectednotification.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT discrepancydetectednotification.ID FROM DiscrepancyDetectedNotification discrepancydetectednotification WHERE discrepancydetectednotification.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT discrepancydetectednotification.ID,discrepancydetectednotification.externalID,discrepancydetectednotification.type,discrepancydetectednotification.message,discrepancydetectednotification.name,discrepancydetectednotification.eStartActivityCodeName,discrepancydetectednotification.auxCodeEntryName,discrepancydetectednotification.date,discrepancydetectednotification.agent_ID,discrepancydetectednotification.lOBConfiguration_ID,discrepancydetectednotification.eStartActivityCode_ID,discrepancydetectednotification.auxMode_ID,discrepancydetectednotification.teamLeader_ID FROM DiscrepancyDetectedNotification discrepancydetectednotification WHERE discrepancydetectednotification." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT discrepancydetectednotification.ID FROM DiscrepancyDetectedNotification discrepancydetectednotification WHERE discrepancydetectednotification." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT discrepancydetectednotification.ID FROM DiscrepancyDetectedNotification discrepancydetectednotification ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT discrepancydetectednotification.ID,discrepancydetectednotification.externalID,discrepancydetectednotification.type,discrepancydetectednotification.message,discrepancydetectednotification.name,discrepancydetectednotification.eStartActivityCodeName,discrepancydetectednotification.auxCodeEntryName,discrepancydetectednotification.date,discrepancydetectednotification.agent_ID,discrepancydetectednotification.lOBConfiguration_ID,discrepancydetectednotification.eStartActivityCode_ID,discrepancydetectednotification.auxMode_ID,discrepancydetectednotification.teamLeader_ID FROM DiscrepancyDetectedNotification discrepancydetectednotification ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO DiscrepancyDetectedNotification (ID,externalID,type,message,name,eStartActivityCodeName,auxCodeEntryName,date,agent_ID,lOBConfiguration_ID,eStartActivityCode_ID,auxMode_ID,teamLeader_ID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE DiscrepancyDetectedNotification SET externalID=?,type=?,message=?,name=?,eStartActivityCodeName=?,auxCodeEntryName=?,date=?,agent_ID=?,lOBConfiguration_ID=?,eStartActivityCode_ID=?,auxMode_ID=?,teamLeader_ID=? WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM DiscrepancyDetectedNotification WHERE ID=?";
	}
	
	@Override
	protected DiscrepancyDetectedNotification extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	DiscrepancyDetectedNotification nextResult = new DiscrepancyDetectedNotification();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setExternalID(rs.getString("externalID"));

nextResult.setType(rs.getString("type"));

nextResult.setMessage(rs.getString("message"));

nextResult.setName(rs.getString("name"));

nextResult.setEStartActivityCodeName(rs.getString("eStartActivityCodeName"));

nextResult.setAuxCodeEntryName(rs.getString("auxCodeEntryName"));

nextResult.setDate(rs.getString("date"));

Agent agent = new Agent();
agent.setID(rs.getString("agent_ID"));
nextResult.setAgent(agent);

LOBConfiguration lobconfiguration = new LOBConfiguration();
lobconfiguration.setID(rs.getString("lobconfiguration_ID"));
nextResult.setLOBConfiguration(lobconfiguration);

EStartActivityCode estartactivitycode = new EStartActivityCode();
estartactivitycode.setID(rs.getString("estartactivitycode_ID"));
nextResult.setEStartActivityCode(estartactivitycode);

AuxMode auxmode = new AuxMode();
auxmode.setID(rs.getString("auxmode_ID"));
nextResult.setAuxMode(auxmode);

TeamLeader teamleader = new TeamLeader();
teamleader.setID(rs.getString("teamleader_ID"));
nextResult.setTeamLeader(teamleader);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(DiscrepancyDetectedNotification perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getExternalID());
pstmt.setString(3, perceroObject.getType());
pstmt.setString(4, perceroObject.getMessage());
pstmt.setString(5, perceroObject.getName());
pstmt.setString(6, perceroObject.getEStartActivityCodeName());
pstmt.setString(7, perceroObject.getAuxCodeEntryName());
pstmt.setString(8, perceroObject.getDate());

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


if (perceroObject.getEStartActivityCode() == null)
{
pstmt.setString(11, null);
}
else
{
		pstmt.setString(11, perceroObject.getEStartActivityCode().getID());
}


if (perceroObject.getAuxMode() == null)
{
pstmt.setString(12, null);
}
else
{
		pstmt.setString(12, perceroObject.getAuxMode().getID());
}


if (perceroObject.getTeamLeader() == null)
{
pstmt.setString(13, null);
}
else
{
		pstmt.setString(13, perceroObject.getTeamLeader().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(DiscrepancyDetectedNotification perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getExternalID());
pstmt.setString(2, perceroObject.getType());
pstmt.setString(3, perceroObject.getMessage());
pstmt.setString(4, perceroObject.getName());
pstmt.setString(5, perceroObject.getEStartActivityCodeName());
pstmt.setString(6, perceroObject.getAuxCodeEntryName());
pstmt.setString(7, perceroObject.getDate());

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


if (perceroObject.getEStartActivityCode() == null)
{
pstmt.setString(10, null);
}
else
{
		pstmt.setString(10, perceroObject.getEStartActivityCode().getID());
}


if (perceroObject.getAuxMode() == null)
{
pstmt.setString(11, null);
}
else
{
		pstmt.setString(11, perceroObject.getAuxMode().getID());
}


if (perceroObject.getTeamLeader() == null)
{
pstmt.setString(12, null);
}
else
{
		pstmt.setString(12, perceroObject.getTeamLeader().getID());
}

pstmt.setString(13, perceroObject.getID());

		
	}

	@Override
	public List<DiscrepancyDetectedNotification> findByExample(DiscrepancyDetectedNotification theQueryObject,
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

boolean useEStartActivityCodeName = StringUtils.hasText(theQueryObject.getEStartActivityCodeName()) && (excludeProperties == null || !excludeProperties.contains("eStartActivityCodeName"));

if (useEStartActivityCodeName)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " eStartActivityCodeName=? ";
paramValues.add(theQueryObject.getEStartActivityCodeName());
propertyCounter++;
}

boolean useAuxCodeEntryName = StringUtils.hasText(theQueryObject.getAuxCodeEntryName()) && (excludeProperties == null || !excludeProperties.contains("auxCodeEntryName"));

if (useAuxCodeEntryName)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " auxCodeEntryName=? ";
paramValues.add(theQueryObject.getAuxCodeEntryName());
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

boolean useEStartActivityCodeID = theQueryObject.getEStartActivityCode() != null && (excludeProperties == null || !excludeProperties.contains("eStartActivityCode"));

if (useEStartActivityCodeID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " eStartActivityCodeID=? ";
paramValues.add(theQueryObject.getEStartActivityCode().getID());
propertyCounter++;
}

boolean useAuxModeID = theQueryObject.getAuxMode() != null && (excludeProperties == null || !excludeProperties.contains("auxMode"));

if (useAuxModeID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " auxModeID=? ";
paramValues.add(theQueryObject.getAuxMode().getID());
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
