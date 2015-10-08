
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
import com.pulse.mo.Attachment;
import com.pulse.mo.PerformanceSummary;
import com.pulse.mo.AdhocCoachingSession;
import com.pulse.mo.CoachingSession;
import com.pulse.mo.CorrectiveAction;

*/

@Component
public class AttachmentDAO extends SqlDataAccessObject<Attachment> implements IDataAccessObject<Attachment> {

	static final Logger log = Logger.getLogger(AttachmentDAO.class);

	
	public AttachmentDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(Attachment.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	@Override
	protected String getConnectionFactoryName() {
		return AttachmentDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT ATTACHMENT.ID FROM ATTACHMENT ATTACHMENT WHERE ATTACHMENT.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT ATTACHMENT.ID,ATTACHMENT.FILE_URI,ATTACHMENT.NAME,ATTACHMENT.ADHOC_COACHING_SESSION_ID,ATTACHMENT.COACHING_SESSION_ID,ATTACHMENT.CORRECTIVE_ACTION_ID,ATTACHMENT.PERFORMANCE_SUMMARY_ID FROM ATTACHMENT ATTACHMENT WHERE ATTACHMENT.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT ATTACHMENT.ID FROM ATTACHMENT ATTACHMENT ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT ATTACHMENT.ID FROM ATTACHMENT ATTACHMENT ORDER BY ATTACHMENT.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT ATTACHMENT.ID,ATTACHMENT.FILE_URI,ATTACHMENT.NAME,ATTACHMENT.ADHOC_COACHING_SESSION_ID,ATTACHMENT.COACHING_SESSION_ID,ATTACHMENT.CORRECTIVE_ACTION_ID,ATTACHMENT.PERFORMANCE_SUMMARY_ID FROM ATTACHMENT ATTACHMENT ORDER BY ATTACHMENT.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT ATTACHMENT.ID,ATTACHMENT.FILE_URI,ATTACHMENT.NAME,ATTACHMENT.ADHOC_COACHING_SESSION_ID,ATTACHMENT.COACHING_SESSION_ID,ATTACHMENT.CORRECTIVE_ACTION_ID,ATTACHMENT.PERFORMANCE_SUMMARY_ID FROM ATTACHMENT ATTACHMENT ORDER BY ATTACHMENT.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM ATTACHMENT ATTACHMENT";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT ATTACHMENT.ID,ATTACHMENT.FILE_URI,ATTACHMENT.NAME,ATTACHMENT.ADHOC_COACHING_SESSION_ID,ATTACHMENT.COACHING_SESSION_ID,ATTACHMENT.CORRECTIVE_ACTION_ID,ATTACHMENT.PERFORMANCE_SUMMARY_ID FROM ATTACHMENT ATTACHMENT WHERE ATTACHMENT.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT ATTACHMENT.ID FROM ATTACHMENT ATTACHMENT WHERE ATTACHMENT.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT ATTACHMENT.ID,ATTACHMENT.FILE_URI,ATTACHMENT.NAME,ATTACHMENT.ADHOC_COACHING_SESSION_ID,ATTACHMENT.COACHING_SESSION_ID,ATTACHMENT.CORRECTIVE_ACTION_ID,ATTACHMENT.PERFORMANCE_SUMMARY_ID FROM ATTACHMENT ATTACHMENT WHERE ATTACHMENT." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT ATTACHMENT.ID FROM ATTACHMENT ATTACHMENT WHERE ATTACHMENT." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT ATTACHMENT.ID FROM ATTACHMENT ATTACHMENT ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT ATTACHMENT.ID,ATTACHMENT.FILE_URI,ATTACHMENT.NAME,ATTACHMENT.ADHOC_COACHING_SESSION_ID,ATTACHMENT.COACHING_SESSION_ID,ATTACHMENT.CORRECTIVE_ACTION_ID,ATTACHMENT.PERFORMANCE_SUMMARY_ID FROM ATTACHMENT ATTACHMENT ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO ATTACHMENT (ID,FILE_URI,NAME,ADHOC_COACHING_SESSION_ID,COACHING_SESSION_ID,CORRECTIVE_ACTION_ID,PERFORMANCE_SUMMARY_ID) VALUES (?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE ATTACHMENT SET FILE_URI=?,NAME=?,ADHOC_COACHING_SESSION_ID,COACHING_SESSION_ID,CORRECTIVE_ACTION_ID,PERFORMANCE_SUMMARY_ID WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM ATTACHMENT WHERE ID=?";
	}
	
	@Override
	protected Attachment extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	Attachment nextResult = new Attachment();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setFileUri(rs.getString("FILE_URI"));

nextResult.setName(rs.getString("NAME"));

AdhocCoachingSession adhoccoachingsession = new AdhocCoachingSession();
adhoccoachingsession.setID(rs.getString("ADHOC_COACHING_SESSION_ID"));
nextResult.setAdhocCoachingSession(adhoccoachingsession);

CoachingSession coachingsession = new CoachingSession();
coachingsession.setID(rs.getString("COACHING_SESSION_ID"));
nextResult.setCoachingSession(coachingsession);

CorrectiveAction correctiveaction = new CorrectiveAction();
correctiveaction.setID(rs.getString("CORRECTIVE_ACTION_ID"));
nextResult.setCorrectiveAction(correctiveaction);

PerformanceSummary performancesummary = new PerformanceSummary();
performancesummary.setID(rs.getString("PERFORMANCE_SUMMARY_ID"));
nextResult.setPerformanceSummary(performancesummary);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(Attachment perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getFileUri());
pstmt.setString(3, perceroObject.getName());

if (perceroObject.getAdhocCoachingSession() == null)
{
pstmt.setString(4, null);
}
else
{
		pstmt.setString(4, perceroObject.getAdhocCoachingSession().getID());
}


if (perceroObject.getCoachingSession() == null)
{
pstmt.setString(5, null);
}
else
{
		pstmt.setString(5, perceroObject.getCoachingSession().getID());
}


if (perceroObject.getCorrectiveAction() == null)
{
pstmt.setString(6, null);
}
else
{
		pstmt.setString(6, perceroObject.getCorrectiveAction().getID());
}


if (perceroObject.getPerformanceSummary() == null)
{
pstmt.setString(7, null);
}
else
{
		pstmt.setString(7, perceroObject.getPerformanceSummary().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(Attachment perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getFileUri());
pstmt.setString(2, perceroObject.getName());

if (perceroObject.getAdhocCoachingSession() == null)
{
pstmt.setString(3, null);
}
else
{
		pstmt.setString(3, perceroObject.getAdhocCoachingSession().getID());
}


if (perceroObject.getCoachingSession() == null)
{
pstmt.setString(4, null);
}
else
{
		pstmt.setString(4, perceroObject.getCoachingSession().getID());
}


if (perceroObject.getCorrectiveAction() == null)
{
pstmt.setString(5, null);
}
else
{
		pstmt.setString(5, perceroObject.getCorrectiveAction().getID());
}


if (perceroObject.getPerformanceSummary() == null)
{
pstmt.setString(6, null);
}
else
{
		pstmt.setString(6, perceroObject.getPerformanceSummary().getID());
}

pstmt.setString(7, perceroObject.getID());

		
	}

	@Override
	public List<Attachment> findByExample(Attachment theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useFileUri = StringUtils.hasText(theQueryObject.getFileUri()) && (excludeProperties == null || !excludeProperties.contains("fileUri"));

if (useFileUri)
{
sql += " WHERE ";
sql += " FILE_URI=? ";
paramValues.add(theQueryObject.getFileUri());
propertyCounter++;
}

boolean useName = StringUtils.hasText(theQueryObject.getName()) && (excludeProperties == null || !excludeProperties.contains("name"));

if (useName)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " NAME=? ";
paramValues.add(theQueryObject.getName());
propertyCounter++;
}

boolean useAdhocCoachingSessionID = theQueryObject.getAdhocCoachingSession() != null && (excludeProperties == null || !excludeProperties.contains("adhocCoachingSession"));

if (useAdhocCoachingSessionID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " ADHOC_COACHING_SESSION_ID=? ";
paramValues.add(theQueryObject.getAdhocCoachingSession().getID());
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
sql += " COACHING_SESSION_ID=? ";
paramValues.add(theQueryObject.getCoachingSession().getID());
propertyCounter++;
}

boolean useCorrectiveActionID = theQueryObject.getCorrectiveAction() != null && (excludeProperties == null || !excludeProperties.contains("correctiveAction"));

if (useCorrectiveActionID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " CORRECTIVE_ACTION_ID=? ";
paramValues.add(theQueryObject.getCorrectiveAction().getID());
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
sql += " PERFORMANCE_SUMMARY_ID=? ";
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
