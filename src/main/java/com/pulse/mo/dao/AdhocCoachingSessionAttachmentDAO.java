


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
	
	public static final String SQL_VIEW = ",\"CORRECTIVE_ATTACHMENT\".\"NAME\",\"CORRECTIVE_ATTACHMENT\".\"CREATED_BY\",\"CORRECTIVE_ATTACHMENT\".\"CREATED_ON\",\"CORRECTIVE_ATTACHMENT\".\"DESCRIPTION\",\"CORRECTIVE_ATTACHMENT\".\"DOCUMENT_REFERENCE_ID\",\"CORRECTIVE_ATTACHMENT\".\"EMPLOYEE_ID\",\"CORRECTIVE_ATTACHMENT\".\"TEMP_STORE_ID\",\"CORRECTIVE_ATTACHMENT\".\"TYPE\",\"CORRECTIVE_ATTACHMENT\".\"UPDATED_BY\",\"CORRECTIVE_ATTACHMENT\".\"UPDATED_ON\",\"CORRECTIVE_ATTACHMENT\".\"VERSION\"";
	private String selectFromStatementTableName = " FROM \"CORRECTIVE_ATTACHMENT\" \"CORRECTIVE_ATTACHMENT\"";
	private String whereClause = "  WHERE \"CORRECTIVE_ATTACHMENT\".\"ID\"=?";
	private String whereInClause = "  join table(sys.dbms_debug_vc2coll(?)) SQLLIST on \"CORRECTIVE_ATTACHMENT\".\"ID\"= SQLLIST.column_value";
	private String orderByTableName = "  ORDER BY \"CORRECTIVE_ATTACHMENT\".\"ID\"";
	
	

	
	@Override
	protected String getConnectionFactoryName() {
		return AdhocCoachingSessionAttachmentDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT \"CORRECTIVE_ATTACHMENT\".\"ID\" " + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT \"CORRECTIVE_ATTACHMENT\".\"ID\"" + SQL_VIEW  + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT \"CORRECTIVE_ATTACHMENT\".\"ID\" " + selectFromStatementTableName +  orderByTableName;
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT \"CORRECTIVE_ATTACHMENT\".\"ID\" " + selectFromStatementTableName  +  orderByTableName  + " LIMIT ? OFFSET ?";
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
		return "SELECT \"CORRECTIVE_ATTACHMENT\".\"ID\" " + selectFromStatementTableName + whereInClause;
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		
		return "SELECT \"CORRECTIVE_ATTACHMENT\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + " WHERE \"CORRECTIVE_ATTACHMENT\"." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) 
	{
		
		return "SELECT \"CORRECTIVE_ATTACHMENT\".\"ID\" " + selectFromStatementTableName + " WHERE \"CORRECTIVE_ATTACHMENT\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT \"CORRECTIVE_ATTACHMENT\".\"ID\" " + selectFromStatementTableName;
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT \"CORRECTIVE_ATTACHMENT\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName;
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO TBL_CORRECTIVE_ATTACHMENT (\"ID\",\"NAME\",\"CREATED_BY\",\"CREATED_ON\",\"DESCRIPTION\",\"DOCUMENT_REFERENCE_ID\",\"EMPLOYEE_ID\",\"TEMP_STORE_ID\",\"TYPE\",\"UPDATED_BY\",\"UPDATED_ON\",\"VERSION\") VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE TBL_CORRECTIVE_ATTACHMENT SET \"NAME\"=?,\"CREATED_BY\"=?,\"CREATED_ON\"=?,\"DESCRIPTION\"=?,\"DOCUMENT_REFERENCE_ID\"=?,\"EMPLOYEE_ID\"=?,\"TEMP_STORE_ID\"=?,\"TYPE\"=?,\"UPDATED_BY\"=?,\"UPDATED_ON\"=?,\"VERSION\"=? WHERE \"ID\"=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM TBL_CORRECTIVE_ATTACHMENT WHERE \"ID\"=?";
	}
	
	@Override
	protected AdhocCoachingSessionAttachment extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	AdhocCoachingSessionAttachment nextResult = new AdhocCoachingSessionAttachment();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setName(rs.getString("NAME"));

nextResult.setCreatedBy(rs.getString("CREATED_BY"));

nextResult.setCreatedOn(rs.getString("CREATED_ON"));

nextResult.setDescription(rs.getString("DESCRIPTION"));

nextResult.setDocumentReferenceId(rs.getString("DOCUMENT_REFERENCE_ID"));

nextResult.setEmployeeId(rs.getString("EMPLOYEE_ID"));

nextResult.setTempStoreId(rs.getString("TEMP_STORE_ID"));

nextResult.setType(rs.getString("TYPE"));

nextResult.setUpdatedBy(rs.getString("UPDATED_BY"));

nextResult.setUpdatedOn(rs.getString("UPDATED_ON"));

nextResult.setVersion(rs.getString("VERSION"));


			
    	}
    	
    	return nextResult;
	}
	
	protected void setBaseStatmentInsertParams(AdhocCoachingSessionAttachment perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getName());
pstmt.setString(3, perceroObject.getCreatedBy());
pstmt.setString(4, perceroObject.getCreatedOn());
pstmt.setString(5, perceroObject.getDescription());
pstmt.setString(6, perceroObject.getDocumentReferenceId());
pstmt.setString(7, perceroObject.getEmployeeId());
pstmt.setString(8, perceroObject.getTempStoreId());
pstmt.setString(9, perceroObject.getType());
pstmt.setString(10, perceroObject.getUpdatedBy());
pstmt.setString(11, perceroObject.getUpdatedOn());
pstmt.setString(12, perceroObject.getVersion());

		
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
pstmt.setString(5, perceroObject.getDocumentReferenceId());
pstmt.setString(6, perceroObject.getEmployeeId());
pstmt.setString(7, perceroObject.getTempStoreId());
pstmt.setString(8, perceroObject.getType());
pstmt.setString(9, perceroObject.getUpdatedBy());
pstmt.setString(10, perceroObject.getUpdatedOn());
pstmt.setString(11, perceroObject.getVersion());
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

boolean useDocumentReferenceId = StringUtils.hasText(theQueryObject.getDocumentReferenceId()) && (excludeProperties == null || !excludeProperties.contains("documentReferenceId"));

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



		if (propertyCounter == 0) {
			throw new SyncException(SyncException.METHOD_UNSUPPORTED, SyncException.METHOD_UNSUPPORTED_CODE);
		}
		
		return executeSelectWithParams(sql, paramValues.toArray(), shellOnly);		
	}
	
	@Override
	protected String getUpdateCallableStatementSql() {
		return "{call UPDATE_CORRECTIVE_ATTACHMENT(?,?,?,?,?,?,?,?,?,?,?,?)}";
	}
	@Override
	protected String getInsertCallableStatementSql() {
		return "{call CREATE_CORRECTIVE_ATTACHMENT(?,?,?,?,?,?,?,?,?,?,?,?)}";
	}
	@Override
	protected String getDeleteCallableStatementSql() {
		return "{call Delete_CORRECTIVE_ATTACHMENT(?)}";
	}
	
	
	
	
}
