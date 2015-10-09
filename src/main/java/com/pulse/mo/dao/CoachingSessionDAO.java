
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
import com.pulse.mo.CoachingSession;
import com.pulse.mo.Attachment;
import com.pulse.mo.BehaviorResponse;
import com.pulse.mo.QualityEvaluation;
import com.pulse.mo.CoachingSessionState;
import com.pulse.mo.Agent;
import com.pulse.mo.Scorecard;

*/

@Component
public class CoachingSessionDAO extends SqlDataAccessObject<CoachingSession> implements IDataAccessObject<CoachingSession> {

	static final Logger log = Logger.getLogger(CoachingSessionDAO.class);

	
	public CoachingSessionDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(CoachingSession.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	@Override
	protected String getConnectionFactoryName() {
		return CoachingSessionDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT COACHING_SESSION.ID FROM COACHING_SESSION COACHING_SESSION WHERE COACHING_SESSION.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT COACHING_SESSION.ID,COACHING_SESSION.IS_REQUIRED,COACHING_SESSION.MTD_TREND,COACHING_SESSION.PREVIOUS_MTD_OVERALL_SCORE,COACHING_SESSION.PREVIOUS_MTD_THRESHOLD_GRADE,COACHING_SESSION.CREATED_BY,COACHING_SESSION.CREATED_ON,COACHING_SESSION.CURRENT_MTD_OVERALL_SCORE,COACHING_SESSION.CURRENT_MTD_THRESHOLD_GRADE,COACHING_SESSION.TYPE,COACHING_SESSION.UPDATED_BY,COACHING_SESSION.UPDATED_ON,COACHING_SESSION.WEEKEND_DATE,COACHING_SESSION.WEEKLY_OVERALL_SCORE,COACHING_SESSION.WEEKLY_OVERALL_SCORE_STATE_NAME,COACHING_SESSION.WEEKLY_TREND,COACHING_SESSION.CLOSED_ON,COACHING_SESSION.COACHING_SESSION_STATE_ID,COACHING_SESSION.AGENT_ID,COACHING_SESSION.SCORECARD_ID FROM COACHING_SESSION COACHING_SESSION WHERE COACHING_SESSION.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT COACHING_SESSION.ID FROM COACHING_SESSION COACHING_SESSION ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT COACHING_SESSION.ID FROM COACHING_SESSION COACHING_SESSION ORDER BY COACHING_SESSION.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT COACHING_SESSION.ID,COACHING_SESSION.IS_REQUIRED,COACHING_SESSION.MTD_TREND,COACHING_SESSION.PREVIOUS_MTD_OVERALL_SCORE,COACHING_SESSION.PREVIOUS_MTD_THRESHOLD_GRADE,COACHING_SESSION.CREATED_BY,COACHING_SESSION.CREATED_ON,COACHING_SESSION.CURRENT_MTD_OVERALL_SCORE,COACHING_SESSION.CURRENT_MTD_THRESHOLD_GRADE,COACHING_SESSION.TYPE,COACHING_SESSION.UPDATED_BY,COACHING_SESSION.UPDATED_ON,COACHING_SESSION.WEEKEND_DATE,COACHING_SESSION.WEEKLY_OVERALL_SCORE,COACHING_SESSION.WEEKLY_OVERALL_SCORE_STATE_NAME,COACHING_SESSION.WEEKLY_TREND,COACHING_SESSION.CLOSED_ON,COACHING_SESSION.COACHING_SESSION_STATE_ID,COACHING_SESSION.AGENT_ID,COACHING_SESSION.SCORECARD_ID FROM COACHING_SESSION COACHING_SESSION ORDER BY COACHING_SESSION.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT COACHING_SESSION.ID,COACHING_SESSION.IS_REQUIRED,COACHING_SESSION.MTD_TREND,COACHING_SESSION.PREVIOUS_MTD_OVERALL_SCORE,COACHING_SESSION.PREVIOUS_MTD_THRESHOLD_GRADE,COACHING_SESSION.CREATED_BY,COACHING_SESSION.CREATED_ON,COACHING_SESSION.CURRENT_MTD_OVERALL_SCORE,COACHING_SESSION.CURRENT_MTD_THRESHOLD_GRADE,COACHING_SESSION.TYPE,COACHING_SESSION.UPDATED_BY,COACHING_SESSION.UPDATED_ON,COACHING_SESSION.WEEKEND_DATE,COACHING_SESSION.WEEKLY_OVERALL_SCORE,COACHING_SESSION.WEEKLY_OVERALL_SCORE_STATE_NAME,COACHING_SESSION.WEEKLY_TREND,COACHING_SESSION.CLOSED_ON,COACHING_SESSION.COACHING_SESSION_STATE_ID,COACHING_SESSION.AGENT_ID,COACHING_SESSION.SCORECARD_ID FROM COACHING_SESSION COACHING_SESSION ORDER BY COACHING_SESSION.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM COACHING_SESSION COACHING_SESSION";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT COACHING_SESSION.ID,COACHING_SESSION.IS_REQUIRED,COACHING_SESSION.MTD_TREND,COACHING_SESSION.PREVIOUS_MTD_OVERALL_SCORE,COACHING_SESSION.PREVIOUS_MTD_THRESHOLD_GRADE,COACHING_SESSION.CREATED_BY,COACHING_SESSION.CREATED_ON,COACHING_SESSION.CURRENT_MTD_OVERALL_SCORE,COACHING_SESSION.CURRENT_MTD_THRESHOLD_GRADE,COACHING_SESSION.TYPE,COACHING_SESSION.UPDATED_BY,COACHING_SESSION.UPDATED_ON,COACHING_SESSION.WEEKEND_DATE,COACHING_SESSION.WEEKLY_OVERALL_SCORE,COACHING_SESSION.WEEKLY_OVERALL_SCORE_STATE_NAME,COACHING_SESSION.WEEKLY_TREND,COACHING_SESSION.CLOSED_ON,COACHING_SESSION.COACHING_SESSION_STATE_ID,COACHING_SESSION.AGENT_ID,COACHING_SESSION.SCORECARD_ID FROM COACHING_SESSION COACHING_SESSION WHERE COACHING_SESSION.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT COACHING_SESSION.ID FROM COACHING_SESSION COACHING_SESSION WHERE COACHING_SESSION.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT COACHING_SESSION.ID,COACHING_SESSION.IS_REQUIRED,COACHING_SESSION.MTD_TREND,COACHING_SESSION.PREVIOUS_MTD_OVERALL_SCORE,COACHING_SESSION.PREVIOUS_MTD_THRESHOLD_GRADE,COACHING_SESSION.CREATED_BY,COACHING_SESSION.CREATED_ON,COACHING_SESSION.CURRENT_MTD_OVERALL_SCORE,COACHING_SESSION.CURRENT_MTD_THRESHOLD_GRADE,COACHING_SESSION.TYPE,COACHING_SESSION.UPDATED_BY,COACHING_SESSION.UPDATED_ON,COACHING_SESSION.WEEKEND_DATE,COACHING_SESSION.WEEKLY_OVERALL_SCORE,COACHING_SESSION.WEEKLY_OVERALL_SCORE_STATE_NAME,COACHING_SESSION.WEEKLY_TREND,COACHING_SESSION.CLOSED_ON,COACHING_SESSION.COACHING_SESSION_STATE_ID,COACHING_SESSION.AGENT_ID,COACHING_SESSION.SCORECARD_ID FROM COACHING_SESSION COACHING_SESSION WHERE COACHING_SESSION." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT COACHING_SESSION.ID FROM COACHING_SESSION COACHING_SESSION WHERE COACHING_SESSION." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT COACHING_SESSION.ID FROM COACHING_SESSION COACHING_SESSION ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT COACHING_SESSION.ID,COACHING_SESSION.IS_REQUIRED,COACHING_SESSION.MTD_TREND,COACHING_SESSION.PREVIOUS_MTD_OVERALL_SCORE,COACHING_SESSION.PREVIOUS_MTD_THRESHOLD_GRADE,COACHING_SESSION.CREATED_BY,COACHING_SESSION.CREATED_ON,COACHING_SESSION.CURRENT_MTD_OVERALL_SCORE,COACHING_SESSION.CURRENT_MTD_THRESHOLD_GRADE,COACHING_SESSION.TYPE,COACHING_SESSION.UPDATED_BY,COACHING_SESSION.UPDATED_ON,COACHING_SESSION.WEEKEND_DATE,COACHING_SESSION.WEEKLY_OVERALL_SCORE,COACHING_SESSION.WEEKLY_OVERALL_SCORE_STATE_NAME,COACHING_SESSION.WEEKLY_TREND,COACHING_SESSION.CLOSED_ON,COACHING_SESSION.COACHING_SESSION_STATE_ID,COACHING_SESSION.AGENT_ID,COACHING_SESSION.SCORECARD_ID FROM COACHING_SESSION COACHING_SESSION ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO COACHING_SESSION (ID,IS_REQUIRED,MTD_TREND,PREVIOUS_MTD_OVERALL_SCORE,PREVIOUS_MTD_THRESHOLD_GRADE,CREATED_BY,CREATED_ON,CURRENT_MTD_OVERALL_SCORE,CURRENT_MTD_THRESHOLD_GRADE,TYPE,UPDATED_BY,UPDATED_ON,WEEKEND_DATE,WEEKLY_OVERALL_SCORE,WEEKLY_OVERALL_SCORE_STATE_NAME,WEEKLY_TREND,CLOSED_ON,COACHING_SESSION_STATE_ID,AGENT_ID,SCORECARD_ID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE COACHING_SESSION SET IS_REQUIRED=?,MTD_TREND=?,PREVIOUS_MTD_OVERALL_SCORE=?,PREVIOUS_MTD_THRESHOLD_GRADE=?,CREATED_BY=?,CREATED_ON=?,CURRENT_MTD_OVERALL_SCORE=?,CURRENT_MTD_THRESHOLD_GRADE=?,TYPE=?,UPDATED_BY=?,UPDATED_ON=?,WEEKEND_DATE=?,WEEKLY_OVERALL_SCORE=?,WEEKLY_OVERALL_SCORE_STATE_NAME=?,WEEKLY_TREND=?,CLOSED_ON=?,COACHING_SESSION_STATE_ID=?,AGENT_ID=?,SCORECARD_ID=? WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM COACHING_SESSION WHERE ID=?";
	}
	
	@Override
	protected CoachingSession extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	CoachingSession nextResult = new CoachingSession();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setIsRequired(rs.getBoolean("IS_REQUIRED"));

nextResult.setMTDTrend(rs.getString("MTD_TREND"));

nextResult.setPreviousMTDOverallScore(rs.getString("PREVIOUS_MTD_OVERALL_SCORE"));

nextResult.setPreviousMTDThresholdGrade(rs.getDouble("PREVIOUS_MTD_THRESHOLD_GRADE"));

nextResult.setCreatedBy(rs.getString("CREATED_BY"));

nextResult.setCreatedOn(rs.getDate("CREATED_ON"));

nextResult.setCurrentMTDOverallScore(rs.getString("CURRENT_MTD_OVERALL_SCORE"));

nextResult.setCurrentMTDThresholdGrade(rs.getDouble("CURRENT_MTD_THRESHOLD_GRADE"));

nextResult.setType(rs.getString("TYPE"));

nextResult.setUpdatedBy(rs.getString("UPDATED_BY"));

nextResult.setUpdatedOn(rs.getDate("UPDATED_ON"));

nextResult.setWeekendDate(rs.getString("WEEKEND_DATE"));

nextResult.setWeeklyOverallScore(rs.getString("WEEKLY_OVERALL_SCORE"));

nextResult.setWeeklyOverallScoreStateName(rs.getString("WEEKLY_OVERALL_SCORE_STATE_NAME"));

nextResult.setWeeklyTrend(rs.getString("WEEKLY_TREND"));

nextResult.setClosedOn(rs.getDate("CLOSED_ON"));

CoachingSessionState coachingsessionstate = new CoachingSessionState();
coachingsessionstate.setID(rs.getString("COACHING_SESSION_STATE_ID"));
nextResult.setCoachingSessionState(coachingsessionstate);

Agent agent = new Agent();
agent.setID(rs.getString("AGENT_ID"));
nextResult.setAgent(agent);

Scorecard scorecard = new Scorecard();
scorecard.setID(rs.getString("SCORECARD_ID"));
nextResult.setScorecard(scorecard);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(CoachingSession perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setBoolean(2, perceroObject.getIsRequired());
pstmt.setString(3, perceroObject.getMTDTrend());
pstmt.setString(4, perceroObject.getPreviousMTDOverallScore());
pstmt.setDouble(5, perceroObject.getPreviousMTDThresholdGrade());
pstmt.setString(6, perceroObject.getCreatedBy());
pstmt.setDate(7, DateUtils.utilDateToSqlDate(perceroObject.getCreatedOn()));
pstmt.setString(8, perceroObject.getCurrentMTDOverallScore());
pstmt.setDouble(9, perceroObject.getCurrentMTDThresholdGrade());
pstmt.setString(10, perceroObject.getType());
pstmt.setString(11, perceroObject.getUpdatedBy());
pstmt.setDate(12, DateUtils.utilDateToSqlDate(perceroObject.getUpdatedOn()));
pstmt.setString(13, perceroObject.getWeekendDate());
pstmt.setString(14, perceroObject.getWeeklyOverallScore());
pstmt.setString(15, perceroObject.getWeeklyOverallScoreStateName());
pstmt.setString(16, perceroObject.getWeeklyTrend());
pstmt.setDate(17, DateUtils.utilDateToSqlDate(perceroObject.getClosedOn()));

if (perceroObject.getCoachingSessionState() == null)
{
pstmt.setString(18, null);
}
else
{
		pstmt.setString(18, perceroObject.getCoachingSessionState().getID());
}


if (perceroObject.getAgent() == null)
{
pstmt.setString(19, null);
}
else
{
		pstmt.setString(19, perceroObject.getAgent().getID());
}


if (perceroObject.getScorecard() == null)
{
pstmt.setString(20, null);
}
else
{
		pstmt.setString(20, perceroObject.getScorecard().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(CoachingSession perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setBoolean(1, perceroObject.getIsRequired());
pstmt.setString(2, perceroObject.getMTDTrend());
pstmt.setString(3, perceroObject.getPreviousMTDOverallScore());
pstmt.setDouble(4, perceroObject.getPreviousMTDThresholdGrade());
pstmt.setString(5, perceroObject.getCreatedBy());
pstmt.setDate(6, DateUtils.utilDateToSqlDate(perceroObject.getCreatedOn()));
pstmt.setString(7, perceroObject.getCurrentMTDOverallScore());
pstmt.setDouble(8, perceroObject.getCurrentMTDThresholdGrade());
pstmt.setString(9, perceroObject.getType());
pstmt.setString(10, perceroObject.getUpdatedBy());
pstmt.setDate(11, DateUtils.utilDateToSqlDate(perceroObject.getUpdatedOn()));
pstmt.setString(12, perceroObject.getWeekendDate());
pstmt.setString(13, perceroObject.getWeeklyOverallScore());
pstmt.setString(14, perceroObject.getWeeklyOverallScoreStateName());
pstmt.setString(15, perceroObject.getWeeklyTrend());
pstmt.setDate(16, DateUtils.utilDateToSqlDate(perceroObject.getClosedOn()));

if (perceroObject.getCoachingSessionState() == null)
{
pstmt.setString(17, null);
}
else
{
		pstmt.setString(17, perceroObject.getCoachingSessionState().getID());
}


if (perceroObject.getAgent() == null)
{
pstmt.setString(18, null);
}
else
{
		pstmt.setString(18, perceroObject.getAgent().getID());
}


if (perceroObject.getScorecard() == null)
{
pstmt.setString(19, null);
}
else
{
		pstmt.setString(19, perceroObject.getScorecard().getID());
}

pstmt.setString(20, perceroObject.getID());

		
	}

	@Override
	public List<CoachingSession> findByExample(CoachingSession theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useIsRequired = theQueryObject.getIsRequired() != null && (excludeProperties == null || !excludeProperties.contains("isRequired"));

if (useIsRequired)
{
sql += " WHERE ";
sql += " IS_REQUIRED=? ";
paramValues.add(theQueryObject.getIsRequired());
propertyCounter++;
}

boolean useMTDTrend = StringUtils.hasText(theQueryObject.getMTDTrend()) && (excludeProperties == null || !excludeProperties.contains("mTDTrend"));

if (useMTDTrend)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " MTD_TREND=? ";
paramValues.add(theQueryObject.getMTDTrend());
propertyCounter++;
}

boolean usePreviousMTDOverallScore = StringUtils.hasText(theQueryObject.getPreviousMTDOverallScore()) && (excludeProperties == null || !excludeProperties.contains("previousMTDOverallScore"));

if (usePreviousMTDOverallScore)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " PREVIOUS_MTD_OVERALL_SCORE=? ";
paramValues.add(theQueryObject.getPreviousMTDOverallScore());
propertyCounter++;
}

boolean usePreviousMTDThresholdGrade = theQueryObject.getPreviousMTDThresholdGrade() != null && (excludeProperties == null || !excludeProperties.contains("previousMTDThresholdGrade"));

if (usePreviousMTDThresholdGrade)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " PREVIOUS_MTD_THRESHOLD_GRADE=? ";
paramValues.add(theQueryObject.getPreviousMTDThresholdGrade());
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

boolean useCurrentMTDOverallScore = StringUtils.hasText(theQueryObject.getCurrentMTDOverallScore()) && (excludeProperties == null || !excludeProperties.contains("currentMTDOverallScore"));

if (useCurrentMTDOverallScore)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " CURRENT_MTD_OVERALL_SCORE=? ";
paramValues.add(theQueryObject.getCurrentMTDOverallScore());
propertyCounter++;
}

boolean useCurrentMTDThresholdGrade = theQueryObject.getCurrentMTDThresholdGrade() != null && (excludeProperties == null || !excludeProperties.contains("currentMTDThresholdGrade"));

if (useCurrentMTDThresholdGrade)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " CURRENT_MTD_THRESHOLD_GRADE=? ";
paramValues.add(theQueryObject.getCurrentMTDThresholdGrade());
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
sql += " TYPE=? ";
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

boolean useWeekendDate = StringUtils.hasText(theQueryObject.getWeekendDate()) && (excludeProperties == null || !excludeProperties.contains("weekendDate"));

if (useWeekendDate)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " WEEKEND_DATE=? ";
paramValues.add(theQueryObject.getWeekendDate());
propertyCounter++;
}

boolean useWeeklyOverallScore = StringUtils.hasText(theQueryObject.getWeeklyOverallScore()) && (excludeProperties == null || !excludeProperties.contains("weeklyOverallScore"));

if (useWeeklyOverallScore)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " WEEKLY_OVERALL_SCORE=? ";
paramValues.add(theQueryObject.getWeeklyOverallScore());
propertyCounter++;
}

boolean useWeeklyOverallScoreStateName = StringUtils.hasText(theQueryObject.getWeeklyOverallScoreStateName()) && (excludeProperties == null || !excludeProperties.contains("weeklyOverallScoreStateName"));

if (useWeeklyOverallScoreStateName)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " WEEKLY_OVERALL_SCORE_STATE_NAME=? ";
paramValues.add(theQueryObject.getWeeklyOverallScoreStateName());
propertyCounter++;
}

boolean useWeeklyTrend = StringUtils.hasText(theQueryObject.getWeeklyTrend()) && (excludeProperties == null || !excludeProperties.contains("weeklyTrend"));

if (useWeeklyTrend)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " WEEKLY_TREND=? ";
paramValues.add(theQueryObject.getWeeklyTrend());
propertyCounter++;
}

boolean useClosedOn = theQueryObject.getClosedOn() != null && (excludeProperties == null || !excludeProperties.contains("closedOn"));

if (useClosedOn)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " CLOSED_ON=? ";
paramValues.add(theQueryObject.getClosedOn());
propertyCounter++;
}

boolean useCoachingSessionStateID = theQueryObject.getCoachingSessionState() != null && (excludeProperties == null || !excludeProperties.contains("coachingSessionState"));

if (useCoachingSessionStateID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " COACHING_SESSION_STATE_ID=? ";
paramValues.add(theQueryObject.getCoachingSessionState().getID());
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

boolean useScorecardID = theQueryObject.getScorecard() != null && (excludeProperties == null || !excludeProperties.contains("scorecard"));

if (useScorecardID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " SCORECARD_ID=? ";
paramValues.add(theQueryObject.getScorecard().getID());
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
