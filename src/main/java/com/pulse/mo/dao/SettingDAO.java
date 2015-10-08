
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
import com.pulse.mo.Setting;
import com.pulse.mo.TeamLeader;

*/

@Component
public class SettingDAO extends SqlDataAccessObject<Setting> implements IDataAccessObject<Setting> {

	static final Logger log = Logger.getLogger(SettingDAO.class);

	
	public SettingDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(Setting.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	@Override
	protected String getConnectionFactoryName() {
		return SettingDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT SETTING.ID FROM SETTING SETTING WHERE SETTING.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT SETTING.ID,SETTING.VALUE,SETTING.NAME,SETTING.TEAM_LEADER_ID FROM SETTING SETTING WHERE SETTING.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT SETTING.ID FROM SETTING SETTING ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT SETTING.ID FROM SETTING SETTING ORDER BY SETTING.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT SETTING.ID,SETTING.VALUE,SETTING.NAME,SETTING.TEAM_LEADER_ID FROM SETTING SETTING ORDER BY SETTING.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT SETTING.ID,SETTING.VALUE,SETTING.NAME,SETTING.TEAM_LEADER_ID FROM SETTING SETTING ORDER BY SETTING.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM SETTING SETTING";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT SETTING.ID,SETTING.VALUE,SETTING.NAME,SETTING.TEAM_LEADER_ID FROM SETTING SETTING WHERE SETTING.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT SETTING.ID FROM SETTING SETTING WHERE SETTING.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT SETTING.ID,SETTING.VALUE,SETTING.NAME,SETTING.TEAM_LEADER_ID FROM SETTING SETTING WHERE SETTING." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT SETTING.ID FROM SETTING SETTING WHERE SETTING." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT SETTING.ID FROM SETTING SETTING ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT SETTING.ID,SETTING.VALUE,SETTING.NAME,SETTING.TEAM_LEADER_ID FROM SETTING SETTING ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO SETTING (ID,VALUE,NAME,TEAM_LEADER_ID) VALUES (?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE SETTING SET VALUE=?,NAME=?,TEAM_LEADER_ID WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM SETTING WHERE ID=?";
	}
	
	@Override
	protected Setting extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	Setting nextResult = new Setting();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setValue(rs.getString("VALUE"));

nextResult.setName(rs.getString("NAME"));

TeamLeader teamleader = new TeamLeader();
teamleader.setID(rs.getString("TEAM_LEADER_ID"));
nextResult.setTeamLeader(teamleader);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(Setting perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getValue());
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
	protected void setPreparedStatmentUpdateParams(Setting perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getValue());
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
	public List<Setting> findByExample(Setting theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useValue = StringUtils.hasText(theQueryObject.getValue()) && (excludeProperties == null || !excludeProperties.contains("value"));

if (useValue)
{
sql += " WHERE ";
sql += " VALUE=? ";
paramValues.add(theQueryObject.getValue());
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
