package com.example.cruddatabase.services;

import java.util.List;
import java.util.Optional;
//import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cruddatabase.model.Person;
import com.example.cruddatabase.repository.PersonRepository;

@Service
public class PersonService {
    @Autowired
	private PersonRepository personRepository;
    
	public List<Person> getAllPerson(){
		return personRepository.findAll();
	}
	public Person savePerson(Person person)
	{
		return personRepository.save(person);
	}
	
	public void deletePerson(Long id)
	{
		personRepository.deleteById(id);
	}
	//get by ID one by one
//	public Person getPersonById(Long id)
//	{
//		return personRepository.findById(id).orElse(Else(null));
//	}
//	
	 public Person updatePerson(Long id, Person updatedPerson) {
	        Optional<Person> existingPersonOptional = personRepository.findById(id);
            //if(po.isPresent())
	        if (existingPersonOptional.isPresent())
	        {
	            Person existingPerson = existingPersonOptional.get();
	            existingPerson.setName(updatedPerson.getName());
	            existingPerson.setAge(updatedPerson.getAge());
	            

	            return personRepository.save(existingPerson);
	        } 
	        else {
	           System.out.println("error");
	            return null;
	        }
	 
	 }	 
}

