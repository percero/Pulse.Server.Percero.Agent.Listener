
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
import com.pulse.mo.BehaviorResponse;
import com.pulse.mo.Agent;
import com.pulse.mo.Behavior;
import com.pulse.mo.ScorecardMeasure;
import com.pulse.mo.CoachingSession;

*/

@Component
public class BehaviorResponseDAO extends SqlDataAccessObject<BehaviorResponse> implements IDataAccessObject<BehaviorResponse> {

	static final Logger log = Logger.getLogger(BehaviorResponseDAO.class);

	
	public BehaviorResponseDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(BehaviorResponse.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	@Override
	protected String getConnectionFactoryName() {
		return BehaviorResponseDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT BEHAVIOR_RESPONSE.ID FROM BEHAVIOR_RESPONSE BEHAVIOR_RESPONSE WHERE BEHAVIOR_RESPONSE.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT BEHAVIOR_RESPONSE.ID,BEHAVIOR_RESPONSE.RESPONSE,BEHAVIOR_RESPONSE.UPDATED_BY,BEHAVIOR_RESPONSE.UPDATED_ON,BEHAVIOR_RESPONSE.WEEK_DATE,BEHAVIOR_RESPONSE.CREATED_BY,BEHAVIOR_RESPONSE.CREATED_ON,BEHAVIOR_RESPONSE.AGENT_ID,BEHAVIOR_RESPONSE.BEHAVIOR_ID,BEHAVIOR_RESPONSE.COACHING_SESSION_ID,BEHAVIOR_RESPONSE.SCORECARD_MEASURE_ID FROM BEHAVIOR_RESPONSE BEHAVIOR_RESPONSE WHERE BEHAVIOR_RESPONSE.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT BEHAVIOR_RESPONSE.ID FROM BEHAVIOR_RESPONSE BEHAVIOR_RESPONSE ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT BEHAVIOR_RESPONSE.ID FROM BEHAVIOR_RESPONSE BEHAVIOR_RESPONSE ORDER BY BEHAVIOR_RESPONSE.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT BEHAVIOR_RESPONSE.ID,BEHAVIOR_RESPONSE.RESPONSE,BEHAVIOR_RESPONSE.UPDATED_BY,BEHAVIOR_RESPONSE.UPDATED_ON,BEHAVIOR_RESPONSE.WEEK_DATE,BEHAVIOR_RESPONSE.CREATED_BY,BEHAVIOR_RESPONSE.CREATED_ON,BEHAVIOR_RESPONSE.AGENT_ID,BEHAVIOR_RESPONSE.BEHAVIOR_ID,BEHAVIOR_RESPONSE.COACHING_SESSION_ID,BEHAVIOR_RESPONSE.SCORECARD_MEASURE_ID FROM BEHAVIOR_RESPONSE BEHAVIOR_RESPONSE ORDER BY BEHAVIOR_RESPONSE.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT BEHAVIOR_RESPONSE.ID,BEHAVIOR_RESPONSE.RESPONSE,BEHAVIOR_RESPONSE.UPDATED_BY,BEHAVIOR_RESPONSE.UPDATED_ON,BEHAVIOR_RESPONSE.WEEK_DATE,BEHAVIOR_RESPONSE.CREATED_BY,BEHAVIOR_RESPONSE.CREATED_ON,BEHAVIOR_RESPONSE.AGENT_ID,BEHAVIOR_RESPONSE.BEHAVIOR_ID,BEHAVIOR_RESPONSE.COACHING_SESSION_ID,BEHAVIOR_RESPONSE.SCORECARD_MEASURE_ID FROM BEHAVIOR_RESPONSE BEHAVIOR_RESPONSE ORDER BY BEHAVIOR_RESPONSE.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM BEHAVIOR_RESPONSE BEHAVIOR_RESPONSE";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT BEHAVIOR_RESPONSE.ID,BEHAVIOR_RESPONSE.RESPONSE,BEHAVIOR_RESPONSE.UPDATED_BY,BEHAVIOR_RESPONSE.UPDATED_ON,BEHAVIOR_RESPONSE.WEEK_DATE,BEHAVIOR_RESPONSE.CREATED_BY,BEHAVIOR_RESPONSE.CREATED_ON,BEHAVIOR_RESPONSE.AGENT_ID,BEHAVIOR_RESPONSE.BEHAVIOR_ID,BEHAVIOR_RESPONSE.COACHING_SESSION_ID,BEHAVIOR_RESPONSE.SCORECARD_MEASURE_ID FROM BEHAVIOR_RESPONSE BEHAVIOR_RESPONSE WHERE BEHAVIOR_RESPONSE.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT BEHAVIOR_RESPONSE.ID FROM BEHAVIOR_RESPONSE BEHAVIOR_RESPONSE WHERE BEHAVIOR_RESPONSE.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT BEHAVIOR_RESPONSE.ID,BEHAVIOR_RESPONSE.RESPONSE,BEHAVIOR_RESPONSE.UPDATED_BY,BEHAVIOR_RESPONSE.UPDATED_ON,BEHAVIOR_RESPONSE.WEEK_DATE,BEHAVIOR_RESPONSE.CREATED_BY,BEHAVIOR_RESPONSE.CREATED_ON,BEHAVIOR_RESPONSE.AGENT_ID,BEHAVIOR_RESPONSE.BEHAVIOR_ID,BEHAVIOR_RESPONSE.COACHING_SESSION_ID,BEHAVIOR_RESPONSE.SCORECARD_MEASURE_ID FROM BEHAVIOR_RESPONSE BEHAVIOR_RESPONSE WHERE BEHAVIOR_RESPONSE." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT BEHAVIOR_RESPONSE.ID FROM BEHAVIOR_RESPONSE BEHAVIOR_RESPONSE WHERE BEHAVIOR_RESPONSE." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT BEHAVIOR_RESPONSE.ID FROM BEHAVIOR_RESPONSE BEHAVIOR_RESPONSE ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT BEHAVIOR_RESPONSE.ID,BEHAVIOR_RESPONSE.RESPONSE,BEHAVIOR_RESPONSE.UPDATED_BY,BEHAVIOR_RESPONSE.UPDATED_ON,BEHAVIOR_RESPONSE.WEEK_DATE,BEHAVIOR_RESPONSE.CREATED_BY,BEHAVIOR_RESPONSE.CREATED_ON,BEHAVIOR_RESPONSE.AGENT_ID,BEHAVIOR_RESPONSE.BEHAVIOR_ID,BEHAVIOR_RESPONSE.COACHING_SESSION_ID,BEHAVIOR_RESPONSE.SCORECARD_MEASURE_ID FROM BEHAVIOR_RESPONSE BEHAVIOR_RESPONSE ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO BEHAVIOR_RESPONSE (ID,RESPONSE,UPDATED_BY,UPDATED_ON,WEEK_DATE,CREATED_BY,CREATED_ON,AGENT_ID,BEHAVIOR_ID,COACHING_SESSION_ID,SCORECARD_MEASURE_ID) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE BEHAVIOR_RESPONSE SET RESPONSE=?,UPDATED_BY=?,UPDATED_ON=?,WEEK_DATE=?,CREATED_BY=?,CREATED_ON=?,AGENT_ID=?,BEHAVIOR_ID=?,COACHING_SESSION_ID=?,SCORECARD_MEASURE_ID=? WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM BEHAVIOR_RESPONSE WHERE ID=?";
	}
	
	@Override
	protected BehaviorResponse extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	BehaviorResponse nextResult = new BehaviorResponse();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setResponse(rs.getInt("RESPONSE"));

nextResult.setUpdatedBy(rs.getString("UPDATED_BY"));

nextResult.setUpdatedOn(rs.getDate("UPDATED_ON"));

nextResult.setWeekDate(rs.getDate("WEEK_DATE"));

nextResult.setCreatedBy(rs.getString("CREATED_BY"));

nextResult.setCreatedOn(rs.getDate("CREATED_ON"));

Agent agent = new Agent();
agent.setID(rs.getString("AGENT_ID"));
nextResult.setAgent(agent);

Behavior behavior = new Behavior();
behavior.setID(rs.getString("BEHAVIOR_ID"));
nextResult.setBehavior(behavior);

CoachingSession coachingsession = new CoachingSession();
coachingsession.setID(rs.getString("COACHING_SESSION_ID"));
nextResult.setCoachingSession(coachingsession);

ScorecardMeasure scorecardmeasure = new ScorecardMeasure();
scorecardmeasure.setID(rs.getString("SCORECARD_MEASURE_ID"));
nextResult.setScorecardMeasure(scorecardmeasure);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(BehaviorResponse perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setInt(2, perceroObject.getResponse());
pstmt.setString(3, perceroObject.getUpdatedBy());
pstmt.setDate(4, DateUtils.utilDateToSqlDate(perceroObject.getUpdatedOn()));
pstmt.setDate(5, DateUtils.utilDateToSqlDate(perceroObject.getWeekDate()));
pstmt.setString(6, perceroObject.getCreatedBy());
pstmt.setDate(7, DateUtils.utilDateToSqlDate(perceroObject.getCreatedOn()));

if (perceroObject.getAgent() == null)
{
pstmt.setString(8, null);
}
else
{
		pstmt.setString(8, perceroObject.getAgent().getID());
}


if (perceroObject.getBehavior() == null)
{
pstmt.setString(9, null);
}
else
{
		pstmt.setString(9, perceroObject.getBehavior().getID());
}


if (perceroObject.getCoachingSession() == null)
{
pstmt.setString(10, null);
}
else
{
		pstmt.setString(10, perceroObject.getCoachingSession().getID());
}


if (perceroObject.getScorecardMeasure() == null)
{
pstmt.setString(11, null);
}
else
{
		pstmt.setString(11, perceroObject.getScorecardMeasure().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(BehaviorResponse perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setInt(1, perceroObject.getResponse());
pstmt.setString(2, perceroObject.getUpdatedBy());
pstmt.setDate(3, DateUtils.utilDateToSqlDate(perceroObject.getUpdatedOn()));
pstmt.setDate(4, DateUtils.utilDateToSqlDate(perceroObject.getWeekDate()));
pstmt.setString(5, perceroObject.getCreatedBy());
pstmt.setDate(6, DateUtils.utilDateToSqlDate(perceroObject.getCreatedOn()));

if (perceroObject.getAgent() == null)
{
pstmt.setString(7, null);
}
else
{
		pstmt.setString(7, perceroObject.getAgent().getID());
}


if (perceroObject.getBehavior() == null)
{
pstmt.setString(8, null);
}
else
{
		pstmt.setString(8, perceroObject.getBehavior().getID());
}


if (perceroObject.getCoachingSession() == null)
{
pstmt.setString(9, null);
}
else
{
		pstmt.setString(9, perceroObject.getCoachingSession().getID());
}


if (perceroObject.getScorecardMeasure() == null)
{
pstmt.setString(10, null);
}
else
{
		pstmt.setString(10, perceroObject.getScorecardMeasure().getID());
}

pstmt.setString(11, perceroObject.getID());

		
	}

	@Override
	public List<BehaviorResponse> findByExample(BehaviorResponse theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useResponse = theQueryObject.getResponse() != null && (excludeProperties == null || !excludeProperties.contains("response"));

if (useResponse)
{
sql += " WHERE ";
sql += " RESPONSE=? ";
paramValues.add(theQueryObject.getResponse());
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
sql += " UPDATED_BY=? ";
paramValues.add(theQueryObject.getUpdatedBy());
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
sql += " UPDATED_ON=? ";
paramValues.add(theQueryObject.getUpdatedOn());
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
sql += " WEEK_DATE=? ";
paramValues.add(theQueryObject.getWeekDate());
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
sql += " CREATED_BY=? ";
paramValues.add(theQueryObject.getCreatedBy());
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
sql += " CREATED_ON=? ";
paramValues.add(theQueryObject.getCreatedOn());
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

boolean useBehaviorID = theQueryObject.getBehavior() != null && (excludeProperties == null || !excludeProperties.contains("behavior"));

if (useBehaviorID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " BEHAVIOR_ID=? ";
paramValues.add(theQueryObject.getBehavior().getID());
propertyCounter++;
}

boolean useCoachingSessionID = theQueryObject.getCoachingSession() != null && (excludeProperties == null || !excludeProperties.contains("coachingSession"));

if (useCoachingSessionID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " COACHING_SESSION_ID=? ";
paramValues.add(theQueryObject.getCoachingSession().getID());
propertyCounter++;
}

boolean useScorecardMeasureID = theQueryObject.getScorecardMeasure() != null && (excludeProperties == null || !excludeProperties.contains("scorecardMeasure"));

if (useScorecardMeasureID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " SCORECARD_MEASURE_ID=? ";
paramValues.add(theQueryObject.getScorecardMeasure().getID());
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
