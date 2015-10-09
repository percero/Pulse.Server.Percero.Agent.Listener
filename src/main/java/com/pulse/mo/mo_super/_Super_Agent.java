

package com.pulse.mo.mo_super;

import com.google.gson.JsonObject;
import com.percero.agents.sync.metadata.MappedClass;
import com.percero.agents.sync.metadata.MappedClass.MappedClassMethodPair;
import com.percero.agents.sync.vo.BaseDataObject;
import com.percero.serial.BDODeserializer;
import com.percero.serial.BDOSerializer;
import com.percero.serial.JsonUtils;
import com.pulse.mo.*;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.persistence.*;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

/*
Imports based on semantic requirements
*/

/*
Entity Tags based on semantic requirements
*/

@MappedSuperclass
public class _Super_Agent extends BaseDataObject implements Serializable
{
	//////////////////////////////////////////////////////
	// VERSION
	//////////////////////////////////////////////////////
	@Override
	public String classVersion() {
		return "1.0.0";
	}

	
	/*
	Keys of Agent
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
}/*
FullName
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String fullName;

public String getFullName() 
{
	return this.fullName;
}

public void setFullName(String fullName)
{
	this.fullName = fullName;
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
}

	//////////////////////////////////////////////////////
	// Target Relationships
	//////////////////////////////////////////////////////
	@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@OneToMany(fetch=FetchType.LAZY, targetEntity=ScheduledTime.class, mappedBy="agent", cascade=javax.persistence.CascadeType.REMOVE)
private List<ScheduledTime> scheduledTimes;
public List<ScheduledTime> getScheduledTimes() {
	return this.scheduledTimes;
}

public void setScheduledTimes(List<ScheduledTime> value) {
	this.scheduledTimes = value;
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
@OneToMany(fetch=FetchType.LAZY, targetEntity=AgentScorecard.class, mappedBy="agent", cascade=javax.persistence.CascadeType.REMOVE)
private List<AgentScorecard> agentScorecards;
public List<AgentScorecard> getAgentScorecards() {
	return this.agentScorecards;
}

public void setAgentScorecards(List<AgentScorecard> value) {
	this.agentScorecards = value;
}

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
@OneToMany(fetch=FetchType.LAZY, targetEntity=LOBConfigurationNotification.class, mappedBy="agent", cascade=javax.persistence.CascadeType.REMOVE)
private List<LOBConfigurationNotification> lOBConfigurationNotifications;
public List<LOBConfigurationNotification> getLOBConfigurationNotifications() {
	return this.lOBConfigurationNotifications;
}

public void setLOBConfigurationNotifications(List<LOBConfigurationNotification> value) {
	this.lOBConfigurationNotifications = value;
}

@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@OneToMany(fetch=FetchType.LAZY, targetEntity=CorrectiveAction.class, mappedBy="agent", cascade=javax.persistence.CascadeType.REMOVE)
private List<CorrectiveAction> correctiveActions;
public List<CorrectiveAction> getCorrectiveActions() {
	return this.correctiveActions;
}

public void setCorrectiveActions(List<CorrectiveAction> value) {
	this.correctiveActions = value;
}

@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@OneToMany(fetch=FetchType.LAZY, targetEntity=Timecard.class, mappedBy="agent", cascade=javax.persistence.CascadeType.REMOVE)
private List<Timecard> timecards;
public List<Timecard> getTimecards() {
	return this.timecards;
}

public void setTimecards(List<Timecard> value) {
	this.timecards = value;
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

@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@OneToMany(fetch=FetchType.LAZY, targetEntity=GeneralComment.class, mappedBy="agent", cascade=javax.persistence.CascadeType.REMOVE)
private List<GeneralComment> generalComments;
public List<GeneralComment> getGeneralComments() {
	return this.generalComments;
}

public void setGeneralComments(List<GeneralComment> value) {
	this.generalComments = value;
}



	//////////////////////////////////////////////////////
	// Source Relationships
	//////////////////////////////////////////////////////
	
@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@JoinColumn(name="TEAM_LEADER_ID")
@org.hibernate.annotations.ForeignKey(name="FK_TeamLeaderOfAgent")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private TeamLeader teamLeader;
public TeamLeader getTeamLeader() {
	return this.teamLeader;
}

public void setTeamLeader(TeamLeader value) {
	this.teamLeader = value;
}

	
	//////////////////////////////////////////////////////
	// JSON
	//////////////////////////////////////////////////////
	@Override
	public String retrieveJson(ObjectMapper objectMapper) {
		String objectJson = super.retrieveJson(objectMapper);

		// Properties		
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
		//Retrieve value of the Full Name property
		objectJson += ",\"fullName\":";
		
		if (getFullName() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getFullName());
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

				
		// Source Relationships
//Retrieve value of the Team Leader of Agent relationship
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
//Retrieve value of the Agent of Scheduled Time relationship
objectJson += ",\"scheduledTimes\":[";
		
		if (getScheduledTimes() != null) {
			int scheduledTimesCounter = 0;
			for(ScheduledTime nextScheduledTimes : getScheduledTimes()) {
				if (scheduledTimesCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextScheduledTimes).toEmbeddedJson();
					scheduledTimesCounter++;
				} catch(Exception e) {
					// Do nothing.
				}
			}
		}
		objectJson += "]";
//Retrieve value of the Agent of Adhoc Coaching Session relationship
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
//Retrieve value of the Agent of Agent Scorecard relationship
objectJson += ",\"agentScorecards\":[";
		
		if (getAgentScorecards() != null) {
			int agentScorecardsCounter = 0;
			for(AgentScorecard nextAgentScorecards : getAgentScorecards()) {
				if (agentScorecardsCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextAgentScorecards).toEmbeddedJson();
					agentScorecardsCounter++;
				} catch(Exception e) {
					// Do nothing.
				}
			}
		}
		objectJson += "]";
//Retrieve value of the Agent of Coaching Session relationship
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
//Retrieve value of the Agent of LOB Configuration Notification relationship
objectJson += ",\"lOBConfigurationNotifications\":[";
		
		if (getLOBConfigurationNotifications() != null) {
			int lOBConfigurationNotificationsCounter = 0;
			for(LOBConfigurationNotification nextLOBConfigurationNotifications : getLOBConfigurationNotifications()) {
				if (lOBConfigurationNotificationsCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextLOBConfigurationNotifications).toEmbeddedJson();
					lOBConfigurationNotificationsCounter++;
				} catch(Exception e) {
					// Do nothing.
				}
			}
		}
		objectJson += "]";
//Retrieve value of the Agent of Corrective Action relationship
objectJson += ",\"correctiveActions\":[";
		
		if (getCorrectiveActions() != null) {
			int correctiveActionsCounter = 0;
			for(CorrectiveAction nextCorrectiveActions : getCorrectiveActions()) {
				if (correctiveActionsCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextCorrectiveActions).toEmbeddedJson();
					correctiveActionsCounter++;
				} catch(Exception e) {
					// Do nothing.
				}
			}
		}
		objectJson += "]";
//Retrieve value of the Agent of Timecard relationship
objectJson += ",\"timecards\":[";
		
		if (getTimecards() != null) {
			int timecardsCounter = 0;
			for(Timecard nextTimecards : getTimecards()) {
				if (timecardsCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextTimecards).toEmbeddedJson();
					timecardsCounter++;
				} catch(Exception e) {
					// Do nothing.
				}
			}
		}
		objectJson += "]";
//Retrieve value of the Agent of Adhoc Task relationship
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
//Retrieve value of the Agent of General Comment relationship
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

		
		return objectJson;
	}


	@Override
	protected void fromJson(JsonObject jsonObject) {
	    super.fromJson(jsonObject);

		// Properties
		//From value of the Email Address property
		setEmailAddress(JsonUtils.getJsonString(jsonObject, "emailAddress"));
		//From value of the Full Name property
		setFullName(JsonUtils.getJsonString(jsonObject, "fullName"));
		//From value of the Last Name property
		setLastName(JsonUtils.getJsonString(jsonObject, "lastName"));
		//From value of the Photo Uri property
		setPhotoUri(JsonUtils.getJsonString(jsonObject, "photoUri"));
		//From value of the First Name property
		setFirstName(JsonUtils.getJsonString(jsonObject, "firstName"));
		//From value of the Employee Id property
		setEmployeeId(JsonUtils.getJsonString(jsonObject, "employeeId"));

		
		// Source Relationships
		this.teamLeader = (TeamLeader) JsonUtils.getJsonPerceroObject(jsonObject, "teamLeader");


		// Target Relationships
		this.scheduledTimes = (List<ScheduledTime>) JsonUtils.getJsonListPerceroObject(jsonObject, "scheduledTimes");

		this.adhocCoachingSessions = (List<AdhocCoachingSession>) JsonUtils.getJsonListPerceroObject(jsonObject, "adhocCoachingSessions");
		this.agentScorecards = (List<AgentScorecard>) JsonUtils.getJsonListPerceroObject(jsonObject, "agentScorecards");
		this.coachingSessions = (List<CoachingSession>) JsonUtils.getJsonListPerceroObject(jsonObject, "coachingSessions");
		this.lOBConfigurationNotifications = (List<LOBConfigurationNotification>) JsonUtils.getJsonListPerceroObject(jsonObject, "lOBConfigurationNotifications");
		this.correctiveActions = (List<CorrectiveAction>) JsonUtils.getJsonListPerceroObject(jsonObject, "correctiveActions");
		this.timecards = (List<Timecard>) JsonUtils.getJsonListPerceroObject(jsonObject, "timecards");
		this.adhocTasks = (List<AdhocTask>) JsonUtils.getJsonListPerceroObject(jsonObject, "adhocTasks");

		this.generalComments = (List<GeneralComment>) JsonUtils.getJsonListPerceroObject(jsonObject, "generalComments");


	}
	
	@Override
	protected List<MappedClassMethodPair> getListSetters() {
		List<MappedClassMethodPair> listSetters = super.getListSetters();

		// Target Relationships
		listSetters.add(MappedClass.getFieldSetters(ScheduledTime.class, "agent"));
		listSetters.add(MappedClass.getFieldSetters(AdhocCoachingSession.class, "agent"));
		listSetters.add(MappedClass.getFieldSetters(AgentScorecard.class, "agent"));
		listSetters.add(MappedClass.getFieldSetters(CoachingSession.class, "agent"));
		listSetters.add(MappedClass.getFieldSetters(LOBConfigurationNotification.class, "agent"));
		listSetters.add(MappedClass.getFieldSetters(CorrectiveAction.class, "agent"));
		listSetters.add(MappedClass.getFieldSetters(Timecard.class, "agent"));
		listSetters.add(MappedClass.getFieldSetters(AdhocTask.class, "agent"));
		listSetters.add(MappedClass.getFieldSetters(GeneralComment.class, "agent"));

		
		return listSetters;
	}
}

