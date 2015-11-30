
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
public class CMSEntryDAO extends SqlDataAccessObject<CMSEntry> implements IDataAccessObject<CMSEntry> {

	static final Logger log = Logger.getLogger(CMSEntryDAO.class);


	public CMSEntryDAO() {
		super();

		DAORegistry.getInstance().registerDataAccessObject(CMSEntry.class.getCanonicalName(), this);
	}


	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
	//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "cms";

	//TODO:For use refactoring, so we set it once
	public static final String SQL_VIEW = "SELECT  \"CMS_ENTRY\".\"ID\" as \"ID\", \"CMS_ENTRY\".\"START_TIME\" as \"FROM_TIME\", '' as \"ESTART_PROJECT_NAME\", \"CMS_ENTRY\".\"EVENT_DURATION\" as \"DURATION\", \"CMS_ENTRY\".\"AUXREASON\" as \"CMS_AUX_MODE\", \"CMS_ENTRY\".\"END_TIME\" as \"TO_TIME\", \"CMS_ENTRY\".\"EMPLOYEE_ID\" as \"AGENT_ID\" FROM \"MOB_CMS_DATA_VW\" \"CMS_ENTRY\" ";
	private String selectFromStatementTableName = " FROM \"PULSE\".\"MOB_CMS_DATA_VW\" \"CMS_ENTRY\"";
	private String whereClause = " WHERE \"CMS_ENTRY\".\"ID\"=?";
	private String whereInClause = " join table(sys.dbms_debug_vc2coll(?)) SQLLIST on \"CMS_ENTRY\".\"ID\"= SQLLIST.column_value";
	private String orderByTableName = " ORDER BY \"CMS_ENTRY\".\"ID\"";

	


	@Override
	protected String getConnectionFactoryName() {
		return CMSEntryDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT \"CMS_ENTRY\".\"ID\" as \"ID\" " + selectFromStatementTableName + whereClause;
	}

	@Override
	protected String getSelectStarSQL() {
		return SQL_VIEW   + whereClause;
	}

	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT \"CMS_ENTRY\".\"ID\" as \"ID\" " + selectFromStatementTableName +  orderByTableName;
	}

	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT \"CMS_ENTRY\".\"ID\" as \"ID\" " + selectFromStatementTableName  +  orderByTableName  + " LIMIT ? OFFSET ?";
	}

	@Override
	protected String getSelectAllStarSQL() {
		return SQL_VIEW  +  orderByTableName;
	}

	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return SQL_VIEW +  orderByTableName +" LIMIT ? OFFSET ?";
	}

	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) " + selectFromStatementTableName;
	}

	@Override
	protected String getSelectInStarSQL() {
		return SQL_VIEW + whereInClause;
	}

	@Override
	protected String getSelectInShellOnlySQL() 
	{
		return "SELECT \"CMS_ENTRY\".\"ID\" as \"ID\" " + selectFromStatementTableName +  whereInClause;
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		
		return SQL_VIEW + "  \"CMS_ENTRY\"." + joinColumnName + "=?";
	}

	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) 
	{
		

		return "SELECT \"CMS_ENTRY\".\"ID\" as \"ID\" " + selectFromStatementTableName + " WHERE \"CMS_ENTRY\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT \"CMS_ENTRY\".\"ID\" as \"ID\" " + selectFromStatementTableName;
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return SQL_VIEW;
	}

	@Override
	protected String getInsertIntoSQL() {
		return "";//"INSERT INTO CMS_ENTRY (ID) VALUES (?)";
	}

	@Override
	protected String getUpdateSet() {
		return "";//"UPDATE CMS_ENTRY SET  WHERE ID=?";
	}

	@Override
	protected String getDeleteFromSQL() 
	{
		return "";//"DELETE FROM CMS_ENTRY WHERE ID=?";
	}

	@Override
	protected CMSEntry extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {

		
CMSEntry nextResult = null;
    	
		    	
    	if (nextResult == null) {
    		nextResult = new CMSEntry();
    	}


		// ID
		nextResult.setID(rs.getString("ID"));

		if (!shellOnly) 
		{
			nextResult.setCMSAuxMode(rs.getString("CMS_AUX_MODE"));


nextResult.setEStartProjectName(rs.getString("ESTART_PROJECT_NAME"));


nextResult.setFromTime(DateUtils.utilDateFromSqlTimestamp(rs.getTimestamp("FROM_TIME")));


nextResult.setToTime(DateUtils.utilDateFromSqlTimestamp(rs.getTimestamp("TO_TIME")));


nextResult.setDuration(rs.getDouble("DURATION"));


String agentID = rs.getString("AGENT_ID");
if (StringUtils.hasText(agentID) && !"null".equalsIgnoreCase(agentID) ){
Agent agent = new Agent();
agent.setID(agentID);
nextResult.setAgent(agent);
}




		}

		return nextResult;
	}

	@Override
	protected void setPreparedStatmentInsertParams(CMSEntry perceroObject, PreparedStatement pstmt) throws SQLException {



	}

	@Override
	protected void setPreparedStatmentUpdateParams(CMSEntry perceroObject, PreparedStatement pstmt) throws SQLException {



	}

	@Override
	public List<CMSEntry> findByExample(CMSEntry theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
	{



		String sql = getFindByExampleSelectSql(shellOnly);

		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();

		boolean useCMSAuxMode = StringUtils.hasText(theQueryObject.getCMSAuxMode()) && (excludeProperties == null || !excludeProperties.contains("cMSAuxMode"));

if (useCMSAuxMode)
{
sql += " WHERE ";
sql += " CMS_AUX_MODE=? ";
paramValues.add(theQueryObject.getCMSAuxMode());
propertyCounter++;
}

boolean useEStartProjectName = StringUtils.hasText(theQueryObject.getEStartProjectName()) && (excludeProperties == null || !excludeProperties.contains("eStartProjectName"));

if (useEStartProjectName)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " ESTART_PROJECT_NAME=? ";
paramValues.add(theQueryObject.getEStartProjectName());
propertyCounter++;
}

boolean useFromTime = theQueryObject.getFromTime() != null && (excludeProperties == null || !excludeProperties.contains("fromTime"));

if (useFromTime)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " FROM_TIME=? ";
paramValues.add(theQueryObject.getFromTime());
propertyCounter++;
}

boolean useToTime = theQueryObject.getToTime() != null && (excludeProperties == null || !excludeProperties.contains("toTime"));

if (useToTime)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " TO_TIME=? ";
paramValues.add(theQueryObject.getToTime());
propertyCounter++;
}

boolean useDuration = theQueryObject.getDuration() != null && (excludeProperties == null || !excludeProperties.contains("duration"));

if (useDuration)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " DURATION=? ";
paramValues.add(theQueryObject.getDuration());
propertyCounter++;
}

boolean useAgentID = theQueryObject.getAgent() != null && (excludeProperties == null || !excludeProperties.contains("agent"));

if (useAgentID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " AGENT_ID=? ";
paramValues.add(theQueryObject.getAgent().getID());
propertyCounter++;
}




		return executeSelectWithParams(sql, paramValues.toArray(), shellOnly);		
	}

	
public CMSEntry createObject(CMSEntry perceroObject, String userId)
		throws SyncException {
	if ( !hasCreateAccess(BaseDataObject.toClassIdPair(perceroObject), userId) ) {
		return null;
	}

	long timeStart = System.currentTimeMillis();

	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	String query = "Select MOB_CMS_DATA_VW_SEQ.NEXTVAL from dual";
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
