
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
import com.pulse.mo.ScheduledActivityCode;
import com.pulse.mo.ScheduledActivityType;
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
		return "SELECT SCHEDULED_TIME_ENTRY.ID FROM SCHEDULED_TIME_ENTRY SCHEDULED_TIME_ENTRY WHERE SCHEDULED_TIME_ENTRY.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT SCHEDULED_TIME_ENTRY.ID,SCHEDULED_TIME_ENTRY.ACTIVITY_TYPE_NAME,SCHEDULED_TIME_ENTRY.DURATION,SCHEDULED_TIME_ENTRY.FROM_TIME,SCHEDULED_TIME_ENTRY.TO_TIME,SCHEDULED_TIME_ENTRY.SCHEDULED_ACTIVITY_CODE_ID,SCHEDULED_TIME_ENTRY.SCHEDULED_ACTIVITY_TYPE_ID,SCHEDULED_TIME_ENTRY.SCHEDULED_TIME_ID FROM SCHEDULED_TIME_ENTRY SCHEDULED_TIME_ENTRY WHERE SCHEDULED_TIME_ENTRY.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT SCHEDULED_TIME_ENTRY.ID FROM SCHEDULED_TIME_ENTRY SCHEDULED_TIME_ENTRY ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT SCHEDULED_TIME_ENTRY.ID FROM SCHEDULED_TIME_ENTRY SCHEDULED_TIME_ENTRY ORDER BY SCHEDULED_TIME_ENTRY.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT SCHEDULED_TIME_ENTRY.ID,SCHEDULED_TIME_ENTRY.ACTIVITY_TYPE_NAME,SCHEDULED_TIME_ENTRY.DURATION,SCHEDULED_TIME_ENTRY.FROM_TIME,SCHEDULED_TIME_ENTRY.TO_TIME,SCHEDULED_TIME_ENTRY.SCHEDULED_ACTIVITY_CODE_ID,SCHEDULED_TIME_ENTRY.SCHEDULED_ACTIVITY_TYPE_ID,SCHEDULED_TIME_ENTRY.SCHEDULED_TIME_ID FROM SCHEDULED_TIME_ENTRY SCHEDULED_TIME_ENTRY ORDER BY SCHEDULED_TIME_ENTRY.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT SCHEDULED_TIME_ENTRY.ID,SCHEDULED_TIME_ENTRY.ACTIVITY_TYPE_NAME,SCHEDULED_TIME_ENTRY.DURATION,SCHEDULED_TIME_ENTRY.FROM_TIME,SCHEDULED_TIME_ENTRY.TO_TIME,SCHEDULED_TIME_ENTRY.SCHEDULED_ACTIVITY_CODE_ID,SCHEDULED_TIME_ENTRY.SCHEDULED_ACTIVITY_TYPE_ID,SCHEDULED_TIME_ENTRY.SCHEDULED_TIME_ID FROM SCHEDULED_TIME_ENTRY SCHEDULED_TIME_ENTRY ORDER BY SCHEDULED_TIME_ENTRY.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM SCHEDULED_TIME_ENTRY SCHEDULED_TIME_ENTRY";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT SCHEDULED_TIME_ENTRY.ID,SCHEDULED_TIME_ENTRY.ACTIVITY_TYPE_NAME,SCHEDULED_TIME_ENTRY.DURATION,SCHEDULED_TIME_ENTRY.FROM_TIME,SCHEDULED_TIME_ENTRY.TO_TIME,SCHEDULED_TIME_ENTRY.SCHEDULED_ACTIVITY_CODE_ID,SCHEDULED_TIME_ENTRY.SCHEDULED_ACTIVITY_TYPE_ID,SCHEDULED_TIME_ENTRY.SCHEDULED_TIME_ID FROM SCHEDULED_TIME_ENTRY SCHEDULED_TIME_ENTRY WHERE SCHEDULED_TIME_ENTRY.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT SCHEDULED_TIME_ENTRY.ID FROM SCHEDULED_TIME_ENTRY SCHEDULED_TIME_ENTRY WHERE SCHEDULED_TIME_ENTRY.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT SCHEDULED_TIME_ENTRY.ID,SCHEDULED_TIME_ENTRY.ACTIVITY_TYPE_NAME,SCHEDULED_TIME_ENTRY.DURATION,SCHEDULED_TIME_ENTRY.FROM_TIME,SCHEDULED_TIME_ENTRY.TO_TIME,SCHEDULED_TIME_ENTRY.SCHEDULED_ACTIVITY_CODE_ID,SCHEDULED_TIME_ENTRY.SCHEDULED_ACTIVITY_TYPE_ID,SCHEDULED_TIME_ENTRY.SCHEDULED_TIME_ID FROM SCHEDULED_TIME_ENTRY SCHEDULED_TIME_ENTRY WHERE SCHEDULED_TIME_ENTRY." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT SCHEDULED_TIME_ENTRY.ID FROM SCHEDULED_TIME_ENTRY SCHEDULED_TIME_ENTRY WHERE SCHEDULED_TIME_ENTRY." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT SCHEDULED_TIME_ENTRY.ID FROM SCHEDULED_TIME_ENTRY SCHEDULED_TIME_ENTRY ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT SCHEDULED_TIME_ENTRY.ID,SCHEDULED_TIME_ENTRY.ACTIVITY_TYPE_NAME,SCHEDULED_TIME_ENTRY.DURATION,SCHEDULED_TIME_ENTRY.FROM_TIME,SCHEDULED_TIME_ENTRY.TO_TIME,SCHEDULED_TIME_ENTRY.SCHEDULED_ACTIVITY_CODE_ID,SCHEDULED_TIME_ENTRY.SCHEDULED_ACTIVITY_TYPE_ID,SCHEDULED_TIME_ENTRY.SCHEDULED_TIME_ID FROM SCHEDULED_TIME_ENTRY SCHEDULED_TIME_ENTRY ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO SCHEDULED_TIME_ENTRY (ID,ACTIVITY_TYPE_NAME,DURATION,FROM_TIME,TO_TIME,SCHEDULED_ACTIVITY_CODE_ID,SCHEDULED_ACTIVITY_TYPE_ID,SCHEDULED_TIME_ID) VALUES (?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE SCHEDULED_TIME_ENTRY SET ACTIVITY_TYPE_NAME=?,DURATION=?,FROM_TIME=?,TO_TIME=?,SCHEDULED_ACTIVITY_CODE_ID=?,SCHEDULED_ACTIVITY_TYPE_ID=?,SCHEDULED_TIME_ID=? WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM SCHEDULED_TIME_ENTRY WHERE ID=?";
	}
	
	@Override
	protected ScheduledTimeEntry extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	ScheduledTimeEntry nextResult = new ScheduledTimeEntry();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setActivityTypeName(rs.getString("ACTIVITY_TYPE_NAME"));

nextResult.setDuration(rs.getInt("DURATION"));

nextResult.setFromTime(rs.getDate("FROM_TIME"));

nextResult.setToTime(rs.getDate("TO_TIME"));

ScheduledActivityCode scheduledactivitycode = new ScheduledActivityCode();
scheduledactivitycode.setID(rs.getString("SCHEDULED_ACTIVITY_CODE_ID"));
nextResult.setScheduledActivityCode(scheduledactivitycode);

ScheduledActivityType scheduledactivitytype = new ScheduledActivityType();
scheduledactivitytype.setID(rs.getString("SCHEDULED_ACTIVITY_TYPE_ID"));
nextResult.setScheduledActivityType(scheduledactivitytype);

ScheduledTime scheduledtime = new ScheduledTime();
scheduledtime.setID(rs.getString("SCHEDULED_TIME_ID"));
nextResult.setScheduledTime(scheduledtime);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(ScheduledTimeEntry perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getActivityTypeName());
pstmt.setInt(3, perceroObject.getDuration());
pstmt.setDate(4, DateUtils.utilDateToSqlDate(perceroObject.getFromTime()));
pstmt.setDate(5, DateUtils.utilDateToSqlDate(perceroObject.getToTime()));

if (perceroObject.getScheduledActivityCode() == null)
{
pstmt.setString(6, null);
}
else
{
		pstmt.setString(6, perceroObject.getScheduledActivityCode().getID());
}


if (perceroObject.getScheduledActivityType() == null)
{
pstmt.setString(7, null);
}
else
{
		pstmt.setString(7, perceroObject.getScheduledActivityType().getID());
}


if (perceroObject.getScheduledTime() == null)
{
pstmt.setString(8, null);
}
else
{
		pstmt.setString(8, perceroObject.getScheduledTime().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(ScheduledTimeEntry perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getActivityTypeName());
pstmt.setInt(2, perceroObject.getDuration());
pstmt.setDate(3, DateUtils.utilDateToSqlDate(perceroObject.getFromTime()));
pstmt.setDate(4, DateUtils.utilDateToSqlDate(perceroObject.getToTime()));

if (perceroObject.getScheduledActivityCode() == null)
{
pstmt.setString(5, null);
}
else
{
		pstmt.setString(5, perceroObject.getScheduledActivityCode().getID());
}


if (perceroObject.getScheduledActivityType() == null)
{
pstmt.setString(6, null);
}
else
{
		pstmt.setString(6, perceroObject.getScheduledActivityType().getID());
}


if (perceroObject.getScheduledTime() == null)
{
pstmt.setString(7, null);
}
else
{
		pstmt.setString(7, perceroObject.getScheduledTime().getID());
}

pstmt.setString(8, perceroObject.getID());

		
	}

	@Override
	public List<ScheduledTimeEntry> findByExample(ScheduledTimeEntry theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useActivityTypeName = StringUtils.hasText(theQueryObject.getActivityTypeName()) && (excludeProperties == null || !excludeProperties.contains("activityTypeName"));

if (useActivityTypeName)
{
sql += " WHERE ";
sql += " ACTIVITY_TYPE_NAME=? ";
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
sql += " DURATION=? ";
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
sql += " FROM_TIME=? ";
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
sql += " TO_TIME=? ";
paramValues.add(theQueryObject.getToTime());
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
sql += " SCHEDULED_ACTIVITY_CODE_ID=? ";
paramValues.add(theQueryObject.getScheduledActivityCode().getID());
propertyCounter++;
}

boolean useScheduledActivityTypeID = theQueryObject.getScheduledActivityType() != null && (excludeProperties == null || !excludeProperties.contains("scheduledActivityType"));

if (useScheduledActivityTypeID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " SCHEDULED_ACTIVITY_TYPE_ID=? ";
paramValues.add(theQueryObject.getScheduledActivityType().getID());
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
sql += " SCHEDULED_TIME_ID=? ";
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
