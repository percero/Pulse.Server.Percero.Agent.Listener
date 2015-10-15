
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
import com.pulse.mo.CoachingSessionAttachment;

*/

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
	
	public static final String SQL_VIEW = ",\"COACHING_SESSION_ATTACHMENT\".\"FILE_URI\",\"COACHING_SESSION_ATTACHMENT\".\"NAME\",\"COACHING_SESSION_ATTACHMENT\".\"DOCUMENT_REFERENCE_ID\",\"COACHING_SESSION_ATTACHMENT\".\"TYPE\"";
	private String selectFromStatementTableName = " FROM \"COACHING_SESSION_ATTACHMENT\" \"COACHING_SESSION_ATTACHMENT\"";
	private String whereClause = " WHERE \"COACHING_SESSION_ATTACHMENT\".\"ID\"=?";
	private String whereInClause = " join table(sys.dbms_debug_vc2coll(?)) SQLLIST on \"COACHING_SESSION_ATTACHMENT\".\"ID\"= SQLLIST.column_value";
	private String orderByTableName = " ORDER BY \"COACHING_SESSION_ATTACHMENT\".\"ID\"";
	
	

	
	@Override
	protected String getConnectionFactoryName() {
		return CoachingSessionAttachmentDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT \"COACHING_SESSION_ATTACHMENT\".\"ID\" " + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT \"COACHING_SESSION_ATTACHMENT\".\"ID\"" + SQL_VIEW  + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT \"COACHING_SESSION_ATTACHMENT\".\"ID\" " + selectFromStatementTableName +  orderByTableName;
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT \"COACHING_SESSION_ATTACHMENT\".\"ID\" " + selectFromStatementTableName  +  orderByTableName  + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT \"COACHING_SESSION_ATTACHMENT\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName  + orderByTableName;
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT \"COACHING_SESSION_ATTACHMENT\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + orderByTableName + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() 
	{
		return "SELECT COUNT(ID) " + selectFromStatementTableName;
	}
	
	@Override
	protected String getSelectInStarSQL() 
	{
		return "SELECT \"COACHING_SESSION_ATTACHMENT\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + whereInClause;
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT \"COACHING_SESSION_ATTACHMENT\".\"ID\" " + selectFromStatementTableName + whereInClause;
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		
		return "SELECT \"COACHING_SESSION_ATTACHMENT\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + " WHERE \"COACHING_SESSION_ATTACHMENT\"." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) 
	{
		
		return "SELECT \"COACHING_SESSION_ATTACHMENT\".\"ID\" " + selectFromStatementTableName + " WHERE \"COACHING_SESSION_ATTACHMENT\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT \"COACHING_SESSION_ATTACHMENT\".\"ID\" " + selectFromStatementTableName;
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT \"COACHING_SESSION_ATTACHMENT\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName;
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO COACHING_SESSION_ATTACHMENT (\"ID\",\"FILE_URI\",\"NAME\",\"DOCUMENT_REFERENCE_ID\",\"TYPE\") VALUES (?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE \"COACHING_SESSION_ATTACHMENT\" SET \"FILE_URI\"=?,\"NAME\"=?,\"DOCUMENT_REFERENCE_ID\"=?,\"TYPE\"=? WHERE \"ID\"=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM \"COACHING_SESSION_ATTACHMENT\" WHERE \"ID\"=?";
	}
	
	@Override
	protected CoachingSessionAttachment extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	CoachingSessionAttachment nextResult = new CoachingSessionAttachment();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setFileUri(rs.getString("FILE_URI"));

nextResult.setName(rs.getString("NAME"));

nextResult.setDocumentReferenceId(rs.getString("DOCUMENT_REFERENCE_ID"));

nextResult.setType(rs.getString("TYPE"));


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(CoachingSessionAttachment perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getFileUri());
pstmt.setString(3, perceroObject.getName());
pstmt.setString(4, perceroObject.getDocumentReferenceId());
pstmt.setString(5, perceroObject.getType());

		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(CoachingSessionAttachment perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getFileUri());
pstmt.setString(2, perceroObject.getName());
pstmt.setString(3, perceroObject.getDocumentReferenceId());
pstmt.setString(4, perceroObject.getType());
pstmt.setString(5, perceroObject.getID());

		
	}

	@Override
	public List<CoachingSessionAttachment> findByExample(CoachingSessionAttachment theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useFileUri = StringUtils.hasText(theQueryObject.getFileUri()) && (excludeProperties == null || !excludeProperties.contains("fileUri"));

if (useFileUri)
{
sql += " WHERE ";
sql += " \"FILE_URI\" =? ";
paramValues.add(theQueryObject.getFileUri());
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
