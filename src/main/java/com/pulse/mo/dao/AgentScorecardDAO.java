

package com.pulse.mo.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.percero.agents.sync.exceptions.SyncDataException;
import com.percero.util.DateUtils;
import com.pulse.dataprovider.IConnectionFactory;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import com.percero.agents.sync.metadata.MappedClass;
import com.percero.agents.sync.dao.DAORegistry;
import com.percero.agents.sync.dao.IDataAccessObject;
import com.percero.agents.sync.exceptions.SyncDataException;
import com.percero.agents.sync.exceptions.SyncException;
import com.percero.agents.sync.vo.BaseDataObject;
import java.sql.Connection;
import java.sql.Statement;
import com.pulse.dataprovider.IConnectionFactory;
import com.percero.agents.sync.exceptions.SyncDataException;
import com.pulse.mo.*;

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

	public static final String SHELL_ONLY_SELECT = "\"AGENT_SCORECARD\".\"ID\"";
	public static final String SQL_VIEW = ",\"AGENT_SCORECARD\".\"END_DATE\",\"AGENT_SCORECARD\".\"START_DATE\",\"AGENT_SCORECARD\".\"WEEK_DATE\",\"AGENT_SCORECARD\".\"POINTS_POSSIBLE\",\"AGENT_SCORECARD\".\"POINTS_RECEIVED\",\"AGENT_SCORECARD\".\"SCORE\",\"AGENT_SCORECARD\".\"GRADE\",\"AGENT_SCORECARD\".\"QUARTILE\",\"AGENT_SCORECARD\".\"LOCK_LEVEL\",\"AGENT_SCORECARD\".\"AGENT_ID\",\"AGENT_SCORECARD\".\"SCORECARD_ID\",\"AGENT_SCORECARD\".\"SCORECARD_WEEKLY_SCORE_ID\"";
	private String selectFromStatementTableName = " FROM \"AGENT_SCORECARD\" \"AGENT_SCORECARD\"";
	private String whereClause = " ,(select ? As SQLID From Dual) WHERE AGENT_SCORECARD.AGENT_ID= SUBSTR(SQLID,0,9) AND AGENT_SCORECARD.SCORECARD_ID=SUBSTR(SQLID,INSTR(SQLID,'-', 1, 1) + 1,INSTR(SQLID,'-', 1, 2)-INSTR(SQLID,'-', 1, 1)-1) AND AGENT_SCORECARD.WEEK_DATE= SUBSTR(SQLID,INSTR(SQLID,'-', 1, 2) + 1,10)";
	private String whereInClause = " Join Table(sys.dbmsdebugvc2coll(?)) SQLLIST On AGENT_SCORECARD.AGENT_ID= SUBSTR(SQLLIST.columnvalue,0,9) And AGENT_SCORECARD.SCORECARD_ID=SUBSTR(SQLLIST.columnvalue,INSTR(SQLLIST.columnvalue,'-', 1, 1) + 1,INSTR(SQLLIST.columnvalue,'-', 1, 2)-INSTR(SQLLIST.columnvalue,'-', 1, 1)-1) AND AGENT_SCORECARD.WEEK_DATE= SUBSTR(SQLLIST.columnvalue,INSTR(SQLLIST.columnvalue,'-', 1, 2) + 1,10)";
	private String orderByTableName = " ORDER BY AGENT_SCORECARD.WEEK_DATE DESC";
	private String extendedWhereClause =  ""; //" WHERE ROWNUM <= 4 ";




	@Override
	protected String getConnectionFactoryName() {
		return AgentScorecardDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT " + SHELL_ONLY_SELECT +  " " + selectFromStatementTableName + whereClause;
	}

	@Override
	protected String getSelectStarSQL() {
		return "SELECT \"AGENT_SCORECARD\".\"ID\"" + SQL_VIEW  + selectFromStatementTableName + whereClause;
	}

	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName +  orderByTableName;
	}

	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName  +  orderByTableName  + " LIMIT ? OFFSET ?";
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
		return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName + whereInClause;
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName)
	{
		return "SELECT * FROM (" + "SELECT \"AGENT_SCORECARD\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + " WHERE \"AGENT_SCORECARD\"." + joinColumnName + "=? AND " + orderByTableName + " ) " + extendedWhereClause;
	}

	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName)
	{
		return "SELECT * FROM (" + "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName + " WHERE \"AGENT_SCORECARD\"." + joinColumnName + "=?" + orderByTableName + " ) " + extendedWhereClause;
	}


	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName;
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT \"AGENT_SCORECARD\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName;
	}

	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO TBL_AGENT_SCORECARD (\"ID\",\"END_DATE\",\"START_DATE\",\"WEEK_DATE\",\"POINTS_POSSIBLE\",\"POINTS_RECEIVED\",\"SCORE\",\"GRADE\",\"QUARTILE\",\"LOCK_LEVEL\",\"AGENT_ID\",\"SCORECARD_ID\",\"SCORECARD_WEEKLY_SCORE_ID\") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
	}

	@Override
	protected String getUpdateSet() {
		return "UPDATE TBL_AGENT_SCORECARD SET \"END_DATE\"=?,\"START_DATE\"=?,\"WEEK_DATE\"=?,\"POINTS_POSSIBLE\"=?,\"POINTS_RECEIVED\"=?,\"SCORE\"=?,\"GRADE\"=?,\"QUARTILE\"=?,\"LOCK_LEVEL\"=?,\"AGENT_ID\"=?,\"SCORECARD_ID\"=?,\"SCORECARD_WEEKLY_SCORE_ID\"=? WHERE \"ID\"=?";
	}

	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM TBL_AGENT_SCORECARD WHERE \"ID\"=?";
	}

	@Override
	protected AgentScorecard extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {



AgentScorecard nextResult = null;


    	if (nextResult == null) {
    		nextResult = new AgentScorecard();
    	}


    	// ID
    	nextResult.setID(rs.getString("ID"));

    	if (!shellOnly)
		{
			nextResult.setEndDate(DateUtils.utilDateFromSqlTimestamp(rs.getTimestamp("END_DATE")));


nextResult.setStartDate(DateUtils.utilDateFromSqlTimestamp(rs.getTimestamp("START_DATE")));


nextResult.setWeekDate(DateUtils.utilDateFromSqlTimestamp(rs.getTimestamp("WEEK_DATE")));


nextResult.setPointsPossible(rs.getDouble("POINTS_POSSIBLE"));


nextResult.setPointsReceived(rs.getDouble("POINTS_RECEIVED"));


nextResult.setScore(rs.getDouble("SCORE"));


nextResult.setGrade(rs.getInt("GRADE"));


nextResult.setQuartile(rs.getInt("QUARTILE"));


nextResult.setLockLevel(rs.getString("LOCK_LEVEL"));


String agentID = rs.getString("AGENT_ID");
if (StringUtils.hasText(agentID) && !"null".equalsIgnoreCase(agentID) ){
Agent agent = new Agent();
agent.setID(agentID);
nextResult.setAgent(agent);
}


String scorecardID = rs.getString("SCORECARD_ID");
if (StringUtils.hasText(scorecardID) && !"null".equalsIgnoreCase(scorecardID) ){
Scorecard scorecard = new Scorecard();
scorecard.setID(scorecardID);
nextResult.setScorecard(scorecard);
}


String scorecardweeklyscoreID = rs.getString("SCORECARD_WEEKLY_SCORE_ID");
if (StringUtils.hasText(scorecardweeklyscoreID) && !"null".equalsIgnoreCase(scorecardweeklyscoreID) ){
ScorecardWeeklyScore scorecardweeklyscore = new ScorecardWeeklyScore();
scorecardweeklyscore.setID(scorecardweeklyscoreID);
nextResult.setScorecardWeeklyScore(scorecardweeklyscore);
}




    	}


    	return nextResult;
	}

	protected void setBaseStatmentInsertParams(AgentScorecard perceroObject, PreparedStatement pstmt) throws SQLException {

		pstmt.setString(1, perceroObject.getID());
pstmt.setDate(2, DateUtils.utilDateToSqlDate(perceroObject.getEndDate()));
pstmt.setDate(3, DateUtils.utilDateToSqlDate(perceroObject.getStartDate()));
pstmt.setDate(4, DateUtils.utilDateToSqlDate(perceroObject.getWeekDate()));
JdbcHelper.setDouble(pstmt,5, perceroObject.getPointsPossible());
JdbcHelper.setDouble(pstmt,6, perceroObject.getPointsReceived());
JdbcHelper.setDouble(pstmt,7, perceroObject.getScore());
JdbcHelper.setInt(pstmt,8, perceroObject.getGrade());
JdbcHelper.setInt(pstmt,9, perceroObject.getQuartile());
pstmt.setString(10, perceroObject.getLockLevel());

if (perceroObject.getAgent() == null)
{
pstmt.setString(11, null);
}
else
{
		pstmt.setString(11, perceroObject.getAgent().getID());
}


if (perceroObject.getScorecard() == null)
{
pstmt.setString(12, null);
}
else
{
		pstmt.setString(12, perceroObject.getScorecard().getID());
}


if (perceroObject.getScorecardWeeklyScore() == null)
{
pstmt.setString(13, null);
}
else
{
		pstmt.setString(13, perceroObject.getScorecardWeeklyScore().getID());
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

		pstmt.setDate(1, DateUtils.utilDateToSqlDate(perceroObject.getEndDate()));
pstmt.setDate(2, DateUtils.utilDateToSqlDate(perceroObject.getStartDate()));
pstmt.setDate(3, DateUtils.utilDateToSqlDate(perceroObject.getWeekDate()));
JdbcHelper.setDouble(pstmt,4, perceroObject.getPointsPossible());
JdbcHelper.setDouble(pstmt,5, perceroObject.getPointsReceived());
JdbcHelper.setDouble(pstmt,6, perceroObject.getScore());
JdbcHelper.setInt(pstmt,7, perceroObject.getGrade());
JdbcHelper.setInt(pstmt,8, perceroObject.getQuartile());
pstmt.setString(9, perceroObject.getLockLevel());

if (perceroObject.getAgent() == null)
{
pstmt.setString(10, null);
}
else
{
		pstmt.setString(10, perceroObject.getAgent().getID());
}


if (perceroObject.getScorecard() == null)
{
pstmt.setString(11, null);
}
else
{
		pstmt.setString(11, perceroObject.getScorecard().getID());
}


if (perceroObject.getScorecardWeeklyScore() == null)
{
pstmt.setString(12, null);
}
else
{
		pstmt.setString(12, perceroObject.getScorecardWeeklyScore().getID());
}

pstmt.setString(13, perceroObject.getID());


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

		boolean useEndDate = theQueryObject.getEndDate() != null && (excludeProperties == null || !excludeProperties.contains("endDate"));

if (useEndDate)
{
sql += " WHERE ";
sql += " \"END_DATE\" =? ";
paramValues.add(theQueryObject.getEndDate());
propertyCounter++;
}

boolean useStartDate = theQueryObject.getStartDate() != null && (excludeProperties == null || !excludeProperties.contains("startDate"));

if (useStartDate)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"START_DATE\" =? ";
paramValues.add(theQueryObject.getStartDate());
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

boolean useLockLevel = StringUtils.hasText(theQueryObject.getLockLevel()) && (excludeProperties == null || !excludeProperties.contains("lockLevel"));

if (useLockLevel)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"LOCK_LEVEL\" =? ";
paramValues.add(theQueryObject.getLockLevel());
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

boolean useScorecardWeeklyScoreID = theQueryObject.getScorecardWeeklyScore() != null && (excludeProperties == null || !excludeProperties.contains("scorecardWeeklyScore"));

if (useScorecardWeeklyScoreID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"SCORECARD_WEEKLY_SCORE_ID\" =? ";
paramValues.add(theQueryObject.getScorecardWeeklyScore().getID());
propertyCounter++;
}



		if (propertyCounter == 0) {
			throw new SyncException(SyncException.METHOD_UNSUPPORTED, SyncException.METHOD_UNSUPPORTED_CODE);
		}

		return executeSelectWithParams(sql, paramValues.toArray(), shellOnly);
	}

	public List<Date> findCurrentWeekDates(String teamLeaderId) throws SyncException {
//		String sql = "SELECT * FROM AGENT_SCORECARD WHERE AGENT_ID=? AND WEEK_DATE>? ORDER BY WEEK_DATE DESC";

		List<Date> results = new ArrayList<Date>();
//		String sql = "SELECT DISTINCT(\"WEEK_DATE\") FROM \"AGENT_SCORECARD\" WHERE \"WEEK_DATE\">?";
		String sql = "select WEEK_DATE from (select distinct ac.WEEK_DATE from Team_Leader t join Agent  a on a.Team_Leader_Id = t.Id join AGENT_SCORECARD ac on ac.Agent_Id = a.Id and ac.START_DATE >= (add_months(sysdate,-1)-6) where t.ID =?) T order by WEEK_DATE desc";

		long timeStart = System.currentTimeMillis();

		// Open the database session.
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			IConnectionFactory connectionFactory = getConnectionRegistry().getConnectionFactory(getConnectionFactoryName());
			conn = connectionFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setFetchSize(connectionFactory.getFetchSize());
			pstmt.setQueryTimeout(QUERY_TIMEOUT);

			// Looking for past 4 weeks worth.
//			DateTime theDateTime = new DateTime();
//			theDateTime = theDateTime.minusMonths(1);
//			pstmt.setDate(1, DateUtils.utilDateToSqlDate(theDateTime.toDate()));
			pstmt.setString(1, teamLeaderId);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Date nextResult = DateUtils.utilDateFromSqlTimestamp(rs.getTimestamp("WEEK_DATE"));
				results.add(nextResult);
			}
		} catch(Exception e) {
			log.error("[AgentScorecardDAO] Unable to findMostRecent\n" + sql, e);
			throw new SyncDataException(e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				log.error("[AgentScorecardDAO] Error closing database statement/connection", e);
			}
		}

		long timeEnd = System.currentTimeMillis();
		long totalTime = timeEnd - timeStart;
		if (totalTime > LONG_RUNNING_QUERY_TIME) {
			log.warn("LONG RUNNING QUERY: " + totalTime + "ms\n" + sql);
		}

		return results;
	}

	@Override
	protected String getUpdateCallableStatementSql() {
		return "{call UPDATE_AGENT_SCORECARD(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	}
	@Override
	protected String getInsertCallableStatementSql() {
		return "{call CREATE_AGENT_SCORECARD(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	}
	@Override
	protected String getDeleteCallableStatementSql() {
		return "{call Delete_AGENT_SCORECARD(?)}";
	}



public AgentScorecard createObject(AgentScorecard perceroObject, String userId)
		throws SyncException {
	if ( !hasCreateAccess(BaseDataObject.toClassIdPair(perceroObject), userId) ) {
		return null;
	}

	long timeStart = System.currentTimeMillis();

	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	String query = "Select AGENT_SCORECARD_SEQ.NEXTVAL from dual";
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

