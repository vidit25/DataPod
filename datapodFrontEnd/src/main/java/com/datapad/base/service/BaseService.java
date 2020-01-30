package com.datapad.base.service;

import java.util.Map;

import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Autowired
	private SessionService sessionService;
	
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
		   String authToken = (String) sessionService.getCurrentSession().getAttribute("authToken");
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
	
	protected <T> T doPost(String serviceURL,Map params,Class<T> responseType) {
		return callService(serviceURL, params, HttpMethod.POST, MediaType.APPLICATION_JSON,responseType,true);
	}
	
	protected <T> T doPost(String serviceURL,Map params,MediaType contentType,Class<T> responseType) {
		return callService(serviceURL, params, HttpMethod.POST, contentType,responseType,false);
	}
	
	protected <T> T doGet(String serviceURL,Map params,Class<T> responseType) {
		return callService(serviceURL, params, HttpMethod.GET, MediaType.APPLICATION_JSON,responseType,false);
	}
	
	protected <T> T doPut(String serviceURL,Map params,Class<T> responseType) {
		return callService(serviceURL, params, HttpMethod.PUT, MediaType.APPLICATION_JSON,responseType,true);
	}
	
	protected <T> T doDelete(String serviceURL,Map params,Class<T> responseType) {
		return callService(serviceURL, params, HttpMethod.DELETE, MediaType.APPLICATION_JSON,responseType,true);
	}
	
	protected <T> T doPatch(String serviceURL,Map params,Class<T> responseType) {
		return callService(serviceURL, params, HttpMethod.PATCH, MediaType.APPLICATION_JSON, responseType,true);
	}
	
	
	
	private <T> T callService(String serviceURL,Map params,HttpMethod httpMethod,MediaType contentType,Class<T> responseType,boolean isTokenAuth) {
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
				HttpEntity<Map<String, String>> postRequestEntity = new HttpEntity<>(params, headers);
				LOGGER.info(postRequestEntity.getBody().toString());
				LOGGER.info(postRequestEntity.getHeaders().toString());
				responseEntity= restTemplate.exchange(endpointURL, HttpMethod.POST, postRequestEntity, responseType);
//				responseEntity= restTemplate.postForEntity(endpointURL, postRequestEntity, responseType);
				break;
			case PUT:
				HttpEntity<Map<String, String>> putRequestEntity = new HttpEntity<>(params, headers);
				responseEntity= restTemplate.exchange(endpointURL, HttpMethod.PUT, putRequestEntity, responseType);
				break;
			case PATCH:
				HttpEntity<Map<String, String>> patchRequestEntity = new HttpEntity<>(params, headers);
				responseEntity= restTemplate.exchange(endpointURL, HttpMethod.PATCH, patchRequestEntity, responseType);
				break;		
			case DELETE:
				HttpEntity<Map<String, String>> deleteRequestEntity = new HttpEntity<>(params, headers);
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
