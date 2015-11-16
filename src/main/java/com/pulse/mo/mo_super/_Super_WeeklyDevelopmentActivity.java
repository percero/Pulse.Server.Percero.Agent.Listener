
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
public class _Super_WeeklyDevelopmentActivity extends BaseDataObject implements Serializable
{
	//////////////////////////////////////////////////////
	// VERSION
	//////////////////////////////////////////////////////
	@Override
	public String classVersion() {
		return "1.0.0";
	}

	
	/*
	Keys of WeeklyDevelopmentActivity
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
	

	//////////////////////////////////////////////////////
	// Target Relationships
	//////////////////////////////////////////////////////
	

	//////////////////////////////////////////////////////
	// Source Relationships
	//////////////////////////////////////////////////////
	@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@JoinColumn(name="DEVELOPMENT_ACTIVITY_ID")
@org.hibernate.annotations.ForeignKey(name="FK_DevelopmentActivityOfWeeklyDevelopmentActivity")
@ManyToOne(fetch=FetchType.LAZY, optional=true)
private DevelopmentActivity developmentActivity;
public DevelopmentActivity getDevelopmentActivity() {
	return this.developmentActivity;
}

public void setDevelopmentActivity(DevelopmentActivity value) {
	this.developmentActivity = value;
}@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@JoinColumn(name="SCORECARD_WEEKLY_RESULT_ID")
@org.hibernate.annotations.ForeignKey(name="FK_ScorecardWeeklyResultOfWeeklyDevelopmentActivity")
@ManyToOne(fetch=FetchType.LAZY, optional=true)
private ScorecardWeeklyResult scorecardWeeklyResult;
public ScorecardWeeklyResult getScorecardWeeklyResult() {
	return this.scorecardWeeklyResult;
}

public void setScorecardWeeklyResult(ScorecardWeeklyResult value) {
	this.scorecardWeeklyResult = value;
}

	
	//////////////////////////////////////////////////////
	// JSON
	//////////////////////////////////////////////////////
	@Override
	public String retrieveJson(ObjectMapper objectMapper) {
		String objectJson = super.retrieveJson(objectMapper);

		// Properties		

				
		// Source Relationships
//Retrieve value of the Development Activity of Weekly Development Activity relationship
objectJson += ",\"developmentActivity\":";
		if (getDevelopmentActivity() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getDevelopmentActivity()).toEmbeddedJson();
			} catch(Exception e) {
				objectJson += "null";
			}
		}
		objectJson += "";
//Retrieve value of the Scorecard Weekly Result of Weekly Development Activity relationship
objectJson += ",\"scorecardWeeklyResult\":";
		if (getScorecardWeeklyResult() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getScorecardWeeklyResult()).toEmbeddedJson();
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

		
		// Source Relationships
		this.developmentActivity = (DevelopmentActivity) JsonUtils.getJsonPerceroObject(jsonObject, "developmentActivity");
		this.scorecardWeeklyResult = (ScorecardWeeklyResult) JsonUtils.getJsonPerceroObject(jsonObject, "scorecardWeeklyResult");


		// Target Relationships


	}
	
	@Override
	protected List<MappedClassMethodPair> getListSetters() {
		List<MappedClassMethodPair> listSetters = super.getListSetters();

		// Target Relationships

		
		return listSetters;
	}
}
