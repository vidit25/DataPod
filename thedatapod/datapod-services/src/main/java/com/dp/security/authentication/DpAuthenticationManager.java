package com.dp.security.authentication;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.common.exceptions.UserDeniedAuthorizationException;
import org.springframework.stereotype.Component;

import com.dp.db.model.DpAuthority;
import com.dp.db.model.DpUser;
import com.dp.services.profile.tools.ProfileTools;
import com.dp.services.exception.GenericDaoException;
import com.dp.utils.DpUtils;
import com.dp.utils.ResourceBundleHelper;

/**
 * The Class DpAuthenticationManager.
 */
@Component
public class DpAuthenticationManager extends AbstractUserDetailsAuthenticationProvider {

	/** The logger. */
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/** The user service. */
	@Autowired
	private ProfileTools profileTools;

	/** The resource bundle helper component. */
	@Autowired
	private ResourceBundleHelper resourceBundleHelperComponent;

	/**
	 * Additional authentication checks.
	 *
	 * @param arg0 the arg 0
	 * @param arg1 the arg 1
	 * @throws AuthenticationException the authentication exception
	 */
	@Override
	protected void additionalAuthenticationChecks(UserDetails arg0, UsernamePasswordAuthenticationToken arg1)
			throws AuthenticationException {

	}

	/**
	 * Authenticate.
	 *
	 * @param authentication the authentication
	 * @return the authentication
	 * @throws AuthenticationException the authentication exception
	 */
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		return super.authenticate(authentication);
	}

	/**
	 * Retrieve user.
	 *
	 * @param userName  the user name
	 * @param userToken the user token
	 * @return the user details
	 * @throws AuthenticationException the authentication exception
	 */
	@Override
	protected UserDetails retrieveUser(String userName, UsernamePasswordAuthenticationToken userToken)
			throws AuthenticationException {
		try {
			if (logger.isDebugEnabled()) {
				logger.debug("inside retrieveUser method:::");
			}
			DpUser lUser = profileTools.getUserBasedOnUserName(userName);
			if (lUser != null) {
				boolean validatePassword = validatePassword(userName, (String) userToken.getCredentials(), lUser);
				if (validatePassword) {
					List<DpAuthority> lAuthorities = lUser.getAuthorities();
					List<GrantedAuthority> lGrants = new ArrayList<GrantedAuthority>();
					if (lAuthorities != null) {
						for (DpAuthority lAuthority : lAuthorities) {
							GrantedAuthority lGrantAuthority = new SimpleGrantedAuthority(lAuthority.getName());
							lGrants.add(lGrantAuthority);
						}
					}
					UserDetails lUserDetails = (UserDetails) new User(lUser.getEmailAddress(), lUser.getPassword(),
							lGrants);
					return lUserDetails;
				} else {				
					
					String lMessage = resourceBundleHelperComponent.getMessage("error.login", null);
					throw new UserDeniedAuthorizationException(lMessage);

				}
			} else {
				String lMessage = resourceBundleHelperComponent.getMessage("error.user.notExist", null);
				throw new UserDeniedAuthorizationException(lMessage);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new UserDeniedAuthorizationException(e.getMessage());
		}
	}

	/**
	 * Supports.
	 *
	 * @param authentication the authentication
	 * @return true, if successful
	 */
	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

	/**
	 * Validate password.
	 *
	 * @param username the username
	 * @param password the password
	 * @param user     the user
	 * @return true, if successful
	 * @throws GenericDaoException the generic dao exception
	 */
	public boolean validatePassword(String username, String password, DpUser user) throws GenericDaoException {
		String lEncryptedPassword = user.getPassword();
		boolean lPasswordMatched = DpUtils.matchPassword(password, lEncryptedPassword);
		if (!lPasswordMatched) {			
			return Boolean.FALSE;
		} else {
			return Boolean.TRUE;
		}
	}

}
