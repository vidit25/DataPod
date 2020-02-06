package com.dp.services.cde.rest;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.Principal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dp.db.model.DpCriticalDataElement;
import com.dp.services.cde.manager.CriticalDataElementServiceManager;
import com.dp.services.cde.request.CriticalDataElementRequest;
import com.dp.services.constants.Error;
import com.dp.services.exception.GenericDaoException;
import com.dp.services.response.ErrorResponseVO;
import com.dp.services.response.GenericResponseVO;
import com.dp.utils.DpUtils;
import com.dp.utils.ResourceBundleHelper;

/**
 * The Class CurrentUserResource.
 */
@RestController
public class CriticalDataElementResource {

	/** The logger. */
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	/** The resource bundle helper component. */
	@Autowired
	private ResourceBundleHelper resourceBundleHelperComponent;

	@Autowired
	private CriticalDataElementServiceManager criticalDataElementServiceManager;

	/**
	 * 
	 * @param apiKey
	 * @param subDomainIds
	 * @return
	 */
	
	@GetMapping("/api/cde/retrieve-critical-element-by-subdomain/{subDomainIds}")
	public GenericResponseVO getCriticalDataElementBySubDomain(@RequestHeader(name = "x-api-Key") String apiKey, @PathVariable List<Integer> subDomainIds) {
		List<DpCriticalDataElement> dpCriticalDataElement = null;
		GenericResponseVO userResponse = new GenericResponseVO();
		if (subDomainIds == null || subDomainIds.size() == 0) {
			String message = resourceBundleHelperComponent.getMessage(Error.SUB_DOMAIN_ID_MISSING.getLabel(), null);
			List<ErrorResponseVO> errorMsg = DpUtils.generateErrorMsg(Error.SUB_DOMAIN_ID_MISSING.getCode(), 
					Error.SUB_DOMAIN_ID_MISSING.getLabel(), message);
			userResponse = new GenericResponseVO(false, errorMsg);
		}
		try {
			
			dpCriticalDataElement = criticalDataElementServiceManager.getCriticalDataElementBySubDomain((List<Integer>)subDomainIds);
			if (dpCriticalDataElement != null) {			
				userResponse = new GenericResponseVO(true, dpCriticalDataElement);
			}
		
		} catch (Exception e) {
			List<ErrorResponseVO> errorMsg = DpUtils.generateErrorMsg(Error.SYSTEM_ERROR.getCode(),
					Error.SYSTEM_ERROR.getLabel(), e.getMessage());
			userResponse = new GenericResponseVO(false, errorMsg);
			LOGGER.error(e.getMessage(), e);
		}
		return userResponse;
	}
	
	
	@PostMapping("/api/cde/file/{accountId}")
	public GenericResponseVO uploadFile(@RequestParam("file") MultipartFile file, @PathVariable String accountId) throws IOException {
	    GenericResponseVO fileUploadResponse = new GenericResponseVO();
	    try {
			criticalDataElementServiceManager.uploadFile(file,accountId);
		} catch (GenericDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fileUploadResponse;
		
	}

	
	/**
	 * 
	 * @param request
	 * @param pPrincipal
	 * @return
	 */
	@PostMapping("/api/cde/associate-functional-data")
	public GenericResponseVO handleAssociateCriticalDataElement(@RequestBody CriticalDataElementRequest request, Principal pPrincipal) {
		GenericResponseVO responseVO = new GenericResponseVO();
		String userName = pPrincipal.getName();
		try {
			responseVO = criticalDataElementServiceManager.associateCriticalDataElement(request, userName); 
		} catch (Exception e) {
			List<ErrorResponseVO> errorMsg = DpUtils.generateErrorMsg(Error.SYSTEM_ERROR.getCode(),
					Error.SYSTEM_ERROR.getLabel(), e.getMessage());
			responseVO = new GenericResponseVO(false, errorMsg);
			LOGGER.error(e.getMessage(), e);
		}
		return responseVO;
	}

	/**
	 * 
	 * @param apiKey
	 * @param pPrincipal
	 * @return
	 */
	@GetMapping("/api/cde/retrieve-associated-functional-data")
	public GenericResponseVO retrieveAssociatedCriticalDataElement(@RequestHeader(name = "x-api-Key") String apiKey, Principal pPrincipal) {
		List<DpCriticalDataElement> dpCriticalDataElement = null;
		GenericResponseVO responseVO = new GenericResponseVO();
		try {
			dpCriticalDataElement = criticalDataElementServiceManager.retrieveAssociatedFunctionalData(pPrincipal.getName());
			if (dpCriticalDataElement != null) {			
				responseVO = new GenericResponseVO(true, dpCriticalDataElement);
			}

		} catch (Exception e) {
			List<ErrorResponseVO> errorMsg = DpUtils.generateErrorMsg(Error.SYSTEM_ERROR.getCode(),
					Error.SYSTEM_ERROR.getLabel(), e.getMessage());
			responseVO = new GenericResponseVO(false, errorMsg);
			LOGGER.error(e.getMessage(), e);
		}
		return responseVO;
	}
}
