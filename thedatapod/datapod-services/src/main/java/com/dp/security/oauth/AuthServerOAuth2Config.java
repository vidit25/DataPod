package com.dp.security.oauth;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * The Class AuthServerOAuth2Config.
 */
@Configuration
@EnableAuthorizationServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Import(ServerSecurityConfig.class)
public class AuthServerOAuth2Config extends
AuthorizationServerConfigurerAdapter {

	/** The data source. */
	@Autowired
	@Qualifier("dataSource")
	private DataSource dataSource;

	/** The user details service. */
	@Autowired
	private UserDetailsService customUserDetailsService;

	/** The oauth client password encoder. */
	@Autowired
	private PasswordEncoder oauthClientPasswordEncoder;
	
	/** The authentication manager bean. */
	private AuthenticationManager authenticationManagerBean;
	
  	/**
	   * Sets the authentication manager bean.
	   *
	   * @param authenticationManagerBean the new authentication manager bean
	   */
	  @Autowired
  	public void setAuthenticationManagerBean(AuthenticationManager authenticationManagerBean) {
  		this.authenticationManagerBean = authenticationManagerBean;
  	}

	/**
	 * Configure.
	 *
	 * @param endpoints the endpoints
	 */
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
		endpoints.tokenStore(tokenStore())
		.authenticationManager(authenticationManagerBean)
		.userDetailsService(customUserDetailsService);
	}

	/**
	 * Configure.
	 *
	 * @param oauthServer the oauth server
	 */
	@Override
	public void configure(AuthorizationServerSecurityConfigurer oauthServer) {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.applyPermitDefaultValues();
		// Maybe there's a way to use config from
		// AuthorizationServerEndpointsConfigurer endpoints?
		source.registerCorsConfiguration("/oauth/token", config);
		CorsFilter filter = new CorsFilter(source);
		oauthServer.tokenKeyAccess("permitAll()")
		.checkTokenAccess("isAuthenticated()")
		.passwordEncoder(oauthClientPasswordEncoder)
		.addTokenEndpointAuthenticationFilter(filter);
	}

	/**
	 * Configure.
	 *
	 * @param clients the clients
	 * @throws Exception the exception
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.springframework.security.oauth2.config.annotation.web.configuration
	 * .AuthorizationServerConfigurerAdapter
	 * #configure(org.springframework.security
	 * .oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer)
	 */
	@Override
	public void configure(ClientDetailsServiceConfigurer clients)
			throws Exception {
		clients.jdbc(dataSource);
	}

	/**
	 * Oauth access denied handler.
	 *
	 * @return the o auth 2 access denied handler
	 */
	@Bean
	public OAuth2AccessDeniedHandler oauthAccessDeniedHandler() {
		return new OAuth2AccessDeniedHandler();
	}

	/**
	 * Token store.
	 *
	 * @return the token store
	 */
	@Bean
	public TokenStore tokenStore() {
		return new JdbcTokenStore(dataSource);
	}

}
