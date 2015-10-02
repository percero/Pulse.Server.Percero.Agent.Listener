

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
		return "SELECT teamleader.ID FROM TeamLeader teamleader WHERE teamleader.ID=?";
	}

	@Override
	protected String getSelectStarSQL() {
		return "SELECT teamleader.ID,teamleader.lastName,teamleader.emailAddress,teamleader.externalID,teamleader.firstName,teamleader.employeeId,teamleader.notificationCount,teamleader.photoUri,teamleader.supervisor_ID FROM TeamLeader teamleader WHERE teamleader.ID=?";
	}

	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT teamleader.ID FROM TeamLeader teamleader ORDER BY ID";
	}

	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT teamleader.ID FROM TeamLeader teamleader ORDER BY teamleader.ID LIMIT ? OFFSET ?";
	}

	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT teamleader.ID,teamleader.lastName,teamleader.emailAddress,teamleader.externalID,teamleader.firstName,teamleader.employeeId,teamleader.notificationCount,teamleader.photoUri,teamleader.supervisor_ID FROM TeamLeader teamleader ORDER BY teamleader.ID";
	}

	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT teamleader.ID,teamleader.lastName,teamleader.emailAddress,teamleader.externalID,teamleader.firstName,teamleader.employeeId,teamleader.notificationCount,teamleader.photoUri,teamleader.supervisor_ID FROM TeamLeader teamleader ORDER BY teamleader.ID LIMIT ? OFFSET ?";
	}

	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM TeamLeader teamleader";
	}

	@Override
	protected String getSelectInStarSQL() {
		return "SELECT teamleader.ID,teamleader.lastName,teamleader.emailAddress,teamleader.externalID,teamleader.firstName,teamleader.employeeId,teamleader.notificationCount,teamleader.photoUri,teamleader.supervisor_ID FROM TeamLeader teamleader WHERE teamleader.ID IN (?)";
	}

	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT teamleader.ID FROM TeamLeader teamleader WHERE teamleader.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT teamleader.ID,teamleader.lastName,teamleader.emailAddress,teamleader.externalID,teamleader.firstName,teamleader.employeeId,teamleader.notificationCount,teamleader.photoUri,teamleader.supervisor_ID FROM TeamLeader teamleader WHERE teamleader." + joinColumnName + "=?";
	}

	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT teamleader.ID FROM TeamLeader teamleader WHERE teamleader." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT teamleader.ID FROM TeamLeader teamleader ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
//		return "SELECT teamleader.ID,teamleader.lastName,teamleader.emailAddress,teamleader.externalID,teamleader.firstName,teamleader.employeeId,teamleader.notificationCount,teamleader.photoUri,teamleader.supervisor_ID FROM TeamLeader teamleader ";
		return "SELECT teamleader.\"LastName\", teamleader.\"FirstName\",teamleader.\"EmployeeId\" FROM \"TeamLeader\" teamleader ";
	}

	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO TeamLeader (ID,lastName,emailAddress,externalID,firstName,employeeId,notificationCount,photoUri,supervisor_ID) VALUES (?,?,?,?,?,?,?,?,?)";
	}

	@Override
	protected String getUpdateSet() {
		return "UPDATE TeamLeader SET lastName=?,emailAddress=?,externalID=?,firstName=?,employeeId=?,notificationCount=?,photoUri=?,supervisor_ID=? WHERE ID=?";
	}

	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM TeamLeader WHERE ID=?";
	}

	@Override
	protected TeamLeader extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
		TeamLeader nextResult = new TeamLeader();

		// ID
//		nextResult.setID(rs.getString("ID"));

		if (!shellOnly)
		{
			nextResult.setLastName(rs.getString("lastName"));

//			nextResult.setEmailAddress(rs.getString("emailAddress"));

//			nextResult.setExternalID(rs.getString("externalID"));

			nextResult.setFirstName(rs.getString("firstName"));

			nextResult.setEmployeeId(rs.getString("employeeId"));

//			nextResult.setNotificationCount(rs.getInt("notificationCount"));

//			nextResult.setPhotoUri(rs.getString("photoUri"));

//			Supervisor supervisor = new Supervisor();
//			supervisor.setID(rs.getString("supervisor_ID"));
//			nextResult.setSupervisor(supervisor);



		}

		return nextResult;
	}

	@Override
	protected void setPreparedStatmentInsertParams(TeamLeader perceroObject, PreparedStatement pstmt) throws SQLException {

		pstmt.setString(1, perceroObject.getID());
		pstmt.setString(2, perceroObject.getLastName());
		pstmt.setString(3, perceroObject.getEmailAddress());
		pstmt.setString(4, perceroObject.getExternalID());
		pstmt.setString(5, perceroObject.getFirstName());
		pstmt.setString(6, perceroObject.getEmployeeId());
		pstmt.setInt(7, perceroObject.getNotificationCount());
		pstmt.setString(8, perceroObject.getPhotoUri());

		if (perceroObject.getSupervisor() == null)
		{
			pstmt.setString(9, null);
		}
		else
		{
			pstmt.setString(9, perceroObject.getSupervisor().getID());
		}



	}

	@Override
	protected void setPreparedStatmentUpdateParams(TeamLeader perceroObject, PreparedStatement pstmt) throws SQLException {

		pstmt.setString(1, perceroObject.getLastName());
		pstmt.setString(2, perceroObject.getEmailAddress());
		pstmt.setString(3, perceroObject.getExternalID());
		pstmt.setString(4, perceroObject.getFirstName());
		pstmt.setString(5, perceroObject.getEmployeeId());
		pstmt.setInt(6, perceroObject.getNotificationCount());
		pstmt.setString(7, perceroObject.getPhotoUri());

		if (perceroObject.getSupervisor() == null)
		{
			pstmt.setString(8, null);
		}
		else
		{
			pstmt.setString(8, perceroObject.getSupervisor().getID());
		}

		pstmt.setString(9, perceroObject.getID());


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
			sql += " teamleader.\"EmployeeId\"=? ";
			paramValues.add(theQueryObject.getEmployeeId());
			propertyCounter++;
		}

		boolean useNotificationCount = theQueryObject.getNotificationCount() != null && (excludeProperties == null || !excludeProperties.contains("notificationCount"));

		if (useNotificationCount)
		{
			if (propertyCounter > 0)
			{
				sql += " AND ";
			}
			else
			{
				sql += " WHERE ";
			}
			sql += " notificationCount=? ";
			paramValues.add(theQueryObject.getNotificationCount());
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

		boolean useSupervisorID = theQueryObject.getSupervisor() != null && (excludeProperties == null || !excludeProperties.contains("supervisor"));

		if (useSupervisorID)
		{
			if (propertyCounter > 0)
			{
				sql += " AND ";
			}
			else
			{
				sql += " WHERE ";
			}
			sql += " supervisorID=? ";
			paramValues.add(theQueryObject.getSupervisor().getID());
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

