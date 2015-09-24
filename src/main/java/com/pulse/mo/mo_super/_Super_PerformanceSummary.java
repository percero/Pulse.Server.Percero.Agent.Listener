
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
public class _Super_PerformanceSummary extends BaseDataObject implements Serializable
{
	//////////////////////////////////////////////////////
	// VERSION
	//////////////////////////////////////////////////////
	@Override
	public String classVersion() {
		return "1.0.0";
	}

	
	/*
	Keys of PerformanceSummary
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
WeeklyOverviewScore
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String weeklyOverviewScore;

public String getWeeklyOverviewScore() 
{
	return this.weeklyOverviewScore;
}

public void setWeeklyOverviewScore(String weeklyOverviewScore)
{
	this.weeklyOverviewScore = weeklyOverviewScore;
}/*
CurrentMTDScore
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String currentMTDScore;

public String getCurrentMTDScore() 
{
	return this.currentMTDScore;
}

public void setCurrentMTDScore(String currentMTDScore)
{
	this.currentMTDScore = currentMTDScore;
}/*
WeeklyTrend
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String weeklyTrend;

public String getWeeklyTrend() 
{
	return this.weeklyTrend;
}

public void setWeeklyTrend(String weeklyTrend)
{
	this.weeklyTrend = weeklyTrend;
}/*
WekendDate
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Date wekendDate;

public Date getWekendDate() 
{
	return this.wekendDate;
}

public void setWekendDate(Date wekendDate)
{
	this.wekendDate = wekendDate;
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
}/*
PreviousMTDTrend
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String previousMTDTrend;

public String getPreviousMTDTrend() 
{
	return this.previousMTDTrend;
}

public void setPreviousMTDTrend(String previousMTDTrend)
{
	this.previousMTDTrend = previousMTDTrend;
}/*
PreviousMTDScore
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String previousMTDScore;

public String getPreviousMTDScore() 
{
	return this.previousMTDScore;
}

public void setPreviousMTDScore(String previousMTDScore)
{
	this.previousMTDScore = previousMTDScore;
}/*
CurrentMTDTrend
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String currentMTDTrend;

public String getCurrentMTDTrend() 
{
	return this.currentMTDTrend;
}

public void setCurrentMTDTrend(String currentMTDTrend)
{
	this.currentMTDTrend = currentMTDTrend;
}

	//////////////////////////////////////////////////////
	// Target Relationships
	//////////////////////////////////////////////////////
	@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@OneToMany(fetch=FetchType.LAZY, targetEntity=Agent.class, mappedBy="performanceSummary", cascade=javax.persistence.CascadeType.REMOVE)
private List<Agent> agents;
public List<Agent> getAgents() {
	return this.agents;
}

public void setAgents(List<Agent> value) {
	this.agents = value;
}

@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@OneToMany(fetch=FetchType.LAZY, targetEntity=Attachment.class, mappedBy="performanceSummary", cascade=javax.persistence.CascadeType.REMOVE)
private List<Attachment> attachments;
public List<Attachment> getAttachments() {
	return this.attachments;
}

public void setAttachments(List<Attachment> value) {
	this.attachments = value;
}

@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@OneToMany(fetch=FetchType.LAZY, targetEntity=QualityEvaluation.class, mappedBy="performanceSummary", cascade=javax.persistence.CascadeType.REMOVE)
private List<QualityEvaluation> qualityEvaluations;
public List<QualityEvaluation> getQualityEvaluations() {
	return this.qualityEvaluations;
}

public void setQualityEvaluations(List<QualityEvaluation> value) {
	this.qualityEvaluations = value;
}



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
		//Retrieve value of the Weekly Overview Score property
		objectJson += ",\"weeklyOverviewScore\":";
		
		if (getWeeklyOverviewScore() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getWeeklyOverviewScore());
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
		//Retrieve value of the Current MTD Score property
		objectJson += ",\"currentMTDScore\":";
		
		if (getCurrentMTDScore() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getCurrentMTDScore());
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
		//Retrieve value of the Weekly Trend property
		objectJson += ",\"weeklyTrend\":";
		
		if (getWeeklyTrend() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getWeeklyTrend());
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
		//Retrieve value of the Wekend Date property
		objectJson += ",\"wekendDate\":";
		if (getWekendDate() == null)
			objectJson += "null";
		else {
			objectJson += getWekendDate().getTime();
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
		//Retrieve value of the Previous MTD Trend property
		objectJson += ",\"previousMTDTrend\":";
		
		if (getPreviousMTDTrend() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getPreviousMTDTrend());
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
		//Retrieve value of the Previous MTD Score property
		objectJson += ",\"previousMTDScore\":";
		
		if (getPreviousMTDScore() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getPreviousMTDScore());
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
		//Retrieve value of the Current MTD Trend property
		objectJson += ",\"currentMTDTrend\":";
		
		if (getCurrentMTDTrend() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getCurrentMTDTrend());
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
//Retrieve value of the Performance Summary of Agent relationship
objectJson += ",\"agents\":[";
		
		if (getAgents() != null) {
			int agentsCounter = 0;
			for(Agent nextAgents : getAgents()) {
				if (agentsCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextAgents).toEmbeddedJson();
					agentsCounter++;
				} catch(Exception e) {
					// Do nothing.
				}
			}
		}
		objectJson += "]";
//Retrieve value of the Performance Summary of Attachment relationship
objectJson += ",\"attachments\":[";
		
		if (getAttachments() != null) {
			int attachmentsCounter = 0;
			for(Attachment nextAttachments : getAttachments()) {
				if (attachmentsCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextAttachments).toEmbeddedJson();
					attachmentsCounter++;
				} catch(Exception e) {
					// Do nothing.
				}
			}
		}
		objectJson += "]";
//Retrieve value of the Performance Summary of Quality Evaluation relationship
objectJson += ",\"qualityEvaluations\":[";
		
		if (getQualityEvaluations() != null) {
			int qualityEvaluationsCounter = 0;
			for(QualityEvaluation nextQualityEvaluations : getQualityEvaluations()) {
				if (qualityEvaluationsCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextQualityEvaluations).toEmbeddedJson();
					qualityEvaluationsCounter++;
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
		//From value of the Weekly Overview Score property
		setWeeklyOverviewScore(JsonUtils.getJsonString(jsonObject, "weeklyOverviewScore"));
		//From value of the Current MTD Score property
		setCurrentMTDScore(JsonUtils.getJsonString(jsonObject, "currentMTDScore"));
		//From value of the Weekly Trend property
		setWeeklyTrend(JsonUtils.getJsonString(jsonObject, "weeklyTrend"));
		//From value of the Wekend Date property
		setWekendDate(JsonUtils.getJsonDate(jsonObject, "wekendDate"));
		//From value of the External ID property
		setExternalID(JsonUtils.getJsonString(jsonObject, "externalID"));
		//From value of the Previous MTD Trend property
		setPreviousMTDTrend(JsonUtils.getJsonString(jsonObject, "previousMTDTrend"));
		//From value of the Previous MTD Score property
		setPreviousMTDScore(JsonUtils.getJsonString(jsonObject, "previousMTDScore"));
		//From value of the Current MTD Trend property
		setCurrentMTDTrend(JsonUtils.getJsonString(jsonObject, "currentMTDTrend"));

		
		// Source Relationships


		// Target Relationships
		this.agents = (List<Agent>) JsonUtils.getJsonListPerceroObject(jsonObject, "agents");
		this.attachments = (List<Attachment>) JsonUtils.getJsonListPerceroObject(jsonObject, "attachments");
		this.qualityEvaluations = (List<QualityEvaluation>) JsonUtils.getJsonListPerceroObject(jsonObject, "qualityEvaluations");


	}
	
	@Override
	protected List<MappedClassMethodPair> getListSetters() {
		List<MappedClassMethodPair> listSetters = super.getListSetters();

		// Target Relationships
		listSetters.add(MappedClass.getFieldSetters(Agent.class, "performancesummary"));
		listSetters.add(MappedClass.getFieldSetters(Attachment.class, "performancesummary"));
		listSetters.add(MappedClass.getFieldSetters(QualityEvaluation.class, "performancesummary"));

		
		return listSetters;
	}
}
