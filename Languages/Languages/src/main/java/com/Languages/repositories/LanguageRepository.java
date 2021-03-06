package com.Languages.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Languages.models.languages;

@Repository
public interface LanguageRepository extends CrudRepository<languages, Long> {
	  // this method retrieves all the books from the database
    List<languages> findAll();
    // this method finds books with descriptions containing the search string
    //List<languages> findByDescriptionContaining(String search);
    // this method counts how many titles contain a certain string
    //Long countByTitleContaining(String search);
    // this method deletes a book that starts with a specific title
    //Long deleteByTitleStartingWith(String search);
}
