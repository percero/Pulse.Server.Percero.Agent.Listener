
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
import com.pulse.mo.CoachingSessionMeasure;
import com.pulse.mo.QualityEvaluation;
import com.pulse.mo.Agent;
import com.pulse.mo.CoachingSessionState;
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
		return "SELECT coachingsession.ID FROM CoachingSession coachingsession WHERE coachingsession.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT coachingsession.ID,coachingsession.externalID,coachingsession.scorecardName,coachingsession.stateName,coachingsession.weekendDate,coachingsession.weeklyOverallScore,coachingsession.weeklyOverallScoreStateName,coachingsession.weeklyTrend,coachingsession.mTDTrend,coachingsession.previousMTDOverallScore,coachingsession.previousMTDThresholdGrade,coachingsession.currentMTDOverallScore,coachingsession.currentMTDThresholdGrade,coachingsession.agent_ID,coachingsession.coachingSessionState_ID,coachingsession.scorecard_ID FROM CoachingSession coachingsession WHERE coachingsession.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT coachingsession.ID FROM CoachingSession coachingsession ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT coachingsession.ID FROM CoachingSession coachingsession ORDER BY coachingsession.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT coachingsession.ID,coachingsession.externalID,coachingsession.scorecardName,coachingsession.stateName,coachingsession.weekendDate,coachingsession.weeklyOverallScore,coachingsession.weeklyOverallScoreStateName,coachingsession.weeklyTrend,coachingsession.mTDTrend,coachingsession.previousMTDOverallScore,coachingsession.previousMTDThresholdGrade,coachingsession.currentMTDOverallScore,coachingsession.currentMTDThresholdGrade,coachingsession.agent_ID,coachingsession.coachingSessionState_ID,coachingsession.scorecard_ID FROM CoachingSession coachingsession ORDER BY coachingsession.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT coachingsession.ID,coachingsession.externalID,coachingsession.scorecardName,coachingsession.stateName,coachingsession.weekendDate,coachingsession.weeklyOverallScore,coachingsession.weeklyOverallScoreStateName,coachingsession.weeklyTrend,coachingsession.mTDTrend,coachingsession.previousMTDOverallScore,coachingsession.previousMTDThresholdGrade,coachingsession.currentMTDOverallScore,coachingsession.currentMTDThresholdGrade,coachingsession.agent_ID,coachingsession.coachingSessionState_ID,coachingsession.scorecard_ID FROM CoachingSession coachingsession ORDER BY coachingsession.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM CoachingSession coachingsession";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT coachingsession.ID,coachingsession.externalID,coachingsession.scorecardName,coachingsession.stateName,coachingsession.weekendDate,coachingsession.weeklyOverallScore,coachingsession.weeklyOverallScoreStateName,coachingsession.weeklyTrend,coachingsession.mTDTrend,coachingsession.previousMTDOverallScore,coachingsession.previousMTDThresholdGrade,coachingsession.currentMTDOverallScore,coachingsession.currentMTDThresholdGrade,coachingsession.agent_ID,coachingsession.coachingSessionState_ID,coachingsession.scorecard_ID FROM CoachingSession coachingsession WHERE coachingsession.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT coachingsession.ID FROM CoachingSession coachingsession WHERE coachingsession.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT coachingsession.ID,coachingsession.externalID,coachingsession.scorecardName,coachingsession.stateName,coachingsession.weekendDate,coachingsession.weeklyOverallScore,coachingsession.weeklyOverallScoreStateName,coachingsession.weeklyTrend,coachingsession.mTDTrend,coachingsession.previousMTDOverallScore,coachingsession.previousMTDThresholdGrade,coachingsession.currentMTDOverallScore,coachingsession.currentMTDThresholdGrade,coachingsession.agent_ID,coachingsession.coachingSessionState_ID,coachingsession.scorecard_ID FROM CoachingSession coachingsession WHERE coachingsession." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT coachingsession.ID FROM CoachingSession coachingsession WHERE coachingsession." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT coachingsession.ID FROM CoachingSession coachingsession ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT coachingsession.ID,coachingsession.externalID,coachingsession.scorecardName,coachingsession.stateName,coachingsession.weekendDate,coachingsession.weeklyOverallScore,coachingsession.weeklyOverallScoreStateName,coachingsession.weeklyTrend,coachingsession.mTDTrend,coachingsession.previousMTDOverallScore,coachingsession.previousMTDThresholdGrade,coachingsession.currentMTDOverallScore,coachingsession.currentMTDThresholdGrade,coachingsession.agent_ID,coachingsession.coachingSessionState_ID,coachingsession.scorecard_ID FROM CoachingSession coachingsession ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO CoachingSession (ID,externalID,scorecardName,stateName,weekendDate,weeklyOverallScore,weeklyOverallScoreStateName,weeklyTrend,mTDTrend,previousMTDOverallScore,previousMTDThresholdGrade,currentMTDOverallScore,currentMTDThresholdGrade,agent_ID,coachingSessionState_ID,scorecard_ID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE CoachingSession SET externalID=?,scorecardName=?,stateName=?,weekendDate=?,weeklyOverallScore=?,weeklyOverallScoreStateName=?,weeklyTrend=?,mTDTrend=?,previousMTDOverallScore=?,previousMTDThresholdGrade=?,currentMTDOverallScore=?,currentMTDThresholdGrade=?,agent_ID=?,coachingSessionState_ID=?,scorecard_ID=? WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM CoachingSession WHERE ID=?";
	}
	
	@Override
	protected CoachingSession extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	CoachingSession nextResult = new CoachingSession();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setExternalID(rs.getString("externalID"));

nextResult.setScorecardName(rs.getString("scorecardName"));

nextResult.setStateName(rs.getString("stateName"));

nextResult.setWeekendDate(rs.getString("weekendDate"));

nextResult.setWeeklyOverallScore(rs.getString("weeklyOverallScore"));

nextResult.setWeeklyOverallScoreStateName(rs.getString("weeklyOverallScoreStateName"));

nextResult.setWeeklyTrend(rs.getString("weeklyTrend"));

nextResult.setMTDTrend(rs.getString("mTDTrend"));

nextResult.setPreviousMTDOverallScore(rs.getString("previousMTDOverallScore"));

nextResult.setPreviousMTDThresholdGrade(rs.getDouble("previousMTDThresholdGrade"));

nextResult.setCurrentMTDOverallScore(rs.getString("currentMTDOverallScore"));

nextResult.setCurrentMTDThresholdGrade(rs.getDouble("currentMTDThresholdGrade"));

Agent agent = new Agent();
agent.setID(rs.getString("agent_ID"));
nextResult.setAgent(agent);

CoachingSessionState coachingsessionstate = new CoachingSessionState();
coachingsessionstate.setID(rs.getString("coachingsessionstate_ID"));
nextResult.setCoachingSessionState(coachingsessionstate);

Scorecard scorecard = new Scorecard();
scorecard.setID(rs.getString("scorecard_ID"));
nextResult.setScorecard(scorecard);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(CoachingSession perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getExternalID());
pstmt.setString(3, perceroObject.getScorecardName());
pstmt.setString(4, perceroObject.getStateName());
pstmt.setString(5, perceroObject.getWeekendDate());
pstmt.setString(6, perceroObject.getWeeklyOverallScore());
pstmt.setString(7, perceroObject.getWeeklyOverallScoreStateName());
pstmt.setString(8, perceroObject.getWeeklyTrend());
pstmt.setString(9, perceroObject.getMTDTrend());
pstmt.setString(10, perceroObject.getPreviousMTDOverallScore());
pstmt.setDouble(11, perceroObject.getPreviousMTDThresholdGrade());
pstmt.setString(12, perceroObject.getCurrentMTDOverallScore());
pstmt.setDouble(13, perceroObject.getCurrentMTDThresholdGrade());

if (perceroObject.getAgent() == null)
{
pstmt.setString(14, null);
}
else
{
		pstmt.setString(14, perceroObject.getAgent().getID());
}


if (perceroObject.getCoachingSessionState() == null)
{
pstmt.setString(15, null);
}
else
{
		pstmt.setString(15, perceroObject.getCoachingSessionState().getID());
}


if (perceroObject.getScorecard() == null)
{
pstmt.setString(16, null);
}
else
{
		pstmt.setString(16, perceroObject.getScorecard().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(CoachingSession perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getExternalID());
pstmt.setString(2, perceroObject.getScorecardName());
pstmt.setString(3, perceroObject.getStateName());
pstmt.setString(4, perceroObject.getWeekendDate());
pstmt.setString(5, perceroObject.getWeeklyOverallScore());
pstmt.setString(6, perceroObject.getWeeklyOverallScoreStateName());
pstmt.setString(7, perceroObject.getWeeklyTrend());
pstmt.setString(8, perceroObject.getMTDTrend());
pstmt.setString(9, perceroObject.getPreviousMTDOverallScore());
pstmt.setDouble(10, perceroObject.getPreviousMTDThresholdGrade());
pstmt.setString(11, perceroObject.getCurrentMTDOverallScore());
pstmt.setDouble(12, perceroObject.getCurrentMTDThresholdGrade());

if (perceroObject.getAgent() == null)
{
pstmt.setString(13, null);
}
else
{
		pstmt.setString(13, perceroObject.getAgent().getID());
}


if (perceroObject.getCoachingSessionState() == null)
{
pstmt.setString(14, null);
}
else
{
		pstmt.setString(14, perceroObject.getCoachingSessionState().getID());
}


if (perceroObject.getScorecard() == null)
{
pstmt.setString(15, null);
}
else
{
		pstmt.setString(15, perceroObject.getScorecard().getID());
}

pstmt.setString(16, perceroObject.getID());

		
	}

	@Override
	public List<CoachingSession> findByExample(CoachingSession theQueryObject,
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

boolean useScorecardName = StringUtils.hasText(theQueryObject.getScorecardName()) && (excludeProperties == null || !excludeProperties.contains("scorecardName"));

if (useScorecardName)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " scorecardName=? ";
paramValues.add(theQueryObject.getScorecardName());
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
sql += " weekendDate=? ";
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
sql += " weeklyOverallScore=? ";
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
sql += " weeklyOverallScoreStateName=? ";
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
sql += " weeklyTrend=? ";
paramValues.add(theQueryObject.getWeeklyTrend());
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
sql += " mTDTrend=? ";
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
sql += " previousMTDOverallScore=? ";
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
sql += " previousMTDThresholdGrade=? ";
paramValues.add(theQueryObject.getPreviousMTDThresholdGrade());
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
sql += " currentMTDOverallScore=? ";
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
sql += " currentMTDThresholdGrade=? ";
paramValues.add(theQueryObject.getCurrentMTDThresholdGrade());
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
sql += " coachingSessionStateID=? ";
paramValues.add(theQueryObject.getCoachingSessionState().getID());
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
sql += " scorecardID=? ";
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
