package com.pulse.mo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.percero.agents.sync.dao.IDataAccessObject;
import com.percero.agents.sync.hibernate.SyncHibernateUtils;
import com.percero.agents.sync.metadata.IMappedClassManager;
import com.percero.agents.sync.metadata.JpqlQuery;
import com.percero.agents.sync.metadata.MappedClass;
import com.percero.agents.sync.metadata.MappedClassManagerFactory;
import com.percero.framework.vo.IPerceroObject;
import com.percero.framework.vo.PerceroList;
import com.pulse.mo.Email;
import com.pulse.mo.Person;

@Component
public class EmailDAO extends SqlDataAccessObject<Email> implements IDataAccessObject<Email> {

	static final Logger log = Logger.getLogger(EmailDAO.class);

	
	public EmailDAO() {
		super();
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
	public static final String CONNECTION_FACTORY_NAME = "dataSource";
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
	
	public static final String SELECT_ALL_SQL = "SELECT email.ID, email.value, email.person_ID FROM Email email ORDER BY ID";
	@Override
	protected String getSelectAllSql() {
		return EmailDAO.SELECT_ALL_SQL;
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
	public PerceroList<Email> getAll(Integer pageNumber, Integer pageSize,
			Boolean returnTotal, String userId) throws Exception {
		
		StringBuilder sb = new StringBuilder(getSelectAllSql());
		
		if (pageNumber != null && pageSize != null && pageSize > 0) {
			sb.append(" LIMIT ").append(pageNumber).append(",").append(pageSize);
		}
		
		String selectQueryString = sb.toString();
		if ( StringUtils.hasText(userId) ) {
			selectQueryString = selectQueryString.replaceAll(":userId", "'" + userId + "'");
		}
		
		String countQueryString = "select count(*) from ("+selectQueryString+") as U";

		
		Session s = appSessionFactory.openSession();
		try {
			returnTotal = true;
			Query countQuery = null;
			Query query = null;
//			Class theClass = MappedClass.forName(aName.toString());

			IMappedClassManager mcm = MappedClassManagerFactory.getMappedClassManager();
			MappedClass mappedClass = mcm.getMappedClassByClassName(Email.class.getCanonicalName());
			boolean isValidReadQuery = false;
			if (mappedClass != null) {
				if (mappedClass.getReadQuery() != null && StringUtils.hasText(mappedClass.getReadQuery().getQuery())) {
					isValidReadQuery = true;
				}
			}

			/**
			 * readAllQuery optimization
			 * You can now define a readAllQuery on a class to imporove it's initial download time
			 * for briefcase mode.
			 * 
			 * Only supports plain SQL for now
			 */
			if(mappedClass.getReadAllQuery() != null && mappedClass.getReadAllQuery().getQuery() != null && !mappedClass.getReadAllQuery().getQuery().isEmpty()){
				if((mappedClass.getReadAllQuery() instanceof JpqlQuery)){
					throw new IllegalArgumentException("Illegal query type on:"+aClassName+". readAllQueries must be plain SQL. JPQL, HQL not supported yet. ");
				}
				
				log.debug("Using readAllQuery: "+aClassName);
				String selectQueryString = mappedClass.getReadAllQuery().getQuery();
				
				String countQueryString = "select count(*) from ("+selectQueryString+") as U";
				
				// Add the limit clause
				if (pageSize != null && pageNumber != null && pageSize.intValue() > 0) {
					int offset = pageSize.intValue() * pageNumber.intValue();
					selectQueryString += " limit "+pageSize+" OFFSET "+offset;
				}
				
				query = s.createSQLQuery(selectQueryString).addEntity(theClass);
				countQuery = s.createSQLQuery(countQueryString);
				
				query.setParameter("userId", userId);
				countQuery.setParameter("userId", userId);
			}
			else 
				if (theClass != null) {
				String countQueryString = "";
				if (returnTotal)
					countQueryString = "SELECT COUNT(getAllResult.ID) FROM " + aClassName + " getAllResult";
				String queryString = "SELECT getAllResult FROM " + aClassName + " getAllResult";

				// If the Read Query/Filter uses the ID, then we need to check against each ID here.
				if (isValidReadQuery) {
					String queryFilterString = mappedClass.getReadQuery().getQuery();
					if (mappedClass.getReadQuery().getUseId()) {
						// Need to replace :id with 
						queryFilterString = queryFilterString.replaceAll(":id", "getAllResult.ID");
						queryFilterString = queryFilterString.replaceAll(":Id", "getAllResult.ID");
						queryFilterString = queryFilterString.replaceAll(":iD", "getAllResult.ID");
						queryFilterString = queryFilterString.replaceAll(":ID", "getAllResult.ID");
					}
					String countQueryFilterString = "";
					if (returnTotal)
						countQueryFilterString = queryFilterString;
					queryFilterString = queryString + " WHERE (" + queryFilterString + ") > 0 ORDER BY getAllResult.ID";

					if (returnTotal) {
						countQueryFilterString = countQueryString + " WHERE (" + countQueryFilterString + ") > 0";
						countQuery = s.createQuery(countQueryFilterString);
					}
					query = s.createQuery(queryFilterString);
					mappedClass.getReadQuery().setQueryParameters(query, null, userId);
					mappedClass.getReadQuery().setQueryParameters(countQuery, null, userId);
				}
				else {
					queryString += " ORDER BY getAllResult.ID";
					if (returnTotal) {
						countQueryString += " ORDER BY ID";
						countQuery = s.createQuery(countQueryString);
					}
					query = s.createQuery(queryString);
				}
				if (pageSize != null && pageNumber != null && pageSize.intValue() > 0) {
					int pageValue = pageSize.intValue() * pageNumber.intValue();
					query.setFirstResult(pageValue);
					query.setMaxResults(pageSize.intValue());
				}
			}

			if (query != null) {
				
				log.debug("Get ALL: "+aClassName);	
				long t1 = new Date().getTime();
				List<?> list = query.list();
				long t2 = new Date().getTime();
				log.debug("Query Time: "+(t2-t1));
				PerceroList<IPerceroObject> result = new PerceroList<IPerceroObject>( (List<IPerceroObject>) SyncHibernateUtils.cleanObject(list, s, userId) );
				long t3 = new Date().getTime();
				log.debug("Clean Time: "+(t3-t2));
				
				result.setPageNumber(pageNumber);
				result.setPageSize(pageSize);
				
				if (returnTotal && pageSize != null && pageNumber != null && pageSize.intValue() > 0){
					result.setTotalLength(((Number)countQuery.uniqueResult()).intValue());
					log.debug("Total Obs: "+result.getTotalLength());
				}
				else
					result.setTotalLength(result.size());
				return result;
			}
			else {
				return null;
			}

		} catch (Exception e) {
			log.error("Unable to getAllByName", e);
		} finally {
			s.close();
		}

		return null;
	}
}

