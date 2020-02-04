package com.dp.db.repository.impl;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.dp.db.model.DpCriticalDataElement;
import com.dp.db.repository.CriticalDataElementCustomRepository;
import com.dp.services.exception.GenericDaoException;

/**
 * The Class CriticalDataElementCustomRepositoryImpl.
 */
@Repository
@Transactional
public class CriticalDataElementCustomRepositoryImpl implements CriticalDataElementCustomRepository {

	/** The entity manager. */
	@PersistenceContext
	private EntityManager entityManager;
	
	
	
	/**
	 * Gets the CDE based on sub domain id.
	 * @param subDomainIds
	 * @return
	 * @throws GenericDaoException
	 */
	public List<DpCriticalDataElement> getCDEBySubDomain( List<Integer> subDomainIds) throws GenericDaoException {
		
		List<DpCriticalDataElement> criticalDataElements = null;
				Query query = entityManager.createNativeQuery("SELECT * FROM dp_cde cde " + "WHERE cde.sub_domain_id IN  (:subDomainIds)", DpCriticalDataElement.class);
		query.setParameter("subDomainIds", subDomainIds);
		criticalDataElements = query.getResultList();
		return criticalDataElements;
	}

	 

	
}
