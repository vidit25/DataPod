package com.datapad.page.cde.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.datapad.base.constants.DataPodConstant;
import com.datapad.base.models.ServiceModel;
import com.datapad.base.service.BaseService;
import com.datapad.page.cde.model.CriticalDataElementModel;

@Component
public class CriticalDataElementService {
	
	
	/**
	 * variable retrieveCritialDataElementBySubDomainURL
	 */
	
	@Value("${endpoint.retrieveCritialDataElementBySubDomainURL}")
	public String retrieveCritialDataElementBySubDomainURL;
	
	@Autowired
	private BaseService baseService;
	
  
	/**
	 * 
	 * @param domainId
	 * @return
	 */
	public CriticalDataElementModel getCriticalDataElementBySubDomain(String subDomainId) {
		String endpointURL = retrieveCritialDataElementBySubDomainURL+DataPodConstant.SLASH+subDomainId;
		Map<String, Object> params = new HashMap<String, Object>();
		ServiceModel serviceModel = new ServiceModel.ServiceModelBuilder()
				.serviceURL(endpointURL).params(params).isUseTokenAuth(false)
				.contentType(MediaType.APPLICATION_JSON).build();
		CriticalDataElementModel response = baseService.doGet(serviceModel, CriticalDataElementModel.class);
		return response;
	}
	
	

}
