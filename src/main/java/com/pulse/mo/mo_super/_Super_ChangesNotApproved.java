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
@SecondaryTable(name="ChangesNotApproved")
/*
*/
public class _Super_ChangesNotApproved extends com.pulse.mo.Notification
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
	private Integer approvedStateCount;
	public Integer getApprovedStateCount() {
		return this.approvedStateCount;
	}
	public void setApprovedStateCount(Integer value)
	{
		this.approvedStateCount = value;
	}

	@Column
    @com.percero.agents.sync.metadata.annotations.Externalize
	/**
	 *  

	 */
	private Integer completeStateCount;
	public Integer getCompleteStateCount() {
		return this.completeStateCount;
	}
	public void setCompleteStateCount(Integer value)
	{
		this.completeStateCount = value;
	}

	@Column
    @com.percero.agents.sync.metadata.annotations.Externalize
	private Integer inProgressStateCount;
	public Integer getInProgressStateCount() {
		return this.inProgressStateCount;
	}
	public void setInProgressStateCount(Integer value)
	{
		this.inProgressStateCount = value;
	}

	@Column
    @com.percero.agents.sync.metadata.annotations.Externalize
	private Integer notYetStartedStateCount;
	public Integer getNotYetStartedStateCount() {
		return this.notYetStartedStateCount;
	}
	public void setNotYetStartedStateCount(Integer value)
	{
		this.notYetStartedStateCount = value;
	}

	@Column
    @com.percero.agents.sync.metadata.annotations.Externalize
	private Date shiftEndDate;
	public Date getShiftEndDate() {
		return this.shiftEndDate;
	}
	public void setShiftEndDate(Date value)
	{
		this.shiftEndDate = value;
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
		objectJson += ",\"approvedStateCount\":";
		if (getApprovedStateCount() == null)
			objectJson += "null";
		else {
			objectJson += getApprovedStateCount();
		}

		objectJson += ",\"completeStateCount\":";
		if (getCompleteStateCount() == null)
			objectJson += "null";
		else {
			objectJson += getCompleteStateCount();
		}

		objectJson += ",\"inProgressStateCount\":";
		if (getInProgressStateCount() == null)
			objectJson += "null";
		else {
			objectJson += getInProgressStateCount();
		}

		objectJson += ",\"notYetStartedStateCount\":";
		if (getNotYetStartedStateCount() == null)
			objectJson += "null";
		else {
			objectJson += getNotYetStartedStateCount();
		}

		objectJson += ",\"shiftEndDate\":";
		if (getShiftEndDate() == null)
			objectJson += "null";
		else {
			objectJson += getShiftEndDate().getTime();
		}

		// Source Relationships
		// Target Relationships
		
		return objectJson;
	}

	@Override
	protected void fromJson(JsonObject jsonObject) {
	    super.fromJson(jsonObject);

		// Properties
		setApprovedStateCount(JsonUtils.getJsonInteger(jsonObject, "approvedStateCount"));
		setCompleteStateCount(JsonUtils.getJsonInteger(jsonObject, "completeStateCount"));
		setInProgressStateCount(JsonUtils.getJsonInteger(jsonObject, "inProgressStateCount"));
		setNotYetStartedStateCount(JsonUtils.getJsonInteger(jsonObject, "notYetStartedStateCount"));
		setShiftEndDate(JsonUtils.getJsonDate(jsonObject, "shiftEndDate"));

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