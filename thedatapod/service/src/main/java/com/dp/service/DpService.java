package com.dp.service;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

/**
 * The Class DpService.
 */
@Service
@EnableConfigurationProperties(ServiceProperties.class)
public class DpService {

	/** The service properties. */
	private final ServiceProperties serviceProperties;

	/**
	 * Instantiates a new dp service.
	 *
	 * @param serviceProperties the service properties
	 */
	public DpService(ServiceProperties serviceProperties) {
		this.serviceProperties = serviceProperties;
	}

	/**
	 * Message.
	 *
	 * @return the string
	 */
	public String message() {
		return this.serviceProperties.getMessage();
	}
}
