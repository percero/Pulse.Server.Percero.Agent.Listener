
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
import com.pulse.mo.AdhocCoachingSession;
import com.pulse.mo.CoachingComment;
import com.pulse.mo.AdhocCoachingCategory;
import com.pulse.mo.Agent;
import com.pulse.mo.TeamLeader;

*/

@Component
public class AdhocCoachingSessionDAO extends SqlDataAccessObject<AdhocCoachingSession> implements IDataAccessObject<AdhocCoachingSession> {

	static final Logger log = Logger.getLogger(AdhocCoachingSessionDAO.class);

	
	public AdhocCoachingSessionDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(AdhocCoachingSession.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	
	
	
	@Override
	protected String getConnectionFactoryName() {
		return AdhocCoachingSessionDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT \"ADHOC_COACHING_SESSION\".\"ID\" FROM \"ADHOC_COACHING_SESSION\" \"ADHOC_COACHING_SESSION\" WHERE \"ADHOC_COACHING_SESSION\".\"ID\"=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT \"ADHOC_COACHING_SESSION\".\"ID\",\"ADHOC_COACHING_SESSION\".\"SESSION_TYPE\",\"ADHOC_COACHING_SESSION\".\"STATUS\",\"ADHOC_COACHING_SESSION\".\"WEEK_DATE\",\"ADHOC_COACHING_SESSION\".\"ADHOC_COACHING_CATEGORY_ID\",\"ADHOC_COACHING_SESSION\".\"AGENT_ID\",\"ADHOC_COACHING_SESSION\".\"TEAM_LEADER_ID\" FROM \"ADHOC_COACHING_SESSION\" \"ADHOC_COACHING_SESSION\" WHERE \"ADHOC_COACHING_SESSION\".\"ID\"=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT \"ADHOC_COACHING_SESSION\".\"ID\" FROM \"ADHOC_COACHING_SESSION\" \"ADHOC_COACHING_SESSION\" ORDER BY \"ID\"";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT \"ADHOC_COACHING_SESSION\".\"ID\" FROM \"ADHOC_COACHING_SESSION\" \"ADHOC_COACHING_SESSION\" ORDER BY \"ADHOC_COACHING_SESSION\".\"ID\" LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT \"ADHOC_COACHING_SESSION\".\"ID\",\"ADHOC_COACHING_SESSION\".\"SESSION_TYPE\",\"ADHOC_COACHING_SESSION\".\"STATUS\",\"ADHOC_COACHING_SESSION\".\"WEEK_DATE\",\"ADHOC_COACHING_SESSION\".\"ADHOC_COACHING_CATEGORY_ID\",\"ADHOC_COACHING_SESSION\".\"AGENT_ID\",\"ADHOC_COACHING_SESSION\".\"TEAM_LEADER_ID\" FROM \"ADHOC_COACHING_SESSION\" \"ADHOC_COACHING_SESSION\" ORDER BY \"ADHOC_COACHING_SESSION\".\"ID\"";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT \"ADHOC_COACHING_SESSION\".\"ID\",\"ADHOC_COACHING_SESSION\".\"SESSION_TYPE\",\"ADHOC_COACHING_SESSION\".\"STATUS\",\"ADHOC_COACHING_SESSION\".\"WEEK_DATE\",\"ADHOC_COACHING_SESSION\".\"ADHOC_COACHING_CATEGORY_ID\",\"ADHOC_COACHING_SESSION\".\"AGENT_ID\",\"ADHOC_COACHING_SESSION\".\"TEAM_LEADER_ID\" FROM \"ADHOC_COACHING_SESSION\" \"ADHOC_COACHING_SESSION\" ORDER BY \"ADHOC_COACHING_SESSION\".\"ID\" LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM \"ADHOC_COACHING_SESSION\" \"ADHOC_COACHING_SESSION\"";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT \"ADHOC_COACHING_SESSION\".\"ID\",\"ADHOC_COACHING_SESSION\".\"SESSION_TYPE\",\"ADHOC_COACHING_SESSION\".\"STATUS\",\"ADHOC_COACHING_SESSION\".\"WEEK_DATE\",\"ADHOC_COACHING_SESSION\".\"ADHOC_COACHING_CATEGORY_ID\",\"ADHOC_COACHING_SESSION\".\"AGENT_ID\",\"ADHOC_COACHING_SESSION\".\"TEAM_LEADER_ID\" FROM \"ADHOC_COACHING_SESSION\" \"ADHOC_COACHING_SESSION\" WHERE \"ADHOC_COACHING_SESSION\".\"ID\" IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT \"ADHOC_COACHING_SESSION\".\"ID\" FROM \"ADHOC_COACHING_SESSION\" \"ADHOC_COACHING_SESSION\" WHERE \"ADHOC_COACHING_SESSION\".\"ID\" IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		return "SELECT \"ADHOC_COACHING_SESSION\".\"ID\",\"ADHOC_COACHING_SESSION\".\"SESSION_TYPE\",\"ADHOC_COACHING_SESSION\".\"STATUS\",\"ADHOC_COACHING_SESSION\".\"WEEK_DATE\",\"ADHOC_COACHING_SESSION\".\"ADHOC_COACHING_CATEGORY_ID\",\"ADHOC_COACHING_SESSION\".\"AGENT_ID\",\"ADHOC_COACHING_SESSION\".\"TEAM_LEADER_ID\" FROM \"ADHOC_COACHING_SESSION\" \"ADHOC_COACHING_SESSION\" WHERE \"ADHOC_COACHING_SESSION\"." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT \"ADHOC_COACHING_SESSION\".\"ID\" FROM \"ADHOC_COACHING_SESSION\" \"ADHOC_COACHING_SESSION\" WHERE \"ADHOC_COACHING_SESSION\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT \"ADHOC_COACHING_SESSION\".\"ID\" FROM \"ADHOC_COACHING_SESSION\" \"ADHOC_COACHING_SESSION\" ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT \"ADHOC_COACHING_SESSION\".\"ID\",\"ADHOC_COACHING_SESSION\".\"SESSION_TYPE\",\"ADHOC_COACHING_SESSION\".\"STATUS\",\"ADHOC_COACHING_SESSION\".\"WEEK_DATE\",\"ADHOC_COACHING_SESSION\".\"ADHOC_COACHING_CATEGORY_ID\",\"ADHOC_COACHING_SESSION\".\"AGENT_ID\",\"ADHOC_COACHING_SESSION\".\"TEAM_LEADER_ID\" FROM \"ADHOC_COACHING_SESSION\" \"ADHOC_COACHING_SESSION\" ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO ADHOC_COACHING_SESSION (\"ID\",\"SESSION_TYPE\",\"STATUS\",\"WEEK_DATE\",\"ADHOC_COACHING_CATEGORY_ID\",\"AGENT_ID\",\"TEAM_LEADER_ID\") VALUES (?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE \"ADHOC_COACHING_SESSION\" SET \"SESSION_TYPE\"=?,\"STATUS\"=?,\"WEEK_DATE\"=?,\"ADHOC_COACHING_CATEGORY_ID\"=?,\"AGENT_ID\"=?,\"TEAM_LEADER_ID\"=? WHERE \"ID\"=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM \"ADHOC_COACHING_SESSION\" WHERE \"ID\"=?";
	}
	
	@Override
	protected AdhocCoachingSession extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	AdhocCoachingSession nextResult = new AdhocCoachingSession();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setSessionType(rs.getString("SESSION_TYPE"));

nextResult.setStatus(rs.getString("STATUS"));

nextResult.setWeekDate(rs.getDate("WEEK_DATE"));

AdhocCoachingCategory adhoccoachingcategory = new AdhocCoachingCategory();
adhoccoachingcategory.setID(rs.getString("ADHOC_COACHING_CATEGORY_ID"));
nextResult.setAdhocCoachingCategory(adhoccoachingcategory);

Agent agent = new Agent();
agent.setID(rs.getString("AGENT_ID"));
nextResult.setAgent(agent);

TeamLeader teamleader = new TeamLeader();
teamleader.setID(rs.getString("TEAM_LEADER_ID"));
nextResult.setTeamLeader(teamleader);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(AdhocCoachingSession perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getSessionType());
pstmt.setString(3, perceroObject.getStatus());
pstmt.setDate(4, DateUtils.utilDateToSqlDate(perceroObject.getWeekDate()));

if (perceroObject.getAdhocCoachingCategory() == null)
{
pstmt.setString(5, null);
}
else
{
		pstmt.setString(5, perceroObject.getAdhocCoachingCategory().getID());
}


if (perceroObject.getAgent() == null)
{
pstmt.setString(6, null);
}
else
{
		pstmt.setString(6, perceroObject.getAgent().getID());
}


if (perceroObject.getTeamLeader() == null)
{
pstmt.setString(7, null);
}
else
{
		pstmt.setString(7, perceroObject.getTeamLeader().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(AdhocCoachingSession perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getSessionType());
pstmt.setString(2, perceroObject.getStatus());
pstmt.setDate(3, DateUtils.utilDateToSqlDate(perceroObject.getWeekDate()));

if (perceroObject.getAdhocCoachingCategory() == null)
{
pstmt.setString(4, null);
}
else
{
		pstmt.setString(4, perceroObject.getAdhocCoachingCategory().getID());
}


if (perceroObject.getAgent() == null)
{
pstmt.setString(5, null);
}
else
{
		pstmt.setString(5, perceroObject.getAgent().getID());
}


if (perceroObject.getTeamLeader() == null)
{
pstmt.setString(6, null);
}
else
{
		pstmt.setString(6, perceroObject.getTeamLeader().getID());
}

pstmt.setString(7, perceroObject.getID());

		
	}

	@Override
	public List<AdhocCoachingSession> findByExample(AdhocCoachingSession theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useSessionType = StringUtils.hasText(theQueryObject.getSessionType()) && (excludeProperties == null || !excludeProperties.contains("sessionType"));

if (useSessionType)
{
sql += " WHERE ";
sql += " \"SESSION_TYPE\" =? ";
paramValues.add(theQueryObject.getSessionType());
propertyCounter++;
}

boolean useStatus = StringUtils.hasText(theQueryObject.getStatus()) && (excludeProperties == null || !excludeProperties.contains("status"));

if (useStatus)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"STATUS\" =? ";
paramValues.add(theQueryObject.getStatus());
propertyCounter++;
}

boolean useWeekDate = theQueryObject.getWeekDate() != null && (excludeProperties == null || !excludeProperties.contains("weekDate"));

if (useWeekDate)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"WEEK_DATE\" =? ";
paramValues.add(theQueryObject.getWeekDate());
propertyCounter++;
}

boolean useAdhocCoachingCategoryID = theQueryObject.getAdhocCoachingCategory() != null && (excludeProperties == null || !excludeProperties.contains("adhocCoachingCategory"));

if (useAdhocCoachingCategoryID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"ADHOC_COACHING_CATEGORY_ID\" =? ";
paramValues.add(theQueryObject.getAdhocCoachingCategory().getID());
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
