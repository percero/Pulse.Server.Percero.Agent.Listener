
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
public class _Super_ScheduledTimeEntry extends BaseDataObject implements Serializable
{
	//////////////////////////////////////////////////////
	// VERSION
	//////////////////////////////////////////////////////
	@Override
	public String classVersion() {
		return "1.0.0";
	}

	
	/*
	Keys of ScheduledTimeEntry
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
ActivityTypeName
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String activityTypeName;

public String getActivityTypeName() 
{
	return this.activityTypeName;
}

public void setActivityTypeName(String activityTypeName)
{
	this.activityTypeName = activityTypeName;
}/*
ToTime
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Date toTime;

public Date getToTime() 
{
	return this.toTime;
}

public void setToTime(Date toTime)
{
	this.toTime = toTime;
}/*
FromTime
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Date fromTime;

public Date getFromTime() 
{
	return this.fromTime;
}

public void setFromTime(Date fromTime)
{
	this.fromTime = fromTime;
}/*
Duration
Notes:Number of minutes
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Integer duration;

public Integer getDuration() 
{
	return this.duration;
}

public void setDuration(Integer duration)
{
	this.duration = duration;
}

	//////////////////////////////////////////////////////
	// Target Relationships
	//////////////////////////////////////////////////////
	

	//////////////////////////////////////////////////////
	// Source Relationships
	//////////////////////////////////////////////////////
	@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@JoinColumn(name="SCHEDULED_ACTIVITY_CODE_ID")
@org.hibernate.annotations.ForeignKey(name="FK_ScheduledActivityCodeOfScheduledTimeEntry")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private ScheduledActivityCode scheduledActivityCode;
public ScheduledActivityCode getScheduledActivityCode() {
	return this.scheduledActivityCode;
}

public void setScheduledActivityCode(ScheduledActivityCode value) {
	this.scheduledActivityCode = value;
}@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@JoinColumn(name="SCHEDULED_ACTIVITY_TYPE_ID")
@org.hibernate.annotations.ForeignKey(name="FK_ScheduledActivityTypeOfScheduledTimeEntry")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private ScheduledActivityType scheduledActivityType;
public ScheduledActivityType getScheduledActivityType() {
	return this.scheduledActivityType;
}

public void setScheduledActivityType(ScheduledActivityType value) {
	this.scheduledActivityType = value;
}@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@JoinColumn(name="SCHEDULED_TIME_ID")
@org.hibernate.annotations.ForeignKey(name="FK_ScheduledTimeOfScheduledTimeEntry")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private ScheduledTime scheduledTime;
public ScheduledTime getScheduledTime() {
	return this.scheduledTime;
}

public void setScheduledTime(ScheduledTime value) {
	this.scheduledTime = value;
}

	
	//////////////////////////////////////////////////////
	// JSON
	//////////////////////////////////////////////////////
	@Override
	public String retrieveJson(ObjectMapper objectMapper) {
		String objectJson = super.retrieveJson(objectMapper);

		// Properties		
		//Retrieve value of the Activity Type Name property
		objectJson += ",\"activityTypeName\":";
		
		if (getActivityTypeName() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getActivityTypeName());
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
		//Retrieve value of the To Time property
		objectJson += ",\"toTime\":";
		if (getToTime() == null)
			objectJson += "null";
		else {
			objectJson += getToTime().getTime();
		}
		//Retrieve value of the From Time property
		objectJson += ",\"fromTime\":";
		if (getFromTime() == null)
			objectJson += "null";
		else {
			objectJson += getFromTime().getTime();
		}
		//Retrieve value of the Duration property
		objectJson += ",\"duration\":";
		
		if (getDuration() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getDuration());
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
//Retrieve value of the Scheduled Activity Code of Scheduled Time Entry relationship
objectJson += ",\"scheduledActivityCode\":";
		if (getScheduledActivityCode() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getScheduledActivityCode()).toEmbeddedJson();
			} catch(Exception e) {
				objectJson += "null";
			}
		}
		objectJson += "";
//Retrieve value of the Scheduled Activity Type of Scheduled Time Entry relationship
objectJson += ",\"scheduledActivityType\":";
		if (getScheduledActivityType() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getScheduledActivityType()).toEmbeddedJson();
			} catch(Exception e) {
				objectJson += "null";
			}
		}
		objectJson += "";
//Retrieve value of the Scheduled Time of Scheduled Time Entry relationship
objectJson += ",\"scheduledTime\":";
		if (getScheduledTime() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getScheduledTime()).toEmbeddedJson();
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
		//From value of the Activity Type Name property
		setActivityTypeName(JsonUtils.getJsonString(jsonObject, "activityTypeName"));
		//From value of the To Time property
		setToTime(JsonUtils.getJsonDate(jsonObject, "toTime"));
		//From value of the From Time property
		setFromTime(JsonUtils.getJsonDate(jsonObject, "fromTime"));
		//From value of the Duration property
		setDuration(JsonUtils.getJsonInteger(jsonObject, "duration"));

		
		// Source Relationships
		this.scheduledActivityCode = (ScheduledActivityCode) JsonUtils.getJsonPerceroObject(jsonObject, "scheduledActivityCode");
		this.scheduledActivityType = (ScheduledActivityType) JsonUtils.getJsonPerceroObject(jsonObject, "scheduledActivityType");
		this.scheduledTime = (ScheduledTime) JsonUtils.getJsonPerceroObject(jsonObject, "scheduledTime");


		// Target Relationships


	}
	
	@Override
	protected List<MappedClassMethodPair> getListSetters() {
		List<MappedClassMethodPair> listSetters = super.getListSetters();

		// Target Relationships

		
		return listSetters;
	}
}
