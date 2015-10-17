
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
import com.pulse.mo.ThresholdLevel;
import com.pulse.mo.ThresholdScale;

*/

@Component
public class ThresholdLevelDAO extends SqlDataAccessObject<ThresholdLevel> implements IDataAccessObject<ThresholdLevel> {

	static final Logger log = Logger.getLogger(ThresholdLevelDAO.class);

	
	public ThresholdLevelDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(ThresholdLevel.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	
	public static final String SQL_VIEW = ",\"THRESHOLD_LEVEL\".\"COLOR\",\"THRESHOLD_LEVEL\".\"END_EXPRESSION\",\"THRESHOLD_LEVEL\".\"END_VALUE\",\"THRESHOLD_LEVEL\".\"EXPRESSION_OPERATOR\",\"THRESHOLD_LEVEL\".\"START_EXPRESSION\",\"THRESHOLD_LEVEL\".\"START_VALUE\",\"THRESHOLD_LEVEL\".\"THRESHOLD_SCALE_ID\"";
	private String selectFromStatementTableName = " FROM \"THRESHOLD_LEVEL\" \"THRESHOLD_LEVEL\"";
	private String whereClause = "  WHERE \"THRESHOLD_LEVEL\".\"ID\"=?";
	private String whereInClause = "  join table(sys.dbms_debug_vc2coll(?)) SQLLIST on \"THRESHOLD_LEVEL\".\"ID\"= SQLLIST.column_value";
	private String orderByTableName = "  ORDER BY \"THRESHOLD_LEVEL\".\"ID\"";
	
	

	
	@Override
	protected String getConnectionFactoryName() {
		return ThresholdLevelDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT \"THRESHOLD_LEVEL\".\"ID\" " + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT \"THRESHOLD_LEVEL\".\"ID\"" + SQL_VIEW  + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT \"THRESHOLD_LEVEL\".\"ID\" " + selectFromStatementTableName +  orderByTableName;
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT \"THRESHOLD_LEVEL\".\"ID\" " + selectFromStatementTableName  +  orderByTableName  + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT \"THRESHOLD_LEVEL\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName  + orderByTableName;
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT \"THRESHOLD_LEVEL\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + orderByTableName + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() 
	{
		return "SELECT COUNT(ID) " + selectFromStatementTableName;
	}
	
	@Override
	protected String getSelectInStarSQL() 
	{
		return "SELECT \"THRESHOLD_LEVEL\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + whereInClause;
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT \"THRESHOLD_LEVEL\".\"ID\" " + selectFromStatementTableName + whereInClause;
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		
		return "SELECT \"THRESHOLD_LEVEL\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + " WHERE \"THRESHOLD_LEVEL\"." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) 
	{
		
		return "SELECT \"THRESHOLD_LEVEL\".\"ID\" " + selectFromStatementTableName + " WHERE \"THRESHOLD_LEVEL\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT \"THRESHOLD_LEVEL\".\"ID\" " + selectFromStatementTableName;
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT \"THRESHOLD_LEVEL\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName;
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO THRESHOLD_LEVEL (\"ID\",\"COLOR\",\"END_EXPRESSION\",\"END_VALUE\",\"EXPRESSION_OPERATOR\",\"START_EXPRESSION\",\"START_VALUE\",\"THRESHOLD_SCALE_ID\") VALUES (?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE \"TBL_THRESHOLD_LEVEL\" SET \"COLOR\"=?,\"END_EXPRESSION\"=?,\"END_VALUE\"=?,\"EXPRESSION_OPERATOR\"=?,\"START_EXPRESSION\"=?,\"START_VALUE\"=?,\"THRESHOLD_SCALE_ID\"=? WHERE \"ID\"=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM \"TBL_THRESHOLD_LEVEL\" WHERE \"ID\"=?";
	}
	
	@Override
	protected ThresholdLevel extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	ThresholdLevel nextResult = new ThresholdLevel();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setColor(rs.getString("COLOR"));

nextResult.setEndExpression(rs.getString("END_EXPRESSION"));

nextResult.setEndValue(rs.getString("END_VALUE"));

nextResult.setExpressionOperator(rs.getString("EXPRESSION_OPERATOR"));

nextResult.setStartExpression(rs.getString("START_EXPRESSION"));

nextResult.setStartValue(rs.getString("START_VALUE"));

ThresholdScale thresholdscale = new ThresholdScale();
thresholdscale.setID(rs.getString("THRESHOLD_SCALE_ID"));
nextResult.setThresholdScale(thresholdscale);


			
    	}
    	
    	return nextResult;
	}
	
	protected void setBaseStatmentInsertParams(ThresholdLevel perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getColor());
pstmt.setString(3, perceroObject.getEndExpression());
pstmt.setString(4, perceroObject.getEndValue());
pstmt.setString(5, perceroObject.getExpressionOperator());
pstmt.setString(6, perceroObject.getStartExpression());
pstmt.setString(7, perceroObject.getStartValue());

if (perceroObject.getThresholdScale() == null)
{
pstmt.setString(8, null);
}
else
{
		pstmt.setString(8, perceroObject.getThresholdScale().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(ThresholdLevel perceroObject, PreparedStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
		
	}
	
	@Override
	protected void setCallableStatmentInsertParams(ThresholdLevel perceroObject, CallableStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	

	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(ThresholdLevel perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getColor());
pstmt.setString(2, perceroObject.getEndExpression());
pstmt.setString(3, perceroObject.getEndValue());
pstmt.setString(4, perceroObject.getExpressionOperator());
pstmt.setString(5, perceroObject.getStartExpression());
pstmt.setString(6, perceroObject.getStartValue());

if (perceroObject.getThresholdScale() == null)
{
pstmt.setString(7, null);
}
else
{
		pstmt.setString(7, perceroObject.getThresholdScale().getID());
}

pstmt.setString(8, perceroObject.getID());

		
	}
	
	
	@Override
	protected void setCallableStatmentUpdateParams(ThresholdLevel perceroObject, CallableStatement pstmt) throws SQLException 
	{
		
		//must be in same order as insert
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	}
	
	

	@Override
	public List<ThresholdLevel> findByExample(ThresholdLevel theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useColor = StringUtils.hasText(theQueryObject.getColor()) && (excludeProperties == null || !excludeProperties.contains("color"));

if (useColor)
{
sql += " WHERE ";
sql += " \"COLOR\" =? ";
paramValues.add(theQueryObject.getColor());
propertyCounter++;
}

boolean useEndExpression = StringUtils.hasText(theQueryObject.getEndExpression()) && (excludeProperties == null || !excludeProperties.contains("endExpression"));

if (useEndExpression)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"END_EXPRESSION\" =? ";
paramValues.add(theQueryObject.getEndExpression());
propertyCounter++;
}

boolean useEndValue = StringUtils.hasText(theQueryObject.getEndValue()) && (excludeProperties == null || !excludeProperties.contains("endValue"));

if (useEndValue)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"END_VALUE\" =? ";
paramValues.add(theQueryObject.getEndValue());
propertyCounter++;
}

boolean useExpressionOperator = StringUtils.hasText(theQueryObject.getExpressionOperator()) && (excludeProperties == null || !excludeProperties.contains("expressionOperator"));

if (useExpressionOperator)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"EXPRESSION_OPERATOR\" =? ";
paramValues.add(theQueryObject.getExpressionOperator());
propertyCounter++;
}

boolean useStartExpression = StringUtils.hasText(theQueryObject.getStartExpression()) && (excludeProperties == null || !excludeProperties.contains("startExpression"));

if (useStartExpression)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"START_EXPRESSION\" =? ";
paramValues.add(theQueryObject.getStartExpression());
propertyCounter++;
}

boolean useStartValue = StringUtils.hasText(theQueryObject.getStartValue()) && (excludeProperties == null || !excludeProperties.contains("startValue"));

if (useStartValue)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"START_VALUE\" =? ";
paramValues.add(theQueryObject.getStartValue());
propertyCounter++;
}

boolean useThresholdScaleID = theQueryObject.getThresholdScale() != null && (excludeProperties == null || !excludeProperties.contains("thresholdScale"));

if (useThresholdScaleID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"THRESHOLD_SCALE_ID\" =? ";
paramValues.add(theQueryObject.getThresholdScale().getID());
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
		return "{call UPDATE_THRESHOLD_LEVEL(?,?,?,?,?,?,?,?)}";
	}
	@Override
	protected String getInsertCallableStatementSql() {
		return "{call CREATE_THRESHOLD_LEVEL(?,?,?,?,?,?,?,?)}";
	}
	@Override
	protected String getDeleteCallableStatementSql() {
		return "{call Delete_THRESHOLD_LEVEL(?)}";
	}
	
	
	
	
}
