
package com.pulsemobile.mo.mo_super;

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

import com.pulsemobile.mo.*;

/*
Entity Tags based on semantic requirements
*/

@MappedSuperclass
public class _Super_ChangesNotApprovedNotification extends Notification implements Serializable
{
	//////////////////////////////////////////////////////
	// VERSION
	//////////////////////////////////////////////////////
	@Override
	public String classVersion() {
		return "1.0.0";
	}

	
	/*
	Keys of ChangesNotApprovedNotification
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
Resolved
Notes:Flag that determines if the notification has been resolved
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Boolean resolved;

public Boolean getResolved() 
{
	return this.resolved;
}

public void setResolved(Boolean resolved)
{
	this.resolved = resolved;
}/*
NotYetStartedStateCount
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Integer notYetStartedStateCount;

public Integer getNotYetStartedStateCount() 
{
	return this.notYetStartedStateCount;
}

public void setNotYetStartedStateCount(Integer notYetStartedStateCount)
{
	this.notYetStartedStateCount = notYetStartedStateCount;
}/*
ShiftEndDate
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Date shiftEndDate;

public Date getShiftEndDate() 
{
	return this.shiftEndDate;
}

public void setShiftEndDate(Date shiftEndDate)
{
	this.shiftEndDate = shiftEndDate;
}/*
InProgressStateCount
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Integer inProgressStateCount;

public Integer getInProgressStateCount() 
{
	return this.inProgressStateCount;
}

public void setInProgressStateCount(Integer inProgressStateCount)
{
	this.inProgressStateCount = inProgressStateCount;
}/*
ApprovedStateCount
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Integer approvedStateCount;

public Integer getApprovedStateCount() 
{
	return this.approvedStateCount;
}

public void setApprovedStateCount(Integer approvedStateCount)
{
	this.approvedStateCount = approvedStateCount;
}/*
CompleteStateCount
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Integer completeStateCount;

public Integer getCompleteStateCount() 
{
	return this.completeStateCount;
}

public void setCompleteStateCount(Integer completeStateCount)
{
	this.completeStateCount = completeStateCount;
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
@JoinColumn(name="CVGProjectId")
@org.hibernate.annotations.ForeignKey(name="FK_CVGProjectOfChangesNotApprovedNotification")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private CVGProject cVGProject;
public CVGProject getCVGProject() {
	return this.cVGProject;
}

public void setCVGProject(CVGProject value) {
	this.cVGProject = value;
}@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@JoinColumn(name="EStartActivityCodeId")
@org.hibernate.annotations.ForeignKey(name="FK_EStartActivityCodeOfChangesNotApprovedNotification")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private EStartActivityCode eStartActivityCode;
public EStartActivityCode getEStartActivityCode() {
	return this.eStartActivityCode;
}

public void setEStartActivityCode(EStartActivityCode value) {
	this.eStartActivityCode = value;
}

	
	//////////////////////////////////////////////////////
	// JSON
	//////////////////////////////////////////////////////
	@Override
	public String retrieveJson(ObjectMapper objectMapper) {
		String objectJson = super.retrieveJson(objectMapper);

		// Properties		
		//Retrieve value of the Resolved property
		objectJson += ",\"resolved\":";
		if (getResolved() == null)
			objectJson += "null";
		else {
			objectJson += getResolved();
		}
		//Retrieve value of the Not Yet Started State Count property
		objectJson += ",\"notYetStartedStateCount\":";
		
		if (getNotYetStartedStateCount() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getNotYetStartedStateCount());
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
		//Retrieve value of the Shift End Date property
		objectJson += ",\"shiftEndDate\":";
		
		if (getShiftEndDate() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getShiftEndDate());
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
		//Retrieve value of the In Progress State Count property
		objectJson += ",\"inProgressStateCount\":";
		
		if (getInProgressStateCount() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getInProgressStateCount());
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
		//Retrieve value of the Approved State Count property
		objectJson += ",\"approvedStateCount\":";
		
		if (getApprovedStateCount() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getApprovedStateCount());
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
		//Retrieve value of the Complete State Count property
		objectJson += ",\"completeStateCount\":";
		
		if (getCompleteStateCount() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getCompleteStateCount());
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
//Retrieve value of the CVG Project of Changes Not Approved Notification relationship
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
//Retrieve value of the EStart Activity Code of Changes Not Approved Notification relationship
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

		
		// Target Relationships

		
		return objectJson;
	}


	@Override
	protected void fromJson(JsonObject jsonObject) {
	    super.fromJson(jsonObject);

		// Properties
		//From value of the Resolved property
		setResolved(JsonUtils.getJsonBoolean(jsonObject, "resolved"));
		//From value of the Not Yet Started State Count property
		setNotYetStartedStateCount(JsonUtils.getJsonInteger(jsonObject, "notYetStartedStateCount"));
		//From value of the Shift End Date property
		setShiftEndDate(JsonUtils.getJsonDate(jsonObject, "shiftEndDate"));
		//From value of the In Progress State Count property
		setInProgressStateCount(JsonUtils.getJsonInteger(jsonObject, "inProgressStateCount"));
		//From value of the Approved State Count property
		setApprovedStateCount(JsonUtils.getJsonInteger(jsonObject, "approvedStateCount"));
		//From value of the Complete State Count property
		setCompleteStateCount(JsonUtils.getJsonInteger(jsonObject, "completeStateCount"));

		
		// Source Relationships
		this.cVGProject = (CVGProject) JsonUtils.getJsonPerceroObject(jsonObject, "cVGProject");
		this.eStartActivityCode = (EStartActivityCode) JsonUtils.getJsonPerceroObject(jsonObject, "eStartActivityCode");


		// Target Relationships


	}
	
	@Override
	protected List<MappedClassMethodPair> getListSetters() {
		List<MappedClassMethodPair> listSetters = super.getListSetters();

		// Target Relationships

		
		return listSetters;
	}
}
