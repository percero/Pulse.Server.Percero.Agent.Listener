
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
import com.pulse.mo.Client;
import com.pulse.mo.LOB;
import com.pulse.mo.Site;

*/

@Component
public class ClientDAO extends SqlDataAccessObject<Client> implements IDataAccessObject<Client> {

	static final Logger log = Logger.getLogger(ClientDAO.class);

	
	public ClientDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(Client.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	@Override
	protected String getConnectionFactoryName() {
		return ClientDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT CLIENT.ID FROM CLIENT CLIENT WHERE CLIENT.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT CLIENT.ID,CLIENT.NAME,CLIENT.SITE_ID FROM CLIENT CLIENT WHERE CLIENT.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT CLIENT.ID FROM CLIENT CLIENT ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT CLIENT.ID FROM CLIENT CLIENT ORDER BY CLIENT.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT CLIENT.ID,CLIENT.NAME,CLIENT.SITE_ID FROM CLIENT CLIENT ORDER BY CLIENT.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT CLIENT.ID,CLIENT.NAME,CLIENT.SITE_ID FROM CLIENT CLIENT ORDER BY CLIENT.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM CLIENT CLIENT";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT CLIENT.ID,CLIENT.NAME,CLIENT.SITE_ID FROM CLIENT CLIENT WHERE CLIENT.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT CLIENT.ID FROM CLIENT CLIENT WHERE CLIENT.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT CLIENT.ID,CLIENT.NAME,CLIENT.SITE_ID FROM CLIENT CLIENT WHERE CLIENT." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT CLIENT.ID FROM CLIENT CLIENT WHERE CLIENT." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT CLIENT.ID FROM CLIENT CLIENT ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT CLIENT.ID,CLIENT.NAME,CLIENT.SITE_ID FROM CLIENT CLIENT ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO CLIENT (ID,NAME,SITE_ID) VALUES (?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE CLIENT SET NAME=?,SITE_ID WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM CLIENT WHERE ID=?";
	}
	
	@Override
	protected Client extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	Client nextResult = new Client();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setName(rs.getString("NAME"));

Site site = new Site();
site.setID(rs.getString("SITE_ID"));
nextResult.setSite(site);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(Client perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getName());

if (perceroObject.getSite() == null)
{
pstmt.setString(3, null);
}
else
{
		pstmt.setString(3, perceroObject.getSite().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(Client perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getName());

if (perceroObject.getSite() == null)
{
pstmt.setString(2, null);
}
else
{
		pstmt.setString(2, perceroObject.getSite().getID());
}

pstmt.setString(3, perceroObject.getID());

		
	}

	@Override
	public List<Client> findByExample(Client theQueryObject,
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

boolean useSiteID = theQueryObject.getSite() != null && (excludeProperties == null || !excludeProperties.contains("site"));

if (useSiteID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " SITE_ID=? ";
paramValues.add(theQueryObject.getSite().getID());
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
