
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
		return "SELECT PULSE_CONFIGURATION.ID FROM PULSE_CONFIGURATION PULSE_CONFIGURATION WHERE PULSE_CONFIGURATION.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT PULSE_CONFIGURATION.ID,PULSE_CONFIGURATION.DURATION_TOLERANCE FROM PULSE_CONFIGURATION PULSE_CONFIGURATION WHERE PULSE_CONFIGURATION.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT PULSE_CONFIGURATION.ID FROM PULSE_CONFIGURATION PULSE_CONFIGURATION ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT PULSE_CONFIGURATION.ID FROM PULSE_CONFIGURATION PULSE_CONFIGURATION ORDER BY PULSE_CONFIGURATION.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT PULSE_CONFIGURATION.ID,PULSE_CONFIGURATION.DURATION_TOLERANCE FROM PULSE_CONFIGURATION PULSE_CONFIGURATION ORDER BY PULSE_CONFIGURATION.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT PULSE_CONFIGURATION.ID,PULSE_CONFIGURATION.DURATION_TOLERANCE FROM PULSE_CONFIGURATION PULSE_CONFIGURATION ORDER BY PULSE_CONFIGURATION.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM PULSE_CONFIGURATION PULSE_CONFIGURATION";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT PULSE_CONFIGURATION.ID,PULSE_CONFIGURATION.DURATION_TOLERANCE FROM PULSE_CONFIGURATION PULSE_CONFIGURATION WHERE PULSE_CONFIGURATION.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT PULSE_CONFIGURATION.ID FROM PULSE_CONFIGURATION PULSE_CONFIGURATION WHERE PULSE_CONFIGURATION.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT PULSE_CONFIGURATION.ID,PULSE_CONFIGURATION.DURATION_TOLERANCE FROM PULSE_CONFIGURATION PULSE_CONFIGURATION WHERE PULSE_CONFIGURATION." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT PULSE_CONFIGURATION.ID FROM PULSE_CONFIGURATION PULSE_CONFIGURATION WHERE PULSE_CONFIGURATION." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT PULSE_CONFIGURATION.ID FROM PULSE_CONFIGURATION PULSE_CONFIGURATION ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT PULSE_CONFIGURATION.ID,PULSE_CONFIGURATION.DURATION_TOLERANCE FROM PULSE_CONFIGURATION PULSE_CONFIGURATION ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO PULSE_CONFIGURATION (ID,DURATION_TOLERANCE) VALUES (?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE PULSE_CONFIGURATION SET DURATION_TOLERANCE=? WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM PULSE_CONFIGURATION WHERE ID=?";
	}
	
	@Override
	protected PulseConfiguration extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	PulseConfiguration nextResult = new PulseConfiguration();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setDurationTolerance(rs.getInt("DURATION_TOLERANCE"));


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(PulseConfiguration perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setInt(2, perceroObject.getDurationTolerance());

		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(PulseConfiguration perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setInt(1, perceroObject.getDurationTolerance());
pstmt.setString(2, perceroObject.getID());

		
	}

	@Override
	public List<PulseConfiguration> findByExample(PulseConfiguration theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useDurationTolerance = theQueryObject.getDurationTolerance() != null && (excludeProperties == null || !excludeProperties.contains("durationTolerance"));

if (useDurationTolerance)
{
sql += " WHERE ";
sql += " DURATION_TOLERANCE=? ";
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
