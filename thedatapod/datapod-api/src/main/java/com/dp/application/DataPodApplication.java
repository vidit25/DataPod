package com.dp.application;

import com.dp.service.DpService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Class DataPodApplication.
 */
@SpringBootApplication(scanBasePackages = "com.dp")
@RestController
public class DataPodApplication {

	/** The dp service. */
	private final DpService dpService;

	/**
	 * Instantiates a new data pod application.
	 *
	 * @param dpService the dp service
	 */
	public DataPodApplication(DpService dpService) {
		this.dpService = dpService;
	}

	/**
	 * Home.
	 *
	 * @return the string
	 */
	@GetMapping("/")
	public String home() {
		return dpService.message();
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(DataPodApplication.class, args);
	}
}
