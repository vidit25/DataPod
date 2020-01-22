package com.dp.db.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.dp.db.model.DpUser;
import com.dp.db.repository.UserCustomRepository;
import com.dp.services.exception.GenericDaoException;

/**
 * The Class UserCustomRepositoryImpl.
 */
@Repository
@Transactional
public class UserCustomRepositoryImpl implements UserCustomRepository {

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
	@Override
	public DpUser getUserBasedOnUserName(String pUserName) throws GenericDaoException {
		Query query = entityManager.createNativeQuery("SELECT * FROM dp_user " + "WHERE email = ?", DpUser.class);
		query.setParameter(1, pUserName);
		List users = query.getResultList();
		if (users != null && !users.isEmpty()) {
			return (DpUser) users.get(0);
		}
		return null;
	}

	
}
