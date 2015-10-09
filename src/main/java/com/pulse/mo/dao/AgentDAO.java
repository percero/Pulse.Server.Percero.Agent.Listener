

package com.pulse.mo.dao;

import com.percero.agents.sync.dao.DAORegistry;
import com.percero.agents.sync.dao.IDataAccessObject;
import com.percero.agents.sync.exceptions.SyncException;
import com.pulse.mo.Agent;
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
import com.pulse.mo.Agent;
import com.pulse.mo.ScheduledTime;
import com.pulse.mo.TimecardEntry;
import com.pulse.mo.BehaviorResponse;
import com.pulse.mo.AdhocCoachingSession;
import com.pulse.mo.AgentScorecard;
import com.pulse.mo.CoachingSession;
import com.pulse.mo.LOBConfigurationNotification;
import com.pulse.mo.CorrectiveAction;
import com.pulse.mo.Timecard;
import com.pulse.mo.AdhocTask;
import com.pulse.mo.GeneralComment;
import com.pulse.mo.TeamLeader;

*/

@Component
public class AgentDAO extends SqlDataAccessObject<Agent> implements IDataAccessObject<Agent> {

	static final Logger log = Logger.getLogger(AgentDAO.class);


	public AgentDAO() {
		super();

		DAORegistry.getInstance().registerDataAccessObject(Agent.class.getCanonicalName(), this);
	}


	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	@Override
	protected String getConnectionFactoryName() {
		return AgentDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT AGENT.ID FROM AGENT AGENT WHERE AGENT.ID=?";
	}

	@Override
	protected String getSelectStarSQL() {
		return "SELECT AGENT.ID,AGENT.LAST_NAME,AGENT.EMAIL_ADDRESS,AGENT.EMPLOYEE_ID,AGENT.FIRST_NAME,AGENT.FULL_NAME,AGENT.TEAM_LEADER_ID FROM AGENT AGENT WHERE AGENT.ID=?";
	}

	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT AGENT.ID FROM AGENT AGENT ORDER BY ID";
	}

	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT AGENT.ID FROM AGENT AGENT ORDER BY AGENT.ID LIMIT ? OFFSET ?";
	}

	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT AGENT.ID,AGENT.LAST_NAME,AGENT.EMAIL_ADDRESS,AGENT.EMPLOYEE_ID,AGENT.FIRST_NAME,AGENT.FULL_NAME,AGENT.TEAM_LEADER_ID FROM AGENT AGENT ORDER BY AGENT.ID";
	}

	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT AGENT.ID,AGENT.LAST_NAME,AGENT.EMAIL_ADDRESS,AGENT.EMPLOYEE_ID,AGENT.FIRST_NAME,AGENT.FULL_NAME,AGENT.TEAM_LEADER_ID FROM AGENT AGENT ORDER BY AGENT.ID LIMIT ? OFFSET ?";
	}

	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM AGENT AGENT";
	}

	@Override
	protected String getSelectInStarSQL() {
		return "SELECT AGENT.ID,AGENT.LAST_NAME,AGENT.EMAIL_ADDRESS,AGENT.EMPLOYEE_ID,AGENT.FIRST_NAME,AGENT.FULL_NAME,AGENT.TEAM_LEADER_ID FROM AGENT AGENT WHERE AGENT.ID IN (?)";
	}

	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT AGENT.ID FROM AGENT AGENT WHERE AGENT.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT AGENT.ID,AGENT.LAST_NAME,AGENT.EMAIL_ADDRESS,AGENT.EMPLOYEE_ID,AGENT.FIRST_NAME,AGENT.FULL_NAME,AGENT.TEAM_LEADER_ID FROM AGENT AGENT WHERE AGENT." + joinColumnName + "=?";
	}

	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT AGENT.ID FROM AGENT AGENT WHERE AGENT." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT AGENT.ID FROM AGENT AGENT ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT AGENT.ID,AGENT.LAST_NAME,AGENT.EMAIL_ADDRESS,AGENT.EMPLOYEE_ID,AGENT.FIRST_NAME,AGENT.FULL_NAME,AGENT.TEAM_LEADER_ID FROM AGENT AGENT ";
	}

	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO AGENT (ID,LAST_NAME,EMAIL_ADDRESS,EMPLOYEE_ID,FIRST_NAME,FULL_NAME,TEAM_LEADER_ID) VALUES (?,?,?,?,?,?,?)";
	}

	@Override
	protected String getUpdateSet() {
		return "UPDATE AGENT SET LAST_NAME=?,EMAIL_ADDRESS=?,EMPLOYEE_ID=?,FIRST_NAME=?,FULL_NAME=?,TEAM_LEADER_ID=? WHERE ID=?";
	}

	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM AGENT WHERE ID=?";
	}

	@Override
	protected Agent extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
		Agent nextResult = new Agent();

		// ID
		nextResult.setID(rs.getString("ID"));

		if (!shellOnly)
		{
			nextResult.setLastName(rs.getString("LAST_NAME"));

			nextResult.setEmailAddress(rs.getString("EMAIL_ADDRESS"));

			nextResult.setEmployeeId(rs.getString("EMPLOYEE_ID"));

			nextResult.setFirstName(rs.getString("FIRST_NAME"));

			nextResult.setFullName(rs.getString("FULL_NAME"));

			TeamLeader teamleader = new TeamLeader();
			teamleader.setID(rs.getString("TEAM_LEADER_ID"));
			nextResult.setTeamLeader(teamleader);



		}

		return nextResult;
	}

	@Override
	protected void setPreparedStatmentInsertParams(Agent perceroObject, PreparedStatement pstmt) throws SQLException {

		pstmt.setString(1, perceroObject.getID());
		pstmt.setString(2, perceroObject.getLastName());
		pstmt.setString(3, perceroObject.getEmailAddress());
		pstmt.setString(4, perceroObject.getEmployeeId());
		pstmt.setString(5, perceroObject.getFirstName());
		pstmt.setString(6, perceroObject.getFullName());

		if (perceroObject.getTeamLeader() == null)
		{
			pstmt.setString(7, null);
		}
		else
		{
			pstmt.setString(7, perceroObject.getTeamLeader().getID());
		}
	}

	@Override
	protected void setPreparedStatmentUpdateParams(Agent perceroObject, PreparedStatement pstmt) throws SQLException {

		pstmt.setString(1, perceroObject.getLastName());
		pstmt.setString(2, perceroObject.getEmailAddress());
		pstmt.setString(3, perceroObject.getEmployeeId());
		pstmt.setString(4, perceroObject.getFirstName());
		pstmt.setString(5, perceroObject.getFullName());

		if (perceroObject.getTeamLeader() == null)
		{
			pstmt.setString(6, null);
		}
		else
		{
			pstmt.setString(6, perceroObject.getTeamLeader().getID());
		}

		pstmt.setString(7, perceroObject.getID());


	}

	@Override
	public List<Agent> findByExample(Agent theQueryObject,
									 List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException
	{



		String sql = getFindByExampleSelectSql(shellOnly);

		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();

		boolean useLastName = StringUtils.hasText(theQueryObject.getLastName()) && (excludeProperties == null || !excludeProperties.contains("lastName"));

		if (useLastName)
		{
			sql += " WHERE ";
			sql += " LAST_NAME=? ";
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
			sql += " EMAIL_ADDRESS=? ";
			paramValues.add(theQueryObject.getEmailAddress());
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

