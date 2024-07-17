package com.SpringBoot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	
	@RequestMapping("/spring")
	@ResponseBody
	public  String home()
	{
		return "<h1> Welcome to SpringBoot First Task</h1>";
	}

}
