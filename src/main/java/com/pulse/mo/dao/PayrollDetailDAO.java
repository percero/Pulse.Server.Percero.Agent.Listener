
package com.pulse.mo.dao;

import java.sql.PreparedStatement;
import java.sql.CallableStatement;
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
	
	public static final String SQL_VIEW = ",\"PAYROLL_DETAIL\".\"ASSUMED_OFF\",\"PAYROLL_DETAIL\".\"SHIFT_START_DATE_TIME\",\"PAYROLL_DETAIL\".\"SHIFT_START_END_TIME\",\"PAYROLL_DETAIL\".\"SHIFT_RULE\"";
	private String selectFromStatementTableName = " FROM \"PAYROLL_DETAIL\" \"PAYROLL_DETAIL\"";
	private String whereClause = " WHERE \"PAYROLL_DETAIL\".\"ID\"=?";
	private String whereInClause = " join table(sys.dbms_debug_vc2coll(?)) SQLLIST on \"PAYROLL_DETAIL\".\"ID\"= SQLLIST.column_value";
	private String orderByTableName = " ORDER BY \"PAYROLL_DETAIL\".\"ID\"";
	
	

	
	@Override
	protected String getConnectionFactoryName() {
		return PayrollDetailDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT \"PAYROLL_DETAIL\".\"ID\" " + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT \"PAYROLL_DETAIL\".\"ID\"" + SQL_VIEW  + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT \"PAYROLL_DETAIL\".\"ID\" " + selectFromStatementTableName +  orderByTableName;
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT \"PAYROLL_DETAIL\".\"ID\" " + selectFromStatementTableName  +  orderByTableName  + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT \"PAYROLL_DETAIL\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName  + orderByTableName;
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT \"PAYROLL_DETAIL\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + orderByTableName + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() 
	{
		return "SELECT COUNT(ID) " + selectFromStatementTableName;
	}
	
	@Override
	protected String getSelectInStarSQL() 
	{
		return "SELECT \"PAYROLL_DETAIL\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + whereInClause;
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT \"PAYROLL_DETAIL\".\"ID\" " + selectFromStatementTableName + whereInClause;
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		
		return "SELECT \"PAYROLL_DETAIL\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + " WHERE \"PAYROLL_DETAIL\"." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) 
	{
		
		return "SELECT \"PAYROLL_DETAIL\".\"ID\" " + selectFromStatementTableName + " WHERE \"PAYROLL_DETAIL\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT \"PAYROLL_DETAIL\".\"ID\" " + selectFromStatementTableName;
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT \"PAYROLL_DETAIL\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName;
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO PAYROLL_DETAIL (\"ID\",\"ASSUMED_OFF\",\"SHIFT_START_DATE_TIME\",\"SHIFT_START_END_TIME\",\"SHIFT_RULE\") VALUES (?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE \"TBL_PAYROLL_DETAIL\" SET \"ASSUMED_OFF\"=?,\"SHIFT_START_DATE_TIME\"=?,\"SHIFT_START_END_TIME\"=?,\"SHIFT_RULE\"=? WHERE \"ID\"=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM \"TBL_PAYROLL_DETAIL\" WHERE \"ID\"=?";
	}
	
	@Override
	protected PayrollDetail extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	PayrollDetail nextResult = new PayrollDetail();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setAssumedOff(rs.getBoolean("ASSUMED_OFF"));

nextResult.setShiftStartDateTime(rs.getDate("SHIFT_START_DATE_TIME"));

nextResult.setShiftStartEndTime(rs.getDate("SHIFT_START_END_TIME"));

nextResult.setShiftRule(rs.getString("SHIFT_RULE"));


			
    	}
    	
    	return nextResult;
	}
	
	protected void setBaseStatmentInsertParams(PayrollDetail perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setBoolean(2, perceroObject.getAssumedOff());
pstmt.setDate(3, DateUtils.utilDateToSqlDate(perceroObject.getShiftStartDateTime()));
pstmt.setDate(4, DateUtils.utilDateToSqlDate(perceroObject.getShiftStartEndTime()));
pstmt.setString(5, perceroObject.getShiftRule());

		
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(PayrollDetail perceroObject, PreparedStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
		
	}
	
	@Override
	protected void setCallableStatmentInsertParams(PayrollDetail perceroObject, CallableStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	

	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(PayrollDetail perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setBoolean(1, perceroObject.getAssumedOff());
pstmt.setDate(2, DateUtils.utilDateToSqlDate(perceroObject.getShiftStartDateTime()));
pstmt.setDate(3, DateUtils.utilDateToSqlDate(perceroObject.getShiftStartEndTime()));
pstmt.setString(4, perceroObject.getShiftRule());
pstmt.setString(5, perceroObject.getID());

		
	}
	
	
	@Override
	protected void setCallableStatmentUpdateParams(PayrollDetail perceroObject, CallableStatement pstmt) throws SQLException 
	{
		
		//must be in same order as insert
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	}
	
	

	@Override
	public List<PayrollDetail> findByExample(PayrollDetail theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useAssumedOff = theQueryObject.getAssumedOff() != null && (excludeProperties == null || !excludeProperties.contains("assumedOff"));

if (useAssumedOff)
{
sql += " WHERE ";
sql += " \"ASSUMED_OFF\" =? ";
paramValues.add(theQueryObject.getAssumedOff());
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
sql += " \"SHIFT_RULE\" =? ";
paramValues.add(theQueryObject.getShiftRule());
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
	
	@Override
	protected String getUpdateCallableStatementSql() {
		return "{call UPDATE_PAYROLL_DETAIL(?,?,?,?,?)}";
	}
	@Override
	protected String getInsertCallableStatementSql() {
		return "{call CREATE_PAYROLL_DETAIL(?,?,?,?,?)}";
	}
	@Override
	protected String getDeleteCallableStatementSql() {
		return "{call Delete_PAYROLL_DETAIL(?)}";
	}
	
	
	
	
}
