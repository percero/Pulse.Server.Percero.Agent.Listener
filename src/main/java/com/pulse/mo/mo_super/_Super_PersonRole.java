package com.pulse.mo.mo_super;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.google.gson.JsonObject;
import com.percero.agents.sync.metadata.MappedClass.MappedClassMethodPair;
import com.percero.agents.sync.vo.BaseDataObject;
import com.percero.serial.BDODeserializer;
import com.percero.serial.BDOSerializer;
import com.percero.serial.JsonUtils;
import com.pulse.mo.Person;

@MappedSuperclass
@com.percero.agents.sync.metadata.annotations.EntityInterface(interfaceClass=com.percero.agents.auth.vo.IUserRole.class)
/*
@com.percero.agents.auth.vo.IUserRoleA(
						roleNameFieldName="roleName", roleNameFieldType="String"
				            
    					, 
    	userAnchorFieldName="person", userAnchorFieldType="com.pulse.mo.Person"
)
*/
public class _Super_PersonRole extends BaseDataObject implements Serializable, com.percero.agents.auth.vo.IUserRole
{
	//////////////////////////////////////////////////////
	// VERSION
	//////////////////////////////////////////////////////
	@Override
	public String classVersion() {
		return "D9FB0AF0-DA00-1650-CFC9-0A632EB72634";
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
    @com.percero.agents.sync.metadata.annotations.PropertyInterface(entityInterfaceClass=com.percero.agents.auth.vo.IUserRole.class, propertyName="roleName",
        params={
        }
    )
    @com.percero.agents.sync.metadata.annotations.Externalize
	private String roleName;
	public String getRoleName() {
		return this.roleName;
	}
	public void setRoleName(String value)
	{
		this.roleName = value;
	}


	//////////////////////////////////////////////////////
	// Source Relationships
	//////////////////////////////////////////////////////
    @com.percero.agents.sync.metadata.annotations.RelationshipInterface(entityInterfaceClass=com.percero.agents.auth.vo.IUserRole.class, sourceVarName="userAnchor")
    @com.percero.agents.sync.metadata.annotations.Externalize
	@JsonSerialize(using=BDOSerializer.class)
	@JsonDeserialize(using=BDODeserializer.class)
	@JoinColumn(name="person_ID")
	@org.hibernate.annotations.ForeignKey(name="FK_Person_person_TO_PersonRole")
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	private Person person;
	public Person getPerson() {
		return this.person;
	}
	public void setPerson(Person value) {
		this.person = value;
	}

	/*
	public com.percero.agents.auth.vo.IUserAnchor getUserAnchor()
	{
		return (com.percero.agents.auth.vo.IUserAnchor) person;
	}
	public void setUserAnchor(com.percero.agents.auth.vo.IUserAnchor value)
	{
		this.person = (Person)value;
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
		objectJson += ",\"person\":";
		if (getPerson() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getPerson()).toEmbeddedJson();
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
		setRoleName(JsonUtils.getJsonString(jsonObject, "roleName"));

		// Source Relationships
        this.person = JsonUtils.getJsonPerceroObject(jsonObject, "person");

		// Target Relationships
	}

	@Override
	protected List<MappedClassMethodPair> getListSetters() {
		List<MappedClassMethodPair> listSetters = super.getListSetters();

		// Target Relationships
	
		return listSetters;
	}
}