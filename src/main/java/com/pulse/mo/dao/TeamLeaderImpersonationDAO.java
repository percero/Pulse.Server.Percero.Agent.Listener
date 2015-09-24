
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
import com.pulse.mo.TeamLeaderImpersonation;
import com.pulse.mo.TeamLeader;
import com.pulse.mo.PulseUser;

*/

@Component
public class TeamLeaderImpersonationDAO extends SqlDataAccessObject<TeamLeaderImpersonation> implements IDataAccessObject<TeamLeaderImpersonation> {

	static final Logger log = Logger.getLogger(TeamLeaderImpersonationDAO.class);

	
	public TeamLeaderImpersonationDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(TeamLeaderImpersonation.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	@Override
	protected String getConnectionFactoryName() {
		return TeamLeaderImpersonationDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT teamleaderimpersonation.ID FROM TeamLeaderImpersonation teamleaderimpersonation WHERE teamleaderimpersonation.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT teamleaderimpersonation.ID,teamleaderimpersonation.externalID,teamleaderimpersonation.lastImpersonatedOn,teamleaderimpersonation.pulseUser_ID,teamleaderimpersonation.teamLeader_ID FROM TeamLeaderImpersonation teamleaderimpersonation WHERE teamleaderimpersonation.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT teamleaderimpersonation.ID FROM TeamLeaderImpersonation teamleaderimpersonation ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT teamleaderimpersonation.ID FROM TeamLeaderImpersonation teamleaderimpersonation ORDER BY teamleaderimpersonation.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT teamleaderimpersonation.ID,teamleaderimpersonation.externalID,teamleaderimpersonation.lastImpersonatedOn,teamleaderimpersonation.pulseUser_ID,teamleaderimpersonation.teamLeader_ID FROM TeamLeaderImpersonation teamleaderimpersonation ORDER BY teamleaderimpersonation.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT teamleaderimpersonation.ID,teamleaderimpersonation.externalID,teamleaderimpersonation.lastImpersonatedOn,teamleaderimpersonation.pulseUser_ID,teamleaderimpersonation.teamLeader_ID FROM TeamLeaderImpersonation teamleaderimpersonation ORDER BY teamleaderimpersonation.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM TeamLeaderImpersonation teamleaderimpersonation";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT teamleaderimpersonation.ID,teamleaderimpersonation.externalID,teamleaderimpersonation.lastImpersonatedOn,teamleaderimpersonation.pulseUser_ID,teamleaderimpersonation.teamLeader_ID FROM TeamLeaderImpersonation teamleaderimpersonation WHERE teamleaderimpersonation.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT teamleaderimpersonation.ID FROM TeamLeaderImpersonation teamleaderimpersonation WHERE teamleaderimpersonation.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT teamleaderimpersonation.ID,teamleaderimpersonation.externalID,teamleaderimpersonation.lastImpersonatedOn,teamleaderimpersonation.pulseUser_ID,teamleaderimpersonation.teamLeader_ID FROM TeamLeaderImpersonation teamleaderimpersonation WHERE teamleaderimpersonation." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT teamleaderimpersonation.ID FROM TeamLeaderImpersonation teamleaderimpersonation WHERE teamleaderimpersonation." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT teamleaderimpersonation.ID FROM TeamLeaderImpersonation teamleaderimpersonation ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT teamleaderimpersonation.ID,teamleaderimpersonation.externalID,teamleaderimpersonation.lastImpersonatedOn,teamleaderimpersonation.pulseUser_ID,teamleaderimpersonation.teamLeader_ID FROM TeamLeaderImpersonation teamleaderimpersonation ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO TeamLeaderImpersonation (ID,externalID,lastImpersonatedOn,pulseUser_ID,teamLeader_ID) VALUES (?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE TeamLeaderImpersonation SET externalID=?,lastImpersonatedOn=?,pulseUser_ID=?,teamLeader_ID=? WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM TeamLeaderImpersonation WHERE ID=?";
	}
	
	@Override
	protected TeamLeaderImpersonation extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	TeamLeaderImpersonation nextResult = new TeamLeaderImpersonation();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setExternalID(rs.getString("externalID"));

nextResult.setLastImpersonatedOn(rs.getDate("lastImpersonatedOn"));

PulseUser pulseuser = new PulseUser();
pulseuser.setID(rs.getString("pulseuser_ID"));
nextResult.setPulseUser(pulseuser);

TeamLeader teamleader = new TeamLeader();
teamleader.setID(rs.getString("teamleader_ID"));
nextResult.setTeamLeader(teamleader);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(TeamLeaderImpersonation perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getExternalID());
pstmt.setDate(3, DateUtils.utilDateToSqlDate(perceroObject.getLastImpersonatedOn()));

if (perceroObject.getPulseUser() == null)
{
pstmt.setString(4, null);
}
else
{
		pstmt.setString(4, perceroObject.getPulseUser().getID());
}


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
	protected void setPreparedStatmentUpdateParams(TeamLeaderImpersonation perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getExternalID());
pstmt.setDate(2, DateUtils.utilDateToSqlDate(perceroObject.getLastImpersonatedOn()));

if (perceroObject.getPulseUser() == null)
{
pstmt.setString(3, null);
}
else
{
		pstmt.setString(3, perceroObject.getPulseUser().getID());
}


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
	public List<TeamLeaderImpersonation> findByExample(TeamLeaderImpersonation theQueryObject,
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

boolean useLastImpersonatedOn = theQueryObject.getLastImpersonatedOn() != null && (excludeProperties == null || !excludeProperties.contains("lastImpersonatedOn"));

if (useLastImpersonatedOn)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " lastImpersonatedOn=? ";
paramValues.add(theQueryObject.getLastImpersonatedOn());
propertyCounter++;
}

boolean usePulseUserID = theQueryObject.getPulseUser() != null && (excludeProperties == null || !excludeProperties.contains("pulseUser"));

if (usePulseUserID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " pulseUserID=? ";
paramValues.add(theQueryObject.getPulseUser().getID());
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
