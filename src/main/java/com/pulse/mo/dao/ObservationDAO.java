
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
import com.pulse.mo.Observation;
import com.pulse.mo.CoachingSessionMeasure;

*/

@Component
public class ObservationDAO extends SqlDataAccessObject<Observation> implements IDataAccessObject<Observation> {

	static final Logger log = Logger.getLogger(ObservationDAO.class);

	
	public ObservationDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(Observation.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	@Override
	protected String getConnectionFactoryName() {
		return ObservationDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT OBSERVATION.ID FROM OBSERVATION OBSERVATION WHERE OBSERVATION.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT OBSERVATION.ID,OBSERVATION.COACHING_SESSION_MEASURE_ID FROM OBSERVATION OBSERVATION WHERE OBSERVATION.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT OBSERVATION.ID FROM OBSERVATION OBSERVATION ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT OBSERVATION.ID FROM OBSERVATION OBSERVATION ORDER BY OBSERVATION.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT OBSERVATION.ID,OBSERVATION.COACHING_SESSION_MEASURE_ID FROM OBSERVATION OBSERVATION ORDER BY OBSERVATION.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT OBSERVATION.ID,OBSERVATION.COACHING_SESSION_MEASURE_ID FROM OBSERVATION OBSERVATION ORDER BY OBSERVATION.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM OBSERVATION OBSERVATION";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT OBSERVATION.ID,OBSERVATION.COACHING_SESSION_MEASURE_ID FROM OBSERVATION OBSERVATION WHERE OBSERVATION.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT OBSERVATION.ID FROM OBSERVATION OBSERVATION WHERE OBSERVATION.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT OBSERVATION.ID,OBSERVATION.COACHING_SESSION_MEASURE_ID FROM OBSERVATION OBSERVATION WHERE OBSERVATION." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT OBSERVATION.ID FROM OBSERVATION OBSERVATION WHERE OBSERVATION." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT OBSERVATION.ID FROM OBSERVATION OBSERVATION ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT OBSERVATION.ID,OBSERVATION.COACHING_SESSION_MEASURE_ID FROM OBSERVATION OBSERVATION ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO OBSERVATION (ID,COACHING_SESSION_MEASURE_ID) VALUES (?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE OBSERVATION SET COACHING_SESSION_MEASURE_ID WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM OBSERVATION WHERE ID=?";
	}
	
	@Override
	protected Observation extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	Observation nextResult = new Observation();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			CoachingSessionMeasure coachingsessionmeasure = new CoachingSessionMeasure();
coachingsessionmeasure.setID(rs.getString("COACHING_SESSION_MEASURE_ID"));
nextResult.setCoachingSessionMeasure(coachingsessionmeasure);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(Observation perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());

if (perceroObject.getCoachingSessionMeasure() == null)
{
pstmt.setString(2, null);
}
else
{
		pstmt.setString(2, perceroObject.getCoachingSessionMeasure().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(Observation perceroObject, PreparedStatement pstmt) throws SQLException {
		
		
if (perceroObject.getCoachingSessionMeasure() == null)
{
pstmt.setString(1, null);
}
else
{
		pstmt.setString(1, perceroObject.getCoachingSessionMeasure().getID());
}

pstmt.setString(2, perceroObject.getID());

		
	}

	@Override
	public List<Observation> findByExample(Observation theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useCoachingSessionMeasureID = theQueryObject.getCoachingSessionMeasure() != null && (excludeProperties == null || !excludeProperties.contains("coachingSessionMeasure"));

if (useCoachingSessionMeasureID)
{
sql += " WHERE ";
sql += " COACHING_SESSION_MEASURE_ID=? ";
paramValues.add(theQueryObject.getCoachingSessionMeasure().getID());
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
