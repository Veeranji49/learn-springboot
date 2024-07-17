package com.example.SpringbootRestTemplate.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.example.SpringbootRestTemplate.Entity.Employee;

@Controller
public class EmployeeController {

	/*
	 * @RequestMapping(value="/post") public String post(Model model) { RestTemplate
	 * template=new RestTemplate();
	 * 
	 * Employee emp=new Employee(); emp.setName("shoukath"); emp.setSalary(60000);
	 * emp.setLocation("Hyderabad");
	 * 
	 * Employee epost=template.postForObject("http://localhost:9999/rest/api/save",
	 * emp,Employee.class); System.out.println("Details:"+epost);
	 * 
	 * model.addAttribute("employee",epost);
	 * 
	 * return "post"; }
	 */
	
	
	
	/*
	 * @RequestMapping("/put") public String update(Model model) 
	 * {
	 *   RestTemplate template=new RestTemplate();
	 * 
	 * Employee emp=new Employee(); 
	 * emp.setName("redmi"); 
	 * emp.setSalary(45670);
	 * emp.setLocation("banglore");
	 * 
	 * template.put("http://localhost:9999/rest/api/update/16", emp);
	 * 
	 * model.addAttribute("employee", emp);
	 *  return "update"; 
	 * }
	 */
	
	
//		@RequestMapping("/delete")
//		public String delete(Model model)
//		{
//			RestTemplate template=new RestTemplate();
//			
//			template.delete("http://localhost:9999/rest/api/delete/8");
//			model.addAttribute("employee", template);
//			return "delete";
//		}
	
	
	@RequestMapping("/getone")
	public String get1(Model model)
	{
		RestTemplate template=new RestTemplate();
		
		Employee emp=template.getForObject("http://localhost:9999/rest/api/getone/4",Employee.class);
//		System.out.println("Name:"+emp.getName());
//		System.out.println("Location:"+emp.getLocation());
//		System.out.println("Salary:"+emp.getSalary());
		
		model.addAttribute("employee", emp);
		
		return "getone";
	}
	
	
	@RequestMapping("/getall")
	public String getall(Model model)
	{
		RestTemplate template=new RestTemplate();
		
		ResponseEntity<Employee[]> emp=template.getForEntity("http://localhost:9999/rest/api/getall", Employee[].class);
		
		Employee[] egetall=emp.getBody();
	
		for(int i=0; i<=egetall.length-1; i++)
		{
			System.out.println(egetall[i]);
		}
		
		model.addAttribute("employee", egetall);
		return "getall";
		
	}
}
