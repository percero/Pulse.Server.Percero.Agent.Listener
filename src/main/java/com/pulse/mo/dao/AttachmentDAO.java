
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
		return "SELECT attachment.ID FROM Attachment attachment WHERE attachment.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT attachment.ID,attachment.name,attachment.externalID,attachment.fileUri,attachment.performanceSummary_ID,attachment.adhocCoachingSession_ID,attachment.coachingSession_ID,attachment.correctiveAction_ID FROM Attachment attachment WHERE attachment.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT attachment.ID FROM Attachment attachment ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT attachment.ID FROM Attachment attachment ORDER BY attachment.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT attachment.ID,attachment.name,attachment.externalID,attachment.fileUri,attachment.performanceSummary_ID,attachment.adhocCoachingSession_ID,attachment.coachingSession_ID,attachment.correctiveAction_ID FROM Attachment attachment ORDER BY attachment.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT attachment.ID,attachment.name,attachment.externalID,attachment.fileUri,attachment.performanceSummary_ID,attachment.adhocCoachingSession_ID,attachment.coachingSession_ID,attachment.correctiveAction_ID FROM Attachment attachment ORDER BY attachment.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM Attachment attachment";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT attachment.ID,attachment.name,attachment.externalID,attachment.fileUri,attachment.performanceSummary_ID,attachment.adhocCoachingSession_ID,attachment.coachingSession_ID,attachment.correctiveAction_ID FROM Attachment attachment WHERE attachment.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT attachment.ID FROM Attachment attachment WHERE attachment.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT attachment.ID,attachment.name,attachment.externalID,attachment.fileUri,attachment.performanceSummary_ID,attachment.adhocCoachingSession_ID,attachment.coachingSession_ID,attachment.correctiveAction_ID FROM Attachment attachment WHERE attachment." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT attachment.ID FROM Attachment attachment WHERE attachment." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT attachment.ID FROM Attachment attachment ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT attachment.ID,attachment.name,attachment.externalID,attachment.fileUri,attachment.performanceSummary_ID,attachment.adhocCoachingSession_ID,attachment.coachingSession_ID,attachment.correctiveAction_ID FROM Attachment attachment ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO Attachment (ID,name,externalID,fileUri,performanceSummary_ID,adhocCoachingSession_ID,coachingSession_ID,correctiveAction_ID) VALUES (?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE Attachment SET name=?,externalID=?,fileUri=?,performanceSummary_ID=?,adhocCoachingSession_ID=?,coachingSession_ID=?,correctiveAction_ID=? WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM Attachment WHERE ID=?";
	}
	
	@Override
	protected Attachment extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	Attachment nextResult = new Attachment();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setName(rs.getString("name"));

nextResult.setExternalID(rs.getString("externalID"));

nextResult.setFileUri(rs.getString("fileUri"));

PerformanceSummary performancesummary = new PerformanceSummary();
performancesummary.setID(rs.getString("performancesummary_ID"));
nextResult.setPerformanceSummary(performancesummary);

AdhocCoachingSession adhoccoachingsession = new AdhocCoachingSession();
adhoccoachingsession.setID(rs.getString("adhoccoachingsession_ID"));
nextResult.setAdhocCoachingSession(adhoccoachingsession);

CoachingSession coachingsession = new CoachingSession();
coachingsession.setID(rs.getString("coachingsession_ID"));
nextResult.setCoachingSession(coachingsession);

CorrectiveAction correctiveaction = new CorrectiveAction();
correctiveaction.setID(rs.getString("correctiveaction_ID"));
nextResult.setCorrectiveAction(correctiveaction);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(Attachment perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getName());
pstmt.setString(3, perceroObject.getExternalID());
pstmt.setString(4, perceroObject.getFileUri());

if (perceroObject.getPerformanceSummary() == null)
{
pstmt.setString(5, null);
}
else
{
		pstmt.setString(5, perceroObject.getPerformanceSummary().getID());
}


if (perceroObject.getAdhocCoachingSession() == null)
{
pstmt.setString(6, null);
}
else
{
		pstmt.setString(6, perceroObject.getAdhocCoachingSession().getID());
}


if (perceroObject.getCoachingSession() == null)
{
pstmt.setString(7, null);
}
else
{
		pstmt.setString(7, perceroObject.getCoachingSession().getID());
}


if (perceroObject.getCorrectiveAction() == null)
{
pstmt.setString(8, null);
}
else
{
		pstmt.setString(8, perceroObject.getCorrectiveAction().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(Attachment perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getName());
pstmt.setString(2, perceroObject.getExternalID());
pstmt.setString(3, perceroObject.getFileUri());

if (perceroObject.getPerformanceSummary() == null)
{
pstmt.setString(4, null);
}
else
{
		pstmt.setString(4, perceroObject.getPerformanceSummary().getID());
}


if (perceroObject.getAdhocCoachingSession() == null)
{
pstmt.setString(5, null);
}
else
{
		pstmt.setString(5, perceroObject.getAdhocCoachingSession().getID());
}


if (perceroObject.getCoachingSession() == null)
{
pstmt.setString(6, null);
}
else
{
		pstmt.setString(6, perceroObject.getCoachingSession().getID());
}


if (perceroObject.getCorrectiveAction() == null)
{
pstmt.setString(7, null);
}
else
{
		pstmt.setString(7, perceroObject.getCorrectiveAction().getID());
}

pstmt.setString(8, perceroObject.getID());

		
	}

	@Override
	public List<Attachment> findByExample(Attachment theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useName = StringUtils.hasText(theQueryObject.getName()) && (excludeProperties == null || !excludeProperties.contains("name"));

if (useName)
{
sql += " WHERE ";
paramValues.add(theQueryObject.getName());
propertyCounter++;
}

boolean useExternalID = StringUtils.hasText(theQueryObject.getExternalID()) && (excludeProperties == null || !excludeProperties.contains("externalID"));

if (useExternalID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " externalID=? ";
paramValues.add(theQueryObject.getExternalID());
propertyCounter++;
}

boolean useFileUri = StringUtils.hasText(theQueryObject.getFileUri()) && (excludeProperties == null || !excludeProperties.contains("fileUri"));

if (useFileUri)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " fileUri=? ";
paramValues.add(theQueryObject.getFileUri());
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
sql += " adhocCoachingSessionID=? ";
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
sql += " coachingSessionID=? ";
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
sql += " correctiveActionID=? ";
paramValues.add(theQueryObject.getCorrectiveAction().getID());
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
