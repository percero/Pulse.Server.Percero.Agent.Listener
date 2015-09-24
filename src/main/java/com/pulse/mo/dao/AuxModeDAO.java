
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
import com.pulse.mo.AuxMode;
import com.pulse.mo.DiscrepancyDetectedNotification;
import com.pulse.mo.ActualTimeEntry;
import com.pulse.mo.LOBConfigurationEntry;

*/

@Component
public class AuxModeDAO extends SqlDataAccessObject<AuxMode> implements IDataAccessObject<AuxMode> {

	static final Logger log = Logger.getLogger(AuxModeDAO.class);

	
	public AuxModeDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(AuxMode.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	@Override
	protected String getConnectionFactoryName() {
		return AuxModeDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT auxmode.ID FROM AuxMode auxmode WHERE auxmode.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT auxmode.ID,auxmode.name,auxmode.externalID,auxmode.eventCount FROM AuxMode auxmode WHERE auxmode.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT auxmode.ID FROM AuxMode auxmode ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT auxmode.ID FROM AuxMode auxmode ORDER BY auxmode.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT auxmode.ID,auxmode.name,auxmode.externalID,auxmode.eventCount FROM AuxMode auxmode ORDER BY auxmode.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT auxmode.ID,auxmode.name,auxmode.externalID,auxmode.eventCount FROM AuxMode auxmode ORDER BY auxmode.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM AuxMode auxmode";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT auxmode.ID,auxmode.name,auxmode.externalID,auxmode.eventCount FROM AuxMode auxmode WHERE auxmode.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT auxmode.ID FROM AuxMode auxmode WHERE auxmode.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT auxmode.ID,auxmode.name,auxmode.externalID,auxmode.eventCount FROM AuxMode auxmode WHERE auxmode." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT auxmode.ID FROM AuxMode auxmode WHERE auxmode." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT auxmode.ID FROM AuxMode auxmode ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT auxmode.ID,auxmode.name,auxmode.externalID,auxmode.eventCount FROM AuxMode auxmode ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO AuxMode (ID,name,externalID,eventCount) VALUES (?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE AuxMode SET name=?,externalID=?,eventCount=? WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM AuxMode WHERE ID=?";
	}
	
	@Override
	protected AuxMode extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	AuxMode nextResult = new AuxMode();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setName(rs.getString("name"));

nextResult.setExternalID(rs.getString("externalID"));

nextResult.setEventCount(rs.getInt("eventCount"));


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(AuxMode perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getName());
pstmt.setString(3, perceroObject.getExternalID());
pstmt.setInt(4, perceroObject.getEventCount());

		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(AuxMode perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getName());
pstmt.setString(2, perceroObject.getExternalID());
pstmt.setInt(3, perceroObject.getEventCount());
pstmt.setString(4, perceroObject.getID());

		
	}

	@Override
	public List<AuxMode> findByExample(AuxMode theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useName = StringUtils.hasText(theQueryObject.getName()) && (excludeProperties == null || !excludeProperties.contains("name"));

if (useName)
{
sql += " WHERE ";
paramValues.add(theQueryObject.getName());
propertyCounter++;
}

boolean useExternalID = StringUtils.hasText(theQueryObject.getExternalID()) && (excludeProperties == null || !excludeProperties.contains("externalID"));

if (useExternalID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " externalID=? ";
paramValues.add(theQueryObject.getExternalID());
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
