package com.datapad.base.models;

import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public class ServiceModel {
	
	private String serviceURL;
	
	private Map params;
	
	private MediaType contentType;
	
	private HttpHeaders httpHeader;
	
	private boolean isUseTokenAuth;
	
	
	private ServiceModel(ServiceModelBuilder serviceModelBuilder) {
		this.serviceURL = serviceModelBuilder.serviceURL;
		this.params = serviceModelBuilder.params;
		this.contentType = serviceModelBuilder.contentType;
		this.isUseTokenAuth = serviceModelBuilder.isUseTokenAuth;
	}

	public String getServiceURL() {
		return serviceURL;
	}

	public Map getParams() {
		return params;
	}

	public MediaType getContentType() {
		return contentType;
	}

	public boolean isUseTokenAuth() {
		return isUseTokenAuth;
	}
	
	public HttpHeaders getHttpHeader() {
		return httpHeader;
	}



	public static class ServiceModelBuilder {
		
		private String serviceURL;
		
		private Map params;
		
		private MediaType contentType;
		
		private boolean isUseTokenAuth;
		
		public ServiceModelBuilder serviceURL(String serviceURL) {
			this.serviceURL = serviceURL;
			return this;
		}
		
		public ServiceModelBuilder params(Map params) {
			this.params = params;
			return this;
		}
		
		public ServiceModelBuilder contentType(MediaType contentType) {
			this.contentType = contentType;
			return this;
		}
		
		public ServiceModelBuilder isUseTokenAuth(boolean isUseTokenAuth) {
			this.isUseTokenAuth = isUseTokenAuth;
			return this;
		}
		
		public ServiceModel build() {
			ServiceModel serviceModel =  new ServiceModel(this);
            return serviceModel;
        }
	}
	
}
