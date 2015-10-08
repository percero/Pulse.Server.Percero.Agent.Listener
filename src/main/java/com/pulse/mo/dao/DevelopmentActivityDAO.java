
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
import com.pulse.mo.DevelopmentActivity;
import com.pulse.mo.TeamLeader;

*/

@Component
public class DevelopmentActivityDAO extends SqlDataAccessObject<DevelopmentActivity> implements IDataAccessObject<DevelopmentActivity> {

	static final Logger log = Logger.getLogger(DevelopmentActivityDAO.class);

	
	public DevelopmentActivityDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(DevelopmentActivity.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	@Override
	protected String getConnectionFactoryName() {
		return DevelopmentActivityDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT DEVELOPMENT_ACTIVITY.ID FROM DEVELOPMENT_ACTIVITY DEVELOPMENT_ACTIVITY WHERE DEVELOPMENT_ACTIVITY.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT DEVELOPMENT_ACTIVITY.ID,DEVELOPMENT_ACTIVITY.DUE_DATE,DEVELOPMENT_ACTIVITY.NAME,DEVELOPMENT_ACTIVITY.TEAM_LEADER_ID FROM DEVELOPMENT_ACTIVITY DEVELOPMENT_ACTIVITY WHERE DEVELOPMENT_ACTIVITY.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT DEVELOPMENT_ACTIVITY.ID FROM DEVELOPMENT_ACTIVITY DEVELOPMENT_ACTIVITY ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT DEVELOPMENT_ACTIVITY.ID FROM DEVELOPMENT_ACTIVITY DEVELOPMENT_ACTIVITY ORDER BY DEVELOPMENT_ACTIVITY.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT DEVELOPMENT_ACTIVITY.ID,DEVELOPMENT_ACTIVITY.DUE_DATE,DEVELOPMENT_ACTIVITY.NAME,DEVELOPMENT_ACTIVITY.TEAM_LEADER_ID FROM DEVELOPMENT_ACTIVITY DEVELOPMENT_ACTIVITY ORDER BY DEVELOPMENT_ACTIVITY.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT DEVELOPMENT_ACTIVITY.ID,DEVELOPMENT_ACTIVITY.DUE_DATE,DEVELOPMENT_ACTIVITY.NAME,DEVELOPMENT_ACTIVITY.TEAM_LEADER_ID FROM DEVELOPMENT_ACTIVITY DEVELOPMENT_ACTIVITY ORDER BY DEVELOPMENT_ACTIVITY.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM DEVELOPMENT_ACTIVITY DEVELOPMENT_ACTIVITY";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT DEVELOPMENT_ACTIVITY.ID,DEVELOPMENT_ACTIVITY.DUE_DATE,DEVELOPMENT_ACTIVITY.NAME,DEVELOPMENT_ACTIVITY.TEAM_LEADER_ID FROM DEVELOPMENT_ACTIVITY DEVELOPMENT_ACTIVITY WHERE DEVELOPMENT_ACTIVITY.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT DEVELOPMENT_ACTIVITY.ID FROM DEVELOPMENT_ACTIVITY DEVELOPMENT_ACTIVITY WHERE DEVELOPMENT_ACTIVITY.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT DEVELOPMENT_ACTIVITY.ID,DEVELOPMENT_ACTIVITY.DUE_DATE,DEVELOPMENT_ACTIVITY.NAME,DEVELOPMENT_ACTIVITY.TEAM_LEADER_ID FROM DEVELOPMENT_ACTIVITY DEVELOPMENT_ACTIVITY WHERE DEVELOPMENT_ACTIVITY." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT DEVELOPMENT_ACTIVITY.ID FROM DEVELOPMENT_ACTIVITY DEVELOPMENT_ACTIVITY WHERE DEVELOPMENT_ACTIVITY." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT DEVELOPMENT_ACTIVITY.ID FROM DEVELOPMENT_ACTIVITY DEVELOPMENT_ACTIVITY ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT DEVELOPMENT_ACTIVITY.ID,DEVELOPMENT_ACTIVITY.DUE_DATE,DEVELOPMENT_ACTIVITY.NAME,DEVELOPMENT_ACTIVITY.TEAM_LEADER_ID FROM DEVELOPMENT_ACTIVITY DEVELOPMENT_ACTIVITY ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO DEVELOPMENT_ACTIVITY (ID,DUE_DATE,NAME,TEAM_LEADER_ID) VALUES (?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE DEVELOPMENT_ACTIVITY SET DUE_DATE=?,NAME=?,TEAM_LEADER_ID WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM DEVELOPMENT_ACTIVITY WHERE ID=?";
	}
	
	@Override
	protected DevelopmentActivity extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	DevelopmentActivity nextResult = new DevelopmentActivity();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setDueDate(rs.getDate("DUE_DATE"));

nextResult.setName(rs.getString("NAME"));

TeamLeader teamleader = new TeamLeader();
teamleader.setID(rs.getString("TEAM_LEADER_ID"));
nextResult.setTeamLeader(teamleader);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(DevelopmentActivity perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setDate(2, DateUtils.utilDateToSqlDate(perceroObject.getDueDate()));
pstmt.setString(3, perceroObject.getName());

if (perceroObject.getTeamLeader() == null)
{
pstmt.setString(4, null);
}
else
{
		pstmt.setString(4, perceroObject.getTeamLeader().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(DevelopmentActivity perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setDate(1, DateUtils.utilDateToSqlDate(perceroObject.getDueDate()));
pstmt.setString(2, perceroObject.getName());

if (perceroObject.getTeamLeader() == null)
{
pstmt.setString(3, null);
}
else
{
		pstmt.setString(3, perceroObject.getTeamLeader().getID());
}

pstmt.setString(4, perceroObject.getID());

		
	}

	@Override
	public List<DevelopmentActivity> findByExample(DevelopmentActivity theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useDueDate = theQueryObject.getDueDate() != null && (excludeProperties == null || !excludeProperties.contains("dueDate"));

if (useDueDate)
{
sql += " WHERE ";
sql += " DUE_DATE=? ";
paramValues.add(theQueryObject.getDueDate());
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
