package com.dp.services.profile.tools;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dp.db.model.DpAuthority;
import com.dp.db.model.DpUser;
import com.dp.db.repository.AuthorityRepository;
import com.dp.db.repository.UserRepository;
import com.dp.services.exception.GenericDaoException;

/**
 * The Class ProfileTools.
 */
@Transactional
@Service("profileTools")
public class ProfileTools {

	/** The user repository. */
	@Autowired
	private UserRepository userRepository;

	
	/** The authority repository. */
	@Autowired
	private AuthorityRepository authorityRepository;

	/**
	 * Creates the user.
	 *
	 * @param pUser the user
	 * @return the ly user
	 * @throws GenericDaoException the generic dao exception
	 */
	public DpUser createUser(DpUser pUser) throws GenericDaoException {
		try {
			if (pUser == null) {
				throw new GenericDaoException("User Information is missing");
			}
			DpUser lUser = userRepository.getUserBasedOnUserName(pUser.getEmailAddress());
			if (lUser != null) {
				throw new GenericDaoException("User Exists");
			} else {				
				pUser.setStatus("ACTIVE");
				pUser.setFailureCount(0);
				DpAuthority lAuthority = authorityRepository.getRoleBasedOnType("CUSTOMER");
				if (lAuthority != null) {
					List<DpAuthority> lAuthorities = new ArrayList<DpAuthority>();
					lAuthorities.add(lAuthority);
					pUser.setAuthorities(lAuthorities);
				}
				DpUser lUpdatedUser = userRepository.save(pUser);
				// fetch the user
				return lUpdatedUser;
			}
		} catch (GenericDaoException e) {
			throw e;
		}
	}

	
	/**
	 * Update user.
	 *
	 * @param pUser the user
	 * @return the ly user
	 * @throws GenericDaoException the generic dao exception
	 */
	public DpUser updateUser(DpUser pUser) throws GenericDaoException {
		try {
			if (pUser == null) {
				throw new GenericDaoException("User Information is missing");
			}
			DpUser lUser = userRepository.getUserBasedOnUserName(pUser.getEmailAddress());
			if (lUser == null) {
				throw new GenericDaoException("User does not Exists");
			} else {
				userRepository.save(pUser);
			}
		} catch (GenericDaoException e) {
			throw e;
		}
		return null;
	}

	/**
	 * Change password.
	 *
	 * @param pUserName the user name
	 * @param pPassword the password
	 * @return true, if successful
	 * @throws GenericDaoException the generic dao exception
	 */
	public boolean changePassword(String pUserName, String pPassword) throws GenericDaoException {
		boolean lStatus = false;
		try {
			DpUser lUser = userRepository.getUserBasedOnUserName(pUserName);
			if (lUser == null) {
				throw new GenericDaoException("User does not exists");
			} else {
				lUser.setPassword(pPassword);
				lUser.setResetFlag(Boolean.FALSE);
				userRepository.save(lUser);
				lStatus = true;
			}
		} catch (GenericDaoException e) {
			throw e;
		}
		return lStatus;
	}

	
	/**
	 * Gets the user based on user name.
	 *
	 * @param pUserName the user name
	 * @return the user based on user name
	 * @throws GenericDaoException the generic dao exception
	 */

	public DpUser getUserBasedOnUserName(String pUserName) throws GenericDaoException {
		DpUser user = userRepository.getUserBasedOnUserName(pUserName);
		return user;
	}

	/**
	 * Gets the user based on token.
	 *
	 * @return the user based on token
	 * @throws GenericDaoException the generic dao exception
	 */

	public DpUser getUserBasedOnToken() throws GenericDaoException {
		// TODO
		return null;
	}

	
	/**
	 * Deletes User.
	 *
	 * @param createdUser the created user
	 * @throws GenericDaoException the generic dao exception
	 */

	public void deleteUser(DpUser createdUser) throws GenericDaoException {
		userRepository.delete(createdUser);

	}

	/**
	 * Save user.
	 *
	 * @param lUser the l user
	 * @throws GenericDaoException the generic dao exception
	 */
	public void saveUser(DpUser lUser) throws GenericDaoException {
		userRepository.save(lUser);

	}

}
