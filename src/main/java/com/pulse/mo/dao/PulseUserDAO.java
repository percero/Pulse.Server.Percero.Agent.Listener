

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
import com.pulse.mo.Email;
import com.pulse.mo.TraceEntry;
import com.pulse.mo.TeamLeaderImpersonation;
import com.pulse.mo.UserSession;
import com.pulse.mo.UserRole;
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
		return "SELECT PULSE_USER.ID FROM PULSE_USER PULSE_USER WHERE PULSE_USER.ID=?";
	}

	@Override
	protected String getSelectStarSQL() {
		return "SELECT PULSE_USER.ID,PULSE_USER.USER_ID,PULSE_USER.EMPLOYEE_ID,PULSE_USER.FIRST_NAME,PULSE_USER.LAST_NAME,PULSE_USER.TEAM_LEADER_ID FROM PULSE_USER PULSE_USER WHERE PULSE_USER.ID=?";
	}

	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT PULSE_USER.ID FROM PULSE_USER PULSE_USER ORDER BY ID";
	}

	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT PULSE_USER.ID FROM PULSE_USER PULSE_USER ORDER BY PULSE_USER.ID LIMIT ? OFFSET ?";
	}

	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT PULSE_USER.ID,PULSE_USER.USER_ID,PULSE_USER.EMPLOYEE_ID,PULSE_USER.FIRST_NAME,PULSE_USER.LAST_NAME,PULSE_USER.TEAM_LEADER_ID FROM PULSE_USER PULSE_USER ORDER BY PULSE_USER.ID";
	}

	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT PULSE_USER.ID,PULSE_USER.USER_ID,PULSE_USER.EMPLOYEE_ID,PULSE_USER.FIRST_NAME,PULSE_USER.LAST_NAME,PULSE_USER.TEAM_LEADER_ID FROM PULSE_USER PULSE_USER ORDER BY PULSE_USER.ID LIMIT ? OFFSET ?";
	}

	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM PULSE_USER PULSE_USER";
	}

	@Override
	protected String getSelectInStarSQL() {
		return "SELECT PULSE_USER.ID,PULSE_USER.USER_ID,PULSE_USER.EMPLOYEE_ID,PULSE_USER.FIRST_NAME,PULSE_USER.LAST_NAME,PULSE_USER.TEAM_LEADER_ID FROM PULSE_USER PULSE_USER WHERE PULSE_USER.ID IN (?)";
	}

	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT PULSE_USER.ID FROM PULSE_USER PULSE_USER WHERE PULSE_USER.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT PULSE_USER.ID,PULSE_USER.USER_ID,PULSE_USER.EMPLOYEE_ID,PULSE_USER.FIRST_NAME,PULSE_USER.LAST_NAME,PULSE_USER.TEAM_LEADER_ID FROM PULSE_USER PULSE_USER WHERE PULSE_USER." + joinColumnName + "=?";
	}

	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT PULSE_USER.ID FROM PULSE_USER PULSE_USER WHERE PULSE_USER." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT PULSE_USER.ID FROM PULSE_USER PULSE_USER ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT PULSE_USER.ID,PULSE_USER.USER_ID,PULSE_USER.EMPLOYEE_ID,PULSE_USER.FIRST_NAME,PULSE_USER.LAST_NAME,PULSE_USER.TEAM_LEADER_ID FROM PULSE_USER PULSE_USER ";
	}

	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO PULSE_USER (ID,USER_ID,EMPLOYEE_ID,FIRST_NAME,LAST_NAME,TEAM_LEADER_ID) VALUES (?,?,?,?,?,?)";
	}

	@Override
	protected String getUpdateSet() {
		return "UPDATE PULSE_USER SET USER_ID=?,EMPLOYEE_ID=?,FIRST_NAME=?,LAST_NAME=?,TEAM_LEADER_ID=? WHERE ID=?";
	}

	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM PULSE_USER WHERE ID=?";
	}

	@Override
	protected PulseUser extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
		PulseUser nextResult = new PulseUser();

		// ID
		nextResult.setID(rs.getString("ID"));

		if (!shellOnly)
		{
			nextResult.setUserId(rs.getString("USER_ID"));

			nextResult.setEmployeeId(rs.getString("EMPLOYEE_ID"));

			nextResult.setFirstName(rs.getString("FIRST_NAME"));

			nextResult.setLastName(rs.getString("LAST_NAME"));

			TeamLeader teamleader = new TeamLeader();
			teamleader.setID(rs.getString("TEAM_LEADER_ID"));
			nextResult.setTeamLeader(teamleader);



		}

		return nextResult;
	}

	@Override
	protected void setPreparedStatmentInsertParams(PulseUser perceroObject, PreparedStatement pstmt) throws SQLException {

		pstmt.setString(1, perceroObject.getID());
		pstmt.setString(2, perceroObject.getUserId());
		pstmt.setString(3, perceroObject.getEmployeeId());
		pstmt.setString(4, perceroObject.getFirstName());
		pstmt.setString(5, perceroObject.getLastName());

		if (perceroObject.getTeamLeader() == null)
		{
			pstmt.setString(6, null);
		}
		else
		{
			pstmt.setString(6, perceroObject.getTeamLeader().getID());
		}
	}

	@Override
	protected void setPreparedStatmentUpdateParams(PulseUser perceroObject, PreparedStatement pstmt) throws SQLException {

		pstmt.setString(1, perceroObject.getUserId());
		pstmt.setString(2, perceroObject.getEmployeeId());
		pstmt.setString(3, perceroObject.getFirstName());
		pstmt.setString(4, perceroObject.getLastName());

		if (perceroObject.getTeamLeader() == null)
		{
			pstmt.setString(5, null);
		}
		else
		{
			pstmt.setString(5, perceroObject.getTeamLeader().getID());
		}

		pstmt.setString(6, perceroObject.getID());


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
			sql += " WHERE ";
			sql += " USER_ID=? ";
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
			sql += " EMPLOYEE_ID=? ";
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
			sql += " TEAM_LEADER_ID=? ";
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

