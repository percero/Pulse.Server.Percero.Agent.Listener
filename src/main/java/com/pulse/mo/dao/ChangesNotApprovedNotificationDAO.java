
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
import com.pulse.mo.CVGProject;
import com.pulse.mo.EStartActivityCode;

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
		return "SELECT changesnotapprovednotification.ID FROM ChangesNotApprovedNotification changesnotapprovednotification WHERE changesnotapprovednotification.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT changesnotapprovednotification.ID,changesnotapprovednotification.resolved,changesnotapprovednotification.externalID,changesnotapprovednotification.type,changesnotapprovednotification.shiftEndDate,changesnotapprovednotification.inProgressStateCount,changesnotapprovednotification.name,changesnotapprovednotification.notYetStartedStateCount,changesnotapprovednotification.approvedStateCount,changesnotapprovednotification.completeStateCount,changesnotapprovednotification.date,changesnotapprovednotification.eStartActivityCode_ID,changesnotapprovednotification.cVGProject_ID,changesnotapprovednotification.teamLeader_ID FROM ChangesNotApprovedNotification changesnotapprovednotification WHERE changesnotapprovednotification.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT changesnotapprovednotification.ID FROM ChangesNotApprovedNotification changesnotapprovednotification ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT changesnotapprovednotification.ID FROM ChangesNotApprovedNotification changesnotapprovednotification ORDER BY changesnotapprovednotification.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT changesnotapprovednotification.ID,changesnotapprovednotification.resolved,changesnotapprovednotification.externalID,changesnotapprovednotification.type,changesnotapprovednotification.shiftEndDate,changesnotapprovednotification.inProgressStateCount,changesnotapprovednotification.name,changesnotapprovednotification.notYetStartedStateCount,changesnotapprovednotification.approvedStateCount,changesnotapprovednotification.completeStateCount,changesnotapprovednotification.date,changesnotapprovednotification.eStartActivityCode_ID,changesnotapprovednotification.cVGProject_ID,changesnotapprovednotification.teamLeader_ID FROM ChangesNotApprovedNotification changesnotapprovednotification ORDER BY changesnotapprovednotification.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT changesnotapprovednotification.ID,changesnotapprovednotification.resolved,changesnotapprovednotification.externalID,changesnotapprovednotification.type,changesnotapprovednotification.shiftEndDate,changesnotapprovednotification.inProgressStateCount,changesnotapprovednotification.name,changesnotapprovednotification.notYetStartedStateCount,changesnotapprovednotification.approvedStateCount,changesnotapprovednotification.completeStateCount,changesnotapprovednotification.date,changesnotapprovednotification.eStartActivityCode_ID,changesnotapprovednotification.cVGProject_ID,changesnotapprovednotification.teamLeader_ID FROM ChangesNotApprovedNotification changesnotapprovednotification ORDER BY changesnotapprovednotification.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM ChangesNotApprovedNotification changesnotapprovednotification";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT changesnotapprovednotification.ID,changesnotapprovednotification.resolved,changesnotapprovednotification.externalID,changesnotapprovednotification.type,changesnotapprovednotification.shiftEndDate,changesnotapprovednotification.inProgressStateCount,changesnotapprovednotification.name,changesnotapprovednotification.notYetStartedStateCount,changesnotapprovednotification.approvedStateCount,changesnotapprovednotification.completeStateCount,changesnotapprovednotification.date,changesnotapprovednotification.eStartActivityCode_ID,changesnotapprovednotification.cVGProject_ID,changesnotapprovednotification.teamLeader_ID FROM ChangesNotApprovedNotification changesnotapprovednotification WHERE changesnotapprovednotification.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT changesnotapprovednotification.ID FROM ChangesNotApprovedNotification changesnotapprovednotification WHERE changesnotapprovednotification.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT changesnotapprovednotification.ID,changesnotapprovednotification.resolved,changesnotapprovednotification.externalID,changesnotapprovednotification.type,changesnotapprovednotification.shiftEndDate,changesnotapprovednotification.inProgressStateCount,changesnotapprovednotification.name,changesnotapprovednotification.notYetStartedStateCount,changesnotapprovednotification.approvedStateCount,changesnotapprovednotification.completeStateCount,changesnotapprovednotification.date,changesnotapprovednotification.eStartActivityCode_ID,changesnotapprovednotification.cVGProject_ID,changesnotapprovednotification.teamLeader_ID FROM ChangesNotApprovedNotification changesnotapprovednotification WHERE changesnotapprovednotification." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT changesnotapprovednotification.ID FROM ChangesNotApprovedNotification changesnotapprovednotification WHERE changesnotapprovednotification." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT changesnotapprovednotification.ID FROM ChangesNotApprovedNotification changesnotapprovednotification ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT changesnotapprovednotification.ID,changesnotapprovednotification.resolved,changesnotapprovednotification.externalID,changesnotapprovednotification.type,changesnotapprovednotification.shiftEndDate,changesnotapprovednotification.inProgressStateCount,changesnotapprovednotification.name,changesnotapprovednotification.notYetStartedStateCount,changesnotapprovednotification.approvedStateCount,changesnotapprovednotification.completeStateCount,changesnotapprovednotification.date,changesnotapprovednotification.eStartActivityCode_ID,changesnotapprovednotification.cVGProject_ID,changesnotapprovednotification.teamLeader_ID FROM ChangesNotApprovedNotification changesnotapprovednotification ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO ChangesNotApprovedNotification (ID,resolved,externalID,type,shiftEndDate,inProgressStateCount,name,notYetStartedStateCount,approvedStateCount,completeStateCount,date,eStartActivityCode_ID,cVGProject_ID,teamLeader_ID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE ChangesNotApprovedNotification SET resolved=?,externalID=?,type=?,shiftEndDate=?,inProgressStateCount=?,name=?,notYetStartedStateCount=?,approvedStateCount=?,completeStateCount=?,date=?,eStartActivityCode_ID=?,cVGProject_ID=?,teamLeader_ID=? WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM ChangesNotApprovedNotification WHERE ID=?";
	}
	
	@Override
	protected ChangesNotApprovedNotification extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	ChangesNotApprovedNotification nextResult = new ChangesNotApprovedNotification();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setResolved(rs.getBoolean("resolved"));

nextResult.setExternalID(rs.getString("externalID"));

nextResult.setType(rs.getString("type"));

nextResult.setShiftEndDate(rs.getDate("shiftEndDate"));

nextResult.setInProgressStateCount(rs.getInt("inProgressStateCount"));

nextResult.setName(rs.getString("name"));

nextResult.setNotYetStartedStateCount(rs.getInt("notYetStartedStateCount"));

nextResult.setApprovedStateCount(rs.getInt("approvedStateCount"));

nextResult.setCompleteStateCount(rs.getInt("completeStateCount"));

nextResult.setDate(rs.getString("date"));

EStartActivityCode estartactivitycode = new EStartActivityCode();
estartactivitycode.setID(rs.getString("estartactivitycode_ID"));
nextResult.setEStartActivityCode(estartactivitycode);

CVGProject cvgproject = new CVGProject();
cvgproject.setID(rs.getString("cvgproject_ID"));
nextResult.setCVGProject(cvgproject);

TeamLeader teamleader = new TeamLeader();
teamleader.setID(rs.getString("teamleader_ID"));
nextResult.setTeamLeader(teamleader);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(ChangesNotApprovedNotification perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setBoolean(2, perceroObject.getResolved());
pstmt.setString(3, perceroObject.getExternalID());
pstmt.setString(4, perceroObject.getType());
pstmt.setDate(5, DateUtils.utilDateToSqlDate(perceroObject.getShiftEndDate()));
pstmt.setInt(6, perceroObject.getInProgressStateCount());
pstmt.setString(7, perceroObject.getName());
pstmt.setInt(8, perceroObject.getNotYetStartedStateCount());
pstmt.setInt(9, perceroObject.getApprovedStateCount());
pstmt.setInt(10, perceroObject.getCompleteStateCount());
pstmt.setString(11, perceroObject.getDate());

if (perceroObject.getEStartActivityCode() == null)
{
pstmt.setString(12, null);
}
else
{
		pstmt.setString(12, perceroObject.getEStartActivityCode().getID());
}


if (perceroObject.getCVGProject() == null)
{
pstmt.setString(13, null);
}
else
{
		pstmt.setString(13, perceroObject.getCVGProject().getID());
}


if (perceroObject.getTeamLeader() == null)
{
pstmt.setString(14, null);
}
else
{
		pstmt.setString(14, perceroObject.getTeamLeader().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(ChangesNotApprovedNotification perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setBoolean(1, perceroObject.getResolved());
pstmt.setString(2, perceroObject.getExternalID());
pstmt.setString(3, perceroObject.getType());
pstmt.setDate(4, DateUtils.utilDateToSqlDate(perceroObject.getShiftEndDate()));
pstmt.setInt(5, perceroObject.getInProgressStateCount());
pstmt.setString(6, perceroObject.getName());
pstmt.setInt(7, perceroObject.getNotYetStartedStateCount());
pstmt.setInt(8, perceroObject.getApprovedStateCount());
pstmt.setInt(9, perceroObject.getCompleteStateCount());
pstmt.setString(10, perceroObject.getDate());

if (perceroObject.getEStartActivityCode() == null)
{
pstmt.setString(11, null);
}
else
{
		pstmt.setString(11, perceroObject.getEStartActivityCode().getID());
}


if (perceroObject.getCVGProject() == null)
{
pstmt.setString(12, null);
}
else
{
		pstmt.setString(12, perceroObject.getCVGProject().getID());
}


if (perceroObject.getTeamLeader() == null)
{
pstmt.setString(13, null);
}
else
{
		pstmt.setString(13, perceroObject.getTeamLeader().getID());
}

pstmt.setString(14, perceroObject.getID());

		
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
paramValues.add(theQueryObject.getResolved());
propertyCounter++;
}

boolean useExternalID = StringUtils.hasText(theQueryObject.getExternalID()) && (excludeProperties == null || !excludeProperties.contains("externalID"));

if (useExternalID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " externalID=? ";
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
sql += " shiftEndDate=? ";
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
sql += " inProgressStateCount=? ";
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
sql += " name=? ";
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
sql += " notYetStartedStateCount=? ";
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
sql += " approvedStateCount=? ";
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
sql += " completeStateCount=? ";
paramValues.add(theQueryObject.getCompleteStateCount());
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

boolean useEStartActivityCodeID = theQueryObject.getEStartActivityCode() != null && (excludeProperties == null || !excludeProperties.contains("eStartActivityCode"));

if (useEStartActivityCodeID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " eStartActivityCodeID=? ";
paramValues.add(theQueryObject.getEStartActivityCode().getID());
propertyCounter++;
}

boolean useCVGProjectID = theQueryObject.getCVGProject() != null && (excludeProperties == null || !excludeProperties.contains("cVGProject"));

if (useCVGProjectID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " cVGProjectID=? ";
paramValues.add(theQueryObject.getCVGProject().getID());
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
