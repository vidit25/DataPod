package com.dp.services.subscription.manager;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.dp.db.model.DpDomain;
import com.dp.services.constants.Error;
import com.dp.services.exception.GenericDaoException;
import com.dp.services.exception.GenericException;
import com.dp.services.response.ErrorResponseVO;
import com.dp.services.response.GenericResponseVO;
import com.dp.services.subscription.request.DomainRequest;
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
	
	@Autowired
	private SubscriptionTools subscriptionTools;
	
	public GenericResponseVO createDomain(DomainRequest pRequest) throws GenericException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("createDomain");
		}
		GenericResponseVO domainResponse = new GenericResponseVO();
		try {
			if (pRequest != null && !DpUtils.isEmptyString(pRequest.getName())) {
					DpDomain domain = new DpDomain();
					BeanUtils.copyProperties(pRequest, domain);
					domain = subscriptionTools.createDomain(domain);
					domainResponse = new GenericResponseVO(true, domain);	
					return domainResponse;			
			} else {
				String lMessage = resourceBundleHelperComponent.getMessage("error.required.domain.name", null);
				List<ErrorResponseVO> errorMsg = DpUtils.generateErrorMsg(Error.DOMAIN_NAME_MISSING.getCode(), 
						Error.DOMAIN_NAME_MISSING.getLabel(), lMessage);
				domainResponse = new GenericResponseVO(false, errorMsg);	
				return domainResponse;
			}

		} catch (GenericDaoException e) {
			String lMessage = resourceBundleHelperComponent.getMessage(e.getErrLevel(), null);
			List<ErrorResponseVO> errorMsg = DpUtils.generateErrorMsg(e.getErrCode(), 
					e.getErrLevel(), lMessage);
			domainResponse = new GenericResponseVO(false, errorMsg);	
			return domainResponse;
		}
	}
	
	
}
