
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
import com.pulse.mo.CMSAuxMode;
import com.pulse.mo.DiscrepancyDetectedNotification;
import com.pulse.mo.CMSEntry;
import com.pulse.mo.LOBConfigurationEntry;

*/

@Component
public class CMSAuxModeDAO extends SqlDataAccessObject<CMSAuxMode> implements IDataAccessObject<CMSAuxMode> {

	static final Logger log = Logger.getLogger(CMSAuxModeDAO.class);

	
	public CMSAuxModeDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(CMSAuxMode.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	@Override
	protected String getConnectionFactoryName() {
		return CMSAuxModeDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT CMS_AUX_MODE.ID FROM CMS_AUX_MODE CMS_AUX_MODE WHERE CMS_AUX_MODE.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT CMS_AUX_MODE.ID,CMS_AUX_MODE.NAME,CMS_AUX_MODE.EVENT_COUNT FROM CMS_AUX_MODE CMS_AUX_MODE WHERE CMS_AUX_MODE.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT CMS_AUX_MODE.ID FROM CMS_AUX_MODE CMS_AUX_MODE ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT CMS_AUX_MODE.ID FROM CMS_AUX_MODE CMS_AUX_MODE ORDER BY CMS_AUX_MODE.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT CMS_AUX_MODE.ID,CMS_AUX_MODE.NAME,CMS_AUX_MODE.EVENT_COUNT FROM CMS_AUX_MODE CMS_AUX_MODE ORDER BY CMS_AUX_MODE.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT CMS_AUX_MODE.ID,CMS_AUX_MODE.NAME,CMS_AUX_MODE.EVENT_COUNT FROM CMS_AUX_MODE CMS_AUX_MODE ORDER BY CMS_AUX_MODE.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM CMS_AUX_MODE CMS_AUX_MODE";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT CMS_AUX_MODE.ID,CMS_AUX_MODE.NAME,CMS_AUX_MODE.EVENT_COUNT FROM CMS_AUX_MODE CMS_AUX_MODE WHERE CMS_AUX_MODE.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT CMS_AUX_MODE.ID FROM CMS_AUX_MODE CMS_AUX_MODE WHERE CMS_AUX_MODE.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT CMS_AUX_MODE.ID,CMS_AUX_MODE.NAME,CMS_AUX_MODE.EVENT_COUNT FROM CMS_AUX_MODE CMS_AUX_MODE WHERE CMS_AUX_MODE." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT CMS_AUX_MODE.ID FROM CMS_AUX_MODE CMS_AUX_MODE WHERE CMS_AUX_MODE." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT CMS_AUX_MODE.ID FROM CMS_AUX_MODE CMS_AUX_MODE ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT CMS_AUX_MODE.ID,CMS_AUX_MODE.NAME,CMS_AUX_MODE.EVENT_COUNT FROM CMS_AUX_MODE CMS_AUX_MODE ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO CMS_AUX_MODE (ID,NAME,EVENT_COUNT) VALUES (?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE CMS_AUX_MODE SET NAME=?,EVENT_COUNT=? WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM CMS_AUX_MODE WHERE ID=?";
	}
	
	@Override
	protected CMSAuxMode extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	CMSAuxMode nextResult = new CMSAuxMode();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setName(rs.getString("NAME"));

nextResult.setEventCount(rs.getInt("EVENT_COUNT"));


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(CMSAuxMode perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getName());
pstmt.setInt(3, perceroObject.getEventCount());

		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(CMSAuxMode perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getName());
pstmt.setInt(2, perceroObject.getEventCount());
pstmt.setString(3, perceroObject.getID());

		
	}

	@Override
	public List<CMSAuxMode> findByExample(CMSAuxMode theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useName = StringUtils.hasText(theQueryObject.getName()) && (excludeProperties == null || !excludeProperties.contains("name"));

if (useName)
{
sql += " WHERE ";
sql += " NAME=? ";
paramValues.add(theQueryObject.getName());
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
sql += " EVENT_COUNT=? ";
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
