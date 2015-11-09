
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
public class _Super_ScheduleEntry extends BaseDataObject implements Serializable
{
	//////////////////////////////////////////////////////
	// VERSION
	//////////////////////////////////////////////////////
	@Override
	public String classVersion() {
		return "1.0.0";
	}

	
	/*
	Keys of ScheduleEntry
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
Project
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String project;

public String getProject() 
{
	return this.project;
}

public void setProject(String project)
{
	this.project = project;
}/*
StartDate
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Date startDate;

public Date getStartDate() 
{
	return this.startDate;
}

public void setStartDate(Date startDate)
{
	this.startDate = startDate;
}/*
EndTime
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Date endTime;

public Date getEndTime() 
{
	return this.endTime;
}

public void setEndTime(Date endTime)
{
	this.endTime = endTime;
}/*
Position
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String position;

public String getPosition() 
{
	return this.position;
}

public void setPosition(String position)
{
	this.position = position;
}/*
CostPOSIndex
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Integer costPOSIndex;

public Integer getCostPOSIndex() 
{
	return this.costPOSIndex;
}

public void setCostPOSIndex(Integer costPOSIndex)
{
	this.costPOSIndex = costPOSIndex;
}/*
StartTime
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Date startTime;

public Date getStartTime() 
{
	return this.startTime;
}

public void setStartTime(Date startTime)
{
	this.startTime = startTime;
}/*
ModifiedTimestamp
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Date modifiedTimestamp;

public Date getModifiedTimestamp() 
{
	return this.modifiedTimestamp;
}

public void setModifiedTimestamp(Date modifiedTimestamp)
{
	this.modifiedTimestamp = modifiedTimestamp;
}/*
Duration
Notes:Number of minutes
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Double duration;

public Double getDuration() 
{
	return this.duration;
}

public void setDuration(Double duration)
{
	this.duration = duration;
}/*
EndDate
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Date endDate;

public Date getEndDate() 
{
	return this.endDate;
}

public void setEndDate(Date endDate)
{
	this.endDate = endDate;
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
@JoinColumn(name="PAYROLL")
@org.hibernate.annotations.ForeignKey(name="FK_AgentOfScheduleEntry")
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
@JoinColumn(name="SCHEDULE_ID")
@org.hibernate.annotations.ForeignKey(name="FK_ScheduleOfScheduleEntry")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private Schedule schedule;
public Schedule getSchedule() {
	return this.schedule;
}

public void setSchedule(Schedule value) {
	this.schedule = value;
}

	
	//////////////////////////////////////////////////////
	// JSON
	//////////////////////////////////////////////////////
	@Override
	public String retrieveJson(ObjectMapper objectMapper) {
		String objectJson = super.retrieveJson(objectMapper);

		// Properties		
		//Retrieve value of the Project property
		objectJson += ",\"project\":";
		
		if (getProject() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getProject());
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
		//Retrieve value of the Start Date property
		objectJson += ",\"startDate\":";
		if (getStartDate() == null)
			objectJson += "null";
		else {
			objectJson += getStartDate().getTime();
		}
		//Retrieve value of the End Time property
		objectJson += ",\"endTime\":";
		if (getEndTime() == null)
			objectJson += "null";
		else {
			objectJson += getEndTime().getTime();
		}
		//Retrieve value of the Position property
		objectJson += ",\"position\":";
		
		if (getPosition() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getPosition());
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
		//Retrieve value of the Cost POS Index property
		objectJson += ",\"costPOSIndex\":";
		
		if (getCostPOSIndex() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getCostPOSIndex());
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
		//Retrieve value of the Start Time property
		objectJson += ",\"startTime\":";
		if (getStartTime() == null)
			objectJson += "null";
		else {
			objectJson += getStartTime().getTime();
		}
		//Retrieve value of the Modified Timestamp property
		objectJson += ",\"modifiedTimestamp\":";
		if (getModifiedTimestamp() == null)
			objectJson += "null";
		else {
			objectJson += getModifiedTimestamp().getTime();
		}
		//Retrieve value of the Duration property
		objectJson += ",\"duration\":";
		if (getDuration() == null)
			objectJson += "null";
		else {
			objectJson += getDuration();
		}
		//Retrieve value of the End Date property
		objectJson += ",\"endDate\":";
		if (getEndDate() == null)
			objectJson += "null";
		else {
			objectJson += getEndDate().getTime();
		}

				
		// Source Relationships
//Retrieve value of the Agent of Schedule Entry relationship
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
//Retrieve value of the Schedule of Schedule Entry relationship
objectJson += ",\"schedule\":";
		if (getSchedule() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getSchedule()).toEmbeddedJson();
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
		//From value of the Project property
		setProject(JsonUtils.getJsonString(jsonObject, "project"));
		//From value of the Start Date property
		setStartDate(JsonUtils.getJsonDate(jsonObject, "startDate"));
		//From value of the End Time property
		setEndTime(JsonUtils.getJsonDate(jsonObject, "endTime"));
		//From value of the Position property
		setPosition(JsonUtils.getJsonString(jsonObject, "position"));
		//From value of the Cost POS Index property
		setCostPOSIndex(JsonUtils.getJsonInteger(jsonObject, "costPOSIndex"));
		//From value of the Start Time property
		setStartTime(JsonUtils.getJsonDate(jsonObject, "startTime"));
		//From value of the Modified Timestamp property
		setModifiedTimestamp(JsonUtils.getJsonDate(jsonObject, "modifiedTimestamp"));
		//From value of the Duration property
		setDuration(JsonUtils.getJsonDouble(jsonObject, "duration"));
		//From value of the End Date property
		setEndDate(JsonUtils.getJsonDate(jsonObject, "endDate"));

		
		// Source Relationships
		this.agent = (Agent) JsonUtils.getJsonPerceroObject(jsonObject, "agent");
		this.schedule = (Schedule) JsonUtils.getJsonPerceroObject(jsonObject, "schedule");


		// Target Relationships


	}
	
	@Override
	protected List<MappedClassMethodPair> getListSetters() {
		List<MappedClassMethodPair> listSetters = super.getListSetters();

		// Target Relationships

		
		return listSetters;
	}
}
