
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
		return "SELECT coachingnotification.ID FROM CoachingNotification coachingnotification WHERE coachingnotification.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT coachingnotification.ID,coachingnotification.externalID,coachingnotification.type,coachingnotification.weekendDate,coachingnotification.name,coachingnotification.pendingCoachStateCount,coachingnotification.pendingEmployeeStateCount,coachingnotification.pendingStateCount,coachingnotification.acknowledgementStateCount,coachingnotification.date,coachingnotification.skippedStateCount,coachingnotification.submittedStateCount,coachingnotification.teamLeader_ID,coachingnotification.scorecard_ID FROM CoachingNotification coachingnotification WHERE coachingnotification.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT coachingnotification.ID FROM CoachingNotification coachingnotification ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT coachingnotification.ID FROM CoachingNotification coachingnotification ORDER BY coachingnotification.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT coachingnotification.ID,coachingnotification.externalID,coachingnotification.type,coachingnotification.weekendDate,coachingnotification.name,coachingnotification.pendingCoachStateCount,coachingnotification.pendingEmployeeStateCount,coachingnotification.pendingStateCount,coachingnotification.acknowledgementStateCount,coachingnotification.date,coachingnotification.skippedStateCount,coachingnotification.submittedStateCount,coachingnotification.teamLeader_ID,coachingnotification.scorecard_ID FROM CoachingNotification coachingnotification ORDER BY coachingnotification.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT coachingnotification.ID,coachingnotification.externalID,coachingnotification.type,coachingnotification.weekendDate,coachingnotification.name,coachingnotification.pendingCoachStateCount,coachingnotification.pendingEmployeeStateCount,coachingnotification.pendingStateCount,coachingnotification.acknowledgementStateCount,coachingnotification.date,coachingnotification.skippedStateCount,coachingnotification.submittedStateCount,coachingnotification.teamLeader_ID,coachingnotification.scorecard_ID FROM CoachingNotification coachingnotification ORDER BY coachingnotification.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM CoachingNotification coachingnotification";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT coachingnotification.ID,coachingnotification.externalID,coachingnotification.type,coachingnotification.weekendDate,coachingnotification.name,coachingnotification.pendingCoachStateCount,coachingnotification.pendingEmployeeStateCount,coachingnotification.pendingStateCount,coachingnotification.acknowledgementStateCount,coachingnotification.date,coachingnotification.skippedStateCount,coachingnotification.submittedStateCount,coachingnotification.teamLeader_ID,coachingnotification.scorecard_ID FROM CoachingNotification coachingnotification WHERE coachingnotification.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT coachingnotification.ID FROM CoachingNotification coachingnotification WHERE coachingnotification.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT coachingnotification.ID,coachingnotification.externalID,coachingnotification.type,coachingnotification.weekendDate,coachingnotification.name,coachingnotification.pendingCoachStateCount,coachingnotification.pendingEmployeeStateCount,coachingnotification.pendingStateCount,coachingnotification.acknowledgementStateCount,coachingnotification.date,coachingnotification.skippedStateCount,coachingnotification.submittedStateCount,coachingnotification.teamLeader_ID,coachingnotification.scorecard_ID FROM CoachingNotification coachingnotification WHERE coachingnotification." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT coachingnotification.ID FROM CoachingNotification coachingnotification WHERE coachingnotification." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT coachingnotification.ID FROM CoachingNotification coachingnotification ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT coachingnotification.ID,coachingnotification.externalID,coachingnotification.type,coachingnotification.weekendDate,coachingnotification.name,coachingnotification.pendingCoachStateCount,coachingnotification.pendingEmployeeStateCount,coachingnotification.pendingStateCount,coachingnotification.acknowledgementStateCount,coachingnotification.date,coachingnotification.skippedStateCount,coachingnotification.submittedStateCount,coachingnotification.teamLeader_ID,coachingnotification.scorecard_ID FROM CoachingNotification coachingnotification ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO CoachingNotification (ID,externalID,type,weekendDate,name,pendingCoachStateCount,pendingEmployeeStateCount,pendingStateCount,acknowledgementStateCount,date,skippedStateCount,submittedStateCount,teamLeader_ID,scorecard_ID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE CoachingNotification SET externalID=?,type=?,weekendDate=?,name=?,pendingCoachStateCount=?,pendingEmployeeStateCount=?,pendingStateCount=?,acknowledgementStateCount=?,date=?,skippedStateCount=?,submittedStateCount=?,teamLeader_ID=?,scorecard_ID=? WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM CoachingNotification WHERE ID=?";
	}
	
	@Override
	protected CoachingNotification extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	CoachingNotification nextResult = new CoachingNotification();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setExternalID(rs.getString("externalID"));

nextResult.setType(rs.getString("type"));

nextResult.setWeekendDate(rs.getDate("weekendDate"));

nextResult.setName(rs.getString("name"));

nextResult.setPendingCoachStateCount(rs.getInt("pendingCoachStateCount"));

nextResult.setPendingEmployeeStateCount(rs.getInt("pendingEmployeeStateCount"));

nextResult.setPendingStateCount(rs.getInt("pendingStateCount"));

nextResult.setAcknowledgementStateCount(rs.getInt("acknowledgementStateCount"));

nextResult.setDate(rs.getString("date"));

nextResult.setSkippedStateCount(rs.getInt("skippedStateCount"));

nextResult.setSubmittedStateCount(rs.getInt("submittedStateCount"));

TeamLeader teamleader = new TeamLeader();
teamleader.setID(rs.getString("teamleader_ID"));
nextResult.setTeamLeader(teamleader);

Scorecard scorecard = new Scorecard();
scorecard.setID(rs.getString("scorecard_ID"));
nextResult.setScorecard(scorecard);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(CoachingNotification perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getExternalID());
pstmt.setString(3, perceroObject.getType());
pstmt.setDate(4, DateUtils.utilDateToSqlDate(perceroObject.getWeekendDate()));
pstmt.setString(5, perceroObject.getName());
pstmt.setInt(6, perceroObject.getPendingCoachStateCount());
pstmt.setInt(7, perceroObject.getPendingEmployeeStateCount());
pstmt.setInt(8, perceroObject.getPendingStateCount());
pstmt.setInt(9, perceroObject.getAcknowledgementStateCount());
pstmt.setString(10, perceroObject.getDate());
pstmt.setInt(11, perceroObject.getSkippedStateCount());
pstmt.setInt(12, perceroObject.getSubmittedStateCount());

if (perceroObject.getTeamLeader() == null)
{
pstmt.setString(13, null);
}
else
{
		pstmt.setString(13, perceroObject.getTeamLeader().getID());
}


if (perceroObject.getScorecard() == null)
{
pstmt.setString(14, null);
}
else
{
		pstmt.setString(14, perceroObject.getScorecard().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(CoachingNotification perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getExternalID());
pstmt.setString(2, perceroObject.getType());
pstmt.setDate(3, DateUtils.utilDateToSqlDate(perceroObject.getWeekendDate()));
pstmt.setString(4, perceroObject.getName());
pstmt.setInt(5, perceroObject.getPendingCoachStateCount());
pstmt.setInt(6, perceroObject.getPendingEmployeeStateCount());
pstmt.setInt(7, perceroObject.getPendingStateCount());
pstmt.setInt(8, perceroObject.getAcknowledgementStateCount());
pstmt.setString(9, perceroObject.getDate());
pstmt.setInt(10, perceroObject.getSkippedStateCount());
pstmt.setInt(11, perceroObject.getSubmittedStateCount());

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

pstmt.setString(14, perceroObject.getID());

		
	}

	@Override
	public List<CoachingNotification> findByExample(CoachingNotification theQueryObject,
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
sql += " type=? ";
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
sql += " weekendDate=? ";
paramValues.add(theQueryObject.getWeekendDate());
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
sql += " pendingCoachStateCount=? ";
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
sql += " pendingEmployeeStateCount=? ";
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
sql += " pendingStateCount=? ";
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
sql += " acknowledgementStateCount=? ";
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
sql += " date=? ";
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
sql += " skippedStateCount=? ";
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
sql += " submittedStateCount=? ";
paramValues.add(theQueryObject.getSubmittedStateCount());
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
sql += " teamLeaderID=? ";
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
