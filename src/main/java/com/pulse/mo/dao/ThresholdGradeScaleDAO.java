
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
import com.pulse.mo.ThresholdGradeScale;

*/

@Component
public class ThresholdGradeScaleDAO extends SqlDataAccessObject<ThresholdGradeScale> implements IDataAccessObject<ThresholdGradeScale> {

	static final Logger log = Logger.getLogger(ThresholdGradeScaleDAO.class);

	
	public ThresholdGradeScaleDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(ThresholdGradeScale.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	@Override
	protected String getConnectionFactoryName() {
		return ThresholdGradeScaleDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT thresholdgradescale.ID FROM ThresholdGradeScale thresholdgradescale WHERE thresholdgradescale.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT thresholdgradescale.ID,thresholdgradescale.externalID FROM ThresholdGradeScale thresholdgradescale WHERE thresholdgradescale.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT thresholdgradescale.ID FROM ThresholdGradeScale thresholdgradescale ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT thresholdgradescale.ID FROM ThresholdGradeScale thresholdgradescale ORDER BY thresholdgradescale.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT thresholdgradescale.ID,thresholdgradescale.externalID FROM ThresholdGradeScale thresholdgradescale ORDER BY thresholdgradescale.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT thresholdgradescale.ID,thresholdgradescale.externalID FROM ThresholdGradeScale thresholdgradescale ORDER BY thresholdgradescale.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM ThresholdGradeScale thresholdgradescale";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT thresholdgradescale.ID,thresholdgradescale.externalID FROM ThresholdGradeScale thresholdgradescale WHERE thresholdgradescale.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT thresholdgradescale.ID FROM ThresholdGradeScale thresholdgradescale WHERE thresholdgradescale.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT thresholdgradescale.ID,thresholdgradescale.externalID FROM ThresholdGradeScale thresholdgradescale WHERE thresholdgradescale." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT thresholdgradescale.ID FROM ThresholdGradeScale thresholdgradescale WHERE thresholdgradescale." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT thresholdgradescale.ID FROM ThresholdGradeScale thresholdgradescale ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT thresholdgradescale.ID,thresholdgradescale.externalID FROM ThresholdGradeScale thresholdgradescale ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO ThresholdGradeScale (ID,externalID) VALUES (?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE ThresholdGradeScale SET externalID=? WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM ThresholdGradeScale WHERE ID=?";
	}
	
	@Override
	protected ThresholdGradeScale extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	ThresholdGradeScale nextResult = new ThresholdGradeScale();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setExternalID(rs.getString("externalID"));


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(ThresholdGradeScale perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getExternalID());

		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(ThresholdGradeScale perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getExternalID());
pstmt.setString(2, perceroObject.getID());

		
	}

	@Override
	public List<ThresholdGradeScale> findByExample(ThresholdGradeScale theQueryObject,
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
