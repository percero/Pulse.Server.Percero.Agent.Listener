


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
public class _Super_Employee extends BaseDataObject implements Serializable
{
	//////////////////////////////////////////////////////
	// VERSION
	//////////////////////////////////////////////////////
	@Override
	public String classVersion() {
		return "1.0.0";
	}

	
	/*
	Keys of Employee
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
}

	//////////////////////////////////////////////////////
	// Target Relationships
	//////////////////////////////////////////////////////
	@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@OneToMany(fetch=FetchType.LAZY, targetEntity=CorrectiveAction.class, mappedBy="managerEmployee", cascade=javax.persistence.CascadeType.REMOVE)
private List<CorrectiveAction> managerCorrectiveActions;
public List<CorrectiveAction> getManagerCorrectiveActions() {
	return this.managerCorrectiveActions;
}

public void setManagerCorrectiveActions(List<CorrectiveAction> value) {
	this.managerCorrectiveActions = value;
}

@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@OneToMany(fetch=FetchType.LAZY, targetEntity=CorrectiveAction.class, mappedBy="supervisorManagerEmployee", cascade=javax.persistence.CascadeType.REMOVE)
private List<CorrectiveAction> supervisorCorrectiveActions;
public List<CorrectiveAction> getSupervisorCorrectiveActions() {
	return this.supervisorCorrectiveActions;
}

public void setSupervisorCorrectiveActions(List<CorrectiveAction> value) {
	this.supervisorCorrectiveActions = value;
}

@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@OneToMany(fetch=FetchType.LAZY, targetEntity=CorrectiveAction.class, mappedBy="hREmployee", cascade=javax.persistence.CascadeType.REMOVE)
private List<CorrectiveAction> hRCorrectiveActions;
public List<CorrectiveAction> getHRCorrectiveActions() {
	return this.hRCorrectiveActions;
}

public void setHRCorrectiveActions(List<CorrectiveAction> value) {
	this.hRCorrectiveActions = value;
}



	//////////////////////////////////////////////////////
	// Source Relationships
	//////////////////////////////////////////////////////
	

	
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

				
		// Source Relationships

		
		// Target Relationships
//Retrieve value of the Manager Employee of Manager Corrective Action relationship
objectJson += ",\"managerCorrectiveActions\":[";
		
		if (getManagerCorrectiveActions() != null) {
			int managerCorrectiveActionsCounter = 0;
			for(CorrectiveAction nextManagerCorrectiveActions : getManagerCorrectiveActions()) {
				if (managerCorrectiveActionsCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextManagerCorrectiveActions).toEmbeddedJson();
					managerCorrectiveActionsCounter++;
				} catch(Exception e) {
					// Do nothing.
				}
			}
		}
		objectJson += "]";
//Retrieve value of the Supervisor Manager Employee of Supervisor Corrective Action relationship
objectJson += ",\"supervisorCorrectiveActions\":[";
		
		if (getSupervisorCorrectiveActions() != null) {
			int supervisorCorrectiveActionsCounter = 0;
			for(CorrectiveAction nextSupervisorCorrectiveActions : getSupervisorCorrectiveActions()) {
				if (supervisorCorrectiveActionsCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextSupervisorCorrectiveActions).toEmbeddedJson();
					supervisorCorrectiveActionsCounter++;
				} catch(Exception e) {
					// Do nothing.
				}
			}
		}
		objectJson += "]";
//Retrieve value of the HR Employee of HR Corrective Action relationship
objectJson += ",\"hRCorrectiveActions\":[";
		
		if (getHRCorrectiveActions() != null) {
			int hRCorrectiveActionsCounter = 0;
			for(CorrectiveAction nextHRCorrectiveActions : getHRCorrectiveActions()) {
				if (hRCorrectiveActionsCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextHRCorrectiveActions).toEmbeddedJson();
					hRCorrectiveActionsCounter++;
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
		//From value of the Photo Uri property
		setPhotoUri(JsonUtils.getJsonString(jsonObject, "photoUri"));
		//From value of the Last Name property
		setLastName(JsonUtils.getJsonString(jsonObject, "lastName"));
		//From value of the Email Address property
		setEmailAddress(JsonUtils.getJsonString(jsonObject, "emailAddress"));
		//From value of the Full Name property
		setFullName(JsonUtils.getJsonString(jsonObject, "fullName"));

		
		// Source Relationships


		// Target Relationships
		this.managerCorrectiveActions = (List<CorrectiveAction>) JsonUtils.getJsonListPerceroObject(jsonObject, "managerCorrectiveActions");
		this.supervisorCorrectiveActions = (List<CorrectiveAction>) JsonUtils.getJsonListPerceroObject(jsonObject, "supervisorCorrectiveActions");
		this.hRCorrectiveActions = (List<CorrectiveAction>) JsonUtils.getJsonListPerceroObject(jsonObject, "hRCorrectiveActions");


	}
	
	@Override
	protected List<MappedClassMethodPair> getListSetters() {
		List<MappedClassMethodPair> listSetters = super.getListSetters();

		// Target Relationships
		listSetters.add(MappedClass.getFieldSetters(CorrectiveAction.class, "employee"));
		listSetters.add(MappedClass.getFieldSetters(CorrectiveAction.class, "employee"));
		listSetters.add(MappedClass.getFieldSetters(CorrectiveAction.class, "employee"));

		
		return listSetters;
	}
}
