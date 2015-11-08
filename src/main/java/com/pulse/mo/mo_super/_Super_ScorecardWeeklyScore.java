

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
public class _Super_ScorecardWeeklyScore extends BaseDataObject implements Serializable
{
	//////////////////////////////////////////////////////
	// VERSION
	//////////////////////////////////////////////////////
	@Override
	public String classVersion() {
		return "1.0.0";
	}

	
	/*
	Keys of ScorecardWeeklyScore
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
EmployeeId
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String employeeId;

public String getEmployeeId() 
{
	return this.employeeId;
}

public void setEmployeeId(String employeeId)
{
	this.employeeId = employeeId;
}/*
PointsReceived
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Double pointsReceived;

public Double getPointsReceived() 
{
	return this.pointsReceived;
}

public void setPointsReceived(Double pointsReceived)
{
	this.pointsReceived = pointsReceived;
}/*
IntervalType
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String intervalType;

public String getIntervalType() 
{
	return this.intervalType;
}

public void setIntervalType(String intervalType)
{
	this.intervalType = intervalType;
}/*
StartDate
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Date startDate;

public Date getStartDate() 
{
	return this.startDate;
}

public void setStartDate(Date startDate)
{
	this.startDate = startDate;
}/*
EndDate
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Date endDate;

public Date getEndDate() 
{
	return this.endDate;
}

public void setEndDate(Date endDate)
{
	this.endDate = endDate;
}/*
Score
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Double score;

public Double getScore() 
{
	return this.score;
}

public void setScore(Double score)
{
	this.score = score;
}/*
PointsPossible
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Double pointsPossible;

public Double getPointsPossible() 
{
	return this.pointsPossible;
}

public void setPointsPossible(Double pointsPossible)
{
	this.pointsPossible = pointsPossible;
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
Grade
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Integer grade;

public Integer getGrade() 
{
	return this.grade;
}

public void setGrade(Integer grade)
{
	this.grade = grade;
}

	//////////////////////////////////////////////////////
	// Target Relationships
	//////////////////////////////////////////////////////
	

	//////////////////////////////////////////////////////
	// Source Relationships
	//////////////////////////////////////////////////////
	
@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@JoinColumn(name="AGENT_ID")
@org.hibernate.annotations.ForeignKey(name="FK_AgentOfScorecardWeeklyScore")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private Agent agent;
public Agent getAgent() {
	return this.agent;
}

public void setAgent(Agent value) {
	this.agent = value;
}
@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@JoinColumn(name="SCORECARD_ID")
@org.hibernate.annotations.ForeignKey(name="FK_ScorecardOfScorecardWeeklyScore")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private Scorecard scorecard;
public Scorecard getScorecard() {
	return this.scorecard;
}

public void setScorecard(Scorecard value) {
	this.scorecard = value;
}
@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@JoinColumn(name="PREV_SCARD_WEEKLY_SCORE_ID")
@org.hibernate.annotations.ForeignKey(name="FK_PreviousScorecardWeeklyScoreOfNextScorecardWeeklyScore")
@OneToOne(fetch=FetchType.LAZY, optional=false)
private ScorecardWeeklyScore previousScorecardWeeklyScore;
public ScorecardWeeklyScore getPreviousScorecardWeeklyScore() {
	return this.previousScorecardWeeklyScore;
}

public void setPreviousScorecardWeeklyScore(ScorecardWeeklyScore value) 
{
	this.previousScorecardWeeklyScore = value;
}
@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@JoinColumn(name="GOAL_ID")
@org.hibernate.annotations.ForeignKey(name="FK_GoalOfScorecardWeeklyScore")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private Goal goal;
public Goal getGoal() {
	return this.goal;
}

public void setGoal(Goal value) {
	this.goal = value;
}
@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@JoinColumn(name="SCORECARD_MONTHLY_SCORE_ID")
@org.hibernate.annotations.ForeignKey(name="FK_ScorecardMonthlyScoreOfScorecardWeeklyScore")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private ScorecardMonthlyScore scorecardMonthlyScore;
public ScorecardMonthlyScore getScorecardMonthlyScore() {
	return this.scorecardMonthlyScore;
}

public void setScorecardMonthlyScore(ScorecardMonthlyScore value) {
	this.scorecardMonthlyScore = value;
}
@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@JoinColumn(name="SCORECARD_MEASURE_ID")
@org.hibernate.annotations.ForeignKey(name="FK_ScorecardMeasureOfScorecardWeeklyScore")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private ScorecardMeasure scorecardMeasure;
public ScorecardMeasure getScorecardMeasure() {
	return this.scorecardMeasure;
}

public void setScorecardMeasure(ScorecardMeasure value) {
	this.scorecardMeasure = value;
}

	
	//////////////////////////////////////////////////////
	// JSON
	//////////////////////////////////////////////////////
	@Override
	public String retrieveJson(ObjectMapper objectMapper) {
		String objectJson = super.retrieveJson(objectMapper);

		// Properties		
		//Retrieve value of the Created On property
		objectJson += ",\"createdOn\":";
		if (getCreatedOn() == null)
			objectJson += "null";
		else {
			objectJson += getCreatedOn().getTime();
		}
		//Retrieve value of the Employee Id property
		objectJson += ",\"employeeId\":";
		
		if (getEmployeeId() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getEmployeeId());
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
		//Retrieve value of the Points Received property
		objectJson += ",\"pointsReceived\":";
		if (getPointsReceived() == null)
			objectJson += "null";
		else {
			objectJson += getPointsReceived();
		}
		//Retrieve value of the Interval Type property
		objectJson += ",\"intervalType\":";
		
		if (getIntervalType() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getIntervalType());
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
		//Retrieve value of the Start Date property
		objectJson += ",\"startDate\":";
		if (getStartDate() == null)
			objectJson += "null";
		else {
			objectJson += getStartDate().getTime();
		}
		//Retrieve value of the End Date property
		objectJson += ",\"endDate\":";
		if (getEndDate() == null)
			objectJson += "null";
		else {
			objectJson += getEndDate().getTime();
		}
		//Retrieve value of the Score property
		objectJson += ",\"score\":";
		if (getScore() == null)
			objectJson += "null";
		else {
			objectJson += getScore();
		}
		//Retrieve value of the Points Possible property
		objectJson += ",\"pointsPossible\":";
		if (getPointsPossible() == null)
			objectJson += "null";
		else {
			objectJson += getPointsPossible();
		}
		//Retrieve value of the Updated On property
		objectJson += ",\"updatedOn\":";
		if (getUpdatedOn() == null)
			objectJson += "null";
		else {
			objectJson += getUpdatedOn().getTime();
		}
		//Retrieve value of the Grade property
		objectJson += ",\"grade\":";
		
		if (getGrade() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getGrade());
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
//Retrieve value of the Agent of Scorecard Weekly Score relationship
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
//Retrieve value of the Scorecard of Scorecard Weekly Score relationship
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
//Retrieve value of the Previous Scorecard Weekly Score of Next Scorecard Weekly Score relationship
objectJson += ",\"previousScorecardWeeklyScore\":";
		if (getPreviousScorecardWeeklyScore() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getPreviousScorecardWeeklyScore()).toEmbeddedJson();
			} catch(Exception e) {
				objectJson += "null";
			}
		}
		objectJson += "";
//Retrieve value of the Goal of Scorecard Weekly Score relationship
objectJson += ",\"goal\":";
		if (getGoal() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getGoal()).toEmbeddedJson();
			} catch(Exception e) {
				objectJson += "null";
			}
		}
		objectJson += "";
//Retrieve value of the Scorecard Monthly Score of Scorecard Weekly Score relationship
objectJson += ",\"scorecardMonthlyScore\":";
		if (getScorecardMonthlyScore() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getScorecardMonthlyScore()).toEmbeddedJson();
			} catch(Exception e) {
				objectJson += "null";
			}
		}
		objectJson += "";
//Retrieve value of the Scorecard Measure of Scorecard Weekly Score relationship
objectJson += ",\"scorecardMeasure\":";
		if (getScorecardMeasure() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getScorecardMeasure()).toEmbeddedJson();
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
		//From value of the Created On property
		setCreatedOn(JsonUtils.getJsonDate(jsonObject, "createdOn"));
		//From value of the Employee Id property
		setEmployeeId(JsonUtils.getJsonString(jsonObject, "employeeId"));
		//From value of the Points Received property
		setPointsReceived(JsonUtils.getJsonDouble(jsonObject, "pointsReceived"));
		//From value of the Interval Type property
		setIntervalType(JsonUtils.getJsonString(jsonObject, "intervalType"));
		//From value of the Start Date property
		setStartDate(JsonUtils.getJsonDate(jsonObject, "startDate"));
		//From value of the End Date property
		setEndDate(JsonUtils.getJsonDate(jsonObject, "endDate"));
		//From value of the Score property
		setScore(JsonUtils.getJsonDouble(jsonObject, "score"));
		//From value of the Points Possible property
		setPointsPossible(JsonUtils.getJsonDouble(jsonObject, "pointsPossible"));
		//From value of the Updated On property
		setUpdatedOn(JsonUtils.getJsonDate(jsonObject, "updatedOn"));
		//From value of the Grade property
		setGrade(JsonUtils.getJsonInteger(jsonObject, "grade"));

		
		// Source Relationships
		this.agent = (Agent) JsonUtils.getJsonPerceroObject(jsonObject, "agent");
		this.scorecard = (Scorecard) JsonUtils.getJsonPerceroObject(jsonObject, "scorecard");
		this.previousScorecardWeeklyScore = (ScorecardWeeklyScore) JsonUtils.getJsonPerceroObject(jsonObject, "previousScorecardWeeklyScore");
		this.goal = (Goal) JsonUtils.getJsonPerceroObject(jsonObject, "goal");
		this.scorecardMonthlyScore = (ScorecardMonthlyScore) JsonUtils.getJsonPerceroObject(jsonObject, "scorecardMonthlyScore");
		this.scorecardMeasure = (ScorecardMeasure) JsonUtils.getJsonPerceroObject(jsonObject, "scorecardMeasure");


		// Target Relationships


	}
	
	@Override
	protected List<MappedClassMethodPair> getListSetters() {
		List<MappedClassMethodPair> listSetters = super.getListSetters();

		// Target Relationships

		
		return listSetters;
	}
}

