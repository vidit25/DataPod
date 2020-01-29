package com.dp.db.repository;

import com.dp.db.model.DpUserSubscription;
import com.dp.services.exception.GenericDaoException;

public interface UserSubscriptionCustomRepository {
	
	
	public DpUserSubscription getUserSubscriptionBasedOnEmail(String pEmail) throws GenericDaoException;
	
	
	
	
}
