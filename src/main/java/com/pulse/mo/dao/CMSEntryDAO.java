
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
import com.pulse.mo.CMSEntry;
import com.pulse.mo.CMSAuxMode;
import com.pulse.mo.Agent;

*/

@Component
public class CMSEntryDAO extends SqlDataAccessObject<CMSEntry> implements IDataAccessObject<CMSEntry> {

	static final Logger log = Logger.getLogger(CMSEntryDAO.class);

	
	public CMSEntryDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(CMSEntry.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "cms";
	
	//TODO:For use refactoring, so we set it once
	public static final String SQL_VIEW = "SELECT  \"CMS_ENTRY\".\"ID\" as \"ID\", '' as \"ESTART_PROJECT_NAME\", \"CMS_ENTRY\".\"START_TIME\" as \"FROM_TIME\", \"CMS_ENTRY\".\"EVENT_DURATION\" as \"DURATION\", \"CMS_ENTRY\".\"END_TIME\" as \"TO_TIME\", \"CMS_ENTRY\".\"AUXREASON\" as \"CMS_AUX_MODE_ID\", '' as \"AGENT_ID\" FROM \"MOB_CMS_DATA_VW\" \"CMS_ENTRY\" ";
	
	@Override
	protected String getConnectionFactoryName() {
		return CMSEntryDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT \"CMS_ENTRY\".\"ID\" as \"ID\" FROM \"PULSE\".\"MOB_CMS_DATA_VW\" \"CMS_ENTRY\" WHERE \"CMS_ENTRY\".\"ID\"=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return SQL_VIEW + " where \"CMS_ENTRY\".ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT \"CMS_ENTRY\".\"ID\" as \"ID\" FROM \"PULSE\".\"MOB_CMS_DATA_VW\" \"CMS_ENTRY\" ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT \"CMS_ENTRY\".\"ID\" as \"ID\" FROM \"PULSE\".\"MOB_CMS_DATA_VW\" \"CMS_ENTRY\" ORDER BY \"CMS_ENTRY\".ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return SQL_VIEW + " ORDER BY \"CMS_ENTRY\".ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return SQL_VIEW + " ORDER BY \"CMS_ENTRY\".ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM \"PULSE\".\"MOB_CMS_DATA_VW\" \"CMS_ENTRY\"";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return SQL_VIEW + " where \"CMS_ENTRY\".ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT \"CMS_ENTRY\".\"ID\" as \"ID\" FROM \"PULSE\".\"MOB_CMS_DATA_VW\" \"CMS_ENTRY\" WHERE \"CMS_ENTRY\".ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return SQL_VIEW + "  \"CMS_ENTRY\"." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT \"CMS_ENTRY\".\"ID\" as \"ID\" FROM \"PULSE\".\"MOB_CMS_DATA_VW\" \"CMS_ENTRY\" WHERE \"CMS_ENTRY\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT \"CMS_ENTRY\".\"ID\" as \"ID\" FROM \"PULSE\".\"MOB_CMS_DATA_VW\" \"CMS_ENTRY\" ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return SQL_VIEW;
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "";//"INSERT INTO CMS_ENTRY (ID) VALUES (?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "";//"UPDATE CMS_ENTRY SET  WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() 
	{
		return "";//"DELETE FROM CMS_ENTRY WHERE ID=?";
	}
	
	@Override
	protected CMSEntry extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	CMSEntry nextResult = new CMSEntry();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setToTime(rs.getString("TO_TIME"));

nextResult.setDuration(rs.getDouble("DURATION"));

nextResult.setEStartProjectName(rs.getString("ESTART_PROJECT_NAME"));

nextResult.setFromTime(rs.getDate("FROM_TIME"));

Agent agent = new Agent();
agent.setID(rs.getString("AGENT_ID"));
nextResult.setAgent(agent);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(CMSEntry perceroObject, PreparedStatement pstmt) throws SQLException {
		
		
		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(CMSEntry perceroObject, PreparedStatement pstmt) throws SQLException {
		
	
		
	}

	@Override
	public List<CMSEntry> findByExample(CMSEntry theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useToTime = StringUtils.hasText(theQueryObject.getToTime()) && (excludeProperties == null || !excludeProperties.contains("toTime"));

if (useToTime)
{
sql += " WHERE ";
sql += " TO_TIME=? ";
paramValues.add(theQueryObject.getToTime());
propertyCounter++;
}

boolean useDuration = theQueryObject.getDuration() != null && (excludeProperties == null || !excludeProperties.contains("duration"));

if (useDuration)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " DURATION=? ";
paramValues.add(theQueryObject.getDuration());
propertyCounter++;
}

boolean useEStartProjectName = StringUtils.hasText(theQueryObject.getEStartProjectName()) && (excludeProperties == null || !excludeProperties.contains("eStartProjectName"));

if (useEStartProjectName)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " ESTART_PROJECT_NAME=? ";
paramValues.add(theQueryObject.getEStartProjectName());
propertyCounter++;
}

boolean useFromTime = theQueryObject.getFromTime() != null && (excludeProperties == null || !excludeProperties.contains("fromTime"));

if (useFromTime)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " FROM_TIME=? ";
paramValues.add(theQueryObject.getFromTime());
propertyCounter++;
}

boolean useAgentID = theQueryObject.getAgent() != null && (excludeProperties == null || !excludeProperties.contains("agent"));

if (useAgentID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " AGENT_ID=? ";
paramValues.add(theQueryObject.getAgent().getID());
propertyCounter++;
}


		
		
		return executeSelectWithParams(sql, paramValues.toArray(), shellOnly);		
	}
	
}
