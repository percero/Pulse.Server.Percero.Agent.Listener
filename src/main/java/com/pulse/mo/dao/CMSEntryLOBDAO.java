
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
public class CMSEntryLOBDAO extends SqlDataAccessObject<CMSEntryLOB> implements IDataAccessObject<CMSEntryLOB> {

	static final Logger log = Logger.getLogger(CMSEntryLOBDAO.class);


	public CMSEntryLOBDAO() {
		super();

		DAORegistry.getInstance().registerDataAccessObject(CMSEntryLOB.class.getCanonicalName(), this);
	}


	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
	//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "cms";

	//TODO:For use refactoring, so we set it once
	public static final String SQL_VIEW = "SELECT  AGENT_LOB.ECP_LOB_ID as \"ID\", CLIENT_SITE.SITE_ID as \"SITE_ID\", CMS_ENTRY.EMPLOYEEID as \"EMPLOYEE_ID\", AGENT_LOB_SITE.SITE_DESCR as \"SITE_NAME\", AGENT_LOB_SITE.CLIENT_DESCR as \"LOB_NAME\", AGENT_LOB_SITE.CLIENT_DESCR as \"CLIENT_NAME\", AGENT_LOB_SITE.CLIENT_ID as \"CLIENT_ID\", CMS_ENTRY.ID as \"CMS_ENTRY_ID\", AGENT_LOB_SITE.ECP_LOB_ID as \"LOB_ID\" FROM \"MOB_CMS_DATA_VW\" \"CMS_ENTRY_LOB\" ";
	private String selectFromStatementTableName = " FROM \"PULSE\".\"MOB_CMS_DATA_VW\" \"CMS_ENTRY_LOB\"";
	private String whereClause = "Join PULSE.MOB_EMP_LOB_VW AGENT_LOB On AGENT_LOB.EMPLOYEE_ID = CMS_ENTRY.EMPLOYEE_ID Join PULSE.MOB_CLIENT_SITE_VW CLIENT_SITE On CLIENT_SITE.ID =AGENT_LOB.CLIENT_ID Join PULSE.MOB_LOB_SITE_CLIENT_VW AGENT_LOB_SITE On AGENT_LOB_SITE.CLIENT_ID =AGENT_LOB.CLIENT_ID And AGENT_LOB_SITE.SITE_ID =CLIENT_SITE.SITE_ID WHERE AGENT_LOB.ECP_LOB_ID=?";
	private String whereInClause = "Join PULSE.MOB_EMP_LOB_VW AGENT_LOB On AGENT_LOB.EMPLOYEE_ID = CMS_ENTRY.EMPLOYEE_ID Join PULSE.MOB_CLIENT_SITE_VW CLIENT_SITE On CLIENT_SITE.ID =AGENT_LOB.CLIENT_ID Join PULSE.MOB_LOB_SITE_CLIENT_VW AGENT_LOB_SITE On AGENT_LOB_SITE.CLIENT_ID =AGENT_LOB.CLIENT_ID And AGENT_LOB_SITE.SITE_ID =CLIENT_SITE.SITE_ID Join Table(sys.dbms_debug_vc2coll(?)) SQLLIST On AGENT_LOB.ECP_LOB_ID= SQLLIST.column_value";
	private String orderByTableName = "ORDER BY AGENT_LOB.ECP_LOB_ID";

	


	@Override
	protected String getConnectionFactoryName() {
		return CMSEntryLOBDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT AGENT_LOB.ECP_LOB_ID as \"ID\" " + selectFromStatementTableName + whereClause;
	}

	@Override
	protected String getSelectStarSQL() {
		return SQL_VIEW   + whereClause;
	}

	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT AGENT_LOB.ECP_LOB_ID as \"ID\" " + selectFromStatementTableName +  orderByTableName;
	}

	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT AGENT_LOB.ECP_LOB_ID as \"ID\" " + selectFromStatementTableName  +  orderByTableName  + " LIMIT ? OFFSET ?";
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
		return "SELECT AGENT_LOB.ECP_LOB_ID as \"ID\" " + selectFromStatementTableName +  whereInClause;
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		
		return SQL_VIEW + "  \"CMS_ENTRY_LOB\"." + joinColumnName + "=?";
	}

	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) 
	{
		

		return "SELECT AGENT_LOB.ECP_LOB_ID as \"ID\" " + selectFromStatementTableName + " Join PULSE.MOB_EMP_LOB_VW AGENT_LOB On AGENT_LOB.EMPLOYEE_ID = CMS_ENTRY.EMPLOYEE_ID Join PULSE.MOB_CLIENT_SITE_VW CLIENT_SITE On CLIENT_SITE.ID =AGENT_LOB.CLIENT_ID Join PULSE.MOB_LOB_SITE_CLIENT_VW AGENT_LOB_SITE On AGENT_LOB_SITE.CLIENT_ID =AGENT_LOB.CLIENT_ID And AGENT_LOB_SITE.SITE_ID =CLIENT_SITE.SITE_ID WHERE \"CMS_ENTRY_LOB\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT AGENT_LOB.ECP_LOB_ID as \"ID\" " + selectFromStatementTableName;
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return SQL_VIEW;
	}

	@Override
	protected String getInsertIntoSQL() {
		return "";//"INSERT INTO CMS_ENTRY_LOB (ID) VALUES (?)";
	}

	@Override
	protected String getUpdateSet() {
		return "";//"UPDATE CMS_ENTRY_LOB SET  WHERE ID=?";
	}

	@Override
	protected String getDeleteFromSQL() 
	{
		return "";//"DELETE FROM CMS_ENTRY_LOB WHERE ID=?";
	}

	@Override
	protected CMSEntryLOB extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {

		
CMSEntryLOB nextResult = null;
    	
		    	
    	if (nextResult == null) {
    		nextResult = new CMSEntryLOB();
    	}


		// ID
		nextResult.setID(rs.getString("ID"));

		if (!shellOnly) 
		{
			nextResult.setLOBName(rs.getString("LOB_NAME"));


nextResult.setSiteName(rs.getString("SITE_NAME"));


nextResult.setClientId(rs.getInt("CLIENT_ID"));


nextResult.setEmployeeId(rs.getInt("EMPLOYEE_ID"));


nextResult.setSiteId(rs.getInt("SITE_ID"));


nextResult.setClientName(rs.getString("CLIENT_NAME"));


CMSEntry cmsentry = new CMSEntry();
cmsentry.setID(rs.getString("CMS_ENTRY_ID"));
nextResult.setCMSEntry(cmsentry);


LOB lob = new LOB();
lob.setID(rs.getString("LOB_ID"));
nextResult.setLOB(lob);




		}

		return nextResult;
	}

	@Override
	protected void setPreparedStatmentInsertParams(CMSEntryLOB perceroObject, PreparedStatement pstmt) throws SQLException {



	}

	@Override
	protected void setPreparedStatmentUpdateParams(CMSEntryLOB perceroObject, PreparedStatement pstmt) throws SQLException {



	}

	@Override
	public List<CMSEntryLOB> findByExample(CMSEntryLOB theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
	{



		String sql = getFindByExampleSelectSql(shellOnly);

		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();

		boolean useLOBName = StringUtils.hasText(theQueryObject.getLOBName()) && (excludeProperties == null || !excludeProperties.contains("lOBName"));

if (useLOBName)
{
sql += " WHERE ";
sql += " LOB_NAME=? ";
paramValues.add(theQueryObject.getLOBName());
propertyCounter++;
}

boolean useSiteName = StringUtils.hasText(theQueryObject.getSiteName()) && (excludeProperties == null || !excludeProperties.contains("siteName"));

if (useSiteName)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " SITE_NAME=? ";
paramValues.add(theQueryObject.getSiteName());
propertyCounter++;
}

boolean useClientId = theQueryObject.getClientId() != null && (excludeProperties == null || !excludeProperties.contains("clientId"));

if (useClientId)
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
paramValues.add(theQueryObject.getClientId());
propertyCounter++;
}

boolean useEmployeeId = theQueryObject.getEmployeeId() != null && (excludeProperties == null || !excludeProperties.contains("employeeId"));

if (useEmployeeId)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " EMPLOYEE_ID=? ";
paramValues.add(theQueryObject.getEmployeeId());
propertyCounter++;
}

boolean useSiteId = theQueryObject.getSiteId() != null && (excludeProperties == null || !excludeProperties.contains("siteId"));

if (useSiteId)
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
paramValues.add(theQueryObject.getSiteId());
propertyCounter++;
}

boolean useClientName = StringUtils.hasText(theQueryObject.getClientName()) && (excludeProperties == null || !excludeProperties.contains("clientName"));

if (useClientName)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " CLIENT_NAME=? ";
paramValues.add(theQueryObject.getClientName());
propertyCounter++;
}

boolean useCMSEntryID = theQueryObject.getCMSEntry() != null && (excludeProperties == null || !excludeProperties.contains("cMSEntry"));

if (useCMSEntryID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " CMS_ENTRY_ID=? ";
paramValues.add(theQueryObject.getCMSEntry().getID());
propertyCounter++;
}

boolean useLOBID = theQueryObject.getLOB() != null && (excludeProperties == null || !excludeProperties.contains("lOB"));

if (useLOBID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " LOB_ID=? ";
paramValues.add(theQueryObject.getLOB().getID());
propertyCounter++;
}




		return executeSelectWithParams(sql, paramValues.toArray(), shellOnly);		
	}

	
public CMSEntryLOB createObject(CMSEntryLOB perceroObject, String userId)
		throws SyncException {
	if ( !hasCreateAccess(BaseDataObject.toClassIdPair(perceroObject), userId) ) {
		return null;
	}

	long timeStart = System.currentTimeMillis();

	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	String query = "Select MOB_CMS_DATA_VW_SEQ.NEXTVAL from dual";
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
