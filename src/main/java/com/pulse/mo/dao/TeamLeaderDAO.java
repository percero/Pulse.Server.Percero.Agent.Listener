

package com.pulse.mo.dao;

import com.percero.agents.sync.dao.DAORegistry;
import com.percero.agents.sync.dao.IDataAccessObject;
import com.percero.agents.sync.exceptions.SyncException;
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
import com.pulse.mo.TeamLeader;
import com.pulse.mo.Notification;
import com.pulse.mo.Agent;
import com.pulse.mo.Alert;
import com.pulse.mo.AdhocCoachingSession;
import com.pulse.mo.AdhocTask;
import com.pulse.mo.AppAction;
import com.pulse.mo.DevelopmentActivity;
import com.pulse.mo.GeneralComment;
import com.pulse.mo.TeamLeaderImpersonation;
import com.pulse.mo.Setting;
import com.pulse.mo.TeamLeaderAction;
import com.pulse.mo.UserSession;
import com.pulse.mo.Supervisor;

*/

@Component
public class TeamLeaderDAO extends SqlDataAccessObject<TeamLeader> implements IDataAccessObject<TeamLeader> {

	static final Logger log = Logger.getLogger(TeamLeaderDAO.class);


	public TeamLeaderDAO() {
		super();

		DAORegistry.getInstance().registerDataAccessObject(TeamLeader.class.getCanonicalName(), this);
	}


	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	@Override
	protected String getConnectionFactoryName() {
		return TeamLeaderDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT teamleader.\"ID\" FROM \"TeamLeader\" teamleader WHERE teamleader.\"ID\"=?";
	}

	@Override
	protected String getSelectStarSQL() {
		return "SELECT teamleader.\"ID\",teamleader.\"LastName\",teamleader.\"FirstName\",teamleader.\"EmployeeId\" FROM \"TeamLeader\" teamleader WHERE teamleader.\"ID\"=?";
	}

	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT teamleader.\"ID\" FROM \"TeamLeader\" teamleader ORDER BY ID";
	}

	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT teamleader.\"ID\" FROM \"TeamLeader\" teamleader ORDER BY teamleader.\"ID\" LIMIT ? OFFSET ?";
	}

	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT teamleader.\"ID\",teamleader.\"LastName\",teamleader.\"FirstName\",teamleader.\"EmployeeId\" FROM \"TeamLeader\" teamleader ORDER BY teamleader.\"ID\"";
	}

	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT teamleader.\"ID\",teamleader.\"LastName\",teamleader.\"FirstName\",teamleader.\"EmployeeId\" FROM \"TeamLeader\" teamleader ORDER BY teamleader.\"ID\" LIMIT ? OFFSET ?";
	}

	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM \"TeamLeader\" teamleader";
	}

	@Override
	protected String getSelectInStarSQL() {
		return "SELECT teamleader.\"ID\",teamleader.\"LastName\",teamleader.\"FirstName\",teamleader.\"EmployeeId\" FROM \"TeamLeader\" teamleader WHERE teamleader.\"ID\" IN (?)";
	}

	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT teamleader.\"ID\" FROM \"TeamLeader\" teamleader WHERE teamleader.\"ID\" IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT teamleader.\"ID\",teamleader.\"LastName\",teamleader.\"FirstName\",teamleader.\"EmployeeId\" FROM \"TeamLeader\" teamleader WHERE teamleader." + joinColumnName + "=?";
	}

	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT teamleader.\"ID\" FROM \"TeamLeader\" teamleader WHERE teamleader." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT teamleader.\"ID\" FROM \"TeamLeader\" teamleader ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
//		return "SELECT teamleader.\"ID\",teamleader.\"LastName\",teamleader.\"FirstName\",teamleader.\"EmployeeId\" FROM \"TeamLeader\" teamleader ";
		return "SELECT teamleader.\"LastName\", teamleader.\"FirstName\",teamleader.\"EmployeeId\" FROM \"TeamLeader\" teamleader ";
	}

	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO \"TeamLeader\" (\"ID\",\"LastName\",\"FirstName\",\"EmployeeId\") VALUES (?,?,?,?)";
	}

	@Override
	protected String getUpdateSet() {
		return "UPDATE \"TeamLeader\" SET \"LastName\"=?,\"FirstName\"=?,\"EmployeeId\"=? WHERE ID=?";
	}

	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM \"TeamLeader\" WHERE ID=?";
	}

	@Override
	protected TeamLeader extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
		TeamLeader nextResult = new TeamLeader();

		// ID
//		nextResult.setID(rs.getString("ID"));

		if (!shellOnly)
		{
			nextResult.setLastName(rs.getString("lastName"));

			nextResult.setFirstName(rs.getString("firstName"));

			nextResult.setEmployeeId(rs.getString("employeeId"));
		}

		return nextResult;
	}

	@Override
	protected void setPreparedStatmentInsertParams(TeamLeader perceroObject, PreparedStatement pstmt) throws SQLException {

		pstmt.setString(1, perceroObject.getID());
		pstmt.setString(2, perceroObject.getLastName());
		pstmt.setString(3, perceroObject.getFirstName());
		pstmt.setString(4, perceroObject.getEmployeeId());

	}

	@Override
	protected void setPreparedStatmentUpdateParams(TeamLeader perceroObject, PreparedStatement pstmt) throws SQLException {

		pstmt.setString(1, perceroObject.getLastName());
		pstmt.setString(2, perceroObject.getFirstName());
		pstmt.setString(3, perceroObject.getEmployeeId());
		pstmt.setString(4, perceroObject.getID());
	}

	@Override
	public List<TeamLeader> findByExample(TeamLeader theQueryObject,
										  List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException
	{



		String sql = getFindByExampleSelectSql(shellOnly);

		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();

		boolean useLastName = StringUtils.hasText(theQueryObject.getLastName()) && (excludeProperties == null || !excludeProperties.contains("lastName"));

		if (useLastName)
		{
			sql += " WHERE ";
			sql += " \"LastName\"=? ";
			paramValues.add(theQueryObject.getLastName());
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
			sql += " \"FirstName\"=? ";
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
			sql += " teamleader.\"EmployeeId\"=? ";
			paramValues.add(theQueryObject.getEmployeeId());
			propertyCounter++;
		}

		return executeSelectWithParams(sql, paramValues.toArray(), shellOnly);
	}

}

