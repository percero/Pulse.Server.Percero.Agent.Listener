

package com.pulse.mo.dao;

import com.percero.agents.sync.dao.DAORegistry;
import com.percero.agents.sync.dao.IDataAccessObject;
import com.percero.agents.sync.exceptions.SyncException;
import com.pulse.mo.PulseUser;
import com.pulse.mo.TeamLeader;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
import com.pulse.mo.PulseUser;
import com.pulse.mo.Credential;
import com.pulse.mo.Dashboard;
import com.pulse.mo.Email;
import com.pulse.mo.TeamLeaderImpersonation;
import com.pulse.mo.UserRole;
import com.pulse.mo.TraceEntry;
import com.pulse.mo.UserSession;
import com.pulse.mo.TeamLeader;

*/

@Component
public class PulseUserDAO extends SqlDataAccessObject<PulseUser> implements IDataAccessObject<PulseUser> {

	static final Logger log = Logger.getLogger(PulseUserDAO.class);

	
	public PulseUserDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(PulseUser.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	@Override
	protected String getConnectionFactoryName() {
		return PulseUserDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT pulseuser.ID FROM PulseUser pulseuser WHERE pulseuser.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
//		return "SELECT pulseuser.ID,pulseuser.externalID,pulseuser.userId,pulseuser.employeeId,pulseuser.firstName,pulseuser.fullName,pulseuser.lastName,pulseuser.photoUri,pulseuser.teamLeader_ID FROM PulseUser pulseuser WHERE pulseuser.ID=?";
		return "SELECT pulseuser.ID,pulseuser.employeeId,pulseuser.\"TeamLeader_ID\" FROM \"PulseUser\" pulseuser WHERE pulseuser.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT pulseuser.ID FROM PulseUser pulseuser ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT pulseuser.ID FROM PulseUser pulseuser ORDER BY pulseuser.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT pulseuser.ID,pulseuser.externalID,pulseuser.userId,pulseuser.employeeId,pulseuser.firstName,pulseuser.fullName,pulseuser.lastName,pulseuser.photoUri,pulseuser.teamLeader_ID FROM PulseUser pulseuser ORDER BY pulseuser.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT pulseuser.ID,pulseuser.externalID,pulseuser.userId,pulseuser.employeeId,pulseuser.firstName,pulseuser.fullName,pulseuser.lastName,pulseuser.photoUri,pulseuser.teamLeader_ID FROM PulseUser pulseuser ORDER BY pulseuser.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM PulseUser pulseuser";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT pulseuser.ID,pulseuser.externalID,pulseuser.userId,pulseuser.employeeId,pulseuser.firstName,pulseuser.fullName,pulseuser.lastName,pulseuser.photoUri,pulseuser.teamLeader_ID FROM PulseUser pulseuser WHERE pulseuser.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT pulseuser.ID FROM PulseUser pulseuser WHERE pulseuser.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT pulseuser.ID,pulseuser.externalID,pulseuser.userId,pulseuser.employeeId,pulseuser.firstName,pulseuser.fullName,pulseuser.lastName,pulseuser.photoUri,pulseuser.teamLeader_ID FROM PulseUser pulseuser WHERE pulseuser." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT pulseuser.ID FROM PulseUser pulseuser WHERE pulseuser." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT pulseuser.ID FROM PulseUser pulseuser ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT pulseuser.ID,pulseuser.externalID,pulseuser.userId,pulseuser.employeeId,pulseuser.firstName,pulseuser.fullName,pulseuser.lastName,pulseuser.photoUri,pulseuser.teamLeader_ID FROM PulseUser pulseuser ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO PulseUser (ID,externalID,userId,employeeId,firstName,fullName,lastName,photoUri,teamLeader_ID) VALUES (?,?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE PulseUser SET externalID=?,userId=?,employeeId=?,firstName=?,fullName=?,lastName=?,photoUri=?,teamLeader_ID=? WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM PulseUser WHERE ID=?";
	}
	
	@Override
	protected PulseUser extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	PulseUser nextResult = new PulseUser();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setExternalID(rs.getString("externalID"));

nextResult.setUserId(rs.getString("userId"));

nextResult.setEmployeeId(rs.getString("employeeId"));

nextResult.setFirstName(rs.getString("firstName"));

nextResult.setFullName(rs.getString("fullName"));

nextResult.setLastName(rs.getString("lastName"));

nextResult.setPhotoUri(rs.getString("photoUri"));

TeamLeader teamleader = new TeamLeader();
teamleader.setID(rs.getString("teamleader_ID"));
nextResult.setTeamLeader(teamleader);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(PulseUser perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getExternalID());
pstmt.setString(3, perceroObject.getUserId());
pstmt.setString(4, perceroObject.getEmployeeId());
pstmt.setString(5, perceroObject.getFirstName());
pstmt.setString(6, perceroObject.getFullName());
pstmt.setString(7, perceroObject.getLastName());
pstmt.setString(8, perceroObject.getPhotoUri());

if (perceroObject.getTeamLeader() == null)
{
pstmt.setString(9, null);
}
else
{
		pstmt.setString(9, perceroObject.getTeamLeader().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(PulseUser perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getExternalID());
pstmt.setString(2, perceroObject.getUserId());
pstmt.setString(3, perceroObject.getEmployeeId());
pstmt.setString(4, perceroObject.getFirstName());
pstmt.setString(5, perceroObject.getFullName());
pstmt.setString(6, perceroObject.getLastName());
pstmt.setString(7, perceroObject.getPhotoUri());

if (perceroObject.getTeamLeader() == null)
{
pstmt.setString(8, null);
}
else
{
		pstmt.setString(8, perceroObject.getTeamLeader().getID());
}

pstmt.setString(9, perceroObject.getID());

		
	}

	@Override
	public List<PulseUser> findByExample(PulseUser theQueryObject,
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

boolean useUserId = StringUtils.hasText(theQueryObject.getUserId()) && (excludeProperties == null || !excludeProperties.contains("userId"));

if (useUserId)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " userId=? ";
paramValues.add(theQueryObject.getUserId());
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

boolean useLastName = StringUtils.hasText(theQueryObject.getLastName()) && (excludeProperties == null || !excludeProperties.contains("lastName"));

if (useLastName)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " lastName=? ";
paramValues.add(theQueryObject.getLastName());
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

