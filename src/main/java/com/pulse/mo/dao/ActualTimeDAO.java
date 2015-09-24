
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
import com.pulse.mo.ActualTime;
import com.pulse.mo.ActualTimeEntry;
import com.pulse.mo.Agent;

*/

@Component
public class ActualTimeDAO extends SqlDataAccessObject<ActualTime> implements IDataAccessObject<ActualTime> {

	static final Logger log = Logger.getLogger(ActualTimeDAO.class);

	
	public ActualTimeDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(ActualTime.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	@Override
	protected String getConnectionFactoryName() {
		return ActualTimeDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT actualtime.ID FROM ActualTime actualtime WHERE actualtime.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT actualtime.ID,actualtime.externalID,actualtime.stateName,actualtime.totalTime,actualtime.agent_ID FROM ActualTime actualtime WHERE actualtime.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT actualtime.ID FROM ActualTime actualtime ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT actualtime.ID FROM ActualTime actualtime ORDER BY actualtime.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT actualtime.ID,actualtime.externalID,actualtime.stateName,actualtime.totalTime,actualtime.agent_ID FROM ActualTime actualtime ORDER BY actualtime.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT actualtime.ID,actualtime.externalID,actualtime.stateName,actualtime.totalTime,actualtime.agent_ID FROM ActualTime actualtime ORDER BY actualtime.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM ActualTime actualtime";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT actualtime.ID,actualtime.externalID,actualtime.stateName,actualtime.totalTime,actualtime.agent_ID FROM ActualTime actualtime WHERE actualtime.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT actualtime.ID FROM ActualTime actualtime WHERE actualtime.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT actualtime.ID,actualtime.externalID,actualtime.stateName,actualtime.totalTime,actualtime.agent_ID FROM ActualTime actualtime WHERE actualtime." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT actualtime.ID FROM ActualTime actualtime WHERE actualtime." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT actualtime.ID FROM ActualTime actualtime ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT actualtime.ID,actualtime.externalID,actualtime.stateName,actualtime.totalTime,actualtime.agent_ID FROM ActualTime actualtime ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO ActualTime (ID,externalID,stateName,totalTime,agent_ID) VALUES (?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE ActualTime SET externalID=?,stateName=?,totalTime=?,agent_ID=? WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM ActualTime WHERE ID=?";
	}
	
	@Override
	protected ActualTime extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	ActualTime nextResult = new ActualTime();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setExternalID(rs.getString("externalID"));

nextResult.setStateName(rs.getString("stateName"));

nextResult.setTotalTime(rs.getDouble("totalTime"));

Agent agent = new Agent();
agent.setID(rs.getString("agent_ID"));
nextResult.setAgent(agent);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(ActualTime perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getExternalID());
pstmt.setString(3, perceroObject.getStateName());
pstmt.setDouble(4, perceroObject.getTotalTime());

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
	protected void setPreparedStatmentUpdateParams(ActualTime perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getExternalID());
pstmt.setString(2, perceroObject.getStateName());
pstmt.setDouble(3, perceroObject.getTotalTime());

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
	public List<ActualTime> findByExample(ActualTime theQueryObject,
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

boolean useStateName = StringUtils.hasText(theQueryObject.getStateName()) && (excludeProperties == null || !excludeProperties.contains("stateName"));

if (useStateName)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " stateName=? ";
paramValues.add(theQueryObject.getStateName());
propertyCounter++;
}

boolean useTotalTime = theQueryObject.getTotalTime() != null && (excludeProperties == null || !excludeProperties.contains("totalTime"));

if (useTotalTime)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " totalTime=? ";
paramValues.add(theQueryObject.getTotalTime());
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
