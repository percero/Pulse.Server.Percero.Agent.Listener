
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
@SecondaryTable(name="DiscrepancyDetectedNotification")
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
TimecardActivityName
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String timecardActivityName;

public String getTimecardActivityName() 
{
	return this.timecardActivityName;
}

public void setTimecardActivityName(String timecardActivityName)
{
	this.timecardActivityName = timecardActivityName;
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
@JoinColumn(name="CMS_AUX_MODE_ID")
@org.hibernate.annotations.ForeignKey(name="FK_CMSAuxModeOfDiscrepancyDetectedNotification")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private CMSAuxMode cMSAuxMode;
public CMSAuxMode getCMSAuxMode() {
	return this.cMSAuxMode;
}

public void setCMSAuxMode(CMSAuxMode value) {
	this.cMSAuxMode = value;
}@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@JoinColumn(name="TIMECARD_ACTIVITY_ID")
@org.hibernate.annotations.ForeignKey(name="FK_TimecardActivityOfDiscrepancyDetectedNotification")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private TimecardActivity timecardActivity;
public TimecardActivity getTimecardActivity() {
	return this.timecardActivity;
}

public void setTimecardActivity(TimecardActivity value) {
	this.timecardActivity = value;
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
		//Retrieve value of the Timecard Activity Name property
		objectJson += ",\"timecardActivityName\":";
		
		if (getTimecardActivityName() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getTimecardActivityName());
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
//Retrieve value of the CMS Aux Mode of Discrepancy Detected Notification relationship
objectJson += ",\"cMSAuxMode\":";
		if (getCMSAuxMode() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getCMSAuxMode()).toEmbeddedJson();
			} catch(Exception e) {
				objectJson += "null";
			}
		}
		objectJson += "";
//Retrieve value of the Timecard Activity of Discrepancy Detected Notification relationship
objectJson += ",\"timecardActivity\":";
		if (getTimecardActivity() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getTimecardActivity()).toEmbeddedJson();
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
		//From value of the Timecard Activity Name property
		setTimecardActivityName(JsonUtils.getJsonString(jsonObject, "timecardActivityName"));

		
		// Source Relationships
		this.cMSAuxMode = (CMSAuxMode) JsonUtils.getJsonPerceroObject(jsonObject, "cMSAuxMode");
		this.timecardActivity = (TimecardActivity) JsonUtils.getJsonPerceroObject(jsonObject, "timecardActivity");


		// Target Relationships


	}
	
	@Override
	protected List<MappedClassMethodPair> getListSetters() {
		List<MappedClassMethodPair> listSetters = super.getListSetters();

		// Target Relationships

		
		return listSetters;
	}
}
