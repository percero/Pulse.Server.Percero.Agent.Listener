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

import com.pulse.mo.TeamLeader;
import com.pulse.mo.PulseUser;

import com.percero.agents.sync.vo.BaseDataObject;
import com.percero.serial.BDODeserializer;
import com.percero.serial.BDOSerializer;
import com.percero.serial.JsonUtils;

import com.pulse.mo.*;

@MappedSuperclass
/*
*/
public class _Super_TeamLeaderImpersonation extends BaseDataObject implements Serializable
{
	//////////////////////////////////////////////////////
	// VERSION
	//////////////////////////////////////////////////////
	@Override
	public String classVersion() {
		return "D3125E0B-9CB3-788F-018C-BE2E5A4DEFBC";
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
	private Date lastImpersonatedOn;
	public Date getLastImpersonatedOn() {
		return this.lastImpersonatedOn;
	}
	public void setLastImpersonatedOn(Date value)
	{
		this.lastImpersonatedOn = value;
	}


	//////////////////////////////////////////////////////
	// Source Relationships
	//////////////////////////////////////////////////////
    @com.percero.agents.sync.metadata.annotations.Externalize
	@JsonSerialize(using=BDOSerializer.class)
	@JsonDeserialize(using=BDODeserializer.class)
	@JoinColumn(name="teamLeader_ID")
	@org.hibernate.annotations.ForeignKey(name="FK_TeamLeader_teamLeader_TO_TeamLeaderImpersonation")
	@OneToOne(fetch=FetchType.LAZY, optional=false)
	private TeamLeader teamLeader;
	public TeamLeader getTeamLeader() {
		return this.teamLeader;
	}
	public void setTeamLeader(TeamLeader value) {
		this.teamLeader = value;
	}

    @com.percero.agents.sync.metadata.annotations.Externalize
	@JsonSerialize(using=BDOSerializer.class)
	@JsonDeserialize(using=BDODeserializer.class)
	@JoinColumn(name="pulseUser_ID")
	@org.hibernate.annotations.ForeignKey(name="FK_PulseUser_pulseUser_TO_TeamLeaderImpersonation")
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	private PulseUser pulseUser;
	public PulseUser getPulseUser() {
		return this.pulseUser;
	}
	public void setPulseUser(PulseUser value) {
		this.pulseUser = value;
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
		objectJson += ",\"lastImpersonatedOn\":";
		if (getLastImpersonatedOn() == null)
			objectJson += "null";
		else {
			objectJson += getLastImpersonatedOn().getTime();
		}

		// Source Relationships
		objectJson += ",\"teamLeader\":";
		if (getTeamLeader() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getTeamLeader()).toEmbeddedJson();
			} catch(Exception e) {
				objectJson += "null";
			}
		}
		objectJson += "";

		objectJson += ",\"pulseUser\":";
		if (getPulseUser() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getPulseUser()).toEmbeddedJson();
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
		setLastImpersonatedOn(JsonUtils.getJsonDate(jsonObject, "lastImpersonatedOn"));

		// Source Relationships
        this.teamLeader = JsonUtils.getJsonPerceroObject(jsonObject, "teamLeader");
        this.pulseUser = JsonUtils.getJsonPerceroObject(jsonObject, "pulseUser");

		// Target Relationships
	}

	@Override
	protected List<MappedClassMethodPair> getListSetters() {
		List<MappedClassMethodPair> listSetters = super.getListSetters();

		// Target Relationships
	
		return listSetters;
	}
}