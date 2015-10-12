
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
import com.pulse.mo.DevelopmentActivity;
import com.pulse.mo.Agent;
import com.pulse.mo.DevelopmentPlan;
import com.pulse.mo.TeamLeader;

*/

@Component
public class DevelopmentActivityDAO extends SqlDataAccessObject<DevelopmentActivity> implements IDataAccessObject<DevelopmentActivity> {

	static final Logger log = Logger.getLogger(DevelopmentActivityDAO.class);

	
	public DevelopmentActivityDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(DevelopmentActivity.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	
	
	
	@Override
	protected String getConnectionFactoryName() {
		return DevelopmentActivityDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT \"DEVELOPMENT_ACTIVITY\".\"ID\" FROM \"DEVELOPMENT_ACTIVITY\" \"DEVELOPMENT_ACTIVITY\" WHERE \"DEVELOPMENT_ACTIVITY\".\"ID\"=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT \"DEVELOPMENT_ACTIVITY\".\"ID\",\"DEVELOPMENT_ACTIVITY\".\"WEEK_DATE\",\"DEVELOPMENT_ACTIVITY\".\"COMPLETED_ON\",\"DEVELOPMENT_ACTIVITY\".\"CREATED_ON\",\"DEVELOPMENT_ACTIVITY\".\"DUE_DATE\",\"DEVELOPMENT_ACTIVITY\".\"UPDATED_ON\",\"DEVELOPMENT_ACTIVITY\".\"CREATED_BY\",\"DEVELOPMENT_ACTIVITY\".\"NAME\",\"DEVELOPMENT_ACTIVITY\".\"PLAN_ID\",\"DEVELOPMENT_ACTIVITY\".\"STATUS\",\"DEVELOPMENT_ACTIVITY\".\"TYPE\",\"DEVELOPMENT_ACTIVITY\".\"UPDATED_BY\",\"DEVELOPMENT_ACTIVITY\".\"AGENT_ID\",\"DEVELOPMENT_ACTIVITY\".\"DEVELOPMENT_PLAN_ID\",\"DEVELOPMENT_ACTIVITY\".\"TEAM_LEADER_ID\" FROM \"DEVELOPMENT_ACTIVITY\" \"DEVELOPMENT_ACTIVITY\" WHERE \"DEVELOPMENT_ACTIVITY\".\"ID\"=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT \"DEVELOPMENT_ACTIVITY\".\"ID\" FROM \"DEVELOPMENT_ACTIVITY\" \"DEVELOPMENT_ACTIVITY\" ORDER BY \"ID\"";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT \"DEVELOPMENT_ACTIVITY\".\"ID\" FROM \"DEVELOPMENT_ACTIVITY\" \"DEVELOPMENT_ACTIVITY\" ORDER BY \"DEVELOPMENT_ACTIVITY\".\"ID\" LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT \"DEVELOPMENT_ACTIVITY\".\"ID\",\"DEVELOPMENT_ACTIVITY\".\"WEEK_DATE\",\"DEVELOPMENT_ACTIVITY\".\"COMPLETED_ON\",\"DEVELOPMENT_ACTIVITY\".\"CREATED_ON\",\"DEVELOPMENT_ACTIVITY\".\"DUE_DATE\",\"DEVELOPMENT_ACTIVITY\".\"UPDATED_ON\",\"DEVELOPMENT_ACTIVITY\".\"CREATED_BY\",\"DEVELOPMENT_ACTIVITY\".\"NAME\",\"DEVELOPMENT_ACTIVITY\".\"PLAN_ID\",\"DEVELOPMENT_ACTIVITY\".\"STATUS\",\"DEVELOPMENT_ACTIVITY\".\"TYPE\",\"DEVELOPMENT_ACTIVITY\".\"UPDATED_BY\",\"DEVELOPMENT_ACTIVITY\".\"AGENT_ID\",\"DEVELOPMENT_ACTIVITY\".\"DEVELOPMENT_PLAN_ID\",\"DEVELOPMENT_ACTIVITY\".\"TEAM_LEADER_ID\" FROM \"DEVELOPMENT_ACTIVITY\" \"DEVELOPMENT_ACTIVITY\" ORDER BY \"DEVELOPMENT_ACTIVITY\".\"ID\"";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT \"DEVELOPMENT_ACTIVITY\".\"ID\",\"DEVELOPMENT_ACTIVITY\".\"WEEK_DATE\",\"DEVELOPMENT_ACTIVITY\".\"COMPLETED_ON\",\"DEVELOPMENT_ACTIVITY\".\"CREATED_ON\",\"DEVELOPMENT_ACTIVITY\".\"DUE_DATE\",\"DEVELOPMENT_ACTIVITY\".\"UPDATED_ON\",\"DEVELOPMENT_ACTIVITY\".\"CREATED_BY\",\"DEVELOPMENT_ACTIVITY\".\"NAME\",\"DEVELOPMENT_ACTIVITY\".\"PLAN_ID\",\"DEVELOPMENT_ACTIVITY\".\"STATUS\",\"DEVELOPMENT_ACTIVITY\".\"TYPE\",\"DEVELOPMENT_ACTIVITY\".\"UPDATED_BY\",\"DEVELOPMENT_ACTIVITY\".\"AGENT_ID\",\"DEVELOPMENT_ACTIVITY\".\"DEVELOPMENT_PLAN_ID\",\"DEVELOPMENT_ACTIVITY\".\"TEAM_LEADER_ID\" FROM \"DEVELOPMENT_ACTIVITY\" \"DEVELOPMENT_ACTIVITY\" ORDER BY \"DEVELOPMENT_ACTIVITY\".\"ID\" LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM \"DEVELOPMENT_ACTIVITY\" \"DEVELOPMENT_ACTIVITY\"";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT \"DEVELOPMENT_ACTIVITY\".\"ID\",\"DEVELOPMENT_ACTIVITY\".\"WEEK_DATE\",\"DEVELOPMENT_ACTIVITY\".\"COMPLETED_ON\",\"DEVELOPMENT_ACTIVITY\".\"CREATED_ON\",\"DEVELOPMENT_ACTIVITY\".\"DUE_DATE\",\"DEVELOPMENT_ACTIVITY\".\"UPDATED_ON\",\"DEVELOPMENT_ACTIVITY\".\"CREATED_BY\",\"DEVELOPMENT_ACTIVITY\".\"NAME\",\"DEVELOPMENT_ACTIVITY\".\"PLAN_ID\",\"DEVELOPMENT_ACTIVITY\".\"STATUS\",\"DEVELOPMENT_ACTIVITY\".\"TYPE\",\"DEVELOPMENT_ACTIVITY\".\"UPDATED_BY\",\"DEVELOPMENT_ACTIVITY\".\"AGENT_ID\",\"DEVELOPMENT_ACTIVITY\".\"DEVELOPMENT_PLAN_ID\",\"DEVELOPMENT_ACTIVITY\".\"TEAM_LEADER_ID\" FROM \"DEVELOPMENT_ACTIVITY\" \"DEVELOPMENT_ACTIVITY\" WHERE \"DEVELOPMENT_ACTIVITY\".\"ID\" IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT \"DEVELOPMENT_ACTIVITY\".\"ID\" FROM \"DEVELOPMENT_ACTIVITY\" \"DEVELOPMENT_ACTIVITY\" WHERE \"DEVELOPMENT_ACTIVITY\".\"ID\" IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		return "SELECT \"DEVELOPMENT_ACTIVITY\".\"ID\",\"DEVELOPMENT_ACTIVITY\".\"WEEK_DATE\",\"DEVELOPMENT_ACTIVITY\".\"COMPLETED_ON\",\"DEVELOPMENT_ACTIVITY\".\"CREATED_ON\",\"DEVELOPMENT_ACTIVITY\".\"DUE_DATE\",\"DEVELOPMENT_ACTIVITY\".\"UPDATED_ON\",\"DEVELOPMENT_ACTIVITY\".\"CREATED_BY\",\"DEVELOPMENT_ACTIVITY\".\"NAME\",\"DEVELOPMENT_ACTIVITY\".\"PLAN_ID\",\"DEVELOPMENT_ACTIVITY\".\"STATUS\",\"DEVELOPMENT_ACTIVITY\".\"TYPE\",\"DEVELOPMENT_ACTIVITY\".\"UPDATED_BY\",\"DEVELOPMENT_ACTIVITY\".\"AGENT_ID\",\"DEVELOPMENT_ACTIVITY\".\"DEVELOPMENT_PLAN_ID\",\"DEVELOPMENT_ACTIVITY\".\"TEAM_LEADER_ID\" FROM \"DEVELOPMENT_ACTIVITY\" \"DEVELOPMENT_ACTIVITY\" WHERE \"DEVELOPMENT_ACTIVITY\"." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT \"DEVELOPMENT_ACTIVITY\".\"ID\" FROM \"DEVELOPMENT_ACTIVITY\" \"DEVELOPMENT_ACTIVITY\" WHERE \"DEVELOPMENT_ACTIVITY\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT \"DEVELOPMENT_ACTIVITY\".\"ID\" FROM \"DEVELOPMENT_ACTIVITY\" \"DEVELOPMENT_ACTIVITY\" ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT \"DEVELOPMENT_ACTIVITY\".\"ID\",\"DEVELOPMENT_ACTIVITY\".\"WEEK_DATE\",\"DEVELOPMENT_ACTIVITY\".\"COMPLETED_ON\",\"DEVELOPMENT_ACTIVITY\".\"CREATED_ON\",\"DEVELOPMENT_ACTIVITY\".\"DUE_DATE\",\"DEVELOPMENT_ACTIVITY\".\"UPDATED_ON\",\"DEVELOPMENT_ACTIVITY\".\"CREATED_BY\",\"DEVELOPMENT_ACTIVITY\".\"NAME\",\"DEVELOPMENT_ACTIVITY\".\"PLAN_ID\",\"DEVELOPMENT_ACTIVITY\".\"STATUS\",\"DEVELOPMENT_ACTIVITY\".\"TYPE\",\"DEVELOPMENT_ACTIVITY\".\"UPDATED_BY\",\"DEVELOPMENT_ACTIVITY\".\"AGENT_ID\",\"DEVELOPMENT_ACTIVITY\".\"DEVELOPMENT_PLAN_ID\",\"DEVELOPMENT_ACTIVITY\".\"TEAM_LEADER_ID\" FROM \"DEVELOPMENT_ACTIVITY\" \"DEVELOPMENT_ACTIVITY\" ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO DEVELOPMENT_ACTIVITY (\"ID\",\"WEEK_DATE\",\"COMPLETED_ON\",\"CREATED_ON\",\"DUE_DATE\",\"UPDATED_ON\",\"CREATED_BY\",\"NAME\",\"PLAN_ID\",\"STATUS\",\"TYPE\",\"UPDATED_BY\",\"AGENT_ID\",\"DEVELOPMENT_PLAN_ID\",\"TEAM_LEADER_ID\") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE \"DEVELOPMENT_ACTIVITY\" SET \"WEEK_DATE\"=?,\"COMPLETED_ON\"=?,\"CREATED_ON\"=?,\"DUE_DATE\"=?,\"UPDATED_ON\"=?,\"CREATED_BY\"=?,\"NAME\"=?,\"PLAN_ID\"=?,\"STATUS\"=?,\"TYPE\"=?,\"UPDATED_BY\"=?,\"AGENT_ID\"=?,\"DEVELOPMENT_PLAN_ID\"=?,\"TEAM_LEADER_ID\"=? WHERE \"ID\"=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM \"DEVELOPMENT_ACTIVITY\" WHERE \"ID\"=?";
	}
	
	@Override
	protected DevelopmentActivity extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	DevelopmentActivity nextResult = new DevelopmentActivity();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setWeekDate(rs.getDate("WEEK_DATE"));

nextResult.setCompletedOn(rs.getDate("COMPLETED_ON"));

nextResult.setCreatedOn(rs.getDate("CREATED_ON"));

nextResult.setDueDate(rs.getDate("DUE_DATE"));

nextResult.setUpdatedOn(rs.getDate("UPDATED_ON"));

nextResult.setCreatedBy(rs.getString("CREATED_BY"));

nextResult.setName(rs.getString("NAME"));

nextResult.setPlanId(rs.getString("PLAN_ID"));

nextResult.setStatus(rs.getString("STATUS"));

nextResult.setType(rs.getString("TYPE"));

nextResult.setUpdatedBy(rs.getString("UPDATED_BY"));

Agent agent = new Agent();
agent.setID(rs.getString("AGENT_ID"));
nextResult.setAgent(agent);

DevelopmentPlan developmentplan = new DevelopmentPlan();
developmentplan.setID(rs.getString("DEVELOPMENT_PLAN_ID"));
nextResult.setDevelopmentPlan(developmentplan);

TeamLeader teamleader = new TeamLeader();
teamleader.setID(rs.getString("TEAM_LEADER_ID"));
nextResult.setTeamLeader(teamleader);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(DevelopmentActivity perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setDate(2, DateUtils.utilDateToSqlDate(perceroObject.getWeekDate()));
pstmt.setDate(3, DateUtils.utilDateToSqlDate(perceroObject.getCompletedOn()));
pstmt.setDate(4, DateUtils.utilDateToSqlDate(perceroObject.getCreatedOn()));
pstmt.setDate(5, DateUtils.utilDateToSqlDate(perceroObject.getDueDate()));
pstmt.setDate(6, DateUtils.utilDateToSqlDate(perceroObject.getUpdatedOn()));
pstmt.setString(7, perceroObject.getCreatedBy());
pstmt.setString(8, perceroObject.getName());
pstmt.setString(9, perceroObject.getPlanId());
pstmt.setString(10, perceroObject.getStatus());
pstmt.setString(11, perceroObject.getType());
pstmt.setString(12, perceroObject.getUpdatedBy());

if (perceroObject.getAgent() == null)
{
pstmt.setString(13, null);
}
else
{
		pstmt.setString(13, perceroObject.getAgent().getID());
}


if (perceroObject.getDevelopmentPlan() == null)
{
pstmt.setString(14, null);
}
else
{
		pstmt.setString(14, perceroObject.getDevelopmentPlan().getID());
}


if (perceroObject.getTeamLeader() == null)
{
pstmt.setString(15, null);
}
else
{
		pstmt.setString(15, perceroObject.getTeamLeader().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(DevelopmentActivity perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setDate(1, DateUtils.utilDateToSqlDate(perceroObject.getWeekDate()));
pstmt.setDate(2, DateUtils.utilDateToSqlDate(perceroObject.getCompletedOn()));
pstmt.setDate(3, DateUtils.utilDateToSqlDate(perceroObject.getCreatedOn()));
pstmt.setDate(4, DateUtils.utilDateToSqlDate(perceroObject.getDueDate()));
pstmt.setDate(5, DateUtils.utilDateToSqlDate(perceroObject.getUpdatedOn()));
pstmt.setString(6, perceroObject.getCreatedBy());
pstmt.setString(7, perceroObject.getName());
pstmt.setString(8, perceroObject.getPlanId());
pstmt.setString(9, perceroObject.getStatus());
pstmt.setString(10, perceroObject.getType());
pstmt.setString(11, perceroObject.getUpdatedBy());

if (perceroObject.getAgent() == null)
{
pstmt.setString(12, null);
}
else
{
		pstmt.setString(12, perceroObject.getAgent().getID());
}


if (perceroObject.getDevelopmentPlan() == null)
{
pstmt.setString(13, null);
}
else
{
		pstmt.setString(13, perceroObject.getDevelopmentPlan().getID());
}


if (perceroObject.getTeamLeader() == null)
{
pstmt.setString(14, null);
}
else
{
		pstmt.setString(14, perceroObject.getTeamLeader().getID());
}

pstmt.setString(15, perceroObject.getID());

		
	}

	@Override
	public List<DevelopmentActivity> findByExample(DevelopmentActivity theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useWeekDate = theQueryObject.getWeekDate() != null && (excludeProperties == null || !excludeProperties.contains("weekDate"));

if (useWeekDate)
{
sql += " WHERE ";
sql += " \"WEEK_DATE\" =? ";
paramValues.add(theQueryObject.getWeekDate());
propertyCounter++;
}

boolean useCompletedOn = theQueryObject.getCompletedOn() != null && (excludeProperties == null || !excludeProperties.contains("completedOn"));

if (useCompletedOn)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"COMPLETED_ON\" =? ";
paramValues.add(theQueryObject.getCompletedOn());
propertyCounter++;
}

boolean useCreatedOn = theQueryObject.getCreatedOn() != null && (excludeProperties == null || !excludeProperties.contains("createdOn"));

if (useCreatedOn)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"CREATED_ON\" =? ";
paramValues.add(theQueryObject.getCreatedOn());
propertyCounter++;
}

boolean useDueDate = theQueryObject.getDueDate() != null && (excludeProperties == null || !excludeProperties.contains("dueDate"));

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
sql += " \"DUE_DATE\" =? ";
paramValues.add(theQueryObject.getDueDate());
propertyCounter++;
}

boolean useUpdatedOn = theQueryObject.getUpdatedOn() != null && (excludeProperties == null || !excludeProperties.contains("updatedOn"));

if (useUpdatedOn)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"UPDATED_ON\" =? ";
paramValues.add(theQueryObject.getUpdatedOn());
propertyCounter++;
}

boolean useCreatedBy = StringUtils.hasText(theQueryObject.getCreatedBy()) && (excludeProperties == null || !excludeProperties.contains("createdBy"));

if (useCreatedBy)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"CREATED_BY\" =? ";
paramValues.add(theQueryObject.getCreatedBy());
propertyCounter++;
}

boolean useName = StringUtils.hasText(theQueryObject.getName()) && (excludeProperties == null || !excludeProperties.contains("name"));

if (useName)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"NAME\" =? ";
paramValues.add(theQueryObject.getName());
propertyCounter++;
}

boolean usePlanId = StringUtils.hasText(theQueryObject.getPlanId()) && (excludeProperties == null || !excludeProperties.contains("planId"));

if (usePlanId)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"PLAN_ID\" =? ";
paramValues.add(theQueryObject.getPlanId());
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

boolean useType = StringUtils.hasText(theQueryObject.getType()) && (excludeProperties == null || !excludeProperties.contains("type"));

if (useType)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"TYPE\" =? ";
paramValues.add(theQueryObject.getType());
propertyCounter++;
}

boolean useUpdatedBy = StringUtils.hasText(theQueryObject.getUpdatedBy()) && (excludeProperties == null || !excludeProperties.contains("updatedBy"));

if (useUpdatedBy)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"UPDATED_BY\" =? ";
paramValues.add(theQueryObject.getUpdatedBy());
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

boolean useDevelopmentPlanID = theQueryObject.getDevelopmentPlan() != null && (excludeProperties == null || !excludeProperties.contains("developmentPlan"));

if (useDevelopmentPlanID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"DEVELOPMENT_PLAN_ID\" =? ";
paramValues.add(theQueryObject.getDevelopmentPlan().getID());
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
