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

import com.pulse.mo.DiscrepancyDetectedNotification;
import com.pulse.mo.LOBConfigurationEntry;

import com.percero.agents.sync.vo.BaseDataObject;
import com.percero.serial.BDODeserializer;
import com.percero.serial.BDOSerializer;
import com.percero.serial.JsonUtils;

import com.pulse.mo.*;

@MappedSuperclass
/*
*/
public class _Super_AuxEntry extends BaseDataObject implements Serializable
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
	private String name;
	public String getName() {
		return this.name;
	}
	public void setName(String value)
	{
		this.name = value;
	}

	@Column
    @com.percero.agents.sync.metadata.annotations.Externalize
	private Integer eventCount;
	public Integer getEventCount() {
		return this.eventCount;
	}
	public void setEventCount(Integer value)
	{
		this.eventCount = value;
	}


	//////////////////////////////////////////////////////
	// Source Relationships
	//////////////////////////////////////////////////////

	//////////////////////////////////////////////////////
	// Target Relationships
	//////////////////////////////////////////////////////
    @com.percero.agents.sync.metadata.annotations.Externalize
	@JsonSerialize(contentUsing=BDOSerializer.class)
	@JsonDeserialize(contentUsing=BDODeserializer.class)
	@OneToMany(fetch=FetchType.LAZY, targetEntity=DiscrepancyDetectedNotification.class, mappedBy="auxEntry", cascade=javax.persistence.CascadeType.REMOVE)
	private List<DiscrepancyDetectedNotification> notifications;
	public List<DiscrepancyDetectedNotification> getNotifications() {
		return this.notifications;
	}
	public void setNotifications(List<DiscrepancyDetectedNotification> value) {
		this.notifications = value;
	}

	@JsonSerialize(using=BDOSerializer.class)
	@JsonDeserialize(using=BDODeserializer.class)
    @com.percero.agents.sync.metadata.annotations.Externalize
	@JoinColumn(name="lobConfigurationEntry_ID")
	@org.hibernate.annotations.ForeignKey(name="FK_AuxEntry_lobConfigurationEntry_LOBConfigurationEntry")
	@OneToOne(fetch=FetchType.LAZY, mappedBy="auxEntry", cascade=javax.persistence.CascadeType.REMOVE)
	private LOBConfigurationEntry lobConfigurationEntry;
	public LOBConfigurationEntry getLobConfigurationEntry() {
		return this.lobConfigurationEntry;
	}
	public void setLobConfigurationEntry(LOBConfigurationEntry value) {
		this.lobConfigurationEntry = value;
	}



	
	//////////////////////////////////////////////////////
	// JSON
	//////////////////////////////////////////////////////
	@Override
	public String retrieveJson(ObjectMapper objectMapper) {
		String objectJson = super.retrieveJson(objectMapper);

		// Properties
		objectJson += ",\"name\":";
		if (getName() == null)
			objectJson += "null";
		else {
			if (objectMapper == null)
				objectMapper = new ObjectMapper();
			try {
				objectJson += objectMapper.writeValueAsString(getName());
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

		objectJson += ",\"eventCount\":";
		if (getEventCount() == null)
			objectJson += "null";
		else {
			objectJson += getEventCount();
		}

		// Source Relationships
		// Target Relationships
		objectJson += ",\"notifications\":[";
		if (getNotifications() != null) {
			int notificationsCounter = 0;
			for(DiscrepancyDetectedNotification nextNotifications : getNotifications()) {
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

		objectJson += ",\"lobConfigurationEntry\":";
		if (getLobConfigurationEntry() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getLobConfigurationEntry()).toEmbeddedJson();
			} catch(Exception e) {
				objectJson += "null";
			}
		}
		objectJson += "";

		
		return objectJson;
	}

	@Override
	protected void fromJson(JsonObject jsonObject) {
	    super.fromJson(jsonObject);

		// Properties
		setName(JsonUtils.getJsonString(jsonObject, "name"));
		setEventCount(JsonUtils.getJsonInteger(jsonObject, "eventCount"));

		// Source Relationships

		// Target Relationships
		this.notifications = (List<DiscrepancyDetectedNotification>) JsonUtils.getJsonListPerceroObject(jsonObject, "notifications");
		this.lobConfigurationEntry = JsonUtils.getJsonPerceroObject(jsonObject, "lobConfigurationEntry");
	}

	@Override
	protected List<MappedClassMethodPair> getListSetters() {
		List<MappedClassMethodPair> listSetters = super.getListSetters();

		// Target Relationships
		listSetters.add(MappedClass.getFieldSetters(DiscrepancyDetectedNotification.class, "auxEntry"));
		listSetters.add(MappedClass.getFieldSetters(LOBConfigurationEntry.class, "auxEntry"));
	
		return listSetters;
	}
}