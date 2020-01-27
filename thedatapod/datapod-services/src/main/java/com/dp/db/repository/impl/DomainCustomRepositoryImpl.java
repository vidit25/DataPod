package com.dp.db.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.dp.db.model.DpDomain;
import com.dp.db.repository.DomainCustomRepository;
import com.dp.services.exception.GenericDaoException;

/**
 * The Class DomainCustomRepositoryImpl.
 */
@Repository
@Transactional
public class DomainCustomRepositoryImpl implements DomainCustomRepository {

	/** The entity manager. */
	@PersistenceContext
	private EntityManager entityManager;	
	
	
	/**
	 * Gets the domain based on status.
	 *
	 * @param pStatus the status
	 * @return the domain based on status
	 * @throws GenericDaoException the generic dao exception
	 */
	public DpDomain getDomainBasedOnStatus(String pStatus) throws GenericDaoException {
		Query query = entityManager.createNativeQuery("SELECT * FROM domains " + "WHERE status = ?", DpDomain.class);
		query.setParameter(1, pStatus);
		List domains = query.getResultList();
		if (domains != null && !domains.isEmpty()) {
			return (DpDomain) domains.get(0);
		}
		return null;
	}


	
}
