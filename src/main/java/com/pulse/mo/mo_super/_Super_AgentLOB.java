

package com.pulse.mo.mo_super;

import com.google.gson.JsonObject;
import com.percero.agents.sync.metadata.MappedClass;
import com.percero.agents.sync.metadata.MappedClass.MappedClassMethodPair;
import com.percero.agents.sync.vo.BaseDataObject;
import com.percero.serial.BDODeserializer;
import com.percero.serial.BDOSerializer;
import com.percero.serial.JsonUtils;
import com.pulse.mo.Agent;
import com.pulse.mo.CMSEntry;
import com.pulse.mo.LOB;
import com.pulse.mo.QualityEvaluation;
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
public class _Super_AgentLOB extends BaseDataObject implements Serializable {
    //////////////////////////////////////////////////////
    // VERSION
    //////////////////////////////////////////////////////
    @Override
    public String classVersion() {
        return "1.0.0";
    }


    /*
    Keys of AgentLOB
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
    // Target Relationships
    //////////////////////////////////////////////////////
    @com.percero.agents.sync.metadata.annotations.Externalize
    @JsonSerialize(using = BDOSerializer.class)
    @JsonDeserialize(using = BDODeserializer.class)
    @JoinColumn(name = "ECP_LOB_ID")
    @org.hibernate.annotations.ForeignKey(name = "FK_LOBOfAgentLOB")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private LOB lOB;

    public LOB getLOB() {
        return this.lOB;
    }

    public void setLOB(LOB value) {
        this.lOB = value;
    }

    //////////////////////////////////////////////////////
    // Source Relationships
    //////////////////////////////////////////////////////


    @com.percero.agents.sync.metadata.annotations.Externalize
    @JsonSerialize(using = BDOSerializer.class)
    @JsonDeserialize(using = BDODeserializer.class)
    @JoinColumn(name = "EMPLOYEE_ID")
    @org.hibernate.annotations.ForeignKey(name = "FK_AgentOfAgentLOB")
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    private Agent agent;

    public Agent getAgent() {
        return this.agent;
    }


    public void setAgent(Agent value)
    {
        this.agent = value;
    }

    //////////////////////////////////////////////////////
    // JSON
    //////////////////////////////////////////////////////
    @Override
    public String retrieveJson(ObjectMapper objectMapper) {
        String objectJson = super.retrieveJson(objectMapper);

        // Properties


        // Source Relationships
//Retrieve value of the LOB of CMS Entry LOB relationship
        objectJson += ",\"lOB\":";
        if (getLOB() == null)
            objectJson += "null";
        else {
            try {
                objectJson += ((BaseDataObject) getLOB()).toEmbeddedJson();
            } catch (Exception e) {
                objectJson += "null";
            }
        }
        objectJson += "";

        //Retrieve value of the Agent of Agent Scorecard relationship
        objectJson += ",\"agent\":";
        if (getAgent() == null)
            objectJson += "null";
        else {
            try {
                objectJson += ((BaseDataObject) getAgent()).toEmbeddedJson();
            } catch (Exception e) {
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
        this.agent = (Agent) JsonUtils.getJsonPerceroObject(jsonObject, "agent");
        // Target Relationships
        this.lOB = (LOB) JsonUtils.getJsonPerceroObject(jsonObject, "lOB");

    }

    @Override
    protected List<MappedClassMethodPair> getListSetters() {
        List<MappedClassMethodPair> listSetters = super.getListSetters();

        listSetters.add(MappedClass.getFieldSetters(Agent.class, "agent"));

        // Target Relationships

        listSetters.add(MappedClass.getFieldSetters(LOB.class, "agentLOB"));

        return listSetters;
    }
}

