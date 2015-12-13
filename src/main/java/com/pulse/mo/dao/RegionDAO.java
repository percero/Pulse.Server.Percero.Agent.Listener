

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
public class RegionDAO extends SqlDataAccessObject<Region> implements IDataAccessObject<Region> {

    static final Logger log = Logger.getLogger(RegionDAO.class);


    public RegionDAO() {
        super();

        DAORegistry.getInstance().registerDataAccessObject(Region.class.getCanonicalName(), this);
    }


    // This is the name of the Data Source that is registered to handle this class type.
    // For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
    public static final String CONNECTION_FACTORY_NAME = "default";

    public static final String SHELL_ONLY_SELECT = "\"REGION\".\"ID\"";
    public static final String SQL_VIEW = ",\"REGION\".\"NAME\", \"REGION\".\"GEOCODE\" ";
    private String selectFromStatementTableName = " FROM \"REGION\" \"REGION\"";
    private String whereClause = "  WHERE \"REGION\".\"ID\"=?";
    private String whereInClause = "  join table(sys.dbms_debug_vc2coll(?)) SQLLIST on \"REGION\".\"ID\"= SQLLIST.column_value";
    private String orderByTableName = "  ORDER BY \"REGION\".\"ID\"";




    @Override
    protected String getConnectionFactoryName() {
        return RegionDAO.CONNECTION_FACTORY_NAME;
    }

    @Override
    protected String getSelectShellOnlySQL() {
        return "SELECT " + SHELL_ONLY_SELECT +  " " + selectFromStatementTableName + whereClause;
    }

    @Override
    protected String getSelectStarSQL() {
        return "SELECT \"REGION\".\"ID\"" + SQL_VIEW  + selectFromStatementTableName + whereClause;
    }

    @Override
    protected String getSelectAllShellOnlySQL() {
        return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName +  orderByTableName;
    }

    @Override
    protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
        return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName  +  orderByTableName  + " LIMIT ? OFFSET ?";
    }

    @Override
    protected String getSelectAllStarSQL() {
        return "SELECT \"REGION\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName  + orderByTableName;
    }

    @Override
    protected String getSelectAllStarWithLimitAndOffsetSQL() {
        return "SELECT \"REGION\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + orderByTableName + " LIMIT ? OFFSET ?";
    }

    @Override
    protected String getCountAllSQL()
    {
        return "SELECT COUNT(ID) " + selectFromStatementTableName;
    }

    @Override
    protected String getSelectInStarSQL()
    {
        return "SELECT \"REGION\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + whereInClause;
    }

    @Override
    protected String getSelectInShellOnlySQL() {
        return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName + whereInClause;
    }

    @Override
    protected String getSelectByRelationshipStarSQL(String joinColumnName)
    {

        return "SELECT \"REGION\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + " WHERE \"REGION\"." + joinColumnName + "=?";
    }

    @Override
    protected String getSelectByRelationshipShellOnlySQL(String joinColumnName)
    {

        return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName + " WHERE \"REGION\"." + joinColumnName + "=?";
    }

    @Override
    protected String getFindByExampleSelectShellOnlySQL() {
        return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName;
    }

    @Override
    protected String getFindByExampleSelectAllStarSQL() {
        return "SELECT \"REGION\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName;
    }

    @Override
    protected String getInsertIntoSQL() {
        return "INSERT INTO TBL_REGION (\"ID\",\"NAME\") VALUES (?,?)";
    }

    @Override
    protected String getUpdateSet() {
        return "UPDATE TBL_REGION SET \"NAME\"=? WHERE \"ID\"=?";
    }

    @Override
    protected String getDeleteFromSQL() {
        return "DELETE FROM TBL_REGION WHERE \"ID\"=?";
    }

    @Override
    protected Region extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {

        Region nextResult = null;

        if (nextResult == null) {
            nextResult = new Region();
        }


        // ID
        nextResult.setID(rs.getString("ID"));

        if (!shellOnly)
        {
            nextResult.setName(rs.getString("NAME"));
            nextResult.setGeoCode(rs.getString("GEOCODE"));
        }


        return nextResult;
    }

    protected void setBaseStatmentInsertParams(Region perceroObject, PreparedStatement pstmt) throws SQLException {

        pstmt.setString(1, perceroObject.getID());
        pstmt.setString(2, perceroObject.getName());


    }

    @Override
    protected void setPreparedStatmentInsertParams(Region perceroObject, PreparedStatement pstmt) throws SQLException {

        setBaseStatmentInsertParams(perceroObject,pstmt);

    }

    @Override
    protected void setCallableStatmentInsertParams(Region perceroObject, CallableStatement pstmt) throws SQLException {

        setBaseStatmentInsertParams(perceroObject,pstmt);



    }

    @Override
    protected void setPreparedStatmentUpdateParams(Region perceroObject, PreparedStatement pstmt) throws SQLException {

        pstmt.setString(1, perceroObject.getName());
        pstmt.setString(2, perceroObject.getID());


    }


    @Override
    protected void setCallableStatmentUpdateParams(Region perceroObject, CallableStatement pstmt) throws SQLException
    {

        //must be in same order as insert
        setBaseStatmentInsertParams(perceroObject,pstmt);

    }



    @Override
    public List<Region> findByExample(Region theQueryObject,
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

        boolean useGeoCode = StringUtils.hasText(theQueryObject.getGeoCode()) && (excludeProperties == null || !excludeProperties.contains("geoCode"));

        if (useName)
        {
            sql += " WHERE ";
            sql += " \"GEOCODE\" =? ";
            paramValues.add(theQueryObject.getGeoCode());
            propertyCounter++;
        }


        if (propertyCounter == 0) {
            throw new SyncException(SyncException.METHOD_UNSUPPORTED, SyncException.METHOD_UNSUPPORTED_CODE);
        }

        return executeSelectWithParams(sql, paramValues.toArray(), shellOnly);
    }

    @Override
    protected String getUpdateCallableStatementSql() {
        return "{call UPDATE_REGION(?,?)}";
    }
    @Override
    protected String getInsertCallableStatementSql() {
        return "{call CREATE_REGION(?,?)}";
    }
    @Override
    protected String getDeleteCallableStatementSql() {
        return "{call Delete_REGION(?)}";
    }




}

