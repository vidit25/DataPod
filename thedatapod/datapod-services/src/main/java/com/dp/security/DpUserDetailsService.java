package com.dp.security;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dp.db.model.DpAuthority;
import com.dp.db.model.DpUser;
import com.dp.services.profile.tools.ProfileTools;
import com.dp.services.exception.GenericDaoException;

/**
 * The Class CbUserDetailsService.
 */
@Service("customUserDetailsService")
public class DpUserDetailsService implements UserDetailsService {

	/** The logger. */
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/** The request. */
	@Autowired
	private HttpServletRequest request;

	/** The user service. */
	@Autowired
	private ProfileTools profileTools;

	
	/**
	 * Load user by username.
	 *
	 * @param username the username
	 * @return the user details
	 * @throws UsernameNotFoundException the username not found exception
	 */
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		DpUser lUser = null;
		try {
			if (logger.isDebugEnabled()) {
				logger.debug("inside loadUserByUsername method:::");
			}
			lUser = profileTools.getUserBasedOnUserName(username);
		} catch (GenericDaoException e) {
			logger.error(e.getMessage(), e);
			throw new UsernameNotFoundException(e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new UsernameNotFoundException(e.getMessage());
		}
		if (lUser != null) {
			List<DpAuthority> lAuthorities = lUser.getAuthorities();
			List<GrantedAuthority> lGrants = new ArrayList<GrantedAuthority>();
			if (lAuthorities != null) {
				for (DpAuthority lAuthority : lAuthorities) {
					GrantedAuthority lGrantAuthority = new SimpleGrantedAuthority(lAuthority.getAuthority());
					lGrants.add(lGrantAuthority);
				}
			}
			UserDetails lUserDetails = (UserDetails) new User(lUser.getEmailAddress(), lUser.getPassword(), lGrants);
			return lUserDetails;
		} else {
			throw new UsernameNotFoundException(username);
		}
	}
}
