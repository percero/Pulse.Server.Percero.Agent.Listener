
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
		return "SELECT supervisor.ID FROM Supervisor supervisor WHERE supervisor.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT supervisor.ID,supervisor.lastName,supervisor.emailAddress,supervisor.externalID,supervisor.firstName,supervisor.employeeId,supervisor.photoUri,supervisor.managerSupervisor_ID FROM Supervisor supervisor WHERE supervisor.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT supervisor.ID FROM Supervisor supervisor ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT supervisor.ID FROM Supervisor supervisor ORDER BY supervisor.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT supervisor.ID,supervisor.lastName,supervisor.emailAddress,supervisor.externalID,supervisor.firstName,supervisor.employeeId,supervisor.photoUri,supervisor.managerSupervisor_ID FROM Supervisor supervisor ORDER BY supervisor.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT supervisor.ID,supervisor.lastName,supervisor.emailAddress,supervisor.externalID,supervisor.firstName,supervisor.employeeId,supervisor.photoUri,supervisor.managerSupervisor_ID FROM Supervisor supervisor ORDER BY supervisor.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM Supervisor supervisor";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT supervisor.ID,supervisor.lastName,supervisor.emailAddress,supervisor.externalID,supervisor.firstName,supervisor.employeeId,supervisor.photoUri,supervisor.managerSupervisor_ID FROM Supervisor supervisor WHERE supervisor.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT supervisor.ID FROM Supervisor supervisor WHERE supervisor.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT supervisor.ID,supervisor.lastName,supervisor.emailAddress,supervisor.externalID,supervisor.firstName,supervisor.employeeId,supervisor.photoUri,supervisor.managerSupervisor_ID FROM Supervisor supervisor WHERE supervisor." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT supervisor.ID FROM Supervisor supervisor WHERE supervisor." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT supervisor.ID FROM Supervisor supervisor ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT supervisor.ID,supervisor.lastName,supervisor.emailAddress,supervisor.externalID,supervisor.firstName,supervisor.employeeId,supervisor.photoUri,supervisor.managerSupervisor_ID FROM Supervisor supervisor ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO Supervisor (ID,lastName,emailAddress,externalID,firstName,employeeId,photoUri,managerSupervisor_ID) VALUES (?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE Supervisor SET lastName=?,emailAddress=?,externalID=?,firstName=?,employeeId=?,photoUri=?,managerSupervisor_ID=? WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM Supervisor WHERE ID=?";
	}
	
	@Override
	protected Supervisor extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	Supervisor nextResult = new Supervisor();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setLastName(rs.getString("lastName"));

nextResult.setEmailAddress(rs.getString("emailAddress"));

nextResult.setExternalID(rs.getString("externalID"));

nextResult.setFirstName(rs.getString("firstName"));

nextResult.setEmployeeId(rs.getString("employeeId"));

nextResult.setPhotoUri(rs.getString("photoUri"));

Supervisor supervisor = new Supervisor();
supervisor.setID(rs.getString("supervisor_ID"));
nextResult.setManagerSupervisor(supervisor);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(Supervisor perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getLastName());
pstmt.setString(3, perceroObject.getEmailAddress());
pstmt.setString(4, perceroObject.getExternalID());
pstmt.setString(5, perceroObject.getFirstName());
pstmt.setString(6, perceroObject.getEmployeeId());
pstmt.setString(7, perceroObject.getPhotoUri());

if (perceroObject.getManagerSupervisor() == null)
{
pstmt.setString(8, null);
}
else
{
		pstmt.setString(8, perceroObject.getManagerSupervisor().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(Supervisor perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getLastName());
pstmt.setString(2, perceroObject.getEmailAddress());
pstmt.setString(3, perceroObject.getExternalID());
pstmt.setString(4, perceroObject.getFirstName());
pstmt.setString(5, perceroObject.getEmployeeId());
pstmt.setString(6, perceroObject.getPhotoUri());

if (perceroObject.getManagerSupervisor() == null)
{
pstmt.setString(7, null);
}
else
{
		pstmt.setString(7, perceroObject.getManagerSupervisor().getID());
}

pstmt.setString(8, perceroObject.getID());

		
	}

	@Override
	public List<Supervisor> findByExample(Supervisor theQueryObject,
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
sql += " managerSupervisorID=? ";
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
