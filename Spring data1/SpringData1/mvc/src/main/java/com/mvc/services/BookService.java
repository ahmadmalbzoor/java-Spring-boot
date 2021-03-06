package com.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mvc.models.Books;
import com.mvc.repositories.BookRepository;

@Service
public class BookService {
	// adding the book repository as a dependency
	private final BookRepository bookRepository;

	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	// returns all the books
	public List<Books> allBooks() {
		return bookRepository.findAll();
	}

	// creates a book
	public Books createBook(Books b) {
		return bookRepository.save(b);
	}

	// retrieves a book
	public Books findBook(Long id) {
		Optional<Books> optionalBook = bookRepository.findById(id);
		if (optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}

	public void deleteBook(Long id) {
		Optional<Books> optionalBook = bookRepository.findById(id);
		if (optionalBook.isPresent()) {
			bookRepository.delete(optionalBook.get());
		}
	}

	public Books updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
	       Books book=this.findBook(id);
	        book.setDescription(desc);
	        book.setLanguage(lang);
	        book.setTitle(title);
	        book.setNumberOfPages(numOfPages);
	        return bookRepository.save(book);
	}

}
