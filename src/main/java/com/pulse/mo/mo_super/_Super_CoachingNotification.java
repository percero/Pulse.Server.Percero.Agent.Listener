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


import com.percero.agents.sync.vo.BaseDataObject;
import com.percero.serial.BDODeserializer;
import com.percero.serial.BDOSerializer;
import com.percero.serial.JsonUtils;

import com.pulse.mo.*;

@MappedSuperclass
@SecondaryTable(name="CoachingNotification")
/*
*/
public class _Super_CoachingNotification extends com.pulse.mo.Notification
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
	private Integer pendingStateCount;
	public Integer getPendingStateCount() {
		return this.pendingStateCount;
	}
	public void setPendingStateCount(Integer value)
	{
		this.pendingStateCount = value;
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
		objectJson += ",\"acknowledgementStateCount\":";
		if (getAcknowledgementStateCount() == null)
			objectJson += "null";
		else {
			objectJson += getAcknowledgementStateCount();
		}

		objectJson += ",\"pendingCoachStateCount\":";
		if (getPendingCoachStateCount() == null)
			objectJson += "null";
		else {
			objectJson += getPendingCoachStateCount();
		}

		objectJson += ",\"pendingEmployeeStateCount\":";
		if (getPendingEmployeeStateCount() == null)
			objectJson += "null";
		else {
			objectJson += getPendingEmployeeStateCount();
		}

		objectJson += ",\"pendingStateCount\":";
		if (getPendingStateCount() == null)
			objectJson += "null";
		else {
			objectJson += getPendingStateCount();
		}

		objectJson += ",\"skippedStateCount\":";
		if (getSkippedStateCount() == null)
			objectJson += "null";
		else {
			objectJson += getSkippedStateCount();
		}

		objectJson += ",\"submittedStateCount\":";
		if (getSubmittedStateCount() == null)
			objectJson += "null";
		else {
			objectJson += getSubmittedStateCount();
		}

		objectJson += ",\"weekEndDate\":";
		if (getWeekEndDate() == null)
			objectJson += "null";
		else {
			objectJson += getWeekEndDate().getTime();
		}

		// Source Relationships
		// Target Relationships
		
		return objectJson;
	}

	@Override
	protected void fromJson(JsonObject jsonObject) {
	    super.fromJson(jsonObject);

		// Properties
		setAcknowledgementStateCount(JsonUtils.getJsonInteger(jsonObject, "acknowledgementStateCount"));
		setPendingCoachStateCount(JsonUtils.getJsonInteger(jsonObject, "pendingCoachStateCount"));
		setPendingEmployeeStateCount(JsonUtils.getJsonInteger(jsonObject, "pendingEmployeeStateCount"));
		setPendingStateCount(JsonUtils.getJsonInteger(jsonObject, "pendingStateCount"));
		setSkippedStateCount(JsonUtils.getJsonInteger(jsonObject, "skippedStateCount"));
		setSubmittedStateCount(JsonUtils.getJsonInteger(jsonObject, "submittedStateCount"));
		setWeekEndDate(JsonUtils.getJsonDate(jsonObject, "weekEndDate"));

		// Source Relationships

		// Target Relationships
	}

	@Override
	protected List<MappedClassMethodPair> getListSetters() {
		List<MappedClassMethodPair> listSetters = super.getListSetters();

		// Target Relationships
	
		return listSetters;
	}
}