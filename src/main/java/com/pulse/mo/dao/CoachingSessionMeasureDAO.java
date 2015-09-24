
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
import com.pulse.mo.CoachingSessionMeasure;
import com.pulse.mo.Behavior;
import com.pulse.mo.Observation;
import com.pulse.mo.CoachingSession;

*/

@Component
public class CoachingSessionMeasureDAO extends SqlDataAccessObject<CoachingSessionMeasure> implements IDataAccessObject<CoachingSessionMeasure> {

	static final Logger log = Logger.getLogger(CoachingSessionMeasureDAO.class);

	
	public CoachingSessionMeasureDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(CoachingSessionMeasure.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	@Override
	protected String getConnectionFactoryName() {
		return CoachingSessionMeasureDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT coachingsessionmeasure.ID FROM CoachingSessionMeasure coachingsessionmeasure WHERE coachingsessionmeasure.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT coachingsessionmeasure.ID,coachingsessionmeasure.externalID,coachingsessionmeasure.goal,coachingsessionmeasure.coachable,coachingsessionmeasure.currentWeekScore,coachingsessionmeasure.currentWeekScoreThresholdGrade,coachingsessionmeasure.eligableForIncentive,coachingsessionmeasure.mTDScore,coachingsessionmeasure.mTDScoreThresholdGrade,coachingsessionmeasure.mTDTrend,coachingsessionmeasure.name,coachingsessionmeasure.previoisWeekScore,coachingsessionmeasure.previoisWeekScoreThresholdGrade,coachingsessionmeasure.previousMonthScore,coachingsessionmeasure.previousMonthScoreThresholdGrade,coachingsessionmeasure.requiresCoaching,coachingsessionmeasure.tenure,coachingsessionmeasure.weeklyTrend,coachingsessionmeasure.weight,coachingsessionmeasure.coachingSession_ID FROM CoachingSessionMeasure coachingsessionmeasure WHERE coachingsessionmeasure.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT coachingsessionmeasure.ID FROM CoachingSessionMeasure coachingsessionmeasure ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT coachingsessionmeasure.ID FROM CoachingSessionMeasure coachingsessionmeasure ORDER BY coachingsessionmeasure.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT coachingsessionmeasure.ID,coachingsessionmeasure.externalID,coachingsessionmeasure.goal,coachingsessionmeasure.coachable,coachingsessionmeasure.currentWeekScore,coachingsessionmeasure.currentWeekScoreThresholdGrade,coachingsessionmeasure.eligableForIncentive,coachingsessionmeasure.mTDScore,coachingsessionmeasure.mTDScoreThresholdGrade,coachingsessionmeasure.mTDTrend,coachingsessionmeasure.name,coachingsessionmeasure.previoisWeekScore,coachingsessionmeasure.previoisWeekScoreThresholdGrade,coachingsessionmeasure.previousMonthScore,coachingsessionmeasure.previousMonthScoreThresholdGrade,coachingsessionmeasure.requiresCoaching,coachingsessionmeasure.tenure,coachingsessionmeasure.weeklyTrend,coachingsessionmeasure.weight,coachingsessionmeasure.coachingSession_ID FROM CoachingSessionMeasure coachingsessionmeasure ORDER BY coachingsessionmeasure.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT coachingsessionmeasure.ID,coachingsessionmeasure.externalID,coachingsessionmeasure.goal,coachingsessionmeasure.coachable,coachingsessionmeasure.currentWeekScore,coachingsessionmeasure.currentWeekScoreThresholdGrade,coachingsessionmeasure.eligableForIncentive,coachingsessionmeasure.mTDScore,coachingsessionmeasure.mTDScoreThresholdGrade,coachingsessionmeasure.mTDTrend,coachingsessionmeasure.name,coachingsessionmeasure.previoisWeekScore,coachingsessionmeasure.previoisWeekScoreThresholdGrade,coachingsessionmeasure.previousMonthScore,coachingsessionmeasure.previousMonthScoreThresholdGrade,coachingsessionmeasure.requiresCoaching,coachingsessionmeasure.tenure,coachingsessionmeasure.weeklyTrend,coachingsessionmeasure.weight,coachingsessionmeasure.coachingSession_ID FROM CoachingSessionMeasure coachingsessionmeasure ORDER BY coachingsessionmeasure.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM CoachingSessionMeasure coachingsessionmeasure";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT coachingsessionmeasure.ID,coachingsessionmeasure.externalID,coachingsessionmeasure.goal,coachingsessionmeasure.coachable,coachingsessionmeasure.currentWeekScore,coachingsessionmeasure.currentWeekScoreThresholdGrade,coachingsessionmeasure.eligableForIncentive,coachingsessionmeasure.mTDScore,coachingsessionmeasure.mTDScoreThresholdGrade,coachingsessionmeasure.mTDTrend,coachingsessionmeasure.name,coachingsessionmeasure.previoisWeekScore,coachingsessionmeasure.previoisWeekScoreThresholdGrade,coachingsessionmeasure.previousMonthScore,coachingsessionmeasure.previousMonthScoreThresholdGrade,coachingsessionmeasure.requiresCoaching,coachingsessionmeasure.tenure,coachingsessionmeasure.weeklyTrend,coachingsessionmeasure.weight,coachingsessionmeasure.coachingSession_ID FROM CoachingSessionMeasure coachingsessionmeasure WHERE coachingsessionmeasure.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT coachingsessionmeasure.ID FROM CoachingSessionMeasure coachingsessionmeasure WHERE coachingsessionmeasure.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT coachingsessionmeasure.ID,coachingsessionmeasure.externalID,coachingsessionmeasure.goal,coachingsessionmeasure.coachable,coachingsessionmeasure.currentWeekScore,coachingsessionmeasure.currentWeekScoreThresholdGrade,coachingsessionmeasure.eligableForIncentive,coachingsessionmeasure.mTDScore,coachingsessionmeasure.mTDScoreThresholdGrade,coachingsessionmeasure.mTDTrend,coachingsessionmeasure.name,coachingsessionmeasure.previoisWeekScore,coachingsessionmeasure.previoisWeekScoreThresholdGrade,coachingsessionmeasure.previousMonthScore,coachingsessionmeasure.previousMonthScoreThresholdGrade,coachingsessionmeasure.requiresCoaching,coachingsessionmeasure.tenure,coachingsessionmeasure.weeklyTrend,coachingsessionmeasure.weight,coachingsessionmeasure.coachingSession_ID FROM CoachingSessionMeasure coachingsessionmeasure WHERE coachingsessionmeasure." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT coachingsessionmeasure.ID FROM CoachingSessionMeasure coachingsessionmeasure WHERE coachingsessionmeasure." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT coachingsessionmeasure.ID FROM CoachingSessionMeasure coachingsessionmeasure ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT coachingsessionmeasure.ID,coachingsessionmeasure.externalID,coachingsessionmeasure.goal,coachingsessionmeasure.coachable,coachingsessionmeasure.currentWeekScore,coachingsessionmeasure.currentWeekScoreThresholdGrade,coachingsessionmeasure.eligableForIncentive,coachingsessionmeasure.mTDScore,coachingsessionmeasure.mTDScoreThresholdGrade,coachingsessionmeasure.mTDTrend,coachingsessionmeasure.name,coachingsessionmeasure.previoisWeekScore,coachingsessionmeasure.previoisWeekScoreThresholdGrade,coachingsessionmeasure.previousMonthScore,coachingsessionmeasure.previousMonthScoreThresholdGrade,coachingsessionmeasure.requiresCoaching,coachingsessionmeasure.tenure,coachingsessionmeasure.weeklyTrend,coachingsessionmeasure.weight,coachingsessionmeasure.coachingSession_ID FROM CoachingSessionMeasure coachingsessionmeasure ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO CoachingSessionMeasure (ID,externalID,goal,coachable,currentWeekScore,currentWeekScoreThresholdGrade,eligableForIncentive,mTDScore,mTDScoreThresholdGrade,mTDTrend,name,previoisWeekScore,previoisWeekScoreThresholdGrade,previousMonthScore,previousMonthScoreThresholdGrade,requiresCoaching,tenure,weeklyTrend,weight,coachingSession_ID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE CoachingSessionMeasure SET externalID=?,goal=?,coachable=?,currentWeekScore=?,currentWeekScoreThresholdGrade=?,eligableForIncentive=?,mTDScore=?,mTDScoreThresholdGrade=?,mTDTrend=?,name=?,previoisWeekScore=?,previoisWeekScoreThresholdGrade=?,previousMonthScore=?,previousMonthScoreThresholdGrade=?,requiresCoaching=?,tenure=?,weeklyTrend=?,weight=?,coachingSession_ID=? WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM CoachingSessionMeasure WHERE ID=?";
	}
	
	@Override
	protected CoachingSessionMeasure extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	CoachingSessionMeasure nextResult = new CoachingSessionMeasure();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setExternalID(rs.getString("externalID"));

nextResult.setGoal(rs.getString("goal"));

nextResult.setCoachable(rs.getBoolean("coachable"));

nextResult.setCurrentWeekScore(rs.getString("currentWeekScore"));

nextResult.setCurrentWeekScoreThresholdGrade(rs.getString("currentWeekScoreThresholdGrade"));

nextResult.setEligableForIncentive(rs.getBoolean("eligableForIncentive"));

nextResult.setMTDScore(rs.getString("mTDScore"));

nextResult.setMTDScoreThresholdGrade(rs.getString("mTDScoreThresholdGrade"));

nextResult.setMTDTrend(rs.getString("mTDTrend"));

nextResult.setName(rs.getString("name"));

nextResult.setPrevioisWeekScore(rs.getString("previoisWeekScore"));

nextResult.setPrevioisWeekScoreThresholdGrade(rs.getString("previoisWeekScoreThresholdGrade"));

nextResult.setPreviousMonthScore(rs.getString("previousMonthScore"));

nextResult.setPreviousMonthScoreThresholdGrade(rs.getString("previousMonthScoreThresholdGrade"));

nextResult.setRequiresCoaching(rs.getBoolean("requiresCoaching"));

nextResult.setTenure(rs.getString("tenure"));

nextResult.setWeeklyTrend(rs.getString("weeklyTrend"));

nextResult.setWeight(rs.getString("weight"));

CoachingSession coachingsession = new CoachingSession();
coachingsession.setID(rs.getString("coachingsession_ID"));
nextResult.setCoachingSession(coachingsession);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(CoachingSessionMeasure perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getExternalID());
pstmt.setString(3, perceroObject.getGoal());
pstmt.setBoolean(4, perceroObject.getCoachable());
pstmt.setString(5, perceroObject.getCurrentWeekScore());
pstmt.setString(6, perceroObject.getCurrentWeekScoreThresholdGrade());
pstmt.setBoolean(7, perceroObject.getEligableForIncentive());
pstmt.setString(8, perceroObject.getMTDScore());
pstmt.setString(9, perceroObject.getMTDScoreThresholdGrade());
pstmt.setString(10, perceroObject.getMTDTrend());
pstmt.setString(11, perceroObject.getName());
pstmt.setString(12, perceroObject.getPrevioisWeekScore());
pstmt.setString(13, perceroObject.getPrevioisWeekScoreThresholdGrade());
pstmt.setString(14, perceroObject.getPreviousMonthScore());
pstmt.setString(15, perceroObject.getPreviousMonthScoreThresholdGrade());
pstmt.setBoolean(16, perceroObject.getRequiresCoaching());
pstmt.setString(17, perceroObject.getTenure());
pstmt.setString(18, perceroObject.getWeeklyTrend());
pstmt.setString(19, perceroObject.getWeight());

if (perceroObject.getCoachingSession() == null)
{
pstmt.setString(20, null);
}
else
{
		pstmt.setString(20, perceroObject.getCoachingSession().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(CoachingSessionMeasure perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getExternalID());
pstmt.setString(2, perceroObject.getGoal());
pstmt.setBoolean(3, perceroObject.getCoachable());
pstmt.setString(4, perceroObject.getCurrentWeekScore());
pstmt.setString(5, perceroObject.getCurrentWeekScoreThresholdGrade());
pstmt.setBoolean(6, perceroObject.getEligableForIncentive());
pstmt.setString(7, perceroObject.getMTDScore());
pstmt.setString(8, perceroObject.getMTDScoreThresholdGrade());
pstmt.setString(9, perceroObject.getMTDTrend());
pstmt.setString(10, perceroObject.getName());
pstmt.setString(11, perceroObject.getPrevioisWeekScore());
pstmt.setString(12, perceroObject.getPrevioisWeekScoreThresholdGrade());
pstmt.setString(13, perceroObject.getPreviousMonthScore());
pstmt.setString(14, perceroObject.getPreviousMonthScoreThresholdGrade());
pstmt.setBoolean(15, perceroObject.getRequiresCoaching());
pstmt.setString(16, perceroObject.getTenure());
pstmt.setString(17, perceroObject.getWeeklyTrend());
pstmt.setString(18, perceroObject.getWeight());

if (perceroObject.getCoachingSession() == null)
{
pstmt.setString(19, null);
}
else
{
		pstmt.setString(19, perceroObject.getCoachingSession().getID());
}

pstmt.setString(20, perceroObject.getID());

		
	}

	@Override
	public List<CoachingSessionMeasure> findByExample(CoachingSessionMeasure theQueryObject,
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

boolean useGoal = StringUtils.hasText(theQueryObject.getGoal()) && (excludeProperties == null || !excludeProperties.contains("goal"));

if (useGoal)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " goal=? ";
paramValues.add(theQueryObject.getGoal());
propertyCounter++;
}

boolean useCoachable = theQueryObject.getCoachable() != null && (excludeProperties == null || !excludeProperties.contains("coachable"));

if (useCoachable)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " coachable=? ";
paramValues.add(theQueryObject.getCoachable());
propertyCounter++;
}

boolean useCurrentWeekScore = StringUtils.hasText(theQueryObject.getCurrentWeekScore()) && (excludeProperties == null || !excludeProperties.contains("currentWeekScore"));

if (useCurrentWeekScore)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " currentWeekScore=? ";
paramValues.add(theQueryObject.getCurrentWeekScore());
propertyCounter++;
}

boolean useCurrentWeekScoreThresholdGrade = StringUtils.hasText(theQueryObject.getCurrentWeekScoreThresholdGrade()) && (excludeProperties == null || !excludeProperties.contains("currentWeekScoreThresholdGrade"));

if (useCurrentWeekScoreThresholdGrade)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " currentWeekScoreThresholdGrade=? ";
paramValues.add(theQueryObject.getCurrentWeekScoreThresholdGrade());
propertyCounter++;
}

boolean useEligableForIncentive = theQueryObject.getEligableForIncentive() != null && (excludeProperties == null || !excludeProperties.contains("eligableForIncentive"));

if (useEligableForIncentive)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " eligableForIncentive=? ";
paramValues.add(theQueryObject.getEligableForIncentive());
propertyCounter++;
}

boolean useMTDScore = StringUtils.hasText(theQueryObject.getMTDScore()) && (excludeProperties == null || !excludeProperties.contains("mTDScore"));

if (useMTDScore)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " mTDScore=? ";
paramValues.add(theQueryObject.getMTDScore());
propertyCounter++;
}

boolean useMTDScoreThresholdGrade = StringUtils.hasText(theQueryObject.getMTDScoreThresholdGrade()) && (excludeProperties == null || !excludeProperties.contains("mTDScoreThresholdGrade"));

if (useMTDScoreThresholdGrade)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " mTDScoreThresholdGrade=? ";
paramValues.add(theQueryObject.getMTDScoreThresholdGrade());
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
sql += " name=? ";
paramValues.add(theQueryObject.getName());
propertyCounter++;
}

boolean usePrevioisWeekScore = StringUtils.hasText(theQueryObject.getPrevioisWeekScore()) && (excludeProperties == null || !excludeProperties.contains("previoisWeekScore"));

if (usePrevioisWeekScore)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " previoisWeekScore=? ";
paramValues.add(theQueryObject.getPrevioisWeekScore());
propertyCounter++;
}

boolean usePrevioisWeekScoreThresholdGrade = StringUtils.hasText(theQueryObject.getPrevioisWeekScoreThresholdGrade()) && (excludeProperties == null || !excludeProperties.contains("previoisWeekScoreThresholdGrade"));

if (usePrevioisWeekScoreThresholdGrade)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " previoisWeekScoreThresholdGrade=? ";
paramValues.add(theQueryObject.getPrevioisWeekScoreThresholdGrade());
propertyCounter++;
}

boolean usePreviousMonthScore = StringUtils.hasText(theQueryObject.getPreviousMonthScore()) && (excludeProperties == null || !excludeProperties.contains("previousMonthScore"));

if (usePreviousMonthScore)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " previousMonthScore=? ";
paramValues.add(theQueryObject.getPreviousMonthScore());
propertyCounter++;
}

boolean usePreviousMonthScoreThresholdGrade = StringUtils.hasText(theQueryObject.getPreviousMonthScoreThresholdGrade()) && (excludeProperties == null || !excludeProperties.contains("previousMonthScoreThresholdGrade"));

if (usePreviousMonthScoreThresholdGrade)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " previousMonthScoreThresholdGrade=? ";
paramValues.add(theQueryObject.getPreviousMonthScoreThresholdGrade());
propertyCounter++;
}

boolean useRequiresCoaching = theQueryObject.getRequiresCoaching() != null && (excludeProperties == null || !excludeProperties.contains("requiresCoaching"));

if (useRequiresCoaching)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " requiresCoaching=? ";
paramValues.add(theQueryObject.getRequiresCoaching());
propertyCounter++;
}

boolean useTenure = StringUtils.hasText(theQueryObject.getTenure()) && (excludeProperties == null || !excludeProperties.contains("tenure"));

if (useTenure)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " tenure=? ";
paramValues.add(theQueryObject.getTenure());
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

boolean useWeight = StringUtils.hasText(theQueryObject.getWeight()) && (excludeProperties == null || !excludeProperties.contains("weight"));

if (useWeight)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " weight=? ";
paramValues.add(theQueryObject.getWeight());
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
sql += " coachingSessionID=? ";
paramValues.add(theQueryObject.getCoachingSession().getID());
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
