package com.Licenses.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Licenses.models.Person;

@Repository
public interface PersonRepositories extends CrudRepository<Person,Long> {
    List<Person> findAll();
    List<Person> findBylicenseIsNull();
    


}
