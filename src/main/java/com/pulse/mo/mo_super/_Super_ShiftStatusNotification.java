
package com.pulse.mo.mo_super;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.SecondaryTable;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.google.gson.JsonObject;
import com.percero.agents.sync.metadata.MappedClass.MappedClassMethodPair;
import com.percero.agents.sync.vo.BaseDataObject;
import com.percero.serial.BDODeserializer;
import com.percero.serial.BDOSerializer;
import com.percero.serial.JsonUtils;
import com.pulse.mo.Notification;
import com.pulse.mo.TimecardActivity;
/*
Imports based on semantic requirements
*/

/*
Entity Tags based on semantic requirements
*/
@SecondaryTable(name="ShiftStatusNotification")
@MappedSuperclass
public class _Super_ShiftStatusNotification extends Notification implements Serializable
{
	//////////////////////////////////////////////////////
	// VERSION
	//////////////////////////////////////////////////////
	@Override
	public String classVersion() {
		return "1.0.0";
	}

	
	/*
	Keys of ShiftStatusNotification
	*/
	
	
	//////////////////////////////////////////////////////
	// Properties
	//////////////////////////////////////////////////////
	/*
ShiftEndDate
Notes:
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Date shiftEndDate;

public Date getShiftEndDate() 
{
	return this.shiftEndDate;
}

public void setShiftEndDate(Date shiftEndDate)
{
	this.shiftEndDate = shiftEndDate;
}/*
Resolved
Notes:Flag that determines if the notification has been resolved
*/
@Column
@com.percero.agents.sync.metadata.annotations.Externalize

private Boolean resolved;

public Boolean getResolved() 
{
	return this.resolved;
}

public void setResolved(Boolean resolved)
{
	this.resolved = resolved;
}

	//////////////////////////////////////////////////////
	// Target Relationships
	//////////////////////////////////////////////////////
	

	//////////////////////////////////////////////////////
	// Source Relationships
	//////////////////////////////////////////////////////
	@com.percero.agents.sync.metadata.annotations.Externalize
@JsonSerialize(using=BDOSerializer.class)
@JsonDeserialize(using=BDODeserializer.class)
@JoinColumn(name="TIMECARD_ACTIVITY_ID")
@org.hibernate.annotations.ForeignKey(name="FK_TimecardActivityOfShiftStatusNotification")
@ManyToOne(fetch=FetchType.LAZY, optional=false)
private TimecardActivity timecardActivity;
public TimecardActivity getTimecardActivity() {
	return this.timecardActivity;
}

public void setTimecardActivity(TimecardActivity value) {
	this.timecardActivity = value;
}

	

	//////////////////////////////////////////////////////
	// JSON
	//////////////////////////////////////////////////////
	@Override
	public String retrieveJson(ObjectMapper objectMapper) {
		String objectJson = super.retrieveJson(objectMapper);

		// Properties		
		//Retrieve value of the Shift End Date property
		objectJson += ",\"shiftEndDate\":";
		if (getShiftEndDate() == null)
			objectJson += "null";
		else {
			objectJson += getShiftEndDate().getTime();
		}
		//Retrieve value of the Resolved property
		objectJson += ",\"resolved\":";
		if (getResolved() == null)
			objectJson += "null";
		else {
			objectJson += getResolved();
		}

				
		// Source Relationships
//Retrieve value of the Timecard Activity of Shift Status Notification relationship
objectJson += ",\"timecardActivity\":";
		if (getTimecardActivity() == null)
			objectJson += "null";
		else {
			try {
				objectJson += ((BaseDataObject) getTimecardActivity()).toEmbeddedJson();
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
		//From value of the Shift End Date property
		setShiftEndDate(JsonUtils.getJsonDate(jsonObject, "shiftEndDate"));
		//From value of the Resolved property
		setResolved(JsonUtils.getJsonBoolean(jsonObject, "resolved"));

		
		// Source Relationships
		this.timecardActivity = (TimecardActivity) JsonUtils.getJsonPerceroObject(jsonObject, "timecardActivity");


		// Target Relationships


	}
	
	@Override
	protected List<MappedClassMethodPair> getListSetters() {
		List<MappedClassMethodPair> listSetters = super.getListSetters();

		// Target Relationships

		
		return listSetters;
	}
}
