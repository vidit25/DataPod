package com.datapad.base.service.impl;

import java.util.Map;

import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.datapad.base.constants.DataPodConstant;
import com.datapad.base.models.ServiceModel;
import com.datapad.base.service.BaseService;
import com.datapad.base.service.SessionService;

@Component
public class BaseServiceImpl implements BaseService {
	
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
	public HttpHeaders buildHeader(ServiceModel serviceModel) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(serviceModel.getContentType());
		headers.set(DataPodConstant.X_API_KEY, apiKey);
		// Get the token from session and set it in header.
		if (serviceModel.isUseTokenAuth()) {
			String authToken = (String) sessionService.getCurrentSession().getAttribute("authToken");
			headers.setBearerAuth(authToken);
		} else {
			String plainCreds = clientId + DataPodConstant.COLON_SEPARATOR + clientSecretKey;
			byte[] plainCredsBytes = plainCreds.getBytes();
			byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
			String base64Creds = new String(base64CredsBytes);
			headers.set(DataPodConstant.AUTHORIZATION, "Basic " + base64Creds);
		}
		return headers;
	}
	
	@Override
	public <T> T callService(ServiceModel serviceModel,HttpMethod httpMethod, Class<T> responseType) {
		RestTemplate restTemplate = new RestTemplate();
		String endpointURL = hostName+serviceModel.getServiceURL();
		HttpHeaders headers = buildHeader(serviceModel);
		T response = null;
		ResponseEntity<T> responseEntity;
		try {
			switch(httpMethod) {
			case GET:
				HttpEntity httpGetEntity = new HttpEntity(headers);
				responseEntity= restTemplate.exchange(endpointURL, httpMethod, httpGetEntity, responseType);
				break;
			case POST:
			case PUT:
			case PATCH:
			case DELETE:
				HttpEntity<Map<String, String>> httpEntity = new HttpEntity<>(serviceModel.getParams(), headers);
				responseEntity= restTemplate.exchange(endpointURL, httpMethod, httpEntity, responseType);
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
