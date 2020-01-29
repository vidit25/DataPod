package com.dp.services.profile.tools;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dp.db.model.DpAccount;
import com.dp.db.model.DpAuthority;
import com.dp.db.model.DpUser;
import com.dp.db.model.DpUserSubscription;
import com.dp.db.repository.AccountRepository;
import com.dp.db.repository.AuthorityRepository;
import com.dp.db.repository.UserRepository;
import com.dp.services.constants.Account;
import com.dp.services.constants.Error;
import com.dp.services.exception.GenericDaoException;
import com.dp.utils.DpUtils;

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
	
	/** The account repository. */
	@Autowired
	private AccountRepository accountRepository;



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
	
	/**
	 * Creates the account.
	 *
	 * @param pUserSubscription the user subscription
	 * @return the dp account
	 * @throws GenericDaoException the generic dao exception
	 */
	public DpAccount createAccount(DpUserSubscription pUserSubscription) throws GenericDaoException {
		DpAccount account = new DpAccount();
		String accountNumber = String.valueOf(pUserSubscription.getEmail().hashCode());
		accountNumber = accountNumber.replace("-", "");
		DpAccount accountExist = accountRepository.getAccountBasedOnAccountNum(accountNumber);
		if (accountExist != null) {
			throw new GenericDaoException(Error.ACCOUNT_ALREADY_EXIST.getCode(), 
					Error.ACCOUNT_ALREADY_EXIST.getLabel(), Error.ACCOUNT_ALREADY_EXIST.getValue());
		}
		account.setAccountNumber(accountNumber);
		account.setAddress(pUserSubscription.getAddress());
		if (pUserSubscription.getSubscriptionType() != null) {
			account.setCost(pUserSubscription.getSubscriptionType().getCost());
		}
		account.setOrganizationDescription(pUserSubscription.getOrganizationDescription());
		account.setOrganizationName(pUserSubscription.getOrganizationName());
		account.setPhone(pUserSubscription.getPhone());
		account.setSubscriptionId(pUserSubscription.getSubscriptionType());
		account.setStatus(Account.DEACTIVE.getValue());
		account.setCreationDate(Timestamp.valueOf(LocalDateTime.now()));
		account.setLastModifiedDate(Timestamp.valueOf(LocalDateTime.now()));
		account = accountRepository.save(account);
		/*if (account != null) {
			accountNumber = accountNumber + account.getAccountId();
			account.setAccountNumber(accountNumber);
			account = accountRepository.save(account);
		}*/
		return account;	
	}
	
	public void activateAccount(DpAccount pAccount) throws GenericDaoException {
		if (pAccount != null) {
			pAccount.setStatus(Account.ACTIVE.getValue());
			accountRepository.save(pAccount);
		}
	}
	
	/**
	 * Creates the user.
	 *
	 * @param pUserSubscription the user subscription
	 * @param pAccount the account
	 * @return the dp user
	 * @throws GenericDaoException the generic dao exception
	 */
	public DpUser createUser(DpUserSubscription pUserSubscription, DpAccount pAccount) throws GenericDaoException {
		DpUser user = new DpUser();
		user.setEmailAddress(pUserSubscription.getEmail());
		user.setPhone(pUserSubscription.getPhone());
		user.setFirstName(pUserSubscription.getOrganizationName());
		user.setAccountId(pAccount);
		user.setPassword(DpUtils.bCrypt(pAccount.getAccountNumber()));
		DpAuthority authority = authorityRepository.getRoleBasedOnType("ADMIN");
		if (authority != null) {
			List<DpAuthority> authorities = new ArrayList<DpAuthority>();
			authorities.add(authority);
			user.setAuthorities(authorities);
		}
		userRepository.save(user);
		return user;	
	}
	
	
	
	

}
