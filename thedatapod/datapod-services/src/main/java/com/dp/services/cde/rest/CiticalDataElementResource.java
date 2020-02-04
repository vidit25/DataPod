package com.dp.services.cde.rest;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.dp.db.model.DpCriticalDataElement;
import com.dp.services.cde.manager.CriticalDataElementServiceManager;
import com.dp.services.constants.Error;
import com.dp.services.profile.manager.ProfileServiceManager;
import com.dp.services.response.ErrorResponseVO;
import com.dp.services.response.GenericResponseVO;
import com.dp.utils.DpUtils;
import com.dp.utils.ResourceBundleHelper;

/**
 * The Class CurrentUserResource.
 */
@RestController
public class CiticalDataElementResource {

	/** The logger. */
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	/** The resource bundle helper component. */
	@Autowired
	private ResourceBundleHelper resourceBundleHelperComponent;

	@Autowired
	private CriticalDataElementServiceManager criticalDataElementServiceManager;

	
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
				//Map cdeMap = DpUtils.getPojoToMapObject(dpCriticalDataElement);
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

}
