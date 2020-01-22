package com.dp.services.profile.manager;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.dp.db.model.DpUser;
import com.dp.services.exception.GenericDaoException;
import com.dp.services.exception.GenericException;
import com.dp.services.profile.tools.ProfileTools;
import com.dp.services.profile.request.RegisterUserRequest;
import com.dp.services.profile.response.GenericResponseVO;
import com.dp.utils.DpUtils;
import com.dp.utils.ResourceBundleHelper;

/**
 * The Class RegistrationServiceManager.
 */
@Service("registrationManager")
public class RegistrationServiceManager {

	/** The logger. */
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	/** The resource bundle helper component. */
	@Autowired
	private ResourceBundleHelper resourceBundleHelperComponent;

	
	
	/** The profileTools. */
	@Autowired
	private ProfileTools profileTools;
	
	/** The environment. */
	@Autowired
	private Environment environment;
	
	

	/**
	 * Method to handle registration requests.
	 *
	 * @param pRequest the request
	 * @return the generic response VO
	 * @throws GenericException the generic exception
	 */
	public GenericResponseVO processRegistration(@RequestBody final RegisterUserRequest pRequest)
			throws GenericException {

		LOGGER.debug("RegistrationService: processRegistration");

		GenericResponseVO responseVO = new GenericResponseVO();

		try {
			
			DpUser lUser = profileTools.getUserBasedOnUserName(pRequest.getEmail());
			if (lUser != null) {
				String lMessage = resourceBundleHelperComponent.getMessage("error.user.exist", null);
				responseVO.setSuccess(Boolean.FALSE);
				responseVO.setErrorResponse(lMessage);
				return responseVO;
			} else {
				// create new user
				DpUser user = new DpUser();
				String type = pRequest.getType();
				

				
				user.setEmailAddress(pRequest.getEmail());
				String firstName = pRequest.getFirstName();
				if (!DpUtils.isEmptyString(firstName)) {
					user.setFirstName(firstName);
				}
				String lastName = pRequest.getLastName();
				if (!DpUtils.isEmptyString(lastName)) {
					user.setLastName(pRequest.getLastName());
				}

				String phone = pRequest.getPhone();
				if (!DpUtils.isEmptyString(phone)) {
					user.setPhone(phone);
				}

				String lEncodedPwd = null;
				String generatedPassword = null;
				lEncodedPwd = DpUtils.bCrypt(pRequest.getPassword());
				String otp = null;
				if (!DpUtils.isEmptyString(lEncodedPwd)) {
					user.setPassword(lEncodedPwd);
					user.setStatus("ACTIVE");
					user.setFailureCount(0);
					DpUser createdUser = profileTools.createUser(user);

					if (createdUser == null) {
						String lMessage = resourceBundleHelperComponent.getMessage("error.invalid.request", null);
						responseVO.setSuccess(Boolean.FALSE);
						responseVO.setErrorResponse(lMessage);
						return responseVO;
					} 
				} else {
					String lMessage = resourceBundleHelperComponent.getMessage("error.invalid.request", null);
					responseVO.setSuccess(Boolean.FALSE);
					responseVO.setErrorResponse(lMessage);
					return responseVO;
				}


				responseVO.setSuccess(Boolean.TRUE);
				return responseVO;
			}
		}  catch (GenericDaoException e) {
			responseVO.setSuccess(Boolean.FALSE);
			responseVO.setErrorResponse(e.getMessage());
			return responseVO;
		}
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
}
