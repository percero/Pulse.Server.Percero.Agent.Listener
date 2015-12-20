

package com.pulse.mo.mo_super;

import com.google.gson.JsonObject;
import com.percero.agents.sync.metadata.MappedClass;
import com.percero.agents.sync.metadata.MappedClass.MappedClassMethodPair;
import com.percero.agents.sync.vo.BaseDataObject;
import com.percero.serial.BDODeserializer;
import com.percero.serial.BDOSerializer;
import com.percero.serial.JsonUtils;
import com.pulse.mo.LOB;
import com.pulse.mo.LOBConfiguration;
import com.pulse.mo.LOBConfigurationEntry;
import com.pulse.mo.LOBConfigurationNotification;
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
public class _Super_LOBConfigurationActivityAuxCode extends BaseDataObject implements Serializable {
    //////////////////////////////////////////////////////
    // VERSION
    //////////////////////////////////////////////////////
    @Override
    public String classVersion() {
        return "1.0.0";
    }


    /*
    Keys of LOBConfiguration
    */
    //////////////////////////////////////////////////////
// ID
//////////////////////////////////////////////////////
    @Id
    @com.percero.agents.sync.metadata.annotations.Externalize
    @Column(unique = true, name = "ID")
    private String ID;

    @JsonProperty(value = "ID")
    public String getID() {
        return this.ID;
    }

    @JsonProperty(value = "ID")
    public void setID(String value) {
        this.ID = value;
    }

    //////////////////////////////////////////////////////
    // Properties
    //////////////////////////////////////////////////////


    //////////////////////////////////////////////////////
    // Target Relationships
    //////////////////////////////////////////////////////
//	@com.percero.agents.sync.metadata.annotations.Externalize
//@JsonSerialize(contentUsing=BDOSerializer.class)
//@JsonDeserialize(contentUsing=BDODeserializer.class)
//@OneToMany(fetch=FetchType.LAZY, targetEntity=LOBConfigurationNotification.class, mappedBy="lOBConfiguration", cascade=javax.persistence.CascadeType.REMOVE)
//private List<LOBConfigurationNotification> lOBConfigurationNotifications;
//public List<LOBConfigurationNotification> getLOBConfigurationNotifications() {
//	return this.lOBConfigurationNotifications;
//}
//
//public void setLOBConfigurationNotifications(List<LOBConfigurationNotification> value) {
//	this.lOBConfigurationNotifications = value;
//}


    @com.percero.agents.sync.metadata.annotations.Externalize
    @JsonSerialize(using = BDOSerializer.class)
    @JsonDeserialize(using = BDODeserializer.class)
    @JoinColumn(name = "ID")
    @org.hibernate.annotations.ForeignKey(name = "FK_LOBConfigurationActivityAuxCodeOfLOBConfigurationEntry")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private LOBConfigurationEntry lOBConfigurationEntry;

    public LOBConfigurationEntry getLOBConfigurationEntry() {
        return this.lOBConfigurationEntry;
    }

    public void setLOBConfigurationEntry(LOBConfigurationEntry value) {
        this.lOBConfigurationEntry = value;
    }
    //////////////////////////////////////////////////////
    // Source Relationships
    //////////////////////////////////////////////////////

    @com.percero.agents.sync.metadata.annotations.Externalize
    @JsonSerialize(using = BDOSerializer.class)
    @JsonDeserialize(using = BDODeserializer.class)
    @JoinColumn(name = "CMS_AUX_CODE")
    @org.hibernate.annotations.ForeignKey(name = "FK_CMSAuxCodeOfLOBConfiguration")
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    private String cMSAuxCode;

    public String getCMSAuxCode() {
        return this.cMSAuxCode;
    }

    public void setCMSAuxCode(String value) {
        this.cMSAuxCode = value;
    }


    //////////////////////////////////////////////////////
    // JSON
    //////////////////////////////////////////////////////
    @Override
    public String retrieveJson(ObjectMapper objectMapper) {
        String objectJson = super.retrieveJson(objectMapper);

        // Properties


        // Source Relationships
        objectJson += ",\"cMSAuxCode\":";
        if (getCMSAuxCode() == null)
            objectJson += "null";
        else {
            if (objectMapper == null)
                objectMapper = new ObjectMapper();
            try {
                objectJson += objectMapper.writeValueAsString(getCMSAuxCode());
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

        return objectJson;
    }


    @Override
    protected void fromJson(JsonObject jsonObject) {
        super.fromJson(jsonObject);

        // Properties


        // Source Relationships
        setCMSAuxCode(JsonUtils.getJsonString(jsonObject, "cMSAuxCode"));
        this.lOBConfigurationEntry = (LOBConfigurationEntry) JsonUtils.getJsonPerceroObject(jsonObject, "lOBConfigurationEntry");

        // Target Relationships
//		this.lOBConfigurationNotifications = (List<LOBConfigurationNotification>) JsonUtils.getJsonListPerceroObject(jsonObject, "lOBConfigurationNotifications");


    }

    @Override
    protected List<MappedClassMethodPair> getListSetters() {
        List<MappedClassMethodPair> listSetters = super.getListSetters();

        // Target Relationships
		listSetters.add(MappedClass.getFieldSetters(LOBConfigurationEntry.class, "lOBConfigurationActivityAuxCode"));
//		listSetters.add(MappedClass.getFieldSetters(LOBConfigurationEntry.class, "lobConfiguration"));


        return listSetters;
    }
}

