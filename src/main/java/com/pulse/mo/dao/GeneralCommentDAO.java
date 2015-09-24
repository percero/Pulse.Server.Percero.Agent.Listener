
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
import com.pulse.mo.GeneralComment;
import com.pulse.mo.Agent;
import com.pulse.mo.TeamLeader;

*/

@Component
public class GeneralCommentDAO extends SqlDataAccessObject<GeneralComment> implements IDataAccessObject<GeneralComment> {

	static final Logger log = Logger.getLogger(GeneralCommentDAO.class);

	
	public GeneralCommentDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(GeneralComment.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	@Override
	protected String getConnectionFactoryName() {
		return GeneralCommentDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT generalcomment.ID FROM GeneralComment generalcomment WHERE generalcomment.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT generalcomment.ID,generalcomment.comment,generalcomment.date,generalcomment.externalID,generalcomment.agent_ID,generalcomment.teamLeader_ID FROM GeneralComment generalcomment WHERE generalcomment.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT generalcomment.ID FROM GeneralComment generalcomment ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT generalcomment.ID FROM GeneralComment generalcomment ORDER BY generalcomment.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT generalcomment.ID,generalcomment.comment,generalcomment.date,generalcomment.externalID,generalcomment.agent_ID,generalcomment.teamLeader_ID FROM GeneralComment generalcomment ORDER BY generalcomment.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT generalcomment.ID,generalcomment.comment,generalcomment.date,generalcomment.externalID,generalcomment.agent_ID,generalcomment.teamLeader_ID FROM GeneralComment generalcomment ORDER BY generalcomment.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM GeneralComment generalcomment";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT generalcomment.ID,generalcomment.comment,generalcomment.date,generalcomment.externalID,generalcomment.agent_ID,generalcomment.teamLeader_ID FROM GeneralComment generalcomment WHERE generalcomment.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT generalcomment.ID FROM GeneralComment generalcomment WHERE generalcomment.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT generalcomment.ID,generalcomment.comment,generalcomment.date,generalcomment.externalID,generalcomment.agent_ID,generalcomment.teamLeader_ID FROM GeneralComment generalcomment WHERE generalcomment." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT generalcomment.ID FROM GeneralComment generalcomment WHERE generalcomment." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT generalcomment.ID FROM GeneralComment generalcomment ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT generalcomment.ID,generalcomment.comment,generalcomment.date,generalcomment.externalID,generalcomment.agent_ID,generalcomment.teamLeader_ID FROM GeneralComment generalcomment ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO GeneralComment (ID,comment,date,externalID,agent_ID,teamLeader_ID) VALUES (?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE GeneralComment SET comment=?,date=?,externalID=?,agent_ID=?,teamLeader_ID=? WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM GeneralComment WHERE ID=?";
	}
	
	@Override
	protected GeneralComment extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	GeneralComment nextResult = new GeneralComment();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setComment(rs.getString("comment"));

nextResult.setDate(rs.getDate("date"));

nextResult.setExternalID(rs.getString("externalID"));

Agent agent = new Agent();
agent.setID(rs.getString("agent_ID"));
nextResult.setAgent(agent);

TeamLeader teamleader = new TeamLeader();
teamleader.setID(rs.getString("teamleader_ID"));
nextResult.setTeamLeader(teamleader);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(GeneralComment perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getComment());
pstmt.setDate(3, DateUtils.utilDateToSqlDate(perceroObject.getDate()));
pstmt.setString(4, perceroObject.getExternalID());

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


		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(GeneralComment perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getComment());
pstmt.setDate(2, DateUtils.utilDateToSqlDate(perceroObject.getDate()));
pstmt.setString(3, perceroObject.getExternalID());

if (perceroObject.getAgent() == null)
{
pstmt.setString(4, null);
}
else
{
		pstmt.setString(4, perceroObject.getAgent().getID());
}


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
	public List<GeneralComment> findByExample(GeneralComment theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useComment = StringUtils.hasText(theQueryObject.getComment()) && (excludeProperties == null || !excludeProperties.contains("comment"));

if (useComment)
{
sql += " WHERE ";
paramValues.add(theQueryObject.getComment());
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
