

package com.pulse.mo.mo_super;

import com.google.gson.JsonObject;
import com.percero.agents.sync.metadata.MappedClass.MappedClassMethodPair;
import com.percero.agents.sync.vo.BaseDataObject;
import com.percero.serial.BDODeserializer;
import com.percero.serial.BDOSerializer;
import com.percero.serial.JsonUtils;
import com.pulse.mo.Agent;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.persistence.*;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/*
Imports based on semantic requirements
*/

/*
Entity Tags based on semantic requirements
*/

@MappedSuperclass
public class _Super_Timecard extends BaseDataObject implements Serializable
{
	//////////////////////////////////////////////////////
	// VERSION
	//////////////////////////////////////////////////////
	@Override
	public String classVersion() {
		return "1.0.0";
	}

	
	/*
	Keys of Timecard
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
TimecardState
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String timecardState;

public String getTimecardState() 
{
	return this.timecardState;
}

public void setTimecardState(String timecardState)
{
	this.timecardState = timecardState;
}/*
TotalTime
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Double totalTime;

public Double getTotalTime() 
{
	return this.totalTime;
}

public void setTotalTime(Double totalTime)
{
	this.totalTime = totalTime;
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
IsHoliday
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String isHoliday;

public String getIsHoliday() 
{
	return this.isHoliday;
}

public void setIsHoliday(String isHoliday)
{
	this.isHoliday = isHoliday;
}/*
EndDate
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Date endDate;

public Date getEndDate() 
{
	return this.endDate;
}

public void setEndDate(Date endDate)
{
	this.endDate = endDate;
}/*
AssumedOff
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String assumedOff;

public String getAssumedOff() 
{
	return this.assumedOff;
}

public void setAssumedOff(String assumedOff)
{
	this.assumedOff = assumedOff;
}/*
Date
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String date;

public String getDate() 
{
	return this.date;
}

public void setDate(String date)
{
	this.date = date;
}/*
LocalTimeCode
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String localTimeCode;

public String getLocalTimeCode() 
{
	return this.localTimeCode;
}

public void setLocalTimeCode(String localTimeCode)
{
	this.localTimeCode = localTimeCode;
}/*
StartDate
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Date startDate;

public Date getStartDate() 
{
	return this.startDate;
}

public void setStartDate(Date startDate)
{
	this.startDate = startDate;
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
@JoinColumn(name="PAYROLL")
@org.hibernate.annotations.ForeignKey(name="FK_AgentOfTimecard")
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
		//Retrieve value of the Timecard State property
		objectJson += ",\"timecardState\":";
		
		if (getTimecardState() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getTimecardState());
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
		//Retrieve value of the Total Time property
		objectJson += ",\"totalTime\":";
		if (getTotalTime() == null)
			objectJson += "null";
		else {
			objectJson += getTotalTime();
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
		//Retrieve value of the Is Holiday property
		objectJson += ",\"isHoliday\":";
		
		if (getIsHoliday() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getIsHoliday());
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
		//Retrieve value of the End Date property
		objectJson += ",\"endDate\":";
		if (getEndDate() == null)
			objectJson += "null";
		else {
			objectJson += getEndDate().getTime();
		}
		//Retrieve value of the Assumed Off property
		objectJson += ",\"assumedOff\":";
		
		if (getAssumedOff() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getAssumedOff());
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
		//Retrieve value of the Date property
		objectJson += ",\"date\":";
		
		if (getDate() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getDate());
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
		//Retrieve value of the Local Time Code property
		objectJson += ",\"localTimeCode\":";
		
		if (getLocalTimeCode() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getLocalTimeCode());
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
		//Retrieve value of the Start Date property
		objectJson += ",\"startDate\":";
		if (getStartDate() == null)
			objectJson += "null";
		else {
			objectJson += getStartDate().getTime();
		}

				
		// Source Relationships
//Retrieve value of the Agent of Timecard relationship
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

		
		return objectJson;
	}


	@Override
	protected void fromJson(JsonObject jsonObject) {
	    super.fromJson(jsonObject);

		// Properties
		//From value of the Timecard State property
		setTimecardState(JsonUtils.getJsonString(jsonObject, "timecardState"));
		//From value of the Total Time property
		setTotalTime(JsonUtils.getJsonDouble(jsonObject, "totalTime"));
		//From value of the Lock Level property
		setLockLevel(JsonUtils.getJsonString(jsonObject, "lockLevel"));
		//From value of the Is Holiday property
		setIsHoliday(JsonUtils.getJsonString(jsonObject, "isHoliday"));
		//From value of the End Date property
		setEndDate(JsonUtils.getJsonDate(jsonObject, "endDate"));
		//From value of the Assumed Off property
		setAssumedOff(JsonUtils.getJsonString(jsonObject, "assumedOff"));
		//From value of the Date property
		setDate(JsonUtils.getJsonString(jsonObject, "date"));
		//From value of the Local Time Code property
		setLocalTimeCode(JsonUtils.getJsonString(jsonObject, "localTimeCode"));
		//From value of the Start Date property
		setStartDate(JsonUtils.getJsonDate(jsonObject, "startDate"));

		
		// Source Relationships
		this.agent = (Agent) JsonUtils.getJsonPerceroObject(jsonObject, "agent");


		// Target Relationships

	}
	
	@Override
	protected List<MappedClassMethodPair> getListSetters() {
		List<MappedClassMethodPair> listSetters = super.getListSetters();

		// Target Relationships
		
		return listSetters;
	}
}

