//package com.pulse.mo.dao;
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import org.apache.log4j.Logger;
//
//import com.percero.agents.sync.dao.IDataAccessObject;
//import com.percero.agents.sync.services.DAORegistry;
//import com.pulse.mo.Email;
//import com.pulse.mo.Person;
//
//public class EmailDAO extends SqlDataAccessObject<Email> implements IDataAccessObject<Email> {
//
//	static final Logger log = Logger.getLogger(EmailDAO.class);
//
//	
//	public EmailDAO() {
//		super();
//		
//		DAORegistry.getInstance().registerDataAccessObject(Email.class.getCanonicalName(), this);
//	}
//
//	
//	// This is the name of the Data Source that is registered to handle this class type.
//	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
//	@Override
//	protected String getConnectionFactoryName() {
//		return EmailDAO.CONNECTION_FACTORY_NAME;
//	}
//
//	@Override
//	protected String getSelectShellOnlySQL() {
//		return "SELECT email.ID FROM Email email WHERE email.ID=?";
//	}
//	
//	@Override
//	protected String getSelectStarSQL() {
//		return "SELECT email.ID, email.value, email.person_ID FROM Email email WHERE email.ID=?";
//	}
//	
//	@Override
//	protected String getSelectAllShellOnlySQL() {
//		return "SELECT email.ID FROM Email email ORDER BY ID";
//	}
//	
//	@Override
//	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
//		return "SELECT email.ID FROM Email email ORDER BY ID LIMIT ?,?";
//	}
//	
//	@Override
//	protected String getSelectAllStarSQL() {
//		return "SELECT email.ID, email.value, email.person_ID FROM Email email ORDER BY ID";
//	}
//	
//	@Override
//	protected String getSelectAllStarWithLimitAndOffsetSQL() {
//		return "SELECT email.ID, email.value, email.person_ID FROM Email email ORDER BY ID LIMIT ?,?";
//	}
//	
//	@Override
//	protected String getCountAllSQL() {
//		return "SELECT COUNT(ID) FROM Email email";
//	}
//	
//	@Override
//	protected String getSelectInStarSQL() {
//		return "SELECT email.ID, email.value, email.person_ID FROM Email email WHERE email.ID IN (?)";
//	}
//	
//	@Override
//	protected String getSelectInShellOnlySQL() {
//		return "SELECT email.ID FROM Email email WHERE email.ID IN (?)";
//	}
//
//	@Override
//	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
//		return "SELECT email.ID, email.value, email.person_ID FROM Email email WHERE email." + joinColumnName + "=?";
//	}
//	
//	@Override
//	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
//		return "SELECT email.ID FROM Email email WHERE email." + joinColumnName + "?";
//	}
//
//	@Override
//	protected String getInsertIntoSQL() {
//		return "INSERT INTO Email (ID, value, person_ID) VALUES ?, ?, ?";
//	}
//	
//	@Override
//	protected String getUpdateSet() {
//		return "UPDATE Email SET value=?, person_ID=? WHERE ID=?";
//	}
//	
//	@Override
//	protected String getDeleteFromSQL() {
//		return "DELETE FROM Email WHERE ID=?";
//	}
//	
//	@Override
//	protected Email extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
//    	Email nextResult = new Email();
//    	
//    	// ID
//    	nextResult.setID(rs.getString("ID"));
//    	
//    	if (!shellOnly) {
//    		// Properties
//			nextResult.setValue(rs.getString("value"));
//			
//			// Source Relationships
//			Person person = new Person();
//			person.setID(rs.getString("person_ID"));
//			nextResult.setPerson(person);
//    	}
//    	
//    	return nextResult;
//	}
//	
//	@Override
//	protected void setPreparedStatmentInsertParams(Email perceroObject, PreparedStatement pstmt) throws SQLException {
//		pstmt.setString(1, perceroObject.getID());
//		pstmt.setString(2, perceroObject.getValue());
//		if (perceroObject.getPerson() == null) {
//			pstmt.setString(3, null);
//		}
//		else {
//			pstmt.setString(3, perceroObject.getPerson().getID());
//		}
//	}
//	
//	@Override
//	protected void setPreparedStatmentUpdateParams(Email perceroObject, PreparedStatement pstmt) throws SQLException {
//		pstmt.setString(1, perceroObject.getValue());
//		if (perceroObject.getPerson() == null) {
//			pstmt.setString(2, null);
//		}
//		else {
//			pstmt.setString(2, perceroObject.getPerson().getID());
//		}
//		pstmt.setString(3, perceroObject.getID());
//	}
//
//	
//}
