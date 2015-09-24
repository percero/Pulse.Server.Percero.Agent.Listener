
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
	@Override
	protected String getConnectionFactoryName() {
		return QualityEvaluationDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT qualityevaluation.ID FROM QualityEvaluation qualityevaluation WHERE qualityevaluation.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT qualityevaluation.ID,qualityevaluation.externalID,qualityevaluation.performanceSummary_ID,qualityevaluation.coachingSession_ID FROM QualityEvaluation qualityevaluation WHERE qualityevaluation.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT qualityevaluation.ID FROM QualityEvaluation qualityevaluation ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT qualityevaluation.ID FROM QualityEvaluation qualityevaluation ORDER BY qualityevaluation.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT qualityevaluation.ID,qualityevaluation.externalID,qualityevaluation.performanceSummary_ID,qualityevaluation.coachingSession_ID FROM QualityEvaluation qualityevaluation ORDER BY qualityevaluation.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT qualityevaluation.ID,qualityevaluation.externalID,qualityevaluation.performanceSummary_ID,qualityevaluation.coachingSession_ID FROM QualityEvaluation qualityevaluation ORDER BY qualityevaluation.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM QualityEvaluation qualityevaluation";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT qualityevaluation.ID,qualityevaluation.externalID,qualityevaluation.performanceSummary_ID,qualityevaluation.coachingSession_ID FROM QualityEvaluation qualityevaluation WHERE qualityevaluation.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT qualityevaluation.ID FROM QualityEvaluation qualityevaluation WHERE qualityevaluation.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT qualityevaluation.ID,qualityevaluation.externalID,qualityevaluation.performanceSummary_ID,qualityevaluation.coachingSession_ID FROM QualityEvaluation qualityevaluation WHERE qualityevaluation." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT qualityevaluation.ID FROM QualityEvaluation qualityevaluation WHERE qualityevaluation." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT qualityevaluation.ID FROM QualityEvaluation qualityevaluation ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT qualityevaluation.ID,qualityevaluation.externalID,qualityevaluation.performanceSummary_ID,qualityevaluation.coachingSession_ID FROM QualityEvaluation qualityevaluation ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO QualityEvaluation (ID,externalID,performanceSummary_ID,coachingSession_ID) VALUES (?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE QualityEvaluation SET externalID=?,performanceSummary_ID=?,coachingSession_ID=? WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM QualityEvaluation WHERE ID=?";
	}
	
	@Override
	protected QualityEvaluation extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	QualityEvaluation nextResult = new QualityEvaluation();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setExternalID(rs.getString("externalID"));

PerformanceSummary performancesummary = new PerformanceSummary();
performancesummary.setID(rs.getString("performancesummary_ID"));
nextResult.setPerformanceSummary(performancesummary);

CoachingSession coachingsession = new CoachingSession();
coachingsession.setID(rs.getString("coachingsession_ID"));
nextResult.setCoachingSession(coachingsession);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(QualityEvaluation perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getExternalID());

if (perceroObject.getPerformanceSummary() == null)
{
pstmt.setString(3, null);
}
else
{
		pstmt.setString(3, perceroObject.getPerformanceSummary().getID());
}


if (perceroObject.getCoachingSession() == null)
{
pstmt.setString(4, null);
}
else
{
		pstmt.setString(4, perceroObject.getCoachingSession().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(QualityEvaluation perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getExternalID());

if (perceroObject.getPerformanceSummary() == null)
{
pstmt.setString(2, null);
}
else
{
		pstmt.setString(2, perceroObject.getPerformanceSummary().getID());
}


if (perceroObject.getCoachingSession() == null)
{
pstmt.setString(3, null);
}
else
{
		pstmt.setString(3, perceroObject.getCoachingSession().getID());
}

pstmt.setString(4, perceroObject.getID());

		
	}

	@Override
	public List<QualityEvaluation> findByExample(QualityEvaluation theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useExternalID = StringUtils.hasText(theQueryObject.getExternalID()) && (excludeProperties == null || !excludeProperties.contains("externalID"));

if (useExternalID)
{
sql += " WHERE ";
paramValues.add(theQueryObject.getExternalID());
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
sql += " performanceSummaryID=? ";
paramValues.add(theQueryObject.getPerformanceSummary().getID());
propertyCounter++;
}

boolean useCoachingSessionID = theQueryObject.getCoachingSession() != null && (excludeProperties == null || !excludeProperties.contains("coachingSession"));

if (useCoachingSessionID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " coachingSessionID=? ";
paramValues.add(theQueryObject.getCoachingSession().getID());
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
