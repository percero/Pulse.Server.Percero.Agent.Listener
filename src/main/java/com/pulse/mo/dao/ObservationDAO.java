
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
		return "SELECT observation.ID FROM Observation observation WHERE observation.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT observation.ID,observation.externalID,observation.coachingSessionMeasure_ID FROM Observation observation WHERE observation.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT observation.ID FROM Observation observation ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT observation.ID FROM Observation observation ORDER BY observation.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT observation.ID,observation.externalID,observation.coachingSessionMeasure_ID FROM Observation observation ORDER BY observation.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT observation.ID,observation.externalID,observation.coachingSessionMeasure_ID FROM Observation observation ORDER BY observation.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM Observation observation";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT observation.ID,observation.externalID,observation.coachingSessionMeasure_ID FROM Observation observation WHERE observation.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT observation.ID FROM Observation observation WHERE observation.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT observation.ID,observation.externalID,observation.coachingSessionMeasure_ID FROM Observation observation WHERE observation." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT observation.ID FROM Observation observation WHERE observation." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT observation.ID FROM Observation observation ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT observation.ID,observation.externalID,observation.coachingSessionMeasure_ID FROM Observation observation ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO Observation (ID,externalID,coachingSessionMeasure_ID) VALUES (?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE Observation SET externalID=?,coachingSessionMeasure_ID=? WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM Observation WHERE ID=?";
	}
	
	@Override
	protected Observation extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	Observation nextResult = new Observation();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setExternalID(rs.getString("externalID"));

CoachingSessionMeasure coachingsessionmeasure = new CoachingSessionMeasure();
coachingsessionmeasure.setID(rs.getString("coachingsessionmeasure_ID"));
nextResult.setCoachingSessionMeasure(coachingsessionmeasure);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(Observation perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getExternalID());

if (perceroObject.getCoachingSessionMeasure() == null)
{
pstmt.setString(3, null);
}
else
{
		pstmt.setString(3, perceroObject.getCoachingSessionMeasure().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(Observation perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getExternalID());

if (perceroObject.getCoachingSessionMeasure() == null)
{
pstmt.setString(2, null);
}
else
{
		pstmt.setString(2, perceroObject.getCoachingSessionMeasure().getID());
}

pstmt.setString(3, perceroObject.getID());

		
	}

	@Override
	public List<Observation> findByExample(Observation theQueryObject,
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

boolean useCoachingSessionMeasureID = theQueryObject.getCoachingSessionMeasure() != null && (excludeProperties == null || !excludeProperties.contains("coachingSessionMeasure"));

if (useCoachingSessionMeasureID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " coachingSessionMeasureID=? ";
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
