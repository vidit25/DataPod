package com.dp.db.repository;

import com.dp.db.model.DpUser;
import com.dp.services.exception.GenericDaoException;

public interface UserCustomRepository {
	
	/**
	 * Gets the user based on user name.
	 *
	 * @param pUserName
	 *            the user name
	 * @return the user based on user name
	 * @throws GenericDaoException
	 *             the generic dao exception
	 */
	public DpUser getUserBasedOnUserName(String pUserName) throws GenericDaoException;
	
	
	
	
}
