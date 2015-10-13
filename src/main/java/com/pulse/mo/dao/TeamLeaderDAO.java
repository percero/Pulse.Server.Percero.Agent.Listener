
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
import com.pulse.mo.TeamLeader;
import com.pulse.mo.Notification;
import com.pulse.mo.Agent;
import com.pulse.mo.Alert;
import com.pulse.mo.AdhocTask;
import com.pulse.mo.DevelopmentActivity;
import com.pulse.mo.GeneralComment;
import com.pulse.mo.Setting;
import com.pulse.mo.TeamLeaderImpersonation;
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
	
	public static final String SQL_VIEW = ",\"TEAM_LEADER\".\"EMAIL_ADDRESS\",\"TEAM_LEADER\".\"FIRST_NAME\",\"TEAM_LEADER\".\"LAST_NAME\",\"TEAM_LEADER\".\"EMPLOYEE_ID\",\"TEAM_LEADER\".\"FULL_NAME\",\"TEAM_LEADER\".\"PHOTO_URI\",\"TEAM_LEADER\".\"SUPERVISOR_ID\"";
	private String selectFromStatementTableName = " FROM \"TEAM_LEADER\" \"TEAM_LEADER\"";
	private String whereClause = " WHERE \"TEAM_LEADER\".\"ID\"=?";
	private String whereInClause = " join table(sys.dbms_debug_vc2coll(?)) SQLLIST on \"TEAM_LEADER\".\"ID\"= SQLLIST.column_value";
	private String orderByTableName = " ORDER BY \"TEAM_LEADER\".\"ID\"";
	
	

	
	@Override
	protected String getConnectionFactoryName() {
		return TeamLeaderDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT \"TEAM_LEADER\".\"ID\" " + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT \"TEAM_LEADER\".\"ID\"" + SQL_VIEW  + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT \"TEAM_LEADER\".\"ID\" " + selectFromStatementTableName +  orderByTableName;
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT \"TEAM_LEADER\".\"ID\" " + selectFromStatementTableName  +  orderByTableName  + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT \"TEAM_LEADER\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName  + orderByTableName;
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT \"TEAM_LEADER\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + orderByTableName + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() 
	{
		return "SELECT COUNT(ID) " + selectFromStatementTableName;
	}
	
	@Override
	protected String getSelectInStarSQL() 
	{
		return "SELECT \"TEAM_LEADER\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + whereInClause;
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT \"TEAM_LEADER\".\"ID\" " + selectFromStatementTableName + whereInClause;
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		
		return "SELECT \"TEAM_LEADER\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + " WHERE \"TEAM_LEADER\"." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) 
	{
		
		return "SELECT \"TEAM_LEADER\".\"ID\" " + selectFromStatementTableName + " WHERE \"TEAM_LEADER\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT \"TEAM_LEADER\".\"ID\" " + selectFromStatementTableName;
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT \"TEAM_LEADER\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName;
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO TEAM_LEADER (\"ID\",\"EMAIL_ADDRESS\",\"FIRST_NAME\",\"LAST_NAME\",\"EMPLOYEE_ID\",\"FULL_NAME\",\"PHOTO_URI\",\"SUPERVISOR_ID\") VALUES (?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE \"TEAM_LEADER\" SET \"EMAIL_ADDRESS\"=?,\"FIRST_NAME\"=?,\"LAST_NAME\"=?,\"EMPLOYEE_ID\"=?,\"FULL_NAME\"=?,\"PHOTO_URI\"=?,\"SUPERVISOR_ID\"=? WHERE \"ID\"=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM \"TEAM_LEADER\" WHERE \"ID\"=?";
	}
	
	@Override
	protected TeamLeader extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	TeamLeader nextResult = new TeamLeader();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setEmailAddress(rs.getString("EMAIL_ADDRESS"));

nextResult.setFirstName(rs.getString("FIRST_NAME"));

nextResult.setLastName(rs.getString("LAST_NAME"));

nextResult.setEmployeeId(rs.getString("EMPLOYEE_ID"));

nextResult.setFullName(rs.getString("FULL_NAME"));

nextResult.setPhotoUri(rs.getString("PHOTO_URI"));

Supervisor supervisor = new Supervisor();
supervisor.setID(rs.getString("SUPERVISOR_ID"));
nextResult.setSupervisor(supervisor);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(TeamLeader perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getEmailAddress());
pstmt.setString(3, perceroObject.getFirstName());
pstmt.setString(4, perceroObject.getLastName());
pstmt.setString(5, perceroObject.getEmployeeId());
pstmt.setString(6, perceroObject.getFullName());
pstmt.setString(7, perceroObject.getPhotoUri());

if (perceroObject.getSupervisor() == null)
{
pstmt.setString(8, null);
}
else
{
		pstmt.setString(8, perceroObject.getSupervisor().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(TeamLeader perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getEmailAddress());
pstmt.setString(2, perceroObject.getFirstName());
pstmt.setString(3, perceroObject.getLastName());
pstmt.setString(4, perceroObject.getEmployeeId());
pstmt.setString(5, perceroObject.getFullName());
pstmt.setString(6, perceroObject.getPhotoUri());

if (perceroObject.getSupervisor() == null)
{
pstmt.setString(7, null);
}
else
{
		pstmt.setString(7, perceroObject.getSupervisor().getID());
}

pstmt.setString(8, perceroObject.getID());

		
	}

	@Override
	public List<TeamLeader> findByExample(TeamLeader theQueryObject,
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
sql += " \"FIRST_NAME\" =? ";
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
sql += " \"LAST_NAME\" =? ";
paramValues.add(theQueryObject.getLastName());
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
sql += " \"EMPLOYEE_ID\" =? ";
paramValues.add(theQueryObject.getEmployeeId());
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
sql += " \"FULL_NAME\" =? ";
paramValues.add(theQueryObject.getFullName());
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
sql += " \"PHOTO_URI\" =? ";
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
sql += " \"SUPERVISOR_ID\" =? ";
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
