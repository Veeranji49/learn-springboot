package com.example.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/logger")
public class LoggerController {

	public static final Logger logger=LoggerFactory.getLogger(LoggerController.class);
	
	@GetMapping(value="/log")
	public String log()
	{
		logger.info("This is info logger");
		logger.warn("This is warn logger");
		logger.debug("This is debug logger");
		logger.error("This is error logger");
		
		return "Hello welcome to Springboot Logging";
	}
}
