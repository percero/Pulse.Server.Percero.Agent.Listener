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

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.percero.agents.sync.metadata.MappedClass;
import com.percero.agents.sync.metadata.MappedClass.MappedClassMethodPair;

import org.hibernate.annotations.AccessType;

import com.pulse.mo.PulseUser;
import com.percero.agents.auth.vo.IUserIdentifier;

import com.percero.agents.sync.vo.BaseDataObject;
import com.percero.serial.BDODeserializer;
import com.percero.serial.BDOSerializer;
import com.percero.serial.JsonUtils;

import com.pulse.mo.*;

@MappedSuperclass
@com.percero.agents.sync.metadata.annotations.EntityInterface(interfaceClass=com.percero.agents.auth.vo.IUserIdentifier.class)
/*
@com.percero.agents.auth.vo.IUserIdentifierA(
						userIdentifierFieldName="value", userIdentifierFieldType="String"
				            , userIdentifierParadigm="email"
    					, 
    	userAnchorFieldName="pulseUser", userAnchorFieldType="com.pulse.mo.PulseUser"
)
*/
public class _Super_Email extends BaseDataObject implements Serializable, com.percero.agents.auth.vo.IUserIdentifier
{
	//////////////////////////////////////////////////////
	// VERSION
	//////////////////////////////////////////////////////
	@Override
	public String classVersion() {
		return "0.0.0.0";
	}


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
	@Column
    @com.percero.agents.sync.metadata.annotations.PropertyInterface(entityInterfaceClass=com.percero.agents.auth.vo.IUserIdentifier.class, propertyName="userIdentifier",
        params={
                    
                    @com.percero.agents.sync.metadata.annotations.PropertyInterfaceParam(name="paradigm", value="email")
        }
    )
    @com.percero.agents.sync.metadata.annotations.Externalize
	private String value;
	public String getValue() {
		return this.value;
	}
	public void setValue(String value)
	{
		this.value = value;
	}


	//////////////////////////////////////////////////////
	// Source Relationships
	//////////////////////////////////////////////////////
    @com.percero.agents.sync.metadata.annotations.RelationshipInterface(entityInterfaceClass=com.percero.agents.auth.vo.IUserIdentifier.class, sourceVarName="userAnchor")
    @com.percero.agents.sync.metadata.annotations.Externalize
	@JsonSerialize(using=BDOSerializer.class)
	@JsonDeserialize(using=BDODeserializer.class)
	@JoinColumn(name="pulseUser_ID")
	@org.hibernate.annotations.ForeignKey(name="FK_PulseUser_pulseUser_TO_Email")
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	private PulseUser pulseUser;
	public PulseUser getPulseUser() {
		return this.pulseUser;
	}
	public void setPulseUser(PulseUser value) {
		this.pulseUser = value;
	}

	/*
	public com.percero.agents.auth.vo.IUserAnchor getUserAnchor()
	{
		return (com.percero.agents.auth.vo.IUserAnchor) pulseUser;
	}
	public void setUserAnchor(com.percero.agents.auth.vo.IUserAnchor value)
	{
		this.pulseUser = (PulseUser)value;
	}
	*/

	//////////////////////////////////////////////////////
	// Target Relationships
	//////////////////////////////////////////////////////


	
	//////////////////////////////////////////////////////
	// JSON
	//////////////////////////////////////////////////////
	@Override
	public String retrieveJson(ObjectMapper objectMapper) {
		String objectJson = super.retrieveJson(objectMapper);

		// Properties
		objectJson += ",\"value\":";
		if (getValue() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getValue());
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
		objectJson += ",\"pulseUser\":";
		if (getPulseUser() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getPulseUser()).toEmbeddedJson();
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
		setValue(JsonUtils.getJsonString(jsonObject, "value"));

		// Source Relationships
        this.pulseUser = JsonUtils.getJsonPerceroObject(jsonObject, "pulseUser");

		// Target Relationships
	}

	@Override
	protected List<MappedClassMethodPair> getListSetters() {
		List<MappedClassMethodPair> listSetters = super.getListSetters();

		// Target Relationships
	
		return listSetters;
	}
}