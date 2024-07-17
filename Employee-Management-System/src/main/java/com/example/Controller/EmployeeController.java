package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.Entity.Employee;
import com.example.Repository.EmployeeRepository;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@RequestMapping("/")
	public String home()
	{
		return "home";
	}
	
	@RequestMapping("/list")
	public ModelAndView list()
	{
		ModelAndView mav=new ModelAndView();
		List<Employee> employee=employeeRepository.findAll();
		mav.setViewName("employeelist");
		mav.addObject("employees", employee);
		return mav;
	}
	
	@RequestMapping("/new")
	public ModelAndView add()
	{
		ModelAndView mav=new ModelAndView();
		Employee employee=new Employee();
		mav.setViewName("addemployee");
		mav.addObject("employee",employee);
		return mav;
	}
	@RequestMapping("/save")
	public String save(@ModelAttribute Employee employee)
	{
		employeeRepository.save(employee);
		return "redirect:/list";
	}
	
	@RequestMapping("/update")
	public ModelAndView update(@RequestParam Long updateById)
	{
		ModelAndView mav=new ModelAndView();
		 Employee employee=employeeRepository.findById(updateById).get();
		 mav.setViewName("addemployee");
		 mav.addObject("employee",employee);
		 return mav;
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam Long deleteById)
	{
		employeeRepository.deleteById(deleteById);
		return "redirect:/list";
	}
}
