
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
public class SupervisorDAO extends SqlDataAccessObject<Supervisor> implements IDataAccessObject<Supervisor> {

	static final Logger log = Logger.getLogger(SupervisorDAO.class);

	
	public SupervisorDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(Supervisor.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	
	public static final String SHELL_ONLY_SELECT = "\"SUPERVISOR\".\"ID\"";
	public static final String SQL_VIEW = ",\"SUPERVISOR\".\"EMAIL_ADDRESS\",\"SUPERVISOR\".\"FIRST_NAME\",\"SUPERVISOR\".\"LAST_NAME\",\"SUPERVISOR\".\"FULL_NAME\",\"SUPERVISOR\".\"PHOTO_URI\",\"SUPERVISOR\".\"MANAGER_SUPERVISOR_ID\"";
	private String selectFromStatementTableName = " FROM \"SUPERVISOR\" \"SUPERVISOR\"";
	private String whereClause = "  WHERE \"SUPERVISOR\".\"ID\"=?";
	private String whereInClause = "  join table(sys.dbms_debug_vc2coll(?)) SQLLIST on \"SUPERVISOR\".\"ID\"= SQLLIST.column_value";
	private String orderByTableName = "  ORDER BY \"SUPERVISOR\".\"ID\"";
	
	

	
	@Override
	protected String getConnectionFactoryName() {
		return SupervisorDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT " + SHELL_ONLY_SELECT +  " " + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT \"SUPERVISOR\".\"ID\"" + SQL_VIEW  + selectFromStatementTableName + whereClause;
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
		return "SELECT \"SUPERVISOR\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName  + orderByTableName;
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT \"SUPERVISOR\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + orderByTableName + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() 
	{
		return "SELECT COUNT(ID) " + selectFromStatementTableName;
	}
	
	@Override
	protected String getSelectInStarSQL() 
	{
		return "SELECT \"SUPERVISOR\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + whereInClause;
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName + whereInClause;
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		
		return "SELECT \"SUPERVISOR\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + " WHERE \"SUPERVISOR\"." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) 
	{
		
		return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName + " WHERE \"SUPERVISOR\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName;
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT \"SUPERVISOR\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName;
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO TBL_SUPERVISOR (\"ID\",\"EMAIL_ADDRESS\",\"FIRST_NAME\",\"LAST_NAME\",\"FULL_NAME\",\"PHOTO_URI\",\"MANAGER_SUPERVISOR_ID\") VALUES (?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE TBL_SUPERVISOR SET \"EMAIL_ADDRESS\"=?,\"FIRST_NAME\"=?,\"LAST_NAME\"=?,\"FULL_NAME\"=?,\"PHOTO_URI\"=?,\"MANAGER_SUPERVISOR_ID\"=? WHERE \"ID\"=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM TBL_SUPERVISOR WHERE \"ID\"=?";
	}
	
	@Override
	protected Supervisor extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	
		
Supervisor nextResult = null;
    	
		    	
    	if (nextResult == null) {
    		nextResult = new Supervisor();
    	}

		
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setEmailAddress(rs.getString("EMAIL_ADDRESS"));


nextResult.setFirstName(rs.getString("FIRST_NAME"));


nextResult.setLastName(rs.getString("LAST_NAME"));


nextResult.setFullName(rs.getString("FULL_NAME"));


nextResult.setPhotoUri(rs.getString("PHOTO_URI"));


String managersupervisorID = rs.getString("MANAGER_SUPERVISOR_ID");
if (StringUtils.hasText(managersupervisorID) && !"null".equalsIgnoreCase(managersupervisorID) ){
Supervisor managersupervisor = new Supervisor();
managersupervisor.setID(managersupervisorID);
nextResult.setManagerSupervisor(managersupervisor);
}



			
    	}
		
		
    	return nextResult;
	}
	
	protected void setBaseStatmentInsertParams(Supervisor perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getEmailAddress());
pstmt.setString(3, perceroObject.getFirstName());
pstmt.setString(4, perceroObject.getLastName());
pstmt.setString(5, perceroObject.getFullName());
pstmt.setString(6, perceroObject.getPhotoUri());

if (perceroObject.getManagerSupervisor() == null)
{
pstmt.setString(7, null);
}
else
{
		pstmt.setString(7, perceroObject.getManagerSupervisor().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(Supervisor perceroObject, PreparedStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
		
	}
	
	@Override
	protected void setCallableStatmentInsertParams(Supervisor perceroObject, CallableStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	

	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(Supervisor perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getEmailAddress());
pstmt.setString(2, perceroObject.getFirstName());
pstmt.setString(3, perceroObject.getLastName());
pstmt.setString(4, perceroObject.getFullName());
pstmt.setString(5, perceroObject.getPhotoUri());

if (perceroObject.getManagerSupervisor() == null)
{
pstmt.setString(6, null);
}
else
{
		pstmt.setString(6, perceroObject.getManagerSupervisor().getID());
}

pstmt.setString(7, perceroObject.getID());

		
	}
	
	
	@Override
	protected void setCallableStatmentUpdateParams(Supervisor perceroObject, CallableStatement pstmt) throws SQLException 
	{
		
		//must be in same order as insert
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	}
	
	

	@Override
	public List<Supervisor> findByExample(Supervisor theQueryObject,
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

boolean useManagerSupervisorID = theQueryObject.getManagerSupervisor() != null && (excludeProperties == null || !excludeProperties.contains("managerSupervisor"));

if (useManagerSupervisorID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"MANAGER_SUPERVISOR_ID\" =? ";
paramValues.add(theQueryObject.getManagerSupervisor().getID());
propertyCounter++;
}



		if (propertyCounter == 0) {
			throw new SyncException(SyncException.METHOD_UNSUPPORTED, SyncException.METHOD_UNSUPPORTED_CODE);
		}
		
		return executeSelectWithParams(sql, paramValues.toArray(), shellOnly);		
	}
	
	@Override
	protected String getUpdateCallableStatementSql() {
		return "{call UPDATE_SUPERVISOR(?,?,?,?,?,?,?)}";
	}
	@Override
	protected String getInsertCallableStatementSql() {
		return "{call CREATE_SUPERVISOR(?,?,?,?,?,?,?)}";
	}
	@Override
	protected String getDeleteCallableStatementSql() {
		return "{call Delete_SUPERVISOR(?)}";
	}
	
	
public Supervisor createObject(Supervisor perceroObject, String userId)
		throws SyncException {
	if ( !hasCreateAccess(BaseDataObject.toClassIdPair(perceroObject), userId) ) {
		return null;
	}

	long timeStart = System.currentTimeMillis();

	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	String query = "Select SUPERVISOR_SEQ.NEXTVAL from dual";
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
