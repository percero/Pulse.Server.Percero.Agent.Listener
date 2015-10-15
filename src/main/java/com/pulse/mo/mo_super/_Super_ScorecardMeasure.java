
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
public class _Super_ScorecardMeasure extends BaseDataObject implements Serializable
{
	//////////////////////////////////////////////////////
	// VERSION
	//////////////////////////////////////////////////////
	@Override
	public String classVersion() {
		return "1.0.0";
	}

	
	/*
	Keys of ScorecardMeasure
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
}

	//////////////////////////////////////////////////////
	// Target Relationships
	//////////////////////////////////////////////////////
	@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@OneToMany(fetch=FetchType.LAZY, targetEntity=ScorecardMeasureMonthlyResult.class, mappedBy="scorecardMeasure", cascade=javax.persistence.CascadeType.REMOVE)
private List<ScorecardMeasureMonthlyResult> scorecardMeasureMonthlyResults;
public List<ScorecardMeasureMonthlyResult> getScorecardMeasureMonthlyResults() {
	return this.scorecardMeasureMonthlyResults;
}

public void setScorecardMeasureMonthlyResults(List<ScorecardMeasureMonthlyResult> value) {
	this.scorecardMeasureMonthlyResults = value;
}

@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@OneToMany(fetch=FetchType.LAZY, targetEntity=ScorecardMeasureWeeklyResult.class, mappedBy="scorecardMeasure", cascade=javax.persistence.CascadeType.REMOVE)
private List<ScorecardMeasureWeeklyResult> scorecardMeasureWeeklyResults;
public List<ScorecardMeasureWeeklyResult> getScorecardMeasureWeeklyResults() {
	return this.scorecardMeasureWeeklyResults;
}

public void setScorecardMeasureWeeklyResults(List<ScorecardMeasureWeeklyResult> value) {
	this.scorecardMeasureWeeklyResults = value;
}



	//////////////////////////////////////////////////////
	// Source Relationships
	//////////////////////////////////////////////////////
	@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@JoinColumn(name="MEASURE_ID")
@org.hibernate.annotations.ForeignKey(name="FK_MeasureOfScorecardMeasure")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private Measure measure;
public Measure getMeasure() {
	return this.measure;
}

public void setMeasure(Measure value) {
	this.measure = value;
}

	
	//////////////////////////////////////////////////////
	// JSON
	//////////////////////////////////////////////////////
	@Override
	public String retrieveJson(ObjectMapper objectMapper) {
		String objectJson = super.retrieveJson(objectMapper);

		// Properties		
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
		//Retrieve value of the Coachable property
		objectJson += ",\"coachable\":";
		if (getCoachable() == null)
			objectJson += "null";
		else {
			objectJson += getCoachable();
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

				
		// Source Relationships
//Retrieve value of the Measure of Scorecard Measure relationship
objectJson += ",\"measure\":";
		if (getMeasure() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getMeasure()).toEmbeddedJson();
			} catch(Exception e) {
				objectJson += "null";
			}
		}
		objectJson += "";

		
		// Target Relationships
//Retrieve value of the Scorecard Measure of Scorecard Measure Monthly Result relationship
objectJson += ",\"scorecardMeasureMonthlyResults\":[";
		
		if (getScorecardMeasureMonthlyResults() != null) {
			int scorecardMeasureMonthlyResultsCounter = 0;
			for(ScorecardMeasureMonthlyResult nextScorecardMeasureMonthlyResults : getScorecardMeasureMonthlyResults()) {
				if (scorecardMeasureMonthlyResultsCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextScorecardMeasureMonthlyResults).toEmbeddedJson();
					scorecardMeasureMonthlyResultsCounter++;
				} catch(Exception e) {
					// Do nothing.
				}
			}
		}
		objectJson += "]";
//Retrieve value of the Scorecard Measure of Scorecard Measure Weekly Result relationship
objectJson += ",\"scorecardMeasureWeeklyResults\":[";
		
		if (getScorecardMeasureWeeklyResults() != null) {
			int scorecardMeasureWeeklyResultsCounter = 0;
			for(ScorecardMeasureWeeklyResult nextScorecardMeasureWeeklyResults : getScorecardMeasureWeeklyResults()) {
				if (scorecardMeasureWeeklyResultsCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextScorecardMeasureWeeklyResults).toEmbeddedJson();
					scorecardMeasureWeeklyResultsCounter++;
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
		//From value of the Weekly Trend property
		setWeeklyTrend(JsonUtils.getJsonString(jsonObject, "weeklyTrend"));
		//From value of the Name property
		setName(JsonUtils.getJsonString(jsonObject, "name"));
		//From value of the Coachable property
		setCoachable(JsonUtils.getJsonBoolean(jsonObject, "coachable"));
		//From value of the Weight property
		setWeight(JsonUtils.getJsonString(jsonObject, "weight"));

		
		// Source Relationships
		this.measure = (Measure) JsonUtils.getJsonPerceroObject(jsonObject, "measure");


		// Target Relationships
		this.scorecardMeasureMonthlyResults = (List<ScorecardMeasureMonthlyResult>) JsonUtils.getJsonListPerceroObject(jsonObject, "scorecardMeasureMonthlyResults");
		this.scorecardMeasureWeeklyResults = (List<ScorecardMeasureWeeklyResult>) JsonUtils.getJsonListPerceroObject(jsonObject, "scorecardMeasureWeeklyResults");


	}
	
	@Override
	protected List<MappedClassMethodPair> getListSetters() {
		List<MappedClassMethodPair> listSetters = super.getListSetters();

		// Target Relationships
		listSetters.add(MappedClass.getFieldSetters(ScorecardMeasureMonthlyResult.class, "scorecardmeasure"));
		listSetters.add(MappedClass.getFieldSetters(ScorecardMeasureWeeklyResult.class, "scorecardmeasure"));

		
		return listSetters;
	}
}
