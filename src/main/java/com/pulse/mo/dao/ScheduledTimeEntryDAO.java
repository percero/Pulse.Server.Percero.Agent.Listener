
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
import com.pulse.mo.ScheduledTimeEntry;
import com.pulse.mo.ActivityType;
import com.pulse.mo.ScheduledActivityCode;
import com.pulse.mo.ScheduledTime;

*/

@Component
public class ScheduledTimeEntryDAO extends SqlDataAccessObject<ScheduledTimeEntry> implements IDataAccessObject<ScheduledTimeEntry> {

	static final Logger log = Logger.getLogger(ScheduledTimeEntryDAO.class);

	
	public ScheduledTimeEntryDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(ScheduledTimeEntry.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	@Override
	protected String getConnectionFactoryName() {
		return ScheduledTimeEntryDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT scheduledtimeentry.ID FROM ScheduledTimeEntry scheduledtimeentry WHERE scheduledtimeentry.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT scheduledtimeentry.ID,scheduledtimeentry.externalID,scheduledtimeentry.activityTypeName,scheduledtimeentry.duration,scheduledtimeentry.fromTime,scheduledtimeentry.toTime,scheduledtimeentry.activityType_ID,scheduledtimeentry.scheduledActivityCode_ID,scheduledtimeentry.scheduledTime_ID FROM ScheduledTimeEntry scheduledtimeentry WHERE scheduledtimeentry.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT scheduledtimeentry.ID FROM ScheduledTimeEntry scheduledtimeentry ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT scheduledtimeentry.ID FROM ScheduledTimeEntry scheduledtimeentry ORDER BY scheduledtimeentry.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT scheduledtimeentry.ID,scheduledtimeentry.externalID,scheduledtimeentry.activityTypeName,scheduledtimeentry.duration,scheduledtimeentry.fromTime,scheduledtimeentry.toTime,scheduledtimeentry.activityType_ID,scheduledtimeentry.scheduledActivityCode_ID,scheduledtimeentry.scheduledTime_ID FROM ScheduledTimeEntry scheduledtimeentry ORDER BY scheduledtimeentry.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT scheduledtimeentry.ID,scheduledtimeentry.externalID,scheduledtimeentry.activityTypeName,scheduledtimeentry.duration,scheduledtimeentry.fromTime,scheduledtimeentry.toTime,scheduledtimeentry.activityType_ID,scheduledtimeentry.scheduledActivityCode_ID,scheduledtimeentry.scheduledTime_ID FROM ScheduledTimeEntry scheduledtimeentry ORDER BY scheduledtimeentry.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM ScheduledTimeEntry scheduledtimeentry";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT scheduledtimeentry.ID,scheduledtimeentry.externalID,scheduledtimeentry.activityTypeName,scheduledtimeentry.duration,scheduledtimeentry.fromTime,scheduledtimeentry.toTime,scheduledtimeentry.activityType_ID,scheduledtimeentry.scheduledActivityCode_ID,scheduledtimeentry.scheduledTime_ID FROM ScheduledTimeEntry scheduledtimeentry WHERE scheduledtimeentry.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT scheduledtimeentry.ID FROM ScheduledTimeEntry scheduledtimeentry WHERE scheduledtimeentry.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT scheduledtimeentry.ID,scheduledtimeentry.externalID,scheduledtimeentry.activityTypeName,scheduledtimeentry.duration,scheduledtimeentry.fromTime,scheduledtimeentry.toTime,scheduledtimeentry.activityType_ID,scheduledtimeentry.scheduledActivityCode_ID,scheduledtimeentry.scheduledTime_ID FROM ScheduledTimeEntry scheduledtimeentry WHERE scheduledtimeentry." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT scheduledtimeentry.ID FROM ScheduledTimeEntry scheduledtimeentry WHERE scheduledtimeentry." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT scheduledtimeentry.ID FROM ScheduledTimeEntry scheduledtimeentry ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT scheduledtimeentry.ID,scheduledtimeentry.externalID,scheduledtimeentry.activityTypeName,scheduledtimeentry.duration,scheduledtimeentry.fromTime,scheduledtimeentry.toTime,scheduledtimeentry.activityType_ID,scheduledtimeentry.scheduledActivityCode_ID,scheduledtimeentry.scheduledTime_ID FROM ScheduledTimeEntry scheduledtimeentry ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO ScheduledTimeEntry (ID,externalID,activityTypeName,duration,fromTime,toTime,activityType_ID,scheduledActivityCode_ID,scheduledTime_ID) VALUES (?,?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE ScheduledTimeEntry SET externalID=?,activityTypeName=?,duration=?,fromTime=?,toTime=?,activityType_ID=?,scheduledActivityCode_ID=?,scheduledTime_ID=? WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM ScheduledTimeEntry WHERE ID=?";
	}
	
	@Override
	protected ScheduledTimeEntry extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	ScheduledTimeEntry nextResult = new ScheduledTimeEntry();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setExternalID(rs.getString("externalID"));

nextResult.setActivityTypeName(rs.getString("activityTypeName"));

nextResult.setDuration(rs.getInt("duration"));

nextResult.setFromTime(rs.getDate("fromTime"));

nextResult.setToTime(rs.getDate("toTime"));

ActivityType activitytype = new ActivityType();
activitytype.setID(rs.getString("activitytype_ID"));
nextResult.setActivityType(activitytype);

ScheduledActivityCode scheduledactivitycode = new ScheduledActivityCode();
scheduledactivitycode.setID(rs.getString("scheduledactivitycode_ID"));
nextResult.setScheduledActivityCode(scheduledactivitycode);

ScheduledTime scheduledtime = new ScheduledTime();
scheduledtime.setID(rs.getString("scheduledtime_ID"));
nextResult.setScheduledTime(scheduledtime);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(ScheduledTimeEntry perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getExternalID());
pstmt.setString(3, perceroObject.getActivityTypeName());
pstmt.setInt(4, perceroObject.getDuration());
pstmt.setDate(5, DateUtils.utilDateToSqlDate(perceroObject.getFromTime()));
pstmt.setDate(6, DateUtils.utilDateToSqlDate(perceroObject.getToTime()));

if (perceroObject.getActivityType() == null)
{
pstmt.setString(7, null);
}
else
{
		pstmt.setString(7, perceroObject.getActivityType().getID());
}


if (perceroObject.getScheduledActivityCode() == null)
{
pstmt.setString(8, null);
}
else
{
		pstmt.setString(8, perceroObject.getScheduledActivityCode().getID());
}


if (perceroObject.getScheduledTime() == null)
{
pstmt.setString(9, null);
}
else
{
		pstmt.setString(9, perceroObject.getScheduledTime().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(ScheduledTimeEntry perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getExternalID());
pstmt.setString(2, perceroObject.getActivityTypeName());
pstmt.setInt(3, perceroObject.getDuration());
pstmt.setDate(4, DateUtils.utilDateToSqlDate(perceroObject.getFromTime()));
pstmt.setDate(5, DateUtils.utilDateToSqlDate(perceroObject.getToTime()));

if (perceroObject.getActivityType() == null)
{
pstmt.setString(6, null);
}
else
{
		pstmt.setString(6, perceroObject.getActivityType().getID());
}


if (perceroObject.getScheduledActivityCode() == null)
{
pstmt.setString(7, null);
}
else
{
		pstmt.setString(7, perceroObject.getScheduledActivityCode().getID());
}


if (perceroObject.getScheduledTime() == null)
{
pstmt.setString(8, null);
}
else
{
		pstmt.setString(8, perceroObject.getScheduledTime().getID());
}

pstmt.setString(9, perceroObject.getID());

		
	}

	@Override
	public List<ScheduledTimeEntry> findByExample(ScheduledTimeEntry theQueryObject,
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

boolean useActivityTypeName = StringUtils.hasText(theQueryObject.getActivityTypeName()) && (excludeProperties == null || !excludeProperties.contains("activityTypeName"));

if (useActivityTypeName)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " activityTypeName=? ";
paramValues.add(theQueryObject.getActivityTypeName());
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

boolean useActivityTypeID = theQueryObject.getActivityType() != null && (excludeProperties == null || !excludeProperties.contains("activityType"));

if (useActivityTypeID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " activityTypeID=? ";
paramValues.add(theQueryObject.getActivityType().getID());
propertyCounter++;
}

boolean useScheduledActivityCodeID = theQueryObject.getScheduledActivityCode() != null && (excludeProperties == null || !excludeProperties.contains("scheduledActivityCode"));

if (useScheduledActivityCodeID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " scheduledActivityCodeID=? ";
paramValues.add(theQueryObject.getScheduledActivityCode().getID());
propertyCounter++;
}

boolean useScheduledTimeID = theQueryObject.getScheduledTime() != null && (excludeProperties == null || !excludeProperties.contains("scheduledTime"));

if (useScheduledTimeID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " scheduledTimeID=? ";
paramValues.add(theQueryObject.getScheduledTime().getID());
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
