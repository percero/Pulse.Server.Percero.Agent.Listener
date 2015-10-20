


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
public class _Super_ScorecardMonthlyResult extends BaseDataObject implements Serializable
{
	//////////////////////////////////////////////////////
	// VERSION
	//////////////////////////////////////////////////////
	@Override
	public String classVersion() {
		return "1.0.0";
	}

	
	/*
	Keys of ScorecardMonthlyResult
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
MetricType
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String metricType;

public String getMetricType() 
{
	return this.metricType;
}

public void setMetricType(String metricType)
{
	this.metricType = metricType;
}/*
MetricResult
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Double metricResult;

public Double getMetricResult() 
{
	return this.metricResult;
}

public void setMetricResult(Double metricResult)
{
	this.metricResult = metricResult;
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
ScorecardId
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String scorecardId;

public String getScorecardId() 
{
	return this.scorecardId;
}

public void setScorecardId(String scorecardId)
{
	this.scorecardId = scorecardId;
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
MetricUnit
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String metricUnit;

public String getMetricUnit() 
{
	return this.metricUnit;
}

public void setMetricUnit(String metricUnit)
{
	this.metricUnit = metricUnit;
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
	@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@OneToMany(fetch=FetchType.LAZY, targetEntity=ScorecardWeeklyResult.class, mappedBy="previous3ScorecardMonthlyResult", cascade=javax.persistence.CascadeType.REMOVE)
private List<ScorecardWeeklyResult> next3ScorecardWeeklyResults;
public List<ScorecardWeeklyResult> getNext3ScorecardWeeklyResults() {
	return this.next3ScorecardWeeklyResults;
}

public void setNext3ScorecardWeeklyResults(List<ScorecardWeeklyResult> value) {
	this.next3ScorecardWeeklyResults = value;
}

@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@OneToMany(fetch=FetchType.LAZY, targetEntity=ScorecardWeeklyResult.class, mappedBy="currentScorecardMonthlyResult", cascade=javax.persistence.CascadeType.REMOVE)
private List<ScorecardWeeklyResult> currentMonthScorecardWeeklyResults;
public List<ScorecardWeeklyResult> getCurrentMonthScorecardWeeklyResults() {
	return this.currentMonthScorecardWeeklyResults;
}

public void setCurrentMonthScorecardWeeklyResults(List<ScorecardWeeklyResult> value) {
	this.currentMonthScorecardWeeklyResults = value;
}

@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@OneToMany(fetch=FetchType.LAZY, targetEntity=ScorecardWeeklyResult.class, mappedBy="previous2ScorecardMonthlyResult", cascade=javax.persistence.CascadeType.REMOVE)
private List<ScorecardWeeklyResult> next2ScorecardWeeklyResults;
public List<ScorecardWeeklyResult> getNext2ScorecardWeeklyResults() {
	return this.next2ScorecardWeeklyResults;
}

public void setNext2ScorecardWeeklyResults(List<ScorecardWeeklyResult> value) {
	this.next2ScorecardWeeklyResults = value;
}

@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@OneToMany(fetch=FetchType.LAZY, targetEntity=ScorecardWeeklyResult.class, mappedBy="previous1ScorecardMonthlyResult", cascade=javax.persistence.CascadeType.REMOVE)
private List<ScorecardWeeklyResult> next1ScorecardWeeklyResults;
public List<ScorecardWeeklyResult> getNext1ScorecardWeeklyResults() {
	return this.next1ScorecardWeeklyResults;
}

public void setNext1ScorecardWeeklyResults(List<ScorecardWeeklyResult> value) {
	this.next1ScorecardWeeklyResults = value;
}



	//////////////////////////////////////////////////////
	// Source Relationships
	//////////////////////////////////////////////////////
	
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@JoinColumn(name="GOAL_ID")
@org.hibernate.annotations.ForeignKey(name="FK_GoalOfScorecardMonthlyResult")
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
@org.hibernate.annotations.ForeignKey(name="FK_ScorecardMeasureOfScorecardMonthlyResult")
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
		//Retrieve value of the Points Possible property
		objectJson += ",\"pointsPossible\":";
		if (getPointsPossible() == null)
			objectJson += "null";
		else {
			objectJson += getPointsPossible();
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
		//Retrieve value of the Metric Type property
		objectJson += ",\"metricType\":";
		
		if (getMetricType() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getMetricType());
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
		//Retrieve value of the Metric Result property
		objectJson += ",\"metricResult\":";
		if (getMetricResult() == null)
			objectJson += "null";
		else {
			objectJson += getMetricResult();
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
		//Retrieve value of the Scorecard Id property
		objectJson += ",\"scorecardId\":";
		
		if (getScorecardId() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getScorecardId());
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
		//Retrieve value of the Metric Unit property
		objectJson += ",\"metricUnit\":";
		
		if (getMetricUnit() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getMetricUnit());
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
		//Retrieve value of the Points Received property
		objectJson += ",\"pointsReceived\":";
		if (getPointsReceived() == null)
			objectJson += "null";
		else {
			objectJson += getPointsReceived();
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
//Retrieve value of the Goal of Scorecard Monthly Result relationship
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
//Retrieve value of the Scorecard Measure of Scorecard Monthly Result relationship
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
//Retrieve value of the Previous 3 Scorecard Monthly Result of Next 3 Scorecard Weekly Result relationship
objectJson += ",\"next3ScorecardWeeklyResults\":[";
		
		if (getNext3ScorecardWeeklyResults() != null) {
			int next3ScorecardWeeklyResultsCounter = 0;
			for(ScorecardWeeklyResult nextNext3ScorecardWeeklyResults : getNext3ScorecardWeeklyResults()) {
				if (next3ScorecardWeeklyResultsCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextNext3ScorecardWeeklyResults).toEmbeddedJson();
					next3ScorecardWeeklyResultsCounter++;
				} catch(Exception e) {
					// Do nothing.
				}
			}
		}
		objectJson += "]";
//Retrieve value of the Current Scorecard Monthly Result of Current Month Scorecard Weekly Result relationship
objectJson += ",\"currentMonthScorecardWeeklyResults\":[";
		
		if (getCurrentMonthScorecardWeeklyResults() != null) {
			int currentMonthScorecardWeeklyResultsCounter = 0;
			for(ScorecardWeeklyResult nextCurrentMonthScorecardWeeklyResults : getCurrentMonthScorecardWeeklyResults()) {
				if (currentMonthScorecardWeeklyResultsCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextCurrentMonthScorecardWeeklyResults).toEmbeddedJson();
					currentMonthScorecardWeeklyResultsCounter++;
				} catch(Exception e) {
					// Do nothing.
				}
			}
		}
		objectJson += "]";
//Retrieve value of the Previous 2 Scorecard Monthly Result of Next 2 Scorecard Weekly Result relationship
objectJson += ",\"next2ScorecardWeeklyResults\":[";
		
		if (getNext2ScorecardWeeklyResults() != null) {
			int next2ScorecardWeeklyResultsCounter = 0;
			for(ScorecardWeeklyResult nextNext2ScorecardWeeklyResults : getNext2ScorecardWeeklyResults()) {
				if (next2ScorecardWeeklyResultsCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextNext2ScorecardWeeklyResults).toEmbeddedJson();
					next2ScorecardWeeklyResultsCounter++;
				} catch(Exception e) {
					// Do nothing.
				}
			}
		}
		objectJson += "]";
//Retrieve value of the Previous 1 Scorecard Monthly Result of Next 1 Scorecard Weekly Result relationship
objectJson += ",\"next1ScorecardWeeklyResults\":[";
		
		if (getNext1ScorecardWeeklyResults() != null) {
			int next1ScorecardWeeklyResultsCounter = 0;
			for(ScorecardWeeklyResult nextNext1ScorecardWeeklyResults : getNext1ScorecardWeeklyResults()) {
				if (next1ScorecardWeeklyResultsCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextNext1ScorecardWeeklyResults).toEmbeddedJson();
					next1ScorecardWeeklyResultsCounter++;
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
		//From value of the Points Possible property
		setPointsPossible(JsonUtils.getJsonDouble(jsonObject, "pointsPossible"));
		//From value of the Interval Type property
		setIntervalType(JsonUtils.getJsonString(jsonObject, "intervalType"));
		//From value of the Metric Type property
		setMetricType(JsonUtils.getJsonString(jsonObject, "metricType"));
		//From value of the Metric Result property
		setMetricResult(JsonUtils.getJsonDouble(jsonObject, "metricResult"));
		//From value of the Rollup Type property
		setRollupType(JsonUtils.getJsonInteger(jsonObject, "rollupType"));
		//From value of the Percentage Attainment property
		setPercentageAttainment(JsonUtils.getJsonDouble(jsonObject, "percentageAttainment"));
		//From value of the Start Date property
		setStartDate(JsonUtils.getJsonDate(jsonObject, "startDate"));
		//From value of the End Date property
		setEndDate(JsonUtils.getJsonDate(jsonObject, "endDate"));
		//From value of the Scorecard Id property
		setScorecardId(JsonUtils.getJsonString(jsonObject, "scorecardId"));
		//From value of the Tenure property
		setTenure(JsonUtils.getJsonInteger(jsonObject, "tenure"));
		//From value of the Metric Unit property
		setMetricUnit(JsonUtils.getJsonString(jsonObject, "metricUnit"));
		//From value of the Employee Id property
		setEmployeeId(JsonUtils.getJsonString(jsonObject, "employeeId"));
		//From value of the Points Received property
		setPointsReceived(JsonUtils.getJsonDouble(jsonObject, "pointsReceived"));
		//From value of the Excluded property
		setExcluded(JsonUtils.getJsonInteger(jsonObject, "excluded"));
		//From value of the Grade property
		setGrade(JsonUtils.getJsonInteger(jsonObject, "grade"));

		
		// Source Relationships
		this.goal = (Goal) JsonUtils.getJsonPerceroObject(jsonObject, "goal");
		this.scorecardMeasure = (ScorecardMeasure) JsonUtils.getJsonPerceroObject(jsonObject, "scorecardMeasure");


		// Target Relationships
		this.next3ScorecardWeeklyResults = (List<ScorecardWeeklyResult>) JsonUtils.getJsonListPerceroObject(jsonObject, "next3ScorecardWeeklyResults");
		this.currentMonthScorecardWeeklyResults = (List<ScorecardWeeklyResult>) JsonUtils.getJsonListPerceroObject(jsonObject, "currentMonthScorecardWeeklyResults");
		this.next2ScorecardWeeklyResults = (List<ScorecardWeeklyResult>) JsonUtils.getJsonListPerceroObject(jsonObject, "next2ScorecardWeeklyResults");
		this.next1ScorecardWeeklyResults = (List<ScorecardWeeklyResult>) JsonUtils.getJsonListPerceroObject(jsonObject, "next1ScorecardWeeklyResults");


	}
	
	@Override
	protected List<MappedClassMethodPair> getListSetters() {
		List<MappedClassMethodPair> listSetters = super.getListSetters();

		// Target Relationships
		listSetters.add(MappedClass.getFieldSetters(ScorecardWeeklyResult.class, "scorecardmonthlyresult"));
		listSetters.add(MappedClass.getFieldSetters(ScorecardWeeklyResult.class, "scorecardmonthlyresult"));
		listSetters.add(MappedClass.getFieldSetters(ScorecardWeeklyResult.class, "scorecardmonthlyresult"));
		listSetters.add(MappedClass.getFieldSetters(ScorecardWeeklyResult.class, "scorecardmonthlyresult"));

		
		return listSetters;
	}
}
