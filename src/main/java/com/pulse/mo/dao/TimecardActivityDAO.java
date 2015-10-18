
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
import com.pulse.mo.TimecardActivity;
import com.pulse.mo.TimecardEntry;
import com.pulse.mo.LOBConfigurationEntry;
import com.pulse.mo.DiscrepancyDetectedNotification;
import com.pulse.mo.ShiftStatusNotification;

*/

@Component
public class TimecardActivityDAO extends SqlDataAccessObject<TimecardActivity> implements IDataAccessObject<TimecardActivity> {

	static final Logger log = Logger.getLogger(TimecardActivityDAO.class);

	
	public TimecardActivityDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(TimecardActivity.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "estart";
	
	//TODO:For use refactoring, so we set it once
	public static final String SQL_VIEW = "SELECT  \"TIMECARD_ACTIVITY\".CENTRE || \"TIMECARD_ACTIVITY\".POS as \"ID\", \"TIMECARD_ACTIVITY\".CENTRE || \"TIMECARD_ACTIVITY\".POS as \"NAME\", \"TIMECARD_ACTIVITY\".\"BILLABLE\" as \"NON_BILLABLE\", \"TIMECARD_ACTIVITY\".\"POS\" as \"CODE\", \"TIMECARD_ACTIVITY\".\"DESCRIPTION\" as \"DESCRIPTION\" FROM \"ESTART_ACTIVITY_CODE_VW\" \"TIMECARD_ACTIVITY\" ";
	private String selectFromStatementTableName = " FROM \"CONVERGYS\".\"ESTART_ACTIVITY_CODE_VW\" \"TIMECARD_ACTIVITY\"";
	private String whereClause = " WHERE \"TIMECARD_ACTIVITY\".\"ID\"=?";
	private String whereInClause = " join table(sys.dbms_debug_vc2coll(?)) SQLLIST on \"TIMECARD_ACTIVITY\".\"ID\"= SQLLIST.column_value";
	private String orderByTableName = " ORDER BY \"TIMECARD_ACTIVITY\".\"ID\"";
	
	

	
	@Override
	protected String getConnectionFactoryName() {
		return TimecardActivityDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT \"TIMECARD_ACTIVITY\".CENTRE || \"TIMECARD_ACTIVITY\".POS as \"ID\" " + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectStarSQL() {
		return SQL_VIEW   + whereClause;
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT \"TIMECARD_ACTIVITY\".CENTRE || \"TIMECARD_ACTIVITY\".POS as \"ID\" " + selectFromStatementTableName +  orderByTableName;
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT \"TIMECARD_ACTIVITY\".CENTRE || \"TIMECARD_ACTIVITY\".POS as \"ID\" " + selectFromStatementTableName  +  orderByTableName  + " LIMIT ? OFFSET ?";
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
		return "SELECT \"TIMECARD_ACTIVITY\".CENTRE || \"TIMECARD_ACTIVITY\".POS as \"ID\" " + selectFromStatementTableName +  whereInClause;
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		
		return SQL_VIEW + "  \"TIMECARD_ACTIVITY\"." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) 
	{
		
		
		return "SELECT \"TIMECARD_ACTIVITY\".CENTRE || \"TIMECARD_ACTIVITY\".POS as \"ID\" " + selectFromStatementTableName + " WHERE \"TIMECARD_ACTIVITY\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT \"TIMECARD_ACTIVITY\".CENTRE || \"TIMECARD_ACTIVITY\".POS as \"ID\" " + selectFromStatementTableName;
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return SQL_VIEW;
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "";//"INSERT INTO TIMECARD_ACTIVITY (ID) VALUES (?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "";//"UPDATE TIMECARD_ACTIVITY SET  WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() 
	{
		return "";//"DELETE FROM TIMECARD_ACTIVITY WHERE ID=?";
	}
	
	@Override
	protected TimecardActivity extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	TimecardActivity nextResult = new TimecardActivity();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setNonBillable(rs.getBoolean("NON_BILLABLE"));

nextResult.setCode(rs.getString("CODE"));

nextResult.setDescription(rs.getString("DESCRIPTION"));

nextResult.setName(rs.getString("NAME"));


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(TimecardActivity perceroObject, PreparedStatement pstmt) throws SQLException {
		
		
		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(TimecardActivity perceroObject, PreparedStatement pstmt) throws SQLException {
		
	
		
	}

	@Override
	public List<TimecardActivity> findByExample(TimecardActivity theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useNonBillable = theQueryObject.getNonBillable() != null && (excludeProperties == null || !excludeProperties.contains("nonBillable"));

if (useNonBillable)
{
sql += " WHERE ";
sql += " NON_BILLABLE=? ";
paramValues.add(theQueryObject.getNonBillable());
propertyCounter++;
}

boolean useCode = StringUtils.hasText(theQueryObject.getCode()) && (excludeProperties == null || !excludeProperties.contains("code"));

if (useCode)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " CODE=? ";
paramValues.add(theQueryObject.getCode());
propertyCounter++;
}

boolean useDescription = StringUtils.hasText(theQueryObject.getDescription()) && (excludeProperties == null || !excludeProperties.contains("description"));

if (useDescription)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " DESCRIPTION=? ";
paramValues.add(theQueryObject.getDescription());
propertyCounter++;
}

boolean useName = StringUtils.hasText(theQueryObject.getName()) && (excludeProperties == null || !excludeProperties.contains("name"));

if (useName)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " NAME=? ";
paramValues.add(theQueryObject.getName());
propertyCounter++;
}


		
		
		return executeSelectWithParams(sql, paramValues.toArray(), shellOnly);		
	}
	
}
