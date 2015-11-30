

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
import com.percero.agents.sync.metadata.MappedClass;
import com.percero.agents.sync.dao.DAORegistry;
import com.percero.agents.sync.dao.IDataAccessObject;
import com.percero.agents.sync.exceptions.SyncException;
import com.percero.agents.sync.vo.BaseDataObject;
import java.sql.Connection;
import java.sql.Statement;
import com.pulse.dataprovider.IConnectionFactory;
import com.percero.agents.sync.exceptions.SyncDataException;
import com.pulse.mo.*;

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
	public static final String SQL_VIEW = "SELECT  \"LOB\".\"ID\" as \"ID\", \"LOB\".\"NAME\" as \"NAME\", '' as \"CLIENT_SITE_ID\", \"LOB\".\"CLIENT_ID\" as \"CLIENT_ID\", '' as \"PULSE_CONFIGURATION_ID\" FROM \"PULSE\".\"MOB_LOB_SITE_VW\" \"LOB\" ";
	private String selectFromStatementTableName = " FROM \"PULSE\".\"MOB_LOB_SITE_VW\" \"LOB\"";
	private String whereClause = " WHERE \"LOB\".\"ID\"=?";
	private String whereInClause = " join table(sys.dbms_debug_vc2coll(?)) SQLLIST on \"LOB\".\"ID\"= SQLLIST.column_value";
	private String orderByTableName = " ORDER BY \"LOB\".\"ID\"";

	@Override
	protected String getConnectionFactoryName() {
		return LOBDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT \"LOB\".\"ID\" as \"ID\" " + selectFromStatementTableName + whereClause;
	}

	@Override
	protected String getSelectStarSQL() {
		return SQL_VIEW   + whereClause;
	}

	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT \"LOB\".\"ID\" as \"ID\" " + selectFromStatementTableName +  orderByTableName;
	}

	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT \"LOB\".\"ID\" as \"ID\" " + selectFromStatementTableName  +  orderByTableName  + " LIMIT ? OFFSET ?";
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
		return "SELECT \"LOB\".\"ID\" as \"ID\" " + selectFromStatementTableName +  whereInClause;
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		
		return SQL_VIEW + "  \"LOB\"." + joinColumnName + "=?";
	}

	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) 
	{
		

		return "SELECT \"LOB\".\"ID\" as \"ID\" " + selectFromStatementTableName + " WHERE \"LOB\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT \"LOB\".\"ID\" as \"ID\" " + selectFromStatementTableName;
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

		

LOB nextResult = null;
    	
		    	
    	if (nextResult == null) {
    		nextResult = new LOB();
    	}


		// ID
		nextResult.setID(rs.getString("ID"));

		if (!shellOnly) 
		{
			nextResult.setName(rs.getString("NAME"));


String clientID = rs.getString("CLIENT_ID");
if (StringUtils.hasText(clientID) && !"null".equalsIgnoreCase(clientID) ){
Client client = new Client();
client.setID(clientID);
nextResult.setClient(client);
}


String clientsiteID = rs.getString("CLIENT_SITE_ID");
if (StringUtils.hasText(clientsiteID) && !"null".equalsIgnoreCase(clientsiteID) ){
ClientSite clientsite = new ClientSite();
clientsite.setID(clientsiteID);
nextResult.setClientSite(clientsite);
}


String pulseconfigurationID = rs.getString("PULSE_CONFIGURATION_ID");
if (StringUtils.hasText(pulseconfigurationID) && !"null".equalsIgnoreCase(pulseconfigurationID) ){
PulseConfiguration pulseconfiguration = new PulseConfiguration();
pulseconfiguration.setID(pulseconfigurationID);
nextResult.setPulseConfiguration(pulseconfiguration);
}




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

boolean useClientSiteID = theQueryObject.getClientSite() != null && (excludeProperties == null || !excludeProperties.contains("clientSite"));

if (useClientSiteID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " CLIENT_SITE_ID=? ";
paramValues.add(theQueryObject.getClientSite().getID());
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

	

public LOB createObject(LOB perceroObject, String userId)
		throws SyncException {
	if ( !hasCreateAccess(BaseDataObject.toClassIdPair(perceroObject), userId) ) {
		return null;
	}

	long timeStart = System.currentTimeMillis();

	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	String query = "Select MOB_LOB_SITE_VW_SEQ.NEXTVAL from dual";
	String sql = null;
	String insertedId = "0";
	int result = 0;
	try {
		IConnectionFactory connectionFactory = getConnectionRegistry().getConnectionFactory(getConnectionFactoryName());
		conn = connectionFactory.getConnection();
		conn.setAutoCommit(false);
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			insertedId = rs.getString(1);
		}

		perceroObject.setID(insertedId);
		sql = getInsertIntoSQL();
		pstmt = conn.prepareStatement(sql);


		setPreparedStatmentInsertParams(perceroObject, pstmt);
		result = pstmt.executeUpdate();
		conn.commit();
	} catch(Exception e) {
		log.error("Unable to executeUpdate\n" + sql, e);
		throw new SyncDataException(e);
	} finally {
		try {
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.setAutoCommit(true);
				conn.close();
			}
		} catch (Exception e) {
			log.error("Error closing database statement/connection", e);
		}
	}

	long timeEnd = System.currentTimeMillis();
	long totalTime = timeEnd - timeStart;
	if (totalTime > LONG_RUNNING_QUERY_TIME) {
		log.warn("LONG RUNNING QUERY: " + totalTime + "ms\n" + sql);
	}

	if (result > 0) {
		return retrieveObject(BaseDataObject.toClassIdPair(perceroObject), userId, false);
	}
	else {
		return null;
	}
}




}

