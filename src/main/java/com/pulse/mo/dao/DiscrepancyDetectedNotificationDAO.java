
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
import com.pulse.mo.CMSAuxMode;
import com.pulse.mo.TimecardActivity;

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
		return "SELECT DISCREPANCY_DETECTED_NOTIFICATION.ID FROM DISCREPANCY_DETECTED_NOTIFICATION DISCREPANCY_DETECTED_NOTIFICATION WHERE DISCREPANCY_DETECTED_NOTIFICATION.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT DISCREPANCY_DETECTED_NOTIFICATION.ID,DISCREPANCY_DETECTED_NOTIFICATION.TIMECARD_ACTIVITY_NAME,DISCREPANCY_DETECTED_NOTIFICATION.TYPE,DISCREPANCY_DETECTED_NOTIFICATION.AUX_CODE_ENTRY_NAME,DISCREPANCY_DETECTED_NOTIFICATION.DATE,DISCREPANCY_DETECTED_NOTIFICATION.MESSAGE,DISCREPANCY_DETECTED_NOTIFICATION.NAME,DISCREPANCY_DETECTED_NOTIFICATION.AGENT_ID,DISCREPANCY_DETECTED_NOTIFICATION.LOB_CONFIGURATION_ID,DISCREPANCY_DETECTED_NOTIFICATION.CMS_AUX_MODE_ID,DISCREPANCY_DETECTED_NOTIFICATION.TEAM_LEADER_ID FROM DISCREPANCY_DETECTED_NOTIFICATION DISCREPANCY_DETECTED_NOTIFICATION WHERE DISCREPANCY_DETECTED_NOTIFICATION.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT DISCREPANCY_DETECTED_NOTIFICATION.ID FROM DISCREPANCY_DETECTED_NOTIFICATION DISCREPANCY_DETECTED_NOTIFICATION ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT DISCREPANCY_DETECTED_NOTIFICATION.ID FROM DISCREPANCY_DETECTED_NOTIFICATION DISCREPANCY_DETECTED_NOTIFICATION ORDER BY DISCREPANCY_DETECTED_NOTIFICATION.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT DISCREPANCY_DETECTED_NOTIFICATION.ID,DISCREPANCY_DETECTED_NOTIFICATION.TIMECARD_ACTIVITY_NAME,DISCREPANCY_DETECTED_NOTIFICATION.TYPE,DISCREPANCY_DETECTED_NOTIFICATION.AUX_CODE_ENTRY_NAME,DISCREPANCY_DETECTED_NOTIFICATION.DATE,DISCREPANCY_DETECTED_NOTIFICATION.MESSAGE,DISCREPANCY_DETECTED_NOTIFICATION.NAME,DISCREPANCY_DETECTED_NOTIFICATION.AGENT_ID,DISCREPANCY_DETECTED_NOTIFICATION.LOB_CONFIGURATION_ID,DISCREPANCY_DETECTED_NOTIFICATION.CMS_AUX_MODE_ID,DISCREPANCY_DETECTED_NOTIFICATION.TEAM_LEADER_ID FROM DISCREPANCY_DETECTED_NOTIFICATION DISCREPANCY_DETECTED_NOTIFICATION ORDER BY DISCREPANCY_DETECTED_NOTIFICATION.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT DISCREPANCY_DETECTED_NOTIFICATION.ID,DISCREPANCY_DETECTED_NOTIFICATION.TIMECARD_ACTIVITY_NAME,DISCREPANCY_DETECTED_NOTIFICATION.TYPE,DISCREPANCY_DETECTED_NOTIFICATION.AUX_CODE_ENTRY_NAME,DISCREPANCY_DETECTED_NOTIFICATION.DATE,DISCREPANCY_DETECTED_NOTIFICATION.MESSAGE,DISCREPANCY_DETECTED_NOTIFICATION.NAME,DISCREPANCY_DETECTED_NOTIFICATION.AGENT_ID,DISCREPANCY_DETECTED_NOTIFICATION.LOB_CONFIGURATION_ID,DISCREPANCY_DETECTED_NOTIFICATION.CMS_AUX_MODE_ID,DISCREPANCY_DETECTED_NOTIFICATION.TEAM_LEADER_ID FROM DISCREPANCY_DETECTED_NOTIFICATION DISCREPANCY_DETECTED_NOTIFICATION ORDER BY DISCREPANCY_DETECTED_NOTIFICATION.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM DISCREPANCY_DETECTED_NOTIFICATION DISCREPANCY_DETECTED_NOTIFICATION";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT DISCREPANCY_DETECTED_NOTIFICATION.ID,DISCREPANCY_DETECTED_NOTIFICATION.TIMECARD_ACTIVITY_NAME,DISCREPANCY_DETECTED_NOTIFICATION.TYPE,DISCREPANCY_DETECTED_NOTIFICATION.AUX_CODE_ENTRY_NAME,DISCREPANCY_DETECTED_NOTIFICATION.DATE,DISCREPANCY_DETECTED_NOTIFICATION.MESSAGE,DISCREPANCY_DETECTED_NOTIFICATION.NAME,DISCREPANCY_DETECTED_NOTIFICATION.AGENT_ID,DISCREPANCY_DETECTED_NOTIFICATION.LOB_CONFIGURATION_ID,DISCREPANCY_DETECTED_NOTIFICATION.CMS_AUX_MODE_ID,DISCREPANCY_DETECTED_NOTIFICATION.TEAM_LEADER_ID FROM DISCREPANCY_DETECTED_NOTIFICATION DISCREPANCY_DETECTED_NOTIFICATION WHERE DISCREPANCY_DETECTED_NOTIFICATION.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT DISCREPANCY_DETECTED_NOTIFICATION.ID FROM DISCREPANCY_DETECTED_NOTIFICATION DISCREPANCY_DETECTED_NOTIFICATION WHERE DISCREPANCY_DETECTED_NOTIFICATION.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT DISCREPANCY_DETECTED_NOTIFICATION.ID,DISCREPANCY_DETECTED_NOTIFICATION.TIMECARD_ACTIVITY_NAME,DISCREPANCY_DETECTED_NOTIFICATION.TYPE,DISCREPANCY_DETECTED_NOTIFICATION.AUX_CODE_ENTRY_NAME,DISCREPANCY_DETECTED_NOTIFICATION.DATE,DISCREPANCY_DETECTED_NOTIFICATION.MESSAGE,DISCREPANCY_DETECTED_NOTIFICATION.NAME,DISCREPANCY_DETECTED_NOTIFICATION.AGENT_ID,DISCREPANCY_DETECTED_NOTIFICATION.LOB_CONFIGURATION_ID,DISCREPANCY_DETECTED_NOTIFICATION.CMS_AUX_MODE_ID,DISCREPANCY_DETECTED_NOTIFICATION.TEAM_LEADER_ID FROM DISCREPANCY_DETECTED_NOTIFICATION DISCREPANCY_DETECTED_NOTIFICATION WHERE DISCREPANCY_DETECTED_NOTIFICATION." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT DISCREPANCY_DETECTED_NOTIFICATION.ID FROM DISCREPANCY_DETECTED_NOTIFICATION DISCREPANCY_DETECTED_NOTIFICATION WHERE DISCREPANCY_DETECTED_NOTIFICATION." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT DISCREPANCY_DETECTED_NOTIFICATION.ID FROM DISCREPANCY_DETECTED_NOTIFICATION DISCREPANCY_DETECTED_NOTIFICATION ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT DISCREPANCY_DETECTED_NOTIFICATION.ID,DISCREPANCY_DETECTED_NOTIFICATION.TIMECARD_ACTIVITY_NAME,DISCREPANCY_DETECTED_NOTIFICATION.TYPE,DISCREPANCY_DETECTED_NOTIFICATION.AUX_CODE_ENTRY_NAME,DISCREPANCY_DETECTED_NOTIFICATION.DATE,DISCREPANCY_DETECTED_NOTIFICATION.MESSAGE,DISCREPANCY_DETECTED_NOTIFICATION.NAME,DISCREPANCY_DETECTED_NOTIFICATION.AGENT_ID,DISCREPANCY_DETECTED_NOTIFICATION.LOB_CONFIGURATION_ID,DISCREPANCY_DETECTED_NOTIFICATION.CMS_AUX_MODE_ID,DISCREPANCY_DETECTED_NOTIFICATION.TEAM_LEADER_ID FROM DISCREPANCY_DETECTED_NOTIFICATION DISCREPANCY_DETECTED_NOTIFICATION ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO DISCREPANCY_DETECTED_NOTIFICATION (ID,TIMECARD_ACTIVITY_NAME,TYPE,AUX_CODE_ENTRY_NAME,DATE,MESSAGE,NAME,AGENT_ID,LOB_CONFIGURATION_ID,CMS_AUX_MODE_ID,TEAM_LEADER_ID) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE DISCREPANCY_DETECTED_NOTIFICATION SET TIMECARD_ACTIVITY_NAME=?,TYPE=?,AUX_CODE_ENTRY_NAME=?,DATE=?,MESSAGE=?,NAME=?,AGENT_ID=?,LOB_CONFIGURATION_ID=?,CMS_AUX_MODE_ID=?,TEAM_LEADER_ID=? WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM DISCREPANCY_DETECTED_NOTIFICATION WHERE ID=?";
	}
	
	@Override
	protected DiscrepancyDetectedNotification extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	DiscrepancyDetectedNotification nextResult = new DiscrepancyDetectedNotification();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setTimecardActivityName(rs.getString("TIMECARD_ACTIVITY_NAME"));

nextResult.setType(rs.getString("TYPE"));

nextResult.setAuxCodeEntryName(rs.getString("AUX_CODE_ENTRY_NAME"));

nextResult.setDate(rs.getString("DATE"));

nextResult.setMessage(rs.getString("MESSAGE"));

nextResult.setName(rs.getString("NAME"));

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


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(DiscrepancyDetectedNotification perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getTimecardActivityName());
pstmt.setString(3, perceroObject.getType());
pstmt.setString(4, perceroObject.getAuxCodeEntryName());
pstmt.setString(5, perceroObject.getDate());
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


if (perceroObject.getCMSAuxMode() == null)
{
pstmt.setString(10, null);
}
else
{
		pstmt.setString(10, perceroObject.getCMSAuxMode().getID());
}


if (perceroObject.getTeamLeader() == null)
{
pstmt.setString(11, null);
}
else
{
		pstmt.setString(11, perceroObject.getTeamLeader().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(DiscrepancyDetectedNotification perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getTimecardActivityName());
pstmt.setString(2, perceroObject.getType());
pstmt.setString(3, perceroObject.getAuxCodeEntryName());
pstmt.setString(4, perceroObject.getDate());
pstmt.setString(5, perceroObject.getMessage());
pstmt.setString(6, perceroObject.getName());

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


if (perceroObject.getCMSAuxMode() == null)
{
pstmt.setString(9, null);
}
else
{
		pstmt.setString(9, perceroObject.getCMSAuxMode().getID());
}


if (perceroObject.getTeamLeader() == null)
{
pstmt.setString(10, null);
}
else
{
		pstmt.setString(10, perceroObject.getTeamLeader().getID());
}

pstmt.setString(11, perceroObject.getID());

		
	}

	@Override
	public List<DiscrepancyDetectedNotification> findByExample(DiscrepancyDetectedNotification theQueryObject,
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
