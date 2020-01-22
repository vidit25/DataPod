package com.dp.filters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;


/**
 * The Class AccessControlFilter.
 */
public class AccessControlFilter extends GenericFilterBean {

	/** The Constant logger. */
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	/** The swagger page. */
	private List<String> swaggerPage;

	/** The api key. */
	@Value("${apiKey}")
	private String apiKey;

	/**
	 * Instantiates a new access control filter.
	 */
	public AccessControlFilter() {
		swaggerPage = new ArrayList<String>();
		swaggerPage.add("swagger-ui.html");
		swaggerPage.add("webjars");
		swaggerPage.add("swagger-resources");
		swaggerPage.add("/v2/api-docs");
		swaggerPage.add("loggerAdmin");
		swaggerPage.add("info");
		swaggerPage.add("health");		
	}

	/**
	 * Do filter.
	 *
	 * @param pRequest the request
	 * @param pResponse the response
	 * @param pChain the chain
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ServletException the servlet exception
	 */
	@Override
	public void doFilter(ServletRequest pRequest, ServletResponse pResponse, FilterChain pChain)
			throws IOException, ServletException {
		if (logger.isDebugEnabled()) {
			logger.debug("Inside AccessControlFilter.doFilter method::::");
		}

		HttpServletRequest lRequest = (HttpServletRequest) pRequest;
		HttpServletResponse lResponse = (HttpServletResponse) pResponse;
		String lContextPath = lRequest.getContextPath();
		String lRequestUri = lRequest.getRequestURI();
		if (logger.isDebugEnabled()) {
			logger.debug("RequestUri::::" + lRequestUri);
		}
		boolean lIsSwaggerPage = false;
		if ((swaggerPage != null) && !swaggerPage.isEmpty() && !StringUtils.isEmpty(lRequestUri)) {
			for (String lSwaggerPage : swaggerPage) {
				if (lRequestUri.contains(lSwaggerPage)) {
					lIsSwaggerPage = true;
					break;
				}
			}
		}
		if (!lIsSwaggerPage && (lContextPath.equals(lRequestUri) || lRequest.getMethod().equalsIgnoreCase("OPTIONS"))) {
			lIsSwaggerPage = true;
		}
		if (!StringUtils.isEmpty(lRequestUri) && lIsSwaggerPage) {
			pChain.doFilter(pRequest, pResponse);
		} else {
			String lXApiKey = lRequest.getHeader("x-api-key");
			if (!StringUtils.isEmpty(lXApiKey) && lXApiKey.equals(apiKey)) {
				pChain.doFilter(pRequest, pResponse);
			} else {
				lResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
				return;
			}
		}
	}
}
