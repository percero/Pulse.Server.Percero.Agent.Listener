
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
import com.pulse.mo.Notification;
import com.pulse.mo.TeamLeader;

*/

@Component
public class NotificationDAO extends SqlDataAccessObject<Notification> implements IDataAccessObject<Notification> {

	static final Logger log = Logger.getLogger(NotificationDAO.class);

	
	public NotificationDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(Notification.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	
	
	
	@Override
	protected String getConnectionFactoryName() {
		return NotificationDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT \"NOTIFICATION\".\"ID\" FROM \"NOTIFICATION\" \"NOTIFICATION\" WHERE \"NOTIFICATION\".\"ID\"=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT \"NOTIFICATION\".\"ID\",\"NOTIFICATION\".\"DATE\",\"NOTIFICATION\".\"NAME\",\"NOTIFICATION\".\"TYPE\",\"NOTIFICATION\".\"TEAM_LEADER_ID\" FROM \"NOTIFICATION\" \"NOTIFICATION\" WHERE \"NOTIFICATION\".\"ID\"=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT \"NOTIFICATION\".\"ID\" FROM \"NOTIFICATION\" \"NOTIFICATION\" ORDER BY \"ID\"";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT \"NOTIFICATION\".\"ID\" FROM \"NOTIFICATION\" \"NOTIFICATION\" ORDER BY \"NOTIFICATION\".\"ID\" LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT \"NOTIFICATION\".\"ID\",\"NOTIFICATION\".\"DATE\",\"NOTIFICATION\".\"NAME\",\"NOTIFICATION\".\"TYPE\",\"NOTIFICATION\".\"TEAM_LEADER_ID\" FROM \"NOTIFICATION\" \"NOTIFICATION\" ORDER BY \"NOTIFICATION\".\"ID\"";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT \"NOTIFICATION\".\"ID\",\"NOTIFICATION\".\"DATE\",\"NOTIFICATION\".\"NAME\",\"NOTIFICATION\".\"TYPE\",\"NOTIFICATION\".\"TEAM_LEADER_ID\" FROM \"NOTIFICATION\" \"NOTIFICATION\" ORDER BY \"NOTIFICATION\".\"ID\" LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM \"NOTIFICATION\" \"NOTIFICATION\"";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT \"NOTIFICATION\".\"ID\",\"NOTIFICATION\".\"DATE\",\"NOTIFICATION\".\"NAME\",\"NOTIFICATION\".\"TYPE\",\"NOTIFICATION\".\"TEAM_LEADER_ID\" FROM \"NOTIFICATION\" \"NOTIFICATION\" WHERE \"NOTIFICATION\".\"ID\" IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT \"NOTIFICATION\".\"ID\" FROM \"NOTIFICATION\" \"NOTIFICATION\" WHERE \"NOTIFICATION\".\"ID\" IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		return "SELECT \"NOTIFICATION\".\"ID\",\"NOTIFICATION\".\"DATE\",\"NOTIFICATION\".\"NAME\",\"NOTIFICATION\".\"TYPE\",\"NOTIFICATION\".\"TEAM_LEADER_ID\" FROM \"NOTIFICATION\" \"NOTIFICATION\" WHERE \"NOTIFICATION\"." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT \"NOTIFICATION\".\"ID\" FROM \"NOTIFICATION\" \"NOTIFICATION\" WHERE \"NOTIFICATION\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT \"NOTIFICATION\".\"ID\" FROM \"NOTIFICATION\" \"NOTIFICATION\" ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT \"NOTIFICATION\".\"ID\",\"NOTIFICATION\".\"DATE\",\"NOTIFICATION\".\"NAME\",\"NOTIFICATION\".\"TYPE\",\"NOTIFICATION\".\"TEAM_LEADER_ID\" FROM \"NOTIFICATION\" \"NOTIFICATION\" ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO NOTIFICATION (\"ID\",\"DATE\",\"NAME\",\"TYPE\",\"TEAM_LEADER_ID\") VALUES (?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE \"NOTIFICATION\" SET \"DATE\"=?,\"NAME\"=?,\"TYPE\"=?,\"TEAM_LEADER_ID\"=? WHERE \"ID\"=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM \"NOTIFICATION\" WHERE \"ID\"=?";
	}
	
	@Override
	protected Notification extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	Notification nextResult = new Notification();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setDate(rs.getString("DATE"));

nextResult.setName(rs.getString("NAME"));

nextResult.setType(rs.getString("TYPE"));

TeamLeader teamleader = new TeamLeader();
teamleader.setID(rs.getString("TEAM_LEADER_ID"));
nextResult.setTeamLeader(teamleader);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(Notification perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getDate());
pstmt.setString(3, perceroObject.getName());
pstmt.setString(4, perceroObject.getType());

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
	protected void setPreparedStatmentUpdateParams(Notification perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getDate());
pstmt.setString(2, perceroObject.getName());
pstmt.setString(3, perceroObject.getType());

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
	public List<Notification> findByExample(Notification theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useDate = StringUtils.hasText(theQueryObject.getDate()) && (excludeProperties == null || !excludeProperties.contains("date"));

if (useDate)
{
sql += " WHERE ";
sql += " \"DATE\" =? ";
paramValues.add(theQueryObject.getDate());
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
