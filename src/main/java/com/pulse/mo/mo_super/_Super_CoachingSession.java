
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
Type
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String type;

public String getType() 
{
	return this.type;
}

public void setType(String type)
{
	this.type = type;
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
ClosedOn
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Date closedOn;

public Date getClosedOn() 
{
	return this.closedOn;
}

public void setClosedOn(Date closedOn)
{
	this.closedOn = closedOn;
}/*
EmployeeId
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Integer employeeId;

public Integer getEmployeeId() 
{
	return this.employeeId;
}

public void setEmployeeId(Integer employeeId)
{
	this.employeeId = employeeId;
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
}

	//////////////////////////////////////////////////////
	// Target Relationships
	//////////////////////////////////////////////////////
	@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@OneToMany(fetch=FetchType.LAZY, targetEntity=CoachingSessionAttachment.class, mappedBy="coachingSession", cascade=javax.persistence.CascadeType.REMOVE)
private List<CoachingSessionAttachment> coachingSessionAttachments;
public List<CoachingSessionAttachment> getCoachingSessionAttachments() {
	return this.coachingSessionAttachments;
}

public void setCoachingSessionAttachments(List<CoachingSessionAttachment> value) {
	this.coachingSessionAttachments = value;
}



	//////////////////////////////////////////////////////
	// Source Relationships
	//////////////////////////////////////////////////////
	@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@JoinColumn(name="COACHING_SESSION_STATE_ID")
@org.hibernate.annotations.ForeignKey(name="FK_CoachingSessionStateOfCoachingSession")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private CoachingSessionState coachingSessionState;
public CoachingSessionState getCoachingSessionState() {
	return this.coachingSessionState;
}

public void setCoachingSessionState(CoachingSessionState value) {
	this.coachingSessionState = value;
}@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@JoinColumn(name="AGENT_ID")
@org.hibernate.annotations.ForeignKey(name="FK_AgentOfCoachingSession")
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
@org.hibernate.annotations.ForeignKey(name="FK_ScorecardOfCoachingSession")
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
@org.hibernate.annotations.ForeignKey(name="FK_AgentScorecardOfCoachingSession")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private AgentScorecard agentScorecard;
public AgentScorecard getAgentScorecard() {
	return this.agentScorecard;
}

public void setAgentScorecard(AgentScorecard value) {
	this.agentScorecard = value;
}

	
	//////////////////////////////////////////////////////
	// JSON
	//////////////////////////////////////////////////////
	@Override
	public String retrieveJson(ObjectMapper objectMapper) {
		String objectJson = super.retrieveJson(objectMapper);

		// Properties		
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
		//Retrieve value of the Created On property
		objectJson += ",\"createdOn\":";
		if (getCreatedOn() == null)
			objectJson += "null";
		else {
			objectJson += getCreatedOn().getTime();
		}
		//Retrieve value of the Updated On property
		objectJson += ",\"updatedOn\":";
		if (getUpdatedOn() == null)
			objectJson += "null";
		else {
			objectJson += getUpdatedOn().getTime();
		}
		//Retrieve value of the Type property
		objectJson += ",\"type\":";
		
		if (getType() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getType());
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
		//Retrieve value of the Is Required property
		objectJson += ",\"isRequired\":";
		if (getIsRequired() == null)
			objectJson += "null";
		else {
			objectJson += getIsRequired();
		}
		//Retrieve value of the Week Date property
		objectJson += ",\"weekDate\":";
		if (getWeekDate() == null)
			objectJson += "null";
		else {
			objectJson += getWeekDate().getTime();
		}
		//Retrieve value of the Closed On property
		objectJson += ",\"closedOn\":";
		if (getClosedOn() == null)
			objectJson += "null";
		else {
			objectJson += getClosedOn().getTime();
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

				
		// Source Relationships
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
//Retrieve value of the Agent Scorecard of Coaching Session relationship
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

		
		// Target Relationships
//Retrieve value of the Coaching Session of Coaching Session Attachment relationship
objectJson += ",\"coachingSessionAttachments\":[";
		
		if (getCoachingSessionAttachments() != null) {
			int coachingSessionAttachmentsCounter = 0;
			for(CoachingSessionAttachment nextCoachingSessionAttachments : getCoachingSessionAttachments()) {
				if (coachingSessionAttachmentsCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextCoachingSessionAttachments).toEmbeddedJson();
					coachingSessionAttachmentsCounter++;
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
		//From value of the Created By property
		setCreatedBy(JsonUtils.getJsonString(jsonObject, "createdBy"));
		//From value of the Created On property
		setCreatedOn(JsonUtils.getJsonDate(jsonObject, "createdOn"));
		//From value of the Updated On property
		setUpdatedOn(JsonUtils.getJsonDate(jsonObject, "updatedOn"));
		//From value of the Type property
		setType(JsonUtils.getJsonString(jsonObject, "type"));
		//From value of the Is Required property
		setIsRequired(JsonUtils.getJsonBoolean(jsonObject, "isRequired"));
		//From value of the Week Date property
		setWeekDate(JsonUtils.getJsonDate(jsonObject, "weekDate"));
		//From value of the Closed On property
		setClosedOn(JsonUtils.getJsonDate(jsonObject, "closedOn"));
		//From value of the Employee Id property
		setEmployeeId(JsonUtils.getJsonInteger(jsonObject, "employeeId"));
		//From value of the Updated By property
		setUpdatedBy(JsonUtils.getJsonString(jsonObject, "updatedBy"));

		
		// Source Relationships
		this.coachingSessionState = (CoachingSessionState) JsonUtils.getJsonPerceroObject(jsonObject, "coachingSessionState");
		this.agent = (Agent) JsonUtils.getJsonPerceroObject(jsonObject, "agent");
		this.scorecard = (Scorecard) JsonUtils.getJsonPerceroObject(jsonObject, "scorecard");
		this.agentScorecard = (AgentScorecard) JsonUtils.getJsonPerceroObject(jsonObject, "agentScorecard");


		// Target Relationships
		this.coachingSessionAttachments = (List<CoachingSessionAttachment>) JsonUtils.getJsonListPerceroObject(jsonObject, "coachingSessionAttachments");


	}
	
	@Override
	protected List<MappedClassMethodPair> getListSetters() {
		List<MappedClassMethodPair> listSetters = super.getListSetters();

		// Target Relationships
		listSetters.add(MappedClass.getFieldSetters(CoachingSessionAttachment.class, "coachingsession"));

		
		return listSetters;
	}
}
