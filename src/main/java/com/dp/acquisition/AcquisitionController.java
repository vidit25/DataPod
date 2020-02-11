package com.dp.acquisition;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dp.acquisition.snowflake.SnowFlakeService;

@RestController
@RequestMapping("/rest")
public class AcquisitionController {
	private static final Logger LOGGER=LoggerFactory.getLogger(AcquisitionController.class);

	@Autowired
	private SnowFlakeService service;
	
	@RequestMapping("/isServerUp")
	public String isServerUp(@RequestParam(value = "name", defaultValue = "World") String name) {
		String helloStr = String.format("Hello, %s!", name);
		LOGGER.info(helloStr);
		return helloStr;
	}

	@RequestMapping("/startDataAcquisition")
	public String startDataAcquisition(@RequestParam(value = "name", defaultValue = "World") String name) {
		LOGGER.info("Data Acquisition Started");
		service.startLoading();
		return "Data Acquisition Started";
	}

}