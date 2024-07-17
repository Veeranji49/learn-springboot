package com.SpringBoot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	
	@RequestMapping("/sss")
	public String hello()
	{
		return "wow";
	}
	
	@RequestMapping("/")
	@ResponseBody
	public String eiek()
	{
		return "<h1>Welcome to Spring Tool Suite <h1>";
	}

}
