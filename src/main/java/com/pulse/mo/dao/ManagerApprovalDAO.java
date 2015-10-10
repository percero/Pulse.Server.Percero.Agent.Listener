
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
import com.pulse.mo.ManagerApproval;
import com.pulse.mo.CorrectiveAction;

*/

@Component
public class ManagerApprovalDAO extends SqlDataAccessObject<ManagerApproval> implements IDataAccessObject<ManagerApproval> {

	static final Logger log = Logger.getLogger(ManagerApprovalDAO.class);

	
	public ManagerApprovalDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(ManagerApproval.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	
	
	
	@Override
	protected String getConnectionFactoryName() {
		return ManagerApprovalDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT \"MANAGER_APPROVAL\".\"ID\" FROM \"MANAGER_APPROVAL\" \"MANAGER_APPROVAL\" WHERE \"MANAGER_APPROVAL\".\"ID\"=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT \"MANAGER_APPROVAL\".\"ID\",\"MANAGER_APPROVAL\".\"NAME\",\"MANAGER_APPROVAL\".\"DATE\" FROM \"MANAGER_APPROVAL\" \"MANAGER_APPROVAL\" WHERE \"MANAGER_APPROVAL\".\"ID\"=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT \"MANAGER_APPROVAL\".\"ID\" FROM \"MANAGER_APPROVAL\" \"MANAGER_APPROVAL\" ORDER BY \"ID\"";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT \"MANAGER_APPROVAL\".\"ID\" FROM \"MANAGER_APPROVAL\" \"MANAGER_APPROVAL\" ORDER BY \"MANAGER_APPROVAL\".\"ID\" LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT \"MANAGER_APPROVAL\".\"ID\",\"MANAGER_APPROVAL\".\"NAME\",\"MANAGER_APPROVAL\".\"DATE\" FROM \"MANAGER_APPROVAL\" \"MANAGER_APPROVAL\" ORDER BY \"MANAGER_APPROVAL\".\"ID\"";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT \"MANAGER_APPROVAL\".\"ID\",\"MANAGER_APPROVAL\".\"NAME\",\"MANAGER_APPROVAL\".\"DATE\" FROM \"MANAGER_APPROVAL\" \"MANAGER_APPROVAL\" ORDER BY \"MANAGER_APPROVAL\".\"ID\" LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM \"MANAGER_APPROVAL\" \"MANAGER_APPROVAL\"";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT \"MANAGER_APPROVAL\".\"ID\",\"MANAGER_APPROVAL\".\"NAME\",\"MANAGER_APPROVAL\".\"DATE\" FROM \"MANAGER_APPROVAL\" \"MANAGER_APPROVAL\" WHERE \"MANAGER_APPROVAL\".\"ID\" IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT \"MANAGER_APPROVAL\".\"ID\" FROM \"MANAGER_APPROVAL\" \"MANAGER_APPROVAL\" WHERE \"MANAGER_APPROVAL\".\"ID\" IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		return "SELECT \"MANAGER_APPROVAL\".\"ID\",\"MANAGER_APPROVAL\".\"NAME\",\"MANAGER_APPROVAL\".\"DATE\" FROM \"MANAGER_APPROVAL\" \"MANAGER_APPROVAL\" WHERE \"MANAGER_APPROVAL\"." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT \"MANAGER_APPROVAL\".\"ID\" FROM \"MANAGER_APPROVAL\" \"MANAGER_APPROVAL\" WHERE \"MANAGER_APPROVAL\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT \"MANAGER_APPROVAL\".\"ID\" FROM \"MANAGER_APPROVAL\" \"MANAGER_APPROVAL\" ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT \"MANAGER_APPROVAL\".\"ID\",\"MANAGER_APPROVAL\".\"NAME\",\"MANAGER_APPROVAL\".\"DATE\" FROM \"MANAGER_APPROVAL\" \"MANAGER_APPROVAL\" ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO MANAGER_APPROVAL (\"ID\",\"NAME\",\"DATE\") VALUES (?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE \"MANAGER_APPROVAL\" SET \"NAME\"=?,\"DATE\"=? WHERE \"ID\"=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM \"MANAGER_APPROVAL\" WHERE \"ID\"=?";
	}
	
	@Override
	protected ManagerApproval extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	ManagerApproval nextResult = new ManagerApproval();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setName(rs.getString("NAME"));

nextResult.setDate(rs.getDate("DATE"));


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(ManagerApproval perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getName());
pstmt.setDate(3, DateUtils.utilDateToSqlDate(perceroObject.getDate()));

		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(ManagerApproval perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getName());
pstmt.setDate(2, DateUtils.utilDateToSqlDate(perceroObject.getDate()));
pstmt.setString(3, perceroObject.getID());

		
	}

	@Override
	public List<ManagerApproval> findByExample(ManagerApproval theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useName = StringUtils.hasText(theQueryObject.getName()) && (excludeProperties == null || !excludeProperties.contains("name"));

if (useName)
{
sql += " WHERE ";
sql += " \"NAME\" =? ";
paramValues.add(theQueryObject.getName());
propertyCounter++;
}

boolean useDate = theQueryObject.getDate() != null && (excludeProperties == null || !excludeProperties.contains("date"));

if (useDate)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"DATE\" =? ";
paramValues.add(theQueryObject.getDate());
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
