package com.dp.db.repository;

import com.dp.db.model.DpUser;
import com.dp.services.exception.GenericDaoException;

// TODO: Auto-generated Javadoc
/**
 * The Interface UserCustomRepository.
 */
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
	
	/**
	 * Gets the user based on account number.
	 *
	 * @param pAccountName the account name
	 * @return the user based on account number
	 * @throws GenericDaoException the generic dao exception
	 */
	public DpUser getUserBasedOnAccountNumber(String pAccountName) throws GenericDaoException;
	
	
	
	
}
