package com.pulse.mo.dao;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.percero.agents.sync.dao.IDataAccessObject;
import com.percero.agents.sync.exceptions.SyncException;
import com.percero.agents.sync.metadata.MappedField;
import com.percero.agents.sync.vo.ClassIDPair;
import com.percero.agents.sync.vo.ClassIDPairs;
import com.percero.framework.vo.PerceroList;

public class EmailStaticDAO extends SqlDataAccessObject<Email> implements IDataAccessObject<Email> {

	public EmailStaticDAO() {
		// TODO Auto-generated constructor stub
	}
	
	private final String READ_ACCESS_SQL = null; 

	@Override
	public Boolean hasCreateAccess(ClassIDPair classIdPair, String userId) {
		// TODO Auto-generated method stub
		if (READ_ACCESS_SQL == null) {
			return true;
		}
		else {
			
		}
	}

	@Override
	public Boolean hasReadAccess(ClassIDPair classIdPair, String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean hasUpdateAccess(ClassIDPair classIdPair, String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean hasDeleteAccess(ClassIDPair classIdPair, String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PerceroList<T> getAll(Integer pageNumber, Integer pageSize,
			Boolean returnTotal, String userId, Boolean shellOnly)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer countAll(String userId) throws SyncException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> retrieveAllByRelationship(MappedField mappedField,
			ClassIDPair targetClassIdPair, Boolean shellOnly, String userId)
			throws SyncException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findByExample(T theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly)
			throws SyncException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T retrieveObject(ClassIDPair classIdPair, String userId,
			Boolean shellOnly) throws SyncException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> retrieveObjects(ClassIDPairs classIdPairs, String userId,
			Boolean shellOnly) throws SyncException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T createObject(T percero, String userIdObject) throws SyncException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T updateObject(T perceroObject,
			Map<ClassIDPair, Collection<MappedField>> changedFields,
			String userId) throws SyncException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteObject(ClassIDPair classIdPair, String userId)
			throws SyncException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> runQuery(String queryName, Object[] queryArguments,
			String userId) throws SyncException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T cleanObjectForUser(T perceroObject, String userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
