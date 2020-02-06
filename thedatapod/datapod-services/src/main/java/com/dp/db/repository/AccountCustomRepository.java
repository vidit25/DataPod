package com.dp.db.repository;

import com.dp.db.model.DpAccount;
import com.dp.services.exception.GenericDaoException;

public interface AccountCustomRepository {
	
	/**
	 * Gets the account on account num.
	 *
	 * @param pAccountNum
	 *            the account num
	 * @return the user based on user name
	 * @throws GenericDaoException
	 *             the generic dao exception
	 */
	public DpAccount getAccountBasedOnAccountNum(String pAccountNum) throws GenericDaoException;

	public DpAccount getAccountBasedOnAccountId(String accountId) throws GenericDaoException;
	
	
	
	
}
