
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

private Date hRApprovalDate;

public Date getHRApprovalDate() 
{
	return this.hRApprovalDate;
}

public void setHRApprovalDate(Date hRApprovalDate)
{
	this.hRApprovalDate = hRApprovalDate;
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
}@com.percero.agents.sync.metadata.annotations.Externalize
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
}@com.percero.agents.sync.metadata.annotations.Externalize
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
}@com.percero.agents.sync.metadata.annotations.Externalize
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
}@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@JoinColumn(name="SUPERVISORMANAGER_EMPLOYEE_ID")
@org.hibernate.annotations.ForeignKey(name="FK_SupervisorManagerEmployeeOfSupervisorCorrectiveAction")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private Employee supervisorManagerEmployee;
public Employee getSupervisorManagerEmployee() {
	return this.supervisorManagerEmployee;
}

public void setSupervisorManagerEmployee(Employee value) {
	this.supervisorManagerEmployee = value;
}@com.percero.agents.sync.metadata.annotations.Externalize
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
}@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@JoinColumn(name="SUPERVISOR_ID")
@org.hibernate.annotations.ForeignKey(name="FK_SupervisorOfCorrectiveAction")
@OneToOne(fetch=FetchType.LAZY, optional=false)
private Supervisor supervisor;
public Supervisor getSupervisor() {
	return this.supervisor;
}

public void setSupervisor(Supervisor value) 
{
	this.supervisor = value;
}

	
	//////////////////////////////////////////////////////
	// JSON
	//////////////////////////////////////////////////////
	@Override
	public String retrieveJson(ObjectMapper objectMapper) {
		String objectJson = super.retrieveJson(objectMapper);

		// Properties		
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
		//Retrieve value of the Manager Approval Date property
		objectJson += ",\"managerApprovalDate\":";
		if (getManagerApprovalDate() == null)
			objectJson += "null";
		else {
			objectJson += getManagerApprovalDate().getTime();
		}
		//Retrieve value of the Supervisor ACK Date property
		objectJson += ",\"supervisorACKDate\":";
		if (getSupervisorACKDate() == null)
			objectJson += "null";
		else {
			objectJson += getSupervisorACKDate().getTime();
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

		
		return objectJson;
	}


	@Override
	protected void fromJson(JsonObject jsonObject) {
	    super.fromJson(jsonObject);

		// Properties
		//From value of the Supervisor Comment property
		setSupervisorComment(JsonUtils.getJsonString(jsonObject, "supervisorComment"));
		//From value of the Completion Date property
		setCompletionDate(JsonUtils.getJsonDate(jsonObject, "completionDate"));
		//From value of the Employee Comment property
		setEmployeeComment(JsonUtils.getJsonString(jsonObject, "employeeComment"));
		//From value of the Details property
		setDetails(JsonUtils.getJsonString(jsonObject, "details"));
		//From value of the Manager Approval Date property
		setManagerApprovalDate(JsonUtils.getJsonDate(jsonObject, "managerApprovalDate"));
		//From value of the Supervisor ACK Date property
		setSupervisorACKDate(JsonUtils.getJsonDate(jsonObject, "supervisorACKDate"));
		//From value of the Client Id property
		setClientId(JsonUtils.getJsonInteger(jsonObject, "clientId"));
		//From value of the Expire Date property
		setExpireDate(JsonUtils.getJsonDate(jsonObject, "expireDate"));
		//From value of the HR Approval Date property
		setHRApprovalDate(JsonUtils.getJsonDate(jsonObject, "hRApprovalDate"));

		
		// Source Relationships
		this.correctiveActionState = (CorrectiveActionState) JsonUtils.getJsonPerceroObject(jsonObject, "correctiveActionState");
		this.correctiveActionType = (CorrectiveActionType) JsonUtils.getJsonPerceroObject(jsonObject, "correctiveActionType");
		this.agent = (Agent) JsonUtils.getJsonPerceroObject(jsonObject, "agent");
		this.managerEmployee = (Employee) JsonUtils.getJsonPerceroObject(jsonObject, "managerEmployee");
		this.supervisorManagerEmployee = (Employee) JsonUtils.getJsonPerceroObject(jsonObject, "supervisorManagerEmployee");
		this.hREmployee = (Employee) JsonUtils.getJsonPerceroObject(jsonObject, "hREmployee");
		this.supervisor = (Supervisor) JsonUtils.getJsonPerceroObject(jsonObject, "supervisor");


		// Target Relationships
		this.correctiveActionAttachments = (List<CorrectiveActionAttachment>) JsonUtils.getJsonListPerceroObject(jsonObject, "correctiveActionAttachments");


	}
	
	@Override
	protected List<MappedClassMethodPair> getListSetters() {
		List<MappedClassMethodPair> listSetters = super.getListSetters();

		// Target Relationships
		listSetters.add(MappedClass.getFieldSetters(CorrectiveActionAttachment.class, "correctiveaction"));

		
		return listSetters;
	}
}
