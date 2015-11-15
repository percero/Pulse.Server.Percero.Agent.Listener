

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
	public static final String SQL_VIEW = ",\"CORRECTIVE_ACTION\".\"ATTACHMENT_NAME\",\"CORRECTIVE_ACTION\".\"DETAILS\",\"CORRECTIVE_ACTION\".\"DETAILS_CONFIG\",\"CORRECTIVE_ACTION\".\"EMPLOYEE_ACK\",\"CORRECTIVE_ACTION\".\"EMPLOYEE_COMMENT\",\"CORRECTIVE_ACTION\".\"CREATED_ON\",\"CORRECTIVE_ACTION\".\"EXPIRE_DATE\",\"CORRECTIVE_ACTION\".\"HR_APPROVAL_DATE\",\"CORRECTIVE_ACTION\".\"MANAGER_APPROVAL_DATE\",\"CORRECTIVE_ACTION\".\"SUPERVISOR_ACK_DATE\",\"CORRECTIVE_ACTION\".\"COMPLETION_DATE\",\"CORRECTIVE_ACTION\".\"ATTACHMENT_ID\",\"CORRECTIVE_ACTION\".\"CLIENT_ID\",\"CORRECTIVE_ACTION\".\"DISCIPLINE_TYPE\",\"CORRECTIVE_ACTION\".\"FORM_ID\",\"CORRECTIVE_ACTION\".\"SESSION_ID\",\"CORRECTIVE_ACTION\".\"METRIC_REF\",\"CORRECTIVE_ACTION\".\"NEXT_STEPS\",\"CORRECTIVE_ACTION\".\"PROGRAM\",\"CORRECTIVE_ACTION\".\"REASON\",\"CORRECTIVE_ACTION\".\"REASON_TYPE\",\"CORRECTIVE_ACTION\".\"SUPERVISOR_COMMENT\",\"CORRECTIVE_ACTION\".\"SUPERVISOR_CONFIG\",\"CORRECTIVE_ACTION\".\"SUPERVISOR_ID\",\"CORRECTIVE_ACTION\".\"SUPERVISOR_MANAGER_EMPLOYEE_ID\",\"CORRECTIVE_ACTION\".\"AGENT_ID\",\"CORRECTIVE_ACTION\".\"HR_EMPLOYEE_ID\",\"CORRECTIVE_ACTION\".\"MANAGER_EMPLOYEE_ID\",\"CORRECTIVE_ACTION\".\"CORRECTIVE_ACTION_STATE_ID\",\"CORRECTIVE_ACTION\".\"CORRECTIVE_ACTION_TYPE_ID\"";
	private String selectFromStatementTableName = " FROM \"CORRECTIVE_ACTION\" \"CORRECTIVE_ACTION\"";
	private String whereClause = "  WHERE \"CORRECTIVE_ACTION\".\"ID\"=?";
	private String whereInClause = "  join table(sys.dbms_debug_vc2coll(?)) SQLLIST on \"CORRECTIVE_ACTION\".\"ID\"= SQLLIST.column_value";
	private String orderByTableName = "  ORDER BY \"CORRECTIVE_ACTION\".\"CREATED_ON\" DESC";
	
	

	
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

		return "SELECT \"CORRECTIVE_ACTION\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + " WHERE \"CORRECTIVE_ACTION\"." + joinColumnName + "=?" + orderByTableName;
	}

	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName)
	{

		return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName + " WHERE \"CORRECTIVE_ACTION\"." + joinColumnName + "=?" + orderByTableName;
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
		return "INSERT INTO TBL_CORRECTIVE_ACTION (\"ID\",\"ATTACHMENT_NAME\",\"DETAILS\",\"DETAILS_CONFIG\",\"EMPLOYEE_ACK\",\"EMPLOYEE_COMMENT\",\"CREATED_ON\",\"EXPIRE_DATE\",\"HR_APPROVAL_DATE\",\"MANAGER_APPROVAL_DATE\",\"SUPERVISOR_ACK_DATE\",\"COMPLETION_DATE\",\"ATTACHMENT_ID\",\"CLIENT_ID\",\"DISCIPLINE_TYPE\",\"FORM_ID\",\"SESSION_ID\",\"METRIC_REF\",\"NEXT_STEPS\",\"PROGRAM\",\"REASON\",\"REASON_TYPE\",\"SUPERVISOR_COMMENT\",\"SUPERVISOR_CONFIG\",\"SUPERVISOR_ID\",\"SUPERVISOR_MANAGER_EMPLOYEE_ID\",\"AGENT_ID\",\"HR_EMPLOYEE_ID\",\"MANAGER_EMPLOYEE_ID\",\"CORRECTIVE_ACTION_STATE_ID\",\"CORRECTIVE_ACTION_TYPE_ID\") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE TBL_CORRECTIVE_ACTION SET \"ATTACHMENT_NAME\"=?,\"DETAILS\"=?,\"DETAILS_CONFIG\"=?,\"EMPLOYEE_ACK\"=?,\"EMPLOYEE_COMMENT\"=?,\"CREATED_ON\"=?,\"EXPIRE_DATE\"=?,\"HR_APPROVAL_DATE\"=?,\"MANAGER_APPROVAL_DATE\"=?,\"SUPERVISOR_ACK_DATE\"=?,\"COMPLETION_DATE\"=?,\"ATTACHMENT_ID\"=?,\"CLIENT_ID\"=?,\"DISCIPLINE_TYPE\"=?,\"FORM_ID\"=?,\"SESSION_ID\"=?,\"METRIC_REF\"=?,\"NEXT_STEPS\"=?,\"PROGRAM\"=?,\"REASON\"=?,\"REASON_TYPE\"=?,\"SUPERVISOR_COMMENT\"=?,\"SUPERVISOR_CONFIG\"=?,\"SUPERVISOR_ID\"=?,\"SUPERVISOR_MANAGER_EMPLOYEE_ID\"=?,\"AGENT_ID\"=?,\"HR_EMPLOYEE_ID\"=?,\"MANAGER_EMPLOYEE_ID\"=?,\"CORRECTIVE_ACTION_STATE_ID\"=?,\"CORRECTIVE_ACTION_TYPE_ID\"=? WHERE \"ID\"=?";
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
			nextResult.setAttachmentName(rs.getString("ATTACHMENT_NAME"));


nextResult.setDetails(rs.getString("DETAILS"));


nextResult.setDetailsConfig(rs.getString("DETAILS_CONFIG"));


nextResult.setEmployeeAck(rs.getString("EMPLOYEE_ACK"));


nextResult.setEmployeeComment(rs.getString("EMPLOYEE_COMMENT"));


nextResult.setCreatedOn(DateUtils.utilDateFromSqlTimestamp(rs.getTimestamp("CREATED_ON")));


nextResult.setExpireDate(DateUtils.utilDateFromSqlTimestamp(rs.getTimestamp("EXPIRE_DATE")));


nextResult.setHRApprovalDate(DateUtils.utilDateFromSqlTimestamp(rs.getTimestamp("HR_APPROVAL_DATE")));


nextResult.setManagerApprovalDate(DateUtils.utilDateFromSqlTimestamp(rs.getTimestamp("MANAGER_APPROVAL_DATE")));


nextResult.setSupervisorACKDate(DateUtils.utilDateFromSqlTimestamp(rs.getTimestamp("SUPERVISOR_ACK_DATE")));


nextResult.setCompletionDate(DateUtils.utilDateFromSqlTimestamp(rs.getTimestamp("COMPLETION_DATE")));


nextResult.setAttachmentId(rs.getInt("ATTACHMENT_ID"));


nextResult.setClientId(rs.getInt("CLIENT_ID"));


nextResult.setDisciplineType(rs.getInt("DISCIPLINE_TYPE"));


nextResult.setFormId(rs.getInt("FORM_ID"));


nextResult.setSessionId(rs.getInt("SESSION_ID"));


nextResult.setMetricRef(rs.getString("METRIC_REF"));


nextResult.setNextSteps(rs.getString("NEXT_STEPS"));


nextResult.setProgram(rs.getString("PROGRAM"));


nextResult.setReason(rs.getString("REASON"));


nextResult.setReasonType(rs.getString("REASON_TYPE"));


nextResult.setSupervisorComment(rs.getString("SUPERVISOR_COMMENT"));


nextResult.setSupervisorConfig(rs.getString("SUPERVISOR_CONFIG"));


String supervisorID = rs.getString("SUPERVISOR_ID");
if (StringUtils.hasText(supervisorID) && !"null".equalsIgnoreCase(supervisorID) ){
Supervisor supervisor = new Supervisor();
supervisor.setID(supervisorID);
nextResult.setSupervisor(supervisor);
}


String supervisormanageremployeeID = rs.getString("SUPERVISOR_MANAGER_EMPLOYEE_ID");
if (StringUtils.hasText(supervisormanageremployeeID) && !"null".equalsIgnoreCase(supervisormanageremployeeID) ){
Employee supervisormanageremployee = new Employee();
supervisormanageremployee.setID(supervisormanageremployeeID);
nextResult.setSupervisorManagerEmployee(supervisormanageremployee);
}


String agentID = rs.getString("AGENT_ID");
if (StringUtils.hasText(agentID) && !"null".equalsIgnoreCase(agentID) ){
Agent agent = new Agent();
agent.setID(agentID);
nextResult.setAgent(agent);
}


String hremployeeID = rs.getString("HR_EMPLOYEE_ID");
if (StringUtils.hasText(hremployeeID) && !"null".equalsIgnoreCase(hremployeeID) ){
Employee hremployee = new Employee();
hremployee.setID(hremployeeID);
nextResult.setHREmployee(hremployee);
}


String manageremployeeID = rs.getString("MANAGER_EMPLOYEE_ID");
if (StringUtils.hasText(manageremployeeID) && !"null".equalsIgnoreCase(manageremployeeID) ){
Employee manageremployee = new Employee();
manageremployee.setID(manageremployeeID);
nextResult.setManagerEmployee(manageremployee);
}


String correctiveactionstateID = rs.getString("CORRECTIVE_ACTION_STATE_ID");
if (StringUtils.hasText(correctiveactionstateID) && !"null".equalsIgnoreCase(correctiveactionstateID) ){
CorrectiveActionState correctiveactionstate = new CorrectiveActionState();
correctiveactionstate.setID(correctiveactionstateID);
nextResult.setCorrectiveActionState(correctiveactionstate);
}


String correctiveactiontypeID = rs.getString("CORRECTIVE_ACTION_TYPE_ID");
if (StringUtils.hasText(correctiveactiontypeID) && !"null".equalsIgnoreCase(correctiveactiontypeID) ){
CorrectiveActionType correctiveactiontype = new CorrectiveActionType();
correctiveactiontype.setID(correctiveactiontypeID);
nextResult.setCorrectiveActionType(correctiveactiontype);
}



			
    	}
		
		
    	return nextResult;
	}
	
	protected void setBaseStatmentInsertParams(CorrectiveAction perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getAttachmentName());
pstmt.setString(3, perceroObject.getDetails());
pstmt.setString(4, perceroObject.getDetailsConfig());
pstmt.setString(5, perceroObject.getEmployeeAck());
pstmt.setString(6, perceroObject.getEmployeeComment());
pstmt.setDate(7, DateUtils.utilDateToSqlDate(perceroObject.getCreatedOn()));
pstmt.setDate(8, DateUtils.utilDateToSqlDate(perceroObject.getExpireDate()));
pstmt.setDate(9, DateUtils.utilDateToSqlDate(perceroObject.getHRApprovalDate()));
pstmt.setDate(10, DateUtils.utilDateToSqlDate(perceroObject.getManagerApprovalDate()));
pstmt.setDate(11, DateUtils.utilDateToSqlDate(perceroObject.getSupervisorACKDate()));
pstmt.setDate(12, DateUtils.utilDateToSqlDate(perceroObject.getCompletionDate()));
JdbcHelper.setInt(pstmt,13, perceroObject.getAttachmentId());
JdbcHelper.setInt(pstmt,14, perceroObject.getClientId());
JdbcHelper.setInt(pstmt,15, perceroObject.getDisciplineType());
JdbcHelper.setInt(pstmt,16, perceroObject.getFormId());
JdbcHelper.setInt(pstmt,17, perceroObject.getSessionId());
pstmt.setString(18, perceroObject.getMetricRef());
pstmt.setString(19, perceroObject.getNextSteps());
pstmt.setString(20, perceroObject.getProgram());
pstmt.setString(21, perceroObject.getReason());
pstmt.setString(22, perceroObject.getReasonType());
pstmt.setString(23, perceroObject.getSupervisorComment());
pstmt.setString(24, perceroObject.getSupervisorConfig());

if (perceroObject.getSupervisor() == null)
{
pstmt.setString(25, null);
}
else
{
		pstmt.setString(25, perceroObject.getSupervisor().getID());
}


if (perceroObject.getSupervisorManagerEmployee() == null)
{
pstmt.setString(26, null);
}
else
{
		pstmt.setString(26, perceroObject.getSupervisorManagerEmployee().getID());
}


if (perceroObject.getAgent() == null)
{
pstmt.setString(27, null);
}
else
{
		pstmt.setString(27, perceroObject.getAgent().getID());
}


if (perceroObject.getHREmployee() == null)
{
pstmt.setString(28, null);
}
else
{
		pstmt.setString(28, perceroObject.getHREmployee().getID());
}


if (perceroObject.getManagerEmployee() == null)
{
pstmt.setString(29, null);
}
else
{
		pstmt.setString(29, perceroObject.getManagerEmployee().getID());
}


if (perceroObject.getCorrectiveActionState() == null)
{
pstmt.setString(30, null);
}
else
{
		pstmt.setString(30, perceroObject.getCorrectiveActionState().getID());
}


if (perceroObject.getCorrectiveActionType() == null)
{
pstmt.setString(31, null);
}
else
{
		pstmt.setString(31, perceroObject.getCorrectiveActionType().getID());
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
		
		pstmt.setString(1, perceroObject.getAttachmentName());
pstmt.setString(2, perceroObject.getDetails());
pstmt.setString(3, perceroObject.getDetailsConfig());
pstmt.setString(4, perceroObject.getEmployeeAck());
pstmt.setString(5, perceroObject.getEmployeeComment());
pstmt.setDate(6, DateUtils.utilDateToSqlDate(perceroObject.getCreatedOn()));
pstmt.setDate(7, DateUtils.utilDateToSqlDate(perceroObject.getExpireDate()));
pstmt.setDate(8, DateUtils.utilDateToSqlDate(perceroObject.getHRApprovalDate()));
pstmt.setDate(9, DateUtils.utilDateToSqlDate(perceroObject.getManagerApprovalDate()));
pstmt.setDate(10, DateUtils.utilDateToSqlDate(perceroObject.getSupervisorACKDate()));
pstmt.setDate(11, DateUtils.utilDateToSqlDate(perceroObject.getCompletionDate()));
JdbcHelper.setInt(pstmt,12, perceroObject.getAttachmentId());
JdbcHelper.setInt(pstmt,13, perceroObject.getClientId());
JdbcHelper.setInt(pstmt,14, perceroObject.getDisciplineType());
JdbcHelper.setInt(pstmt,15, perceroObject.getFormId());
JdbcHelper.setInt(pstmt,16, perceroObject.getSessionId());
pstmt.setString(17, perceroObject.getMetricRef());
pstmt.setString(18, perceroObject.getNextSteps());
pstmt.setString(19, perceroObject.getProgram());
pstmt.setString(20, perceroObject.getReason());
pstmt.setString(21, perceroObject.getReasonType());
pstmt.setString(22, perceroObject.getSupervisorComment());
pstmt.setString(23, perceroObject.getSupervisorConfig());

if (perceroObject.getSupervisor() == null)
{
pstmt.setString(24, null);
}
else
{
		pstmt.setString(24, perceroObject.getSupervisor().getID());
}


if (perceroObject.getSupervisorManagerEmployee() == null)
{
pstmt.setString(25, null);
}
else
{
		pstmt.setString(25, perceroObject.getSupervisorManagerEmployee().getID());
}


if (perceroObject.getAgent() == null)
{
pstmt.setString(26, null);
}
else
{
		pstmt.setString(26, perceroObject.getAgent().getID());
}


if (perceroObject.getHREmployee() == null)
{
pstmt.setString(27, null);
}
else
{
		pstmt.setString(27, perceroObject.getHREmployee().getID());
}


if (perceroObject.getManagerEmployee() == null)
{
pstmt.setString(28, null);
}
else
{
		pstmt.setString(28, perceroObject.getManagerEmployee().getID());
}


if (perceroObject.getCorrectiveActionState() == null)
{
pstmt.setString(29, null);
}
else
{
		pstmt.setString(29, perceroObject.getCorrectiveActionState().getID());
}


if (perceroObject.getCorrectiveActionType() == null)
{
pstmt.setString(30, null);
}
else
{
		pstmt.setString(30, perceroObject.getCorrectiveActionType().getID());
}

pstmt.setString(31, perceroObject.getID());

		
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
		
		boolean useAttachmentName = StringUtils.hasText(theQueryObject.getAttachmentName()) && (excludeProperties == null || !excludeProperties.contains("attachmentName"));

if (useAttachmentName)
{
sql += " WHERE ";
sql += " \"ATTACHMENT_NAME\" =? ";
paramValues.add(theQueryObject.getAttachmentName());
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

boolean useDetailsConfig = StringUtils.hasText(theQueryObject.getDetailsConfig()) && (excludeProperties == null || !excludeProperties.contains("detailsConfig"));

if (useDetailsConfig)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"DETAILS_CONFIG\" =? ";
paramValues.add(theQueryObject.getDetailsConfig());
propertyCounter++;
}

boolean useEmployeeAck = StringUtils.hasText(theQueryObject.getEmployeeAck()) && (excludeProperties == null || !excludeProperties.contains("employeeAck"));

if (useEmployeeAck)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"EMPLOYEE_ACK\" =? ";
paramValues.add(theQueryObject.getEmployeeAck());
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

boolean useCreatedOn = theQueryObject.getCreatedOn() != null && (excludeProperties == null || !excludeProperties.contains("createdOn"));

if (useCreatedOn)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"CREATED_ON\" =? ";
paramValues.add(theQueryObject.getCreatedOn());
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

boolean useAttachmentId = theQueryObject.getAttachmentId() != null && (excludeProperties == null || !excludeProperties.contains("attachmentId"));

if (useAttachmentId)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"ATTACHMENT_ID\" =? ";
paramValues.add(theQueryObject.getAttachmentId());
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

boolean useReasonType = StringUtils.hasText(theQueryObject.getReasonType()) && (excludeProperties == null || !excludeProperties.contains("reasonType"));

if (useReasonType)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"REASON_TYPE\" =? ";
paramValues.add(theQueryObject.getReasonType());
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

boolean useSupervisorConfig = StringUtils.hasText(theQueryObject.getSupervisorConfig()) && (excludeProperties == null || !excludeProperties.contains("supervisorConfig"));

if (useSupervisorConfig)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"SUPERVISOR_CONFIG\" =? ";
paramValues.add(theQueryObject.getSupervisorConfig());
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
		return "{call UPDATE_CORRECTIVE_ACTION(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	}
	@Override
	protected String getInsertCallableStatementSql() {
		return "{call CREATE_CORRECTIVE_ACTION(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
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

