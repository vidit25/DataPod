package com.dp.db.repository;

import java.util.List;

import com.dp.db.model.DpSubscriptionType;
import com.dp.services.exception.GenericDaoException;

/**
 * The Interface SubscriptionTypeCustomRepository.
 */
public interface SubscriptionTypeCustomRepository {
	
	
	/**
	 * Gets the subscription type based on status.
	 *
	 * @param pStatus the status
	 * @return the domain based on status
	 * @throws GenericDaoException the generic dao exception
	 */
	public DpSubscriptionType getSubscriptionTypeBasedOnStatus(String pStatus) throws GenericDaoException;
	
	/**
	 * Gets the subscription type based on domain.
	 *
	 * @param pDomainId the domain id
	 * @return the subscription type based on domain
	 * @throws GenericDaoException the generic dao exception
	 */
	public List<DpSubscriptionType> getSubscriptionTypeBasedOnDomain(Integer pDomainId) throws GenericDaoException;
	
	
	
	
}
