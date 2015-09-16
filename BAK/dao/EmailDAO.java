package com.pulse.mo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.percero.agents.sync.dao.IDataAccessObject;
import com.percero.agents.sync.services.DAORegistry;
import com.pulse.mo.Email;
import com.pulse.mo.Person;

@Component
public class EmailDAO extends SqlDataAccessObject<Email> implements IDataAccessObject<Email> {

	static final Logger log = Logger.getLogger(EmailDAO.class);

	
	public EmailDAO() {
		super();
	}
	
	@PostConstruct
	protected void init() {
		DAORegistry.getInstance().registerDataAccessObject(Email.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
	public static final String CONNECTION_FACTORY_NAME = "${dataSource}";
	@Override
	protected String getConnectionFactoryName() {
		return EmailDAO.CONNECTION_FACTORY_NAME;
	}

	public static final String SELECT_SHELL_ONLY = "SELECT email.ID FROM Email email ";
	@Override
	protected String getSelectShellOnly() {
		return EmailDAO.SELECT_SHELL_ONLY;
	}
	
	public static final String SELECT_STAR = "SELECT email.ID, email.value, email.person_ID FROM Email email ";
	@Override
	protected String getSelectStar() {
		return EmailDAO.SELECT_STAR;
	}
	
	public static final String SELECT_ALL_SHELL_ONLY = "SELECT email.ID FROM Email email ORDER BY ID";
	@Override
	protected String getSelectAllShellOnly() {
		return EmailDAO.SELECT_ALL_SHELL_ONLY;
	}
	
	public static final String SELECT_ALL_STAR = "SELECT email.ID, email.value, email.person_ID FROM Email email ORDER BY ID";
	@Override
	protected String getSelectAllStar() {
		return EmailDAO.SELECT_ALL_STAR;
	}
	
	public static final String COUNT_ALL_SQL = "SELECT COUNT(ID) FROM Email email";
	@Override
	protected String getCountAllSql() {
		return EmailDAO.COUNT_ALL_SQL;
	}
	
	public static final String INSERT_INTO = "INSERT INTO Email (ID, value, person_ID) VALUES ";
	@Override
	protected String getInsertInto() {
		return EmailDAO.INSERT_INTO;
	}
	
	public static final String UPDATE_SET = "UPDATE Email SET ";
	@Override
	protected String getUpdateSet() {
		return EmailDAO.UPDATE_SET;
	}
	
	public static final String DELETE_FROM = "DELETE FROM Email ";
	@Override
	protected String getDeleteFrom() {
		return EmailDAO.DELETE_FROM;
	}
	
	public static final String FULL_TABLE_NAME = "email";
	@Override
	protected String getFullTableName() {
		return EmailDAO.FULL_TABLE_NAME;
	}
	
	@Override
	protected Email extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	Email nextResult = new Email();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) {
    		// Properties
			nextResult.setValue(rs.getString("value"));
			
			// Source Relationships
			Person person = new Person();
			person.setID(rs.getString("person_ID"));
			nextResult.setPerson(person);
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected StringBuilder buildInsertValues(Email perceroObject, StringBuilder sb) {
		if (sb == null) {
			sb = new StringBuilder();
		}
		sb.append(" ").append(buildPerceroObjectIdValue(perceroObject))
				.append(",")
				.append(buildStringValue(perceroObject.getValue()))
				.append(",")
				.append(buildPerceroObjectIdValue(perceroObject.getPerson()))
				.append(" ");
		return sb;
	}
	
	@Override
	protected StringBuilder buildUpdateValues(Email perceroObject, StringBuilder sb) {
		if (sb == null) {
			sb = new StringBuilder();
		}
		
		sb.append(" value=")
		.append(buildStringValue(perceroObject.getValue()))
		.append(", person_ID=")
		.append(buildPerceroObjectIdValue(perceroObject.getPerson()))
		.append(" WHERE ID=").append(buildPerceroObjectIdValue(perceroObject))
		.append(" ");
		
		return sb;
	}


	@Override
	public Email cleanObjectForUser(Email perceroObject, String userId) {
		// TODO Auto-generated method stub
		return null;
	}
}

