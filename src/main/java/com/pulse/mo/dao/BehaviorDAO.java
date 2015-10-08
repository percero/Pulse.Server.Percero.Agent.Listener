
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
import com.pulse.mo.Behavior;
import com.pulse.mo.CoachingSessionMeasure;

*/

@Component
public class BehaviorDAO extends SqlDataAccessObject<Behavior> implements IDataAccessObject<Behavior> {

	static final Logger log = Logger.getLogger(BehaviorDAO.class);

	
	public BehaviorDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(Behavior.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	@Override
	protected String getConnectionFactoryName() {
		return BehaviorDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT BEHAVIOR.ID FROM BEHAVIOR BEHAVIOR WHERE BEHAVIOR.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT BEHAVIOR.ID,BEHAVIOR.DESCRIPTION,BEHAVIOR.NAME,BEHAVIOR.RESPONSE,BEHAVIOR.COACHING_SESSION_MEASURE_ID FROM BEHAVIOR BEHAVIOR WHERE BEHAVIOR.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT BEHAVIOR.ID FROM BEHAVIOR BEHAVIOR ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT BEHAVIOR.ID FROM BEHAVIOR BEHAVIOR ORDER BY BEHAVIOR.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT BEHAVIOR.ID,BEHAVIOR.DESCRIPTION,BEHAVIOR.NAME,BEHAVIOR.RESPONSE,BEHAVIOR.COACHING_SESSION_MEASURE_ID FROM BEHAVIOR BEHAVIOR ORDER BY BEHAVIOR.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT BEHAVIOR.ID,BEHAVIOR.DESCRIPTION,BEHAVIOR.NAME,BEHAVIOR.RESPONSE,BEHAVIOR.COACHING_SESSION_MEASURE_ID FROM BEHAVIOR BEHAVIOR ORDER BY BEHAVIOR.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM BEHAVIOR BEHAVIOR";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT BEHAVIOR.ID,BEHAVIOR.DESCRIPTION,BEHAVIOR.NAME,BEHAVIOR.RESPONSE,BEHAVIOR.COACHING_SESSION_MEASURE_ID FROM BEHAVIOR BEHAVIOR WHERE BEHAVIOR.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT BEHAVIOR.ID FROM BEHAVIOR BEHAVIOR WHERE BEHAVIOR.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT BEHAVIOR.ID,BEHAVIOR.DESCRIPTION,BEHAVIOR.NAME,BEHAVIOR.RESPONSE,BEHAVIOR.COACHING_SESSION_MEASURE_ID FROM BEHAVIOR BEHAVIOR WHERE BEHAVIOR." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT BEHAVIOR.ID FROM BEHAVIOR BEHAVIOR WHERE BEHAVIOR." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT BEHAVIOR.ID FROM BEHAVIOR BEHAVIOR ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT BEHAVIOR.ID,BEHAVIOR.DESCRIPTION,BEHAVIOR.NAME,BEHAVIOR.RESPONSE,BEHAVIOR.COACHING_SESSION_MEASURE_ID FROM BEHAVIOR BEHAVIOR ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO BEHAVIOR (ID,DESCRIPTION,NAME,RESPONSE,COACHING_SESSION_MEASURE_ID) VALUES (?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE BEHAVIOR SET DESCRIPTION=?,NAME=?,RESPONSE=?,COACHING_SESSION_MEASURE_ID WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM BEHAVIOR WHERE ID=?";
	}
	
	@Override
	protected Behavior extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	Behavior nextResult = new Behavior();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setDescription(rs.getString("DESCRIPTION"));

nextResult.setName(rs.getString("NAME"));

nextResult.setResponse(rs.getString("RESPONSE"));

CoachingSessionMeasure coachingsessionmeasure = new CoachingSessionMeasure();
coachingsessionmeasure.setID(rs.getString("COACHING_SESSION_MEASURE_ID"));
nextResult.setCoachingSessionMeasure(coachingsessionmeasure);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(Behavior perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getDescription());
pstmt.setString(3, perceroObject.getName());
pstmt.setString(4, perceroObject.getResponse());

if (perceroObject.getCoachingSessionMeasure() == null)
{
pstmt.setString(5, null);
}
else
{
		pstmt.setString(5, perceroObject.getCoachingSessionMeasure().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(Behavior perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getDescription());
pstmt.setString(2, perceroObject.getName());
pstmt.setString(3, perceroObject.getResponse());

if (perceroObject.getCoachingSessionMeasure() == null)
{
pstmt.setString(4, null);
}
else
{
		pstmt.setString(4, perceroObject.getCoachingSessionMeasure().getID());
}

pstmt.setString(5, perceroObject.getID());

		
	}

	@Override
	public List<Behavior> findByExample(Behavior theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useDescription = StringUtils.hasText(theQueryObject.getDescription()) && (excludeProperties == null || !excludeProperties.contains("description"));

if (useDescription)
{
sql += " WHERE ";
sql += " DESCRIPTION=? ";
paramValues.add(theQueryObject.getDescription());
propertyCounter++;
}

boolean useName = StringUtils.hasText(theQueryObject.getName()) && (excludeProperties == null || !excludeProperties.contains("name"));

if (useName)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " NAME=? ";
paramValues.add(theQueryObject.getName());
propertyCounter++;
}

boolean useResponse = StringUtils.hasText(theQueryObject.getResponse()) && (excludeProperties == null || !excludeProperties.contains("response"));

if (useResponse)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " RESPONSE=? ";
paramValues.add(theQueryObject.getResponse());
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
