
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
import com.pulse.mo.PerformanceSummary;
import com.pulse.mo.Agent;
import com.pulse.mo.Attachment;
import com.pulse.mo.QualityEvaluation;

*/

@Component
public class PerformanceSummaryDAO extends SqlDataAccessObject<PerformanceSummary> implements IDataAccessObject<PerformanceSummary> {

	static final Logger log = Logger.getLogger(PerformanceSummaryDAO.class);

	
	public PerformanceSummaryDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(PerformanceSummary.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	@Override
	protected String getConnectionFactoryName() {
		return PerformanceSummaryDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT performancesummary.ID FROM PerformanceSummary performancesummary WHERE performancesummary.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT performancesummary.ID,performancesummary.externalID,performancesummary.currentMTDScore,performancesummary.currentMTDTrend,performancesummary.previousMTDScore,performancesummary.previousMTDTrend,performancesummary.weeklyOverviewScore,performancesummary.weeklyTrend,performancesummary.wekendDate FROM PerformanceSummary performancesummary WHERE performancesummary.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT performancesummary.ID FROM PerformanceSummary performancesummary ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT performancesummary.ID FROM PerformanceSummary performancesummary ORDER BY performancesummary.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT performancesummary.ID,performancesummary.externalID,performancesummary.currentMTDScore,performancesummary.currentMTDTrend,performancesummary.previousMTDScore,performancesummary.previousMTDTrend,performancesummary.weeklyOverviewScore,performancesummary.weeklyTrend,performancesummary.wekendDate FROM PerformanceSummary performancesummary ORDER BY performancesummary.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT performancesummary.ID,performancesummary.externalID,performancesummary.currentMTDScore,performancesummary.currentMTDTrend,performancesummary.previousMTDScore,performancesummary.previousMTDTrend,performancesummary.weeklyOverviewScore,performancesummary.weeklyTrend,performancesummary.wekendDate FROM PerformanceSummary performancesummary ORDER BY performancesummary.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM PerformanceSummary performancesummary";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT performancesummary.ID,performancesummary.externalID,performancesummary.currentMTDScore,performancesummary.currentMTDTrend,performancesummary.previousMTDScore,performancesummary.previousMTDTrend,performancesummary.weeklyOverviewScore,performancesummary.weeklyTrend,performancesummary.wekendDate FROM PerformanceSummary performancesummary WHERE performancesummary.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT performancesummary.ID FROM PerformanceSummary performancesummary WHERE performancesummary.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT performancesummary.ID,performancesummary.externalID,performancesummary.currentMTDScore,performancesummary.currentMTDTrend,performancesummary.previousMTDScore,performancesummary.previousMTDTrend,performancesummary.weeklyOverviewScore,performancesummary.weeklyTrend,performancesummary.wekendDate FROM PerformanceSummary performancesummary WHERE performancesummary." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT performancesummary.ID FROM PerformanceSummary performancesummary WHERE performancesummary." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT performancesummary.ID FROM PerformanceSummary performancesummary ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT performancesummary.ID,performancesummary.externalID,performancesummary.currentMTDScore,performancesummary.currentMTDTrend,performancesummary.previousMTDScore,performancesummary.previousMTDTrend,performancesummary.weeklyOverviewScore,performancesummary.weeklyTrend,performancesummary.wekendDate FROM PerformanceSummary performancesummary ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO PerformanceSummary (ID,externalID,currentMTDScore,currentMTDTrend,previousMTDScore,previousMTDTrend,weeklyOverviewScore,weeklyTrend,wekendDate) VALUES (?,?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE PerformanceSummary SET externalID=?,currentMTDScore=?,currentMTDTrend=?,previousMTDScore=?,previousMTDTrend=?,weeklyOverviewScore=?,weeklyTrend=?,wekendDate=? WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM PerformanceSummary WHERE ID=?";
	}
	
	@Override
	protected PerformanceSummary extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	PerformanceSummary nextResult = new PerformanceSummary();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setExternalID(rs.getString("externalID"));

nextResult.setCurrentMTDScore(rs.getString("currentMTDScore"));

nextResult.setCurrentMTDTrend(rs.getString("currentMTDTrend"));

nextResult.setPreviousMTDScore(rs.getString("previousMTDScore"));

nextResult.setPreviousMTDTrend(rs.getString("previousMTDTrend"));

nextResult.setWeeklyOverviewScore(rs.getString("weeklyOverviewScore"));

nextResult.setWeeklyTrend(rs.getString("weeklyTrend"));

nextResult.setWekendDate(rs.getDate("wekendDate"));


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(PerformanceSummary perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getExternalID());
pstmt.setString(3, perceroObject.getCurrentMTDScore());
pstmt.setString(4, perceroObject.getCurrentMTDTrend());
pstmt.setString(5, perceroObject.getPreviousMTDScore());
pstmt.setString(6, perceroObject.getPreviousMTDTrend());
pstmt.setString(7, perceroObject.getWeeklyOverviewScore());
pstmt.setString(8, perceroObject.getWeeklyTrend());
pstmt.setDate(9, DateUtils.utilDateToSqlDate(perceroObject.getWekendDate()));

		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(PerformanceSummary perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getExternalID());
pstmt.setString(2, perceroObject.getCurrentMTDScore());
pstmt.setString(3, perceroObject.getCurrentMTDTrend());
pstmt.setString(4, perceroObject.getPreviousMTDScore());
pstmt.setString(5, perceroObject.getPreviousMTDTrend());
pstmt.setString(6, perceroObject.getWeeklyOverviewScore());
pstmt.setString(7, perceroObject.getWeeklyTrend());
pstmt.setDate(8, DateUtils.utilDateToSqlDate(perceroObject.getWekendDate()));
pstmt.setString(9, perceroObject.getID());

		
	}

	@Override
	public List<PerformanceSummary> findByExample(PerformanceSummary theQueryObject,
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

boolean useCurrentMTDScore = StringUtils.hasText(theQueryObject.getCurrentMTDScore()) && (excludeProperties == null || !excludeProperties.contains("currentMTDScore"));

if (useCurrentMTDScore)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " currentMTDScore=? ";
paramValues.add(theQueryObject.getCurrentMTDScore());
propertyCounter++;
}

boolean useCurrentMTDTrend = StringUtils.hasText(theQueryObject.getCurrentMTDTrend()) && (excludeProperties == null || !excludeProperties.contains("currentMTDTrend"));

if (useCurrentMTDTrend)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " currentMTDTrend=? ";
paramValues.add(theQueryObject.getCurrentMTDTrend());
propertyCounter++;
}

boolean usePreviousMTDScore = StringUtils.hasText(theQueryObject.getPreviousMTDScore()) && (excludeProperties == null || !excludeProperties.contains("previousMTDScore"));

if (usePreviousMTDScore)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " previousMTDScore=? ";
paramValues.add(theQueryObject.getPreviousMTDScore());
propertyCounter++;
}

boolean usePreviousMTDTrend = StringUtils.hasText(theQueryObject.getPreviousMTDTrend()) && (excludeProperties == null || !excludeProperties.contains("previousMTDTrend"));

if (usePreviousMTDTrend)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " previousMTDTrend=? ";
paramValues.add(theQueryObject.getPreviousMTDTrend());
propertyCounter++;
}

boolean useWeeklyOverviewScore = StringUtils.hasText(theQueryObject.getWeeklyOverviewScore()) && (excludeProperties == null || !excludeProperties.contains("weeklyOverviewScore"));

if (useWeeklyOverviewScore)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " weeklyOverviewScore=? ";
paramValues.add(theQueryObject.getWeeklyOverviewScore());
propertyCounter++;
}

boolean useWeeklyTrend = StringUtils.hasText(theQueryObject.getWeeklyTrend()) && (excludeProperties == null || !excludeProperties.contains("weeklyTrend"));

if (useWeeklyTrend)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " weeklyTrend=? ";
paramValues.add(theQueryObject.getWeeklyTrend());
propertyCounter++;
}

boolean useWekendDate = theQueryObject.getWekendDate() != null && (excludeProperties == null || !excludeProperties.contains("wekendDate"));

if (useWekendDate)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " wekendDate=? ";
paramValues.add(theQueryObject.getWekendDate());
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
