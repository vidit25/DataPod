package com.dp.db.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.dp.db.model.DpAuthority;
import com.dp.db.repository.AuthorityCustomRepository;
import com.dp.services.exception.GenericDaoException;

/**
 * The Class AuthorityCustomRepositoryImpl.
 */
@Repository
@Transactional
public class AuthorityCustomRepositoryImpl implements AuthorityCustomRepository {

	/** The entity manager. */
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Gets the role based on type.
	 *
	 * @param pType the type
	 * @return the role based on type
	 * @throws GenericDaoException the generic dao exception
	 */
	@Override
	public DpAuthority getRoleBasedOnType(String pType) throws GenericDaoException {
		Query query = entityManager.createNativeQuery("SELECT * FROM authority " + "WHERE name = ?", DpAuthority.class);
		query.setParameter(1, pType);
		List users = query.getResultList();
		if (users != null && !users.isEmpty()) {
			return (DpAuthority) users.get(0);
		}
		return null;
	}

}
