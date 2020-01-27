package com.dp.db.repository;

import com.dp.db.model.DpDomain;
import com.dp.services.exception.GenericDaoException;

/**
 * The Interface DomainCustomRepository.
 */
public interface DomainCustomRepository {
	
	
	/**
	 * Gets the domain based on status.
	 *
	 * @param pStatus the status
	 * @return the domain based on status
	 * @throws GenericDaoException the generic dao exception
	 */
	public DpDomain getDomainBasedOnStatus(String pStatus) throws GenericDaoException;
	
	
	
	
}
