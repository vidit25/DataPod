package com.dp.application;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dp.service.DpService;

/**
 * The Class DataPodApplicationTest.
 */
@SpringBootTest
public class DataPodApplicationTest {

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

}
