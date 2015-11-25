
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
public class _Super_SessionComment extends BaseDataObject implements Serializable
{
	//////////////////////////////////////////////////////
	// VERSION
	//////////////////////////////////////////////////////
	@Override
	public String classVersion() {
		return "1.0.0";
	}

	
	/*
	Keys of SessionComment
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
DatarefId
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Integer datarefId;

public Integer getDatarefId() 
{
	return this.datarefId;
}

public void setDatarefId(Integer datarefId)
{
	this.datarefId = datarefId;
}/*
Type
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Integer type;

public Integer getType() 
{
	return this.type;
}

public void setType(Integer type)
{
	this.type = type;
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
@JoinColumn(name="ADHOC_COACHING_SESSION_ID")
@org.hibernate.annotations.ForeignKey(name="FK_AdhocCoachingSessionOfSessionComment")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private AdhocCoachingSession adhocCoachingSession;
public AdhocCoachingSession getAdhocCoachingSession() {
	return this.adhocCoachingSession;
}

public void setAdhocCoachingSession(AdhocCoachingSession value) {
	this.adhocCoachingSession = value;
}@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@JoinColumn(name="COACHING_SESSION_ID")
@org.hibernate.annotations.ForeignKey(name="FK_CoachingSessionOfSessionComment")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private CoachingSession coachingSession;
public CoachingSession getCoachingSession() {
	return this.coachingSession;
}

public void setCoachingSession(CoachingSession value) {
	this.coachingSession = value;
}@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@JoinColumn(name="CORRECTIVE_ACTION_ID")
@org.hibernate.annotations.ForeignKey(name="FK_CorrectiveActionOfSessionComment")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private CorrectiveAction correctiveAction;
public CorrectiveAction getCorrectiveAction() {
	return this.correctiveAction;
}

public void setCorrectiveAction(CorrectiveAction value) {
	this.correctiveAction = value;
}

	
	//////////////////////////////////////////////////////
	// JSON
	//////////////////////////////////////////////////////
	@Override
	public String retrieveJson(ObjectMapper objectMapper) {
		String objectJson = super.retrieveJson(objectMapper);

		// Properties		
		//Retrieve value of the Updated On property
		objectJson += ",\"updatedOn\":";
		if (getUpdatedOn() == null)
			objectJson += "null";
		else {
			objectJson += getUpdatedOn().getTime();
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
		//Retrieve value of the Dataref Id property
		objectJson += ",\"datarefId\":";
		
		if (getDatarefId() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getDatarefId());
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
//Retrieve value of the Adhoc Coaching Session of Session Comment relationship
objectJson += ",\"adhocCoachingSession\":";
		if (getAdhocCoachingSession() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getAdhocCoachingSession()).toEmbeddedJson();
			} catch(Exception e) {
				objectJson += "null";
			}
		}
		objectJson += "";
//Retrieve value of the Coaching Session of Session Comment relationship
objectJson += ",\"coachingSession\":";
		if (getCoachingSession() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getCoachingSession()).toEmbeddedJson();
			} catch(Exception e) {
				objectJson += "null";
			}
		}
		objectJson += "";
//Retrieve value of the Corrective Action of Session Comment relationship
objectJson += ",\"correctiveAction\":";
		if (getCorrectiveAction() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getCorrectiveAction()).toEmbeddedJson();
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
		//From value of the Updated On property
		setUpdatedOn(JsonUtils.getJsonDate(jsonObject, "updatedOn"));
		//From value of the Description property
		setDescription(JsonUtils.getJsonString(jsonObject, "description"));
		//From value of the Dataref Id property
		setDatarefId(JsonUtils.getJsonInteger(jsonObject, "datarefId"));
		//From value of the Type property
		setType(JsonUtils.getJsonInteger(jsonObject, "type"));
		//From value of the Created By property
		setCreatedBy(JsonUtils.getJsonString(jsonObject, "createdBy"));
		//From value of the Created On property
		setCreatedOn(JsonUtils.getJsonDate(jsonObject, "createdOn"));
		//From value of the Updated By property
		setUpdatedBy(JsonUtils.getJsonString(jsonObject, "updatedBy"));

		
		// Source Relationships
		this.adhocCoachingSession = (AdhocCoachingSession) JsonUtils.getJsonPerceroObject(jsonObject, "adhocCoachingSession");
		this.coachingSession = (CoachingSession) JsonUtils.getJsonPerceroObject(jsonObject, "coachingSession");
		this.correctiveAction = (CorrectiveAction) JsonUtils.getJsonPerceroObject(jsonObject, "correctiveAction");


		// Target Relationships


	}
	
	@Override
	protected List<MappedClassMethodPair> getListSetters() {
		List<MappedClassMethodPair> listSetters = super.getListSetters();

		// Target Relationships

		
		return listSetters;
	}
}
