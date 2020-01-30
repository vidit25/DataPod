package com.dp.security.oauth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.web.csrf.CsrfFilter;

import com.dp.filters.AccessControlFilter;

/**
 * The Class ResourceServerConfiguration.
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

	/** The Constant RESOURCE_ID. */
	private static final String RESOURCE_ID = "resource-server-rest-api";


	/** The Constant SECURED_WRITE_SCOPE. */
	private static final String SECURED_USER_SCOPE = "#oauth2.hasAnyScope('superadmin','admin')";

	/** The Constant SECURED_PATTERN. */
	private static final String SECURED_PATTERN = "/api/**";

	/**
	 * Configure.
	 *
	 * @param http the http
	 * @throws Exception the exception
	 */	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.cors().and().addFilterAfter(getAccessControlFilter(), CsrfFilter.class).sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
				.antMatchers(HttpMethod.OPTIONS, "/oauth/token").permitAll()
				.antMatchers("/v2/api-docs", "/swagger-ui.html", "/webjars/**", "favicon.ico").permitAll()
				.antMatchers(HttpMethod.POST, SECURED_PATTERN).access(SECURED_USER_SCOPE)
				.antMatchers(HttpMethod.GET, "/swagger-resources/**", "/v2/api-docs",
						"/swagger-ui.html", "/webjars/**", "favicon.ico", "/health", "/info")
				.permitAll().antMatchers(HttpMethod.GET, SECURED_PATTERN).permitAll()
				.antMatchers(HttpMethod.POST, SECURED_PATTERN).access(SECURED_USER_SCOPE)
				.antMatchers(HttpMethod.DELETE, SECURED_PATTERN).access(SECURED_USER_SCOPE).anyRequest().permitAll()
				.and().csrf().disable();

	}

	/**
	 * Configure.
	 *
	 * @param resources the resources
	 */	
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) {
		resources.resourceId(RESOURCE_ID);
	}

	/**
	 * Gets the access control filter.
	 *
	 * @return the access control filter
	 */
	@Bean
	public AccessControlFilter getAccessControlFilter() {
		AccessControlFilter lAccessControlFilter = new AccessControlFilter();
		return lAccessControlFilter;
	}
}
