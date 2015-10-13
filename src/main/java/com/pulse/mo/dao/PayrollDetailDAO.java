
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
		return "SELECT \"PAYROLL_DETAIL\".\"ID\" FROM \"PAYROLL_DETAIL\" \"PAYROLL_DETAIL\" WHERE \"PAYROLL_DETAIL\".\"ID\"=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT \"PAYROLL_DETAIL\".\"ID\",\"PAYROLL_DETAIL\".\"SHIFT_RULE\",\"PAYROLL_DETAIL\".\"SHIFT_START_DATE_TIME\",\"PAYROLL_DETAIL\".\"SHIFT_START_END_TIME\",\"PAYROLL_DETAIL\".\"ASSUMED_OFF\" FROM \"PAYROLL_DETAIL\" \"PAYROLL_DETAIL\" WHERE \"PAYROLL_DETAIL\".\"ID\"=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT \"PAYROLL_DETAIL\".\"ID\" FROM \"PAYROLL_DETAIL\" \"PAYROLL_DETAIL\" ORDER BY \"ID\"";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT \"PAYROLL_DETAIL\".\"ID\" FROM \"PAYROLL_DETAIL\" \"PAYROLL_DETAIL\" ORDER BY \"PAYROLL_DETAIL\".\"ID\" LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT \"PAYROLL_DETAIL\".\"ID\",\"PAYROLL_DETAIL\".\"SHIFT_RULE\",\"PAYROLL_DETAIL\".\"SHIFT_START_DATE_TIME\",\"PAYROLL_DETAIL\".\"SHIFT_START_END_TIME\",\"PAYROLL_DETAIL\".\"ASSUMED_OFF\" FROM \"PAYROLL_DETAIL\" \"PAYROLL_DETAIL\" ORDER BY \"PAYROLL_DETAIL\".\"ID\"";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT \"PAYROLL_DETAIL\".\"ID\",\"PAYROLL_DETAIL\".\"SHIFT_RULE\",\"PAYROLL_DETAIL\".\"SHIFT_START_DATE_TIME\",\"PAYROLL_DETAIL\".\"SHIFT_START_END_TIME\",\"PAYROLL_DETAIL\".\"ASSUMED_OFF\" FROM \"PAYROLL_DETAIL\" \"PAYROLL_DETAIL\" ORDER BY \"PAYROLL_DETAIL\".\"ID\" LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM \"PAYROLL_DETAIL\" \"PAYROLL_DETAIL\"";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT \"PAYROLL_DETAIL\".\"ID\",\"PAYROLL_DETAIL\".\"SHIFT_RULE\",\"PAYROLL_DETAIL\".\"SHIFT_START_DATE_TIME\",\"PAYROLL_DETAIL\".\"SHIFT_START_END_TIME\",\"PAYROLL_DETAIL\".\"ASSUMED_OFF\" FROM \"PAYROLL_DETAIL\" \"PAYROLL_DETAIL\" WHERE \"PAYROLL_DETAIL\".\"ID\" IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT \"PAYROLL_DETAIL\".\"ID\" FROM \"PAYROLL_DETAIL\" \"PAYROLL_DETAIL\" WHERE \"PAYROLL_DETAIL\".\"ID\" IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		return "SELECT \"PAYROLL_DETAIL\".\"ID\",\"PAYROLL_DETAIL\".\"SHIFT_RULE\",\"PAYROLL_DETAIL\".\"SHIFT_START_DATE_TIME\",\"PAYROLL_DETAIL\".\"SHIFT_START_END_TIME\",\"PAYROLL_DETAIL\".\"ASSUMED_OFF\" FROM \"PAYROLL_DETAIL\" \"PAYROLL_DETAIL\" WHERE \"PAYROLL_DETAIL\"." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT \"PAYROLL_DETAIL\".\"ID\" FROM \"PAYROLL_DETAIL\" \"PAYROLL_DETAIL\" WHERE \"PAYROLL_DETAIL\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT \"PAYROLL_DETAIL\".\"ID\" FROM \"PAYROLL_DETAIL\" \"PAYROLL_DETAIL\" ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT \"PAYROLL_DETAIL\".\"ID\",\"PAYROLL_DETAIL\".\"SHIFT_RULE\",\"PAYROLL_DETAIL\".\"SHIFT_START_DATE_TIME\",\"PAYROLL_DETAIL\".\"SHIFT_START_END_TIME\",\"PAYROLL_DETAIL\".\"ASSUMED_OFF\" FROM \"PAYROLL_DETAIL\" \"PAYROLL_DETAIL\" ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO PAYROLL_DETAIL (\"ID\",\"SHIFT_RULE\",\"SHIFT_START_DATE_TIME\",\"SHIFT_START_END_TIME\",\"ASSUMED_OFF\") VALUES (?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE \"PAYROLL_DETAIL\" SET \"SHIFT_RULE\"=?,\"SHIFT_START_DATE_TIME\"=?,\"SHIFT_START_END_TIME\"=?,\"ASSUMED_OFF\"=? WHERE \"ID\"=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM \"PAYROLL_DETAIL\" WHERE \"ID\"=?";
	}
	
	@Override
	protected PayrollDetail extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	PayrollDetail nextResult = new PayrollDetail();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setShiftRule(rs.getString("SHIFT_RULE"));

nextResult.setShiftStartDateTime(rs.getDate("SHIFT_START_DATE_TIME"));

nextResult.setShiftStartEndTime(rs.getDate("SHIFT_START_END_TIME"));

nextResult.setAssumedOff(rs.getBoolean("ASSUMED_OFF"));


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(PayrollDetail perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getShiftRule());
pstmt.setDate(3, DateUtils.utilDateToSqlDate(perceroObject.getShiftStartDateTime()));
pstmt.setDate(4, DateUtils.utilDateToSqlDate(perceroObject.getShiftStartEndTime()));
pstmt.setBoolean(5, perceroObject.getAssumedOff());

		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(PayrollDetail perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getShiftRule());
pstmt.setDate(2, DateUtils.utilDateToSqlDate(perceroObject.getShiftStartDateTime()));
pstmt.setDate(3, DateUtils.utilDateToSqlDate(perceroObject.getShiftStartEndTime()));
pstmt.setBoolean(4, perceroObject.getAssumedOff());
pstmt.setString(5, perceroObject.getID());

		
	}

	@Override
	public List<PayrollDetail> findByExample(PayrollDetail theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useShiftRule = StringUtils.hasText(theQueryObject.getShiftRule()) && (excludeProperties == null || !excludeProperties.contains("shiftRule"));

if (useShiftRule)
{
sql += " WHERE ";
sql += " \"SHIFT_RULE\" =? ";
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
sql += " \"SHIFT_START_DATE_TIME\" =? ";
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
sql += " \"SHIFT_START_END_TIME\" =? ";
paramValues.add(theQueryObject.getShiftStartEndTime());
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
sql += " \"ASSUMED_OFF\" =? ";
paramValues.add(theQueryObject.getAssumedOff());
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
