


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
public class _Super_Behavior extends BaseDataObject implements Serializable
{
	//////////////////////////////////////////////////////
	// VERSION
	//////////////////////////////////////////////////////
	@Override
	public String classVersion() {
		return "1.0.0";
	}

	
	/*
	Keys of Behavior
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
}

	//////////////////////////////////////////////////////
	// Target Relationships
	//////////////////////////////////////////////////////
	@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@OneToMany(fetch=FetchType.LAZY, targetEntity=BehaviorResponse.class, mappedBy="behavior", cascade=javax.persistence.CascadeType.REMOVE)
private List<BehaviorResponse> behaviorResponses;
public List<BehaviorResponse> getBehaviorResponses() {
	return this.behaviorResponses;
}

public void setBehaviorResponses(List<BehaviorResponse> value) {
	this.behaviorResponses = value;
}



	//////////////////////////////////////////////////////
	// Source Relationships
	//////////////////////////////////////////////////////
	
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@JoinColumn(name="SCORECARD_MEASURE_ID")
@org.hibernate.annotations.ForeignKey(name="FK_ScorecardMeasureOfBehavior")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private ScorecardMeasure scorecardMeasure;
public ScorecardMeasure getScorecardMeasure() {
	return this.scorecardMeasure;
}

public void setScorecardMeasure(ScorecardMeasure value) {
	this.scorecardMeasure = value;
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

				
		// Source Relationships
//Retrieve value of the Scorecard Measure of Behavior relationship
objectJson += ",\"scorecardMeasure\":";
		if (getScorecardMeasure() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getScorecardMeasure()).toEmbeddedJson();
			} catch(Exception e) {
				objectJson += "null";
			}
		}
		objectJson += "";

		
		// Target Relationships
//Retrieve value of the Behavior of Behavior Response relationship
objectJson += ",\"behaviorResponses\":[";
		
		if (getBehaviorResponses() != null) {
			int behaviorResponsesCounter = 0;
			for(BehaviorResponse nextBehaviorResponses : getBehaviorResponses()) {
				if (behaviorResponsesCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextBehaviorResponses).toEmbeddedJson();
					behaviorResponsesCounter++;
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
		//From value of the Name property
		setName(JsonUtils.getJsonString(jsonObject, "name"));

		
		// Source Relationships
		this.scorecardMeasure = (ScorecardMeasure) JsonUtils.getJsonPerceroObject(jsonObject, "scorecardMeasure");


		// Target Relationships
		this.behaviorResponses = (List<BehaviorResponse>) JsonUtils.getJsonListPerceroObject(jsonObject, "behaviorResponses");


	}
	
	@Override
	protected List<MappedClassMethodPair> getListSetters() {
		List<MappedClassMethodPair> listSetters = super.getListSetters();

		// Target Relationships
		listSetters.add(MappedClass.getFieldSetters(BehaviorResponse.class, "behavior"));

		
		return listSetters;
	}
}
