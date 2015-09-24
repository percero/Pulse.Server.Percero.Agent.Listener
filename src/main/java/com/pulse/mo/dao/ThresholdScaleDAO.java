
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
import com.pulse.mo.ThresholdScale;
import com.pulse.mo.ThresholdLevel;

*/

@Component
public class ThresholdScaleDAO extends SqlDataAccessObject<ThresholdScale> implements IDataAccessObject<ThresholdScale> {

	static final Logger log = Logger.getLogger(ThresholdScaleDAO.class);

	
	public ThresholdScaleDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(ThresholdScale.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	@Override
	protected String getConnectionFactoryName() {
		return ThresholdScaleDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT thresholdscale.ID FROM ThresholdScale thresholdscale WHERE thresholdscale.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT thresholdscale.ID,thresholdscale.externalID,thresholdscale.goal,thresholdscale.date FROM ThresholdScale thresholdscale WHERE thresholdscale.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT thresholdscale.ID FROM ThresholdScale thresholdscale ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT thresholdscale.ID FROM ThresholdScale thresholdscale ORDER BY thresholdscale.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT thresholdscale.ID,thresholdscale.externalID,thresholdscale.goal,thresholdscale.date FROM ThresholdScale thresholdscale ORDER BY thresholdscale.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT thresholdscale.ID,thresholdscale.externalID,thresholdscale.goal,thresholdscale.date FROM ThresholdScale thresholdscale ORDER BY thresholdscale.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM ThresholdScale thresholdscale";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT thresholdscale.ID,thresholdscale.externalID,thresholdscale.goal,thresholdscale.date FROM ThresholdScale thresholdscale WHERE thresholdscale.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT thresholdscale.ID FROM ThresholdScale thresholdscale WHERE thresholdscale.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT thresholdscale.ID,thresholdscale.externalID,thresholdscale.goal,thresholdscale.date FROM ThresholdScale thresholdscale WHERE thresholdscale." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT thresholdscale.ID FROM ThresholdScale thresholdscale WHERE thresholdscale." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT thresholdscale.ID FROM ThresholdScale thresholdscale ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT thresholdscale.ID,thresholdscale.externalID,thresholdscale.goal,thresholdscale.date FROM ThresholdScale thresholdscale ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO ThresholdScale (ID,externalID,goal,date) VALUES (?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE ThresholdScale SET externalID=?,goal=?,date=? WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM ThresholdScale WHERE ID=?";
	}
	
	@Override
	protected ThresholdScale extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	ThresholdScale nextResult = new ThresholdScale();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setExternalID(rs.getString("externalID"));

nextResult.setGoal(rs.getInt("goal"));

nextResult.setDate(rs.getDate("date"));


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(ThresholdScale perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getExternalID());
pstmt.setInt(3, perceroObject.getGoal());
pstmt.setDate(4, DateUtils.utilDateToSqlDate(perceroObject.getDate()));

		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(ThresholdScale perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getExternalID());
pstmt.setInt(2, perceroObject.getGoal());
pstmt.setDate(3, DateUtils.utilDateToSqlDate(perceroObject.getDate()));
pstmt.setString(4, perceroObject.getID());

		
	}

	@Override
	public List<ThresholdScale> findByExample(ThresholdScale theQueryObject,
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

boolean useGoal = theQueryObject.getGoal() != null && (excludeProperties == null || !excludeProperties.contains("goal"));

if (useGoal)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " goal=? ";
paramValues.add(theQueryObject.getGoal());
propertyCounter++;
}

boolean useDate = theQueryObject.getDate() != null && (excludeProperties == null || !excludeProperties.contains("date"));

if (useDate)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " date=? ";
paramValues.add(theQueryObject.getDate());
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
