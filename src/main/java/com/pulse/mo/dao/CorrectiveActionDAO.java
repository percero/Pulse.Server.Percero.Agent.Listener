
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
import com.pulse.mo.Attachment;
import com.pulse.mo.Agent;
import com.pulse.mo.ManagerApproval;
import com.pulse.mo.SupervisorAcknowledgement;
import com.pulse.mo.HRApproval;
import com.pulse.mo.EmployeeAcknowledgement;
import com.pulse.mo.CorrectiveActionType;
import com.pulse.mo.CorrectiveActionState;

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
		return "SELECT correctiveaction.ID FROM CorrectiveAction correctiveaction WHERE correctiveaction.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT correctiveaction.ID,correctiveaction.externalID,correctiveaction.correctiveActionTypeName,correctiveaction.correctiveActionStateName,correctiveaction.agentEmployeeId,correctiveaction.agentFirstName,correctiveaction.agentLastName,correctiveaction.completionDate,correctiveaction.completionStatus,correctiveaction.details,correctiveaction.employeeComment,correctiveaction.lOBName,correctiveaction.message,correctiveaction.messageReason,correctiveaction.nextStepsMessage,correctiveaction.supervisorComment,correctiveaction.supervisorName,correctiveaction.supervisorAcknowledgement_ID,correctiveaction.managerApproval_ID,correctiveaction.hRApproval_ID,correctiveaction.employeeAcknowledgement_ID,correctiveaction.correctiveActionState_ID,correctiveaction.agent_ID,correctiveaction.correctiveActionType_ID FROM CorrectiveAction correctiveaction WHERE correctiveaction.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT correctiveaction.ID FROM CorrectiveAction correctiveaction ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT correctiveaction.ID FROM CorrectiveAction correctiveaction ORDER BY correctiveaction.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT correctiveaction.ID,correctiveaction.externalID,correctiveaction.correctiveActionTypeName,correctiveaction.correctiveActionStateName,correctiveaction.agentEmployeeId,correctiveaction.agentFirstName,correctiveaction.agentLastName,correctiveaction.completionDate,correctiveaction.completionStatus,correctiveaction.details,correctiveaction.employeeComment,correctiveaction.lOBName,correctiveaction.message,correctiveaction.messageReason,correctiveaction.nextStepsMessage,correctiveaction.supervisorComment,correctiveaction.supervisorName,correctiveaction.supervisorAcknowledgement_ID,correctiveaction.managerApproval_ID,correctiveaction.hRApproval_ID,correctiveaction.employeeAcknowledgement_ID,correctiveaction.correctiveActionState_ID,correctiveaction.agent_ID,correctiveaction.correctiveActionType_ID FROM CorrectiveAction correctiveaction ORDER BY correctiveaction.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT correctiveaction.ID,correctiveaction.externalID,correctiveaction.correctiveActionTypeName,correctiveaction.correctiveActionStateName,correctiveaction.agentEmployeeId,correctiveaction.agentFirstName,correctiveaction.agentLastName,correctiveaction.completionDate,correctiveaction.completionStatus,correctiveaction.details,correctiveaction.employeeComment,correctiveaction.lOBName,correctiveaction.message,correctiveaction.messageReason,correctiveaction.nextStepsMessage,correctiveaction.supervisorComment,correctiveaction.supervisorName,correctiveaction.supervisorAcknowledgement_ID,correctiveaction.managerApproval_ID,correctiveaction.hRApproval_ID,correctiveaction.employeeAcknowledgement_ID,correctiveaction.correctiveActionState_ID,correctiveaction.agent_ID,correctiveaction.correctiveActionType_ID FROM CorrectiveAction correctiveaction ORDER BY correctiveaction.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM CorrectiveAction correctiveaction";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT correctiveaction.ID,correctiveaction.externalID,correctiveaction.correctiveActionTypeName,correctiveaction.correctiveActionStateName,correctiveaction.agentEmployeeId,correctiveaction.agentFirstName,correctiveaction.agentLastName,correctiveaction.completionDate,correctiveaction.completionStatus,correctiveaction.details,correctiveaction.employeeComment,correctiveaction.lOBName,correctiveaction.message,correctiveaction.messageReason,correctiveaction.nextStepsMessage,correctiveaction.supervisorComment,correctiveaction.supervisorName,correctiveaction.supervisorAcknowledgement_ID,correctiveaction.managerApproval_ID,correctiveaction.hRApproval_ID,correctiveaction.employeeAcknowledgement_ID,correctiveaction.correctiveActionState_ID,correctiveaction.agent_ID,correctiveaction.correctiveActionType_ID FROM CorrectiveAction correctiveaction WHERE correctiveaction.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT correctiveaction.ID FROM CorrectiveAction correctiveaction WHERE correctiveaction.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT correctiveaction.ID,correctiveaction.externalID,correctiveaction.correctiveActionTypeName,correctiveaction.correctiveActionStateName,correctiveaction.agentEmployeeId,correctiveaction.agentFirstName,correctiveaction.agentLastName,correctiveaction.completionDate,correctiveaction.completionStatus,correctiveaction.details,correctiveaction.employeeComment,correctiveaction.lOBName,correctiveaction.message,correctiveaction.messageReason,correctiveaction.nextStepsMessage,correctiveaction.supervisorComment,correctiveaction.supervisorName,correctiveaction.supervisorAcknowledgement_ID,correctiveaction.managerApproval_ID,correctiveaction.hRApproval_ID,correctiveaction.employeeAcknowledgement_ID,correctiveaction.correctiveActionState_ID,correctiveaction.agent_ID,correctiveaction.correctiveActionType_ID FROM CorrectiveAction correctiveaction WHERE correctiveaction." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT correctiveaction.ID FROM CorrectiveAction correctiveaction WHERE correctiveaction." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT correctiveaction.ID FROM CorrectiveAction correctiveaction ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT correctiveaction.ID,correctiveaction.externalID,correctiveaction.correctiveActionTypeName,correctiveaction.correctiveActionStateName,correctiveaction.agentEmployeeId,correctiveaction.agentFirstName,correctiveaction.agentLastName,correctiveaction.completionDate,correctiveaction.completionStatus,correctiveaction.details,correctiveaction.employeeComment,correctiveaction.lOBName,correctiveaction.message,correctiveaction.messageReason,correctiveaction.nextStepsMessage,correctiveaction.supervisorComment,correctiveaction.supervisorName,correctiveaction.supervisorAcknowledgement_ID,correctiveaction.managerApproval_ID,correctiveaction.hRApproval_ID,correctiveaction.employeeAcknowledgement_ID,correctiveaction.correctiveActionState_ID,correctiveaction.agent_ID,correctiveaction.correctiveActionType_ID FROM CorrectiveAction correctiveaction ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO CorrectiveAction (ID,externalID,correctiveActionTypeName,correctiveActionStateName,agentEmployeeId,agentFirstName,agentLastName,completionDate,completionStatus,details,employeeComment,lOBName,message,messageReason,nextStepsMessage,supervisorComment,supervisorName,supervisorAcknowledgement_ID,managerApproval_ID,hRApproval_ID,employeeAcknowledgement_ID,correctiveActionState_ID,agent_ID,correctiveActionType_ID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE CorrectiveAction SET externalID=?,correctiveActionTypeName=?,correctiveActionStateName=?,agentEmployeeId=?,agentFirstName=?,agentLastName=?,completionDate=?,completionStatus=?,details=?,employeeComment=?,lOBName=?,message=?,messageReason=?,nextStepsMessage=?,supervisorComment=?,supervisorName=?,supervisorAcknowledgement_ID=?,managerApproval_ID=?,hRApproval_ID=?,employeeAcknowledgement_ID=?,correctiveActionState_ID=?,agent_ID=?,correctiveActionType_ID=? WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM CorrectiveAction WHERE ID=?";
	}
	
	@Override
	protected CorrectiveAction extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	CorrectiveAction nextResult = new CorrectiveAction();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setExternalID(rs.getString("externalID"));

nextResult.setCorrectiveActionTypeName(rs.getString("correctiveActionTypeName"));

nextResult.setCorrectiveActionStateName(rs.getString("correctiveActionStateName"));

nextResult.setAgentEmployeeId(rs.getString("agentEmployeeId"));

nextResult.setAgentFirstName(rs.getString("agentFirstName"));

nextResult.setAgentLastName(rs.getString("agentLastName"));

nextResult.setCompletionDate(rs.getDate("completionDate"));

nextResult.setCompletionStatus(rs.getString("completionStatus"));

nextResult.setDetails(rs.getString("details"));

nextResult.setEmployeeComment(rs.getString("employeeComment"));

nextResult.setLOBName(rs.getString("lOBName"));

nextResult.setMessage(rs.getString("message"));

nextResult.setMessageReason(rs.getString("messageReason"));

nextResult.setNextStepsMessage(rs.getString("nextStepsMessage"));

nextResult.setSupervisorComment(rs.getString("supervisorComment"));

nextResult.setSupervisorName(rs.getString("supervisorName"));

SupervisorAcknowledgement supervisoracknowledgement = new SupervisorAcknowledgement();
supervisoracknowledgement.setID(rs.getString("supervisoracknowledgement_ID"));
nextResult.setSupervisorAcknowledgement(supervisoracknowledgement);

ManagerApproval managerapproval = new ManagerApproval();
managerapproval.setID(rs.getString("managerapproval_ID"));
nextResult.setManagerApproval(managerapproval);

HRApproval hrapproval = new HRApproval();
hrapproval.setID(rs.getString("hrapproval_ID"));
nextResult.setHRApproval(hrapproval);

EmployeeAcknowledgement employeeacknowledgement = new EmployeeAcknowledgement();
employeeacknowledgement.setID(rs.getString("employeeacknowledgement_ID"));
nextResult.setEmployeeAcknowledgement(employeeacknowledgement);

CorrectiveActionState correctiveactionstate = new CorrectiveActionState();
correctiveactionstate.setID(rs.getString("correctiveactionstate_ID"));
nextResult.setCorrectiveActionState(correctiveactionstate);

Agent agent = new Agent();
agent.setID(rs.getString("agent_ID"));
nextResult.setAgent(agent);

CorrectiveActionType correctiveactiontype = new CorrectiveActionType();
correctiveactiontype.setID(rs.getString("correctiveactiontype_ID"));
nextResult.setCorrectiveActionType(correctiveactiontype);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(CorrectiveAction perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getExternalID());
pstmt.setString(3, perceroObject.getCorrectiveActionTypeName());
pstmt.setString(4, perceroObject.getCorrectiveActionStateName());
pstmt.setString(5, perceroObject.getAgentEmployeeId());
pstmt.setString(6, perceroObject.getAgentFirstName());
pstmt.setString(7, perceroObject.getAgentLastName());
pstmt.setDate(8, DateUtils.utilDateToSqlDate(perceroObject.getCompletionDate()));
pstmt.setString(9, perceroObject.getCompletionStatus());
pstmt.setString(10, perceroObject.getDetails());
pstmt.setString(11, perceroObject.getEmployeeComment());
pstmt.setString(12, perceroObject.getLOBName());
pstmt.setString(13, perceroObject.getMessage());
pstmt.setString(14, perceroObject.getMessageReason());
pstmt.setString(15, perceroObject.getNextStepsMessage());
pstmt.setString(16, perceroObject.getSupervisorComment());
pstmt.setString(17, perceroObject.getSupervisorName());

if (perceroObject.getSupervisorAcknowledgement() == null)
{
pstmt.setString(18, null);
}
else
{
		pstmt.setString(18, perceroObject.getSupervisorAcknowledgement().getID());
}


if (perceroObject.getManagerApproval() == null)
{
pstmt.setString(19, null);
}
else
{
		pstmt.setString(19, perceroObject.getManagerApproval().getID());
}


if (perceroObject.getHRApproval() == null)
{
pstmt.setString(20, null);
}
else
{
		pstmt.setString(20, perceroObject.getHRApproval().getID());
}


if (perceroObject.getEmployeeAcknowledgement() == null)
{
pstmt.setString(21, null);
}
else
{
		pstmt.setString(21, perceroObject.getEmployeeAcknowledgement().getID());
}


if (perceroObject.getCorrectiveActionState() == null)
{
pstmt.setString(22, null);
}
else
{
		pstmt.setString(22, perceroObject.getCorrectiveActionState().getID());
}


if (perceroObject.getAgent() == null)
{
pstmt.setString(23, null);
}
else
{
		pstmt.setString(23, perceroObject.getAgent().getID());
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
	protected void setPreparedStatmentUpdateParams(CorrectiveAction perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getExternalID());
pstmt.setString(2, perceroObject.getCorrectiveActionTypeName());
pstmt.setString(3, perceroObject.getCorrectiveActionStateName());
pstmt.setString(4, perceroObject.getAgentEmployeeId());
pstmt.setString(5, perceroObject.getAgentFirstName());
pstmt.setString(6, perceroObject.getAgentLastName());
pstmt.setDate(7, DateUtils.utilDateToSqlDate(perceroObject.getCompletionDate()));
pstmt.setString(8, perceroObject.getCompletionStatus());
pstmt.setString(9, perceroObject.getDetails());
pstmt.setString(10, perceroObject.getEmployeeComment());
pstmt.setString(11, perceroObject.getLOBName());
pstmt.setString(12, perceroObject.getMessage());
pstmt.setString(13, perceroObject.getMessageReason());
pstmt.setString(14, perceroObject.getNextStepsMessage());
pstmt.setString(15, perceroObject.getSupervisorComment());
pstmt.setString(16, perceroObject.getSupervisorName());

if (perceroObject.getSupervisorAcknowledgement() == null)
{
pstmt.setString(17, null);
}
else
{
		pstmt.setString(17, perceroObject.getSupervisorAcknowledgement().getID());
}


if (perceroObject.getManagerApproval() == null)
{
pstmt.setString(18, null);
}
else
{
		pstmt.setString(18, perceroObject.getManagerApproval().getID());
}


if (perceroObject.getHRApproval() == null)
{
pstmt.setString(19, null);
}
else
{
		pstmt.setString(19, perceroObject.getHRApproval().getID());
}


if (perceroObject.getEmployeeAcknowledgement() == null)
{
pstmt.setString(20, null);
}
else
{
		pstmt.setString(20, perceroObject.getEmployeeAcknowledgement().getID());
}


if (perceroObject.getCorrectiveActionState() == null)
{
pstmt.setString(21, null);
}
else
{
		pstmt.setString(21, perceroObject.getCorrectiveActionState().getID());
}


if (perceroObject.getAgent() == null)
{
pstmt.setString(22, null);
}
else
{
		pstmt.setString(22, perceroObject.getAgent().getID());
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
	public List<CorrectiveAction> findByExample(CorrectiveAction theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useExternalID = StringUtils.hasText(theQueryObject.getExternalID()) && (excludeProperties == null || !excludeProperties.contains("externalID"));

if (useExternalID)
{
sql += " WHERE ";
paramValues.add(theQueryObject.getExternalID());
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
sql += " correctiveActionTypeName=? ";
paramValues.add(theQueryObject.getCorrectiveActionTypeName());
propertyCounter++;
}

boolean useCorrectiveActionStateName = StringUtils.hasText(theQueryObject.getCorrectiveActionStateName()) && (excludeProperties == null || !excludeProperties.contains("correctiveActionStateName"));

if (useCorrectiveActionStateName)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " correctiveActionStateName=? ";
paramValues.add(theQueryObject.getCorrectiveActionStateName());
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
sql += " agentEmployeeId=? ";
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
sql += " agentFirstName=? ";
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
sql += " agentLastName=? ";
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
sql += " completionDate=? ";
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
sql += " completionStatus=? ";
paramValues.add(theQueryObject.getCompletionStatus());
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
sql += " details=? ";
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
sql += " employeeComment=? ";
paramValues.add(theQueryObject.getEmployeeComment());
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
sql += " lOBName=? ";
paramValues.add(theQueryObject.getLOBName());
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
sql += " message=? ";
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
sql += " messageReason=? ";
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
sql += " nextStepsMessage=? ";
paramValues.add(theQueryObject.getNextStepsMessage());
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
sql += " supervisorComment=? ";
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
sql += " supervisorName=? ";
paramValues.add(theQueryObject.getSupervisorName());
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
sql += " supervisorAcknowledgementID=? ";
paramValues.add(theQueryObject.getSupervisorAcknowledgement().getID());
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
sql += " managerApprovalID=? ";
paramValues.add(theQueryObject.getManagerApproval().getID());
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
sql += " hRApprovalID=? ";
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
sql += " employeeAcknowledgementID=? ";
paramValues.add(theQueryObject.getEmployeeAcknowledgement().getID());
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
sql += " correctiveActionStateID=? ";
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
sql += " agentID=? ";
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
sql += " correctiveActionTypeID=? ";
paramValues.add(theQueryObject.getCorrectiveActionType().getID());
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
