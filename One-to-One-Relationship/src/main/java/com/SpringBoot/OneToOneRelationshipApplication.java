package com.SpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.SpringBoot.Entity.Passport;
import com.SpringBoot.Entity.Person;
import com.SpringBoot.Repository.PersonRepository;

@SpringBootApplication
public class OneToOneRelationshipApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(OneToOneRelationshipApplication.class, args);
	}
	
	@Autowired
	private PersonRepository personRepository;

	@Override
	public void run(String... args) throws Exception {
		
		//Person reference 
		Person person=new Person();
		person.setPerson_name("veeru");
		person.setLocation("hyderabad");
		
		
		//Passport reference
		Passport passport=new Passport();
		passport.setPp_number(87437);
		
		
		passport.setPersons(person);
		person.setPassport(passport);
		
		personRepository.save(person);
		
	}

}
