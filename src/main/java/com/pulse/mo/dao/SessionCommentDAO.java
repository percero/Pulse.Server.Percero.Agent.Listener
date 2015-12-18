

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
public class SessionCommentDAO extends SqlDataAccessObject<SessionComment> implements IDataAccessObject<SessionComment> {

	static final Logger log = Logger.getLogger(SessionCommentDAO.class);

	
	public SessionCommentDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(SessionComment.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	
	public static final String SHELL_ONLY_SELECT = "\"SESSION_COMMENT\".\"ID\"";
	public static final String SQL_VIEW = ",\"SESSION_COMMENT\".\"DESCRIPTION\",\"SESSION_COMMENT\".\"CREATED_BY\",\"SESSION_COMMENT\".\"UPDATED_BY\",\"SESSION_COMMENT\".\"CREATED_ON\",\"SESSION_COMMENT\".\"UPDATED_ON\",\"SESSION_COMMENT\".\"DATAREF_ID\",\"SESSION_COMMENT\".\"TYPE\",\"SESSION_COMMENT\".\"ADHOC_COACHING_SESSION_ID\",\"SESSION_COMMENT\".\"COACHING_SESSION_ID\",\"SESSION_COMMENT\".\"CORRECTIVE_ACTION_ID\"";
	private String selectFromStatementTableName = " FROM \"SESSION_COMMENT\" \"SESSION_COMMENT\"";
	private String whereClause = "  WHERE \"SESSION_COMMENT\".\"ID\"=?";
	private String whereInClause = "  join table(sys.dbms_debug_vc2coll(?)) SQLLIST on \"SESSION_COMMENT\".\"ID\"= SQLLIST.column_value";
	private String orderByTableName = "  ORDER BY \"SESSION_COMMENT\".\"ID\"";
	
	

	
	@Override
	protected String getConnectionFactoryName() {
		return SessionCommentDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT " + SHELL_ONLY_SELECT +  " " + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT \"SESSION_COMMENT\".\"ID\"" + SQL_VIEW  + selectFromStatementTableName + whereClause;
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
		return "SELECT \"SESSION_COMMENT\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName  + orderByTableName;
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT \"SESSION_COMMENT\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + orderByTableName + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() 
	{
		return "SELECT COUNT(ID) " + selectFromStatementTableName;
	}
	
	@Override
	protected String getSelectInStarSQL() 
	{
		return "SELECT \"SESSION_COMMENT\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + whereInClause;
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName + whereInClause;
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		
		return "SELECT \"SESSION_COMMENT\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + " WHERE \"SESSION_COMMENT\"." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) 
	{
		
		return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName + " WHERE \"SESSION_COMMENT\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName;
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT \"SESSION_COMMENT\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName;
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO EFC_SESSION_COMMENT  (\"COMMENT_ID\",\"SESSION_ID\", \"TYPE\", \"DATAREF_ID\", \"COMMENT_DESC\", \"CREATED_BY\", \"UPDATED_BY\", \"CREATED_ON\", \"UPDATED_ON\") VALUES (?,?,?,?,?,?,?,sysdate,sysdate)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE EFC_SESSION_COMMENT SET \"COMMENT_DESC\"=?,\"CREATED_ON\"=?,\"UPDATED_ON\"=sysdate,\"DATAREF_ID\"=?,\"SESSION_ID\"=?,\"TYPE\"=?,\"CREATED_BY\"=?,\"UPDATED_BY\"=? WHERE \"COMMENT_ID\"=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM TBL_SESSION_COMMENT WHERE \"ID\"=?";
	}
	
	@Override
	protected SessionComment extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	
		

SessionComment nextResult = null;
    	
		    	
    	if (nextResult == null) {
    		nextResult = new SessionComment();
    	}

		
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setDescription(rs.getString("DESCRIPTION"));


nextResult.setCreatedBy(rs.getString("CREATED_BY"));


nextResult.setUpdatedBy(rs.getString("UPDATED_BY"));


nextResult.setCreatedOn(DateUtils.utilDateFromSqlTimestamp(rs.getTimestamp("CREATED_ON")));


nextResult.setUpdatedOn(DateUtils.utilDateFromSqlTimestamp(rs.getTimestamp("UPDATED_ON")));


nextResult.setDatarefId(rs.getInt("DATAREF_ID"));


nextResult.setType(rs.getInt("TYPE"));


String adhoccoachingsessionID = rs.getString("ADHOC_COACHING_SESSION_ID");
if (StringUtils.hasText(adhoccoachingsessionID) && !"null".equalsIgnoreCase(adhoccoachingsessionID) ){
AdhocCoachingSession adhoccoachingsession = new AdhocCoachingSession();
adhoccoachingsession.setID(adhoccoachingsessionID);
nextResult.setAdhocCoachingSession(adhoccoachingsession);
}


String coachingsessionID = rs.getString("COACHING_SESSION_ID");
if (StringUtils.hasText(coachingsessionID) && !"null".equalsIgnoreCase(coachingsessionID) ){
CoachingSession coachingsession = new CoachingSession();
coachingsession.setID(coachingsessionID);
nextResult.setCoachingSession(coachingsession);
}


String correctiveactionID = rs.getString("CORRECTIVE_ACTION_ID");
if (StringUtils.hasText(correctiveactionID) && !"null".equalsIgnoreCase(correctiveactionID) ){
CorrectiveAction correctiveaction = new CorrectiveAction();
correctiveaction.setID(correctiveactionID);
nextResult.setCorrectiveAction(correctiveaction);
}



			
    	}
		
		
    	return nextResult;
	}
	
	protected void setBaseStatmentInsertParams(SessionComment perceroObject, PreparedStatement pstmt) throws SQLException {

		pstmt.setString(1, perceroObject.getID());  //COMMENT_ID
		if (perceroObject.getAdhocCoachingSession() != null)
		{
			pstmt.setString(2, perceroObject.getAdhocCoachingSession().getID());  //SESSION_ID
		} else if (perceroObject.getCoachingSession() != null)
		{
			pstmt.setString(2, perceroObject.getCoachingSession().getID());  //SESSION_ID
		} else if (perceroObject.getCorrectiveAction() != null)
		{
			pstmt.setString(2, perceroObject.getCorrectiveAction().getID());  //SESSION_ID
		}

		pstmt.setInt(3, perceroObject.getType());  //Type
		pstmt.setInt(4, perceroObject.getDatarefId()); // DATAREF_ID
		pstmt.setString(5, perceroObject.getDescription()); //Adhoc Coaching session - TYPE

		pstmt.setString(6, perceroObject.getCreatedBy());  //CREATED_BY
		pstmt.setString(7, perceroObject.getUpdatedBy());	//UPDATED_BY

		
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(SessionComment perceroObject, PreparedStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
		
	}
	
	@Override
	protected void setCallableStatmentInsertParams(SessionComment perceroObject, CallableStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	

	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(SessionComment perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getDescription());
pstmt.setDate(2, DateUtils.utilDateToSqlDate(perceroObject.getCreatedOn()));

JdbcHelper.setInt(pstmt,3, perceroObject.getDatarefId());
		if (perceroObject.getAdhocCoachingSession() != null)
		{
			pstmt.setString(4, perceroObject.getAdhocCoachingSession().getID());  //SESSION_ID
		} else if (perceroObject.getCoachingSession() != null)
		{
			pstmt.setString(4, perceroObject.getCoachingSession().getID());  //SESSION_ID
		} else if (perceroObject.getCorrectiveAction() != null)
		{
			pstmt.setString(4, perceroObject.getCorrectiveAction().getID());  //SESSION_ID
		}
JdbcHelper.setInt(pstmt,5, perceroObject.getType());
pstmt.setString(6, perceroObject.getCreatedBy());
pstmt.setString(7, perceroObject.getUpdatedBy());
pstmt.setString(8, perceroObject.getID());

		
	}
	
	
	@Override
	protected void setCallableStatmentUpdateParams(SessionComment perceroObject, CallableStatement pstmt) throws SQLException 
	{
		
		//must be in same order as insert
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	}
	
	

	@Override
	public List<SessionComment> findByExample(SessionComment theQueryObject,
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

boolean useCoachingSessionID = theQueryObject.getCoachingSession() != null && (excludeProperties == null || !excludeProperties.contains("coachingSession"));

if (useCoachingSessionID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"COACHING_SESSION_ID\" =? ";
paramValues.add(theQueryObject.getCoachingSession().getID());
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
		return "{call UPDATE_SESSION_COMMENT(?,?,?,?,?,?,?,?,?,?,?)}";
	}
	@Override
	protected String getInsertCallableStatementSql() {
		return "{call CREATE_SESSION_COMMENT(?,?,?,?,?,?,?,?,?,?,?)}";
	}
	@Override
	protected String getDeleteCallableStatementSql() {
		return "{call Delete_SESSION_COMMENT(?)}";
	}
	
	

public SessionComment createObject(SessionComment perceroObject, String userId)
		throws SyncException {
	if ( !hasCreateAccess(BaseDataObject.toClassIdPair(perceroObject), userId) ) {
		return null;
	}

	long timeStart = System.currentTimeMillis();

	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	String query = "Select EFC_SESSION_COMMENT_SEQ.NEXTVAL from dual";
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

