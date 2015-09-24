
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
import com.pulse.mo.Agent;
import com.pulse.mo.AdhocTaskState;
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
		return "SELECT adhoctask.ID FROM AdhocTask adhoctask WHERE adhoctask.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT adhoctask.ID,adhoctask.externalID,adhoctask.taskDetail,adhoctask.adhocTaskStateName,adhoctask.dueDate,adhoctask.agent_ID,adhoctask.teamLeader_ID,adhoctask.adhocTaskState_ID FROM AdhocTask adhoctask WHERE adhoctask.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT adhoctask.ID FROM AdhocTask adhoctask ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT adhoctask.ID FROM AdhocTask adhoctask ORDER BY adhoctask.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT adhoctask.ID,adhoctask.externalID,adhoctask.taskDetail,adhoctask.adhocTaskStateName,adhoctask.dueDate,adhoctask.agent_ID,adhoctask.teamLeader_ID,adhoctask.adhocTaskState_ID FROM AdhocTask adhoctask ORDER BY adhoctask.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT adhoctask.ID,adhoctask.externalID,adhoctask.taskDetail,adhoctask.adhocTaskStateName,adhoctask.dueDate,adhoctask.agent_ID,adhoctask.teamLeader_ID,adhoctask.adhocTaskState_ID FROM AdhocTask adhoctask ORDER BY adhoctask.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM AdhocTask adhoctask";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT adhoctask.ID,adhoctask.externalID,adhoctask.taskDetail,adhoctask.adhocTaskStateName,adhoctask.dueDate,adhoctask.agent_ID,adhoctask.teamLeader_ID,adhoctask.adhocTaskState_ID FROM AdhocTask adhoctask WHERE adhoctask.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT adhoctask.ID FROM AdhocTask adhoctask WHERE adhoctask.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT adhoctask.ID,adhoctask.externalID,adhoctask.taskDetail,adhoctask.adhocTaskStateName,adhoctask.dueDate,adhoctask.agent_ID,adhoctask.teamLeader_ID,adhoctask.adhocTaskState_ID FROM AdhocTask adhoctask WHERE adhoctask." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT adhoctask.ID FROM AdhocTask adhoctask WHERE adhoctask." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT adhoctask.ID FROM AdhocTask adhoctask ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT adhoctask.ID,adhoctask.externalID,adhoctask.taskDetail,adhoctask.adhocTaskStateName,adhoctask.dueDate,adhoctask.agent_ID,adhoctask.teamLeader_ID,adhoctask.adhocTaskState_ID FROM AdhocTask adhoctask ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO AdhocTask (ID,externalID,taskDetail,adhocTaskStateName,dueDate,agent_ID,teamLeader_ID,adhocTaskState_ID) VALUES (?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE AdhocTask SET externalID=?,taskDetail=?,adhocTaskStateName=?,dueDate=?,agent_ID=?,teamLeader_ID=?,adhocTaskState_ID=? WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM AdhocTask WHERE ID=?";
	}
	
	@Override
	protected AdhocTask extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	AdhocTask nextResult = new AdhocTask();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setExternalID(rs.getString("externalID"));

nextResult.setTaskDetail(rs.getString("taskDetail"));

nextResult.setAdhocTaskStateName(rs.getString("adhocTaskStateName"));

nextResult.setDueDate(rs.getString("dueDate"));

Agent agent = new Agent();
agent.setID(rs.getString("agent_ID"));
nextResult.setAgent(agent);

TeamLeader teamleader = new TeamLeader();
teamleader.setID(rs.getString("teamleader_ID"));
nextResult.setTeamLeader(teamleader);

AdhocTaskState adhoctaskstate = new AdhocTaskState();
adhoctaskstate.setID(rs.getString("adhoctaskstate_ID"));
nextResult.setAdhocTaskState(adhoctaskstate);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(AdhocTask perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getExternalID());
pstmt.setString(3, perceroObject.getTaskDetail());
pstmt.setString(4, perceroObject.getAdhocTaskStateName());
pstmt.setString(5, perceroObject.getDueDate());

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


if (perceroObject.getAdhocTaskState() == null)
{
pstmt.setString(8, null);
}
else
{
		pstmt.setString(8, perceroObject.getAdhocTaskState().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(AdhocTask perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getExternalID());
pstmt.setString(2, perceroObject.getTaskDetail());
pstmt.setString(3, perceroObject.getAdhocTaskStateName());
pstmt.setString(4, perceroObject.getDueDate());

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


if (perceroObject.getAdhocTaskState() == null)
{
pstmt.setString(7, null);
}
else
{
		pstmt.setString(7, perceroObject.getAdhocTaskState().getID());
}

pstmt.setString(8, perceroObject.getID());

		
	}

	@Override
	public List<AdhocTask> findByExample(AdhocTask theQueryObject,
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
sql += " taskDetail=? ";
paramValues.add(theQueryObject.getTaskDetail());
propertyCounter++;
}

boolean useAdhocTaskStateName = StringUtils.hasText(theQueryObject.getAdhocTaskStateName()) && (excludeProperties == null || !excludeProperties.contains("adhocTaskStateName"));

if (useAdhocTaskStateName)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " adhocTaskStateName=? ";
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
sql += " dueDate=? ";
paramValues.add(theQueryObject.getDueDate());
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
sql += " adhocTaskStateID=? ";
paramValues.add(theQueryObject.getAdhocTaskState().getID());
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
