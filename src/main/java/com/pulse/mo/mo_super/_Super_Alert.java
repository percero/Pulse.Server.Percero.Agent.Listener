package com.pulse.mo.mo_super;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.google.gson.JsonObject;
import com.percero.agents.sync.metadata.MappedClass.MappedClassMethodPair;
import com.percero.agents.sync.vo.BaseDataObject;
import com.percero.serial.BDODeserializer;
import com.percero.serial.BDOSerializer;
import com.percero.serial.JsonUtils;
import com.pulse.mo.Person;

@MappedSuperclass
/*
*/
public class _Super_Alert extends BaseDataObject implements Serializable
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

	//////////////////////////////////////////////////////
	// Source Relationships
	//////////////////////////////////////////////////////
    @com.percero.agents.sync.metadata.annotations.Externalize
	@JsonSerialize(using=BDOSerializer.class)
	@JsonDeserialize(using=BDODeserializer.class)
	@JoinColumn(name="person_ID")
	@org.hibernate.annotations.ForeignKey(name="FK_Person_person_TO_Alert")
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	private Person person;
	public Person getPerson() {
		return this.person;
	}
	public void setPerson(Person value) {
		this.person = value;
	}

    @com.percero.agents.sync.metadata.annotations.Externalize
	@JsonSerialize(using=BDOSerializer.class)
	@JsonDeserialize(using=BDODeserializer.class)
	@JoinColumn(name="agent_ID")
	@org.hibernate.annotations.ForeignKey(name="FK_Person_agent_TO_Alert")
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	private Person agent;
	public Person getAgent() {
		return this.agent;
	}
	public void setAgent(Person value) {
		this.agent = value;
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
		// Source Relationships
		objectJson += ",\"person\":";
		if (getPerson() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getPerson()).toEmbeddedJson();
			} catch(Exception e) {
				objectJson += "null";
			}
		}
		objectJson += "";

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

		// Target Relationships
		
		return objectJson;
	}

	@Override
	protected void fromJson(JsonObject jsonObject) {
	    super.fromJson(jsonObject);

		// Properties

		// Source Relationships
        this.person = JsonUtils.getJsonPerceroObject(jsonObject, "person");
        this.agent = JsonUtils.getJsonPerceroObject(jsonObject, "agent");

		// Target Relationships
	}

	@Override
	protected List<MappedClassMethodPair> getListSetters() {
		List<MappedClassMethodPair> listSetters = super.getListSetters();

		// Target Relationships
	
		return listSetters;
	}
}