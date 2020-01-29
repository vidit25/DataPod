package com.dp.services.profile.rest;

import java.security.Principal;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dp.db.model.DpUser;
import com.dp.utils.DpUtils;
import com.dp.utils.ResourceBundleHelper;
import com.dp.services.constants.Error;
import com.dp.services.exception.GenericException;
import com.dp.services.profile.manager.ProfileServiceManager;
import com.dp.services.profile.request.ActivateSubscriptionRequest;
import com.dp.services.response.ErrorResponseVO;
import com.dp.services.response.GenericResponseVO;

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

	/** The profile service manager. */
	@Autowired
	private ProfileServiceManager profileServiceManager;
	
	/** The environment. */
	@Autowired
	private Environment environment;

	
	
	/**
	 * Handle current user.
	 *
	 * @param apiKey the api key
	 * @param pPrincipal the principal
	 * @return the generic response VO
	 */
	@GetMapping(value = "/api/user")
	public @ResponseBody GenericResponseVO handleCurrentUser(@RequestHeader(name = "x-api-Key") String apiKey,
			Principal pPrincipal) {
		GenericResponseVO userResponse = new GenericResponseVO();
		LOGGER.debug("CurrentUserResource: handleCurrentUser - request ");
		try {
			if (pPrincipal != null) {
				DpUser lUser = profileServiceManager.getUserBasedOnUserName(pPrincipal.getName());
				if (lUser != null) {			
					Map userMap = DpUtils.getPojoToMapObject(lUser);
					userMap.remove("password");		
					userResponse = new GenericResponseVO(true, userMap);
				}
			} else {
				String message = resourceBundleHelperComponent.getMessage(Error.USER_NOT_FOUND.getLabel(), null);
				List<ErrorResponseVO> errorMsg = DpUtils.generateErrorMsg(Error.USER_NOT_FOUND.getCode(), 
						Error.USER_NOT_FOUND.getLabel(), message);
				userResponse = new GenericResponseVO(false, errorMsg);
			}
		}  catch(Exception e) {
			List<ErrorResponseVO> errorMsg = DpUtils.generateErrorMsg(Error.SYSTEM_ERROR.getCode(),
					Error.SYSTEM_ERROR.getLabel(), e.getMessage());
			userResponse = new GenericResponseVO(false, errorMsg);
			LOGGER.error(e.getMessage(), e);
		}
		LOGGER.debug("CurrentUserResource: handleCurrentUser - request handled");
		return userResponse;
	}
	
	
	
	/**
	 * Handle activate subscription.
	 *
	 * @param pRequest the request
	 * @param apiKey the api key
	 * @return the generic response VO
	 */
	@PostMapping(value = "/api/user/activate-subscription")
	public @ResponseBody GenericResponseVO handleActivateSubscription(@RequestBody ActivateSubscriptionRequest pRequest,
			@RequestHeader(name = "x-api-Key") String apiKey) {
		GenericResponseVO userResponse = new GenericResponseVO();
		LOGGER.debug("CurrentUserResource: handleActivateSubscription - request ");
		try {
			userResponse = profileServiceManager.activateSubscription(pRequest);			
		} catch (GenericException e) {
			String lMessage = resourceBundleHelperComponent.getMessage(e.getErrLevel(), null);
			List<ErrorResponseVO> errorMsg = DpUtils.generateErrorMsg(e.getErrCode(), 
					e.getErrLevel(), lMessage);
			userResponse = new GenericResponseVO(false, errorMsg);
		} 
		LOGGER.debug("CurrentUserResource: handleActivateSubscription - request handled");
		return userResponse;
	}

}
