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

import com.pulse.mo.TeamLeader;
import com.pulse.mo.Email;
import com.pulse.mo.UserRole;
import com.percero.agents.auth.vo.IUserAnchor;

import com.percero.agents.sync.vo.BaseDataObject;
import com.percero.serial.BDODeserializer;
import com.percero.serial.BDOSerializer;
import com.percero.serial.JsonUtils;

import com.pulse.mo.*;

@MappedSuperclass
@com.percero.agents.sync.metadata.annotations.EntityInterface(interfaceClass=com.percero.agents.auth.vo.IUserAnchor.class)
/*
@com.percero.agents.auth.vo.IUserAnchorA(
						lastNameFieldName="lastName", lastNameFieldType="String"
				            
					, 
	firstNameFieldName="firstName", firstNameFieldType="String"
				            
					, 
	userIdFieldName="userId", userIdFieldType="String"
				            
        				, 
    	identifiersFieldName="emails", identifiersFieldType="com.pulse.mo.Email"
        				, 
    	rolesFieldName="roles", rolesFieldType="com.pulse.mo.UserRole"
)
*/
public class _Super_PulseUser extends BaseDataObject implements Serializable, com.percero.agents.auth.vo.IUserAnchor
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
    @com.percero.agents.sync.metadata.annotations.PropertyInterface(entityInterfaceClass=com.percero.agents.auth.vo.IUserAnchor.class, propertyName="lastName",
        params={
        }
    )
    @com.percero.agents.sync.metadata.annotations.Externalize
	private String lastName;
	public String getLastName() {
		return this.lastName;
	}
	public void setLastName(String value)
	{
		this.lastName = value;
	}

	@Column
    @com.percero.agents.sync.metadata.annotations.PropertyInterface(entityInterfaceClass=com.percero.agents.auth.vo.IUserAnchor.class, propertyName="firstName",
        params={
        }
    )
    @com.percero.agents.sync.metadata.annotations.Externalize
	private String firstName;
	public String getFirstName() {
		return this.firstName;
	}
	public void setFirstName(String value)
	{
		this.firstName = value;
	}

	@Column
    @com.percero.agents.sync.metadata.annotations.PropertyInterface(entityInterfaceClass=com.percero.agents.auth.vo.IUserAnchor.class, propertyName="userId",
        params={
        }
    )
    @com.percero.agents.sync.metadata.annotations.Externalize
	private String userId;
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String value)
	{
		this.userId = value;
	}

	@Column
    @com.percero.agents.sync.metadata.annotations.Externalize
	private String userIcon;
	public String getUserIcon() {
		return this.userIcon;
	}
	public void setUserIcon(String value)
	{
		this.userIcon = value;
	}

	@Column
    @com.percero.agents.sync.metadata.annotations.Externalize
	private String userName;
	public String getUserName() {
		return this.userName;
	}
	public void setUserName(String value)
	{
		this.userName = value;
	}


	//////////////////////////////////////////////////////
	// Source Relationships
	//////////////////////////////////////////////////////
    @com.percero.agents.sync.metadata.annotations.Externalize
	@JsonSerialize(using=BDOSerializer.class)
	@JsonDeserialize(using=BDODeserializer.class)
	@JoinColumn(name="teamLeader_ID")
	@org.hibernate.annotations.ForeignKey(name="FK_TeamLeader_teamLeader_TO_PulseUser")
	@OneToOne(fetch=FetchType.LAZY)
	private TeamLeader teamLeader;
	public TeamLeader getTeamLeader() {
		return this.teamLeader;
	}
	public void setTeamLeader(TeamLeader value) {
		this.teamLeader = value;
	}


	//////////////////////////////////////////////////////
	// Target Relationships
	//////////////////////////////////////////////////////
    @com.percero.agents.sync.metadata.annotations.Externalize
	@JsonSerialize(contentUsing=BDOSerializer.class)
	@JsonDeserialize(contentUsing=BDODeserializer.class)
	@OneToMany(fetch=FetchType.LAZY, targetEntity=Email.class, mappedBy="pulseUser", cascade=javax.persistence.CascadeType.REMOVE)
	private List<Email> emails;
	public List<Email> getEmails() {
		return this.emails;
	}
	public void setEmails(List<Email> value) {
		this.emails = value;
	}

	/*
	public List<com.percero.agents.auth.vo.IUserAnchor> getIdentifiers()
	{
		return (List<com.percero.agents.auth.vo.IUserAnchor>)emails;
	}
	public void setIdentifiers(List<com.percero.agents.auth.vo.IUserAnchor> value )
	{
		this.emails = (List<Email>) value;
	}
	*/
    @com.percero.agents.sync.metadata.annotations.Externalize
	@JsonSerialize(contentUsing=BDOSerializer.class)
	@JsonDeserialize(contentUsing=BDODeserializer.class)
	@OneToMany(fetch=FetchType.LAZY, targetEntity=UserRole.class, mappedBy="pulseUser", cascade=javax.persistence.CascadeType.REMOVE)
	private List<UserRole> roles;
	public List<UserRole> getRoles() {
		return this.roles;
	}
	public void setRoles(List<UserRole> value) {
		this.roles = value;
	}



	
	//////////////////////////////////////////////////////
	// JSON
	//////////////////////////////////////////////////////
	@Override
	public String retrieveJson(ObjectMapper objectMapper) {
		String objectJson = super.retrieveJson(objectMapper);

		// Properties
		objectJson += ",\"lastName\":";
		if (getLastName() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getLastName());
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

		objectJson += ",\"firstName\":";
		if (getFirstName() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getFirstName());
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

		objectJson += ",\"userId\":";
		if (getUserId() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getUserId());
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

		objectJson += ",\"userIcon\":";
		if (getUserIcon() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getUserIcon());
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

		objectJson += ",\"userName\":";
		if (getUserName() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getUserName());
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
		objectJson += ",\"teamLeader\":";
		if (getTeamLeader() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getTeamLeader()).toEmbeddedJson();
			} catch(Exception e) {
				objectJson += "null";
			}
		}
		objectJson += "";

		// Target Relationships
		objectJson += ",\"emails\":[";
		if (getEmails() != null) {
			int emailsCounter = 0;
			for(Email nextEmails : getEmails()) {
				if (emailsCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextEmails).toEmbeddedJson();
					emailsCounter++;
				} catch(Exception e) {
					// Do nothing.
				}
			}
		}
		objectJson += "]";

		objectJson += ",\"roles\":[";
		if (getRoles() != null) {
			int rolesCounter = 0;
			for(UserRole nextRoles : getRoles()) {
				if (rolesCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextRoles).toEmbeddedJson();
					rolesCounter++;
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
		setLastName(JsonUtils.getJsonString(jsonObject, "lastName"));
		setFirstName(JsonUtils.getJsonString(jsonObject, "firstName"));
		setUserId(JsonUtils.getJsonString(jsonObject, "userId"));
		setUserIcon(JsonUtils.getJsonString(jsonObject, "userIcon"));
		setUserName(JsonUtils.getJsonString(jsonObject, "userName"));

		// Source Relationships
        this.teamLeader = JsonUtils.getJsonPerceroObject(jsonObject, "teamLeader");

		// Target Relationships
		this.emails = (List<Email>) JsonUtils.getJsonListPerceroObject(jsonObject, "emails");
		this.roles = (List<UserRole>) JsonUtils.getJsonListPerceroObject(jsonObject, "roles");
	}

	@Override
	protected List<MappedClassMethodPair> getListSetters() {
		List<MappedClassMethodPair> listSetters = super.getListSetters();

		// Target Relationships
		listSetters.add(MappedClass.getFieldSetters(Email.class, "pulseUser"));
		listSetters.add(MappedClass.getFieldSetters(UserRole.class, "pulseUser"));
	
		return listSetters;
	}
}