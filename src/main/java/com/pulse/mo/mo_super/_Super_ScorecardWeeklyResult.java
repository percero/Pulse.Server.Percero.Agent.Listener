


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
Quartile
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Integer quartile;

public Integer getQuartile() 
{
	return this.quartile;
}

public void setQuartile(Integer quartile)
{
	this.quartile = quartile;
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
}

	//////////////////////////////////////////////////////
	// Target Relationships
	//////////////////////////////////////////////////////
	

	//////////////////////////////////////////////////////
	// Source Relationships
	//////////////////////////////////////////////////////
	
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
}
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
}
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
}
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@JoinColumn(name="PREVIOUS3_SCORECARD_MONTHLY_RESULT_ID")
@org.hibernate.annotations.ForeignKey(name="FK_Previous3ScorecardMonthlyResultOfNext3ScorecardWeeklyResult")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private ScorecardMonthlyResult previous3ScorecardMonthlyResult;
public ScorecardMonthlyResult getPrevious3ScorecardMonthlyResult() {
	return this.previous3ScorecardMonthlyResult;
}

public void setPrevious3ScorecardMonthlyResult(ScorecardMonthlyResult value) {
	this.previous3ScorecardMonthlyResult = value;
}
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@JoinColumn(name="CURRENT_SCORECARD_MONTHLY_RESULT_ID")
@org.hibernate.annotations.ForeignKey(name="FK_CurrentScorecardMonthlyResultOfCurrentMonthScorecardWeeklyResult")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private ScorecardMonthlyResult currentScorecardMonthlyResult;
public ScorecardMonthlyResult getCurrentScorecardMonthlyResult() {
	return this.currentScorecardMonthlyResult;
}

public void setCurrentScorecardMonthlyResult(ScorecardMonthlyResult value) {
	this.currentScorecardMonthlyResult = value;
}
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@JoinColumn(name="PREVIOUS2_SCORECARD_MONTHLY_RESULT_ID")
@org.hibernate.annotations.ForeignKey(name="FK_Previous2ScorecardMonthlyResultOfNext2ScorecardWeeklyResult")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private ScorecardMonthlyResult previous2ScorecardMonthlyResult;
public ScorecardMonthlyResult getPrevious2ScorecardMonthlyResult() {
	return this.previous2ScorecardMonthlyResult;
}

public void setPrevious2ScorecardMonthlyResult(ScorecardMonthlyResult value) {
	this.previous2ScorecardMonthlyResult = value;
}
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@JoinColumn(name="PREVIOUS1_SCORECARD_MONTHLY_RESULT_ID")
@org.hibernate.annotations.ForeignKey(name="FK_Previous1ScorecardMonthlyResultOfNext1ScorecardWeeklyResult")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private ScorecardMonthlyResult previous1ScorecardMonthlyResult;
public ScorecardMonthlyResult getPrevious1ScorecardMonthlyResult() {
	return this.previous1ScorecardMonthlyResult;
}

public void setPrevious1ScorecardMonthlyResult(ScorecardMonthlyResult value) {
	this.previous1ScorecardMonthlyResult = value;
}

	
	//////////////////////////////////////////////////////
	// JSON
	//////////////////////////////////////////////////////
	@Override
	public String retrieveJson(ObjectMapper objectMapper) {
		String objectJson = super.retrieveJson(objectMapper);

		// Properties		
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
		//Retrieve value of the Updated On property
		objectJson += ",\"updatedOn\":";
		if (getUpdatedOn() == null)
			objectJson += "null";
		else {
			objectJson += getUpdatedOn().getTime();
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
		//Retrieve value of the Quartile property
		objectJson += ",\"quartile\":";
		
		if (getQuartile() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getQuartile());
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
		//Retrieve value of the Week Date property
		objectJson += ",\"weekDate\":";
		if (getWeekDate() == null)
			objectJson += "null";
		else {
			objectJson += getWeekDate().getTime();
		}
		//Retrieve value of the Points Possible property
		objectJson += ",\"pointsPossible\":";
		if (getPointsPossible() == null)
			objectJson += "null";
		else {
			objectJson += getPointsPossible();
		}
		//Retrieve value of the Points Received property
		objectJson += ",\"pointsReceived\":";
		if (getPointsReceived() == null)
			objectJson += "null";
		else {
			objectJson += getPointsReceived();
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
		//Retrieve value of the Percentage Attainment property
		objectJson += ",\"percentageAttainment\":";
		if (getPercentageAttainment() == null)
			objectJson += "null";
		else {
			objectJson += getPercentageAttainment();
		}
		//Retrieve value of the Result property
		objectJson += ",\"result\":";
		if (getResult() == null)
			objectJson += "null";
		else {
			objectJson += getResult();
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
		//Retrieve value of the Created On property
		objectJson += ",\"createdOn\":";
		if (getCreatedOn() == null)
			objectJson += "null";
		else {
			objectJson += getCreatedOn().getTime();
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

				
		// Source Relationships
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
//Retrieve value of the Previous 3 Scorecard Monthly Result of Next 3 Scorecard Weekly Result relationship
objectJson += ",\"previous3ScorecardMonthlyResult\":";
		if (getPrevious3ScorecardMonthlyResult() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getPrevious3ScorecardMonthlyResult()).toEmbeddedJson();
			} catch(Exception e) {
				objectJson += "null";
			}
		}
		objectJson += "";
//Retrieve value of the Current Scorecard Monthly Result of Current Month Scorecard Weekly Result relationship
objectJson += ",\"currentScorecardMonthlyResult\":";
		if (getCurrentScorecardMonthlyResult() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getCurrentScorecardMonthlyResult()).toEmbeddedJson();
			} catch(Exception e) {
				objectJson += "null";
			}
		}
		objectJson += "";
//Retrieve value of the Previous 2 Scorecard Monthly Result of Next 2 Scorecard Weekly Result relationship
objectJson += ",\"previous2ScorecardMonthlyResult\":";
		if (getPrevious2ScorecardMonthlyResult() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getPrevious2ScorecardMonthlyResult()).toEmbeddedJson();
			} catch(Exception e) {
				objectJson += "null";
			}
		}
		objectJson += "";
//Retrieve value of the Previous 1 Scorecard Monthly Result of Next 1 Scorecard Weekly Result relationship
objectJson += ",\"previous1ScorecardMonthlyResult\":";
		if (getPrevious1ScorecardMonthlyResult() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getPrevious1ScorecardMonthlyResult()).toEmbeddedJson();
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
		//From value of the Duration From property
		setDurationFrom(JsonUtils.getJsonInteger(jsonObject, "durationFrom"));
		//From value of the Created By property
		setCreatedBy(JsonUtils.getJsonString(jsonObject, "createdBy"));
		//From value of the Updated On property
		setUpdatedOn(JsonUtils.getJsonDate(jsonObject, "updatedOn"));
		//From value of the Excluded property
		setExcluded(JsonUtils.getJsonInteger(jsonObject, "excluded"));
		//From value of the Quartile property
		setQuartile(JsonUtils.getJsonInteger(jsonObject, "quartile"));
		//From value of the Grade property
		setGrade(JsonUtils.getJsonInteger(jsonObject, "grade"));
		//From value of the Week Date property
		setWeekDate(JsonUtils.getJsonDate(jsonObject, "weekDate"));
		//From value of the Points Possible property
		setPointsPossible(JsonUtils.getJsonDouble(jsonObject, "pointsPossible"));
		//From value of the Points Received property
		setPointsReceived(JsonUtils.getJsonDouble(jsonObject, "pointsReceived"));
		//From value of the Goal Type property
		setGoalType(JsonUtils.getJsonInteger(jsonObject, "goalType"));
		//From value of the Rollup Type property
		setRollupType(JsonUtils.getJsonInteger(jsonObject, "rollupType"));
		//From value of the Percentage Attainment property
		setPercentageAttainment(JsonUtils.getJsonDouble(jsonObject, "percentageAttainment"));
		//From value of the Result property
		setResult(JsonUtils.getJsonDouble(jsonObject, "result"));
		//From value of the Employee Id property
		setEmployeeId(JsonUtils.getJsonString(jsonObject, "employeeId"));
		//From value of the Created On property
		setCreatedOn(JsonUtils.getJsonDate(jsonObject, "createdOn"));
		//From value of the Updated By property
		setUpdatedBy(JsonUtils.getJsonString(jsonObject, "updatedBy"));
		//From value of the Duration To property
		setDurationTo(JsonUtils.getJsonInteger(jsonObject, "durationTo"));

		
		// Source Relationships
		this.agentScorecard = (AgentScorecard) JsonUtils.getJsonPerceroObject(jsonObject, "agentScorecard");
		this.goal = (Goal) JsonUtils.getJsonPerceroObject(jsonObject, "goal");
		this.scorecardMeasure = (ScorecardMeasure) JsonUtils.getJsonPerceroObject(jsonObject, "scorecardMeasure");
		this.previous3ScorecardMonthlyResult = (ScorecardMonthlyResult) JsonUtils.getJsonPerceroObject(jsonObject, "previous3ScorecardMonthlyResult");
		this.currentScorecardMonthlyResult = (ScorecardMonthlyResult) JsonUtils.getJsonPerceroObject(jsonObject, "currentScorecardMonthlyResult");
		this.previous2ScorecardMonthlyResult = (ScorecardMonthlyResult) JsonUtils.getJsonPerceroObject(jsonObject, "previous2ScorecardMonthlyResult");
		this.previous1ScorecardMonthlyResult = (ScorecardMonthlyResult) JsonUtils.getJsonPerceroObject(jsonObject, "previous1ScorecardMonthlyResult");


		// Target Relationships


	}
	
	@Override
	protected List<MappedClassMethodPair> getListSetters() {
		List<MappedClassMethodPair> listSetters = super.getListSetters();

		// Target Relationships

		
		return listSetters;
	}
}
