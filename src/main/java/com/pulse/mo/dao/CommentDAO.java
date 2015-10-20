
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
public class CommentDAO extends SqlDataAccessObject<Comment> implements IDataAccessObject<Comment> {

	static final Logger log = Logger.getLogger(CommentDAO.class);

	
	public CommentDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(Comment.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	
	public static final String SQL_VIEW = ",\"COMMENT\".\"DESCRIPTION\",\"COMMENT\".\"CREATED_ON\",\"COMMENT\".\"UPDATED_ON\",\"COMMENT\".\"DATAREF_ID\",\"COMMENT\".\"SESSION_ID\",\"COMMENT\".\"TYPE\",\"COMMENT\".\"CREATED_BY\",\"COMMENT\".\"UPDATED_BY\"";
	private String selectFromStatementTableName = " FROM \"COMMENT\" \"COMMENT\"";
	private String whereClause = "  WHERE \"COMMENT\".\"ID\"=?";
	private String whereInClause = "  join table(sys.dbms_debug_vc2coll(?)) SQLLIST on \"COMMENT\".\"ID\"= SQLLIST.column_value";
	private String orderByTableName = "  ORDER BY \"COMMENT\".\"ID\"";
	
	

	
	@Override
	protected String getConnectionFactoryName() {
		return CommentDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT \"COMMENT\".\"ID\" " + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT \"COMMENT\".\"ID\"" + SQL_VIEW  + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT \"COMMENT\".\"ID\" " + selectFromStatementTableName +  orderByTableName;
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT \"COMMENT\".\"ID\" " + selectFromStatementTableName  +  orderByTableName  + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT \"COMMENT\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName  + orderByTableName;
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT \"COMMENT\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + orderByTableName + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() 
	{
		return "SELECT COUNT(ID) " + selectFromStatementTableName;
	}
	
	@Override
	protected String getSelectInStarSQL() 
	{
		return "SELECT \"COMMENT\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + whereInClause;
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT \"COMMENT\".\"ID\" " + selectFromStatementTableName + whereInClause;
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		
		return "SELECT \"COMMENT\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + " WHERE \"COMMENT\"." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) 
	{
		
		return "SELECT \"COMMENT\".\"ID\" " + selectFromStatementTableName + " WHERE \"COMMENT\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT \"COMMENT\".\"ID\" " + selectFromStatementTableName;
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT \"COMMENT\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName;
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO TBL_COMMENT (\"ID\",\"DESCRIPTION\",\"CREATED_ON\",\"UPDATED_ON\",\"DATAREF_ID\",\"SESSION_ID\",\"TYPE\",\"CREATED_BY\",\"UPDATED_BY\") VALUES (?,?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE TBL_COMMENT SET \"DESCRIPTION\"=?,\"CREATED_ON\"=?,\"UPDATED_ON\"=?,\"DATAREF_ID\"=?,\"SESSION_ID\"=?,\"TYPE\"=?,\"CREATED_BY\"=?,\"UPDATED_BY\"=? WHERE \"ID\"=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM TBL_COMMENT WHERE \"ID\"=?";
	}
	
	@Override
	protected Comment extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	Comment nextResult = new Comment();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setDescription(rs.getString("DESCRIPTION"));

nextResult.setCreatedOn(rs.getDate("CREATED_ON"));

nextResult.setUpdatedOn(rs.getDate("UPDATED_ON"));

nextResult.setDatarefId(rs.getInt("DATAREF_ID"));

nextResult.setSessionId(rs.getInt("SESSION_ID"));

nextResult.setType(rs.getInt("TYPE"));

nextResult.setCreatedBy(rs.getString("CREATED_BY"));

nextResult.setUpdatedBy(rs.getString("UPDATED_BY"));


			
    	}
    	
    	return nextResult;
	}
	
	protected void setBaseStatmentInsertParams(Comment perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getDescription());
pstmt.setDate(3, DateUtils.utilDateToSqlDate(perceroObject.getCreatedOn()));
pstmt.setDate(4, DateUtils.utilDateToSqlDate(perceroObject.getUpdatedOn()));
JdbcHelper.setInt(pstmt,5, perceroObject.getDatarefId());
JdbcHelper.setInt(pstmt,6, perceroObject.getSessionId());
JdbcHelper.setInt(pstmt,7, perceroObject.getType());
pstmt.setString(8, perceroObject.getCreatedBy());
pstmt.setString(9, perceroObject.getUpdatedBy());

		
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(Comment perceroObject, PreparedStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
		
	}
	
	@Override
	protected void setCallableStatmentInsertParams(Comment perceroObject, CallableStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	

	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(Comment perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getDescription());
pstmt.setDate(2, DateUtils.utilDateToSqlDate(perceroObject.getCreatedOn()));
pstmt.setDate(3, DateUtils.utilDateToSqlDate(perceroObject.getUpdatedOn()));
JdbcHelper.setInt(pstmt,4, perceroObject.getDatarefId());
JdbcHelper.setInt(pstmt,5, perceroObject.getSessionId());
JdbcHelper.setInt(pstmt,6, perceroObject.getType());
pstmt.setString(7, perceroObject.getCreatedBy());
pstmt.setString(8, perceroObject.getUpdatedBy());
pstmt.setString(9, perceroObject.getID());

		
	}
	
	
	@Override
	protected void setCallableStatmentUpdateParams(Comment perceroObject, CallableStatement pstmt) throws SQLException 
	{
		
		//must be in same order as insert
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	}
	
	

	@Override
	public List<Comment> findByExample(Comment theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useDescription = StringUtils.hasText(theQueryObject.getDescription()) && (excludeProperties == null || !excludeProperties.contains("description"));

if (useDescription)
{
sql += " WHERE ";
sql += " \"DESCRIPTION\" =? ";
paramValues.add(theQueryObject.getDescription());
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

boolean useDatarefId = theQueryObject.getDatarefId() != null && (excludeProperties == null || !excludeProperties.contains("datarefId"));

if (useDatarefId)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"DATAREF_ID\" =? ";
paramValues.add(theQueryObject.getDatarefId());
propertyCounter++;
}

boolean useSessionId = theQueryObject.getSessionId() != null && (excludeProperties == null || !excludeProperties.contains("sessionId"));

if (useSessionId)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"SESSION_ID\" =? ";
paramValues.add(theQueryObject.getSessionId());
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



		if (propertyCounter == 0) {
			throw new SyncException(SyncException.METHOD_UNSUPPORTED, SyncException.METHOD_UNSUPPORTED_CODE);
		}
		
		return executeSelectWithParams(sql, paramValues.toArray(), shellOnly);		
	}
	
	@Override
	protected String getUpdateCallableStatementSql() {
		return "{call UPDATE_COMMENT(?,?,?,?,?,?,?,?,?)}";
	}
	@Override
	protected String getInsertCallableStatementSql() {
		return "{call CREATE_COMMENT(?,?,?,?,?,?,?,?,?)}";
	}
	@Override
	protected String getDeleteCallableStatementSql() {
		return "{call Delete_COMMENT(?)}";
	}
	
	
	
	
}
