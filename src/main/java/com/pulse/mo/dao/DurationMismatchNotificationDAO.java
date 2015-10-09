

package com.pulse.mo.dao;

import com.percero.agents.sync.dao.DAORegistry;
import com.percero.agents.sync.dao.IDataAccessObject;
import com.percero.agents.sync.exceptions.SyncException;
import com.percero.util.DateUtils;
import com.pulse.mo.*;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
		return "SELECT DURATION_MISMATCH_NOTIF.ID FROM DURATION_MISMATCH_NOTIF DURATION_MISMATCH_NOTIF WHERE DURATION_MISMATCH_NOTIF.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT DURATION_MISMATCH_NOTIF.ID,DURATION_MISMATCH_NOTIF.TIMECARD_ACTIVITY_NAME,DURATION_MISMATCH_NOTIF.TYPE,DURATION_MISMATCH_NOTIF.AUX_CODE_ENTRY_NAME,DURATION_MISMATCH_NOTIF.DATE,DURATION_MISMATCH_NOTIF.DURATION,DURATION_MISMATCH_NOTIF.END_TIME,DURATION_MISMATCH_NOTIF.MESSAGE,DURATION_MISMATCH_NOTIF.NAME,DURATION_MISMATCH_NOTIF.START_TIME,DURATION_MISMATCH_NOTIF.LOB_CONFIGURATION_ID,DURATION_MISMATCH_NOTIF.AGENT_ID,DURATION_MISMATCH_NOTIF.TEAM_LEADER_ID,DURATION_MISMATCH_NOTIF.CMS_AUX_MODE_ID FROM DURATION_MISMATCH_NOTIF DURATION_MISMATCH_NOTIF WHERE DURATION_MISMATCH_NOTIF.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT DURATION_MISMATCH_NOTIF.ID FROM DURATION_MISMATCH_NOTIF DURATION_MISMATCH_NOTIF ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT DURATION_MISMATCH_NOTIF.ID FROM DURATION_MISMATCH_NOTIF DURATION_MISMATCH_NOTIF ORDER BY DURATION_MISMATCH_NOTIF.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT DURATION_MISMATCH_NOTIF.ID,DURATION_MISMATCH_NOTIF.TIMECARD_ACTIVITY_NAME,DURATION_MISMATCH_NOTIF.TYPE,DURATION_MISMATCH_NOTIF.AUX_CODE_ENTRY_NAME,DURATION_MISMATCH_NOTIF.DATE,DURATION_MISMATCH_NOTIF.DURATION,DURATION_MISMATCH_NOTIF.END_TIME,DURATION_MISMATCH_NOTIF.MESSAGE,DURATION_MISMATCH_NOTIF.NAME,DURATION_MISMATCH_NOTIF.START_TIME,DURATION_MISMATCH_NOTIF.LOB_CONFIGURATION_ID,DURATION_MISMATCH_NOTIF.AGENT_ID,DURATION_MISMATCH_NOTIF.TEAM_LEADER_ID,DURATION_MISMATCH_NOTIF.CMS_AUX_MODE_ID FROM DURATION_MISMATCH_NOTIF DURATION_MISMATCH_NOTIF ORDER BY DURATION_MISMATCH_NOTIF.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT DURATION_MISMATCH_NOTIF.ID,DURATION_MISMATCH_NOTIF.TIMECARD_ACTIVITY_NAME,DURATION_MISMATCH_NOTIF.TYPE,DURATION_MISMATCH_NOTIF.AUX_CODE_ENTRY_NAME,DURATION_MISMATCH_NOTIF.DATE,DURATION_MISMATCH_NOTIF.DURATION,DURATION_MISMATCH_NOTIF.END_TIME,DURATION_MISMATCH_NOTIF.MESSAGE,DURATION_MISMATCH_NOTIF.NAME,DURATION_MISMATCH_NOTIF.START_TIME,DURATION_MISMATCH_NOTIF.LOB_CONFIGURATION_ID,DURATION_MISMATCH_NOTIF.AGENT_ID,DURATION_MISMATCH_NOTIF.TEAM_LEADER_ID,DURATION_MISMATCH_NOTIF.CMS_AUX_MODE_ID FROM DURATION_MISMATCH_NOTIF DURATION_MISMATCH_NOTIF ORDER BY DURATION_MISMATCH_NOTIF.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM DURATION_MISMATCH_NOTIF DURATION_MISMATCH_NOTIF";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT DURATION_MISMATCH_NOTIF.ID,DURATION_MISMATCH_NOTIF.TIMECARD_ACTIVITY_NAME,DURATION_MISMATCH_NOTIF.TYPE,DURATION_MISMATCH_NOTIF.AUX_CODE_ENTRY_NAME,DURATION_MISMATCH_NOTIF.DATE,DURATION_MISMATCH_NOTIF.DURATION,DURATION_MISMATCH_NOTIF.END_TIME,DURATION_MISMATCH_NOTIF.MESSAGE,DURATION_MISMATCH_NOTIF.NAME,DURATION_MISMATCH_NOTIF.START_TIME,DURATION_MISMATCH_NOTIF.LOB_CONFIGURATION_ID,DURATION_MISMATCH_NOTIF.AGENT_ID,DURATION_MISMATCH_NOTIF.TEAM_LEADER_ID,DURATION_MISMATCH_NOTIF.CMS_AUX_MODE_ID FROM DURATION_MISMATCH_NOTIF DURATION_MISMATCH_NOTIF WHERE DURATION_MISMATCH_NOTIF.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT DURATION_MISMATCH_NOTIF.ID FROM DURATION_MISMATCH_NOTIF DURATION_MISMATCH_NOTIF WHERE DURATION_MISMATCH_NOTIF.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT DURATION_MISMATCH_NOTIF.ID,DURATION_MISMATCH_NOTIF.TIMECARD_ACTIVITY_NAME,DURATION_MISMATCH_NOTIF.TYPE,DURATION_MISMATCH_NOTIF.AUX_CODE_ENTRY_NAME,DURATION_MISMATCH_NOTIF.DATE,DURATION_MISMATCH_NOTIF.DURATION,DURATION_MISMATCH_NOTIF.END_TIME,DURATION_MISMATCH_NOTIF.MESSAGE,DURATION_MISMATCH_NOTIF.NAME,DURATION_MISMATCH_NOTIF.START_TIME,DURATION_MISMATCH_NOTIF.LOB_CONFIGURATION_ID,DURATION_MISMATCH_NOTIF.AGENT_ID,DURATION_MISMATCH_NOTIF.TEAM_LEADER_ID,DURATION_MISMATCH_NOTIF.CMS_AUX_MODE_ID FROM DURATION_MISMATCH_NOTIF DURATION_MISMATCH_NOTIF WHERE DURATION_MISMATCH_NOTIF." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT DURATION_MISMATCH_NOTIF.ID FROM DURATION_MISMATCH_NOTIF DURATION_MISMATCH_NOTIF WHERE DURATION_MISMATCH_NOTIF." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT DURATION_MISMATCH_NOTIF.ID FROM DURATION_MISMATCH_NOTIF DURATION_MISMATCH_NOTIF ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT DURATION_MISMATCH_NOTIF.ID,DURATION_MISMATCH_NOTIF.TIMECARD_ACTIVITY_NAME,DURATION_MISMATCH_NOTIF.TYPE,DURATION_MISMATCH_NOTIF.AUX_CODE_ENTRY_NAME,DURATION_MISMATCH_NOTIF.DATE,DURATION_MISMATCH_NOTIF.DURATION,DURATION_MISMATCH_NOTIF.END_TIME,DURATION_MISMATCH_NOTIF.MESSAGE,DURATION_MISMATCH_NOTIF.NAME,DURATION_MISMATCH_NOTIF.START_TIME,DURATION_MISMATCH_NOTIF.LOB_CONFIGURATION_ID,DURATION_MISMATCH_NOTIF.AGENT_ID,DURATION_MISMATCH_NOTIF.TEAM_LEADER_ID,DURATION_MISMATCH_NOTIF.CMS_AUX_MODE_ID FROM DURATION_MISMATCH_NOTIF DURATION_MISMATCH_NOTIF ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO DURATION_MISMATCH_NOTIF (ID,TIMECARD_ACTIVITY_NAME,TYPE,AUX_CODE_ENTRY_NAME,DATE,DURATION,END_TIME,MESSAGE,NAME,START_TIME,LOB_CONFIGURATION_ID,AGENT_ID,TEAM_LEADER_ID,CMS_AUX_MODE_ID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE DURATION_MISMATCH_NOTIF SET TIMECARD_ACTIVITY_NAME=?,TYPE=?,AUX_CODE_ENTRY_NAME=?,DATE=?,DURATION=?,END_TIME=?,MESSAGE=?,NAME=?,START_TIME=?,LOB_CONFIGURATION_ID=?,AGENT_ID=?,TEAM_LEADER_ID=?,CMS_AUX_MODE_ID=? WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM DURATION_MISMATCH_NOTIF WHERE ID=?";
	}
	
	@Override
	protected DurationMismatchNotification extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	DurationMismatchNotification nextResult = new DurationMismatchNotification();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setTimecardActivityName(rs.getString("TIMECARD_ACTIVITY_NAME"));

nextResult.setType(rs.getString("TYPE"));

nextResult.setAuxCodeEntryName(rs.getString("AUX_CODE_ENTRY_NAME"));

nextResult.setDate(rs.getString("DATE"));

nextResult.setDuration(rs.getDouble("DURATION"));

nextResult.setEndTime(rs.getDate("END_TIME"));

nextResult.setMessage(rs.getString("MESSAGE"));

nextResult.setName(rs.getString("NAME"));

nextResult.setStartTime(rs.getDate("START_TIME"));

LOBConfiguration lobconfiguration = new LOBConfiguration();
lobconfiguration.setID(rs.getString("LOB_CONFIGURATION_ID"));
nextResult.setLOBConfiguration(lobconfiguration);

Agent agent = new Agent();
agent.setID(rs.getString("AGENT_ID"));
nextResult.setAgent(agent);

TeamLeader teamleader = new TeamLeader();
teamleader.setID(rs.getString("TEAM_LEADER_ID"));
nextResult.setTeamLeader(teamleader);

CMSAuxMode cmsauxmode = new CMSAuxMode();
cmsauxmode.setID(rs.getString("CMS_AUX_MODE_ID"));
nextResult.setCMSAuxMode(cmsauxmode);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(DurationMismatchNotification perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getTimecardActivityName());
pstmt.setString(3, perceroObject.getType());
pstmt.setString(4, perceroObject.getAuxCodeEntryName());
pstmt.setString(5, perceroObject.getDate());
pstmt.setDouble(6, perceroObject.getDuration());
pstmt.setDate(7, DateUtils.utilDateToSqlDate(perceroObject.getEndTime()));
pstmt.setString(8, perceroObject.getMessage());
pstmt.setString(9, perceroObject.getName());
pstmt.setDate(10, DateUtils.utilDateToSqlDate(perceroObject.getStartTime()));

if (perceroObject.getLOBConfiguration() == null)
{
pstmt.setString(11, null);
}
else
{
		pstmt.setString(11, perceroObject.getLOBConfiguration().getID());
}


if (perceroObject.getAgent() == null)
{
pstmt.setString(12, null);
}
else
{
		pstmt.setString(12, perceroObject.getAgent().getID());
}


if (perceroObject.getTeamLeader() == null)
{
pstmt.setString(13, null);
}
else
{
		pstmt.setString(13, perceroObject.getTeamLeader().getID());
}


if (perceroObject.getCMSAuxMode() == null)
{
pstmt.setString(14, null);
}
else
{
		pstmt.setString(14, perceroObject.getCMSAuxMode().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(DurationMismatchNotification perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getTimecardActivityName());
pstmt.setString(2, perceroObject.getType());
pstmt.setString(3, perceroObject.getAuxCodeEntryName());
pstmt.setString(4, perceroObject.getDate());
pstmt.setDouble(5, perceroObject.getDuration());
pstmt.setDate(6, DateUtils.utilDateToSqlDate(perceroObject.getEndTime()));
pstmt.setString(7, perceroObject.getMessage());
pstmt.setString(8, perceroObject.getName());
pstmt.setDate(9, DateUtils.utilDateToSqlDate(perceroObject.getStartTime()));

if (perceroObject.getLOBConfiguration() == null)
{
pstmt.setString(10, null);
}
else
{
		pstmt.setString(10, perceroObject.getLOBConfiguration().getID());
}


if (perceroObject.getAgent() == null)
{
pstmt.setString(11, null);
}
else
{
		pstmt.setString(11, perceroObject.getAgent().getID());
}


if (perceroObject.getTeamLeader() == null)
{
pstmt.setString(12, null);
}
else
{
		pstmt.setString(12, perceroObject.getTeamLeader().getID());
}


if (perceroObject.getCMSAuxMode() == null)
{
pstmt.setString(13, null);
}
else
{
		pstmt.setString(13, perceroObject.getCMSAuxMode().getID());
}

pstmt.setString(14, perceroObject.getID());

		
	}

	@Override
	public List<DurationMismatchNotification> findByExample(DurationMismatchNotification theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useTimecardActivityName = StringUtils.hasText(theQueryObject.getTimecardActivityName()) && (excludeProperties == null || !excludeProperties.contains("timecardActivityName"));

if (useTimecardActivityName)
{
sql += " WHERE ";
sql += " TIMECARD_ACTIVITY_NAME=? ";
paramValues.add(theQueryObject.getTimecardActivityName());
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
sql += " AUX_CODE_ENTRY_NAME=? ";
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
sql += " DATE=? ";
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
sql += " DURATION=? ";
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
sql += " END_TIME=? ";
paramValues.add(theQueryObject.getEndTime());
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
sql += " START_TIME=? ";
paramValues.add(theQueryObject.getStartTime());
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

boolean useCMSAuxModeID = theQueryObject.getCMSAuxMode() != null && (excludeProperties == null || !excludeProperties.contains("cMSAuxMode"));

if (useCMSAuxModeID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " CMS_AUX_MODE_ID=? ";
paramValues.add(theQueryObject.getCMSAuxMode().getID());
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

