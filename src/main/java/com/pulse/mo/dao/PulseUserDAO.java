

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
		return "SELECT pulseuser.\"ID\" FROM \"PulseUser\" pulseuser WHERE pulseuser.\"ID\"=?";
	}

	@Override
	protected String getSelectStarSQL() {
		return "SELECT pulseuser.\"ID\",pulseuser.\"userId\",pulseuser.\"EmployeeId\",pulseuser.\"TeamLeaderID\" FROM \"PulseUser\" pulseuser WHERE pulseuser.\"ID\"=?";
	}

	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT pulseuser.\"ID\" FROM \"PulseUser\" pulseuser ORDER BY \"ID\"";
	}

	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT pulseuser.\"ID\" FROM \"PulseUser\" pulseuser ORDER BY pulseuser.\"ID\" LIMIT ? OFFSET ?";
	}

	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT pulseuser.\"ID\",pulseuser.\"userId\",pulseuser.\"EmployeeId\",pulseuser.\"TeamLeaderID\" FROM \"PulseUser\" pulseuser ORDER BY pulseuser.\"ID\"";
	}

	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT pulseuser.\"ID\",pulseuser.\"userId\",pulseuser.\"EmployeeId\",pulseuser.\"TeamLeaderID\" FROM \"PulseUser\" pulseuser ORDER BY pulseuser.\"ID\" LIMIT ? OFFSET ?";
	}

	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(\"ID\") FROM \"PulseUser\" pulseuser";
	}

	@Override
	protected String getSelectInStarSQL() {
		return "SELECT pulseuser.\"ID\",pulseuser.\"userId\",pulseuser.\"EmployeeId\",pulseuser.\"TeamLeaderID\" FROM \"PulseUser\" pulseuser WHERE pulseuser.\"ID\" IN (?)";
	}

	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT pulseuser.\"ID\" FROM \"PulseUser\" pulseuser WHERE pulseuser.\"ID\" IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT pulseuser.\"ID\",pulseuser.\"userId\",pulseuser.\"EmployeeId\",pulseuser.\"TeamLeaderID\" FROM \"PulseUser\" pulseuser WHERE pulseuser." + joinColumnName + "=?";
	}

	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT pulseuser.\"ID\" FROM \"PulseUser\" pulseuser WHERE pulseuser." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT pulseuser.\"ID\" FROM \"PulseUser\" pulseuser ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT pulseuser.\"ID\",pulseuser.\"userId\",pulseuser.\"EmployeeId\",pulseuser.\"TeamLeaderID\" FROM \"PulseUser\" pulseuser ";
	}

	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO \"PulseUser\" (\"ID\", \"userId\",\"EmployeeId\",\"TeamLeaderID\") VALUES (?,?,?,?)";
	}

	@Override
	protected String getUpdateSet() {
		return "UPDATE \"PulseUser\" SET \"userId\"=?,\"EmployeeId\"=?,\"TeamLeaderID\"=? WHERE ID=?";
	}

	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM \"PulseUser\" WHERE \"ID\"=?";
	}

	@Override
	protected PulseUser extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
		PulseUser nextResult = new PulseUser();

		// ID
		nextResult.setID(rs.getString("ID"));

		if (!shellOnly)
		{
//			nextResult.setExternalID(rs.getString("externalID"));

			nextResult.setUserId(rs.getString("userId"));

			nextResult.setEmployeeId(rs.getString("EmployeeId"));

//			nextResult.setFirstName(rs.getString("firstName"));

//			nextResult.setFullName(rs.getString("fullName"));

//			nextResult.setLastName(rs.getString("lastName"));

//			nextResult.setPhotoUri(rs.getString("photoUri"));

			TeamLeader teamleader = new TeamLeader();
			teamleader.setID(rs.getString("TeamleaderID"));
			nextResult.setTeamLeader(teamleader);



		}

		return nextResult;
	}

	@Override
	protected void setPreparedStatmentInsertParams(PulseUser perceroObject, PreparedStatement pstmt) throws SQLException {

		pstmt.setString(1, perceroObject.getID());
//		pstmt.setString(2, perceroObject.getExternalID());
		pstmt.setString(2, perceroObject.getUserId());
		pstmt.setString(3, perceroObject.getEmployeeId());
//		pstmt.setString(5, perceroObject.getFirstName());
//		pstmt.setString(6, perceroObject.getFullName());
//		pstmt.setString(7, perceroObject.getLastName());
//		pstmt.setString(8, perceroObject.getPhotoUri());

		if (perceroObject.getTeamLeader() == null)
		{
			pstmt.setString(4, null);
		}
		else
		{
			pstmt.setString(4, perceroObject.getTeamLeader().getID());
		}



	}

	@Override
	protected void setPreparedStatmentUpdateParams(PulseUser perceroObject, PreparedStatement pstmt) throws SQLException {

//		pstmt.setString(1, perceroObject.getExternalID());
		pstmt.setString(1, perceroObject.getUserId());
		pstmt.setString(2, perceroObject.getEmployeeId());
//		pstmt.setString(4, perceroObject.getFirstName());
//		pstmt.setString(5, perceroObject.getFullName());
//		pstmt.setString(6, perceroObject.getLastName());
//		pstmt.setString(7, perceroObject.getPhotoUri());

		if (perceroObject.getTeamLeader() == null)
		{
			pstmt.setString(3, null);
		}
		else
		{
			pstmt.setString(3, perceroObject.getTeamLeader().getID());
		}

		pstmt.setString(4, perceroObject.getID());


	}

	@Override
	public List<PulseUser> findByExample(PulseUser theQueryObject,
										 List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException
	{



		String sql = getFindByExampleSelectSql(shellOnly);

		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();

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
			sql += " \"userId\"=? ";
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
			sql += " \"EmployeeId\"=? ";
			paramValues.add(theQueryObject.getEmployeeId());
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
			sql += " \"TeamLeaderID\"=? ";
			paramValues.add(theQueryObject.getTeamLeader().getID());
			propertyCounter++;
		}

		return executeSelectWithParams(sql, paramValues.toArray(), shellOnly);
	}

}

