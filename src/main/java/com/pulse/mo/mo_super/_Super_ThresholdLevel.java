
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
public class _Super_ThresholdLevel extends BaseDataObject implements Serializable
{
	//////////////////////////////////////////////////////
	// VERSION
	//////////////////////////////////////////////////////
	@Override
	public String classVersion() {
		return "1.0.0";
	}

	
	/*
	Keys of ThresholdLevel
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
StartExpression
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String startExpression;

public String getStartExpression() 
{
	return this.startExpression;
}

public void setStartExpression(String startExpression)
{
	this.startExpression = startExpression;
}/*
StartValue
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String startValue;

public String getStartValue() 
{
	return this.startValue;
}

public void setStartValue(String startValue)
{
	this.startValue = startValue;
}/*
EndExpression
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String endExpression;

public String getEndExpression() 
{
	return this.endExpression;
}

public void setEndExpression(String endExpression)
{
	this.endExpression = endExpression;
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
ExpressionOperator
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String expressionOperator;

public String getExpressionOperator() 
{
	return this.expressionOperator;
}

public void setExpressionOperator(String expressionOperator)
{
	this.expressionOperator = expressionOperator;
}/*
Color
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String color;

public String getColor() 
{
	return this.color;
}

public void setColor(String color)
{
	this.color = color;
}/*
EndValue
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String endValue;

public String getEndValue() 
{
	return this.endValue;
}

public void setEndValue(String endValue)
{
	this.endValue = endValue;
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
@JoinColumn(name="ThresholdScaleId")
@org.hibernate.annotations.ForeignKey(name="FK_ThresholdScaleOfThresholdLevel")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private ThresholdScale thresholdScale;
public ThresholdScale getThresholdScale() {
	return this.thresholdScale;
}

public void setThresholdScale(ThresholdScale value) {
	this.thresholdScale = value;
}

	
	//////////////////////////////////////////////////////
	// JSON
	//////////////////////////////////////////////////////
	@Override
	public String retrieveJson(ObjectMapper objectMapper) {
		String objectJson = super.retrieveJson(objectMapper);

		// Properties		
		//Retrieve value of the Start Expression property
		objectJson += ",\"startExpression\":";
		
		if (getStartExpression() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getStartExpression());
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
		//Retrieve value of the Start Value property
		objectJson += ",\"startValue\":";
		
		if (getStartValue() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getStartValue());
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
		//Retrieve value of the End Expression property
		objectJson += ",\"endExpression\":";
		
		if (getEndExpression() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getEndExpression());
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
		//Retrieve value of the Expression Operator property
		objectJson += ",\"expressionOperator\":";
		
		if (getExpressionOperator() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getExpressionOperator());
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
		//Retrieve value of the Color property
		objectJson += ",\"color\":";
		
		if (getColor() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getColor());
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
		//Retrieve value of the End Value property
		objectJson += ",\"endValue\":";
		
		if (getEndValue() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getEndValue());
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
//Retrieve value of the Threshold Scale of Threshold Level relationship
objectJson += ",\"thresholdScale\":";
		if (getThresholdScale() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getThresholdScale()).toEmbeddedJson();
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
		//From value of the Start Expression property
		setStartExpression(JsonUtils.getJsonString(jsonObject, "startExpression"));
		//From value of the Start Value property
		setStartValue(JsonUtils.getJsonString(jsonObject, "startValue"));
		//From value of the End Expression property
		setEndExpression(JsonUtils.getJsonString(jsonObject, "endExpression"));
		//From value of the External ID property
		setExternalID(JsonUtils.getJsonString(jsonObject, "externalID"));
		//From value of the Expression Operator property
		setExpressionOperator(JsonUtils.getJsonString(jsonObject, "expressionOperator"));
		//From value of the Color property
		setColor(JsonUtils.getJsonString(jsonObject, "color"));
		//From value of the End Value property
		setEndValue(JsonUtils.getJsonString(jsonObject, "endValue"));

		
		// Source Relationships
		this.thresholdScale = (ThresholdScale) JsonUtils.getJsonPerceroObject(jsonObject, "thresholdScale");


		// Target Relationships


	}
	
	@Override
	protected List<MappedClassMethodPair> getListSetters() {
		List<MappedClassMethodPair> listSetters = super.getListSetters();

		// Target Relationships

		
		return listSetters;
	}
}
