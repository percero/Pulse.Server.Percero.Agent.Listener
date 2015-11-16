
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
import com.percero.agents.sync.metadata.MappedClass;
import com.percero.agents.sync.dao.DAORegistry;
import com.percero.agents.sync.dao.IDataAccessObject;
import com.percero.agents.sync.exceptions.SyncException;
import com.percero.agents.sync.vo.BaseDataObject;
import java.sql.Connection;
import java.sql.Statement;
import com.pulse.dataprovider.IConnectionFactory;
import com.percero.agents.sync.exceptions.SyncDataException;
import com.pulse.mo.*;

@Component
public class CorrectiveActionAttachmentDAO extends SqlDataAccessObject<CorrectiveActionAttachment> implements IDataAccessObject<CorrectiveActionAttachment> {

	static final Logger log = Logger.getLogger(CorrectiveActionAttachmentDAO.class);

	
	public CorrectiveActionAttachmentDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(CorrectiveActionAttachment.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	
	public static final String SHELL_ONLY_SELECT = "\"CORRECTIVE_ATTACHMENT\".\"ID\"";
	public static final String SQL_VIEW = ",\"CORRECTIVE_ATTACHMENT\".\"CREATED_ON\",\"CORRECTIVE_ATTACHMENT\".\"UPDATED_ON\",\"CORRECTIVE_ATTACHMENT\".\"TYPE\",\"CORRECTIVE_ATTACHMENT\".\"CREATED_BY\",\"CORRECTIVE_ATTACHMENT\".\"DESCRIPTION\",\"CORRECTIVE_ATTACHMENT\".\"EMPLOYEE_ID\",\"CORRECTIVE_ATTACHMENT\".\"TEMP_STORE_ID\",\"CORRECTIVE_ATTACHMENT\".\"UPDATED_BY\",\"CORRECTIVE_ATTACHMENT\".\"VERSION\",\"CORRECTIVE_ATTACHMENT\".\"CORRECTIVE_ACTION_ID\"";
	private String selectFromStatementTableName = " FROM \"CORRECTIVE_ATTACHMENT\" \"CORRECTIVE_ATTACHMENT\"";
	private String whereClause = "  WHERE \"CORRECTIVE_ATTACHMENT\".\"ID\"=?";
	private String whereInClause = "  join table(sys.dbms_debug_vc2coll(?)) SQLLIST on \"CORRECTIVE_ATTACHMENT\".\"ID\"= SQLLIST.column_value";
	private String orderByTableName = "  ORDER BY \"CORRECTIVE_ATTACHMENT\".\"ID\"";
	
	

	
	@Override
	protected String getConnectionFactoryName() {
		return CorrectiveActionAttachmentDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT " + SHELL_ONLY_SELECT +  " " + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT \"CORRECTIVE_ATTACHMENT\".\"ID\"" + SQL_VIEW  + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName +  orderByTableName;
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName  +  orderByTableName  + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT \"CORRECTIVE_ATTACHMENT\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName  + orderByTableName;
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT \"CORRECTIVE_ATTACHMENT\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + orderByTableName + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() 
	{
		return "SELECT COUNT(ID) " + selectFromStatementTableName;
	}
	
	@Override
	protected String getSelectInStarSQL() 
	{
		return "SELECT \"CORRECTIVE_ATTACHMENT\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + whereInClause;
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName + whereInClause;
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		
		return "SELECT \"CORRECTIVE_ATTACHMENT\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + " WHERE \"CORRECTIVE_ATTACHMENT\"." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) 
	{
		
		return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName + " WHERE \"CORRECTIVE_ATTACHMENT\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName;
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT \"CORRECTIVE_ATTACHMENT\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName;
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO TBL_CORRECTIVE_ATTACHMENT (\"ID\",\"CREATED_ON\",\"UPDATED_ON\",\"TYPE\",\"CREATED_BY\",\"DESCRIPTION\",\"EMPLOYEE_ID\",\"TEMP_STORE_ID\",\"UPDATED_BY\",\"VERSION\",\"CORRECTIVE_ACTION_ID\") VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE TBL_CORRECTIVE_ATTACHMENT SET \"CREATED_ON\"=?,\"UPDATED_ON\"=?,\"TYPE\"=?,\"CREATED_BY\"=?,\"DESCRIPTION\"=?,\"EMPLOYEE_ID\"=?,\"TEMP_STORE_ID\"=?,\"UPDATED_BY\"=?,\"VERSION\"=?,\"CORRECTIVE_ACTION_ID\"=? WHERE \"ID\"=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM TBL_CORRECTIVE_ATTACHMENT WHERE \"ID\"=?";
	}
	
	@Override
	protected CorrectiveActionAttachment extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	
		
CorrectiveActionAttachment nextResult = null;
    	
		    	
    	if (nextResult == null) {
    		nextResult = new CorrectiveActionAttachment();
    	}

		
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setCreatedOn(DateUtils.utilDateFromSqlTimestamp(rs.getTimestamp("CREATED_ON")));


nextResult.setUpdatedOn(DateUtils.utilDateFromSqlTimestamp(rs.getTimestamp("UPDATED_ON")));


nextResult.setType(rs.getInt("TYPE"));


nextResult.setCreatedBy(rs.getString("CREATED_BY"));


nextResult.setDescription(rs.getString("DESCRIPTION"));


nextResult.setEmployeeId(rs.getString("EMPLOYEE_ID"));


nextResult.setTempStoreId(rs.getString("TEMP_STORE_ID"));


nextResult.setUpdatedBy(rs.getString("UPDATED_BY"));


nextResult.setVersion(rs.getString("VERSION"));


String correctiveactionID = rs.getString("CORRECTIVE_ACTION_ID");
if (StringUtils.hasText(correctiveactionID) && !"null".equalsIgnoreCase(correctiveactionID) ){
CorrectiveAction correctiveaction = new CorrectiveAction();
correctiveaction.setID(correctiveactionID);
nextResult.setCorrectiveAction(correctiveaction);
}



			
    	}
		
		
    	return nextResult;
	}
	
	protected void setBaseStatmentInsertParams(CorrectiveActionAttachment perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setDate(2, DateUtils.utilDateToSqlDate(perceroObject.getCreatedOn()));
pstmt.setDate(3, DateUtils.utilDateToSqlDate(perceroObject.getUpdatedOn()));
JdbcHelper.setInt(pstmt,4, perceroObject.getType());
pstmt.setString(5, perceroObject.getCreatedBy());
pstmt.setString(6, perceroObject.getDescription());
pstmt.setString(7, perceroObject.getEmployeeId());
pstmt.setString(8, perceroObject.getTempStoreId());
pstmt.setString(9, perceroObject.getUpdatedBy());
pstmt.setString(10, perceroObject.getVersion());

if (perceroObject.getCorrectiveAction() == null)
{
pstmt.setString(11, null);
}
else
{
		pstmt.setString(11, perceroObject.getCorrectiveAction().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(CorrectiveActionAttachment perceroObject, PreparedStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
		
	}
	
	@Override
	protected void setCallableStatmentInsertParams(CorrectiveActionAttachment perceroObject, CallableStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	

	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(CorrectiveActionAttachment perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setDate(1, DateUtils.utilDateToSqlDate(perceroObject.getCreatedOn()));
pstmt.setDate(2, DateUtils.utilDateToSqlDate(perceroObject.getUpdatedOn()));
JdbcHelper.setInt(pstmt,3, perceroObject.getType());
pstmt.setString(4, perceroObject.getCreatedBy());
pstmt.setString(5, perceroObject.getDescription());
pstmt.setString(6, perceroObject.getEmployeeId());
pstmt.setString(7, perceroObject.getTempStoreId());
pstmt.setString(8, perceroObject.getUpdatedBy());
pstmt.setString(9, perceroObject.getVersion());

if (perceroObject.getCorrectiveAction() == null)
{
pstmt.setString(10, null);
}
else
{
		pstmt.setString(10, perceroObject.getCorrectiveAction().getID());
}

pstmt.setString(11, perceroObject.getID());

		
	}
	
	
	@Override
	protected void setCallableStatmentUpdateParams(CorrectiveActionAttachment perceroObject, CallableStatement pstmt) throws SQLException 
	{
		
		//must be in same order as insert
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	}
	
	

	@Override
	public List<CorrectiveActionAttachment> findByExample(CorrectiveActionAttachment theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useCreatedOn = theQueryObject.getCreatedOn() != null && (excludeProperties == null || !excludeProperties.contains("createdOn"));

if (useCreatedOn)
{
sql += " WHERE ";
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

boolean useType = theQueryObject.getType() != null && (excludeProperties == null || !excludeProperties.contains("type"));

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

boolean useCorrectiveActionID = theQueryObject.getCorrectiveAction() != null && (excludeProperties == null || !excludeProperties.contains("correctiveAction"));

if (useCorrectiveActionID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"CORRECTIVE_ACTION_ID\" =? ";
paramValues.add(theQueryObject.getCorrectiveAction().getID());
propertyCounter++;
}



		if (propertyCounter == 0) {
			throw new SyncException(SyncException.METHOD_UNSUPPORTED, SyncException.METHOD_UNSUPPORTED_CODE);
		}
		
		return executeSelectWithParams(sql, paramValues.toArray(), shellOnly);		
	}
	
	@Override
	protected String getUpdateCallableStatementSql() {
		return "{call UPDATE_CORRECTIVE_ATTACHMENT(?,?,?,?,?,?,?,?,?,?,?)}";
	}
	@Override
	protected String getInsertCallableStatementSql() {
		return "{call CREATE_CORRECTIVE_ATTACHMENT(?,?,?,?,?,?,?,?,?,?,?)}";
	}
	@Override
	protected String getDeleteCallableStatementSql() {
		return "{call Delete_CORRECTIVE_ATTACHMENT(?)}";
	}
	
	
public CorrectiveActionAttachment createObject(CorrectiveActionAttachment perceroObject, String userId)
		throws SyncException {
	if ( !hasCreateAccess(BaseDataObject.toClassIdPair(perceroObject), userId) ) {
		return null;
	}

	long timeStart = System.currentTimeMillis();

	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	String query = "Select CORRECTIVE_ATTACHMENT_SEQ.NEXTVAL from dual";
	String sql = null;
	String insertedId = "0";
	int result = 0;
	try {
		IConnectionFactory connectionFactory = getConnectionRegistry().getConnectionFactory(getConnectionFactoryName());
		conn = connectionFactory.getConnection();
		conn.setAutoCommit(false);
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			insertedId = rs.getString(1);
		}

		perceroObject.setID(insertedId);
		sql = getInsertIntoSQL();
		pstmt = conn.prepareStatement(sql);


		setPreparedStatmentInsertParams(perceroObject, pstmt);
		result = pstmt.executeUpdate();
		conn.commit();
	} catch(Exception e) {
		log.error("Unable to executeUpdate\n" + sql, e);
		throw new SyncDataException(e);
	} finally {
		try {
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.setAutoCommit(true);
				conn.close();
			}
		} catch (Exception e) {
			log.error("Error closing database statement/connection", e);
		}
	}

	long timeEnd = System.currentTimeMillis();
	long totalTime = timeEnd - timeStart;
	if (totalTime > LONG_RUNNING_QUERY_TIME) {
		log.warn("LONG RUNNING QUERY: " + totalTime + "ms\n" + sql);
	}

	if (result > 0) {
		return retrieveObject(BaseDataObject.toClassIdPair(perceroObject), userId, false);
	}
	else {
		return null;
	}
}


	
	
}
