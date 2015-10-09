
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
	@Override
	protected String getConnectionFactoryName() {
		return TraceEntryDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT TRACE_ENTRY.ID FROM TRACE_ENTRY TRACE_ENTRY WHERE TRACE_ENTRY.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT TRACE_ENTRY.ID,TRACE_ENTRY.LOG_MESSAGE,TRACE_ENTRY.TIMESTAMP,TRACE_ENTRY.TRACE_TYPE,TRACE_ENTRY.TRACE_LOG_ID,TRACE_ENTRY.PULSE_USER_ID FROM TRACE_ENTRY TRACE_ENTRY WHERE TRACE_ENTRY.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT TRACE_ENTRY.ID FROM TRACE_ENTRY TRACE_ENTRY ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT TRACE_ENTRY.ID FROM TRACE_ENTRY TRACE_ENTRY ORDER BY TRACE_ENTRY.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT TRACE_ENTRY.ID,TRACE_ENTRY.LOG_MESSAGE,TRACE_ENTRY.TIMESTAMP,TRACE_ENTRY.TRACE_TYPE,TRACE_ENTRY.TRACE_LOG_ID,TRACE_ENTRY.PULSE_USER_ID FROM TRACE_ENTRY TRACE_ENTRY ORDER BY TRACE_ENTRY.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT TRACE_ENTRY.ID,TRACE_ENTRY.LOG_MESSAGE,TRACE_ENTRY.TIMESTAMP,TRACE_ENTRY.TRACE_TYPE,TRACE_ENTRY.TRACE_LOG_ID,TRACE_ENTRY.PULSE_USER_ID FROM TRACE_ENTRY TRACE_ENTRY ORDER BY TRACE_ENTRY.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM TRACE_ENTRY TRACE_ENTRY";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT TRACE_ENTRY.ID,TRACE_ENTRY.LOG_MESSAGE,TRACE_ENTRY.TIMESTAMP,TRACE_ENTRY.TRACE_TYPE,TRACE_ENTRY.TRACE_LOG_ID,TRACE_ENTRY.PULSE_USER_ID FROM TRACE_ENTRY TRACE_ENTRY WHERE TRACE_ENTRY.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT TRACE_ENTRY.ID FROM TRACE_ENTRY TRACE_ENTRY WHERE TRACE_ENTRY.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT TRACE_ENTRY.ID,TRACE_ENTRY.LOG_MESSAGE,TRACE_ENTRY.TIMESTAMP,TRACE_ENTRY.TRACE_TYPE,TRACE_ENTRY.TRACE_LOG_ID,TRACE_ENTRY.PULSE_USER_ID FROM TRACE_ENTRY TRACE_ENTRY WHERE TRACE_ENTRY." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT TRACE_ENTRY.ID FROM TRACE_ENTRY TRACE_ENTRY WHERE TRACE_ENTRY." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT TRACE_ENTRY.ID FROM TRACE_ENTRY TRACE_ENTRY ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT TRACE_ENTRY.ID,TRACE_ENTRY.LOG_MESSAGE,TRACE_ENTRY.TIMESTAMP,TRACE_ENTRY.TRACE_TYPE,TRACE_ENTRY.TRACE_LOG_ID,TRACE_ENTRY.PULSE_USER_ID FROM TRACE_ENTRY TRACE_ENTRY ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO TRACE_ENTRY (ID,LOG_MESSAGE,TIMESTAMP,TRACE_TYPE,TRACE_LOG_ID,PULSE_USER_ID) VALUES (?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE TRACE_ENTRY SET LOG_MESSAGE=?,TIMESTAMP=?,TRACE_TYPE=?,TRACE_LOG_ID=?,PULSE_USER_ID=? WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM TRACE_ENTRY WHERE ID=?";
	}
	
	@Override
	protected TraceEntry extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	TraceEntry nextResult = new TraceEntry();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setLogMessage(rs.getString("LOG_MESSAGE"));

nextResult.setTimestamp(rs.getDate("TIMESTAMP"));

nextResult.setTraceType(rs.getString("TRACE_TYPE"));

TraceLog tracelog = new TraceLog();
tracelog.setID(rs.getString("TRACE_LOG_ID"));
nextResult.setTraceLog(tracelog);

PulseUser pulseuser = new PulseUser();
pulseuser.setID(rs.getString("PULSE_USER_ID"));
nextResult.setPulseUser(pulseuser);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(TraceEntry perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getLogMessage());
pstmt.setDate(3, DateUtils.utilDateToSqlDate(perceroObject.getTimestamp()));
pstmt.setString(4, perceroObject.getTraceType());

if (perceroObject.getTraceLog() == null)
{
pstmt.setString(5, null);
}
else
{
		pstmt.setString(5, perceroObject.getTraceLog().getID());
}


if (perceroObject.getPulseUser() == null)
{
pstmt.setString(6, null);
}
else
{
		pstmt.setString(6, perceroObject.getPulseUser().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(TraceEntry perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getLogMessage());
pstmt.setDate(2, DateUtils.utilDateToSqlDate(perceroObject.getTimestamp()));
pstmt.setString(3, perceroObject.getTraceType());

if (perceroObject.getTraceLog() == null)
{
pstmt.setString(4, null);
}
else
{
		pstmt.setString(4, perceroObject.getTraceLog().getID());
}


if (perceroObject.getPulseUser() == null)
{
pstmt.setString(5, null);
}
else
{
		pstmt.setString(5, perceroObject.getPulseUser().getID());
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
		
		boolean useLogMessage = StringUtils.hasText(theQueryObject.getLogMessage()) && (excludeProperties == null || !excludeProperties.contains("logMessage"));

if (useLogMessage)
{
sql += " WHERE ";
sql += " LOG_MESSAGE=? ";
paramValues.add(theQueryObject.getLogMessage());
propertyCounter++;
}

boolean useTimestamp = theQueryObject.getTimestamp() != null && (excludeProperties == null || !excludeProperties.contains("timestamp"));

if (useTimestamp)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " TIMESTAMP=? ";
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
sql += " TRACE_TYPE=? ";
paramValues.add(theQueryObject.getTraceType());
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
sql += " TRACE_LOG_ID=? ";
paramValues.add(theQueryObject.getTraceLog().getID());
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
sql += " PULSE_USER_ID=? ";
paramValues.add(theQueryObject.getPulseUser().getID());
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
