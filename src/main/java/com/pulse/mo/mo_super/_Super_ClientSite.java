
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
public class _Super_ClientSite extends BaseDataObject implements Serializable
{
	//////////////////////////////////////////////////////
	// VERSION
	//////////////////////////////////////////////////////
	@Override
	public String classVersion() {
		return "1.0.0";
	}

	
	/*
	Keys of ClientSite
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
	

	//////////////////////////////////////////////////////
	// Target Relationships
	//////////////////////////////////////////////////////
	@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(contentUsing=BDOSerializer.class)
@JsonDeserialize(contentUsing=BDODeserializer.class)
@OneToMany(fetch=FetchType.LAZY, targetEntity=LOB.class, mappedBy="clientSite", cascade=javax.persistence.CascadeType.REMOVE)
private List<LOB> lOBs;
public List<LOB> getLOBs() {
	return this.lOBs;
}

public void setLOBs(List<LOB> value) {
	this.lOBs = value;
}



	//////////////////////////////////////////////////////
	// Source Relationships
	//////////////////////////////////////////////////////
	@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@JoinColumn(name="CLIENT_ID")
@org.hibernate.annotations.ForeignKey(name="FK_ClientOfClientSite")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private Client client;
public Client getClient() {
	return this.client;
}

public void setClient(Client value) {
	this.client = value;
}@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@JoinColumn(name="SITE_ID")
@org.hibernate.annotations.ForeignKey(name="FK_SiteOfClientSite")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private Site site;
public Site getSite() {
	return this.site;
}

public void setSite(Site value) {
	this.site = value;
}

	
	//////////////////////////////////////////////////////
	// JSON
	//////////////////////////////////////////////////////
	@Override
	public String retrieveJson(ObjectMapper objectMapper) {
		String objectJson = super.retrieveJson(objectMapper);

		// Properties		

				
		// Source Relationships
//Retrieve value of the Client of Client Site relationship
objectJson += ",\"client\":";
		if (getClient() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getClient()).toEmbeddedJson();
			} catch(Exception e) {
				objectJson += "null";
			}
		}
		objectJson += "";
//Retrieve value of the Site of Client Site relationship
objectJson += ",\"site\":";
		if (getSite() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getSite()).toEmbeddedJson();
			} catch(Exception e) {
				objectJson += "null";
			}
		}
		objectJson += "";

		
		// Target Relationships
//Retrieve value of the Client Site of LOB relationship
objectJson += ",\"lOBs\":[";
		
		if (getLOBs() != null) {
			int lOBsCounter = 0;
			for(LOB nextLOBs : getLOBs()) {
				if (lOBsCounter > 0)
					objectJson += ",";
				try {
					objectJson += ((BaseDataObject) nextLOBs).toEmbeddedJson();
					lOBsCounter++;
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

		
		// Source Relationships
		this.client = (Client) JsonUtils.getJsonPerceroObject(jsonObject, "client");
		this.site = (Site) JsonUtils.getJsonPerceroObject(jsonObject, "site");


		// Target Relationships
		this.lOBs = (List<LOB>) JsonUtils.getJsonListPerceroObject(jsonObject, "lOBs");


	}
	
	@Override
	protected List<MappedClassMethodPair> getListSetters() {
		List<MappedClassMethodPair> listSetters = super.getListSetters();

		// Target Relationships
		listSetters.add(MappedClass.getFieldSetters(LOB.class, "clientsite"));

		
		return listSetters;
	}
}
