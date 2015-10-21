
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
import com.pulse.mo.ClientSite;
import com.pulse.mo.LOB;
import com.pulse.mo.Client;
import com.pulse.mo.Site;

*/

@Component
public class ClientSiteDAO extends SqlDataAccessObject<ClientSite> implements IDataAccessObject<ClientSite> {

	static final Logger log = Logger.getLogger(ClientSiteDAO.class);

	
	public ClientSiteDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(ClientSite.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "cms";
	
	//TODO:For use refactoring, so we set it once
	public static final String SQL_VIEW = "SELECT  ID || '-' || SITEID as \"ID\", \"CLIENT_SITE\".\"SITE_ID\" as \"SITE_ID\", \"CLIENT_SITE\".\"ID\" as \"CLIENT_ID\" FROM \"MOB_CLIENT_SITE_VW\" \"CLIENT_SITE\" ";
	private String selectFromStatementTableName = " FROM \"PULSE\".\"MOB_CLIENT_SITE_VW\" \"CLIENT_SITE\"";
	private String whereClause = " WHERE \"CLIENT_SITE\".\"ID\"=?";
	private String whereInClause = " join table(sys.dbms_debug_vc2coll(?)) SQLLIST on \"CLIENT_SITE\".\"ID\"= SQLLIST.column_value";
	private String orderByTableName = " ORDER BY \"CLIENT_SITE\".\"ID\"";
	
	

	
	@Override
	protected String getConnectionFactoryName() {
		return ClientSiteDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT ID || '-' || SITEID as \"ID\" " + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectStarSQL() {
		return SQL_VIEW   + whereClause;
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT ID || '-' || SITEID as \"ID\" " + selectFromStatementTableName +  orderByTableName;
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT ID || '-' || SITEID as \"ID\" " + selectFromStatementTableName  +  orderByTableName  + " LIMIT ? OFFSET ?";
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
		return "SELECT ID || '-' || SITEID as \"ID\" " + selectFromStatementTableName +  whereInClause;
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		
		return SQL_VIEW + "  \"CLIENT_SITE\"." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) 
	{
		
		
		return "SELECT ID || '-' || SITEID as \"ID\" " + selectFromStatementTableName + " WHERE \"CLIENT_SITE\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT ID || '-' || SITEID as \"ID\" " + selectFromStatementTableName;
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return SQL_VIEW;
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "";//"INSERT INTO CLIENT_SITE (ID) VALUES (?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "";//"UPDATE CLIENT_SITE SET  WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() 
	{
		return "";//"DELETE FROM CLIENT_SITE WHERE ID=?";
	}
	
	@Override
	protected ClientSite extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	ClientSite nextResult = new ClientSite();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			Client client = new Client();
client.setID(rs.getString("CLIENT_ID"));
nextResult.setClient(client);

Site site = new Site();
site.setID(rs.getString("SITE_ID"));
nextResult.setSite(site);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(ClientSite perceroObject, PreparedStatement pstmt) throws SQLException {
		
		
		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(ClientSite perceroObject, PreparedStatement pstmt) throws SQLException {
		
	
		
	}

	@Override
	public List<ClientSite> findByExample(ClientSite theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useClientID = theQueryObject.getClient() != null && (excludeProperties == null || !excludeProperties.contains("client"));

if (useClientID)
{
sql += " WHERE ";
sql += " CLIENT_ID=? ";
paramValues.add(theQueryObject.getClient().getID());
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


		
		
		return executeSelectWithParams(sql, paramValues.toArray(), shellOnly);		
	}
	
}
