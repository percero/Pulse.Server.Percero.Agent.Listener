

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
import javax.persistence.Inheritance;import javax.persistence.InheritanceType;

import com.percero.agents.sync.vo.BaseDataObject;
import com.percero.serial.BDODeserializer;
import com.percero.serial.BDOSerializer;
import com.percero.serial.JsonUtils;

import com.pulse.mo.*;

/*
Entity Tags based on semantic requirements
*/
@SecondaryTable(name="LOBConfigurationNotification")
@MappedSuperclass
public class _Super_LOBConfigurationNotification extends Notification implements Serializable
{
	//////////////////////////////////////////////////////
	// VERSION
	//////////////////////////////////////////////////////
	@Override
	public String classVersion() {
		return "1.0.0";
	}

	
	/*
	Keys of LOBConfigurationNotification
	*/
	
	
	//////////////////////////////////////////////////////
	// Properties
	//////////////////////////////////////////////////////
	/*
Message
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String message;

public String getMessage() 
{
	return this.message;
}

public void setMessage(String message)
{
	this.message = message;
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
@JoinColumn(name="AGENT_ID")
@org.hibernate.annotations.ForeignKey(name="FK_AgentOfLOBConfigurationNotification")
@ManyToOne(fetch=FetchType.LAZY, optional=true)
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
@JoinColumn(name="LOB_CONFIGURATION_ID")
@org.hibernate.annotations.ForeignKey(name="FK_LOBConfigurationOfLOBConfigurationNotification")
@ManyToOne(fetch=FetchType.LAZY, optional=true)
private LOBConfiguration lOBConfiguration;
public LOBConfiguration getLOBConfiguration() {
	return this.lOBConfiguration;
}

public void setLOBConfiguration(LOBConfiguration value) {
	this.lOBConfiguration = value;
}


	@com.percero.agents.sync.metadata.annotations.Externalize
	@JsonSerialize(using=BDOSerializer.class)
	@JsonDeserialize(using=BDODeserializer.class)
	@JoinColumn(name="CMS_ENTRY_ID")
	@org.hibernate.annotations.ForeignKey(name="FK_CMSEntryOfLOBConfigurationNotification")
	@ManyToOne(fetch=FetchType.LAZY, optional=true)
	private CMSEntry cMSEntry;
	public CMSEntry getCMSEntry() {
		return this.cMSEntry;
	}

	public void setCMSEntry(CMSEntry value) {
		this.cMSEntry = value;
	}

	@com.percero.agents.sync.metadata.annotations.Externalize
	@JsonSerialize(using=BDOSerializer.class)
	@JsonDeserialize(using=BDODeserializer.class)
	@JoinColumn(name="WORKED_ID")
	@org.hibernate.annotations.ForeignKey(name="FK_TimecardEntryOfLOBConfigurationNotification")
	@ManyToOne(fetch=FetchType.LAZY, optional=true)
	private TimecardEntry timecardEntry;
	public TimecardEntry getTimecardEntry() {
		return this.timecardEntry;
	}

	public void setTimecardEntry(TimecardEntry value) {
		this.timecardEntry = value;
	}

	//////////////////////////////////////////////////////
	//////////////////////////////////////////////////////
	// JSON
	//////////////////////////////////////////////////////
	@Override
	public String retrieveJson(ObjectMapper objectMapper) {
		String objectJson = super.retrieveJson(objectMapper);

		// Properties		
		//Retrieve value of the Message property
		objectJson += ",\"message\":";
		
		if (getMessage() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getMessage());
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
//Retrieve value of the Agent of LOB Configuration Notification relationship
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
//Retrieve value of the LOB Configuration of LOB Configuration Notification relationship
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

		objectJson += ",\"cMSEntry\":";
		if (getCMSEntry() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getCMSEntry()).toEmbeddedJson();
			} catch(Exception e) {
				objectJson += "null";
			}
		}
		objectJson += "";

		objectJson += ",\"timecarEntry\":";
		if (getTimecardEntry() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getTimecardEntry()).toEmbeddedJson();
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
		//From value of the Message property
		setMessage(JsonUtils.getJsonString(jsonObject, "message"));

		
		// Source Relationships
		this.agent = (Agent) JsonUtils.getJsonPerceroObject(jsonObject, "agent");
		this.lOBConfiguration = (LOBConfiguration) JsonUtils.getJsonPerceroObject(jsonObject, "lOBConfiguration");

		this.cMSEntry = (CMSEntry) JsonUtils.getJsonPerceroObject(jsonObject, "cMSEntry");
		this.timecardEntry = (TimecardEntry) JsonUtils.getJsonPerceroObject(jsonObject, "timecardEntry");

		// Target Relationships


	}
	
	@Override
	protected List<MappedClassMethodPair> getListSetters() {
		List<MappedClassMethodPair> listSetters = super.getListSetters();

		// Target Relationships

		listSetters.add(MappedClass.getFieldSetters(CMSEntry.class, "lOBConfigurationNotification"));
		listSetters.add(MappedClass.getFieldSetters(Timecard.class, "lOBConfigurationNotification"));

		return listSetters;
	}
}

