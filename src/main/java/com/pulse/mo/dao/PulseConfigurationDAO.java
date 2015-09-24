
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
import com.pulse.mo.PulseConfiguration;
import com.pulse.mo.LOB;

*/

@Component
public class PulseConfigurationDAO extends SqlDataAccessObject<PulseConfiguration> implements IDataAccessObject<PulseConfiguration> {

	static final Logger log = Logger.getLogger(PulseConfigurationDAO.class);

	
	public PulseConfigurationDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(PulseConfiguration.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	@Override
	protected String getConnectionFactoryName() {
		return PulseConfigurationDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT pulseconfiguration.ID FROM PulseConfiguration pulseconfiguration WHERE pulseconfiguration.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT pulseconfiguration.ID,pulseconfiguration.externalID,pulseconfiguration.durationTolerance FROM PulseConfiguration pulseconfiguration WHERE pulseconfiguration.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT pulseconfiguration.ID FROM PulseConfiguration pulseconfiguration ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT pulseconfiguration.ID FROM PulseConfiguration pulseconfiguration ORDER BY pulseconfiguration.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT pulseconfiguration.ID,pulseconfiguration.externalID,pulseconfiguration.durationTolerance FROM PulseConfiguration pulseconfiguration ORDER BY pulseconfiguration.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT pulseconfiguration.ID,pulseconfiguration.externalID,pulseconfiguration.durationTolerance FROM PulseConfiguration pulseconfiguration ORDER BY pulseconfiguration.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM PulseConfiguration pulseconfiguration";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT pulseconfiguration.ID,pulseconfiguration.externalID,pulseconfiguration.durationTolerance FROM PulseConfiguration pulseconfiguration WHERE pulseconfiguration.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT pulseconfiguration.ID FROM PulseConfiguration pulseconfiguration WHERE pulseconfiguration.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT pulseconfiguration.ID,pulseconfiguration.externalID,pulseconfiguration.durationTolerance FROM PulseConfiguration pulseconfiguration WHERE pulseconfiguration." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT pulseconfiguration.ID FROM PulseConfiguration pulseconfiguration WHERE pulseconfiguration." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT pulseconfiguration.ID FROM PulseConfiguration pulseconfiguration ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT pulseconfiguration.ID,pulseconfiguration.externalID,pulseconfiguration.durationTolerance FROM PulseConfiguration pulseconfiguration ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO PulseConfiguration (ID,externalID,durationTolerance) VALUES (?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE PulseConfiguration SET externalID=?,durationTolerance=? WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM PulseConfiguration WHERE ID=?";
	}
	
	@Override
	protected PulseConfiguration extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	PulseConfiguration nextResult = new PulseConfiguration();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setExternalID(rs.getString("externalID"));

nextResult.setDurationTolerance(rs.getInt("durationTolerance"));


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(PulseConfiguration perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getExternalID());
pstmt.setInt(3, perceroObject.getDurationTolerance());

		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(PulseConfiguration perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getExternalID());
pstmt.setInt(2, perceroObject.getDurationTolerance());
pstmt.setString(3, perceroObject.getID());

		
	}

	@Override
	public List<PulseConfiguration> findByExample(PulseConfiguration theQueryObject,
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

boolean useDurationTolerance = theQueryObject.getDurationTolerance() != null && (excludeProperties == null || !excludeProperties.contains("durationTolerance"));

if (useDurationTolerance)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " durationTolerance=? ";
paramValues.add(theQueryObject.getDurationTolerance());
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
