package com.dp.db.repository;

import com.dp.db.model.DpSubDomain;
import com.dp.services.exception.GenericDaoException;

/**
 * The Interface SubDomainCustomRepository.
 */
public interface SubDomainCustomRepository {
	
	
	/**
	 * Gets the sub domain based on status.
	 *
	 * @param pStatus the status
	 * @return the domain based on status
	 * @throws GenericDaoException the generic dao exception
	 */
	public DpSubDomain getSubDomainBasedOnStatus(String pStatus) throws GenericDaoException;
	
	
	
	
}
