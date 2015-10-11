
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
public class _Super_LOB extends BaseDataObject implements Serializable
{
	//////////////////////////////////////////////////////
	// VERSION
	//////////////////////////////////////////////////////
	@Override
	public String classVersion() {
		return "1.0.0";
	}

	
	/*
	Keys of LOB
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
}

	//////////////////////////////////////////////////////
	// Target Relationships
	//////////////////////////////////////////////////////
	@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@OneToMany(fetch=FetchType.LAZY, targetEntity=LOBConfiguration.class, mappedBy="lOB", cascade=javax.persistence.CascadeType.REMOVE)
private List<LOBConfiguration> lOBConfigurations;
public List<LOBConfiguration> getLOBConfigurations() {
	return this.lOBConfigurations;
}

public void setLOBConfigurations(List<LOBConfiguration> value) {
	this.lOBConfigurations = value;
}



	//////////////////////////////////////////////////////
	// Source Relationships
	//////////////////////////////////////////////////////
	@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@JoinColumn(name="PULSE_CONFIGURATION_ID")
@org.hibernate.annotations.ForeignKey(name="FK_PulseConfigurationOfLOB")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private PulseConfiguration pulseConfiguration;
public PulseConfiguration getPulseConfiguration() {
	return this.pulseConfiguration;
}

public void setPulseConfiguration(PulseConfiguration value) {
	this.pulseConfiguration = value;
}@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@JoinColumn(name="CLIENT_ID")
@org.hibernate.annotations.ForeignKey(name="FK_ClientOfLOB")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private Client client;
public Client getClient() {
	return this.client;
}

public void setClient(Client value) {
	this.client = value;
}

	
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

				
		// Source Relationships
//Retrieve value of the Pulse Configuration of LOB relationship
objectJson += ",\"pulseConfiguration\":";
		if (getPulseConfiguration() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getPulseConfiguration()).toEmbeddedJson();
			} catch(Exception e) {
				objectJson += "null";
			}
		}
		objectJson += "";
//Retrieve value of the Client of LOB relationship
objectJson += ",\"client\":";
		if (getClient() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getClient()).toEmbeddedJson();
			} catch(Exception e) {
				objectJson += "null";
			}
		}
		objectJson += "";

		
		// Target Relationships
//Retrieve value of the LOB of LOB Configuration relationship
objectJson += ",\"lOBConfigurations\":[";
		
		if (getLOBConfigurations() != null) {
			int lOBConfigurationsCounter = 0;
			for(LOBConfiguration nextLOBConfigurations : getLOBConfigurations()) {
				if (lOBConfigurationsCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextLOBConfigurations).toEmbeddedJson();
					lOBConfigurationsCounter++;
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

		
		// Source Relationships
		this.pulseConfiguration = (PulseConfiguration) JsonUtils.getJsonPerceroObject(jsonObject, "pulseConfiguration");
		this.client = (Client) JsonUtils.getJsonPerceroObject(jsonObject, "client");


		// Target Relationships
		this.lOBConfigurations = (List<LOBConfiguration>) JsonUtils.getJsonListPerceroObject(jsonObject, "lOBConfigurations");


	}
	
	@Override
	protected List<MappedClassMethodPair> getListSetters() {
		List<MappedClassMethodPair> listSetters = super.getListSetters();

		// Target Relationships
		listSetters.add(MappedClass.getFieldSetters(LOBConfiguration.class, "lob"));

		
		return listSetters;
	}
}
