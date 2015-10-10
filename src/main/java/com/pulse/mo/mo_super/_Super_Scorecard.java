
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
GroupId
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String groupId;

public String getGroupId() 
{
	return this.groupId;
}

public void setGroupId(String groupId)
{
	this.groupId = groupId;
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
Description
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String description;

public String getDescription() 
{
	return this.description;
}

public void setDescription(String description)
{
	this.description = description;
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
RegionId
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String regionId;

public String getRegionId() 
{
	return this.regionId;
}

public void setRegionId(String regionId)
{
	this.regionId = regionId;
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
ECoachingLOBId
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String eCoachingLOBId;

public String getECoachingLOBId() 
{
	return this.eCoachingLOBId;
}

public void setECoachingLOBId(String eCoachingLOBId)
{
	this.eCoachingLOBId = eCoachingLOBId;
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
LockLevel
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String lockLevel;

public String getLockLevel() 
{
	return this.lockLevel;
}

public void setLockLevel(String lockLevel)
{
	this.lockLevel = lockLevel;
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
}

	//////////////////////////////////////////////////////
	// Target Relationships
	//////////////////////////////////////////////////////
	@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@OneToMany(fetch=FetchType.LAZY, targetEntity=ScorecardMeasure.class, mappedBy="scorecard", cascade=javax.persistence.CascadeType.REMOVE)
private List<ScorecardMeasure> scorecardMeasures;
public List<ScorecardMeasure> getScorecardMeasures() {
	return this.scorecardMeasures;
}

public void setScorecardMeasures(List<ScorecardMeasure> value) {
	this.scorecardMeasures = value;
}

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



	//////////////////////////////////////////////////////
	// Source Relationships
	//////////////////////////////////////////////////////
	

	
	//////////////////////////////////////////////////////
	// JSON
	//////////////////////////////////////////////////////
	@Override
	public String retrieveJson(ObjectMapper objectMapper) {
		String objectJson = super.retrieveJson(objectMapper);

		// Properties		
		//Retrieve value of the Group Id property
		objectJson += ",\"groupId\":";
		
		if (getGroupId() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getGroupId());
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
		//Retrieve value of the Description property
		objectJson += ",\"description\":";
		
		if (getDescription() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getDescription());
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
		//Retrieve value of the Region Id property
		objectJson += ",\"regionId\":";
		
		if (getRegionId() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getRegionId());
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
		//Retrieve value of the Created On property
		objectJson += ",\"createdOn\":";
		
		if (getCreatedOn() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getCreatedOn());
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
		//Retrieve value of the ECoaching LOB Id property
		objectJson += ",\"eCoachingLOBId\":";
		
		if (getECoachingLOBId() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getECoachingLOBId());
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
		//Retrieve value of the Lock Level property
		objectJson += ",\"lockLevel\":";
		
		if (getLockLevel() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getLockLevel());
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

				
		// Source Relationships

		
		// Target Relationships
//Retrieve value of the Scorecard of Scorecard Measure relationship
objectJson += ",\"scorecardMeasures\":[";
		
		if (getScorecardMeasures() != null) {
			int scorecardMeasuresCounter = 0;
			for(ScorecardMeasure nextScorecardMeasures : getScorecardMeasures()) {
				if (scorecardMeasuresCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextScorecardMeasures).toEmbeddedJson();
					scorecardMeasuresCounter++;
				} catch(Exception e) {
					// Do nothing.
				}
			}
		}
		objectJson += "]";
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


		
		return objectJson;
	}


	@Override
	protected void fromJson(JsonObject jsonObject) {
	    super.fromJson(jsonObject);

		// Properties
		//From value of the Group Id property
		setGroupId(JsonUtils.getJsonString(jsonObject, "groupId"));
		//From value of the Acknowledged Coaching Session Count property
		setAcknowledgedCoachingSessionCount(JsonUtils.getJsonInteger(jsonObject, "acknowledgedCoachingSessionCount"));
		//From value of the Description property
		setDescription(JsonUtils.getJsonString(jsonObject, "description"));
		//From value of the Total Coaching Session Count property
		setTotalCoachingSessionCount(JsonUtils.getJsonInteger(jsonObject, "totalCoachingSessionCount"));
		//From value of the Submitted Coaching Session Count property
		setSubmittedCoachingSessionCount(JsonUtils.getJsonInteger(jsonObject, "submittedCoachingSessionCount"));
		//From value of the Region Id property
		setRegionId(JsonUtils.getJsonString(jsonObject, "regionId"));
		//From value of the Pending Employee Coaching Session Count property
		setPendingEmployeeCoachingSessionCount(JsonUtils.getJsonInteger(jsonObject, "pendingEmployeeCoachingSessionCount"));
		//From value of the Created On property
		setCreatedOn(JsonUtils.getJsonDate(jsonObject, "createdOn"));
		//From value of the Name property
		setName(JsonUtils.getJsonString(jsonObject, "name"));
		//From value of the Skipped Coaching Session Count property
		setSkippedCoachingSessionCount(JsonUtils.getJsonInteger(jsonObject, "skippedCoachingSessionCount"));
		//From value of the Created By property
		setCreatedBy(JsonUtils.getJsonString(jsonObject, "createdBy"));
		//From value of the Pending Coaching Session Count property
		setPendingCoachingSessionCount(JsonUtils.getJsonInteger(jsonObject, "pendingCoachingSessionCount"));
		//From value of the Updated By property
		setUpdatedBy(JsonUtils.getJsonString(jsonObject, "updatedBy"));
		//From value of the ECoaching LOB Id property
		setECoachingLOBId(JsonUtils.getJsonString(jsonObject, "eCoachingLOBId"));
		//From value of the Pending Coach Coaching Session Count property
		setPendingCoachCoachingSessionCount(JsonUtils.getJsonInteger(jsonObject, "pendingCoachCoachingSessionCount"));
		//From value of the Lock Level property
		setLockLevel(JsonUtils.getJsonString(jsonObject, "lockLevel"));
		//From value of the Updated On property
		setUpdatedOn(JsonUtils.getJsonDate(jsonObject, "updatedOn"));

		
		// Source Relationships


		// Target Relationships
		this.scorecardMeasures = (List<ScorecardMeasure>) JsonUtils.getJsonListPerceroObject(jsonObject, "scorecardMeasures");
		this.agentScorecards = (List<AgentScorecard>) JsonUtils.getJsonListPerceroObject(jsonObject, "agentScorecards");
		this.coachingNotification = (CoachingNotification) JsonUtils.getJsonPerceroObject(jsonObject, "coachingNotification");


	}
	
	@Override
	protected List<MappedClassMethodPair> getListSetters() {
		List<MappedClassMethodPair> listSetters = super.getListSetters();

		// Target Relationships
		listSetters.add(MappedClass.getFieldSetters(ScorecardMeasure.class, "scorecard"));
		listSetters.add(MappedClass.getFieldSetters(AgentScorecard.class, "scorecard"));

		
		return listSetters;
	}
}
