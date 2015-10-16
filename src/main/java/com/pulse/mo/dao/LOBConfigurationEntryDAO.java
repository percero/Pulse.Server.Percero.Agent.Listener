
package com.pulse.mo.dao;

import java.sql.PreparedStatement;
import java.sql.CallableStatement;
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
import com.pulse.mo.LOBConfigurationEntry;
import com.pulse.mo.ThresholdExceededNotification;
import com.pulse.mo.LOBConfiguration;
import com.pulse.mo.NotificationFrequency;
import com.pulse.mo.TimecardActivity;

*/

@Component
public class LOBConfigurationEntryDAO extends SqlDataAccessObject<LOBConfigurationEntry> implements IDataAccessObject<LOBConfigurationEntry> {

	static final Logger log = Logger.getLogger(LOBConfigurationEntryDAO.class);

	
	public LOBConfigurationEntryDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(LOBConfigurationEntry.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	
	public static final String SQL_VIEW = ",\"LOB_CONFIGURATION_ENTRY\".\"DURATION_TOLERANCE_ENABLED\",\"LOB_CONFIGURATION_ENTRY\".\"DURATION_TOLERANCE\",\"LOB_CONFIGURATION_ENTRY\".\"DURATION_TOLERANCE_INTERVAL\",\"LOB_CONFIGURATION_ENTRY\".\"OCC_TOLERANCE_INTERVAL\",\"LOB_CONFIGURATION_ENTRY\".\"REMINDER_INTERVAL\",\"LOB_CONFIGURATION_ENTRY\".\"LOB_CONFIGURATION_ID\",\"LOB_CONFIGURATION_ENTRY\".\"NOTIFICATION_FREQUENCY_ID\"";
	private String selectFromStatementTableName = " FROM \"LOB_CONFIGURATION_ENTRY\" \"LOB_CONFIGURATION_ENTRY\"";
	private String whereClause = " WHERE \"LOB_CONFIGURATION_ENTRY\".\"ID\"=?";
	private String whereInClause = " join table(sys.dbms_debug_vc2coll(?)) SQLLIST on \"LOB_CONFIGURATION_ENTRY\".\"ID\"= SQLLIST.column_value";
	private String orderByTableName = " ORDER BY \"LOB_CONFIGURATION_ENTRY\".\"ID\"";
	
	

	
	@Override
	protected String getConnectionFactoryName() {
		return LOBConfigurationEntryDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT \"LOB_CONFIGURATION_ENTRY\".\"ID\" " + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT \"LOB_CONFIGURATION_ENTRY\".\"ID\"" + SQL_VIEW  + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT \"LOB_CONFIGURATION_ENTRY\".\"ID\" " + selectFromStatementTableName +  orderByTableName;
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT \"LOB_CONFIGURATION_ENTRY\".\"ID\" " + selectFromStatementTableName  +  orderByTableName  + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT \"LOB_CONFIGURATION_ENTRY\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName  + orderByTableName;
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT \"LOB_CONFIGURATION_ENTRY\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + orderByTableName + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() 
	{
		return "SELECT COUNT(ID) " + selectFromStatementTableName;
	}
	
	@Override
	protected String getSelectInStarSQL() 
	{
		return "SELECT \"LOB_CONFIGURATION_ENTRY\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + whereInClause;
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT \"LOB_CONFIGURATION_ENTRY\".\"ID\" " + selectFromStatementTableName + whereInClause;
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		
		return "SELECT \"LOB_CONFIGURATION_ENTRY\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + " WHERE \"LOB_CONFIGURATION_ENTRY\"." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) 
	{
		
		return "SELECT \"LOB_CONFIGURATION_ENTRY\".\"ID\" " + selectFromStatementTableName + " WHERE \"LOB_CONFIGURATION_ENTRY\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT \"LOB_CONFIGURATION_ENTRY\".\"ID\" " + selectFromStatementTableName;
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT \"LOB_CONFIGURATION_ENTRY\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName;
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO LOB_CONFIGURATION_ENTRY (\"ID\",\"DURATION_TOLERANCE_ENABLED\",\"DURATION_TOLERANCE\",\"DURATION_TOLERANCE_INTERVAL\",\"OCC_TOLERANCE_INTERVAL\",\"REMINDER_INTERVAL\",\"LOB_CONFIGURATION_ID\",\"NOTIFICATION_FREQUENCY_ID\") VALUES (?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE \"TBL_LOB_CONFIGURATION_ENTRY\" SET \"DURATION_TOLERANCE_ENABLED\"=?,\"DURATION_TOLERANCE\"=?,\"DURATION_TOLERANCE_INTERVAL\"=?,\"OCC_TOLERANCE_INTERVAL\"=?,\"REMINDER_INTERVAL\"=?,\"LOB_CONFIGURATION_ID\"=?,\"NOTIFICATION_FREQUENCY_ID\"=? WHERE \"ID\"=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM \"TBL_LOB_CONFIGURATION_ENTRY\" WHERE \"ID\"=?";
	}
	
	@Override
	protected LOBConfigurationEntry extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	LOBConfigurationEntry nextResult = new LOBConfigurationEntry();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setDurationToleranceEnabled(rs.getBoolean("DURATION_TOLERANCE_ENABLED"));

nextResult.setDurationTolerance(rs.getInt("DURATION_TOLERANCE"));

nextResult.setDurationToleranceInterval(rs.getInt("DURATION_TOLERANCE_INTERVAL"));

nextResult.setOccurrenceToleranceInterval(rs.getInt("OCC_TOLERANCE_INTERVAL"));

nextResult.setReminderInterval(rs.getInt("REMINDER_INTERVAL"));

LOBConfiguration lobconfiguration = new LOBConfiguration();
lobconfiguration.setID(rs.getString("LOB_CONFIGURATION_ID"));
nextResult.setLOBConfiguration(lobconfiguration);

NotificationFrequency notificationfrequency = new NotificationFrequency();
notificationfrequency.setID(rs.getString("NOTIFICATION_FREQUENCY_ID"));
nextResult.setNotificationFrequency(notificationfrequency);


			
    	}
    	
    	return nextResult;
	}
	
	protected void setBaseStatmentInsertParams(LOBConfigurationEntry perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setBoolean(2, perceroObject.getDurationToleranceEnabled());
pstmt.setInt(3, perceroObject.getDurationTolerance());
pstmt.setInt(4, perceroObject.getDurationToleranceInterval());
pstmt.setInt(5, perceroObject.getOccurrenceToleranceInterval());
pstmt.setInt(6, perceroObject.getReminderInterval());

if (perceroObject.getLOBConfiguration() == null)
{
pstmt.setString(7, null);
}
else
{
		pstmt.setString(7, perceroObject.getLOBConfiguration().getID());
}


if (perceroObject.getNotificationFrequency() == null)
{
pstmt.setString(8, null);
}
else
{
		pstmt.setString(8, perceroObject.getNotificationFrequency().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(LOBConfigurationEntry perceroObject, PreparedStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
		
	}
	
	@Override
	protected void setCallableStatmentInsertParams(LOBConfigurationEntry perceroObject, CallableStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	

	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(LOBConfigurationEntry perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setBoolean(1, perceroObject.getDurationToleranceEnabled());
pstmt.setInt(2, perceroObject.getDurationTolerance());
pstmt.setInt(3, perceroObject.getDurationToleranceInterval());
pstmt.setInt(4, perceroObject.getOccurrenceToleranceInterval());
pstmt.setInt(5, perceroObject.getReminderInterval());

if (perceroObject.getLOBConfiguration() == null)
{
pstmt.setString(6, null);
}
else
{
		pstmt.setString(6, perceroObject.getLOBConfiguration().getID());
}


if (perceroObject.getNotificationFrequency() == null)
{
pstmt.setString(7, null);
}
else
{
		pstmt.setString(7, perceroObject.getNotificationFrequency().getID());
}

pstmt.setString(8, perceroObject.getID());

		
	}
	
	
	@Override
	protected void setCallableStatmentUpdateParams(LOBConfigurationEntry perceroObject, CallableStatement pstmt) throws SQLException 
	{
		
		//must be in same order as insert
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	}
	
	

	@Override
	public List<LOBConfigurationEntry> findByExample(LOBConfigurationEntry theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useDurationToleranceEnabled = theQueryObject.getDurationToleranceEnabled() != null && (excludeProperties == null || !excludeProperties.contains("durationToleranceEnabled"));

if (useDurationToleranceEnabled)
{
sql += " WHERE ";
sql += " \"DURATION_TOLERANCE_ENABLED\" =? ";
paramValues.add(theQueryObject.getDurationToleranceEnabled());
propertyCounter++;
}

boolean useDurationTolerance = theQueryObject.getDurationTolerance() != null && (excludeProperties == null || !excludeProperties.contains("durationTolerance"));

if (useDurationTolerance)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"DURATION_TOLERANCE\" =? ";
paramValues.add(theQueryObject.getDurationTolerance());
propertyCounter++;
}

boolean useDurationToleranceInterval = theQueryObject.getDurationToleranceInterval() != null && (excludeProperties == null || !excludeProperties.contains("durationToleranceInterval"));

if (useDurationToleranceInterval)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"DURATION_TOLERANCE_INTERVAL\" =? ";
paramValues.add(theQueryObject.getDurationToleranceInterval());
propertyCounter++;
}

boolean useOccurrenceToleranceInterval = theQueryObject.getOccurrenceToleranceInterval() != null && (excludeProperties == null || !excludeProperties.contains("occurrenceToleranceInterval"));

if (useOccurrenceToleranceInterval)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"OCC_TOLERANCE_INTERVAL\" =? ";
paramValues.add(theQueryObject.getOccurrenceToleranceInterval());
propertyCounter++;
}

boolean useReminderInterval = theQueryObject.getReminderInterval() != null && (excludeProperties == null || !excludeProperties.contains("reminderInterval"));

if (useReminderInterval)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"REMINDER_INTERVAL\" =? ";
paramValues.add(theQueryObject.getReminderInterval());
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
sql += " \"LOB_CONFIGURATION_ID\" =? ";
paramValues.add(theQueryObject.getLOBConfiguration().getID());
propertyCounter++;
}

boolean useNotificationFrequencyID = theQueryObject.getNotificationFrequency() != null && (excludeProperties == null || !excludeProperties.contains("notificationFrequency"));

if (useNotificationFrequencyID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"NOTIFICATION_FREQUENCY_ID\" =? ";
paramValues.add(theQueryObject.getNotificationFrequency().getID());
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
	
	@Override
	protected String getUpdateCallableStatementSql() {
		return "{call UPDATE_LOB_CONFIGURATION_ENTRY(?,?,?,?,?,?,?,?)}";
	}
	@Override
	protected String getInsertCallableStatementSql() {
		return "{call CREATE_LOB_CONFIGURATION_ENTRY(?,?,?,?,?,?,?,?)}";
	}
	@Override
	protected String getDeleteCallableStatementSql() {
		return "{call Delete_LOB_CONFIGURATION_ENTRY(?)}";
	}
	
	
	
	
}
