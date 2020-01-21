package com.dp.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * The Class DpServiceTest.
 */
@SpringBootTest("service.message=Welcome to Datapod")
public class DpServiceTest {

	/** The dp service. */
	@Autowired
	private DpService dpService;

	/**
	 * Context loads.
	 */
	@Test
	public void contextLoads() {
		assertThat(dpService.message()).isNotNull();
	}

	/**
	 * The Class TestConfiguration.
	 */
	@SpringBootApplication
	static class TestConfiguration {
	}

}
