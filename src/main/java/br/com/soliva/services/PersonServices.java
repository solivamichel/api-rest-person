package br.com.soliva.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.soliva.exception.ResourceNotFound;
import br.com.soliva.model.Person;
import br.com.soliva.repository.PersonRepository;


@Service
public class PersonServices {
	
	@Autowired
	PersonRepository repository;
	
	public Person create( Person person ) {
		return repository.save(person);
	}
	
	public List<Person> findAll() {
		return repository.findAll();
	}
	
	public Person findById( Long id ) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFound("No records found for this ID"));
	}
	
	public Person update( Person person ) {
		
		Person entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFound("No records found for this ID"));
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAdress(person.getAdress());
		entity.setGender(person.getGender());
		
		return repository.save(entity);
	}
	
	public void delete( Long id ) {
		Person entity = repository.findById(id).orElseThrow(() -> new ResourceNotFound("No records found for this ID"));
		repository.delete(entity);
	}
}
