package com.datapad.controllers;

import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.datapad.form.UserForm;
import com.datapad.utils.DataPodConstant;

@Controller
public class LoginController implements DataPodConstant
{
	@Value("${service.client.id}")
	private String clientId;
	
	@Value("${service.client.secretKey}")
	private String clientSecretKey;
	
	@Value("${service.host}")
	private String hostName;
	
	@Value("${url.signin}")
	private String loginURI;
	
	@Value("${service.api.key}")
	private String apiKey;
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	
   /**
    * This method is used load login screen. 	
    * @param model
    * @return
    */
   @RequestMapping(value = "/", method = RequestMethod.GET)
   public String index(Model model)
   {
	   model.addAttribute("signinForm", new UserForm());
      return "index";
   }

  
   /**
    * This method will login.
    * @param userForm
    * @return
    */
   @PostMapping("/login")
   public String login (@ModelAttribute UserForm userForm, Model model) {
	   RestTemplate restTemplate = new RestTemplate();
	   MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
	   params.add(GRANT_TYPE, PASSWORD);
	   params.add(USER_NAME, userForm.getUserName());
	   params.add(PASSWORD, userForm.getPassword());
	   HttpEntity<MultiValueMap<String, String>> request = createHeaders(params);
	   
	   try {
		   ResponseEntity<String> responseEntity= restTemplate.postForEntity(hostName+loginURI, request, String.class);
		   if (responseEntity != null && responseEntity.getBody() != null) {
			   LOGGER.info("Value of loginResponse..." + responseEntity.getBody());
		   }
	   } catch (HttpClientErrorException exception) {
		   LOGGER.error("Send message error: Response body: {} \nException: ", exception.getResponseBodyAsString(), exception);
		   model.addAttribute("signinForm", new UserForm());
		   return "index";
	   }
	   return "dashboard";
   }

   /**
    * This method will create request headers
    * @param params
    * @return
    */
   private HttpEntity<MultiValueMap<String, String>> createHeaders (MultiValueMap<String, String> params) {
	   HttpHeaders headers = new HttpHeaders();
	   String plainCreds = clientId+COLAN_SEPARATOR+clientSecretKey;
	   byte[] plainCredsBytes = plainCreds.getBytes();
	   byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
	   String base64Creds = new String(base64CredsBytes);
	   headers.add(AUTHORIZATION, "Basic "+base64Creds);
	   headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
	   headers.add(X_API_KEY, apiKey);
	   HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);
	   return request;
   }
   
   
 
}
