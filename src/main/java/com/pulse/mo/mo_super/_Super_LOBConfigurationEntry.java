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

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.percero.agents.sync.metadata.MappedClass;
import com.percero.agents.sync.metadata.MappedClass.MappedClassMethodPair;

import org.hibernate.annotations.AccessType;

import com.pulse.mo.NotificationFrequency;
import com.pulse.mo.AuxEntry;
import com.pulse.mo.EStartActivityCode;
import com.pulse.mo.ThresholdExceededNotification;

import com.percero.agents.sync.vo.BaseDataObject;
import com.percero.serial.BDODeserializer;
import com.percero.serial.BDOSerializer;
import com.percero.serial.JsonUtils;

import com.pulse.mo.*;

@MappedSuperclass
/*
*/
public class _Super_LOBConfigurationEntry extends BaseDataObject implements Serializable
{
	//////////////////////////////////////////////////////
	// VERSION
	//////////////////////////////////////////////////////
	@Override
	public String classVersion() {
		return "0.0.0.0";
	}


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
	@Column
    @com.percero.agents.sync.metadata.annotations.Externalize
	private Boolean durationToleranceEnabled;
	public Boolean getDurationToleranceEnabled() {
		return this.durationToleranceEnabled;
	}
	public void setDurationToleranceEnabled(Boolean value)
	{
		this.durationToleranceEnabled = value;
	}

	@Column
    @com.percero.agents.sync.metadata.annotations.Externalize
	private Integer durationToleranceInterval;
	public Integer getDurationToleranceInterval() {
		return this.durationToleranceInterval;
	}
	public void setDurationToleranceInterval(Integer value)
	{
		this.durationToleranceInterval = value;
	}

	@Column
    @com.percero.agents.sync.metadata.annotations.Externalize
	private Integer occurrenceToleranceInterval;
	public Integer getOccurrenceToleranceInterval() {
		return this.occurrenceToleranceInterval;
	}
	public void setOccurrenceToleranceInterval(Integer value)
	{
		this.occurrenceToleranceInterval = value;
	}

	@Column
    @com.percero.agents.sync.metadata.annotations.Externalize
	private Integer reminderInterval;
	public Integer getReminderInterval() {
		return this.reminderInterval;
	}
	public void setReminderInterval(Integer value)
	{
		this.reminderInterval = value;
	}


	//////////////////////////////////////////////////////
	// Source Relationships
	//////////////////////////////////////////////////////
    @com.percero.agents.sync.metadata.annotations.Externalize
	@JsonSerialize(using=BDOSerializer.class)
	@JsonDeserialize(using=BDODeserializer.class)
	@JoinColumn(name="notificationFrequency_ID")
	@org.hibernate.annotations.ForeignKey(name="FK_NotificationFrequency_notificationFrequency_TO_LOBConfigurationEntry")
	@OneToOne(fetch=FetchType.LAZY, optional=false)
	private NotificationFrequency notificationFrequency;
	public NotificationFrequency getNotificationFrequency() {
		return this.notificationFrequency;
	}
	public void setNotificationFrequency(NotificationFrequency value) {
		this.notificationFrequency = value;
	}

    @com.percero.agents.sync.metadata.annotations.Externalize
	@JsonSerialize(using=BDOSerializer.class)
	@JsonDeserialize(using=BDODeserializer.class)
	@JoinColumn(name="auxEntry_ID")
	@org.hibernate.annotations.ForeignKey(name="FK_AuxEntry_auxEntry_TO_LOBConfigurationEntry")
	@OneToOne(fetch=FetchType.LAZY, optional=false)
	private AuxEntry auxEntry;
	public AuxEntry getAuxEntry() {
		return this.auxEntry;
	}
	public void setAuxEntry(AuxEntry value) {
		this.auxEntry = value;
	}

    @com.percero.agents.sync.metadata.annotations.Externalize
	@JsonSerialize(using=BDOSerializer.class)
	@JsonDeserialize(using=BDODeserializer.class)
	@JoinColumn(name="eStartActivityCode_ID")
	@org.hibernate.annotations.ForeignKey(name="FK_EStartActivityCode_eStartActivityCode_TO_LOBConfigurationEntry")
	@OneToOne(fetch=FetchType.LAZY, optional=false)
	private EStartActivityCode eStartActivityCode;
	public EStartActivityCode getEStartActivityCode() {
		return this.eStartActivityCode;
	}
	public void setEStartActivityCode(EStartActivityCode value) {
		this.eStartActivityCode = value;
	}


	//////////////////////////////////////////////////////
	// Target Relationships
	//////////////////////////////////////////////////////
    @com.percero.agents.sync.metadata.annotations.Externalize
	@JsonSerialize(contentUsing=BDOSerializer.class)
	@JsonDeserialize(contentUsing=BDODeserializer.class)
	@OneToMany(fetch=FetchType.LAZY, targetEntity=ThresholdExceededNotification.class, mappedBy="lobConfigurationEntry", cascade=javax.persistence.CascadeType.REMOVE)
	private List<ThresholdExceededNotification> thresholdExceededNotifications;
	public List<ThresholdExceededNotification> getThresholdExceededNotifications() {
		return this.thresholdExceededNotifications;
	}
	public void setThresholdExceededNotifications(List<ThresholdExceededNotification> value) {
		this.thresholdExceededNotifications = value;
	}



	
	//////////////////////////////////////////////////////
	// JSON
	//////////////////////////////////////////////////////
	@Override
	public String retrieveJson(ObjectMapper objectMapper) {
		String objectJson = super.retrieveJson(objectMapper);

		// Properties
		objectJson += ",\"durationToleranceEnabled\":";
		if (getDurationToleranceEnabled() == null)
			objectJson += "null";
		else {
			objectJson += getDurationToleranceEnabled();
		}

		objectJson += ",\"durationToleranceInterval\":";
		if (getDurationToleranceInterval() == null)
			objectJson += "null";
		else {
			objectJson += getDurationToleranceInterval();
		}

		objectJson += ",\"occurrenceToleranceInterval\":";
		if (getOccurrenceToleranceInterval() == null)
			objectJson += "null";
		else {
			objectJson += getOccurrenceToleranceInterval();
		}

		objectJson += ",\"reminderInterval\":";
		if (getReminderInterval() == null)
			objectJson += "null";
		else {
			objectJson += getReminderInterval();
		}

		// Source Relationships
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

		objectJson += ",\"auxEntry\":";
		if (getAuxEntry() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getAuxEntry()).toEmbeddedJson();
			} catch(Exception e) {
				objectJson += "null";
			}
		}
		objectJson += "";

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
		setDurationToleranceEnabled(JsonUtils.getJsonBoolean(jsonObject, "durationToleranceEnabled"));
		setDurationToleranceInterval(JsonUtils.getJsonInteger(jsonObject, "durationToleranceInterval"));
		setOccurrenceToleranceInterval(JsonUtils.getJsonInteger(jsonObject, "occurrenceToleranceInterval"));
		setReminderInterval(JsonUtils.getJsonInteger(jsonObject, "reminderInterval"));

		// Source Relationships
        this.notificationFrequency = JsonUtils.getJsonPerceroObject(jsonObject, "notificationFrequency");
        this.auxEntry = JsonUtils.getJsonPerceroObject(jsonObject, "auxEntry");
        this.eStartActivityCode = JsonUtils.getJsonPerceroObject(jsonObject, "eStartActivityCode");

		// Target Relationships
		this.thresholdExceededNotifications = (List<ThresholdExceededNotification>) JsonUtils.getJsonListPerceroObject(jsonObject, "thresholdExceededNotifications");
	}

	@Override
	protected List<MappedClassMethodPair> getListSetters() {
		List<MappedClassMethodPair> listSetters = super.getListSetters();

		// Target Relationships
		listSetters.add(MappedClass.getFieldSetters(ThresholdExceededNotification.class, "lobConfigurationEntry"));
	
		return listSetters;
	}
}