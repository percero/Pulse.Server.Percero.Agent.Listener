

package com.pulse.mo.dao;

import com.percero.agents.sync.dao.DAORegistry;
import com.percero.agents.sync.dao.IDataAccessObject;
import com.percero.agents.sync.exceptions.SyncException;
import com.pulse.mo.LOB;
import com.pulse.mo.LOBConfigurationActivityAuxCode;
import com.pulse.mo.LOBConfigurationEntry;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class LOBConfigurationActivityAuxCodeDAO extends SqlDataAccessObject<LOBConfigurationActivityAuxCode> implements IDataAccessObject<LOBConfigurationActivityAuxCode> {

    static final Logger log = Logger.getLogger(LOBConfigurationActivityAuxCodeDAO.class);


    public LOBConfigurationActivityAuxCodeDAO() {
        super();

        DAORegistry.getInstance().registerDataAccessObject(LOBConfigurationActivityAuxCode.class.getCanonicalName(), this);
    }


    // This is the name of the Data Source that is registered to handle this class type.
    // For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
    public static final String CONNECTION_FACTORY_NAME = "default";

    public static final String SHELL_ONLY_SELECT = "\"LOB_CONF_ACTVT_ASOC_AUXCOD\".\"ID\", \"LOB_CONF_ACTVT_ASOC_AUXCOD\".\"LOB_CONFIGURATION_ENTRY_ID\"";
    public static final String SQL_VIEW = ",\"LOB_CONF_ACTVT_ASOC_AUXCOD\".\"CMS_AUX_CODE\", \"LOB_CONF_ACTVT_ASOC_AUXCOD\".\"LOB_CONFIGURATION_ENTRY_ID\"";
    private String selectFromStatementTableName = " FROM \"LOB_CONF_ACTVT_ASOC_AUXCOD\" \"LOB_CONF_ACTVT_ASOC_AUXCOD\"";
    private String whereClause = "  WHERE \"LOB_CONF_ACTVT_ASOC_AUXCOD\".\"ID\"=?";
    private String whereInClause = "  join table(sys.dbms_debug_vc2coll(?)) SQLLIST on \"LOB_CONF_ACTVT_ASOC_AUXCOD\".\"ID\"= SQLLIST.column_value";
    private String orderByTableName = "  ORDER BY \"LOB_CONF_ACTVT_ASOC_AUXCOD\".\"ID\"";


    @Override
    protected String getConnectionFactoryName() {
        return LOBConfigurationActivityAuxCodeDAO.CONNECTION_FACTORY_NAME;
    }

    @Override
    protected String getSelectShellOnlySQL() {
        return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName + whereClause;
    }

    @Override
    protected String getSelectStarSQL() {
        return "SELECT \"LOB_CONF_ACTVT_ASOC_AUXCOD\".\"ID\"" + SQL_VIEW + selectFromStatementTableName + whereClause;
    }

    @Override
    protected String getSelectAllShellOnlySQL() {
        return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName + orderByTableName;
    }

    @Override
    protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
        return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName + orderByTableName + " LIMIT ? OFFSET ?";
    }

    @Override
    protected String getSelectAllStarSQL() {
        return "SELECT \"LOB_CONF_ACTVT_ASOC_AUXCOD\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + orderByTableName;
    }

    @Override
    protected String getSelectAllStarWithLimitAndOffsetSQL() {
        return "SELECT \"LOB_CONF_ACTVT_ASOC_AUXCOD\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + orderByTableName + " LIMIT ? OFFSET ?";
    }

    @Override
    protected String getCountAllSQL() {
        return "SELECT COUNT(ID) " + selectFromStatementTableName;
    }

    @Override
    protected String getSelectInStarSQL() {
        return "SELECT \"LOB_CONF_ACTVT_ASOC_AUXCOD\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + whereInClause;
    }

    @Override
    protected String getSelectInShellOnlySQL() {
        return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName + whereInClause;
    }

    @Override
    protected String getSelectByRelationshipStarSQL(String joinColumnName) {

        return "SELECT \"LOB_CONF_ACTVT_ASOC_AUXCOD\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + " WHERE \"LOB_CONF_ACTVT_ASOC_AUXCOD\"." + joinColumnName + "=?";
    }

    @Override
    protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {

        return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName + " WHERE \"LOB_CONF_ACTVT_ASOC_AUXCOD\"." + joinColumnName + "=?";
    }

    @Override
    protected String getFindByExampleSelectShellOnlySQL() {
        return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName;
    }

    @Override
    protected String getFindByExampleSelectAllStarSQL() {
        return "SELECT \"LOB_CONF_ACTVT_ASOC_AUXCOD\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName;
    }

    @Override
    protected String getInsertIntoSQL() {
        return "INSERT INTO TBL_LOB_CONF_ACTVT_ASOC_AUXCOD (\"ID\",\"CMS_AUX_CODE\") VALUES (?,?)";
    }

    @Override
    protected String getUpdateSet() {
        return "UPDATE TBL_LOB_CONF_ACTVT_ASOC_AUXCOD SET \"CMS_AUX_CODE\"=? WHERE \"ID\"=?";
    }

    @Override
    protected String getDeleteFromSQL() {
        return "DELETE FROM TBL_LOB_CONF_ACTVT_ASOC_AUXCOD WHERE \"ID\"=?";
    }

    @Override
    protected LOBConfigurationActivityAuxCode extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {


        LOBConfigurationActivityAuxCode nextResult = null;


        if (nextResult == null) {
            nextResult = new LOBConfigurationActivityAuxCode();
        }


        // ID
        nextResult.setID(rs.getString("ID"));

        if (!shellOnly) {
            String cMSAuxCode = rs.getString("CMS_AUX_CODE");
            if (StringUtils.hasText(cMSAuxCode) && !"null".equalsIgnoreCase(cMSAuxCode)) {

                nextResult.setCMSAuxCode(cMSAuxCode);
            }

            String lOBConfigurationEntryId = rs.getString("LOB_CONFIGURATION_ENTRY_ID");
            if (StringUtils.hasText(lOBConfigurationEntryId) && !"null".equalsIgnoreCase(lOBConfigurationEntryId)) {
                LOBConfigurationEntry lobConfigurationEntry = new LOBConfigurationEntry();
                lobConfigurationEntry.setID(lOBConfigurationEntryId);
                nextResult.setLOBConfigurationEntry(lobConfigurationEntry);
            }

        }


        return nextResult;
    }

    protected void setBaseStatmentInsertParams(LOBConfigurationActivityAuxCode perceroObject, PreparedStatement pstmt) throws SQLException {

        pstmt.setString(1, perceroObject.getID());

        if (perceroObject.getCMSAuxCode() == null) {
            pstmt.setString(2, null);
        } else {
            pstmt.setString(2, perceroObject.getCMSAuxCode());
        }


    }

    @Override
    protected void setPreparedStatmentInsertParams(LOBConfigurationActivityAuxCode perceroObject, PreparedStatement pstmt) throws SQLException {

        setBaseStatmentInsertParams(perceroObject, pstmt);

    }

    @Override
    protected void setCallableStatmentInsertParams(LOBConfigurationActivityAuxCode perceroObject, CallableStatement pstmt) throws SQLException {

        setBaseStatmentInsertParams(perceroObject, pstmt);


    }

    @Override
    protected void setPreparedStatmentUpdateParams(LOBConfigurationActivityAuxCode perceroObject, PreparedStatement pstmt) throws SQLException {


        if (perceroObject.getCMSAuxCode() == null) {
            pstmt.setString(1, null);
        } else {
            pstmt.setString(1, perceroObject.getCMSAuxCode());
        }

        pstmt.setString(2, perceroObject.getID());


    }


    @Override
    protected void setCallableStatmentUpdateParams(LOBConfigurationActivityAuxCode perceroObject, CallableStatement pstmt) throws SQLException {

        //must be in same order as insert
        setBaseStatmentInsertParams(perceroObject, pstmt);

    }


    @Override
    public List<LOBConfigurationActivityAuxCode> findByExample(LOBConfigurationActivityAuxCode theQueryObject,
                                                List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException {


        String sql = getFindByExampleSelectSql(shellOnly);

        int propertyCounter = 0;
        List<Object> paramValues = new ArrayList<Object>();

        boolean useLOBID = theQueryObject.getCMSAuxCode() != null && (excludeProperties == null || !excludeProperties.contains("cMSAuxCode"));

        if (useLOBID) {
            sql += " WHERE ";
            sql += " \"CMS_AUX_CODE\" =? ";
            paramValues.add(theQueryObject.getCMSAuxCode());
            propertyCounter++;
        }


        boolean useLOBConfigurationEntryID = theQueryObject.getLOBConfigurationEntry().getID() != null && (excludeProperties == null || !excludeProperties.contains("lOBConfigurationEntry"));

        if (useLOBID) {
            sql += " WHERE ";
            sql += " \"LOB_CONFIGURATION_ENTRY_ID\" =? ";
            paramValues.add(theQueryObject.getLOBConfigurationEntry().getID());
            propertyCounter++;
        }
        if (propertyCounter == 0) {
            throw new SyncException(SyncException.METHOD_UNSUPPORTED, SyncException.METHOD_UNSUPPORTED_CODE);
        }

        return executeSelectWithParams(sql, paramValues.toArray(), shellOnly);
    }

    @Override
    protected String getUpdateCallableStatementSql() {
        return "{call UPDATE_LOB_CONF_ACTVT_ASOC_AUXCOD(?,?)}";
    }

    @Override
    protected String getInsertCallableStatementSql() {
        return "{call CREATE_LOB_CONF_ACTVT_ASOC_AUXCOD(?,?)}";
    }

    @Override
    protected String getDeleteCallableStatementSql() {
        return "{call Delete_LOB_CONF_ACTVT_ASOC_AUXCOD(?)}";
    }


}

