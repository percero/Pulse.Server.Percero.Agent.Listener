
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
import com.pulse.mo.Attachment;
import com.pulse.mo.Agent;
import com.pulse.mo.AdhocCoachingCategory;
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
		return "SELECT adhoccoachingsession.ID FROM AdhocCoachingSession adhoccoachingsession WHERE adhoccoachingsession.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT adhoccoachingsession.ID,adhoccoachingsession.externalID,adhoccoachingsession.adhocCoachingCategoryName,adhoccoachingsession.coachingComment,adhoccoachingsession.agent_ID,adhoccoachingsession.adhocCoachingCategory_ID,adhoccoachingsession.teamLeader_ID FROM AdhocCoachingSession adhoccoachingsession WHERE adhoccoachingsession.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT adhoccoachingsession.ID FROM AdhocCoachingSession adhoccoachingsession ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT adhoccoachingsession.ID FROM AdhocCoachingSession adhoccoachingsession ORDER BY adhoccoachingsession.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT adhoccoachingsession.ID,adhoccoachingsession.externalID,adhoccoachingsession.adhocCoachingCategoryName,adhoccoachingsession.coachingComment,adhoccoachingsession.agent_ID,adhoccoachingsession.adhocCoachingCategory_ID,adhoccoachingsession.teamLeader_ID FROM AdhocCoachingSession adhoccoachingsession ORDER BY adhoccoachingsession.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT adhoccoachingsession.ID,adhoccoachingsession.externalID,adhoccoachingsession.adhocCoachingCategoryName,adhoccoachingsession.coachingComment,adhoccoachingsession.agent_ID,adhoccoachingsession.adhocCoachingCategory_ID,adhoccoachingsession.teamLeader_ID FROM AdhocCoachingSession adhoccoachingsession ORDER BY adhoccoachingsession.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM AdhocCoachingSession adhoccoachingsession";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT adhoccoachingsession.ID,adhoccoachingsession.externalID,adhoccoachingsession.adhocCoachingCategoryName,adhoccoachingsession.coachingComment,adhoccoachingsession.agent_ID,adhoccoachingsession.adhocCoachingCategory_ID,adhoccoachingsession.teamLeader_ID FROM AdhocCoachingSession adhoccoachingsession WHERE adhoccoachingsession.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT adhoccoachingsession.ID FROM AdhocCoachingSession adhoccoachingsession WHERE adhoccoachingsession.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT adhoccoachingsession.ID,adhoccoachingsession.externalID,adhoccoachingsession.adhocCoachingCategoryName,adhoccoachingsession.coachingComment,adhoccoachingsession.agent_ID,adhoccoachingsession.adhocCoachingCategory_ID,adhoccoachingsession.teamLeader_ID FROM AdhocCoachingSession adhoccoachingsession WHERE adhoccoachingsession." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT adhoccoachingsession.ID FROM AdhocCoachingSession adhoccoachingsession WHERE adhoccoachingsession." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT adhoccoachingsession.ID FROM AdhocCoachingSession adhoccoachingsession ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT adhoccoachingsession.ID,adhoccoachingsession.externalID,adhoccoachingsession.adhocCoachingCategoryName,adhoccoachingsession.coachingComment,adhoccoachingsession.agent_ID,adhoccoachingsession.adhocCoachingCategory_ID,adhoccoachingsession.teamLeader_ID FROM AdhocCoachingSession adhoccoachingsession ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO AdhocCoachingSession (ID,externalID,adhocCoachingCategoryName,coachingComment,agent_ID,adhocCoachingCategory_ID,teamLeader_ID) VALUES (?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE AdhocCoachingSession SET externalID=?,adhocCoachingCategoryName=?,coachingComment=?,agent_ID=?,adhocCoachingCategory_ID=?,teamLeader_ID=? WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM AdhocCoachingSession WHERE ID=?";
	}
	
	@Override
	protected AdhocCoachingSession extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	AdhocCoachingSession nextResult = new AdhocCoachingSession();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setExternalID(rs.getString("externalID"));

nextResult.setAdhocCoachingCategoryName(rs.getString("adhocCoachingCategoryName"));

nextResult.setCoachingComment(rs.getString("coachingComment"));

Agent agent = new Agent();
agent.setID(rs.getString("agent_ID"));
nextResult.setAgent(agent);

AdhocCoachingCategory adhoccoachingcategory = new AdhocCoachingCategory();
adhoccoachingcategory.setID(rs.getString("adhoccoachingcategory_ID"));
nextResult.setAdhocCoachingCategory(adhoccoachingcategory);

TeamLeader teamleader = new TeamLeader();
teamleader.setID(rs.getString("teamleader_ID"));
nextResult.setTeamLeader(teamleader);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(AdhocCoachingSession perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getExternalID());
pstmt.setString(3, perceroObject.getAdhocCoachingCategoryName());
pstmt.setString(4, perceroObject.getCoachingComment());

if (perceroObject.getAgent() == null)
{
pstmt.setString(5, null);
}
else
{
		pstmt.setString(5, perceroObject.getAgent().getID());
}


if (perceroObject.getAdhocCoachingCategory() == null)
{
pstmt.setString(6, null);
}
else
{
		pstmt.setString(6, perceroObject.getAdhocCoachingCategory().getID());
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
		
		pstmt.setString(1, perceroObject.getExternalID());
pstmt.setString(2, perceroObject.getAdhocCoachingCategoryName());
pstmt.setString(3, perceroObject.getCoachingComment());

if (perceroObject.getAgent() == null)
{
pstmt.setString(4, null);
}
else
{
		pstmt.setString(4, perceroObject.getAgent().getID());
}


if (perceroObject.getAdhocCoachingCategory() == null)
{
pstmt.setString(5, null);
}
else
{
		pstmt.setString(5, perceroObject.getAdhocCoachingCategory().getID());
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
		
		boolean useExternalID = StringUtils.hasText(theQueryObject.getExternalID()) && (excludeProperties == null || !excludeProperties.contains("externalID"));

if (useExternalID)
{
sql += " WHERE ";
paramValues.add(theQueryObject.getExternalID());
propertyCounter++;
}

boolean useAdhocCoachingCategoryName = StringUtils.hasText(theQueryObject.getAdhocCoachingCategoryName()) && (excludeProperties == null || !excludeProperties.contains("adhocCoachingCategoryName"));

if (useAdhocCoachingCategoryName)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " adhocCoachingCategoryName=? ";
paramValues.add(theQueryObject.getAdhocCoachingCategoryName());
propertyCounter++;
}

boolean useCoachingComment = StringUtils.hasText(theQueryObject.getCoachingComment()) && (excludeProperties == null || !excludeProperties.contains("coachingComment"));

if (useCoachingComment)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " coachingComment=? ";
paramValues.add(theQueryObject.getCoachingComment());
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
sql += " agentID=? ";
paramValues.add(theQueryObject.getAgent().getID());
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
sql += " adhocCoachingCategoryID=? ";
paramValues.add(theQueryObject.getAdhocCoachingCategory().getID());
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
