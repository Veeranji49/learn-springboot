package com.SpringBoot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

	@RequestMapping("/")
	public String home()
	{
		return "home";
	}
	
	@RequestMapping("/about")
	public String aboutpage()
	{
		return "about";
	}
	
	@RequestMapping("/contact")
	public String contactpage()
	{
		return "contact";
	}
	
	@RequestMapping("/login")
	public String loginpage()
	{
		return "login";
	}
	
	@RequestMapping("/reg")
	public String Registerpage()
	{
		return "reg";
	}
}
