
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
import com.pulse.mo.LOBConfiguration;
import com.pulse.mo.LOBConfigurationEntry;
import com.pulse.mo.LOBConfigurationNotification;
import com.pulse.mo.LOB;

*/

@Component
public class LOBConfigurationDAO extends SqlDataAccessObject<LOBConfiguration> implements IDataAccessObject<LOBConfiguration> {

	static final Logger log = Logger.getLogger(LOBConfigurationDAO.class);

	
	public LOBConfigurationDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(LOBConfiguration.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	
	public static final String SQL_VIEW = "";
	private String selectFromStatementTableName = " FROM \"LOB_CONFIGURATION\" \"LOB_CONFIGURATION\"";
	private String whereClause = "  WHERE \"LOB_CONFIGURATION\".\"ID\"=?";
	private String whereInClause = "  join table(sys.dbms_debug_vc2coll(?)) SQLLIST on \"LOB_CONFIGURATION\".\"ID\"= SQLLIST.column_value";
	private String orderByTableName = "  ORDER BY \"LOB_CONFIGURATION\".\"ID\"";
	
	

	
	@Override
	protected String getConnectionFactoryName() {
		return LOBConfigurationDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT \"LOB_CONFIGURATION\".\"ID\" " + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT \"LOB_CONFIGURATION\".\"ID\"" + SQL_VIEW  + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT \"LOB_CONFIGURATION\".\"ID\" " + selectFromStatementTableName +  orderByTableName;
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT \"LOB_CONFIGURATION\".\"ID\" " + selectFromStatementTableName  +  orderByTableName  + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT \"LOB_CONFIGURATION\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName  + orderByTableName;
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT \"LOB_CONFIGURATION\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + orderByTableName + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() 
	{
		return "SELECT COUNT(ID) " + selectFromStatementTableName;
	}
	
	@Override
	protected String getSelectInStarSQL() 
	{
		return "SELECT \"LOB_CONFIGURATION\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + whereInClause;
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT \"LOB_CONFIGURATION\".\"ID\" " + selectFromStatementTableName + whereInClause;
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		
		return "SELECT \"LOB_CONFIGURATION\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + " WHERE \"LOB_CONFIGURATION\"." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) 
	{
		
		return "SELECT \"LOB_CONFIGURATION\".\"ID\" " + selectFromStatementTableName + " WHERE \"LOB_CONFIGURATION\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT \"LOB_CONFIGURATION\".\"ID\" " + selectFromStatementTableName;
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT \"LOB_CONFIGURATION\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName;
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO LOB_CONFIGURATION (\"ID\") VALUES (?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE \"TBL_LOB_CONFIGURATION\" SET  WHERE \"ID\"=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM \"TBL_LOB_CONFIGURATION\" WHERE \"ID\"=?";
	}
	
	@Override
	protected LOBConfiguration extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	LOBConfiguration nextResult = new LOBConfiguration();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			
			
    	}
    	
    	return nextResult;
	}
	
	protected void setBaseStatmentInsertParams(LOBConfiguration perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());

		
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(LOBConfiguration perceroObject, PreparedStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
		
	}
	
	@Override
	protected void setCallableStatmentInsertParams(LOBConfiguration perceroObject, CallableStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	

	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(LOBConfiguration perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());

		
	}
	
	
	@Override
	protected void setCallableStatmentUpdateParams(LOBConfiguration perceroObject, CallableStatement pstmt) throws SQLException 
	{
		
		//must be in same order as insert
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	}
	
	

	@Override
	public List<LOBConfiguration> findByExample(LOBConfiguration theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		
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
		return "{call UPDATE_LOB_CONFIGURATION(?)}";
	}
	@Override
	protected String getInsertCallableStatementSql() {
		return "{call CREATE_LOB_CONFIGURATION(?)}";
	}
	@Override
	protected String getDeleteCallableStatementSql() {
		return "{call Delete_LOB_CONFIGURATION(?)}";
	}
	
	
	
	
}
