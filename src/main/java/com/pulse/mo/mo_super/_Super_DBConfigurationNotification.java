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

import com.pulse.mo.Agent;
import com.pulse.mo.LOB;

import com.percero.agents.sync.metadata.annotations.Externalize;
import com.percero.agents.sync.metadata.MappedClass;
import com.percero.agents.sync.metadata.MappedClass.MappedClassMethodPair;
import com.percero.agents.sync.vo.BaseDataObject;
import com.percero.serial.BDODeserializer;
import com.percero.serial.BDOSerializer;
import com.percero.serial.JsonUtils;

import com.pulse.mo.*;

@MappedSuperclass
@SecondaryTable(name="DBConfigurationNotification")
/*
*/
public class _Super_DBConfigurationNotification extends com.pulse.mo.Notification
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
	/** Inherits from another Model Object Class, so no ID here. **/
	
	//////////////////////////////////////////////////////
	// Properties
	//////////////////////////////////////////////////////
	@Column
    @com.percero.agents.sync.metadata.annotations.Externalize
	private String message;
	public String getMessage() {
		return this.message;
	}
	public void setMessage(String value)
	{
		this.message = value;
	}


	//////////////////////////////////////////////////////
	// Source Relationships
	//////////////////////////////////////////////////////
    @com.percero.agents.sync.metadata.annotations.Externalize
	@JsonSerialize(using=BDOSerializer.class)
	@JsonDeserialize(using=BDODeserializer.class)
	@JoinColumn(name="agent_ID")
	@org.hibernate.annotations.ForeignKey(name="FK_Agent_agent_TO_DBConfigurationNotification")
	@OneToOne(fetch=FetchType.LAZY, optional=false)
	private Agent agent;
	public Agent getAgent() {
		return this.agent;
	}
	public void setAgent(Agent value) {
		this.agent = value;
	}

	@com.percero.agents.sync.metadata.annotations.Externalize(useLazyLoading=false)
	@JsonSerialize(using=BDOSerializer.class)
	@JsonDeserialize(using=BDODeserializer.class)
	@JoinColumn(name="lob_ID")
	@org.hibernate.annotations.ForeignKey(name="FK_LOB_lob_TO_DBConfigurationNotification")
	@OneToOne(fetch=FetchType.LAZY, optional=false)
	private LOB lob;
	public LOB getLob() {
		return this.lob;
	}
	public void setLob(LOB value) {
		this.lob = value;
	}


	//////////////////////////////////////////////////////
	// Target Relationships
	//////////////////////////////////////////////////////


	
	//////////////////////////////////////////////////////
	// JSON
	//////////////////////////////////////////////////////
	@Override
	public String retrieveJson(ObjectMapper objectMapper) {
		String objectJson = super.retrieveJson(objectMapper);

		// Properties
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

		objectJson += ",\"lob\":";
		if (getLob() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getLob()).toEmbeddedJson();
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
		setMessage(JsonUtils.getJsonString(jsonObject, "message"));

		// Source Relationships
        this.agent = JsonUtils.getJsonPerceroObject(jsonObject, "agent");
        this.lob = JsonUtils.getJsonPerceroObject(jsonObject, "lob");

		// Target Relationships
	}

	@Override
	protected List<MappedClassMethodPair> getListSetters() {
		List<MappedClassMethodPair> listSetters = super.getListSetters();

		// Target Relationships
	
		return listSetters;
	}
}