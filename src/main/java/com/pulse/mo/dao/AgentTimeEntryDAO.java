
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
import com.pulse.mo.AgentTimeEntry;
import com.pulse.mo.AgentTime;
import com.pulse.mo.EStartActivityCode;
import com.pulse.mo.CVGProject;

*/

@Component
public class AgentTimeEntryDAO extends SqlDataAccessObject<AgentTimeEntry> implements IDataAccessObject<AgentTimeEntry> {

	static final Logger log = Logger.getLogger(AgentTimeEntryDAO.class);

	
	public AgentTimeEntryDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(AgentTimeEntry.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	@Override
	protected String getConnectionFactoryName() {
		return AgentTimeEntryDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT agenttimeentry.ID FROM AgentTimeEntry agenttimeentry WHERE agenttimeentry.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT agenttimeentry.ID,agenttimeentry.externalID,agenttimeentry.fromTime,agenttimeentry.notificationDetected,agenttimeentry.notificationResolved,agenttimeentry.toTime,agenttimeentry.actionCode,agenttimeentry.actionName,agenttimeentry.activityName,agenttimeentry.cVGProjectName,agenttimeentry.duration,agenttimeentry.eStartActivityCode_ID,agenttimeentry.agentTime_ID,agenttimeentry.cVGProject_ID FROM AgentTimeEntry agenttimeentry WHERE agenttimeentry.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT agenttimeentry.ID FROM AgentTimeEntry agenttimeentry ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT agenttimeentry.ID FROM AgentTimeEntry agenttimeentry ORDER BY agenttimeentry.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT agenttimeentry.ID,agenttimeentry.externalID,agenttimeentry.fromTime,agenttimeentry.notificationDetected,agenttimeentry.notificationResolved,agenttimeentry.toTime,agenttimeentry.actionCode,agenttimeentry.actionName,agenttimeentry.activityName,agenttimeentry.cVGProjectName,agenttimeentry.duration,agenttimeentry.eStartActivityCode_ID,agenttimeentry.agentTime_ID,agenttimeentry.cVGProject_ID FROM AgentTimeEntry agenttimeentry ORDER BY agenttimeentry.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT agenttimeentry.ID,agenttimeentry.externalID,agenttimeentry.fromTime,agenttimeentry.notificationDetected,agenttimeentry.notificationResolved,agenttimeentry.toTime,agenttimeentry.actionCode,agenttimeentry.actionName,agenttimeentry.activityName,agenttimeentry.cVGProjectName,agenttimeentry.duration,agenttimeentry.eStartActivityCode_ID,agenttimeentry.agentTime_ID,agenttimeentry.cVGProject_ID FROM AgentTimeEntry agenttimeentry ORDER BY agenttimeentry.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM AgentTimeEntry agenttimeentry";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT agenttimeentry.ID,agenttimeentry.externalID,agenttimeentry.fromTime,agenttimeentry.notificationDetected,agenttimeentry.notificationResolved,agenttimeentry.toTime,agenttimeentry.actionCode,agenttimeentry.actionName,agenttimeentry.activityName,agenttimeentry.cVGProjectName,agenttimeentry.duration,agenttimeentry.eStartActivityCode_ID,agenttimeentry.agentTime_ID,agenttimeentry.cVGProject_ID FROM AgentTimeEntry agenttimeentry WHERE agenttimeentry.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT agenttimeentry.ID FROM AgentTimeEntry agenttimeentry WHERE agenttimeentry.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT agenttimeentry.ID,agenttimeentry.externalID,agenttimeentry.fromTime,agenttimeentry.notificationDetected,agenttimeentry.notificationResolved,agenttimeentry.toTime,agenttimeentry.actionCode,agenttimeentry.actionName,agenttimeentry.activityName,agenttimeentry.cVGProjectName,agenttimeentry.duration,agenttimeentry.eStartActivityCode_ID,agenttimeentry.agentTime_ID,agenttimeentry.cVGProject_ID FROM AgentTimeEntry agenttimeentry WHERE agenttimeentry." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT agenttimeentry.ID FROM AgentTimeEntry agenttimeentry WHERE agenttimeentry." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT agenttimeentry.ID FROM AgentTimeEntry agenttimeentry ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT agenttimeentry.ID,agenttimeentry.externalID,agenttimeentry.fromTime,agenttimeentry.notificationDetected,agenttimeentry.notificationResolved,agenttimeentry.toTime,agenttimeentry.actionCode,agenttimeentry.actionName,agenttimeentry.activityName,agenttimeentry.cVGProjectName,agenttimeentry.duration,agenttimeentry.eStartActivityCode_ID,agenttimeentry.agentTime_ID,agenttimeentry.cVGProject_ID FROM AgentTimeEntry agenttimeentry ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO AgentTimeEntry (ID,externalID,fromTime,notificationDetected,notificationResolved,toTime,actionCode,actionName,activityName,cVGProjectName,duration,eStartActivityCode_ID,agentTime_ID,cVGProject_ID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE AgentTimeEntry SET externalID=?,fromTime=?,notificationDetected=?,notificationResolved=?,toTime=?,actionCode=?,actionName=?,activityName=?,cVGProjectName=?,duration=?,eStartActivityCode_ID=?,agentTime_ID=?,cVGProject_ID=? WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM AgentTimeEntry WHERE ID=?";
	}
	
	@Override
	protected AgentTimeEntry extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	AgentTimeEntry nextResult = new AgentTimeEntry();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setExternalID(rs.getString("externalID"));

nextResult.setFromTime(rs.getDate("fromTime"));

nextResult.setNotificationDetected(rs.getBoolean("notificationDetected"));

nextResult.setNotificationResolved(rs.getBoolean("notificationResolved"));

nextResult.setToTime(rs.getDate("toTime"));

nextResult.setActionCode(rs.getString("actionCode"));

nextResult.setActionName(rs.getString("actionName"));

nextResult.setActivityName(rs.getString("activityName"));

nextResult.setCVGProjectName(rs.getString("cVGProjectName"));

nextResult.setDuration(rs.getInt("duration"));

EStartActivityCode estartactivitycode = new EStartActivityCode();
estartactivitycode.setID(rs.getString("estartactivitycode_ID"));
nextResult.setEStartActivityCode(estartactivitycode);

AgentTime agenttime = new AgentTime();
agenttime.setID(rs.getString("agenttime_ID"));
nextResult.setAgentTime(agenttime);

CVGProject cvgproject = new CVGProject();
cvgproject.setID(rs.getString("cvgproject_ID"));
nextResult.setCVGProject(cvgproject);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(AgentTimeEntry perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getExternalID());
pstmt.setDate(3, DateUtils.utilDateToSqlDate(perceroObject.getFromTime()));
pstmt.setBoolean(4, perceroObject.getNotificationDetected());
pstmt.setBoolean(5, perceroObject.getNotificationResolved());
pstmt.setDate(6, DateUtils.utilDateToSqlDate(perceroObject.getToTime()));
pstmt.setString(7, perceroObject.getActionCode());
pstmt.setString(8, perceroObject.getActionName());
pstmt.setString(9, perceroObject.getActivityName());
pstmt.setString(10, perceroObject.getCVGProjectName());
pstmt.setInt(11, perceroObject.getDuration());

if (perceroObject.getEStartActivityCode() == null)
{
pstmt.setString(12, null);
}
else
{
		pstmt.setString(12, perceroObject.getEStartActivityCode().getID());
}


if (perceroObject.getAgentTime() == null)
{
pstmt.setString(13, null);
}
else
{
		pstmt.setString(13, perceroObject.getAgentTime().getID());
}


if (perceroObject.getCVGProject() == null)
{
pstmt.setString(14, null);
}
else
{
		pstmt.setString(14, perceroObject.getCVGProject().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(AgentTimeEntry perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getExternalID());
pstmt.setDate(2, DateUtils.utilDateToSqlDate(perceroObject.getFromTime()));
pstmt.setBoolean(3, perceroObject.getNotificationDetected());
pstmt.setBoolean(4, perceroObject.getNotificationResolved());
pstmt.setDate(5, DateUtils.utilDateToSqlDate(perceroObject.getToTime()));
pstmt.setString(6, perceroObject.getActionCode());
pstmt.setString(7, perceroObject.getActionName());
pstmt.setString(8, perceroObject.getActivityName());
pstmt.setString(9, perceroObject.getCVGProjectName());
pstmt.setInt(10, perceroObject.getDuration());

if (perceroObject.getEStartActivityCode() == null)
{
pstmt.setString(11, null);
}
else
{
		pstmt.setString(11, perceroObject.getEStartActivityCode().getID());
}


if (perceroObject.getAgentTime() == null)
{
pstmt.setString(12, null);
}
else
{
		pstmt.setString(12, perceroObject.getAgentTime().getID());
}


if (perceroObject.getCVGProject() == null)
{
pstmt.setString(13, null);
}
else
{
		pstmt.setString(13, perceroObject.getCVGProject().getID());
}

pstmt.setString(14, perceroObject.getID());

		
	}

	@Override
	public List<AgentTimeEntry> findByExample(AgentTimeEntry theQueryObject,
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

boolean useFromTime = theQueryObject.getFromTime() != null && (excludeProperties == null || !excludeProperties.contains("fromTime"));

if (useFromTime)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " fromTime=? ";
paramValues.add(theQueryObject.getFromTime());
propertyCounter++;
}

boolean useNotificationDetected = theQueryObject.getNotificationDetected() != null && (excludeProperties == null || !excludeProperties.contains("notificationDetected"));

if (useNotificationDetected)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " notificationDetected=? ";
paramValues.add(theQueryObject.getNotificationDetected());
propertyCounter++;
}

boolean useNotificationResolved = theQueryObject.getNotificationResolved() != null && (excludeProperties == null || !excludeProperties.contains("notificationResolved"));

if (useNotificationResolved)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " notificationResolved=? ";
paramValues.add(theQueryObject.getNotificationResolved());
propertyCounter++;
}

boolean useToTime = theQueryObject.getToTime() != null && (excludeProperties == null || !excludeProperties.contains("toTime"));

if (useToTime)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " toTime=? ";
paramValues.add(theQueryObject.getToTime());
propertyCounter++;
}

boolean useActionCode = StringUtils.hasText(theQueryObject.getActionCode()) && (excludeProperties == null || !excludeProperties.contains("actionCode"));

if (useActionCode)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " actionCode=? ";
paramValues.add(theQueryObject.getActionCode());
propertyCounter++;
}

boolean useActionName = StringUtils.hasText(theQueryObject.getActionName()) && (excludeProperties == null || !excludeProperties.contains("actionName"));

if (useActionName)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " actionName=? ";
paramValues.add(theQueryObject.getActionName());
propertyCounter++;
}

boolean useActivityName = StringUtils.hasText(theQueryObject.getActivityName()) && (excludeProperties == null || !excludeProperties.contains("activityName"));

if (useActivityName)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " activityName=? ";
paramValues.add(theQueryObject.getActivityName());
propertyCounter++;
}

boolean useCVGProjectName = StringUtils.hasText(theQueryObject.getCVGProjectName()) && (excludeProperties == null || !excludeProperties.contains("cVGProjectName"));

if (useCVGProjectName)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " cVGProjectName=? ";
paramValues.add(theQueryObject.getCVGProjectName());
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

boolean useAgentTimeID = theQueryObject.getAgentTime() != null && (excludeProperties == null || !excludeProperties.contains("agentTime"));

if (useAgentTimeID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " agentTimeID=? ";
paramValues.add(theQueryObject.getAgentTime().getID());
propertyCounter++;
}

boolean useCVGProjectID = theQueryObject.getCVGProject() != null && (excludeProperties == null || !excludeProperties.contains("cVGProject"));

if (useCVGProjectID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " cVGProjectID=? ";
paramValues.add(theQueryObject.getCVGProject().getID());
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
