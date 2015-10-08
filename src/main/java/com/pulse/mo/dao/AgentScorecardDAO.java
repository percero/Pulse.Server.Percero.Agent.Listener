
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
import com.pulse.mo.AgentScorecard;
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
	@Override
	protected String getConnectionFactoryName() {
		return AgentScorecardDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT AGENT_SCORECARD.ID FROM AGENT_SCORECARD AGENT_SCORECARD WHERE AGENT_SCORECARD.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT AGENT_SCORECARD.ID,AGENT_SCORECARD.AGENT_ID,AGENT_SCORECARD.SCORECARD_ID FROM AGENT_SCORECARD AGENT_SCORECARD WHERE AGENT_SCORECARD.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT AGENT_SCORECARD.ID FROM AGENT_SCORECARD AGENT_SCORECARD ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT AGENT_SCORECARD.ID FROM AGENT_SCORECARD AGENT_SCORECARD ORDER BY AGENT_SCORECARD.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT AGENT_SCORECARD.ID,AGENT_SCORECARD.AGENT_ID,AGENT_SCORECARD.SCORECARD_ID FROM AGENT_SCORECARD AGENT_SCORECARD ORDER BY AGENT_SCORECARD.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT AGENT_SCORECARD.ID,AGENT_SCORECARD.AGENT_ID,AGENT_SCORECARD.SCORECARD_ID FROM AGENT_SCORECARD AGENT_SCORECARD ORDER BY AGENT_SCORECARD.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM AGENT_SCORECARD AGENT_SCORECARD";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT AGENT_SCORECARD.ID,AGENT_SCORECARD.AGENT_ID,AGENT_SCORECARD.SCORECARD_ID FROM AGENT_SCORECARD AGENT_SCORECARD WHERE AGENT_SCORECARD.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT AGENT_SCORECARD.ID FROM AGENT_SCORECARD AGENT_SCORECARD WHERE AGENT_SCORECARD.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT AGENT_SCORECARD.ID,AGENT_SCORECARD.AGENT_ID,AGENT_SCORECARD.SCORECARD_ID FROM AGENT_SCORECARD AGENT_SCORECARD WHERE AGENT_SCORECARD." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT AGENT_SCORECARD.ID FROM AGENT_SCORECARD AGENT_SCORECARD WHERE AGENT_SCORECARD." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT AGENT_SCORECARD.ID FROM AGENT_SCORECARD AGENT_SCORECARD ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT AGENT_SCORECARD.ID,AGENT_SCORECARD.AGENT_ID,AGENT_SCORECARD.SCORECARD_ID FROM AGENT_SCORECARD AGENT_SCORECARD ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO AGENT_SCORECARD (ID,AGENT_ID,SCORECARD_ID) VALUES (?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE AGENT_SCORECARD SET AGENT_ID,SCORECARD_ID WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM AGENT_SCORECARD WHERE ID=?";
	}
	
	@Override
	protected AgentScorecard extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	AgentScorecard nextResult = new AgentScorecard();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			Agent agent = new Agent();
agent.setID(rs.getString("AGENT_ID"));
nextResult.setAgent(agent);

Scorecard scorecard = new Scorecard();
scorecard.setID(rs.getString("SCORECARD_ID"));
nextResult.setScorecard(scorecard);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(AgentScorecard perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());

if (perceroObject.getAgent() == null)
{
pstmt.setString(2, null);
}
else
{
		pstmt.setString(2, perceroObject.getAgent().getID());
}


if (perceroObject.getScorecard() == null)
{
pstmt.setString(3, null);
}
else
{
		pstmt.setString(3, perceroObject.getScorecard().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(AgentScorecard perceroObject, PreparedStatement pstmt) throws SQLException {
		
		
if (perceroObject.getAgent() == null)
{
pstmt.setString(1, null);
}
else
{
		pstmt.setString(1, perceroObject.getAgent().getID());
}


if (perceroObject.getScorecard() == null)
{
pstmt.setString(2, null);
}
else
{
		pstmt.setString(2, perceroObject.getScorecard().getID());
}

pstmt.setString(3, perceroObject.getID());

		
	}

	@Override
	public List<AgentScorecard> findByExample(AgentScorecard theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useAgentID = theQueryObject.getAgent() != null && (excludeProperties == null || !excludeProperties.contains("agent"));

if (useAgentID)
{
sql += " WHERE ";
sql += " AGENT_ID=? ";
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
sql += " SCORECARD_ID=? ";
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
	
}
