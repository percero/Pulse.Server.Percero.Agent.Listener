

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
public class AgentDAO extends SqlDataAccessObject<Agent> implements IDataAccessObject<Agent> {

	static final Logger log = Logger.getLogger(AgentDAO.class);

	
	public AgentDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(Agent.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	
	public static final String SHELL_ONLY_SELECT = "\"AGENT\".\"ID\"";
	public static final String SQL_VIEW = ",\"AGENT\".\"EMAIL_ADDRESS\",\"AGENT\".\"LAST_NAME\",\"AGENT\".\"EMPLOYEE_ID\",\"AGENT\".\"FIRST_NAME\",\"AGENT\".\"FULL_NAME\",\"AGENT\".\"PHOTO_URI\",\"AGENT\".\"TEAM_LEADER_ID\", \"AGENT\".\"REGION_ID\"";
	private String selectFromStatementTableName = " FROM \"AGENT\" \"AGENT\"";
	private String whereClause = "  WHERE \"AGENT\".\"ID\"=?";
	private String whereInClause = "  join table(sys.dbms_debug_vc2coll(?)) SQLLIST on \"AGENT\".\"ID\"= SQLLIST.column_value";
	private String orderByTableName = "  ORDER BY \"AGENT\".\"ID\"";
	
	

	
	@Override
	protected String getConnectionFactoryName() {
		return AgentDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT " + SHELL_ONLY_SELECT +  " " + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT \"AGENT\".\"ID\"" + SQL_VIEW  + selectFromStatementTableName + whereClause;
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
		return "SELECT \"AGENT\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName  + orderByTableName;
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT \"AGENT\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + orderByTableName + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() 
	{
		return "SELECT COUNT(ID) " + selectFromStatementTableName;
	}
	
	@Override
	protected String getSelectInStarSQL() 
	{
		return "SELECT \"AGENT\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + whereInClause;
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName + whereInClause;
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		
		return "SELECT \"AGENT\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + " WHERE \"AGENT\"." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) 
	{
		
		return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName + " WHERE \"AGENT\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName;
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT \"AGENT\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName;
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO TBL_AGENT (\"ID\",\"EMAIL_ADDRESS\",\"LAST_NAME\",\"EMPLOYEE_ID\",\"FIRST_NAME\",\"FULL_NAME\",\"PHOTO_URI\",\"TEAM_LEADER_ID\") VALUES (?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE TBL_AGENT SET \"EMAIL_ADDRESS\"=?,\"LAST_NAME\"=?,\"EMPLOYEE_ID\"=?,\"FIRST_NAME\"=?,\"FULL_NAME\"=?,\"PHOTO_URI\"=?,\"TEAM_LEADER_ID\"=? WHERE \"ID\"=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM TBL_AGENT WHERE \"ID\"=?";
	}
	
	@Override
	protected Agent extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	
		

Agent nextResult = null;
    	
		    	
    	if (nextResult == null) {
    		nextResult = new Agent();
    	}

		
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setEmailAddress(rs.getString("EMAIL_ADDRESS"));
			nextResult.setLastName(rs.getString("LAST_NAME"));
			nextResult.setEmployeeId(rs.getString("EMPLOYEE_ID"));
			nextResult.setFirstName(rs.getString("FIRST_NAME"));
			nextResult.setFullName(rs.getString("FULL_NAME"));
			nextResult.setPhotoUri(rs.getString("PHOTO_URI"));

			String teamleaderID = rs.getString("TEAM_LEADER_ID");
			if (StringUtils.hasText(teamleaderID) && !"null".equalsIgnoreCase(teamleaderID) ){
			TeamLeader teamleader = new TeamLeader();
			teamleader.setID(teamleaderID);
			nextResult.setTeamLeader(teamleader);
			}

			String regionID = rs.getString("REGION_ID");
			if (StringUtils.hasText(regionID) && !"null".equalsIgnoreCase(regionID) ){
				Region region = new Region();
				region.setID(regionID);
				nextResult.setRegion(region);
			}

    	}
		
		
    	return nextResult;
	}
	
	protected void setBaseStatmentInsertParams(Agent perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
		pstmt.setString(2, perceroObject.getEmailAddress());
		pstmt.setString(3, perceroObject.getLastName());
		pstmt.setString(4, perceroObject.getEmployeeId());
		pstmt.setString(5, perceroObject.getFirstName());
		pstmt.setString(6, perceroObject.getFullName());
		pstmt.setString(7, perceroObject.getPhotoUri());

		if (perceroObject.getTeamLeader() == null)
		{
		pstmt.setString(8, null);
		}
		else
		{
				pstmt.setString(8, perceroObject.getTeamLeader().getID());
		}

	}
	
	@Override
	protected void setPreparedStatmentInsertParams(Agent perceroObject, PreparedStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
		
	}
	
	@Override
	protected void setCallableStatmentInsertParams(Agent perceroObject, CallableStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	

	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(Agent perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getEmailAddress());
		pstmt.setString(2, perceroObject.getLastName());
		pstmt.setString(3, perceroObject.getEmployeeId());
		pstmt.setString(4, perceroObject.getFirstName());
		pstmt.setString(5, perceroObject.getFullName());
		pstmt.setString(6, perceroObject.getPhotoUri());

		if (perceroObject.getTeamLeader() == null)
		{
		pstmt.setString(7, null);
		}
		else
		{
				pstmt.setString(7, perceroObject.getTeamLeader().getID());
		}

		pstmt.setString(8, perceroObject.getID());
		
	}
	
	
	@Override
	protected void setCallableStatmentUpdateParams(Agent perceroObject, CallableStatement pstmt) throws SQLException 
	{
		
		//must be in same order as insert
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	}
	
	

	@Override
	public List<Agent> findByExample(Agent theQueryObject,
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

			boolean useRegionId = theQueryObject.getRegion() != null && (excludeProperties == null || !excludeProperties.contains("region"));

			if (useRegionId)
			{
				if (propertyCounter > 0)
				{
					sql += " AND ";
				}
				else
				{
					sql += " WHERE ";
				}
				sql += " \"REGION_ID\" =? ";
				paramValues.add(theQueryObject.getRegion().getID());
				propertyCounter++;
			}

boolean useTeamLeaderID = theQueryObject.getTeamLeader() != null && (excludeProperties == null || !excludeProperties.contains("teamLeader"));

if (useTeamLeaderID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"TEAM_LEADER_ID\" =? ";
paramValues.add(theQueryObject.getTeamLeader().getID());
propertyCounter++;
}



		if (propertyCounter == 0) {
			throw new SyncException(SyncException.METHOD_UNSUPPORTED, SyncException.METHOD_UNSUPPORTED_CODE);
		}
		
		return executeSelectWithParams(sql, paramValues.toArray(), shellOnly);		
	}
	
	@Override
	protected String getUpdateCallableStatementSql() {
		return "{call UPDATE_AGENT(?,?,?,?,?,?,?,?)}";
	}
	@Override
	protected String getInsertCallableStatementSql() {
		return "{call CREATE_AGENT(?,?,?,?,?,?,?,?)}";
	}
	@Override
	protected String getDeleteCallableStatementSql() {
		return "{call Delete_AGENT(?)}";
	}
	
	

public Agent createObject(Agent perceroObject, String userId)
		throws SyncException {
	if ( !hasCreateAccess(BaseDataObject.toClassIdPair(perceroObject), userId) ) {
		return null;
	}

	long timeStart = System.currentTimeMillis();

	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	String query = "Select AGENT_SEQ.NEXTVAL from dual";
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

