
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
import com.pulse.mo.Client;
import com.pulse.mo.PulseConfiguration;

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
	public static final String CONNECTION_FACTORY_NAME = "default";
	@Override
	protected String getConnectionFactoryName() {
		return LOBDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT LOB.ID FROM LOB LOB WHERE LOB.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT LOB.ID,LOB.NAME,LOB.CLIENT_ID,LOB.PULSE_CONFIGURATION_ID FROM LOB LOB WHERE LOB.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT LOB.ID FROM LOB LOB ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT LOB.ID FROM LOB LOB ORDER BY LOB.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT LOB.ID,LOB.NAME,LOB.CLIENT_ID,LOB.PULSE_CONFIGURATION_ID FROM LOB LOB ORDER BY LOB.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT LOB.ID,LOB.NAME,LOB.CLIENT_ID,LOB.PULSE_CONFIGURATION_ID FROM LOB LOB ORDER BY LOB.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM LOB LOB";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT LOB.ID,LOB.NAME,LOB.CLIENT_ID,LOB.PULSE_CONFIGURATION_ID FROM LOB LOB WHERE LOB.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT LOB.ID FROM LOB LOB WHERE LOB.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT LOB.ID,LOB.NAME,LOB.CLIENT_ID,LOB.PULSE_CONFIGURATION_ID FROM LOB LOB WHERE LOB." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT LOB.ID FROM LOB LOB WHERE LOB." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT LOB.ID FROM LOB LOB ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT LOB.ID,LOB.NAME,LOB.CLIENT_ID,LOB.PULSE_CONFIGURATION_ID FROM LOB LOB ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO LOB (ID,NAME,CLIENT_ID,PULSE_CONFIGURATION_ID) VALUES (?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE LOB SET NAME=?,CLIENT_ID,PULSE_CONFIGURATION_ID WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM LOB WHERE ID=?";
	}
	
	@Override
	protected LOB extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	LOB nextResult = new LOB();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setName(rs.getString("NAME"));

Client client = new Client();
client.setID(rs.getString("CLIENT_ID"));
nextResult.setClient(client);

PulseConfiguration pulseconfiguration = new PulseConfiguration();
pulseconfiguration.setID(rs.getString("PULSE_CONFIGURATION_ID"));
nextResult.setPulseConfiguration(pulseconfiguration);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(LOB perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getName());

if (perceroObject.getClient() == null)
{
pstmt.setString(3, null);
}
else
{
		pstmt.setString(3, perceroObject.getClient().getID());
}


if (perceroObject.getPulseConfiguration() == null)
{
pstmt.setString(4, null);
}
else
{
		pstmt.setString(4, perceroObject.getPulseConfiguration().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(LOB perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getName());

if (perceroObject.getClient() == null)
{
pstmt.setString(2, null);
}
else
{
		pstmt.setString(2, perceroObject.getClient().getID());
}


if (perceroObject.getPulseConfiguration() == null)
{
pstmt.setString(3, null);
}
else
{
		pstmt.setString(3, perceroObject.getPulseConfiguration().getID());
}

pstmt.setString(4, perceroObject.getID());

		
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

boolean useClientID = theQueryObject.getClient() != null && (excludeProperties == null || !excludeProperties.contains("client"));

if (useClientID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " CLIENT_ID=? ";
paramValues.add(theQueryObject.getClient().getID());
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
