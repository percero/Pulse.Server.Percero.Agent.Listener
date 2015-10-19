
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
public class _Super_TraceEntry extends BaseDataObject implements Serializable
{
	//////////////////////////////////////////////////////
	// VERSION
	//////////////////////////////////////////////////////
	@Override
	public String classVersion() {
		return "1.0.0";
	}

	
	/*
	Keys of TraceEntry
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
Timestamp
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Date timestamp;

public Date getTimestamp() 
{
	return this.timestamp;
}

public void setTimestamp(Date timestamp)
{
	this.timestamp = timestamp;
}/*
LogMessage
Notes:
*/
@Column(columnDefinition="TEXT")
@com.percero.agents.sync.metadata.annotations.Externalize

private String logMessage;

public String getLogMessage() 
{
	return this.logMessage;
}

public void setLogMessage(String logMessage)
{
	this.logMessage = logMessage;
}/*
TraceType
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String traceType;

public String getTraceType() 
{
	return this.traceType;
}

public void setTraceType(String traceType)
{
	this.traceType = traceType;
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
@JoinColumn(name="TRACE_LOG_ID")
@org.hibernate.annotations.ForeignKey(name="FK_TraceLogOfTraceEntry")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private TraceLog traceLog;
public TraceLog getTraceLog() {
	return this.traceLog;
}

public void setTraceLog(TraceLog value) {
	this.traceLog = value;
}@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@JoinColumn(name="PULSE_USER_ID")
@org.hibernate.annotations.ForeignKey(name="FK_PulseUserOfTraceEntry")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private PulseUser pulseUser;
public PulseUser getPulseUser() {
	return this.pulseUser;
}

public void setPulseUser(PulseUser value) {
	this.pulseUser = value;
}

	
	//////////////////////////////////////////////////////
	// JSON
	//////////////////////////////////////////////////////
	@Override
	public String retrieveJson(ObjectMapper objectMapper) {
		String objectJson = super.retrieveJson(objectMapper);

		// Properties		
		//Retrieve value of the Timestamp property
		objectJson += ",\"timestamp\":";
		if (getTimestamp() == null)
			objectJson += "null";
		else {
			objectJson += getTimestamp().getTime();
		}
		//Retrieve value of the Log Message property
		objectJson += ",\"logMessage\":";
		
		if (getLogMessage() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getLogMessage());
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
		//Retrieve value of the Trace Type property
		objectJson += ",\"traceType\":";
		
		if (getTraceType() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getTraceType());
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
//Retrieve value of the Trace Log of Trace Entry relationship
objectJson += ",\"traceLog\":";
		if (getTraceLog() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getTraceLog()).toEmbeddedJson();
			} catch(Exception e) {
				objectJson += "null";
			}
		}
		objectJson += "";
//Retrieve value of the Pulse User of Trace Entry relationship
objectJson += ",\"pulseUser\":";
		if (getPulseUser() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getPulseUser()).toEmbeddedJson();
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
		//From value of the Timestamp property
		setTimestamp(JsonUtils.getJsonDate(jsonObject, "timestamp"));
		//From value of the Log Message property
		setLogMessage(JsonUtils.getJsonString(jsonObject, "logMessage"));
		//From value of the Trace Type property
		setTraceType(JsonUtils.getJsonString(jsonObject, "traceType"));

		
		// Source Relationships
		this.traceLog = (TraceLog) JsonUtils.getJsonPerceroObject(jsonObject, "traceLog");
		this.pulseUser = (PulseUser) JsonUtils.getJsonPerceroObject(jsonObject, "pulseUser");


		// Target Relationships


	}
	
	@Override
	protected List<MappedClassMethodPair> getListSetters() {
		List<MappedClassMethodPair> listSetters = super.getListSetters();

		// Target Relationships

		
		return listSetters;
	}
}
