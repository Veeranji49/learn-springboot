package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.User;
import com.example.ExceptionHandling.ResourceNotFoundException;
import com.example.Repository.UserRepository;

@RestController
@RequestMapping(value="/api/v1/resource")
public class UserController {

	@Autowired
	public UserRepository userRepository;
	
	
	/////// Insert /////
	
	@PostMapping("/save")
	public String sav(@RequestBody User user)
	{
		userRepository.save(user);
		return "Successfully saved";
	}
	
	
	////// Update by Id //////
	
	@PutMapping("/update/{id}")
	public String updatee(@RequestBody User user, @PathVariable long id)
	{
		User us=userRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("User id is not found:"+id));
		us.setName(user.getName());
		us.setSalary(user.getSalary());
		us.setLocation(user.getLocation());
		
		userRepository.save(us);
		return "Updated Successfully";
	}
	
	
	///// Delete by Id /////
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<User> delete(@PathVariable long id)
	{
		User existing=this.userRepository.findById(id)
		.orElseThrow(()->new ResourceNotFoundException("User id is not found :"+id));
		this.userRepository.delete(existing);
		return ResponseEntity.ok().build();
		
	}
	
	///// find by Id /////
	
	@GetMapping("/getone/{id}")
	public User getone(@PathVariable long id)
	{
		return this.userRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("user id is not found:"+id));
	
	}
	
	///// find all /////
	
	@GetMapping("/getall")
	public List<User> list()
	{
		List<User> list=userRepository.findAll();
		return list;
				
	}
}
