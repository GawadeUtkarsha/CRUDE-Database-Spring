package com.example.cruddatabase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.cruddatabase.model.Person;
import com.example.cruddatabase.services.PersonService;


@RestController
public class PersonController {
    @Autowired
	private PersonService personService;
    
    @GetMapping("/getAll")
	public List<Person> getAllPerson(){
		return personService.getAllPerson();
	}
    @PostMapping("/post")
    
   public Person savePerson(@RequestBody Person person)
    {
    	 return personService.savePerson(person);
    }
    
    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Long id)
    {
		personService.deletePerson(id);
    }
    
    @PutMapping("/{id}")

    public Person updatePerson(@PathVariable Long id, @RequestBody Person updatedPerson)
    {
        return personService.updatePerson(id, updatedPerson);
    }

    
    
   
}