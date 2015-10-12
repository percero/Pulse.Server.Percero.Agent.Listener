
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
import com.pulse.mo.ChangesNotApprovedNotification;
import com.pulse.mo.TimecardActivity;

*/

@Component
public class ChangesNotApprovedNotificationDAO extends SqlDataAccessObject<ChangesNotApprovedNotification> implements IDataAccessObject<ChangesNotApprovedNotification> {

	static final Logger log = Logger.getLogger(ChangesNotApprovedNotificationDAO.class);

	
	public ChangesNotApprovedNotificationDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(ChangesNotApprovedNotification.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	
	
	
	@Override
	protected String getConnectionFactoryName() {
		return ChangesNotApprovedNotificationDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT \"CHANGES_NOT_APPROVED_NOTIF\".\"ID\" FROM \"CHANGES_NOT_APPROVED_NOTIF\" \"CHANGES_NOT_APPROVED_NOTIF\" WHERE \"CHANGES_NOT_APPROVED_NOTIF\".\"ID\"=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT \"CHANGES_NOT_APPROVED_NOTIF\".\"ID\",\"CHANGES_NOT_APPROVED_NOTIF\".\"RESOLVED\",\"CHANGES_NOT_APPROVED_NOTIF\".\"SHIFT_END_DATE\",\"CHANGES_NOT_APPROVED_NOTIF\".\"IN_PROGRESS_STATE_COUNT\",\"CHANGES_NOT_APPROVED_NOTIF\".\"NAME\",\"CHANGES_NOT_APPROVED_NOTIF\".\"NOT_YET_STARTED_STATE_COUNT\",\"CHANGES_NOT_APPROVED_NOTIF\".\"APPROVED_STATE_COUNT\",\"CHANGES_NOT_APPROVED_NOTIF\".\"COMPLETE_STATE_COUNT\",\"CHANGES_NOT_APPROVED_NOTIF\".\"DATE\",\"CHANGES_NOT_APPROVED_NOTIF\".\"TYPE\",\"CHANGES_NOT_APPROVED_NOTIF\".\"TEAM_LEADER_ID\" FROM \"CHANGES_NOT_APPROVED_NOTIF\" \"CHANGES_NOT_APPROVED_NOTIF\" WHERE \"CHANGES_NOT_APPROVED_NOTIF\".\"ID\"=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT \"CHANGES_NOT_APPROVED_NOTIF\".\"ID\" FROM \"CHANGES_NOT_APPROVED_NOTIF\" \"CHANGES_NOT_APPROVED_NOTIF\" ORDER BY \"ID\"";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT \"CHANGES_NOT_APPROVED_NOTIF\".\"ID\" FROM \"CHANGES_NOT_APPROVED_NOTIF\" \"CHANGES_NOT_APPROVED_NOTIF\" ORDER BY \"CHANGES_NOT_APPROVED_NOTIF\".\"ID\" LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT \"CHANGES_NOT_APPROVED_NOTIF\".\"ID\",\"CHANGES_NOT_APPROVED_NOTIF\".\"RESOLVED\",\"CHANGES_NOT_APPROVED_NOTIF\".\"SHIFT_END_DATE\",\"CHANGES_NOT_APPROVED_NOTIF\".\"IN_PROGRESS_STATE_COUNT\",\"CHANGES_NOT_APPROVED_NOTIF\".\"NAME\",\"CHANGES_NOT_APPROVED_NOTIF\".\"NOT_YET_STARTED_STATE_COUNT\",\"CHANGES_NOT_APPROVED_NOTIF\".\"APPROVED_STATE_COUNT\",\"CHANGES_NOT_APPROVED_NOTIF\".\"COMPLETE_STATE_COUNT\",\"CHANGES_NOT_APPROVED_NOTIF\".\"DATE\",\"CHANGES_NOT_APPROVED_NOTIF\".\"TYPE\",\"CHANGES_NOT_APPROVED_NOTIF\".\"TEAM_LEADER_ID\" FROM \"CHANGES_NOT_APPROVED_NOTIF\" \"CHANGES_NOT_APPROVED_NOTIF\" ORDER BY \"CHANGES_NOT_APPROVED_NOTIF\".\"ID\"";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT \"CHANGES_NOT_APPROVED_NOTIF\".\"ID\",\"CHANGES_NOT_APPROVED_NOTIF\".\"RESOLVED\",\"CHANGES_NOT_APPROVED_NOTIF\".\"SHIFT_END_DATE\",\"CHANGES_NOT_APPROVED_NOTIF\".\"IN_PROGRESS_STATE_COUNT\",\"CHANGES_NOT_APPROVED_NOTIF\".\"NAME\",\"CHANGES_NOT_APPROVED_NOTIF\".\"NOT_YET_STARTED_STATE_COUNT\",\"CHANGES_NOT_APPROVED_NOTIF\".\"APPROVED_STATE_COUNT\",\"CHANGES_NOT_APPROVED_NOTIF\".\"COMPLETE_STATE_COUNT\",\"CHANGES_NOT_APPROVED_NOTIF\".\"DATE\",\"CHANGES_NOT_APPROVED_NOTIF\".\"TYPE\",\"CHANGES_NOT_APPROVED_NOTIF\".\"TEAM_LEADER_ID\" FROM \"CHANGES_NOT_APPROVED_NOTIF\" \"CHANGES_NOT_APPROVED_NOTIF\" ORDER BY \"CHANGES_NOT_APPROVED_NOTIF\".\"ID\" LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM \"CHANGES_NOT_APPROVED_NOTIF\" \"CHANGES_NOT_APPROVED_NOTIF\"";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT \"CHANGES_NOT_APPROVED_NOTIF\".\"ID\",\"CHANGES_NOT_APPROVED_NOTIF\".\"RESOLVED\",\"CHANGES_NOT_APPROVED_NOTIF\".\"SHIFT_END_DATE\",\"CHANGES_NOT_APPROVED_NOTIF\".\"IN_PROGRESS_STATE_COUNT\",\"CHANGES_NOT_APPROVED_NOTIF\".\"NAME\",\"CHANGES_NOT_APPROVED_NOTIF\".\"NOT_YET_STARTED_STATE_COUNT\",\"CHANGES_NOT_APPROVED_NOTIF\".\"APPROVED_STATE_COUNT\",\"CHANGES_NOT_APPROVED_NOTIF\".\"COMPLETE_STATE_COUNT\",\"CHANGES_NOT_APPROVED_NOTIF\".\"DATE\",\"CHANGES_NOT_APPROVED_NOTIF\".\"TYPE\",\"CHANGES_NOT_APPROVED_NOTIF\".\"TEAM_LEADER_ID\" FROM \"CHANGES_NOT_APPROVED_NOTIF\" \"CHANGES_NOT_APPROVED_NOTIF\" WHERE \"CHANGES_NOT_APPROVED_NOTIF\".\"ID\" IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT \"CHANGES_NOT_APPROVED_NOTIF\".\"ID\" FROM \"CHANGES_NOT_APPROVED_NOTIF\" \"CHANGES_NOT_APPROVED_NOTIF\" WHERE \"CHANGES_NOT_APPROVED_NOTIF\".\"ID\" IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		return "SELECT \"CHANGES_NOT_APPROVED_NOTIF\".\"ID\",\"CHANGES_NOT_APPROVED_NOTIF\".\"RESOLVED\",\"CHANGES_NOT_APPROVED_NOTIF\".\"SHIFT_END_DATE\",\"CHANGES_NOT_APPROVED_NOTIF\".\"IN_PROGRESS_STATE_COUNT\",\"CHANGES_NOT_APPROVED_NOTIF\".\"NAME\",\"CHANGES_NOT_APPROVED_NOTIF\".\"NOT_YET_STARTED_STATE_COUNT\",\"CHANGES_NOT_APPROVED_NOTIF\".\"APPROVED_STATE_COUNT\",\"CHANGES_NOT_APPROVED_NOTIF\".\"COMPLETE_STATE_COUNT\",\"CHANGES_NOT_APPROVED_NOTIF\".\"DATE\",\"CHANGES_NOT_APPROVED_NOTIF\".\"TYPE\",\"CHANGES_NOT_APPROVED_NOTIF\".\"TEAM_LEADER_ID\" FROM \"CHANGES_NOT_APPROVED_NOTIF\" \"CHANGES_NOT_APPROVED_NOTIF\" WHERE \"CHANGES_NOT_APPROVED_NOTIF\"." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT \"CHANGES_NOT_APPROVED_NOTIF\".\"ID\" FROM \"CHANGES_NOT_APPROVED_NOTIF\" \"CHANGES_NOT_APPROVED_NOTIF\" WHERE \"CHANGES_NOT_APPROVED_NOTIF\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT \"CHANGES_NOT_APPROVED_NOTIF\".\"ID\" FROM \"CHANGES_NOT_APPROVED_NOTIF\" \"CHANGES_NOT_APPROVED_NOTIF\" ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT \"CHANGES_NOT_APPROVED_NOTIF\".\"ID\",\"CHANGES_NOT_APPROVED_NOTIF\".\"RESOLVED\",\"CHANGES_NOT_APPROVED_NOTIF\".\"SHIFT_END_DATE\",\"CHANGES_NOT_APPROVED_NOTIF\".\"IN_PROGRESS_STATE_COUNT\",\"CHANGES_NOT_APPROVED_NOTIF\".\"NAME\",\"CHANGES_NOT_APPROVED_NOTIF\".\"NOT_YET_STARTED_STATE_COUNT\",\"CHANGES_NOT_APPROVED_NOTIF\".\"APPROVED_STATE_COUNT\",\"CHANGES_NOT_APPROVED_NOTIF\".\"COMPLETE_STATE_COUNT\",\"CHANGES_NOT_APPROVED_NOTIF\".\"DATE\",\"CHANGES_NOT_APPROVED_NOTIF\".\"TYPE\",\"CHANGES_NOT_APPROVED_NOTIF\".\"TEAM_LEADER_ID\" FROM \"CHANGES_NOT_APPROVED_NOTIF\" \"CHANGES_NOT_APPROVED_NOTIF\" ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO CHANGES_NOT_APPROVED_NOTIF (\"ID\",\"RESOLVED\",\"SHIFT_END_DATE\",\"IN_PROGRESS_STATE_COUNT\",\"NAME\",\"NOT_YET_STARTED_STATE_COUNT\",\"APPROVED_STATE_COUNT\",\"COMPLETE_STATE_COUNT\",\"DATE\",\"TYPE\",\"TEAM_LEADER_ID\") VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE \"CHANGES_NOT_APPROVED_NOTIF\" SET \"RESOLVED\"=?,\"SHIFT_END_DATE\"=?,\"IN_PROGRESS_STATE_COUNT\"=?,\"NAME\"=?,\"NOT_YET_STARTED_STATE_COUNT\"=?,\"APPROVED_STATE_COUNT\"=?,\"COMPLETE_STATE_COUNT\"=?,\"DATE\"=?,\"TYPE\"=?,\"TEAM_LEADER_ID\"=? WHERE \"ID\"=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM \"CHANGES_NOT_APPROVED_NOTIF\" WHERE \"ID\"=?";
	}
	
	@Override
	protected ChangesNotApprovedNotification extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	ChangesNotApprovedNotification nextResult = new ChangesNotApprovedNotification();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setResolved(rs.getBoolean("RESOLVED"));

nextResult.setShiftEndDate(rs.getDate("SHIFT_END_DATE"));

nextResult.setInProgressStateCount(rs.getInt("IN_PROGRESS_STATE_COUNT"));

nextResult.setName(rs.getString("NAME"));

nextResult.setNotYetStartedStateCount(rs.getInt("NOT_YET_STARTED_STATE_COUNT"));

nextResult.setApprovedStateCount(rs.getInt("APPROVED_STATE_COUNT"));

nextResult.setCompleteStateCount(rs.getInt("COMPLETE_STATE_COUNT"));

nextResult.setDate(rs.getDate("DATE"));

nextResult.setType(rs.getString("TYPE"));

TeamLeader teamleader = new TeamLeader();
teamleader.setID(rs.getString("TEAM_LEADER_ID"));
nextResult.setTeamLeader(teamleader);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(ChangesNotApprovedNotification perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setBoolean(2, perceroObject.getResolved());
pstmt.setDate(3, DateUtils.utilDateToSqlDate(perceroObject.getShiftEndDate()));
pstmt.setInt(4, perceroObject.getInProgressStateCount());
pstmt.setString(5, perceroObject.getName());
pstmt.setInt(6, perceroObject.getNotYetStartedStateCount());
pstmt.setInt(7, perceroObject.getApprovedStateCount());
pstmt.setInt(8, perceroObject.getCompleteStateCount());
pstmt.setDate(9, DateUtils.utilDateToSqlDate(perceroObject.getDate()));
pstmt.setString(10, perceroObject.getType());

if (perceroObject.getTeamLeader() == null)
{
pstmt.setString(11, null);
}
else
{
		pstmt.setString(11, perceroObject.getTeamLeader().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(ChangesNotApprovedNotification perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setBoolean(1, perceroObject.getResolved());
pstmt.setDate(2, DateUtils.utilDateToSqlDate(perceroObject.getShiftEndDate()));
pstmt.setInt(3, perceroObject.getInProgressStateCount());
pstmt.setString(4, perceroObject.getName());
pstmt.setInt(5, perceroObject.getNotYetStartedStateCount());
pstmt.setInt(6, perceroObject.getApprovedStateCount());
pstmt.setInt(7, perceroObject.getCompleteStateCount());
pstmt.setDate(8, DateUtils.utilDateToSqlDate(perceroObject.getDate()));
pstmt.setString(9, perceroObject.getType());

if (perceroObject.getTeamLeader() == null)
{
pstmt.setString(10, null);
}
else
{
		pstmt.setString(10, perceroObject.getTeamLeader().getID());
}

pstmt.setString(11, perceroObject.getID());

		
	}

	@Override
	public List<ChangesNotApprovedNotification> findByExample(ChangesNotApprovedNotification theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useResolved = theQueryObject.getResolved() != null && (excludeProperties == null || !excludeProperties.contains("resolved"));

if (useResolved)
{
sql += " WHERE ";
sql += " \"RESOLVED\" =? ";
paramValues.add(theQueryObject.getResolved());
propertyCounter++;
}

boolean useShiftEndDate = theQueryObject.getShiftEndDate() != null && (excludeProperties == null || !excludeProperties.contains("shiftEndDate"));

if (useShiftEndDate)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"SHIFT_END_DATE\" =? ";
paramValues.add(theQueryObject.getShiftEndDate());
propertyCounter++;
}

boolean useInProgressStateCount = theQueryObject.getInProgressStateCount() != null && (excludeProperties == null || !excludeProperties.contains("inProgressStateCount"));

if (useInProgressStateCount)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"IN_PROGRESS_STATE_COUNT\" =? ";
paramValues.add(theQueryObject.getInProgressStateCount());
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

boolean useNotYetStartedStateCount = theQueryObject.getNotYetStartedStateCount() != null && (excludeProperties == null || !excludeProperties.contains("notYetStartedStateCount"));

if (useNotYetStartedStateCount)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"NOT_YET_STARTED_STATE_COUNT\" =? ";
paramValues.add(theQueryObject.getNotYetStartedStateCount());
propertyCounter++;
}

boolean useApprovedStateCount = theQueryObject.getApprovedStateCount() != null && (excludeProperties == null || !excludeProperties.contains("approvedStateCount"));

if (useApprovedStateCount)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"APPROVED_STATE_COUNT\" =? ";
paramValues.add(theQueryObject.getApprovedStateCount());
propertyCounter++;
}

boolean useCompleteStateCount = theQueryObject.getCompleteStateCount() != null && (excludeProperties == null || !excludeProperties.contains("completeStateCount"));

if (useCompleteStateCount)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"COMPLETE_STATE_COUNT\" =? ";
paramValues.add(theQueryObject.getCompleteStateCount());
propertyCounter++;
}

boolean useDate = theQueryObject.getDate() != null && (excludeProperties == null || !excludeProperties.contains("date"));

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
