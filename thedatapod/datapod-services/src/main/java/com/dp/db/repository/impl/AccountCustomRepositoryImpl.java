package com.dp.db.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.dp.db.model.DpAccount;
import com.dp.db.repository.AccountCustomRepository;
import com.dp.services.exception.GenericDaoException;

/**
 * The Class AccountCustomRepositoryImpl.
 */
@Repository
@Transactional
public class AccountCustomRepositoryImpl implements AccountCustomRepository {

	/** The entity manager. */
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Gets the account on account num.
	 *
	 * @param pAccountNum
	 *            the account num
	 * @return the user based on user name
	 * @throws GenericDaoException
	 *             the generic dao exception
	 */
	@Override
	public DpAccount getAccountBasedOnAccountNum(String pAccountNum) throws GenericDaoException {
		Query query = entityManager.createNativeQuery("SELECT * FROM account " + "WHERE account_num = ?", DpAccount.class);
		query.setParameter(1, pAccountNum);
		List users = query.getResultList();
		if (users != null && !users.isEmpty()) {
			return (DpAccount) users.get(0);
		}
		return null;
	}

	
}
