
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
import com.pulse.mo.ScheduledTime;
import com.pulse.mo.ScheduledTimeEntry;
import com.pulse.mo.Agent;

*/

@Component
public class ScheduledTimeDAO extends SqlDataAccessObject<ScheduledTime> implements IDataAccessObject<ScheduledTime> {

	static final Logger log = Logger.getLogger(ScheduledTimeDAO.class);

	
	public ScheduledTimeDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(ScheduledTime.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	@Override
	protected String getConnectionFactoryName() {
		return ScheduledTimeDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT SCHEDULED_TIME.ID FROM SCHEDULED_TIME SCHEDULED_TIME WHERE SCHEDULED_TIME.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT SCHEDULED_TIME.ID,SCHEDULED_TIME.TOTAL_TIME,SCHEDULED_TIME.STATE_NAME,SCHEDULED_TIME.AGENT_ID FROM SCHEDULED_TIME SCHEDULED_TIME WHERE SCHEDULED_TIME.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT SCHEDULED_TIME.ID FROM SCHEDULED_TIME SCHEDULED_TIME ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT SCHEDULED_TIME.ID FROM SCHEDULED_TIME SCHEDULED_TIME ORDER BY SCHEDULED_TIME.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT SCHEDULED_TIME.ID,SCHEDULED_TIME.TOTAL_TIME,SCHEDULED_TIME.STATE_NAME,SCHEDULED_TIME.AGENT_ID FROM SCHEDULED_TIME SCHEDULED_TIME ORDER BY SCHEDULED_TIME.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT SCHEDULED_TIME.ID,SCHEDULED_TIME.TOTAL_TIME,SCHEDULED_TIME.STATE_NAME,SCHEDULED_TIME.AGENT_ID FROM SCHEDULED_TIME SCHEDULED_TIME ORDER BY SCHEDULED_TIME.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM SCHEDULED_TIME SCHEDULED_TIME";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT SCHEDULED_TIME.ID,SCHEDULED_TIME.TOTAL_TIME,SCHEDULED_TIME.STATE_NAME,SCHEDULED_TIME.AGENT_ID FROM SCHEDULED_TIME SCHEDULED_TIME WHERE SCHEDULED_TIME.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT SCHEDULED_TIME.ID FROM SCHEDULED_TIME SCHEDULED_TIME WHERE SCHEDULED_TIME.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT SCHEDULED_TIME.ID,SCHEDULED_TIME.TOTAL_TIME,SCHEDULED_TIME.STATE_NAME,SCHEDULED_TIME.AGENT_ID FROM SCHEDULED_TIME SCHEDULED_TIME WHERE SCHEDULED_TIME." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT SCHEDULED_TIME.ID FROM SCHEDULED_TIME SCHEDULED_TIME WHERE SCHEDULED_TIME." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT SCHEDULED_TIME.ID FROM SCHEDULED_TIME SCHEDULED_TIME ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT SCHEDULED_TIME.ID,SCHEDULED_TIME.TOTAL_TIME,SCHEDULED_TIME.STATE_NAME,SCHEDULED_TIME.AGENT_ID FROM SCHEDULED_TIME SCHEDULED_TIME ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO SCHEDULED_TIME (ID,TOTAL_TIME,STATE_NAME,AGENT_ID) VALUES (?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE SCHEDULED_TIME SET TOTAL_TIME=?,STATE_NAME=?,AGENT_ID WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM SCHEDULED_TIME WHERE ID=?";
	}
	
	@Override
	protected ScheduledTime extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	ScheduledTime nextResult = new ScheduledTime();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setTotalTime(rs.getDouble("TOTAL_TIME"));

nextResult.setStateName(rs.getString("STATE_NAME"));

Agent agent = new Agent();
agent.setID(rs.getString("AGENT_ID"));
nextResult.setAgent(agent);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(ScheduledTime perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setDouble(2, perceroObject.getTotalTime());
pstmt.setString(3, perceroObject.getStateName());

if (perceroObject.getAgent() == null)
{
pstmt.setString(4, null);
}
else
{
		pstmt.setString(4, perceroObject.getAgent().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(ScheduledTime perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setDouble(1, perceroObject.getTotalTime());
pstmt.setString(2, perceroObject.getStateName());

if (perceroObject.getAgent() == null)
{
pstmt.setString(3, null);
}
else
{
		pstmt.setString(3, perceroObject.getAgent().getID());
}

pstmt.setString(4, perceroObject.getID());

		
	}

	@Override
	public List<ScheduledTime> findByExample(ScheduledTime theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useTotalTime = theQueryObject.getTotalTime() != null && (excludeProperties == null || !excludeProperties.contains("totalTime"));

if (useTotalTime)
{
sql += " WHERE ";
sql += " TOTAL_TIME=? ";
paramValues.add(theQueryObject.getTotalTime());
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
sql += " STATE_NAME=? ";
paramValues.add(theQueryObject.getStateName());
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
