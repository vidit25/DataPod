package com.datapad.page.login.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.datapad.base.constants.DataPodConstant;
import com.datapad.base.service.BaseService;
import com.datapad.form.UserForm;
import com.datapad.page.login.model.LoginModel;

@Component
public class LoginService extends BaseService {
	
	
	
	@Value("${url.signin}")
	private String loginURL;
	
	public boolean doLogin(UserForm userForm) {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add(DataPodConstant.GRANT_TYPE, DataPodConstant.PASSWORD);
		params.add(DataPodConstant.USER_NAME, userForm.getUserName());
		params.add(DataPodConstant.PASSWORD, userForm.getPassword());
		LoginModel loginResponse = doPost(loginURL, params, MediaType.APPLICATION_FORM_URLENCODED,LoginModel.class);
		if(null != loginResponse && null != loginResponse.getAccessToken() && !StringUtils.isEmpty(loginResponse.getAccessToken())) {
			ServletRequestAttributes servletReqAttribs = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
			HttpSession session= servletReqAttribs.getRequest().getSession(true);
			session.setAttribute("authToken", loginResponse.getAccessToken());
			return true;
		}
		return false;
	}

}
