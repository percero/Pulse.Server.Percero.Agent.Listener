
package com.pulsemobile.mo.mo_super;

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

import com.pulsemobile.mo.*;

/*
Entity Tags based on semantic requirements
*/

@MappedSuperclass
public class _Super_Attachment extends BaseDataObject implements Serializable
{
	//////////////////////////////////////////////////////
	// VERSION
	//////////////////////////////////////////////////////
	@Override
	public String classVersion() {
		return "1.0.0";
	}

	
	/*
	Keys of Attachment
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
FileUri
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String fileUri;

public String getFileUri() 
{
	return this.fileUri;
}

public void setFileUri(String fileUri)
{
	this.fileUri = fileUri;
}/*
ExternalID
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String externalID;

public String getExternalID() 
{
	return this.externalID;
}

public void setExternalID(String externalID)
{
	this.externalID = externalID;
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
@JoinColumn(name="PerformanceSummaryId")
@org.hibernate.annotations.ForeignKey(name="FK_PerformanceSummaryOfAttachment")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private PerformanceSummary performanceSummary;
public PerformanceSummary getPerformanceSummary() {
	return this.performanceSummary;
}

public void setPerformanceSummary(PerformanceSummary value) {
	this.performanceSummary = value;
}@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@JoinColumn(name="AdhocCoachingSessionId")
@org.hibernate.annotations.ForeignKey(name="FK_AdhocCoachingSessionOfAttachment")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private AdhocCoachingSession adhocCoachingSession;
public AdhocCoachingSession getAdhocCoachingSession() {
	return this.adhocCoachingSession;
}

public void setAdhocCoachingSession(AdhocCoachingSession value) {
	this.adhocCoachingSession = value;
}@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@JoinColumn(name="CoachingSessionId")
@org.hibernate.annotations.ForeignKey(name="FK_CoachingSessionOfAttachment")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private CoachingSession coachingSession;
public CoachingSession getCoachingSession() {
	return this.coachingSession;
}

public void setCoachingSession(CoachingSession value) {
	this.coachingSession = value;
}@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@JoinColumn(name="CorrectiveActionId")
@org.hibernate.annotations.ForeignKey(name="FK_CorrectiveActionOfAttachment")
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
		//Retrieve value of the File Uri property
		objectJson += ",\"fileUri\":";
		
		if (getFileUri() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getFileUri());
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
		//Retrieve value of the External ID property
		objectJson += ",\"externalID\":";
		
		if (getExternalID() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getExternalID());
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
//Retrieve value of the Performance Summary of Attachment relationship
objectJson += ",\"performanceSummary\":";
		if (getPerformanceSummary() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getPerformanceSummary()).toEmbeddedJson();
			} catch(Exception e) {
				objectJson += "null";
			}
		}
		objectJson += "";
//Retrieve value of the Adhoc Coaching Session of Attachment relationship
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
//Retrieve value of the Coaching Session of Attachment relationship
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
//Retrieve value of the Corrective Action of Attachment relationship
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
		//From value of the Name property
		setName(JsonUtils.getJsonString(jsonObject, "name"));
		//From value of the File Uri property
		setFileUri(JsonUtils.getJsonString(jsonObject, "fileUri"));
		//From value of the External ID property
		setExternalID(JsonUtils.getJsonString(jsonObject, "externalID"));

		
		// Source Relationships
		this.performanceSummary = (PerformanceSummary) JsonUtils.getJsonPerceroObject(jsonObject, "performanceSummary");
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
