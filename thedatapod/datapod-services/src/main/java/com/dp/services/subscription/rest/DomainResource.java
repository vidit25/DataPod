package com.dp.services.subscription.rest;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dp.utils.DpUtils;
import com.dp.utils.ResourceBundleHelper;
import com.dp.services.constants.Error;
import com.dp.services.exception.GenericException;
import com.dp.services.response.ErrorResponseVO;
import com.dp.services.response.GenericResponseVO;
import com.dp.services.subscription.manager.DomainServiceManager;
import com.dp.services.subscription.request.DomainRequest;
import com.dp.services.subscription.request.SubDomainRequest;

/**
 * The Class DomainResource.
 */
@RestController
public class DomainResource {

	/** The logger. */
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	/** The resource bundle helper component. */
	@Autowired
	private ResourceBundleHelper resourceBundleHelperComponent;

	/** The ProfileTools. */
	@Autowired
	private DomainServiceManager domainManager;
	
		/** The environment. */
		@Autowired
	private Environment environment;
		
	/**
	 * Handle create domin.
	 *
	 * @param pRequest the request
	 * @param apiKey the api key
	 * @return the generic response VO
	 */
	@PostMapping(value = "/api/domain")
	public @ResponseBody GenericResponseVO handleCreateDomin(@RequestBody DomainRequest pRequest,
			@RequestHeader(name = "x-api-Key") String apiKey) {
		GenericResponseVO domainResponse = new GenericResponseVO();
		LOGGER.debug("DomainResource: handleCreateDomin - request ");
		try {
			domainResponse = domainManager.createDomain(pRequest);			
		} catch (GenericException e) {
			String lMessage = resourceBundleHelperComponent.getMessage(e.getErrLevel(), null);
			List<ErrorResponseVO> errorMsg = DpUtils.generateErrorMsg(e.getErrCode(), 
					e.getErrLevel(), lMessage);
			domainResponse = new GenericResponseVO(false, errorMsg);
		} 
		LOGGER.debug("DomainResource: handleCreateDomin - request handled");
		return domainResponse;
	}
	
	/**
	 * Handle update domain.
	 *
	 * @param pRequest the request
	 * @param apiKey the api key
	 * @return the generic response VO
	 */
	@PutMapping(value = "/api/domain")
	public @ResponseBody GenericResponseVO handleUpdateDomain(@RequestBody DomainRequest pRequest,
			@RequestHeader(name = "x-api-Key") String apiKey) {
		GenericResponseVO domainResponse = new GenericResponseVO();
		LOGGER.debug("DomainResource: handleUpdateDomain - request ");
		try {
			domainResponse = domainManager.updateDomain(pRequest);			
		} catch (GenericException e) {
			String lMessage = resourceBundleHelperComponent.getMessage(e.getErrLevel(), null);
			List<ErrorResponseVO> errorMsg = DpUtils.generateErrorMsg(e.getErrCode(), 
					e.getErrLevel(), lMessage);
			domainResponse = new GenericResponseVO(false, errorMsg);
		} 
		LOGGER.debug("DomainResource: handleUpdateDomain - request handled");
		return domainResponse;
	}
	
	/**
	 * Handle create sub domin.
	 *
	 * @param pRequest the request
	 * @param apiKey the api key
	 * @return the generic response VO
	 */
	@PostMapping(value = "/api/domain/sub-domain")
	public @ResponseBody GenericResponseVO handleCreateSubDomin(@RequestBody SubDomainRequest pRequest,
			@RequestHeader(name = "x-api-Key") String apiKey) {
		GenericResponseVO domainResponse = new GenericResponseVO();
		LOGGER.debug("DomainResource: handleCreateSubDomin - request ");
		try {
			domainResponse = domainManager.createSubDomain(pRequest);			
		} catch (GenericException e) {
			String lMessage = resourceBundleHelperComponent.getMessage(e.getErrLevel(), null);
			List<ErrorResponseVO> errorMsg = DpUtils.generateErrorMsg(e.getErrCode(), 
					e.getErrLevel(), lMessage);
			domainResponse = new GenericResponseVO(false, errorMsg);
		} 
		LOGGER.debug("DomainResource: handleCreateSubDomin - request handled");
		return domainResponse;
	}
	
	/**
	 * Handle update sub domain.
	 *
	 * @param pRequest the request
	 * @param apiKey the api key
	 * @return the generic response VO
	 */
	@PutMapping(value = "/api/domain/sub-domain")
	public @ResponseBody GenericResponseVO handleUpdateSubDomain(@RequestBody SubDomainRequest pRequest,
			@RequestHeader(name = "x-api-Key") String apiKey) {
		GenericResponseVO domainResponse = new GenericResponseVO();
		LOGGER.debug("DomainResource: handleUpdateSubDomain - request ");
		try {
			domainResponse = domainManager.updateSubDomain(pRequest);			
		} catch (GenericException e) {
			String lMessage = resourceBundleHelperComponent.getMessage(e.getErrLevel(), null);
			List<ErrorResponseVO> errorMsg = DpUtils.generateErrorMsg(e.getErrCode(), 
					e.getErrLevel(), lMessage);
			domainResponse = new GenericResponseVO(false, errorMsg);
		} 
		LOGGER.debug("DomainResource: handleUpdateSubDomain - request handled");
		return domainResponse;
	}
	
	/**
	 * Handle link sub domain.
	 *
	 * @param apiKey the api key
	 * @return the generic response VO
	 */
	/*@PostMapping(value = "/api/link-sub-domain")
	public @ResponseBody GenericResponseVO handleLinkSubDomain(@RequestBody SubDomainRequest pRequest,
			@RequestHeader(name = "x-api-Key") String apiKey) {
		GenericResponseVO domainResponse = new GenericResponseVO();
		LOGGER.debug("DomainResource: handleLinkSubDomain - request ");
		try {
			domainResponse = domainManager.updateSubDomain(pRequest);			
		} catch (GenericException e) {
			String lMessage = resourceBundleHelperComponent.getMessage(e.getErrLevel(), null);
			List<ErrorResponseVO> errorMsg = DpUtils.generateErrorMsg(e.getErrCode(), 
					e.getErrLevel(), lMessage);
			domainResponse = new GenericResponseVO(false, errorMsg);
		} 
		LOGGER.debug("DomainResource: handleLinkSubDomain - request handled");
		return domainResponse;
	}*/
	
	@GetMapping(value = "/api/domain")
	public @ResponseBody GenericResponseVO handleGetAllDomain(@RequestHeader(name = "x-api-Key") String apiKey) {
		GenericResponseVO domainResponse = new GenericResponseVO();
		LOGGER.debug("DomainResource: handleGetAllDomain - request ");
		try {
			domainResponse = domainManager.getAllDomain();			
		} catch (GenericException e) {
			String lMessage = resourceBundleHelperComponent.getMessage(e.getErrLevel(), null);
			List<ErrorResponseVO> errorMsg = DpUtils.generateErrorMsg(e.getErrCode(), 
					e.getErrLevel(), lMessage);
			domainResponse = new GenericResponseVO(false, errorMsg);
		} 
		LOGGER.debug("DomainResource: handleGetAllDomain - request handled");
		return domainResponse;
	}
	
	/**
	 * Handle get domain by id.
	 *
	 * @param apiKey the api key
	 * @param domainId the domain id
	 * @return the generic response VO
	 */
	@GetMapping(path = "/api/domain/{domainId}")
	public @ResponseBody GenericResponseVO handleGetDomainById(@RequestHeader(name = "x-api-Key") String apiKey,
			@PathVariable String domainId) {
		GenericResponseVO domainResponse = new GenericResponseVO();
		LOGGER.debug("DomainResource: handleGetDomainById - request ");
		try {
			if (!DpUtils.isEmptyString(domainId)) {
				domainResponse = domainManager.getDomainById(Integer.valueOf(domainId));
			} else {
				LOGGER.error("handleGetDomainById: DOMAIN_ID_MISSING");
				String message = resourceBundleHelperComponent.getMessage(Error.DOMAIN_ID_MISSING.getLabel(), null);
				List<ErrorResponseVO> errorMsg = DpUtils.generateErrorMsg(Error.DOMAIN_ID_MISSING.getCode(), 
						Error.DOMAIN_ID_MISSING.getLabel(), message);
				domainResponse = new GenericResponseVO(false, errorMsg);
			}
		} catch (GenericException e) {
			String lMessage = resourceBundleHelperComponent.getMessage(e.getErrLevel(), null);
			List<ErrorResponseVO> errorMsg = DpUtils.generateErrorMsg(e.getErrCode(), 
					e.getErrLevel(), lMessage);
			domainResponse = new GenericResponseVO(false, errorMsg);
			LOGGER.error(e.getMessage(), e);
		} catch(Exception e) {
			List<ErrorResponseVO> errorMsg = DpUtils.generateErrorMsg(Error.SYSTEM_ERROR.getCode(),
					Error.SYSTEM_ERROR.getLabel(), e.getMessage());
			domainResponse = new GenericResponseVO(false, errorMsg);
			LOGGER.error(e.getMessage(), e);
		}
		LOGGER.debug("DomainResource: handleGetDomainById - request handled");
		return domainResponse;
	}
	
	/**
	 * Handle get sub domain by id.
	 *
	 * @param apiKey the api key
	 * @param domainId the domain id
	 * @return the generic response VO
	 */
	@GetMapping(path = "/api/domain/sub-domain/{domainId}")
	public @ResponseBody GenericResponseVO handleGetSubDomainById(@RequestHeader(name = "x-api-Key") String apiKey,
			@PathVariable String domainId) {
		GenericResponseVO domainResponse = new GenericResponseVO();
		LOGGER.debug("DomainResource: handleGetSubDomainById - request ");
		try {
			if (!DpUtils.isEmptyString(domainId)) {
				domainResponse = domainManager.getSubDomainById(Integer.valueOf(domainId));
			} else {
				LOGGER.error("handleGetSubDomainById: DOMAIN_ID_MISSING");
				String message = resourceBundleHelperComponent.getMessage(Error.DOMAIN_ID_MISSING.getLabel(), null);
				List<ErrorResponseVO> errorMsg = DpUtils.generateErrorMsg(Error.DOMAIN_ID_MISSING.getCode(), 
						Error.DOMAIN_ID_MISSING.getLabel(), message);
				domainResponse = new GenericResponseVO(false, errorMsg);
			}
		} catch (GenericException e) {
			String lMessage = resourceBundleHelperComponent.getMessage(e.getErrLevel(), null);
			List<ErrorResponseVO> errorMsg = DpUtils.generateErrorMsg(e.getErrCode(), 
					e.getErrLevel(), lMessage);
			domainResponse = new GenericResponseVO(false, errorMsg);
			LOGGER.error(e.getMessage(), e);
		} catch(Exception e) {
			List<ErrorResponseVO> errorMsg = DpUtils.generateErrorMsg(Error.SYSTEM_ERROR.getCode(),
					Error.SYSTEM_ERROR.getLabel(), e.getMessage());
			domainResponse = new GenericResponseVO(false, errorMsg);
			LOGGER.error(e.getMessage(), e);
		}
		LOGGER.debug("DomainResource: handleGetSubDomainById - request handled");
		return domainResponse;
	}
	
}
