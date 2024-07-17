package com.SpringBoot.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.SpringBoot.Entity.Hostel;
import com.SpringBoot.service.HostelService;

@Controller
public class HostelController {

	@Autowired
	private HostelService service;
	
	@RequestMapping("/")
	@ResponseBody
	public String save(Model model)
	{
		Hostel hostel=new Hostel();
		hostel.setName("Raghavendra hostel");
		hostel.setFees(5000);
		hostel.setId(2);
		hostel.setLocation("Banglore");
		hostel.setStudents(250);
		
		Hostel hst=service.insert(hostel);
		String msg="Inserted Successfully";
		model.addAttribute("Message",msg);
		model.addAttribute("Hostel", hst);
		
		return "view";
	}
	
	@RequestMapping("/vieww")
	public String jsp()
	{
		return "view";
	}
}
