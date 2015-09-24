
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
		return "SELECT notificationalert.ID FROM NotificationAlert notificationalert WHERE notificationalert.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT notificationalert.ID,notificationalert.name,notificationalert.date,notificationalert.externalID,notificationalert.hasBeenRead,notificationalert.teamLeader_ID FROM NotificationAlert notificationalert WHERE notificationalert.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT notificationalert.ID FROM NotificationAlert notificationalert ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT notificationalert.ID FROM NotificationAlert notificationalert ORDER BY notificationalert.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT notificationalert.ID,notificationalert.name,notificationalert.date,notificationalert.externalID,notificationalert.hasBeenRead,notificationalert.teamLeader_ID FROM NotificationAlert notificationalert ORDER BY notificationalert.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT notificationalert.ID,notificationalert.name,notificationalert.date,notificationalert.externalID,notificationalert.hasBeenRead,notificationalert.teamLeader_ID FROM NotificationAlert notificationalert ORDER BY notificationalert.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM NotificationAlert notificationalert";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT notificationalert.ID,notificationalert.name,notificationalert.date,notificationalert.externalID,notificationalert.hasBeenRead,notificationalert.teamLeader_ID FROM NotificationAlert notificationalert WHERE notificationalert.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT notificationalert.ID FROM NotificationAlert notificationalert WHERE notificationalert.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT notificationalert.ID,notificationalert.name,notificationalert.date,notificationalert.externalID,notificationalert.hasBeenRead,notificationalert.teamLeader_ID FROM NotificationAlert notificationalert WHERE notificationalert." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT notificationalert.ID FROM NotificationAlert notificationalert WHERE notificationalert." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT notificationalert.ID FROM NotificationAlert notificationalert ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT notificationalert.ID,notificationalert.name,notificationalert.date,notificationalert.externalID,notificationalert.hasBeenRead,notificationalert.teamLeader_ID FROM NotificationAlert notificationalert ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO NotificationAlert (ID,name,date,externalID,hasBeenRead,teamLeader_ID) VALUES (?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE NotificationAlert SET name=?,date=?,externalID=?,hasBeenRead=?,teamLeader_ID=? WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM NotificationAlert WHERE ID=?";
	}
	
	@Override
	protected NotificationAlert extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	NotificationAlert nextResult = new NotificationAlert();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setName(rs.getString("name"));

nextResult.setDate(rs.getDate("date"));

nextResult.setExternalID(rs.getString("externalID"));

nextResult.setHasBeenRead(rs.getString("hasBeenRead"));

TeamLeader teamleader = new TeamLeader();
teamleader.setID(rs.getString("teamleader_ID"));
nextResult.setTeamLeader(teamleader);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(NotificationAlert perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getName());
pstmt.setDate(3, DateUtils.utilDateToSqlDate(perceroObject.getDate()));
pstmt.setString(4, perceroObject.getExternalID());
pstmt.setString(5, perceroObject.getHasBeenRead());

if (perceroObject.getTeamLeader() == null)
{
pstmt.setString(6, null);
}
else
{
		pstmt.setString(6, perceroObject.getTeamLeader().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(NotificationAlert perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getName());
pstmt.setDate(2, DateUtils.utilDateToSqlDate(perceroObject.getDate()));
pstmt.setString(3, perceroObject.getExternalID());
pstmt.setString(4, perceroObject.getHasBeenRead());

if (perceroObject.getTeamLeader() == null)
{
pstmt.setString(5, null);
}
else
{
		pstmt.setString(5, perceroObject.getTeamLeader().getID());
}

pstmt.setString(6, perceroObject.getID());

		
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
sql += " date=? ";
paramValues.add(theQueryObject.getDate());
propertyCounter++;
}

boolean useExternalID = StringUtils.hasText(theQueryObject.getExternalID()) && (excludeProperties == null || !excludeProperties.contains("externalID"));

if (useExternalID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " externalID=? ";
paramValues.add(theQueryObject.getExternalID());
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
sql += " hasBeenRead=? ";
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
sql += " teamLeaderID=? ";
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
