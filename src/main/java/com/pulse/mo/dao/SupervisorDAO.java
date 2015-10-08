
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
import com.pulse.mo.Supervisor;
import com.pulse.mo.TeamLeader;
import com.pulse.mo.Supervisor;

*/

@Component
public class SupervisorDAO extends SqlDataAccessObject<Supervisor> implements IDataAccessObject<Supervisor> {

	static final Logger log = Logger.getLogger(SupervisorDAO.class);

	
	public SupervisorDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(Supervisor.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	@Override
	protected String getConnectionFactoryName() {
		return SupervisorDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT SUPERVISOR.ID FROM SUPERVISOR SUPERVISOR WHERE SUPERVISOR.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT SUPERVISOR.ID,SUPERVISOR.EMAIL_ADDRESS,SUPERVISOR.FIRST_NAME,SUPERVISOR.LAST_NAME,SUPERVISOR.FULL_NAME,SUPERVISOR.PHOTO_URI,SUPERVISOR.MANAGER_SUPERVISOR_ID FROM SUPERVISOR SUPERVISOR WHERE SUPERVISOR.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT SUPERVISOR.ID FROM SUPERVISOR SUPERVISOR ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT SUPERVISOR.ID FROM SUPERVISOR SUPERVISOR ORDER BY SUPERVISOR.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT SUPERVISOR.ID,SUPERVISOR.EMAIL_ADDRESS,SUPERVISOR.FIRST_NAME,SUPERVISOR.LAST_NAME,SUPERVISOR.FULL_NAME,SUPERVISOR.PHOTO_URI,SUPERVISOR.MANAGER_SUPERVISOR_ID FROM SUPERVISOR SUPERVISOR ORDER BY SUPERVISOR.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT SUPERVISOR.ID,SUPERVISOR.EMAIL_ADDRESS,SUPERVISOR.FIRST_NAME,SUPERVISOR.LAST_NAME,SUPERVISOR.FULL_NAME,SUPERVISOR.PHOTO_URI,SUPERVISOR.MANAGER_SUPERVISOR_ID FROM SUPERVISOR SUPERVISOR ORDER BY SUPERVISOR.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM SUPERVISOR SUPERVISOR";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT SUPERVISOR.ID,SUPERVISOR.EMAIL_ADDRESS,SUPERVISOR.FIRST_NAME,SUPERVISOR.LAST_NAME,SUPERVISOR.FULL_NAME,SUPERVISOR.PHOTO_URI,SUPERVISOR.MANAGER_SUPERVISOR_ID FROM SUPERVISOR SUPERVISOR WHERE SUPERVISOR.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT SUPERVISOR.ID FROM SUPERVISOR SUPERVISOR WHERE SUPERVISOR.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT SUPERVISOR.ID,SUPERVISOR.EMAIL_ADDRESS,SUPERVISOR.FIRST_NAME,SUPERVISOR.LAST_NAME,SUPERVISOR.FULL_NAME,SUPERVISOR.PHOTO_URI,SUPERVISOR.MANAGER_SUPERVISOR_ID FROM SUPERVISOR SUPERVISOR WHERE SUPERVISOR." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT SUPERVISOR.ID FROM SUPERVISOR SUPERVISOR WHERE SUPERVISOR." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT SUPERVISOR.ID FROM SUPERVISOR SUPERVISOR ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT SUPERVISOR.ID,SUPERVISOR.EMAIL_ADDRESS,SUPERVISOR.FIRST_NAME,SUPERVISOR.LAST_NAME,SUPERVISOR.FULL_NAME,SUPERVISOR.PHOTO_URI,SUPERVISOR.MANAGER_SUPERVISOR_ID FROM SUPERVISOR SUPERVISOR ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO SUPERVISOR (ID,EMAIL_ADDRESS,FIRST_NAME,LAST_NAME,FULL_NAME,PHOTO_URI,MANAGER_SUPERVISOR_ID) VALUES (?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE SUPERVISOR SET EMAIL_ADDRESS=?,FIRST_NAME=?,LAST_NAME=?,FULL_NAME=?,PHOTO_URI=?,MANAGER_SUPERVISOR_ID WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM SUPERVISOR WHERE ID=?";
	}
	
	@Override
	protected Supervisor extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	Supervisor nextResult = new Supervisor();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setEmailAddress(rs.getString("EMAIL_ADDRESS"));

nextResult.setFirstName(rs.getString("FIRST_NAME"));

nextResult.setLastName(rs.getString("LAST_NAME"));

nextResult.setFullName(rs.getString("FULL_NAME"));

nextResult.setPhotoUri(rs.getString("PHOTO_URI"));

Supervisor supervisor = new Supervisor();
supervisor.setID(rs.getString("MANAGER_SUPERVISOR_ID"));
nextResult.setManagerSupervisor(supervisor);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(Supervisor perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getEmailAddress());
pstmt.setString(3, perceroObject.getFirstName());
pstmt.setString(4, perceroObject.getLastName());
pstmt.setString(5, perceroObject.getFullName());
pstmt.setString(6, perceroObject.getPhotoUri());

if (perceroObject.getManagerSupervisor() == null)
{
pstmt.setString(7, null);
}
else
{
		pstmt.setString(7, perceroObject.getManagerSupervisor().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(Supervisor perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getEmailAddress());
pstmt.setString(2, perceroObject.getFirstName());
pstmt.setString(3, perceroObject.getLastName());
pstmt.setString(4, perceroObject.getFullName());
pstmt.setString(5, perceroObject.getPhotoUri());

if (perceroObject.getManagerSupervisor() == null)
{
pstmt.setString(6, null);
}
else
{
		pstmt.setString(6, perceroObject.getManagerSupervisor().getID());
}

pstmt.setString(7, perceroObject.getID());

		
	}

	@Override
	public List<Supervisor> findByExample(Supervisor theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useEmailAddress = StringUtils.hasText(theQueryObject.getEmailAddress()) && (excludeProperties == null || !excludeProperties.contains("emailAddress"));

if (useEmailAddress)
{
sql += " WHERE ";
sql += " EMAIL_ADDRESS=? ";
paramValues.add(theQueryObject.getEmailAddress());
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
sql += " FIRST_NAME=? ";
paramValues.add(theQueryObject.getFirstName());
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
sql += " LAST_NAME=? ";
paramValues.add(theQueryObject.getLastName());
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
sql += " FULL_NAME=? ";
paramValues.add(theQueryObject.getFullName());
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
sql += " PHOTO_URI=? ";
paramValues.add(theQueryObject.getPhotoUri());
propertyCounter++;
}

boolean useManagerSupervisorID = theQueryObject.getManagerSupervisor() != null && (excludeProperties == null || !excludeProperties.contains("managerSupervisor"));

if (useManagerSupervisorID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " MANAGER_SUPERVISOR_ID=? ";
paramValues.add(theQueryObject.getManagerSupervisor().getID());
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
