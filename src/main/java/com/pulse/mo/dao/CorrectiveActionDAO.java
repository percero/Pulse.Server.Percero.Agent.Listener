
package com.pulse.mo.dao;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.percero.agents.sync.exceptions.SyncDataException;
import com.percero.util.DateUtils;
import com.pulse.dataprovider.IConnectionFactory;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.percero.agents.sync.dao.DAORegistry;
import com.percero.agents.sync.dao.IDataAccessObject;
import com.percero.agents.sync.exceptions.SyncException;

import com.pulse.mo.*;


@Component
public class CorrectiveActionDAO extends SqlDataAccessObject<CorrectiveAction> implements IDataAccessObject<CorrectiveAction> {

	static final Logger log = Logger.getLogger(CorrectiveActionDAO.class);

	
	public CorrectiveActionDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(CorrectiveAction.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	
	public static final String SQL_VIEW = ",\"CORRECTIVE_ACTION\".\"SUPERVISOR_COMMENT\",\"CORRECTIVE_ACTION\".\"DETAILS\",\"CORRECTIVE_ACTION\".\"EMPLOYEE_COMMENT\",\"CORRECTIVE_ACTION\".\"EXPIRE_DATE\",\"CORRECTIVE_ACTION\".\"HR_APPROVAL_DATE\",\"CORRECTIVE_ACTION\".\"MANAGER_APPROVAL_DATE\",\"CORRECTIVE_ACTION\".\"SUPERVISOR_ACK_DATE\",\"CORRECTIVE_ACTION\".\"COMPLETION_DATE\",\"CORRECTIVE_ACTION\".\"CLIENT_ID\",\"CORRECTIVE_ACTION\".\"SESSION_ID\",\"CORRECTIVE_ACTION\".\"AGENT_ID\",\"CORRECTIVE_ACTION\".\"CORRECTIVE_ACTION_STATE_ID\",\"CORRECTIVE_ACTION\".\"CORRECTIVE_ACTION_TYPE_ID\",\"CORRECTIVE_ACTION\".\"HR_EMPLOYEE_ID\",\"CORRECTIVE_ACTION\".\"MANAGER_EMPLOYEE_ID\",\"CORRECTIVE_ACTION\".\"SUPERVISOR_ID\",\"CORRECTIVE_ACTION\".\"SUPERVISOR_MANAGER_EMPLOYEE_ID\"";
	private String selectFromStatementTableName = " FROM \"CORRECTIVE_ACTION\" \"CORRECTIVE_ACTION\"";
	private String whereClause = "  WHERE \"CORRECTIVE_ACTION\".\"ID\"=?";
	private String whereInClause = "  join table(sys.dbms_debug_vc2coll(?)) SQLLIST on \"CORRECTIVE_ACTION\".\"ID\"= SQLLIST.column_value";
	private String orderByTableName = "  ORDER BY \"CORRECTIVE_ACTION\".\"ID\"";
	
	

	
	@Override
	protected String getConnectionFactoryName() {
		return CorrectiveActionDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT \"CORRECTIVE_ACTION\".\"ID\" " + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT \"CORRECTIVE_ACTION\".\"ID\"" + SQL_VIEW  + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT \"CORRECTIVE_ACTION\".\"ID\" " + selectFromStatementTableName +  orderByTableName;
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT \"CORRECTIVE_ACTION\".\"ID\" " + selectFromStatementTableName  +  orderByTableName  + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT \"CORRECTIVE_ACTION\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName  + orderByTableName;
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT \"CORRECTIVE_ACTION\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + orderByTableName + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() 
	{
		return "SELECT COUNT(ID) " + selectFromStatementTableName;
	}
	
	@Override
	protected String getSelectInStarSQL() 
	{
		return "SELECT \"CORRECTIVE_ACTION\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + whereInClause;
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT \"CORRECTIVE_ACTION\".\"ID\" " + selectFromStatementTableName + whereInClause;
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		
		return "SELECT \"CORRECTIVE_ACTION\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + " WHERE \"CORRECTIVE_ACTION\"." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) 
	{
		
		return "SELECT \"CORRECTIVE_ACTION\".\"ID\" " + selectFromStatementTableName + " WHERE \"CORRECTIVE_ACTION\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT \"CORRECTIVE_ACTION\".\"ID\" " + selectFromStatementTableName;
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT \"CORRECTIVE_ACTION\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName;
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO TBL_CORRECTIVE_ACTION (\"ID\",\"SUPERVISOR_COMMENT\",\"DETAILS\",\"EMPLOYEE_COMMENT\",\"EXPIRE_DATE\",\"HR_APPROVAL_DATE\",\"MANAGER_APPROVAL_DATE\",\"SUPERVISOR_ACK_DATE\",\"COMPLETION_DATE\",\"CLIENT_ID\",\"SESSION_ID\",\"AGENT_ID\",\"CORRECTIVE_ACTION_STATE_ID\",\"CORRECTIVE_ACTION_TYPE_ID\",\"HR_EMPLOYEE_ID\",\"MANAGER_EMPLOYEE_ID\",\"SUPERVISOR_ID\",\"SUPERVISOR_MANAGER_EMPLOYEE_ID\") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE TBL_CORRECTIVE_ACTION SET \"SUPERVISOR_COMMENT\"=?,\"DETAILS\"=?,\"EMPLOYEE_COMMENT\"=?,\"EXPIRE_DATE\"=?,\"HR_APPROVAL_DATE\"=?,\"MANAGER_APPROVAL_DATE\"=?,\"SUPERVISOR_ACK_DATE\"=?,\"COMPLETION_DATE\"=?,\"CLIENT_ID\"=?,\"SESSION_ID\"=?,\"AGENT_ID\"=?,\"CORRECTIVE_ACTION_STATE_ID\"=?,\"CORRECTIVE_ACTION_TYPE_ID\"=?,\"HR_EMPLOYEE_ID\"=?,\"MANAGER_EMPLOYEE_ID\"=?,\"SUPERVISOR_ID\"=?,\"SUPERVISOR_MANAGER_EMPLOYEE_ID\"=? WHERE \"ID\"=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM TBL_CORRECTIVE_ACTION WHERE \"ID\"=?";
	}
	
	@Override
	protected CorrectiveAction extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	CorrectiveAction nextResult = new CorrectiveAction();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setSupervisorComment(rs.getString("SUPERVISOR_COMMENT"));

nextResult.setDetails(rs.getString("DETAILS"));

nextResult.setEmployeeComment(rs.getString("EMPLOYEE_COMMENT"));

nextResult.setExpireDate(rs.getDate("EXPIRE_DATE"));

nextResult.setHRApprovalDate(rs.getDate("HR_APPROVAL_DATE"));

nextResult.setManagerApprovalDate(rs.getDate("MANAGER_APPROVAL_DATE"));

nextResult.setSupervisorACKDate(rs.getDate("SUPERVISOR_ACK_DATE"));

nextResult.setCompletionDate(rs.getDate("COMPLETION_DATE"));

nextResult.setClientId(rs.getInt("CLIENT_ID"));

nextResult.setSessionId(rs.getInt("SESSION_ID"));

Agent agent = new Agent();
agent.setID(rs.getString("AGENT_ID"));
nextResult.setAgent(agent);

CorrectiveActionState correctiveactionstate = new CorrectiveActionState();
correctiveactionstate.setID(rs.getString("CORRECTIVE_ACTION_STATE_ID"));
nextResult.setCorrectiveActionState(correctiveactionstate);

CorrectiveActionType correctiveactiontype = new CorrectiveActionType();
correctiveactiontype.setID(rs.getString("CORRECTIVE_ACTION_TYPE_ID"));
nextResult.setCorrectiveActionType(correctiveactiontype);

Employee hremployee = new Employee();
hremployee.setID(rs.getString("HR_EMPLOYEE_ID"));
nextResult.setHREmployee(hremployee);

Employee manageremployee = new Employee();
manageremployee.setID(rs.getString("MANAGER_EMPLOYEE_ID"));
nextResult.setManagerEmployee(manageremployee);

Supervisor supervisor = new Supervisor();
supervisor.setID(rs.getString("SUPERVISOR_ID"));
nextResult.setSupervisor(supervisor);

Employee supervisormanageremployee = new Employee();
supervisormanageremployee.setID(rs.getString("SUPERVISOR_MANAGER_EMPLOYEE_ID"));
nextResult.setSupervisorManagerEmployee(supervisormanageremployee);


			
    	}
    	
    	return nextResult;
	}
	
	protected void setBaseStatmentInsertParams(CorrectiveAction perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getSupervisorComment());
pstmt.setString(3, perceroObject.getDetails());
pstmt.setString(4, perceroObject.getEmployeeComment());
pstmt.setDate(5, DateUtils.utilDateToSqlDate(perceroObject.getExpireDate()));
pstmt.setDate(6, DateUtils.utilDateToSqlDate(perceroObject.getHRApprovalDate()));
pstmt.setDate(7, DateUtils.utilDateToSqlDate(perceroObject.getManagerApprovalDate()));
pstmt.setDate(8, DateUtils.utilDateToSqlDate(perceroObject.getSupervisorACKDate()));
pstmt.setDate(9, DateUtils.utilDateToSqlDate(perceroObject.getCompletionDate()));
JdbcHelper.setInt(pstmt,10, perceroObject.getClientId());
JdbcHelper.setInt(pstmt,11, perceroObject.getSessionId());

if (perceroObject.getAgent() == null)
{
pstmt.setString(12, null);
}
else
{
		pstmt.setString(12, perceroObject.getAgent().getID());
}


if (perceroObject.getCorrectiveActionState() == null)
{
pstmt.setString(13, null);
}
else
{
		pstmt.setString(13, perceroObject.getCorrectiveActionState().getID());
}


if (perceroObject.getCorrectiveActionType() == null)
{
pstmt.setString(14, null);
}
else
{
		pstmt.setString(14, perceroObject.getCorrectiveActionType().getID());
}


if (perceroObject.getHREmployee() == null)
{
pstmt.setString(15, null);
}
else
{
		pstmt.setString(15, perceroObject.getHREmployee().getID());
}


if (perceroObject.getManagerEmployee() == null)
{
pstmt.setString(16, null);
}
else
{
		pstmt.setString(16, perceroObject.getManagerEmployee().getID());
}


if (perceroObject.getSupervisor() == null)
{
pstmt.setString(17, null);
}
else
{
		pstmt.setString(17, perceroObject.getSupervisor().getID());
}


if (perceroObject.getSupervisorManagerEmployee() == null)
{
pstmt.setString(18, null);
}
else
{
		pstmt.setString(18, perceroObject.getSupervisorManagerEmployee().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(CorrectiveAction perceroObject, PreparedStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
		
	}
	
	@Override
	protected void setCallableStatmentInsertParams(CorrectiveAction perceroObject, CallableStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	

	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(CorrectiveAction perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getSupervisorComment());
pstmt.setString(2, perceroObject.getDetails());
pstmt.setString(3, perceroObject.getEmployeeComment());
pstmt.setDate(4, DateUtils.utilDateToSqlDate(perceroObject.getExpireDate()));
pstmt.setDate(5, DateUtils.utilDateToSqlDate(perceroObject.getHRApprovalDate()));
pstmt.setDate(6, DateUtils.utilDateToSqlDate(perceroObject.getManagerApprovalDate()));
pstmt.setDate(7, DateUtils.utilDateToSqlDate(perceroObject.getSupervisorACKDate()));
pstmt.setDate(8, DateUtils.utilDateToSqlDate(perceroObject.getCompletionDate()));
JdbcHelper.setInt(pstmt,9, perceroObject.getClientId());
JdbcHelper.setInt(pstmt,10, perceroObject.getSessionId());

if (perceroObject.getAgent() == null)
{
pstmt.setString(11, null);
}
else
{
		pstmt.setString(11, perceroObject.getAgent().getID());
}


if (perceroObject.getCorrectiveActionState() == null)
{
pstmt.setString(12, null);
}
else
{
		pstmt.setString(12, perceroObject.getCorrectiveActionState().getID());
}


if (perceroObject.getCorrectiveActionType() == null)
{
pstmt.setString(13, null);
}
else
{
		pstmt.setString(13, perceroObject.getCorrectiveActionType().getID());
}


if (perceroObject.getHREmployee() == null)
{
pstmt.setString(14, null);
}
else
{
		pstmt.setString(14, perceroObject.getHREmployee().getID());
}


if (perceroObject.getManagerEmployee() == null)
{
pstmt.setString(15, null);
}
else
{
		pstmt.setString(15, perceroObject.getManagerEmployee().getID());
}


if (perceroObject.getSupervisor() == null)
{
pstmt.setString(16, null);
}
else
{
		pstmt.setString(16, perceroObject.getSupervisor().getID());
}


if (perceroObject.getSupervisorManagerEmployee() == null)
{
pstmt.setString(17, null);
}
else
{
		pstmt.setString(17, perceroObject.getSupervisorManagerEmployee().getID());
}

pstmt.setString(18, perceroObject.getID());

		
	}
	
	
	@Override
	protected void setCallableStatmentUpdateParams(CorrectiveAction perceroObject, CallableStatement pstmt) throws SQLException 
	{
		
		//must be in same order as insert
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	}
	
	

	@Override
	public List<CorrectiveAction> findByExample(CorrectiveAction theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useSupervisorComment = StringUtils.hasText(theQueryObject.getSupervisorComment()) && (excludeProperties == null || !excludeProperties.contains("supervisorComment"));

if (useSupervisorComment)
{
sql += " WHERE ";
sql += " \"SUPERVISOR_COMMENT\" =? ";
paramValues.add(theQueryObject.getSupervisorComment());
propertyCounter++;
}

boolean useDetails = StringUtils.hasText(theQueryObject.getDetails()) && (excludeProperties == null || !excludeProperties.contains("details"));

if (useDetails)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"DETAILS\" =? ";
paramValues.add(theQueryObject.getDetails());
propertyCounter++;
}

boolean useEmployeeComment = StringUtils.hasText(theQueryObject.getEmployeeComment()) && (excludeProperties == null || !excludeProperties.contains("employeeComment"));

if (useEmployeeComment)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"EMPLOYEE_COMMENT\" =? ";
paramValues.add(theQueryObject.getEmployeeComment());
propertyCounter++;
}

boolean useExpireDate = theQueryObject.getExpireDate() != null && (excludeProperties == null || !excludeProperties.contains("expireDate"));

if (useExpireDate)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"EXPIRE_DATE\" =? ";
paramValues.add(theQueryObject.getExpireDate());
propertyCounter++;
}

boolean useHRApprovalDate = theQueryObject.getHRApprovalDate() != null && (excludeProperties == null || !excludeProperties.contains("hRApprovalDate"));

if (useHRApprovalDate)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"HR_APPROVAL_DATE\" =? ";
paramValues.add(theQueryObject.getHRApprovalDate());
propertyCounter++;
}

boolean useManagerApprovalDate = theQueryObject.getManagerApprovalDate() != null && (excludeProperties == null || !excludeProperties.contains("managerApprovalDate"));

if (useManagerApprovalDate)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"MANAGER_APPROVAL_DATE\" =? ";
paramValues.add(theQueryObject.getManagerApprovalDate());
propertyCounter++;
}

boolean useSupervisorACKDate = theQueryObject.getSupervisorACKDate() != null && (excludeProperties == null || !excludeProperties.contains("supervisorACKDate"));

if (useSupervisorACKDate)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"SUPERVISOR_ACK_DATE\" =? ";
paramValues.add(theQueryObject.getSupervisorACKDate());
propertyCounter++;
}

boolean useCompletionDate = theQueryObject.getCompletionDate() != null && (excludeProperties == null || !excludeProperties.contains("completionDate"));

if (useCompletionDate)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"COMPLETION_DATE\" =? ";
paramValues.add(theQueryObject.getCompletionDate());
propertyCounter++;
}

boolean useClientId = theQueryObject.getClientId() != null && (excludeProperties == null || !excludeProperties.contains("clientId"));

if (useClientId)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"CLIENT_ID\" =? ";
paramValues.add(theQueryObject.getClientId());
propertyCounter++;
}

boolean useSessionId = theQueryObject.getSessionId() != null && (excludeProperties == null || !excludeProperties.contains("sessionId"));

if (useSessionId)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"SESSION_ID\" =? ";
paramValues.add(theQueryObject.getSessionId());
propertyCounter++;
}

boolean useAgentID = theQueryObject.getAgent() != null && (excludeProperties == null || !excludeProperties.contains("agent"));

if (useAgentID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"AGENT_ID\" =? ";
paramValues.add(theQueryObject.getAgent().getID());
propertyCounter++;
}

boolean useCorrectiveActionStateID = theQueryObject.getCorrectiveActionState() != null && (excludeProperties == null || !excludeProperties.contains("correctiveActionState"));

if (useCorrectiveActionStateID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"CORRECTIVE_ACTION_STATE_ID\" =? ";
paramValues.add(theQueryObject.getCorrectiveActionState().getID());
propertyCounter++;
}

boolean useCorrectiveActionTypeID = theQueryObject.getCorrectiveActionType() != null && (excludeProperties == null || !excludeProperties.contains("correctiveActionType"));

if (useCorrectiveActionTypeID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"CORRECTIVE_ACTION_TYPE_ID\" =? ";
paramValues.add(theQueryObject.getCorrectiveActionType().getID());
propertyCounter++;
}

boolean useHREmployeeID = theQueryObject.getHREmployee() != null && (excludeProperties == null || !excludeProperties.contains("hREmployee"));

if (useHREmployeeID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"HR_EMPLOYEE_ID\" =? ";
paramValues.add(theQueryObject.getHREmployee().getID());
propertyCounter++;
}

boolean useManagerEmployeeID = theQueryObject.getManagerEmployee() != null && (excludeProperties == null || !excludeProperties.contains("managerEmployee"));

if (useManagerEmployeeID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"MANAGER_EMPLOYEE_ID\" =? ";
paramValues.add(theQueryObject.getManagerEmployee().getID());
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

boolean useSupervisorManagerEmployeeID = theQueryObject.getSupervisorManagerEmployee() != null && (excludeProperties == null || !excludeProperties.contains("supervisorManagerEmployee"));

if (useSupervisorManagerEmployeeID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"SUPERVISOR_MANAGER_EMPLOYEE_ID\" =? ";
paramValues.add(theQueryObject.getSupervisorManagerEmployee().getID());
propertyCounter++;
}



		if (propertyCounter == 0) {
			throw new SyncException(SyncException.METHOD_UNSUPPORTED, SyncException.METHOD_UNSUPPORTED_CODE);
		}
		
		return executeSelectWithParams(sql, paramValues.toArray(), shellOnly);		
	}
	
	@Override
	protected String getUpdateCallableStatementSql() {
		return "{call UPDATE_CORRECTIVE_ACTION(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	}
	@Override
	protected String getInsertCallableStatementSql() {
		return "{call CREATE_CORRECTIVE_ACTION(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	}
	@Override
	protected String getDeleteCallableStatementSql() {
		return "{call Delete_CORRECTIVE_ACTION(?)}";
	}
	
	
	
	
}
