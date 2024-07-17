/*
package com.example.Security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {
	
	@Bean  //@Bean is used for creating object for the class automatically
	public InMemoryUserDetailsManager secure()
	{
		UserDetails user1=User.builder().username("anji").password("{noop}veeru").roles("EMPLOYEE,ADMIN").build();
		
		
		UserDetails user3=User.builder().username("Lenovo").password("{noop}2030").roles("LAPTOP").build();
		
		
		UserDetails user4=User.builder().username("Cristiano").password("{noop}123456").roles("FOOTBALL").build();
		
		InMemoryUserDetailsManager imudm=new InMemoryUserDetailsManager(user1,user3,user4);
		
		return imudm;
	}
}

*/
