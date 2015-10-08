
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
public class _Super_Scorecard extends BaseDataObject implements Serializable
{
	//////////////////////////////////////////////////////
	// VERSION
	//////////////////////////////////////////////////////
	@Override
	public String classVersion() {
		return "1.0.0";
	}

	
	/*
	Keys of Scorecard
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
SkippedCoachingSessionCount
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Integer skippedCoachingSessionCount;

public Integer getSkippedCoachingSessionCount() 
{
	return this.skippedCoachingSessionCount;
}

public void setSkippedCoachingSessionCount(Integer skippedCoachingSessionCount)
{
	this.skippedCoachingSessionCount = skippedCoachingSessionCount;
}/*
SubmittedCoachingSessionCount
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Integer submittedCoachingSessionCount;

public Integer getSubmittedCoachingSessionCount() 
{
	return this.submittedCoachingSessionCount;
}

public void setSubmittedCoachingSessionCount(Integer submittedCoachingSessionCount)
{
	this.submittedCoachingSessionCount = submittedCoachingSessionCount;
}/*
PendingCoachCoachingSessionCount
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Integer pendingCoachCoachingSessionCount;

public Integer getPendingCoachCoachingSessionCount() 
{
	return this.pendingCoachCoachingSessionCount;
}

public void setPendingCoachCoachingSessionCount(Integer pendingCoachCoachingSessionCount)
{
	this.pendingCoachCoachingSessionCount = pendingCoachCoachingSessionCount;
}/*
TotalCoachingSessionCount
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Integer totalCoachingSessionCount;

public Integer getTotalCoachingSessionCount() 
{
	return this.totalCoachingSessionCount;
}

public void setTotalCoachingSessionCount(Integer totalCoachingSessionCount)
{
	this.totalCoachingSessionCount = totalCoachingSessionCount;
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
AcknowledgedCoachingSessionCount
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Integer acknowledgedCoachingSessionCount;

public Integer getAcknowledgedCoachingSessionCount() 
{
	return this.acknowledgedCoachingSessionCount;
}

public void setAcknowledgedCoachingSessionCount(Integer acknowledgedCoachingSessionCount)
{
	this.acknowledgedCoachingSessionCount = acknowledgedCoachingSessionCount;
}/*
PendingEmployeeCoachingSessionCount
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Integer pendingEmployeeCoachingSessionCount;

public Integer getPendingEmployeeCoachingSessionCount() 
{
	return this.pendingEmployeeCoachingSessionCount;
}

public void setPendingEmployeeCoachingSessionCount(Integer pendingEmployeeCoachingSessionCount)
{
	this.pendingEmployeeCoachingSessionCount = pendingEmployeeCoachingSessionCount;
}/*
PendingCoachingSessionCount
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Integer pendingCoachingSessionCount;

public Integer getPendingCoachingSessionCount() 
{
	return this.pendingCoachingSessionCount;
}

public void setPendingCoachingSessionCount(Integer pendingCoachingSessionCount)
{
	this.pendingCoachingSessionCount = pendingCoachingSessionCount;
}

	//////////////////////////////////////////////////////
	// Target Relationships
	//////////////////////////////////////////////////////
	@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@OneToMany(fetch=FetchType.LAZY, targetEntity=AgentScorecard.class, mappedBy="scorecard", cascade=javax.persistence.CascadeType.REMOVE)
private List<AgentScorecard> agentScorecards;
public List<AgentScorecard> getAgentScorecards() {
	return this.agentScorecards;
}

public void setAgentScorecards(List<AgentScorecard> value) {
	this.agentScorecards = value;
}

@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@com.percero.agents.sync.metadata.annotations.Externalize
@OneToOne(fetch=FetchType.LAZY, mappedBy="scorecard", cascade=javax.persistence.CascadeType.REMOVE)
private CoachingNotification coachingNotification;
public CoachingNotification getCoachingNotification() {
	return this.coachingNotification;
}

public void setCoachingNotification(CoachingNotification value) 
{
	this.coachingNotification = value;
}

@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@OneToMany(fetch=FetchType.LAZY, targetEntity=CoachingSession.class, mappedBy="scorecard", cascade=javax.persistence.CascadeType.REMOVE)
private List<CoachingSession> coachingSessions;
public List<CoachingSession> getCoachingSessions() {
	return this.coachingSessions;
}

public void setCoachingSessions(List<CoachingSession> value) {
	this.coachingSessions = value;
}



	//////////////////////////////////////////////////////
	// Source Relationships
	//////////////////////////////////////////////////////
	@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@JoinColumn(name="SCORECARD_STATE_ID")
@org.hibernate.annotations.ForeignKey(name="FK_ScorecardStateOfScorecard")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private ScorecardState scorecardState;
public ScorecardState getScorecardState() {
	return this.scorecardState;
}

public void setScorecardState(ScorecardState value) {
	this.scorecardState = value;
}

	
	//////////////////////////////////////////////////////
	// JSON
	//////////////////////////////////////////////////////
	@Override
	public String retrieveJson(ObjectMapper objectMapper) {
		String objectJson = super.retrieveJson(objectMapper);

		// Properties		
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
		//Retrieve value of the Skipped Coaching Session Count property
		objectJson += ",\"skippedCoachingSessionCount\":";
		
		if (getSkippedCoachingSessionCount() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getSkippedCoachingSessionCount());
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
		//Retrieve value of the Submitted Coaching Session Count property
		objectJson += ",\"submittedCoachingSessionCount\":";
		
		if (getSubmittedCoachingSessionCount() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getSubmittedCoachingSessionCount());
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
		//Retrieve value of the Pending Coach Coaching Session Count property
		objectJson += ",\"pendingCoachCoachingSessionCount\":";
		
		if (getPendingCoachCoachingSessionCount() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getPendingCoachCoachingSessionCount());
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
		//Retrieve value of the Total Coaching Session Count property
		objectJson += ",\"totalCoachingSessionCount\":";
		
		if (getTotalCoachingSessionCount() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getTotalCoachingSessionCount());
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
		//Retrieve value of the Acknowledged Coaching Session Count property
		objectJson += ",\"acknowledgedCoachingSessionCount\":";
		
		if (getAcknowledgedCoachingSessionCount() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getAcknowledgedCoachingSessionCount());
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
		//Retrieve value of the Pending Employee Coaching Session Count property
		objectJson += ",\"pendingEmployeeCoachingSessionCount\":";
		
		if (getPendingEmployeeCoachingSessionCount() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getPendingEmployeeCoachingSessionCount());
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
		//Retrieve value of the Pending Coaching Session Count property
		objectJson += ",\"pendingCoachingSessionCount\":";
		
		if (getPendingCoachingSessionCount() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getPendingCoachingSessionCount());
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
//Retrieve value of the Scorecard State of Scorecard relationship
objectJson += ",\"scorecardState\":";
		if (getScorecardState() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getScorecardState()).toEmbeddedJson();
			} catch(Exception e) {
				objectJson += "null";
			}
		}
		objectJson += "";

		
		// Target Relationships
//Retrieve value of the Scorecard of Agent Scorecard relationship
objectJson += ",\"agentScorecards\":[";
		
		if (getAgentScorecards() != null) {
			int agentScorecardsCounter = 0;
			for(AgentScorecard nextAgentScorecards : getAgentScorecards()) {
				if (agentScorecardsCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextAgentScorecards).toEmbeddedJson();
					agentScorecardsCounter++;
				} catch(Exception e) {
					// Do nothing.
				}
			}
		}
		objectJson += "]";
//Retrieve value of the Scorecard of Coaching Notification relationship

//Retrieve value of the Scorecard of Coaching Session relationship
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

		
		return objectJson;
	}


	@Override
	protected void fromJson(JsonObject jsonObject) {
	    super.fromJson(jsonObject);

		// Properties
		//From value of the Name property
		setName(JsonUtils.getJsonString(jsonObject, "name"));
		//From value of the Skipped Coaching Session Count property
		setSkippedCoachingSessionCount(JsonUtils.getJsonInteger(jsonObject, "skippedCoachingSessionCount"));
		//From value of the Submitted Coaching Session Count property
		setSubmittedCoachingSessionCount(JsonUtils.getJsonInteger(jsonObject, "submittedCoachingSessionCount"));
		//From value of the Pending Coach Coaching Session Count property
		setPendingCoachCoachingSessionCount(JsonUtils.getJsonInteger(jsonObject, "pendingCoachCoachingSessionCount"));
		//From value of the Total Coaching Session Count property
		setTotalCoachingSessionCount(JsonUtils.getJsonInteger(jsonObject, "totalCoachingSessionCount"));
		//From value of the Scorecard Name property
		setScorecardName(JsonUtils.getJsonString(jsonObject, "scorecardName"));
		//From value of the Acknowledged Coaching Session Count property
		setAcknowledgedCoachingSessionCount(JsonUtils.getJsonInteger(jsonObject, "acknowledgedCoachingSessionCount"));
		//From value of the Pending Employee Coaching Session Count property
		setPendingEmployeeCoachingSessionCount(JsonUtils.getJsonInteger(jsonObject, "pendingEmployeeCoachingSessionCount"));
		//From value of the Pending Coaching Session Count property
		setPendingCoachingSessionCount(JsonUtils.getJsonInteger(jsonObject, "pendingCoachingSessionCount"));

		
		// Source Relationships
		this.scorecardState = (ScorecardState) JsonUtils.getJsonPerceroObject(jsonObject, "scorecardState");


		// Target Relationships
		this.agentScorecards = (List<AgentScorecard>) JsonUtils.getJsonListPerceroObject(jsonObject, "agentScorecards");
		this.coachingNotification = (CoachingNotification) JsonUtils.getJsonPerceroObject(jsonObject, "coachingNotification");
		this.coachingSessions = (List<CoachingSession>) JsonUtils.getJsonListPerceroObject(jsonObject, "coachingSessions");


	}
	
	@Override
	protected List<MappedClassMethodPair> getListSetters() {
		List<MappedClassMethodPair> listSetters = super.getListSetters();

		// Target Relationships
		listSetters.add(MappedClass.getFieldSetters(AgentScorecard.class, "scorecard"));
		listSetters.add(MappedClass.getFieldSetters(CoachingSession.class, "scorecard"));

		
		return listSetters;
	}
}
