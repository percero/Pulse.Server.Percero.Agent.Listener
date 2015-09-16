
package com.pulsemobile.mo.mo_super;

import java.io.IOException;
import java.io.Serializable;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SecondaryTable;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.hibernate.annotations.AccessType;

import com.google.gson.JsonObject;
import com.percero.agents.sync.metadata.MappedClass.MappedClassMethodPair;
import com.percero.agents.sync.metadata.MappedClass;

/*
Imports based on semantic requirements
*/


import com.percero.agents.sync.vo.BaseDataObject;
import com.percero.serial.BDODeserializer;
import com.percero.serial.BDOSerializer;
import com.percero.serial.JsonUtils;

import com.pulsemobile.mo.*;

/*
Entity Tags based on semantic requirements
*/

@MappedSuperclass
public class _Super_CorrectiveAction extends BaseDataObject implements Serializable
{
	//////////////////////////////////////////////////////
	// VERSION
	//////////////////////////////////////////////////////
	@Override
	public String classVersion() {
		return "1.0.0";
	}

	
	/*
	Keys of CorrectiveAction
	*/
	//////////////////////////////////////////////////////
// ID
//////////////////////////////////////////////////////
@Id
@com.percero.agents.sync.metadata.annotations.Externalize
@Column(unique=true,name="ID")
private String ID;
@JsonProperty(value="ID")
public String getID() {
	return this.ID;
}

@JsonProperty(value="ID")
public void setID(String value) {
	this.ID = value;
}
	
	//////////////////////////////////////////////////////
	// Properties
	//////////////////////////////////////////////////////
	/*
AgentEmployeeId
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String agentEmployeeId;

public String getAgentEmployeeId() 
{
	return this.agentEmployeeId;
}

public void setAgentEmployeeId(String agentEmployeeId)
{
	this.agentEmployeeId = agentEmployeeId;
}/*
NextStepsMessage
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String nextStepsMessage;

public String getNextStepsMessage() 
{
	return this.nextStepsMessage;
}

public void setNextStepsMessage(String nextStepsMessage)
{
	this.nextStepsMessage = nextStepsMessage;
}/*
SupervisorName
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String supervisorName;

public String getSupervisorName() 
{
	return this.supervisorName;
}

public void setSupervisorName(String supervisorName)
{
	this.supervisorName = supervisorName;
}/*
LOBName
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String lOBName;

public String getLOBName() 
{
	return this.lOBName;
}

public void setLOBName(String lOBName)
{
	this.lOBName = lOBName;
}/*
CompletionStatus
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String completionStatus;

public String getCompletionStatus() 
{
	return this.completionStatus;
}

public void setCompletionStatus(String completionStatus)
{
	this.completionStatus = completionStatus;
}/*
EmployeeComment
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String employeeComment;

public String getEmployeeComment() 
{
	return this.employeeComment;
}

public void setEmployeeComment(String employeeComment)
{
	this.employeeComment = employeeComment;
}/*
ExternalID
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String externalID;

public String getExternalID() 
{
	return this.externalID;
}

public void setExternalID(String externalID)
{
	this.externalID = externalID;
}/*
AgentFirstName
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String agentFirstName;

public String getAgentFirstName() 
{
	return this.agentFirstName;
}

public void setAgentFirstName(String agentFirstName)
{
	this.agentFirstName = agentFirstName;
}/*
SupervisorComment
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String supervisorComment;

public String getSupervisorComment() 
{
	return this.supervisorComment;
}

public void setSupervisorComment(String supervisorComment)
{
	this.supervisorComment = supervisorComment;
}/*
CompletionDate
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Date completionDate;

public Date getCompletionDate() 
{
	return this.completionDate;
}

public void setCompletionDate(Date completionDate)
{
	this.completionDate = completionDate;
}/*
AgentLastName
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String agentLastName;

public String getAgentLastName() 
{
	return this.agentLastName;
}

public void setAgentLastName(String agentLastName)
{
	this.agentLastName = agentLastName;
}/*
CorrectiveActionTypeName
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String correctiveActionTypeName;

public String getCorrectiveActionTypeName() 
{
	return this.correctiveActionTypeName;
}

public void setCorrectiveActionTypeName(String correctiveActionTypeName)
{
	this.correctiveActionTypeName = correctiveActionTypeName;
}/*
CorrectiveActionStateName
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String correctiveActionStateName;

public String getCorrectiveActionStateName() 
{
	return this.correctiveActionStateName;
}

public void setCorrectiveActionStateName(String correctiveActionStateName)
{
	this.correctiveActionStateName = correctiveActionStateName;
}/*
Message
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String message;

public String getMessage() 
{
	return this.message;
}

public void setMessage(String message)
{
	this.message = message;
}/*
Details
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String details;

public String getDetails() 
{
	return this.details;
}

public void setDetails(String details)
{
	this.details = details;
}/*
MessageReason
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String messageReason;

public String getMessageReason() 
{
	return this.messageReason;
}

public void setMessageReason(String messageReason)
{
	this.messageReason = messageReason;
}

	//////////////////////////////////////////////////////
	// Target Relationships
	//////////////////////////////////////////////////////
	@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@OneToMany(fetch=FetchType.LAZY, targetEntity=Attachment.class, mappedBy="correctiveAction", cascade=javax.persistence.CascadeType.REMOVE)
private List<Attachment> attachments;
public List<Attachment> getAttachments() {
	return this.attachments;
}

public void setAttachments(List<Attachment> value) {
	this.attachments = value;
}



	//////////////////////////////////////////////////////
	// Source Relationships
	//////////////////////////////////////////////////////
	@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@JoinColumn(name="AgentId")
@org.hibernate.annotations.ForeignKey(name="FK_AgentOfCorrectiveAction")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private Agent agent;
public Agent getAgent() {
	return this.agent;
}

public void setAgent(Agent value) {
	this.agent = value;
}@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@JoinColumn(name="EmployeeAcknowledgementId")
@org.hibernate.annotations.ForeignKey(name="FK_EmployeeAcknowledgementOfCorrectiveAction")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private EmployeeAcknowledgement employeeAcknowledgement;
public EmployeeAcknowledgement getEmployeeAcknowledgement() {
	return this.employeeAcknowledgement;
}

public void setEmployeeAcknowledgement(EmployeeAcknowledgement value) {
	this.employeeAcknowledgement = value;
}@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@JoinColumn(name="SupervisorAcknowledgementId")
@org.hibernate.annotations.ForeignKey(name="FK_SupervisorAcknowledgementOfCorrectiveAction")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private SupervisorAcknowledgement supervisorAcknowledgement;
public SupervisorAcknowledgement getSupervisorAcknowledgement() {
	return this.supervisorAcknowledgement;
}

public void setSupervisorAcknowledgement(SupervisorAcknowledgement value) {
	this.supervisorAcknowledgement = value;
}@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@JoinColumn(name="ManagerApprovalId")
@org.hibernate.annotations.ForeignKey(name="FK_ManagerApprovalOfCorrectiveAction")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private ManagerApproval managerApproval;
public ManagerApproval getManagerApproval() {
	return this.managerApproval;
}

public void setManagerApproval(ManagerApproval value) {
	this.managerApproval = value;
}@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@JoinColumn(name="HRApprovalId")
@org.hibernate.annotations.ForeignKey(name="FK_HRApprovalOfCorrectiveAction")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private HRApproval hRApproval;
public HRApproval getHRApproval() {
	return this.hRApproval;
}

public void setHRApproval(HRApproval value) {
	this.hRApproval = value;
}@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@JoinColumn(name="CorrectiveActionTypeId")
@org.hibernate.annotations.ForeignKey(name="FK_CorrectiveActionTypeOfCorrectiveAction")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private CorrectiveActionType correctiveActionType;
public CorrectiveActionType getCorrectiveActionType() {
	return this.correctiveActionType;
}

public void setCorrectiveActionType(CorrectiveActionType value) {
	this.correctiveActionType = value;
}@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@JoinColumn(name="CorrectiveActionStateId")
@org.hibernate.annotations.ForeignKey(name="FK_CorrectiveActionStateOfCorrectiveAction")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private CorrectiveActionState correctiveActionState;
public CorrectiveActionState getCorrectiveActionState() {
	return this.correctiveActionState;
}

public void setCorrectiveActionState(CorrectiveActionState value) {
	this.correctiveActionState = value;
}

	
	//////////////////////////////////////////////////////
	// JSON
	//////////////////////////////////////////////////////
	@Override
	public String retrieveJson(ObjectMapper objectMapper) {
		String objectJson = super.retrieveJson(objectMapper);

		// Properties		
		//Retrieve value of the Agent Employee Id property
		objectJson += ",\"agentEmployeeId\":";
		
		if (getAgentEmployeeId() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getAgentEmployeeId());
			} catch (JsonGenerationException e) {
				objectJson += "null";
				e.printStackTrace();
			} catch (JsonMappingException e) {
				objectJson += "null";
				e.printStackTrace();
			} catch (IOException e) {
				objectJson += "null";
				e.printStackTrace();
			}
		}
		//Retrieve value of the Next Steps Message property
		objectJson += ",\"nextStepsMessage\":";
		
		if (getNextStepsMessage() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getNextStepsMessage());
			} catch (JsonGenerationException e) {
				objectJson += "null";
				e.printStackTrace();
			} catch (JsonMappingException e) {
				objectJson += "null";
				e.printStackTrace();
			} catch (IOException e) {
				objectJson += "null";
				e.printStackTrace();
			}
		}
		//Retrieve value of the Supervisor Name property
		objectJson += ",\"supervisorName\":";
		
		if (getSupervisorName() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getSupervisorName());
			} catch (JsonGenerationException e) {
				objectJson += "null";
				e.printStackTrace();
			} catch (JsonMappingException e) {
				objectJson += "null";
				e.printStackTrace();
			} catch (IOException e) {
				objectJson += "null";
				e.printStackTrace();
			}
		}
		//Retrieve value of the LOB Name property
		objectJson += ",\"lOBName\":";
		
		if (getLOBName() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getLOBName());
			} catch (JsonGenerationException e) {
				objectJson += "null";
				e.printStackTrace();
			} catch (JsonMappingException e) {
				objectJson += "null";
				e.printStackTrace();
			} catch (IOException e) {
				objectJson += "null";
				e.printStackTrace();
			}
		}
		//Retrieve value of the Completion Status property
		objectJson += ",\"completionStatus\":";
		
		if (getCompletionStatus() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getCompletionStatus());
			} catch (JsonGenerationException e) {
				objectJson += "null";
				e.printStackTrace();
			} catch (JsonMappingException e) {
				objectJson += "null";
				e.printStackTrace();
			} catch (IOException e) {
				objectJson += "null";
				e.printStackTrace();
			}
		}
		//Retrieve value of the Employee Comment property
		objectJson += ",\"employeeComment\":";
		
		if (getEmployeeComment() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getEmployeeComment());
			} catch (JsonGenerationException e) {
				objectJson += "null";
				e.printStackTrace();
			} catch (JsonMappingException e) {
				objectJson += "null";
				e.printStackTrace();
			} catch (IOException e) {
				objectJson += "null";
				e.printStackTrace();
			}
		}
		//Retrieve value of the External ID property
		objectJson += ",\"externalID\":";
		
		if (getExternalID() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getExternalID());
			} catch (JsonGenerationException e) {
				objectJson += "null";
				e.printStackTrace();
			} catch (JsonMappingException e) {
				objectJson += "null";
				e.printStackTrace();
			} catch (IOException e) {
				objectJson += "null";
				e.printStackTrace();
			}
		}
		//Retrieve value of the Agent First Name property
		objectJson += ",\"agentFirstName\":";
		
		if (getAgentFirstName() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getAgentFirstName());
			} catch (JsonGenerationException e) {
				objectJson += "null";
				e.printStackTrace();
			} catch (JsonMappingException e) {
				objectJson += "null";
				e.printStackTrace();
			} catch (IOException e) {
				objectJson += "null";
				e.printStackTrace();
			}
		}
		//Retrieve value of the Supervisor Comment property
		objectJson += ",\"supervisorComment\":";
		
		if (getSupervisorComment() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getSupervisorComment());
			} catch (JsonGenerationException e) {
				objectJson += "null";
				e.printStackTrace();
			} catch (JsonMappingException e) {
				objectJson += "null";
				e.printStackTrace();
			} catch (IOException e) {
				objectJson += "null";
				e.printStackTrace();
			}
		}
		//Retrieve value of the Completion Date property
		objectJson += ",\"completionDate\":";
		if (getCompletionDate() == null)
			objectJson += "null";
		else {
			objectJson += getCompletionDate().getTime();
		}
		//Retrieve value of the Agent Last Name property
		objectJson += ",\"agentLastName\":";
		
		if (getAgentLastName() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getAgentLastName());
			} catch (JsonGenerationException e) {
				objectJson += "null";
				e.printStackTrace();
			} catch (JsonMappingException e) {
				objectJson += "null";
				e.printStackTrace();
			} catch (IOException e) {
				objectJson += "null";
				e.printStackTrace();
			}
		}
		//Retrieve value of the Corrective Action Type Name property
		objectJson += ",\"correctiveActionTypeName\":";
		
		if (getCorrectiveActionTypeName() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getCorrectiveActionTypeName());
			} catch (JsonGenerationException e) {
				objectJson += "null";
				e.printStackTrace();
			} catch (JsonMappingException e) {
				objectJson += "null";
				e.printStackTrace();
			} catch (IOException e) {
				objectJson += "null";
				e.printStackTrace();
			}
		}
		//Retrieve value of the Corrective Action State Name property
		objectJson += ",\"correctiveActionStateName\":";
		
		if (getCorrectiveActionStateName() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getCorrectiveActionStateName());
			} catch (JsonGenerationException e) {
				objectJson += "null";
				e.printStackTrace();
			} catch (JsonMappingException e) {
				objectJson += "null";
				e.printStackTrace();
			} catch (IOException e) {
				objectJson += "null";
				e.printStackTrace();
			}
		}
		//Retrieve value of the Message property
		objectJson += ",\"message\":";
		
		if (getMessage() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getMessage());
			} catch (JsonGenerationException e) {
				objectJson += "null";
				e.printStackTrace();
			} catch (JsonMappingException e) {
				objectJson += "null";
				e.printStackTrace();
			} catch (IOException e) {
				objectJson += "null";
				e.printStackTrace();
			}
		}
		//Retrieve value of the Details property
		objectJson += ",\"details\":";
		
		if (getDetails() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getDetails());
			} catch (JsonGenerationException e) {
				objectJson += "null";
				e.printStackTrace();
			} catch (JsonMappingException e) {
				objectJson += "null";
				e.printStackTrace();
			} catch (IOException e) {
				objectJson += "null";
				e.printStackTrace();
			}
		}
		//Retrieve value of the Message Reason property
		objectJson += ",\"messageReason\":";
		
		if (getMessageReason() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getMessageReason());
			} catch (JsonGenerationException e) {
				objectJson += "null";
				e.printStackTrace();
			} catch (JsonMappingException e) {
				objectJson += "null";
				e.printStackTrace();
			} catch (IOException e) {
				objectJson += "null";
				e.printStackTrace();
			}
		}

				
		// Source Relationships
//Retrieve value of the Agent of Corrective Action relationship
objectJson += ",\"agent\":";
		if (getAgent() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getAgent()).toEmbeddedJson();
			} catch(Exception e) {
				objectJson += "null";
			}
		}
		objectJson += "";
//Retrieve value of the Employee Acknowledgement of Corrective Action relationship
objectJson += ",\"employeeAcknowledgement\":";
		if (getEmployeeAcknowledgement() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getEmployeeAcknowledgement()).toEmbeddedJson();
			} catch(Exception e) {
				objectJson += "null";
			}
		}
		objectJson += "";
//Retrieve value of the Supervisor Acknowledgement of Corrective Action relationship
objectJson += ",\"supervisorAcknowledgement\":";
		if (getSupervisorAcknowledgement() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getSupervisorAcknowledgement()).toEmbeddedJson();
			} catch(Exception e) {
				objectJson += "null";
			}
		}
		objectJson += "";
//Retrieve value of the Manager Approval of Corrective Action relationship
objectJson += ",\"managerApproval\":";
		if (getManagerApproval() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getManagerApproval()).toEmbeddedJson();
			} catch(Exception e) {
				objectJson += "null";
			}
		}
		objectJson += "";
//Retrieve value of the HR Approval of Corrective Action relationship
objectJson += ",\"hRApproval\":";
		if (getHRApproval() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getHRApproval()).toEmbeddedJson();
			} catch(Exception e) {
				objectJson += "null";
			}
		}
		objectJson += "";
//Retrieve value of the Corrective Action Type of Corrective Action relationship
objectJson += ",\"correctiveActionType\":";
		if (getCorrectiveActionType() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getCorrectiveActionType()).toEmbeddedJson();
			} catch(Exception e) {
				objectJson += "null";
			}
		}
		objectJson += "";
//Retrieve value of the Corrective Action State of Corrective Action relationship
objectJson += ",\"correctiveActionState\":";
		if (getCorrectiveActionState() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getCorrectiveActionState()).toEmbeddedJson();
			} catch(Exception e) {
				objectJson += "null";
			}
		}
		objectJson += "";

		
		// Target Relationships
//Retrieve value of the Corrective Action of Attachment relationship
objectJson += ",\"attachments\":[";
		
		if (getAttachments() != null) {
			int attachmentsCounter = 0;
			for(Attachment nextAttachments : getAttachments()) {
				if (attachmentsCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextAttachments).toEmbeddedJson();
					attachmentsCounter++;
				} catch(Exception e) {
					// Do nothing.
				}
			}
		}
		objectJson += "]";

		
		return objectJson;
	}


	@Override
	protected void fromJson(JsonObject jsonObject) {
	    super.fromJson(jsonObject);

		// Properties
		//From value of the Agent Employee Id property
		setAgentEmployeeId(JsonUtils.getJsonString(jsonObject, "agentEmployeeId"));
		//From value of the Next Steps Message property
		setNextStepsMessage(JsonUtils.getJsonString(jsonObject, "nextStepsMessage"));
		//From value of the Supervisor Name property
		setSupervisorName(JsonUtils.getJsonString(jsonObject, "supervisorName"));
		//From value of the LOB Name property
		setLOBName(JsonUtils.getJsonString(jsonObject, "lOBName"));
		//From value of the Completion Status property
		setCompletionStatus(JsonUtils.getJsonString(jsonObject, "completionStatus"));
		//From value of the Employee Comment property
		setEmployeeComment(JsonUtils.getJsonString(jsonObject, "employeeComment"));
		//From value of the External ID property
		setExternalID(JsonUtils.getJsonString(jsonObject, "externalID"));
		//From value of the Agent First Name property
		setAgentFirstName(JsonUtils.getJsonString(jsonObject, "agentFirstName"));
		//From value of the Supervisor Comment property
		setSupervisorComment(JsonUtils.getJsonString(jsonObject, "supervisorComment"));
		//From value of the Completion Date property
		setCompletionDate(JsonUtils.getJsonDate(jsonObject, "completionDate"));
		//From value of the Agent Last Name property
		setAgentLastName(JsonUtils.getJsonString(jsonObject, "agentLastName"));
		//From value of the Corrective Action Type Name property
		setCorrectiveActionTypeName(JsonUtils.getJsonString(jsonObject, "correctiveActionTypeName"));
		//From value of the Corrective Action State Name property
		setCorrectiveActionStateName(JsonUtils.getJsonString(jsonObject, "correctiveActionStateName"));
		//From value of the Message property
		setMessage(JsonUtils.getJsonString(jsonObject, "message"));
		//From value of the Details property
		setDetails(JsonUtils.getJsonString(jsonObject, "details"));
		//From value of the Message Reason property
		setMessageReason(JsonUtils.getJsonString(jsonObject, "messageReason"));

		
		// Source Relationships
		this.agent = (Agent) JsonUtils.getJsonPerceroObject(jsonObject, "agent");
		this.employeeAcknowledgement = (EmployeeAcknowledgement) JsonUtils.getJsonPerceroObject(jsonObject, "employeeAcknowledgement");
		this.supervisorAcknowledgement = (SupervisorAcknowledgement) JsonUtils.getJsonPerceroObject(jsonObject, "supervisorAcknowledgement");
		this.managerApproval = (ManagerApproval) JsonUtils.getJsonPerceroObject(jsonObject, "managerApproval");
		this.hRApproval = (HRApproval) JsonUtils.getJsonPerceroObject(jsonObject, "hRApproval");
		this.correctiveActionType = (CorrectiveActionType) JsonUtils.getJsonPerceroObject(jsonObject, "correctiveActionType");
		this.correctiveActionState = (CorrectiveActionState) JsonUtils.getJsonPerceroObject(jsonObject, "correctiveActionState");


		// Target Relationships
		this.attachments = (List<Attachment>) JsonUtils.getJsonListPerceroObject(jsonObject, "attachments");


	}
	
	@Override
	protected List<MappedClassMethodPair> getListSetters() {
		List<MappedClassMethodPair> listSetters = super.getListSetters();

		// Target Relationships
		listSetters.add(MappedClass.getFieldSetters(Attachment.class, "correctiveaction"));

		
		return listSetters;
	}
}
