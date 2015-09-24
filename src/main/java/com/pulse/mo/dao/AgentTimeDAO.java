
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
import com.pulse.mo.AgentTime;
import com.pulse.mo.AgentTimeEntry;
import com.pulse.mo.Agent;
import com.pulse.mo.PayrollDetail;

*/

@Component
public class AgentTimeDAO extends SqlDataAccessObject<AgentTime> implements IDataAccessObject<AgentTime> {

	static final Logger log = Logger.getLogger(AgentTimeDAO.class);

	
	public AgentTimeDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(AgentTime.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	@Override
	protected String getConnectionFactoryName() {
		return AgentTimeDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT agenttime.ID FROM AgentTime agenttime WHERE agenttime.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT agenttime.ID,agenttime.externalID,agenttime.date,agenttime.stateName,agenttime.totalTime,agenttime.payrollDetail_ID,agenttime.agent_ID FROM AgentTime agenttime WHERE agenttime.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT agenttime.ID FROM AgentTime agenttime ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT agenttime.ID FROM AgentTime agenttime ORDER BY agenttime.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT agenttime.ID,agenttime.externalID,agenttime.date,agenttime.stateName,agenttime.totalTime,agenttime.payrollDetail_ID,agenttime.agent_ID FROM AgentTime agenttime ORDER BY agenttime.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT agenttime.ID,agenttime.externalID,agenttime.date,agenttime.stateName,agenttime.totalTime,agenttime.payrollDetail_ID,agenttime.agent_ID FROM AgentTime agenttime ORDER BY agenttime.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM AgentTime agenttime";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT agenttime.ID,agenttime.externalID,agenttime.date,agenttime.stateName,agenttime.totalTime,agenttime.payrollDetail_ID,agenttime.agent_ID FROM AgentTime agenttime WHERE agenttime.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT agenttime.ID FROM AgentTime agenttime WHERE agenttime.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT agenttime.ID,agenttime.externalID,agenttime.date,agenttime.stateName,agenttime.totalTime,agenttime.payrollDetail_ID,agenttime.agent_ID FROM AgentTime agenttime WHERE agenttime." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT agenttime.ID FROM AgentTime agenttime WHERE agenttime." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT agenttime.ID FROM AgentTime agenttime ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT agenttime.ID,agenttime.externalID,agenttime.date,agenttime.stateName,agenttime.totalTime,agenttime.payrollDetail_ID,agenttime.agent_ID FROM AgentTime agenttime ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO AgentTime (ID,externalID,date,stateName,totalTime,payrollDetail_ID,agent_ID) VALUES (?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE AgentTime SET externalID=?,date=?,stateName=?,totalTime=?,payrollDetail_ID=?,agent_ID=? WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM AgentTime WHERE ID=?";
	}
	
	@Override
	protected AgentTime extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	AgentTime nextResult = new AgentTime();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setExternalID(rs.getString("externalID"));

nextResult.setDate(rs.getString("date"));

nextResult.setStateName(rs.getString("stateName"));

nextResult.setTotalTime(rs.getDouble("totalTime"));

PayrollDetail payrolldetail = new PayrollDetail();
payrolldetail.setID(rs.getString("payrolldetail_ID"));
nextResult.setPayrollDetail(payrolldetail);

Agent agent = new Agent();
agent.setID(rs.getString("agent_ID"));
nextResult.setAgent(agent);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(AgentTime perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getExternalID());
pstmt.setString(3, perceroObject.getDate());
pstmt.setString(4, perceroObject.getStateName());
pstmt.setDouble(5, perceroObject.getTotalTime());

if (perceroObject.getPayrollDetail() == null)
{
pstmt.setString(6, null);
}
else
{
		pstmt.setString(6, perceroObject.getPayrollDetail().getID());
}


if (perceroObject.getAgent() == null)
{
pstmt.setString(7, null);
}
else
{
		pstmt.setString(7, perceroObject.getAgent().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(AgentTime perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getExternalID());
pstmt.setString(2, perceroObject.getDate());
pstmt.setString(3, perceroObject.getStateName());
pstmt.setDouble(4, perceroObject.getTotalTime());

if (perceroObject.getPayrollDetail() == null)
{
pstmt.setString(5, null);
}
else
{
		pstmt.setString(5, perceroObject.getPayrollDetail().getID());
}


if (perceroObject.getAgent() == null)
{
pstmt.setString(6, null);
}
else
{
		pstmt.setString(6, perceroObject.getAgent().getID());
}

pstmt.setString(7, perceroObject.getID());

		
	}

	@Override
	public List<AgentTime> findByExample(AgentTime theQueryObject,
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

boolean useDate = StringUtils.hasText(theQueryObject.getDate()) && (excludeProperties == null || !excludeProperties.contains("date"));

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

boolean usePayrollDetailID = theQueryObject.getPayrollDetail() != null && (excludeProperties == null || !excludeProperties.contains("payrollDetail"));

if (usePayrollDetailID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " payrollDetailID=? ";
paramValues.add(theQueryObject.getPayrollDetail().getID());
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
