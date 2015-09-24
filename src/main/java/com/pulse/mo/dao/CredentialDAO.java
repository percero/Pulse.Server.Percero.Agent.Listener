
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
import com.pulse.mo.Credential;
import com.pulse.mo.PulseUser;

*/

@Component
public class CredentialDAO extends SqlDataAccessObject<Credential> implements IDataAccessObject<Credential> {

	static final Logger log = Logger.getLogger(CredentialDAO.class);

	
	public CredentialDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(Credential.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	@Override
	protected String getConnectionFactoryName() {
		return CredentialDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT credential.ID FROM Credential credential WHERE credential.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT credential.ID,credential.externalID,credential.username,credential.password,credential.pulseUser_ID FROM Credential credential WHERE credential.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT credential.ID FROM Credential credential ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT credential.ID FROM Credential credential ORDER BY credential.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT credential.ID,credential.externalID,credential.username,credential.password,credential.pulseUser_ID FROM Credential credential ORDER BY credential.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT credential.ID,credential.externalID,credential.username,credential.password,credential.pulseUser_ID FROM Credential credential ORDER BY credential.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM Credential credential";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT credential.ID,credential.externalID,credential.username,credential.password,credential.pulseUser_ID FROM Credential credential WHERE credential.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT credential.ID FROM Credential credential WHERE credential.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT credential.ID,credential.externalID,credential.username,credential.password,credential.pulseUser_ID FROM Credential credential WHERE credential." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT credential.ID FROM Credential credential WHERE credential." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT credential.ID FROM Credential credential ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT credential.ID,credential.externalID,credential.username,credential.password,credential.pulseUser_ID FROM Credential credential ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO Credential (ID,externalID,username,password,pulseUser_ID) VALUES (?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE Credential SET externalID=?,username=?,password=?,pulseUser_ID=? WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM Credential WHERE ID=?";
	}
	
	@Override
	protected Credential extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	Credential nextResult = new Credential();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setExternalID(rs.getString("externalID"));

nextResult.setUsername(rs.getString("username"));

nextResult.setPassword(rs.getString("password"));

PulseUser pulseuser = new PulseUser();
pulseuser.setID(rs.getString("pulseuser_ID"));
nextResult.setPulseUser(pulseuser);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(Credential perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getExternalID());
pstmt.setString(3, perceroObject.getUsername());
pstmt.setString(4, perceroObject.getPassword());

if (perceroObject.getPulseUser() == null)
{
pstmt.setString(5, null);
}
else
{
		pstmt.setString(5, perceroObject.getPulseUser().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(Credential perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getExternalID());
pstmt.setString(2, perceroObject.getUsername());
pstmt.setString(3, perceroObject.getPassword());

if (perceroObject.getPulseUser() == null)
{
pstmt.setString(4, null);
}
else
{
		pstmt.setString(4, perceroObject.getPulseUser().getID());
}

pstmt.setString(5, perceroObject.getID());

		
	}

	@Override
	public List<Credential> findByExample(Credential theQueryObject,
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

boolean useUsername = StringUtils.hasText(theQueryObject.getUsername()) && (excludeProperties == null || !excludeProperties.contains("username"));

if (useUsername)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " username=? ";
paramValues.add(theQueryObject.getUsername());
propertyCounter++;
}

boolean usePassword = StringUtils.hasText(theQueryObject.getPassword()) && (excludeProperties == null || !excludeProperties.contains("password"));

if (usePassword)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " password=? ";
paramValues.add(theQueryObject.getPassword());
propertyCounter++;
}

boolean usePulseUserID = theQueryObject.getPulseUser() != null && (excludeProperties == null || !excludeProperties.contains("pulseUser"));

if (usePulseUserID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " pulseUserID=? ";
paramValues.add(theQueryObject.getPulseUser().getID());
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
