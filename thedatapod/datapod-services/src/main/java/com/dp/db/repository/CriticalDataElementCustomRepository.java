package com.dp.db.repository;

import java.util.List;

import com.dp.db.model.DpCriticalDataElement;
import com.dp.services.exception.GenericDaoException;

/**
 * The Interface CriticalDataElementCustomRepository.
 */
public interface CriticalDataElementCustomRepository {
	
	/**
	 * Gets the CDE based on sub domain id.
	 * @param subDomainIds
	 * @return
	 * @throws GenericDaoException
	 */
	public List<DpCriticalDataElement> getCDEBySubDomain( List<Integer> subDomainIds) throws GenericDaoException;
	
	
	
	
	
}
