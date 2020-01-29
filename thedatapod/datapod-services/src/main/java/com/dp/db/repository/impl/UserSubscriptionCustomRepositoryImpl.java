package com.dp.db.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.dp.db.model.DpUser;
import com.dp.db.model.DpUserSubscription;
import com.dp.db.repository.UserCustomRepository;
import com.dp.db.repository.UserSubscriptionCustomRepository;
import com.dp.services.exception.GenericDaoException;

/**
 * The Class UserSubscriptionCustomRepositoryImpl.
 */
@Repository
@Transactional
public class UserSubscriptionCustomRepositoryImpl implements UserSubscriptionCustomRepository {

	/** The entity manager. */
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Gets the user based on user name.
	 *
	 * @param pUserName the user name
	 * @return the user based on user name
	 * @throws GenericDaoException the generic dao exception
	 */
	public DpUserSubscription getUserSubscriptionBasedOnEmail(String pEmail) throws GenericDaoException {
		Query query = entityManager.createNativeQuery("SELECT * FROM user_subscription " + "WHERE email = ?", DpUserSubscription.class);
		query.setParameter(1, pEmail);
		List userSubscription = query.getResultList();
		if (userSubscription != null && !userSubscription.isEmpty()) {
			return (DpUserSubscription) userSubscription.get(0);
		}
		return null;
	}

	
}
