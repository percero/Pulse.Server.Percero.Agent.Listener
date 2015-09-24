
package com.pulse.mo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.percero.util.DateUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.percero.agents.sync.dao.DAORegistry;
import com.percero.agents.sync.dao.IDataAccessObject;
import com.percero.agents.sync.exceptions.SyncException;

import com.pulse.mo.*;

/*
import com.pulse.mo.EStartActivityCode;
import com.pulse.mo.DiscrepancyDetectedNotification;
import com.pulse.mo.AgentTimeEntry;
import com.pulse.mo.LOBConfigurationEntry;
import com.pulse.mo.ChangesNotApprovedNotification;

*/

@Component
public class EStartActivityCodeDAO extends SqlDataAccessObject<EStartActivityCode> implements IDataAccessObject<EStartActivityCode> {

	static final Logger log = Logger.getLogger(EStartActivityCodeDAO.class);

	
	public EStartActivityCodeDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(EStartActivityCode.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	@Override
	protected String getConnectionFactoryName() {
		return EStartActivityCodeDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT estartactivitycode.ID FROM EStartActivityCode estartactivitycode WHERE estartactivitycode.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT estartactivitycode.ID,estartactivitycode.externalID,estartactivitycode.name,estartactivitycode.nonBillable,estartactivitycode.code,estartactivitycode.description,estartactivitycode.eventCount FROM EStartActivityCode estartactivitycode WHERE estartactivitycode.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT estartactivitycode.ID FROM EStartActivityCode estartactivitycode ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT estartactivitycode.ID FROM EStartActivityCode estartactivitycode ORDER BY estartactivitycode.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT estartactivitycode.ID,estartactivitycode.externalID,estartactivitycode.name,estartactivitycode.nonBillable,estartactivitycode.code,estartactivitycode.description,estartactivitycode.eventCount FROM EStartActivityCode estartactivitycode ORDER BY estartactivitycode.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT estartactivitycode.ID,estartactivitycode.externalID,estartactivitycode.name,estartactivitycode.nonBillable,estartactivitycode.code,estartactivitycode.description,estartactivitycode.eventCount FROM EStartActivityCode estartactivitycode ORDER BY estartactivitycode.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM EStartActivityCode estartactivitycode";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT estartactivitycode.ID,estartactivitycode.externalID,estartactivitycode.name,estartactivitycode.nonBillable,estartactivitycode.code,estartactivitycode.description,estartactivitycode.eventCount FROM EStartActivityCode estartactivitycode WHERE estartactivitycode.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT estartactivitycode.ID FROM EStartActivityCode estartactivitycode WHERE estartactivitycode.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT estartactivitycode.ID,estartactivitycode.externalID,estartactivitycode.name,estartactivitycode.nonBillable,estartactivitycode.code,estartactivitycode.description,estartactivitycode.eventCount FROM EStartActivityCode estartactivitycode WHERE estartactivitycode." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT estartactivitycode.ID FROM EStartActivityCode estartactivitycode WHERE estartactivitycode." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT estartactivitycode.ID FROM EStartActivityCode estartactivitycode ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT estartactivitycode.ID,estartactivitycode.externalID,estartactivitycode.name,estartactivitycode.nonBillable,estartactivitycode.code,estartactivitycode.description,estartactivitycode.eventCount FROM EStartActivityCode estartactivitycode ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO EStartActivityCode (ID,externalID,name,nonBillable,code,description,eventCount) VALUES (?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE EStartActivityCode SET externalID=?,name=?,nonBillable=?,code=?,description=?,eventCount=? WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM EStartActivityCode WHERE ID=?";
	}
	
	@Override
	protected EStartActivityCode extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	EStartActivityCode nextResult = new EStartActivityCode();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setExternalID(rs.getString("externalID"));

nextResult.setName(rs.getString("name"));

nextResult.setNonBillable(rs.getBoolean("nonBillable"));

nextResult.setCode(rs.getString("code"));

nextResult.setDescription(rs.getString("description"));

nextResult.setEventCount(rs.getInt("eventCount"));


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(EStartActivityCode perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getExternalID());
pstmt.setString(3, perceroObject.getName());
pstmt.setBoolean(4, perceroObject.getNonBillable());
pstmt.setString(5, perceroObject.getCode());
pstmt.setString(6, perceroObject.getDescription());
pstmt.setInt(7, perceroObject.getEventCount());

		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(EStartActivityCode perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getExternalID());
pstmt.setString(2, perceroObject.getName());
pstmt.setBoolean(3, perceroObject.getNonBillable());
pstmt.setString(4, perceroObject.getCode());
pstmt.setString(5, perceroObject.getDescription());
pstmt.setInt(6, perceroObject.getEventCount());
pstmt.setString(7, perceroObject.getID());

		
	}

	@Override
	public List<EStartActivityCode> findByExample(EStartActivityCode theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useExternalID = StringUtils.hasText(theQueryObject.getExternalID()) && (excludeProperties == null || !excludeProperties.contains("externalID"));

if (useExternalID)
{
sql += " WHERE ";
paramValues.add(theQueryObject.getExternalID());
propertyCounter++;
}

boolean useName = StringUtils.hasText(theQueryObject.getName()) && (excludeProperties == null || !excludeProperties.contains("name"));

if (useName)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " name=? ";
paramValues.add(theQueryObject.getName());
propertyCounter++;
}

boolean useNonBillable = theQueryObject.getNonBillable() != null && (excludeProperties == null || !excludeProperties.contains("nonBillable"));

if (useNonBillable)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " nonBillable=? ";
paramValues.add(theQueryObject.getNonBillable());
propertyCounter++;
}

boolean useCode = StringUtils.hasText(theQueryObject.getCode()) && (excludeProperties == null || !excludeProperties.contains("code"));

if (useCode)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " code=? ";
paramValues.add(theQueryObject.getCode());
propertyCounter++;
}

boolean useDescription = StringUtils.hasText(theQueryObject.getDescription()) && (excludeProperties == null || !excludeProperties.contains("description"));

if (useDescription)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " description=? ";
paramValues.add(theQueryObject.getDescription());
propertyCounter++;
}

boolean useEventCount = theQueryObject.getEventCount() != null && (excludeProperties == null || !excludeProperties.contains("eventCount"));

if (useEventCount)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " eventCount=? ";
paramValues.add(theQueryObject.getEventCount());
propertyCounter++;
}


		/*
		boolean useValue = StringUtils.hasText(theQueryObject.getValue()) && (excludeProperties == null || !excludeProperties.contains("value"));
		
		if (useValue) {
			sql += " WHERE value=? ";
			paramValues.add(theQueryObject.getValue());
			propertyCounter++;
		}
		
		boolean usePersonId = theQueryObject.getPerson() != null && (excludeProperties == null || !excludeProperties.contains("person"));
		
		if (usePersonId) {
			if (propertyCounter > 0) {
				sql += " AND ";
			}
			else {
				sql += " WHERE ";
			}
			sql += " person_ID=? ";
			paramValues.add(theQueryObject.getPerson().getID());
			propertyCounter++;
		}
		
		*/
		
		return executeSelectWithParams(sql, paramValues.toArray(), shellOnly);		
	}
	
}
