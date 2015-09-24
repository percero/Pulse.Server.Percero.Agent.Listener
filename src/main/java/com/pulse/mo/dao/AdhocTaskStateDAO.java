
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
import com.pulse.mo.AdhocTaskState;
import com.pulse.mo.AdhocTask;

*/

@Component
public class AdhocTaskStateDAO extends SqlDataAccessObject<AdhocTaskState> implements IDataAccessObject<AdhocTaskState> {

	static final Logger log = Logger.getLogger(AdhocTaskStateDAO.class);

	
	public AdhocTaskStateDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(AdhocTaskState.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	@Override
	protected String getConnectionFactoryName() {
		return AdhocTaskStateDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT adhoctaskstate.ID FROM AdhocTaskState adhoctaskstate WHERE adhoctaskstate.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT adhoctaskstate.ID,adhoctaskstate.name,adhoctaskstate.externalID FROM AdhocTaskState adhoctaskstate WHERE adhoctaskstate.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT adhoctaskstate.ID FROM AdhocTaskState adhoctaskstate ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT adhoctaskstate.ID FROM AdhocTaskState adhoctaskstate ORDER BY adhoctaskstate.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT adhoctaskstate.ID,adhoctaskstate.name,adhoctaskstate.externalID FROM AdhocTaskState adhoctaskstate ORDER BY adhoctaskstate.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT adhoctaskstate.ID,adhoctaskstate.name,adhoctaskstate.externalID FROM AdhocTaskState adhoctaskstate ORDER BY adhoctaskstate.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM AdhocTaskState adhoctaskstate";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT adhoctaskstate.ID,adhoctaskstate.name,adhoctaskstate.externalID FROM AdhocTaskState adhoctaskstate WHERE adhoctaskstate.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT adhoctaskstate.ID FROM AdhocTaskState adhoctaskstate WHERE adhoctaskstate.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT adhoctaskstate.ID,adhoctaskstate.name,adhoctaskstate.externalID FROM AdhocTaskState adhoctaskstate WHERE adhoctaskstate." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT adhoctaskstate.ID FROM AdhocTaskState adhoctaskstate WHERE adhoctaskstate." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT adhoctaskstate.ID FROM AdhocTaskState adhoctaskstate ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT adhoctaskstate.ID,adhoctaskstate.name,adhoctaskstate.externalID FROM AdhocTaskState adhoctaskstate ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO AdhocTaskState (ID,name,externalID) VALUES (?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE AdhocTaskState SET name=?,externalID=? WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM AdhocTaskState WHERE ID=?";
	}
	
	@Override
	protected AdhocTaskState extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	AdhocTaskState nextResult = new AdhocTaskState();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setName(rs.getString("name"));

nextResult.setExternalID(rs.getString("externalID"));


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(AdhocTaskState perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getName());
pstmt.setString(3, perceroObject.getExternalID());

		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(AdhocTaskState perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getName());
pstmt.setString(2, perceroObject.getExternalID());
pstmt.setString(3, perceroObject.getID());

		
	}

	@Override
	public List<AdhocTaskState> findByExample(AdhocTaskState theQueryObject,
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
