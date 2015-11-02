
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
public class _Super_CMSEntryLOB extends BaseDataObject implements Serializable
{
	//////////////////////////////////////////////////////
	// VERSION
	//////////////////////////////////////////////////////
	@Override
	public String classVersion() {
		return "1.0.0";
	}

	
	/*
	Keys of CMSEntryLOB
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
EmployeeId
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Integer employeeId;

public Integer getEmployeeId() 
{
	return this.employeeId;
}

public void setEmployeeId(Integer employeeId)
{
	this.employeeId = employeeId;
}/*
ClientName
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String clientName;

public String getClientName() 
{
	return this.clientName;
}

public void setClientName(String clientName)
{
	this.clientName = clientName;
}/*
LOBName
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String lOBName;

public String getLOBName() 
{
	return this.lOBName;
}

public void setLOBName(String lOBName)
{
	this.lOBName = lOBName;
}/*
SiteName
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String siteName;

public String getSiteName() 
{
	return this.siteName;
}

public void setSiteName(String siteName)
{
	this.siteName = siteName;
}/*
ClientId
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Integer clientId;

public Integer getClientId() 
{
	return this.clientId;
}

public void setClientId(Integer clientId)
{
	this.clientId = clientId;
}/*
SiteId
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Integer siteId;

public Integer getSiteId() 
{
	return this.siteId;
}

public void setSiteId(Integer siteId)
{
	this.siteId = siteId;
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
@JoinColumn(name="LOB_ID")
@org.hibernate.annotations.ForeignKey(name="FK_LOBOfCMSEntryLOB")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private LOB lOB;
public LOB getLOB() {
	return this.lOB;
}

public void setLOB(LOB value) {
	this.lOB = value;
}@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@JoinColumn(name="CMS_ENTRY_ID")
@org.hibernate.annotations.ForeignKey(name="FK_CMSEntryOfCMSEntryLOB")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private CMSEntry cMSEntry;
public CMSEntry getCMSEntry() {
	return this.cMSEntry;
}

public void setCMSEntry(CMSEntry value) {
	this.cMSEntry = value;
}

	
	//////////////////////////////////////////////////////
	// JSON
	//////////////////////////////////////////////////////
	@Override
	public String retrieveJson(ObjectMapper objectMapper) {
		String objectJson = super.retrieveJson(objectMapper);

		// Properties		
		//Retrieve value of the Employee Id property
		objectJson += ",\"employeeId\":";
		
		if (getEmployeeId() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getEmployeeId());
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
		//Retrieve value of the Client Name property
		objectJson += ",\"clientName\":";
		
		if (getClientName() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getClientName());
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
		//Retrieve value of the LOB Name property
		objectJson += ",\"lOBName\":";
		
		if (getLOBName() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getLOBName());
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
		//Retrieve value of the Site Name property
		objectJson += ",\"siteName\":";
		
		if (getSiteName() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getSiteName());
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
		//Retrieve value of the Client Id property
		objectJson += ",\"clientId\":";
		
		if (getClientId() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getClientId());
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
		//Retrieve value of the Site Id property
		objectJson += ",\"siteId\":";
		
		if (getSiteId() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getSiteId());
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
//Retrieve value of the LOB of CMS Entry LOB relationship
objectJson += ",\"lOB\":";
		if (getLOB() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getLOB()).toEmbeddedJson();
			} catch(Exception e) {
				objectJson += "null";
			}
		}
		objectJson += "";
//Retrieve value of the CMS Entry of CMS Entry LOB relationship
objectJson += ",\"cMSEntry\":";
		if (getCMSEntry() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getCMSEntry()).toEmbeddedJson();
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
		//From value of the Employee Id property
		setEmployeeId(JsonUtils.getJsonInteger(jsonObject, "employeeId"));
		//From value of the Client Name property
		setClientName(JsonUtils.getJsonString(jsonObject, "clientName"));
		//From value of the LOB Name property
		setLOBName(JsonUtils.getJsonString(jsonObject, "lOBName"));
		//From value of the Site Name property
		setSiteName(JsonUtils.getJsonString(jsonObject, "siteName"));
		//From value of the Client Id property
		setClientId(JsonUtils.getJsonInteger(jsonObject, "clientId"));
		//From value of the Site Id property
		setSiteId(JsonUtils.getJsonInteger(jsonObject, "siteId"));

		
		// Source Relationships
		this.lOB = (LOB) JsonUtils.getJsonPerceroObject(jsonObject, "lOB");
		this.cMSEntry = (CMSEntry) JsonUtils.getJsonPerceroObject(jsonObject, "cMSEntry");


		// Target Relationships


	}
	
	@Override
	protected List<MappedClassMethodPair> getListSetters() {
		List<MappedClassMethodPair> listSetters = super.getListSetters();

		// Target Relationships

		
		return listSetters;
	}
}
