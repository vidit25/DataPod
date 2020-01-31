package com.datapad.page.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;

import com.datapad.base.constants.DataPodConstant;
import com.datapad.base.models.ServiceModel;
import com.datapad.base.service.BaseService;
import com.datapad.base.service.SessionService;
import com.datapad.form.UserForm;
import com.datapad.page.login.model.LoginModel;

@Component
public class LoginService {
	
	
	
	@Value("${url.signin}")
	private String loginURL;
	
	@Autowired
	private SessionService sessionService;
	
	@Autowired
	private BaseService baseService;
	
	public boolean doLogin(UserForm userForm) {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add(DataPodConstant.GRANT_TYPE, DataPodConstant.PASSWORD);
		params.add(DataPodConstant.USER_NAME, userForm.getUserName());
		params.add(DataPodConstant.PASSWORD, userForm.getPassword());
		ServiceModel serviceModel = new ServiceModel.ServiceModelBuilder()
				.serviceURL(loginURL).params(params).isUseTokenAuth(false)
				.contentType(MediaType.APPLICATION_FORM_URLENCODED).build();
		LoginModel loginResponse = baseService.doPost(serviceModel,LoginModel.class);
		if(null != loginResponse && null != loginResponse.getAccessToken() && !StringUtils.isEmpty(loginResponse.getAccessToken())) {
			sessionService.getCurrentSession().setAttribute("authToken", loginResponse.getAccessToken());
			return true;
		}
		return false;
	}

}
