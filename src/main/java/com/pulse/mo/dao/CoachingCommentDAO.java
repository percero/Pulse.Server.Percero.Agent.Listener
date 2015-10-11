
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
import com.pulse.mo.CoachingComment;
import com.pulse.mo.AdhocCoachingSession;

*/

@Component
public class CoachingCommentDAO extends SqlDataAccessObject<CoachingComment> implements IDataAccessObject<CoachingComment> {

	static final Logger log = Logger.getLogger(CoachingCommentDAO.class);

	
	public CoachingCommentDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(CoachingComment.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	
	
	
	@Override
	protected String getConnectionFactoryName() {
		return CoachingCommentDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT \"COACHING_COMMENT\".\"ID\" FROM \"COACHING_COMMENT\" \"COACHING_COMMENT\" WHERE \"COACHING_COMMENT\".\"ID\"=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT \"COACHING_COMMENT\".\"ID\",\"COACHING_COMMENT\".\"COMMENT\",\"COACHING_COMMENT\".\"ADHOC_COACHING_SESSION_ID\" FROM \"COACHING_COMMENT\" \"COACHING_COMMENT\" WHERE \"COACHING_COMMENT\".\"ID\"=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT \"COACHING_COMMENT\".\"ID\" FROM \"COACHING_COMMENT\" \"COACHING_COMMENT\" ORDER BY \"ID\"";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT \"COACHING_COMMENT\".\"ID\" FROM \"COACHING_COMMENT\" \"COACHING_COMMENT\" ORDER BY \"COACHING_COMMENT\".\"ID\" LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT \"COACHING_COMMENT\".\"ID\",\"COACHING_COMMENT\".\"COMMENT\",\"COACHING_COMMENT\".\"ADHOC_COACHING_SESSION_ID\" FROM \"COACHING_COMMENT\" \"COACHING_COMMENT\" ORDER BY \"COACHING_COMMENT\".\"ID\"";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT \"COACHING_COMMENT\".\"ID\",\"COACHING_COMMENT\".\"COMMENT\",\"COACHING_COMMENT\".\"ADHOC_COACHING_SESSION_ID\" FROM \"COACHING_COMMENT\" \"COACHING_COMMENT\" ORDER BY \"COACHING_COMMENT\".\"ID\" LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM \"COACHING_COMMENT\" \"COACHING_COMMENT\"";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT \"COACHING_COMMENT\".\"ID\",\"COACHING_COMMENT\".\"COMMENT\",\"COACHING_COMMENT\".\"ADHOC_COACHING_SESSION_ID\" FROM \"COACHING_COMMENT\" \"COACHING_COMMENT\" WHERE \"COACHING_COMMENT\".\"ID\" IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT \"COACHING_COMMENT\".\"ID\" FROM \"COACHING_COMMENT\" \"COACHING_COMMENT\" WHERE \"COACHING_COMMENT\".\"ID\" IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		return "SELECT \"COACHING_COMMENT\".\"ID\",\"COACHING_COMMENT\".\"COMMENT\",\"COACHING_COMMENT\".\"ADHOC_COACHING_SESSION_ID\" FROM \"COACHING_COMMENT\" \"COACHING_COMMENT\" WHERE \"COACHING_COMMENT\"." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT \"COACHING_COMMENT\".\"ID\" FROM \"COACHING_COMMENT\" \"COACHING_COMMENT\" WHERE \"COACHING_COMMENT\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT \"COACHING_COMMENT\".\"ID\" FROM \"COACHING_COMMENT\" \"COACHING_COMMENT\" ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT \"COACHING_COMMENT\".\"ID\",\"COACHING_COMMENT\".\"COMMENT\",\"COACHING_COMMENT\".\"ADHOC_COACHING_SESSION_ID\" FROM \"COACHING_COMMENT\" \"COACHING_COMMENT\" ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO COACHING_COMMENT (\"ID\",\"COMMENT\",\"ADHOC_COACHING_SESSION_ID\") VALUES (?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE \"COACHING_COMMENT\" SET \"COMMENT\"=?,\"ADHOC_COACHING_SESSION_ID\"=? WHERE \"ID\"=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM \"COACHING_COMMENT\" WHERE \"ID\"=?";
	}
	
	@Override
	protected CoachingComment extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	CoachingComment nextResult = new CoachingComment();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setComment(rs.getString("COMMENT"));

AdhocCoachingSession adhoccoachingsession = new AdhocCoachingSession();
adhoccoachingsession.setID(rs.getString("ADHOC_COACHING_SESSION_ID"));
nextResult.setAdhocCoachingSession(adhoccoachingsession);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(CoachingComment perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getComment());

if (perceroObject.getAdhocCoachingSession() == null)
{
pstmt.setString(3, null);
}
else
{
		pstmt.setString(3, perceroObject.getAdhocCoachingSession().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(CoachingComment perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getComment());

if (perceroObject.getAdhocCoachingSession() == null)
{
pstmt.setString(2, null);
}
else
{
		pstmt.setString(2, perceroObject.getAdhocCoachingSession().getID());
}

pstmt.setString(3, perceroObject.getID());

		
	}

	@Override
	public List<CoachingComment> findByExample(CoachingComment theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useComment = StringUtils.hasText(theQueryObject.getComment()) && (excludeProperties == null || !excludeProperties.contains("comment"));

if (useComment)
{
sql += " WHERE ";
sql += " \"COMMENT\" =? ";
paramValues.add(theQueryObject.getComment());
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
sql += " \"ADHOC_COACHING_SESSION_ID\" =? ";
paramValues.add(theQueryObject.getAdhocCoachingSession().getID());
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
