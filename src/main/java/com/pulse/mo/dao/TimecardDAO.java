

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
public class TimecardDAO extends SqlDataAccessObject<Timecard> implements IDataAccessObject<Timecard> {

	static final Logger log = Logger.getLogger(TimecardDAO.class);


	public TimecardDAO() {
		super();

		DAORegistry.getInstance().registerDataAccessObject(Timecard.class.getCanonicalName(), this);
	}


	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
	//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "estart";

	//TODO:For use refactoring, so we set it once
	public static final String SQL_VIEW = "SELECT  \"TIMECARD\".\"ID\" as \"ID\", \"TIMECARD\".\"ASSUMED_OFF\" as \"ASSUMED_OFF\", \"TIMECARD\".\"PDATE\" as \"DATE\", \"TIMECARD\".\"IS_HOLIDAY\" as \"IS_HOLIDAY\", \"TIMECARD\".\"ON_TIME\" as \"START_DATE\", \"TIMECARD\".\"LOCK_LEVEL\" as \"LOCK_LEVEL\", \"TIMECARD\".\"OFF_TIME\" as \"END_DATE\", \"TIMECARD\".\"APPROVED\" as \"APPROVED\", \"TIMECARD\".\"SH_RULE\" as \"LOCAL_TIME_CODE\", 'USE TIMECARD.currentStatus' as \"TIMECARD_STATE\", \"TIMECARD\".\"PAYROLL\" as \"AGENT_ID\" FROM \"AGENT_TIME_VW\" \"TIMECARD\" ";
	private String selectFromStatementTableName = " FROM \"CONVERGYS\".\"AGENT_TIME_VW\" \"TIMECARD\"";
	private String whereClause = " WHERE \"TIMECARD\".\"ID\"=? AND \"TIMECARD\".\"PDATE\" > (sysdate - 14) ";
	private String whereInClause = " join table(sys.dbms_debug_vc2coll(?)) SQLLIST on \"TIMECARD\".\"ID\"= SQLLIST.column_value WHERE \"TIMECARD\".\"PDATE\" > (sysdate - 14) ";
	private String orderByTableName = " ORDER BY \"TIMECARD\".\"ID\"";

	


	@Override
	protected String getConnectionFactoryName() {
		return TimecardDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT \"TIMECARD\".\"ID\" as \"ID\" " + selectFromStatementTableName + whereClause;
	}

	@Override
	protected String getSelectStarSQL() {
		return SQL_VIEW   + whereClause;
	}

	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT \"TIMECARD\".\"ID\" as \"ID\" " + selectFromStatementTableName + " WHERE \"TIMECARD\".\"PDATE\" > (sysdate - 14) " + orderByTableName;
	}

	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT \"TIMECARD\".\"ID\" as \"ID\" " + selectFromStatementTableName  + " WHERE \"TIMECARD\".\"PDATE\" > (sysdate - 14) " + orderByTableName  + " LIMIT ? OFFSET ?";
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
		return "SELECT \"TIMECARD\".\"ID\" as \"ID\" " + selectFromStatementTableName +  whereInClause;
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		return "select * from (" + SQL_VIEW + " WHERE \"TIMECARD\"." + joinColumnName + "=? order by \"PDATE\" desc) where ROWNUM < 15";

//		return SQL_VIEW + " WHERE \"TIMECARD\".\"PDATE\" > (sysdate - 14) AND \"TIMECARD\"." + joinColumnName + "=?";
	}

	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) 
	{
		
		return "select * from (SELECT \"TIMECARD\".\"ID\" as \"ID\" " + selectFromStatementTableName + " WHERE \"TIMECARD\"." + joinColumnName + "=? order by \"PDATE\" desc) where ROWNUM < 15";

//		return "SELECT \"TIMECARD\".\"ID\" as \"ID\" " + selectFromStatementTableName + " WHERE \"TIMECARD\".\"PDATE\" > (sysdate - 14) AND \"TIMECARD\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT \"TIMECARD\".\"ID\" as \"ID\" " + selectFromStatementTableName;
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return SQL_VIEW;
	}

	@Override
	protected String getInsertIntoSQL() {
		return "";//"INSERT INTO TIMECARD (ID) VALUES (?)";
	}

	@Override
	protected String getUpdateSet() {
		return "";//"UPDATE TIMECARD SET  WHERE ID=?";
	}

	@Override
	protected String getDeleteFromSQL() 
	{
		return "";//"DELETE FROM TIMECARD WHERE ID=?";
	}

	@Override
	protected Timecard extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {

		

Timecard nextResult = null;
    	
		    	
    	if (nextResult == null) {
    		nextResult = new Timecard();
    	}


		// ID
		nextResult.setID(rs.getString("ID"));

		if (!shellOnly) 
		{
			nextResult.setDate(DateUtils.utilDateFromSqlTimestamp(rs.getTimestamp("DATE")));


nextResult.setEndDate(DateUtils.utilDateFromSqlTimestamp(rs.getTimestamp("END_DATE")));


nextResult.setStartDate(DateUtils.utilDateFromSqlTimestamp(rs.getTimestamp("START_DATE")));


nextResult.setApproved(rs.getString("APPROVED"));


nextResult.setAssumedOff(rs.getString("ASSUMED_OFF"));


nextResult.setIsHoliday(rs.getString("IS_HOLIDAY"));


nextResult.setLocalTimeCode(rs.getString("LOCAL_TIME_CODE"));


nextResult.setLockLevel(rs.getString("LOCK_LEVEL"));


nextResult.setTimecardState(rs.getString("TIMECARD_STATE"));


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
	protected void setPreparedStatmentInsertParams(Timecard perceroObject, PreparedStatement pstmt) throws SQLException {



	}

	@Override
	protected void setPreparedStatmentUpdateParams(Timecard perceroObject, PreparedStatement pstmt) throws SQLException {



	}

	@Override
	public List<Timecard> findByExample(Timecard theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
	{



		String sql = getFindByExampleSelectSql(shellOnly);

		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();

		boolean useDate = theQueryObject.getDate() != null && (excludeProperties == null || !excludeProperties.contains("date"));

if (useDate)
{
sql += " WHERE ";
sql += " DATE=? ";
paramValues.add(theQueryObject.getDate());
propertyCounter++;
}

boolean useEndDate = theQueryObject.getEndDate() != null && (excludeProperties == null || !excludeProperties.contains("endDate"));

if (useEndDate)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
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

boolean useApproved = StringUtils.hasText(theQueryObject.getApproved()) && (excludeProperties == null || !excludeProperties.contains("approved"));

if (useApproved)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " APPROVED=? ";
paramValues.add(theQueryObject.getApproved());
propertyCounter++;
}

boolean useAssumedOff = StringUtils.hasText(theQueryObject.getAssumedOff()) && (excludeProperties == null || !excludeProperties.contains("assumedOff"));

if (useAssumedOff)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " ASSUMED_OFF=? ";
paramValues.add(theQueryObject.getAssumedOff());
propertyCounter++;
}

boolean useIsHoliday = StringUtils.hasText(theQueryObject.getIsHoliday()) && (excludeProperties == null || !excludeProperties.contains("isHoliday"));

if (useIsHoliday)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " IS_HOLIDAY=? ";
paramValues.add(theQueryObject.getIsHoliday());
propertyCounter++;
}

boolean useLocalTimeCode = StringUtils.hasText(theQueryObject.getLocalTimeCode()) && (excludeProperties == null || !excludeProperties.contains("localTimeCode"));

if (useLocalTimeCode)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " LOCAL_TIME_CODE=? ";
paramValues.add(theQueryObject.getLocalTimeCode());
propertyCounter++;
}

boolean useLockLevel = StringUtils.hasText(theQueryObject.getLockLevel()) && (excludeProperties == null || !excludeProperties.contains("lockLevel"));

if (useLockLevel)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " LOCK_LEVEL=? ";
paramValues.add(theQueryObject.getLockLevel());
propertyCounter++;
}

boolean useTimecardState = StringUtils.hasText(theQueryObject.getTimecardState()) && (excludeProperties == null || !excludeProperties.contains("timecardState"));

if (useTimecardState)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " TIMECARD_STATE=? ";
paramValues.add(theQueryObject.getTimecardState());
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

	

public Timecard createObject(Timecard perceroObject, String userId)
		throws SyncException {
	if ( !hasCreateAccess(BaseDataObject.toClassIdPair(perceroObject), userId) ) {
		return null;
	}

	long timeStart = System.currentTimeMillis();

	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	String query = "Select AGENT_TIME_VW_SEQ.NEXTVAL from dual";
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

