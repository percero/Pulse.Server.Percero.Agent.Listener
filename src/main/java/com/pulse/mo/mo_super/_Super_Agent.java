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
import com.pulse.mo.LOBConfigurationNotification;
import com.pulse.mo.CorrectiveAction;
import com.pulse.mo.AgentCoachingSessions;
import com.pulse.mo.AdhocCoachingSession;
import com.pulse.mo.AgentTime;
import com.pulse.mo.AdhocTask;

import com.percero.agents.sync.vo.BaseDataObject;
import com.percero.serial.BDODeserializer;
import com.percero.serial.BDOSerializer;
import com.percero.serial.JsonUtils;

import com.pulse.mo.*;

@MappedSuperclass
/*
*/
public class _Super_Agent extends BaseDataObject implements Serializable
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


	//////////////////////////////////////////////////////
	// Source Relationships
	//////////////////////////////////////////////////////
    @com.percero.agents.sync.metadata.annotations.Externalize
	@JsonSerialize(using=BDOSerializer.class)
	@JsonDeserialize(using=BDODeserializer.class)
	@JoinColumn(name="teamLeader_ID")
	@org.hibernate.annotations.ForeignKey(name="FK_TeamLeader_teamLeader_TO_Agent")
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
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
	@OneToMany(fetch=FetchType.LAZY, targetEntity=LOBConfigurationNotification.class, mappedBy="agent", cascade=javax.persistence.CascadeType.REMOVE)
	private List<LOBConfigurationNotification> lobConfigurationNotifications;
	public List<LOBConfigurationNotification> getLobConfigurationNotifications() {
		return this.lobConfigurationNotifications;
	}
	public void setLobConfigurationNotifications(List<LOBConfigurationNotification> value) {
		this.lobConfigurationNotifications = value;
	}

    @com.percero.agents.sync.metadata.annotations.Externalize
	@JsonSerialize(contentUsing=BDOSerializer.class)
	@JsonDeserialize(contentUsing=BDODeserializer.class)
	@OneToMany(fetch=FetchType.LAZY, targetEntity=CorrectiveAction.class, mappedBy="agent", cascade=javax.persistence.CascadeType.REMOVE)
	private List<CorrectiveAction> correctiveAction;
	public List<CorrectiveAction> getCorrectiveAction() {
		return this.correctiveAction;
	}
	public void setCorrectiveAction(List<CorrectiveAction> value) {
		this.correctiveAction = value;
	}

    @com.percero.agents.sync.metadata.annotations.Externalize
	@JsonSerialize(contentUsing=BDOSerializer.class)
	@JsonDeserialize(contentUsing=BDODeserializer.class)
	@OneToMany(fetch=FetchType.LAZY, targetEntity=AgentCoachingSessions.class, mappedBy="agent", cascade=javax.persistence.CascadeType.REMOVE)
	private List<AgentCoachingSessions> agentCoachingSessions;
	public List<AgentCoachingSessions> getAgentCoachingSessions() {
		return this.agentCoachingSessions;
	}
	public void setAgentCoachingSessions(List<AgentCoachingSessions> value) {
		this.agentCoachingSessions = value;
	}

    @com.percero.agents.sync.metadata.annotations.Externalize
	@JsonSerialize(contentUsing=BDOSerializer.class)
	@JsonDeserialize(contentUsing=BDODeserializer.class)
	@OneToMany(fetch=FetchType.LAZY, targetEntity=AdhocCoachingSession.class, mappedBy="agent", cascade=javax.persistence.CascadeType.REMOVE)
	private List<AdhocCoachingSession> adhocCoachingSessions;
	public List<AdhocCoachingSession> getAdhocCoachingSessions() {
		return this.adhocCoachingSessions;
	}
	public void setAdhocCoachingSessions(List<AdhocCoachingSession> value) {
		this.adhocCoachingSessions = value;
	}

    @com.percero.agents.sync.metadata.annotations.Externalize
	@JsonSerialize(contentUsing=BDOSerializer.class)
	@JsonDeserialize(contentUsing=BDODeserializer.class)
	@OneToMany(fetch=FetchType.LAZY, targetEntity=AgentTime.class, mappedBy="agent", cascade=javax.persistence.CascadeType.REMOVE)
	private List<AgentTime> agentTimes;
	public List<AgentTime> getAgentTimes() {
		return this.agentTimes;
	}
	public void setAgentTimes(List<AgentTime> value) {
		this.agentTimes = value;
	}

    @com.percero.agents.sync.metadata.annotations.Externalize
	@JsonSerialize(contentUsing=BDOSerializer.class)
	@JsonDeserialize(contentUsing=BDODeserializer.class)
	@OneToMany(fetch=FetchType.LAZY, targetEntity=AdhocTask.class, mappedBy="agent", cascade=javax.persistence.CascadeType.REMOVE)
	private List<AdhocTask> adhocTasks;
	public List<AdhocTask> getAdhocTasks() {
		return this.adhocTasks;
	}
	public void setAdhocTasks(List<AdhocTask> value) {
		this.adhocTasks = value;
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
		objectJson += ",\"lobConfigurationNotifications\":[";
		if (getLobConfigurationNotifications() != null) {
			int lobConfigurationNotificationsCounter = 0;
			for(LOBConfigurationNotification nextLobConfigurationNotifications : getLobConfigurationNotifications()) {
				if (lobConfigurationNotificationsCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextLobConfigurationNotifications).toEmbeddedJson();
					lobConfigurationNotificationsCounter++;
				} catch(Exception e) {
					// Do nothing.
				}
			}
		}
		objectJson += "]";

		objectJson += ",\"correctiveAction\":[";
		if (getCorrectiveAction() != null) {
			int correctiveActionCounter = 0;
			for(CorrectiveAction nextCorrectiveAction : getCorrectiveAction()) {
				if (correctiveActionCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextCorrectiveAction).toEmbeddedJson();
					correctiveActionCounter++;
				} catch(Exception e) {
					// Do nothing.
				}
			}
		}
		objectJson += "]";

		objectJson += ",\"agentCoachingSessions\":[";
		if (getAgentCoachingSessions() != null) {
			int agentCoachingSessionsCounter = 0;
			for(AgentCoachingSessions nextAgentCoachingSessions : getAgentCoachingSessions()) {
				if (agentCoachingSessionsCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextAgentCoachingSessions).toEmbeddedJson();
					agentCoachingSessionsCounter++;
				} catch(Exception e) {
					// Do nothing.
				}
			}
		}
		objectJson += "]";

		objectJson += ",\"adhocCoachingSessions\":[";
		if (getAdhocCoachingSessions() != null) {
			int adhocCoachingSessionsCounter = 0;
			for(AdhocCoachingSession nextAdhocCoachingSessions : getAdhocCoachingSessions()) {
				if (adhocCoachingSessionsCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextAdhocCoachingSessions).toEmbeddedJson();
					adhocCoachingSessionsCounter++;
				} catch(Exception e) {
					// Do nothing.
				}
			}
		}
		objectJson += "]";

		objectJson += ",\"agentTimes\":[";
		if (getAgentTimes() != null) {
			int agentTimesCounter = 0;
			for(AgentTime nextAgentTimes : getAgentTimes()) {
				if (agentTimesCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextAgentTimes).toEmbeddedJson();
					agentTimesCounter++;
				} catch(Exception e) {
					// Do nothing.
				}
			}
		}
		objectJson += "]";

		objectJson += ",\"adhocTasks\":[";
		if (getAdhocTasks() != null) {
			int adhocTasksCounter = 0;
			for(AdhocTask nextAdhocTasks : getAdhocTasks()) {
				if (adhocTasksCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextAdhocTasks).toEmbeddedJson();
					adhocTasksCounter++;
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
		setEmployeeId(JsonUtils.getJsonString(jsonObject, "employeeId"));
		setPhotoUri(JsonUtils.getJsonString(jsonObject, "photoUri"));

		// Source Relationships
        this.teamLeader = JsonUtils.getJsonPerceroObject(jsonObject, "teamLeader");

		// Target Relationships
		this.lobConfigurationNotifications = (List<LOBConfigurationNotification>) JsonUtils.getJsonListPerceroObject(jsonObject, "lobConfigurationNotifications");
		this.correctiveAction = (List<CorrectiveAction>) JsonUtils.getJsonListPerceroObject(jsonObject, "correctiveAction");
		this.agentCoachingSessions = (List<AgentCoachingSessions>) JsonUtils.getJsonListPerceroObject(jsonObject, "agentCoachingSessions");
		this.adhocCoachingSessions = (List<AdhocCoachingSession>) JsonUtils.getJsonListPerceroObject(jsonObject, "adhocCoachingSessions");
		this.agentTimes = (List<AgentTime>) JsonUtils.getJsonListPerceroObject(jsonObject, "agentTimes");
		this.adhocTasks = (List<AdhocTask>) JsonUtils.getJsonListPerceroObject(jsonObject, "adhocTasks");
	}

	@Override
	protected List<MappedClassMethodPair> getListSetters() {
		List<MappedClassMethodPair> listSetters = super.getListSetters();

		// Target Relationships
		listSetters.add(MappedClass.getFieldSetters(LOBConfigurationNotification.class, "agent"));
		listSetters.add(MappedClass.getFieldSetters(CorrectiveAction.class, "agent"));
		listSetters.add(MappedClass.getFieldSetters(AgentCoachingSessions.class, "agent"));
		listSetters.add(MappedClass.getFieldSetters(AdhocCoachingSession.class, "agent"));
		listSetters.add(MappedClass.getFieldSetters(AgentTime.class, "agent"));
		listSetters.add(MappedClass.getFieldSetters(AdhocTask.class, "agent"));
	
		return listSetters;
	}
}