package com.dp.services.profile.manager;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.dp.db.model.DpAccount;
import com.dp.db.model.DpUser;
import com.dp.db.model.DpUserSubscription;
import com.dp.services.constants.Error;
import com.dp.services.constants.UserSubscriptionType;
import com.dp.services.exception.GenericDaoException;
import com.dp.services.exception.GenericException;
import com.dp.services.profile.request.ActivateSubscriptionRequest;
import com.dp.services.profile.tools.ProfileTools;
import com.dp.services.response.ErrorResponseVO;
import com.dp.services.response.GenericResponseVO;
import com.dp.services.subscription.tools.SubscriptionTools;
import com.dp.utils.DpUtils;
import com.dp.utils.ResourceBundleHelper;

/**
 * The Class ProfileServiceManager.
 */
@Service("profileServiceManager")
public class ProfileServiceManager {

	/** The logger. */
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	/** The resource bundle helper component. */
	@Autowired
	private ResourceBundleHelper resourceBundleHelperComponent;	
	
	/** The profileTools. */
	@Autowired
	private ProfileTools profileTools;
	
	/** The subscription tools. */
	@Autowired
	private SubscriptionTools subscriptionTools;
	
	/** The environment. */
	@Autowired
	private Environment environment;
	
	/**
	 * Gets the user based on user name.
	 *
	 * @param pUserName the user name
	 * @return the user based on user name
	 * @throws GenericDaoException the generic dao exception
	 */
	public DpUser getUserBasedOnUserName(String pUserName) throws GenericDaoException {
		return profileTools.getUserBasedOnUserName(pUserName);
	}
	
	

		
	/**
	 * Gets the current user name.
	 *
	 * @return the current user name
	 */
	public final String getCurrentUserName() {
		String userName = null;
		Object lPrincipal = null;
		if (SecurityContextHolder.getContext().getAuthentication() != null) {
			lPrincipal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		if (lPrincipal instanceof User) {
			userName = ((User) lPrincipal).getUsername();
		}
		return userName;
	}
	
	
	/**
	 * Activate subscription.
	 *
	 * @param pActivateRequest the activate request
	 * @return the generic response VO
	 * @throws GenericException the generic exception
	 */
	public GenericResponseVO activateSubscription(ActivateSubscriptionRequest pActivateRequest) throws GenericException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("activateSubscription");
		}
		GenericResponseVO userResponse = new GenericResponseVO();
		try {
			if (pActivateRequest != null && pActivateRequest.getSubscriptionId() != null) {
				DpUserSubscription userSubscription = subscriptionTools.getUserSubscription(pActivateRequest.getSubscriptionId());
				if (userSubscription != null) {
					userSubscription.setStatus(UserSubscriptionType.ACTIVE.getValue());
					subscriptionTools.saveUserSubscription(userSubscription);
					DpAccount account = profileTools.createAccount(userSubscription);
					if (account != null) {
						DpUser user = profileTools.createUser(userSubscription, account);
						if (user != null) {
							profileTools.activateAccount(account);
							userResponse = new GenericResponseVO(true, user);
							return userResponse;
						} else {
							String lMessage = resourceBundleHelperComponent.getMessage(Error.ACCOUNT_CREATION_ERROR.getLabel(), null);
							List<ErrorResponseVO> errorMsg = DpUtils.generateErrorMsg(Error.ACCOUNT_CREATION_ERROR.getCode(), 
									Error.ACCOUNT_CREATION_ERROR.getLabel(), lMessage);
							userResponse = new GenericResponseVO(false, errorMsg);	
							return userResponse;
						}
					} else {
						String lMessage = resourceBundleHelperComponent.getMessage(Error.ACCOUNT_CREATION_ERROR.getLabel(), null);
						List<ErrorResponseVO> errorMsg = DpUtils.generateErrorMsg(Error.ACCOUNT_CREATION_ERROR.getCode(), 
								Error.ACCOUNT_CREATION_ERROR.getLabel(), lMessage);
						userResponse = new GenericResponseVO(false, errorMsg);	
						return userResponse;
					}
					
				} else {
					String lMessage = resourceBundleHelperComponent.getMessage(Error.USER_SUBSCRIPTION_NOT_FOUND.getLabel(), null);
					List<ErrorResponseVO> errorMsg = DpUtils.generateErrorMsg(Error.USER_SUBSCRIPTION_NOT_FOUND.getCode(), 
							Error.USER_SUBSCRIPTION_NOT_FOUND.getLabel(), lMessage);
					userResponse = new GenericResponseVO(false, errorMsg);	
					return userResponse;
				}
							
			} else {
				String lMessage = resourceBundleHelperComponent.getMessage(Error.USER_SUBSCRIPTION_TYPE_ID_REQUIRED.getLabel(), null);
				List<ErrorResponseVO> errorMsg = DpUtils.generateErrorMsg(Error.USER_SUBSCRIPTION_TYPE_ID_REQUIRED.getCode(), 
						Error.USER_SUBSCRIPTION_TYPE_ID_REQUIRED.getLabel(), lMessage);
				userResponse = new GenericResponseVO(false, errorMsg);	
				return userResponse;
			}

		} catch (GenericDaoException e) {
			String lMessage = resourceBundleHelperComponent.getMessage(e.getErrLevel(), null);
			List<ErrorResponseVO> errorMsg = DpUtils.generateErrorMsg(e.getErrCode(), 
					e.getErrLevel(), lMessage);
			userResponse = new GenericResponseVO(false, errorMsg);	
			return userResponse;
		}
	}

}
