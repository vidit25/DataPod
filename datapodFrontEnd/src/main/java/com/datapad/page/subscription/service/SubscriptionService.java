package com.datapad.page.subscription.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.datapad.base.constants.DataPodConstant;
import com.datapad.base.models.GenericModel;
import com.datapad.base.models.ServiceModel;
import com.datapad.base.service.BaseService;
import com.datapad.form.SubscriptionForm;
import com.datapad.page.subscription.model.SubscriptionModel;
import com.datapad.page.subscriptionType.model.SubscrptionTypeModel;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class SubscriptionService {
	
	
	/**
	 * variable createSubcriptionURL
	 */
	@Value("${endpoint.createSubcriptionURL}")
	public String createSubcriptionURL;
	
	@Value("${endpoint.retrieveSubscriptionTypeByDomainURL}")
	public String retrieveSubscriptionTypeByDomainURL;
	
	@Value("${endpoint.retrieveSubscriptionByStatusURL}")
	public String retrieveSubscriptionByStatusURL;
	
	
	@Value("${endpoint.activateSubscriptionURL}")
	public String activateSubscriptionURL;
	
	@Autowired
	private BaseService baseService;
	
    /**
     * 
     * @param subscriptionForm
     * @return
     */
	public GenericModel createSubcription(SubscriptionForm subscriptionForm) {
		
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> params = new HashMap<String, Object>();
		params = mapper.convertValue(subscriptionForm, Map.class);
		ServiceModel serviceModel = new ServiceModel.ServiceModelBuilder()
				.serviceURL(createSubcriptionURL).params(params).isUseTokenAuth(false)
				.contentType(MediaType.APPLICATION_JSON).build();
		GenericModel response = baseService.doPost(serviceModel,GenericModel.class);
		return response;
	}
	
	/**
	 * This method will activate subscription
	 * @param id
	 * @return
	 */
	public GenericModel activateSubcription(Integer id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("subscriptionId", id);
		ServiceModel serviceModel = new ServiceModel.ServiceModelBuilder()
				.serviceURL(activateSubscriptionURL).params(params).isUseTokenAuth(false)
				.contentType(MediaType.APPLICATION_JSON).build();
		GenericModel response = baseService.doPost(serviceModel,GenericModel.class);
		return response;
	}
	
	/**
	 * 
	 * @param domainId
	 * @return
	 */
	public SubscrptionTypeModel getSubscriptionTypeByDomain(String domainId) {
		String endpointURL = retrieveSubscriptionTypeByDomainURL+DataPodConstant.SLASH+domainId;
		Map<String, Object> params = new HashMap<String, Object>();
		ServiceModel serviceModel = new ServiceModel.ServiceModelBuilder()
				.serviceURL(endpointURL).params(params).isUseTokenAuth(false)
				.contentType(MediaType.APPLICATION_JSON).build();
		SubscrptionTypeModel response = baseService.doGet(serviceModel, SubscrptionTypeModel.class);
		return response;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public SubscriptionModel getSubscriptionByInitiatedStatus() {
		Map<String, Object> params = new HashMap<String, Object>();
		String endpointURL = retrieveSubscriptionByStatusURL+DataPodConstant.SLASH+"INITIATED";
		ServiceModel serviceModel = new ServiceModel.ServiceModelBuilder()
				.serviceURL(endpointURL).params(params).isUseTokenAuth(false)
				.contentType(MediaType.APPLICATION_JSON).build();
		
		SubscriptionModel response = baseService.doGet(serviceModel, SubscriptionModel.class);
		return response;
	}
	

}
