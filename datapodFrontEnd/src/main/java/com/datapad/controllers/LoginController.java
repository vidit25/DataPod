package com.datapad.controllers;

import org.apache.tomcat.util.codec.binary.Base64;
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
import org.springframework.web.client.RestTemplate;

import com.datapad.form.UserForm;
import com.datapad.response.LoginResponse;

@Controller
public class LoginController
{
	
	
	
   @RequestMapping(value = "/", method = RequestMethod.GET)
   public String index(Model model)
   {
	   model.addAttribute("signinForm", new UserForm());
      return "index";
   }

  
   @PostMapping("/login")
   public String login(@ModelAttribute UserForm userForm) {
	   RestTemplate restTemplate = new RestTemplate();
	   
	   MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
	   params.add("grant_type", "password");
	   params.add("username", userForm.getUserName());
	   params.add("password", userForm.getPassword());
	   HttpHeaders headers = new HttpHeaders();
	   String plainCreds = "thedatapod-client:datapod@2020";
       byte[] plainCredsBytes = plainCreds.getBytes();
       byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
       String base64Creds = new String(base64CredsBytes);
       System.out.println("Value of base64Creds ... " + base64Creds);
        headers.add("Authorization", "Basic "+base64Creds);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.add("x-api-key", "AKIARJPM3QSSJFGHPTNO_Dev");
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);
		ResponseEntity<LoginResponse> responseEntity= restTemplate.postForEntity("http://127.0.0.1:8081/oauth/token", request, LoginResponse.class);
		
		if (responseEntity != null && responseEntity.getBody() != null) {
			LoginResponse loginResponse = responseEntity.getBody();
			System.out.println("Value of loginResponse..." + loginResponse.getAccess_token());
		}
	   return "dashboard";
   }
   
   
 
}
