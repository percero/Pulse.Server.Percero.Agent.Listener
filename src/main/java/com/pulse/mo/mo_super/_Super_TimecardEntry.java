
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
public class _Super_TimecardEntry extends BaseDataObject implements Serializable
{
	//////////////////////////////////////////////////////
	// VERSION
	//////////////////////////////////////////////////////
	@Override
	public String classVersion() {
		return "1.0.0";
	}

	
	/*
	Keys of TimecardEntry
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
NotificationResolved
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Boolean notificationResolved;

public Boolean getNotificationResolved() 
{
	return this.notificationResolved;
}

public void setNotificationResolved(Boolean notificationResolved)
{
	this.notificationResolved = notificationResolved;
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
EStartProjectName
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String eStartProjectName;

public String getEStartProjectName() 
{
	return this.eStartProjectName;
}

public void setEStartProjectName(String eStartProjectName)
{
	this.eStartProjectName = eStartProjectName;
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
ActionName
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String actionName;

public String getActionName() 
{
	return this.actionName;
}

public void setActionName(String actionName)
{
	this.actionName = actionName;
}/*
ActivityName
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String activityName;

public String getActivityName() 
{
	return this.activityName;
}

public void setActivityName(String activityName)
{
	this.activityName = activityName;
}/*
NotificationDetected
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Boolean notificationDetected;

public Boolean getNotificationDetected() 
{
	return this.notificationDetected;
}

public void setNotificationDetected(Boolean notificationDetected)
{
	this.notificationDetected = notificationDetected;
}/*
ActionCode
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String actionCode;

public String getActionCode() 
{
	return this.actionCode;
}

public void setActionCode(String actionCode)
{
	this.actionCode = actionCode;
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
@JoinColumn(name="TIMECARD_ACTIVITY_ID")
@org.hibernate.annotations.ForeignKey(name="FK_TimecardActivityOfTimecardEntry")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private TimecardActivity timecardActivity;
public TimecardActivity getTimecardActivity() {
	return this.timecardActivity;
}

public void setTimecardActivity(TimecardActivity value) {
	this.timecardActivity = value;
}@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@JoinColumn(name="PAYROLL")
@org.hibernate.annotations.ForeignKey(name="FK_AgentOfTimecardEntry")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private Agent agent;
public Agent getAgent() {
	return this.agent;
}

public void setAgent(Agent value) {
	this.agent = value;
}@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@JoinColumn(name="TIMECARD_ID")
@org.hibernate.annotations.ForeignKey(name="FK_TimecardOfTimecardEntry")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private Timecard timecard;
public Timecard getTimecard() {
	return this.timecard;
}

public void setTimecard(Timecard value) {
	this.timecard = value;
}

	
	//////////////////////////////////////////////////////
	// JSON
	//////////////////////////////////////////////////////
	@Override
	public String retrieveJson(ObjectMapper objectMapper) {
		String objectJson = super.retrieveJson(objectMapper);

		// Properties		
		//Retrieve value of the From Time property
		objectJson += ",\"fromTime\":";
		if (getFromTime() == null)
			objectJson += "null";
		else {
			objectJson += getFromTime().getTime();
		}
		//Retrieve value of the Notification Resolved property
		objectJson += ",\"notificationResolved\":";
		if (getNotificationResolved() == null)
			objectJson += "null";
		else {
			objectJson += getNotificationResolved();
		}
		//Retrieve value of the To Time property
		objectJson += ",\"toTime\":";
		if (getToTime() == null)
			objectJson += "null";
		else {
			objectJson += getToTime().getTime();
		}
		//Retrieve value of the EStart Project Name property
		objectJson += ",\"eStartProjectName\":";
		
		if (getEStartProjectName() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getEStartProjectName());
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
		//Retrieve value of the Duration property
		objectJson += ",\"duration\":";
		if (getDuration() == null)
			objectJson += "null";
		else {
			objectJson += getDuration();
		}
		//Retrieve value of the Action Name property
		objectJson += ",\"actionName\":";
		
		if (getActionName() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getActionName());
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
		//Retrieve value of the Activity Name property
		objectJson += ",\"activityName\":";
		
		if (getActivityName() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getActivityName());
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
		//Retrieve value of the Notification Detected property
		objectJson += ",\"notificationDetected\":";
		if (getNotificationDetected() == null)
			objectJson += "null";
		else {
			objectJson += getNotificationDetected();
		}
		//Retrieve value of the Action Code property
		objectJson += ",\"actionCode\":";
		
		if (getActionCode() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getActionCode());
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
//Retrieve value of the Timecard Activity of Timecard Entry relationship
objectJson += ",\"timecardActivity\":";
		if (getTimecardActivity() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getTimecardActivity()).toEmbeddedJson();
			} catch(Exception e) {
				objectJson += "null";
			}
		}
		objectJson += "";
//Retrieve value of the Agent of Timecard Entry relationship
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
//Retrieve value of the Timecard of Timecard Entry relationship
objectJson += ",\"timecard\":";
		if (getTimecard() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getTimecard()).toEmbeddedJson();
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
		//From value of the From Time property
		setFromTime(JsonUtils.getJsonDate(jsonObject, "fromTime"));
		//From value of the Notification Resolved property
		setNotificationResolved(JsonUtils.getJsonBoolean(jsonObject, "notificationResolved"));
		//From value of the To Time property
		setToTime(JsonUtils.getJsonDate(jsonObject, "toTime"));
		//From value of the EStart Project Name property
		setEStartProjectName(JsonUtils.getJsonString(jsonObject, "eStartProjectName"));
		//From value of the Duration property
		setDuration(JsonUtils.getJsonDouble(jsonObject, "duration"));
		//From value of the Action Name property
		setActionName(JsonUtils.getJsonString(jsonObject, "actionName"));
		//From value of the Activity Name property
		setActivityName(JsonUtils.getJsonString(jsonObject, "activityName"));
		//From value of the Notification Detected property
		setNotificationDetected(JsonUtils.getJsonBoolean(jsonObject, "notificationDetected"));
		//From value of the Action Code property
		setActionCode(JsonUtils.getJsonString(jsonObject, "actionCode"));

		
		// Source Relationships
		this.timecardActivity = (TimecardActivity) JsonUtils.getJsonPerceroObject(jsonObject, "timecardActivity");
		this.agent = (Agent) JsonUtils.getJsonPerceroObject(jsonObject, "agent");
		this.timecard = (Timecard) JsonUtils.getJsonPerceroObject(jsonObject, "timecard");


		// Target Relationships


	}
	
	@Override
	protected List<MappedClassMethodPair> getListSetters() {
		List<MappedClassMethodPair> listSetters = super.getListSetters();

		// Target Relationships

		
		return listSetters;
	}
}
