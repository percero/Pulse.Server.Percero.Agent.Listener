
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
		return "SELECT GENERAL_COMMENT.ID FROM GENERAL_COMMENT GENERAL_COMMENT WHERE GENERAL_COMMENT.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT GENERAL_COMMENT.ID,GENERAL_COMMENT.COMMENT,GENERAL_COMMENT.DATE,GENERAL_COMMENT.TEAM_LEADER_ID,GENERAL_COMMENT.AGENT_ID FROM GENERAL_COMMENT GENERAL_COMMENT WHERE GENERAL_COMMENT.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT GENERAL_COMMENT.ID FROM GENERAL_COMMENT GENERAL_COMMENT ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT GENERAL_COMMENT.ID FROM GENERAL_COMMENT GENERAL_COMMENT ORDER BY GENERAL_COMMENT.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT GENERAL_COMMENT.ID,GENERAL_COMMENT.COMMENT,GENERAL_COMMENT.DATE,GENERAL_COMMENT.TEAM_LEADER_ID,GENERAL_COMMENT.AGENT_ID FROM GENERAL_COMMENT GENERAL_COMMENT ORDER BY GENERAL_COMMENT.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT GENERAL_COMMENT.ID,GENERAL_COMMENT.COMMENT,GENERAL_COMMENT.DATE,GENERAL_COMMENT.TEAM_LEADER_ID,GENERAL_COMMENT.AGENT_ID FROM GENERAL_COMMENT GENERAL_COMMENT ORDER BY GENERAL_COMMENT.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM GENERAL_COMMENT GENERAL_COMMENT";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT GENERAL_COMMENT.ID,GENERAL_COMMENT.COMMENT,GENERAL_COMMENT.DATE,GENERAL_COMMENT.TEAM_LEADER_ID,GENERAL_COMMENT.AGENT_ID FROM GENERAL_COMMENT GENERAL_COMMENT WHERE GENERAL_COMMENT.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT GENERAL_COMMENT.ID FROM GENERAL_COMMENT GENERAL_COMMENT WHERE GENERAL_COMMENT.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT GENERAL_COMMENT.ID,GENERAL_COMMENT.COMMENT,GENERAL_COMMENT.DATE,GENERAL_COMMENT.TEAM_LEADER_ID,GENERAL_COMMENT.AGENT_ID FROM GENERAL_COMMENT GENERAL_COMMENT WHERE GENERAL_COMMENT." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT GENERAL_COMMENT.ID FROM GENERAL_COMMENT GENERAL_COMMENT WHERE GENERAL_COMMENT." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT GENERAL_COMMENT.ID FROM GENERAL_COMMENT GENERAL_COMMENT ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT GENERAL_COMMENT.ID,GENERAL_COMMENT.COMMENT,GENERAL_COMMENT.DATE,GENERAL_COMMENT.TEAM_LEADER_ID,GENERAL_COMMENT.AGENT_ID FROM GENERAL_COMMENT GENERAL_COMMENT ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO GENERAL_COMMENT (ID,COMMENT,DATE,TEAM_LEADER_ID,AGENT_ID) VALUES (?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE GENERAL_COMMENT SET COMMENT=?,DATE=?,TEAM_LEADER_ID=?,AGENT_ID=? WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM GENERAL_COMMENT WHERE ID=?";
	}
	
	@Override
	protected GeneralComment extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	GeneralComment nextResult = new GeneralComment();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setComment(rs.getString("COMMENT"));

nextResult.setDate(rs.getDate("DATE"));

TeamLeader teamleader = new TeamLeader();
teamleader.setID(rs.getString("TEAM_LEADER_ID"));
nextResult.setTeamLeader(teamleader);

Agent agent = new Agent();
agent.setID(rs.getString("AGENT_ID"));
nextResult.setAgent(agent);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(GeneralComment perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getComment());
pstmt.setDate(3, DateUtils.utilDateToSqlDate(perceroObject.getDate()));

if (perceroObject.getTeamLeader() == null)
{
pstmt.setString(4, null);
}
else
{
		pstmt.setString(4, perceroObject.getTeamLeader().getID());
}


if (perceroObject.getAgent() == null)
{
pstmt.setString(5, null);
}
else
{
		pstmt.setString(5, perceroObject.getAgent().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(GeneralComment perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getComment());
pstmt.setDate(2, DateUtils.utilDateToSqlDate(perceroObject.getDate()));

if (perceroObject.getTeamLeader() == null)
{
pstmt.setString(3, null);
}
else
{
		pstmt.setString(3, perceroObject.getTeamLeader().getID());
}


if (perceroObject.getAgent() == null)
{
pstmt.setString(4, null);
}
else
{
		pstmt.setString(4, perceroObject.getAgent().getID());
}

pstmt.setString(5, perceroObject.getID());

		
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
sql += " COMMENT=? ";
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
sql += " DATE=? ";
paramValues.add(theQueryObject.getDate());
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
sql += " AGENT_ID=? ";
paramValues.add(theQueryObject.getAgent().getID());
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
