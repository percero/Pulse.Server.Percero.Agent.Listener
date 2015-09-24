
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
	public static final String CONNECTION_FACTORY_NAME = "default";
	@Override
	protected String getConnectionFactoryName() {
		return LOBDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT lob.ID FROM LOB lob WHERE lob.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT lob.ID,lob.name,lob.externalID,lob.pulseConfiguration_ID,lob.client_ID FROM LOB lob WHERE lob.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT lob.ID FROM LOB lob ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT lob.ID FROM LOB lob ORDER BY lob.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT lob.ID,lob.name,lob.externalID,lob.pulseConfiguration_ID,lob.client_ID FROM LOB lob ORDER BY lob.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT lob.ID,lob.name,lob.externalID,lob.pulseConfiguration_ID,lob.client_ID FROM LOB lob ORDER BY lob.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM LOB lob";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT lob.ID,lob.name,lob.externalID,lob.pulseConfiguration_ID,lob.client_ID FROM LOB lob WHERE lob.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT lob.ID FROM LOB lob WHERE lob.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT lob.ID,lob.name,lob.externalID,lob.pulseConfiguration_ID,lob.client_ID FROM LOB lob WHERE lob." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT lob.ID FROM LOB lob WHERE lob." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT lob.ID FROM LOB lob ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT lob.ID,lob.name,lob.externalID,lob.pulseConfiguration_ID,lob.client_ID FROM LOB lob ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO LOB (ID,name,externalID,pulseConfiguration_ID,client_ID) VALUES (?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE LOB SET name=?,externalID=?,pulseConfiguration_ID=?,client_ID=? WHERE ID=?";
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
			nextResult.setName(rs.getString("name"));

nextResult.setExternalID(rs.getString("externalID"));

PulseConfiguration pulseconfiguration = new PulseConfiguration();
pulseconfiguration.setID(rs.getString("pulseconfiguration_ID"));
nextResult.setPulseConfiguration(pulseconfiguration);

Client client = new Client();
client.setID(rs.getString("client_ID"));
nextResult.setClient(client);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(LOB perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getName());
pstmt.setString(3, perceroObject.getExternalID());

if (perceroObject.getPulseConfiguration() == null)
{
pstmt.setString(4, null);
}
else
{
		pstmt.setString(4, perceroObject.getPulseConfiguration().getID());
}


if (perceroObject.getClient() == null)
{
pstmt.setString(5, null);
}
else
{
		pstmt.setString(5, perceroObject.getClient().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(LOB perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getName());
pstmt.setString(2, perceroObject.getExternalID());

if (perceroObject.getPulseConfiguration() == null)
{
pstmt.setString(3, null);
}
else
{
		pstmt.setString(3, perceroObject.getPulseConfiguration().getID());
}


if (perceroObject.getClient() == null)
{
pstmt.setString(4, null);
}
else
{
		pstmt.setString(4, perceroObject.getClient().getID());
}

pstmt.setString(5, perceroObject.getID());

		
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
paramValues.add(theQueryObject.getName());
propertyCounter++;
}

boolean useExternalID = StringUtils.hasText(theQueryObject.getExternalID()) && (excludeProperties == null || !excludeProperties.contains("externalID"));

if (useExternalID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " externalID=? ";
paramValues.add(theQueryObject.getExternalID());
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
sql += " pulseConfigurationID=? ";
paramValues.add(theQueryObject.getPulseConfiguration().getID());
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
sql += " clientID=? ";
paramValues.add(theQueryObject.getClient().getID());
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
