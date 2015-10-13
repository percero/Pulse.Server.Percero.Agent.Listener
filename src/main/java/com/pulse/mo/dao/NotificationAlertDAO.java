
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
import com.pulse.mo.NotificationAlert;

*/

@Component
public class NotificationAlertDAO extends SqlDataAccessObject<NotificationAlert> implements IDataAccessObject<NotificationAlert> {

	static final Logger log = Logger.getLogger(NotificationAlertDAO.class);

	
	public NotificationAlertDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(NotificationAlert.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	
	
	
	@Override
	protected String getConnectionFactoryName() {
		return NotificationAlertDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT \"NOTIFICATION_ALERT\".\"ID\" FROM \"NOTIFICATION_ALERT\" \"NOTIFICATION_ALERT\" WHERE \"NOTIFICATION_ALERT\".\"ID\"=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT \"NOTIFICATION_ALERT\".\"ID\",\"NOTIFICATION_ALERT\".\"NAME\",\"NOTIFICATION_ALERT\".\"DATE\",\"NOTIFICATION_ALERT\".\"HAS_BEEN_READ\",\"NOTIFICATION_ALERT\".\"TEAM_LEADER_ID\" FROM \"NOTIFICATION_ALERT\" \"NOTIFICATION_ALERT\" WHERE \"NOTIFICATION_ALERT\".\"ID\"=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT \"NOTIFICATION_ALERT\".\"ID\" FROM \"NOTIFICATION_ALERT\" \"NOTIFICATION_ALERT\" ORDER BY \"ID\"";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT \"NOTIFICATION_ALERT\".\"ID\" FROM \"NOTIFICATION_ALERT\" \"NOTIFICATION_ALERT\" ORDER BY \"NOTIFICATION_ALERT\".\"ID\" LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT \"NOTIFICATION_ALERT\".\"ID\",\"NOTIFICATION_ALERT\".\"NAME\",\"NOTIFICATION_ALERT\".\"DATE\",\"NOTIFICATION_ALERT\".\"HAS_BEEN_READ\",\"NOTIFICATION_ALERT\".\"TEAM_LEADER_ID\" FROM \"NOTIFICATION_ALERT\" \"NOTIFICATION_ALERT\" ORDER BY \"NOTIFICATION_ALERT\".\"ID\"";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT \"NOTIFICATION_ALERT\".\"ID\",\"NOTIFICATION_ALERT\".\"NAME\",\"NOTIFICATION_ALERT\".\"DATE\",\"NOTIFICATION_ALERT\".\"HAS_BEEN_READ\",\"NOTIFICATION_ALERT\".\"TEAM_LEADER_ID\" FROM \"NOTIFICATION_ALERT\" \"NOTIFICATION_ALERT\" ORDER BY \"NOTIFICATION_ALERT\".\"ID\" LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM \"NOTIFICATION_ALERT\" \"NOTIFICATION_ALERT\"";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT \"NOTIFICATION_ALERT\".\"ID\",\"NOTIFICATION_ALERT\".\"NAME\",\"NOTIFICATION_ALERT\".\"DATE\",\"NOTIFICATION_ALERT\".\"HAS_BEEN_READ\",\"NOTIFICATION_ALERT\".\"TEAM_LEADER_ID\" FROM \"NOTIFICATION_ALERT\" \"NOTIFICATION_ALERT\" WHERE \"NOTIFICATION_ALERT\".\"ID\" IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT \"NOTIFICATION_ALERT\".\"ID\" FROM \"NOTIFICATION_ALERT\" \"NOTIFICATION_ALERT\" WHERE \"NOTIFICATION_ALERT\".\"ID\" IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		return "SELECT \"NOTIFICATION_ALERT\".\"ID\",\"NOTIFICATION_ALERT\".\"NAME\",\"NOTIFICATION_ALERT\".\"DATE\",\"NOTIFICATION_ALERT\".\"HAS_BEEN_READ\",\"NOTIFICATION_ALERT\".\"TEAM_LEADER_ID\" FROM \"NOTIFICATION_ALERT\" \"NOTIFICATION_ALERT\" WHERE \"NOTIFICATION_ALERT\"." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT \"NOTIFICATION_ALERT\".\"ID\" FROM \"NOTIFICATION_ALERT\" \"NOTIFICATION_ALERT\" WHERE \"NOTIFICATION_ALERT\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT \"NOTIFICATION_ALERT\".\"ID\" FROM \"NOTIFICATION_ALERT\" \"NOTIFICATION_ALERT\" ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT \"NOTIFICATION_ALERT\".\"ID\",\"NOTIFICATION_ALERT\".\"NAME\",\"NOTIFICATION_ALERT\".\"DATE\",\"NOTIFICATION_ALERT\".\"HAS_BEEN_READ\",\"NOTIFICATION_ALERT\".\"TEAM_LEADER_ID\" FROM \"NOTIFICATION_ALERT\" \"NOTIFICATION_ALERT\" ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO NOTIFICATION_ALERT (\"ID\",\"NAME\",\"DATE\",\"HAS_BEEN_READ\",\"TEAM_LEADER_ID\") VALUES (?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE \"NOTIFICATION_ALERT\" SET \"NAME\"=?,\"DATE\"=?,\"HAS_BEEN_READ\"=?,\"TEAM_LEADER_ID\"=? WHERE \"ID\"=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM \"NOTIFICATION_ALERT\" WHERE \"ID\"=?";
	}
	
	@Override
	protected NotificationAlert extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	NotificationAlert nextResult = new NotificationAlert();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setName(rs.getString("NAME"));

nextResult.setDate(rs.getDate("DATE"));

nextResult.setHasBeenRead(rs.getString("HAS_BEEN_READ"));

TeamLeader teamleader = new TeamLeader();
teamleader.setID(rs.getString("TEAM_LEADER_ID"));
nextResult.setTeamLeader(teamleader);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(NotificationAlert perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getName());
pstmt.setDate(3, DateUtils.utilDateToSqlDate(perceroObject.getDate()));
pstmt.setString(4, perceroObject.getHasBeenRead());

if (perceroObject.getTeamLeader() == null)
{
pstmt.setString(5, null);
}
else
{
		pstmt.setString(5, perceroObject.getTeamLeader().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(NotificationAlert perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getName());
pstmt.setDate(2, DateUtils.utilDateToSqlDate(perceroObject.getDate()));
pstmt.setString(3, perceroObject.getHasBeenRead());

if (perceroObject.getTeamLeader() == null)
{
pstmt.setString(4, null);
}
else
{
		pstmt.setString(4, perceroObject.getTeamLeader().getID());
}

pstmt.setString(5, perceroObject.getID());

		
	}

	@Override
	public List<NotificationAlert> findByExample(NotificationAlert theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useName = StringUtils.hasText(theQueryObject.getName()) && (excludeProperties == null || !excludeProperties.contains("name"));

if (useName)
{
sql += " WHERE ";
sql += " \"NAME\" =? ";
paramValues.add(theQueryObject.getName());
propertyCounter++;
}

boolean useDate = theQueryObject.getDate() != null && (excludeProperties == null || !excludeProperties.contains("date"));

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

boolean useHasBeenRead = StringUtils.hasText(theQueryObject.getHasBeenRead()) && (excludeProperties == null || !excludeProperties.contains("hasBeenRead"));

if (useHasBeenRead)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"HAS_BEEN_READ\" =? ";
paramValues.add(theQueryObject.getHasBeenRead());
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
