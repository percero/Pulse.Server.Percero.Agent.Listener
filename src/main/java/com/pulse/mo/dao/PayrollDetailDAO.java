
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
import com.pulse.mo.PayrollDetail;
import com.pulse.mo.AgentTime;

*/

@Component
public class PayrollDetailDAO extends SqlDataAccessObject<PayrollDetail> implements IDataAccessObject<PayrollDetail> {

	static final Logger log = Logger.getLogger(PayrollDetailDAO.class);

	
	public PayrollDetailDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(PayrollDetail.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	@Override
	protected String getConnectionFactoryName() {
		return PayrollDetailDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT payrolldetail.ID FROM PayrollDetail payrolldetail WHERE payrolldetail.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT payrolldetail.ID,payrolldetail.externalID,payrolldetail.assumedOff,payrolldetail.shiftRule,payrolldetail.shiftStartDateTime,payrolldetail.shiftStartEndTime FROM PayrollDetail payrolldetail WHERE payrolldetail.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT payrolldetail.ID FROM PayrollDetail payrolldetail ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT payrolldetail.ID FROM PayrollDetail payrolldetail ORDER BY payrolldetail.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT payrolldetail.ID,payrolldetail.externalID,payrolldetail.assumedOff,payrolldetail.shiftRule,payrolldetail.shiftStartDateTime,payrolldetail.shiftStartEndTime FROM PayrollDetail payrolldetail ORDER BY payrolldetail.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT payrolldetail.ID,payrolldetail.externalID,payrolldetail.assumedOff,payrolldetail.shiftRule,payrolldetail.shiftStartDateTime,payrolldetail.shiftStartEndTime FROM PayrollDetail payrolldetail ORDER BY payrolldetail.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM PayrollDetail payrolldetail";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT payrolldetail.ID,payrolldetail.externalID,payrolldetail.assumedOff,payrolldetail.shiftRule,payrolldetail.shiftStartDateTime,payrolldetail.shiftStartEndTime FROM PayrollDetail payrolldetail WHERE payrolldetail.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT payrolldetail.ID FROM PayrollDetail payrolldetail WHERE payrolldetail.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT payrolldetail.ID,payrolldetail.externalID,payrolldetail.assumedOff,payrolldetail.shiftRule,payrolldetail.shiftStartDateTime,payrolldetail.shiftStartEndTime FROM PayrollDetail payrolldetail WHERE payrolldetail." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT payrolldetail.ID FROM PayrollDetail payrolldetail WHERE payrolldetail." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT payrolldetail.ID FROM PayrollDetail payrolldetail ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT payrolldetail.ID,payrolldetail.externalID,payrolldetail.assumedOff,payrolldetail.shiftRule,payrolldetail.shiftStartDateTime,payrolldetail.shiftStartEndTime FROM PayrollDetail payrolldetail ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO PayrollDetail (ID,externalID,assumedOff,shiftRule,shiftStartDateTime,shiftStartEndTime) VALUES (?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE PayrollDetail SET externalID=?,assumedOff=?,shiftRule=?,shiftStartDateTime=?,shiftStartEndTime=? WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM PayrollDetail WHERE ID=?";
	}
	
	@Override
	protected PayrollDetail extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	PayrollDetail nextResult = new PayrollDetail();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setExternalID(rs.getString("externalID"));

nextResult.setAssumedOff(rs.getBoolean("assumedOff"));

nextResult.setShiftRule(rs.getString("shiftRule"));

nextResult.setShiftStartDateTime(rs.getDate("shiftStartDateTime"));

nextResult.setShiftStartEndTime(rs.getDate("shiftStartEndTime"));


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(PayrollDetail perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getExternalID());
pstmt.setBoolean(3, perceroObject.getAssumedOff());
pstmt.setString(4, perceroObject.getShiftRule());
pstmt.setDate(5, DateUtils.utilDateToSqlDate(perceroObject.getShiftStartDateTime()));
pstmt.setDate(6, DateUtils.utilDateToSqlDate(perceroObject.getShiftStartEndTime()));

		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(PayrollDetail perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getExternalID());
pstmt.setBoolean(2, perceroObject.getAssumedOff());
pstmt.setString(3, perceroObject.getShiftRule());
pstmt.setDate(4, DateUtils.utilDateToSqlDate(perceroObject.getShiftStartDateTime()));
pstmt.setDate(5, DateUtils.utilDateToSqlDate(perceroObject.getShiftStartEndTime()));
pstmt.setString(6, perceroObject.getID());

		
	}

	@Override
	public List<PayrollDetail> findByExample(PayrollDetail theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useExternalID = StringUtils.hasText(theQueryObject.getExternalID()) && (excludeProperties == null || !excludeProperties.contains("externalID"));

if (useExternalID)
{
sql += " WHERE ";
paramValues.add(theQueryObject.getExternalID());
propertyCounter++;
}

boolean useAssumedOff = theQueryObject.getAssumedOff() != null && (excludeProperties == null || !excludeProperties.contains("assumedOff"));

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
sql += " assumedOff=? ";
paramValues.add(theQueryObject.getAssumedOff());
propertyCounter++;
}

boolean useShiftRule = StringUtils.hasText(theQueryObject.getShiftRule()) && (excludeProperties == null || !excludeProperties.contains("shiftRule"));

if (useShiftRule)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " shiftRule=? ";
paramValues.add(theQueryObject.getShiftRule());
propertyCounter++;
}

boolean useShiftStartDateTime = theQueryObject.getShiftStartDateTime() != null && (excludeProperties == null || !excludeProperties.contains("shiftStartDateTime"));

if (useShiftStartDateTime)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " shiftStartDateTime=? ";
paramValues.add(theQueryObject.getShiftStartDateTime());
propertyCounter++;
}

boolean useShiftStartEndTime = theQueryObject.getShiftStartEndTime() != null && (excludeProperties == null || !excludeProperties.contains("shiftStartEndTime"));

if (useShiftStartEndTime)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " shiftStartEndTime=? ";
paramValues.add(theQueryObject.getShiftStartEndTime());
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
