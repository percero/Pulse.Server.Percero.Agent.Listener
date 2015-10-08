
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
public class _Super_PayrollDetail extends BaseDataObject implements Serializable
{
	//////////////////////////////////////////////////////
	// VERSION
	//////////////////////////////////////////////////////
	@Override
	public String classVersion() {
		return "1.0.0";
	}

	
	/*
	Keys of PayrollDetail
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
ShiftStartDateTime
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Date shiftStartDateTime;

public Date getShiftStartDateTime() 
{
	return this.shiftStartDateTime;
}

public void setShiftStartDateTime(Date shiftStartDateTime)
{
	this.shiftStartDateTime = shiftStartDateTime;
}/*
ShiftStartEndTime
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Date shiftStartEndTime;

public Date getShiftStartEndTime() 
{
	return this.shiftStartEndTime;
}

public void setShiftStartEndTime(Date shiftStartEndTime)
{
	this.shiftStartEndTime = shiftStartEndTime;
}/*
AssumedOff
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Boolean assumedOff;

public Boolean getAssumedOff() 
{
	return this.assumedOff;
}

public void setAssumedOff(Boolean assumedOff)
{
	this.assumedOff = assumedOff;
}/*
ShiftRule
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String shiftRule;

public String getShiftRule() 
{
	return this.shiftRule;
}

public void setShiftRule(String shiftRule)
{
	this.shiftRule = shiftRule;
}

	//////////////////////////////////////////////////////
	// Target Relationships
	//////////////////////////////////////////////////////
	

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
		//Retrieve value of the Shift Start Date Time property
		objectJson += ",\"shiftStartDateTime\":";
		if (getShiftStartDateTime() == null)
			objectJson += "null";
		else {
			objectJson += getShiftStartDateTime().getTime();
		}
		//Retrieve value of the Shift Start End Time property
		objectJson += ",\"shiftStartEndTime\":";
		if (getShiftStartEndTime() == null)
			objectJson += "null";
		else {
			objectJson += getShiftStartEndTime().getTime();
		}
		//Retrieve value of the Assumed Off property
		objectJson += ",\"assumedOff\":";
		if (getAssumedOff() == null)
			objectJson += "null";
		else {
			objectJson += getAssumedOff();
		}
		//Retrieve value of the Shift Rule property
		objectJson += ",\"shiftRule\":";
		
		if (getShiftRule() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getShiftRule());
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

		
		return objectJson;
	}


	@Override
	protected void fromJson(JsonObject jsonObject) {
	    super.fromJson(jsonObject);

		// Properties
		//From value of the Shift Start Date Time property
		setShiftStartDateTime(JsonUtils.getJsonDate(jsonObject, "shiftStartDateTime"));
		//From value of the Shift Start End Time property
		setShiftStartEndTime(JsonUtils.getJsonDate(jsonObject, "shiftStartEndTime"));
		//From value of the Assumed Off property
		setAssumedOff(JsonUtils.getJsonBoolean(jsonObject, "assumedOff"));
		//From value of the Shift Rule property
		setShiftRule(JsonUtils.getJsonString(jsonObject, "shiftRule"));

		
		// Source Relationships


		// Target Relationships



	}
	
	@Override
	protected List<MappedClassMethodPair> getListSetters() {
		List<MappedClassMethodPair> listSetters = super.getListSetters();

		// Target Relationships

		
		return listSetters;
	}
}
