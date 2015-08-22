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

import com.pulse.mo.EStartActivityCode;
import com.pulse.mo.AuxEntry;

import com.percero.agents.sync.vo.BaseDataObject;
import com.percero.serial.BDODeserializer;
import com.percero.serial.BDOSerializer;
import com.percero.serial.JsonUtils;

import com.pulse.mo.*;

@MappedSuperclass
@SecondaryTable(name="DiscrepancyDetectedNotification")
/*
*/
public class _Super_DiscrepancyDetectedNotification extends com.pulse.mo.Notification
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
	/** Inherits from another Model Object Class, so no ID here. **/
	
	//////////////////////////////////////////////////////
	// Properties
	//////////////////////////////////////////////////////

	//////////////////////////////////////////////////////
	// Source Relationships
	//////////////////////////////////////////////////////
    @com.percero.agents.sync.metadata.annotations.Externalize
	@JsonSerialize(using=BDOSerializer.class)
	@JsonDeserialize(using=BDODeserializer.class)
	@JoinColumn(name="eStartActivityCode_ID")
	@org.hibernate.annotations.ForeignKey(name="FK_EStartActivityCode_eStartActivityCode_TO_DiscrepancyDetectedNotification")
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	private EStartActivityCode eStartActivityCode;
	public EStartActivityCode getEStartActivityCode() {
		return this.eStartActivityCode;
	}
	public void setEStartActivityCode(EStartActivityCode value) {
		this.eStartActivityCode = value;
	}

    @com.percero.agents.sync.metadata.annotations.Externalize
	@JsonSerialize(using=BDOSerializer.class)
	@JsonDeserialize(using=BDODeserializer.class)
	@JoinColumn(name="auxEntry_ID")
	@org.hibernate.annotations.ForeignKey(name="FK_AuxEntry_auxEntry_TO_DiscrepancyDetectedNotification")
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	private AuxEntry auxEntry;
	public AuxEntry getAuxEntry() {
		return this.auxEntry;
	}
	public void setAuxEntry(AuxEntry value) {
		this.auxEntry = value;
	}


	//////////////////////////////////////////////////////
	// Target Relationships
	//////////////////////////////////////////////////////


	
	//////////////////////////////////////////////////////
	// JSON
	//////////////////////////////////////////////////////
	@Override
	public String retrieveJson(ObjectMapper objectMapper) {
		String objectJson = super.retrieveJson(objectMapper);

		// Properties
		// Source Relationships
		objectJson += ",\"eStartActivityCode\":";
		if (getEStartActivityCode() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getEStartActivityCode()).toEmbeddedJson();
			} catch(Exception e) {
				objectJson += "null";
			}
		}
		objectJson += "";

		objectJson += ",\"auxEntry\":";
		if (getAuxEntry() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getAuxEntry()).toEmbeddedJson();
			} catch(Exception e) {
				objectJson += "null";
			}
		}
		objectJson += "";

		// Target Relationships
		
		return objectJson;
	}

	@Override
	protected void fromJson(JsonObject jsonObject) {
	    super.fromJson(jsonObject);

		// Properties

		// Source Relationships
        this.eStartActivityCode = JsonUtils.getJsonPerceroObject(jsonObject, "eStartActivityCode");
        this.auxEntry = JsonUtils.getJsonPerceroObject(jsonObject, "auxEntry");

		// Target Relationships
	}

	@Override
	protected List<MappedClassMethodPair> getListSetters() {
		List<MappedClassMethodPair> listSetters = super.getListSetters();

		// Target Relationships
	
		return listSetters;
	}
}