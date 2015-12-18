

package com.pulse.mo.mo_super;

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

import com.pulse.mo.*;

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
ManagerApprovalDate
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Date managerApprovalDate;

public Date getManagerApprovalDate() 
{
	return this.managerApprovalDate;
}

public void setManagerApprovalDate(Date managerApprovalDate)
{
	this.managerApprovalDate = managerApprovalDate;
}/*
DisciplineType
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Integer disciplineType;

public Integer getDisciplineType() 
{
	return this.disciplineType;
}

public void setDisciplineType(Integer disciplineType)
{
	this.disciplineType = disciplineType;
}/*
AttachmentId
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Integer attachmentId;

public Integer getAttachmentId() 
{
	return this.attachmentId;
}

public void setAttachmentId(Integer attachmentId)
{
	this.attachmentId = attachmentId;
}/*
ClientId
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Integer clientId;

public Integer getClientId() 
{
	return this.clientId;
}

public void setClientId(Integer clientId)
{
	this.clientId = clientId;
}/*
ReasonType
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String reasonType;

public String getReasonType() 
{
	return this.reasonType;
}

public void setReasonType(String reasonType)
{
	this.reasonType = reasonType;
}/*
Reason
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String reason;

public String getReason() 
{
	return this.reason;
}

public void setReason(String reason)
{
	this.reason = reason;
}/*
DetailsConfig
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String detailsConfig;

public String getDetailsConfig() 
{
	return this.detailsConfig;
}

public void setDetailsConfig(String detailsConfig)
{
	this.detailsConfig = detailsConfig;
}/*
SupervisorConfig
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String supervisorConfig;

public String getSupervisorConfig() 
{
	return this.supervisorConfig;
}

public void setSupervisorConfig(String supervisorConfig)
{
	this.supervisorConfig = supervisorConfig;
}/*
CreatedOn
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Date createdOn;

public Date getCreatedOn() 
{
	return this.createdOn;
}

public void setCreatedOn(Date createdOn)
{
	this.createdOn = createdOn;
}/*
UpdatedOn
Notes:
*/
	@Column
	@com.percero.agents.sync.metadata.annotations.Externalize

	private Date updatedOn;

	public Date getUpdatedOn()
	{
		return this.updatedOn;
	}

	public void setUpdatedOn(Date updatedOn)
	{
		this.updatedOn = updatedOn;
	}/*
UpdatedOn
Notes:
*/
	@Column
	@com.percero.agents.sync.metadata.annotations.Externalize

	private String updatedBy;

	public String getUpdatedBy()
	{
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy)
	{
		this.updatedBy = updatedBy;
	}/*
UpdatedOn
Notes:
*/
	@Column
	@com.percero.agents.sync.metadata.annotations.Externalize

	private String createdBy;

	public String getCreatedBy() { return this.createdBy; }

	public void setCreatedBy(String createdBy)
	{
		this.createdBy = createdBy;
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
AttachmentName
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String attachmentName;

public String getAttachmentName() 
{
	return this.attachmentName;
}

public void setAttachmentName(String attachmentName)
{
	this.attachmentName = attachmentName;
}/*
SupervisorACKDate
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Date supervisorACKDate;

public Date getSupervisorACKDate() 
{
	return this.supervisorACKDate;
}

public void setSupervisorACKDate(Date supervisorACKDate)
{
	this.supervisorACKDate = supervisorACKDate;
}/*
Program
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String program;

public String getProgram() 
{
	return this.program;
}

public void setProgram(String program)
{
	this.program = program;
}/*
SessionId
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String sessionId;

public String getSessionId() 
{
	return this.sessionId;
}

public void setSessionId(String sessionId)
{
	this.sessionId = sessionId;
}/*
NextSteps
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String nextSteps;

public String getNextSteps() 
{
	return this.nextSteps;
}

public void setNextSteps(String nextSteps)
{
	this.nextSteps = nextSteps;
}/*
MetricRef
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String metricRef;

public String getMetricRef() 
{
	return this.metricRef;
}

public void setMetricRef(String metricRef)
{
	this.metricRef = metricRef;
}/*
EmployeeAck
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String employeeAck;

public String getEmployeeAck() 
{
	return this.employeeAck;
}

public void setEmployeeAck(String employeeAck)
{
	this.employeeAck = employeeAck;
}/*
ExpireDate
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Date expireDate;

public Date getExpireDate() 
{
	return this.expireDate;
}

public void setExpireDate(Date expireDate)
{
	this.expireDate = expireDate;
}/*
HRApprovalDate
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize
@JsonProperty(value="hRApprovalDate")
private Date hRApprovalDate;

public Date getHRApprovalDate() 
{
	return this.hRApprovalDate;
}

public void setHRApprovalDate(Date hRApprovalDate)
{
	this.hRApprovalDate = hRApprovalDate;
}/*
FormId
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Integer formId;

public Integer getFormId() 
{
	return this.formId;
}

public void setFormId(Integer formId)
{
	this.formId = formId;
}

	//////////////////////////////////////////////////////
	// Target Relationships
	//////////////////////////////////////////////////////
	@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@OneToMany(fetch=FetchType.LAZY, targetEntity=CorrectiveActionAttachment.class, mappedBy="correctiveAction", cascade=javax.persistence.CascadeType.REMOVE)
private List<CorrectiveActionAttachment> correctiveActionAttachments;
public List<CorrectiveActionAttachment> getCorrectiveActionAttachments() {
	return this.correctiveActionAttachments;
}

public void setCorrectiveActionAttachments(List<CorrectiveActionAttachment> value) {
	this.correctiveActionAttachments = value;
}

@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@OneToMany(fetch=FetchType.LAZY, targetEntity=SessionComment.class, mappedBy="correctiveAction", cascade=javax.persistence.CascadeType.REMOVE)
private List<SessionComment> sessionComments;
public List<SessionComment> getSessionComments() {
	return this.sessionComments;
}

public void setSessionComments(List<SessionComment> value) {
	this.sessionComments = value;
}



	//////////////////////////////////////////////////////
	// Source Relationships
	//////////////////////////////////////////////////////
	
@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@JoinColumn(name="CORRECTIVE_ACTION_STATE_ID")
@org.hibernate.annotations.ForeignKey(name="FK_CorrectiveActionStateOfCorrectiveAction")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private CorrectiveActionState correctiveActionState;
public CorrectiveActionState getCorrectiveActionState() {
	return this.correctiveActionState;
}

public void setCorrectiveActionState(CorrectiveActionState value) {
	this.correctiveActionState = value;
}
@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@JoinColumn(name="CORRECTIVE_ACTION_TYPE_ID")
@org.hibernate.annotations.ForeignKey(name="FK_CorrectiveActionTypeOfCorrectiveAction")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private CorrectiveActionType correctiveActionType;
public CorrectiveActionType getCorrectiveActionType() {
	return this.correctiveActionType;
}

public void setCorrectiveActionType(CorrectiveActionType value) {
	this.correctiveActionType = value;
}
@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@JoinColumn(name="AGENT_ID")
@org.hibernate.annotations.ForeignKey(name="FK_AgentOfCorrectiveAction")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private Agent agent;
public Agent getAgent() {
	return this.agent;
}

public void setAgent(Agent value) {
	this.agent = value;
}
@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@JoinColumn(name="SUPERVISOR_MANAGER_EMPLOYEE_ID")
@org.hibernate.annotations.ForeignKey(name="FK_SupervisorManagerEmployeeOfSupervisorCorrectiveAction")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private Employee supervisorManagerEmployee;
public Employee getSupervisorManagerEmployee() {
	return this.supervisorManagerEmployee;
}

public void setSupervisorManagerEmployee(Employee value) {
	this.supervisorManagerEmployee = value;
}
@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@JoinColumn(name="HR_EMPLOYEE_ID")
@org.hibernate.annotations.ForeignKey(name="FK_HREmployeeOfHRCorrectiveAction")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private Employee hREmployee;
public Employee getHREmployee() {
	return this.hREmployee;
}

public void setHREmployee(Employee value) {
	this.hREmployee = value;
}
@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@JoinColumn(name="MANAGER_EMPLOYEE_ID")
@org.hibernate.annotations.ForeignKey(name="FK_ManagerEmployeeOfManagerCorrectiveAction")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private Employee managerEmployee;
public Employee getManagerEmployee() {
	return this.managerEmployee;
}

public void setManagerEmployee(Employee value) {
	this.managerEmployee = value;
}
@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@JoinColumn(name="SUPERVISOR_ID")
@org.hibernate.annotations.ForeignKey(name="FK_SupervisorOfCorrectiveAction")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private Supervisor supervisor;
public Supervisor getSupervisor() {
	return this.supervisor;
}

public void setSupervisor(Supervisor value) {
	this.supervisor = value;
}

	
	//////////////////////////////////////////////////////
	// JSON
	//////////////////////////////////////////////////////
	@Override
	public String retrieveJson(ObjectMapper objectMapper) {
		String objectJson = super.retrieveJson(objectMapper);

		// Properties		
		//Retrieve value of the Manager Approval Date property
		objectJson += ",\"managerApprovalDate\":";
		if (getManagerApprovalDate() == null)
			objectJson += "null";
		else {
			objectJson += getManagerApprovalDate().getTime();
		}
		//Retrieve value of the Discipline Type property
		objectJson += ",\"disciplineType\":";
		
		if (getDisciplineType() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getDisciplineType());
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
		//Retrieve value of the Attachment Id property
		objectJson += ",\"attachmentId\":";
		
		if (getAttachmentId() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getAttachmentId());
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
		//Retrieve value of the Client Id property
		objectJson += ",\"clientId\":";
		
		if (getClientId() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getClientId());
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
		//Retrieve value of the Reason Type property
		objectJson += ",\"reasonType\":";
		
		if (getReasonType() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getReasonType());
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
		//Retrieve value of the Reason property
		objectJson += ",\"reason\":";
		
		if (getReason() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getReason());
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
		//Retrieve value of the Details Config property
		objectJson += ",\"detailsConfig\":";
		
		if (getDetailsConfig() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getDetailsConfig());
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
		//Retrieve value of the Supervisor Config property
		objectJson += ",\"supervisorConfig\":";
		
		if (getSupervisorConfig() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getSupervisorConfig());
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
		//Retrieve value of the Created On property
		objectJson += ",\"createdOn\":";
		if (getCreatedOn() == null)
			objectJson += "null";
		else {
			objectJson += getCreatedOn().getTime();
		}

		//Retrieve value of the Updated On property
		objectJson += ",\"updatedOn\":";
		if (getUpdatedOn() == null)
			objectJson += "null";
		else {
			objectJson += getUpdatedOn().getTime();
		}
		//Retrieve value of the Completion Date property
		objectJson += ",\"completionDate\":";
		if (getCompletionDate() == null)
			objectJson += "null";
		else {
			objectJson += getCompletionDate().getTime();
		}
		//Retrieve value of the Attachment Name property
		objectJson += ",\"attachmentName\":";
		
		if (getAttachmentName() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getAttachmentName());
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
		//Retrieve value of the created by property
		objectJson += ",\"createdBy\":";

		if (getCreatedBy() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getCreatedBy());
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
		//Retrieve value of the Attachment Name property
		objectJson += ",\"updatedBy\":";

		if (getUpdatedBy() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getUpdatedBy());
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
		//Retrieve value of the Supervisor ACK Date property
		objectJson += ",\"supervisorACKDate\":";
		if (getSupervisorACKDate() == null)
			objectJson += "null";
		else {
			objectJson += getSupervisorACKDate().getTime();
		}
		//Retrieve value of the Program property
		objectJson += ",\"program\":";
		
		if (getProgram() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getProgram());
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
		//Retrieve value of the Session Id property
		objectJson += ",\"sessionId\":";
		
		if (getSessionId() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getSessionId());
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
		//Retrieve value of the Next Steps property
		objectJson += ",\"nextSteps\":";
		
		if (getNextSteps() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getNextSteps());
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
		//Retrieve value of the Metric Ref property
		objectJson += ",\"metricRef\":";
		
		if (getMetricRef() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getMetricRef());
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
		//Retrieve value of the Employee Ack property
		objectJson += ",\"employeeAck\":";
		
		if (getEmployeeAck() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getEmployeeAck());
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
		//Retrieve value of the Expire Date property
		objectJson += ",\"expireDate\":";
		if (getExpireDate() == null)
			objectJson += "null";
		else {
			objectJson += getExpireDate().getTime();
		}
		//Retrieve value of the HR Approval Date property
		objectJson += ",\"hRApprovalDate\":";
		if (getHRApprovalDate() == null)
			objectJson += "null";
		else {
			objectJson += getHRApprovalDate().getTime();
		}
		//Retrieve value of the Form Id property
		objectJson += ",\"formId\":";
		
		if (getFormId() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getFormId());
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
//Retrieve value of the Supervisor Manager Employee of Supervisor Corrective Action relationship
objectJson += ",\"supervisorManagerEmployee\":";
		if (getSupervisorManagerEmployee() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getSupervisorManagerEmployee()).toEmbeddedJson();
			} catch(Exception e) {
				objectJson += "null";
			}
		}
		objectJson += "";
//Retrieve value of the HR Employee of HR Corrective Action relationship
objectJson += ",\"hREmployee\":";
		if (getHREmployee() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getHREmployee()).toEmbeddedJson();
			} catch(Exception e) {
				objectJson += "null";
			}
		}
		objectJson += "";
//Retrieve value of the Manager Employee of Manager Corrective Action relationship
objectJson += ",\"managerEmployee\":";
		if (getManagerEmployee() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getManagerEmployee()).toEmbeddedJson();
			} catch(Exception e) {
				objectJson += "null";
			}
		}
		objectJson += "";
//Retrieve value of the Supervisor of Corrective Action relationship
objectJson += ",\"supervisor\":";
		if (getSupervisor() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getSupervisor()).toEmbeddedJson();
			} catch(Exception e) {
				objectJson += "null";
			}
		}
		objectJson += "";

		
		// Target Relationships
//Retrieve value of the Corrective Action of Corrective Action Attachment relationship
objectJson += ",\"correctiveActionAttachments\":[";
		
		if (getCorrectiveActionAttachments() != null) {
			int correctiveActionAttachmentsCounter = 0;
			for(CorrectiveActionAttachment nextCorrectiveActionAttachments : getCorrectiveActionAttachments()) {
				if (correctiveActionAttachmentsCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextCorrectiveActionAttachments).toEmbeddedJson();
					correctiveActionAttachmentsCounter++;
				} catch(Exception e) {
					// Do nothing.
				}
			}
		}
		objectJson += "]";
//Retrieve value of the Corrective Action of Session Comment relationship
objectJson += ",\"sessionComments\":[";
		
		if (getSessionComments() != null) {
			int sessionCommentsCounter = 0;
			for(SessionComment nextSessionComments : getSessionComments()) {
				if (sessionCommentsCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextSessionComments).toEmbeddedJson();
					sessionCommentsCounter++;
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
		//From value of the Manager Approval Date property
		setManagerApprovalDate(JsonUtils.getJsonDate(jsonObject, "managerApprovalDate"));
		//From value of the Discipline Type property
		setDisciplineType(JsonUtils.getJsonInteger(jsonObject, "disciplineType"));
		//From value of the Attachment Id property
		setAttachmentId(JsonUtils.getJsonInteger(jsonObject, "attachmentId"));
		//From value of the Client Id property
		setClientId(JsonUtils.getJsonInteger(jsonObject, "clientId"));
		//From value of the Reason Type property
		setReasonType(JsonUtils.getJsonString(jsonObject, "reasonType"));
		//From value of the Reason property
		setReason(JsonUtils.getJsonString(jsonObject, "reason"));
		//From value of the Details Config property
		setDetailsConfig(JsonUtils.getJsonString(jsonObject, "detailsConfig"));
		//From value of the Supervisor Config property
		setSupervisorConfig(JsonUtils.getJsonString(jsonObject, "supervisorConfig"));
		//From value of the Created On property
		setCreatedOn(JsonUtils.getJsonDate(jsonObject, "createdOn"));
		//From value of the Updated On property
		setUpdatedOn(JsonUtils.getJsonDate(jsonObject, "updatedOn"));
		//From value of the Attachment Name property
		setUpdatedBy(JsonUtils.getJsonString(jsonObject, "updatedBy"));
		//From value of the Attachment Name property
		setCreatedBy(JsonUtils.getJsonString(jsonObject, "createdBy"));
		//From value of the Completion Date property
		setCompletionDate(JsonUtils.getJsonDate(jsonObject, "completionDate"));
		//From value of the Attachment Name property
		setAttachmentName(JsonUtils.getJsonString(jsonObject, "attachmentName"));
		//From value of the Supervisor ACK Date property
		setSupervisorACKDate(JsonUtils.getJsonDate(jsonObject, "supervisorACKDate"));
		//From value of the Program property
		setProgram(JsonUtils.getJsonString(jsonObject, "program"));
		//From value of the Session Id property
		setSessionId(JsonUtils.getJsonString(jsonObject, "sessionId"));
		//From value of the Next Steps property
		setNextSteps(JsonUtils.getJsonString(jsonObject, "nextSteps"));
		//From value of the Metric Ref property
		setMetricRef(JsonUtils.getJsonString(jsonObject, "metricRef"));
		//From value of the Employee Ack property
		setEmployeeAck(JsonUtils.getJsonString(jsonObject, "employeeAck"));
		//From value of the Expire Date property
		setExpireDate(JsonUtils.getJsonDate(jsonObject, "expireDate"));
		//From value of the HR Approval Date property
		setHRApprovalDate(JsonUtils.getJsonDate(jsonObject, "hRApprovalDate"));
		//From value of the Form Id property
		setFormId(JsonUtils.getJsonInteger(jsonObject, "formId"));

		
		// Source Relationships
		this.correctiveActionState = (CorrectiveActionState) JsonUtils.getJsonPerceroObject(jsonObject, "correctiveActionState");
		this.correctiveActionType = (CorrectiveActionType) JsonUtils.getJsonPerceroObject(jsonObject, "correctiveActionType");
		this.agent = (Agent) JsonUtils.getJsonPerceroObject(jsonObject, "agent");
		this.supervisorManagerEmployee = (Employee) JsonUtils.getJsonPerceroObject(jsonObject, "supervisorManagerEmployee");
		this.hREmployee = (Employee) JsonUtils.getJsonPerceroObject(jsonObject, "hREmployee");
		this.managerEmployee = (Employee) JsonUtils.getJsonPerceroObject(jsonObject, "managerEmployee");
		this.supervisor = (Supervisor) JsonUtils.getJsonPerceroObject(jsonObject, "supervisor");


		// Target Relationships
		this.correctiveActionAttachments = (List<CorrectiveActionAttachment>) JsonUtils.getJsonListPerceroObject(jsonObject, "correctiveActionAttachments");
		this.sessionComments = (List<SessionComment>) JsonUtils.getJsonListPerceroObject(jsonObject, "sessionComments");


	}
	
	@Override
	protected List<MappedClassMethodPair> getListSetters() {
		List<MappedClassMethodPair> listSetters = super.getListSetters();

		// Target Relationships
		listSetters.add(MappedClass.getFieldSetters(CorrectiveActionAttachment.class, "correctiveaction"));
		listSetters.add(MappedClass.getFieldSetters(SessionComment.class, "correctiveaction"));

		
		return listSetters;
	}
}

