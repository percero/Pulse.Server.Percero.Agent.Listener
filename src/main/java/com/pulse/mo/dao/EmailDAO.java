
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
import com.pulse.mo.Email;
import com.pulse.mo.PulseUser;

*/

@Component
public class EmailDAO extends SqlDataAccessObject<Email> implements IDataAccessObject<Email> {

	static final Logger log = Logger.getLogger(EmailDAO.class);

	
	public EmailDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(Email.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	@Override
	protected String getConnectionFactoryName() {
		return EmailDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT email.ID FROM Email email WHERE email.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT email.ID,email.emailAddress,email.externalID,email.pulseUser_ID FROM Email email WHERE email.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT email.ID FROM Email email ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT email.ID FROM Email email ORDER BY email.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT email.ID,email.emailAddress,email.externalID,email.pulseUser_ID FROM Email email ORDER BY email.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT email.ID,email.emailAddress,email.externalID,email.pulseUser_ID FROM Email email ORDER BY email.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM Email email";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT email.ID,email.emailAddress,email.externalID,email.pulseUser_ID FROM Email email WHERE email.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT email.ID FROM Email email WHERE email.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT email.ID,email.emailAddress,email.externalID,email.pulseUser_ID FROM Email email WHERE email." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT email.ID FROM Email email WHERE email." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT email.ID FROM Email email ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT email.ID,email.emailAddress,email.externalID,email.pulseUser_ID FROM Email email ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO Email (ID,emailAddress,externalID,pulseUser_ID) VALUES (?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE Email SET emailAddress=?,externalID=?,pulseUser_ID=? WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM Email WHERE ID=?";
	}
	
	@Override
	protected Email extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	Email nextResult = new Email();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setEmailAddress(rs.getString("emailAddress"));

nextResult.setExternalID(rs.getString("externalID"));

PulseUser pulseuser = new PulseUser();
pulseuser.setID(rs.getString("pulseuser_ID"));
nextResult.setPulseUser(pulseuser);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(Email perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getEmailAddress());
pstmt.setString(3, perceroObject.getExternalID());

if (perceroObject.getPulseUser() == null)
{
pstmt.setString(4, null);
}
else
{
		pstmt.setString(4, perceroObject.getPulseUser().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(Email perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getEmailAddress());
pstmt.setString(2, perceroObject.getExternalID());

if (perceroObject.getPulseUser() == null)
{
pstmt.setString(3, null);
}
else
{
		pstmt.setString(3, perceroObject.getPulseUser().getID());
}

pstmt.setString(4, perceroObject.getID());

		
	}

	@Override
	public List<Email> findByExample(Email theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useEmailAddress = StringUtils.hasText(theQueryObject.getEmailAddress()) && (excludeProperties == null || !excludeProperties.contains("emailAddress"));

if (useEmailAddress)
{
sql += " WHERE ";
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
