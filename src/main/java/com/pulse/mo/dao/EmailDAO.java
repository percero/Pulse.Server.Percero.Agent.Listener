

package com.pulse.mo.dao;

import com.percero.agents.sync.dao.DAORegistry;
import com.percero.agents.sync.dao.IDataAccessObject;
import com.percero.agents.sync.exceptions.SyncException;
import com.pulse.mo.Email;
import com.pulse.mo.PulseUser;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
		return "SELECT \"EMAIL\".\"ID\" FROM \"EMAIL\" \"EMAIL\" WHERE \"EMAIL\".\"ID\"=?";
	}

	@Override
	protected String getSelectStarSQL() {
		return "SELECT \"EMAIL\".\"ID\",\"EMAIL\".\"EMAIL_ADDRESS\",\"EMAIL\".\"PULSE_USER_ID\" FROM \"EMAIL\" \"EMAIL\" WHERE \"EMAIL\".\"ID\"=?";
	}

	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT \"EMAIL\".\"ID\" FROM \"EMAIL\" \"EMAIL\" ORDER BY \"ID\"";
	}

	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT \"EMAIL\".\"ID\" FROM \"EMAIL\" \"EMAIL\" ORDER BY \"EMAIL\".\"ID\" LIMIT ? OFFSET ?";
	}

	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT \"EMAIL\".\"ID\",\"EMAIL\".\"EMAIL_ADDRESS\",\"EMAIL\".\"PULSE_USER_ID\" FROM \"EMAIL\" \"EMAIL\" ORDER BY \"EMAIL\".\"ID\"";
	}

	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT \"EMAIL\".\"ID\",\"EMAIL\".\"EMAIL_ADDRESS\",\"EMAIL\".\"PULSE_USER_ID\" FROM \"EMAIL\" \"EMAIL\" ORDER BY \"EMAIL\".\"ID\" LIMIT ? OFFSET ?";
	}

	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM \"EMAIL\" \"EMAIL\"";
	}

	@Override
	protected String getSelectInStarSQL() {
		return "SELECT \"EMAIL\".\"ID\",\"EMAIL\".\"EMAIL_ADDRESS\",\"EMAIL\".\"PULSE_USER_ID\" FROM \"EMAIL\" \"EMAIL\" WHERE \"EMAIL\".\"ID\" IN (?)";
	}

	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT \"EMAIL\".\"ID\" FROM \"EMAIL\" \"EMAIL\" WHERE \"EMAIL\".\"ID\" IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName)
	{
		return "SELECT \"EMAIL\".\"ID\",\"EMAIL\".\"EMAIL_ADDRESS\",\"EMAIL\".\"PULSE_USER_ID\" FROM \"EMAIL\" \"EMAIL\" WHERE \"EMAIL\"." + joinColumnName + "=?";
	}

	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT \"EMAIL\".\"ID\" FROM \"EMAIL\" \"EMAIL\" WHERE \"EMAIL\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT \"EMAIL\".\"ID\" FROM \"EMAIL\" \"EMAIL\" ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT \"EMAIL\".\"ID\",\"EMAIL\".\"EMAIL_ADDRESS\",\"EMAIL\".\"PULSE_USER_ID\" FROM \"EMAIL\" \"EMAIL\" ";
	}

	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO EMAIL (\"ID\",\"EMAIL_ADDRESS\",\"PULSE_USER_ID\") VALUES (?,?,?)";
	}

	@Override
	protected String getUpdateSet() {
		return "UPDATE \"EMAIL\" SET \"EMAIL_ADDRESS\"=?,\"PULSE_USER_ID\"=? WHERE \"ID\"=?";
	}

	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM \"EMAIL\" WHERE \"ID\"=?";
	}

	@Override
	protected Email extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
		Email nextResult = new Email();

		// ID
		nextResult.setID(rs.getString("ID"));

		if (!shellOnly)
		{
			nextResult.setEmailAddress(rs.getString("EMAIL_ADDRESS"));

			PulseUser pulseuser = new PulseUser();
			pulseuser.setID(rs.getString("PULSE_USER_ID"));
			nextResult.setPulseUser(pulseuser);



		}

		return nextResult;
	}

	@Override
	protected void setPreparedStatmentInsertParams(Email perceroObject, PreparedStatement pstmt) throws SQLException {

		pstmt.setString(1, perceroObject.getID());
		pstmt.setString(2, perceroObject.getEmailAddress());

		if (perceroObject.getPulseUser() == null)
		{
			pstmt.setString(3, null);
		}
		else
		{
			pstmt.setString(3, perceroObject.getPulseUser().getID());
		}



	}

	@Override
	protected void setPreparedStatmentUpdateParams(Email perceroObject, PreparedStatement pstmt) throws SQLException {

		pstmt.setString(1, perceroObject.getEmailAddress());

		if (perceroObject.getPulseUser() == null)
		{
			pstmt.setString(2, null);
		}
		else
		{
			pstmt.setString(2, perceroObject.getPulseUser().getID());
		}

		pstmt.setString(3, perceroObject.getID());


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
			sql += " \"EMAIL_ADDRESS\" =? ";
			paramValues.add(theQueryObject.getEmailAddress());
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
			sql += " \"PULSE_USER_ID\" =? ";
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

