
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
		return "SELECT THRESHOLD_SCALE.ID FROM THRESHOLD_SCALE THRESHOLD_SCALE WHERE THRESHOLD_SCALE.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT THRESHOLD_SCALE.ID,THRESHOLD_SCALE.DATE,THRESHOLD_SCALE.GOAL FROM THRESHOLD_SCALE THRESHOLD_SCALE WHERE THRESHOLD_SCALE.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT THRESHOLD_SCALE.ID FROM THRESHOLD_SCALE THRESHOLD_SCALE ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT THRESHOLD_SCALE.ID FROM THRESHOLD_SCALE THRESHOLD_SCALE ORDER BY THRESHOLD_SCALE.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT THRESHOLD_SCALE.ID,THRESHOLD_SCALE.DATE,THRESHOLD_SCALE.GOAL FROM THRESHOLD_SCALE THRESHOLD_SCALE ORDER BY THRESHOLD_SCALE.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT THRESHOLD_SCALE.ID,THRESHOLD_SCALE.DATE,THRESHOLD_SCALE.GOAL FROM THRESHOLD_SCALE THRESHOLD_SCALE ORDER BY THRESHOLD_SCALE.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM THRESHOLD_SCALE THRESHOLD_SCALE";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT THRESHOLD_SCALE.ID,THRESHOLD_SCALE.DATE,THRESHOLD_SCALE.GOAL FROM THRESHOLD_SCALE THRESHOLD_SCALE WHERE THRESHOLD_SCALE.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT THRESHOLD_SCALE.ID FROM THRESHOLD_SCALE THRESHOLD_SCALE WHERE THRESHOLD_SCALE.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT THRESHOLD_SCALE.ID,THRESHOLD_SCALE.DATE,THRESHOLD_SCALE.GOAL FROM THRESHOLD_SCALE THRESHOLD_SCALE WHERE THRESHOLD_SCALE." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT THRESHOLD_SCALE.ID FROM THRESHOLD_SCALE THRESHOLD_SCALE WHERE THRESHOLD_SCALE." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT THRESHOLD_SCALE.ID FROM THRESHOLD_SCALE THRESHOLD_SCALE ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT THRESHOLD_SCALE.ID,THRESHOLD_SCALE.DATE,THRESHOLD_SCALE.GOAL FROM THRESHOLD_SCALE THRESHOLD_SCALE ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO THRESHOLD_SCALE (ID,DATE,GOAL) VALUES (?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE THRESHOLD_SCALE SET DATE=?,GOAL=? WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM THRESHOLD_SCALE WHERE ID=?";
	}
	
	@Override
	protected ThresholdScale extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	ThresholdScale nextResult = new ThresholdScale();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setDate(rs.getDate("DATE"));

nextResult.setGoal(rs.getInt("GOAL"));


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(ThresholdScale perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setDate(2, DateUtils.utilDateToSqlDate(perceroObject.getDate()));
pstmt.setInt(3, perceroObject.getGoal());

		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(ThresholdScale perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setDate(1, DateUtils.utilDateToSqlDate(perceroObject.getDate()));
pstmt.setInt(2, perceroObject.getGoal());
pstmt.setString(3, perceroObject.getID());

		
	}

	@Override
	public List<ThresholdScale> findByExample(ThresholdScale theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useDate = theQueryObject.getDate() != null && (excludeProperties == null || !excludeProperties.contains("date"));

if (useDate)
{
sql += " WHERE ";
sql += " DATE=? ";
paramValues.add(theQueryObject.getDate());
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
sql += " GOAL=? ";
paramValues.add(theQueryObject.getGoal());
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
