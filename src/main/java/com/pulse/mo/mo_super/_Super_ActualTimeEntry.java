
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
public class _Super_ActualTimeEntry extends BaseDataObject implements Serializable
{
	//////////////////////////////////////////////////////
	// VERSION
	//////////////////////////////////////////////////////
	@Override
	public String classVersion() {
		return "1.0.0";
	}

	
	/*
	Keys of ActualTimeEntry
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
ToTime
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Date toTime;

public Date getToTime() 
{
	return this.toTime;
}

public void setToTime(Date toTime)
{
	this.toTime = toTime;
}/*
CVGProjectName
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String cVGProjectName;

public String getCVGProjectName() 
{
	return this.cVGProjectName;
}

public void setCVGProjectName(String cVGProjectName)
{
	this.cVGProjectName = cVGProjectName;
}/*
ActionName
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String actionName;

public String getActionName() 
{
	return this.actionName;
}

public void setActionName(String actionName)
{
	this.actionName = actionName;
}/*
AuxModeName
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String auxModeName;

public String getAuxModeName() 
{
	return this.auxModeName;
}

public void setAuxModeName(String auxModeName)
{
	this.auxModeName = auxModeName;
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
}/*
Duration
Notes:Number of minutes
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Integer duration;

public Integer getDuration() 
{
	return this.duration;
}

public void setDuration(Integer duration)
{
	this.duration = duration;
}/*
FromTime
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Date fromTime;

public Date getFromTime() 
{
	return this.fromTime;
}

public void setFromTime(Date fromTime)
{
	this.fromTime = fromTime;
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
@JoinColumn(name="actualTime_ID")
@org.hibernate.annotations.ForeignKey(name="FK_ActualTimeOfActualTimeEntry")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private ActualTime actualTime;
public ActualTime getActualTime() {
	return this.actualTime;
}

public void setActualTime(ActualTime value) {
	this.actualTime = value;
}@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@JoinColumn(name="auxMode_ID")
@org.hibernate.annotations.ForeignKey(name="FK_AuxModeOfActualTimeEntry")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private AuxMode auxMode;
public AuxMode getAuxMode() {
	return this.auxMode;
}

public void setAuxMode(AuxMode value) {
	this.auxMode = value;
}

	
	//////////////////////////////////////////////////////
	// JSON
	//////////////////////////////////////////////////////
	@Override
	public String retrieveJson(ObjectMapper objectMapper) {
		String objectJson = super.retrieveJson(objectMapper);

		// Properties		
		//Retrieve value of the To Time property
		objectJson += ",\"toTime\":";
		if (getToTime() == null)
			objectJson += "null";
		else {
			objectJson += getToTime().getTime();
		}
		//Retrieve value of the CVG Project Name property
		objectJson += ",\"cVGProjectName\":";
		
		if (getCVGProjectName() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getCVGProjectName());
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
		//Retrieve value of the Action Name property
		objectJson += ",\"actionName\":";
		
		if (getActionName() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getActionName());
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
		//Retrieve value of the Aux Mode Name property
		objectJson += ",\"auxModeName\":";
		
		if (getAuxModeName() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getAuxModeName());
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
		//Retrieve value of the Duration property
		objectJson += ",\"duration\":";
		
		if (getDuration() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getDuration());
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
		//Retrieve value of the From Time property
		objectJson += ",\"fromTime\":";
		if (getFromTime() == null)
			objectJson += "null";
		else {
			objectJson += getFromTime().getTime();
		}

				
		// Source Relationships
//Retrieve value of the Actual Time of Actual Time Entry relationship
objectJson += ",\"actualTime\":";
		if (getActualTime() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getActualTime()).toEmbeddedJson();
			} catch(Exception e) {
				objectJson += "null";
			}
		}
		objectJson += "";
//Retrieve value of the Aux Mode of Actual Time Entry relationship
objectJson += ",\"auxMode\":";
		if (getAuxMode() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getAuxMode()).toEmbeddedJson();
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
		//From value of the To Time property
		setToTime(JsonUtils.getJsonDate(jsonObject, "toTime"));
		//From value of the CVG Project Name property
		setCVGProjectName(JsonUtils.getJsonString(jsonObject, "cVGProjectName"));
		//From value of the Action Name property
		setActionName(JsonUtils.getJsonString(jsonObject, "actionName"));
		//From value of the Aux Mode Name property
		setAuxModeName(JsonUtils.getJsonString(jsonObject, "auxModeName"));
		//From value of the External ID property
		setExternalID(JsonUtils.getJsonString(jsonObject, "externalID"));
		//From value of the Duration property
		setDuration(JsonUtils.getJsonInteger(jsonObject, "duration"));
		//From value of the From Time property
		setFromTime(JsonUtils.getJsonDate(jsonObject, "fromTime"));

		
		// Source Relationships
		this.actualTime = (ActualTime) JsonUtils.getJsonPerceroObject(jsonObject, "actualTime");
		this.auxMode = (AuxMode) JsonUtils.getJsonPerceroObject(jsonObject, "auxMode");


		// Target Relationships


	}
	
	@Override
	protected List<MappedClassMethodPair> getListSetters() {
		List<MappedClassMethodPair> listSetters = super.getListSetters();

		// Target Relationships

		
		return listSetters;
	}
}
