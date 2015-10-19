
package com.pulse.mo.dao;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.percero.agents.sync.exceptions.SyncDataException;
import com.percero.util.DateUtils;
import com.pulse.dataprovider.IConnectionFactory;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.percero.agents.sync.dao.DAORegistry;
import com.percero.agents.sync.dao.IDataAccessObject;
import com.percero.agents.sync.exceptions.SyncException;

import com.pulse.mo.*;


@Component
public class PulseConfigurationDAO extends SqlDataAccessObject<PulseConfiguration> implements IDataAccessObject<PulseConfiguration> {

	static final Logger log = Logger.getLogger(PulseConfigurationDAO.class);

	
	public PulseConfigurationDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(PulseConfiguration.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	
	public static final String SQL_VIEW = ",\"PULSE_CONFIGURATION\".\"DURATION_TOLERANCE\"";
	private String selectFromStatementTableName = " FROM \"PULSE_CONFIGURATION\" \"PULSE_CONFIGURATION\"";
	private String whereClause = "  WHERE \"PULSE_CONFIGURATION\".\"ID\"=?";
	private String whereInClause = "  join table(sys.dbms_debug_vc2coll(?)) SQLLIST on \"PULSE_CONFIGURATION\".\"ID\"= SQLLIST.column_value";
	private String orderByTableName = "  ORDER BY \"PULSE_CONFIGURATION\".\"ID\"";
	
	

	
	@Override
	protected String getConnectionFactoryName() {
		return PulseConfigurationDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT \"PULSE_CONFIGURATION\".\"ID\" " + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT \"PULSE_CONFIGURATION\".\"ID\"" + SQL_VIEW  + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT \"PULSE_CONFIGURATION\".\"ID\" " + selectFromStatementTableName +  orderByTableName;
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT \"PULSE_CONFIGURATION\".\"ID\" " + selectFromStatementTableName  +  orderByTableName  + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT \"PULSE_CONFIGURATION\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName  + orderByTableName;
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT \"PULSE_CONFIGURATION\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + orderByTableName + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() 
	{
		return "SELECT COUNT(ID) " + selectFromStatementTableName;
	}
	
	@Override
	protected String getSelectInStarSQL() 
	{
		return "SELECT \"PULSE_CONFIGURATION\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + whereInClause;
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT \"PULSE_CONFIGURATION\".\"ID\" " + selectFromStatementTableName + whereInClause;
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		
		return "SELECT \"PULSE_CONFIGURATION\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + " WHERE \"PULSE_CONFIGURATION\"." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) 
	{
		
		return "SELECT \"PULSE_CONFIGURATION\".\"ID\" " + selectFromStatementTableName + " WHERE \"PULSE_CONFIGURATION\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT \"PULSE_CONFIGURATION\".\"ID\" " + selectFromStatementTableName;
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT \"PULSE_CONFIGURATION\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName;
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO TBL_PULSE_CONFIGURATION (\"ID\",\"DURATION_TOLERANCE\") VALUES (?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE TBL_PULSE_CONFIGURATION SET \"DURATION_TOLERANCE\"=? WHERE \"ID\"=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM TBL_PULSE_CONFIGURATION WHERE \"ID\"=?";
	}
	
	@Override
	protected PulseConfiguration extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	PulseConfiguration nextResult = new PulseConfiguration();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setDurationTolerance(rs.getInt("DURATION_TOLERANCE"));


			
    	}
    	
    	return nextResult;
	}
	
	protected void setBaseStatmentInsertParams(PulseConfiguration perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
JdbcHelper.setInt(pstmt,2, perceroObject.getDurationTolerance());

		
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(PulseConfiguration perceroObject, PreparedStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
		
	}
	
	@Override
	protected void setCallableStatmentInsertParams(PulseConfiguration perceroObject, CallableStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	

	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(PulseConfiguration perceroObject, PreparedStatement pstmt) throws SQLException {
		
		JdbcHelper.setInt(pstmt,1, perceroObject.getDurationTolerance());
pstmt.setString(2, perceroObject.getID());

		
	}
	
	
	@Override
	protected void setCallableStatmentUpdateParams(PulseConfiguration perceroObject, CallableStatement pstmt) throws SQLException 
	{
		
		//must be in same order as insert
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	}
	
	

	@Override
	public List<PulseConfiguration> findByExample(PulseConfiguration theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useDurationTolerance = theQueryObject.getDurationTolerance() != null && (excludeProperties == null || !excludeProperties.contains("durationTolerance"));

if (useDurationTolerance)
{
sql += " WHERE ";
sql += " \"DURATION_TOLERANCE\" =? ";
paramValues.add(theQueryObject.getDurationTolerance());
propertyCounter++;
}



		if (propertyCounter == 0) {
			throw new SyncException(SyncException.METHOD_UNSUPPORTED, SyncException.METHOD_UNSUPPORTED_CODE);
		}
		
		return executeSelectWithParams(sql, paramValues.toArray(), shellOnly);		
	}
	
	@Override
	protected String getUpdateCallableStatementSql() {
		return "{call UPDATE_PULSE_CONFIGURATION(?,?)}";
	}
	@Override
	protected String getInsertCallableStatementSql() {
		return "{call CREATE_PULSE_CONFIGURATION(?,?)}";
	}
	@Override
	protected String getDeleteCallableStatementSql() {
		return "{call Delete_PULSE_CONFIGURATION(?)}";
	}
	
	
	
	
}
