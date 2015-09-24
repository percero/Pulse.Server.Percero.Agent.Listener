
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
}/*
ScorecardName
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String scorecardName;

public String getScorecardName() 
{
	return this.scorecardName;
}

public void setScorecardName(String scorecardName)
{
	this.scorecardName = scorecardName;
}/*
MTDTrend
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String mTDTrend;

public String getMTDTrend() 
{
	return this.mTDTrend;
}

public void setMTDTrend(String mTDTrend)
{
	this.mTDTrend = mTDTrend;
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
WeeklyTrend
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String weeklyTrend;

public String getWeeklyTrend() 
{
	return this.weeklyTrend;
}

public void setWeeklyTrend(String weeklyTrend)
{
	this.weeklyTrend = weeklyTrend;
}/*
StateName
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String stateName;

public String getStateName() 
{
	return this.stateName;
}

public void setStateName(String stateName)
{
	this.stateName = stateName;
}/*
CurrentMTDOverallScore
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String currentMTDOverallScore;

public String getCurrentMTDOverallScore() 
{
	return this.currentMTDOverallScore;
}

public void setCurrentMTDOverallScore(String currentMTDOverallScore)
{
	this.currentMTDOverallScore = currentMTDOverallScore;
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
ExternalID
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String externalID;

public String getExternalID() 
{
	return this.externalID;
}

public void setExternalID(String externalID)
{
	this.externalID = externalID;
}/*
PreviousMTDOverallScore
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String previousMTDOverallScore;

public String getPreviousMTDOverallScore() 
{
	return this.previousMTDOverallScore;
}

public void setPreviousMTDOverallScore(String previousMTDOverallScore)
{
	this.previousMTDOverallScore = previousMTDOverallScore;
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
}

	//////////////////////////////////////////////////////
	// Target Relationships
	//////////////////////////////////////////////////////
	@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@OneToMany(fetch=FetchType.LAZY, targetEntity=Attachment.class, mappedBy="coachingSession", cascade=javax.persistence.CascadeType.REMOVE)
private List<Attachment> attachments;
public List<Attachment> getAttachments() {
	return this.attachments;
}

public void setAttachments(List<Attachment> value) {
	this.attachments = value;
}

@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@OneToMany(fetch=FetchType.LAZY, targetEntity=CoachingSessionMeasure.class, mappedBy="coachingSession", cascade=javax.persistence.CascadeType.REMOVE)
private List<CoachingSessionMeasure> coachingSessionMeasures;
public List<CoachingSessionMeasure> getCoachingSessionMeasures() {
	return this.coachingSessionMeasures;
}

public void setCoachingSessionMeasures(List<CoachingSessionMeasure> value) {
	this.coachingSessionMeasures = value;
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
@JoinColumn(name="agent_ID")
@org.hibernate.annotations.ForeignKey(name="FK_AgentOfCoachingSession")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private Agent agent;
public Agent getAgent() {
	return this.agent;
}

public void setAgent(Agent value) {
	this.agent = value;
}@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@JoinColumn(name="coachingSessionState_ID")
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
@JoinColumn(name="scorecard_ID")
@org.hibernate.annotations.ForeignKey(name="FK_ScorecardOfCoachingSession")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private Scorecard scorecard;
public Scorecard getScorecard() {
	return this.scorecard;
}

public void setScorecard(Scorecard value) {
	this.scorecard = value;
}

	
	//////////////////////////////////////////////////////
	// JSON
	//////////////////////////////////////////////////////
	@Override
	public String retrieveJson(ObjectMapper objectMapper) {
		String objectJson = super.retrieveJson(objectMapper);

		// Properties		
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
		//Retrieve value of the Scorecard Name property
		objectJson += ",\"scorecardName\":";
		
		if (getScorecardName() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getScorecardName());
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
		//Retrieve value of the MTD Trend property
		objectJson += ",\"mTDTrend\":";
		
		if (getMTDTrend() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getMTDTrend());
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
		//Retrieve value of the Weekly Trend property
		objectJson += ",\"weeklyTrend\":";
		
		if (getWeeklyTrend() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getWeeklyTrend());
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
		//Retrieve value of the State Name property
		objectJson += ",\"stateName\":";
		
		if (getStateName() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getStateName());
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
		//Retrieve value of the Current MTD Overall Score property
		objectJson += ",\"currentMTDOverallScore\":";
		
		if (getCurrentMTDOverallScore() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getCurrentMTDOverallScore());
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
		//Retrieve value of the Current MTD Threshold Grade property
		objectJson += ",\"currentMTDThresholdGrade\":";
		if (getCurrentMTDThresholdGrade() == null)
			objectJson += "null";
		else {
			objectJson += getCurrentMTDThresholdGrade();
		}
		//Retrieve value of the External ID property
		objectJson += ",\"externalID\":";
		
		if (getExternalID() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getExternalID());
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
		//Retrieve value of the Previous MTD Overall Score property
		objectJson += ",\"previousMTDOverallScore\":";
		
		if (getPreviousMTDOverallScore() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getPreviousMTDOverallScore());
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

				
		// Source Relationships
//Retrieve value of the Agent of Coaching Session relationship
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
//Retrieve value of the Scorecard of Coaching Session relationship
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
//Retrieve value of the Coaching Session of Attachment relationship
objectJson += ",\"attachments\":[";
		
		if (getAttachments() != null) {
			int attachmentsCounter = 0;
			for(Attachment nextAttachments : getAttachments()) {
				if (attachmentsCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextAttachments).toEmbeddedJson();
					attachmentsCounter++;
				} catch(Exception e) {
					// Do nothing.
				}
			}
		}
		objectJson += "]";
//Retrieve value of the Coaching Session of Coaching Session Measure relationship
objectJson += ",\"coachingSessionMeasures\":[";
		
		if (getCoachingSessionMeasures() != null) {
			int coachingSessionMeasuresCounter = 0;
			for(CoachingSessionMeasure nextCoachingSessionMeasures : getCoachingSessionMeasures()) {
				if (coachingSessionMeasuresCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextCoachingSessionMeasures).toEmbeddedJson();
					coachingSessionMeasuresCounter++;
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
		//From value of the Weekly Overall Score property
		setWeeklyOverallScore(JsonUtils.getJsonString(jsonObject, "weeklyOverallScore"));
		//From value of the Weekly Overall Score State Name property
		setWeeklyOverallScoreStateName(JsonUtils.getJsonString(jsonObject, "weeklyOverallScoreStateName"));
		//From value of the Scorecard Name property
		setScorecardName(JsonUtils.getJsonString(jsonObject, "scorecardName"));
		//From value of the MTD Trend property
		setMTDTrend(JsonUtils.getJsonString(jsonObject, "mTDTrend"));
		//From value of the Weekend Date property
		setWeekendDate(JsonUtils.getJsonString(jsonObject, "weekendDate"));
		//From value of the Weekly Trend property
		setWeeklyTrend(JsonUtils.getJsonString(jsonObject, "weeklyTrend"));
		//From value of the State Name property
		setStateName(JsonUtils.getJsonString(jsonObject, "stateName"));
		//From value of the Current MTD Overall Score property
		setCurrentMTDOverallScore(JsonUtils.getJsonString(jsonObject, "currentMTDOverallScore"));
		//From value of the Current MTD Threshold Grade property
		setCurrentMTDThresholdGrade(JsonUtils.getJsonDouble(jsonObject, "currentMTDThresholdGrade"));
		//From value of the External ID property
		setExternalID(JsonUtils.getJsonString(jsonObject, "externalID"));
		//From value of the Previous MTD Overall Score property
		setPreviousMTDOverallScore(JsonUtils.getJsonString(jsonObject, "previousMTDOverallScore"));
		//From value of the Previous MTD Threshold Grade property
		setPreviousMTDThresholdGrade(JsonUtils.getJsonDouble(jsonObject, "previousMTDThresholdGrade"));

		
		// Source Relationships
		this.agent = (Agent) JsonUtils.getJsonPerceroObject(jsonObject, "agent");
		this.coachingSessionState = (CoachingSessionState) JsonUtils.getJsonPerceroObject(jsonObject, "coachingSessionState");
		this.scorecard = (Scorecard) JsonUtils.getJsonPerceroObject(jsonObject, "scorecard");


		// Target Relationships
		this.attachments = (List<Attachment>) JsonUtils.getJsonListPerceroObject(jsonObject, "attachments");
		this.coachingSessionMeasures = (List<CoachingSessionMeasure>) JsonUtils.getJsonListPerceroObject(jsonObject, "coachingSessionMeasures");
		this.qualityEvaluations = (List<QualityEvaluation>) JsonUtils.getJsonListPerceroObject(jsonObject, "qualityEvaluations");


	}
	
	@Override
	protected List<MappedClassMethodPair> getListSetters() {
		List<MappedClassMethodPair> listSetters = super.getListSetters();

		// Target Relationships
		listSetters.add(MappedClass.getFieldSetters(Attachment.class, "coachingsession"));
		listSetters.add(MappedClass.getFieldSetters(CoachingSessionMeasure.class, "coachingsession"));
		listSetters.add(MappedClass.getFieldSetters(QualityEvaluation.class, "coachingsession"));

		
		return listSetters;
	}
}
