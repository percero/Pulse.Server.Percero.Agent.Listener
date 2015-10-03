

package com.pulse.mo.dao;

import com.percero.agents.sync.dao.DAORegistry;
import com.percero.agents.sync.dao.IDataAccessObject;
import com.percero.agents.sync.exceptions.SyncException;
import com.pulse.mo.PulseUser;
import com.pulse.mo.UserRole;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
import com.pulse.mo.UserRole;
import com.pulse.mo.PulseUser;

*/

@Component
public class UserRoleDAO extends SqlDataAccessObject<UserRole> implements IDataAccessObject<UserRole> {

	static final Logger log = Logger.getLogger(UserRoleDAO.class);


	public UserRoleDAO() {
		super();

		DAORegistry.getInstance().registerDataAccessObject(UserRole.class.getCanonicalName(), this);
	}


	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	@Override
	protected String getConnectionFactoryName() {
		return UserRoleDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT userrole.\"ID\" FROM \"UserRole\" userrole WHERE userrole.\"ID\"=?";
	}

	@Override
	protected String getSelectStarSQL() {
		return "SELECT userrole.\"ID\",userrole.\"RoleName\",userrole.\"PulseUserID\" FROM \"UserRole\" userrole WHERE userrole.\"ID\"=?";
	}

	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT userrole.\"ID\" FROM \"UserRole\" userrole ORDER BY ID";
	}

	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT userrole.\"ID\" FROM \"UserRole\" userrole ORDER BY userrole.\"ID\" LIMIT ? OFFSET ?";
	}

	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT userrole.\"ID\",userrole.\"RoleName\",userrole.\"PulseUserID\" FROM \"UserRole\" userrole ORDER BY userrole.\"ID\"";
	}

	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT userrole.\"ID\",userrole.\"RoleName\",userrole.\"PulseUserID\" FROM \"UserRole\" userrole ORDER BY userrole.\"ID\" LIMIT ? OFFSET ?";
	}

	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM \"UserRole\" userrole";
	}

	@Override
	protected String getSelectInStarSQL() {
		return "SELECT userrole.\"ID\",userrole.\"RoleName\",userrole.\"PulseUserID\" FROM \"UserRole\" userrole WHERE userrole.\"ID\" IN (?)";
	}

	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT userrole.\"ID\" FROM \"UserRole\" userrole WHERE userrole.\"ID\" IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT userrole.\"ID\",userrole.\"RoleName\",userrole.\"PulseUserID\" FROM \"UserRole\" userrole WHERE userrole." + joinColumnName + "=?";
	}

	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT userrole.\"ID\" FROM \"UserRole\" userrole WHERE userrole." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT userrole.\"ID\" FROM \"UserRole\" userrole ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT userrole.\"ID\",userrole.\"RoleName\",userrole.\"PulseUserID\" FROM \"UserRole\" userrole ";
	}

	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO \"UserRole\" (ID,\"RoleName\",\"PulseUserID\") VALUES (?,?,?)";
	}

	@Override
	protected String getUpdateSet() {
		return "UPDATE \"UserRole\" SET \"RoleName\"=?,\"PulseUserID\"=? WHERE ID=?";
	}

	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM \"UserRole\" WHERE ID=?";
	}

	@Override
	protected UserRole extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
		UserRole nextResult = new UserRole();

		// ID
		nextResult.setID(rs.getString("ID"));

		if (!shellOnly)
		{
			nextResult.setRoleName(rs.getString("RoleName"));

			PulseUser pulseuser = new PulseUser();
			pulseuser.setID(rs.getString("PulseUserID"));
			nextResult.setPulseUser(pulseuser);
		}

		return nextResult;
	}

	@Override
	protected void setPreparedStatmentInsertParams(UserRole perceroObject, PreparedStatement pstmt) throws SQLException {

		pstmt.setString(1, perceroObject.getID());
		pstmt.setString(2, perceroObject.getRoleName());

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
	protected void setPreparedStatmentUpdateParams(UserRole perceroObject, PreparedStatement pstmt) throws SQLException {
		pstmt.setString(1, perceroObject.getRoleName());
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
	public List<UserRole> findByExample(UserRole theQueryObject,
										List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException
	{



		String sql = getFindByExampleSelectSql(shellOnly);

		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();

		boolean useRoleName = StringUtils.hasText(theQueryObject.getRoleName()) && (excludeProperties == null || !excludeProperties.contains("\"RoleName\""));

		if (useRoleName)
		{
			if (propertyCounter > 0)
			{
				sql += " AND ";
			}
			else
			{
				sql += " WHERE ";
			}
			sql += " \"RoleName\"=? ";
			paramValues.add(theQueryObject.getRoleName());
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
			sql += " \"PulseUserID\"=? ";
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

