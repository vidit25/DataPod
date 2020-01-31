package com.datapad.base.service;

import org.springframework.http.HttpMethod;

import com.datapad.base.models.ServiceModel;

public interface BaseService {
	
	
	default <T> T doPost(ServiceModel serviceModel,Class<T> responseType) {
		return callService(serviceModel,HttpMethod.POST,responseType);
	}
	
	default <T> T doGet(ServiceModel serviceModel,Class<T> responseType) {
		return callService(serviceModel,HttpMethod.GET,responseType);
	}
	
	default <T> T doPut(ServiceModel serviceModel,Class<T> responseType) {
		return callService(serviceModel,HttpMethod.PUT,responseType);
	}
	
	default <T> T doDelete(ServiceModel serviceModel,Class<T> responseType) {
		return callService(serviceModel,HttpMethod.DELETE,responseType);
	}
	
	default <T> T doPatch(ServiceModel serviceModel,Class<T> responseType) {
		return callService(serviceModel,HttpMethod.PATCH,responseType);
	}
	
	<T> T callService(ServiceModel serviceModel, HttpMethod httpMethod, Class<T> responseType);
	
}
