package com.dp.db.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.dp.db.model.DpSubDomain;
import com.dp.db.repository.SubDomainCustomRepository;
import com.dp.services.exception.GenericDaoException;

/**
 * The Class SubDomainCustomRepositoryImpl.
 */
@Repository
@Transactional
public class SubDomainCustomRepositoryImpl implements SubDomainCustomRepository {

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
	public DpSubDomain getSubDomainBasedOnStatus(String pStatus) throws GenericDaoException {
		Query query = entityManager.createNativeQuery("SELECT * FROM sub_domains " + "WHERE status = ?", DpSubDomain.class);
		query.setParameter(1, pStatus);
		List domains = query.getResultList();
		if (domains != null && !domains.isEmpty()) {
			return (DpSubDomain) domains.get(0);
		}
		return null;
	}


	
}
