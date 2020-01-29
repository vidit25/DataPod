package com.datapad.page.domains.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.datapad.base.service.BaseService;
import com.datapad.page.domains.model.DomainModel;

@Component
public class DomainService extends BaseService {
	
	
	
	@Value("${endpoint.domainURL}")
	public String domainURL;
	
	public DomainModel getDomains() {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		DomainModel response = doGet(domainURL, params, DomainModel.class);
		return response;
	}

}
