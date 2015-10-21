
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
public class _Super_CMSEntry extends BaseDataObject implements Serializable
{
	//////////////////////////////////////////////////////
	// VERSION
	//////////////////////////////////////////////////////
	@Override
	public String classVersion() {
		return "1.0.0";
	}

	
	/*
	Keys of CMSEntry
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
EStartProjectName
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String eStartProjectName;

public String getEStartProjectName() 
{
	return this.eStartProjectName;
}

public void setEStartProjectName(String eStartProjectName)
{
	this.eStartProjectName = eStartProjectName;
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
}/*
CMSAuxMode
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String cMSAuxMode;

public String getCMSAuxMode() 
{
	return this.cMSAuxMode;
}

public void setCMSAuxMode(String cMSAuxMode)
{
	this.cMSAuxMode = cMSAuxMode;
}/*
Duration
Notes:Number of minutes
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Double duration;

public Double getDuration() 
{
	return this.duration;
}

public void setDuration(Double duration)
{
	this.duration = duration;
}/*
ToTime
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String toTime;

public String getToTime() 
{
	return this.toTime;
}

public void setToTime(String toTime)
{
	this.toTime = toTime;
}

	//////////////////////////////////////////////////////
	// Target Relationships
	//////////////////////////////////////////////////////
	@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@OneToMany(fetch=FetchType.LAZY, targetEntity=CMSEntryLOB.class, mappedBy="cMSEntry", cascade=javax.persistence.CascadeType.REMOVE)
private List<CMSEntryLOB> cMSEntryLOBs;
public List<CMSEntryLOB> getCMSEntryLOBs() {
	return this.cMSEntryLOBs;
}

public void setCMSEntryLOBs(List<CMSEntryLOB> value) {
	this.cMSEntryLOBs = value;
}



	//////////////////////////////////////////////////////
	// Source Relationships
	//////////////////////////////////////////////////////
	@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@JoinColumn(name="EMPLOYEE_ID")
@org.hibernate.annotations.ForeignKey(name="FK_AgentOfCMSEntry")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private Agent agent;
public Agent getAgent() {
	return this.agent;
}

public void setAgent(Agent value) {
	this.agent = value;
}

	
	//////////////////////////////////////////////////////
	// JSON
	//////////////////////////////////////////////////////
	@Override
	public String retrieveJson(ObjectMapper objectMapper) {
		String objectJson = super.retrieveJson(objectMapper);

		// Properties		
		//Retrieve value of the EStart Project Name property
		objectJson += ",\"eStartProjectName\":";
		
		if (getEStartProjectName() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getEStartProjectName());
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
		//Retrieve value of the CMS Aux Mode property
		objectJson += ",\"cMSAuxMode\":";
		
		if (getCMSAuxMode() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getCMSAuxMode());
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
			objectJson += getDuration();
		}
		//Retrieve value of the To Time property
		objectJson += ",\"toTime\":";
		
		if (getToTime() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getToTime());
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
//Retrieve value of the Agent of CMS Entry relationship
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

		
		// Target Relationships
//Retrieve value of the CMS Entry of CMS Entry LOB relationship
objectJson += ",\"cMSEntryLOBs\":[";
		
		if (getCMSEntryLOBs() != null) {
			int cMSEntryLOBsCounter = 0;
			for(CMSEntryLOB nextCMSEntryLOBs : getCMSEntryLOBs()) {
				if (cMSEntryLOBsCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextCMSEntryLOBs).toEmbeddedJson();
					cMSEntryLOBsCounter++;
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
		//From value of the EStart Project Name property
		setEStartProjectName(JsonUtils.getJsonString(jsonObject, "eStartProjectName"));
		//From value of the From Time property
		setFromTime(JsonUtils.getJsonDate(jsonObject, "fromTime"));
		//From value of the CMS Aux Mode property
		setCMSAuxMode(JsonUtils.getJsonString(jsonObject, "cMSAuxMode"));
		//From value of the Duration property
		setDuration(JsonUtils.getJsonDouble(jsonObject, "duration"));
		//From value of the To Time property
		setToTime(JsonUtils.getJsonString(jsonObject, "toTime"));

		
		// Source Relationships
		this.agent = (Agent) JsonUtils.getJsonPerceroObject(jsonObject, "agent");


		// Target Relationships
		this.cMSEntryLOBs = (List<CMSEntryLOB>) JsonUtils.getJsonListPerceroObject(jsonObject, "cMSEntryLOBs");


	}
	
	@Override
	protected List<MappedClassMethodPair> getListSetters() {
		List<MappedClassMethodPair> listSetters = super.getListSetters();

		// Target Relationships
		listSetters.add(MappedClass.getFieldSetters(CMSEntryLOB.class, "cmsentry"));

		
		return listSetters;
	}
}
