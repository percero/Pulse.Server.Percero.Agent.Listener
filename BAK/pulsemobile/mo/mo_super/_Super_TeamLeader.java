
package com.pulsemobile.mo.mo_super;

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

import com.pulsemobile.mo.*;
import com.pulsev2.mo.PulseUser;

/*
Entity Tags based on semantic requirements
*/

@MappedSuperclass
public class _Super_TeamLeader extends BaseDataObject implements Serializable
{
	//////////////////////////////////////////////////////
	// VERSION
	//////////////////////////////////////////////////////
	@Override
	public String classVersion() {
		return "1.0.0";
	}

	
	/*
	Keys of TeamLeader
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
FirstName
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String firstName;

public String getFirstName() 
{
	return this.firstName;
}

public void setFirstName(String firstName)
{
	this.firstName = firstName;
}/*
LastName
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String lastName;

public String getLastName() 
{
	return this.lastName;
}

public void setLastName(String lastName)
{
	this.lastName = lastName;
}/*
EmployeeId
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String employeeId;

public String getEmployeeId() 
{
	return this.employeeId;
}

public void setEmployeeId(String employeeId)
{
	this.employeeId = employeeId;
}/*
PhotoUri
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String photoUri;

public String getPhotoUri() 
{
	return this.photoUri;
}

public void setPhotoUri(String photoUri)
{
	this.photoUri = photoUri;
}/*
NotificationCount
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Integer notificationCount;

public Integer getNotificationCount() 
{
	return this.notificationCount;
}

public void setNotificationCount(Integer notificationCount)
{
	this.notificationCount = notificationCount;
}/*
EmailAddress
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String emailAddress;

public String getEmailAddress() 
{
	return this.emailAddress;
}

public void setEmailAddress(String emailAddress)
{
	this.emailAddress = emailAddress;
}

	//////////////////////////////////////////////////////
	// Target Relationships
	//////////////////////////////////////////////////////
	@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@OneToMany(fetch=FetchType.LAZY, targetEntity=Notification.class, mappedBy="teamLeader", cascade=javax.persistence.CascadeType.REMOVE)
private List<Notification> notifications;
public List<Notification> getNotifications() {
	return this.notifications;
}

public void setNotifications(List<Notification> value) {
	this.notifications = value;
}

@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@OneToMany(fetch=FetchType.LAZY, targetEntity=Agent.class, mappedBy="teamLeader", cascade=javax.persistence.CascadeType.REMOVE)
private List<Agent> agents;
public List<Agent> getAgents() {
	return this.agents;
}

public void setAgents(List<Agent> value) {
	this.agents = value;
}

@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@OneToMany(fetch=FetchType.LAZY, targetEntity=Alert.class, mappedBy="teamLeader", cascade=javax.persistence.CascadeType.REMOVE)
private List<Alert> alerts;
public List<Alert> getAlerts() {
	return this.alerts;
}

public void setAlerts(List<Alert> value) {
	this.alerts = value;
}

@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@OneToMany(fetch=FetchType.LAZY, targetEntity=AdhocCoachingSession.class, mappedBy="teamLeader", cascade=javax.persistence.CascadeType.REMOVE)
private List<AdhocCoachingSession> adhocCoachingSessions;
public List<AdhocCoachingSession> getAdhocCoachingSessions() {
	return this.adhocCoachingSessions;
}

public void setAdhocCoachingSessions(List<AdhocCoachingSession> value) {
	this.adhocCoachingSessions = value;
}

@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@OneToMany(fetch=FetchType.LAZY, targetEntity=AdhocTask.class, mappedBy="teamLeader", cascade=javax.persistence.CascadeType.REMOVE)
private List<AdhocTask> adhocTasks;
public List<AdhocTask> getAdhocTasks() {
	return this.adhocTasks;
}

public void setAdhocTasks(List<AdhocTask> value) {
	this.adhocTasks = value;
}

@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@OneToMany(fetch=FetchType.LAZY, targetEntity=AppAction.class, mappedBy="teamLeader", cascade=javax.persistence.CascadeType.REMOVE)
private List<AppAction> appActions;
public List<AppAction> getAppActions() {
	return this.appActions;
}

public void setAppActions(List<AppAction> value) {
	this.appActions = value;
}

@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@OneToMany(fetch=FetchType.LAZY, targetEntity=DevelopmentActivity.class, mappedBy="teamLeader", cascade=javax.persistence.CascadeType.REMOVE)
private List<DevelopmentActivity> developmentActivities;
public List<DevelopmentActivity> getDevelopmentActivities() {
	return this.developmentActivities;
}

public void setDevelopmentActivities(List<DevelopmentActivity> value) {
	this.developmentActivities = value;
}

@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@OneToMany(fetch=FetchType.LAZY, targetEntity=GeneralComment.class, mappedBy="teamLeader", cascade=javax.persistence.CascadeType.REMOVE)
private List<GeneralComment> generalComments;
public List<GeneralComment> getGeneralComments() {
	return this.generalComments;
}

public void setGeneralComments(List<GeneralComment> value) {
	this.generalComments = value;
}

@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@OneToMany(fetch=FetchType.LAZY, targetEntity=TeamLeaderImpersonation.class, mappedBy="teamLeader", cascade=javax.persistence.CascadeType.REMOVE)
private List<TeamLeaderImpersonation> teamLeaderImpersonations;
public List<TeamLeaderImpersonation> getTeamLeaderImpersonations() {
	return this.teamLeaderImpersonations;
}

public void setTeamLeaderImpersonations(List<TeamLeaderImpersonation> value) {
	this.teamLeaderImpersonations = value;
}

@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@OneToMany(fetch=FetchType.LAZY, targetEntity=Setting.class, mappedBy="teamLeader", cascade=javax.persistence.CascadeType.REMOVE)
private List<Setting> settings;
public List<Setting> getSettings() {
	return this.settings;
}

public void setSettings(List<Setting> value) {
	this.settings = value;
}

@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@OneToMany(fetch=FetchType.LAZY, targetEntity=UserSession.class, mappedBy="teamLeader", cascade=javax.persistence.CascadeType.REMOVE)
private List<UserSession> userSessions;
public List<UserSession> getUserSessions() {
	return this.userSessions;
}

public void setUserSessions(List<UserSession> value) {
	this.userSessions = value;
}

@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@JoinColumn(name="TeamLeaderId")
@org.hibernate.annotations.ForeignKey(name="FK_TeamLeaderOfPulseUser")
@OneToOne(fetch=FetchType.LAZY, mappedBy="teamLeader", cascade=javax.persistence.CascadeType.REMOVE)
private PulseUser pulseUser;
public PulseUser getPulseUser() {
	return this.pulseUser;
}
public void setPulseUser(PulseUser value) {
	this.pulseUser = value;
}

@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@OneToMany(fetch=FetchType.LAZY, targetEntity=TeamLeaderAction.class, mappedBy="teamLeader", cascade=javax.persistence.CascadeType.REMOVE)
private List<TeamLeaderAction> teamLeaderActions;
public List<TeamLeaderAction> getTeamLeaderActions() {
	return this.teamLeaderActions;
}

public void setTeamLeaderActions(List<TeamLeaderAction> value) {
	this.teamLeaderActions = value;
}

@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@OneToMany(fetch=FetchType.LAZY, targetEntity=TeamLeaderImpersonation.class, mappedBy="teamLeader", cascade=javax.persistence.CascadeType.REMOVE)
private List<TeamLeaderImpersonation> impersonatedByTeamLeaderImpersonations;
public List<TeamLeaderImpersonation> getImpersonatedByTeamLeaderImpersonations() {
	return this.impersonatedByTeamLeaderImpersonations;
}

public void setImpersonatedByTeamLeaderImpersonations(List<TeamLeaderImpersonation> value) {
	this.impersonatedByTeamLeaderImpersonations = value;
}



	//////////////////////////////////////////////////////
	// Source Relationships
	//////////////////////////////////////////////////////
@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@JoinColumn(name="SupervisorId")
@org.hibernate.annotations.ForeignKey(name="FK_SupervisorOfTeamLeader")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private Supervisor supervisor;
public Supervisor getSupervisor() {
	return this.supervisor;
}

public void setSupervisor(Supervisor value) {
	this.supervisor = value;
}

	
	//////////////////////////////////////////////////////
	// JSON
	//////////////////////////////////////////////////////
	@Override
	public String retrieveJson(ObjectMapper objectMapper) {
		String objectJson = super.retrieveJson(objectMapper);

		// Properties		
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
		//Retrieve value of the First Name property
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
		//Retrieve value of the Last Name property
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
		//Retrieve value of the Employee Id property
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
		//Retrieve value of the Photo Uri property
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
		//Retrieve value of the Notification Count property
		objectJson += ",\"notificationCount\":";
		
		if (getNotificationCount() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getNotificationCount());
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
		//Retrieve value of the Email Address property
		objectJson += ",\"emailAddress\":";
		
		if (getEmailAddress() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getEmailAddress());
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
//Retrieve value of the Pulse User of Available Team Leader relationship
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
//Retrieve value of the Pulse User of Recent Team Leader relationship
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
//Retrieve value of the Supervisor of Team Leader relationship
objectJson += ",\"supervisor\":";
		if (getSupervisor() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getSupervisor()).toEmbeddedJson();
			} catch(Exception e) {
				objectJson += "null";
			}
		}
		objectJson += "";

		
		// Target Relationships
//Retrieve value of the Team Leader of Notification relationship
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
//Retrieve value of the Team Leader of Agent relationship
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
//Retrieve value of the Team Leader of Alert relationship
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
//Retrieve value of the Team Leader of Adhoc Coaching Session relationship
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
//Retrieve value of the Team Leader of Adhoc Task relationship
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
//Retrieve value of the Team Leader of App Action relationship
objectJson += ",\"appActions\":[";
		
		if (getAppActions() != null) {
			int appActionsCounter = 0;
			for(AppAction nextAppActions : getAppActions()) {
				if (appActionsCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextAppActions).toEmbeddedJson();
					appActionsCounter++;
				} catch(Exception e) {
					// Do nothing.
				}
			}
		}
		objectJson += "]";
//Retrieve value of the Team Leader of Development Activity relationship
objectJson += ",\"developmentActivities\":[";
		
		if (getDevelopmentActivities() != null) {
			int developmentActivitiesCounter = 0;
			for(DevelopmentActivity nextDevelopmentActivities : getDevelopmentActivities()) {
				if (developmentActivitiesCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextDevelopmentActivities).toEmbeddedJson();
					developmentActivitiesCounter++;
				} catch(Exception e) {
					// Do nothing.
				}
			}
		}
		objectJson += "]";
//Retrieve value of the Team Leader of General Comment relationship
objectJson += ",\"generalComments\":[";
		
		if (getGeneralComments() != null) {
			int generalCommentsCounter = 0;
			for(GeneralComment nextGeneralComments : getGeneralComments()) {
				if (generalCommentsCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextGeneralComments).toEmbeddedJson();
					generalCommentsCounter++;
				} catch(Exception e) {
					// Do nothing.
				}
			}
		}
		objectJson += "]";
//Retrieve value of the Team Leader of Team Leader Impersonation relationship
objectJson += ",\"teamLeaderImpersonations\":[";
		
		if (getTeamLeaderImpersonations() != null) {
			int teamLeaderImpersonationsCounter = 0;
			for(TeamLeaderImpersonation nextTeamLeaderImpersonations : getTeamLeaderImpersonations()) {
				if (teamLeaderImpersonationsCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextTeamLeaderImpersonations).toEmbeddedJson();
					teamLeaderImpersonationsCounter++;
				} catch(Exception e) {
					// Do nothing.
				}
			}
		}
		objectJson += "]";
//Retrieve value of the Team Leader of Setting relationship
objectJson += ",\"settings\":[";
		
		if (getSettings() != null) {
			int settingsCounter = 0;
			for(Setting nextSettings : getSettings()) {
				if (settingsCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextSettings).toEmbeddedJson();
					settingsCounter++;
				} catch(Exception e) {
					// Do nothing.
				}
			}
		}
		objectJson += "]";
//Retrieve value of the Current Team Leader of User Session relationship
objectJson += ",\"userSessions\":[";
		
		if (getUserSessions() != null) {
			int userSessionsCounter = 0;
			for(UserSession nextUserSessions : getUserSessions()) {
				if (userSessionsCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextUserSessions).toEmbeddedJson();
					userSessionsCounter++;
				} catch(Exception e) {
					// Do nothing.
				}
			}
		}
		objectJson += "]";
//Retrieve value of the Team Leader of Pulse User relationship

//Retrieve value of the Team Leader of Team Leader Action relationship
objectJson += ",\"teamLeaderActions\":[";
		
		if (getTeamLeaderActions() != null) {
			int teamLeaderActionsCounter = 0;
			for(TeamLeaderAction nextTeamLeaderActions : getTeamLeaderActions()) {
				if (teamLeaderActionsCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextTeamLeaderActions).toEmbeddedJson();
					teamLeaderActionsCounter++;
				} catch(Exception e) {
					// Do nothing.
				}
			}
		}
		objectJson += "]";
//Retrieve value of the Impersonates Team Leader of Impersonated By Team Leader Impersonation relationship
objectJson += ",\"impersonatedByTeamLeaderImpersonations\":[";
		
		if (getImpersonatedByTeamLeaderImpersonations() != null) {
			int impersonatedByTeamLeaderImpersonationsCounter = 0;
			for(TeamLeaderImpersonation nextImpersonatedByTeamLeaderImpersonations : getImpersonatedByTeamLeaderImpersonations()) {
				if (impersonatedByTeamLeaderImpersonationsCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextImpersonatedByTeamLeaderImpersonations).toEmbeddedJson();
					impersonatedByTeamLeaderImpersonationsCounter++;
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
		//From value of the External ID property
		setExternalID(JsonUtils.getJsonString(jsonObject, "externalID"));
		//From value of the First Name property
		setFirstName(JsonUtils.getJsonString(jsonObject, "firstName"));
		//From value of the Last Name property
		setLastName(JsonUtils.getJsonString(jsonObject, "lastName"));
		//From value of the Employee Id property
		setEmployeeId(JsonUtils.getJsonString(jsonObject, "employeeId"));
		//From value of the Photo Uri property
		setPhotoUri(JsonUtils.getJsonString(jsonObject, "photoUri"));
		//From value of the Notification Count property
		setNotificationCount(JsonUtils.getJsonInteger(jsonObject, "notificationCount"));
		//From value of the Email Address property
		setEmailAddress(JsonUtils.getJsonString(jsonObject, "emailAddress"));

		
		// Source Relationships
		this.pulseUser = (PulseUser) JsonUtils.getJsonPerceroObject(jsonObject, "pulseUser");
		this.pulseUser = (PulseUser) JsonUtils.getJsonPerceroObject(jsonObject, "pulseUser");
		this.supervisor = (Supervisor) JsonUtils.getJsonPerceroObject(jsonObject, "supervisor");


		// Target Relationships
		this.notifications = (List<Notification>) JsonUtils.getJsonListPerceroObject(jsonObject, "notifications");
		this.agents = (List<Agent>) JsonUtils.getJsonListPerceroObject(jsonObject, "agents");
		this.alerts = (List<Alert>) JsonUtils.getJsonListPerceroObject(jsonObject, "alerts");
		this.adhocCoachingSessions = (List<AdhocCoachingSession>) JsonUtils.getJsonListPerceroObject(jsonObject, "adhocCoachingSessions");
		this.adhocTasks = (List<AdhocTask>) JsonUtils.getJsonListPerceroObject(jsonObject, "adhocTasks");
		this.appActions = (List<AppAction>) JsonUtils.getJsonListPerceroObject(jsonObject, "appActions");
		this.developmentActivities = (List<DevelopmentActivity>) JsonUtils.getJsonListPerceroObject(jsonObject, "developmentActivities");
		this.generalComments = (List<GeneralComment>) JsonUtils.getJsonListPerceroObject(jsonObject, "generalComments");
		this.teamLeaderImpersonations = (List<TeamLeaderImpersonation>) JsonUtils.getJsonListPerceroObject(jsonObject, "teamLeaderImpersonations");
		this.settings = (List<Setting>) JsonUtils.getJsonListPerceroObject(jsonObject, "settings");
		this.userSessions = (List<UserSession>) JsonUtils.getJsonListPerceroObject(jsonObject, "userSessions");
		this.pulseUser = (PulseUser) JsonUtils.getJsonPerceroObject(jsonObject, "pulseUser");
		this.teamLeaderActions = (List<TeamLeaderAction>) JsonUtils.getJsonListPerceroObject(jsonObject, "teamLeaderActions");
		this.impersonatedByTeamLeaderImpersonations = (List<TeamLeaderImpersonation>) JsonUtils.getJsonListPerceroObject(jsonObject, "impersonatedByTeamLeaderImpersonations");


	}
	
	@Override
	protected List<MappedClassMethodPair> getListSetters() {
		List<MappedClassMethodPair> listSetters = super.getListSetters();

		// Target Relationships
		listSetters.add(MappedClass.getFieldSetters(Notification.class, "teamleader"));
		listSetters.add(MappedClass.getFieldSetters(Agent.class, "teamleader"));
		listSetters.add(MappedClass.getFieldSetters(Alert.class, "teamleader"));
		listSetters.add(MappedClass.getFieldSetters(AdhocCoachingSession.class, "teamleader"));
		listSetters.add(MappedClass.getFieldSetters(AdhocTask.class, "teamleader"));
		listSetters.add(MappedClass.getFieldSetters(AppAction.class, "teamleader"));
		listSetters.add(MappedClass.getFieldSetters(DevelopmentActivity.class, "teamleader"));
		listSetters.add(MappedClass.getFieldSetters(GeneralComment.class, "teamleader"));
		listSetters.add(MappedClass.getFieldSetters(TeamLeaderImpersonation.class, "teamleader"));
		listSetters.add(MappedClass.getFieldSetters(Setting.class, "teamleader"));
		listSetters.add(MappedClass.getFieldSetters(UserSession.class, "teamleader"));
		listSetters.add(MappedClass.getFieldSetters(TeamLeaderAction.class, "teamleader"));
		listSetters.add(MappedClass.getFieldSetters(TeamLeaderImpersonation.class, "teamleader"));

		
		return listSetters;
	}
}
