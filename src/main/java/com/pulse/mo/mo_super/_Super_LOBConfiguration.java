
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
public class _Super_LOBConfiguration extends BaseDataObject implements Serializable
{
	//////////////////////////////////////////////////////
	// VERSION
	//////////////////////////////////////////////////////
	@Override
	public String classVersion() {
		return "1.0.0";
	}

	
	/*
	Keys of LOBConfiguration
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
	

	//////////////////////////////////////////////////////
	// Target Relationships
	//////////////////////////////////////////////////////
	@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@OneToMany(fetch=FetchType.LAZY, targetEntity=LOBConfigurationNotification.class, mappedBy="lOBConfiguration", cascade=javax.persistence.CascadeType.REMOVE)
private List<LOBConfigurationNotification> lOBConfigurationNotifications;
public List<LOBConfigurationNotification> getLOBConfigurationNotifications() {
	return this.lOBConfigurationNotifications;
}

public void setLOBConfigurationNotifications(List<LOBConfigurationNotification> value) {
	this.lOBConfigurationNotifications = value;
}

@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@OneToMany(fetch=FetchType.LAZY, targetEntity=LOBConfigurationEntry.class, mappedBy="lOBConfiguration", cascade=javax.persistence.CascadeType.REMOVE)
private List<LOBConfigurationEntry> lOBConfigurationEntries;
public List<LOBConfigurationEntry> getLOBConfigurationEntries() {
	return this.lOBConfigurationEntries;
}

public void setLOBConfigurationEntries(List<LOBConfigurationEntry> value) {
	this.lOBConfigurationEntries = value;
}



	//////////////////////////////////////////////////////
	// Source Relationships
	//////////////////////////////////////////////////////
	@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@JoinColumn(name="LOB_ID")
@org.hibernate.annotations.ForeignKey(name="FK_LOBOfLOBConfiguration")
@ManyToOne(fetch=FetchType.LAZY, optional=true)
private LOB lOB;
public LOB getLOB() {
	return this.lOB;
}

public void setLOB(LOB value) {
	this.lOB = value;
}

	
	//////////////////////////////////////////////////////
	// JSON
	//////////////////////////////////////////////////////
	@Override
	public String retrieveJson(ObjectMapper objectMapper) {
		String objectJson = super.retrieveJson(objectMapper);

		// Properties		

				
		// Source Relationships
//Retrieve value of the LOB of LOB Configuration relationship
objectJson += ",\"lOB\":";
		if (getLOB() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getLOB()).toEmbeddedJson();
			} catch(Exception e) {
				objectJson += "null";
			}
		}
		objectJson += "";

		
		// Target Relationships
//Retrieve value of the LOB Configuration of LOB Configuration Notification relationship
objectJson += ",\"lOBConfigurationNotifications\":[";
		
		if (getLOBConfigurationNotifications() != null) {
			int lOBConfigurationNotificationsCounter = 0;
			for(LOBConfigurationNotification nextLOBConfigurationNotifications : getLOBConfigurationNotifications()) {
				if (lOBConfigurationNotificationsCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextLOBConfigurationNotifications).toEmbeddedJson();
					lOBConfigurationNotificationsCounter++;
				} catch(Exception e) {
					// Do nothing.
				}
			}
		}
		objectJson += "]";
//Retrieve value of the LOB Configuration of LOB Configuration Entry relationship
objectJson += ",\"lOBConfigurationEntries\":[";
		
		if (getLOBConfigurationEntries() != null) {
			int lOBConfigurationEntriesCounter = 0;
			for(LOBConfigurationEntry nextLOBConfigurationEntries : getLOBConfigurationEntries()) {
				if (lOBConfigurationEntriesCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextLOBConfigurationEntries).toEmbeddedJson();
					lOBConfigurationEntriesCounter++;
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

		
		// Source Relationships
		this.lOB = (LOB) JsonUtils.getJsonPerceroObject(jsonObject, "lOB");


		// Target Relationships
		this.lOBConfigurationNotifications = (List<LOBConfigurationNotification>) JsonUtils.getJsonListPerceroObject(jsonObject, "lOBConfigurationNotifications");
		this.lOBConfigurationEntries = (List<LOBConfigurationEntry>) JsonUtils.getJsonListPerceroObject(jsonObject, "lOBConfigurationEntries");


	}
	
	@Override
	protected List<MappedClassMethodPair> getListSetters() {
		List<MappedClassMethodPair> listSetters = super.getListSetters();

		// Target Relationships
		listSetters.add(MappedClass.getFieldSetters(LOBConfigurationNotification.class, "lobconfiguration"));
		listSetters.add(MappedClass.getFieldSetters(LOBConfigurationEntry.class, "lobconfiguration"));

		
		return listSetters;
	}
}
