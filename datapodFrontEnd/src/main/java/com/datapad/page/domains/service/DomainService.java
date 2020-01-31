package com.datapad.page.domains.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.datapad.base.constants.DataPodConstant;
import com.datapad.base.models.ServiceModel;
import com.datapad.base.service.BaseService;
import com.datapad.page.domains.model.DomainModel;

@Component
public class DomainService {
	
	
	
	@Value("${endpoint.domainURL}")
	public String domainURL;
	
	@Value("${endpoint.subDomainURL}")
	public String subDomainURL;
	
	@Autowired
	public BaseService baseService;
	
	public DomainModel getAllDomains() {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		ServiceModel serviceModel = new ServiceModel.ServiceModelBuilder()
				.serviceURL(domainURL).params(params).isUseTokenAuth(false)
				.contentType(MediaType.APPLICATION_JSON).build();
		DomainModel response = baseService.doGet(serviceModel, DomainModel.class);
		return response;
	}
	
	public DomainModel getDomainById(String id) {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		String endpointURL = domainURL+DataPodConstant.SLASH+id;
		ServiceModel serviceModel = new ServiceModel.ServiceModelBuilder()
				.serviceURL(endpointURL).params(params).isUseTokenAuth(false)
				.contentType(MediaType.APPLICATION_JSON).build();
		DomainModel response = baseService.doGet(serviceModel, DomainModel.class);
		return response;
	}
	
	
	public DomainModel addDomain(DomainModel domainModel) {
		
		HashMap<String, String> params = new HashMap<String, String>();
		params.put(DataPodConstant.NAME, domainModel.getName());
		params.put(DataPodConstant.DESCRIPTION, domainModel.getDescription());
		ServiceModel serviceModel = new ServiceModel.ServiceModelBuilder()
				.serviceURL(domainURL).params(params).isUseTokenAuth(true)
				.contentType(MediaType.APPLICATION_JSON).build();
		DomainModel response = baseService.doPost(serviceModel, DomainModel.class);
		return response;
	}
	
//	public DomainModel deleteDomain(DomainModel domainModel) {
//		
//		HashMap<String, String> params = new HashMap<String, String>();
//		params.put(DataPodConstant.NAME, domainModel.getName());
//		params.put(DataPodConstant.DESCRIPTION, domainModel.getDescription());
//		DomainModel response = doDelete(domainURL, params, DomainModel.class);
//		return response;
//	}
	
	public DomainModel addSubDomain(DomainModel domainModel) {
		
		HashMap<String, String> params = new HashMap<String, String>();
		params.put(DataPodConstant.DOMAIN_ID, String.valueOf(domainModel.getId()));
		params.put(DataPodConstant.NAME, domainModel.getName());
		params.put(DataPodConstant.DESCRIPTION, domainModel.getDescription());
		ServiceModel serviceModel = new ServiceModel.ServiceModelBuilder()
				.serviceURL(subDomainURL).params(params).isUseTokenAuth(true)
				.contentType(MediaType.APPLICATION_JSON).build();
		DomainModel response = baseService.doPost(serviceModel, DomainModel.class);
		return response;
	}

}
