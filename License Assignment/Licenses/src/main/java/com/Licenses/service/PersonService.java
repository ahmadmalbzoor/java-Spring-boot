package com.Licenses.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Licenses.models.Person;
import com.Licenses.repositories.PersonRepositories;
@Service
public class PersonService {
	private final PersonRepositories personRepositories;

	public PersonService(PersonRepositories personRepositories) {
		this.personRepositories = personRepositories;
	}

	public List<Person> allPerson() {
		return personRepositories.findAll();
	}

	public Person createPerson(Person p) {
		return personRepositories.save(p);
	}

	public Person findPerson(Long id) {
		Optional<Person> optionalPerson = personRepositories.findById(id);
		if (optionalPerson.isPresent()) {
			return optionalPerson.get();
		} else

			return null;
	}
}
