package com.pulsev2.mo.mo_super;

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

import com.pulsev2.mo.Scorecard;

import com.percero.agents.sync.vo.BaseDataObject;
import com.percero.serial.BDODeserializer;
import com.percero.serial.BDOSerializer;
import com.percero.serial.JsonUtils;

import com.pulsev2.mo.*;

@MappedSuperclass
@SecondaryTable(name="CoachingNotification")
/*
*/
public class _Super_CoachingNotification extends com.pulsev2.mo.Notification
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
	private Integer pendingEmployeeStateCount;
	public Integer getPendingEmployeeStateCount() {
		return this.pendingEmployeeStateCount;
	}
	public void setPendingEmployeeStateCount(Integer value)
	{
		this.pendingEmployeeStateCount = value;
	}

	@Column
    @com.percero.agents.sync.metadata.annotations.Externalize
	private Integer pendingCoachStateCount;
	public Integer getPendingCoachStateCount() {
		return this.pendingCoachStateCount;
	}
	public void setPendingCoachStateCount(Integer value)
	{
		this.pendingCoachStateCount = value;
	}

	@Column
    @com.percero.agents.sync.metadata.annotations.Externalize
	private Integer acknowledgementStateCount;
	public Integer getAcknowledgementStateCount() {
		return this.acknowledgementStateCount;
	}
	public void setAcknowledgementStateCount(Integer value)
	{
		this.acknowledgementStateCount = value;
	}

	@Column
    @com.percero.agents.sync.metadata.annotations.Externalize
	private Integer skippedStateCount;
	public Integer getSkippedStateCount() {
		return this.skippedStateCount;
	}
	public void setSkippedStateCount(Integer value)
	{
		this.skippedStateCount = value;
	}

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

	@Column
    @com.percero.agents.sync.metadata.annotations.Externalize
	private Integer submittedStateCount;
	public Integer getSubmittedStateCount() {
		return this.submittedStateCount;
	}
	public void setSubmittedStateCount(Integer value)
	{
		this.submittedStateCount = value;
	}

	@Column
    @com.percero.agents.sync.metadata.annotations.Externalize
	private Integer pendingStateCount;
	public Integer getPendingStateCount() {
		return this.pendingStateCount;
	}
	public void setPendingStateCount(Integer value)
	{
		this.pendingStateCount = value;
	}


	//////////////////////////////////////////////////////
	// Source Relationships
	//////////////////////////////////////////////////////
    @com.percero.agents.sync.metadata.annotations.Externalize
	@JsonSerialize(using=BDOSerializer.class)
	@JsonDeserialize(using=BDODeserializer.class)
	@JoinColumn(name="scorecard_ID")
	@org.hibernate.annotations.ForeignKey(name="FK_Scorecard_scorecard_TO_CoachingNotification")
	@OneToOne(fetch=FetchType.LAZY, optional=false)
	private Scorecard scorecard;
	public Scorecard getScorecard() {
		return this.scorecard;
	}
	public void setScorecard(Scorecard value) {
		this.scorecard = value;
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
		objectJson += ",\"pendingEmployeeStateCount\":";
		if (getPendingEmployeeStateCount() == null)
			objectJson += "null";
		else {
			objectJson += getPendingEmployeeStateCount();
		}

		objectJson += ",\"pendingCoachStateCount\":";
		if (getPendingCoachStateCount() == null)
			objectJson += "null";
		else {
			objectJson += getPendingCoachStateCount();
		}

		objectJson += ",\"acknowledgementStateCount\":";
		if (getAcknowledgementStateCount() == null)
			objectJson += "null";
		else {
			objectJson += getAcknowledgementStateCount();
		}

		objectJson += ",\"skippedStateCount\":";
		if (getSkippedStateCount() == null)
			objectJson += "null";
		else {
			objectJson += getSkippedStateCount();
		}

		objectJson += ",\"weekEndDate\":";
		if (getWeekEndDate() == null)
			objectJson += "null";
		else {
			objectJson += getWeekEndDate().getTime();
		}

		objectJson += ",\"submittedStateCount\":";
		if (getSubmittedStateCount() == null)
			objectJson += "null";
		else {
			objectJson += getSubmittedStateCount();
		}

		objectJson += ",\"pendingStateCount\":";
		if (getPendingStateCount() == null)
			objectJson += "null";
		else {
			objectJson += getPendingStateCount();
		}

		// Source Relationships
		objectJson += ",\"scorecard\":";
		if (getScorecard() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getScorecard()).toEmbeddedJson();
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
		setPendingEmployeeStateCount(JsonUtils.getJsonInteger(jsonObject, "pendingEmployeeStateCount"));
		setPendingCoachStateCount(JsonUtils.getJsonInteger(jsonObject, "pendingCoachStateCount"));
		setAcknowledgementStateCount(JsonUtils.getJsonInteger(jsonObject, "acknowledgementStateCount"));
		setSkippedStateCount(JsonUtils.getJsonInteger(jsonObject, "skippedStateCount"));
		setWeekEndDate(JsonUtils.getJsonDate(jsonObject, "weekEndDate"));
		setSubmittedStateCount(JsonUtils.getJsonInteger(jsonObject, "submittedStateCount"));
		setPendingStateCount(JsonUtils.getJsonInteger(jsonObject, "pendingStateCount"));

		// Source Relationships
        this.scorecard = JsonUtils.getJsonPerceroObject(jsonObject, "scorecard");

		// Target Relationships
	}

	@Override
	protected List<MappedClassMethodPair> getListSetters() {
		List<MappedClassMethodPair> listSetters = super.getListSetters();

		// Target Relationships
	
		return listSetters;
	}
}