
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
public class AgentLOBDAO extends SqlDataAccessObject<AgentLOB> implements IDataAccessObject<AgentLOB> {

	static final Logger log = Logger.getLogger(AgentLOBDAO.class);


	public AgentLOBDAO() {
		super();

		DAORegistry.getInstance().registerDataAccessObject(AgentLOB.class.getCanonicalName(), this);
	}


	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
	//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "cms";

	//TODO:For use refactoring, so we set it once
	public static final String SQL_VIEW = "SELECT  \"AGENT_LOB\".\"EMPLOYEE_ID\" || '-' || \"AGENT_LOB\".\"ECP_LOB_ID\"  as \"ID\", \"AGENT_LOB\".\"EMPLOYEE_ID\" as \"AGENT_ID\", \"AGENT_LOB\".\"ECP_LOB_ID\" as \"LOB_ID\" FROM \"MOB_EMP_LOB_VW\" \"AGENT_LOB\" ";
	private String selectFromStatementTableName = " FROM \"PULSE\".\"MOB_EMP_LOB_VW\" \"AGENT_LOB\"";
	private String whereClause = " WHERE \"AGENT_LOB\".\"ID\"=?";
	private String whereInClause = " join table(sys.dbms_debug_vc2coll(?)) SQLLIST on \"AGENT_LOB\".\"ID\"= SQLLIST.column_value";
	private String orderByTableName = " ORDER BY \"AGENT_LOB\".\"ID\"";

	


	@Override
	protected String getConnectionFactoryName() {
		return AgentLOBDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT \"AGENT_LOB\".\"EMPLOYEE_ID\" || '-' || \"AGENT_LOB\".\"ECP_LOB_ID\"  as \"ID\" " + selectFromStatementTableName + whereClause;
	}

	@Override
	protected String getSelectStarSQL() {
		return SQL_VIEW   + whereClause;
	}

	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT \"AGENT_LOB\".\"EMPLOYEE_ID\" || '-' || \"AGENT_LOB\".\"ECP_LOB_ID\"  as \"ID\" " + selectFromStatementTableName +  orderByTableName;
	}

	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT \"AGENT_LOB\".\"EMPLOYEE_ID\" || '-' || \"AGENT_LOB\".\"ECP_LOB_ID\"  as \"ID\" " + selectFromStatementTableName  +  orderByTableName  + " LIMIT ? OFFSET ?";
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
		return "SELECT \"AGENT_LOB\".\"EMPLOYEE_ID\" || '-' || \"AGENT_LOB\".\"ECP_LOB_ID\"  as \"ID\" " + selectFromStatementTableName +  whereInClause;
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		
		return SQL_VIEW + "  \"AGENT_LOB\"." + joinColumnName + "=?";
	}

	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) 
	{
		

		return "SELECT \"AGENT_LOB\".\"EMPLOYEE_ID\" || '-' || \"AGENT_LOB\".\"ECP_LOB_ID\"  as \"ID\" " + selectFromStatementTableName + " WHERE \"AGENT_LOB\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT \"AGENT_LOB\".\"EMPLOYEE_ID\" || '-' || \"AGENT_LOB\".\"ECP_LOB_ID\"  as \"ID\" " + selectFromStatementTableName;
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return SQL_VIEW;
	}

	@Override
	protected String getInsertIntoSQL() {
		return "";//"INSERT INTO AGENT_LOB (ID) VALUES (?)";
	}

	@Override
	protected String getUpdateSet() {
		return "";//"UPDATE AGENT_LOB SET  WHERE ID=?";
	}

	@Override
	protected String getDeleteFromSQL() 
	{
		return "";//"DELETE FROM AGENT_LOB WHERE ID=?";
	}

	@Override
	protected AgentLOB extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {

		
AgentLOB nextResult = null;
    	
		    	
    	if (nextResult == null) {
    		nextResult = new AgentLOB();
    	}


		// ID
		nextResult.setID(rs.getString("ID"));

		if (!shellOnly) 
		{
			String agentID = rs.getString("AGENT_ID");
if (StringUtils.hasText(agentID) && !"null".equalsIgnoreCase(agentID) ){
Agent agent = new Agent();
agent.setID(agentID);
nextResult.setAgent(agent);
}


String lobID = rs.getString("LOB_ID");
if (StringUtils.hasText(lobID) && !"null".equalsIgnoreCase(lobID) ){
LOB lob = new LOB();
lob.setID(lobID);
nextResult.setLOB(lob);
}




		}

		return nextResult;
	}

	@Override
	protected void setPreparedStatmentInsertParams(AgentLOB perceroObject, PreparedStatement pstmt) throws SQLException {



	}

	@Override
	protected void setPreparedStatmentUpdateParams(AgentLOB perceroObject, PreparedStatement pstmt) throws SQLException {



	}

	@Override
	public List<AgentLOB> findByExample(AgentLOB theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
	{



		String sql = getFindByExampleSelectSql(shellOnly);

		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();

		boolean useAgentID = theQueryObject.getAgent() != null && (excludeProperties == null || !excludeProperties.contains("agent"));

if (useAgentID)
{
sql += " WHERE ";
sql += " AGENT_ID=? ";
paramValues.add(theQueryObject.getAgent().getID());
propertyCounter++;
}

boolean useLOBID = theQueryObject.getLOB() != null && (excludeProperties == null || !excludeProperties.contains("lOB"));

if (useLOBID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " LOB_ID=? ";
paramValues.add(theQueryObject.getLOB().getID());
propertyCounter++;
}




		return executeSelectWithParams(sql, paramValues.toArray(), shellOnly);		
	}

	
public AgentLOB createObject(AgentLOB perceroObject, String userId)
		throws SyncException {
	if ( !hasCreateAccess(BaseDataObject.toClassIdPair(perceroObject), userId) ) {
		return null;
	}

	long timeStart = System.currentTimeMillis();

	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	String query = "Select MOB_EMP_LOB_VW_SEQ.NEXTVAL from dual";
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
