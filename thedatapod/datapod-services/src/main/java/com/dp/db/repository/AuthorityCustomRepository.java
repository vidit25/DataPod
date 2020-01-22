package com.dp.db.repository;

import com.dp.db.model.DpAuthority;
import com.dp.services.exception.GenericDaoException;

/**
 * The Interface AuthorityDao.
 */
public interface AuthorityCustomRepository {
	
	/**
	 * Gets the role based on type.
	 *
	 * @param pType the type
	 * @return the role based on type
	 * @throws GenericDaoException the generic dao exception
	 */
	public DpAuthority getRoleBasedOnType(String pType) throws GenericDaoException;

}
