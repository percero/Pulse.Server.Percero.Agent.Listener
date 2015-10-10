
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
public class _Super_CMSAuxMode extends BaseDataObject implements Serializable
{
	//////////////////////////////////////////////////////
	// VERSION
	//////////////////////////////////////////////////////
	@Override
	public String classVersion() {
		return "1.0.0";
	}

	
	/*
	Keys of CMSAuxMode
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
EventCount
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Integer eventCount;

public Integer getEventCount() 
{
	return this.eventCount;
}

public void setEventCount(Integer eventCount)
{
	this.eventCount = eventCount;
}

	//////////////////////////////////////////////////////
	// Target Relationships
	//////////////////////////////////////////////////////
	@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@com.percero.agents.sync.metadata.annotations.Externalize
@OneToOne(fetch=FetchType.LAZY, mappedBy="cMSAuxMode", cascade=javax.persistence.CascadeType.REMOVE)
private LOBConfigurationEntry lOBConfigurationEntry;
public LOBConfigurationEntry getLOBConfigurationEntry() {
	return this.lOBConfigurationEntry;
}

public void setLOBConfigurationEntry(LOBConfigurationEntry value) 
{
	this.lOBConfigurationEntry = value;
}

@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@OneToMany(fetch=FetchType.LAZY, targetEntity=DiscrepancyDetectedNotification.class, mappedBy="cMSAuxMode", cascade=javax.persistence.CascadeType.REMOVE)
private List<DiscrepancyDetectedNotification> discrepancyDetectedNotifications;
public List<DiscrepancyDetectedNotification> getDiscrepancyDetectedNotifications() {
	return this.discrepancyDetectedNotifications;
}

public void setDiscrepancyDetectedNotifications(List<DiscrepancyDetectedNotification> value) {
	this.discrepancyDetectedNotifications = value;
}

@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@OneToMany(fetch=FetchType.LAZY, targetEntity=CMSEntry.class, mappedBy="cMSAuxMode", cascade=javax.persistence.CascadeType.REMOVE)
private List<CMSEntry> cMSEntries;
public List<CMSEntry> getCMSEntries() {
	return this.cMSEntries;
}

public void setCMSEntries(List<CMSEntry> value) {
	this.cMSEntries = value;
}



	//////////////////////////////////////////////////////
	// Source Relationships
	//////////////////////////////////////////////////////
	

	
	//////////////////////////////////////////////////////
	// JSON
	//////////////////////////////////////////////////////
	@Override
	public String retrieveJson(ObjectMapper objectMapper) {
		String objectJson = super.retrieveJson(objectMapper);

		// Properties		
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
		//Retrieve value of the Event Count property
		objectJson += ",\"eventCount\":";
		
		if (getEventCount() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getEventCount());
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

		
		// Target Relationships
//Retrieve value of the CMS Aux Mode of LOB Configuration Entry relationship

//Retrieve value of the CMS Aux Mode of Discrepancy Detected Notification relationship
objectJson += ",\"discrepancyDetectedNotifications\":[";
		
		if (getDiscrepancyDetectedNotifications() != null) {
			int discrepancyDetectedNotificationsCounter = 0;
			for(DiscrepancyDetectedNotification nextDiscrepancyDetectedNotifications : getDiscrepancyDetectedNotifications()) {
				if (discrepancyDetectedNotificationsCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextDiscrepancyDetectedNotifications).toEmbeddedJson();
					discrepancyDetectedNotificationsCounter++;
				} catch(Exception e) {
					// Do nothing.
				}
			}
		}
		objectJson += "]";
//Retrieve value of the CMS Aux Mode of CMS Entry relationship
objectJson += ",\"cMSEntries\":[";
		
		if (getCMSEntries() != null) {
			int cMSEntriesCounter = 0;
			for(CMSEntry nextCMSEntries : getCMSEntries()) {
				if (cMSEntriesCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextCMSEntries).toEmbeddedJson();
					cMSEntriesCounter++;
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
		//From value of the Name property
		setName(JsonUtils.getJsonString(jsonObject, "name"));
		//From value of the Event Count property
		setEventCount(JsonUtils.getJsonInteger(jsonObject, "eventCount"));

		
		// Source Relationships


		// Target Relationships
		this.lOBConfigurationEntry = (LOBConfigurationEntry) JsonUtils.getJsonPerceroObject(jsonObject, "lOBConfigurationEntry");
		this.discrepancyDetectedNotifications = (List<DiscrepancyDetectedNotification>) JsonUtils.getJsonListPerceroObject(jsonObject, "discrepancyDetectedNotifications");
		this.cMSEntries = (List<CMSEntry>) JsonUtils.getJsonListPerceroObject(jsonObject, "cMSEntries");


	}
	
	@Override
	protected List<MappedClassMethodPair> getListSetters() {
		List<MappedClassMethodPair> listSetters = super.getListSetters();

		// Target Relationships
		listSetters.add(MappedClass.getFieldSetters(DiscrepancyDetectedNotification.class, "cmsauxmode"));
		listSetters.add(MappedClass.getFieldSetters(CMSEntry.class, "cmsauxmode"));

		
		return listSetters;
	}
}
