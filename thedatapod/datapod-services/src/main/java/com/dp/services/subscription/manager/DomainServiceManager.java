package com.dp.services.subscription.manager;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.dp.db.model.DpDomain;
import com.dp.db.model.DpSubDomain;
import com.dp.services.constants.Error;
import com.dp.services.exception.GenericDaoException;
import com.dp.services.exception.GenericException;
import com.dp.services.response.ErrorResponseVO;
import com.dp.services.response.GenericResponseVO;
import com.dp.services.subscription.request.DomainRequest;
import com.dp.services.subscription.request.SubDomainRequest;
import com.dp.services.subscription.tools.SubscriptionTools;
import com.dp.utils.DpUtils;
import com.dp.utils.ResourceBundleHelper;

/**
 * The Class subscriptionServiceManager.
 */
@Service("domainManager")
public class DomainServiceManager {

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
	 * Creates the domain.
	 *
	 * @param pRequest the request
	 * @return the generic response VO
	 * @throws GenericException the generic exception
	 */
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
	
	/**
	 * Update domain.
	 *
	 * @param pRequest the request
	 * @return the generic response VO
	 * @throws GenericException the generic exception
	 */
	public GenericResponseVO updateDomain(DomainRequest pRequest) throws GenericException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("updateDomain");
		}
		GenericResponseVO domainResponse = new GenericResponseVO();
		try {
			if (pRequest != null && !DpUtils.isEmptyString(pRequest.getName())) {
					DpDomain domain = new DpDomain();
					BeanUtils.copyProperties(pRequest, domain);
					domain = subscriptionTools.updateDomain(domain);
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
	
	
	/**
	 * Creates the sub domain.
	 *
	 * @param pRequest the request
	 * @return the generic response VO
	 * @throws GenericException the generic exception
	 */
	public GenericResponseVO createSubDomain(SubDomainRequest pRequest) throws GenericException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("createSubDomain");
		}
		GenericResponseVO subDomainResponse = new GenericResponseVO();
		try {
			if (pRequest != null && !DpUtils.isEmptyString(pRequest.getName())) {
					DpSubDomain subDomain = new DpSubDomain();
					BeanUtils.copyProperties(pRequest, subDomain);
					subDomain = subscriptionTools.createSubDomain(subDomain);
					subDomainResponse = new GenericResponseVO(true, subDomain);	
					return subDomainResponse;			
			} else {
				String lMessage = resourceBundleHelperComponent.getMessage("error.required.domain.name", null);
				List<ErrorResponseVO> errorMsg = DpUtils.generateErrorMsg(Error.DOMAIN_NAME_MISSING.getCode(), 
						Error.DOMAIN_NAME_MISSING.getLabel(), lMessage);
				subDomainResponse = new GenericResponseVO(false, errorMsg);	
				return subDomainResponse;
			}

		} catch (GenericDaoException e) {
			String lMessage = resourceBundleHelperComponent.getMessage(e.getErrLevel(), null);
			List<ErrorResponseVO> errorMsg = DpUtils.generateErrorMsg(e.getErrCode(), 
					e.getErrLevel(), lMessage);
			subDomainResponse = new GenericResponseVO(false, errorMsg);	
			return subDomainResponse;
		}
	}
	
	/**
	 * Update sub domain.
	 *
	 * @param pRequest the request
	 * @return the generic response VO
	 * @throws GenericException the generic exception
	 */
	public GenericResponseVO updateSubDomain(SubDomainRequest pRequest) throws GenericException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("updateSubDomain");
		}
		GenericResponseVO subDomainResponse = new GenericResponseVO();
		try {
			if (pRequest != null && pRequest.getDomainId() > 0) {
				DpDomain domain = subscriptionTools.getDomain((int)pRequest.getDomainId());
				if (domain != null) {
					DpSubDomain subDomain = subscriptionTools.getSubDomain((int)pRequest.getId());
					if (subDomain != null) {
						domain = subscriptionTools.linkSubDomain(domain, subDomain);
						return new GenericResponseVO(true, domain);	
					} else if(!DpUtils.isEmptyString(pRequest.getName())) {
						subDomain = new DpSubDomain();
						BeanUtils.copyProperties(pRequest, subDomain);
						domain = subscriptionTools.linkSubDomain(domain, subDomain);
						return new GenericResponseVO(true, domain);	
					} else {
						String lMessage = resourceBundleHelperComponent.getMessage(Error.DOMAIN_NOT_FOUND.getLabel(), null);
						List<ErrorResponseVO> errorMsg = DpUtils.generateErrorMsg(Error.DOMAIN_NOT_FOUND.getCode(), 
								Error.DOMAIN_NOT_FOUND.getLabel(), lMessage);
						subDomainResponse = new GenericResponseVO(false, errorMsg);	
						return subDomainResponse;
					}

				} else {
					String lMessage = resourceBundleHelperComponent.getMessage(Error.DOMAIN_NOT_FOUND.getLabel(), null);
					List<ErrorResponseVO> errorMsg = DpUtils.generateErrorMsg(Error.DOMAIN_NOT_FOUND.getCode(), 
							Error.DOMAIN_NOT_FOUND.getLabel(), lMessage);
					subDomainResponse = new GenericResponseVO(false, errorMsg);	
					return subDomainResponse;
				}				
			} else if (pRequest != null && !DpUtils.isEmptyString(pRequest.getName())) {
					DpSubDomain subDomain = new DpSubDomain();
					BeanUtils.copyProperties(pRequest, subDomain);
					subDomain = subscriptionTools.updateSubDomain(subDomain);
					subDomainResponse = new GenericResponseVO(true, subDomain);	
					return subDomainResponse;			
			} else {
				String lMessage = resourceBundleHelperComponent.getMessage("error.required.domain.name", null);
				List<ErrorResponseVO> errorMsg = DpUtils.generateErrorMsg(Error.DOMAIN_NAME_MISSING.getCode(), 
						Error.DOMAIN_NAME_MISSING.getLabel(), lMessage);
				subDomainResponse = new GenericResponseVO(false, errorMsg);	
				return subDomainResponse;
			}

		} catch (GenericDaoException e) {
			String lMessage = resourceBundleHelperComponent.getMessage(e.getErrLevel(), null);
			List<ErrorResponseVO> errorMsg = DpUtils.generateErrorMsg(e.getErrCode(), 
					e.getErrLevel(), lMessage);
			subDomainResponse = new GenericResponseVO(false, errorMsg);	
			return subDomainResponse;
		}
	}
	
	
}
