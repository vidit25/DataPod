package com.datapad.base.service;

import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.datapad.base.constants.DataPodConstant;

@Component
public class BaseService {
	
	@Value("${service.client.id}")
	public String clientId;
	
	@Value("${service.client.secretKey}")
	public String clientSecretKey;
	
	@Value("${service.host}")
	public String hostName;
	
	@Value("${service.api.key}")
	public String apiKey;
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	/**
	* This method will create request headers
	* @param params
	* @return
	*/
	public HttpHeaders createHeaders(boolean isTokenAuth) {
	   HttpHeaders headers = new HttpHeaders();
	   
	   headers.setContentType(MediaType.APPLICATION_JSON);
	   headers.set(DataPodConstant.X_API_KEY, apiKey);
	   
	   //Get the token from session and set it in header.
	   if(isTokenAuth) {
		   ServletRequestAttributes servletReqAttribs = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		   HttpSession session= servletReqAttribs.getRequest().getSession(true);
		   String authToken = (String) session.getAttribute("authToken");
		   headers.setBearerAuth(authToken);
	   } else {
		   String plainCreds = clientId+DataPodConstant.COLON_SEPARATOR+clientSecretKey;
		   byte[] plainCredsBytes = plainCreds.getBytes();
		   byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
		   String base64Creds = new String(base64CredsBytes);
		   headers.set(DataPodConstant.AUTHORIZATION, "Basic "+base64Creds);
	   }
	   return headers;
	}
	
	protected <T> T doPost(String serviceURL,MultiValueMap params,Class<T> responseType) {
		return callService(serviceURL, params, HttpMethod.POST, MediaType.APPLICATION_JSON,responseType,true);
	}
	
	protected <T> T doPost(String serviceURL,MultiValueMap params,MediaType contentType,Class<T> responseType) {
		return callService(serviceURL, params, HttpMethod.POST, contentType,responseType,false);
	}
	
	protected <T> T doGet(String serviceURL,MultiValueMap params,Class<T> responseType) {
		return callService(serviceURL, params, HttpMethod.GET, MediaType.APPLICATION_JSON,responseType,true);
	}
	
	protected <T> T doPut(String serviceURL,MultiValueMap params,Class<T> responseType) {
		return callService(serviceURL, params, HttpMethod.PUT, MediaType.APPLICATION_JSON,responseType,true);
	}
	
	protected <T> T doDelete(String serviceURL,MultiValueMap params,Class<T> responseType) {
		return callService(serviceURL, params, HttpMethod.DELETE, MediaType.APPLICATION_JSON,responseType,true);
	}
	
	protected <T> T doPatch(String serviceURL,MultiValueMap params,Class<T> responseType) {
		return callService(serviceURL, params, HttpMethod.PATCH, MediaType.APPLICATION_JSON, responseType,true);
	}
	
	
	
	private <T> T callService(String serviceURL,MultiValueMap params,HttpMethod httpMethod,MediaType contentType,Class<T> responseType,boolean isTokenAuth) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = createHeaders(isTokenAuth);
		headers.setContentType(contentType);
		String endpointURL = hostName+serviceURL;
		T response = null;
		ResponseEntity<T> responseEntity;
		try {
			switch (httpMethod) {
			case GET:
				HttpEntity headerEntity = new HttpEntity(headers);
				responseEntity= restTemplate.exchange(endpointURL, HttpMethod.GET, headerEntity, responseType);
				break;
			case POST:
				HttpEntity<MultiValueMap<String, String>> postRequestEntity = new HttpEntity<>(params, headers);
				responseEntity= restTemplate.postForEntity(endpointURL, postRequestEntity, responseType);
				break;
			case PUT:
				HttpEntity<MultiValueMap<String, String>> putRequestEntity = new HttpEntity<>(params, headers);
				responseEntity= restTemplate.exchange(endpointURL, HttpMethod.PUT, putRequestEntity, responseType);
				break;
			case PATCH:
				HttpEntity<MultiValueMap<String, String>> patchRequestEntity = new HttpEntity<>(params, headers);
				responseEntity= restTemplate.exchange(endpointURL, HttpMethod.PATCH, patchRequestEntity, responseType);
				break;		
			case DELETE:
				HttpEntity<MultiValueMap<String, String>> deleteRequestEntity = new HttpEntity<>(params, headers);
				responseEntity= restTemplate.exchange(endpointURL, HttpMethod.DELETE, deleteRequestEntity, responseType);
				break;	
			default:
				responseEntity = null;
				break;
			}
		   if (null != responseEntity && null != responseEntity.getBody()) {
			   response = responseEntity.getBody();
			   LOGGER.info("RESPONSE : " + response);
		   }
		} catch (HttpClientErrorException exception) {
		   LOGGER.error("Send message error: Response body: {} \nException: ", exception.getResponseBodyAsString(), exception);
		}
		return response;
	}
	
}
