package com.dp.services.subscription.manager;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.dp.db.model.DpDomain;
import com.dp.db.model.DpSubscriptionType;
import com.dp.services.constants.Error;
import com.dp.services.exception.GenericDaoException;
import com.dp.services.exception.GenericException;
import com.dp.services.response.ErrorResponseVO;
import com.dp.services.response.GenericResponseVO;
import com.dp.services.subscription.request.SubscriptionTypeRequest;
import com.dp.services.subscription.tools.SubscriptionTools;
import com.dp.utils.DpUtils;
import com.dp.utils.ResourceBundleHelper;

/**
 * The Class subscriptionServiceManager.
 */
@Service("subscriptionManager")
public class SubscriptionServiceManager {

	/** The logger. */
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	/** The resource bundle helper component. */
	@Autowired
	private ResourceBundleHelper resourceBundleHelperComponent;	
	
	/** The environment. */
	@Autowired
	private Environment environment;
	
	/** The subscription tools. */
	@Autowired
	private SubscriptionTools subscriptionTools;
	
	
	
	
	
	/**
	 * Creates the subscription type.
	 *
	 * @param pRequest the request
	 * @return the generic response VO
	 * @throws GenericException the generic exception
	 */
	public GenericResponseVO createSubscriptionType(SubscriptionTypeRequest pRequest) throws GenericException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("createSubscriptionType");
		}
		GenericResponseVO subTypeResponse = new GenericResponseVO();
		try {
			if (pRequest != null && pRequest.getDomainId() != null) {
					DpSubscriptionType subscriptionType = new DpSubscriptionType();				
					BeanUtils.copyProperties(pRequest, subscriptionType);
					subscriptionType = subscriptionTools.createSubscriptionTypeDomain(subscriptionType, pRequest);
					subTypeResponse = new GenericResponseVO(true, subscriptionType);	
					return subTypeResponse;			
			} else {
				String lMessage = resourceBundleHelperComponent.getMessage(Error.DOMAIN_ROOT_REQUIRED.getLabel(), null);
				List<ErrorResponseVO> errorMsg = DpUtils.generateErrorMsg(Error.DOMAIN_ROOT_REQUIRED.getCode(), 
						Error.DOMAIN_ROOT_REQUIRED.getLabel(), lMessage);
				subTypeResponse = new GenericResponseVO(false, errorMsg);	
				return subTypeResponse;
			}

		} catch (GenericDaoException e) {
			String lMessage = resourceBundleHelperComponent.getMessage(e.getErrLevel(), null);
			List<ErrorResponseVO> errorMsg = DpUtils.generateErrorMsg(e.getErrCode(), 
					e.getErrLevel(), lMessage);
			subTypeResponse = new GenericResponseVO(false, errorMsg);	
			return subTypeResponse;
		}
	}
	
	
	/**
	 * Update subscription type.
	 *
	 * @param pRequest the request
	 * @return the generic response VO
	 * @throws GenericException the generic exception
	 */
	public GenericResponseVO updateSubscriptionType(SubscriptionTypeRequest pRequest) throws GenericException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("updateSubscriptionType");
		}
		GenericResponseVO subTypeResponse = new GenericResponseVO();
		try {
			if (pRequest != null && pRequest.getId() != null) {
					DpSubscriptionType subscriptionType = subscriptionTools.updateSubscriptionTypeDomain(pRequest);
					subTypeResponse = new GenericResponseVO(true, subscriptionType);	
					return subTypeResponse;			
			} else {
				String lMessage = resourceBundleHelperComponent.getMessage(Error.SUBSCRIPTION_TYPE_ID_REQUIRED.getLabel(), null);
				List<ErrorResponseVO> errorMsg = DpUtils.generateErrorMsg(Error.SUBSCRIPTION_TYPE_ID_REQUIRED.getCode(), 
						Error.SUBSCRIPTION_TYPE_ID_REQUIRED.getLabel(), lMessage);
				subTypeResponse = new GenericResponseVO(false, errorMsg);	
				return subTypeResponse;
			}

		} catch (GenericDaoException e) {
			String lMessage = resourceBundleHelperComponent.getMessage(e.getErrLevel(), null);
			List<ErrorResponseVO> errorMsg = DpUtils.generateErrorMsg(e.getErrCode(), 
					e.getErrLevel(), lMessage);
			subTypeResponse = new GenericResponseVO(false, errorMsg);	
			return subTypeResponse;
		}
	}
	
	public GenericResponseVO getSubscriptionTypeById(Integer pId) throws GenericException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("getSubscriptionTypeById");
		}
		GenericResponseVO subscriptionTypeResponse = new GenericResponseVO();
		try {				
				DpSubscriptionType subscriptionType = subscriptionTools.getSubscriptionType(pId);
				if (subscriptionType != null) {
					subscriptionTypeResponse = new GenericResponseVO(true, subscriptionType);
				} else {
					String lMessage = resourceBundleHelperComponent.getMessage(Error.SUBSCRIPTION_TYPE_NOT_FOUND.getLabel(), null);
					List<ErrorResponseVO> errorMsg = DpUtils.generateErrorMsg(Error.SUBSCRIPTION_TYPE_NOT_FOUND.getCode(), 
							Error.SUBSCRIPTION_TYPE_NOT_FOUND.getLabel(), lMessage);
					subscriptionTypeResponse = new GenericResponseVO(false, errorMsg);	
				}					
				return subscriptionTypeResponse;			

		} catch (GenericDaoException e) {
			String lMessage = resourceBundleHelperComponent.getMessage(e.getErrLevel(), null);
			List<ErrorResponseVO> errorMsg = DpUtils.generateErrorMsg(e.getErrCode(), 
					e.getErrLevel(), lMessage);
			subscriptionTypeResponse = new GenericResponseVO(false, errorMsg);	
			return subscriptionTypeResponse;
		}
	}
	
	public GenericResponseVO getSubscriptionTypeByDomainId(Integer pDomainId) throws GenericException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("getSubscriptionTypeById");
		}
		GenericResponseVO subscriptionTypeByDomainId = new GenericResponseVO();
		try {				
				List<DpSubscriptionType> subscriptionTypes = subscriptionTools.getSubscriptionTypeBasedOnDomain(pDomainId);
				if (subscriptionTypes != null) {
					subscriptionTypeByDomainId = new GenericResponseVO(true, subscriptionTypes);
				} else {
					String lMessage = resourceBundleHelperComponent.getMessage(Error.SUBSCRIPTION_TYPE_NOT_FOUND.getLabel(), null);
					List<ErrorResponseVO> errorMsg = DpUtils.generateErrorMsg(Error.SUBSCRIPTION_TYPE_NOT_FOUND.getCode(), 
							Error.SUBSCRIPTION_TYPE_NOT_FOUND.getLabel(), lMessage);
					subscriptionTypeByDomainId = new GenericResponseVO(false, errorMsg);	
				}					
				return subscriptionTypeByDomainId;			

		} catch (GenericDaoException e) {
			String lMessage = resourceBundleHelperComponent.getMessage(e.getErrLevel(), null);
			List<ErrorResponseVO> errorMsg = DpUtils.generateErrorMsg(e.getErrCode(), 
					e.getErrLevel(), lMessage);
			subscriptionTypeByDomainId = new GenericResponseVO(false, errorMsg);	
			return subscriptionTypeByDomainId;
		}
	}
	
}
