package com.datapad.page.login.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginModel implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6108400346338329698L;

	@JsonProperty("access_token")
	private String accessToken;
	
	@JsonProperty("token_type")
	private String tokenType;
	
	@JsonProperty("refresh_token")
	private String refreshToken;
	
	@JsonProperty("scope")
	private String scope;
	
	@JsonProperty("expires_in")
	private Integer expiresIn;
	
	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

}
