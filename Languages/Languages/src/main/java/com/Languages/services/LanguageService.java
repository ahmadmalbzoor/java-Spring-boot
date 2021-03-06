package com.Languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Languages.models.languages;
import com.Languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	// adding the book repository as a dependency
	private final LanguageRepository languageRepository;

	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}

	// returns all the books
	public List<languages> allLanguages() {
		return languageRepository.findAll();
	}

	// creates a book
	public languages createLanguages(languages b) {
		return languageRepository.save(b);
	}

	// retrieves a book
	public languages findLanguages(Long id) {
		Optional<languages> optionaLanguages = languageRepository.findById(id);
		if (optionaLanguages.isPresent()) {
			
			return optionaLanguages.get();
		}

		else {
			return null;
		}
	}

	public languages updatLanguage(Long id, String name, String creator, Integer version) {
	       languages newLanguage=this.findLanguages(id);
	       newLanguage.setName(name);
	       newLanguage.setVersion(version);
	       newLanguage.setCreator(creator);
	 
	        return languageRepository.save(newLanguage);
	}

	public void DeleteLang(Long id) {
		{languageRepository.deleteById(id);
		}
	}
}