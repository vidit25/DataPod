package com.dp.db.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.dp.db.model.DpSubscriptionType;
import com.dp.db.repository.SubscriptionTypeCustomRepository;
import com.dp.services.exception.GenericDaoException;

/**
 * The Class SubscriptionTypeCustomRepositoryImpl.
 */
@Repository
@Transactional
public class SubscriptionTypeCustomRepositoryImpl implements SubscriptionTypeCustomRepository {

	/** The entity manager. */
	@PersistenceContext
	private EntityManager entityManager;	
	
	
	/**
	 * Gets the subscription type based on status.
	 *
	 * @param pStatus the status
	 * @return the domain based on status
	 * @throws GenericDaoException the generic dao exception
	 */
	public DpSubscriptionType getSubscriptionTypeBasedOnStatus(String pStatus) throws GenericDaoException {
		Query query = entityManager.createNativeQuery("SELECT * FROM subscription_type " + "WHERE status = ?", DpSubscriptionType.class);
		query.setParameter(1, pStatus);
		List subscriptionTypes = query.getResultList();
		if (subscriptionTypes != null && !subscriptionTypes.isEmpty()) {
			return (DpSubscriptionType) subscriptionTypes.get(0);
		}
		return null;
	}
	
	/**
	 * Gets the subscription type based on domain.
	 *
	 * @param pDomainId the domain id
	 * @return the subscription type based on domain
	 * @throws GenericDaoException the generic dao exception
	 */
	public List<DpSubscriptionType> getSubscriptionTypeBasedOnDomain(Integer pDomainId) throws GenericDaoException {
		Query query = entityManager.createNativeQuery("SELECT * FROM subscription_type " + "WHERE domain_id = ?", DpSubscriptionType.class);
		query.setParameter(1, pDomainId);
		List subscriptionTypes = query.getResultList();
		if (subscriptionTypes != null && !subscriptionTypes.isEmpty()) {
			return (List<DpSubscriptionType>) subscriptionTypes;
		}
		return null;
	}
	


	
}
