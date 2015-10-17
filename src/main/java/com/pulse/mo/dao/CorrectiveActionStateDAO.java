
package com.pulse.mo.dao;

import java.sql.PreparedStatement;
import java.sql.CallableStatement;
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
import com.pulse.mo.CorrectiveActionState;
import com.pulse.mo.CorrectiveAction;

*/

@Component
public class CorrectiveActionStateDAO extends SqlDataAccessObject<CorrectiveActionState> implements IDataAccessObject<CorrectiveActionState> {

	static final Logger log = Logger.getLogger(CorrectiveActionStateDAO.class);

	
	public CorrectiveActionStateDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(CorrectiveActionState.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	
	public static final String SQL_VIEW = ",\"CORRECTIVE_ACTION_STATE\".\"NAME\"";
	private String selectFromStatementTableName = " FROM \"CORRECTIVE_ACTION_STATE\" \"CORRECTIVE_ACTION_STATE\"";
	private String whereClause = "  WHERE \"CORRECTIVE_ACTION_STATE\".\"ID\"=?";
	private String whereInClause = "  join table(sys.dbms_debug_vc2coll(?)) SQLLIST on \"CORRECTIVE_ACTION_STATE\".\"ID\"= SQLLIST.column_value";
	private String orderByTableName = "  ORDER BY \"CORRECTIVE_ACTION_STATE\".\"ID\"";
	
	

	
	@Override
	protected String getConnectionFactoryName() {
		return CorrectiveActionStateDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT \"CORRECTIVE_ACTION_STATE\".\"ID\" " + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT \"CORRECTIVE_ACTION_STATE\".\"ID\"" + SQL_VIEW  + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT \"CORRECTIVE_ACTION_STATE\".\"ID\" " + selectFromStatementTableName +  orderByTableName;
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT \"CORRECTIVE_ACTION_STATE\".\"ID\" " + selectFromStatementTableName  +  orderByTableName  + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT \"CORRECTIVE_ACTION_STATE\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName  + orderByTableName;
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT \"CORRECTIVE_ACTION_STATE\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + orderByTableName + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() 
	{
		return "SELECT COUNT(ID) " + selectFromStatementTableName;
	}
	
	@Override
	protected String getSelectInStarSQL() 
	{
		return "SELECT \"CORRECTIVE_ACTION_STATE\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + whereInClause;
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT \"CORRECTIVE_ACTION_STATE\".\"ID\" " + selectFromStatementTableName + whereInClause;
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		
		return "SELECT \"CORRECTIVE_ACTION_STATE\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + " WHERE \"CORRECTIVE_ACTION_STATE\"." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) 
	{
		
		return "SELECT \"CORRECTIVE_ACTION_STATE\".\"ID\" " + selectFromStatementTableName + " WHERE \"CORRECTIVE_ACTION_STATE\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT \"CORRECTIVE_ACTION_STATE\".\"ID\" " + selectFromStatementTableName;
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT \"CORRECTIVE_ACTION_STATE\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName;
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO CORRECTIVE_ACTION_STATE (\"ID\",\"NAME\") VALUES (?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE \"TBL_CORRECTIVE_ACTION_STATE\" SET \"NAME\"=? WHERE \"ID\"=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM \"TBL_CORRECTIVE_ACTION_STATE\" WHERE \"ID\"=?";
	}
	
	@Override
	protected CorrectiveActionState extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	CorrectiveActionState nextResult = new CorrectiveActionState();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setName(rs.getString("NAME"));


			
    	}
    	
    	return nextResult;
	}
	
	protected void setBaseStatmentInsertParams(CorrectiveActionState perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getName());

		
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(CorrectiveActionState perceroObject, PreparedStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
		
	}
	
	@Override
	protected void setCallableStatmentInsertParams(CorrectiveActionState perceroObject, CallableStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	

	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(CorrectiveActionState perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getName());
pstmt.setString(2, perceroObject.getID());

		
	}
	
	
	@Override
	protected void setCallableStatmentUpdateParams(CorrectiveActionState perceroObject, CallableStatement pstmt) throws SQLException 
	{
		
		//must be in same order as insert
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	}
	
	

	@Override
	public List<CorrectiveActionState> findByExample(CorrectiveActionState theQueryObject,
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
	
	@Override
	protected String getUpdateCallableStatementSql() {
		return "{call UPDATE_CORRECTIVE_ACTION_STATE(?,?)}";
	}
	@Override
	protected String getInsertCallableStatementSql() {
		return "{call CREATE_CORRECTIVE_ACTION_STATE(?,?)}";
	}
	@Override
	protected String getDeleteCallableStatementSql() {
		return "{call Delete_CORRECTIVE_ACTION_STATE(?)}";
	}
	
	
	
	
}
