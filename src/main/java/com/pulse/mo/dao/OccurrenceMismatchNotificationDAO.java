


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
import com.pulse.mo.OccurrenceMismatchNotification;

*/

@Component
public class OccurrenceMismatchNotificationDAO extends SqlDataAccessObject<OccurrenceMismatchNotification> implements IDataAccessObject<OccurrenceMismatchNotification> {

	static final Logger log = Logger.getLogger(OccurrenceMismatchNotificationDAO.class);

	
	public OccurrenceMismatchNotificationDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(OccurrenceMismatchNotification.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	
	
	
	@Override
	protected String getConnectionFactoryName() {
		return OccurrenceMismatchNotificationDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT \"OCCURRENCE_MISMATCH_NOTIF\".\"ID\" FROM \"OCCURRENCE_MISMATCH_NOTIF\" \"OCCURRENCE_MISMATCH_NOTIF\" WHERE \"OCCURRENCE_MISMATCH_NOTIF\".\"ID\"=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT \"OCCURRENCE_MISMATCH_NOTIF\".\"ID\",\"OCCURRENCE_MISMATCH_NOTIF\".\"MESSAGE\",\"OCCURRENCE_MISMATCH_NOTIF\".\"NAME\",\"OCCURRENCE_MISMATCH_NOTIF\".\"AUX_CODE_ENTRY_NAME\",\"OCCURRENCE_MISMATCH_NOTIF\".\"AUX_MODE_EVENT_COUNT\",\"OCCURRENCE_MISMATCH_NOTIF\".\"DATE\",\"OCCURRENCE_MISMATCH_NOTIF\".\"TIMECARD_ACTIVITY_EVENT_COUNT\",\"OCCURRENCE_MISMATCH_NOTIF\".\"TIMECARD_ACTIVITY_NAME\",\"OCCURRENCE_MISMATCH_NOTIF\".\"TYPE\",\"OCCURRENCE_MISMATCH_NOTIF\".\"AGENT_ID\",\"OCCURRENCE_MISMATCH_NOTIF\".\"LOB_CONFIGURATION_ID\",\"OCCURRENCE_MISMATCH_NOTIF\".\"TEAM_LEADER_ID\" FROM \"OCCURRENCE_MISMATCH_NOTIF\" \"OCCURRENCE_MISMATCH_NOTIF\" WHERE \"OCCURRENCE_MISMATCH_NOTIF\".\"ID\"=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT \"OCCURRENCE_MISMATCH_NOTIF\".\"ID\" FROM \"OCCURRENCE_MISMATCH_NOTIF\" \"OCCURRENCE_MISMATCH_NOTIF\" ORDER BY \"ID\"";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT \"OCCURRENCE_MISMATCH_NOTIF\".\"ID\" FROM \"OCCURRENCE_MISMATCH_NOTIF\" \"OCCURRENCE_MISMATCH_NOTIF\" ORDER BY \"OCCURRENCE_MISMATCH_NOTIF\".\"ID\" LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT \"OCCURRENCE_MISMATCH_NOTIF\".\"ID\",\"OCCURRENCE_MISMATCH_NOTIF\".\"MESSAGE\",\"OCCURRENCE_MISMATCH_NOTIF\".\"NAME\",\"OCCURRENCE_MISMATCH_NOTIF\".\"AUX_CODE_ENTRY_NAME\",\"OCCURRENCE_MISMATCH_NOTIF\".\"AUX_MODE_EVENT_COUNT\",\"OCCURRENCE_MISMATCH_NOTIF\".\"DATE\",\"OCCURRENCE_MISMATCH_NOTIF\".\"TIMECARD_ACTIVITY_EVENT_COUNT\",\"OCCURRENCE_MISMATCH_NOTIF\".\"TIMECARD_ACTIVITY_NAME\",\"OCCURRENCE_MISMATCH_NOTIF\".\"TYPE\",\"OCCURRENCE_MISMATCH_NOTIF\".\"AGENT_ID\",\"OCCURRENCE_MISMATCH_NOTIF\".\"LOB_CONFIGURATION_ID\",\"OCCURRENCE_MISMATCH_NOTIF\".\"TEAM_LEADER_ID\" FROM \"OCCURRENCE_MISMATCH_NOTIF\" \"OCCURRENCE_MISMATCH_NOTIF\" ORDER BY \"OCCURRENCE_MISMATCH_NOTIF\".\"ID\"";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT \"OCCURRENCE_MISMATCH_NOTIF\".\"ID\",\"OCCURRENCE_MISMATCH_NOTIF\".\"MESSAGE\",\"OCCURRENCE_MISMATCH_NOTIF\".\"NAME\",\"OCCURRENCE_MISMATCH_NOTIF\".\"AUX_CODE_ENTRY_NAME\",\"OCCURRENCE_MISMATCH_NOTIF\".\"AUX_MODE_EVENT_COUNT\",\"OCCURRENCE_MISMATCH_NOTIF\".\"DATE\",\"OCCURRENCE_MISMATCH_NOTIF\".\"TIMECARD_ACTIVITY_EVENT_COUNT\",\"OCCURRENCE_MISMATCH_NOTIF\".\"TIMECARD_ACTIVITY_NAME\",\"OCCURRENCE_MISMATCH_NOTIF\".\"TYPE\",\"OCCURRENCE_MISMATCH_NOTIF\".\"AGENT_ID\",\"OCCURRENCE_MISMATCH_NOTIF\".\"LOB_CONFIGURATION_ID\",\"OCCURRENCE_MISMATCH_NOTIF\".\"TEAM_LEADER_ID\" FROM \"OCCURRENCE_MISMATCH_NOTIF\" \"OCCURRENCE_MISMATCH_NOTIF\" ORDER BY \"OCCURRENCE_MISMATCH_NOTIF\".\"ID\" LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM \"OCCURRENCE_MISMATCH_NOTIF\" \"OCCURRENCE_MISMATCH_NOTIF\"";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT \"OCCURRENCE_MISMATCH_NOTIF\".\"ID\",\"OCCURRENCE_MISMATCH_NOTIF\".\"MESSAGE\",\"OCCURRENCE_MISMATCH_NOTIF\".\"NAME\",\"OCCURRENCE_MISMATCH_NOTIF\".\"AUX_CODE_ENTRY_NAME\",\"OCCURRENCE_MISMATCH_NOTIF\".\"AUX_MODE_EVENT_COUNT\",\"OCCURRENCE_MISMATCH_NOTIF\".\"DATE\",\"OCCURRENCE_MISMATCH_NOTIF\".\"TIMECARD_ACTIVITY_EVENT_COUNT\",\"OCCURRENCE_MISMATCH_NOTIF\".\"TIMECARD_ACTIVITY_NAME\",\"OCCURRENCE_MISMATCH_NOTIF\".\"TYPE\",\"OCCURRENCE_MISMATCH_NOTIF\".\"AGENT_ID\",\"OCCURRENCE_MISMATCH_NOTIF\".\"LOB_CONFIGURATION_ID\",\"OCCURRENCE_MISMATCH_NOTIF\".\"TEAM_LEADER_ID\" FROM \"OCCURRENCE_MISMATCH_NOTIF\" \"OCCURRENCE_MISMATCH_NOTIF\" WHERE \"OCCURRENCE_MISMATCH_NOTIF\".\"ID\" IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT \"OCCURRENCE_MISMATCH_NOTIF\".\"ID\" FROM \"OCCURRENCE_MISMATCH_NOTIF\" \"OCCURRENCE_MISMATCH_NOTIF\" WHERE \"OCCURRENCE_MISMATCH_NOTIF\".\"ID\" IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		return "SELECT \"OCCURRENCE_MISMATCH_NOTIF\".\"ID\",\"OCCURRENCE_MISMATCH_NOTIF\".\"MESSAGE\",\"OCCURRENCE_MISMATCH_NOTIF\".\"NAME\",\"OCCURRENCE_MISMATCH_NOTIF\".\"AUX_CODE_ENTRY_NAME\",\"OCCURRENCE_MISMATCH_NOTIF\".\"AUX_MODE_EVENT_COUNT\",\"OCCURRENCE_MISMATCH_NOTIF\".\"DATE\",\"OCCURRENCE_MISMATCH_NOTIF\".\"TIMECARD_ACTIVITY_EVENT_COUNT\",\"OCCURRENCE_MISMATCH_NOTIF\".\"TIMECARD_ACTIVITY_NAME\",\"OCCURRENCE_MISMATCH_NOTIF\".\"TYPE\",\"OCCURRENCE_MISMATCH_NOTIF\".\"AGENT_ID\",\"OCCURRENCE_MISMATCH_NOTIF\".\"LOB_CONFIGURATION_ID\",\"OCCURRENCE_MISMATCH_NOTIF\".\"TEAM_LEADER_ID\" FROM \"OCCURRENCE_MISMATCH_NOTIF\" \"OCCURRENCE_MISMATCH_NOTIF\" WHERE \"OCCURRENCE_MISMATCH_NOTIF\"." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT \"OCCURRENCE_MISMATCH_NOTIF\".\"ID\" FROM \"OCCURRENCE_MISMATCH_NOTIF\" \"OCCURRENCE_MISMATCH_NOTIF\" WHERE \"OCCURRENCE_MISMATCH_NOTIF\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT \"OCCURRENCE_MISMATCH_NOTIF\".\"ID\" FROM \"OCCURRENCE_MISMATCH_NOTIF\" \"OCCURRENCE_MISMATCH_NOTIF\" ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT \"OCCURRENCE_MISMATCH_NOTIF\".\"ID\",\"OCCURRENCE_MISMATCH_NOTIF\".\"MESSAGE\",\"OCCURRENCE_MISMATCH_NOTIF\".\"NAME\",\"OCCURRENCE_MISMATCH_NOTIF\".\"AUX_CODE_ENTRY_NAME\",\"OCCURRENCE_MISMATCH_NOTIF\".\"AUX_MODE_EVENT_COUNT\",\"OCCURRENCE_MISMATCH_NOTIF\".\"DATE\",\"OCCURRENCE_MISMATCH_NOTIF\".\"TIMECARD_ACTIVITY_EVENT_COUNT\",\"OCCURRENCE_MISMATCH_NOTIF\".\"TIMECARD_ACTIVITY_NAME\",\"OCCURRENCE_MISMATCH_NOTIF\".\"TYPE\",\"OCCURRENCE_MISMATCH_NOTIF\".\"AGENT_ID\",\"OCCURRENCE_MISMATCH_NOTIF\".\"LOB_CONFIGURATION_ID\",\"OCCURRENCE_MISMATCH_NOTIF\".\"TEAM_LEADER_ID\" FROM \"OCCURRENCE_MISMATCH_NOTIF\" \"OCCURRENCE_MISMATCH_NOTIF\" ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO OCCURRENCE_MISMATCH_NOTIF (\"ID\",\"MESSAGE\",\"NAME\",\"AUX_CODE_ENTRY_NAME\",\"AUX_MODE_EVENT_COUNT\",\"DATE\",\"TIMECARD_ACTIVITY_EVENT_COUNT\",\"TIMECARD_ACTIVITY_NAME\",\"TYPE\",\"AGENT_ID\",\"LOB_CONFIGURATION_ID\",\"TEAM_LEADER_ID\") VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE \"OCCURRENCE_MISMATCH_NOTIF\" SET \"MESSAGE\"=?,\"NAME\"=?,\"AUX_CODE_ENTRY_NAME\"=?,\"AUX_MODE_EVENT_COUNT\"=?,\"DATE\"=?,\"TIMECARD_ACTIVITY_EVENT_COUNT\"=?,\"TIMECARD_ACTIVITY_NAME\"=?,\"TYPE\"=?,\"AGENT_ID\"=?,\"LOB_CONFIGURATION_ID\"=?,\"TEAM_LEADER_ID\"=? WHERE \"ID\"=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM \"OCCURRENCE_MISMATCH_NOTIF\" WHERE \"ID\"=?";
	}
	
	@Override
	protected OccurrenceMismatchNotification extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	OccurrenceMismatchNotification nextResult = new OccurrenceMismatchNotification();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setMessage(rs.getString("MESSAGE"));

nextResult.setName(rs.getString("NAME"));

nextResult.setAuxCodeEntryName(rs.getString("AUX_CODE_ENTRY_NAME"));

nextResult.setAuxModeEventCount(rs.getInt("AUX_MODE_EVENT_COUNT"));

nextResult.setDate(rs.getString("DATE"));

nextResult.setTimecardActivityEventCount(rs.getInt("TIMECARD_ACTIVITY_EVENT_COUNT"));

nextResult.setTimecardActivityName(rs.getString("TIMECARD_ACTIVITY_NAME"));

nextResult.setType(rs.getString("TYPE"));

Agent agent = new Agent();
agent.setID(rs.getString("AGENT_ID"));
nextResult.setAgent(agent);

LOBConfiguration lobconfiguration = new LOBConfiguration();
lobconfiguration.setID(rs.getString("LOB_CONFIGURATION_ID"));
nextResult.setLOBConfiguration(lobconfiguration);

TeamLeader teamleader = new TeamLeader();
teamleader.setID(rs.getString("TEAM_LEADER_ID"));
nextResult.setTeamLeader(teamleader);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(OccurrenceMismatchNotification perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getMessage());
pstmt.setString(3, perceroObject.getName());
pstmt.setString(4, perceroObject.getAuxCodeEntryName());
pstmt.setInt(5, perceroObject.getAuxModeEventCount());
pstmt.setString(6, perceroObject.getDate());
pstmt.setInt(7, perceroObject.getTimecardActivityEventCount());
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


if (perceroObject.getTeamLeader() == null)
{
pstmt.setString(12, null);
}
else
{
		pstmt.setString(12, perceroObject.getTeamLeader().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(OccurrenceMismatchNotification perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getMessage());
pstmt.setString(2, perceroObject.getName());
pstmt.setString(3, perceroObject.getAuxCodeEntryName());
pstmt.setInt(4, perceroObject.getAuxModeEventCount());
pstmt.setString(5, perceroObject.getDate());
pstmt.setInt(6, perceroObject.getTimecardActivityEventCount());
pstmt.setString(7, perceroObject.getTimecardActivityName());
pstmt.setString(8, perceroObject.getType());

if (perceroObject.getAgent() == null)
{
pstmt.setString(9, null);
}
else
{
		pstmt.setString(9, perceroObject.getAgent().getID());
}


if (perceroObject.getLOBConfiguration() == null)
{
pstmt.setString(10, null);
}
else
{
		pstmt.setString(10, perceroObject.getLOBConfiguration().getID());
}


if (perceroObject.getTeamLeader() == null)
{
pstmt.setString(11, null);
}
else
{
		pstmt.setString(11, perceroObject.getTeamLeader().getID());
}

pstmt.setString(12, perceroObject.getID());

		
	}

	@Override
	public List<OccurrenceMismatchNotification> findByExample(OccurrenceMismatchNotification theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useMessage = StringUtils.hasText(theQueryObject.getMessage()) && (excludeProperties == null || !excludeProperties.contains("message"));

if (useMessage)
{
sql += " WHERE ";
sql += " \"MESSAGE\" =? ";
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
sql += " \"NAME\" =? ";
paramValues.add(theQueryObject.getName());
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
sql += " \"AUX_CODE_ENTRY_NAME\" =? ";
paramValues.add(theQueryObject.getAuxCodeEntryName());
propertyCounter++;
}

boolean useAuxModeEventCount = theQueryObject.getAuxModeEventCount() != null && (excludeProperties == null || !excludeProperties.contains("auxModeEventCount"));

if (useAuxModeEventCount)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"AUX_MODE_EVENT_COUNT\" =? ";
paramValues.add(theQueryObject.getAuxModeEventCount());
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
sql += " \"DATE\" =? ";
paramValues.add(theQueryObject.getDate());
propertyCounter++;
}

boolean useTimecardActivityEventCount = theQueryObject.getTimecardActivityEventCount() != null && (excludeProperties == null || !excludeProperties.contains("timecardActivityEventCount"));

if (useTimecardActivityEventCount)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"TIMECARD_ACTIVITY_EVENT_COUNT\" =? ";
paramValues.add(theQueryObject.getTimecardActivityEventCount());
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
sql += " \"TIMECARD_ACTIVITY_NAME\" =? ";
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
sql += " \"TYPE\" =? ";
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
sql += " \"AGENT_ID\" =? ";
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
sql += " \"LOB_CONFIGURATION_ID\" =? ";
paramValues.add(theQueryObject.getLOBConfiguration().getID());
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
sql += " \"TEAM_LEADER_ID\" =? ";
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
