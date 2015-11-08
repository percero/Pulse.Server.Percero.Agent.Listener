
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
public class _Super_Schedule extends BaseDataObject implements Serializable
{
	//////////////////////////////////////////////////////
	// VERSION
	//////////////////////////////////////////////////////
	@Override
	public String classVersion() {
		return "1.0.0";
	}

	
	/*
	Keys of Schedule
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
TotalTime
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Double totalTime;

public Double getTotalTime() 
{
	return this.totalTime;
}

public void setTotalTime(Double totalTime)
{
	this.totalTime = totalTime;
}/*
StateName
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String stateName;

public String getStateName() 
{
	return this.stateName;
}

public void setStateName(String stateName)
{
	this.stateName = stateName;
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
Shift
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Integer shift;

public Integer getShift() 
{
	return this.shift;
}

public void setShift(Integer shift)
{
	this.shift = shift;
}

	//////////////////////////////////////////////////////
	// Target Relationships
	//////////////////////////////////////////////////////
	@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@OneToMany(fetch=FetchType.LAZY, targetEntity=ScheduleEntry.class, mappedBy="schedule", cascade=javax.persistence.CascadeType.REMOVE)
private List<ScheduleEntry> scheduleEntries;
public List<ScheduleEntry> getScheduleEntries() {
	return this.scheduleEntries;
}

public void setScheduleEntries(List<ScheduleEntry> value) {
	this.scheduleEntries = value;
}



	//////////////////////////////////////////////////////
	// Source Relationships
	//////////////////////////////////////////////////////
	@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@JoinColumn(name="PAYROLL")
@org.hibernate.annotations.ForeignKey(name="FK_AgentOfSchedule")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private Agent agent;
public Agent getAgent() {
	return this.agent;
}

public void setAgent(Agent value) {
	this.agent = value;
}

	
	//////////////////////////////////////////////////////
	// JSON
	//////////////////////////////////////////////////////
	@Override
	public String retrieveJson(ObjectMapper objectMapper) {
		String objectJson = super.retrieveJson(objectMapper);

		// Properties		
		//Retrieve value of the End Time property
		objectJson += ",\"endTime\":";
		if (getEndTime() == null)
			objectJson += "null";
		else {
			objectJson += getEndTime().getTime();
		}
		//Retrieve value of the Total Time property
		objectJson += ",\"totalTime\":";
		if (getTotalTime() == null)
			objectJson += "null";
		else {
			objectJson += getTotalTime();
		}
		//Retrieve value of the State Name property
		objectJson += ",\"stateName\":";
		
		if (getStateName() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getStateName());
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
		//Retrieve value of the End Date property
		objectJson += ",\"endDate\":";
		if (getEndDate() == null)
			objectJson += "null";
		else {
			objectJson += getEndDate().getTime();
		}
		//Retrieve value of the Start Time property
		objectJson += ",\"startTime\":";
		if (getStartTime() == null)
			objectJson += "null";
		else {
			objectJson += getStartTime().getTime();
		}
		//Retrieve value of the Start Date property
		objectJson += ",\"startDate\":";
		if (getStartDate() == null)
			objectJson += "null";
		else {
			objectJson += getStartDate().getTime();
		}
		//Retrieve value of the Shift property
		objectJson += ",\"shift\":";
		
		if (getShift() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getShift());
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
//Retrieve value of the Agent of Schedule relationship
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

		
		// Target Relationships
//Retrieve value of the Schedule of Schedule Entry relationship
objectJson += ",\"scheduleEntries\":[";
		
		if (getScheduleEntries() != null) {
			int scheduleEntriesCounter = 0;
			for(ScheduleEntry nextScheduleEntries : getScheduleEntries()) {
				if (scheduleEntriesCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextScheduleEntries).toEmbeddedJson();
					scheduleEntriesCounter++;
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
		//From value of the End Time property
		setEndTime(JsonUtils.getJsonDate(jsonObject, "endTime"));
		//From value of the Total Time property
		setTotalTime(JsonUtils.getJsonDouble(jsonObject, "totalTime"));
		//From value of the State Name property
		setStateName(JsonUtils.getJsonString(jsonObject, "stateName"));
		//From value of the End Date property
		setEndDate(JsonUtils.getJsonDate(jsonObject, "endDate"));
		//From value of the Start Time property
		setStartTime(JsonUtils.getJsonDate(jsonObject, "startTime"));
		//From value of the Start Date property
		setStartDate(JsonUtils.getJsonDate(jsonObject, "startDate"));
		//From value of the Shift property
		setShift(JsonUtils.getJsonInteger(jsonObject, "shift"));

		
		// Source Relationships
		this.agent = (Agent) JsonUtils.getJsonPerceroObject(jsonObject, "agent");


		// Target Relationships
		this.scheduleEntries = (List<ScheduleEntry>) JsonUtils.getJsonListPerceroObject(jsonObject, "scheduleEntries");


	}
	
	@Override
	protected List<MappedClassMethodPair> getListSetters() {
		List<MappedClassMethodPair> listSetters = super.getListSetters();

		// Target Relationships
		listSetters.add(MappedClass.getFieldSetters(ScheduleEntry.class, "schedule"));

		
		return listSetters;
	}
}
