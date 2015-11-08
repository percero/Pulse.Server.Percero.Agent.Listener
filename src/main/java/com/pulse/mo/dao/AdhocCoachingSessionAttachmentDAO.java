
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
public class AdhocCoachingSessionAttachmentDAO extends SqlDataAccessObject<AdhocCoachingSessionAttachment> implements IDataAccessObject<AdhocCoachingSessionAttachment> {

	static final Logger log = Logger.getLogger(AdhocCoachingSessionAttachmentDAO.class);

	
	public AdhocCoachingSessionAttachmentDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(AdhocCoachingSessionAttachment.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	
	public static final String SHELL_ONLY_SELECT = "\"ADHOC_ATTACHMENT\".\"ID\"";
	public static final String SQL_VIEW = ",\"ADHOC_ATTACHMENT\".\"NAME\",\"ADHOC_ATTACHMENT\".\"CREATED_BY\",\"ADHOC_ATTACHMENT\".\"CREATED_ON\",\"ADHOC_ATTACHMENT\".\"DESCRIPTION\",\"ADHOC_ATTACHMENT\".\"EMPLOYEE_ID\",\"ADHOC_ATTACHMENT\".\"TEMP_STORE_ID\",\"ADHOC_ATTACHMENT\".\"TYPE\",\"ADHOC_ATTACHMENT\".\"UPDATED_BY\",\"ADHOC_ATTACHMENT\".\"UPDATED_ON\",\"ADHOC_ATTACHMENT\".\"VERSION\",\"ADHOC_ATTACHMENT\".\"ADHOC_COACHING_SESSION_ID\"";
	private String selectFromStatementTableName = " FROM \"ADHOC_ATTACHMENT\" \"ADHOC_ATTACHMENT\"";
	private String whereClause = "  WHERE \"ADHOC_ATTACHMENT\".\"ID\"=?";
	private String whereInClause = "  join table(sys.dbms_debug_vc2coll(?)) SQLLIST on \"ADHOC_ATTACHMENT\".\"ID\"= SQLLIST.column_value";
	private String orderByTableName = "  ORDER BY \"ADHOC_ATTACHMENT\".\"ID\"";
	
	

	
	@Override
	protected String getConnectionFactoryName() {
		return AdhocCoachingSessionAttachmentDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT " + SHELL_ONLY_SELECT +  " " + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT \"ADHOC_ATTACHMENT\".\"ID\"" + SQL_VIEW  + selectFromStatementTableName + whereClause;
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
		return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName + whereInClause;
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		
		return "SELECT \"ADHOC_ATTACHMENT\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + " WHERE \"ADHOC_ATTACHMENT\"." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) 
	{
		
		return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName + " WHERE \"ADHOC_ATTACHMENT\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName;
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT \"ADHOC_ATTACHMENT\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName;
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO TBL_ADHOC_ATTACHMENT (\"ID\",\"NAME\",\"CREATED_BY\",\"CREATED_ON\",\"DESCRIPTION\",\"EMPLOYEE_ID\",\"TEMP_STORE_ID\",\"TYPE\",\"UPDATED_BY\",\"UPDATED_ON\",\"VERSION\",\"ADHOC_COACHING_SESSION_ID\") VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE TBL_ADHOC_ATTACHMENT SET \"NAME\"=?,\"CREATED_BY\"=?,\"CREATED_ON\"=?,\"DESCRIPTION\"=?,\"EMPLOYEE_ID\"=?,\"TEMP_STORE_ID\"=?,\"TYPE\"=?,\"UPDATED_BY\"=?,\"UPDATED_ON\"=?,\"VERSION\"=?,\"ADHOC_COACHING_SESSION_ID\"=? WHERE \"ID\"=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM TBL_ADHOC_ATTACHMENT WHERE \"ID\"=?";
	}
	
	@Override
	protected AdhocCoachingSessionAttachment extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	
		
AdhocCoachingSessionAttachment nextResult = null;
    	
		    	
    	if (nextResult == null) {
    		nextResult = new AdhocCoachingSessionAttachment();
    	}

		
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setName(rs.getString("NAME"));


nextResult.setCreatedBy(rs.getString("CREATED_BY"));


nextResult.setCreatedOn(rs.getString("CREATED_ON"));


nextResult.setDescription(rs.getString("DESCRIPTION"));


nextResult.setEmployeeId(rs.getString("EMPLOYEE_ID"));


nextResult.setTempStoreId(rs.getString("TEMP_STORE_ID"));


nextResult.setType(rs.getString("TYPE"));


nextResult.setUpdatedBy(rs.getString("UPDATED_BY"));


nextResult.setUpdatedOn(rs.getString("UPDATED_ON"));


nextResult.setVersion(rs.getString("VERSION"));


String adhoccoachingsessionID = rs.getString("ADHOC_COACHING_SESSION_ID");
if (StringUtils.hasText(adhoccoachingsessionID)) {
AdhocCoachingSession adhoccoachingsession = new AdhocCoachingSession();
adhoccoachingsession.setID(adhoccoachingsessionID);
nextResult.setAdhocCoachingSession(adhoccoachingsession);
}



			
    	}
		
		
    	return nextResult;
	}
	
	protected void setBaseStatmentInsertParams(AdhocCoachingSessionAttachment perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getName());
pstmt.setString(3, perceroObject.getCreatedBy());
pstmt.setString(4, perceroObject.getCreatedOn());
pstmt.setString(5, perceroObject.getDescription());
pstmt.setString(6, perceroObject.getEmployeeId());
pstmt.setString(7, perceroObject.getTempStoreId());
pstmt.setString(8, perceroObject.getType());
pstmt.setString(9, perceroObject.getUpdatedBy());
pstmt.setString(10, perceroObject.getUpdatedOn());
pstmt.setString(11, perceroObject.getVersion());

if (perceroObject.getAdhocCoachingSession() == null)
{
pstmt.setString(12, null);
}
else
{
		pstmt.setString(12, perceroObject.getAdhocCoachingSession().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(AdhocCoachingSessionAttachment perceroObject, PreparedStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
		
	}
	
	@Override
	protected void setCallableStatmentInsertParams(AdhocCoachingSessionAttachment perceroObject, CallableStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	

	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(AdhocCoachingSessionAttachment perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getName());
pstmt.setString(2, perceroObject.getCreatedBy());
pstmt.setString(3, perceroObject.getCreatedOn());
pstmt.setString(4, perceroObject.getDescription());
pstmt.setString(5, perceroObject.getEmployeeId());
pstmt.setString(6, perceroObject.getTempStoreId());
pstmt.setString(7, perceroObject.getType());
pstmt.setString(8, perceroObject.getUpdatedBy());
pstmt.setString(9, perceroObject.getUpdatedOn());
pstmt.setString(10, perceroObject.getVersion());

if (perceroObject.getAdhocCoachingSession() == null)
{
pstmt.setString(11, null);
}
else
{
		pstmt.setString(11, perceroObject.getAdhocCoachingSession().getID());
}

pstmt.setString(12, perceroObject.getID());

		
	}
	
	
	@Override
	protected void setCallableStatmentUpdateParams(AdhocCoachingSessionAttachment perceroObject, CallableStatement pstmt) throws SQLException 
	{
		
		//must be in same order as insert
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	}
	
	

	@Override
	public List<AdhocCoachingSessionAttachment> findByExample(AdhocCoachingSessionAttachment theQueryObject,
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

boolean useCreatedOn = StringUtils.hasText(theQueryObject.getCreatedOn()) && (excludeProperties == null || !excludeProperties.contains("createdOn"));

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

boolean useUpdatedOn = StringUtils.hasText(theQueryObject.getUpdatedOn()) && (excludeProperties == null || !excludeProperties.contains("updatedOn"));

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

boolean useAdhocCoachingSessionID = theQueryObject.getAdhocCoachingSession() != null && (excludeProperties == null || !excludeProperties.contains("adhocCoachingSession"));

if (useAdhocCoachingSessionID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"ADHOC_COACHING_SESSION_ID\" =? ";
paramValues.add(theQueryObject.getAdhocCoachingSession().getID());
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
	
	
public AdhocCoachingSessionAttachment createObject(AdhocCoachingSessionAttachment perceroObject, String userId)
		throws SyncException {
	if ( !hasCreateAccess(BaseDataObject.toClassIdPair(perceroObject), userId) ) {
		return null;
	}

	long timeStart = System.currentTimeMillis();

	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	String query = "Select ADHOC_ATTACHMENT_SEQ.NEXTVAL from dual";
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
