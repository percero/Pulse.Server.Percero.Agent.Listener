
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
	
	public static final String SQL_VIEW = ",\"EMPLOYEE_ACKNOWLEDGEMENT\".\"DATE\",\"EMPLOYEE_ACKNOWLEDGEMENT\".\"NAME\"";
	private String selectFromStatementTableName = " FROM \"EMPLOYEE_ACKNOWLEDGEMENT\" \"EMPLOYEE_ACKNOWLEDGEMENT\"";
	private String whereClause = " WHERE \"EMPLOYEE_ACKNOWLEDGEMENT\".\"ID\"=?";
	private String whereInClause = " join table(sys.dbms_debug_vc2coll(?)) SQLLIST on \"EMPLOYEE_ACKNOWLEDGEMENT\".\"ID\"= SQLLIST.column_value";
	private String orderByTableName = " ORDER BY \"EMPLOYEE_ACKNOWLEDGEMENT\".\"ID\"";
	
	

	
	@Override
	protected String getConnectionFactoryName() {
		return EmployeeAcknowledgementDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT \"EMPLOYEE_ACKNOWLEDGEMENT\".\"ID\" " + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT \"EMPLOYEE_ACKNOWLEDGEMENT\".\"ID\"" + SQL_VIEW  + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT \"EMPLOYEE_ACKNOWLEDGEMENT\".\"ID\" " + selectFromStatementTableName +  orderByTableName;
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT \"EMPLOYEE_ACKNOWLEDGEMENT\".\"ID\" " + selectFromStatementTableName  +  orderByTableName  + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT \"EMPLOYEE_ACKNOWLEDGEMENT\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName  + orderByTableName;
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT \"EMPLOYEE_ACKNOWLEDGEMENT\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + orderByTableName + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() 
	{
		return "SELECT COUNT(ID) " + selectFromStatementTableName;
	}
	
	@Override
	protected String getSelectInStarSQL() 
	{
		return "SELECT \"EMPLOYEE_ACKNOWLEDGEMENT\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + whereInClause;
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT \"EMPLOYEE_ACKNOWLEDGEMENT\".\"ID\" " + selectFromStatementTableName + whereInClause;
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		
		return "SELECT \"EMPLOYEE_ACKNOWLEDGEMENT\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + " WHERE \"EMPLOYEE_ACKNOWLEDGEMENT\"." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) 
	{
		
		return "SELECT \"EMPLOYEE_ACKNOWLEDGEMENT\".\"ID\" " + selectFromStatementTableName + " WHERE \"EMPLOYEE_ACKNOWLEDGEMENT\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT \"EMPLOYEE_ACKNOWLEDGEMENT\".\"ID\" " + selectFromStatementTableName;
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT \"EMPLOYEE_ACKNOWLEDGEMENT\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName;
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO EMPLOYEE_ACKNOWLEDGEMENT (\"ID\",\"DATE\",\"NAME\") VALUES (?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE \"TBL_EMPLOYEE_ACKNOWLEDGEMENT\" SET \"DATE\"=?,\"NAME\"=? WHERE \"ID\"=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM \"TBL_EMPLOYEE_ACKNOWLEDGEMENT\" WHERE \"ID\"=?";
	}
	
	@Override
	protected EmployeeAcknowledgement extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	EmployeeAcknowledgement nextResult = new EmployeeAcknowledgement();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setDate(rs.getDate("DATE"));

nextResult.setName(rs.getString("NAME"));


			
    	}
    	
    	return nextResult;
	}
	
	protected void setBaseStatmentInsertParams(EmployeeAcknowledgement perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setDate(2, DateUtils.utilDateToSqlDate(perceroObject.getDate()));
pstmt.setString(3, perceroObject.getName());

		
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(EmployeeAcknowledgement perceroObject, PreparedStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
		
	}
	
	@Override
	protected void setCallableStatmentInsertParams(EmployeeAcknowledgement perceroObject, CallableStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	

	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(EmployeeAcknowledgement perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setDate(1, DateUtils.utilDateToSqlDate(perceroObject.getDate()));
pstmt.setString(2, perceroObject.getName());
pstmt.setString(3, perceroObject.getID());

		
	}
	
	
	@Override
	protected void setCallableStatmentUpdateParams(EmployeeAcknowledgement perceroObject, CallableStatement pstmt) throws SQLException 
	{
		
		//must be in same order as insert
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	}
	
	

	@Override
	public List<EmployeeAcknowledgement> findByExample(EmployeeAcknowledgement theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useDate = theQueryObject.getDate() != null && (excludeProperties == null || !excludeProperties.contains("date"));

if (useDate)
{
sql += " WHERE ";
sql += " \"DATE\" =? ";
paramValues.add(theQueryObject.getDate());
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
sql += " \"NAME\" =? ";
paramValues.add(theQueryObject.getName());
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
		return "{call UPDATE_EMPLOYEE_ACKNOWLEDGEMENT(?,?,?)}";
	}
	@Override
	protected String getInsertCallableStatementSql() {
		return "{call CREATE_EMPLOYEE_ACKNOWLEDGEMENT(?,?,?)}";
	}
	@Override
	protected String getDeleteCallableStatementSql() {
		return "{call Delete_EMPLOYEE_ACKNOWLEDGEMENT(?)}";
	}
	
	
	
	
}
