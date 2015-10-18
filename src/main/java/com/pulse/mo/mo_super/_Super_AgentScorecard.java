
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
public class _Super_AgentScorecard extends BaseDataObject implements Serializable
{
	//////////////////////////////////////////////////////
	// VERSION
	//////////////////////////////////////////////////////
	@Override
	public String classVersion() {
		return "1.0.0";
	}

	
	/*
	Keys of AgentScorecard
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
}

	//////////////////////////////////////////////////////
	// Target Relationships
	//////////////////////////////////////////////////////
	@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@OneToMany(fetch=FetchType.LAZY, targetEntity=AdhocCoachingSession.class, mappedBy="agentScorecard", cascade=javax.persistence.CascadeType.REMOVE)
private List<AdhocCoachingSession> adhocCoachingSessions;
public List<AdhocCoachingSession> getAdhocCoachingSessions() {
	return this.adhocCoachingSessions;
}

public void setAdhocCoachingSessions(List<AdhocCoachingSession> value) {
	this.adhocCoachingSessions = value;
}

@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@OneToMany(fetch=FetchType.LAZY, targetEntity=ScorecardMeasureWeeklyResult.class, mappedBy="agentScorecard", cascade=javax.persistence.CascadeType.REMOVE)
private List<ScorecardMeasureWeeklyResult> scorecardMeasureWeeklyResults;
public List<ScorecardMeasureWeeklyResult> getScorecardMeasureWeeklyResults() {
	return this.scorecardMeasureWeeklyResults;
}

public void setScorecardMeasureWeeklyResults(List<ScorecardMeasureWeeklyResult> value) {
	this.scorecardMeasureWeeklyResults = value;
}

@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@OneToMany(fetch=FetchType.LAZY, targetEntity=QualityEvaluation.class, mappedBy="agentScorecard", cascade=javax.persistence.CascadeType.REMOVE)
private List<QualityEvaluation> qualityEvaluations;
public List<QualityEvaluation> getQualityEvaluations() {
	return this.qualityEvaluations;
}

public void setQualityEvaluations(List<QualityEvaluation> value) {
	this.qualityEvaluations = value;
}

@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@OneToMany(fetch=FetchType.LAZY, targetEntity=CoachingSession.class, mappedBy="agentScorecard", cascade=javax.persistence.CascadeType.REMOVE)
private List<CoachingSession> coachingSessions;
public List<CoachingSession> getCoachingSessions() {
	return this.coachingSessions;
}

public void setCoachingSessions(List<CoachingSession> value) {
	this.coachingSessions = value;
}

@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@OneToMany(fetch=FetchType.LAZY, targetEntity=ScorecardMeasureMonthlyResult.class, mappedBy="agentScorecard", cascade=javax.persistence.CascadeType.REMOVE)
private List<ScorecardMeasureMonthlyResult> scorecardMeasureMonthlyResults;
public List<ScorecardMeasureMonthlyResult> getScorecardMeasureMonthlyResults() {
	return this.scorecardMeasureMonthlyResults;
}

public void setScorecardMeasureMonthlyResults(List<ScorecardMeasureMonthlyResult> value) {
	this.scorecardMeasureMonthlyResults = value;
}



	//////////////////////////////////////////////////////
	// Source Relationships
	//////////////////////////////////////////////////////
	@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@JoinColumn(name="AGENT_ID")
@org.hibernate.annotations.ForeignKey(name="FK_AgentOfAgentScorecard")
@ManyToOne(fetch=FetchType.LAZY, optional=true)
private Agent agent;
public Agent getAgent() {
	return this.agent;
}

public void setAgent(Agent value) {
	this.agent = value;
}@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@JoinColumn(name="SCORECARD_ID")
@org.hibernate.annotations.ForeignKey(name="FK_ScorecardOfAgentScorecard")
@ManyToOne(fetch=FetchType.LAZY, optional=true)
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
		//Retrieve value of the Points Received property
		objectJson += ",\"pointsReceived\":";
		if (getPointsReceived() == null)
			objectJson += "null";
		else {
			objectJson += getPointsReceived();
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
		//Retrieve value of the Score property
		objectJson += ",\"score\":";
		if (getScore() == null)
			objectJson += "null";
		else {
			objectJson += getScore();
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
		//Retrieve value of the Points Possible property
		objectJson += ",\"pointsPossible\":";
		if (getPointsPossible() == null)
			objectJson += "null";
		else {
			objectJson += getPointsPossible();
		}
		//Retrieve value of the Week Date property
		objectJson += ",\"weekDate\":";
		if (getWeekDate() == null)
			objectJson += "null";
		else {
			objectJson += getWeekDate().getTime();
		}

				
		// Source Relationships
//Retrieve value of the Agent of Agent Scorecard relationship
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
//Retrieve value of the Scorecard of Agent Scorecard relationship
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
//Retrieve value of the Agent Scorecard of Adhoc Coaching Session relationship
objectJson += ",\"adhocCoachingSessions\":[";
		
		if (getAdhocCoachingSessions() != null) {
			int adhocCoachingSessionsCounter = 0;
			for(AdhocCoachingSession nextAdhocCoachingSessions : getAdhocCoachingSessions()) {
				if (adhocCoachingSessionsCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextAdhocCoachingSessions).toEmbeddedJson();
					adhocCoachingSessionsCounter++;
				} catch(Exception e) {
					// Do nothing.
				}
			}
		}
		objectJson += "]";
//Retrieve value of the Agent Scorecard of Scorecard Measure Weekly Result relationship
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
//Retrieve value of the Agent Scorecard of Quality Evaluation relationship
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
//Retrieve value of the Agent Scorecard of Coaching Session relationship
objectJson += ",\"coachingSessions\":[";
		
		if (getCoachingSessions() != null) {
			int coachingSessionsCounter = 0;
			for(CoachingSession nextCoachingSessions : getCoachingSessions()) {
				if (coachingSessionsCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextCoachingSessions).toEmbeddedJson();
					coachingSessionsCounter++;
				} catch(Exception e) {
					// Do nothing.
				}
			}
		}
		objectJson += "]";
//Retrieve value of the Agent Scorecard of Scorecard Measure Monthly Result relationship
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

		
		return objectJson;
	}


	@Override
	protected void fromJson(JsonObject jsonObject) {
	    super.fromJson(jsonObject);

		// Properties
		//From value of the Points Received property
		setPointsReceived(JsonUtils.getJsonDouble(jsonObject, "pointsReceived"));
		//From value of the Quartile property
		setQuartile(JsonUtils.getJsonInteger(jsonObject, "quartile"));
		//From value of the Score property
		setScore(JsonUtils.getJsonDouble(jsonObject, "score"));
		//From value of the Grade property
		setGrade(JsonUtils.getJsonInteger(jsonObject, "grade"));
		//From value of the Points Possible property
		setPointsPossible(JsonUtils.getJsonDouble(jsonObject, "pointsPossible"));
		//From value of the Week Date property
		setWeekDate(JsonUtils.getJsonDate(jsonObject, "weekDate"));

		
		// Source Relationships
		this.agent = (Agent) JsonUtils.getJsonPerceroObject(jsonObject, "agent");
		this.scorecard = (Scorecard) JsonUtils.getJsonPerceroObject(jsonObject, "scorecard");


		// Target Relationships
		this.adhocCoachingSessions = (List<AdhocCoachingSession>) JsonUtils.getJsonListPerceroObject(jsonObject, "adhocCoachingSessions");
		this.scorecardMeasureWeeklyResults = (List<ScorecardMeasureWeeklyResult>) JsonUtils.getJsonListPerceroObject(jsonObject, "scorecardMeasureWeeklyResults");
		this.qualityEvaluations = (List<QualityEvaluation>) JsonUtils.getJsonListPerceroObject(jsonObject, "qualityEvaluations");
		this.coachingSessions = (List<CoachingSession>) JsonUtils.getJsonListPerceroObject(jsonObject, "coachingSessions");
		this.scorecardMeasureMonthlyResults = (List<ScorecardMeasureMonthlyResult>) JsonUtils.getJsonListPerceroObject(jsonObject, "scorecardMeasureMonthlyResults");


	}
	
	@Override
	protected List<MappedClassMethodPair> getListSetters() {
		List<MappedClassMethodPair> listSetters = super.getListSetters();

		// Target Relationships
		listSetters.add(MappedClass.getFieldSetters(AdhocCoachingSession.class, "agentscorecard"));
		listSetters.add(MappedClass.getFieldSetters(ScorecardMeasureWeeklyResult.class, "agentscorecard"));
		listSetters.add(MappedClass.getFieldSetters(QualityEvaluation.class, "agentscorecard"));
		listSetters.add(MappedClass.getFieldSetters(CoachingSession.class, "agentscorecard"));
		listSetters.add(MappedClass.getFieldSetters(ScorecardMeasureMonthlyResult.class, "agentscorecard"));

		
		return listSetters;
	}
}
