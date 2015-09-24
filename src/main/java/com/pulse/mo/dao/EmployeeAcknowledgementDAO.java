
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
import com.pulse.mo.EmployeeAcknowledgement;
import com.pulse.mo.CorrectiveAction;

*/

@Component
public class EmployeeAcknowledgementDAO extends SqlDataAccessObject<EmployeeAcknowledgement> implements IDataAccessObject<EmployeeAcknowledgement> {

	static final Logger log = Logger.getLogger(EmployeeAcknowledgementDAO.class);

	
	public EmployeeAcknowledgementDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(EmployeeAcknowledgement.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	@Override
	protected String getConnectionFactoryName() {
		return EmployeeAcknowledgementDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT employeeacknowledgement.ID FROM EmployeeAcknowledgement employeeacknowledgement WHERE employeeacknowledgement.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT employeeacknowledgement.ID,employeeacknowledgement.externalID,employeeacknowledgement.name,employeeacknowledgement.date FROM EmployeeAcknowledgement employeeacknowledgement WHERE employeeacknowledgement.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT employeeacknowledgement.ID FROM EmployeeAcknowledgement employeeacknowledgement ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT employeeacknowledgement.ID FROM EmployeeAcknowledgement employeeacknowledgement ORDER BY employeeacknowledgement.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT employeeacknowledgement.ID,employeeacknowledgement.externalID,employeeacknowledgement.name,employeeacknowledgement.date FROM EmployeeAcknowledgement employeeacknowledgement ORDER BY employeeacknowledgement.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT employeeacknowledgement.ID,employeeacknowledgement.externalID,employeeacknowledgement.name,employeeacknowledgement.date FROM EmployeeAcknowledgement employeeacknowledgement ORDER BY employeeacknowledgement.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM EmployeeAcknowledgement employeeacknowledgement";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT employeeacknowledgement.ID,employeeacknowledgement.externalID,employeeacknowledgement.name,employeeacknowledgement.date FROM EmployeeAcknowledgement employeeacknowledgement WHERE employeeacknowledgement.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT employeeacknowledgement.ID FROM EmployeeAcknowledgement employeeacknowledgement WHERE employeeacknowledgement.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT employeeacknowledgement.ID,employeeacknowledgement.externalID,employeeacknowledgement.name,employeeacknowledgement.date FROM EmployeeAcknowledgement employeeacknowledgement WHERE employeeacknowledgement." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT employeeacknowledgement.ID FROM EmployeeAcknowledgement employeeacknowledgement WHERE employeeacknowledgement." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT employeeacknowledgement.ID FROM EmployeeAcknowledgement employeeacknowledgement ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT employeeacknowledgement.ID,employeeacknowledgement.externalID,employeeacknowledgement.name,employeeacknowledgement.date FROM EmployeeAcknowledgement employeeacknowledgement ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO EmployeeAcknowledgement (ID,externalID,name,date) VALUES (?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE EmployeeAcknowledgement SET externalID=?,name=?,date=? WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM EmployeeAcknowledgement WHERE ID=?";
	}
	
	@Override
	protected EmployeeAcknowledgement extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	EmployeeAcknowledgement nextResult = new EmployeeAcknowledgement();
    	
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
	protected void setPreparedStatmentInsertParams(EmployeeAcknowledgement perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getExternalID());
pstmt.setString(3, perceroObject.getName());
pstmt.setDate(4, DateUtils.utilDateToSqlDate(perceroObject.getDate()));

		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(EmployeeAcknowledgement perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getExternalID());
pstmt.setString(2, perceroObject.getName());
pstmt.setDate(3, DateUtils.utilDateToSqlDate(perceroObject.getDate()));
pstmt.setString(4, perceroObject.getID());

		
	}

	@Override
	public List<EmployeeAcknowledgement> findByExample(EmployeeAcknowledgement theQueryObject,
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
