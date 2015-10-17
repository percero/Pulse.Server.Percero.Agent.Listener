
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
import com.pulse.mo.ThresholdGradeScale;

*/

@Component
public class ThresholdGradeScaleDAO extends SqlDataAccessObject<ThresholdGradeScale> implements IDataAccessObject<ThresholdGradeScale> {

	static final Logger log = Logger.getLogger(ThresholdGradeScaleDAO.class);

	
	public ThresholdGradeScaleDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(ThresholdGradeScale.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	
	public static final String SQL_VIEW = "";
	private String selectFromStatementTableName = " FROM \"THRESHOLD_GRADE_SCALE\" \"THRESHOLD_GRADE_SCALE\"";
	private String whereClause = "  WHERE \"THRESHOLD_GRADE_SCALE\".\"ID\"=?";
	private String whereInClause = "  join table(sys.dbms_debug_vc2coll(?)) SQLLIST on \"THRESHOLD_GRADE_SCALE\".\"ID\"= SQLLIST.column_value";
	private String orderByTableName = "  ORDER BY \"THRESHOLD_GRADE_SCALE\".\"ID\"";
	
	

	
	@Override
	protected String getConnectionFactoryName() {
		return ThresholdGradeScaleDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT \"THRESHOLD_GRADE_SCALE\".\"ID\" " + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT \"THRESHOLD_GRADE_SCALE\".\"ID\"" + SQL_VIEW  + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT \"THRESHOLD_GRADE_SCALE\".\"ID\" " + selectFromStatementTableName +  orderByTableName;
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT \"THRESHOLD_GRADE_SCALE\".\"ID\" " + selectFromStatementTableName  +  orderByTableName  + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT \"THRESHOLD_GRADE_SCALE\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName  + orderByTableName;
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT \"THRESHOLD_GRADE_SCALE\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + orderByTableName + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() 
	{
		return "SELECT COUNT(ID) " + selectFromStatementTableName;
	}
	
	@Override
	protected String getSelectInStarSQL() 
	{
		return "SELECT \"THRESHOLD_GRADE_SCALE\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + whereInClause;
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT \"THRESHOLD_GRADE_SCALE\".\"ID\" " + selectFromStatementTableName + whereInClause;
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		
		return "SELECT \"THRESHOLD_GRADE_SCALE\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + " WHERE \"THRESHOLD_GRADE_SCALE\"." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) 
	{
		
		return "SELECT \"THRESHOLD_GRADE_SCALE\".\"ID\" " + selectFromStatementTableName + " WHERE \"THRESHOLD_GRADE_SCALE\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT \"THRESHOLD_GRADE_SCALE\".\"ID\" " + selectFromStatementTableName;
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT \"THRESHOLD_GRADE_SCALE\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName;
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO THRESHOLD_GRADE_SCALE (\"ID\") VALUES (?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE \"TBL_THRESHOLD_GRADE_SCALE\" SET  WHERE \"ID\"=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM \"TBL_THRESHOLD_GRADE_SCALE\" WHERE \"ID\"=?";
	}
	
	@Override
	protected ThresholdGradeScale extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	ThresholdGradeScale nextResult = new ThresholdGradeScale();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			
			
    	}
    	
    	return nextResult;
	}
	
	protected void setBaseStatmentInsertParams(ThresholdGradeScale perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());

		
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(ThresholdGradeScale perceroObject, PreparedStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
		
	}
	
	@Override
	protected void setCallableStatmentInsertParams(ThresholdGradeScale perceroObject, CallableStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	

	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(ThresholdGradeScale perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());

		
	}
	
	
	@Override
	protected void setCallableStatmentUpdateParams(ThresholdGradeScale perceroObject, CallableStatement pstmt) throws SQLException 
	{
		
		//must be in same order as insert
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	}
	
	

	@Override
	public List<ThresholdGradeScale> findByExample(ThresholdGradeScale theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		
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
		return "{call UPDATE_THRESHOLD_GRADE_SCALE(?)}";
	}
	@Override
	protected String getInsertCallableStatementSql() {
		return "{call CREATE_THRESHOLD_GRADE_SCALE(?)}";
	}
	@Override
	protected String getDeleteCallableStatementSql() {
		return "{call Delete_THRESHOLD_GRADE_SCALE(?)}";
	}
	
	
	
	
}
