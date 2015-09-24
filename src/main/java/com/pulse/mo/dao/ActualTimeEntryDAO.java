
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
import com.pulse.mo.ActualTimeEntry;
import com.pulse.mo.ActualTime;
import com.pulse.mo.AuxMode;

*/

@Component
public class ActualTimeEntryDAO extends SqlDataAccessObject<ActualTimeEntry> implements IDataAccessObject<ActualTimeEntry> {

	static final Logger log = Logger.getLogger(ActualTimeEntryDAO.class);

	
	public ActualTimeEntryDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(ActualTimeEntry.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	@Override
	protected String getConnectionFactoryName() {
		return ActualTimeEntryDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT actualtimeentry.ID FROM ActualTimeEntry actualtimeentry WHERE actualtimeentry.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT actualtimeentry.ID,actualtimeentry.externalID,actualtimeentry.fromTime,actualtimeentry.actionName,actualtimeentry.auxModeName,actualtimeentry.cVGProjectName,actualtimeentry.duration,actualtimeentry.toTime,actualtimeentry.actualTime_ID,actualtimeentry.auxMode_ID FROM ActualTimeEntry actualtimeentry WHERE actualtimeentry.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT actualtimeentry.ID FROM ActualTimeEntry actualtimeentry ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT actualtimeentry.ID FROM ActualTimeEntry actualtimeentry ORDER BY actualtimeentry.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT actualtimeentry.ID,actualtimeentry.externalID,actualtimeentry.fromTime,actualtimeentry.actionName,actualtimeentry.auxModeName,actualtimeentry.cVGProjectName,actualtimeentry.duration,actualtimeentry.toTime,actualtimeentry.actualTime_ID,actualtimeentry.auxMode_ID FROM ActualTimeEntry actualtimeentry ORDER BY actualtimeentry.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT actualtimeentry.ID,actualtimeentry.externalID,actualtimeentry.fromTime,actualtimeentry.actionName,actualtimeentry.auxModeName,actualtimeentry.cVGProjectName,actualtimeentry.duration,actualtimeentry.toTime,actualtimeentry.actualTime_ID,actualtimeentry.auxMode_ID FROM ActualTimeEntry actualtimeentry ORDER BY actualtimeentry.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM ActualTimeEntry actualtimeentry";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT actualtimeentry.ID,actualtimeentry.externalID,actualtimeentry.fromTime,actualtimeentry.actionName,actualtimeentry.auxModeName,actualtimeentry.cVGProjectName,actualtimeentry.duration,actualtimeentry.toTime,actualtimeentry.actualTime_ID,actualtimeentry.auxMode_ID FROM ActualTimeEntry actualtimeentry WHERE actualtimeentry.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT actualtimeentry.ID FROM ActualTimeEntry actualtimeentry WHERE actualtimeentry.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT actualtimeentry.ID,actualtimeentry.externalID,actualtimeentry.fromTime,actualtimeentry.actionName,actualtimeentry.auxModeName,actualtimeentry.cVGProjectName,actualtimeentry.duration,actualtimeentry.toTime,actualtimeentry.actualTime_ID,actualtimeentry.auxMode_ID FROM ActualTimeEntry actualtimeentry WHERE actualtimeentry." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT actualtimeentry.ID FROM ActualTimeEntry actualtimeentry WHERE actualtimeentry." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT actualtimeentry.ID FROM ActualTimeEntry actualtimeentry ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT actualtimeentry.ID,actualtimeentry.externalID,actualtimeentry.fromTime,actualtimeentry.actionName,actualtimeentry.auxModeName,actualtimeentry.cVGProjectName,actualtimeentry.duration,actualtimeentry.toTime,actualtimeentry.actualTime_ID,actualtimeentry.auxMode_ID FROM ActualTimeEntry actualtimeentry ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO ActualTimeEntry (ID,externalID,fromTime,actionName,auxModeName,cVGProjectName,duration,toTime,actualTime_ID,auxMode_ID) VALUES (?,?,?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE ActualTimeEntry SET externalID=?,fromTime=?,actionName=?,auxModeName=?,cVGProjectName=?,duration=?,toTime=?,actualTime_ID=?,auxMode_ID=? WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM ActualTimeEntry WHERE ID=?";
	}
	
	@Override
	protected ActualTimeEntry extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	ActualTimeEntry nextResult = new ActualTimeEntry();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setExternalID(rs.getString("externalID"));

nextResult.setFromTime(rs.getDate("fromTime"));

nextResult.setActionName(rs.getString("actionName"));

nextResult.setAuxModeName(rs.getString("auxModeName"));

nextResult.setCVGProjectName(rs.getString("cVGProjectName"));

nextResult.setDuration(rs.getInt("duration"));

nextResult.setToTime(rs.getDate("toTime"));

ActualTime actualtime = new ActualTime();
actualtime.setID(rs.getString("actualtime_ID"));
nextResult.setActualTime(actualtime);

AuxMode auxmode = new AuxMode();
auxmode.setID(rs.getString("auxmode_ID"));
nextResult.setAuxMode(auxmode);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(ActualTimeEntry perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getExternalID());
pstmt.setDate(3, DateUtils.utilDateToSqlDate(perceroObject.getFromTime()));
pstmt.setString(4, perceroObject.getActionName());
pstmt.setString(5, perceroObject.getAuxModeName());
pstmt.setString(6, perceroObject.getCVGProjectName());
pstmt.setInt(7, perceroObject.getDuration());
pstmt.setDate(8, DateUtils.utilDateToSqlDate(perceroObject.getToTime()));

if (perceroObject.getActualTime() == null)
{
pstmt.setString(9, null);
}
else
{
		pstmt.setString(9, perceroObject.getActualTime().getID());
}


if (perceroObject.getAuxMode() == null)
{
pstmt.setString(10, null);
}
else
{
		pstmt.setString(10, perceroObject.getAuxMode().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(ActualTimeEntry perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getExternalID());
pstmt.setDate(2, DateUtils.utilDateToSqlDate(perceroObject.getFromTime()));
pstmt.setString(3, perceroObject.getActionName());
pstmt.setString(4, perceroObject.getAuxModeName());
pstmt.setString(5, perceroObject.getCVGProjectName());
pstmt.setInt(6, perceroObject.getDuration());
pstmt.setDate(7, DateUtils.utilDateToSqlDate(perceroObject.getToTime()));

if (perceroObject.getActualTime() == null)
{
pstmt.setString(8, null);
}
else
{
		pstmt.setString(8, perceroObject.getActualTime().getID());
}


if (perceroObject.getAuxMode() == null)
{
pstmt.setString(9, null);
}
else
{
		pstmt.setString(9, perceroObject.getAuxMode().getID());
}

pstmt.setString(10, perceroObject.getID());

		
	}

	@Override
	public List<ActualTimeEntry> findByExample(ActualTimeEntry theQueryObject,
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

boolean useAuxModeName = StringUtils.hasText(theQueryObject.getAuxModeName()) && (excludeProperties == null || !excludeProperties.contains("auxModeName"));

if (useAuxModeName)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " auxModeName=? ";
paramValues.add(theQueryObject.getAuxModeName());
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

boolean useActualTimeID = theQueryObject.getActualTime() != null && (excludeProperties == null || !excludeProperties.contains("actualTime"));

if (useActualTimeID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " actualTimeID=? ";
paramValues.add(theQueryObject.getActualTime().getID());
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
