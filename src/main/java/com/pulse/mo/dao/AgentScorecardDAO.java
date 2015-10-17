
package com.pulse.mo.dao;

import java.sql.PreparedStatement;
import java.sql.CallableStatement;
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
import com.pulse.mo.AgentScorecard;
import com.pulse.mo.AdhocCoachingSession;
import com.pulse.mo.ScorecardMeasureWeeklyResult;
import com.pulse.mo.CoachingSession;
import com.pulse.mo.Agent;
import com.pulse.mo.Scorecard;

*/

@Component
public class AgentScorecardDAO extends SqlDataAccessObject<AgentScorecard> implements IDataAccessObject<AgentScorecard> {

	static final Logger log = Logger.getLogger(AgentScorecardDAO.class);

	
	public AgentScorecardDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(AgentScorecard.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	
	public static final String SQL_VIEW = ",\"AGENT_SCORECARD\".\"WEEK_DATE\",\"AGENT_SCORECARD\".\"POINTS_POSSIBLE\",\"AGENT_SCORECARD\".\"POINTS_RECEIVED\",\"AGENT_SCORECARD\".\"SCORE\",\"AGENT_SCORECARD\".\"GRADE\",\"AGENT_SCORECARD\".\"QUARTILE\",\"AGENT_SCORECARD\".\"AGENT_ID\",\"AGENT_SCORECARD\".\"SCORECARD_ID\"";
	private String selectFromStatementTableName = " FROM \"AGENT_SCORECARD\" \"AGENT_SCORECARD\"";
	private String whereClause = " ,(select ? As SQLID From Dual) WHERE AGENT_SCORECARD.AGENT_ID= SUBSTR(SQLID,0,9) AND AGENT_SCORECARD.SCORECARD_ID=SUBSTR(SQLID,INSTR(SQLID,'-', 1, 1) + 1,INSTR(SQLID,'-', 1, 2)-INSTR(SQLID,'-', 1, 1)-1) AND AGENT_SCORECARD.WEEK_DATE= SUBSTR(SQLID,INSTR(SQLID,'-', 1, 2) + 1,10)";
	private String whereInClause = " Join Table(sys.dbmsdebugvc2coll(?)) SQLLIST On AGENT_SCORECARD.AGENT_ID= SUBSTR(SQLLIST.columnvalue,0,9) And AGENT_SCORECARD.SCORECARD_ID=SUBSTR(SQLLIST.columnvalue,INSTR(SQLLIST.columnvalue,'-', 1, 1) + 1,INSTR(SQLLIST.columnvalue,'-', 1, 2)-INSTR(SQLLIST.columnvalue,'-', 1, 1)-1) AND AGENT_SCORECARD.WEEK_DATE= SUBSTR(SQLLIST.columnvalue,INSTR(SQLLIST.columnvalue,'-', 1, 2) + 1,10)";
	private String orderByTableName = " ORDER BY AGENT_SCORECARD.AGENT_ID, AGENT_SCORECARD.SCORECARD_ID, AGENT_SCORECARD.WEEK_DATE";
	
	

	
	@Override
	protected String getConnectionFactoryName() {
		return AgentScorecardDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT \"AGENT_SCORECARD\".\"ID\" " + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT \"AGENT_SCORECARD\".\"ID\"" + SQL_VIEW  + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT \"AGENT_SCORECARD\".\"ID\" " + selectFromStatementTableName +  orderByTableName;
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT \"AGENT_SCORECARD\".\"ID\" " + selectFromStatementTableName  +  orderByTableName  + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT \"AGENT_SCORECARD\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName  + orderByTableName;
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT \"AGENT_SCORECARD\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + orderByTableName + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() 
	{
		return "SELECT COUNT(ID) " + selectFromStatementTableName;
	}
	
	@Override
	protected String getSelectInStarSQL() 
	{
		return "SELECT \"AGENT_SCORECARD\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + whereInClause;
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT \"AGENT_SCORECARD\".\"ID\" " + selectFromStatementTableName + whereInClause;
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		
		return "SELECT \"AGENT_SCORECARD\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + " WHERE \"AGENT_SCORECARD\"." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) 
	{
		
		return "SELECT \"AGENT_SCORECARD\".\"ID\" " + selectFromStatementTableName + " WHERE \"AGENT_SCORECARD\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT \"AGENT_SCORECARD\".\"ID\" " + selectFromStatementTableName;
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT \"AGENT_SCORECARD\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName;
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO AGENT_SCORECARD (\"ID\",\"WEEK_DATE\",\"POINTS_POSSIBLE\",\"POINTS_RECEIVED\",\"SCORE\",\"GRADE\",\"QUARTILE\",\"AGENT_ID\",\"SCORECARD_ID\") VALUES (?,?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE \"TBL_AGENT_SCORECARD\" SET \"WEEK_DATE\"=?,\"POINTS_POSSIBLE\"=?,\"POINTS_RECEIVED\"=?,\"SCORE\"=?,\"GRADE\"=?,\"QUARTILE\"=?,\"AGENT_ID\"=?,\"SCORECARD_ID\"=? WHERE \"ID\"=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM \"TBL_AGENT_SCORECARD\" WHERE \"ID\"=?";
	}
	
	@Override
	protected AgentScorecard extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	AgentScorecard nextResult = new AgentScorecard();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setWeekDate(rs.getDate("WEEK_DATE"));

nextResult.setPointsPossible(rs.getDouble("POINTS_POSSIBLE"));

nextResult.setPointsReceived(rs.getDouble("POINTS_RECEIVED"));

nextResult.setScore(rs.getDouble("SCORE"));

nextResult.setGrade(rs.getInt("GRADE"));

nextResult.setQuartile(rs.getInt("QUARTILE"));

Agent agent = new Agent();
agent.setID(rs.getString("AGENT_ID"));
nextResult.setAgent(agent);

Scorecard scorecard = new Scorecard();
scorecard.setID(rs.getString("SCORECARD_ID"));
nextResult.setScorecard(scorecard);


			
    	}
    	
    	return nextResult;
	}
	
	protected void setBaseStatmentInsertParams(AgentScorecard perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setDate(2, DateUtils.utilDateToSqlDate(perceroObject.getWeekDate()));
pstmt.setDouble(3, perceroObject.getPointsPossible());
pstmt.setDouble(4, perceroObject.getPointsReceived());
pstmt.setDouble(5, perceroObject.getScore());
pstmt.setInt(6, perceroObject.getGrade());
pstmt.setInt(7, perceroObject.getQuartile());

if (perceroObject.getAgent() == null)
{
pstmt.setString(8, null);
}
else
{
		pstmt.setString(8, perceroObject.getAgent().getID());
}


if (perceroObject.getScorecard() == null)
{
pstmt.setString(9, null);
}
else
{
		pstmt.setString(9, perceroObject.getScorecard().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(AgentScorecard perceroObject, PreparedStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
		
	}
	
	@Override
	protected void setCallableStatmentInsertParams(AgentScorecard perceroObject, CallableStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	

	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(AgentScorecard perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setDate(1, DateUtils.utilDateToSqlDate(perceroObject.getWeekDate()));
pstmt.setDouble(2, perceroObject.getPointsPossible());
pstmt.setDouble(3, perceroObject.getPointsReceived());
pstmt.setDouble(4, perceroObject.getScore());
pstmt.setInt(5, perceroObject.getGrade());
pstmt.setInt(6, perceroObject.getQuartile());

if (perceroObject.getAgent() == null)
{
pstmt.setString(7, null);
}
else
{
		pstmt.setString(7, perceroObject.getAgent().getID());
}


if (perceroObject.getScorecard() == null)
{
pstmt.setString(8, null);
}
else
{
		pstmt.setString(8, perceroObject.getScorecard().getID());
}

pstmt.setString(9, perceroObject.getID());

		
	}
	
	
	@Override
	protected void setCallableStatmentUpdateParams(AgentScorecard perceroObject, CallableStatement pstmt) throws SQLException 
	{
		
		//must be in same order as insert
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	}
	
	

	@Override
	public List<AgentScorecard> findByExample(AgentScorecard theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useWeekDate = theQueryObject.getWeekDate() != null && (excludeProperties == null || !excludeProperties.contains("weekDate"));

if (useWeekDate)
{
sql += " WHERE ";
sql += " \"WEEK_DATE\" =? ";
paramValues.add(theQueryObject.getWeekDate());
propertyCounter++;
}

boolean usePointsPossible = theQueryObject.getPointsPossible() != null && (excludeProperties == null || !excludeProperties.contains("pointsPossible"));

if (usePointsPossible)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"POINTS_POSSIBLE\" =? ";
paramValues.add(theQueryObject.getPointsPossible());
propertyCounter++;
}

boolean usePointsReceived = theQueryObject.getPointsReceived() != null && (excludeProperties == null || !excludeProperties.contains("pointsReceived"));

if (usePointsReceived)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"POINTS_RECEIVED\" =? ";
paramValues.add(theQueryObject.getPointsReceived());
propertyCounter++;
}

boolean useScore = theQueryObject.getScore() != null && (excludeProperties == null || !excludeProperties.contains("score"));

if (useScore)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"SCORE\" =? ";
paramValues.add(theQueryObject.getScore());
propertyCounter++;
}

boolean useGrade = theQueryObject.getGrade() != null && (excludeProperties == null || !excludeProperties.contains("grade"));

if (useGrade)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"GRADE\" =? ";
paramValues.add(theQueryObject.getGrade());
propertyCounter++;
}

boolean useQuartile = theQueryObject.getQuartile() != null && (excludeProperties == null || !excludeProperties.contains("quartile"));

if (useQuartile)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"QUARTILE\" =? ";
paramValues.add(theQueryObject.getQuartile());
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
sql += " \"AGENT_ID\" =? ";
paramValues.add(theQueryObject.getAgent().getID());
propertyCounter++;
}

boolean useScorecardID = theQueryObject.getScorecard() != null && (excludeProperties == null || !excludeProperties.contains("scorecard"));

if (useScorecardID)
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
paramValues.add(theQueryObject.getScorecard().getID());
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
	
	@Override
	protected String getUpdateCallableStatementSql() {
		return "{call UPDATE_AGENT_SCORECARD(?,?,?,?,?,?,?,?,?)}";
	}
	@Override
	protected String getInsertCallableStatementSql() {
		return "{call CREATE_AGENT_SCORECARD(?,?,?,?,?,?,?,?,?)}";
	}
	@Override
	protected String getDeleteCallableStatementSql() {
		return "{call Delete_AGENT_SCORECARD(?)}";
	}
	
	
	
	
}
