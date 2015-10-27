
package com.pulse.mo.dao;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
import com.percero.agents.sync.exceptions.SyncException;
import com.percero.agents.sync.vo.BaseDataObject;
import java.sql.Connection;
import java.sql.Statement;
import com.pulse.dataprovider.IConnectionFactory;
import com.percero.agents.sync.exceptions.SyncDataException;
import com.pulse.mo.*;

@Component
public class QualityEvaluationDAO extends SqlDataAccessObject<QualityEvaluation> implements IDataAccessObject<QualityEvaluation> {

	static final Logger log = Logger.getLogger(QualityEvaluationDAO.class);

	
	public QualityEvaluationDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(QualityEvaluation.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	
	public static final String SHELL_ONLY_SELECT = "\"QUALITY_EVALUATION\".\"ID\"";
	public static final String SQL_VIEW = ",\"QUALITY_EVALUATION\".\"UPDATED_BY\",\"QUALITY_EVALUATION\".\"IS_REQUIRED\",\"QUALITY_EVALUATION\".\"CREATED_ON\",\"QUALITY_EVALUATION\".\"UPDATED_ON\",\"QUALITY_EVALUATION\".\"WEEK_DATE\",\"QUALITY_EVALUATION\".\"NICE_EVAL_ID\",\"QUALITY_EVALUATION\".\"CREATED_BY\",\"QUALITY_EVALUATION\".\"MANUAL_DETAILS\",\"QUALITY_EVALUATION\".\"NICE_APP_SERVER\",\"QUALITY_EVALUATION\".\"SCORECARD_ID\",\"QUALITY_EVALUATION\".\"EMPLOYEE_ID\",\"QUALITY_EVALUATION\".\"AGENT_ID\",\"QUALITY_EVALUATION\".\"AGENT_SCORECARD_ID\"";
	private String selectFromStatementTableName = " FROM \"QUALITY_EVALUATION\" \"QUALITY_EVALUATION\"";
	private String whereClause = "  WHERE \"QUALITY_EVALUATION\".\"ID\"=?";
	private String whereInClause = "  join table(sys.dbms_debug_vc2coll(?)) SQLLIST on \"QUALITY_EVALUATION\".\"ID\"= SQLLIST.column_value";
	private String orderByTableName = "  ORDER BY \"QUALITY_EVALUATION\".\"ID\"";
	
	private String joinAgentScorecardIDQualityEvaluation = ",(select ? As SQL_ID From Dual) WHERE QUALITY_EVALUATION.EMPLOYEE_ID= SUBSTR(SQL_ID,0,9) AND QUALITY_EVALUATION.SCORECARD_ID=SUBSTR(SQL_ID,INSTR(SQL_ID,'-', 1, 1) + 1,INSTR(SQL_ID,'-', 1, 2)-INSTR(SQL_ID,'-', 1, 1)-1) AND QUALITY_EVALUATION.WEEK_DATE= SUBSTR(SQL_ID,INSTR(SQL_ID,'-', 1, 2) + 1,10)";


	
	@Override
	protected String getConnectionFactoryName() {
		return QualityEvaluationDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT " + SHELL_ONLY_SELECT +  " " + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT \"QUALITY_EVALUATION\".\"ID\"" + SQL_VIEW  + selectFromStatementTableName + whereClause;
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
		return "SELECT \"QUALITY_EVALUATION\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName  + orderByTableName;
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT \"QUALITY_EVALUATION\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + orderByTableName + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() 
	{
		return "SELECT COUNT(ID) " + selectFromStatementTableName;
	}
	
	@Override
	protected String getSelectInStarSQL() 
	{
		return "SELECT \"QUALITY_EVALUATION\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + whereInClause;
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName + whereInClause;
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		if (joinColumnName.equalsIgnoreCase("\"AGENT_SCORECARD_ID\""))
{
return "SELECT \"QUALITY_EVALUATION\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + joinAgentScorecardIDQualityEvaluation;
}

		return "SELECT \"QUALITY_EVALUATION\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + " WHERE \"QUALITY_EVALUATION\"." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) 
	{
		if (joinColumnName.equalsIgnoreCase("\"AGENT_SCORECARD_ID\""))
{
return "SELECT \"QUALITY_EVALUATION\".\"ID\" " + selectFromStatementTableName + joinAgentScorecardIDQualityEvaluation;
}

		return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName + " WHERE \"QUALITY_EVALUATION\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName;
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT \"QUALITY_EVALUATION\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName;
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO TBL_QUALITY_EVALUATION (\"ID\",\"UPDATED_BY\",\"IS_REQUIRED\",\"CREATED_ON\",\"UPDATED_ON\",\"WEEK_DATE\",\"NICE_EVAL_ID\",\"CREATED_BY\",\"MANUAL_DETAILS\",\"NICE_APP_SERVER\",\"SCORECARD_ID\",\"EMPLOYEE_ID\",\"AGENT_ID\",\"AGENT_SCORECARD_ID\") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE TBL_QUALITY_EVALUATION SET \"UPDATED_BY\"=?,\"IS_REQUIRED\"=?,\"CREATED_ON\"=?,\"UPDATED_ON\"=?,\"WEEK_DATE\"=?,\"NICE_EVAL_ID\"=?,\"CREATED_BY\"=?,\"MANUAL_DETAILS\"=?,\"NICE_APP_SERVER\"=?,\"SCORECARD_ID\"=?,\"EMPLOYEE_ID\"=?,\"AGENT_ID\"=?,\"AGENT_SCORECARD_ID\"=? WHERE \"ID\"=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM TBL_QUALITY_EVALUATION WHERE \"ID\"=?";
	}
	
	@Override
	protected QualityEvaluation extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	
		
QualityEvaluation nextResult = null;
    	
		    	
    	if (nextResult == null) {
    		nextResult = new QualityEvaluation();
    	}

		
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setUpdatedBy(rs.getString("UPDATED_BY"));


nextResult.setIsRequired(rs.getBoolean("IS_REQUIRED"));


nextResult.setCreatedOn(DateUtils.utilDateFromSqlTimestamp(rs.getTimestamp("CREATED_ON")));


nextResult.setUpdatedOn(DateUtils.utilDateFromSqlTimestamp(rs.getTimestamp("UPDATED_ON")));


nextResult.setWeekDate(DateUtils.utilDateFromSqlTimestamp(rs.getTimestamp("WEEK_DATE")));


nextResult.setNiceEvalId(rs.getInt("NICE_EVAL_ID"));


nextResult.setCreatedBy(rs.getString("CREATED_BY"));


nextResult.setManualDetails(rs.getString("MANUAL_DETAILS"));


nextResult.setNiceAppServer(rs.getString("NICE_APP_SERVER"));


Scorecard scorecard = new Scorecard();
scorecard.setID(rs.getString("SCORECARD_ID"));
nextResult.setScorecard(scorecard);


Employee employee = new Employee();
employee.setID(rs.getString("EMPLOYEE_ID"));
nextResult.setEmployee(employee);


Agent agent = new Agent();
agent.setID(rs.getString("AGENT_ID"));
nextResult.setAgent(agent);


AgentScorecard agentscorecard = new AgentScorecard();
agentscorecard.setID(rs.getString("AGENT_SCORECARD_ID"));
nextResult.setAgentScorecard(agentscorecard);



			
    	}
		
		
    	return nextResult;
	}
	
	protected void setBaseStatmentInsertParams(QualityEvaluation perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getUpdatedBy());
JdbcHelper.setBoolean(pstmt,3, perceroObject.getIsRequired());
pstmt.setDate(4, DateUtils.utilDateToSqlDate(perceroObject.getCreatedOn()));
pstmt.setDate(5, DateUtils.utilDateToSqlDate(perceroObject.getUpdatedOn()));
pstmt.setDate(6, DateUtils.utilDateToSqlDate(perceroObject.getWeekDate()));
JdbcHelper.setInt(pstmt,7, perceroObject.getNiceEvalId());
pstmt.setString(8, perceroObject.getCreatedBy());
pstmt.setString(9, perceroObject.getManualDetails());
pstmt.setString(10, perceroObject.getNiceAppServer());

if (perceroObject.getScorecard() == null)
{
pstmt.setString(11, null);
}
else
{
		pstmt.setString(11, perceroObject.getScorecard().getID());
}


if (perceroObject.getEmployee() == null)
{
pstmt.setString(12, null);
}
else
{
		pstmt.setString(12, perceroObject.getEmployee().getID());
}


if (perceroObject.getAgent() == null)
{
pstmt.setString(13, null);
}
else
{
		pstmt.setString(13, perceroObject.getAgent().getID());
}


if (perceroObject.getAgentScorecard() == null)
{
pstmt.setString(14, null);
}
else
{
		pstmt.setString(14, perceroObject.getAgentScorecard().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(QualityEvaluation perceroObject, PreparedStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
		
	}
	
	@Override
	protected void setCallableStatmentInsertParams(QualityEvaluation perceroObject, CallableStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	

	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(QualityEvaluation perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getUpdatedBy());
JdbcHelper.setBoolean(pstmt,2, perceroObject.getIsRequired());
pstmt.setDate(3, DateUtils.utilDateToSqlDate(perceroObject.getCreatedOn()));
pstmt.setDate(4, DateUtils.utilDateToSqlDate(perceroObject.getUpdatedOn()));
pstmt.setDate(5, DateUtils.utilDateToSqlDate(perceroObject.getWeekDate()));
JdbcHelper.setInt(pstmt,6, perceroObject.getNiceEvalId());
pstmt.setString(7, perceroObject.getCreatedBy());
pstmt.setString(8, perceroObject.getManualDetails());
pstmt.setString(9, perceroObject.getNiceAppServer());

if (perceroObject.getScorecard() == null)
{
pstmt.setString(10, null);
}
else
{
		pstmt.setString(10, perceroObject.getScorecard().getID());
}


if (perceroObject.getEmployee() == null)
{
pstmt.setString(11, null);
}
else
{
		pstmt.setString(11, perceroObject.getEmployee().getID());
}


if (perceroObject.getAgent() == null)
{
pstmt.setString(12, null);
}
else
{
		pstmt.setString(12, perceroObject.getAgent().getID());
}


if (perceroObject.getAgentScorecard() == null)
{
pstmt.setString(13, null);
}
else
{
		pstmt.setString(13, perceroObject.getAgentScorecard().getID());
}

pstmt.setString(14, perceroObject.getID());

		
	}
	
	
	@Override
	protected void setCallableStatmentUpdateParams(QualityEvaluation perceroObject, CallableStatement pstmt) throws SQLException 
	{
		
		//must be in same order as insert
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	}
	
	

	@Override
	public List<QualityEvaluation> findByExample(QualityEvaluation theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useUpdatedBy = StringUtils.hasText(theQueryObject.getUpdatedBy()) && (excludeProperties == null || !excludeProperties.contains("updatedBy"));

if (useUpdatedBy)
{
sql += " WHERE ";
sql += " \"UPDATED_BY\" =? ";
paramValues.add(theQueryObject.getUpdatedBy());
propertyCounter++;
}

boolean useIsRequired = theQueryObject.getIsRequired() != null && (excludeProperties == null || !excludeProperties.contains("isRequired"));

if (useIsRequired)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"IS_REQUIRED\" =? ";
paramValues.add(theQueryObject.getIsRequired());
propertyCounter++;
}

boolean useCreatedOn = theQueryObject.getCreatedOn() != null && (excludeProperties == null || !excludeProperties.contains("createdOn"));

if (useCreatedOn)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"CREATED_ON\" =? ";
paramValues.add(theQueryObject.getCreatedOn());
propertyCounter++;
}

boolean useUpdatedOn = theQueryObject.getUpdatedOn() != null && (excludeProperties == null || !excludeProperties.contains("updatedOn"));

if (useUpdatedOn)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"UPDATED_ON\" =? ";
paramValues.add(theQueryObject.getUpdatedOn());
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

boolean useNiceEvalId = theQueryObject.getNiceEvalId() != null && (excludeProperties == null || !excludeProperties.contains("niceEvalId"));

if (useNiceEvalId)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"NICE_EVAL_ID\" =? ";
paramValues.add(theQueryObject.getNiceEvalId());
propertyCounter++;
}

boolean useCreatedBy = StringUtils.hasText(theQueryObject.getCreatedBy()) && (excludeProperties == null || !excludeProperties.contains("createdBy"));

if (useCreatedBy)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"CREATED_BY\" =? ";
paramValues.add(theQueryObject.getCreatedBy());
propertyCounter++;
}

boolean useManualDetails = StringUtils.hasText(theQueryObject.getManualDetails()) && (excludeProperties == null || !excludeProperties.contains("manualDetails"));

if (useManualDetails)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"MANUAL_DETAILS\" =? ";
paramValues.add(theQueryObject.getManualDetails());
propertyCounter++;
}

boolean useNiceAppServer = StringUtils.hasText(theQueryObject.getNiceAppServer()) && (excludeProperties == null || !excludeProperties.contains("niceAppServer"));

if (useNiceAppServer)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"NICE_APP_SERVER\" =? ";
paramValues.add(theQueryObject.getNiceAppServer());
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

boolean useEmployeeID = theQueryObject.getEmployee() != null && (excludeProperties == null || !excludeProperties.contains("employee"));

if (useEmployeeID)
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
paramValues.add(theQueryObject.getEmployee().getID());
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



		if (propertyCounter == 0) {
			throw new SyncException(SyncException.METHOD_UNSUPPORTED, SyncException.METHOD_UNSUPPORTED_CODE);
		}
		
		return executeSelectWithParams(sql, paramValues.toArray(), shellOnly);		
	}
	
	@Override
	protected String getUpdateCallableStatementSql() {
		return "{call UPDATE_QUALITY_EVALUATION(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	}
	@Override
	protected String getInsertCallableStatementSql() {
		return "{call CREATE_QUALITY_EVALUATION(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	}
	@Override
	protected String getDeleteCallableStatementSql() {
		return "{call Delete_QUALITY_EVALUATION(?)}";
	}
	
	
public QualityEvaluation createObject(QualityEvaluation perceroObject, String userId)
		throws SyncException {
	if ( !hasCreateAccess(BaseDataObject.toClassIdPair(perceroObject), userId) ) {
		return null;
	}

	long timeStart = System.currentTimeMillis();

	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	String query = "Select QUALITY_EVALUATION_SEQ.NEXTVAL from dual";
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
