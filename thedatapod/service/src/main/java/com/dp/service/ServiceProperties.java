package com.dp.service;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * The Class ServiceProperties.
 */
@ConfigurationProperties("service")
public class ServiceProperties {

	/**
	 * A message for the service.
	 */
	private String message;

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message the new message
	 */
	public void setMessage(String message) {
		this.message = message;
	}
}
