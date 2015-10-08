
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
import com.pulse.mo.AdhocTask;
import com.pulse.mo.AdhocTaskState;
import com.pulse.mo.Agent;
import com.pulse.mo.TeamLeader;

*/

@Component
public class AdhocTaskDAO extends SqlDataAccessObject<AdhocTask> implements IDataAccessObject<AdhocTask> {

	static final Logger log = Logger.getLogger(AdhocTaskDAO.class);

	
	public AdhocTaskDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(AdhocTask.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	@Override
	protected String getConnectionFactoryName() {
		return AdhocTaskDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT ADHOC_TASK.ID FROM ADHOC_TASK ADHOC_TASK WHERE ADHOC_TASK.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT ADHOC_TASK.ID,ADHOC_TASK.ADHOC_TASK_STATE_NAME,ADHOC_TASK.DUE_DATE,ADHOC_TASK.TASK_DETAIL,ADHOC_TASK.ADHOC_TASK_STATE_ID,ADHOC_TASK.AGENT_ID,ADHOC_TASK.TEAM_LEADER_ID FROM ADHOC_TASK ADHOC_TASK WHERE ADHOC_TASK.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT ADHOC_TASK.ID FROM ADHOC_TASK ADHOC_TASK ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT ADHOC_TASK.ID FROM ADHOC_TASK ADHOC_TASK ORDER BY ADHOC_TASK.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT ADHOC_TASK.ID,ADHOC_TASK.ADHOC_TASK_STATE_NAME,ADHOC_TASK.DUE_DATE,ADHOC_TASK.TASK_DETAIL,ADHOC_TASK.ADHOC_TASK_STATE_ID,ADHOC_TASK.AGENT_ID,ADHOC_TASK.TEAM_LEADER_ID FROM ADHOC_TASK ADHOC_TASK ORDER BY ADHOC_TASK.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT ADHOC_TASK.ID,ADHOC_TASK.ADHOC_TASK_STATE_NAME,ADHOC_TASK.DUE_DATE,ADHOC_TASK.TASK_DETAIL,ADHOC_TASK.ADHOC_TASK_STATE_ID,ADHOC_TASK.AGENT_ID,ADHOC_TASK.TEAM_LEADER_ID FROM ADHOC_TASK ADHOC_TASK ORDER BY ADHOC_TASK.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM ADHOC_TASK ADHOC_TASK";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT ADHOC_TASK.ID,ADHOC_TASK.ADHOC_TASK_STATE_NAME,ADHOC_TASK.DUE_DATE,ADHOC_TASK.TASK_DETAIL,ADHOC_TASK.ADHOC_TASK_STATE_ID,ADHOC_TASK.AGENT_ID,ADHOC_TASK.TEAM_LEADER_ID FROM ADHOC_TASK ADHOC_TASK WHERE ADHOC_TASK.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT ADHOC_TASK.ID FROM ADHOC_TASK ADHOC_TASK WHERE ADHOC_TASK.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT ADHOC_TASK.ID,ADHOC_TASK.ADHOC_TASK_STATE_NAME,ADHOC_TASK.DUE_DATE,ADHOC_TASK.TASK_DETAIL,ADHOC_TASK.ADHOC_TASK_STATE_ID,ADHOC_TASK.AGENT_ID,ADHOC_TASK.TEAM_LEADER_ID FROM ADHOC_TASK ADHOC_TASK WHERE ADHOC_TASK." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT ADHOC_TASK.ID FROM ADHOC_TASK ADHOC_TASK WHERE ADHOC_TASK." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT ADHOC_TASK.ID FROM ADHOC_TASK ADHOC_TASK ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT ADHOC_TASK.ID,ADHOC_TASK.ADHOC_TASK_STATE_NAME,ADHOC_TASK.DUE_DATE,ADHOC_TASK.TASK_DETAIL,ADHOC_TASK.ADHOC_TASK_STATE_ID,ADHOC_TASK.AGENT_ID,ADHOC_TASK.TEAM_LEADER_ID FROM ADHOC_TASK ADHOC_TASK ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO ADHOC_TASK (ID,ADHOC_TASK_STATE_NAME,DUE_DATE,TASK_DETAIL,ADHOC_TASK_STATE_ID,AGENT_ID,TEAM_LEADER_ID) VALUES (?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE ADHOC_TASK SET ADHOC_TASK_STATE_NAME=?,DUE_DATE=?,TASK_DETAIL=?,ADHOC_TASK_STATE_ID,AGENT_ID,TEAM_LEADER_ID WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM ADHOC_TASK WHERE ID=?";
	}
	
	@Override
	protected AdhocTask extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	AdhocTask nextResult = new AdhocTask();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setAdhocTaskStateName(rs.getString("ADHOC_TASK_STATE_NAME"));

nextResult.setDueDate(rs.getString("DUE_DATE"));

nextResult.setTaskDetail(rs.getString("TASK_DETAIL"));

AdhocTaskState adhoctaskstate = new AdhocTaskState();
adhoctaskstate.setID(rs.getString("ADHOC_TASK_STATE_ID"));
nextResult.setAdhocTaskState(adhoctaskstate);

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
	protected void setPreparedStatmentInsertParams(AdhocTask perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getAdhocTaskStateName());
pstmt.setString(3, perceroObject.getDueDate());
pstmt.setString(4, perceroObject.getTaskDetail());

if (perceroObject.getAdhocTaskState() == null)
{
pstmt.setString(5, null);
}
else
{
		pstmt.setString(5, perceroObject.getAdhocTaskState().getID());
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
	protected void setPreparedStatmentUpdateParams(AdhocTask perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getAdhocTaskStateName());
pstmt.setString(2, perceroObject.getDueDate());
pstmt.setString(3, perceroObject.getTaskDetail());

if (perceroObject.getAdhocTaskState() == null)
{
pstmt.setString(4, null);
}
else
{
		pstmt.setString(4, perceroObject.getAdhocTaskState().getID());
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
	public List<AdhocTask> findByExample(AdhocTask theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useAdhocTaskStateName = StringUtils.hasText(theQueryObject.getAdhocTaskStateName()) && (excludeProperties == null || !excludeProperties.contains("adhocTaskStateName"));

if (useAdhocTaskStateName)
{
sql += " WHERE ";
sql += " ADHOC_TASK_STATE_NAME=? ";
paramValues.add(theQueryObject.getAdhocTaskStateName());
propertyCounter++;
}

boolean useDueDate = StringUtils.hasText(theQueryObject.getDueDate()) && (excludeProperties == null || !excludeProperties.contains("dueDate"));

if (useDueDate)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " DUE_DATE=? ";
paramValues.add(theQueryObject.getDueDate());
propertyCounter++;
}

boolean useTaskDetail = StringUtils.hasText(theQueryObject.getTaskDetail()) && (excludeProperties == null || !excludeProperties.contains("taskDetail"));

if (useTaskDetail)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " TASK_DETAIL=? ";
paramValues.add(theQueryObject.getTaskDetail());
propertyCounter++;
}

boolean useAdhocTaskStateID = theQueryObject.getAdhocTaskState() != null && (excludeProperties == null || !excludeProperties.contains("adhocTaskState"));

if (useAdhocTaskStateID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " ADHOC_TASK_STATE_ID=? ";
paramValues.add(theQueryObject.getAdhocTaskState().getID());
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
