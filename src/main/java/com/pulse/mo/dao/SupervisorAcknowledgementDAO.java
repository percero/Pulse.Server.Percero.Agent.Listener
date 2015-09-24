
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
import com.pulse.mo.SupervisorAcknowledgement;
import com.pulse.mo.CorrectiveAction;

*/

@Component
public class SupervisorAcknowledgementDAO extends SqlDataAccessObject<SupervisorAcknowledgement> implements IDataAccessObject<SupervisorAcknowledgement> {

	static final Logger log = Logger.getLogger(SupervisorAcknowledgementDAO.class);

	
	public SupervisorAcknowledgementDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(SupervisorAcknowledgement.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	@Override
	protected String getConnectionFactoryName() {
		return SupervisorAcknowledgementDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT supervisoracknowledgement.ID FROM SupervisorAcknowledgement supervisoracknowledgement WHERE supervisoracknowledgement.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT supervisoracknowledgement.ID,supervisoracknowledgement.externalID,supervisoracknowledgement.name,supervisoracknowledgement.date FROM SupervisorAcknowledgement supervisoracknowledgement WHERE supervisoracknowledgement.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT supervisoracknowledgement.ID FROM SupervisorAcknowledgement supervisoracknowledgement ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT supervisoracknowledgement.ID FROM SupervisorAcknowledgement supervisoracknowledgement ORDER BY supervisoracknowledgement.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT supervisoracknowledgement.ID,supervisoracknowledgement.externalID,supervisoracknowledgement.name,supervisoracknowledgement.date FROM SupervisorAcknowledgement supervisoracknowledgement ORDER BY supervisoracknowledgement.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT supervisoracknowledgement.ID,supervisoracknowledgement.externalID,supervisoracknowledgement.name,supervisoracknowledgement.date FROM SupervisorAcknowledgement supervisoracknowledgement ORDER BY supervisoracknowledgement.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM SupervisorAcknowledgement supervisoracknowledgement";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT supervisoracknowledgement.ID,supervisoracknowledgement.externalID,supervisoracknowledgement.name,supervisoracknowledgement.date FROM SupervisorAcknowledgement supervisoracknowledgement WHERE supervisoracknowledgement.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT supervisoracknowledgement.ID FROM SupervisorAcknowledgement supervisoracknowledgement WHERE supervisoracknowledgement.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT supervisoracknowledgement.ID,supervisoracknowledgement.externalID,supervisoracknowledgement.name,supervisoracknowledgement.date FROM SupervisorAcknowledgement supervisoracknowledgement WHERE supervisoracknowledgement." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT supervisoracknowledgement.ID FROM SupervisorAcknowledgement supervisoracknowledgement WHERE supervisoracknowledgement." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT supervisoracknowledgement.ID FROM SupervisorAcknowledgement supervisoracknowledgement ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT supervisoracknowledgement.ID,supervisoracknowledgement.externalID,supervisoracknowledgement.name,supervisoracknowledgement.date FROM SupervisorAcknowledgement supervisoracknowledgement ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO SupervisorAcknowledgement (ID,externalID,name,date) VALUES (?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE SupervisorAcknowledgement SET externalID=?,name=?,date=? WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM SupervisorAcknowledgement WHERE ID=?";
	}
	
	@Override
	protected SupervisorAcknowledgement extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	SupervisorAcknowledgement nextResult = new SupervisorAcknowledgement();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setExternalID(rs.getString("externalID"));

nextResult.setName(rs.getString("name"));

nextResult.setDate(rs.getDate("date"));


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(SupervisorAcknowledgement perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getExternalID());
pstmt.setString(3, perceroObject.getName());
pstmt.setDate(4, DateUtils.utilDateToSqlDate(perceroObject.getDate()));

		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(SupervisorAcknowledgement perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getExternalID());
pstmt.setString(2, perceroObject.getName());
pstmt.setDate(3, DateUtils.utilDateToSqlDate(perceroObject.getDate()));
pstmt.setString(4, perceroObject.getID());

		
	}

	@Override
	public List<SupervisorAcknowledgement> findByExample(SupervisorAcknowledgement theQueryObject,
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
sql += " name=? ";
paramValues.add(theQueryObject.getName());
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
