
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
Min
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Integer min;

public Integer getMin() 
{
	return this.min;
}

public void setMin(Integer min)
{
	this.min = min;
}/*
Occurrence
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Integer occurrence;

public Integer getOccurrence() 
{
	return this.occurrence;
}

public void setOccurrence(Integer occurrence)
{
	this.occurrence = occurrence;
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
Max
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Integer max;

public Integer getMax() 
{
	return this.max;
}

public void setMax(Integer max)
{
	this.max = max;
}/*
ESTARTActivityCode
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String eSTARTActivityCode;

public String getESTARTActivityCode() 
{
	return this.eSTARTActivityCode;
}

public void setESTARTActivityCode(String eSTARTActivityCode)
{
	this.eSTARTActivityCode = eSTARTActivityCode;
}/*
CMSAuxCode
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String cMSAuxCode;

public String getCMSAuxCode() 
{
	return this.cMSAuxCode;
}

public void setCMSAuxCode(String cMSAuxCode)
{
	this.cMSAuxCode = cMSAuxCode;
}

	//////////////////////////////////////////////////////
	// Target Relationships
	//////////////////////////////////////////////////////
	@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
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
@JoinColumn(name="LOB_CONFIGURATION_ID")
@org.hibernate.annotations.ForeignKey(name="FK_LOBConfigurationOfLOBConfigurationEntry")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private LOBConfiguration lOBConfiguration;
public LOBConfiguration getLOBConfiguration() {
	return this.lOBConfiguration;
}

public void setLOBConfiguration(LOBConfiguration value) {
	this.lOBConfiguration = value;
}@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@JoinColumn(name="NOTIFICATION_FREQUENCY_ID")
@org.hibernate.annotations.ForeignKey(name="FK_NotificationFrequencyOfLOBConfigurationEntry")
@OneToOne(fetch=FetchType.LAZY, optional=false)
private NotificationFrequency notificationFrequency;
public NotificationFrequency getNotificationFrequency() {
	return this.notificationFrequency;
}

public void setNotificationFrequency(NotificationFrequency value) 
{
	this.notificationFrequency = value;
}

	
	//////////////////////////////////////////////////////
	// JSON
	//////////////////////////////////////////////////////
	@Override
	public String retrieveJson(ObjectMapper objectMapper) {
		String objectJson = super.retrieveJson(objectMapper);

		// Properties		
		//Retrieve value of the Min property
		objectJson += ",\"min\":";
		
		if (getMin() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getMin());
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
		//Retrieve value of the Occurrence property
		objectJson += ",\"occurrence\":";
		
		if (getOccurrence() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getOccurrence());
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
		//Retrieve value of the Max property
		objectJson += ",\"max\":";
		
		if (getMax() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getMax());
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
		//Retrieve value of the ESTART Activity Code property
		objectJson += ",\"eSTARTActivityCode\":";
		
		if (getESTARTActivityCode() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getESTARTActivityCode());
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
		//Retrieve value of the CMS Aux Code property
		objectJson += ",\"cMSAuxCode\":";
		
		if (getCMSAuxCode() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getCMSAuxCode());
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
		//From value of the Min property
		setMin(JsonUtils.getJsonInteger(jsonObject, "min"));
		//From value of the Occurrence property
		setOccurrence(JsonUtils.getJsonInteger(jsonObject, "occurrence"));
		//From value of the Type property
		setType(JsonUtils.getJsonString(jsonObject, "type"));
		//From value of the Max property
		setMax(JsonUtils.getJsonInteger(jsonObject, "max"));
		//From value of the ESTART Activity Code property
		setESTARTActivityCode(JsonUtils.getJsonString(jsonObject, "eSTARTActivityCode"));
		//From value of the CMS Aux Code property
		setCMSAuxCode(JsonUtils.getJsonString(jsonObject, "cMSAuxCode"));

		
		// Source Relationships
		this.lOBConfiguration = (LOBConfiguration) JsonUtils.getJsonPerceroObject(jsonObject, "lOBConfiguration");
		this.notificationFrequency = (NotificationFrequency) JsonUtils.getJsonPerceroObject(jsonObject, "notificationFrequency");


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
