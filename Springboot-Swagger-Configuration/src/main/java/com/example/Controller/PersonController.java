package com.example.Controller;


import com.example.Entity.Person;
import com.example.Repository.PersonRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/persons")
@Api(value = "Person API", description = "CRUD operations for Person")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping
    @ApiOperation(value = "Retrieve all persons", response = List.class)
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Retrieve a person by ID", response = Person.class)
    public ResponseEntity<Person> getPersonById(@PathVariable Long id) {
        return personRepository.findById(id)
                .map(person -> new ResponseEntity<>(person, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    @ApiOperation(value = "Create a new person", response = Person.class)
    public Person createPerson(@RequestBody Person person) {
        return personRepository.save(person);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update a person by ID", response = Person.class)
    public ResponseEntity<Person> updatePerson(@PathVariable Long id, @RequestBody Person updatedPerson) {
        return personRepository.findById(id)
                .map(person -> {
                    person.setFirstName(updatedPerson.getFirstName());
                    person.setLastName(updatedPerson.getLastName());
                    person.setEmail(updatedPerson.getEmail());
                    return new ResponseEntity<>(personRepository.save(person), HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete a person by ID")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        if (personRepository.existsById(id)) {
            personRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

//  http://localhost:9777/swagger-ui/index.html