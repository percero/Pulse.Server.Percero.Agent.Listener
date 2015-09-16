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
import javax.persistence.OneToMany;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.google.gson.JsonObject;
import com.percero.agents.sync.metadata.MappedClass;
import com.percero.agents.sync.metadata.MappedClass.MappedClassMethodPair;
import com.percero.agents.sync.vo.BaseDataObject;
import com.percero.serial.BDODeserializer;
import com.percero.serial.BDOSerializer;
import com.percero.serial.JsonUtils;
import com.pulse.mo.Alert;
import com.pulse.mo.CoachingSession;
import com.pulse.mo.Email;
import com.pulse.mo.Notification;
import com.pulse.mo.Person;
import com.pulse.mo.PersonRole;

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
    	rolesFieldName="roles", rolesFieldType="com.pulse.mo.PersonRole"
        				, 
    	identifiersFieldName="emails", identifiersFieldType="com.pulse.mo.Email"
)
*/
public class _Super_Person extends BaseDataObject implements Serializable, com.percero.agents.auth.vo.IUserAnchor
{
	//////////////////////////////////////////////////////
	// VERSION
	//////////////////////////////////////////////////////
	@Override
	public String classVersion() {
		return "50F60E5B-BB4F-E50F-005F-0A6256752CEA";
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
	@com.percero.agents.sync.metadata.annotations.Externalize(useLazyLoading=false)
	@JsonSerialize(using=BDOSerializer.class)
	@JsonDeserialize(using=BDODeserializer.class)
	@JoinColumn(name="managedBy_ID")
	@org.hibernate.annotations.ForeignKey(name="FK_Person_managedBy_TO_Person")
	@ManyToOne(fetch=FetchType.LAZY)
	private Person managedBy;
	public Person getManagedBy() {
		return this.managedBy;
	}
	public void setManagedBy(Person value) {
		this.managedBy = value;
	}


	//////////////////////////////////////////////////////
	// Target Relationships
	//////////////////////////////////////////////////////
    @com.percero.agents.sync.metadata.annotations.Externalize
	@JsonSerialize(contentUsing=BDOSerializer.class)
	@JsonDeserialize(contentUsing=BDODeserializer.class)
	@OneToMany(fetch=FetchType.LAZY, targetEntity=Notification.class, mappedBy="person", cascade=javax.persistence.CascadeType.REMOVE)
	private List<Notification> notifictaions;
	public List<Notification> getNotifictaions() {
		return this.notifictaions;
	}
	public void setNotifictaions(List<Notification> value) {
		this.notifictaions = value;
	}

    @com.percero.agents.sync.metadata.annotations.Externalize
	@JsonSerialize(contentUsing=BDOSerializer.class)
	@JsonDeserialize(contentUsing=BDODeserializer.class)
	@OneToMany(fetch=FetchType.LAZY, targetEntity=Alert.class, mappedBy="person", cascade=javax.persistence.CascadeType.REMOVE)
	private List<Alert> alerts;
	public List<Alert> getAlerts() {
		return this.alerts;
	}
	public void setAlerts(List<Alert> value) {
		this.alerts = value;
	}

    @com.percero.agents.sync.metadata.annotations.Externalize
	@JsonSerialize(contentUsing=BDOSerializer.class)
	@JsonDeserialize(contentUsing=BDODeserializer.class)
	@OneToMany(fetch=FetchType.LAZY, targetEntity=Alert.class, mappedBy="agent", cascade=javax.persistence.CascadeType.REMOVE)
	private List<Alert> agentAlerts;
	public List<Alert> getAgentAlerts() {
		return this.agentAlerts;
	}
	public void setAgentAlerts(List<Alert> value) {
		this.agentAlerts = value;
	}

    @com.percero.agents.sync.metadata.annotations.Externalize
	@JsonSerialize(contentUsing=BDOSerializer.class)
	@JsonDeserialize(contentUsing=BDODeserializer.class)
	@OneToMany(fetch=FetchType.LAZY, targetEntity=PersonRole.class, mappedBy="person", cascade=javax.persistence.CascadeType.REMOVE)
	private List<PersonRole> roles;
	public List<PersonRole> getRoles() {
		return this.roles;
	}
	public void setRoles(List<PersonRole> value) {
		this.roles = value;
	}

    @com.percero.agents.sync.metadata.annotations.Externalize
	@JsonSerialize(contentUsing=BDOSerializer.class)
	@JsonDeserialize(contentUsing=BDODeserializer.class)
	@OneToMany(fetch=FetchType.LAZY, targetEntity=Email.class, mappedBy="person", cascade=javax.persistence.CascadeType.REMOVE)
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
	@OneToMany(fetch=FetchType.LAZY, targetEntity=CoachingSession.class, mappedBy="agent", cascade=javax.persistence.CascadeType.REMOVE)
	private List<CoachingSession> coachingSessions;
	public List<CoachingSession> getCoachingSessions() {
		return this.coachingSessions;
	}
	public void setCoachingSessions(List<CoachingSession> value) {
		this.coachingSessions = value;
	}

    @com.percero.agents.sync.metadata.annotations.Externalize
	@JsonSerialize(contentUsing=BDOSerializer.class)
	@JsonDeserialize(contentUsing=BDODeserializer.class)
	@OneToMany(fetch=FetchType.LAZY, targetEntity=Person.class, mappedBy="managedBy", cascade=javax.persistence.CascadeType.REMOVE)
	private List<Person> manages;
	public List<Person> getManages() {
		return this.manages;
	}
	public void setManages(List<Person> value) {
		this.manages = value;
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
		objectJson += ",\"managedBy\":";
		if (getManagedBy() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getManagedBy()).toEmbeddedJson();
			} catch(Exception e) {
				objectJson += "null";
			}
		}
		objectJson += "";

		// Target Relationships
		objectJson += ",\"notifictaions\":[";
		if (getNotifictaions() != null) {
			int notifictaionsCounter = 0;
			for(Notification nextNotifictaions : getNotifictaions()) {
				if (notifictaionsCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextNotifictaions).toEmbeddedJson();
					notifictaionsCounter++;
				} catch(Exception e) {
					// Do nothing.
				}
			}
		}
		objectJson += "]";

		objectJson += ",\"alerts\":[";
		if (getAlerts() != null) {
			int alertsCounter = 0;
			for(Alert nextAlerts : getAlerts()) {
				if (alertsCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextAlerts).toEmbeddedJson();
					alertsCounter++;
				} catch(Exception e) {
					// Do nothing.
				}
			}
		}
		objectJson += "]";

		objectJson += ",\"agentAlerts\":[";
		if (getAgentAlerts() != null) {
			int agentAlertsCounter = 0;
			for(Alert nextAgentAlerts : getAgentAlerts()) {
				if (agentAlertsCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextAgentAlerts).toEmbeddedJson();
					agentAlertsCounter++;
				} catch(Exception e) {
					// Do nothing.
				}
			}
		}
		objectJson += "]";

		objectJson += ",\"roles\":[";
		if (getRoles() != null) {
			int rolesCounter = 0;
			for(PersonRole nextRoles : getRoles()) {
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

		objectJson += ",\"coachingSessions\":[";
		if (getCoachingSessions() != null) {
			int coachingSessionsCounter = 0;
			for(CoachingSession nextCoachingSessions : getCoachingSessions()) {
				if (coachingSessionsCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextCoachingSessions).toEmbeddedJson();
					coachingSessionsCounter++;
				} catch(Exception e) {
					// Do nothing.
				}
			}
		}
		objectJson += "]";

		objectJson += ",\"manages\":[";
		if (getManages() != null) {
			int managesCounter = 0;
			for(Person nextManages : getManages()) {
				if (managesCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextManages).toEmbeddedJson();
					managesCounter++;
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
        this.managedBy = JsonUtils.getJsonPerceroObject(jsonObject, "managedBy");

		// Target Relationships
		this.notifictaions = (List<Notification>) JsonUtils.getJsonListPerceroObject(jsonObject, "notifictaions");
		this.alerts = (List<Alert>) JsonUtils.getJsonListPerceroObject(jsonObject, "alerts");
		this.agentAlerts = (List<Alert>) JsonUtils.getJsonListPerceroObject(jsonObject, "agentAlerts");
		this.roles = (List<PersonRole>) JsonUtils.getJsonListPerceroObject(jsonObject, "roles");
		this.emails = (List<Email>) JsonUtils.getJsonListPerceroObject(jsonObject, "emails");
		this.coachingSessions = (List<CoachingSession>) JsonUtils.getJsonListPerceroObject(jsonObject, "coachingSessions");
		this.manages = (List<Person>) JsonUtils.getJsonListPerceroObject(jsonObject, "manages");
	}

	@Override
	protected List<MappedClassMethodPair> getListSetters() {
		List<MappedClassMethodPair> listSetters = super.getListSetters();

		// Target Relationships
		listSetters.add(MappedClass.getFieldSetters(Notification.class, "person"));
		listSetters.add(MappedClass.getFieldSetters(Alert.class, "person"));
		listSetters.add(MappedClass.getFieldSetters(Alert.class, "agent"));
		listSetters.add(MappedClass.getFieldSetters(PersonRole.class, "person"));
		listSetters.add(MappedClass.getFieldSetters(Email.class, "person"));
		listSetters.add(MappedClass.getFieldSetters(CoachingSession.class, "agent"));
		listSetters.add(MappedClass.getFieldSetters(Person.class, "managedBy"));
	
		return listSetters;
	}
}