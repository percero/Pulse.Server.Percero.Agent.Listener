
package com.pulsemobile.mo.mo_super;

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

import com.pulsemobile.mo.*;

/*
Entity Tags based on semantic requirements
*/

@MappedSuperclass
public class _Super_CoachingSessionMeasure extends BaseDataObject implements Serializable
{
	//////////////////////////////////////////////////////
	// VERSION
	//////////////////////////////////////////////////////
	@Override
	public String classVersion() {
		return "1.0.0";
	}

	
	/*
	Keys of CoachingSessionMeasure
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
MTDScore
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String mTDScore;

public String getMTDScore() 
{
	return this.mTDScore;
}

public void setMTDScore(String mTDScore)
{
	this.mTDScore = mTDScore;
}/*
PreviousMonthScore
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String previousMonthScore;

public String getPreviousMonthScore() 
{
	return this.previousMonthScore;
}

public void setPreviousMonthScore(String previousMonthScore)
{
	this.previousMonthScore = previousMonthScore;
}/*
PrevioisWeekScore
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String previoisWeekScore;

public String getPrevioisWeekScore() 
{
	return this.previoisWeekScore;
}

public void setPrevioisWeekScore(String previoisWeekScore)
{
	this.previoisWeekScore = previoisWeekScore;
}/*
RequiresCoaching
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Boolean requiresCoaching;

public Boolean getRequiresCoaching() 
{
	return this.requiresCoaching;
}

public void setRequiresCoaching(Boolean requiresCoaching)
{
	this.requiresCoaching = requiresCoaching;
}/*
PreviousMonthScoreThresholdGrade
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String previousMonthScoreThresholdGrade;

public String getPreviousMonthScoreThresholdGrade() 
{
	return this.previousMonthScoreThresholdGrade;
}

public void setPreviousMonthScoreThresholdGrade(String previousMonthScoreThresholdGrade)
{
	this.previousMonthScoreThresholdGrade = previousMonthScoreThresholdGrade;
}/*
Name
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String name;

public String getName() 
{
	return this.name;
}

public void setName(String name)
{
	this.name = name;
}/*
Goal
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String goal;

public String getGoal() 
{
	return this.goal;
}

public void setGoal(String goal)
{
	this.goal = goal;
}/*
Coachable
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Boolean coachable;

public Boolean getCoachable() 
{
	return this.coachable;
}

public void setCoachable(Boolean coachable)
{
	this.coachable = coachable;
}/*
Tenure
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String tenure;

public String getTenure() 
{
	return this.tenure;
}

public void setTenure(String tenure)
{
	this.tenure = tenure;
}/*
CurrentWeekScoreThresholdGrade
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String currentWeekScoreThresholdGrade;

public String getCurrentWeekScoreThresholdGrade() 
{
	return this.currentWeekScoreThresholdGrade;
}

public void setCurrentWeekScoreThresholdGrade(String currentWeekScoreThresholdGrade)
{
	this.currentWeekScoreThresholdGrade = currentWeekScoreThresholdGrade;
}/*
MTDScoreThresholdGrade
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String mTDScoreThresholdGrade;

public String getMTDScoreThresholdGrade() 
{
	return this.mTDScoreThresholdGrade;
}

public void setMTDScoreThresholdGrade(String mTDScoreThresholdGrade)
{
	this.mTDScoreThresholdGrade = mTDScoreThresholdGrade;
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
EligableForIncentive
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Boolean eligableForIncentive;

public Boolean getEligableForIncentive() 
{
	return this.eligableForIncentive;
}

public void setEligableForIncentive(Boolean eligableForIncentive)
{
	this.eligableForIncentive = eligableForIncentive;
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
CurrentWeekScore
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String currentWeekScore;

public String getCurrentWeekScore() 
{
	return this.currentWeekScore;
}

public void setCurrentWeekScore(String currentWeekScore)
{
	this.currentWeekScore = currentWeekScore;
}/*
Weight
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String weight;

public String getWeight() 
{
	return this.weight;
}

public void setWeight(String weight)
{
	this.weight = weight;
}/*
PrevioisWeekScoreThresholdGrade
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String previoisWeekScoreThresholdGrade;

public String getPrevioisWeekScoreThresholdGrade() 
{
	return this.previoisWeekScoreThresholdGrade;
}

public void setPrevioisWeekScoreThresholdGrade(String previoisWeekScoreThresholdGrade)
{
	this.previoisWeekScoreThresholdGrade = previoisWeekScoreThresholdGrade;
}

	//////////////////////////////////////////////////////
	// Target Relationships
	//////////////////////////////////////////////////////
	@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@OneToMany(fetch=FetchType.LAZY, targetEntity=Behavior.class, mappedBy="coachingSessionMeasure", cascade=javax.persistence.CascadeType.REMOVE)
private List<Behavior> behaviors;
public List<Behavior> getBehaviors() {
	return this.behaviors;
}

public void setBehaviors(List<Behavior> value) {
	this.behaviors = value;
}

@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@OneToMany(fetch=FetchType.LAZY, targetEntity=Observation.class, mappedBy="coachingSessionMeasure", cascade=javax.persistence.CascadeType.REMOVE)
private List<Observation> observations;
public List<Observation> getObservations() {
	return this.observations;
}

public void setObservations(List<Observation> value) {
	this.observations = value;
}



	//////////////////////////////////////////////////////
	// Source Relationships
	//////////////////////////////////////////////////////
	@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@JoinColumn(name="CoachingSessionId")
@org.hibernate.annotations.ForeignKey(name="FK_CoachingSessionOfCoachingSessionMeasure")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private CoachingSession coachingSession;
public CoachingSession getCoachingSession() {
	return this.coachingSession;
}

public void setCoachingSession(CoachingSession value) {
	this.coachingSession = value;
}

	
	//////////////////////////////////////////////////////
	// JSON
	//////////////////////////////////////////////////////
	@Override
	public String retrieveJson(ObjectMapper objectMapper) {
		String objectJson = super.retrieveJson(objectMapper);

		// Properties		
		//Retrieve value of the MTD Score property
		objectJson += ",\"mTDScore\":";
		
		if (getMTDScore() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getMTDScore());
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
		//Retrieve value of the Previous Month Score property
		objectJson += ",\"previousMonthScore\":";
		
		if (getPreviousMonthScore() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getPreviousMonthScore());
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
		//Retrieve value of the Previois Week Score property
		objectJson += ",\"previoisWeekScore\":";
		
		if (getPrevioisWeekScore() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getPrevioisWeekScore());
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
		//Retrieve value of the Requires Coaching property
		objectJson += ",\"requiresCoaching\":";
		if (getRequiresCoaching() == null)
			objectJson += "null";
		else {
			objectJson += getRequiresCoaching();
		}
		//Retrieve value of the Previous Month Score Threshold Grade property
		objectJson += ",\"previousMonthScoreThresholdGrade\":";
		
		if (getPreviousMonthScoreThresholdGrade() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getPreviousMonthScoreThresholdGrade());
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
		//Retrieve value of the Name property
		objectJson += ",\"name\":";
		
		if (getName() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getName());
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
		//Retrieve value of the Goal property
		objectJson += ",\"goal\":";
		
		if (getGoal() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getGoal());
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
		//Retrieve value of the Coachable property
		objectJson += ",\"coachable\":";
		if (getCoachable() == null)
			objectJson += "null";
		else {
			objectJson += getCoachable();
		}
		//Retrieve value of the Tenure property
		objectJson += ",\"tenure\":";
		
		if (getTenure() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getTenure());
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
		//Retrieve value of the Current Week Score Threshold Grade property
		objectJson += ",\"currentWeekScoreThresholdGrade\":";
		
		if (getCurrentWeekScoreThresholdGrade() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getCurrentWeekScoreThresholdGrade());
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
		//Retrieve value of the MTD Score Threshold Grade property
		objectJson += ",\"mTDScoreThresholdGrade\":";
		
		if (getMTDScoreThresholdGrade() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getMTDScoreThresholdGrade());
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
		//Retrieve value of the Eligable For Incentive property
		objectJson += ",\"eligableForIncentive\":";
		if (getEligableForIncentive() == null)
			objectJson += "null";
		else {
			objectJson += getEligableForIncentive();
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
		//Retrieve value of the Current Week Score property
		objectJson += ",\"currentWeekScore\":";
		
		if (getCurrentWeekScore() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getCurrentWeekScore());
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
		//Retrieve value of the Weight property
		objectJson += ",\"weight\":";
		
		if (getWeight() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getWeight());
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
		//Retrieve value of the Previois Week Score Threshold Grade property
		objectJson += ",\"previoisWeekScoreThresholdGrade\":";
		
		if (getPrevioisWeekScoreThresholdGrade() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getPrevioisWeekScoreThresholdGrade());
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
//Retrieve value of the Coaching Session of Coaching Session Measure relationship
objectJson += ",\"coachingSession\":";
		if (getCoachingSession() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getCoachingSession()).toEmbeddedJson();
			} catch(Exception e) {
				objectJson += "null";
			}
		}
		objectJson += "";

		
		// Target Relationships
//Retrieve value of the Coaching Session Measure of Behavior relationship
objectJson += ",\"behaviors\":[";
		
		if (getBehaviors() != null) {
			int behaviorsCounter = 0;
			for(Behavior nextBehaviors : getBehaviors()) {
				if (behaviorsCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextBehaviors).toEmbeddedJson();
					behaviorsCounter++;
				} catch(Exception e) {
					// Do nothing.
				}
			}
		}
		objectJson += "]";
//Retrieve value of the Coaching Session Measure of Observation relationship
objectJson += ",\"observations\":[";
		
		if (getObservations() != null) {
			int observationsCounter = 0;
			for(Observation nextObservations : getObservations()) {
				if (observationsCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextObservations).toEmbeddedJson();
					observationsCounter++;
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
		//From value of the MTD Score property
		setMTDScore(JsonUtils.getJsonString(jsonObject, "mTDScore"));
		//From value of the Previous Month Score property
		setPreviousMonthScore(JsonUtils.getJsonString(jsonObject, "previousMonthScore"));
		//From value of the Previois Week Score property
		setPrevioisWeekScore(JsonUtils.getJsonString(jsonObject, "previoisWeekScore"));
		//From value of the Requires Coaching property
		setRequiresCoaching(JsonUtils.getJsonBoolean(jsonObject, "requiresCoaching"));
		//From value of the Previous Month Score Threshold Grade property
		setPreviousMonthScoreThresholdGrade(JsonUtils.getJsonString(jsonObject, "previousMonthScoreThresholdGrade"));
		//From value of the Name property
		setName(JsonUtils.getJsonString(jsonObject, "name"));
		//From value of the Goal property
		setGoal(JsonUtils.getJsonString(jsonObject, "goal"));
		//From value of the Coachable property
		setCoachable(JsonUtils.getJsonBoolean(jsonObject, "coachable"));
		//From value of the Tenure property
		setTenure(JsonUtils.getJsonString(jsonObject, "tenure"));
		//From value of the Current Week Score Threshold Grade property
		setCurrentWeekScoreThresholdGrade(JsonUtils.getJsonString(jsonObject, "currentWeekScoreThresholdGrade"));
		//From value of the MTD Score Threshold Grade property
		setMTDScoreThresholdGrade(JsonUtils.getJsonString(jsonObject, "mTDScoreThresholdGrade"));
		//From value of the MTD Trend property
		setMTDTrend(JsonUtils.getJsonString(jsonObject, "mTDTrend"));
		//From value of the Weekly Trend property
		setWeeklyTrend(JsonUtils.getJsonString(jsonObject, "weeklyTrend"));
		//From value of the Eligable For Incentive property
		setEligableForIncentive(JsonUtils.getJsonBoolean(jsonObject, "eligableForIncentive"));
		//From value of the External ID property
		setExternalID(JsonUtils.getJsonString(jsonObject, "externalID"));
		//From value of the Current Week Score property
		setCurrentWeekScore(JsonUtils.getJsonString(jsonObject, "currentWeekScore"));
		//From value of the Weight property
		setWeight(JsonUtils.getJsonString(jsonObject, "weight"));
		//From value of the Previois Week Score Threshold Grade property
		setPrevioisWeekScoreThresholdGrade(JsonUtils.getJsonString(jsonObject, "previoisWeekScoreThresholdGrade"));

		
		// Source Relationships
		this.coachingSession = (CoachingSession) JsonUtils.getJsonPerceroObject(jsonObject, "coachingSession");


		// Target Relationships
		this.behaviors = (List<Behavior>) JsonUtils.getJsonListPerceroObject(jsonObject, "behaviors");
		this.observations = (List<Observation>) JsonUtils.getJsonListPerceroObject(jsonObject, "observations");


	}
	
	@Override
	protected List<MappedClassMethodPair> getListSetters() {
		List<MappedClassMethodPair> listSetters = super.getListSetters();

		// Target Relationships
		listSetters.add(MappedClass.getFieldSetters(Behavior.class, "coachingsessionmeasure"));
		listSetters.add(MappedClass.getFieldSetters(Observation.class, "coachingsessionmeasure"));

		
		return listSetters;
	}
}
