
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
public class _Super_OccurrenceMismatchNotification extends DiscrepancyDetectedNotification implements Serializable
{
	//////////////////////////////////////////////////////
	// VERSION
	//////////////////////////////////////////////////////
	@Override
	public String classVersion() {
		return "1.0.0";
	}

	
	/*
	Keys of OccurrenceMismatchNotification
	*/
	//////////////////////////////////////////////////////
// ID
//////////////////////////////////////////////////////
//@Id
//@com.percero.agents.sync.metadata.annotations.Externalize
//@Column(unique=true,name="ID")
//private String ID;
//@JsonProperty(value="ID")
//public String getID() {
//	return this.ID;
//}
//
//@JsonProperty(value="ID")
//public void setID(String value) {
//	this.ID = value;
//}
	
	//////////////////////////////////////////////////////
	// Properties
	//////////////////////////////////////////////////////
	/*
EStartActivityCodeEventCount
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Integer eStartActivityCodeEventCount;

public Integer getEStartActivityCodeEventCount() 
{
	return this.eStartActivityCodeEventCount;
}

public void setEStartActivityCodeEventCount(Integer eStartActivityCodeEventCount)
{
	this.eStartActivityCodeEventCount = eStartActivityCodeEventCount;
}/*
AuxModeEventCount
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Integer auxModeEventCount;

public Integer getAuxModeEventCount() 
{
	return this.auxModeEventCount;
}

public void setAuxModeEventCount(Integer auxModeEventCount)
{
	this.auxModeEventCount = auxModeEventCount;
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
		//Retrieve value of the EStart Activity Code Event Count property
		objectJson += ",\"eStartActivityCodeEventCount\":";
		
		if (getEStartActivityCodeEventCount() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getEStartActivityCodeEventCount());
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
		//Retrieve value of the Aux Mode Event Count property
		objectJson += ",\"auxModeEventCount\":";
		
		if (getAuxModeEventCount() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getAuxModeEventCount());
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
		//From value of the EStart Activity Code Event Count property
		setEStartActivityCodeEventCount(JsonUtils.getJsonInteger(jsonObject, "eStartActivityCodeEventCount"));
		//From value of the Aux Mode Event Count property
		setAuxModeEventCount(JsonUtils.getJsonInteger(jsonObject, "auxModeEventCount"));

		
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
