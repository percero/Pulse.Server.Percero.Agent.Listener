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
import com.pulse.mo.Agent;
import com.pulse.mo.Alert;
import com.pulse.mo.Notification;

import com.percero.agents.sync.vo.BaseDataObject;
import com.percero.serial.BDODeserializer;
import com.percero.serial.BDOSerializer;
import com.percero.serial.JsonUtils;

import com.pulse.mo.*;

@MappedSuperclass
/*
*/
public class _Super_TeamLeader extends BaseDataObject implements Serializable
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
    @com.percero.agents.sync.metadata.annotations.Externalize
	private String photoUri;
	public String getPhotoUri() {
		return this.photoUri;
	}
	public void setPhotoUri(String value)
	{
		this.photoUri = value;
	}

	@Column
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
    @com.percero.agents.sync.metadata.annotations.Externalize
	private String employeeId;
	public String getEmployeeId() {
		return this.employeeId;
	}
	public void setEmployeeId(String value)
	{
		this.employeeId = value;
	}


	//////////////////////////////////////////////////////
	// Source Relationships
	//////////////////////////////////////////////////////

	//////////////////////////////////////////////////////
	// Target Relationships
	//////////////////////////////////////////////////////
	@JsonSerialize(using=BDOSerializer.class)
	@JsonDeserialize(using=BDODeserializer.class)
    @com.percero.agents.sync.metadata.annotations.Externalize
	@JoinColumn(name="pulseUser_ID")
	@org.hibernate.annotations.ForeignKey(name="FK_TeamLeader_pulseUser_PulseUser")
	@OneToOne(fetch=FetchType.LAZY, mappedBy="teamLeader", cascade=javax.persistence.CascadeType.REMOVE)
	private PulseUser pulseUser;
	public PulseUser getPulseUser() {
		return this.pulseUser;
	}
	public void setPulseUser(PulseUser value) {
		this.pulseUser = value;
	}

    @com.percero.agents.sync.metadata.annotations.Externalize
	@JsonSerialize(contentUsing=BDOSerializer.class)
	@JsonDeserialize(contentUsing=BDODeserializer.class)
	@OneToMany(fetch=FetchType.LAZY, targetEntity=Agent.class, mappedBy="teamLeader", cascade=javax.persistence.CascadeType.REMOVE)
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
	@OneToMany(fetch=FetchType.LAZY, targetEntity=Alert.class, mappedBy="teamLeader", cascade=javax.persistence.CascadeType.REMOVE)
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
	@OneToMany(fetch=FetchType.LAZY, targetEntity=Notification.class, mappedBy="teamLeader", cascade=javax.persistence.CascadeType.REMOVE)
	private List<Notification> notifications;
	public List<Notification> getNotifications() {
		return this.notifications;
	}
	public void setNotifications(List<Notification> value) {
		this.notifications = value;
	}



	
	//////////////////////////////////////////////////////
	// JSON
	//////////////////////////////////////////////////////
	@Override
	public String retrieveJson(ObjectMapper objectMapper) {
		String objectJson = super.retrieveJson(objectMapper);

		// Properties
		objectJson += ",\"photoUri\":";
		if (getPhotoUri() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getPhotoUri());
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

		objectJson += ",\"employeeId\":";
		if (getEmployeeId() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getEmployeeId());
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

		objectJson += ",\"notifications\":[";
		if (getNotifications() != null) {
			int notificationsCounter = 0;
			for(Notification nextNotifications : getNotifications()) {
				if (notificationsCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextNotifications).toEmbeddedJson();
					notificationsCounter++;
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
		setPhotoUri(JsonUtils.getJsonString(jsonObject, "photoUri"));
		setLastName(JsonUtils.getJsonString(jsonObject, "lastName"));
		setFirstName(JsonUtils.getJsonString(jsonObject, "firstName"));
		setEmployeeId(JsonUtils.getJsonString(jsonObject, "employeeId"));

		// Source Relationships

		// Target Relationships
		this.pulseUser = JsonUtils.getJsonPerceroObject(jsonObject, "pulseUser");
		this.agents = (List<Agent>) JsonUtils.getJsonListPerceroObject(jsonObject, "agents");
		this.alerts = (List<Alert>) JsonUtils.getJsonListPerceroObject(jsonObject, "alerts");
		this.notifications = (List<Notification>) JsonUtils.getJsonListPerceroObject(jsonObject, "notifications");
	}

	@Override
	protected List<MappedClassMethodPair> getListSetters() {
		List<MappedClassMethodPair> listSetters = super.getListSetters();

		// Target Relationships
		listSetters.add(MappedClass.getFieldSetters(PulseUser.class, "teamLeader"));
		listSetters.add(MappedClass.getFieldSetters(Agent.class, "teamLeader"));
		listSetters.add(MappedClass.getFieldSetters(UserSession.class, "teamLeader"));
		listSetters.add(MappedClass.getFieldSetters(Alert.class, "teamLeader"));
		listSetters.add(MappedClass.getFieldSetters(Notification.class, "teamLeader"));
		listSetters.add(MappedClass.getFieldSetters(TeamLeaderImpersonation.class, "teamLeader"));
	
		return listSetters;
	}
}