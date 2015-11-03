
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
import com.percero.agents.sync.metadata.MappedClass;
import com.percero.agents.sync.dao.DAORegistry;
import com.percero.agents.sync.dao.IDataAccessObject;
import com.percero.agents.sync.exceptions.SyncException;
import com.percero.agents.sync.vo.BaseDataObject;
import java.sql.Connection;
import java.sql.Statement;
import com.pulse.dataprovider.IConnectionFactory;
import com.percero.agents.sync.exceptions.SyncDataException;
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
	
	public static final String SHELL_ONLY_SELECT = "\"CORRECTIVE_ACTION\".\"ID\"";
	public static final String SQL_VIEW = ",\"CORRECTIVE_ACTION\".\"EXPIRE_DATE\",\"CORRECTIVE_ACTION\".\"HR_APPROVAL_DATE\",\"CORRECTIVE_ACTION\".\"MANAGER_APPROVAL_DATE\",\"CORRECTIVE_ACTION\".\"SUPERVISOR_ACK_DATE\",\"CORRECTIVE_ACTION\".\"COMPLETION_DATE\",\"CORRECTIVE_ACTION\".\"CLIENT_ID\",\"CORRECTIVE_ACTION\".\"DISCIPLINE_TYPE\",\"CORRECTIVE_ACTION\".\"FORM_ID\",\"CORRECTIVE_ACTION\".\"SESSION_ID\",\"CORRECTIVE_ACTION\".\"REASON\",\"CORRECTIVE_ACTION\".\"SUPERVISOR_COMMENT\",\"CORRECTIVE_ACTION\".\"DETAILS\",\"CORRECTIVE_ACTION\".\"EMPLOYEE_COMMENT\",\"CORRECTIVE_ACTION\".\"METRIC_REF\",\"CORRECTIVE_ACTION\".\"NEXT_STEPS\",\"CORRECTIVE_ACTION\".\"PROGRAM\",\"CORRECTIVE_ACTION\".\"HR_EMPLOYEE_ID\",\"CORRECTIVE_ACTION\".\"MANAGER_EMPLOYEE_ID\",\"CORRECTIVE_ACTION\".\"SUPERVISOR_ID\",\"CORRECTIVE_ACTION\".\"SUPERVISOR_MANAGER_EMPLOYEE_ID\",\"CORRECTIVE_ACTION\".\"AGENT_ID\",\"CORRECTIVE_ACTION\".\"CORRECTIVE_ACTION_STATE_ID\",\"CORRECTIVE_ACTION\".\"CORRECTIVE_ACTION_TYPE_ID\"";
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
		return "SELECT " + SHELL_ONLY_SELECT +  " " + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT \"CORRECTIVE_ACTION\".\"ID\"" + SQL_VIEW  + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName +  orderByTableName;
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName  +  orderByTableName  + " LIMIT ? OFFSET ?";
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
		return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName + whereInClause;
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		
		return "SELECT \"CORRECTIVE_ACTION\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + " WHERE \"CORRECTIVE_ACTION\"." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) 
	{
		
		return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName + " WHERE \"CORRECTIVE_ACTION\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName;
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT \"CORRECTIVE_ACTION\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName;
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO TBL_CORRECTIVE_ACTION (\"ID\",\"EXPIRE_DATE\",\"HR_APPROVAL_DATE\",\"MANAGER_APPROVAL_DATE\",\"SUPERVISOR_ACK_DATE\",\"COMPLETION_DATE\",\"CLIENT_ID\",\"DISCIPLINE_TYPE\",\"FORM_ID\",\"SESSION_ID\",\"REASON\",\"SUPERVISOR_COMMENT\",\"DETAILS\",\"EMPLOYEE_COMMENT\",\"METRIC_REF\",\"NEXT_STEPS\",\"PROGRAM\",\"HR_EMPLOYEE_ID\",\"MANAGER_EMPLOYEE_ID\",\"SUPERVISOR_ID\",\"SUPERVISOR_MANAGER_EMPLOYEE_ID\",\"AGENT_ID\",\"CORRECTIVE_ACTION_STATE_ID\",\"CORRECTIVE_ACTION_TYPE_ID\") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE TBL_CORRECTIVE_ACTION SET \"EXPIRE_DATE\"=?,\"HR_APPROVAL_DATE\"=?,\"MANAGER_APPROVAL_DATE\"=?,\"SUPERVISOR_ACK_DATE\"=?,\"COMPLETION_DATE\"=?,\"CLIENT_ID\"=?,\"DISCIPLINE_TYPE\"=?,\"FORM_ID\"=?,\"SESSION_ID\"=?,\"REASON\"=?,\"SUPERVISOR_COMMENT\"=?,\"DETAILS\"=?,\"EMPLOYEE_COMMENT\"=?,\"METRIC_REF\"=?,\"NEXT_STEPS\"=?,\"PROGRAM\"=?,\"HR_EMPLOYEE_ID\"=?,\"MANAGER_EMPLOYEE_ID\"=?,\"SUPERVISOR_ID\"=?,\"SUPERVISOR_MANAGER_EMPLOYEE_ID\"=?,\"AGENT_ID\"=?,\"CORRECTIVE_ACTION_STATE_ID\"=?,\"CORRECTIVE_ACTION_TYPE_ID\"=? WHERE \"ID\"=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM TBL_CORRECTIVE_ACTION WHERE \"ID\"=?";
	}
	
	@Override
	protected CorrectiveAction extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	
		
CorrectiveAction nextResult = null;
    	
		    	
    	if (nextResult == null) {
    		nextResult = new CorrectiveAction();
    	}

		
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setExpireDate(DateUtils.utilDateFromSqlTimestamp(rs.getTimestamp("EXPIRE_DATE")));


nextResult.setHRApprovalDate(DateUtils.utilDateFromSqlTimestamp(rs.getTimestamp("HR_APPROVAL_DATE")));


nextResult.setManagerApprovalDate(DateUtils.utilDateFromSqlTimestamp(rs.getTimestamp("MANAGER_APPROVAL_DATE")));


nextResult.setSupervisorACKDate(DateUtils.utilDateFromSqlTimestamp(rs.getTimestamp("SUPERVISOR_ACK_DATE")));


nextResult.setCompletionDate(DateUtils.utilDateFromSqlTimestamp(rs.getTimestamp("COMPLETION_DATE")));


nextResult.setClientId(rs.getInt("CLIENT_ID"));


nextResult.setDisciplineType(rs.getInt("DISCIPLINE_TYPE"));


nextResult.setFormId(rs.getInt("FORM_ID"));


nextResult.setSessionId(rs.getInt("SESSION_ID"));


nextResult.setReason(rs.getString("REASON"));


nextResult.setSupervisorComment(rs.getString("SUPERVISOR_COMMENT"));


nextResult.setDetails(rs.getString("DETAILS"));


nextResult.setEmployeeComment(rs.getString("EMPLOYEE_COMMENT"));


nextResult.setMetricRef(rs.getString("METRIC_REF"));


nextResult.setNextSteps(rs.getString("NEXT_STEPS"));


nextResult.setProgram(rs.getString("PROGRAM"));


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


Agent agent = new Agent();
agent.setID(rs.getString("AGENT_ID"));
nextResult.setAgent(agent);


CorrectiveActionState correctiveactionstate = new CorrectiveActionState();
correctiveactionstate.setID(rs.getString("CORRECTIVE_ACTION_STATE_ID"));
nextResult.setCorrectiveActionState(correctiveactionstate);


CorrectiveActionType correctiveactiontype = new CorrectiveActionType();
correctiveactiontype.setID(rs.getString("CORRECTIVE_ACTION_TYPE_ID"));
nextResult.setCorrectiveActionType(correctiveactiontype);



			
    	}
		
		
    	return nextResult;
	}
	
	protected void setBaseStatmentInsertParams(CorrectiveAction perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setDate(2, DateUtils.utilDateToSqlDate(perceroObject.getExpireDate()));
pstmt.setDate(3, DateUtils.utilDateToSqlDate(perceroObject.getHRApprovalDate()));
pstmt.setDate(4, DateUtils.utilDateToSqlDate(perceroObject.getManagerApprovalDate()));
pstmt.setDate(5, DateUtils.utilDateToSqlDate(perceroObject.getSupervisorACKDate()));
pstmt.setDate(6, DateUtils.utilDateToSqlDate(perceroObject.getCompletionDate()));
JdbcHelper.setInt(pstmt,7, perceroObject.getClientId());
JdbcHelper.setInt(pstmt,8, perceroObject.getDisciplineType());
JdbcHelper.setInt(pstmt,9, perceroObject.getFormId());
JdbcHelper.setInt(pstmt,10, perceroObject.getSessionId());
pstmt.setString(11, perceroObject.getReason());
pstmt.setString(12, perceroObject.getSupervisorComment());
pstmt.setString(13, perceroObject.getDetails());
pstmt.setString(14, perceroObject.getEmployeeComment());
pstmt.setString(15, perceroObject.getMetricRef());
pstmt.setString(16, perceroObject.getNextSteps());
pstmt.setString(17, perceroObject.getProgram());

if (perceroObject.getHREmployee() == null)
{
pstmt.setString(18, null);
}
else
{
		pstmt.setString(18, perceroObject.getHREmployee().getID());
}


if (perceroObject.getManagerEmployee() == null)
{
pstmt.setString(19, null);
}
else
{
		pstmt.setString(19, perceroObject.getManagerEmployee().getID());
}


if (perceroObject.getSupervisor() == null)
{
pstmt.setString(20, null);
}
else
{
		pstmt.setString(20, perceroObject.getSupervisor().getID());
}


if (perceroObject.getSupervisorManagerEmployee() == null)
{
pstmt.setString(21, null);
}
else
{
		pstmt.setString(21, perceroObject.getSupervisorManagerEmployee().getID());
}


if (perceroObject.getAgent() == null)
{
pstmt.setString(22, null);
}
else
{
		pstmt.setString(22, perceroObject.getAgent().getID());
}


if (perceroObject.getCorrectiveActionState() == null)
{
pstmt.setString(23, null);
}
else
{
		pstmt.setString(23, perceroObject.getCorrectiveActionState().getID());
}


if (perceroObject.getCorrectiveActionType() == null)
{
pstmt.setString(24, null);
}
else
{
		pstmt.setString(24, perceroObject.getCorrectiveActionType().getID());
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
		
		pstmt.setDate(1, DateUtils.utilDateToSqlDate(perceroObject.getExpireDate()));
pstmt.setDate(2, DateUtils.utilDateToSqlDate(perceroObject.getHRApprovalDate()));
pstmt.setDate(3, DateUtils.utilDateToSqlDate(perceroObject.getManagerApprovalDate()));
pstmt.setDate(4, DateUtils.utilDateToSqlDate(perceroObject.getSupervisorACKDate()));
pstmt.setDate(5, DateUtils.utilDateToSqlDate(perceroObject.getCompletionDate()));
JdbcHelper.setInt(pstmt,6, perceroObject.getClientId());
JdbcHelper.setInt(pstmt,7, perceroObject.getDisciplineType());
JdbcHelper.setInt(pstmt,8, perceroObject.getFormId());
JdbcHelper.setInt(pstmt,9, perceroObject.getSessionId());
pstmt.setString(10, perceroObject.getReason());
pstmt.setString(11, perceroObject.getSupervisorComment());
pstmt.setString(12, perceroObject.getDetails());
pstmt.setString(13, perceroObject.getEmployeeComment());
pstmt.setString(14, perceroObject.getMetricRef());
pstmt.setString(15, perceroObject.getNextSteps());
pstmt.setString(16, perceroObject.getProgram());

if (perceroObject.getHREmployee() == null)
{
pstmt.setString(17, null);
}
else
{
		pstmt.setString(17, perceroObject.getHREmployee().getID());
}


if (perceroObject.getManagerEmployee() == null)
{
pstmt.setString(18, null);
}
else
{
		pstmt.setString(18, perceroObject.getManagerEmployee().getID());
}


if (perceroObject.getSupervisor() == null)
{
pstmt.setString(19, null);
}
else
{
		pstmt.setString(19, perceroObject.getSupervisor().getID());
}


if (perceroObject.getSupervisorManagerEmployee() == null)
{
pstmt.setString(20, null);
}
else
{
		pstmt.setString(20, perceroObject.getSupervisorManagerEmployee().getID());
}


if (perceroObject.getAgent() == null)
{
pstmt.setString(21, null);
}
else
{
		pstmt.setString(21, perceroObject.getAgent().getID());
}


if (perceroObject.getCorrectiveActionState() == null)
{
pstmt.setString(22, null);
}
else
{
		pstmt.setString(22, perceroObject.getCorrectiveActionState().getID());
}


if (perceroObject.getCorrectiveActionType() == null)
{
pstmt.setString(23, null);
}
else
{
		pstmt.setString(23, perceroObject.getCorrectiveActionType().getID());
}

pstmt.setString(24, perceroObject.getID());

		
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
		
		boolean useExpireDate = theQueryObject.getExpireDate() != null && (excludeProperties == null || !excludeProperties.contains("expireDate"));

if (useExpireDate)
{
sql += " WHERE ";
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

boolean useDisciplineType = theQueryObject.getDisciplineType() != null && (excludeProperties == null || !excludeProperties.contains("disciplineType"));

if (useDisciplineType)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"DISCIPLINE_TYPE\" =? ";
paramValues.add(theQueryObject.getDisciplineType());
propertyCounter++;
}

boolean useFormId = theQueryObject.getFormId() != null && (excludeProperties == null || !excludeProperties.contains("formId"));

if (useFormId)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"FORM_ID\" =? ";
paramValues.add(theQueryObject.getFormId());
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

boolean useReason = StringUtils.hasText(theQueryObject.getReason()) && (excludeProperties == null || !excludeProperties.contains("reason"));

if (useReason)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"REASON\" =? ";
paramValues.add(theQueryObject.getReason());
propertyCounter++;
}

boolean useSupervisorComment = StringUtils.hasText(theQueryObject.getSupervisorComment()) && (excludeProperties == null || !excludeProperties.contains("supervisorComment"));

if (useSupervisorComment)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
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

boolean useMetricRef = StringUtils.hasText(theQueryObject.getMetricRef()) && (excludeProperties == null || !excludeProperties.contains("metricRef"));

if (useMetricRef)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"METRIC_REF\" =? ";
paramValues.add(theQueryObject.getMetricRef());
propertyCounter++;
}

boolean useNextSteps = StringUtils.hasText(theQueryObject.getNextSteps()) && (excludeProperties == null || !excludeProperties.contains("nextSteps"));

if (useNextSteps)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"NEXT_STEPS\" =? ";
paramValues.add(theQueryObject.getNextSteps());
propertyCounter++;
}

boolean useProgram = StringUtils.hasText(theQueryObject.getProgram()) && (excludeProperties == null || !excludeProperties.contains("program"));

if (useProgram)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"PROGRAM\" =? ";
paramValues.add(theQueryObject.getProgram());
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



		if (propertyCounter == 0) {
			throw new SyncException(SyncException.METHOD_UNSUPPORTED, SyncException.METHOD_UNSUPPORTED_CODE);
		}
		
		return executeSelectWithParams(sql, paramValues.toArray(), shellOnly);		
	}
	
	@Override
	protected String getUpdateCallableStatementSql() {
		return "{call UPDATE_CORRECTIVE_ACTION(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	}
	@Override
	protected String getInsertCallableStatementSql() {
		return "{call CREATE_CORRECTIVE_ACTION(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	}
	@Override
	protected String getDeleteCallableStatementSql() {
		return "{call Delete_CORRECTIVE_ACTION(?)}";
	}
	
	
public CorrectiveAction createObject(CorrectiveAction perceroObject, String userId)
		throws SyncException {
	if ( !hasCreateAccess(BaseDataObject.toClassIdPair(perceroObject), userId) ) {
		return null;
	}

	long timeStart = System.currentTimeMillis();

	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	String query = "Select CORRECTIVE_ACTION_SEQ.NEXTVAL from dual";
	String sql = null;
	String insertedId = "0";
	int result = 0;
	try {
		IConnectionFactory connectionFactory = getConnectionRegistry().getConnectionFactory(getConnectionFactoryName());
		conn = connectionFactory.getConnection();
		conn.setAutoCommit(false);
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			insertedId = rs.getString(1);
		}

		perceroObject.setID(insertedId);
		sql = getInsertIntoSQL();
		pstmt = conn.prepareStatement(sql);


		setPreparedStatmentInsertParams(perceroObject, pstmt);
		result = pstmt.executeUpdate();
		conn.commit();
	} catch(Exception e) {
		log.error("Unable to executeUpdate\n" + sql, e);
		throw new SyncDataException(e);
	} finally {
		try {
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.setAutoCommit(true);
				conn.close();
			}
		} catch (Exception e) {
			log.error("Error closing database statement/connection", e);
		}
	}

	long timeEnd = System.currentTimeMillis();
	long totalTime = timeEnd - timeStart;
	if (totalTime > LONG_RUNNING_QUERY_TIME) {
		log.warn("LONG RUNNING QUERY: " + totalTime + "ms\n" + sql);
	}

	if (result > 0) {
		return retrieveObject(BaseDataObject.toClassIdPair(perceroObject), userId, false);
	}
	else {
		return null;
	}
}


	
	
}
