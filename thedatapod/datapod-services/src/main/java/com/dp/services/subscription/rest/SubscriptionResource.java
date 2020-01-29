package com.dp.services.subscription.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dp.db.model.DpUserSubscription;
import com.dp.services.constants.Error;
import com.dp.services.exception.GenericException;
import com.dp.services.response.ErrorResponseVO;
import com.dp.services.response.GenericResponseVO;
import com.dp.services.subscription.manager.SubscriptionServiceManager;
import com.dp.services.subscription.request.SubscriptionTypeRequest;
import com.dp.services.subscription.request.UserSubscriptionRequest;
import com.dp.utils.DpUtils;
import com.dp.utils.ResourceBundleHelper;


/**
 * The Class SubscriptionResource.
 */
@RestController
public class SubscriptionResource {
	
	/** The logger. */
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	/** The resource bundle helper component. */
	@Autowired
	private ResourceBundleHelper resourceBundleHelperComponent;
	
	/** The subscription manager. */
	@Autowired
	private SubscriptionServiceManager subscriptionManager;
	
	/**
	 * Handle create subscription type.
	 *
	 * @param pRequest the request
	 * @param apiKey the api key
	 * @return the generic response VO
	 */
	@PostMapping(value = "/api/subscription-type")
	public @ResponseBody GenericResponseVO handleCreateSubscriptionType(@RequestBody SubscriptionTypeRequest pRequest,
			@RequestHeader(name = "x-api-Key") String apiKey) {
		GenericResponseVO subscriptionTypeResponse = new GenericResponseVO();
		LOGGER.debug("SubscriptionResource: handleCreateSubscriptionType - request ");
		try {
			subscriptionTypeResponse = subscriptionManager.createSubscriptionType(pRequest);			
		} catch (GenericException e) {
			String lMessage = resourceBundleHelperComponent.getMessage(e.getErrLevel(), null);
			List<ErrorResponseVO> errorMsg = DpUtils.generateErrorMsg(e.getErrCode(), 
					e.getErrLevel(), lMessage);
			subscriptionTypeResponse = new GenericResponseVO(false, errorMsg);
		} 
		LOGGER.debug("SubscriptionResource: handleCreateSubscriptionType - request handled");
		return subscriptionTypeResponse;
	}
	
	/**
	 * Handle update subscription type.
	 *
	 * @param pRequest the request
	 * @param apiKey the api key
	 * @return the generic response VO
	 */
	@PutMapping(value = "/api/subscription-type")
	public @ResponseBody GenericResponseVO handleUpdateSubscriptionType(@RequestBody SubscriptionTypeRequest pRequest,
			@RequestHeader(name = "x-api-Key") String apiKey) {
		GenericResponseVO subscriptionTypeResponse = new GenericResponseVO();
		LOGGER.debug("SubscriptionResource: handleUpdateSubscriptionType - request ");
		try {
			subscriptionTypeResponse = subscriptionManager.updateSubscriptionType(pRequest);			
		} catch (GenericException e) {
			String lMessage = resourceBundleHelperComponent.getMessage(e.getErrLevel(), null);
			List<ErrorResponseVO> errorMsg = DpUtils.generateErrorMsg(e.getErrCode(), 
					e.getErrLevel(), lMessage);
			subscriptionTypeResponse = new GenericResponseVO(false, errorMsg);
		} 
		LOGGER.debug("SubscriptionResource: handleUpdateSubscriptionType - request handled");
		return subscriptionTypeResponse;
	}
	
	
	
	/**
	 * Handle get subscription type.
	 *
	 * @param apiKey the api key
	 * @param typeId the type id
	 * @return the generic response VO
	 */
	@GetMapping(value = "/api/subscription-type/{typeId}")
	public @ResponseBody GenericResponseVO handleGetSubscriptionType(@RequestHeader(name = "x-api-Key") String apiKey,
			@PathVariable String typeId) {
		GenericResponseVO subscriptionTypeResponse = new GenericResponseVO();
		LOGGER.debug("SubscriptionResource: handleGetSubscriptionType - request ");
		try {
			if (!DpUtils.isEmptyString(typeId)) {
				subscriptionTypeResponse = subscriptionManager.getSubscriptionTypeById(Integer.parseInt(typeId));			
			} else {
				String message = resourceBundleHelperComponent.getMessage(Error.SUBSCRIPTION_TYPE_ID_REQUIRED.getLabel(), null);
				List<ErrorResponseVO> errorMsg = DpUtils.generateErrorMsg(Error.SUBSCRIPTION_TYPE_ID_REQUIRED.getCode(), 
						Error.SUBSCRIPTION_TYPE_ID_REQUIRED.getLabel(), message);
				subscriptionTypeResponse = new GenericResponseVO(false, errorMsg);
			}
		} catch (GenericException e) {
			String lMessage = resourceBundleHelperComponent.getMessage(e.getErrLevel(), null);
			List<ErrorResponseVO> errorMsg = DpUtils.generateErrorMsg(e.getErrCode(), 
					e.getErrLevel(), lMessage);
			subscriptionTypeResponse = new GenericResponseVO(false, errorMsg);
			LOGGER.error(e.getMessage(), e);
		}  catch(Exception e) {
			List<ErrorResponseVO> errorMsg = DpUtils.generateErrorMsg(Error.SYSTEM_ERROR.getCode(),
					Error.SYSTEM_ERROR.getLabel(), e.getMessage());
			subscriptionTypeResponse = new GenericResponseVO(false, errorMsg);
			LOGGER.error(e.getMessage(), e);
		}
		LOGGER.debug("SubscriptionResource: handleGetSubscriptionType - request handled");
		return subscriptionTypeResponse;
	}
	
	
	/**
	 * Handle get subscription type for domain.
	 *
	 * @param apiKey the api key
	 * @param domainId the domain id
	 * @return the generic response VO
	 */
	@GetMapping(value = "/api/domain/subscription-type/{domainId}")
	public @ResponseBody GenericResponseVO handleGetSubscriptionTypeForDomain(@RequestHeader(name = "x-api-Key") String apiKey,
			@PathVariable String domainId) {
		GenericResponseVO subscriptionTypeResponse = new GenericResponseVO();
		LOGGER.debug("SubscriptionResource: handleGetSubscriptionTypeForDomain - request ");
		try {
			if (!DpUtils.isEmptyString(domainId)) {
				subscriptionTypeResponse = subscriptionManager.getSubscriptionTypeByDomainId(Integer.parseInt(domainId));			
			} else {
				String message = resourceBundleHelperComponent.getMessage(Error.DOMAIN_ID_MISSING.getLabel(), null);
				List<ErrorResponseVO> errorMsg = DpUtils.generateErrorMsg(Error.DOMAIN_ID_MISSING.getCode(), 
						Error.DOMAIN_ID_MISSING.getLabel(), message);
				subscriptionTypeResponse = new GenericResponseVO(false, errorMsg);
			}
		} catch (GenericException e) {
			String lMessage = resourceBundleHelperComponent.getMessage(e.getErrLevel(), null);
			List<ErrorResponseVO> errorMsg = DpUtils.generateErrorMsg(e.getErrCode(), 
					e.getErrLevel(), lMessage);
			subscriptionTypeResponse = new GenericResponseVO(false, errorMsg);
			LOGGER.error(e.getMessage(), e);
		}  catch(Exception e) {
			List<ErrorResponseVO> errorMsg = DpUtils.generateErrorMsg(Error.SYSTEM_ERROR.getCode(),
					Error.SYSTEM_ERROR.getLabel(), e.getMessage());
			subscriptionTypeResponse = new GenericResponseVO(false, errorMsg);
			LOGGER.error(e.getMessage(), e);
		}
		LOGGER.debug("SubscriptionResource: handleGetSubscriptionType - request handled");
		return subscriptionTypeResponse;
	}
	
	/**
	 * Handle user subscription.
	 *
	 * @param pRequest the request
	 * @param apiKey the api key
	 * @return the generic response VO
	 */
	@PostMapping(value = "/api/subscribe")
	public @ResponseBody GenericResponseVO handleUserSubscription(@RequestBody UserSubscriptionRequest pRequest,
			@RequestHeader(name = "x-api-Key") String apiKey) {
		GenericResponseVO subscriptionTypeResponse = new GenericResponseVO();
		LOGGER.debug("SubscriptionResource: handleUserSubscription - request ");
		try {
			subscriptionTypeResponse = subscriptionManager.createUserSubscription(pRequest);			
		} catch (GenericException e) {
			String lMessage = resourceBundleHelperComponent.getMessage(e.getErrLevel(), null);
			List<ErrorResponseVO> errorMsg = DpUtils.generateErrorMsg(e.getErrCode(), 
					e.getErrLevel(), lMessage);
			subscriptionTypeResponse = new GenericResponseVO(false, errorMsg);
		} 
		LOGGER.debug("SubscriptionResource: handleUserSubscription - request handled");
		return subscriptionTypeResponse;
	}
	
	
	
	/**
	 * Handle get all subscriptions.
	 *
	 * @param apiKey the api key
	 * @return the generic response VO
	 */
	@GetMapping(value = "/api/all-subscriptions")
	public @ResponseBody GenericResponseVO handleGetAllSubscriptions(@RequestHeader(name = "x-api-Key") String apiKey) {
		GenericResponseVO subscriptionTypeResponse = new GenericResponseVO();
		LOGGER.debug("SubscriptionResource: handleGetAllSubscriptions - request ");
		try {
			List<DpUserSubscription> subscriptions = subscriptionManager.getAllSubscriptions();
			if (subscriptions != null && !subscriptions.isEmpty()) {
				subscriptionTypeResponse =  new GenericResponseVO(true, subscriptions);
			} else {
				String lMessage = resourceBundleHelperComponent.getMessage(Error.SUBSCRIPTIONS_NOT_FOUND.getLabel(), null);
				List<ErrorResponseVO> errorMsg = DpUtils.generateErrorMsg(Error.SUBSCRIPTIONS_NOT_FOUND.getCode(),
						Error.SUBSCRIPTIONS_NOT_FOUND.getLabel(), lMessage);
				subscriptionTypeResponse = new GenericResponseVO(false, errorMsg);
			}
		} catch(Exception e) {
			List<ErrorResponseVO> errorMsg = DpUtils.generateErrorMsg(Error.SYSTEM_ERROR.getCode(),
					Error.SYSTEM_ERROR.getLabel(), e.getMessage());
			subscriptionTypeResponse = new GenericResponseVO(false, errorMsg);
			LOGGER.error(e.getMessage(), e);
		}
		LOGGER.debug("SubscriptionResource: handleGetSubscriptionType - request handled");
		return subscriptionTypeResponse;
	}
	


}
