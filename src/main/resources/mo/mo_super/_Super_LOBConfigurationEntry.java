
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
public class _Super_LOBConfigurationEntry extends BaseDataObject implements Serializable
{
	//////////////////////////////////////////////////////
	// VERSION
	//////////////////////////////////////////////////////
	@Override
	public String classVersion() {
		return "1.0.0";
	}

	
	/*
	Keys of LOBConfigurationEntry
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
OccurrenceToleranceInterval
Notes:The number of times a event can happen before a notification is sent
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Integer occurrenceToleranceInterval;

public Integer getOccurrenceToleranceInterval() 
{
	return this.occurrenceToleranceInterval;
}

public void setOccurrenceToleranceInterval(Integer occurrenceToleranceInterval)
{
	this.occurrenceToleranceInterval = occurrenceToleranceInterval;
}/*
ReminderInterval
Notes:The number of minutes before notification are resent after being dismissed
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Integer reminderInterval;

public Integer getReminderInterval() 
{
	return this.reminderInterval;
}

public void setReminderInterval(Integer reminderInterval)
{
	this.reminderInterval = reminderInterval;
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
DurationToleranceInterval
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Integer durationToleranceInterval;

public Integer getDurationToleranceInterval() 
{
	return this.durationToleranceInterval;
}

public void setDurationToleranceInterval(Integer durationToleranceInterval)
{
	this.durationToleranceInterval = durationToleranceInterval;
}/*
DurationToleranceEnabled
Notes:When there is no tolerance "None" this will be false
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Boolean durationToleranceEnabled;

public Boolean getDurationToleranceEnabled() 
{
	return this.durationToleranceEnabled;
}

public void setDurationToleranceEnabled(Boolean durationToleranceEnabled)
{
	this.durationToleranceEnabled = durationToleranceEnabled;
}/*
DurationTolerance
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Integer durationTolerance;

public Integer getDurationTolerance() 
{
	return this.durationTolerance;
}

public void setDurationTolerance(Integer durationTolerance)
{
	this.durationTolerance = durationTolerance;
}

	//////////////////////////////////////////////////////
	// Target Relationships
	//////////////////////////////////////////////////////
	@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@OneToMany(fetch=FetchType.LAZY, targetEntity=ThresholdExceededNotification.class, mappedBy="lOBConfigurationEntry", cascade=javax.persistence.CascadeType.REMOVE)
private List<ThresholdExceededNotification> thresholdExceededNotifications;
public List<ThresholdExceededNotification> getThresholdExceededNotifications() {
	return this.thresholdExceededNotifications;
}

public void setThresholdExceededNotifications(List<ThresholdExceededNotification> value) {
	this.thresholdExceededNotifications = value;
}



	//////////////////////////////////////////////////////
	// Source Relationships
	//////////////////////////////////////////////////////
	@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@JoinColumn(name="LOBConfigurationId")
@org.hibernate.annotations.ForeignKey(name="FK_LOBConfigurationOfLOBConfigurationEntry")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private LOBConfiguration lOBConfiguration;
public LOBConfiguration getLOBConfiguration() {
	return this.lOBConfiguration;
}

public void setLOBConfiguration(LOBConfiguration value) {
	this.lOBConfiguration = value;
}@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@JoinColumn(name="NotificationFrequencyId")
@org.hibernate.annotations.ForeignKey(name="FK_NotificationFrequencyOfLOBConfigurationEntry")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private NotificationFrequency notificationFrequency;
public NotificationFrequency getNotificationFrequency() {
	return this.notificationFrequency;
}

public void setNotificationFrequency(NotificationFrequency value) {
	this.notificationFrequency = value;
}@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@JoinColumn(name="AuxModeId")
@org.hibernate.annotations.ForeignKey(name="FK_AuxModeOfLOBConfigurationEntry")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private AuxMode auxMode;
public AuxMode getAuxMode() {
	return this.auxMode;
}

public void setAuxMode(AuxMode value) {
	this.auxMode = value;
}@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@JoinColumn(name="EStartActivityCodeId")
@org.hibernate.annotations.ForeignKey(name="FK_EStartActivityCodeOfLOBConfigurationEntry")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private EStartActivityCode eStartActivityCode;
public EStartActivityCode getEStartActivityCode() {
	return this.eStartActivityCode;
}

public void setEStartActivityCode(EStartActivityCode value) {
	this.eStartActivityCode = value;
}

	
	//////////////////////////////////////////////////////
	// JSON
	//////////////////////////////////////////////////////
	@Override
	public String retrieveJson(ObjectMapper objectMapper) {
		String objectJson = super.retrieveJson(objectMapper);

		// Properties		
		//Retrieve value of the OccurrenceTolerance Interval property
		objectJson += ",\"occurrenceToleranceInterval\":";
		
		if (getOccurrenceToleranceInterval() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getOccurrenceToleranceInterval());
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
		//Retrieve value of the Reminder Interval property
		objectJson += ",\"reminderInterval\":";
		
		if (getReminderInterval() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getReminderInterval());
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
		//Retrieve value of the Duration Tolerance Interval property
		objectJson += ",\"durationToleranceInterval\":";
		
		if (getDurationToleranceInterval() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getDurationToleranceInterval());
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
		//Retrieve value of the Duration Tolerance Enabled property
		objectJson += ",\"durationToleranceEnabled\":";
		if (getDurationToleranceEnabled() == null)
			objectJson += "null";
		else {
			objectJson += getDurationToleranceEnabled();
		}
		//Retrieve value of the Duration Tolerance property
		objectJson += ",\"durationTolerance\":";
		
		if (getDurationTolerance() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getDurationTolerance());
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
//Retrieve value of the LOB Configuration of LOB Configuration Entry relationship
objectJson += ",\"lOBConfiguration\":";
		if (getLOBConfiguration() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getLOBConfiguration()).toEmbeddedJson();
			} catch(Exception e) {
				objectJson += "null";
			}
		}
		objectJson += "";
//Retrieve value of the Notification Frequency of LOB Configuration Entry relationship
objectJson += ",\"notificationFrequency\":";
		if (getNotificationFrequency() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getNotificationFrequency()).toEmbeddedJson();
			} catch(Exception e) {
				objectJson += "null";
			}
		}
		objectJson += "";
//Retrieve value of the Aux Mode of LOB Configuration Entry relationship
objectJson += ",\"auxMode\":";
		if (getAuxMode() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getAuxMode()).toEmbeddedJson();
			} catch(Exception e) {
				objectJson += "null";
			}
		}
		objectJson += "";
//Retrieve value of the EStart Activity Code of LOB Configuration Entry relationship
objectJson += ",\"eStartActivityCode\":";
		if (getEStartActivityCode() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getEStartActivityCode()).toEmbeddedJson();
			} catch(Exception e) {
				objectJson += "null";
			}
		}
		objectJson += "";

		
		// Target Relationships
//Retrieve value of the LOB Configuration Entry of Threshold Exceeded Notification relationship
objectJson += ",\"thresholdExceededNotifications\":[";
		
		if (getThresholdExceededNotifications() != null) {
			int thresholdExceededNotificationsCounter = 0;
			for(ThresholdExceededNotification nextThresholdExceededNotifications : getThresholdExceededNotifications()) {
				if (thresholdExceededNotificationsCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextThresholdExceededNotifications).toEmbeddedJson();
					thresholdExceededNotificationsCounter++;
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
		//From value of the OccurrenceTolerance Interval property
		setOccurrenceToleranceInterval(JsonUtils.getJsonInteger(jsonObject, "occurrenceToleranceInterval"));
		//From value of the Reminder Interval property
		setReminderInterval(JsonUtils.getJsonInteger(jsonObject, "reminderInterval"));
		//From value of the External ID property
		setExternalID(JsonUtils.getJsonString(jsonObject, "externalID"));
		//From value of the Duration Tolerance Interval property
		setDurationToleranceInterval(JsonUtils.getJsonInteger(jsonObject, "durationToleranceInterval"));
		//From value of the Duration Tolerance Enabled property
		setDurationToleranceEnabled(JsonUtils.getJsonBoolean(jsonObject, "durationToleranceEnabled"));
		//From value of the Duration Tolerance property
		setDurationTolerance(JsonUtils.getJsonInteger(jsonObject, "durationTolerance"));

		
		// Source Relationships
		this.lOBConfiguration = (LOBConfiguration) JsonUtils.getJsonPerceroObject(jsonObject, "lOBConfiguration");
		this.notificationFrequency = (NotificationFrequency) JsonUtils.getJsonPerceroObject(jsonObject, "notificationFrequency");
		this.auxMode = (AuxMode) JsonUtils.getJsonPerceroObject(jsonObject, "auxMode");
		this.eStartActivityCode = (EStartActivityCode) JsonUtils.getJsonPerceroObject(jsonObject, "eStartActivityCode");


		// Target Relationships
		this.thresholdExceededNotifications = (List<ThresholdExceededNotification>) JsonUtils.getJsonListPerceroObject(jsonObject, "thresholdExceededNotifications");


	}
	
	@Override
	protected List<MappedClassMethodPair> getListSetters() {
		List<MappedClassMethodPair> listSetters = super.getListSetters();

		// Target Relationships
		listSetters.add(MappedClass.getFieldSetters(ThresholdExceededNotification.class, "lobconfigurationentry"));

		
		return listSetters;
	}
}
