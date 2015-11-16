
package com.pulse.mo.dao;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.percero.agents.sync.exceptions.SyncDataException;
import com.percero.util.DateUtils;
import com.pulse.dataprovider.IConnectionFactory;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import com.percero.agents.sync.metadata.MappedClass;
import com.percero.agents.sync.dao.DAORegistry;
import com.percero.agents.sync.dao.IDataAccessObject;
import com.percero.agents.sync.exceptions.SyncException;
import com.percero.agents.sync.vo.BaseDataObject;
import java.sql.Connection;
import java.sql.Statement;
import com.pulse.dataprovider.IConnectionFactory;
import com.percero.agents.sync.exceptions.SyncDataException;
import com.pulse.mo.*;

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
	
	public static final String SHELL_ONLY_SELECT = "\"LOB_CONFIGURATION_ENTRY\".\"ID\"";
	public static final String SQL_VIEW = ",\"LOB_CONFIGURATION_ENTRY\".\"DURATION_TOLERANCE_ENABLED\",\"LOB_CONFIGURATION_ENTRY\".\"DURATION_TOLERANCE\",\"LOB_CONFIGURATION_ENTRY\".\"DURATION_TOLERANCE_INTERVAL\",\"LOB_CONFIGURATION_ENTRY\".\"OCC_TOLERANCE_INTERVAL\",\"LOB_CONFIGURATION_ENTRY\".\"REMINDER_INTERVAL\",\"LOB_CONFIGURATION_ENTRY\".\"LOB_CONFIGURATION_ID\",\"LOB_CONFIGURATION_ENTRY\".\"NOTIFICATION_FREQUENCY_ID\"";
	private String selectFromStatementTableName = " FROM \"LOB_CONFIGURATION_ENTRY\" \"LOB_CONFIGURATION_ENTRY\"";
	private String whereClause = "  WHERE \"LOB_CONFIGURATION_ENTRY\".\"ID\"=?";
	private String whereInClause = "  join table(sys.dbms_debug_vc2coll(?)) SQLLIST on \"LOB_CONFIGURATION_ENTRY\".\"ID\"= SQLLIST.column_value";
	private String orderByTableName = "  ORDER BY \"LOB_CONFIGURATION_ENTRY\".\"ID\"";
	
	

	
	@Override
	protected String getConnectionFactoryName() {
		return LOBConfigurationEntryDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT " + SHELL_ONLY_SELECT +  " " + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT \"LOB_CONFIGURATION_ENTRY\".\"ID\"" + SQL_VIEW  + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName +  orderByTableName;
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName  +  orderByTableName  + " LIMIT ? OFFSET ?";
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
		return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName + whereInClause;
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		
		return "SELECT \"LOB_CONFIGURATION_ENTRY\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + " WHERE \"LOB_CONFIGURATION_ENTRY\"." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) 
	{
		
		return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName + " WHERE \"LOB_CONFIGURATION_ENTRY\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName;
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT \"LOB_CONFIGURATION_ENTRY\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName;
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO TBL_LOB_CONFIGURATION_ENTRY (\"ID\",\"DURATION_TOLERANCE_ENABLED\",\"DURATION_TOLERANCE\",\"DURATION_TOLERANCE_INTERVAL\",\"OCC_TOLERANCE_INTERVAL\",\"REMINDER_INTERVAL\",\"LOB_CONFIGURATION_ID\",\"NOTIFICATION_FREQUENCY_ID\") VALUES (?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE TBL_LOB_CONFIGURATION_ENTRY SET \"DURATION_TOLERANCE_ENABLED\"=?,\"DURATION_TOLERANCE\"=?,\"DURATION_TOLERANCE_INTERVAL\"=?,\"OCC_TOLERANCE_INTERVAL\"=?,\"REMINDER_INTERVAL\"=?,\"LOB_CONFIGURATION_ID\"=?,\"NOTIFICATION_FREQUENCY_ID\"=? WHERE \"ID\"=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM TBL_LOB_CONFIGURATION_ENTRY WHERE \"ID\"=?";
	}
	
	@Override
	protected LOBConfigurationEntry extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	
		
LOBConfigurationEntry nextResult = null;
    	
		    	
    	if (nextResult == null) {
    		nextResult = new LOBConfigurationEntry();
    	}

		
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setDurationToleranceEnabled(rs.getBoolean("DURATION_TOLERANCE_ENABLED"));


nextResult.setDurationTolerance(rs.getInt("DURATION_TOLERANCE"));


nextResult.setDurationToleranceInterval(rs.getInt("DURATION_TOLERANCE_INTERVAL"));


nextResult.setOccurrenceToleranceInterval(rs.getInt("OCC_TOLERANCE_INTERVAL"));


nextResult.setReminderInterval(rs.getInt("REMINDER_INTERVAL"));


String lobconfigurationID = rs.getString("LOB_CONFIGURATION_ID");
if (StringUtils.hasText(lobconfigurationID) && !"null".equalsIgnoreCase(lobconfigurationID) ){
LOBConfiguration lobconfiguration = new LOBConfiguration();
lobconfiguration.setID(lobconfigurationID);
nextResult.setLOBConfiguration(lobconfiguration);
}


String notificationfrequencyID = rs.getString("NOTIFICATION_FREQUENCY_ID");
if (StringUtils.hasText(notificationfrequencyID) && !"null".equalsIgnoreCase(notificationfrequencyID) ){
NotificationFrequency notificationfrequency = new NotificationFrequency();
notificationfrequency.setID(notificationfrequencyID);
nextResult.setNotificationFrequency(notificationfrequency);
}



			
    	}
		
		
    	return nextResult;
	}
	
	protected void setBaseStatmentInsertParams(LOBConfigurationEntry perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
JdbcHelper.setBoolean(pstmt,2, perceroObject.getDurationToleranceEnabled());
JdbcHelper.setInt(pstmt,3, perceroObject.getDurationTolerance());
JdbcHelper.setInt(pstmt,4, perceroObject.getDurationToleranceInterval());
JdbcHelper.setInt(pstmt,5, perceroObject.getOccurrenceToleranceInterval());
JdbcHelper.setInt(pstmt,6, perceroObject.getReminderInterval());

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
		
		JdbcHelper.setBoolean(pstmt,1, perceroObject.getDurationToleranceEnabled());
JdbcHelper.setInt(pstmt,2, perceroObject.getDurationTolerance());
JdbcHelper.setInt(pstmt,3, perceroObject.getDurationToleranceInterval());
JdbcHelper.setInt(pstmt,4, perceroObject.getOccurrenceToleranceInterval());
JdbcHelper.setInt(pstmt,5, perceroObject.getReminderInterval());

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



		if (propertyCounter == 0) {
			throw new SyncException(SyncException.METHOD_UNSUPPORTED, SyncException.METHOD_UNSUPPORTED_CODE);
		}
		
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
