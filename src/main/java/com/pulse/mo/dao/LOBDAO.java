
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
import com.pulse.mo.LOB;
import com.pulse.mo.LOBConfiguration;
import com.pulse.mo.PulseConfiguration;
import com.pulse.mo.Client;

*/

@Component
public class LOBDAO extends SqlDataAccessObject<LOB> implements IDataAccessObject<LOB> {

	static final Logger log = Logger.getLogger(LOBDAO.class);

	
	public LOBDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(LOB.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "cms";
	
	//TODO:For use refactoring, so we set it once
	public static final String SQL_VIEW = "SELECT  \"LOB\".\"ID\" as \"ID\", \"LOB\".\"NAME\" as \"NAME\", '' as \"PULSE_CONFIGURATION_ID\", \"LOB\".\"CLIENT_ID\" as \"CLIENT_ID\" FROM \"MOB_LOB_SITE_VW\" \"LOB\" ";
	

	
	@Override
	protected String getConnectionFactoryName() {
		return LOBDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT \"LOB\".\"ID\" as \"ID\" FROM \"PULSE\".\"MOB_LOB_SITE_VW\" \"LOB\" WHERE \"LOB\".\"ID\"=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return SQL_VIEW + " where \"LOB\".ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT \"LOB\".\"ID\" as \"ID\" FROM \"PULSE\".\"MOB_LOB_SITE_VW\" \"LOB\" ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT \"LOB\".\"ID\" as \"ID\" FROM \"PULSE\".\"MOB_LOB_SITE_VW\" \"LOB\" ORDER BY \"LOB\".ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return SQL_VIEW + " ORDER BY \"LOB\".ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return SQL_VIEW + " ORDER BY \"LOB\".ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM \"PULSE\".\"MOB_LOB_SITE_VW\" \"LOB\"";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return SQL_VIEW + " where \"LOB\".ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT \"LOB\".\"ID\" as \"ID\" FROM \"PULSE\".\"MOB_LOB_SITE_VW\" \"LOB\" WHERE \"LOB\".ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return SQL_VIEW + "  \"LOB\"." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT \"LOB\".\"ID\" as \"ID\" FROM \"PULSE\".\"MOB_LOB_SITE_VW\" \"LOB\" WHERE \"LOB\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT \"LOB\".\"ID\" as \"ID\" FROM \"PULSE\".\"MOB_LOB_SITE_VW\" \"LOB\" ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return SQL_VIEW;
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "";//"INSERT INTO LOB (ID) VALUES (?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "";//"UPDATE LOB SET  WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() 
	{
		return "";//"DELETE FROM LOB WHERE ID=?";
	}
	
	@Override
	protected LOB extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	LOB nextResult = new LOB();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setName(rs.getString("NAME"));

PulseConfiguration pulseconfiguration = new PulseConfiguration();
pulseconfiguration.setID(rs.getString("PULSE_CONFIGURATION_ID"));
nextResult.setPulseConfiguration(pulseconfiguration);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(LOB perceroObject, PreparedStatement pstmt) throws SQLException {
		
		
		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(LOB perceroObject, PreparedStatement pstmt) throws SQLException {
		
	
		
	}

	@Override
	public List<LOB> findByExample(LOB theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useName = StringUtils.hasText(theQueryObject.getName()) && (excludeProperties == null || !excludeProperties.contains("name"));

if (useName)
{
sql += " WHERE ";
sql += " NAME=? ";
paramValues.add(theQueryObject.getName());
propertyCounter++;
}

boolean usePulseConfigurationID = theQueryObject.getPulseConfiguration() != null && (excludeProperties == null || !excludeProperties.contains("pulseConfiguration"));

if (usePulseConfigurationID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " PULSE_CONFIGURATION_ID=? ";
paramValues.add(theQueryObject.getPulseConfiguration().getID());
propertyCounter++;
}


		
		
		return executeSelectWithParams(sql, paramValues.toArray(), shellOnly);		
	}
	
}
