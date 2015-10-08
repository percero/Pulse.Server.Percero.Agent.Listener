
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
import javax.persistence.Inheritance;import javax.persistence.InheritanceType;

import com.percero.agents.sync.vo.BaseDataObject;
import com.percero.serial.BDODeserializer;
import com.percero.serial.BDOSerializer;
import com.percero.serial.JsonUtils;

import com.pulse.mo.*;

/*
Entity Tags based on semantic requirements
*/
@SecondaryTable(name="DurationMismatchNotification")
@MappedSuperclass
public class _Super_DurationMismatchNotification extends DiscrepancyDetectedNotification implements Serializable
{
	//////////////////////////////////////////////////////
	// VERSION
	//////////////////////////////////////////////////////
	@Override
	public String classVersion() {
		return "1.0.0";
	}

	
	/*
	Keys of DurationMismatchNotification
	*/
	
	
	//////////////////////////////////////////////////////
	// Properties
	//////////////////////////////////////////////////////
	/*
StartTime
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Date startTime;

public Date getStartTime() 
{
	return this.startTime;
}

public void setStartTime(Date startTime)
{
	this.startTime = startTime;
}/*
EndTime
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Date endTime;

public Date getEndTime() 
{
	return this.endTime;
}

public void setEndTime(Date endTime)
{
	this.endTime = endTime;
}/*
Duration
Notes:
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
		//Retrieve value of the Start Time property
		objectJson += ",\"startTime\":";
		if (getStartTime() == null)
			objectJson += "null";
		else {
			objectJson += getStartTime().getTime();
		}
		//Retrieve value of the End Time property
		objectJson += ",\"endTime\":";
		if (getEndTime() == null)
			objectJson += "null";
		else {
			objectJson += getEndTime().getTime();
		}
		//Retrieve value of the Duration property
		objectJson += ",\"duration\":";
		if (getDuration() == null)
			objectJson += "null";
		else {
			objectJson += getDuration();
		}

				
		// Source Relationships

		
		// Target Relationships

		
		return objectJson;
	}


	@Override
	protected void fromJson(JsonObject jsonObject) {
	    super.fromJson(jsonObject);

		// Properties
		//From value of the Start Time property
		setStartTime(JsonUtils.getJsonDate(jsonObject, "startTime"));
		//From value of the End Time property
		setEndTime(JsonUtils.getJsonDate(jsonObject, "endTime"));
		//From value of the Duration property
		setDuration(JsonUtils.getJsonDouble(jsonObject, "duration"));

		
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
