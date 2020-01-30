package com.datapad.base.service;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
public class SessionService {
	
	public HttpSession getCurrentSession() {
		ServletRequestAttributes servletReqAttribs = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
	    HttpSession currentSession= servletReqAttribs.getRequest().getSession(true);
	    return currentSession;
	}
}
