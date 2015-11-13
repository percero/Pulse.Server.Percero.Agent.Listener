

package com.pulse.mo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.percero.agents.sync.dao.DAORegistry;
import com.percero.agents.sync.dao.IDataAccessObject;
import com.percero.agents.sync.exceptions.SyncDataException;
import com.percero.agents.sync.exceptions.SyncException;
import com.percero.agents.sync.vo.BaseDataObject;
import com.percero.util.DateUtils;
import com.pulse.dataprovider.IConnectionFactory;
import com.pulse.mo.Agent;
import com.pulse.mo.Schedule;

@Component
public class ScheduleDAO extends SqlDataAccessObject<Schedule> implements IDataAccessObject<Schedule> {

	static final Logger log = Logger.getLogger(ScheduleDAO.class);


	public ScheduleDAO() {
		super();

		DAORegistry.getInstance().registerDataAccessObject(Schedule.class.getCanonicalName(), this);
	}


	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
	//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "estart";

	//TODO:For use refactoring, so we set it once
	public static final String SQL_VIEW = "SELECT  \"SCHEDULE\".\"ID\" as \"ID\", \"SCHEDULE\".\"START_TIME\" as \"SOURCE_START_TIME\", \"SCHEDULE\".\"END_DATE\" as \"END_DATE\", \"SCHEDULE\".\"SHIFT\" as \"SHIFT\", \"SCHEDULE\".\"END_TIME\" as \"SOURCE_END_TIME\", \"SCHEDULE\".\"START_DATE\" as \"START_DATE\", \"SCHEDULE\".\"PAYROLL\" as \"AGENT_ID\" FROM \"SCHEDULE_VW\" \"SCHEDULE\" ";
	private String selectFromStatementTableName = " FROM \"CONVERGYS\".\"SCHEDULE_VW\" \"SCHEDULE\"";
	private String whereClause = " WHERE \"SCHEDULE\".\"ID\"=? AND  \"SCHEDULE\".\"START_DATE\" > (sysdate - 14) ";
	private String whereInClause = " join table(sys.dbms_debug_vc2coll(?)) SQLLIST on \"SCHEDULE\".\"ID\"= SQLLIST.column_value WHERE \"SCHEDULE\".\"START_DATE\" > (sysdate - 14) ";
	private String orderByTableName = " ORDER BY \"SCHEDULE\".\"ID\"";

	


	@Override
	protected String getConnectionFactoryName() {
		return ScheduleDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT \"SCHEDULE\".\"ID\" as \"ID\" " + selectFromStatementTableName + whereClause;
	}

	@Override
	protected String getSelectStarSQL() {
		return SQL_VIEW   + whereClause;
	}

	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT \"SCHEDULE\".\"ID\" as \"ID\" " + selectFromStatementTableName + " WHERE \"SCHEDULE\".\"START_DATE\" > (sysdate - 14) " + orderByTableName;
	}

	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT \"SCHEDULE\".\"ID\" as \"ID\" " + selectFromStatementTableName  + " WHERE \"SCHEDULE\".\"START_DATE\" > (sysdate - 14) " + orderByTableName  + " LIMIT ? OFFSET ?";
	}

	@Override
	protected String getSelectAllStarSQL() {
		return SQL_VIEW  + " WHERE \"SCHEDULE\".\"START_DATE\" > (sysdate - 14) " + orderByTableName;
	}

	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return SQL_VIEW + " WHERE \"SCHEDULE\".\"START_DATE\" > (sysdate - 14) " + orderByTableName +" LIMIT ? OFFSET ?";
	}

	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) " + selectFromStatementTableName + " WHERE \"SCHEDULE\".\"START_DATE\" > (sysdate - 14)";
	}

	@Override
	protected String getSelectInStarSQL() {
		return SQL_VIEW + whereInClause;
	}

	@Override
	protected String getSelectInShellOnlySQL() 
	{
		return "SELECT \"SCHEDULE\".\"ID\" as \"ID\" " + selectFromStatementTableName +  whereInClause;
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		if ("\"PAYROLL\"".equalsIgnoreCase(joinColumnName)) {
			return SQL_VIEW + " WHERE \"SCHEDULE\".\"PAYROLL\" =? and \"SCHEDULE\".\"START_DATE\" > sysdate -30 and \"SCHEDULE\".\"END_DATE\" > sysdate -30 and ROWNUM < 15 order by \"SCHEDULE\".\"START_DATE\" desc";
		}
		return "SELECT * FROM (" + SQL_VIEW + " WHERE \"SCHEDULE\"." + joinColumnName + "=? ORDER BY \"SCHEDULE\".\"START_DATE\" DESC) WHERE ROWNUM < 15";
	}

	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) 
	{
		if ("\"PAYROLL\"".equalsIgnoreCase(joinColumnName)) {
			return "SELECT \"SCHEDULE\".\"ID\" as \"ID\" " + selectFromStatementTableName + " WHERE \"SCHEDULE\".\"PAYROLL\" =? and \"SCHEDULE\".\"START_DATE\" > sysdate -30 and \"SCHEDULE\".\"END_DATE\" > sysdate -30 and ROWNUM < 15 order by\"SCHEDULE\".\"START_DATE\" desc";
		}
		return "SELECT * FROM (SELECT \"SCHEDULE\".\"ID\" as \"ID\" " + selectFromStatementTableName + " WHERE \"SCHEDULE\"." + joinColumnName + "=? ORDER BY \"SCHEDULE\".\"START_DATE\" DESC) WHERE ROWNUM < 15";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT \"SCHEDULE\".\"ID\" as \"ID\" " + selectFromStatementTableName;
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return SQL_VIEW;
	}

	@Override
	protected String getInsertIntoSQL() {
		return "";//"INSERT INTO SCHEDULE (ID) VALUES (?)";
	}

	@Override
	protected String getUpdateSet() {
		return "";//"UPDATE SCHEDULE SET  WHERE ID=?";
	}

	@Override
	protected String getDeleteFromSQL() 
	{
		return "";//"DELETE FROM SCHEDULE WHERE ID=?";
	}

	@Override
	protected Schedule extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {

		

Schedule nextResult = null;
    	
		    	
    	if (nextResult == null) {
    		nextResult = new Schedule();
    	}


		// ID
		nextResult.setID(rs.getString("ID"));

		if (!shellOnly) 
		{
			nextResult.setEndDate(DateUtils.utilDateFromSqlTimestamp(rs.getTimestamp("END_DATE")));


nextResult.setStartDate(DateUtils.utilDateFromSqlTimestamp(rs.getTimestamp("START_DATE")));


nextResult.setSourceEndTime(DateUtils.utilDateFromSqlTimestamp(rs.getTimestamp("SOURCE_END_TIME")));


nextResult.setSourceStartTime(DateUtils.utilDateFromSqlTimestamp(rs.getTimestamp("SOURCE_START_TIME")));


nextResult.setShift(rs.getInt("SHIFT"));


String agentID = rs.getString("AGENT_ID");
if (StringUtils.hasText(agentID)) {
Agent agent = new Agent();
agent.setID(agentID);
nextResult.setAgent(agent);
}




		}

		return nextResult;
	}

	@Override
	protected void setPreparedStatmentInsertParams(Schedule perceroObject, PreparedStatement pstmt) throws SQLException {



	}

	@Override
	protected void setPreparedStatmentUpdateParams(Schedule perceroObject, PreparedStatement pstmt) throws SQLException {



	}

	@Override
	public List<Schedule> findByExample(Schedule theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
	{



		String sql = getFindByExampleSelectSql(shellOnly);

		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();

		boolean useEndDate = theQueryObject.getEndDate() != null && (excludeProperties == null || !excludeProperties.contains("endDate"));

if (useEndDate)
{
sql += " WHERE ";
sql += " END_DATE=? ";
paramValues.add(theQueryObject.getEndDate());
propertyCounter++;
}

boolean useStartDate = theQueryObject.getStartDate() != null && (excludeProperties == null || !excludeProperties.contains("startDate"));

if (useStartDate)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " START_DATE=? ";
paramValues.add(theQueryObject.getStartDate());
propertyCounter++;
}

boolean useSourceEndTime = theQueryObject.getSourceEndTime() != null && (excludeProperties == null || !excludeProperties.contains("sourceEndTime"));

if (useSourceEndTime)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " SOURCE_END_TIME=? ";
paramValues.add(theQueryObject.getSourceEndTime());
propertyCounter++;
}

boolean useSourceStartTime = theQueryObject.getSourceStartTime() != null && (excludeProperties == null || !excludeProperties.contains("sourceStartTime"));

if (useSourceStartTime)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " SOURCE_START_TIME=? ";
paramValues.add(theQueryObject.getSourceStartTime());
propertyCounter++;
}

boolean useShift = theQueryObject.getShift() != null && (excludeProperties == null || !excludeProperties.contains("shift"));

if (useShift)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " SHIFT=? ";
paramValues.add(theQueryObject.getShift());
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

	

public Schedule createObject(Schedule perceroObject, String userId)
		throws SyncException {
	if ( !hasCreateAccess(BaseDataObject.toClassIdPair(perceroObject), userId) ) {
		return null;
	}

	long timeStart = System.currentTimeMillis();

	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	String query = "Select SCHEDULE_VW_SEQ.NEXTVAL from dual";
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

