
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
public class _Super_CVGProject extends BaseDataObject implements Serializable
{
	//////////////////////////////////////////////////////
	// VERSION
	//////////////////////////////////////////////////////
	@Override
	public String classVersion() {
		return "1.0.0";
	}

	
	/*
	Keys of CVGProject
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
}

	//////////////////////////////////////////////////////
	// Target Relationships
	//////////////////////////////////////////////////////
	@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@OneToMany(fetch=FetchType.LAZY, targetEntity=AgentTimeEntry.class, mappedBy="cVGProject", cascade=javax.persistence.CascadeType.REMOVE)
private List<AgentTimeEntry> agentTimeEntries;
public List<AgentTimeEntry> getAgentTimeEntries() {
	return this.agentTimeEntries;
}

public void setAgentTimeEntries(List<AgentTimeEntry> value) {
	this.agentTimeEntries = value;
}

@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@OneToMany(fetch=FetchType.LAZY, targetEntity=ChangesNotApprovedNotification.class, mappedBy="cVGProject", cascade=javax.persistence.CascadeType.REMOVE)
private List<ChangesNotApprovedNotification> changesNotApprovedNotifications;
public List<ChangesNotApprovedNotification> getChangesNotApprovedNotifications() {
	return this.changesNotApprovedNotifications;
}

public void setChangesNotApprovedNotifications(List<ChangesNotApprovedNotification> value) {
	this.changesNotApprovedNotifications = value;
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

				
		// Source Relationships

		
		// Target Relationships
//Retrieve value of the CVG Project of Agent Time Entry relationship
objectJson += ",\"agentTimeEntries\":[";
		
		if (getAgentTimeEntries() != null) {
			int agentTimeEntriesCounter = 0;
			for(AgentTimeEntry nextAgentTimeEntries : getAgentTimeEntries()) {
				if (agentTimeEntriesCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextAgentTimeEntries).toEmbeddedJson();
					agentTimeEntriesCounter++;
				} catch(Exception e) {
					// Do nothing.
				}
			}
		}
		objectJson += "]";
//Retrieve value of the CVG Project of Changes Not Approved Notification relationship
objectJson += ",\"changesNotApprovedNotifications\":[";
		
		if (getChangesNotApprovedNotifications() != null) {
			int changesNotApprovedNotificationsCounter = 0;
			for(ChangesNotApprovedNotification nextChangesNotApprovedNotifications : getChangesNotApprovedNotifications()) {
				if (changesNotApprovedNotificationsCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextChangesNotApprovedNotifications).toEmbeddedJson();
					changesNotApprovedNotificationsCounter++;
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
		//From value of the External ID property
		setExternalID(JsonUtils.getJsonString(jsonObject, "externalID"));
		//From value of the Name property
		setName(JsonUtils.getJsonString(jsonObject, "name"));

		
		// Source Relationships


		// Target Relationships
		this.agentTimeEntries = (List<AgentTimeEntry>) JsonUtils.getJsonListPerceroObject(jsonObject, "agentTimeEntries");
		this.changesNotApprovedNotifications = (List<ChangesNotApprovedNotification>) JsonUtils.getJsonListPerceroObject(jsonObject, "changesNotApprovedNotifications");


	}
	
	@Override
	protected List<MappedClassMethodPair> getListSetters() {
		List<MappedClassMethodPair> listSetters = super.getListSetters();

		// Target Relationships
		listSetters.add(MappedClass.getFieldSetters(AgentTimeEntry.class, "cvgproject"));
		listSetters.add(MappedClass.getFieldSetters(ChangesNotApprovedNotification.class, "cvgproject"));

		
		return listSetters;
	}
}
