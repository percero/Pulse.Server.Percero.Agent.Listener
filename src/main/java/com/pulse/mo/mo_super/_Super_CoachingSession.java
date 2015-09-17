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

import com.pulse.mo.AgentCoachingSessions;
import com.pulse.mo.CoachingSessionState;

import com.percero.agents.sync.vo.BaseDataObject;
import com.percero.serial.BDODeserializer;
import com.percero.serial.BDOSerializer;
import com.percero.serial.JsonUtils;

import com.pulse.mo.*;

@MappedSuperclass
/*
*/
public class _Super_CoachingSession extends BaseDataObject implements Serializable
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
	@JoinColumn(name="agentCoachingSessions_ID")
	@org.hibernate.annotations.ForeignKey(name="FK_AgentCoachingSessions_agentCoachingSessions_TO_CoachingSession")
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	private AgentCoachingSessions agentCoachingSessions;
	public AgentCoachingSessions getAgentCoachingSessions() {
		return this.agentCoachingSessions;
	}
	public void setAgentCoachingSessions(AgentCoachingSessions value) {
		this.agentCoachingSessions = value;
	}

    @com.percero.agents.sync.metadata.annotations.Externalize
	@JsonSerialize(using=BDOSerializer.class)
	@JsonDeserialize(using=BDODeserializer.class)
	@JoinColumn(name="coachingSessionState_ID")
	@org.hibernate.annotations.ForeignKey(name="FK_CoachingSessionState_coachingSessionState_TO_CoachingSession")
	@OneToOne(fetch=FetchType.LAZY, optional=false)
	private CoachingSessionState coachingSessionState;
	public CoachingSessionState getCoachingSessionState() {
		return this.coachingSessionState;
	}
	public void setCoachingSessionState(CoachingSessionState value) {
		this.coachingSessionState = value;
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
		objectJson += ",\"agentCoachingSessions\":";
		if (getAgentCoachingSessions() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getAgentCoachingSessions()).toEmbeddedJson();
			} catch(Exception e) {
				objectJson += "null";
			}
		}
		objectJson += "";

		objectJson += ",\"coachingSessionState\":";
		if (getCoachingSessionState() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getCoachingSessionState()).toEmbeddedJson();
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
        this.agentCoachingSessions = JsonUtils.getJsonPerceroObject(jsonObject, "agentCoachingSessions");
        this.coachingSessionState = JsonUtils.getJsonPerceroObject(jsonObject, "coachingSessionState");

		// Target Relationships
	}

	@Override
	protected List<MappedClassMethodPair> getListSetters() {
		List<MappedClassMethodPair> listSetters = super.getListSetters();

		// Target Relationships
	
		return listSetters;
	}
}