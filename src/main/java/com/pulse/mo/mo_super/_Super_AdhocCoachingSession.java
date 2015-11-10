
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
public class _Super_AdhocCoachingSession extends BaseDataObject implements Serializable
{
	//////////////////////////////////////////////////////
	// VERSION
	//////////////////////////////////////////////////////
	@Override
	public String classVersion() {
		return "1.0.0";
	}

	
	/*
	Keys of AdhocCoachingSession
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
Status
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String status;

public String getStatus() 
{
	return this.status;
}

public void setStatus(String status)
{
	this.status = status;
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
ResponsibleCoach
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String responsibleCoach;

public String getResponsibleCoach() 
{
	return this.responsibleCoach;
}

public void setResponsibleCoach(String responsibleCoach)
{
	this.responsibleCoach = responsibleCoach;
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
SessionType
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String sessionType;

public String getSessionType() 
{
	return this.sessionType;
}

public void setSessionType(String sessionType)
{
	this.sessionType = sessionType;
}/*
ScorecardId
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Integer scorecardId;

public Integer getScorecardId() 
{
	return this.scorecardId;
}

public void setScorecardId(Integer scorecardId)
{
	this.scorecardId = scorecardId;
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
UpdatedBY
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String updatedBY;

public String getUpdatedBY() 
{
	return this.updatedBY;
}

public void setUpdatedBY(String updatedBY)
{
	this.updatedBY = updatedBY;
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
@OneToMany(fetch=FetchType.LAZY, targetEntity=AdhocCoachingSessionAttachment.class, mappedBy="adhocCoachingSession", cascade=javax.persistence.CascadeType.REMOVE)
private List<AdhocCoachingSessionAttachment> adhocCoachingSessionAttachments;
public List<AdhocCoachingSessionAttachment> getAdhocCoachingSessionAttachments() {
	return this.adhocCoachingSessionAttachments;
}

public void setAdhocCoachingSessionAttachments(List<AdhocCoachingSessionAttachment> value) {
	this.adhocCoachingSessionAttachments = value;
}



	//////////////////////////////////////////////////////
	// Source Relationships
	//////////////////////////////////////////////////////
	@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@JoinColumn(name="ADHOC_COACHING_CATEGORY_ID")
@org.hibernate.annotations.ForeignKey(name="FK_AdhocCoachingCategoryOfAdhocCoachingSession")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private AdhocCoachingCategory adhocCoachingCategory;
public AdhocCoachingCategory getAdhocCoachingCategory() {
	return this.adhocCoachingCategory;
}

public void setAdhocCoachingCategory(AdhocCoachingCategory value) {
	this.adhocCoachingCategory = value;
}@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@JoinColumn(name="COMMENT_ID")
@org.hibernate.annotations.ForeignKey(name="FK_CommentOfAdhocCoachingSession")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private Comment comment;
public Comment getComment() {
	return this.comment;
}

public void setComment(Comment value) {
	this.comment = value;
}@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@JoinColumn(name="AGENT_SCORECARD_ID")
@org.hibernate.annotations.ForeignKey(name="FK_AgentScorecardOfAdhocCoachingSession")
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
		//Retrieve value of the Created On property
		objectJson += ",\"createdOn\":";
		if (getCreatedOn() == null)
			objectJson += "null";
		else {
			objectJson += getCreatedOn().getTime();
		}
		//Retrieve value of the Status property
		objectJson += ",\"status\":";
		
		if (getStatus() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getStatus());
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
		//Retrieve value of the Closed On property
		objectJson += ",\"closedOn\":";
		if (getClosedOn() == null)
			objectJson += "null";
		else {
			objectJson += getClosedOn().getTime();
		}
		//Retrieve value of the Responsible Coach property
		objectJson += ",\"responsibleCoach\":";
		
		if (getResponsibleCoach() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getResponsibleCoach());
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
		//Retrieve value of the Session Type property
		objectJson += ",\"sessionType\":";
		
		if (getSessionType() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getSessionType());
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
		//Retrieve value of the Is Required property
		objectJson += ",\"isRequired\":";
		if (getIsRequired() == null)
			objectJson += "null";
		else {
			objectJson += getIsRequired();
		}
		//Retrieve value of the Updated BY property
		objectJson += ",\"updatedBY\":";
		
		if (getUpdatedBY() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getUpdatedBY());
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

				
		// Source Relationships
//Retrieve value of the Adhoc Coaching Category of Adhoc Coaching Session relationship
objectJson += ",\"adhocCoachingCategory\":";
		if (getAdhocCoachingCategory() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getAdhocCoachingCategory()).toEmbeddedJson();
			} catch(Exception e) {
				objectJson += "null";
			}
		}
		objectJson += "";
//Retrieve value of the Comment of Adhoc Coaching Session relationship
objectJson += ",\"comment\":";
		if (getComment() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getComment()).toEmbeddedJson();
			} catch(Exception e) {
				objectJson += "null";
			}
		}
		objectJson += "";
//Retrieve value of the Agent Scorecard of Adhoc Coaching Session relationship
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
//Retrieve value of the Adhoc Coaching Session of Adhoc Coaching Session Attachment relationship
objectJson += ",\"adhocCoachingSessionAttachments\":[";
		
		if (getAdhocCoachingSessionAttachments() != null) {
			int adhocCoachingSessionAttachmentsCounter = 0;
			for(AdhocCoachingSessionAttachment nextAdhocCoachingSessionAttachments : getAdhocCoachingSessionAttachments()) {
				if (adhocCoachingSessionAttachmentsCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextAdhocCoachingSessionAttachments).toEmbeddedJson();
					adhocCoachingSessionAttachmentsCounter++;
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
		//From value of the Created On property
		setCreatedOn(JsonUtils.getJsonDate(jsonObject, "createdOn"));
		//From value of the Status property
		setStatus(JsonUtils.getJsonString(jsonObject, "status"));
		//From value of the Closed On property
		setClosedOn(JsonUtils.getJsonDate(jsonObject, "closedOn"));
		//From value of the Responsible Coach property
		setResponsibleCoach(JsonUtils.getJsonString(jsonObject, "responsibleCoach"));
		//From value of the Created By property
		setCreatedBy(JsonUtils.getJsonString(jsonObject, "createdBy"));
		//From value of the Updated On property
		setUpdatedOn(JsonUtils.getJsonDate(jsonObject, "updatedOn"));
		//From value of the Session Type property
		setSessionType(JsonUtils.getJsonString(jsonObject, "sessionType"));
		//From value of the Scorecard Id property
		setScorecardId(JsonUtils.getJsonInteger(jsonObject, "scorecardId"));
		//From value of the Employee Id property
		setEmployeeId(JsonUtils.getJsonInteger(jsonObject, "employeeId"));
		//From value of the Is Required property
		setIsRequired(JsonUtils.getJsonBoolean(jsonObject, "isRequired"));
		//From value of the Updated BY property
		setUpdatedBY(JsonUtils.getJsonString(jsonObject, "updatedBY"));
		//From value of the Week Date property
		setWeekDate(JsonUtils.getJsonDate(jsonObject, "weekDate"));

		
		// Source Relationships
		this.adhocCoachingCategory = (AdhocCoachingCategory) JsonUtils.getJsonPerceroObject(jsonObject, "adhocCoachingCategory");
		this.comment = (Comment) JsonUtils.getJsonPerceroObject(jsonObject, "comment");
		this.agentScorecard = (AgentScorecard) JsonUtils.getJsonPerceroObject(jsonObject, "agentScorecard");


		// Target Relationships
		this.adhocCoachingSessionAttachments = (List<AdhocCoachingSessionAttachment>) JsonUtils.getJsonListPerceroObject(jsonObject, "adhocCoachingSessionAttachments");


	}
	
	@Override
	protected List<MappedClassMethodPair> getListSetters() {
		List<MappedClassMethodPair> listSetters = super.getListSetters();

		// Target Relationships
		listSetters.add(MappedClass.getFieldSetters(AdhocCoachingSessionAttachment.class, "adhoccoachingsession"));

		
		return listSetters;
	}
}
