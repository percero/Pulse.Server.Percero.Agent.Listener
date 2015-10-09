
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
import com.pulse.mo.Scorecard;
import com.pulse.mo.AgentScorecard;
import com.pulse.mo.CoachingNotification;
import com.pulse.mo.ScorecardMeasure;
import com.pulse.mo.CoachingSession;
import com.pulse.mo.ScorecardState;

*/

@Component
public class ScorecardDAO extends SqlDataAccessObject<Scorecard> implements IDataAccessObject<Scorecard> {

	static final Logger log = Logger.getLogger(ScorecardDAO.class);

	
	public ScorecardDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(Scorecard.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	@Override
	protected String getConnectionFactoryName() {
		return ScorecardDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT SCORECARD.ID FROM SCORECARD SCORECARD WHERE SCORECARD.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT SCORECARD.ID,SCORECARD.NAME,SCORECARD.PENDING_COACH_COACHING_SESSION_COUNT,SCORECARD.PENDING_COACHING_SESSION_COUNT,SCORECARD.PENDING_EMPLOYEE_COACHING_SESSION_COUNT,SCORECARD.SCORECARD_NAME,SCORECARD.SKIPPED_COACHING_SESSION_COUNT,SCORECARD.SUBMITTED_COACHING_SESSION_COUNT,SCORECARD.TOTAL_COACHING_SESSION_COUNT,SCORECARD.ACKNOWLEDGED_COACHING_SESSION_COUNT,SCORECARD.SCORECARD_STATE_ID FROM SCORECARD SCORECARD WHERE SCORECARD.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT SCORECARD.ID FROM SCORECARD SCORECARD ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT SCORECARD.ID FROM SCORECARD SCORECARD ORDER BY SCORECARD.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT SCORECARD.ID,SCORECARD.NAME,SCORECARD.PENDING_COACH_COACHING_SESSION_COUNT,SCORECARD.PENDING_COACHING_SESSION_COUNT,SCORECARD.PENDING_EMPLOYEE_COACHING_SESSION_COUNT,SCORECARD.SCORECARD_NAME,SCORECARD.SKIPPED_COACHING_SESSION_COUNT,SCORECARD.SUBMITTED_COACHING_SESSION_COUNT,SCORECARD.TOTAL_COACHING_SESSION_COUNT,SCORECARD.ACKNOWLEDGED_COACHING_SESSION_COUNT,SCORECARD.SCORECARD_STATE_ID FROM SCORECARD SCORECARD ORDER BY SCORECARD.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT SCORECARD.ID,SCORECARD.NAME,SCORECARD.PENDING_COACH_COACHING_SESSION_COUNT,SCORECARD.PENDING_COACHING_SESSION_COUNT,SCORECARD.PENDING_EMPLOYEE_COACHING_SESSION_COUNT,SCORECARD.SCORECARD_NAME,SCORECARD.SKIPPED_COACHING_SESSION_COUNT,SCORECARD.SUBMITTED_COACHING_SESSION_COUNT,SCORECARD.TOTAL_COACHING_SESSION_COUNT,SCORECARD.ACKNOWLEDGED_COACHING_SESSION_COUNT,SCORECARD.SCORECARD_STATE_ID FROM SCORECARD SCORECARD ORDER BY SCORECARD.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM SCORECARD SCORECARD";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT SCORECARD.ID,SCORECARD.NAME,SCORECARD.PENDING_COACH_COACHING_SESSION_COUNT,SCORECARD.PENDING_COACHING_SESSION_COUNT,SCORECARD.PENDING_EMPLOYEE_COACHING_SESSION_COUNT,SCORECARD.SCORECARD_NAME,SCORECARD.SKIPPED_COACHING_SESSION_COUNT,SCORECARD.SUBMITTED_COACHING_SESSION_COUNT,SCORECARD.TOTAL_COACHING_SESSION_COUNT,SCORECARD.ACKNOWLEDGED_COACHING_SESSION_COUNT,SCORECARD.SCORECARD_STATE_ID FROM SCORECARD SCORECARD WHERE SCORECARD.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT SCORECARD.ID FROM SCORECARD SCORECARD WHERE SCORECARD.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT SCORECARD.ID,SCORECARD.NAME,SCORECARD.PENDING_COACH_COACHING_SESSION_COUNT,SCORECARD.PENDING_COACHING_SESSION_COUNT,SCORECARD.PENDING_EMPLOYEE_COACHING_SESSION_COUNT,SCORECARD.SCORECARD_NAME,SCORECARD.SKIPPED_COACHING_SESSION_COUNT,SCORECARD.SUBMITTED_COACHING_SESSION_COUNT,SCORECARD.TOTAL_COACHING_SESSION_COUNT,SCORECARD.ACKNOWLEDGED_COACHING_SESSION_COUNT,SCORECARD.SCORECARD_STATE_ID FROM SCORECARD SCORECARD WHERE SCORECARD." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT SCORECARD.ID FROM SCORECARD SCORECARD WHERE SCORECARD." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT SCORECARD.ID FROM SCORECARD SCORECARD ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT SCORECARD.ID,SCORECARD.NAME,SCORECARD.PENDING_COACH_COACHING_SESSION_COUNT,SCORECARD.PENDING_COACHING_SESSION_COUNT,SCORECARD.PENDING_EMPLOYEE_COACHING_SESSION_COUNT,SCORECARD.SCORECARD_NAME,SCORECARD.SKIPPED_COACHING_SESSION_COUNT,SCORECARD.SUBMITTED_COACHING_SESSION_COUNT,SCORECARD.TOTAL_COACHING_SESSION_COUNT,SCORECARD.ACKNOWLEDGED_COACHING_SESSION_COUNT,SCORECARD.SCORECARD_STATE_ID FROM SCORECARD SCORECARD ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO SCORECARD (ID,NAME,PENDING_COACH_COACHING_SESSION_COUNT,PENDING_COACHING_SESSION_COUNT,PENDING_EMPLOYEE_COACHING_SESSION_COUNT,SCORECARD_NAME,SKIPPED_COACHING_SESSION_COUNT,SUBMITTED_COACHING_SESSION_COUNT,TOTAL_COACHING_SESSION_COUNT,ACKNOWLEDGED_COACHING_SESSION_COUNT,SCORECARD_STATE_ID) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE SCORECARD SET NAME=?,PENDING_COACH_COACHING_SESSION_COUNT=?,PENDING_COACHING_SESSION_COUNT=?,PENDING_EMPLOYEE_COACHING_SESSION_COUNT=?,SCORECARD_NAME=?,SKIPPED_COACHING_SESSION_COUNT=?,SUBMITTED_COACHING_SESSION_COUNT=?,TOTAL_COACHING_SESSION_COUNT=?,ACKNOWLEDGED_COACHING_SESSION_COUNT=?,SCORECARD_STATE_ID=? WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM SCORECARD WHERE ID=?";
	}
	
	@Override
	protected Scorecard extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	Scorecard nextResult = new Scorecard();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setName(rs.getString("NAME"));

nextResult.setPendingCoachCoachingSessionCount(rs.getInt("PENDING_COACH_COACHING_SESSION_COUNT"));

nextResult.setPendingCoachingSessionCount(rs.getInt("PENDING_COACHING_SESSION_COUNT"));

nextResult.setPendingEmployeeCoachingSessionCount(rs.getInt("PENDING_EMPLOYEE_COACHING_SESSION_COUNT"));

nextResult.setScorecardName(rs.getString("SCORECARD_NAME"));

nextResult.setSkippedCoachingSessionCount(rs.getInt("SKIPPED_COACHING_SESSION_COUNT"));

nextResult.setSubmittedCoachingSessionCount(rs.getInt("SUBMITTED_COACHING_SESSION_COUNT"));

nextResult.setTotalCoachingSessionCount(rs.getInt("TOTAL_COACHING_SESSION_COUNT"));

nextResult.setAcknowledgedCoachingSessionCount(rs.getInt("ACKNOWLEDGED_COACHING_SESSION_COUNT"));

ScorecardState scorecardstate = new ScorecardState();
scorecardstate.setID(rs.getString("SCORECARD_STATE_ID"));
nextResult.setScorecardState(scorecardstate);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(Scorecard perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getName());
pstmt.setInt(3, perceroObject.getPendingCoachCoachingSessionCount());
pstmt.setInt(4, perceroObject.getPendingCoachingSessionCount());
pstmt.setInt(5, perceroObject.getPendingEmployeeCoachingSessionCount());
pstmt.setString(6, perceroObject.getScorecardName());
pstmt.setInt(7, perceroObject.getSkippedCoachingSessionCount());
pstmt.setInt(8, perceroObject.getSubmittedCoachingSessionCount());
pstmt.setInt(9, perceroObject.getTotalCoachingSessionCount());
pstmt.setInt(10, perceroObject.getAcknowledgedCoachingSessionCount());

if (perceroObject.getScorecardState() == null)
{
pstmt.setString(11, null);
}
else
{
		pstmt.setString(11, perceroObject.getScorecardState().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(Scorecard perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getName());
pstmt.setInt(2, perceroObject.getPendingCoachCoachingSessionCount());
pstmt.setInt(3, perceroObject.getPendingCoachingSessionCount());
pstmt.setInt(4, perceroObject.getPendingEmployeeCoachingSessionCount());
pstmt.setString(5, perceroObject.getScorecardName());
pstmt.setInt(6, perceroObject.getSkippedCoachingSessionCount());
pstmt.setInt(7, perceroObject.getSubmittedCoachingSessionCount());
pstmt.setInt(8, perceroObject.getTotalCoachingSessionCount());
pstmt.setInt(9, perceroObject.getAcknowledgedCoachingSessionCount());

if (perceroObject.getScorecardState() == null)
{
pstmt.setString(10, null);
}
else
{
		pstmt.setString(10, perceroObject.getScorecardState().getID());
}

pstmt.setString(11, perceroObject.getID());

		
	}

	@Override
	public List<Scorecard> findByExample(Scorecard theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useName = StringUtils.hasText(theQueryObject.getName()) && (excludeProperties == null || !excludeProperties.contains("name"));

if (useName)
{
sql += " WHERE ";
sql += " NAME=? ";
paramValues.add(theQueryObject.getName());
propertyCounter++;
}

boolean usePendingCoachCoachingSessionCount = theQueryObject.getPendingCoachCoachingSessionCount() != null && (excludeProperties == null || !excludeProperties.contains("pendingCoachCoachingSessionCount"));

if (usePendingCoachCoachingSessionCount)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " PENDING_COACH_COACHING_SESSION_COUNT=? ";
paramValues.add(theQueryObject.getPendingCoachCoachingSessionCount());
propertyCounter++;
}

boolean usePendingCoachingSessionCount = theQueryObject.getPendingCoachingSessionCount() != null && (excludeProperties == null || !excludeProperties.contains("pendingCoachingSessionCount"));

if (usePendingCoachingSessionCount)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " PENDING_COACHING_SESSION_COUNT=? ";
paramValues.add(theQueryObject.getPendingCoachingSessionCount());
propertyCounter++;
}

boolean usePendingEmployeeCoachingSessionCount = theQueryObject.getPendingEmployeeCoachingSessionCount() != null && (excludeProperties == null || !excludeProperties.contains("pendingEmployeeCoachingSessionCount"));

if (usePendingEmployeeCoachingSessionCount)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " PENDING_EMPLOYEE_COACHING_SESSION_COUNT=? ";
paramValues.add(theQueryObject.getPendingEmployeeCoachingSessionCount());
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
sql += " SCORECARD_NAME=? ";
paramValues.add(theQueryObject.getScorecardName());
propertyCounter++;
}

boolean useSkippedCoachingSessionCount = theQueryObject.getSkippedCoachingSessionCount() != null && (excludeProperties == null || !excludeProperties.contains("skippedCoachingSessionCount"));

if (useSkippedCoachingSessionCount)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " SKIPPED_COACHING_SESSION_COUNT=? ";
paramValues.add(theQueryObject.getSkippedCoachingSessionCount());
propertyCounter++;
}

boolean useSubmittedCoachingSessionCount = theQueryObject.getSubmittedCoachingSessionCount() != null && (excludeProperties == null || !excludeProperties.contains("submittedCoachingSessionCount"));

if (useSubmittedCoachingSessionCount)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " SUBMITTED_COACHING_SESSION_COUNT=? ";
paramValues.add(theQueryObject.getSubmittedCoachingSessionCount());
propertyCounter++;
}

boolean useTotalCoachingSessionCount = theQueryObject.getTotalCoachingSessionCount() != null && (excludeProperties == null || !excludeProperties.contains("totalCoachingSessionCount"));

if (useTotalCoachingSessionCount)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " TOTAL_COACHING_SESSION_COUNT=? ";
paramValues.add(theQueryObject.getTotalCoachingSessionCount());
propertyCounter++;
}

boolean useAcknowledgedCoachingSessionCount = theQueryObject.getAcknowledgedCoachingSessionCount() != null && (excludeProperties == null || !excludeProperties.contains("acknowledgedCoachingSessionCount"));

if (useAcknowledgedCoachingSessionCount)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " ACKNOWLEDGED_COACHING_SESSION_COUNT=? ";
paramValues.add(theQueryObject.getAcknowledgedCoachingSessionCount());
propertyCounter++;
}

boolean useScorecardStateID = theQueryObject.getScorecardState() != null && (excludeProperties == null || !excludeProperties.contains("scorecardState"));

if (useScorecardStateID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " SCORECARD_STATE_ID=? ";
paramValues.add(theQueryObject.getScorecardState().getID());
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
