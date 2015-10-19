
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
public class _Super_DevelopmentActivity extends BaseDataObject implements Serializable
{
	//////////////////////////////////////////////////////
	// VERSION
	//////////////////////////////////////////////////////
	@Override
	public String classVersion() {
		return "1.0.0";
	}

	
	/*
	Keys of DevelopmentActivity
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
Status
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String status;

public String getStatus() 
{
	return this.status;
}

public void setStatus(String status)
{
	this.status = status;
}/*
UpdatedBy
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
PlanId
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String planId;

public String getPlanId() 
{
	return this.planId;
}

public void setPlanId(String planId)
{
	this.planId = planId;
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
WeekDate
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Date weekDate;

public Date getWeekDate() 
{
	return this.weekDate;
}

public void setWeekDate(Date weekDate)
{
	this.weekDate = weekDate;
}/*
Name
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String name;

public String getName() 
{
	return this.name;
}

public void setName(String name)
{
	this.name = name;
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
CompletedOn
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Date completedOn;

public Date getCompletedOn() 
{
	return this.completedOn;
}

public void setCompletedOn(Date completedOn)
{
	this.completedOn = completedOn;
}/*
CreatedBy
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String createdBy;

public String getCreatedBy() 
{
	return this.createdBy;
}

public void setCreatedBy(String createdBy)
{
	this.createdBy = createdBy;
}/*
Type
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String type;

public String getType() 
{
	return this.type;
}

public void setType(String type)
{
	this.type = type;
}/*
DueDate
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Date dueDate;

public Date getDueDate() 
{
	return this.dueDate;
}

public void setDueDate(Date dueDate)
{
	this.dueDate = dueDate;
}

	//////////////////////////////////////////////////////
	// Target Relationships
	//////////////////////////////////////////////////////
	

	//////////////////////////////////////////////////////
	// Source Relationships
	//////////////////////////////////////////////////////
	@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@JoinColumn(name="AGENT_ID")
@org.hibernate.annotations.ForeignKey(name="FK_AgentOfDevelopmentActivity")
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
@JoinColumn(name="DEVELOPMENT_PLAN_ID")
@org.hibernate.annotations.ForeignKey(name="FK_DevelopmentPlanOfDevelopmentActivity")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private DevelopmentPlan developmentPlan;
public DevelopmentPlan getDevelopmentPlan() {
	return this.developmentPlan;
}

public void setDevelopmentPlan(DevelopmentPlan value) {
	this.developmentPlan = value;
}@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@JoinColumn(name="TEAM_LEADER_ID")
@org.hibernate.annotations.ForeignKey(name="FK_TeamLeaderOfDevelopmentActivity")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private TeamLeader teamLeader;
public TeamLeader getTeamLeader() {
	return this.teamLeader;
}

public void setTeamLeader(TeamLeader value) {
	this.teamLeader = value;
}

	
	//////////////////////////////////////////////////////
	// JSON
	//////////////////////////////////////////////////////
	@Override
	public String retrieveJson(ObjectMapper objectMapper) {
		String objectJson = super.retrieveJson(objectMapper);

		// Properties		
		//Retrieve value of the Status property
		objectJson += ",\"status\":";
		
		if (getStatus() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getStatus());
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
		//Retrieve value of the Updated By property
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
		//Retrieve value of the Plan Id property
		objectJson += ",\"planId\":";
		
		if (getPlanId() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getPlanId());
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
		//Retrieve value of the Week Date property
		objectJson += ",\"weekDate\":";
		if (getWeekDate() == null)
			objectJson += "null";
		else {
			objectJson += getWeekDate().getTime();
		}
		//Retrieve value of the Name property
		objectJson += ",\"name\":";
		
		if (getName() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getName());
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
		//Retrieve value of the Updated On property
		objectJson += ",\"updatedOn\":";
		if (getUpdatedOn() == null)
			objectJson += "null";
		else {
			objectJson += getUpdatedOn().getTime();
		}
		//Retrieve value of the Completed On property
		objectJson += ",\"completedOn\":";
		if (getCompletedOn() == null)
			objectJson += "null";
		else {
			objectJson += getCompletedOn().getTime();
		}
		//Retrieve value of the Created By property
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
		//Retrieve value of the Type property
		objectJson += ",\"type\":";
		
		if (getType() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getType());
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
		//Retrieve value of the Due Date property
		objectJson += ",\"dueDate\":";
		if (getDueDate() == null)
			objectJson += "null";
		else {
			objectJson += getDueDate().getTime();
		}

				
		// Source Relationships
//Retrieve value of the Agent of Development Activity relationship
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
//Retrieve value of the Development Plan of Development Activity relationship
objectJson += ",\"developmentPlan\":";
		if (getDevelopmentPlan() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getDevelopmentPlan()).toEmbeddedJson();
			} catch(Exception e) {
				objectJson += "null";
			}
		}
		objectJson += "";
//Retrieve value of the Team Leader of Development Activity relationship
objectJson += ",\"teamLeader\":";
		if (getTeamLeader() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getTeamLeader()).toEmbeddedJson();
			} catch(Exception e) {
				objectJson += "null";
			}
		}
		objectJson += "";

		
		// Target Relationships

		
		return objectJson;
	}


	@Override
	protected void fromJson(JsonObject jsonObject) {
	    super.fromJson(jsonObject);

		// Properties
		//From value of the Status property
		setStatus(JsonUtils.getJsonString(jsonObject, "status"));
		//From value of the Updated By property
		setUpdatedBy(JsonUtils.getJsonString(jsonObject, "updatedBy"));
		//From value of the Plan Id property
		setPlanId(JsonUtils.getJsonString(jsonObject, "planId"));
		//From value of the Created On property
		setCreatedOn(JsonUtils.getJsonDate(jsonObject, "createdOn"));
		//From value of the Week Date property
		setWeekDate(JsonUtils.getJsonDate(jsonObject, "weekDate"));
		//From value of the Name property
		setName(JsonUtils.getJsonString(jsonObject, "name"));
		//From value of the Updated On property
		setUpdatedOn(JsonUtils.getJsonDate(jsonObject, "updatedOn"));
		//From value of the Completed On property
		setCompletedOn(JsonUtils.getJsonDate(jsonObject, "completedOn"));
		//From value of the Created By property
		setCreatedBy(JsonUtils.getJsonString(jsonObject, "createdBy"));
		//From value of the Type property
		setType(JsonUtils.getJsonString(jsonObject, "type"));
		//From value of the Due Date property
		setDueDate(JsonUtils.getJsonDate(jsonObject, "dueDate"));

		
		// Source Relationships
		this.agent = (Agent) JsonUtils.getJsonPerceroObject(jsonObject, "agent");
		this.developmentPlan = (DevelopmentPlan) JsonUtils.getJsonPerceroObject(jsonObject, "developmentPlan");
		this.teamLeader = (TeamLeader) JsonUtils.getJsonPerceroObject(jsonObject, "teamLeader");


		// Target Relationships


	}
	
	@Override
	protected List<MappedClassMethodPair> getListSetters() {
		List<MappedClassMethodPair> listSetters = super.getListSetters();

		// Target Relationships

		
		return listSetters;
	}
}
