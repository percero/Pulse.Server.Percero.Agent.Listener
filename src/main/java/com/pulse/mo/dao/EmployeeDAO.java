
package com.pulse.mo.dao;

import java.sql.PreparedStatement;
import java.sql.CallableStatement;
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
import com.pulse.mo.Employee;
import com.pulse.mo.CorrectiveAction;

*/

@Component
public class EmployeeDAO extends SqlDataAccessObject<Employee> implements IDataAccessObject<Employee> {

	static final Logger log = Logger.getLogger(EmployeeDAO.class);

	
	public EmployeeDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(Employee.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	
	public static final String SQL_VIEW = ",\"EMPLOYEE\".\"EMAIL_ADDRESS\",\"EMPLOYEE\".\"FIRST_NAME\",\"EMPLOYEE\".\"FULL_NAME\",\"EMPLOYEE\".\"LAST_NAME\",\"EMPLOYEE\".\"PHOTO_URI\"";
	private String selectFromStatementTableName = " FROM \"EMPLOYEE\" \"EMPLOYEE\"";
	private String whereClause = "  WHERE \"EMPLOYEE\".\"ID\"=?";
	private String whereInClause = "  join table(sys.dbms_debug_vc2coll(?)) SQLLIST on \"EMPLOYEE\".\"ID\"= SQLLIST.column_value";
	private String orderByTableName = "  ORDER BY \"EMPLOYEE\".\"ID\"";
	
	

	
	@Override
	protected String getConnectionFactoryName() {
		return EmployeeDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT \"EMPLOYEE\".\"ID\" " + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT \"EMPLOYEE\".\"ID\"" + SQL_VIEW  + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT \"EMPLOYEE\".\"ID\" " + selectFromStatementTableName +  orderByTableName;
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT \"EMPLOYEE\".\"ID\" " + selectFromStatementTableName  +  orderByTableName  + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT \"EMPLOYEE\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName  + orderByTableName;
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT \"EMPLOYEE\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + orderByTableName + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() 
	{
		return "SELECT COUNT(ID) " + selectFromStatementTableName;
	}
	
	@Override
	protected String getSelectInStarSQL() 
	{
		return "SELECT \"EMPLOYEE\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + whereInClause;
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT \"EMPLOYEE\".\"ID\" " + selectFromStatementTableName + whereInClause;
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		
		return "SELECT \"EMPLOYEE\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + " WHERE \"EMPLOYEE\"." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) 
	{
		
		return "SELECT \"EMPLOYEE\".\"ID\" " + selectFromStatementTableName + " WHERE \"EMPLOYEE\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT \"EMPLOYEE\".\"ID\" " + selectFromStatementTableName;
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT \"EMPLOYEE\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName;
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO EMPLOYEE (\"ID\",\"EMAIL_ADDRESS\",\"FIRST_NAME\",\"FULL_NAME\",\"LAST_NAME\",\"PHOTO_URI\") VALUES (?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE \"TBL_EMPLOYEE\" SET \"EMAIL_ADDRESS\"=?,\"FIRST_NAME\"=?,\"FULL_NAME\"=?,\"LAST_NAME\"=?,\"PHOTO_URI\"=? WHERE \"ID\"=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM \"TBL_EMPLOYEE\" WHERE \"ID\"=?";
	}
	
	@Override
	protected Employee extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	Employee nextResult = new Employee();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setEmailAddress(rs.getString("EMAIL_ADDRESS"));

nextResult.setFirstName(rs.getString("FIRST_NAME"));

nextResult.setFullName(rs.getString("FULL_NAME"));

nextResult.setLastName(rs.getString("LAST_NAME"));

nextResult.setPhotoUri(rs.getString("PHOTO_URI"));


			
    	}
    	
    	return nextResult;
	}
	
	protected void setBaseStatmentInsertParams(Employee perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getEmailAddress());
pstmt.setString(3, perceroObject.getFirstName());
pstmt.setString(4, perceroObject.getFullName());
pstmt.setString(5, perceroObject.getLastName());
pstmt.setString(6, perceroObject.getPhotoUri());

		
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(Employee perceroObject, PreparedStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
		
	}
	
	@Override
	protected void setCallableStatmentInsertParams(Employee perceroObject, CallableStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	

	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(Employee perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getEmailAddress());
pstmt.setString(2, perceroObject.getFirstName());
pstmt.setString(3, perceroObject.getFullName());
pstmt.setString(4, perceroObject.getLastName());
pstmt.setString(5, perceroObject.getPhotoUri());
pstmt.setString(6, perceroObject.getID());

		
	}
	
	
	@Override
	protected void setCallableStatmentUpdateParams(Employee perceroObject, CallableStatement pstmt) throws SQLException 
	{
		
		//must be in same order as insert
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	}
	
	

	@Override
	public List<Employee> findByExample(Employee theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useEmailAddress = StringUtils.hasText(theQueryObject.getEmailAddress()) && (excludeProperties == null || !excludeProperties.contains("emailAddress"));

if (useEmailAddress)
{
sql += " WHERE ";
sql += " \"EMAIL_ADDRESS\" =? ";
paramValues.add(theQueryObject.getEmailAddress());
propertyCounter++;
}

boolean useFirstName = StringUtils.hasText(theQueryObject.getFirstName()) && (excludeProperties == null || !excludeProperties.contains("firstName"));

if (useFirstName)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"FIRST_NAME\" =? ";
paramValues.add(theQueryObject.getFirstName());
propertyCounter++;
}

boolean useFullName = StringUtils.hasText(theQueryObject.getFullName()) && (excludeProperties == null || !excludeProperties.contains("fullName"));

if (useFullName)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"FULL_NAME\" =? ";
paramValues.add(theQueryObject.getFullName());
propertyCounter++;
}

boolean useLastName = StringUtils.hasText(theQueryObject.getLastName()) && (excludeProperties == null || !excludeProperties.contains("lastName"));

if (useLastName)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"LAST_NAME\" =? ";
paramValues.add(theQueryObject.getLastName());
propertyCounter++;
}

boolean usePhotoUri = StringUtils.hasText(theQueryObject.getPhotoUri()) && (excludeProperties == null || !excludeProperties.contains("photoUri"));

if (usePhotoUri)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"PHOTO_URI\" =? ";
paramValues.add(theQueryObject.getPhotoUri());
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
	
	@Override
	protected String getUpdateCallableStatementSql() {
		return "{call UPDATE_EMPLOYEE(?,?,?,?,?,?)}";
	}
	@Override
	protected String getInsertCallableStatementSql() {
		return "{call CREATE_EMPLOYEE(?,?,?,?,?,?)}";
	}
	@Override
	protected String getDeleteCallableStatementSql() {
		return "{call Delete_EMPLOYEE(?)}";
	}
	
	
	
	
}
