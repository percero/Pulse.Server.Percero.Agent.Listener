
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
import com.pulse.mo.ScheduleEntry;
import com.pulse.mo.Agent;

*/

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
	public static final String SQL_VIEW = "SELECT  \"SCHEDULE_ENTRY\".\"ID\" as \"ID\", \"SCHEDULE_ENTRY\".\"POSITION\" as \"POSITION\", \"SCHEDULE_ENTRY\".\"MODIFIED_TIMESTAMP\" as \"MODIFIED_TIMESTAMP\", \"SCHEDULE_ENTRY\".\"PROJECT\" as \"PROJECT\", \"SCHEDULE_ENTRY\".\"END_TIME\" as \"END_TIME\", \"SCHEDULE_ENTRY\".\"START_DATE\" as \"START_DATE\", \"SCHEDULE_ENTRY\".\"END_DATE\" as \"END_DATE\", \"SCHEDULE_ENTRY\".\"COST_POS_INDEX\" as \"COST_POS_INDEX\", \"SCHEDULE_ENTRY\".\"START_TIME\" as \"START_TIME\", '' as \"DURATION\", \"SCHEDULE_ENTRY\".\"PAYROLL\" as \"AGENT_ID\" FROM \"SCHEDULE_DETAIL_VW\" \"SCHEDULE_ENTRY\" ";
	private String selectFromStatementTableName = " FROM \"CONVERGYS\".\"SCHEDULE_DETAIL_VW\" \"SCHEDULE_ENTRY\"";
	private String whereClause = " WHERE \"SCHEDULE_ENTRY\".\"ID\"=?";
	private String whereInClause = " join table(sys.dbms_debug_vc2coll(?)) SQLLIST on \"SCHEDULE_ENTRY\".\"ID\"= SQLLIST.column_value";
	private String orderByTableName = " ORDER BY \"SCHEDULE_ENTRY\".\"ID\"";
	
	

	
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
		
		return SQL_VIEW + "  \"SCHEDULE_ENTRY\"." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) 
	{
		
		
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
    	ScheduleEntry nextResult = new ScheduleEntry();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setPosition(rs.getString("POSITION"));

nextResult.setProject(rs.getString("PROJECT"));

nextResult.setEndDate(rs.getDate("END_DATE"));

nextResult.setStartDate(rs.getDate("START_DATE"));

nextResult.setEndTime(rs.getDate("END_TIME"));

nextResult.setModifiedTimestamp(rs.getDate("MODIFIED_TIMESTAMP"));

nextResult.setStartTime(rs.getDate("START_TIME"));

nextResult.setDuration(rs.getDouble("DURATION"));

nextResult.setCostPOSIndex(rs.getInt("COST_POS_INDEX"));

Agent agent = new Agent();
agent.setID(rs.getString("AGENT_ID"));
nextResult.setAgent(agent);


			
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


		
		
		return executeSelectWithParams(sql, paramValues.toArray(), shellOnly);		
	}
	
}
