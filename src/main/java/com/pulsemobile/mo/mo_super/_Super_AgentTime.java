
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
public class _Super_AgentTime extends BaseDataObject implements Serializable
{
	//////////////////////////////////////////////////////
	// VERSION
	//////////////////////////////////////////////////////
	@Override
	public String classVersion() {
		return "1.0.0";
	}

	
	/*
	Keys of AgentTime
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
StateName
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String stateName;

public String getStateName() 
{
	return this.stateName;
}

public void setStateName(String stateName)
{
	this.stateName = stateName;
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
ExternalID
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String externalID;

public String getExternalID() 
{
	return this.externalID;
}

public void setExternalID(String externalID)
{
	this.externalID = externalID;
}

	//////////////////////////////////////////////////////
	// Target Relationships
	//////////////////////////////////////////////////////
	@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@OneToMany(fetch=FetchType.LAZY, targetEntity=AgentTimeEntry.class, mappedBy="agentTime", cascade=javax.persistence.CascadeType.REMOVE)
private List<AgentTimeEntry> agentTimeEntries;
public List<AgentTimeEntry> getAgentTimeEntries() {
	return this.agentTimeEntries;
}

public void setAgentTimeEntries(List<AgentTimeEntry> value) {
	this.agentTimeEntries = value;
}



	//////////////////////////////////////////////////////
	// Source Relationships
	//////////////////////////////////////////////////////
	@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@JoinColumn(name="AgentId")
@org.hibernate.annotations.ForeignKey(name="FK_AgentOfAgentTime")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private Agent agent;
public Agent getAgent() {
	return this.agent;
}

public void setAgent(Agent value) {
	this.agent = value;
}@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@JoinColumn(name="PayrollDetailId")
@org.hibernate.annotations.ForeignKey(name="FK_PayrollDetailOfAgentTime")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private PayrollDetail payrollDetail;
public PayrollDetail getPayrollDetail() {
	return this.payrollDetail;
}

public void setPayrollDetail(PayrollDetail value) {
	this.payrollDetail = value;
}

	
	//////////////////////////////////////////////////////
	// JSON
	//////////////////////////////////////////////////////
	@Override
	public String retrieveJson(ObjectMapper objectMapper) {
		String objectJson = super.retrieveJson(objectMapper);

		// Properties		
		//Retrieve value of the State Name property
		objectJson += ",\"stateName\":";
		
		if (getStateName() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getStateName());
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
		//Retrieve value of the Total Time property
		objectJson += ",\"totalTime\":";
		if (getTotalTime() == null)
			objectJson += "null";
		else {
			objectJson += getTotalTime();
		}
		//Retrieve value of the External ID property
		objectJson += ",\"externalID\":";
		
		if (getExternalID() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getExternalID());
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
//Retrieve value of the Agent of Agent Time relationship
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
//Retrieve value of the Payroll Detail of Agent Time relationship
objectJson += ",\"payrollDetail\":";
		if (getPayrollDetail() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getPayrollDetail()).toEmbeddedJson();
			} catch(Exception e) {
				objectJson += "null";
			}
		}
		objectJson += "";

		
		// Target Relationships
//Retrieve value of the Agent Time of Agent Time Entry relationship
objectJson += ",\"agentTimeEntries\":[";
		
		if (getAgentTimeEntries() != null) {
			int agentTimeEntriesCounter = 0;
			for(AgentTimeEntry nextAgentTimeEntries : getAgentTimeEntries()) {
				if (agentTimeEntriesCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextAgentTimeEntries).toEmbeddedJson();
					agentTimeEntriesCounter++;
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
		//From value of the State Name property
		setStateName(JsonUtils.getJsonString(jsonObject, "stateName"));
		//From value of the Date property
		setDate(JsonUtils.getJsonString(jsonObject, "date"));
		//From value of the Total Time property
		setTotalTime(JsonUtils.getJsonDouble(jsonObject, "totalTime"));
		//From value of the External ID property
		setExternalID(JsonUtils.getJsonString(jsonObject, "externalID"));

		
		// Source Relationships
		this.agent = (Agent) JsonUtils.getJsonPerceroObject(jsonObject, "agent");
		this.payrollDetail = (PayrollDetail) JsonUtils.getJsonPerceroObject(jsonObject, "payrollDetail");


		// Target Relationships
		this.agentTimeEntries = (List<AgentTimeEntry>) JsonUtils.getJsonListPerceroObject(jsonObject, "agentTimeEntries");


	}
	
	@Override
	protected List<MappedClassMethodPair> getListSetters() {
		List<MappedClassMethodPair> listSetters = super.getListSetters();

		// Target Relationships
		listSetters.add(MappedClass.getFieldSetters(AgentTimeEntry.class, "agenttime"));

		
		return listSetters;
	}
}
