
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
import com.percero.agents.sync.exceptions.SyncDataException;
import com.percero.agents.sync.exceptions.SyncException;

import com.pulse.mo.*;

/*
import com.pulse.mo.Agent;
import com.pulse.mo.ScheduledTime;
import com.pulse.mo.AdhocTask;
import com.pulse.mo.LOBConfigurationNotification;
import com.pulse.mo.AgentTime;
import com.pulse.mo.CorrectiveAction;
import com.pulse.mo.CoachingSession;
import com.pulse.mo.GeneralComment;
import com.pulse.mo.ActualTime;
import com.pulse.mo.AdhocCoachingSession;
import com.pulse.mo.Scorecard;
import com.pulse.mo.PerformanceSummary;
import com.pulse.mo.DevelopmentActivity;
import com.pulse.mo.TeamLeader;

*/

@Component
public class AgentDAO extends SqlDataAccessObject<Agent> implements IDataAccessObject<Agent> {

	static final Logger log = Logger.getLogger(AgentDAO.class);

	
	public AgentDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(Agent.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	@Override
	protected String getConnectionFactoryName() {
		return AgentDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT agent.ID FROM Agent agent WHERE agent.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT agent.ID,agent.lastName,agent.emailAddress,agent.externalID,agent.firstName,agent.fullName,agent.employeeId,agent.photoUri,agent.teamLeader_ID,agent.performanceSummary_ID,agent.developmentActivity_ID FROM Agent agent WHERE agent.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT agent.ID FROM Agent agent ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT agent.ID FROM Agent agent ORDER BY agent.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT agent.ID,agent.lastName,agent.emailAddress,agent.externalID,agent.firstName,agent.fullName,agent.employeeId,agent.photoUri,agent.teamLeader_ID,agent.performanceSummary_ID,agent.developmentActivity_ID FROM Agent agent ORDER BY agent.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT agent.ID,agent.lastName,agent.emailAddress,agent.externalID,agent.firstName,agent.fullName,agent.employeeId,agent.photoUri,agent.teamLeader_ID,agent.performanceSummary_ID,agent.developmentActivity_ID FROM Agent agent ORDER BY agent.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM Agent agent";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT agent.ID,agent.lastName,agent.emailAddress,agent.externalID,agent.firstName,agent.fullName,agent.employeeId,agent.photoUri,agent.teamLeader_ID,agent.performanceSummary_ID,agent.developmentActivity_ID FROM Agent agent WHERE agent.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT agent.ID FROM Agent agent WHERE agent.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT agent.ID,agent.lastName,agent.emailAddress,agent.externalID,agent.firstName,agent.fullName,agent.employeeId,agent.photoUri,agent.teamLeader_ID,agent.performanceSummary_ID,agent.developmentActivity_ID FROM Agent agent WHERE agent." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT agent.ID FROM Agent agent WHERE agent." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT agent.ID FROM Agent agent ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT agent.ID,agent.lastName,agent.emailAddress,agent.externalID,agent.firstName,agent.fullName,agent.employeeId,agent.photoUri,agent.teamLeader_ID,agent.performanceSummary_ID,agent.developmentActivity_ID FROM Agent agent ";
	}
	
	@Override
	protected String getInsertIntoSQL() throws SyncDataException {
		throw new SyncDataException(SyncDataException.READ_ONLY_ERROR, SyncDataException.READ_ONLY_ERROR_CODE);
	}
	
	@Override
	protected String getUpdateSet() throws SyncDataException {
		throw new SyncDataException(SyncDataException.READ_ONLY_ERROR, SyncDataException.READ_ONLY_ERROR_CODE);
	}
	
	@Override
	protected String getDeleteFromSQL() throws SyncDataException {
		throw new SyncDataException(SyncDataException.READ_ONLY_ERROR, SyncDataException.READ_ONLY_ERROR_CODE);
	}
	
	@Override
	protected Agent extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	Agent nextResult = new Agent();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setLastName(rs.getString("lastName"));

nextResult.setEmailAddress(rs.getString("emailAddress"));

nextResult.setExternalID(rs.getString("externalID"));

nextResult.setFirstName(rs.getString("firstName"));

nextResult.setFullName(rs.getString("fullName"));

nextResult.setEmployeeId(rs.getString("employeeId"));

nextResult.setPhotoUri(rs.getString("photoUri"));

TeamLeader teamleader = new TeamLeader();
teamleader.setID(rs.getString("teamleader_ID"));
nextResult.setTeamLeader(teamleader);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(Agent perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getLastName());
pstmt.setString(3, perceroObject.getEmailAddress());
pstmt.setString(4, perceroObject.getExternalID());
pstmt.setString(5, perceroObject.getFirstName());
pstmt.setString(6, perceroObject.getFullName());
pstmt.setString(7, perceroObject.getEmployeeId());
pstmt.setString(8, perceroObject.getPhotoUri());

if (perceroObject.getTeamLeader() == null)
{
pstmt.setString(10, null);
}
else
{
		pstmt.setString(10, perceroObject.getTeamLeader().getID());
}


	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(Agent perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getLastName());
pstmt.setString(2, perceroObject.getEmailAddress());
pstmt.setString(3, perceroObject.getExternalID());
pstmt.setString(4, perceroObject.getFirstName());
pstmt.setString(5, perceroObject.getFullName());
pstmt.setString(6, perceroObject.getEmployeeId());
pstmt.setString(7, perceroObject.getPhotoUri());

if (perceroObject.getTeamLeader() == null)
{
pstmt.setString(9, null);
}
else
{
		pstmt.setString(9, perceroObject.getTeamLeader().getID());
}


pstmt.setString(12, perceroObject.getID());

		
	}

	@Override
	public List<Agent> findByExample(Agent theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useLastName = StringUtils.hasText(theQueryObject.getLastName()) && (excludeProperties == null || !excludeProperties.contains("lastName"));

if (useLastName)
{
sql += " WHERE ";
paramValues.add(theQueryObject.getLastName());
propertyCounter++;
}

boolean useEmailAddress = StringUtils.hasText(theQueryObject.getEmailAddress()) && (excludeProperties == null || !excludeProperties.contains("emailAddress"));

if (useEmailAddress)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " emailAddress=? ";
paramValues.add(theQueryObject.getEmailAddress());
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

boolean useFirstName = StringUtils.hasText(theQueryObject.getFirstName()) && (excludeProperties == null || !excludeProperties.contains("firstName"));

if (useFirstName)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " firstName=? ";
paramValues.add(theQueryObject.getFirstName());
propertyCounter++;
}

boolean useFullName = StringUtils.hasText(theQueryObject.getFullName()) && (excludeProperties == null || !excludeProperties.contains("fullName"));

if (useFullName)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " fullName=? ";
paramValues.add(theQueryObject.getFullName());
propertyCounter++;
}

boolean useEmployeeId = StringUtils.hasText(theQueryObject.getEmployeeId()) && (excludeProperties == null || !excludeProperties.contains("employeeId"));

if (useEmployeeId)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " employeeId=? ";
paramValues.add(theQueryObject.getEmployeeId());
propertyCounter++;
}

boolean usePhotoUri = StringUtils.hasText(theQueryObject.getPhotoUri()) && (excludeProperties == null || !excludeProperties.contains("photoUri"));

if (usePhotoUri)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " photoUri=? ";
paramValues.add(theQueryObject.getPhotoUri());
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
