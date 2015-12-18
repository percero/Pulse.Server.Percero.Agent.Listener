

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
POS
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String pOS;

public String getPOS() 
{
	return this.pOS;
}

public void setPOS(String pOS)
{
	this.pOS = pOS;
}/*
EWA1
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String eWA1;

public String getEWA1() 
{
	return this.eWA1;
}

public void setEWA1(String eWA1)
{
	this.eWA1 = eWA1;
}/*
SourceFromTime
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Date sourceFromTime;

public Date getSourceFromTime() 
{
	return this.sourceFromTime;
}

public void setSourceFromTime(Date sourceFromTime)
{
	this.sourceFromTime = sourceFromTime;
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
Minutes
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Integer minutes;

public Integer getMinutes() 
{
	return this.minutes;
}

public void setMinutes(Integer minutes)
{
	this.minutes = minutes;
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
}/*
Note
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String note;

public String getNote() 
{
	return this.note;
}

public void setNote(String note)
{
	this.note = note;
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
EWA2
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String eWA2;

public String getEWA2() 
{
	return this.eWA2;
}

public void setEWA2(String eWA2)
{
	this.eWA2 = eWA2;
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
SourceToTime
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Date sourceToTime;

public Date getSourceToTime() 
{
	return this.sourceToTime;
}

public void setSourceToTime(Date sourceToTime)
{
	this.sourceToTime = sourceToTime;
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
CodeType
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Integer codeType;

public Integer getCodeType() 
{
	return this.codeType;
}

public void setCodeType(Integer codeType)
{
	this.codeType = codeType;
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
@JoinColumn(name="TIMECARD_ACTIVITY_ID")
@org.hibernate.annotations.ForeignKey(name="FK_TimecardActivityOfTimecardEntry")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private TimecardActivity timecardActivity;
public TimecardActivity getTimecardActivity() {
	return this.timecardActivity;
}

public void setTimecardActivity(TimecardActivity value) {
	this.timecardActivity = value;
}
@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@JoinColumn(name="PAYROLL")
@org.hibernate.annotations.ForeignKey(name="FK_AgentOfTimecardEntry")
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

	@com.percero.agents.sync.metadata.annotations.Externalize
	@JsonSerialize(contentUsing = BDOSerializer.class)
	@JsonDeserialize(contentUsing = BDODeserializer.class)
	@OneToMany(fetch = FetchType.LAZY, targetEntity = LOBConfigurationNotification.class, mappedBy = "timecardEntry", cascade = javax.persistence.CascadeType.REMOVE)
	private List<LOBConfigurationNotification> notifications;

	public List<LOBConfigurationNotification> getNotifications() {
		return this.notifications;
	}

	public void setNotifications(List<LOBConfigurationNotification> value) {
		this.notifications = value;
	}


	//////////////////////////////////////////////////////
	// JSON
	//////////////////////////////////////////////////////
	@Override
	public String retrieveJson(ObjectMapper objectMapper) {
		String objectJson = super.retrieveJson(objectMapper);

		// Properties		
		//Retrieve value of the POS property
		objectJson += ",\"pOS\":";
		
		if (getPOS() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getPOS());
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
		//Retrieve value of the EWA 1 property
		objectJson += ",\"eWA1\":";
		
		if (getEWA1() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getEWA1());
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
		//Retrieve value of the Source From Time property
		objectJson += ",\"sourceFromTime\":";
		if (getSourceFromTime() == null)
			objectJson += "null";
		else {
			objectJson += getSourceFromTime().getTime();
		}
		//Retrieve value of the Duration property
		objectJson += ",\"duration\":";
		if (getDuration() == null)
			objectJson += "null";
		else {
			objectJson += getDuration();
		}
		//Retrieve value of the Minutes property
		objectJson += ",\"minutes\":";
		
		if (getMinutes() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getMinutes());
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
		//Retrieve value of the Notification Resolved property
		objectJson += ",\"notificationResolved\":";
		if (getNotificationResolved() == null)
			objectJson += "null";
		else {
			objectJson += getNotificationResolved();
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
		//Retrieve value of the Note property
		objectJson += ",\"note\":";
		
		if (getNote() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getNote());
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
		//Retrieve value of the EWA 2 property
		objectJson += ",\"eWA2\":";
		
		if (getEWA2() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getEWA2());
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
		//Retrieve value of the Source To Time property
		objectJson += ",\"sourceToTime\":";
		if (getSourceToTime() == null)
			objectJson += "null";
		else {
			objectJson += getSourceToTime().getTime();
		}
		//Retrieve value of the Notification Detected property
		objectJson += ",\"notificationDetected\":";
		if (getNotificationDetected() == null)
			objectJson += "null";
		else {
			objectJson += getNotificationDetected();
		}
		//Retrieve value of the Code Type property
		objectJson += ",\"codeType\":";
		
		if (getCodeType() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getCodeType());
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
		objectJson += ",\"notifications\":[";

		if (getNotifications() != null) {
			int notificationsCounter = 0;
			for (LOBConfigurationNotification notification : getNotifications()) {
				if (notificationsCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) notification).toEmbeddedJson();
					notificationsCounter++;
				} catch (Exception e) {
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
		//From value of the POS property
		setPOS(JsonUtils.getJsonString(jsonObject, "pOS"));
		//From value of the EWA 1 property
		setEWA1(JsonUtils.getJsonString(jsonObject, "eWA1"));
		//From value of the Source From Time property
		setSourceFromTime(JsonUtils.getJsonDate(jsonObject, "sourceFromTime"));
		//From value of the Duration property
		setDuration(JsonUtils.getJsonDouble(jsonObject, "duration"));
		//From value of the Minutes property
		setMinutes(JsonUtils.getJsonInteger(jsonObject, "minutes"));
		//From value of the Notification Resolved property
		setNotificationResolved(JsonUtils.getJsonBoolean(jsonObject, "notificationResolved"));
		//From value of the Action Code property
		setActionCode(JsonUtils.getJsonString(jsonObject, "actionCode"));
		//From value of the Note property
		setNote(JsonUtils.getJsonString(jsonObject, "note"));
		//From value of the Action Name property
		setActionName(JsonUtils.getJsonString(jsonObject, "actionName"));
		//From value of the EWA 2 property
		setEWA2(JsonUtils.getJsonString(jsonObject, "eWA2"));
		//From value of the EStart Project Name property
		setEStartProjectName(JsonUtils.getJsonString(jsonObject, "eStartProjectName"));
		//From value of the Source To Time property
		setSourceToTime(JsonUtils.getJsonDate(jsonObject, "sourceToTime"));
		//From value of the Notification Detected property
		setNotificationDetected(JsonUtils.getJsonBoolean(jsonObject, "notificationDetected"));
		//From value of the Code Type property
		setCodeType(JsonUtils.getJsonInteger(jsonObject, "codeType"));

		
		// Source Relationships
		this.timecardActivity = (TimecardActivity) JsonUtils.getJsonPerceroObject(jsonObject, "timecardActivity");
		this.agent = (Agent) JsonUtils.getJsonPerceroObject(jsonObject, "agent");
		this.timecard = (Timecard) JsonUtils.getJsonPerceroObject(jsonObject, "timecard");


		// Target Relationships

		this.notifications = (List<LOBConfigurationNotification>) JsonUtils.getJsonListPerceroObject(jsonObject, "notifications");
	}
	
	@Override
	protected List<MappedClassMethodPair> getListSetters() {
		List<MappedClassMethodPair> listSetters = super.getListSetters();

		// Target Relationships

		listSetters.add(MappedClass.getFieldSetters(LOBConfigurationNotification.class, "cMSEntry"));

		return listSetters;
	}
}

