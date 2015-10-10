
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
import com.pulse.mo.HRApproval;
import com.pulse.mo.CorrectiveAction;

*/

@Component
public class HRApprovalDAO extends SqlDataAccessObject<HRApproval> implements IDataAccessObject<HRApproval> {

	static final Logger log = Logger.getLogger(HRApprovalDAO.class);

	
	public HRApprovalDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(HRApproval.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	
	
	
	@Override
	protected String getConnectionFactoryName() {
		return HRApprovalDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT \"HR_APPROVAL\".\"ID\" FROM \"HR_APPROVAL\" \"HR_APPROVAL\" WHERE \"HR_APPROVAL\".\"ID\"=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT \"HR_APPROVAL\".\"ID\",\"HR_APPROVAL\".\"NAME\",\"HR_APPROVAL\".\"DATE\" FROM \"HR_APPROVAL\" \"HR_APPROVAL\" WHERE \"HR_APPROVAL\".\"ID\"=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT \"HR_APPROVAL\".\"ID\" FROM \"HR_APPROVAL\" \"HR_APPROVAL\" ORDER BY \"ID\"";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT \"HR_APPROVAL\".\"ID\" FROM \"HR_APPROVAL\" \"HR_APPROVAL\" ORDER BY \"HR_APPROVAL\".\"ID\" LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT \"HR_APPROVAL\".\"ID\",\"HR_APPROVAL\".\"NAME\",\"HR_APPROVAL\".\"DATE\" FROM \"HR_APPROVAL\" \"HR_APPROVAL\" ORDER BY \"HR_APPROVAL\".\"ID\"";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT \"HR_APPROVAL\".\"ID\",\"HR_APPROVAL\".\"NAME\",\"HR_APPROVAL\".\"DATE\" FROM \"HR_APPROVAL\" \"HR_APPROVAL\" ORDER BY \"HR_APPROVAL\".\"ID\" LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM \"HR_APPROVAL\" \"HR_APPROVAL\"";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT \"HR_APPROVAL\".\"ID\",\"HR_APPROVAL\".\"NAME\",\"HR_APPROVAL\".\"DATE\" FROM \"HR_APPROVAL\" \"HR_APPROVAL\" WHERE \"HR_APPROVAL\".\"ID\" IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT \"HR_APPROVAL\".\"ID\" FROM \"HR_APPROVAL\" \"HR_APPROVAL\" WHERE \"HR_APPROVAL\".\"ID\" IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		return "SELECT \"HR_APPROVAL\".\"ID\",\"HR_APPROVAL\".\"NAME\",\"HR_APPROVAL\".\"DATE\" FROM \"HR_APPROVAL\" \"HR_APPROVAL\" WHERE \"HR_APPROVAL\"." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT \"HR_APPROVAL\".\"ID\" FROM \"HR_APPROVAL\" \"HR_APPROVAL\" WHERE \"HR_APPROVAL\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT \"HR_APPROVAL\".\"ID\" FROM \"HR_APPROVAL\" \"HR_APPROVAL\" ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT \"HR_APPROVAL\".\"ID\",\"HR_APPROVAL\".\"NAME\",\"HR_APPROVAL\".\"DATE\" FROM \"HR_APPROVAL\" \"HR_APPROVAL\" ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO HR_APPROVAL (\"ID\",\"NAME\",\"DATE\") VALUES (?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE \"HR_APPROVAL\" SET \"NAME\"=?,\"DATE\"=? WHERE \"ID\"=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM \"HR_APPROVAL\" WHERE \"ID\"=?";
	}
	
	@Override
	protected HRApproval extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	HRApproval nextResult = new HRApproval();
    	
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
	protected void setPreparedStatmentInsertParams(HRApproval perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getName());
pstmt.setDate(3, DateUtils.utilDateToSqlDate(perceroObject.getDate()));

		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(HRApproval perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getName());
pstmt.setDate(2, DateUtils.utilDateToSqlDate(perceroObject.getDate()));
pstmt.setString(3, perceroObject.getID());

		
	}

	@Override
	public List<HRApproval> findByExample(HRApproval theQueryObject,
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
