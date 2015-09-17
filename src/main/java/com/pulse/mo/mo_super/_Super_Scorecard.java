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

import com.pulse.mo.LOB;
import com.pulse.mo.ScorecardState;
import com.pulse.mo.AgentCoachingSessions;

import com.percero.agents.sync.vo.BaseDataObject;
import com.percero.serial.BDODeserializer;
import com.percero.serial.BDOSerializer;
import com.percero.serial.JsonUtils;

import com.pulse.mo.*;

@MappedSuperclass
/*
*/
public class _Super_Scorecard extends BaseDataObject implements Serializable
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
	private Date weekEndDate;
	public Date getWeekEndDate() {
		return this.weekEndDate;
	}
	public void setWeekEndDate(Date value)
	{
		this.weekEndDate = value;
	}


	//////////////////////////////////////////////////////
	// Source Relationships
	//////////////////////////////////////////////////////
    @com.percero.agents.sync.metadata.annotations.Externalize
	@JsonSerialize(using=BDOSerializer.class)
	@JsonDeserialize(using=BDODeserializer.class)
	@JoinColumn(name="lob_ID")
	@org.hibernate.annotations.ForeignKey(name="FK_LOB_lob_TO_Scorecard")
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	private LOB lob;
	public LOB getLob() {
		return this.lob;
	}
	public void setLob(LOB value) {
		this.lob = value;
	}

    @com.percero.agents.sync.metadata.annotations.Externalize
	@JsonSerialize(using=BDOSerializer.class)
	@JsonDeserialize(using=BDODeserializer.class)
	@JoinColumn(name="scorecardState_ID")
	@org.hibernate.annotations.ForeignKey(name="FK_ScorecardState_scorecardState_TO_Scorecard")
	@OneToOne(fetch=FetchType.LAZY, optional=false)
	private ScorecardState scorecardState;
	public ScorecardState getScorecardState() {
		return this.scorecardState;
	}
	public void setScorecardState(ScorecardState value) {
		this.scorecardState = value;
	}


	//////////////////////////////////////////////////////
	// Target Relationships
	//////////////////////////////////////////////////////
    @com.percero.agents.sync.metadata.annotations.Externalize
	@JsonSerialize(contentUsing=BDOSerializer.class)
	@JsonDeserialize(contentUsing=BDODeserializer.class)
	@OneToMany(fetch=FetchType.LAZY, targetEntity=AgentCoachingSessions.class, mappedBy="scorecard", cascade=javax.persistence.CascadeType.REMOVE)
	private List<AgentCoachingSessions> agentCoachingSessions;
	public List<AgentCoachingSessions> getAgentCoachingSessions() {
		return this.agentCoachingSessions;
	}
	public void setAgentCoachingSessions(List<AgentCoachingSessions> value) {
		this.agentCoachingSessions = value;
	}



	
	//////////////////////////////////////////////////////
	// JSON
	//////////////////////////////////////////////////////
	@Override
	public String retrieveJson(ObjectMapper objectMapper) {
		String objectJson = super.retrieveJson(objectMapper);

		// Properties
		objectJson += ",\"weekEndDate\":";
		if (getWeekEndDate() == null)
			objectJson += "null";
		else {
			objectJson += getWeekEndDate().getTime();
		}

		// Source Relationships
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

		objectJson += ",\"scorecardState\":";
		if (getScorecardState() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getScorecardState()).toEmbeddedJson();
			} catch(Exception e) {
				objectJson += "null";
			}
		}
		objectJson += "";

		// Target Relationships
		objectJson += ",\"agentCoachingSessions\":[";
		if (getAgentCoachingSessions() != null) {
			int agentCoachingSessionsCounter = 0;
			for(AgentCoachingSessions nextAgentCoachingSessions : getAgentCoachingSessions()) {
				if (agentCoachingSessionsCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextAgentCoachingSessions).toEmbeddedJson();
					agentCoachingSessionsCounter++;
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
		setWeekEndDate(JsonUtils.getJsonDate(jsonObject, "weekEndDate"));

		// Source Relationships
        this.lob = JsonUtils.getJsonPerceroObject(jsonObject, "lob");
        this.scorecardState = JsonUtils.getJsonPerceroObject(jsonObject, "scorecardState");

		// Target Relationships
		this.agentCoachingSessions = (List<AgentCoachingSessions>) JsonUtils.getJsonListPerceroObject(jsonObject, "agentCoachingSessions");
	}

	@Override
	protected List<MappedClassMethodPair> getListSetters() {
		List<MappedClassMethodPair> listSetters = super.getListSetters();

		// Target Relationships
		listSetters.add(MappedClass.getFieldSetters(AgentCoachingSessions.class, "scorecard"));
		listSetters.add(MappedClass.getFieldSetters(CoachingNotification.class, "scorecard"));
	
		return listSetters;
	}
}