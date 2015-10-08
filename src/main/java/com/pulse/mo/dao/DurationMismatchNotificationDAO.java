
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
		return "SELECT DURATION_MISMATCH_NOTIFICATION.ID FROM DURATION_MISMATCH_NOTIFICATION DURATION_MISMATCH_NOTIFICATION WHERE DURATION_MISMATCH_NOTIFICATION.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT DURATION_MISMATCH_NOTIFICATION.ID,DURATION_MISMATCH_NOTIFICATION.END_TIME,DURATION_MISMATCH_NOTIFICATION.START_TIME,DURATION_MISMATCH_NOTIFICATION.DURATION,DURATION_MISMATCH_NOTIFICATION.AUX_CODE_ENTRY_NAME,DURATION_MISMATCH_NOTIFICATION.DATE,DURATION_MISMATCH_NOTIFICATION.MESSAGE,DURATION_MISMATCH_NOTIFICATION.NAME,DURATION_MISMATCH_NOTIFICATION.TIMECARD_ACTIVITY_NAME,DURATION_MISMATCH_NOTIFICATION.TYPE,DURATION_MISMATCH_NOTIFICATION.AGENT_ID,DURATION_MISMATCH_NOTIFICATION.LOB_CONFIGURATION_ID,DURATION_MISMATCH_NOTIFICATION.CMS_AUX_MODE_ID,DURATION_MISMATCH_NOTIFICATION.TEAM_LEADER_ID,DURATION_MISMATCH_NOTIFICATION.TIMECARD_ACTIVITY_ID FROM DURATION_MISMATCH_NOTIFICATION DURATION_MISMATCH_NOTIFICATION WHERE DURATION_MISMATCH_NOTIFICATION.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT DURATION_MISMATCH_NOTIFICATION.ID FROM DURATION_MISMATCH_NOTIFICATION DURATION_MISMATCH_NOTIFICATION ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT DURATION_MISMATCH_NOTIFICATION.ID FROM DURATION_MISMATCH_NOTIFICATION DURATION_MISMATCH_NOTIFICATION ORDER BY DURATION_MISMATCH_NOTIFICATION.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT DURATION_MISMATCH_NOTIFICATION.ID,DURATION_MISMATCH_NOTIFICATION.END_TIME,DURATION_MISMATCH_NOTIFICATION.START_TIME,DURATION_MISMATCH_NOTIFICATION.DURATION,DURATION_MISMATCH_NOTIFICATION.AUX_CODE_ENTRY_NAME,DURATION_MISMATCH_NOTIFICATION.DATE,DURATION_MISMATCH_NOTIFICATION.MESSAGE,DURATION_MISMATCH_NOTIFICATION.NAME,DURATION_MISMATCH_NOTIFICATION.TIMECARD_ACTIVITY_NAME,DURATION_MISMATCH_NOTIFICATION.TYPE,DURATION_MISMATCH_NOTIFICATION.AGENT_ID,DURATION_MISMATCH_NOTIFICATION.LOB_CONFIGURATION_ID,DURATION_MISMATCH_NOTIFICATION.CMS_AUX_MODE_ID,DURATION_MISMATCH_NOTIFICATION.TEAM_LEADER_ID,DURATION_MISMATCH_NOTIFICATION.TIMECARD_ACTIVITY_ID FROM DURATION_MISMATCH_NOTIFICATION DURATION_MISMATCH_NOTIFICATION ORDER BY DURATION_MISMATCH_NOTIFICATION.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT DURATION_MISMATCH_NOTIFICATION.ID,DURATION_MISMATCH_NOTIFICATION.END_TIME,DURATION_MISMATCH_NOTIFICATION.START_TIME,DURATION_MISMATCH_NOTIFICATION.DURATION,DURATION_MISMATCH_NOTIFICATION.AUX_CODE_ENTRY_NAME,DURATION_MISMATCH_NOTIFICATION.DATE,DURATION_MISMATCH_NOTIFICATION.MESSAGE,DURATION_MISMATCH_NOTIFICATION.NAME,DURATION_MISMATCH_NOTIFICATION.TIMECARD_ACTIVITY_NAME,DURATION_MISMATCH_NOTIFICATION.TYPE,DURATION_MISMATCH_NOTIFICATION.AGENT_ID,DURATION_MISMATCH_NOTIFICATION.LOB_CONFIGURATION_ID,DURATION_MISMATCH_NOTIFICATION.CMS_AUX_MODE_ID,DURATION_MISMATCH_NOTIFICATION.TEAM_LEADER_ID,DURATION_MISMATCH_NOTIFICATION.TIMECARD_ACTIVITY_ID FROM DURATION_MISMATCH_NOTIFICATION DURATION_MISMATCH_NOTIFICATION ORDER BY DURATION_MISMATCH_NOTIFICATION.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM DURATION_MISMATCH_NOTIFICATION DURATION_MISMATCH_NOTIFICATION";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT DURATION_MISMATCH_NOTIFICATION.ID,DURATION_MISMATCH_NOTIFICATION.END_TIME,DURATION_MISMATCH_NOTIFICATION.START_TIME,DURATION_MISMATCH_NOTIFICATION.DURATION,DURATION_MISMATCH_NOTIFICATION.AUX_CODE_ENTRY_NAME,DURATION_MISMATCH_NOTIFICATION.DATE,DURATION_MISMATCH_NOTIFICATION.MESSAGE,DURATION_MISMATCH_NOTIFICATION.NAME,DURATION_MISMATCH_NOTIFICATION.TIMECARD_ACTIVITY_NAME,DURATION_MISMATCH_NOTIFICATION.TYPE,DURATION_MISMATCH_NOTIFICATION.AGENT_ID,DURATION_MISMATCH_NOTIFICATION.LOB_CONFIGURATION_ID,DURATION_MISMATCH_NOTIFICATION.CMS_AUX_MODE_ID,DURATION_MISMATCH_NOTIFICATION.TEAM_LEADER_ID,DURATION_MISMATCH_NOTIFICATION.TIMECARD_ACTIVITY_ID FROM DURATION_MISMATCH_NOTIFICATION DURATION_MISMATCH_NOTIFICATION WHERE DURATION_MISMATCH_NOTIFICATION.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT DURATION_MISMATCH_NOTIFICATION.ID FROM DURATION_MISMATCH_NOTIFICATION DURATION_MISMATCH_NOTIFICATION WHERE DURATION_MISMATCH_NOTIFICATION.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT DURATION_MISMATCH_NOTIFICATION.ID,DURATION_MISMATCH_NOTIFICATION.END_TIME,DURATION_MISMATCH_NOTIFICATION.START_TIME,DURATION_MISMATCH_NOTIFICATION.DURATION,DURATION_MISMATCH_NOTIFICATION.AUX_CODE_ENTRY_NAME,DURATION_MISMATCH_NOTIFICATION.DATE,DURATION_MISMATCH_NOTIFICATION.MESSAGE,DURATION_MISMATCH_NOTIFICATION.NAME,DURATION_MISMATCH_NOTIFICATION.TIMECARD_ACTIVITY_NAME,DURATION_MISMATCH_NOTIFICATION.TYPE,DURATION_MISMATCH_NOTIFICATION.AGENT_ID,DURATION_MISMATCH_NOTIFICATION.LOB_CONFIGURATION_ID,DURATION_MISMATCH_NOTIFICATION.CMS_AUX_MODE_ID,DURATION_MISMATCH_NOTIFICATION.TEAM_LEADER_ID,DURATION_MISMATCH_NOTIFICATION.TIMECARD_ACTIVITY_ID FROM DURATION_MISMATCH_NOTIFICATION DURATION_MISMATCH_NOTIFICATION WHERE DURATION_MISMATCH_NOTIFICATION." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT DURATION_MISMATCH_NOTIFICATION.ID FROM DURATION_MISMATCH_NOTIFICATION DURATION_MISMATCH_NOTIFICATION WHERE DURATION_MISMATCH_NOTIFICATION." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT DURATION_MISMATCH_NOTIFICATION.ID FROM DURATION_MISMATCH_NOTIFICATION DURATION_MISMATCH_NOTIFICATION ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT DURATION_MISMATCH_NOTIFICATION.ID,DURATION_MISMATCH_NOTIFICATION.END_TIME,DURATION_MISMATCH_NOTIFICATION.START_TIME,DURATION_MISMATCH_NOTIFICATION.DURATION,DURATION_MISMATCH_NOTIFICATION.AUX_CODE_ENTRY_NAME,DURATION_MISMATCH_NOTIFICATION.DATE,DURATION_MISMATCH_NOTIFICATION.MESSAGE,DURATION_MISMATCH_NOTIFICATION.NAME,DURATION_MISMATCH_NOTIFICATION.TIMECARD_ACTIVITY_NAME,DURATION_MISMATCH_NOTIFICATION.TYPE,DURATION_MISMATCH_NOTIFICATION.AGENT_ID,DURATION_MISMATCH_NOTIFICATION.LOB_CONFIGURATION_ID,DURATION_MISMATCH_NOTIFICATION.CMS_AUX_MODE_ID,DURATION_MISMATCH_NOTIFICATION.TEAM_LEADER_ID,DURATION_MISMATCH_NOTIFICATION.TIMECARD_ACTIVITY_ID FROM DURATION_MISMATCH_NOTIFICATION DURATION_MISMATCH_NOTIFICATION ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO DURATION_MISMATCH_NOTIFICATION (ID,END_TIME,START_TIME,DURATION,AUX_CODE_ENTRY_NAME,DATE,MESSAGE,NAME,TIMECARD_ACTIVITY_NAME,TYPE,AGENT_ID,LOB_CONFIGURATION_ID,CMS_AUX_MODE_ID,TEAM_LEADER_ID,TIMECARD_ACTIVITY_ID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE DURATION_MISMATCH_NOTIFICATION SET END_TIME=?,START_TIME=?,DURATION=?,AUX_CODE_ENTRY_NAME=?,DATE=?,MESSAGE=?,NAME=?,TIMECARD_ACTIVITY_NAME=?,TYPE=?,AGENT_ID,LOB_CONFIGURATION_ID,CMS_AUX_MODE_ID,TEAM_LEADER_ID,TIMECARD_ACTIVITY_ID WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM DURATION_MISMATCH_NOTIFICATION WHERE ID=?";
	}
	
	@Override
	protected DurationMismatchNotification extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	DurationMismatchNotification nextResult = new DurationMismatchNotification();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setEndTime(rs.getDate("END_TIME"));

nextResult.setStartTime(rs.getDate("START_TIME"));

nextResult.setDuration(rs.getDouble("DURATION"));

nextResult.setAuxCodeEntryName(rs.getString("AUX_CODE_ENTRY_NAME"));

nextResult.setDate(rs.getString("DATE"));

nextResult.setMessage(rs.getString("MESSAGE"));

nextResult.setName(rs.getString("NAME"));

nextResult.setTimecardActivityName(rs.getString("TIMECARD_ACTIVITY_NAME"));

nextResult.setType(rs.getString("TYPE"));

Agent agent = new Agent();
agent.setID(rs.getString("AGENT_ID"));
nextResult.setAgent(agent);

LOBConfiguration lobconfiguration = new LOBConfiguration();
lobconfiguration.setID(rs.getString("LOB_CONFIGURATION_ID"));
nextResult.setLOBConfiguration(lobconfiguration);

CMSAuxMode cmsauxmode = new CMSAuxMode();
cmsauxmode.setID(rs.getString("CMS_AUX_MODE_ID"));
nextResult.setCMSAuxMode(cmsauxmode);

TeamLeader teamleader = new TeamLeader();
teamleader.setID(rs.getString("TEAM_LEADER_ID"));
nextResult.setTeamLeader(teamleader);

TimecardActivity timecardactivity = new TimecardActivity();
timecardactivity.setID(rs.getString("TIMECARD_ACTIVITY_ID"));
nextResult.setTimecardActivity(timecardactivity);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(DurationMismatchNotification perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setDate(2, DateUtils.utilDateToSqlDate(perceroObject.getEndTime()));
pstmt.setDate(3, DateUtils.utilDateToSqlDate(perceroObject.getStartTime()));
pstmt.setDouble(4, perceroObject.getDuration());
pstmt.setString(5, perceroObject.getAuxCodeEntryName());
pstmt.setString(6, perceroObject.getDate());
pstmt.setString(7, perceroObject.getMessage());
pstmt.setString(8, perceroObject.getName());
pstmt.setString(9, perceroObject.getTimecardActivityName());
pstmt.setString(10, perceroObject.getType());

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


if (perceroObject.getCMSAuxMode() == null)
{
pstmt.setString(13, null);
}
else
{
		pstmt.setString(13, perceroObject.getCMSAuxMode().getID());
}


if (perceroObject.getTeamLeader() == null)
{
pstmt.setString(14, null);
}
else
{
		pstmt.setString(14, perceroObject.getTeamLeader().getID());
}


if (perceroObject.getTimecardActivity() == null)
{
pstmt.setString(15, null);
}
else
{
		pstmt.setString(15, perceroObject.getTimecardActivity().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(DurationMismatchNotification perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setDate(1, DateUtils.utilDateToSqlDate(perceroObject.getEndTime()));
pstmt.setDate(2, DateUtils.utilDateToSqlDate(perceroObject.getStartTime()));
pstmt.setDouble(3, perceroObject.getDuration());
pstmt.setString(4, perceroObject.getAuxCodeEntryName());
pstmt.setString(5, perceroObject.getDate());
pstmt.setString(6, perceroObject.getMessage());
pstmt.setString(7, perceroObject.getName());
pstmt.setString(8, perceroObject.getTimecardActivityName());
pstmt.setString(9, perceroObject.getType());

if (perceroObject.getAgent() == null)
{
pstmt.setString(10, null);
}
else
{
		pstmt.setString(10, perceroObject.getAgent().getID());
}


if (perceroObject.getLOBConfiguration() == null)
{
pstmt.setString(11, null);
}
else
{
		pstmt.setString(11, perceroObject.getLOBConfiguration().getID());
}


if (perceroObject.getCMSAuxMode() == null)
{
pstmt.setString(12, null);
}
else
{
		pstmt.setString(12, perceroObject.getCMSAuxMode().getID());
}


if (perceroObject.getTeamLeader() == null)
{
pstmt.setString(13, null);
}
else
{
		pstmt.setString(13, perceroObject.getTeamLeader().getID());
}


if (perceroObject.getTimecardActivity() == null)
{
pstmt.setString(14, null);
}
else
{
		pstmt.setString(14, perceroObject.getTimecardActivity().getID());
}

pstmt.setString(15, perceroObject.getID());

		
	}

	@Override
	public List<DurationMismatchNotification> findByExample(DurationMismatchNotification theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useEndTime = theQueryObject.getEndTime() != null && (excludeProperties == null || !excludeProperties.contains("endTime"));

if (useEndTime)
{
sql += " WHERE ";
sql += " END_TIME=? ";
paramValues.add(theQueryObject.getEndTime());
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

boolean useTimecardActivityName = StringUtils.hasText(theQueryObject.getTimecardActivityName()) && (excludeProperties == null || !excludeProperties.contains("timecardActivityName"));

if (useTimecardActivityName)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
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

boolean useTimecardActivityID = theQueryObject.getTimecardActivity() != null && (excludeProperties == null || !excludeProperties.contains("timecardActivity"));

if (useTimecardActivityID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " TIMECARD_ACTIVITY_ID=? ";
paramValues.add(theQueryObject.getTimecardActivity().getID());
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
