
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
import com.percero.agents.auth.vo.IUserRole;

import com.percero.agents.sync.vo.BaseDataObject;
import com.percero.serial.BDODeserializer;
import com.percero.serial.BDOSerializer;
import com.percero.serial.JsonUtils;

import com.pulse.mo.*;

/*
Entity Tags based on semantic requirements
*/
@com.percero.agents.sync.metadata.annotations.EntityInterface(interfaceClass=com.percero.agents.auth.vo.IUserRole.class)
@MappedSuperclass
public class _Super_UserRole extends BaseDataObject implements Serializable, com.percero.agents.auth.vo.IUserRole
{
	//////////////////////////////////////////////////////
	// VERSION
	//////////////////////////////////////////////////////
	@Override
	public String classVersion() {
		return "1.0.0";
	}

	
	/*
	Keys of UserRole
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
RoleName
Notes:
*/
@Column

@com.percero.agents.sync.metadata.annotations.PropertyInterface(entityInterfaceClass=com.percero.agents.auth.vo.IUserRole.class, propertyName="roleName",params={})
@com.percero.agents.sync.metadata.annotations.Externalize

private String roleName;

public String getRoleName() 
{
	return this.roleName;
}

public void setRoleName(String roleName)
{
	this.roleName = roleName;
}

	//////////////////////////////////////////////////////
	// Target Relationships
	//////////////////////////////////////////////////////
	

	//////////////////////////////////////////////////////
	// Source Relationships
	//////////////////////////////////////////////////////
	@com.percero.agents.sync.metadata.annotations.RelationshipInterface(entityInterfaceClass=com.percero.agents.auth.vo.IUserRole.class, sourceVarName="userAnchor")
@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@JoinColumn(name="pulseUser_ID")
@org.hibernate.annotations.ForeignKey(name="FK_PulseUserOfUserRole")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private PulseUser pulseUser;
public PulseUser getPulseUser() {
	return this.pulseUser;
}

public void setPulseUser(PulseUser value) {
	this.pulseUser = value;
}

	
	//////////////////////////////////////////////////////
	// JSON
	//////////////////////////////////////////////////////
	@Override
	public String retrieveJson(ObjectMapper objectMapper) {
		String objectJson = super.retrieveJson(objectMapper);

		// Properties		
		//Retrieve value of the Role Name property
		objectJson += ",\"roleName\":";
		
		if (getRoleName() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getRoleName());
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
//Retrieve value of the Pulse User of User Role relationship
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
		//From value of the Role Name property
		setRoleName(JsonUtils.getJsonString(jsonObject, "roleName"));

		
		// Source Relationships
		this.pulseUser = (PulseUser) JsonUtils.getJsonPerceroObject(jsonObject, "pulseUser");


		// Target Relationships


	}
	
	@Override
	protected List<MappedClassMethodPair> getListSetters() {
		List<MappedClassMethodPair> listSetters = super.getListSetters();

		// Target Relationships

		
		return listSetters;
	}
}
