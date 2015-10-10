
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
public class _Super_CoachingSession extends BaseDataObject implements Serializable
{
	//////////////////////////////////////////////////////
	// VERSION
	//////////////////////////////////////////////////////
	@Override
	public String classVersion() {
		return "1.0.0";
	}

	
	/*
	Keys of CoachingSession
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
Type
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String type;

public String getType() 
{
	return this.type;
}

public void setType(String type)
{
	this.type = type;
}/*
UpdatedOn
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Date updatedOn;

public Date getUpdatedOn() 
{
	return this.updatedOn;
}

public void setUpdatedOn(Date updatedOn)
{
	this.updatedOn = updatedOn;
}/*
UpdatedBy
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String updatedBy;

public String getUpdatedBy() 
{
	return this.updatedBy;
}

public void setUpdatedBy(String updatedBy)
{
	this.updatedBy = updatedBy;
}/*
PreviousMTDThresholdGrade
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Double previousMTDThresholdGrade;

public Double getPreviousMTDThresholdGrade() 
{
	return this.previousMTDThresholdGrade;
}

public void setPreviousMTDThresholdGrade(Double previousMTDThresholdGrade)
{
	this.previousMTDThresholdGrade = previousMTDThresholdGrade;
}/*
CurrentMTDThresholdGrade
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Double currentMTDThresholdGrade;

public Double getCurrentMTDThresholdGrade() 
{
	return this.currentMTDThresholdGrade;
}

public void setCurrentMTDThresholdGrade(Double currentMTDThresholdGrade)
{
	this.currentMTDThresholdGrade = currentMTDThresholdGrade;
}/*
CreatedBy
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String createdBy;

public String getCreatedBy() 
{
	return this.createdBy;
}

public void setCreatedBy(String createdBy)
{
	this.createdBy = createdBy;
}/*
WeeklyOverallScore
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String weeklyOverallScore;

public String getWeeklyOverallScore() 
{
	return this.weeklyOverallScore;
}

public void setWeeklyOverallScore(String weeklyOverallScore)
{
	this.weeklyOverallScore = weeklyOverallScore;
}/*
WeekendDate
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String weekendDate;

public String getWeekendDate() 
{
	return this.weekendDate;
}

public void setWeekendDate(String weekendDate)
{
	this.weekendDate = weekendDate;
}/*
CreatedOn
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Date createdOn;

public Date getCreatedOn() 
{
	return this.createdOn;
}

public void setCreatedOn(Date createdOn)
{
	this.createdOn = createdOn;
}/*
IsRequired
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Boolean isRequired;

public Boolean getIsRequired() 
{
	return this.isRequired;
}

public void setIsRequired(Boolean isRequired)
{
	this.isRequired = isRequired;
}/*
ClosedOn
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Date closedOn;

public Date getClosedOn() 
{
	return this.closedOn;
}

public void setClosedOn(Date closedOn)
{
	this.closedOn = closedOn;
}/*
WeeklyOverallScoreStateName
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String weeklyOverallScoreStateName;

public String getWeeklyOverallScoreStateName() 
{
	return this.weeklyOverallScoreStateName;
}

public void setWeeklyOverallScoreStateName(String weeklyOverallScoreStateName)
{
	this.weeklyOverallScoreStateName = weeklyOverallScoreStateName;
}

	//////////////////////////////////////////////////////
	// Target Relationships
	//////////////////////////////////////////////////////
	@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@OneToMany(fetch=FetchType.LAZY, targetEntity=BehaviorResponse.class, mappedBy="coachingSession", cascade=javax.persistence.CascadeType.REMOVE)
private List<BehaviorResponse> behaviorResponses;
public List<BehaviorResponse> getBehaviorResponses() {
	return this.behaviorResponses;
}

public void setBehaviorResponses(List<BehaviorResponse> value) {
	this.behaviorResponses = value;
}

@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@OneToMany(fetch=FetchType.LAZY, targetEntity=QualityEvaluation.class, mappedBy="coachingSession", cascade=javax.persistence.CascadeType.REMOVE)
private List<QualityEvaluation> qualityEvaluations;
public List<QualityEvaluation> getQualityEvaluations() {
	return this.qualityEvaluations;
}

public void setQualityEvaluations(List<QualityEvaluation> value) {
	this.qualityEvaluations = value;
}



	//////////////////////////////////////////////////////
	// Source Relationships
	//////////////////////////////////////////////////////
	@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@JoinColumn(name="COACHING_SESSION_STATE_ID")
@org.hibernate.annotations.ForeignKey(name="FK_CoachingSessionStateOfCoachingSession")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private CoachingSessionState coachingSessionState;
public CoachingSessionState getCoachingSessionState() {
	return this.coachingSessionState;
}

public void setCoachingSessionState(CoachingSessionState value) {
	this.coachingSessionState = value;
}@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@JoinColumn(name="AGENT_SCORECARD_ID")
@org.hibernate.annotations.ForeignKey(name="FK_AgentScorecardOfCoachingSession")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private AgentScorecard agentScorecard;
public AgentScorecard getAgentScorecard() {
	return this.agentScorecard;
}

public void setAgentScorecard(AgentScorecard value) {
	this.agentScorecard = value;
}

	
	//////////////////////////////////////////////////////
	// JSON
	//////////////////////////////////////////////////////
	@Override
	public String retrieveJson(ObjectMapper objectMapper) {
		String objectJson = super.retrieveJson(objectMapper);

		// Properties		
		//Retrieve value of the Type property
		objectJson += ",\"type\":";
		
		if (getType() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getType());
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
		//Retrieve value of the Updated On property
		objectJson += ",\"updatedOn\":";
		if (getUpdatedOn() == null)
			objectJson += "null";
		else {
			objectJson += getUpdatedOn().getTime();
		}
		//Retrieve value of the Updated By property
		objectJson += ",\"updatedBy\":";
		
		if (getUpdatedBy() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getUpdatedBy());
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
		//Retrieve value of the Previous MTD Threshold Grade property
		objectJson += ",\"previousMTDThresholdGrade\":";
		if (getPreviousMTDThresholdGrade() == null)
			objectJson += "null";
		else {
			objectJson += getPreviousMTDThresholdGrade();
		}
		//Retrieve value of the Current MTD Threshold Grade property
		objectJson += ",\"currentMTDThresholdGrade\":";
		if (getCurrentMTDThresholdGrade() == null)
			objectJson += "null";
		else {
			objectJson += getCurrentMTDThresholdGrade();
		}
		//Retrieve value of the Created By property
		objectJson += ",\"createdBy\":";
		
		if (getCreatedBy() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getCreatedBy());
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
		//Retrieve value of the Weekly Overall Score property
		objectJson += ",\"weeklyOverallScore\":";
		
		if (getWeeklyOverallScore() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getWeeklyOverallScore());
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
		//Retrieve value of the Created On property
		objectJson += ",\"createdOn\":";
		if (getCreatedOn() == null)
			objectJson += "null";
		else {
			objectJson += getCreatedOn().getTime();
		}
		//Retrieve value of the Is Required property
		objectJson += ",\"isRequired\":";
		if (getIsRequired() == null)
			objectJson += "null";
		else {
			objectJson += getIsRequired();
		}
		//Retrieve value of the Closed On property
		objectJson += ",\"closedOn\":";
		if (getClosedOn() == null)
			objectJson += "null";
		else {
			objectJson += getClosedOn().getTime();
		}
		//Retrieve value of the Weekly Overall Score State Name property
		objectJson += ",\"weeklyOverallScoreStateName\":";
		
		if (getWeeklyOverallScoreStateName() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getWeeklyOverallScoreStateName());
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
//Retrieve value of the Coaching Session State of Coaching Session relationship
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
//Retrieve value of the Agent Scorecard of Coaching Session relationship
objectJson += ",\"agentScorecard\":";
		if (getAgentScorecard() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getAgentScorecard()).toEmbeddedJson();
			} catch(Exception e) {
				objectJson += "null";
			}
		}
		objectJson += "";

		
		// Target Relationships
//Retrieve value of the Coaching Session of Behavior Response relationship
objectJson += ",\"behaviorResponses\":[";
		
		if (getBehaviorResponses() != null) {
			int behaviorResponsesCounter = 0;
			for(BehaviorResponse nextBehaviorResponses : getBehaviorResponses()) {
				if (behaviorResponsesCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextBehaviorResponses).toEmbeddedJson();
					behaviorResponsesCounter++;
				} catch(Exception e) {
					// Do nothing.
				}
			}
		}
		objectJson += "]";
//Retrieve value of the Coaching Session of Quality Evaluation relationship
objectJson += ",\"qualityEvaluations\":[";
		
		if (getQualityEvaluations() != null) {
			int qualityEvaluationsCounter = 0;
			for(QualityEvaluation nextQualityEvaluations : getQualityEvaluations()) {
				if (qualityEvaluationsCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextQualityEvaluations).toEmbeddedJson();
					qualityEvaluationsCounter++;
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
		//From value of the Type property
		setType(JsonUtils.getJsonString(jsonObject, "type"));
		//From value of the Updated On property
		setUpdatedOn(JsonUtils.getJsonDate(jsonObject, "updatedOn"));
		//From value of the Updated By property
		setUpdatedBy(JsonUtils.getJsonString(jsonObject, "updatedBy"));
		//From value of the Previous MTD Threshold Grade property
		setPreviousMTDThresholdGrade(JsonUtils.getJsonDouble(jsonObject, "previousMTDThresholdGrade"));
		//From value of the Current MTD Threshold Grade property
		setCurrentMTDThresholdGrade(JsonUtils.getJsonDouble(jsonObject, "currentMTDThresholdGrade"));
		//From value of the Created By property
		setCreatedBy(JsonUtils.getJsonString(jsonObject, "createdBy"));
		//From value of the Weekly Overall Score property
		setWeeklyOverallScore(JsonUtils.getJsonString(jsonObject, "weeklyOverallScore"));
		//From value of the Weekend Date property
		setWeekendDate(JsonUtils.getJsonString(jsonObject, "weekendDate"));
		//From value of the Created On property
		setCreatedOn(JsonUtils.getJsonDate(jsonObject, "createdOn"));
		//From value of the Is Required property
		setIsRequired(JsonUtils.getJsonBoolean(jsonObject, "isRequired"));
		//From value of the Closed On property
		setClosedOn(JsonUtils.getJsonDate(jsonObject, "closedOn"));
		//From value of the Weekly Overall Score State Name property
		setWeeklyOverallScoreStateName(JsonUtils.getJsonString(jsonObject, "weeklyOverallScoreStateName"));

		
		// Source Relationships
		this.coachingSessionState = (CoachingSessionState) JsonUtils.getJsonPerceroObject(jsonObject, "coachingSessionState");
		this.agentScorecard = (AgentScorecard) JsonUtils.getJsonPerceroObject(jsonObject, "agentScorecard");


		// Target Relationships
		this.behaviorResponses = (List<BehaviorResponse>) JsonUtils.getJsonListPerceroObject(jsonObject, "behaviorResponses");

		this.qualityEvaluations = (List<QualityEvaluation>) JsonUtils.getJsonListPerceroObject(jsonObject, "qualityEvaluations");


	}
	
	@Override
	protected List<MappedClassMethodPair> getListSetters() {
		List<MappedClassMethodPair> listSetters = super.getListSetters();

		// Target Relationships
		listSetters.add(MappedClass.getFieldSetters(BehaviorResponse.class, "coachingsession"));
		listSetters.add(MappedClass.getFieldSetters(QualityEvaluation.class, "coachingsession"));

		
		return listSetters;
	}
}
