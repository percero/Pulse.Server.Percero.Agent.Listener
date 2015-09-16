
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
public class _Super_DiscrepancyDetectedNotification extends LOBConfigurationNotification implements Serializable
{
	//////////////////////////////////////////////////////
	// VERSION
	//////////////////////////////////////////////////////
	@Override
	public String classVersion() {
		return "1.0.0";
	}

	
	/*
	Keys of DiscrepancyDetectedNotification
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
AuxCodeEntryName
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String auxCodeEntryName;

public String getAuxCodeEntryName() 
{
	return this.auxCodeEntryName;
}

public void setAuxCodeEntryName(String auxCodeEntryName)
{
	this.auxCodeEntryName = auxCodeEntryName;
}/*
EStartActivityCodeName
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String eStartActivityCodeName;

public String getEStartActivityCodeName() 
{
	return this.eStartActivityCodeName;
}

public void setEStartActivityCodeName(String eStartActivityCodeName)
{
	this.eStartActivityCodeName = eStartActivityCodeName;
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
@JoinColumn(name="EStartActivityCodeId")
@org.hibernate.annotations.ForeignKey(name="FK_EStartActivityCodeOfDiscrepancyDetectedNotification")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private EStartActivityCode eStartActivityCode;
public EStartActivityCode getEStartActivityCode() {
	return this.eStartActivityCode;
}

public void setEStartActivityCode(EStartActivityCode value) {
	this.eStartActivityCode = value;
}@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@JoinColumn(name="AuxModeId")
@org.hibernate.annotations.ForeignKey(name="FK_AuxModeOfDiscrepancyDetectedNotification")
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
		//Retrieve value of the Aux Code Entry Name property
		objectJson += ",\"auxCodeEntryName\":";
		
		if (getAuxCodeEntryName() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getAuxCodeEntryName());
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
		//Retrieve value of the EStart Activity Code Name property
		objectJson += ",\"eStartActivityCodeName\":";
		
		if (getEStartActivityCodeName() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getEStartActivityCodeName());
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
//Retrieve value of the EStart Activity Code of Discrepancy Detected Notification relationship
objectJson += ",\"eStartActivityCode\":";
		if (getEStartActivityCode() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getEStartActivityCode()).toEmbeddedJson();
			} catch(Exception e) {
				objectJson += "null";
			}
		}
		objectJson += "";
//Retrieve value of the Aux Mode of Discrepancy Detected Notification relationship
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
		//From value of the Aux Code Entry Name property
		setAuxCodeEntryName(JsonUtils.getJsonString(jsonObject, "auxCodeEntryName"));
		//From value of the EStart Activity Code Name property
		setEStartActivityCodeName(JsonUtils.getJsonString(jsonObject, "eStartActivityCodeName"));

		
		// Source Relationships
		this.eStartActivityCode = (EStartActivityCode) JsonUtils.getJsonPerceroObject(jsonObject, "eStartActivityCode");
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
