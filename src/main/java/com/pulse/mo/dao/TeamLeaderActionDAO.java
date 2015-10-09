
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
import com.pulse.mo.TeamLeaderAction;
import com.pulse.mo.TeamLeader;

*/

@Component
public class TeamLeaderActionDAO extends SqlDataAccessObject<TeamLeaderAction> implements IDataAccessObject<TeamLeaderAction> {

	static final Logger log = Logger.getLogger(TeamLeaderActionDAO.class);

	
	public TeamLeaderActionDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(TeamLeaderAction.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	@Override
	protected String getConnectionFactoryName() {
		return TeamLeaderActionDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT TEAM_LEADER_ACTION.ID FROM TEAM_LEADER_ACTION TEAM_LEADER_ACTION WHERE TEAM_LEADER_ACTION.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT TEAM_LEADER_ACTION.ID,TEAM_LEADER_ACTION.NAME,TEAM_LEADER_ACTION.TEAM_LEADER_ID FROM TEAM_LEADER_ACTION TEAM_LEADER_ACTION WHERE TEAM_LEADER_ACTION.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT TEAM_LEADER_ACTION.ID FROM TEAM_LEADER_ACTION TEAM_LEADER_ACTION ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT TEAM_LEADER_ACTION.ID FROM TEAM_LEADER_ACTION TEAM_LEADER_ACTION ORDER BY TEAM_LEADER_ACTION.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT TEAM_LEADER_ACTION.ID,TEAM_LEADER_ACTION.NAME,TEAM_LEADER_ACTION.TEAM_LEADER_ID FROM TEAM_LEADER_ACTION TEAM_LEADER_ACTION ORDER BY TEAM_LEADER_ACTION.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT TEAM_LEADER_ACTION.ID,TEAM_LEADER_ACTION.NAME,TEAM_LEADER_ACTION.TEAM_LEADER_ID FROM TEAM_LEADER_ACTION TEAM_LEADER_ACTION ORDER BY TEAM_LEADER_ACTION.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM TEAM_LEADER_ACTION TEAM_LEADER_ACTION";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT TEAM_LEADER_ACTION.ID,TEAM_LEADER_ACTION.NAME,TEAM_LEADER_ACTION.TEAM_LEADER_ID FROM TEAM_LEADER_ACTION TEAM_LEADER_ACTION WHERE TEAM_LEADER_ACTION.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT TEAM_LEADER_ACTION.ID FROM TEAM_LEADER_ACTION TEAM_LEADER_ACTION WHERE TEAM_LEADER_ACTION.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT TEAM_LEADER_ACTION.ID,TEAM_LEADER_ACTION.NAME,TEAM_LEADER_ACTION.TEAM_LEADER_ID FROM TEAM_LEADER_ACTION TEAM_LEADER_ACTION WHERE TEAM_LEADER_ACTION." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT TEAM_LEADER_ACTION.ID FROM TEAM_LEADER_ACTION TEAM_LEADER_ACTION WHERE TEAM_LEADER_ACTION." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT TEAM_LEADER_ACTION.ID FROM TEAM_LEADER_ACTION TEAM_LEADER_ACTION ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT TEAM_LEADER_ACTION.ID,TEAM_LEADER_ACTION.NAME,TEAM_LEADER_ACTION.TEAM_LEADER_ID FROM TEAM_LEADER_ACTION TEAM_LEADER_ACTION ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO TEAM_LEADER_ACTION (ID,NAME,TEAM_LEADER_ID) VALUES (?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE TEAM_LEADER_ACTION SET NAME=?,TEAM_LEADER_ID=? WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM TEAM_LEADER_ACTION WHERE ID=?";
	}
	
	@Override
	protected TeamLeaderAction extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	TeamLeaderAction nextResult = new TeamLeaderAction();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setName(rs.getString("NAME"));

TeamLeader teamleader = new TeamLeader();
teamleader.setID(rs.getString("TEAM_LEADER_ID"));
nextResult.setTeamLeader(teamleader);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(TeamLeaderAction perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getName());

if (perceroObject.getTeamLeader() == null)
{
pstmt.setString(3, null);
}
else
{
		pstmt.setString(3, perceroObject.getTeamLeader().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(TeamLeaderAction perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getName());

if (perceroObject.getTeamLeader() == null)
{
pstmt.setString(2, null);
}
else
{
		pstmt.setString(2, perceroObject.getTeamLeader().getID());
}

pstmt.setString(3, perceroObject.getID());

		
	}

	@Override
	public List<TeamLeaderAction> findByExample(TeamLeaderAction theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useName = StringUtils.hasText(theQueryObject.getName()) && (excludeProperties == null || !excludeProperties.contains("name"));

if (useName)
{
sql += " WHERE ";
sql += " NAME=? ";
paramValues.add(theQueryObject.getName());
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
sql += " TEAM_LEADER_ID=? ";
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
