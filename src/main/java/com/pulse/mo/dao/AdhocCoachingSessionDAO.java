
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
import com.pulse.mo.AdhocCoachingSession;
import com.pulse.mo.CoachingComment;
import com.pulse.mo.AdhocCoachingCategory;
import com.pulse.mo.AgentScorecard;

*/

@Component
public class AdhocCoachingSessionDAO extends SqlDataAccessObject<AdhocCoachingSession> implements IDataAccessObject<AdhocCoachingSession> {

	static final Logger log = Logger.getLogger(AdhocCoachingSessionDAO.class);

	
	public AdhocCoachingSessionDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(AdhocCoachingSession.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	
	public static final String SQL_VIEW = ",\"ADHOC_COACHING_SESSION\".\"SESSION_TYPE\",\"ADHOC_COACHING_SESSION\".\"STATUS\",\"ADHOC_COACHING_SESSION\".\"WEEK_DATE\",\"ADHOC_COACHING_SESSION\".\"EMPLOYEE_ID\",\"ADHOC_COACHING_SESSION\".\"SCORECARD_ID\",\"ADHOC_COACHING_SESSION\".\"ADHOC_COACHING_CATEGORY_ID\",\"ADHOC_COACHING_SESSION\".\"AGENT_SCORECARD_ID\"";
	private String selectFromStatementTableName = " FROM \"ADHOC_COACHING_SESSION\" \"ADHOC_COACHING_SESSION\"";
	private String whereClause = " WHERE \"ADHOC_COACHING_SESSION\".\"ID\"=?";
	private String whereInClause = " join table(sys.dbms_debug_vc2coll(?)) SQLLIST on \"ADHOC_COACHING_SESSION\".\"ID\"= SQLLIST.column_value";
	private String orderByTableName = " ORDER BY \"ADHOC_COACHING_SESSION\".\"ID\"";
	
	private String joinAgentScorecardIDCoachingSession = ",(select ? As SQLID From Dual) WHERE ADHOC_COACHING_SESSION.EMPLOYEE_ID= SUBSTR(SQLID,0,9) AND ADHOC_COACHING_SESSION.SCORECARD_ID=SUBSTR(SQLID,INSTR(SQLID,'-', 1, 1) + 1,INSTR(SQLID,'-', 1, 2)-INSTR(SQLID,'-', 1, 1)-1) AND ADHOC_COACHING_SESSION.WEEK_DATE= SUBSTR(SQLID,INSTR(SQLID,'-', 1, 2) + 1,10)";
	

	
	@Override
	protected String getConnectionFactoryName() {
		return AdhocCoachingSessionDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT \"ADHOC_COACHING_SESSION\".\"ID\" " + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT \"ADHOC_COACHING_SESSION\".\"ID\"" + SQL_VIEW  + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT \"ADHOC_COACHING_SESSION\".\"ID\" " + selectFromStatementTableName +  orderByTableName;
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT \"ADHOC_COACHING_SESSION\".\"ID\" " + selectFromStatementTableName  +  orderByTableName  + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT \"ADHOC_COACHING_SESSION\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName  + orderByTableName;
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT \"ADHOC_COACHING_SESSION\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + orderByTableName + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() 
	{
		return "SELECT COUNT(ID) " + selectFromStatementTableName;
	}
	
	@Override
	protected String getSelectInStarSQL() 
	{
		return "SELECT \"ADHOC_COACHING_SESSION\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + whereInClause;
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT \"ADHOC_COACHING_SESSION\".\"ID\" " + selectFromStatementTableName + whereInClause;
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		if (joinColumnName.equalsIgnoreCase("\"AGENT_SCORECARD_ID\""))
{
return "SELECT \"ADHOC_COACHING_SESSION\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + joinAgentScorecardIDCoachingSession;
}
		
		return "SELECT \"ADHOC_COACHING_SESSION\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + " WHERE \"ADHOC_COACHING_SESSION\"." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) 
	{
		if (joinColumnName.equalsIgnoreCase("\"AGENT_SCORECARD_ID\""))
{
return "SELECT \"ADHOC_COACHING_SESSION\".\"ID\" " + selectFromStatementTableName + joinAgentScorecardIDCoachingSession;
}
		
		return "SELECT \"ADHOC_COACHING_SESSION\".\"ID\" " + selectFromStatementTableName + " WHERE \"ADHOC_COACHING_SESSION\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT \"ADHOC_COACHING_SESSION\".\"ID\" " + selectFromStatementTableName;
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT \"ADHOC_COACHING_SESSION\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName;
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO ADHOC_COACHING_SESSION (\"ID\",\"SESSION_TYPE\",\"STATUS\",\"WEEK_DATE\",\"EMPLOYEE_ID\",\"SCORECARD_ID\",\"ADHOC_COACHING_CATEGORY_ID\",\"AGENT_SCORECARD_ID\") VALUES (?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE \"ADHOC_COACHING_SESSION\" SET \"SESSION_TYPE\"=?,\"STATUS\"=?,\"WEEK_DATE\"=?,\"EMPLOYEE_ID\"=?,\"SCORECARD_ID\"=?,\"ADHOC_COACHING_CATEGORY_ID\"=?,\"AGENT_SCORECARD_ID\"=? WHERE \"ID\"=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM \"ADHOC_COACHING_SESSION\" WHERE \"ID\"=?";
	}
	
	@Override
	protected AdhocCoachingSession extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	AdhocCoachingSession nextResult = new AdhocCoachingSession();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setSessionType(rs.getString("SESSION_TYPE"));

nextResult.setStatus(rs.getString("STATUS"));

nextResult.setWeekDate(rs.getDate("WEEK_DATE"));

nextResult.setEmployeeId(rs.getInt("EMPLOYEE_ID"));

nextResult.setScorecardId(rs.getInt("SCORECARD_ID"));

AdhocCoachingCategory adhoccoachingcategory = new AdhocCoachingCategory();
adhoccoachingcategory.setID(rs.getString("ADHOC_COACHING_CATEGORY_ID"));
nextResult.setAdhocCoachingCategory(adhoccoachingcategory);

AgentScorecard agentscorecard = new AgentScorecard();
agentscorecard.setID(rs.getString("AGENT_SCORECARD_ID"));
nextResult.setAgentScorecard(agentscorecard);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(AdhocCoachingSession perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getSessionType());
pstmt.setString(3, perceroObject.getStatus());
pstmt.setDate(4, DateUtils.utilDateToSqlDate(perceroObject.getWeekDate()));
pstmt.setInt(5, perceroObject.getEmployeeId());
pstmt.setInt(6, perceroObject.getScorecardId());

if (perceroObject.getAdhocCoachingCategory() == null)
{
pstmt.setString(7, null);
}
else
{
		pstmt.setString(7, perceroObject.getAdhocCoachingCategory().getID());
}


if (perceroObject.getAgentScorecard() == null)
{
pstmt.setString(8, null);
}
else
{
		pstmt.setString(8, perceroObject.getAgentScorecard().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(AdhocCoachingSession perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getSessionType());
pstmt.setString(2, perceroObject.getStatus());
pstmt.setDate(3, DateUtils.utilDateToSqlDate(perceroObject.getWeekDate()));
pstmt.setInt(4, perceroObject.getEmployeeId());
pstmt.setInt(5, perceroObject.getScorecardId());

if (perceroObject.getAdhocCoachingCategory() == null)
{
pstmt.setString(6, null);
}
else
{
		pstmt.setString(6, perceroObject.getAdhocCoachingCategory().getID());
}


if (perceroObject.getAgentScorecard() == null)
{
pstmt.setString(7, null);
}
else
{
		pstmt.setString(7, perceroObject.getAgentScorecard().getID());
}

pstmt.setString(8, perceroObject.getID());

		
	}

	@Override
	public List<AdhocCoachingSession> findByExample(AdhocCoachingSession theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useSessionType = StringUtils.hasText(theQueryObject.getSessionType()) && (excludeProperties == null || !excludeProperties.contains("sessionType"));

if (useSessionType)
{
sql += " WHERE ";
sql += " \"SESSION_TYPE\" =? ";
paramValues.add(theQueryObject.getSessionType());
propertyCounter++;
}

boolean useStatus = StringUtils.hasText(theQueryObject.getStatus()) && (excludeProperties == null || !excludeProperties.contains("status"));

if (useStatus)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"STATUS\" =? ";
paramValues.add(theQueryObject.getStatus());
propertyCounter++;
}

boolean useWeekDate = theQueryObject.getWeekDate() != null && (excludeProperties == null || !excludeProperties.contains("weekDate"));

if (useWeekDate)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"WEEK_DATE\" =? ";
paramValues.add(theQueryObject.getWeekDate());
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
sql += " \"EMPLOYEE_ID\" =? ";
paramValues.add(theQueryObject.getEmployeeId());
propertyCounter++;
}

boolean useScorecardId = theQueryObject.getScorecardId() != null && (excludeProperties == null || !excludeProperties.contains("scorecardId"));

if (useScorecardId)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"SCORECARD_ID\" =? ";
paramValues.add(theQueryObject.getScorecardId());
propertyCounter++;
}

boolean useAdhocCoachingCategoryID = theQueryObject.getAdhocCoachingCategory() != null && (excludeProperties == null || !excludeProperties.contains("adhocCoachingCategory"));

if (useAdhocCoachingCategoryID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"ADHOC_COACHING_CATEGORY_ID\" =? ";
paramValues.add(theQueryObject.getAdhocCoachingCategory().getID());
propertyCounter++;
}

boolean useAgentScorecardID = theQueryObject.getAgentScorecard() != null && (excludeProperties == null || !excludeProperties.contains("agentScorecard"));

if (useAgentScorecardID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"AGENT_SCORECARD_ID\" =? ";
paramValues.add(theQueryObject.getAgentScorecard().getID());
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
