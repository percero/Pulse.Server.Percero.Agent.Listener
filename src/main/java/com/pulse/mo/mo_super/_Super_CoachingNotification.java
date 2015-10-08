
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
@SecondaryTable(name="CoachingNotification")
@MappedSuperclass
public class _Super_CoachingNotification extends Notification implements Serializable
{
	//////////////////////////////////////////////////////
	// VERSION
	//////////////////////////////////////////////////////
	@Override
	public String classVersion() {
		return "1.0.0";
	}

	
	/*
	Keys of CoachingNotification
	*/
	
	
	//////////////////////////////////////////////////////
	// Properties
	//////////////////////////////////////////////////////
	/*
WeekendDate
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Date weekendDate;

public Date getWeekendDate() 
{
	return this.weekendDate;
}

public void setWeekendDate(Date weekendDate)
{
	this.weekendDate = weekendDate;
}/*
SubmittedStateCount
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Integer submittedStateCount;

public Integer getSubmittedStateCount() 
{
	return this.submittedStateCount;
}

public void setSubmittedStateCount(Integer submittedStateCount)
{
	this.submittedStateCount = submittedStateCount;
}/*
SkippedStateCount
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Integer skippedStateCount;

public Integer getSkippedStateCount() 
{
	return this.skippedStateCount;
}

public void setSkippedStateCount(Integer skippedStateCount)
{
	this.skippedStateCount = skippedStateCount;
}/*
PendingCoachStateCount
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Integer pendingCoachStateCount;

public Integer getPendingCoachStateCount() 
{
	return this.pendingCoachStateCount;
}

public void setPendingCoachStateCount(Integer pendingCoachStateCount)
{
	this.pendingCoachStateCount = pendingCoachStateCount;
}/*
PendingEmployeeStateCount
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Integer pendingEmployeeStateCount;

public Integer getPendingEmployeeStateCount() 
{
	return this.pendingEmployeeStateCount;
}

public void setPendingEmployeeStateCount(Integer pendingEmployeeStateCount)
{
	this.pendingEmployeeStateCount = pendingEmployeeStateCount;
}/*
AcknowledgementStateCount
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Integer acknowledgementStateCount;

public Integer getAcknowledgementStateCount() 
{
	return this.acknowledgementStateCount;
}

public void setAcknowledgementStateCount(Integer acknowledgementStateCount)
{
	this.acknowledgementStateCount = acknowledgementStateCount;
}/*
PendingStateCount
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Integer pendingStateCount;

public Integer getPendingStateCount() 
{
	return this.pendingStateCount;
}

public void setPendingStateCount(Integer pendingStateCount)
{
	this.pendingStateCount = pendingStateCount;
}

	//////////////////////////////////////////////////////
	// Target Relationships
	//////////////////////////////////////////////////////
	

	//////////////////////////////////////////////////////
	// Source Relationships
	//////////////////////////////////////////////////////
	@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@JoinColumn(name="SCORECARD_ID")
@org.hibernate.annotations.ForeignKey(name="FK_ScorecardOfCoachingNotification")
@OneToOne(fetch=FetchType.LAZY, optional=false)
private Scorecard scorecard;
public Scorecard getScorecard() {
	return this.scorecard;
}

public void setScorecard(Scorecard value) 
{
	this.scorecard = value;
}

	
	//////////////////////////////////////////////////////
	// JSON
	//////////////////////////////////////////////////////
	@Override
	public String retrieveJson(ObjectMapper objectMapper) {
		String objectJson = super.retrieveJson(objectMapper);

		// Properties		
		//Retrieve value of the Weekend Date property
		objectJson += ",\"weekendDate\":";
		
		if (getWeekendDate() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getWeekendDate());
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
		//Retrieve value of the Submitted State Count property
		objectJson += ",\"submittedStateCount\":";
		
		if (getSubmittedStateCount() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getSubmittedStateCount());
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
		//Retrieve value of the Skipped State Count property
		objectJson += ",\"skippedStateCount\":";
		
		if (getSkippedStateCount() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getSkippedStateCount());
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
		//Retrieve value of the Pending Coach State Count property
		objectJson += ",\"pendingCoachStateCount\":";
		
		if (getPendingCoachStateCount() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getPendingCoachStateCount());
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
		//Retrieve value of the Pending Employee State Count property
		objectJson += ",\"pendingEmployeeStateCount\":";
		
		if (getPendingEmployeeStateCount() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getPendingEmployeeStateCount());
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
		//Retrieve value of the Acknowledgement State Count property
		objectJson += ",\"acknowledgementStateCount\":";
		
		if (getAcknowledgementStateCount() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getAcknowledgementStateCount());
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
		//Retrieve value of the Pending State Count property
		objectJson += ",\"pendingStateCount\":";
		
		if (getPendingStateCount() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getPendingStateCount());
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
//Retrieve value of the Scorecard of Coaching Notification relationship
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
		//From value of the Weekend Date property
		setWeekendDate(JsonUtils.getJsonDate(jsonObject, "weekendDate"));
		//From value of the Submitted State Count property
		setSubmittedStateCount(JsonUtils.getJsonInteger(jsonObject, "submittedStateCount"));
		//From value of the Skipped State Count property
		setSkippedStateCount(JsonUtils.getJsonInteger(jsonObject, "skippedStateCount"));
		//From value of the Pending Coach State Count property
		setPendingCoachStateCount(JsonUtils.getJsonInteger(jsonObject, "pendingCoachStateCount"));
		//From value of the Pending Employee State Count property
		setPendingEmployeeStateCount(JsonUtils.getJsonInteger(jsonObject, "pendingEmployeeStateCount"));
		//From value of the Acknowledgement State Count property
		setAcknowledgementStateCount(JsonUtils.getJsonInteger(jsonObject, "acknowledgementStateCount"));
		//From value of the Pending State Count property
		setPendingStateCount(JsonUtils.getJsonInteger(jsonObject, "pendingStateCount"));

		
		// Source Relationships
		this.scorecard = (Scorecard) JsonUtils.getJsonPerceroObject(jsonObject, "scorecard");


		// Target Relationships


	}
	
	@Override
	protected List<MappedClassMethodPair> getListSetters() {
		List<MappedClassMethodPair> listSetters = super.getListSetters();

		// Target Relationships

		
		return listSetters;
	}
}
