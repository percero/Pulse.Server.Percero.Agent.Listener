
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
import com.pulse.mo.TraceEntry;
import com.pulse.mo.TraceLog;
import com.pulse.mo.PulseUser;

*/

@Component
public class TraceEntryDAO extends SqlDataAccessObject<TraceEntry> implements IDataAccessObject<TraceEntry> {

	static final Logger log = Logger.getLogger(TraceEntryDAO.class);

	
	public TraceEntryDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(TraceEntry.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	
	public static final String SQL_VIEW = ",\"TRACE_ENTRY\".\"TIMESTAMP\",\"TRACE_ENTRY\".\"TRACE_TYPE\",\"TRACE_ENTRY\".\"LOG_MESSAGE\",\"TRACE_ENTRY\".\"PULSE_USER_ID\",\"TRACE_ENTRY\".\"TRACE_LOG_ID\"";
	private String selectFromStatementTableName = " FROM \"TRACE_ENTRY\" \"TRACE_ENTRY\"";
	private String whereClause = " WHERE \"TRACE_ENTRY\".\"ID\"=?";
	private String whereInClause = " join table(sys.dbms_debug_vc2coll(?)) SQLLIST on \"TRACE_ENTRY\".\"ID\"= SQLLIST.column_value";
	private String orderByTableName = " ORDER BY \"TRACE_ENTRY\".\"ID\"";
	
	

	
	@Override
	protected String getConnectionFactoryName() {
		return TraceEntryDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT \"TRACE_ENTRY\".\"ID\" " + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT \"TRACE_ENTRY\".\"ID\"" + SQL_VIEW  + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT \"TRACE_ENTRY\".\"ID\" " + selectFromStatementTableName +  orderByTableName;
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT \"TRACE_ENTRY\".\"ID\" " + selectFromStatementTableName  +  orderByTableName  + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT \"TRACE_ENTRY\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName  + orderByTableName;
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT \"TRACE_ENTRY\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + orderByTableName + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() 
	{
		return "SELECT COUNT(ID) " + selectFromStatementTableName;
	}
	
	@Override
	protected String getSelectInStarSQL() 
	{
		return "SELECT \"TRACE_ENTRY\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + whereInClause;
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT \"TRACE_ENTRY\".\"ID\" " + selectFromStatementTableName + whereInClause;
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		
		return "SELECT \"TRACE_ENTRY\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + " WHERE \"TRACE_ENTRY\"." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) 
	{
		
		return "SELECT \"TRACE_ENTRY\".\"ID\" " + selectFromStatementTableName + " WHERE \"TRACE_ENTRY\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT \"TRACE_ENTRY\".\"ID\" " + selectFromStatementTableName;
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT \"TRACE_ENTRY\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName;
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO TRACE_ENTRY (\"ID\",\"TIMESTAMP\",\"TRACE_TYPE\",\"LOG_MESSAGE\",\"PULSE_USER_ID\",\"TRACE_LOG_ID\") VALUES (?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE \"TRACE_ENTRY\" SET \"TIMESTAMP\"=?,\"TRACE_TYPE\"=?,\"LOG_MESSAGE\"=?,\"PULSE_USER_ID\"=?,\"TRACE_LOG_ID\"=? WHERE \"ID\"=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM \"TRACE_ENTRY\" WHERE \"ID\"=?";
	}
	
	@Override
	protected TraceEntry extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	TraceEntry nextResult = new TraceEntry();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setTimestamp(rs.getDate("TIMESTAMP"));

nextResult.setTraceType(rs.getString("TRACE_TYPE"));

nextResult.setLogMessage(rs.getString("LOG_MESSAGE"));

PulseUser pulseuser = new PulseUser();
pulseuser.setID(rs.getString("PULSE_USER_ID"));
nextResult.setPulseUser(pulseuser);

TraceLog tracelog = new TraceLog();
tracelog.setID(rs.getString("TRACE_LOG_ID"));
nextResult.setTraceLog(tracelog);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(TraceEntry perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setDate(2, DateUtils.utilDateToSqlDate(perceroObject.getTimestamp()));
pstmt.setString(3, perceroObject.getTraceType());
pstmt.setString(4, perceroObject.getLogMessage());

if (perceroObject.getPulseUser() == null)
{
pstmt.setString(5, null);
}
else
{
		pstmt.setString(5, perceroObject.getPulseUser().getID());
}


if (perceroObject.getTraceLog() == null)
{
pstmt.setString(6, null);
}
else
{
		pstmt.setString(6, perceroObject.getTraceLog().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(TraceEntry perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setDate(1, DateUtils.utilDateToSqlDate(perceroObject.getTimestamp()));
pstmt.setString(2, perceroObject.getTraceType());
pstmt.setString(3, perceroObject.getLogMessage());

if (perceroObject.getPulseUser() == null)
{
pstmt.setString(4, null);
}
else
{
		pstmt.setString(4, perceroObject.getPulseUser().getID());
}


if (perceroObject.getTraceLog() == null)
{
pstmt.setString(5, null);
}
else
{
		pstmt.setString(5, perceroObject.getTraceLog().getID());
}

pstmt.setString(6, perceroObject.getID());

		
	}

	@Override
	public List<TraceEntry> findByExample(TraceEntry theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useTimestamp = theQueryObject.getTimestamp() != null && (excludeProperties == null || !excludeProperties.contains("timestamp"));

if (useTimestamp)
{
sql += " WHERE ";
sql += " \"TIMESTAMP\" =? ";
paramValues.add(theQueryObject.getTimestamp());
propertyCounter++;
}

boolean useTraceType = StringUtils.hasText(theQueryObject.getTraceType()) && (excludeProperties == null || !excludeProperties.contains("traceType"));

if (useTraceType)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"TRACE_TYPE\" =? ";
paramValues.add(theQueryObject.getTraceType());
propertyCounter++;
}

boolean useLogMessage = StringUtils.hasText(theQueryObject.getLogMessage()) && (excludeProperties == null || !excludeProperties.contains("logMessage"));

if (useLogMessage)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"LOG_MESSAGE\" =? ";
paramValues.add(theQueryObject.getLogMessage());
propertyCounter++;
}

boolean usePulseUserID = theQueryObject.getPulseUser() != null && (excludeProperties == null || !excludeProperties.contains("pulseUser"));

if (usePulseUserID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"PULSE_USER_ID\" =? ";
paramValues.add(theQueryObject.getPulseUser().getID());
propertyCounter++;
}

boolean useTraceLogID = theQueryObject.getTraceLog() != null && (excludeProperties == null || !excludeProperties.contains("traceLog"));

if (useTraceLogID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"TRACE_LOG_ID\" =? ";
paramValues.add(theQueryObject.getTraceLog().getID());
propertyCounter++;
}


		/*
		boolean useValue = StringUtils.hasText(theQueryObject.getValue()) && (excludeProperties == null || !excludeProperties.contains("value"));
		
		if (useValue) {
			sql += " WHERE value=? ";
			paramValues.add(theQueryObject.getValue());
			propertyCounter++;
		}
		
		boolean usePersonId = theQueryObject.getPerson() != null && (excludeProperties == null || !excludeProperties.contains("person"));
		
		if (usePersonId) {
			if (propertyCounter > 0) {
				sql += " AND ";
			}
			else {
				sql += " WHERE ";
			}
			sql += " person_ID=? ";
			paramValues.add(theQueryObject.getPerson().getID());
			propertyCounter++;
		}
		
		*/
		
		return executeSelectWithParams(sql, paramValues.toArray(), shellOnly);		
	}
	
}
