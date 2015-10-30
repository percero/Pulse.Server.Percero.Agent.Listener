
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
public class ScheduleEntryDAO extends SqlDataAccessObject<ScheduleEntry> implements IDataAccessObject<ScheduleEntry> {

	static final Logger log = Logger.getLogger(ScheduleEntryDAO.class);


	public ScheduleEntryDAO() {
		super();

		DAORegistry.getInstance().registerDataAccessObject(ScheduleEntry.class.getCanonicalName(), this);
	}


	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
	//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "estart";

	//TODO:For use refactoring, so we set it once
	public static final String SQL_VIEW = "SELECT  \"SCHEDULE_ENTRY\".\"ID\" as \"ID\", \"SCHEDULE_ENTRY\".\"COST_POS_INDEX\" as \"COST_POS_INDEX\", '' as \"DURATION\", \"SCHEDULE_ENTRY\".\"MODIFIED_TIMESTAMP\" as \"MODIFIED_TIMESTAMP\", \"SCHEDULE_ENTRY\".\"END_DATE\" as \"END_DATE\", \"SCHEDULE_ENTRY\".\"PROJECT\" as \"PROJECT\", \"SCHEDULE_ENTRY\".\"POSITION\" as \"POSITION\", \"SCHEDULE_ENTRY\".\"END_TIME\" as \"END_TIME\", \"SCHEDULE_ENTRY\".\"START_DATE\" as \"START_DATE\", \"SCHEDULE_ENTRY\".\"START_TIME\" as \"START_TIME\", \"SCHEDULE\".\"ID\" as \"SCHEDULE_ID\", \"SCHEDULE_ENTRY\".\"PAYROLL\" as \"AGENT_ID\" FROM \"SCHEDULE_DETAIL_VW\" \"SCHEDULE_ENTRY\" Join CONVERGYS.SCHEDULE_VW SCHEDULE On SCHEDULE.PAYROLL = SCHEDULE_ENTRY.PAYROLL And SCHEDULE_ENTRY.START_DATE >= SCHEDULE.START_DATE And (SCHEDULE_ENTRY.end_date Is Null Or SCHEDULE_ENTRY.end_date<=SCHEDULE.END_DATE) ";
	private String selectFromStatementTableName = " FROM \"CONVERGYS\".\"SCHEDULE_DETAIL_VW\" \"SCHEDULE_ENTRY\"";
	private String whereClause = " WHERE \"SCHEDULE_ENTRY\".\"ID\"=?";
	private String whereInClause = " join table(sys.dbms_debug_vc2coll(?)) SQLLIST on \"SCHEDULE_ENTRY\".\"ID\"= SQLLIST.column_value";
	private String orderByTableName = " ORDER BY \"SCHEDULE_ENTRY\".\"ID\"";

	private String joinScheduleIDScheduleEntry = "Join CONVERGYS.SCHEDULE_VW SCHEDULE On SCHEDULE.PAYROLL = SCHEDULE_ENTRY.PAYROLL And SCHEDULE_ENTRY.START_DATE >= SCHEDULE.START_DATE And (SCHEDULE_ENTRY.end_date Is Null Or SCHEDULE_ENTRY.end_date<=SCHEDULE.END_DATE) WHERE SCHEDULE.ID=?";



	@Override
	protected String getConnectionFactoryName() {
		return ScheduleEntryDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT \"SCHEDULE_ENTRY\".\"ID\" as \"ID\" " + selectFromStatementTableName + whereClause;
	}

	@Override
	protected String getSelectStarSQL() {
		return SQL_VIEW   + whereClause;
	}

	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT \"SCHEDULE_ENTRY\".\"ID\" as \"ID\" " + selectFromStatementTableName +  orderByTableName;
	}

	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT \"SCHEDULE_ENTRY\".\"ID\" as \"ID\" " + selectFromStatementTableName  +  orderByTableName  + " LIMIT ? OFFSET ?";
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
		return "SELECT \"SCHEDULE_ENTRY\".\"ID\" as \"ID\" " + selectFromStatementTableName +  whereInClause;
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		if (joinColumnName.equalsIgnoreCase("\"SCHEDULE_ID\""))
{
return "SELECT \"SCHEDULE_ENTRY\".\"ID\" as \"ID\" " + SQL_VIEW + " " + selectFromStatementTableName + joinScheduleIDScheduleEntry;
}

		return SQL_VIEW + "  \"SCHEDULE_ENTRY\"." + joinColumnName + "=?";
	}

	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) 
	{
		if (joinColumnName.equalsIgnoreCase("\"SCHEDULE_ID\""))
{
return "SELECT \"SCHEDULE_ENTRY\".\"ID\" as \"ID\" " + selectFromStatementTableName + joinScheduleIDScheduleEntry;
}


		return "SELECT \"SCHEDULE_ENTRY\".\"ID\" as \"ID\" " + selectFromStatementTableName + " WHERE \"SCHEDULE_ENTRY\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT \"SCHEDULE_ENTRY\".\"ID\" as \"ID\" " + selectFromStatementTableName;
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return SQL_VIEW;
	}

	@Override
	protected String getInsertIntoSQL() {
		return "";//"INSERT INTO SCHEDULE_ENTRY (ID) VALUES (?)";
	}

	@Override
	protected String getUpdateSet() {
		return "";//"UPDATE SCHEDULE_ENTRY SET  WHERE ID=?";
	}

	@Override
	protected String getDeleteFromSQL() 
	{
		return "";//"DELETE FROM SCHEDULE_ENTRY WHERE ID=?";
	}

	@Override
	protected ScheduleEntry extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {

		
ScheduleEntry nextResult = null;
    	
		    	
    	if (nextResult == null) {
    		nextResult = new ScheduleEntry();
    	}


		// ID
		nextResult.setID(rs.getString("ID"));

		if (!shellOnly) 
		{
			nextResult.setEndDate(DateUtils.utilDateFromSqlTimestamp(rs.getTimestamp("END_DATE")));


nextResult.setStartDate(DateUtils.utilDateFromSqlTimestamp(rs.getTimestamp("START_DATE")));


nextResult.setEndTime(DateUtils.utilDateFromSqlTimestamp(rs.getTimestamp("END_TIME")));


nextResult.setModifiedTimestamp(DateUtils.utilDateFromSqlTimestamp(rs.getTimestamp("MODIFIED_TIMESTAMP")));


nextResult.setStartTime(DateUtils.utilDateFromSqlTimestamp(rs.getTimestamp("START_TIME")));


nextResult.setDuration(rs.getDouble("DURATION"));


nextResult.setCostPOSIndex(rs.getInt("COST_POS_INDEX"));


nextResult.setProject(rs.getString("PROJECT"));


nextResult.setPosition(rs.getString("POSITION"));


Agent agent = new Agent();
agent.setID(rs.getString("AGENT_ID"));
if (StringUtils.hasText(agent.getID())) {
	nextResult.setAgent(agent);
}


Schedule schedule = new Schedule();
schedule.setID(rs.getString("SCHEDULE_ID"));
if(StringUtils.hasText(schedule.getID())) {
	nextResult.setSchedule(schedule);
}




		}

		return nextResult;
	}

	@Override
	protected void setPreparedStatmentInsertParams(ScheduleEntry perceroObject, PreparedStatement pstmt) throws SQLException {



	}

	@Override
	protected void setPreparedStatmentUpdateParams(ScheduleEntry perceroObject, PreparedStatement pstmt) throws SQLException {



	}

	@Override
	public List<ScheduleEntry> findByExample(ScheduleEntry theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
	{



		String sql = getFindByExampleSelectSql(shellOnly);

		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();

		boolean usePosition = StringUtils.hasText(theQueryObject.getPosition()) && (excludeProperties == null || !excludeProperties.contains("position"));

if (usePosition)
{
sql += " WHERE ";
sql += " POSITION=? ";
paramValues.add(theQueryObject.getPosition());
propertyCounter++;
}

boolean useProject = StringUtils.hasText(theQueryObject.getProject()) && (excludeProperties == null || !excludeProperties.contains("project"));

if (useProject)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " PROJECT=? ";
paramValues.add(theQueryObject.getProject());
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

boolean useEndTime = theQueryObject.getEndTime() != null && (excludeProperties == null || !excludeProperties.contains("endTime"));

if (useEndTime)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " END_TIME=? ";
paramValues.add(theQueryObject.getEndTime());
propertyCounter++;
}

boolean useModifiedTimestamp = theQueryObject.getModifiedTimestamp() != null && (excludeProperties == null || !excludeProperties.contains("modifiedTimestamp"));

if (useModifiedTimestamp)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " MODIFIED_TIMESTAMP=? ";
paramValues.add(theQueryObject.getModifiedTimestamp());
propertyCounter++;
}

boolean useStartTime = theQueryObject.getStartTime() != null && (excludeProperties == null || !excludeProperties.contains("startTime"));

if (useStartTime)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " START_TIME=? ";
paramValues.add(theQueryObject.getStartTime());
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

boolean useCostPOSIndex = theQueryObject.getCostPOSIndex() != null && (excludeProperties == null || !excludeProperties.contains("costPOSIndex"));

if (useCostPOSIndex)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " COST_POS_INDEX=? ";
paramValues.add(theQueryObject.getCostPOSIndex());
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

boolean useScheduleID = theQueryObject.getSchedule() != null && (excludeProperties == null || !excludeProperties.contains("schedule"));

if (useScheduleID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " SCHEDULE_ID=? ";
paramValues.add(theQueryObject.getSchedule().getID());
propertyCounter++;
}




		return executeSelectWithParams(sql, paramValues.toArray(), shellOnly);		
	}

	
public ScheduleEntry createObject(ScheduleEntry perceroObject, String userId)
		throws SyncException {
	if ( !hasCreateAccess(BaseDataObject.toClassIdPair(perceroObject), userId) ) {
		return null;
	}

	long timeStart = System.currentTimeMillis();

	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	String query = "Select SCHEDULE_DETAIL_VW_SEQ.NEXTVAL from dual";
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
