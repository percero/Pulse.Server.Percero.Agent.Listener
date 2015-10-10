
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
import com.pulse.mo.CoachingNotification;
import com.pulse.mo.Scorecard;

*/

@Component
public class CoachingNotificationDAO extends SqlDataAccessObject<CoachingNotification> implements IDataAccessObject<CoachingNotification> {

	static final Logger log = Logger.getLogger(CoachingNotificationDAO.class);

	
	public CoachingNotificationDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(CoachingNotification.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	
	
	
	@Override
	protected String getConnectionFactoryName() {
		return CoachingNotificationDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT \"COACHING_NOTIFICATION\".\"ID\" FROM \"COACHING_NOTIFICATION\" \"COACHING_NOTIFICATION\" WHERE \"COACHING_NOTIFICATION\".\"ID\"=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT \"COACHING_NOTIFICATION\".\"ID\",\"COACHING_NOTIFICATION\".\"NAME\",\"COACHING_NOTIFICATION\".\"PENDING_COACH_STATE_COUNT\",\"COACHING_NOTIFICATION\".\"PENDING_EMPLOYEE_STATE_COUNT\",\"COACHING_NOTIFICATION\".\"PENDING_STATE_COUNT\",\"COACHING_NOTIFICATION\".\"ACKNOWLEDGEMENT_STATE_COUNT\",\"COACHING_NOTIFICATION\".\"DATE\",\"COACHING_NOTIFICATION\".\"SKIPPED_STATE_COUNT\",\"COACHING_NOTIFICATION\".\"SUBMITTED_STATE_COUNT\",\"COACHING_NOTIFICATION\".\"TYPE\",\"COACHING_NOTIFICATION\".\"WEEKEND_DATE\",\"COACHING_NOTIFICATION\".\"TEAM_LEADER_ID\",\"COACHING_NOTIFICATION\".\"SCORECARD_ID\" FROM \"COACHING_NOTIFICATION\" \"COACHING_NOTIFICATION\" WHERE \"COACHING_NOTIFICATION\".\"ID\"=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT \"COACHING_NOTIFICATION\".\"ID\" FROM \"COACHING_NOTIFICATION\" \"COACHING_NOTIFICATION\" ORDER BY \"ID\"";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT \"COACHING_NOTIFICATION\".\"ID\" FROM \"COACHING_NOTIFICATION\" \"COACHING_NOTIFICATION\" ORDER BY \"COACHING_NOTIFICATION\".\"ID\" LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT \"COACHING_NOTIFICATION\".\"ID\",\"COACHING_NOTIFICATION\".\"NAME\",\"COACHING_NOTIFICATION\".\"PENDING_COACH_STATE_COUNT\",\"COACHING_NOTIFICATION\".\"PENDING_EMPLOYEE_STATE_COUNT\",\"COACHING_NOTIFICATION\".\"PENDING_STATE_COUNT\",\"COACHING_NOTIFICATION\".\"ACKNOWLEDGEMENT_STATE_COUNT\",\"COACHING_NOTIFICATION\".\"DATE\",\"COACHING_NOTIFICATION\".\"SKIPPED_STATE_COUNT\",\"COACHING_NOTIFICATION\".\"SUBMITTED_STATE_COUNT\",\"COACHING_NOTIFICATION\".\"TYPE\",\"COACHING_NOTIFICATION\".\"WEEKEND_DATE\",\"COACHING_NOTIFICATION\".\"TEAM_LEADER_ID\",\"COACHING_NOTIFICATION\".\"SCORECARD_ID\" FROM \"COACHING_NOTIFICATION\" \"COACHING_NOTIFICATION\" ORDER BY \"COACHING_NOTIFICATION\".\"ID\"";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT \"COACHING_NOTIFICATION\".\"ID\",\"COACHING_NOTIFICATION\".\"NAME\",\"COACHING_NOTIFICATION\".\"PENDING_COACH_STATE_COUNT\",\"COACHING_NOTIFICATION\".\"PENDING_EMPLOYEE_STATE_COUNT\",\"COACHING_NOTIFICATION\".\"PENDING_STATE_COUNT\",\"COACHING_NOTIFICATION\".\"ACKNOWLEDGEMENT_STATE_COUNT\",\"COACHING_NOTIFICATION\".\"DATE\",\"COACHING_NOTIFICATION\".\"SKIPPED_STATE_COUNT\",\"COACHING_NOTIFICATION\".\"SUBMITTED_STATE_COUNT\",\"COACHING_NOTIFICATION\".\"TYPE\",\"COACHING_NOTIFICATION\".\"WEEKEND_DATE\",\"COACHING_NOTIFICATION\".\"TEAM_LEADER_ID\",\"COACHING_NOTIFICATION\".\"SCORECARD_ID\" FROM \"COACHING_NOTIFICATION\" \"COACHING_NOTIFICATION\" ORDER BY \"COACHING_NOTIFICATION\".\"ID\" LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM \"COACHING_NOTIFICATION\" \"COACHING_NOTIFICATION\"";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT \"COACHING_NOTIFICATION\".\"ID\",\"COACHING_NOTIFICATION\".\"NAME\",\"COACHING_NOTIFICATION\".\"PENDING_COACH_STATE_COUNT\",\"COACHING_NOTIFICATION\".\"PENDING_EMPLOYEE_STATE_COUNT\",\"COACHING_NOTIFICATION\".\"PENDING_STATE_COUNT\",\"COACHING_NOTIFICATION\".\"ACKNOWLEDGEMENT_STATE_COUNT\",\"COACHING_NOTIFICATION\".\"DATE\",\"COACHING_NOTIFICATION\".\"SKIPPED_STATE_COUNT\",\"COACHING_NOTIFICATION\".\"SUBMITTED_STATE_COUNT\",\"COACHING_NOTIFICATION\".\"TYPE\",\"COACHING_NOTIFICATION\".\"WEEKEND_DATE\",\"COACHING_NOTIFICATION\".\"TEAM_LEADER_ID\",\"COACHING_NOTIFICATION\".\"SCORECARD_ID\" FROM \"COACHING_NOTIFICATION\" \"COACHING_NOTIFICATION\" WHERE \"COACHING_NOTIFICATION\".\"ID\" IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT \"COACHING_NOTIFICATION\".\"ID\" FROM \"COACHING_NOTIFICATION\" \"COACHING_NOTIFICATION\" WHERE \"COACHING_NOTIFICATION\".\"ID\" IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		return "SELECT \"COACHING_NOTIFICATION\".\"ID\",\"COACHING_NOTIFICATION\".\"NAME\",\"COACHING_NOTIFICATION\".\"PENDING_COACH_STATE_COUNT\",\"COACHING_NOTIFICATION\".\"PENDING_EMPLOYEE_STATE_COUNT\",\"COACHING_NOTIFICATION\".\"PENDING_STATE_COUNT\",\"COACHING_NOTIFICATION\".\"ACKNOWLEDGEMENT_STATE_COUNT\",\"COACHING_NOTIFICATION\".\"DATE\",\"COACHING_NOTIFICATION\".\"SKIPPED_STATE_COUNT\",\"COACHING_NOTIFICATION\".\"SUBMITTED_STATE_COUNT\",\"COACHING_NOTIFICATION\".\"TYPE\",\"COACHING_NOTIFICATION\".\"WEEKEND_DATE\",\"COACHING_NOTIFICATION\".\"TEAM_LEADER_ID\",\"COACHING_NOTIFICATION\".\"SCORECARD_ID\" FROM \"COACHING_NOTIFICATION\" \"COACHING_NOTIFICATION\" WHERE \"COACHING_NOTIFICATION\"." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT \"COACHING_NOTIFICATION\".\"ID\" FROM \"COACHING_NOTIFICATION\" \"COACHING_NOTIFICATION\" WHERE \"COACHING_NOTIFICATION\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT \"COACHING_NOTIFICATION\".\"ID\" FROM \"COACHING_NOTIFICATION\" \"COACHING_NOTIFICATION\" ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT \"COACHING_NOTIFICATION\".\"ID\",\"COACHING_NOTIFICATION\".\"NAME\",\"COACHING_NOTIFICATION\".\"PENDING_COACH_STATE_COUNT\",\"COACHING_NOTIFICATION\".\"PENDING_EMPLOYEE_STATE_COUNT\",\"COACHING_NOTIFICATION\".\"PENDING_STATE_COUNT\",\"COACHING_NOTIFICATION\".\"ACKNOWLEDGEMENT_STATE_COUNT\",\"COACHING_NOTIFICATION\".\"DATE\",\"COACHING_NOTIFICATION\".\"SKIPPED_STATE_COUNT\",\"COACHING_NOTIFICATION\".\"SUBMITTED_STATE_COUNT\",\"COACHING_NOTIFICATION\".\"TYPE\",\"COACHING_NOTIFICATION\".\"WEEKEND_DATE\",\"COACHING_NOTIFICATION\".\"TEAM_LEADER_ID\",\"COACHING_NOTIFICATION\".\"SCORECARD_ID\" FROM \"COACHING_NOTIFICATION\" \"COACHING_NOTIFICATION\" ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO COACHING_NOTIFICATION (\"ID\",\"NAME\",\"PENDING_COACH_STATE_COUNT\",\"PENDING_EMPLOYEE_STATE_COUNT\",\"PENDING_STATE_COUNT\",\"ACKNOWLEDGEMENT_STATE_COUNT\",\"DATE\",\"SKIPPED_STATE_COUNT\",\"SUBMITTED_STATE_COUNT\",\"TYPE\",\"WEEKEND_DATE\",\"TEAM_LEADER_ID\",\"SCORECARD_ID\") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE \"COACHING_NOTIFICATION\" SET \"NAME\"=?,\"PENDING_COACH_STATE_COUNT\"=?,\"PENDING_EMPLOYEE_STATE_COUNT\"=?,\"PENDING_STATE_COUNT\"=?,\"ACKNOWLEDGEMENT_STATE_COUNT\"=?,\"DATE\"=?,\"SKIPPED_STATE_COUNT\"=?,\"SUBMITTED_STATE_COUNT\"=?,\"TYPE\"=?,\"WEEKEND_DATE\"=?,\"TEAM_LEADER_ID\"=?,\"SCORECARD_ID\"=? WHERE \"ID\"=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM \"COACHING_NOTIFICATION\" WHERE \"ID\"=?";
	}
	
	@Override
	protected CoachingNotification extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	CoachingNotification nextResult = new CoachingNotification();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setName(rs.getString("NAME"));

nextResult.setPendingCoachStateCount(rs.getInt("PENDING_COACH_STATE_COUNT"));

nextResult.setPendingEmployeeStateCount(rs.getInt("PENDING_EMPLOYEE_STATE_COUNT"));

nextResult.setPendingStateCount(rs.getInt("PENDING_STATE_COUNT"));

nextResult.setAcknowledgementStateCount(rs.getInt("ACKNOWLEDGEMENT_STATE_COUNT"));

nextResult.setDate(rs.getString("DATE"));

nextResult.setSkippedStateCount(rs.getInt("SKIPPED_STATE_COUNT"));

nextResult.setSubmittedStateCount(rs.getInt("SUBMITTED_STATE_COUNT"));

nextResult.setType(rs.getString("TYPE"));

nextResult.setWeekendDate(rs.getDate("WEEKEND_DATE"));

TeamLeader teamleader = new TeamLeader();
teamleader.setID(rs.getString("TEAM_LEADER_ID"));
nextResult.setTeamLeader(teamleader);

Scorecard scorecard = new Scorecard();
scorecard.setID(rs.getString("SCORECARD_ID"));
nextResult.setScorecard(scorecard);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(CoachingNotification perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getName());
pstmt.setInt(3, perceroObject.getPendingCoachStateCount());
pstmt.setInt(4, perceroObject.getPendingEmployeeStateCount());
pstmt.setInt(5, perceroObject.getPendingStateCount());
pstmt.setInt(6, perceroObject.getAcknowledgementStateCount());
pstmt.setString(7, perceroObject.getDate());
pstmt.setInt(8, perceroObject.getSkippedStateCount());
pstmt.setInt(9, perceroObject.getSubmittedStateCount());
pstmt.setString(10, perceroObject.getType());
pstmt.setDate(11, DateUtils.utilDateToSqlDate(perceroObject.getWeekendDate()));

if (perceroObject.getTeamLeader() == null)
{
pstmt.setString(12, null);
}
else
{
		pstmt.setString(12, perceroObject.getTeamLeader().getID());
}


if (perceroObject.getScorecard() == null)
{
pstmt.setString(13, null);
}
else
{
		pstmt.setString(13, perceroObject.getScorecard().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(CoachingNotification perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getName());
pstmt.setInt(2, perceroObject.getPendingCoachStateCount());
pstmt.setInt(3, perceroObject.getPendingEmployeeStateCount());
pstmt.setInt(4, perceroObject.getPendingStateCount());
pstmt.setInt(5, perceroObject.getAcknowledgementStateCount());
pstmt.setString(6, perceroObject.getDate());
pstmt.setInt(7, perceroObject.getSkippedStateCount());
pstmt.setInt(8, perceroObject.getSubmittedStateCount());
pstmt.setString(9, perceroObject.getType());
pstmt.setDate(10, DateUtils.utilDateToSqlDate(perceroObject.getWeekendDate()));

if (perceroObject.getTeamLeader() == null)
{
pstmt.setString(11, null);
}
else
{
		pstmt.setString(11, perceroObject.getTeamLeader().getID());
}


if (perceroObject.getScorecard() == null)
{
pstmt.setString(12, null);
}
else
{
		pstmt.setString(12, perceroObject.getScorecard().getID());
}

pstmt.setString(13, perceroObject.getID());

		
	}

	@Override
	public List<CoachingNotification> findByExample(CoachingNotification theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useName = StringUtils.hasText(theQueryObject.getName()) && (excludeProperties == null || !excludeProperties.contains("name"));

if (useName)
{
sql += " WHERE ";
sql += " \"NAME\" =? ";
paramValues.add(theQueryObject.getName());
propertyCounter++;
}

boolean usePendingCoachStateCount = theQueryObject.getPendingCoachStateCount() != null && (excludeProperties == null || !excludeProperties.contains("pendingCoachStateCount"));

if (usePendingCoachStateCount)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"PENDING_COACH_STATE_COUNT\" =? ";
paramValues.add(theQueryObject.getPendingCoachStateCount());
propertyCounter++;
}

boolean usePendingEmployeeStateCount = theQueryObject.getPendingEmployeeStateCount() != null && (excludeProperties == null || !excludeProperties.contains("pendingEmployeeStateCount"));

if (usePendingEmployeeStateCount)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"PENDING_EMPLOYEE_STATE_COUNT\" =? ";
paramValues.add(theQueryObject.getPendingEmployeeStateCount());
propertyCounter++;
}

boolean usePendingStateCount = theQueryObject.getPendingStateCount() != null && (excludeProperties == null || !excludeProperties.contains("pendingStateCount"));

if (usePendingStateCount)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"PENDING_STATE_COUNT\" =? ";
paramValues.add(theQueryObject.getPendingStateCount());
propertyCounter++;
}

boolean useAcknowledgementStateCount = theQueryObject.getAcknowledgementStateCount() != null && (excludeProperties == null || !excludeProperties.contains("acknowledgementStateCount"));

if (useAcknowledgementStateCount)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"ACKNOWLEDGEMENT_STATE_COUNT\" =? ";
paramValues.add(theQueryObject.getAcknowledgementStateCount());
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
sql += " \"DATE\" =? ";
paramValues.add(theQueryObject.getDate());
propertyCounter++;
}

boolean useSkippedStateCount = theQueryObject.getSkippedStateCount() != null && (excludeProperties == null || !excludeProperties.contains("skippedStateCount"));

if (useSkippedStateCount)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"SKIPPED_STATE_COUNT\" =? ";
paramValues.add(theQueryObject.getSkippedStateCount());
propertyCounter++;
}

boolean useSubmittedStateCount = theQueryObject.getSubmittedStateCount() != null && (excludeProperties == null || !excludeProperties.contains("submittedStateCount"));

if (useSubmittedStateCount)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"SUBMITTED_STATE_COUNT\" =? ";
paramValues.add(theQueryObject.getSubmittedStateCount());
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

boolean useWeekendDate = theQueryObject.getWeekendDate() != null && (excludeProperties == null || !excludeProperties.contains("weekendDate"));

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
sql += " \"WEEKEND_DATE\" =? ";
paramValues.add(theQueryObject.getWeekendDate());
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
sql += " \"SCORECARD_ID\" =? ";
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
