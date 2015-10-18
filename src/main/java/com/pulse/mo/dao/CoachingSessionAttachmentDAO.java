
package com.pulse.mo.dao;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.percero.agents.sync.exceptions.SyncDataException;
import com.percero.util.DateUtils;
import com.pulse.dataprovider.IConnectionFactory;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.percero.agents.sync.dao.DAORegistry;
import com.percero.agents.sync.dao.IDataAccessObject;
import com.percero.agents.sync.exceptions.SyncException;

import com.pulse.mo.*;


@Component
public class CoachingSessionAttachmentDAO extends SqlDataAccessObject<CoachingSessionAttachment> implements IDataAccessObject<CoachingSessionAttachment> {

	static final Logger log = Logger.getLogger(CoachingSessionAttachmentDAO.class);

	
	public CoachingSessionAttachmentDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(CoachingSessionAttachment.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	
	public static final String SQL_VIEW = ",\"ADHOC_ATTACHMENT\".\"NAME\",\"ADHOC_ATTACHMENT\".\"CREATED_ON\",\"ADHOC_ATTACHMENT\".\"UPDATED_ON\",\"ADHOC_ATTACHMENT\".\"DOCUMENT_REFERENCE_ID\",\"ADHOC_ATTACHMENT\".\"CREATED_BY\",\"ADHOC_ATTACHMENT\".\"DESCRIPTION\",\"ADHOC_ATTACHMENT\".\"EMPLOYEE_ID\",\"ADHOC_ATTACHMENT\".\"TEMP_STORE_ID\",\"ADHOC_ATTACHMENT\".\"TYPE\",\"ADHOC_ATTACHMENT\".\"UPDATED_BY\",\"ADHOC_ATTACHMENT\".\"VERSION\"";
	private String selectFromStatementTableName = " FROM \"ADHOC_ATTACHMENT\" \"ADHOC_ATTACHMENT\"";
	private String whereClause = "  WHERE \"ADHOC_ATTACHMENT\".\"ID\"=?";
	private String whereInClause = "  join table(sys.dbms_debug_vc2coll(?)) SQLLIST on \"ADHOC_ATTACHMENT\".\"ID\"= SQLLIST.column_value";
	private String orderByTableName = "  ORDER BY \"ADHOC_ATTACHMENT\".\"ID\"";
	
	

	
	@Override
	protected String getConnectionFactoryName() {
		return CoachingSessionAttachmentDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT \"ADHOC_ATTACHMENT\".\"ID\" " + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT \"ADHOC_ATTACHMENT\".\"ID\"" + SQL_VIEW  + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT \"ADHOC_ATTACHMENT\".\"ID\" " + selectFromStatementTableName +  orderByTableName;
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT \"ADHOC_ATTACHMENT\".\"ID\" " + selectFromStatementTableName  +  orderByTableName  + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT \"ADHOC_ATTACHMENT\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName  + orderByTableName;
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT \"ADHOC_ATTACHMENT\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + orderByTableName + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() 
	{
		return "SELECT COUNT(ID) " + selectFromStatementTableName;
	}
	
	@Override
	protected String getSelectInStarSQL() 
	{
		return "SELECT \"ADHOC_ATTACHMENT\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + whereInClause;
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT \"ADHOC_ATTACHMENT\".\"ID\" " + selectFromStatementTableName + whereInClause;
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		
		return "SELECT \"ADHOC_ATTACHMENT\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + " WHERE \"ADHOC_ATTACHMENT\"." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) 
	{
		
		return "SELECT \"ADHOC_ATTACHMENT\".\"ID\" " + selectFromStatementTableName + " WHERE \"ADHOC_ATTACHMENT\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT \"ADHOC_ATTACHMENT\".\"ID\" " + selectFromStatementTableName;
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT \"ADHOC_ATTACHMENT\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName;
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO TBL_ADHOC_ATTACHMENT (\"ID\",\"NAME\",\"CREATED_ON\",\"UPDATED_ON\",\"DOCUMENT_REFERENCE_ID\",\"CREATED_BY\",\"DESCRIPTION\",\"EMPLOYEE_ID\",\"TEMP_STORE_ID\",\"TYPE\",\"UPDATED_BY\",\"VERSION\") VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE TBL_ADHOC_ATTACHMENT SET \"NAME\"=?,\"CREATED_ON\"=?,\"UPDATED_ON\"=?,\"DOCUMENT_REFERENCE_ID\"=?,\"CREATED_BY\"=?,\"DESCRIPTION\"=?,\"EMPLOYEE_ID\"=?,\"TEMP_STORE_ID\"=?,\"TYPE\"=?,\"UPDATED_BY\"=?,\"VERSION\"=? WHERE \"ID\"=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM TBL_ADHOC_ATTACHMENT WHERE \"ID\"=?";
	}
	
	@Override
	protected CoachingSessionAttachment extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	CoachingSessionAttachment nextResult = new CoachingSessionAttachment();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setName(rs.getString("NAME"));

nextResult.setCreatedOn(rs.getDate("CREATED_ON"));

nextResult.setUpdatedOn(rs.getDate("UPDATED_ON"));

nextResult.setDocumentReferenceId(rs.getInt("DOCUMENT_REFERENCE_ID"));

nextResult.setCreatedBy(rs.getString("CREATED_BY"));

nextResult.setDescription(rs.getString("DESCRIPTION"));

nextResult.setEmployeeId(rs.getString("EMPLOYEE_ID"));

nextResult.setTempStoreId(rs.getString("TEMP_STORE_ID"));

nextResult.setType(rs.getString("TYPE"));

nextResult.setUpdatedBy(rs.getString("UPDATED_BY"));

nextResult.setVersion(rs.getString("VERSION"));


			
    	}
    	
    	return nextResult;
	}
	
	protected void setBaseStatmentInsertParams(CoachingSessionAttachment perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getName());
pstmt.setDate(3, DateUtils.utilDateToSqlDate(perceroObject.getCreatedOn()));
pstmt.setDate(4, DateUtils.utilDateToSqlDate(perceroObject.getUpdatedOn()));
pstmt.setInt(5, perceroObject.getDocumentReferenceId());
pstmt.setString(6, perceroObject.getCreatedBy());
pstmt.setString(7, perceroObject.getDescription());
pstmt.setString(8, perceroObject.getEmployeeId());
pstmt.setString(9, perceroObject.getTempStoreId());
pstmt.setString(10, perceroObject.getType());
pstmt.setString(11, perceroObject.getUpdatedBy());
pstmt.setString(12, perceroObject.getVersion());

		
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(CoachingSessionAttachment perceroObject, PreparedStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
		
	}
	
	@Override
	protected void setCallableStatmentInsertParams(CoachingSessionAttachment perceroObject, CallableStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	

	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(CoachingSessionAttachment perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getName());
pstmt.setDate(2, DateUtils.utilDateToSqlDate(perceroObject.getCreatedOn()));
pstmt.setDate(3, DateUtils.utilDateToSqlDate(perceroObject.getUpdatedOn()));
pstmt.setInt(4, perceroObject.getDocumentReferenceId());
pstmt.setString(5, perceroObject.getCreatedBy());
pstmt.setString(6, perceroObject.getDescription());
pstmt.setString(7, perceroObject.getEmployeeId());
pstmt.setString(8, perceroObject.getTempStoreId());
pstmt.setString(9, perceroObject.getType());
pstmt.setString(10, perceroObject.getUpdatedBy());
pstmt.setString(11, perceroObject.getVersion());
pstmt.setString(12, perceroObject.getID());

		
	}
	
	
	@Override
	protected void setCallableStatmentUpdateParams(CoachingSessionAttachment perceroObject, CallableStatement pstmt) throws SQLException 
	{
		
		//must be in same order as insert
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	}
	
	

	@Override
	public List<CoachingSessionAttachment> findByExample(CoachingSessionAttachment theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useName = StringUtils.hasText(theQueryObject.getName()) && (excludeProperties == null || !excludeProperties.contains("name"));

if (useName)
{
sql += " WHERE ";
sql += " \"NAME\" =? ";
paramValues.add(theQueryObject.getName());
propertyCounter++;
}

boolean useCreatedOn = theQueryObject.getCreatedOn() != null && (excludeProperties == null || !excludeProperties.contains("createdOn"));

if (useCreatedOn)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"CREATED_ON\" =? ";
paramValues.add(theQueryObject.getCreatedOn());
propertyCounter++;
}

boolean useUpdatedOn = theQueryObject.getUpdatedOn() != null && (excludeProperties == null || !excludeProperties.contains("updatedOn"));

if (useUpdatedOn)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"UPDATED_ON\" =? ";
paramValues.add(theQueryObject.getUpdatedOn());
propertyCounter++;
}

boolean useDocumentReferenceId = theQueryObject.getDocumentReferenceId() != null && (excludeProperties == null || !excludeProperties.contains("documentReferenceId"));

if (useDocumentReferenceId)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"DOCUMENT_REFERENCE_ID\" =? ";
paramValues.add(theQueryObject.getDocumentReferenceId());
propertyCounter++;
}

boolean useCreatedBy = StringUtils.hasText(theQueryObject.getCreatedBy()) && (excludeProperties == null || !excludeProperties.contains("createdBy"));

if (useCreatedBy)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"CREATED_BY\" =? ";
paramValues.add(theQueryObject.getCreatedBy());
propertyCounter++;
}

boolean useDescription = StringUtils.hasText(theQueryObject.getDescription()) && (excludeProperties == null || !excludeProperties.contains("description"));

if (useDescription)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"DESCRIPTION\" =? ";
paramValues.add(theQueryObject.getDescription());
propertyCounter++;
}

boolean useEmployeeId = StringUtils.hasText(theQueryObject.getEmployeeId()) && (excludeProperties == null || !excludeProperties.contains("employeeId"));

if (useEmployeeId)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"EMPLOYEE_ID\" =? ";
paramValues.add(theQueryObject.getEmployeeId());
propertyCounter++;
}

boolean useTempStoreId = StringUtils.hasText(theQueryObject.getTempStoreId()) && (excludeProperties == null || !excludeProperties.contains("tempStoreId"));

if (useTempStoreId)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"TEMP_STORE_ID\" =? ";
paramValues.add(theQueryObject.getTempStoreId());
propertyCounter++;
}

boolean useType = StringUtils.hasText(theQueryObject.getType()) && (excludeProperties == null || !excludeProperties.contains("type"));

if (useType)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"TYPE\" =? ";
paramValues.add(theQueryObject.getType());
propertyCounter++;
}

boolean useUpdatedBy = StringUtils.hasText(theQueryObject.getUpdatedBy()) && (excludeProperties == null || !excludeProperties.contains("updatedBy"));

if (useUpdatedBy)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"UPDATED_BY\" =? ";
paramValues.add(theQueryObject.getUpdatedBy());
propertyCounter++;
}

boolean useVersion = StringUtils.hasText(theQueryObject.getVersion()) && (excludeProperties == null || !excludeProperties.contains("version"));

if (useVersion)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"VERSION\" =? ";
paramValues.add(theQueryObject.getVersion());
propertyCounter++;
}



		if (propertyCounter == 0) {
			throw new SyncException(SyncException.METHOD_UNSUPPORTED, SyncException.METHOD_UNSUPPORTED_CODE);
		}
		
		return executeSelectWithParams(sql, paramValues.toArray(), shellOnly);		
	}
	
	@Override
	protected String getUpdateCallableStatementSql() {
		return "{call UPDATE_ADHOC_ATTACHMENT(?,?,?,?,?,?,?,?,?,?,?,?)}";
	}
	@Override
	protected String getInsertCallableStatementSql() {
		return "{call CREATE_ADHOC_ATTACHMENT(?,?,?,?,?,?,?,?,?,?,?,?)}";
	}
	@Override
	protected String getDeleteCallableStatementSql() {
		return "{call Delete_ADHOC_ATTACHMENT(?)}";
	}
	
	
	
	
}
