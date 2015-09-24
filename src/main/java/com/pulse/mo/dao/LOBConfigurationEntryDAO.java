
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
import com.pulse.mo.LOBConfigurationEntry;
import com.pulse.mo.ThresholdExceededNotification;
import com.pulse.mo.LOBConfiguration;
import com.pulse.mo.NotificationFrequency;
import com.pulse.mo.AuxMode;
import com.pulse.mo.EStartActivityCode;

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
	@Override
	protected String getConnectionFactoryName() {
		return LOBConfigurationEntryDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT lobconfigurationentry.ID FROM LOBConfigurationEntry lobconfigurationentry WHERE lobconfigurationentry.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT lobconfigurationentry.ID,lobconfigurationentry.externalID,lobconfigurationentry.durationTolerance,lobconfigurationentry.durationToleranceEnabled,lobconfigurationentry.durationToleranceInterval,lobconfigurationentry.occurrenceToleranceInterval,lobconfigurationentry.reminderInterval,lobconfigurationentry.eStartActivityCode_ID,lobconfigurationentry.auxMode_ID,lobconfigurationentry.lOBConfiguration_ID,lobconfigurationentry.notificationFrequency_ID FROM LOBConfigurationEntry lobconfigurationentry WHERE lobconfigurationentry.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT lobconfigurationentry.ID FROM LOBConfigurationEntry lobconfigurationentry ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT lobconfigurationentry.ID FROM LOBConfigurationEntry lobconfigurationentry ORDER BY lobconfigurationentry.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT lobconfigurationentry.ID,lobconfigurationentry.externalID,lobconfigurationentry.durationTolerance,lobconfigurationentry.durationToleranceEnabled,lobconfigurationentry.durationToleranceInterval,lobconfigurationentry.occurrenceToleranceInterval,lobconfigurationentry.reminderInterval,lobconfigurationentry.eStartActivityCode_ID,lobconfigurationentry.auxMode_ID,lobconfigurationentry.lOBConfiguration_ID,lobconfigurationentry.notificationFrequency_ID FROM LOBConfigurationEntry lobconfigurationentry ORDER BY lobconfigurationentry.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT lobconfigurationentry.ID,lobconfigurationentry.externalID,lobconfigurationentry.durationTolerance,lobconfigurationentry.durationToleranceEnabled,lobconfigurationentry.durationToleranceInterval,lobconfigurationentry.occurrenceToleranceInterval,lobconfigurationentry.reminderInterval,lobconfigurationentry.eStartActivityCode_ID,lobconfigurationentry.auxMode_ID,lobconfigurationentry.lOBConfiguration_ID,lobconfigurationentry.notificationFrequency_ID FROM LOBConfigurationEntry lobconfigurationentry ORDER BY lobconfigurationentry.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM LOBConfigurationEntry lobconfigurationentry";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT lobconfigurationentry.ID,lobconfigurationentry.externalID,lobconfigurationentry.durationTolerance,lobconfigurationentry.durationToleranceEnabled,lobconfigurationentry.durationToleranceInterval,lobconfigurationentry.occurrenceToleranceInterval,lobconfigurationentry.reminderInterval,lobconfigurationentry.eStartActivityCode_ID,lobconfigurationentry.auxMode_ID,lobconfigurationentry.lOBConfiguration_ID,lobconfigurationentry.notificationFrequency_ID FROM LOBConfigurationEntry lobconfigurationentry WHERE lobconfigurationentry.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT lobconfigurationentry.ID FROM LOBConfigurationEntry lobconfigurationentry WHERE lobconfigurationentry.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT lobconfigurationentry.ID,lobconfigurationentry.externalID,lobconfigurationentry.durationTolerance,lobconfigurationentry.durationToleranceEnabled,lobconfigurationentry.durationToleranceInterval,lobconfigurationentry.occurrenceToleranceInterval,lobconfigurationentry.reminderInterval,lobconfigurationentry.eStartActivityCode_ID,lobconfigurationentry.auxMode_ID,lobconfigurationentry.lOBConfiguration_ID,lobconfigurationentry.notificationFrequency_ID FROM LOBConfigurationEntry lobconfigurationentry WHERE lobconfigurationentry." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT lobconfigurationentry.ID FROM LOBConfigurationEntry lobconfigurationentry WHERE lobconfigurationentry." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT lobconfigurationentry.ID FROM LOBConfigurationEntry lobconfigurationentry ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT lobconfigurationentry.ID,lobconfigurationentry.externalID,lobconfigurationentry.durationTolerance,lobconfigurationentry.durationToleranceEnabled,lobconfigurationentry.durationToleranceInterval,lobconfigurationentry.occurrenceToleranceInterval,lobconfigurationentry.reminderInterval,lobconfigurationentry.eStartActivityCode_ID,lobconfigurationentry.auxMode_ID,lobconfigurationentry.lOBConfiguration_ID,lobconfigurationentry.notificationFrequency_ID FROM LOBConfigurationEntry lobconfigurationentry ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO LOBConfigurationEntry (ID,externalID,durationTolerance,durationToleranceEnabled,durationToleranceInterval,occurrenceToleranceInterval,reminderInterval,eStartActivityCode_ID,auxMode_ID,lOBConfiguration_ID,notificationFrequency_ID) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE LOBConfigurationEntry SET externalID=?,durationTolerance=?,durationToleranceEnabled=?,durationToleranceInterval=?,occurrenceToleranceInterval=?,reminderInterval=?,eStartActivityCode_ID=?,auxMode_ID=?,lOBConfiguration_ID=?,notificationFrequency_ID=? WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM LOBConfigurationEntry WHERE ID=?";
	}
	
	@Override
	protected LOBConfigurationEntry extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	LOBConfigurationEntry nextResult = new LOBConfigurationEntry();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setExternalID(rs.getString("externalID"));

nextResult.setDurationTolerance(rs.getInt("durationTolerance"));

nextResult.setDurationToleranceEnabled(rs.getBoolean("durationToleranceEnabled"));

nextResult.setDurationToleranceInterval(rs.getInt("durationToleranceInterval"));

nextResult.setOccurrenceToleranceInterval(rs.getInt("occurrenceToleranceInterval"));

nextResult.setReminderInterval(rs.getInt("reminderInterval"));

EStartActivityCode estartactivitycode = new EStartActivityCode();
estartactivitycode.setID(rs.getString("estartactivitycode_ID"));
nextResult.setEStartActivityCode(estartactivitycode);

AuxMode auxmode = new AuxMode();
auxmode.setID(rs.getString("auxmode_ID"));
nextResult.setAuxMode(auxmode);

LOBConfiguration lobconfiguration = new LOBConfiguration();
lobconfiguration.setID(rs.getString("lobconfiguration_ID"));
nextResult.setLOBConfiguration(lobconfiguration);

NotificationFrequency notificationfrequency = new NotificationFrequency();
notificationfrequency.setID(rs.getString("notificationfrequency_ID"));
nextResult.setNotificationFrequency(notificationfrequency);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(LOBConfigurationEntry perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getExternalID());
pstmt.setInt(3, perceroObject.getDurationTolerance());
pstmt.setBoolean(4, perceroObject.getDurationToleranceEnabled());
pstmt.setInt(5, perceroObject.getDurationToleranceInterval());
pstmt.setInt(6, perceroObject.getOccurrenceToleranceInterval());
pstmt.setInt(7, perceroObject.getReminderInterval());

if (perceroObject.getEStartActivityCode() == null)
{
pstmt.setString(8, null);
}
else
{
		pstmt.setString(8, perceroObject.getEStartActivityCode().getID());
}


if (perceroObject.getAuxMode() == null)
{
pstmt.setString(9, null);
}
else
{
		pstmt.setString(9, perceroObject.getAuxMode().getID());
}


if (perceroObject.getLOBConfiguration() == null)
{
pstmt.setString(10, null);
}
else
{
		pstmt.setString(10, perceroObject.getLOBConfiguration().getID());
}


if (perceroObject.getNotificationFrequency() == null)
{
pstmt.setString(11, null);
}
else
{
		pstmt.setString(11, perceroObject.getNotificationFrequency().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(LOBConfigurationEntry perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getExternalID());
pstmt.setInt(2, perceroObject.getDurationTolerance());
pstmt.setBoolean(3, perceroObject.getDurationToleranceEnabled());
pstmt.setInt(4, perceroObject.getDurationToleranceInterval());
pstmt.setInt(5, perceroObject.getOccurrenceToleranceInterval());
pstmt.setInt(6, perceroObject.getReminderInterval());

if (perceroObject.getEStartActivityCode() == null)
{
pstmt.setString(7, null);
}
else
{
		pstmt.setString(7, perceroObject.getEStartActivityCode().getID());
}


if (perceroObject.getAuxMode() == null)
{
pstmt.setString(8, null);
}
else
{
		pstmt.setString(8, perceroObject.getAuxMode().getID());
}


if (perceroObject.getLOBConfiguration() == null)
{
pstmt.setString(9, null);
}
else
{
		pstmt.setString(9, perceroObject.getLOBConfiguration().getID());
}


if (perceroObject.getNotificationFrequency() == null)
{
pstmt.setString(10, null);
}
else
{
		pstmt.setString(10, perceroObject.getNotificationFrequency().getID());
}

pstmt.setString(11, perceroObject.getID());

		
	}

	@Override
	public List<LOBConfigurationEntry> findByExample(LOBConfigurationEntry theQueryObject,
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
sql += " durationTolerance=? ";
paramValues.add(theQueryObject.getDurationTolerance());
propertyCounter++;
}

boolean useDurationToleranceEnabled = theQueryObject.getDurationToleranceEnabled() != null && (excludeProperties == null || !excludeProperties.contains("durationToleranceEnabled"));

if (useDurationToleranceEnabled)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " durationToleranceEnabled=? ";
paramValues.add(theQueryObject.getDurationToleranceEnabled());
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
sql += " durationToleranceInterval=? ";
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
sql += " occurrenceToleranceInterval=? ";
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
sql += " reminderInterval=? ";
paramValues.add(theQueryObject.getReminderInterval());
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
sql += " notificationFrequencyID=? ";
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
	
}
