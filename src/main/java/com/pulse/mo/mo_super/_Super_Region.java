

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
public class _Super_Region extends BaseDataObject implements Serializable
{
    //////////////////////////////////////////////////////
    // VERSION
    //////////////////////////////////////////////////////
    @Override
    public String classVersion() {
        return "1.0.0";
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
	/*
Name
Notes:
*/
    @Column
    @com.percero.agents.sync.metadata.annotations.Externalize

    private String name;

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }


    /*
geocode
Notes:
*/
    @Column
    @com.percero.agents.sync.metadata.annotations.Externalize

    private String geoCode;

    public String getGeoCode()
    {
        return this.geoCode;
    }

    public void setGeoCode(String geoCode)
    {
        this.geoCode = geoCode;
    }

    //////////////////////////////////////////////////////
    // Target Relationships
    //////////////////////////////////////////////////////
    @com.percero.agents.sync.metadata.annotations.Externalize
    @JsonSerialize(contentUsing=BDOSerializer.class)
    @JsonDeserialize(contentUsing=BDODeserializer.class)
    @OneToMany(fetch=FetchType.LAZY, targetEntity=AdhocCoachingCategory.class, mappedBy="region", cascade=javax.persistence.CascadeType.REMOVE)
    private List<AdhocCoachingCategory> adhocCoachingCategories;
    public List<AdhocCoachingCategory> getAdhocCoachingCategories() {
        return this.adhocCoachingCategories;
    }

    public void setAdhocCoachingCategories(List<AdhocCoachingCategory> value) {
        this.adhocCoachingCategories = value;
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
        //Retrieve value of the Name property
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

        objectJson += ",\"geoCode\":";

        if (getGeoCode() == null)
            objectJson += "null";
        else {
            if (objectMapper == null)
                objectMapper = new ObjectMapper();
            try {
                objectJson += objectMapper.writeValueAsString(getGeoCode());
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
        //Retrieve value of the Agent of Corrective Action relationship
        objectJson += ",\"adhocCoachingCategories\":[";

        if (getAdhocCoachingCategories() != null) {
            int adhocCoachingCategoriesCounter = 0;
            for(AdhocCoachingCategory nextAdhocCoachingCategories : getAdhocCoachingCategories()) {
                if (adhocCoachingCategoriesCounter > 0)
                    objectJson += ",";
                try {
                    objectJson += ((BaseDataObject) nextAdhocCoachingCategories).toEmbeddedJson();
                    adhocCoachingCategoriesCounter++;
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
        //From value of the Name property
        setName(JsonUtils.getJsonString(jsonObject, "name"));
        setGeoCode(JsonUtils.getJsonString(jsonObject, "geoCode"));


        // Source Relationships


        // Target Relationships
        this.adhocCoachingCategories = (List<AdhocCoachingCategory>) JsonUtils.getJsonListPerceroObject(jsonObject, "adhocCoachingCategories");


    }

    @Override
    protected List<MappedClassMethodPair> getListSetters() {
        List<MappedClassMethodPair> listSetters = super.getListSetters();

        // Target Relationships
        listSetters.add(MappedClass.getFieldSetters(AdhocCoachingCategory.class, "region"));

        return listSetters;
    }
}
