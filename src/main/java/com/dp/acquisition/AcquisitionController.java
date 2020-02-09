package com.dp.acquisition;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AcquisitionController {
	private static final Logger LOGGER=LoggerFactory.getLogger(AcquisitionController.class);
	
	private static final String HELLO = "Hello, %s!";

	@RequestMapping("/isServerUp")
	public String isServerUp(@RequestParam(value = "name", defaultValue = "World") String name) {
		LOGGER.info(String.format(HELLO, name));
		return String.format(HELLO, name);
	}

}