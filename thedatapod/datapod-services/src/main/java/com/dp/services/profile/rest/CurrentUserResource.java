package com.dp.services.profile.rest;

import java.io.IOException;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dp.db.model.DpUser;
import com.dp.utils.DpUtils;
import com.dp.utils.ResourceBundleHelper;
import com.dp.services.exception.GenericDaoException;
import com.dp.services.profile.tools.ProfileTools;

/**
 * The Class CurrentUserResource.
 */
@RestController
public class CurrentUserResource {

	/** The logger. */
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	/** The resource bundle helper component. */
	@Autowired
	private ResourceBundleHelper resourceBundleHelperComponent;

	/** The ProfileTools. */
	@Autowired
	private ProfileTools profileTools;
	
		/** The environment. */
		@Autowired
	private Environment environment;

	/**
	 * Current user.
	 *
	 * @param pPrincipal the principal
	 * @return the map
	 */

	@GetMapping("/secured/user")
	public Map<String, Object> currentUser(Principal pPrincipal) {
		Map<String, Object> userMap = new HashMap<String, Object>();
		try {
			if (pPrincipal != null) {
				DpUser lUser = profileTools.getUserBasedOnUserName(pPrincipal.getName());
				if (lUser != null) {			
					userMap = DpUtils.getPojoToMapObject(lUser);
					userMap.remove("password");					
				}
			} else {
				String lMessage = resourceBundleHelperComponent.getMessage("error.user.not.found", null);
				userMap = DpUtils.generateErrorResponse(lMessage, null, "400");
			}
		} catch (IOException e) {
			userMap = DpUtils.generateErrorResponse(e.getMessage(), null, "400");
		} catch (GenericDaoException e) {
			userMap = DpUtils.generateErrorResponse(e.getMessage(), null, "400");
		}
		return userMap;
	}

}
