
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
import com.pulse.mo.QualityEvaluation;
import com.pulse.mo.PerformanceSummary;
import com.pulse.mo.CoachingSession;

*/

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
	
	public static final String SQL_VIEW = ",\"QUALITY_EVALUATION\".\"COACHING_SESSION_ID\",\"QUALITY_EVALUATION\".\"PERFORMANCE_SUMMARY_ID\"";
	private String selectFromStatementTableName = " FROM \"QUALITY_EVALUATION\" \"QUALITY_EVALUATION\"";
	private String whereClause = " WHERE \"QUALITY_EVALUATION\".\"ID\"=?";
	private String whereInClause = " join table(sys.dbms_debug_vc2coll(?)) SQLLIST on \"QUALITY_EVALUATION\".\"ID\"= SQLLIST.column_value";
	private String orderByTableName = " ORDER BY \"QUALITY_EVALUATION\".\"ID\"";
	
	

	
	@Override
	protected String getConnectionFactoryName() {
		return QualityEvaluationDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT \"QUALITY_EVALUATION\".\"ID\" " + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT \"QUALITY_EVALUATION\".\"ID\"" + SQL_VIEW  + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT \"QUALITY_EVALUATION\".\"ID\" " + selectFromStatementTableName +  orderByTableName;
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT \"QUALITY_EVALUATION\".\"ID\" " + selectFromStatementTableName  +  orderByTableName  + " LIMIT ? OFFSET ?";
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
		return "SELECT \"QUALITY_EVALUATION\".\"ID\" " + selectFromStatementTableName + whereInClause;
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		
		return "SELECT \"QUALITY_EVALUATION\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + " WHERE \"QUALITY_EVALUATION\"." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) 
	{
		
		return "SELECT \"QUALITY_EVALUATION\".\"ID\" " + selectFromStatementTableName + " WHERE \"QUALITY_EVALUATION\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT \"QUALITY_EVALUATION\".\"ID\" " + selectFromStatementTableName;
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT \"QUALITY_EVALUATION\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName;
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO QUALITY_EVALUATION (\"ID\",\"COACHING_SESSION_ID\",\"PERFORMANCE_SUMMARY_ID\") VALUES (?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE \"QUALITY_EVALUATION\" SET \"COACHING_SESSION_ID\"=?,\"PERFORMANCE_SUMMARY_ID\"=? WHERE \"ID\"=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM \"QUALITY_EVALUATION\" WHERE \"ID\"=?";
	}
	
	@Override
	protected QualityEvaluation extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	QualityEvaluation nextResult = new QualityEvaluation();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			CoachingSession coachingsession = new CoachingSession();
coachingsession.setID(rs.getString("COACHING_SESSION_ID"));
nextResult.setCoachingSession(coachingsession);

PerformanceSummary performancesummary = new PerformanceSummary();
performancesummary.setID(rs.getString("PERFORMANCE_SUMMARY_ID"));
nextResult.setPerformanceSummary(performancesummary);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(QualityEvaluation perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());

if (perceroObject.getCoachingSession() == null)
{
pstmt.setString(2, null);
}
else
{
		pstmt.setString(2, perceroObject.getCoachingSession().getID());
}


if (perceroObject.getPerformanceSummary() == null)
{
pstmt.setString(3, null);
}
else
{
		pstmt.setString(3, perceroObject.getPerformanceSummary().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(QualityEvaluation perceroObject, PreparedStatement pstmt) throws SQLException {
		
		
if (perceroObject.getCoachingSession() == null)
{
pstmt.setString(1, null);
}
else
{
		pstmt.setString(1, perceroObject.getCoachingSession().getID());
}


if (perceroObject.getPerformanceSummary() == null)
{
pstmt.setString(2, null);
}
else
{
		pstmt.setString(2, perceroObject.getPerformanceSummary().getID());
}

pstmt.setString(3, perceroObject.getID());

		
	}

	@Override
	public List<QualityEvaluation> findByExample(QualityEvaluation theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useCoachingSessionID = theQueryObject.getCoachingSession() != null && (excludeProperties == null || !excludeProperties.contains("coachingSession"));

if (useCoachingSessionID)
{
sql += " WHERE ";
sql += " \"COACHING_SESSION_ID\" =? ";
paramValues.add(theQueryObject.getCoachingSession().getID());
propertyCounter++;
}

boolean usePerformanceSummaryID = theQueryObject.getPerformanceSummary() != null && (excludeProperties == null || !excludeProperties.contains("performanceSummary"));

if (usePerformanceSummaryID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"PERFORMANCE_SUMMARY_ID\" =? ";
paramValues.add(theQueryObject.getPerformanceSummary().getID());
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
