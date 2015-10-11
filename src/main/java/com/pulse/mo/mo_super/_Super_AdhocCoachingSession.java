

package com.pulse.mo.mo_super;

import com.google.gson.JsonObject;
import com.percero.agents.sync.metadata.MappedClass;
import com.percero.agents.sync.metadata.MappedClass.MappedClassMethodPair;
import com.percero.agents.sync.vo.BaseDataObject;
import com.percero.serial.BDODeserializer;
import com.percero.serial.BDOSerializer;
import com.percero.serial.JsonUtils;
import com.pulse.mo.AdhocCoachingCategory;
import com.pulse.mo.Agent;
import com.pulse.mo.CoachingComment;
import com.pulse.mo.TeamLeader;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.persistence.*;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/*
Imports based on semantic requirements
*/

/*
Entity Tags based on semantic requirements
*/

@MappedSuperclass
public class _Super_AdhocCoachingSession extends BaseDataObject implements Serializable
{
	//////////////////////////////////////////////////////
	// VERSION
	//////////////////////////////////////////////////////
	@Override
	public String classVersion() {
		return "1.0.0";
	}

	
	/*
	Keys of AdhocCoachingSession
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
WeekDate
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Date weekDate;

public Date getWeekDate() 
{
	return this.weekDate;
}

public void setWeekDate(Date weekDate)
{
	this.weekDate = weekDate;
}/*
SessionType
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String sessionType;

public String getSessionType() 
{
	return this.sessionType;
}

public void setSessionType(String sessionType)
{
	this.sessionType = sessionType;
}/*
Status
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private String status;

public String getStatus() 
{
	return this.status;
}

public void setStatus(String status)
{
	this.status = status;
}

	//////////////////////////////////////////////////////
	// Target Relationships
	//////////////////////////////////////////////////////
	@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@OneToMany(fetch=FetchType.LAZY, targetEntity=CoachingComment.class, mappedBy="adhocCoachingSession", cascade=javax.persistence.CascadeType.REMOVE)
private List<CoachingComment> coachingComments;
public List<CoachingComment> getCoachingComments() {
	return this.coachingComments;
}

public void setCoachingComments(List<CoachingComment> value) {
	this.coachingComments = value;
}



	//////////////////////////////////////////////////////
	// Source Relationships
	//////////////////////////////////////////////////////
	
@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@JoinColumn(name="ADHOC_COACHING_CATEGORY_ID")
@org.hibernate.annotations.ForeignKey(name="FK_AdhocCoachingCategoryOfAdhocCoachingSession")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private AdhocCoachingCategory adhocCoachingCategory;
public AdhocCoachingCategory getAdhocCoachingCategory() {
	return this.adhocCoachingCategory;
}

public void setAdhocCoachingCategory(AdhocCoachingCategory value) {
	this.adhocCoachingCategory = value;
}
@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@JoinColumn(name="AGENT_ID")
@org.hibernate.annotations.ForeignKey(name="FK_AgentOfAdhocCoachingSession")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private Agent agent;
public Agent getAgent() {
	return this.agent;
}

public void setAgent(Agent value) {
	this.agent = value;
}
@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@JoinColumn(name="TEAM_LEADER_ID")
@org.hibernate.annotations.ForeignKey(name="FK_TeamLeaderOfAdhocCoachingSession")
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
		//Retrieve value of the Week Date property
		objectJson += ",\"weekDate\":";
		if (getWeekDate() == null)
			objectJson += "null";
		else {
			objectJson += getWeekDate().getTime();
		}
		//Retrieve value of the Session Type property
		objectJson += ",\"sessionType\":";
		
		if (getSessionType() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getSessionType());
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
		//Retrieve value of the Status property
		objectJson += ",\"status\":";
		
		if (getStatus() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getStatus());
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
//Retrieve value of the Adhoc Coaching Category of Adhoc Coaching Session relationship
objectJson += ",\"adhocCoachingCategory\":";
		if (getAdhocCoachingCategory() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getAdhocCoachingCategory()).toEmbeddedJson();
			} catch(Exception e) {
				objectJson += "null";
			}
		}
		objectJson += "";
//Retrieve value of the Agent of Adhoc Coaching Session relationship
objectJson += ",\"agent\":";
		if (getAgent() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getAgent()).toEmbeddedJson();
			} catch(Exception e) {
				objectJson += "null";
			}
		}
		objectJson += "";
//Retrieve value of the Team Leader of Adhoc Coaching Session relationship
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
//Retrieve value of the Adhoc Coaching Session of Coaching Comment relationship
objectJson += ",\"coachingComments\":[";
		
		if (getCoachingComments() != null) {
			int coachingCommentsCounter = 0;
			for(CoachingComment nextCoachingComments : getCoachingComments()) {
				if (coachingCommentsCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextCoachingComments).toEmbeddedJson();
					coachingCommentsCounter++;
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
		//From value of the Week Date property
		setWeekDate(JsonUtils.getJsonDate(jsonObject, "weekDate"));
		//From value of the Session Type property
		setSessionType(JsonUtils.getJsonString(jsonObject, "sessionType"));
		//From value of the Status property
		setStatus(JsonUtils.getJsonString(jsonObject, "status"));

		
		// Source Relationships
		this.adhocCoachingCategory = (AdhocCoachingCategory) JsonUtils.getJsonPerceroObject(jsonObject, "adhocCoachingCategory");
		this.agent = (Agent) JsonUtils.getJsonPerceroObject(jsonObject, "agent");
		this.teamLeader = (TeamLeader) JsonUtils.getJsonPerceroObject(jsonObject, "teamLeader");


		// Target Relationships
		this.coachingComments = (List<CoachingComment>) JsonUtils.getJsonListPerceroObject(jsonObject, "coachingComments");


	}
	
	@Override
	protected List<MappedClassMethodPair> getListSetters() {
		List<MappedClassMethodPair> listSetters = super.getListSetters();

		// Target Relationships
		listSetters.add(MappedClass.getFieldSetters(CoachingComment.class, "adhoccoachingsession"));

		
		return listSetters;
	}
}

