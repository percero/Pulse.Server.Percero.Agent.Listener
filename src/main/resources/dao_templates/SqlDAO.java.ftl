package com.pulse.mo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.percero.agents.sync.dao.IDataAccessObject;
import com.percero.agents.sync.services.DAORegistry;
import com.pulse.mo.${className};
import com.pulse.mo.Person;

@Component
public class ${className}DAO extends SqlDataAccessObject<${className}> implements IDataAccessObject<${className}> {

	static final Logger log = Logger.getLogger(${className}DAO.class);

	
	public ${className}DAO() {
		super();
	}
	
	@PostConstruct
	protected void init() {
		DAORegistry.getInstance().registerDataAccessObject(${className}.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
	public static final String CONNECTION_FACTORY_NAME = "${dataSource}";
	@Override
	protected String getConnectionFactoryName() {
		return ${className}DAO.CONNECTION_FACTORY_NAME;
	}

	public static final String SELECT_SHELL_ONLY = "SELECT ${tableName}.ID FROM ${className} ${tableName} ";
	@Override
	protected String getSelectShellOnly() {
		return ${className}DAO.SELECT_SHELL_ONLY;
	}
	
	public static final String SELECT_STAR = "SELECT ${tableName}.ID " +
<#list mappedClass.propertyFields as nextPropertyField>
			", ${tableName}.${nextPropertyField.columnName}" +
</#list>
<#list mappedClass.toOneFields as nextSourceRelationship>
	<#if nextSourceRelationship.isSourceEntity>
			", ${tableName}.${nextSourceRelationship.joinColumnName}" +
	</#if>
</#list>
				"FROM ${className} ${tableName} ";
	@Override
	protected String getSelectStar() {
		return ${className}DAO.SELECT_STAR;
	}
	
	@Override
	protected String getSelectAllShellOnly() {
		return ${className}DAO.SELECT_SHELL_ONLY + " ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllStar() {
		return ${className}DAO.SELECT_STAR + " ORDER BY ID";
	}
	
	public static final String COUNT_ALL_SQL = "SELECT COUNT(ID) FROM ${className} ${tableName}";
	@Override
	protected String getCountAllSql() {
		return ${className}DAO.COUNT_ALL_SQL;
	}
	
	public static final String INSERT_INTO = "INSERT INTO ${className} (ID" +
<#list mappedClass.propertyFields as nextPropertyField>
			", ${nextPropertyField.columnName}" +
</#list>
<#list mappedClass.toOneFields as nextSourceRelationship>
	<#if nextSourceRelationship.isSourceEntity>
			", ${nextSourceRelationship.joinColumnName}" +
	</#if>
</#list>
		") VALUES ";
	@Override
	protected String getInsertInto() {
		return ${className}DAO.INSERT_INTO;
	}
	
	public static final String UPDATE_SET = "UPDATE ${className} SET ";
	@Override
	protected String getUpdateSet() {
		return ${className}DAO.UPDATE_SET;
	}
	
	public static final String DELETE_FROM = "DELETE FROM ${className} ";
	@Override
	protected String getDeleteFrom() {
		return ${className}DAO.DELETE_FROM;
	}
	
	public static final String FULL_TABLE_NAME = "${tableName}";
	@Override
	protected String getFullTableName() {
		return ${className}DAO.FULL_TABLE_NAME;
	}
	
	@Override
	protected ${className} extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	${className} nextResult = new ${className}();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) {
    		// Properties
<#list mappedClass.propertyFields as nextPropertyField>
			nextResult.set${nextPropertyField.getField().getName()?cap_first}(rs.getString("${nextPropertyField.columnName}"));
</#list>
			
			// Source Relationships
<#list mappedClass.toOneFields as nextSourceRelationship>
	<#if nextSourceRelationship.isSourceEntity>
			${nextSourceRelationship.getField().getType().getName()} ${nextSourceRelationship.getField().getName()} = new ${nextSourceRelationship.getField().getType().getName()}();
			${nextSourceRelationship.getField().getName()}.setID(rs.getString("${nextSourceRelationship.joinColumnName}"));
			nextResult.set${nextSourceRelationship.getField().getName()?cap_first}(${nextSourceRelationship.getField().getName()});
	</#if>
</#list>
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected StringBuilder buildInsertValues(${className} perceroObject, StringBuilder sb) {
		if (sb == null) {
			sb = new StringBuilder();
		}
		sb.append(" ").append(buildPerceroObjectIdValue(perceroObject))
<#list mappedClass.propertyFields as nextPropertyField>
				.append(",")
				.append(buildStringValue(perceroObject.get${nextPropertyField.getField().getName()?cap_first}()))
</#list>
<#list mappedClass.toOneFields as nextSourceRelationship>
	<#if nextSourceRelationship.isSourceEntity>
				.append(",")
				.append(buildPerceroObjectIdValue(perceroObject.get${nextSourceRelationship.getField().getName()?cap_first}()))
	</#if>
</#list>
				.append(" ");
		return sb;
	}
	
	@Override
	protected StringBuilder buildUpdateValues(${className} perceroObject, StringBuilder sb) {
		if (sb == null) {
			sb = new StringBuilder();
		}
		
		sb
<#list mappedClass.propertyFields as nextPropertyField>
				.append(" ${nextPropertyField.columnName}=")
				.append(buildStringValue(perceroObject.get${nextPropertyField.getField().getName()?cap_first}()))
	<#if (nextPropertyField_has_next)>
				.append(",")
	<#else>
				;
	</#if>
</#list>
		sb
<#list mappedClass.toOneFields as nextSourceRelationship>
	<#if nextSourceRelationship.isSourceEntity>
				.append(" ${nextSourceRelationship.joinColumnName}=")
				.append(buildPerceroObjectIdValue(perceroObject.get${nextSourceRelationship.getField().getName()?cap_first}()))
		<#if (nextPropertyField_has_next)>
				.append(",")
		<#else>
				;
		</#if>
	</#if>
</#list>
		.append(" WHERE ID=").append(buildPerceroObjectIdValue(perceroObject))
		.append(" ");
		
		return sb;
	}


	@Override
	public ${className} cleanObjectForUser(${className} perceroObject, String userId) {
		// TODO Auto-generated method stub
		return null;
	}
}

