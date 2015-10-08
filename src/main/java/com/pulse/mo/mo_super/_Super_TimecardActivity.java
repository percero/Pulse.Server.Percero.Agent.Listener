
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
public class _Super_TimecardActivity extends BaseDataObject implements Serializable
{
	//////////////////////////////////////////////////////
	// VERSION
	//////////////////////////////////////////////////////
	@Override
	public String classVersion() {
		return "1.0.0";
	}

	
	/*
	Keys of TimecardActivity
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
}/*
NonBillable
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Boolean nonBillable;

public Boolean getNonBillable() 
{
	return this.nonBillable;
}

public void setNonBillable(Boolean nonBillable)
{
	this.nonBillable = nonBillable;
}/*
Name
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String name;

public String getName() 
{
	return this.name;
}

public void setName(String name)
{
	this.name = name;
}/*
Code
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String code;

public String getCode() 
{
	return this.code;
}

public void setCode(String code)
{
	this.code = code;
}

	//////////////////////////////////////////////////////
	// Target Relationships
	//////////////////////////////////////////////////////
	@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@OneToMany(fetch=FetchType.LAZY, targetEntity=DiscrepancyDetectedNotification.class, mappedBy="timecardActivity", cascade=javax.persistence.CascadeType.REMOVE)
private List<DiscrepancyDetectedNotification> discrepancyDetectedNotifications;
public List<DiscrepancyDetectedNotification> getDiscrepancyDetectedNotifications() {
	return this.discrepancyDetectedNotifications;
}

public void setDiscrepancyDetectedNotifications(List<DiscrepancyDetectedNotification> value) {
	this.discrepancyDetectedNotifications = value;
}

@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@OneToMany(fetch=FetchType.LAZY, targetEntity=TimecardEntry.class, mappedBy="timecardActivity", cascade=javax.persistence.CascadeType.REMOVE)
private List<TimecardEntry> timecardEntries;
public List<TimecardEntry> getTimecardEntries() {
	return this.timecardEntries;
}

public void setTimecardEntries(List<TimecardEntry> value) {
	this.timecardEntries = value;
}

@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@com.percero.agents.sync.metadata.annotations.Externalize
@OneToOne(fetch=FetchType.LAZY, mappedBy="timecardActivity", cascade=javax.persistence.CascadeType.REMOVE)
private LOBConfigurationEntry lOBConfigurationEntry;
public LOBConfigurationEntry getLOBConfigurationEntry() {
	return this.lOBConfigurationEntry;
}

public void setLOBConfigurationEntry(LOBConfigurationEntry value) 
{
	this.lOBConfigurationEntry = value;
}

@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@OneToMany(fetch=FetchType.LAZY, targetEntity=ChangesNotApprovedNotification.class, mappedBy="timecardActivity", cascade=javax.persistence.CascadeType.REMOVE)
private List<ChangesNotApprovedNotification> changesNotApprovedNotifications;
public List<ChangesNotApprovedNotification> getChangesNotApprovedNotifications() {
	return this.changesNotApprovedNotifications;
}

public void setChangesNotApprovedNotifications(List<ChangesNotApprovedNotification> value) {
	this.changesNotApprovedNotifications = value;
}



	//////////////////////////////////////////////////////
	// Source Relationships
	//////////////////////////////////////////////////////
	@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@JoinColumn(name="CVG_PROJECT_ID")
@org.hibernate.annotations.ForeignKey(name="FK_CVGProjectOfTimecardActivity")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private CVGProject cVGProject;
public CVGProject getCVGProject() {
	return this.cVGProject;
}

public void setCVGProject(CVGProject value) {
	this.cVGProject = value;
}

	
	//////////////////////////////////////////////////////
	// JSON
	//////////////////////////////////////////////////////
	@Override
	public String retrieveJson(ObjectMapper objectMapper) {
		String objectJson = super.retrieveJson(objectMapper);

		// Properties		
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
		//Retrieve value of the Non Billable property
		objectJson += ",\"nonBillable\":";
		if (getNonBillable() == null)
			objectJson += "null";
		else {
			objectJson += getNonBillable();
		}
		//Retrieve value of the Name property
		objectJson += ",\"name\":";
		
		if (getName() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getName());
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
		//Retrieve value of the Code property
		objectJson += ",\"code\":";
		
		if (getCode() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getCode());
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
//Retrieve value of the CVG Project of Timecard Activity relationship
objectJson += ",\"cVGProject\":";
		if (getCVGProject() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getCVGProject()).toEmbeddedJson();
			} catch(Exception e) {
				objectJson += "null";
			}
		}
		objectJson += "";

		
		// Target Relationships
//Retrieve value of the Timecard Activity of Discrepancy Detected Notification relationship
objectJson += ",\"discrepancyDetectedNotifications\":[";
		
		if (getDiscrepancyDetectedNotifications() != null) {
			int discrepancyDetectedNotificationsCounter = 0;
			for(DiscrepancyDetectedNotification nextDiscrepancyDetectedNotifications : getDiscrepancyDetectedNotifications()) {
				if (discrepancyDetectedNotificationsCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextDiscrepancyDetectedNotifications).toEmbeddedJson();
					discrepancyDetectedNotificationsCounter++;
				} catch(Exception e) {
					// Do nothing.
				}
			}
		}
		objectJson += "]";
//Retrieve value of the Timecard Activity of Timecard Entry relationship
objectJson += ",\"timecardEntries\":[";
		
		if (getTimecardEntries() != null) {
			int timecardEntriesCounter = 0;
			for(TimecardEntry nextTimecardEntries : getTimecardEntries()) {
				if (timecardEntriesCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextTimecardEntries).toEmbeddedJson();
					timecardEntriesCounter++;
				} catch(Exception e) {
					// Do nothing.
				}
			}
		}
		objectJson += "]";
//Retrieve value of the Timecard Activity of LOB Configuration Entry relationship

//Retrieve value of the Timecard Activity of Changes Not Approved Notification relationship
objectJson += ",\"changesNotApprovedNotifications\":[";
		
		if (getChangesNotApprovedNotifications() != null) {
			int changesNotApprovedNotificationsCounter = 0;
			for(ChangesNotApprovedNotification nextChangesNotApprovedNotifications : getChangesNotApprovedNotifications()) {
				if (changesNotApprovedNotificationsCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextChangesNotApprovedNotifications).toEmbeddedJson();
					changesNotApprovedNotificationsCounter++;
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
		//From value of the Description property
		setDescription(JsonUtils.getJsonString(jsonObject, "description"));
		//From value of the Non Billable property
		setNonBillable(JsonUtils.getJsonBoolean(jsonObject, "nonBillable"));
		//From value of the Name property
		setName(JsonUtils.getJsonString(jsonObject, "name"));
		//From value of the Code property
		setCode(JsonUtils.getJsonString(jsonObject, "code"));

		
		// Source Relationships
		this.cVGProject = (CVGProject) JsonUtils.getJsonPerceroObject(jsonObject, "cVGProject");


		// Target Relationships
		this.discrepancyDetectedNotifications = (List<DiscrepancyDetectedNotification>) JsonUtils.getJsonListPerceroObject(jsonObject, "discrepancyDetectedNotifications");
		this.timecardEntries = (List<TimecardEntry>) JsonUtils.getJsonListPerceroObject(jsonObject, "timecardEntries");
		this.lOBConfigurationEntry = (LOBConfigurationEntry) JsonUtils.getJsonPerceroObject(jsonObject, "lOBConfigurationEntry");
		this.changesNotApprovedNotifications = (List<ChangesNotApprovedNotification>) JsonUtils.getJsonListPerceroObject(jsonObject, "changesNotApprovedNotifications");


	}
	
	@Override
	protected List<MappedClassMethodPair> getListSetters() {
		List<MappedClassMethodPair> listSetters = super.getListSetters();

		// Target Relationships
		listSetters.add(MappedClass.getFieldSetters(DiscrepancyDetectedNotification.class, "timecardactivity"));
		listSetters.add(MappedClass.getFieldSetters(TimecardEntry.class, "timecardactivity"));
		listSetters.add(MappedClass.getFieldSetters(ChangesNotApprovedNotification.class, "timecardactivity"));

		
		return listSetters;
	}
}
