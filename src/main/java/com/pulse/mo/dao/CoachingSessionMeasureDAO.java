
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
		return "SELECT COACHING_SESSION_MEASURE.ID FROM COACHING_SESSION_MEASURE COACHING_SESSION_MEASURE WHERE COACHING_SESSION_MEASURE.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT COACHING_SESSION_MEASURE.ID,COACHING_SESSION_MEASURE.COACHABLE,COACHING_SESSION_MEASURE.ELIGABLE_FOR_INCENTIVE,COACHING_SESSION_MEASURE.REQUIRES_COACHING,COACHING_SESSION_MEASURE.CURRENT_WEEK_SCORE,COACHING_SESSION_MEASURE.CURRENT_WEEK_SCORE_THRESHOLD_GRADE,COACHING_SESSION_MEASURE.GOAL,COACHING_SESSION_MEASURE.MTD_SCORE,COACHING_SESSION_MEASURE.MTD_SCORE_THRESHOLD_GRADE,COACHING_SESSION_MEASURE.MTD_TREND,COACHING_SESSION_MEASURE.NAME,COACHING_SESSION_MEASURE.PREVIOUS_MONTH_SCORE,COACHING_SESSION_MEASURE.PREVIOUS_MONTH_SCORE_THRESHOLD_GRADE,COACHING_SESSION_MEASURE.PREVIOUS_WEEK_SCORE,COACHING_SESSION_MEASURE.PREVIOUS_WEEK_SCORE_THRESHOLD_GRADE,COACHING_SESSION_MEASURE.TENURE,COACHING_SESSION_MEASURE.WEEKLY_TREND,COACHING_SESSION_MEASURE.WEIGHT,COACHING_SESSION_MEASURE.COACHING_SESSION_ID FROM COACHING_SESSION_MEASURE COACHING_SESSION_MEASURE WHERE COACHING_SESSION_MEASURE.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT COACHING_SESSION_MEASURE.ID FROM COACHING_SESSION_MEASURE COACHING_SESSION_MEASURE ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT COACHING_SESSION_MEASURE.ID FROM COACHING_SESSION_MEASURE COACHING_SESSION_MEASURE ORDER BY COACHING_SESSION_MEASURE.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT COACHING_SESSION_MEASURE.ID,COACHING_SESSION_MEASURE.COACHABLE,COACHING_SESSION_MEASURE.ELIGABLE_FOR_INCENTIVE,COACHING_SESSION_MEASURE.REQUIRES_COACHING,COACHING_SESSION_MEASURE.CURRENT_WEEK_SCORE,COACHING_SESSION_MEASURE.CURRENT_WEEK_SCORE_THRESHOLD_GRADE,COACHING_SESSION_MEASURE.GOAL,COACHING_SESSION_MEASURE.MTD_SCORE,COACHING_SESSION_MEASURE.MTD_SCORE_THRESHOLD_GRADE,COACHING_SESSION_MEASURE.MTD_TREND,COACHING_SESSION_MEASURE.NAME,COACHING_SESSION_MEASURE.PREVIOUS_MONTH_SCORE,COACHING_SESSION_MEASURE.PREVIOUS_MONTH_SCORE_THRESHOLD_GRADE,COACHING_SESSION_MEASURE.PREVIOUS_WEEK_SCORE,COACHING_SESSION_MEASURE.PREVIOUS_WEEK_SCORE_THRESHOLD_GRADE,COACHING_SESSION_MEASURE.TENURE,COACHING_SESSION_MEASURE.WEEKLY_TREND,COACHING_SESSION_MEASURE.WEIGHT,COACHING_SESSION_MEASURE.COACHING_SESSION_ID FROM COACHING_SESSION_MEASURE COACHING_SESSION_MEASURE ORDER BY COACHING_SESSION_MEASURE.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT COACHING_SESSION_MEASURE.ID,COACHING_SESSION_MEASURE.COACHABLE,COACHING_SESSION_MEASURE.ELIGABLE_FOR_INCENTIVE,COACHING_SESSION_MEASURE.REQUIRES_COACHING,COACHING_SESSION_MEASURE.CURRENT_WEEK_SCORE,COACHING_SESSION_MEASURE.CURRENT_WEEK_SCORE_THRESHOLD_GRADE,COACHING_SESSION_MEASURE.GOAL,COACHING_SESSION_MEASURE.MTD_SCORE,COACHING_SESSION_MEASURE.MTD_SCORE_THRESHOLD_GRADE,COACHING_SESSION_MEASURE.MTD_TREND,COACHING_SESSION_MEASURE.NAME,COACHING_SESSION_MEASURE.PREVIOUS_MONTH_SCORE,COACHING_SESSION_MEASURE.PREVIOUS_MONTH_SCORE_THRESHOLD_GRADE,COACHING_SESSION_MEASURE.PREVIOUS_WEEK_SCORE,COACHING_SESSION_MEASURE.PREVIOUS_WEEK_SCORE_THRESHOLD_GRADE,COACHING_SESSION_MEASURE.TENURE,COACHING_SESSION_MEASURE.WEEKLY_TREND,COACHING_SESSION_MEASURE.WEIGHT,COACHING_SESSION_MEASURE.COACHING_SESSION_ID FROM COACHING_SESSION_MEASURE COACHING_SESSION_MEASURE ORDER BY COACHING_SESSION_MEASURE.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM COACHING_SESSION_MEASURE COACHING_SESSION_MEASURE";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT COACHING_SESSION_MEASURE.ID,COACHING_SESSION_MEASURE.COACHABLE,COACHING_SESSION_MEASURE.ELIGABLE_FOR_INCENTIVE,COACHING_SESSION_MEASURE.REQUIRES_COACHING,COACHING_SESSION_MEASURE.CURRENT_WEEK_SCORE,COACHING_SESSION_MEASURE.CURRENT_WEEK_SCORE_THRESHOLD_GRADE,COACHING_SESSION_MEASURE.GOAL,COACHING_SESSION_MEASURE.MTD_SCORE,COACHING_SESSION_MEASURE.MTD_SCORE_THRESHOLD_GRADE,COACHING_SESSION_MEASURE.MTD_TREND,COACHING_SESSION_MEASURE.NAME,COACHING_SESSION_MEASURE.PREVIOUS_MONTH_SCORE,COACHING_SESSION_MEASURE.PREVIOUS_MONTH_SCORE_THRESHOLD_GRADE,COACHING_SESSION_MEASURE.PREVIOUS_WEEK_SCORE,COACHING_SESSION_MEASURE.PREVIOUS_WEEK_SCORE_THRESHOLD_GRADE,COACHING_SESSION_MEASURE.TENURE,COACHING_SESSION_MEASURE.WEEKLY_TREND,COACHING_SESSION_MEASURE.WEIGHT,COACHING_SESSION_MEASURE.COACHING_SESSION_ID FROM COACHING_SESSION_MEASURE COACHING_SESSION_MEASURE WHERE COACHING_SESSION_MEASURE.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT COACHING_SESSION_MEASURE.ID FROM COACHING_SESSION_MEASURE COACHING_SESSION_MEASURE WHERE COACHING_SESSION_MEASURE.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT COACHING_SESSION_MEASURE.ID,COACHING_SESSION_MEASURE.COACHABLE,COACHING_SESSION_MEASURE.ELIGABLE_FOR_INCENTIVE,COACHING_SESSION_MEASURE.REQUIRES_COACHING,COACHING_SESSION_MEASURE.CURRENT_WEEK_SCORE,COACHING_SESSION_MEASURE.CURRENT_WEEK_SCORE_THRESHOLD_GRADE,COACHING_SESSION_MEASURE.GOAL,COACHING_SESSION_MEASURE.MTD_SCORE,COACHING_SESSION_MEASURE.MTD_SCORE_THRESHOLD_GRADE,COACHING_SESSION_MEASURE.MTD_TREND,COACHING_SESSION_MEASURE.NAME,COACHING_SESSION_MEASURE.PREVIOUS_MONTH_SCORE,COACHING_SESSION_MEASURE.PREVIOUS_MONTH_SCORE_THRESHOLD_GRADE,COACHING_SESSION_MEASURE.PREVIOUS_WEEK_SCORE,COACHING_SESSION_MEASURE.PREVIOUS_WEEK_SCORE_THRESHOLD_GRADE,COACHING_SESSION_MEASURE.TENURE,COACHING_SESSION_MEASURE.WEEKLY_TREND,COACHING_SESSION_MEASURE.WEIGHT,COACHING_SESSION_MEASURE.COACHING_SESSION_ID FROM COACHING_SESSION_MEASURE COACHING_SESSION_MEASURE WHERE COACHING_SESSION_MEASURE." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT COACHING_SESSION_MEASURE.ID FROM COACHING_SESSION_MEASURE COACHING_SESSION_MEASURE WHERE COACHING_SESSION_MEASURE." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT COACHING_SESSION_MEASURE.ID FROM COACHING_SESSION_MEASURE COACHING_SESSION_MEASURE ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT COACHING_SESSION_MEASURE.ID,COACHING_SESSION_MEASURE.COACHABLE,COACHING_SESSION_MEASURE.ELIGABLE_FOR_INCENTIVE,COACHING_SESSION_MEASURE.REQUIRES_COACHING,COACHING_SESSION_MEASURE.CURRENT_WEEK_SCORE,COACHING_SESSION_MEASURE.CURRENT_WEEK_SCORE_THRESHOLD_GRADE,COACHING_SESSION_MEASURE.GOAL,COACHING_SESSION_MEASURE.MTD_SCORE,COACHING_SESSION_MEASURE.MTD_SCORE_THRESHOLD_GRADE,COACHING_SESSION_MEASURE.MTD_TREND,COACHING_SESSION_MEASURE.NAME,COACHING_SESSION_MEASURE.PREVIOUS_MONTH_SCORE,COACHING_SESSION_MEASURE.PREVIOUS_MONTH_SCORE_THRESHOLD_GRADE,COACHING_SESSION_MEASURE.PREVIOUS_WEEK_SCORE,COACHING_SESSION_MEASURE.PREVIOUS_WEEK_SCORE_THRESHOLD_GRADE,COACHING_SESSION_MEASURE.TENURE,COACHING_SESSION_MEASURE.WEEKLY_TREND,COACHING_SESSION_MEASURE.WEIGHT,COACHING_SESSION_MEASURE.COACHING_SESSION_ID FROM COACHING_SESSION_MEASURE COACHING_SESSION_MEASURE ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO COACHING_SESSION_MEASURE (ID,COACHABLE,ELIGABLE_FOR_INCENTIVE,REQUIRES_COACHING,CURRENT_WEEK_SCORE,CURRENT_WEEK_SCORE_THRESHOLD_GRADE,GOAL,MTD_SCORE,MTD_SCORE_THRESHOLD_GRADE,MTD_TREND,NAME,PREVIOUS_MONTH_SCORE,PREVIOUS_MONTH_SCORE_THRESHOLD_GRADE,PREVIOUS_WEEK_SCORE,PREVIOUS_WEEK_SCORE_THRESHOLD_GRADE,TENURE,WEEKLY_TREND,WEIGHT,COACHING_SESSION_ID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE COACHING_SESSION_MEASURE SET COACHABLE=?,ELIGABLE_FOR_INCENTIVE=?,REQUIRES_COACHING=?,CURRENT_WEEK_SCORE=?,CURRENT_WEEK_SCORE_THRESHOLD_GRADE=?,GOAL=?,MTD_SCORE=?,MTD_SCORE_THRESHOLD_GRADE=?,MTD_TREND=?,NAME=?,PREVIOUS_MONTH_SCORE=?,PREVIOUS_MONTH_SCORE_THRESHOLD_GRADE=?,PREVIOUS_WEEK_SCORE=?,PREVIOUS_WEEK_SCORE_THRESHOLD_GRADE=?,TENURE=?,WEEKLY_TREND=?,WEIGHT=?,COACHING_SESSION_ID WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM COACHING_SESSION_MEASURE WHERE ID=?";
	}
	
	@Override
	protected CoachingSessionMeasure extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	CoachingSessionMeasure nextResult = new CoachingSessionMeasure();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setCoachable(rs.getBoolean("COACHABLE"));

nextResult.setEligableForIncentive(rs.getBoolean("ELIGABLE_FOR_INCENTIVE"));

nextResult.setRequiresCoaching(rs.getBoolean("REQUIRES_COACHING"));

nextResult.setCurrentWeekScore(rs.getString("CURRENT_WEEK_SCORE"));

nextResult.setCurrentWeekScoreThresholdGrade(rs.getString("CURRENT_WEEK_SCORE_THRESHOLD_GRADE"));

nextResult.setGoal(rs.getString("GOAL"));

nextResult.setMTDScore(rs.getString("MTD_SCORE"));

nextResult.setMTDScoreThresholdGrade(rs.getString("MTD_SCORE_THRESHOLD_GRADE"));

nextResult.setMTDTrend(rs.getString("MTD_TREND"));

nextResult.setName(rs.getString("NAME"));

nextResult.setPreviousMonthScore(rs.getString("PREVIOUS_MONTH_SCORE"));

nextResult.setPreviousMonthScoreThresholdGrade(rs.getString("PREVIOUS_MONTH_SCORE_THRESHOLD_GRADE"));

nextResult.setPreviousWeekScore(rs.getString("PREVIOUS_WEEK_SCORE"));

nextResult.setPreviousWeekScoreThresholdGrade(rs.getString("PREVIOUS_WEEK_SCORE_THRESHOLD_GRADE"));

nextResult.setTenure(rs.getString("TENURE"));

nextResult.setWeeklyTrend(rs.getString("WEEKLY_TREND"));

nextResult.setWeight(rs.getString("WEIGHT"));

CoachingSession coachingsession = new CoachingSession();
coachingsession.setID(rs.getString("COACHING_SESSION_ID"));
nextResult.setCoachingSession(coachingsession);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(CoachingSessionMeasure perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setBoolean(2, perceroObject.getCoachable());
pstmt.setBoolean(3, perceroObject.getEligableForIncentive());
pstmt.setBoolean(4, perceroObject.getRequiresCoaching());
pstmt.setString(5, perceroObject.getCurrentWeekScore());
pstmt.setString(6, perceroObject.getCurrentWeekScoreThresholdGrade());
pstmt.setString(7, perceroObject.getGoal());
pstmt.setString(8, perceroObject.getMTDScore());
pstmt.setString(9, perceroObject.getMTDScoreThresholdGrade());
pstmt.setString(10, perceroObject.getMTDTrend());
pstmt.setString(11, perceroObject.getName());
pstmt.setString(12, perceroObject.getPreviousMonthScore());
pstmt.setString(13, perceroObject.getPreviousMonthScoreThresholdGrade());
pstmt.setString(14, perceroObject.getPreviousWeekScore());
pstmt.setString(15, perceroObject.getPreviousWeekScoreThresholdGrade());
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


		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(CoachingSessionMeasure perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setBoolean(1, perceroObject.getCoachable());
pstmt.setBoolean(2, perceroObject.getEligableForIncentive());
pstmt.setBoolean(3, perceroObject.getRequiresCoaching());
pstmt.setString(4, perceroObject.getCurrentWeekScore());
pstmt.setString(5, perceroObject.getCurrentWeekScoreThresholdGrade());
pstmt.setString(6, perceroObject.getGoal());
pstmt.setString(7, perceroObject.getMTDScore());
pstmt.setString(8, perceroObject.getMTDScoreThresholdGrade());
pstmt.setString(9, perceroObject.getMTDTrend());
pstmt.setString(10, perceroObject.getName());
pstmt.setString(11, perceroObject.getPreviousMonthScore());
pstmt.setString(12, perceroObject.getPreviousMonthScoreThresholdGrade());
pstmt.setString(13, perceroObject.getPreviousWeekScore());
pstmt.setString(14, perceroObject.getPreviousWeekScoreThresholdGrade());
pstmt.setString(15, perceroObject.getTenure());
pstmt.setString(16, perceroObject.getWeeklyTrend());
pstmt.setString(17, perceroObject.getWeight());

if (perceroObject.getCoachingSession() == null)
{
pstmt.setString(18, null);
}
else
{
		pstmt.setString(18, perceroObject.getCoachingSession().getID());
}

pstmt.setString(19, perceroObject.getID());

		
	}

	@Override
	public List<CoachingSessionMeasure> findByExample(CoachingSessionMeasure theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useCoachable = theQueryObject.getCoachable() != null && (excludeProperties == null || !excludeProperties.contains("coachable"));

if (useCoachable)
{
sql += " WHERE ";
sql += " COACHABLE=? ";
paramValues.add(theQueryObject.getCoachable());
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
sql += " ELIGABLE_FOR_INCENTIVE=? ";
paramValues.add(theQueryObject.getEligableForIncentive());
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
sql += " REQUIRES_COACHING=? ";
paramValues.add(theQueryObject.getRequiresCoaching());
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
sql += " CURRENT_WEEK_SCORE=? ";
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
sql += " CURRENT_WEEK_SCORE_THRESHOLD_GRADE=? ";
paramValues.add(theQueryObject.getCurrentWeekScoreThresholdGrade());
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
sql += " GOAL=? ";
paramValues.add(theQueryObject.getGoal());
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
sql += " MTD_SCORE=? ";
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
sql += " MTD_SCORE_THRESHOLD_GRADE=? ";
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
sql += " MTD_TREND=? ";
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
sql += " NAME=? ";
paramValues.add(theQueryObject.getName());
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
sql += " PREVIOUS_MONTH_SCORE=? ";
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
sql += " PREVIOUS_MONTH_SCORE_THRESHOLD_GRADE=? ";
paramValues.add(theQueryObject.getPreviousMonthScoreThresholdGrade());
propertyCounter++;
}

boolean usePreviousWeekScore = StringUtils.hasText(theQueryObject.getPreviousWeekScore()) && (excludeProperties == null || !excludeProperties.contains("previousWeekScore"));

if (usePreviousWeekScore)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " PREVIOUS_WEEK_SCORE=? ";
paramValues.add(theQueryObject.getPreviousWeekScore());
propertyCounter++;
}

boolean usePreviousWeekScoreThresholdGrade = StringUtils.hasText(theQueryObject.getPreviousWeekScoreThresholdGrade()) && (excludeProperties == null || !excludeProperties.contains("previousWeekScoreThresholdGrade"));

if (usePreviousWeekScoreThresholdGrade)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " PREVIOUS_WEEK_SCORE_THRESHOLD_GRADE=? ";
paramValues.add(theQueryObject.getPreviousWeekScoreThresholdGrade());
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
sql += " TENURE=? ";
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
sql += " WEEKLY_TREND=? ";
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
sql += " WEIGHT=? ";
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
sql += " COACHING_SESSION_ID=? ";
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
