
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
import com.pulse.mo.CorrectiveAction;
import com.pulse.mo.CorrectiveActionState;
import com.pulse.mo.CorrectiveActionType;
import com.pulse.mo.Agent;
import com.pulse.mo.EmployeeAcknowledgement;
import com.pulse.mo.HRApproval;
import com.pulse.mo.ManagerApproval;
import com.pulse.mo.SupervisorAcknowledgement;

*/

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
	
	
	
	@Override
	protected String getConnectionFactoryName() {
		return CorrectiveActionDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT \"CORRECTIVE_ACTION\".\"ID\" FROM \"CORRECTIVE_ACTION\" \"CORRECTIVE_ACTION\" WHERE \"CORRECTIVE_ACTION\".\"ID\"=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT \"CORRECTIVE_ACTION\".\"ID\",\"CORRECTIVE_ACTION\".\"CORRECTIVE_ACTION_STATE_NAME\",\"CORRECTIVE_ACTION\".\"CORRECTIVE_ACTION_TYPE_NAME\",\"CORRECTIVE_ACTION\".\"DETAILS\",\"CORRECTIVE_ACTION\".\"EMPLOYEE_COMMENT\",\"CORRECTIVE_ACTION\".\"MESSAGE\",\"CORRECTIVE_ACTION\".\"MESSAGE_REASON\",\"CORRECTIVE_ACTION\".\"NEXT_STEPS_MESSAGE\",\"CORRECTIVE_ACTION\".\"AGENT_EMPLOYEE_ID\",\"CORRECTIVE_ACTION\".\"AGENT_FIRST_NAME\",\"CORRECTIVE_ACTION\".\"AGENT_LAST_NAME\",\"CORRECTIVE_ACTION\".\"COMPLETION_DATE\",\"CORRECTIVE_ACTION\".\"COMPLETION_STATUS\",\"CORRECTIVE_ACTION\".\"LOB_NAME\",\"CORRECTIVE_ACTION\".\"SUPERVISOR_COMMENT\",\"CORRECTIVE_ACTION\".\"SUPERVISOR_NAME\",\"CORRECTIVE_ACTION\".\"MANAGER_APPROVAL_ID\",\"CORRECTIVE_ACTION\".\"CORRECTIVE_ACTION_STATE_ID\",\"CORRECTIVE_ACTION\".\"AGENT_ID\",\"CORRECTIVE_ACTION\".\"CORRECTIVE_ACTION_TYPE_ID\",\"CORRECTIVE_ACTION\".\"SUPERVISOR_ACKNOWLEDGEMENT_ID\",\"CORRECTIVE_ACTION\".\"HR_APPROVAL_ID\",\"CORRECTIVE_ACTION\".\"EMPLOYEE_ACKNOWLEDGEMENT_ID\" FROM \"CORRECTIVE_ACTION\" \"CORRECTIVE_ACTION\" WHERE \"CORRECTIVE_ACTION\".\"ID\"=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT \"CORRECTIVE_ACTION\".\"ID\" FROM \"CORRECTIVE_ACTION\" \"CORRECTIVE_ACTION\" ORDER BY \"ID\"";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT \"CORRECTIVE_ACTION\".\"ID\" FROM \"CORRECTIVE_ACTION\" \"CORRECTIVE_ACTION\" ORDER BY \"CORRECTIVE_ACTION\".\"ID\" LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT \"CORRECTIVE_ACTION\".\"ID\",\"CORRECTIVE_ACTION\".\"CORRECTIVE_ACTION_STATE_NAME\",\"CORRECTIVE_ACTION\".\"CORRECTIVE_ACTION_TYPE_NAME\",\"CORRECTIVE_ACTION\".\"DETAILS\",\"CORRECTIVE_ACTION\".\"EMPLOYEE_COMMENT\",\"CORRECTIVE_ACTION\".\"MESSAGE\",\"CORRECTIVE_ACTION\".\"MESSAGE_REASON\",\"CORRECTIVE_ACTION\".\"NEXT_STEPS_MESSAGE\",\"CORRECTIVE_ACTION\".\"AGENT_EMPLOYEE_ID\",\"CORRECTIVE_ACTION\".\"AGENT_FIRST_NAME\",\"CORRECTIVE_ACTION\".\"AGENT_LAST_NAME\",\"CORRECTIVE_ACTION\".\"COMPLETION_DATE\",\"CORRECTIVE_ACTION\".\"COMPLETION_STATUS\",\"CORRECTIVE_ACTION\".\"LOB_NAME\",\"CORRECTIVE_ACTION\".\"SUPERVISOR_COMMENT\",\"CORRECTIVE_ACTION\".\"SUPERVISOR_NAME\",\"CORRECTIVE_ACTION\".\"MANAGER_APPROVAL_ID\",\"CORRECTIVE_ACTION\".\"CORRECTIVE_ACTION_STATE_ID\",\"CORRECTIVE_ACTION\".\"AGENT_ID\",\"CORRECTIVE_ACTION\".\"CORRECTIVE_ACTION_TYPE_ID\",\"CORRECTIVE_ACTION\".\"SUPERVISOR_ACKNOWLEDGEMENT_ID\",\"CORRECTIVE_ACTION\".\"HR_APPROVAL_ID\",\"CORRECTIVE_ACTION\".\"EMPLOYEE_ACKNOWLEDGEMENT_ID\" FROM \"CORRECTIVE_ACTION\" \"CORRECTIVE_ACTION\" ORDER BY \"CORRECTIVE_ACTION\".\"ID\"";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT \"CORRECTIVE_ACTION\".\"ID\",\"CORRECTIVE_ACTION\".\"CORRECTIVE_ACTION_STATE_NAME\",\"CORRECTIVE_ACTION\".\"CORRECTIVE_ACTION_TYPE_NAME\",\"CORRECTIVE_ACTION\".\"DETAILS\",\"CORRECTIVE_ACTION\".\"EMPLOYEE_COMMENT\",\"CORRECTIVE_ACTION\".\"MESSAGE\",\"CORRECTIVE_ACTION\".\"MESSAGE_REASON\",\"CORRECTIVE_ACTION\".\"NEXT_STEPS_MESSAGE\",\"CORRECTIVE_ACTION\".\"AGENT_EMPLOYEE_ID\",\"CORRECTIVE_ACTION\".\"AGENT_FIRST_NAME\",\"CORRECTIVE_ACTION\".\"AGENT_LAST_NAME\",\"CORRECTIVE_ACTION\".\"COMPLETION_DATE\",\"CORRECTIVE_ACTION\".\"COMPLETION_STATUS\",\"CORRECTIVE_ACTION\".\"LOB_NAME\",\"CORRECTIVE_ACTION\".\"SUPERVISOR_COMMENT\",\"CORRECTIVE_ACTION\".\"SUPERVISOR_NAME\",\"CORRECTIVE_ACTION\".\"MANAGER_APPROVAL_ID\",\"CORRECTIVE_ACTION\".\"CORRECTIVE_ACTION_STATE_ID\",\"CORRECTIVE_ACTION\".\"AGENT_ID\",\"CORRECTIVE_ACTION\".\"CORRECTIVE_ACTION_TYPE_ID\",\"CORRECTIVE_ACTION\".\"SUPERVISOR_ACKNOWLEDGEMENT_ID\",\"CORRECTIVE_ACTION\".\"HR_APPROVAL_ID\",\"CORRECTIVE_ACTION\".\"EMPLOYEE_ACKNOWLEDGEMENT_ID\" FROM \"CORRECTIVE_ACTION\" \"CORRECTIVE_ACTION\" ORDER BY \"CORRECTIVE_ACTION\".\"ID\" LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM \"CORRECTIVE_ACTION\" \"CORRECTIVE_ACTION\"";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT \"CORRECTIVE_ACTION\".\"ID\",\"CORRECTIVE_ACTION\".\"CORRECTIVE_ACTION_STATE_NAME\",\"CORRECTIVE_ACTION\".\"CORRECTIVE_ACTION_TYPE_NAME\",\"CORRECTIVE_ACTION\".\"DETAILS\",\"CORRECTIVE_ACTION\".\"EMPLOYEE_COMMENT\",\"CORRECTIVE_ACTION\".\"MESSAGE\",\"CORRECTIVE_ACTION\".\"MESSAGE_REASON\",\"CORRECTIVE_ACTION\".\"NEXT_STEPS_MESSAGE\",\"CORRECTIVE_ACTION\".\"AGENT_EMPLOYEE_ID\",\"CORRECTIVE_ACTION\".\"AGENT_FIRST_NAME\",\"CORRECTIVE_ACTION\".\"AGENT_LAST_NAME\",\"CORRECTIVE_ACTION\".\"COMPLETION_DATE\",\"CORRECTIVE_ACTION\".\"COMPLETION_STATUS\",\"CORRECTIVE_ACTION\".\"LOB_NAME\",\"CORRECTIVE_ACTION\".\"SUPERVISOR_COMMENT\",\"CORRECTIVE_ACTION\".\"SUPERVISOR_NAME\",\"CORRECTIVE_ACTION\".\"MANAGER_APPROVAL_ID\",\"CORRECTIVE_ACTION\".\"CORRECTIVE_ACTION_STATE_ID\",\"CORRECTIVE_ACTION\".\"AGENT_ID\",\"CORRECTIVE_ACTION\".\"CORRECTIVE_ACTION_TYPE_ID\",\"CORRECTIVE_ACTION\".\"SUPERVISOR_ACKNOWLEDGEMENT_ID\",\"CORRECTIVE_ACTION\".\"HR_APPROVAL_ID\",\"CORRECTIVE_ACTION\".\"EMPLOYEE_ACKNOWLEDGEMENT_ID\" FROM \"CORRECTIVE_ACTION\" \"CORRECTIVE_ACTION\" WHERE \"CORRECTIVE_ACTION\".\"ID\" IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT \"CORRECTIVE_ACTION\".\"ID\" FROM \"CORRECTIVE_ACTION\" \"CORRECTIVE_ACTION\" WHERE \"CORRECTIVE_ACTION\".\"ID\" IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		return "SELECT \"CORRECTIVE_ACTION\".\"ID\",\"CORRECTIVE_ACTION\".\"CORRECTIVE_ACTION_STATE_NAME\",\"CORRECTIVE_ACTION\".\"CORRECTIVE_ACTION_TYPE_NAME\",\"CORRECTIVE_ACTION\".\"DETAILS\",\"CORRECTIVE_ACTION\".\"EMPLOYEE_COMMENT\",\"CORRECTIVE_ACTION\".\"MESSAGE\",\"CORRECTIVE_ACTION\".\"MESSAGE_REASON\",\"CORRECTIVE_ACTION\".\"NEXT_STEPS_MESSAGE\",\"CORRECTIVE_ACTION\".\"AGENT_EMPLOYEE_ID\",\"CORRECTIVE_ACTION\".\"AGENT_FIRST_NAME\",\"CORRECTIVE_ACTION\".\"AGENT_LAST_NAME\",\"CORRECTIVE_ACTION\".\"COMPLETION_DATE\",\"CORRECTIVE_ACTION\".\"COMPLETION_STATUS\",\"CORRECTIVE_ACTION\".\"LOB_NAME\",\"CORRECTIVE_ACTION\".\"SUPERVISOR_COMMENT\",\"CORRECTIVE_ACTION\".\"SUPERVISOR_NAME\",\"CORRECTIVE_ACTION\".\"MANAGER_APPROVAL_ID\",\"CORRECTIVE_ACTION\".\"CORRECTIVE_ACTION_STATE_ID\",\"CORRECTIVE_ACTION\".\"AGENT_ID\",\"CORRECTIVE_ACTION\".\"CORRECTIVE_ACTION_TYPE_ID\",\"CORRECTIVE_ACTION\".\"SUPERVISOR_ACKNOWLEDGEMENT_ID\",\"CORRECTIVE_ACTION\".\"HR_APPROVAL_ID\",\"CORRECTIVE_ACTION\".\"EMPLOYEE_ACKNOWLEDGEMENT_ID\" FROM \"CORRECTIVE_ACTION\" \"CORRECTIVE_ACTION\" WHERE \"CORRECTIVE_ACTION\"." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT \"CORRECTIVE_ACTION\".\"ID\" FROM \"CORRECTIVE_ACTION\" \"CORRECTIVE_ACTION\" WHERE \"CORRECTIVE_ACTION\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT \"CORRECTIVE_ACTION\".\"ID\" FROM \"CORRECTIVE_ACTION\" \"CORRECTIVE_ACTION\" ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT \"CORRECTIVE_ACTION\".\"ID\",\"CORRECTIVE_ACTION\".\"CORRECTIVE_ACTION_STATE_NAME\",\"CORRECTIVE_ACTION\".\"CORRECTIVE_ACTION_TYPE_NAME\",\"CORRECTIVE_ACTION\".\"DETAILS\",\"CORRECTIVE_ACTION\".\"EMPLOYEE_COMMENT\",\"CORRECTIVE_ACTION\".\"MESSAGE\",\"CORRECTIVE_ACTION\".\"MESSAGE_REASON\",\"CORRECTIVE_ACTION\".\"NEXT_STEPS_MESSAGE\",\"CORRECTIVE_ACTION\".\"AGENT_EMPLOYEE_ID\",\"CORRECTIVE_ACTION\".\"AGENT_FIRST_NAME\",\"CORRECTIVE_ACTION\".\"AGENT_LAST_NAME\",\"CORRECTIVE_ACTION\".\"COMPLETION_DATE\",\"CORRECTIVE_ACTION\".\"COMPLETION_STATUS\",\"CORRECTIVE_ACTION\".\"LOB_NAME\",\"CORRECTIVE_ACTION\".\"SUPERVISOR_COMMENT\",\"CORRECTIVE_ACTION\".\"SUPERVISOR_NAME\",\"CORRECTIVE_ACTION\".\"MANAGER_APPROVAL_ID\",\"CORRECTIVE_ACTION\".\"CORRECTIVE_ACTION_STATE_ID\",\"CORRECTIVE_ACTION\".\"AGENT_ID\",\"CORRECTIVE_ACTION\".\"CORRECTIVE_ACTION_TYPE_ID\",\"CORRECTIVE_ACTION\".\"SUPERVISOR_ACKNOWLEDGEMENT_ID\",\"CORRECTIVE_ACTION\".\"HR_APPROVAL_ID\",\"CORRECTIVE_ACTION\".\"EMPLOYEE_ACKNOWLEDGEMENT_ID\" FROM \"CORRECTIVE_ACTION\" \"CORRECTIVE_ACTION\" ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO CORRECTIVE_ACTION (\"ID\",\"CORRECTIVE_ACTION_STATE_NAME\",\"CORRECTIVE_ACTION_TYPE_NAME\",\"DETAILS\",\"EMPLOYEE_COMMENT\",\"MESSAGE\",\"MESSAGE_REASON\",\"NEXT_STEPS_MESSAGE\",\"AGENT_EMPLOYEE_ID\",\"AGENT_FIRST_NAME\",\"AGENT_LAST_NAME\",\"COMPLETION_DATE\",\"COMPLETION_STATUS\",\"LOB_NAME\",\"SUPERVISOR_COMMENT\",\"SUPERVISOR_NAME\",\"MANAGER_APPROVAL_ID\",\"CORRECTIVE_ACTION_STATE_ID\",\"AGENT_ID\",\"CORRECTIVE_ACTION_TYPE_ID\",\"SUPERVISOR_ACKNOWLEDGEMENT_ID\",\"HR_APPROVAL_ID\",\"EMPLOYEE_ACKNOWLEDGEMENT_ID\") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE \"CORRECTIVE_ACTION\" SET \"CORRECTIVE_ACTION_STATE_NAME\"=?,\"CORRECTIVE_ACTION_TYPE_NAME\"=?,\"DETAILS\"=?,\"EMPLOYEE_COMMENT\"=?,\"MESSAGE\"=?,\"MESSAGE_REASON\"=?,\"NEXT_STEPS_MESSAGE\"=?,\"AGENT_EMPLOYEE_ID\"=?,\"AGENT_FIRST_NAME\"=?,\"AGENT_LAST_NAME\"=?,\"COMPLETION_DATE\"=?,\"COMPLETION_STATUS\"=?,\"LOB_NAME\"=?,\"SUPERVISOR_COMMENT\"=?,\"SUPERVISOR_NAME\"=?,\"MANAGER_APPROVAL_ID\"=?,\"CORRECTIVE_ACTION_STATE_ID\"=?,\"AGENT_ID\"=?,\"CORRECTIVE_ACTION_TYPE_ID\"=?,\"SUPERVISOR_ACKNOWLEDGEMENT_ID\"=?,\"HR_APPROVAL_ID\"=?,\"EMPLOYEE_ACKNOWLEDGEMENT_ID\"=? WHERE \"ID\"=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM \"CORRECTIVE_ACTION\" WHERE \"ID\"=?";
	}
	
	@Override
	protected CorrectiveAction extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	CorrectiveAction nextResult = new CorrectiveAction();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setCorrectiveActionStateName(rs.getString("CORRECTIVE_ACTION_STATE_NAME"));

nextResult.setCorrectiveActionTypeName(rs.getString("CORRECTIVE_ACTION_TYPE_NAME"));

nextResult.setDetails(rs.getString("DETAILS"));

nextResult.setEmployeeComment(rs.getString("EMPLOYEE_COMMENT"));

nextResult.setMessage(rs.getString("MESSAGE"));

nextResult.setMessageReason(rs.getString("MESSAGE_REASON"));

nextResult.setNextStepsMessage(rs.getString("NEXT_STEPS_MESSAGE"));

nextResult.setAgentEmployeeId(rs.getString("AGENT_EMPLOYEE_ID"));

nextResult.setAgentFirstName(rs.getString("AGENT_FIRST_NAME"));

nextResult.setAgentLastName(rs.getString("AGENT_LAST_NAME"));

nextResult.setCompletionDate(rs.getDate("COMPLETION_DATE"));

nextResult.setCompletionStatus(rs.getString("COMPLETION_STATUS"));

nextResult.setLOBName(rs.getString("LOB_NAME"));

nextResult.setSupervisorComment(rs.getString("SUPERVISOR_COMMENT"));

nextResult.setSupervisorName(rs.getString("SUPERVISOR_NAME"));

ManagerApproval managerapproval = new ManagerApproval();
managerapproval.setID(rs.getString("MANAGER_APPROVAL_ID"));
nextResult.setManagerApproval(managerapproval);

CorrectiveActionState correctiveactionstate = new CorrectiveActionState();
correctiveactionstate.setID(rs.getString("CORRECTIVE_ACTION_STATE_ID"));
nextResult.setCorrectiveActionState(correctiveactionstate);

Agent agent = new Agent();
agent.setID(rs.getString("AGENT_ID"));
nextResult.setAgent(agent);

CorrectiveActionType correctiveactiontype = new CorrectiveActionType();
correctiveactiontype.setID(rs.getString("CORRECTIVE_ACTION_TYPE_ID"));
nextResult.setCorrectiveActionType(correctiveactiontype);

SupervisorAcknowledgement supervisoracknowledgement = new SupervisorAcknowledgement();
supervisoracknowledgement.setID(rs.getString("SUPERVISOR_ACKNOWLEDGEMENT_ID"));
nextResult.setSupervisorAcknowledgement(supervisoracknowledgement);

HRApproval hrapproval = new HRApproval();
hrapproval.setID(rs.getString("HR_APPROVAL_ID"));
nextResult.setHRApproval(hrapproval);

EmployeeAcknowledgement employeeacknowledgement = new EmployeeAcknowledgement();
employeeacknowledgement.setID(rs.getString("EMPLOYEE_ACKNOWLEDGEMENT_ID"));
nextResult.setEmployeeAcknowledgement(employeeacknowledgement);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(CorrectiveAction perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getCorrectiveActionStateName());
pstmt.setString(3, perceroObject.getCorrectiveActionTypeName());
pstmt.setString(4, perceroObject.getDetails());
pstmt.setString(5, perceroObject.getEmployeeComment());
pstmt.setString(6, perceroObject.getMessage());
pstmt.setString(7, perceroObject.getMessageReason());
pstmt.setString(8, perceroObject.getNextStepsMessage());
pstmt.setString(9, perceroObject.getAgentEmployeeId());
pstmt.setString(10, perceroObject.getAgentFirstName());
pstmt.setString(11, perceroObject.getAgentLastName());
pstmt.setDate(12, DateUtils.utilDateToSqlDate(perceroObject.getCompletionDate()));
pstmt.setString(13, perceroObject.getCompletionStatus());
pstmt.setString(14, perceroObject.getLOBName());
pstmt.setString(15, perceroObject.getSupervisorComment());
pstmt.setString(16, perceroObject.getSupervisorName());

if (perceroObject.getManagerApproval() == null)
{
pstmt.setString(17, null);
}
else
{
		pstmt.setString(17, perceroObject.getManagerApproval().getID());
}


if (perceroObject.getCorrectiveActionState() == null)
{
pstmt.setString(18, null);
}
else
{
		pstmt.setString(18, perceroObject.getCorrectiveActionState().getID());
}


if (perceroObject.getAgent() == null)
{
pstmt.setString(19, null);
}
else
{
		pstmt.setString(19, perceroObject.getAgent().getID());
}


if (perceroObject.getCorrectiveActionType() == null)
{
pstmt.setString(20, null);
}
else
{
		pstmt.setString(20, perceroObject.getCorrectiveActionType().getID());
}


if (perceroObject.getSupervisorAcknowledgement() == null)
{
pstmt.setString(21, null);
}
else
{
		pstmt.setString(21, perceroObject.getSupervisorAcknowledgement().getID());
}


if (perceroObject.getHRApproval() == null)
{
pstmt.setString(22, null);
}
else
{
		pstmt.setString(22, perceroObject.getHRApproval().getID());
}


if (perceroObject.getEmployeeAcknowledgement() == null)
{
pstmt.setString(23, null);
}
else
{
		pstmt.setString(23, perceroObject.getEmployeeAcknowledgement().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(CorrectiveAction perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getCorrectiveActionStateName());
pstmt.setString(2, perceroObject.getCorrectiveActionTypeName());
pstmt.setString(3, perceroObject.getDetails());
pstmt.setString(4, perceroObject.getEmployeeComment());
pstmt.setString(5, perceroObject.getMessage());
pstmt.setString(6, perceroObject.getMessageReason());
pstmt.setString(7, perceroObject.getNextStepsMessage());
pstmt.setString(8, perceroObject.getAgentEmployeeId());
pstmt.setString(9, perceroObject.getAgentFirstName());
pstmt.setString(10, perceroObject.getAgentLastName());
pstmt.setDate(11, DateUtils.utilDateToSqlDate(perceroObject.getCompletionDate()));
pstmt.setString(12, perceroObject.getCompletionStatus());
pstmt.setString(13, perceroObject.getLOBName());
pstmt.setString(14, perceroObject.getSupervisorComment());
pstmt.setString(15, perceroObject.getSupervisorName());

if (perceroObject.getManagerApproval() == null)
{
pstmt.setString(16, null);
}
else
{
		pstmt.setString(16, perceroObject.getManagerApproval().getID());
}


if (perceroObject.getCorrectiveActionState() == null)
{
pstmt.setString(17, null);
}
else
{
		pstmt.setString(17, perceroObject.getCorrectiveActionState().getID());
}


if (perceroObject.getAgent() == null)
{
pstmt.setString(18, null);
}
else
{
		pstmt.setString(18, perceroObject.getAgent().getID());
}


if (perceroObject.getCorrectiveActionType() == null)
{
pstmt.setString(19, null);
}
else
{
		pstmt.setString(19, perceroObject.getCorrectiveActionType().getID());
}


if (perceroObject.getSupervisorAcknowledgement() == null)
{
pstmt.setString(20, null);
}
else
{
		pstmt.setString(20, perceroObject.getSupervisorAcknowledgement().getID());
}


if (perceroObject.getHRApproval() == null)
{
pstmt.setString(21, null);
}
else
{
		pstmt.setString(21, perceroObject.getHRApproval().getID());
}


if (perceroObject.getEmployeeAcknowledgement() == null)
{
pstmt.setString(22, null);
}
else
{
		pstmt.setString(22, perceroObject.getEmployeeAcknowledgement().getID());
}

pstmt.setString(23, perceroObject.getID());

		
	}

	@Override
	public List<CorrectiveAction> findByExample(CorrectiveAction theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useCorrectiveActionStateName = StringUtils.hasText(theQueryObject.getCorrectiveActionStateName()) && (excludeProperties == null || !excludeProperties.contains("correctiveActionStateName"));

if (useCorrectiveActionStateName)
{
sql += " WHERE ";
sql += " \"CORRECTIVE_ACTION_STATE_NAME\" =? ";
paramValues.add(theQueryObject.getCorrectiveActionStateName());
propertyCounter++;
}

boolean useCorrectiveActionTypeName = StringUtils.hasText(theQueryObject.getCorrectiveActionTypeName()) && (excludeProperties == null || !excludeProperties.contains("correctiveActionTypeName"));

if (useCorrectiveActionTypeName)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"CORRECTIVE_ACTION_TYPE_NAME\" =? ";
paramValues.add(theQueryObject.getCorrectiveActionTypeName());
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

boolean useMessage = StringUtils.hasText(theQueryObject.getMessage()) && (excludeProperties == null || !excludeProperties.contains("message"));

if (useMessage)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"MESSAGE\" =? ";
paramValues.add(theQueryObject.getMessage());
propertyCounter++;
}

boolean useMessageReason = StringUtils.hasText(theQueryObject.getMessageReason()) && (excludeProperties == null || !excludeProperties.contains("messageReason"));

if (useMessageReason)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"MESSAGE_REASON\" =? ";
paramValues.add(theQueryObject.getMessageReason());
propertyCounter++;
}

boolean useNextStepsMessage = StringUtils.hasText(theQueryObject.getNextStepsMessage()) && (excludeProperties == null || !excludeProperties.contains("nextStepsMessage"));

if (useNextStepsMessage)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"NEXT_STEPS_MESSAGE\" =? ";
paramValues.add(theQueryObject.getNextStepsMessage());
propertyCounter++;
}

boolean useAgentEmployeeId = StringUtils.hasText(theQueryObject.getAgentEmployeeId()) && (excludeProperties == null || !excludeProperties.contains("agentEmployeeId"));

if (useAgentEmployeeId)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"AGENT_EMPLOYEE_ID\" =? ";
paramValues.add(theQueryObject.getAgentEmployeeId());
propertyCounter++;
}

boolean useAgentFirstName = StringUtils.hasText(theQueryObject.getAgentFirstName()) && (excludeProperties == null || !excludeProperties.contains("agentFirstName"));

if (useAgentFirstName)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"AGENT_FIRST_NAME\" =? ";
paramValues.add(theQueryObject.getAgentFirstName());
propertyCounter++;
}

boolean useAgentLastName = StringUtils.hasText(theQueryObject.getAgentLastName()) && (excludeProperties == null || !excludeProperties.contains("agentLastName"));

if (useAgentLastName)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"AGENT_LAST_NAME\" =? ";
paramValues.add(theQueryObject.getAgentLastName());
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

boolean useCompletionStatus = StringUtils.hasText(theQueryObject.getCompletionStatus()) && (excludeProperties == null || !excludeProperties.contains("completionStatus"));

if (useCompletionStatus)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"COMPLETION_STATUS\" =? ";
paramValues.add(theQueryObject.getCompletionStatus());
propertyCounter++;
}

boolean useLOBName = StringUtils.hasText(theQueryObject.getLOBName()) && (excludeProperties == null || !excludeProperties.contains("lOBName"));

if (useLOBName)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"LOB_NAME\" =? ";
paramValues.add(theQueryObject.getLOBName());
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

boolean useSupervisorName = StringUtils.hasText(theQueryObject.getSupervisorName()) && (excludeProperties == null || !excludeProperties.contains("supervisorName"));

if (useSupervisorName)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"SUPERVISOR_NAME\" =? ";
paramValues.add(theQueryObject.getSupervisorName());
propertyCounter++;
}

boolean useManagerApprovalID = theQueryObject.getManagerApproval() != null && (excludeProperties == null || !excludeProperties.contains("managerApproval"));

if (useManagerApprovalID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"MANAGER_APPROVAL_ID\" =? ";
paramValues.add(theQueryObject.getManagerApproval().getID());
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

boolean useSupervisorAcknowledgementID = theQueryObject.getSupervisorAcknowledgement() != null && (excludeProperties == null || !excludeProperties.contains("supervisorAcknowledgement"));

if (useSupervisorAcknowledgementID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"SUPERVISOR_ACKNOWLEDGEMENT_ID\" =? ";
paramValues.add(theQueryObject.getSupervisorAcknowledgement().getID());
propertyCounter++;
}

boolean useHRApprovalID = theQueryObject.getHRApproval() != null && (excludeProperties == null || !excludeProperties.contains("hRApproval"));

if (useHRApprovalID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"HR_APPROVAL_ID\" =? ";
paramValues.add(theQueryObject.getHRApproval().getID());
propertyCounter++;
}

boolean useEmployeeAcknowledgementID = theQueryObject.getEmployeeAcknowledgement() != null && (excludeProperties == null || !excludeProperties.contains("employeeAcknowledgement"));

if (useEmployeeAcknowledgementID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"EMPLOYEE_ACKNOWLEDGEMENT_ID\" =? ";
paramValues.add(theQueryObject.getEmployeeAcknowledgement().getID());
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
