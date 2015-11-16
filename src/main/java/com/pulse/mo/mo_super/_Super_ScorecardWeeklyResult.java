
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
public class _Super_ScorecardWeeklyResult extends BaseDataObject implements Serializable
{
	//////////////////////////////////////////////////////
	// VERSION
	//////////////////////////////////////////////////////
	@Override
	public String classVersion() {
		return "1.0.0";
	}

	
	/*
	Keys of ScorecardWeeklyResult
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
IsCoachable
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Boolean isCoachable;

public Boolean getIsCoachable() 
{
	return this.isCoachable;
}

public void setIsCoachable(Boolean isCoachable)
{
	this.isCoachable = isCoachable;
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
DurationTo
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Integer durationTo;

public Integer getDurationTo() 
{
	return this.durationTo;
}

public void setDurationTo(Integer durationTo)
{
	this.durationTo = durationTo;
}/*
GoalType
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Integer goalType;

public Integer getGoalType() 
{
	return this.goalType;
}

public void setGoalType(Integer goalType)
{
	this.goalType = goalType;
}/*
Excluded
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Integer excluded;

public Integer getExcluded() 
{
	return this.excluded;
}

public void setExcluded(Integer excluded)
{
	this.excluded = excluded;
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
Result
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Double result;

public Double getResult() 
{
	return this.result;
}

public void setResult(Double result)
{
	this.result = result;
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
PercentageAttainment
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Double percentageAttainment;

public Double getPercentageAttainment() 
{
	return this.percentageAttainment;
}

public void setPercentageAttainment(Double percentageAttainment)
{
	this.percentageAttainment = percentageAttainment;
}/*
DurationFrom
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Integer durationFrom;

public Integer getDurationFrom() 
{
	return this.durationFrom;
}

public void setDurationFrom(Integer durationFrom)
{
	this.durationFrom = durationFrom;
}/*
UpdatedOn
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String updatedOn;

public String getUpdatedOn() 
{
	return this.updatedOn;
}

public void setUpdatedOn(String updatedOn)
{
	this.updatedOn = updatedOn;
}/*
RollupType
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Integer rollupType;

public Integer getRollupType() 
{
	return this.rollupType;
}

public void setRollupType(Integer rollupType)
{
	this.rollupType = rollupType;
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
}/*
Tenure
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Integer tenure;

public Integer getTenure() 
{
	return this.tenure;
}

public void setTenure(Integer tenure)
{
	this.tenure = tenure;
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
WeekDate
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Date weekDate;

public Date getWeekDate() 
{
	return this.weekDate;
}

public void setWeekDate(Date weekDate)
{
	this.weekDate = weekDate;
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
}

	//////////////////////////////////////////////////////
	// Target Relationships
	//////////////////////////////////////////////////////
	@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@OneToMany(fetch=FetchType.LAZY, targetEntity=BehaviorResponse.class, mappedBy="scorecardWeeklyResult", cascade=javax.persistence.CascadeType.REMOVE)
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
@OneToMany(fetch=FetchType.LAZY, targetEntity=WeeklyDevelopmentActivity.class, mappedBy="scorecardWeeklyResult", cascade=javax.persistence.CascadeType.REMOVE)
private List<WeeklyDevelopmentActivity> weeklyDevelopmentActivities;
public List<WeeklyDevelopmentActivity> getWeeklyDevelopmentActivities() {
	return this.weeklyDevelopmentActivities;
}

public void setWeeklyDevelopmentActivities(List<WeeklyDevelopmentActivity> value) {
	this.weeklyDevelopmentActivities = value;
}

@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@OneToMany(fetch=FetchType.LAZY, targetEntity=WeeklyDevelopmentPlan.class, mappedBy="scorecardWeeklyResult", cascade=javax.persistence.CascadeType.REMOVE)
private List<WeeklyDevelopmentPlan> weeklyDevelopmentPlans;
public List<WeeklyDevelopmentPlan> getWeeklyDevelopmentPlans() {
	return this.weeklyDevelopmentPlans;
}

public void setWeeklyDevelopmentPlans(List<WeeklyDevelopmentPlan> value) {
	this.weeklyDevelopmentPlans = value;
}



	//////////////////////////////////////////////////////
	// Source Relationships
	//////////////////////////////////////////////////////
	@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@JoinColumn(name="AGENT_ID")
@org.hibernate.annotations.ForeignKey(name="FK_AgentOfScorecardWeeklyResult")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private Agent agent;
public Agent getAgent() {
	return this.agent;
}

public void setAgent(Agent value) {
	this.agent = value;
}@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@JoinColumn(name="SCORECARD_ID")
@org.hibernate.annotations.ForeignKey(name="FK_ScorecardOfScorecardWeeklyResult")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private Scorecard scorecard;
public Scorecard getScorecard() {
	return this.scorecard;
}

public void setScorecard(Scorecard value) {
	this.scorecard = value;
}@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@JoinColumn(name="AGENT_SCORECARD_ID")
@org.hibernate.annotations.ForeignKey(name="FK_AgentScorecardOfScorecardWeeklyResult")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private AgentScorecard agentScorecard;
public AgentScorecard getAgentScorecard() {
	return this.agentScorecard;
}

public void setAgentScorecard(AgentScorecard value) {
	this.agentScorecard = value;
}@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@JoinColumn(name="GOAL_ID")
@org.hibernate.annotations.ForeignKey(name="FK_GoalOfScorecardWeeklyResult")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private Goal goal;
public Goal getGoal() {
	return this.goal;
}

public void setGoal(Goal value) {
	this.goal = value;
}@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@JoinColumn(name="SCORECARD_MEASURE_ID")
@org.hibernate.annotations.ForeignKey(name="FK_ScorecardMeasureOfScorecardWeeklyResult")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private ScorecardMeasure scorecardMeasure;
public ScorecardMeasure getScorecardMeasure() {
	return this.scorecardMeasure;
}

public void setScorecardMeasure(ScorecardMeasure value) {
	this.scorecardMeasure = value;
}@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@JoinColumn(name="SCORECARD_MONTHLY_RESULT_ID")
@org.hibernate.annotations.ForeignKey(name="FK_ScorecardMonthlyResultOfScorecardWeeklyResult")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private ScorecardMonthlyResult scorecardMonthlyResult;
public ScorecardMonthlyResult getScorecardMonthlyResult() {
	return this.scorecardMonthlyResult;
}

public void setScorecardMonthlyResult(ScorecardMonthlyResult value) {
	this.scorecardMonthlyResult = value;
}@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@JoinColumn(name="PREV_SCARD_WEEKLY_RESULT_ID")
@org.hibernate.annotations.ForeignKey(name="FK_PreviousScorecardWeeklyResultOfNextScorecardWeeklyResult")
@OneToOne(fetch=FetchType.LAZY, optional=false)
private ScorecardWeeklyResult previousScorecardWeeklyResult;
public ScorecardWeeklyResult getPreviousScorecardWeeklyResult() {
	return this.previousScorecardWeeklyResult;
}

public void setPreviousScorecardWeeklyResult(ScorecardWeeklyResult value) 
{
	this.previousScorecardWeeklyResult = value;
}

	
	//////////////////////////////////////////////////////
	// JSON
	//////////////////////////////////////////////////////
	@Override
	public String retrieveJson(ObjectMapper objectMapper) {
		String objectJson = super.retrieveJson(objectMapper);

		// Properties		
		//Retrieve value of the Is Coachable property
		objectJson += ",\"isCoachable\":";
		if (getIsCoachable() == null)
			objectJson += "null";
		else {
			objectJson += getIsCoachable();
		}
		//Retrieve value of the Start Date property
		objectJson += ",\"startDate\":";
		if (getStartDate() == null)
			objectJson += "null";
		else {
			objectJson += getStartDate().getTime();
		}
		//Retrieve value of the Duration To property
		objectJson += ",\"durationTo\":";
		
		if (getDurationTo() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getDurationTo());
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
		//Retrieve value of the Goal Type property
		objectJson += ",\"goalType\":";
		
		if (getGoalType() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getGoalType());
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
		//Retrieve value of the Excluded property
		objectJson += ",\"excluded\":";
		
		if (getExcluded() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getExcluded());
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
		//Retrieve value of the Points Possible property
		objectJson += ",\"pointsPossible\":";
		if (getPointsPossible() == null)
			objectJson += "null";
		else {
			objectJson += getPointsPossible();
		}
		//Retrieve value of the Result property
		objectJson += ",\"result\":";
		if (getResult() == null)
			objectJson += "null";
		else {
			objectJson += getResult();
		}
		//Retrieve value of the Is Required property
		objectJson += ",\"isRequired\":";
		if (getIsRequired() == null)
			objectJson += "null";
		else {
			objectJson += getIsRequired();
		}
		//Retrieve value of the Percentage Attainment property
		objectJson += ",\"percentageAttainment\":";
		if (getPercentageAttainment() == null)
			objectJson += "null";
		else {
			objectJson += getPercentageAttainment();
		}
		//Retrieve value of the Duration From property
		objectJson += ",\"durationFrom\":";
		
		if (getDurationFrom() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getDurationFrom());
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
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getUpdatedOn());
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
		//Retrieve value of the Rollup Type property
		objectJson += ",\"rollupType\":";
		
		if (getRollupType() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getRollupType());
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
		//Retrieve value of the End Date property
		objectJson += ",\"endDate\":";
		if (getEndDate() == null)
			objectJson += "null";
		else {
			objectJson += getEndDate().getTime();
		}
		//Retrieve value of the Week Date property
		objectJson += ",\"weekDate\":";
		if (getWeekDate() == null)
			objectJson += "null";
		else {
			objectJson += getWeekDate().getTime();
		}
		//Retrieve value of the Points Received property
		objectJson += ",\"pointsReceived\":";
		if (getPointsReceived() == null)
			objectJson += "null";
		else {
			objectJson += getPointsReceived();
		}
		//Retrieve value of the Created On property
		objectJson += ",\"createdOn\":";
		if (getCreatedOn() == null)
			objectJson += "null";
		else {
			objectJson += getCreatedOn().getTime();
		}

				
		// Source Relationships
//Retrieve value of the Agent of Scorecard Weekly Result relationship
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
//Retrieve value of the Scorecard of Scorecard Weekly Result relationship
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
//Retrieve value of the Agent Scorecard of Scorecard Weekly Result relationship
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
//Retrieve value of the Goal of Scorecard Weekly Result relationship
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
//Retrieve value of the Scorecard Measure of Scorecard Weekly Result relationship
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
//Retrieve value of the Scorecard Monthly Result of Scorecard Weekly Result relationship
objectJson += ",\"scorecardMonthlyResult\":";
		if (getScorecardMonthlyResult() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getScorecardMonthlyResult()).toEmbeddedJson();
			} catch(Exception e) {
				objectJson += "null";
			}
		}
		objectJson += "";
//Retrieve value of the Previous Scorecard Weekly Result of Next Scorecard Weekly Result relationship
objectJson += ",\"previousScorecardWeeklyResult\":";
		if (getPreviousScorecardWeeklyResult() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getPreviousScorecardWeeklyResult()).toEmbeddedJson();
			} catch(Exception e) {
				objectJson += "null";
			}
		}
		objectJson += "";

		
		// Target Relationships
//Retrieve value of the Scorecard Weekly Result of Behavior Response relationship
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
//Retrieve value of the Scorecard Weekly Result of Weekly Development Activity relationship
objectJson += ",\"weeklyDevelopmentActivities\":[";
		
		if (getWeeklyDevelopmentActivities() != null) {
			int weeklyDevelopmentActivitiesCounter = 0;
			for(WeeklyDevelopmentActivity nextWeeklyDevelopmentActivities : getWeeklyDevelopmentActivities()) {
				if (weeklyDevelopmentActivitiesCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextWeeklyDevelopmentActivities).toEmbeddedJson();
					weeklyDevelopmentActivitiesCounter++;
				} catch(Exception e) {
					// Do nothing.
				}
			}
		}
		objectJson += "]";
//Retrieve value of the Scorecard Weekly Result of Weekly Development Plan relationship
objectJson += ",\"weeklyDevelopmentPlans\":[";
		
		if (getWeeklyDevelopmentPlans() != null) {
			int weeklyDevelopmentPlansCounter = 0;
			for(WeeklyDevelopmentPlan nextWeeklyDevelopmentPlans : getWeeklyDevelopmentPlans()) {
				if (weeklyDevelopmentPlansCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextWeeklyDevelopmentPlans).toEmbeddedJson();
					weeklyDevelopmentPlansCounter++;
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
		//From value of the Is Coachable property
		setIsCoachable(JsonUtils.getJsonBoolean(jsonObject, "isCoachable"));
		//From value of the Start Date property
		setStartDate(JsonUtils.getJsonDate(jsonObject, "startDate"));
		//From value of the Duration To property
		setDurationTo(JsonUtils.getJsonInteger(jsonObject, "durationTo"));
		//From value of the Goal Type property
		setGoalType(JsonUtils.getJsonInteger(jsonObject, "goalType"));
		//From value of the Excluded property
		setExcluded(JsonUtils.getJsonInteger(jsonObject, "excluded"));
		//From value of the Points Possible property
		setPointsPossible(JsonUtils.getJsonDouble(jsonObject, "pointsPossible"));
		//From value of the Result property
		setResult(JsonUtils.getJsonDouble(jsonObject, "result"));
		//From value of the Is Required property
		setIsRequired(JsonUtils.getJsonBoolean(jsonObject, "isRequired"));
		//From value of the Percentage Attainment property
		setPercentageAttainment(JsonUtils.getJsonDouble(jsonObject, "percentageAttainment"));
		//From value of the Duration From property
		setDurationFrom(JsonUtils.getJsonInteger(jsonObject, "durationFrom"));
		//From value of the Updated On property
		setUpdatedOn(JsonUtils.getJsonString(jsonObject, "updatedOn"));
		//From value of the Rollup Type property
		setRollupType(JsonUtils.getJsonInteger(jsonObject, "rollupType"));
		//From value of the Employee Id property
		setEmployeeId(JsonUtils.getJsonString(jsonObject, "employeeId"));
		//From value of the Grade property
		setGrade(JsonUtils.getJsonInteger(jsonObject, "grade"));
		//From value of the Tenure property
		setTenure(JsonUtils.getJsonInteger(jsonObject, "tenure"));
		//From value of the End Date property
		setEndDate(JsonUtils.getJsonDate(jsonObject, "endDate"));
		//From value of the Week Date property
		setWeekDate(JsonUtils.getJsonDate(jsonObject, "weekDate"));
		//From value of the Points Received property
		setPointsReceived(JsonUtils.getJsonDouble(jsonObject, "pointsReceived"));
		//From value of the Created On property
		setCreatedOn(JsonUtils.getJsonDate(jsonObject, "createdOn"));

		
		// Source Relationships
		this.agent = (Agent) JsonUtils.getJsonPerceroObject(jsonObject, "agent");
		this.scorecard = (Scorecard) JsonUtils.getJsonPerceroObject(jsonObject, "scorecard");
		this.agentScorecard = (AgentScorecard) JsonUtils.getJsonPerceroObject(jsonObject, "agentScorecard");
		this.goal = (Goal) JsonUtils.getJsonPerceroObject(jsonObject, "goal");
		this.scorecardMeasure = (ScorecardMeasure) JsonUtils.getJsonPerceroObject(jsonObject, "scorecardMeasure");
		this.scorecardMonthlyResult = (ScorecardMonthlyResult) JsonUtils.getJsonPerceroObject(jsonObject, "scorecardMonthlyResult");
		this.previousScorecardWeeklyResult = (ScorecardWeeklyResult) JsonUtils.getJsonPerceroObject(jsonObject, "previousScorecardWeeklyResult");


		// Target Relationships
		this.behaviorResponses = (List<BehaviorResponse>) JsonUtils.getJsonListPerceroObject(jsonObject, "behaviorResponses");
		this.weeklyDevelopmentActivities = (List<WeeklyDevelopmentActivity>) JsonUtils.getJsonListPerceroObject(jsonObject, "weeklyDevelopmentActivities");
		this.weeklyDevelopmentPlans = (List<WeeklyDevelopmentPlan>) JsonUtils.getJsonListPerceroObject(jsonObject, "weeklyDevelopmentPlans");


	}
	
	@Override
	protected List<MappedClassMethodPair> getListSetters() {
		List<MappedClassMethodPair> listSetters = super.getListSetters();

		// Target Relationships
		listSetters.add(MappedClass.getFieldSetters(BehaviorResponse.class, "scorecardweeklyresult"));
		listSetters.add(MappedClass.getFieldSetters(WeeklyDevelopmentActivity.class, "scorecardweeklyresult"));
		listSetters.add(MappedClass.getFieldSetters(WeeklyDevelopmentPlan.class, "scorecardweeklyresult"));

		
		return listSetters;
	}
}
