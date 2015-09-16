
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


import com.percero.agents.sync.vo.BaseDataObject;
import com.percero.serial.BDODeserializer;
import com.percero.serial.BDOSerializer;
import com.percero.serial.JsonUtils;

import com.pulse.mo.*;

/*
Entity Tags based on semantic requirements
*/

@MappedSuperclass
public class _Super_UserSession extends BaseDataObject implements Serializable
{
	//////////////////////////////////////////////////////
	// VERSION
	//////////////////////////////////////////////////////
	@Override
	public String classVersion() {
		return "1.0.0";
	}

	
	/*
	Keys of UserSession
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
ConnectedStateName
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String connectedStateName;

public String getConnectedStateName() 
{
	return this.connectedStateName;
}

public void setConnectedStateName(String connectedStateName)
{
	this.connectedStateName = connectedStateName;
}/*
Date
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Date date;

public Date getDate() 
{
	return this.date;
}

public void setDate(Date date)
{
	this.date = date;
}/*
IPAddress
Notes:???
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String iPAddress;

public String getIPAddress() 
{
	return this.iPAddress;
}

public void setIPAddress(String iPAddress)
{
	this.iPAddress = iPAddress;
}

	//////////////////////////////////////////////////////
	// Target Relationships
	//////////////////////////////////////////////////////
	@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@OneToMany(fetch=FetchType.LAZY, targetEntity=ConnectedState.class, mappedBy="userSession", cascade=javax.persistence.CascadeType.REMOVE)
private List<ConnectedState> connectedStates;
public List<ConnectedState> getConnectedStates() {
	return this.connectedStates;
}

public void setConnectedStates(List<ConnectedState> value) {
	this.connectedStates = value;
}



	//////////////////////////////////////////////////////
	// Source Relationships
	//////////////////////////////////////////////////////
	@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@JoinColumn(name="CurrentTeamLeaderId")
@org.hibernate.annotations.ForeignKey(name="FK_CurrentTeamLeaderOfUserSession")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private TeamLeader currentTeamLeader;
public TeamLeader getCurrentTeamLeader() {
	return this.currentTeamLeader;
}

public void setCurrentTeamLeader(TeamLeader value) {
	this.currentTeamLeader = value;
}@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@JoinColumn(name="PulseUserId")
@org.hibernate.annotations.ForeignKey(name="FK_PulseUserOfUserSession")
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
		//Retrieve value of the Connected State Name property
		objectJson += ",\"connectedStateName\":";
		
		if (getConnectedStateName() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getConnectedStateName());
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
		//Retrieve value of the Date property
		objectJson += ",\"date\":";
		if (getDate() == null)
			objectJson += "null";
		else {
			objectJson += getDate().getTime();
		}
		//Retrieve value of the IP Address property
		objectJson += ",\"iPAddress\":";
		
		if (getIPAddress() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getIPAddress());
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
//Retrieve value of the Current Team Leader of User Session relationship
objectJson += ",\"currentTeamLeader\":";
		if (getCurrentTeamLeader() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getCurrentTeamLeader()).toEmbeddedJson();
			} catch(Exception e) {
				objectJson += "null";
			}
		}
		objectJson += "";
//Retrieve value of the Pulse User of User Session relationship
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
//Retrieve value of the User Session of Connected State relationship
objectJson += ",\"connectedStates\":[";
		
		if (getConnectedStates() != null) {
			int connectedStatesCounter = 0;
			for(ConnectedState nextConnectedStates : getConnectedStates()) {
				if (connectedStatesCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextConnectedStates).toEmbeddedJson();
					connectedStatesCounter++;
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
		//From value of the Connected State Name property
		setConnectedStateName(JsonUtils.getJsonString(jsonObject, "connectedStateName"));
		//From value of the Date property
		setDate(JsonUtils.getJsonDate(jsonObject, "date"));
		//From value of the IP Address property
		setIPAddress(JsonUtils.getJsonString(jsonObject, "iPAddress"));

		
		// Source Relationships
		this.currentTeamLeader = (TeamLeader) JsonUtils.getJsonPerceroObject(jsonObject, "currentTeamLeader");
		this.pulseUser = (PulseUser) JsonUtils.getJsonPerceroObject(jsonObject, "pulseUser");


		// Target Relationships
		this.connectedStates = (List<ConnectedState>) JsonUtils.getJsonListPerceroObject(jsonObject, "connectedStates");


	}
	
	@Override
	protected List<MappedClassMethodPair> getListSetters() {
		List<MappedClassMethodPair> listSetters = super.getListSetters();

		// Target Relationships
		listSetters.add(MappedClass.getFieldSetters(ConnectedState.class, "usersession"));

		
		return listSetters;
	}
}
