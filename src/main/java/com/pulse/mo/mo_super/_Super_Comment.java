
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
public class _Super_Comment extends BaseDataObject implements Serializable
{
	//////////////////////////////////////////////////////
	// VERSION
	//////////////////////////////////////////////////////
	@Override
	public String classVersion() {
		return "1.0.0";
	}

	
	/*
	Keys of Comment
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
Date
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Date date;

public Date getDate() 
{
	return this.date;
}

public void setDate(Date date)
{
	this.date = date;
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
}

	//////////////////////////////////////////////////////
	// Target Relationships
	//////////////////////////////////////////////////////
	

	//////////////////////////////////////////////////////
	// Source Relationships
	//////////////////////////////////////////////////////
	@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@JoinColumn(name="ADHOC_COACHING_SESSION_ID")
@org.hibernate.annotations.ForeignKey(name="FK_AdhocCoachingSessionOfComment")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private AdhocCoachingSession adhocCoachingSession;
public AdhocCoachingSession getAdhocCoachingSession() {
	return this.adhocCoachingSession;
}

public void setAdhocCoachingSession(AdhocCoachingSession value) {
	this.adhocCoachingSession = value;
}

	
	//////////////////////////////////////////////////////
	// JSON
	//////////////////////////////////////////////////////
	@Override
	public String retrieveJson(ObjectMapper objectMapper) {
		String objectJson = super.retrieveJson(objectMapper);

		// Properties		
		//Retrieve value of the Date property
		objectJson += ",\"date\":";
		if (getDate() == null)
			objectJson += "null";
		else {
			objectJson += getDate().getTime();
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

				
		// Source Relationships
//Retrieve value of the Adhoc Coaching Session of Comment relationship
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

		
		// Target Relationships

		
		return objectJson;
	}


	@Override
	protected void fromJson(JsonObject jsonObject) {
	    super.fromJson(jsonObject);

		// Properties
		//From value of the Date property
		setDate(JsonUtils.getJsonDate(jsonObject, "date"));
		//From value of the Description property
		setDescription(JsonUtils.getJsonString(jsonObject, "description"));

		
		// Source Relationships
		this.adhocCoachingSession = (AdhocCoachingSession) JsonUtils.getJsonPerceroObject(jsonObject, "adhocCoachingSession");


		// Target Relationships


	}
	
	@Override
	protected List<MappedClassMethodPair> getListSetters() {
		List<MappedClassMethodPair> listSetters = super.getListSetters();

		// Target Relationships

		
		return listSetters;
	}
}
