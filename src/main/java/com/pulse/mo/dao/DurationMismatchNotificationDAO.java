
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
import com.pulse.mo.DurationMismatchNotification;

*/

@Component
public class DurationMismatchNotificationDAO extends SqlDataAccessObject<DurationMismatchNotification> implements IDataAccessObject<DurationMismatchNotification> {

	static final Logger log = Logger.getLogger(DurationMismatchNotificationDAO.class);

	
	public DurationMismatchNotificationDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(DurationMismatchNotification.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	@Override
	protected String getConnectionFactoryName() {
		return DurationMismatchNotificationDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT durationmismatchnotification.ID FROM DurationMismatchNotification durationmismatchnotification WHERE durationmismatchnotification.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT durationmismatchnotification.ID,durationmismatchnotification.externalID,durationmismatchnotification.type,durationmismatchnotification.message,durationmismatchnotification.name,durationmismatchnotification.startTime,durationmismatchnotification.date,durationmismatchnotification.duration,durationmismatchnotification.endTime,durationmismatchnotification.auxCodeEntryName,durationmismatchnotification.eStartActivityCodeName,durationmismatchnotification.agent_ID,durationmismatchnotification.lOBConfiguration_ID,durationmismatchnotification.teamLeader_ID,durationmismatchnotification.auxMode_ID,durationmismatchnotification.eStartActivityCode_ID FROM DurationMismatchNotification durationmismatchnotification WHERE durationmismatchnotification.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT durationmismatchnotification.ID FROM DurationMismatchNotification durationmismatchnotification ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT durationmismatchnotification.ID FROM DurationMismatchNotification durationmismatchnotification ORDER BY durationmismatchnotification.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT durationmismatchnotification.ID,durationmismatchnotification.externalID,durationmismatchnotification.type,durationmismatchnotification.message,durationmismatchnotification.name,durationmismatchnotification.startTime,durationmismatchnotification.date,durationmismatchnotification.duration,durationmismatchnotification.endTime,durationmismatchnotification.auxCodeEntryName,durationmismatchnotification.eStartActivityCodeName,durationmismatchnotification.agent_ID,durationmismatchnotification.lOBConfiguration_ID,durationmismatchnotification.teamLeader_ID,durationmismatchnotification.auxMode_ID,durationmismatchnotification.eStartActivityCode_ID FROM DurationMismatchNotification durationmismatchnotification ORDER BY durationmismatchnotification.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT durationmismatchnotification.ID,durationmismatchnotification.externalID,durationmismatchnotification.type,durationmismatchnotification.message,durationmismatchnotification.name,durationmismatchnotification.startTime,durationmismatchnotification.date,durationmismatchnotification.duration,durationmismatchnotification.endTime,durationmismatchnotification.auxCodeEntryName,durationmismatchnotification.eStartActivityCodeName,durationmismatchnotification.agent_ID,durationmismatchnotification.lOBConfiguration_ID,durationmismatchnotification.teamLeader_ID,durationmismatchnotification.auxMode_ID,durationmismatchnotification.eStartActivityCode_ID FROM DurationMismatchNotification durationmismatchnotification ORDER BY durationmismatchnotification.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM DurationMismatchNotification durationmismatchnotification";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT durationmismatchnotification.ID,durationmismatchnotification.externalID,durationmismatchnotification.type,durationmismatchnotification.message,durationmismatchnotification.name,durationmismatchnotification.startTime,durationmismatchnotification.date,durationmismatchnotification.duration,durationmismatchnotification.endTime,durationmismatchnotification.auxCodeEntryName,durationmismatchnotification.eStartActivityCodeName,durationmismatchnotification.agent_ID,durationmismatchnotification.lOBConfiguration_ID,durationmismatchnotification.teamLeader_ID,durationmismatchnotification.auxMode_ID,durationmismatchnotification.eStartActivityCode_ID FROM DurationMismatchNotification durationmismatchnotification WHERE durationmismatchnotification.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT durationmismatchnotification.ID FROM DurationMismatchNotification durationmismatchnotification WHERE durationmismatchnotification.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT durationmismatchnotification.ID,durationmismatchnotification.externalID,durationmismatchnotification.type,durationmismatchnotification.message,durationmismatchnotification.name,durationmismatchnotification.startTime,durationmismatchnotification.date,durationmismatchnotification.duration,durationmismatchnotification.endTime,durationmismatchnotification.auxCodeEntryName,durationmismatchnotification.eStartActivityCodeName,durationmismatchnotification.agent_ID,durationmismatchnotification.lOBConfiguration_ID,durationmismatchnotification.teamLeader_ID,durationmismatchnotification.auxMode_ID,durationmismatchnotification.eStartActivityCode_ID FROM DurationMismatchNotification durationmismatchnotification WHERE durationmismatchnotification." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT durationmismatchnotification.ID FROM DurationMismatchNotification durationmismatchnotification WHERE durationmismatchnotification." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT durationmismatchnotification.ID FROM DurationMismatchNotification durationmismatchnotification ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT durationmismatchnotification.ID,durationmismatchnotification.externalID,durationmismatchnotification.type,durationmismatchnotification.message,durationmismatchnotification.name,durationmismatchnotification.startTime,durationmismatchnotification.date,durationmismatchnotification.duration,durationmismatchnotification.endTime,durationmismatchnotification.auxCodeEntryName,durationmismatchnotification.eStartActivityCodeName,durationmismatchnotification.agent_ID,durationmismatchnotification.lOBConfiguration_ID,durationmismatchnotification.teamLeader_ID,durationmismatchnotification.auxMode_ID,durationmismatchnotification.eStartActivityCode_ID FROM DurationMismatchNotification durationmismatchnotification ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO DurationMismatchNotification (ID,externalID,type,message,name,startTime,date,duration,endTime,auxCodeEntryName,eStartActivityCodeName,agent_ID,lOBConfiguration_ID,teamLeader_ID,auxMode_ID,eStartActivityCode_ID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE DurationMismatchNotification SET externalID=?,type=?,message=?,name=?,startTime=?,date=?,duration=?,endTime=?,auxCodeEntryName=?,eStartActivityCodeName=?,agent_ID=?,lOBConfiguration_ID=?,teamLeader_ID=?,auxMode_ID=?,eStartActivityCode_ID=? WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM DurationMismatchNotification WHERE ID=?";
	}
	
	@Override
	protected DurationMismatchNotification extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	DurationMismatchNotification nextResult = new DurationMismatchNotification();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setExternalID(rs.getString("externalID"));

nextResult.setType(rs.getString("type"));

nextResult.setMessage(rs.getString("message"));

nextResult.setName(rs.getString("name"));

nextResult.setStartTime(rs.getDate("startTime"));

nextResult.setDate(rs.getString("date"));

nextResult.setDuration(rs.getDouble("duration"));

nextResult.setEndTime(rs.getDate("endTime"));

nextResult.setAuxCodeEntryName(rs.getString("auxCodeEntryName"));

nextResult.setEStartActivityCodeName(rs.getString("eStartActivityCodeName"));

Agent agent = new Agent();
agent.setID(rs.getString("agent_ID"));
nextResult.setAgent(agent);

LOBConfiguration lobconfiguration = new LOBConfiguration();
lobconfiguration.setID(rs.getString("lobconfiguration_ID"));
nextResult.setLOBConfiguration(lobconfiguration);

TeamLeader teamleader = new TeamLeader();
teamleader.setID(rs.getString("teamleader_ID"));
nextResult.setTeamLeader(teamleader);

AuxMode auxmode = new AuxMode();
auxmode.setID(rs.getString("auxmode_ID"));
nextResult.setAuxMode(auxmode);

EStartActivityCode estartactivitycode = new EStartActivityCode();
estartactivitycode.setID(rs.getString("estartactivitycode_ID"));
nextResult.setEStartActivityCode(estartactivitycode);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(DurationMismatchNotification perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getExternalID());
pstmt.setString(3, perceroObject.getType());
pstmt.setString(4, perceroObject.getMessage());
pstmt.setString(5, perceroObject.getName());
pstmt.setDate(6, DateUtils.utilDateToSqlDate(perceroObject.getStartTime()));
pstmt.setString(7, perceroObject.getDate());
pstmt.setDouble(8, perceroObject.getDuration());
pstmt.setDate(9, DateUtils.utilDateToSqlDate(perceroObject.getEndTime()));
pstmt.setString(10, perceroObject.getAuxCodeEntryName());
pstmt.setString(11, perceroObject.getEStartActivityCodeName());

if (perceroObject.getAgent() == null)
{
pstmt.setString(12, null);
}
else
{
		pstmt.setString(12, perceroObject.getAgent().getID());
}


if (perceroObject.getLOBConfiguration() == null)
{
pstmt.setString(13, null);
}
else
{
		pstmt.setString(13, perceroObject.getLOBConfiguration().getID());
}


if (perceroObject.getTeamLeader() == null)
{
pstmt.setString(14, null);
}
else
{
		pstmt.setString(14, perceroObject.getTeamLeader().getID());
}


if (perceroObject.getAuxMode() == null)
{
pstmt.setString(15, null);
}
else
{
		pstmt.setString(15, perceroObject.getAuxMode().getID());
}


if (perceroObject.getEStartActivityCode() == null)
{
pstmt.setString(16, null);
}
else
{
		pstmt.setString(16, perceroObject.getEStartActivityCode().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(DurationMismatchNotification perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getExternalID());
pstmt.setString(2, perceroObject.getType());
pstmt.setString(3, perceroObject.getMessage());
pstmt.setString(4, perceroObject.getName());
pstmt.setDate(5, DateUtils.utilDateToSqlDate(perceroObject.getStartTime()));
pstmt.setString(6, perceroObject.getDate());
pstmt.setDouble(7, perceroObject.getDuration());
pstmt.setDate(8, DateUtils.utilDateToSqlDate(perceroObject.getEndTime()));
pstmt.setString(9, perceroObject.getAuxCodeEntryName());
pstmt.setString(10, perceroObject.getEStartActivityCodeName());

if (perceroObject.getAgent() == null)
{
pstmt.setString(11, null);
}
else
{
		pstmt.setString(11, perceroObject.getAgent().getID());
}


if (perceroObject.getLOBConfiguration() == null)
{
pstmt.setString(12, null);
}
else
{
		pstmt.setString(12, perceroObject.getLOBConfiguration().getID());
}


if (perceroObject.getTeamLeader() == null)
{
pstmt.setString(13, null);
}
else
{
		pstmt.setString(13, perceroObject.getTeamLeader().getID());
}


if (perceroObject.getAuxMode() == null)
{
pstmt.setString(14, null);
}
else
{
		pstmt.setString(14, perceroObject.getAuxMode().getID());
}


if (perceroObject.getEStartActivityCode() == null)
{
pstmt.setString(15, null);
}
else
{
		pstmt.setString(15, perceroObject.getEStartActivityCode().getID());
}

pstmt.setString(16, perceroObject.getID());

		
	}

	@Override
	public List<DurationMismatchNotification> findByExample(DurationMismatchNotification theQueryObject,
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

boolean useStartTime = theQueryObject.getStartTime() != null && (excludeProperties == null || !excludeProperties.contains("startTime"));

if (useStartTime)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " startTime=? ";
paramValues.add(theQueryObject.getStartTime());
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

boolean useDuration = theQueryObject.getDuration() != null && (excludeProperties == null || !excludeProperties.contains("duration"));

if (useDuration)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " duration=? ";
paramValues.add(theQueryObject.getDuration());
propertyCounter++;
}

boolean useEndTime = theQueryObject.getEndTime() != null && (excludeProperties == null || !excludeProperties.contains("endTime"));

if (useEndTime)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " endTime=? ";
paramValues.add(theQueryObject.getEndTime());
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
