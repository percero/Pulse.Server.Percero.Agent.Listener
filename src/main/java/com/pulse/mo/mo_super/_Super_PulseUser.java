
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
import com.percero.agents.auth.vo.IUserAnchor;

import com.percero.agents.sync.vo.BaseDataObject;
import com.percero.serial.BDODeserializer;
import com.percero.serial.BDOSerializer;
import com.percero.serial.JsonUtils;

import com.pulse.mo.*;

/*
Entity Tags based on semantic requirements
*/
@com.percero.agents.sync.metadata.annotations.EntityInterface(interfaceClass=com.percero.agents.auth.vo.IUserAnchor.class)
@MappedSuperclass
public class _Super_PulseUser extends BaseDataObject implements Serializable, com.percero.agents.auth.vo.IUserAnchor
{
	//////////////////////////////////////////////////////
	// VERSION
	//////////////////////////////////////////////////////
	@Override
	public String classVersion() {
		return "1.0.0";
	}

	
	/*
	Keys of PulseUser
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
FirstName
Notes:
*/
@Column

@com.percero.agents.sync.metadata.annotations.PropertyInterface(entityInterfaceClass=com.percero.agents.auth.vo.IUserAnchor.class, propertyName="firstName",params={})
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
UserId
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String userId;

public String getUserId() 
{
	return this.userId;
}

public void setUserId(String userId)
{
	this.userId = userId;
}/*
LastName
Notes:
*/
@Column

@com.percero.agents.sync.metadata.annotations.PropertyInterface(entityInterfaceClass=com.percero.agents.auth.vo.IUserAnchor.class, propertyName="lastName",params={})
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

@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@OneToMany(fetch=FetchType.LAZY, targetEntity=UserSession.class, mappedBy="pulseUser", cascade=javax.persistence.CascadeType.REMOVE)
private List<UserSession> userSessions;
public List<UserSession> getUserSessions() {
	return this.userSessions;
}

public void setUserSessions(List<UserSession> value) {
	this.userSessions = value;
}

@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@OneToMany(fetch=FetchType.LAZY, targetEntity=TraceEntry.class, mappedBy="pulseUser", cascade=javax.persistence.CascadeType.REMOVE)
private List<TraceEntry> traceEntries;
public List<TraceEntry> getTraceEntries() {
	return this.traceEntries;
}

public void setTraceEntries(List<TraceEntry> value) {
	this.traceEntries = value;
}

@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@OneToMany(fetch=FetchType.LAZY, targetEntity=UserRole.class, mappedBy="pulseUser", cascade=javax.persistence.CascadeType.REMOVE)
private List<UserRole> userRoles;
public List<UserRole> getUserRoles() {
	return this.userRoles;
}

public void setUserRoles(List<UserRole> value) {
	this.userRoles = value;
}

@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@OneToMany(fetch=FetchType.LAZY, targetEntity=TeamLeaderImpersonation.class, mappedBy="pulseUser", cascade=javax.persistence.CascadeType.REMOVE)
private List<TeamLeaderImpersonation> teamLeaderImpersonations;
public List<TeamLeaderImpersonation> getTeamLeaderImpersonations() {
	return this.teamLeaderImpersonations;
}

public void setTeamLeaderImpersonations(List<TeamLeaderImpersonation> value) {
	this.teamLeaderImpersonations = value;
}



	//////////////////////////////////////////////////////
	// Source Relationships
	//////////////////////////////////////////////////////
	@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@JoinColumn(name="TEAM_LEADER_ID")
@org.hibernate.annotations.ForeignKey(name="FK_TeamLeaderOfPulseUser")
@OneToOne(fetch=FetchType.LAZY, optional=false)
private TeamLeader teamLeader;
public TeamLeader getTeamLeader() {
	return this.teamLeader;
}

public void setTeamLeader(TeamLeader value) 
{
	this.teamLeader = value;
}

	
	//////////////////////////////////////////////////////
	// JSON
	//////////////////////////////////////////////////////
	@Override
	public String retrieveJson(ObjectMapper objectMapper) {
		String objectJson = super.retrieveJson(objectMapper);

		// Properties		
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
		//Retrieve value of the User Id property
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

				
		// Source Relationships
//Retrieve value of the Team Leader of Pulse User relationship
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
//Retrieve value of the Pulse User of Email relationship
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
//Retrieve value of the Pulse User of User Session relationship
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
//Retrieve value of the Pulse User of Trace Entry relationship
objectJson += ",\"traceEntries\":[";
		
		if (getTraceEntries() != null) {
			int traceEntriesCounter = 0;
			for(TraceEntry nextTraceEntries : getTraceEntries()) {
				if (traceEntriesCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextTraceEntries).toEmbeddedJson();
					traceEntriesCounter++;
				} catch(Exception e) {
					// Do nothing.
				}
			}
		}
		objectJson += "]";
//Retrieve value of the Pulse User of User Role relationship
objectJson += ",\"userRoles\":[";
		
		if (getUserRoles() != null) {
			int userRolesCounter = 0;
			for(UserRole nextUserRoles : getUserRoles()) {
				if (userRolesCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextUserRoles).toEmbeddedJson();
					userRolesCounter++;
				} catch(Exception e) {
					// Do nothing.
				}
			}
		}
		objectJson += "]";
//Retrieve value of the Pulse User of Team Leader Impersonation relationship
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

		
		return objectJson;
	}


	@Override
	protected void fromJson(JsonObject jsonObject) {
	    super.fromJson(jsonObject);

		// Properties
		//From value of the First Name property
		setFirstName(JsonUtils.getJsonString(jsonObject, "firstName"));
		//From value of the User Id property
		setUserId(JsonUtils.getJsonString(jsonObject, "userId"));
		//From value of the Last Name property
		setLastName(JsonUtils.getJsonString(jsonObject, "lastName"));
		//From value of the Employee Id property
		setEmployeeId(JsonUtils.getJsonString(jsonObject, "employeeId"));

		
		// Source Relationships
		this.teamLeader = (TeamLeader) JsonUtils.getJsonPerceroObject(jsonObject, "teamLeader");


		// Target Relationships
		this.emails = (List<Email>) JsonUtils.getJsonListPerceroObject(jsonObject, "emails");

		this.userSessions = (List<UserSession>) JsonUtils.getJsonListPerceroObject(jsonObject, "userSessions");
		this.traceEntries = (List<TraceEntry>) JsonUtils.getJsonListPerceroObject(jsonObject, "traceEntries");
		this.userRoles = (List<UserRole>) JsonUtils.getJsonListPerceroObject(jsonObject, "userRoles");
		this.teamLeaderImpersonations = (List<TeamLeaderImpersonation>) JsonUtils.getJsonListPerceroObject(jsonObject, "teamLeaderImpersonations");



	}
	
	@Override
	protected List<MappedClassMethodPair> getListSetters() {
		List<MappedClassMethodPair> listSetters = super.getListSetters();

		// Target Relationships
		listSetters.add(MappedClass.getFieldSetters(Email.class, "pulseuser"));
		listSetters.add(MappedClass.getFieldSetters(UserSession.class, "pulseuser"));
		listSetters.add(MappedClass.getFieldSetters(TraceEntry.class, "pulseuser"));
		listSetters.add(MappedClass.getFieldSetters(UserRole.class, "pulseuser"));
		listSetters.add(MappedClass.getFieldSetters(TeamLeaderImpersonation.class, "pulseuser"));

		
		return listSetters;
	}
}
