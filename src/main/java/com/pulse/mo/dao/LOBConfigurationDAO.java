
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
import com.pulse.mo.LOBConfiguration;
import com.pulse.mo.LOBConfigurationNotification;
import com.pulse.mo.LOBConfigurationEntry;
import com.pulse.mo.LOB;

*/

@Component
public class LOBConfigurationDAO extends SqlDataAccessObject<LOBConfiguration> implements IDataAccessObject<LOBConfiguration> {

	static final Logger log = Logger.getLogger(LOBConfigurationDAO.class);

	
	public LOBConfigurationDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(LOBConfiguration.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	@Override
	protected String getConnectionFactoryName() {
		return LOBConfigurationDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT lobconfiguration.ID FROM LOBConfiguration lobconfiguration WHERE lobconfiguration.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT lobconfiguration.ID,lobconfiguration.externalID,lobconfiguration.lOB_ID FROM LOBConfiguration lobconfiguration WHERE lobconfiguration.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT lobconfiguration.ID FROM LOBConfiguration lobconfiguration ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT lobconfiguration.ID FROM LOBConfiguration lobconfiguration ORDER BY lobconfiguration.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT lobconfiguration.ID,lobconfiguration.externalID,lobconfiguration.lOB_ID FROM LOBConfiguration lobconfiguration ORDER BY lobconfiguration.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT lobconfiguration.ID,lobconfiguration.externalID,lobconfiguration.lOB_ID FROM LOBConfiguration lobconfiguration ORDER BY lobconfiguration.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM LOBConfiguration lobconfiguration";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT lobconfiguration.ID,lobconfiguration.externalID,lobconfiguration.lOB_ID FROM LOBConfiguration lobconfiguration WHERE lobconfiguration.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT lobconfiguration.ID FROM LOBConfiguration lobconfiguration WHERE lobconfiguration.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT lobconfiguration.ID,lobconfiguration.externalID,lobconfiguration.lOB_ID FROM LOBConfiguration lobconfiguration WHERE lobconfiguration." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT lobconfiguration.ID FROM LOBConfiguration lobconfiguration WHERE lobconfiguration." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT lobconfiguration.ID FROM LOBConfiguration lobconfiguration ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT lobconfiguration.ID,lobconfiguration.externalID,lobconfiguration.lOB_ID FROM LOBConfiguration lobconfiguration ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO LOBConfiguration (ID,externalID,lOB_ID) VALUES (?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE LOBConfiguration SET externalID=?,lOB_ID=? WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM LOBConfiguration WHERE ID=?";
	}
	
	@Override
	protected LOBConfiguration extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	LOBConfiguration nextResult = new LOBConfiguration();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setExternalID(rs.getString("externalID"));

LOB lob = new LOB();
lob.setID(rs.getString("lob_ID"));
nextResult.setLOB(lob);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(LOBConfiguration perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getExternalID());

if (perceroObject.getLOB() == null)
{
pstmt.setString(3, null);
}
else
{
		pstmt.setString(3, perceroObject.getLOB().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(LOBConfiguration perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getExternalID());

if (perceroObject.getLOB() == null)
{
pstmt.setString(2, null);
}
else
{
		pstmt.setString(2, perceroObject.getLOB().getID());
}

pstmt.setString(3, perceroObject.getID());

		
	}

	@Override
	public List<LOBConfiguration> findByExample(LOBConfiguration theQueryObject,
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

boolean useLOBID = theQueryObject.getLOB() != null && (excludeProperties == null || !excludeProperties.contains("lOB"));

if (useLOBID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " lOBID=? ";
paramValues.add(theQueryObject.getLOB().getID());
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
