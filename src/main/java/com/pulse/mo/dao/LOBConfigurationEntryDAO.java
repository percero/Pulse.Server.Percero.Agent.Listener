

package com.pulse.mo.dao;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.percero.agents.sync.exceptions.SyncDataException;
import com.percero.util.DateUtils;
import com.pulse.dataprovider.IConnectionFactory;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import com.percero.agents.sync.metadata.MappedClass;
import com.percero.agents.sync.dao.DAORegistry;
import com.percero.agents.sync.dao.IDataAccessObject;
import com.percero.agents.sync.exceptions.SyncException;
import com.percero.agents.sync.vo.BaseDataObject;

import java.sql.Connection;
import java.sql.Statement;

import com.pulse.dataprovider.IConnectionFactory;
import com.percero.agents.sync.exceptions.SyncDataException;
import com.pulse.mo.*;

@Component
public class LOBConfigurationEntryDAO extends SqlDataAccessObject<LOBConfigurationEntry> implements IDataAccessObject<LOBConfigurationEntry> {

    static final Logger log = Logger.getLogger(LOBConfigurationEntryDAO.class);


    public LOBConfigurationEntryDAO() {
        super();

        DAORegistry.getInstance().registerDataAccessObject(LOBConfigurationEntry.class.getCanonicalName(), this);
    }


    // This is the name of the Data Source that is registered to handle this class type.
    // For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
    public static final String CONNECTION_FACTORY_NAME = "default";

    public static final String SHELL_ONLY_SELECT = "\"LOB_CONFIGURATION_ENTRY\".\"ID\"";
    public static final String SQL_VIEW1 = ",\"LOB_CONFIGURATION_ENTRY\".\"DURATION_TOLERANCE_ENABLED\",\"LOB_CONFIGURATION_ENTRY\".\"DURATION_TOLERANCE\",\"LOB_CONFIGURATION_ENTRY\".\"DURATION_TOLERANCE_INTERVAL\",\"LOB_CONFIGURATION_ENTRY\".\"OCC_TOLERANCE_INTERVAL\",\"LOB_CONFIGURATION_ENTRY\".\"REMINDER_INTERVAL\",\"LOB_CONFIGURATION_ENTRY\".\"LOB_CONFIGURATION_ID\",\"LOB_CONFIGURATION_ENTRY\".\"NOTIFICATION_FREQUENCY_ID\"";
    public static final String SQL_VIEW = ",\"LOB_CONFIGURATION_ENTRY\".\"CMS_AUX_CODE\",\"LOB_CONFIGURATION_ENTRY\".\"ESTART_ACTIVITY_CODE\",\"LOB_CONFIGURATION_ENTRY\".\"TYPE\",\"LOB_CONFIGURATION_ENTRY\".\"MIN\",\"LOB_CONFIGURATION_ENTRY\".\"MAX\",\"LOB_CONFIGURATION_ENTRY\".\"OCCURRENCE\",\"LOB_CONFIGURATION_ENTRY\".\"LOB_CONFIGURATION_ID\",\"LOB_CONFIGURATION_ENTRY\".\"NOTIFICATION_FREQUENCY_ID\"";
    private String selectFromStatementTableName = " FROM \"LOB_CONFIGURATION_ENTRY\" \"LOB_CONFIGURATION_ENTRY\"";
    private String whereClause = "  WHERE \"LOB_CONFIGURATION_ENTRY\".\"ID\"=?";
    private String whereInClause = "  join table(sys.dbms_debug_vc2coll(?)) SQLLIST on \"LOB_CONFIGURATION_ENTRY\".\"ID\"= SQLLIST.column_value";
    private String orderByTableName = "  ORDER BY \"LOB_CONFIGURATION_ENTRY\".\"ID\"";


    @Override
    protected String getConnectionFactoryName() {
        return LOBConfigurationEntryDAO.CONNECTION_FACTORY_NAME;
    }

    @Override
    protected String getSelectShellOnlySQL() {
        return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName + whereClause;
    }

    @Override
    protected String getSelectStarSQL() {
        return "SELECT \"LOB_CONFIGURATION_ENTRY\".\"ID\"" + SQL_VIEW + selectFromStatementTableName + whereClause;
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
        return "SELECT \"LOB_CONFIGURATION_ENTRY\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + orderByTableName;
    }

    @Override
    protected String getSelectAllStarWithLimitAndOffsetSQL() {
        return "SELECT \"LOB_CONFIGURATION_ENTRY\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + orderByTableName + " LIMIT ? OFFSET ?";
    }

    @Override
    protected String getCountAllSQL() {
        return "SELECT COUNT(ID) " + selectFromStatementTableName;
    }

    @Override
    protected String getSelectInStarSQL() {
        return "SELECT \"LOB_CONFIGURATION_ENTRY\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + whereInClause;
    }

    @Override
    protected String getSelectInShellOnlySQL() {
        return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName + whereInClause;
    }

    @Override
    protected String getSelectByRelationshipStarSQL(String joinColumnName) {

        return "SELECT \"LOB_CONFIGURATION_ENTRY\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + " WHERE \"LOB_CONFIGURATION_ENTRY\"." + joinColumnName + "=?";
    }

    @Override
    protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {

        return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName + " WHERE \"LOB_CONFIGURATION_ENTRY\"." + joinColumnName + "=?";
    }

    @Override
    protected String getFindByExampleSelectShellOnlySQL() {
        return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName;
    }

    @Override
    protected String getFindByExampleSelectAllStarSQL() {
        return "SELECT \"LOB_CONFIGURATION_ENTRY\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName;
    }

    @Override
    protected String getInsertIntoSQL() {
        return "INSERT INTO TBL_LOB_CONFIGURATION_ENTRY (\"ID\",\"CMS_AUX_CODE\",\"ESTART_ACTIVITY_CODE\",\"TYPE\",\"MIN\",\"MAX\",\"OCCURRENCE\",\"LOB_CONFIGURATION_ID\",\"NOTIFICATION_FREQUENCY_ID\") VALUES (?,?,?,?,?,?,?,?,?)";
    }

    @Override
    protected String getUpdateSet() {
        return "UPDATE TBL_LOB_CONFIGURATION_ENTRY SET \"CMS_AUX_CODE\"=?, \"ESTART_ACTIVITY_CODE\"=?, \"TYPE\"=?, \"MIN\"=?, \"MAX\"=?, \"OCCURRENCE\"=?, \"LOB_CONFIGURATION_ID\"=?, \"NOTIFICATION_FREQUENCY_ID\"=? WHERE \"ID\"=?";
    }

    @Override
    protected String getDeleteFromSQL() {
        return "DELETE FROM TBL_LOB_CONFIGURATION_ENTRY WHERE \"ID\"=?";
    }

    @Override
    protected LOBConfigurationEntry extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {


        LOBConfigurationEntry nextResult = null;


        if (nextResult == null) {
            nextResult = new LOBConfigurationEntry();
        }


        // ID
        nextResult.setID(rs.getString("ID"));

        if (!shellOnly) {
            nextResult.setCMSAuxCode(rs.getString("CMS_AUX_CODE"));


            nextResult.setEStartActivityCode(rs.getString("ESTART_ACTIVITY_CODE"));
            nextResult.setType(rs.getString("TYPE"));

            nextResult.setMin(rs.getInt("MIN"));


            nextResult.setMax(rs.getInt("MAX"));


            nextResult.setOccurrence(rs.getInt("OCCURRENCE"));


            String lobconfigurationID = rs.getString("LOB_CONFIGURATION_ID");
            if (StringUtils.hasText(lobconfigurationID) && !"null".equalsIgnoreCase(lobconfigurationID)) {
                LOBConfiguration lobconfiguration = new LOBConfiguration();
                lobconfiguration.setID(lobconfigurationID);
                nextResult.setLOBConfiguration(lobconfiguration);
            }


            String notificationfrequencyID = rs.getString("NOTIFICATION_FREQUENCY_ID");
            if (StringUtils.hasText(notificationfrequencyID) && !"null".equalsIgnoreCase(notificationfrequencyID)) {
                NotificationFrequency notificationfrequency = new NotificationFrequency();
                notificationfrequency.setID(notificationfrequencyID);
                nextResult.setNotificationFrequency(notificationfrequency);
            }


        }


        return nextResult;
    }

    protected void setBaseStatmentInsertParams(LOBConfigurationEntry perceroObject, PreparedStatement pstmt) throws SQLException {

        pstmt.setString(1, perceroObject.getID());
        pstmt.setString(2, perceroObject.getCMSAuxCode());
        pstmt.setString(3, perceroObject.getEStartActivityCode());
        pstmt.setString(4, perceroObject.getType());
        JdbcHelper.setInt(pstmt, 5, perceroObject.getMin());
        JdbcHelper.setInt(pstmt, 6, perceroObject.getMax());
        JdbcHelper.setInt(pstmt, 7, perceroObject.getOccurrence());

        if (perceroObject.getLOBConfiguration() == null) {
            pstmt.setString(8, null);
        } else {
            pstmt.setString(8, perceroObject.getLOBConfiguration().getID());
        }


        if (perceroObject.getNotificationFrequency() == null) {
            pstmt.setString(9, null);
        } else {
            pstmt.setString(9, perceroObject.getNotificationFrequency().getID());
        }


    }

    @Override
    protected void setPreparedStatmentInsertParams(LOBConfigurationEntry perceroObject, PreparedStatement pstmt) throws SQLException {

        setBaseStatmentInsertParams(perceroObject, pstmt);

    }

    @Override
    protected void setCallableStatmentInsertParams(LOBConfigurationEntry perceroObject, CallableStatement pstmt) throws SQLException {

        setBaseStatmentInsertParams(perceroObject, pstmt);


    }

    @Override
    protected void setPreparedStatmentUpdateParams(LOBConfigurationEntry perceroObject, PreparedStatement pstmt) throws SQLException {

        pstmt.setString(1, perceroObject.getCMSAuxCode());
        pstmt.setString(2, perceroObject.getEStartActivityCode());
        pstmt.setString(3, perceroObject.getType());
        JdbcHelper.setInt(pstmt, 4, perceroObject.getMin());
        JdbcHelper.setInt(pstmt, 5, perceroObject.getMax());
        JdbcHelper.setInt(pstmt, 6, perceroObject.getOccurrence());

        if (perceroObject.getLOBConfiguration() == null) {
            pstmt.setString(7, null);
        } else {
            pstmt.setString(7, perceroObject.getLOBConfiguration().getID());
        }


        if (perceroObject.getNotificationFrequency() == null) {
            pstmt.setString(8, null);
        } else {
            pstmt.setString(8, perceroObject.getNotificationFrequency().getID());
        }

        pstmt.setString(9, perceroObject.getID());


    }


    @Override
    protected void setCallableStatmentUpdateParams(LOBConfigurationEntry perceroObject, CallableStatement pstmt) throws SQLException {

        //must be in same order as insert
        setBaseStatmentInsertParams(perceroObject, pstmt);

    }


    @Override
    public List<LOBConfigurationEntry> findByExample(LOBConfigurationEntry theQueryObject,
                                                     List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException {


        String sql = getFindByExampleSelectSql(shellOnly);

        int propertyCounter = 0;
        List<Object> paramValues = new ArrayList<Object>();

        boolean useCMSAuxCode = theQueryObject.getCMSAuxCode() != null && (excludeProperties == null || !excludeProperties.contains("cMSAuxCode"));
//eStartActivityCode
        if (useCMSAuxCode) {
            sql += " WHERE ";
            sql += " \"CMS_AUX_CODE\" =? ";
            paramValues.add(theQueryObject.getCMSAuxCode());
            propertyCounter++;
        }

        boolean useEStartActivityCode = theQueryObject.getEStartActivityCode() != null && (excludeProperties == null || !excludeProperties.contains("eStartActivityCode"));

        if (useEStartActivityCode) {
            if (propertyCounter > 0) {
                sql += " AND ";
            } else {
                sql += " WHERE ";
            }
            sql += " \"ESTART_ACTIVITY_CODE\" =? ";
            paramValues.add(theQueryObject.getEStartActivityCode());
            propertyCounter++;
        }

        boolean useType = theQueryObject.getType() != null && (excludeProperties == null || !excludeProperties.contains("type"));

        if (useType) {
            if (propertyCounter > 0) {
                sql += " AND ";
            } else {
                sql += " WHERE ";
            }
            sql += " \"TYPE\" =? ";
            paramValues.add(theQueryObject.getType());
            propertyCounter++;
        }

        boolean useMin = theQueryObject.getMin() != null && (excludeProperties == null || !excludeProperties.contains("min"));

        if (useMin) {
            if (propertyCounter > 0) {
                sql += " AND ";
            } else {
                sql += " WHERE ";
            }
            sql += " \"MIN\" =? ";
            paramValues.add(theQueryObject.getMin());
            propertyCounter++;
        }

        boolean useMax = theQueryObject.getMax() != null && (excludeProperties == null || !excludeProperties.contains("max"));

        if (useMax) {
            if (propertyCounter > 0) {
                sql += " AND ";
            } else {
                sql += " WHERE ";
            }
            sql += " \"MAX\" =? ";
            paramValues.add(theQueryObject.getMax());
            propertyCounter++;
        }

        boolean useOccurrence = theQueryObject.getOccurrence() != null && (excludeProperties == null || !excludeProperties.contains("occurrence"));

        if (useOccurrence) {
            if (propertyCounter > 0) {
                sql += " AND ";
            } else {
                sql += " WHERE ";
            }
            sql += " \"OCCURRENCE\" =? ";
            paramValues.add(theQueryObject.getOccurrence());
            propertyCounter++;
        }

        boolean useLOBConfigurationID = theQueryObject.getLOBConfiguration() != null && (excludeProperties == null || !excludeProperties.contains("lOBConfiguration"));

        if (useLOBConfigurationID) {
            if (propertyCounter > 0) {
                sql += " AND ";
            } else {
                sql += " WHERE ";
            }
            sql += " \"LOB_CONFIGURATION_ID\" =? ";
            paramValues.add(theQueryObject.getLOBConfiguration().getID());
            propertyCounter++;
        }

        boolean useNotificationFrequencyID = theQueryObject.getNotificationFrequency() != null && (excludeProperties == null || !excludeProperties.contains("notificationFrequency"));

        if (useNotificationFrequencyID) {
            if (propertyCounter > 0) {
                sql += " AND ";
            } else {
                sql += " WHERE ";
            }
            sql += " \"NOTIFICATION_FREQUENCY_ID\" =? ";
            paramValues.add(theQueryObject.getNotificationFrequency().getID());
            propertyCounter++;
        }


        if (propertyCounter == 0) {
            throw new SyncException(SyncException.METHOD_UNSUPPORTED, SyncException.METHOD_UNSUPPORTED_CODE);
        }

        return executeSelectWithParams(sql, paramValues.toArray(), shellOnly);
    }

    @Override
    protected String getUpdateCallableStatementSql() {
        return "{call UPDATE_LOB_CONFIGURATION_ENTRY(?,?,?,?,?,?,?,?)}";
    }

    @Override
    protected String getInsertCallableStatementSql() {
        return "{call CREATE_LOB_CONFIGURATION_ENTRY(?,?,?,?,?,?,?,?)}";
    }

    @Override
    protected String getDeleteCallableStatementSql() {
        return "{call Delete_LOB_CONFIGURATION_ENTRY(?)}";
    }


}

