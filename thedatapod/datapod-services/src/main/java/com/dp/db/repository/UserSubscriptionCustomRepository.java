package com.dp.db.repository;

import java.util.List;

import com.dp.db.model.DpUserSubscription;
import com.dp.services.exception.GenericDaoException;

public interface UserSubscriptionCustomRepository {
	
	
	public DpUserSubscription getUserSubscriptionBasedOnEmail(String pEmail) throws GenericDaoException;
	
	/**
	 * Gets the user subscription based on status.
	 *
	 * @param pUserName the user name
	 * @return the user based on user name
	 * @throws GenericDaoException the generic dao exception
	 */
	public List<DpUserSubscription> getUserSubscriptionBasedOnStatus(String status) throws GenericDaoException;
	
	
	
	
}
