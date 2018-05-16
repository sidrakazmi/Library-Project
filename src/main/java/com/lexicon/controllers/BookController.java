package com.lexicon.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lexicon.models.BookModel;
import com.lexicon.repositories.BookService;
import com.lexicon.repositories.BookRepository;
import javax.validation.Valid;

import java.net.URI;
import java.util.List;
/**
 * This class has the logic for acting on web requests.
 * 
 * @author Sidra Kazmi
 *
 */
@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	BookService bookRep;
	

    /**
     * Creates a new book and saves it to the database
     * @param newBook is a Member class item to be added
     * @return a new book added as an object
     */
	@PostMapping("/add")
	public ResponseEntity<BookModel> createBook(@RequestBody BookModel newBook) {
		BookModel createdBook = bookRep.addBook(newBook);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(createdBook.getId()).toUri();

		return ResponseEntity.created(location).build();

	}

    /**
     * Updates a book and saves it to the database
     * @param bookDetails is a Book class item to be added
     * @return updatedBook as an object
     */
	@PutMapping("/update/{id}")
	public BookModel updateBook(@PathVariable(value = "id") Long bookId, @Valid @RequestBody BookModel bookDetails) {

		BookModel bookModel = bookRep.findOneBook(bookId);

		bookModel.setTitle(bookDetails.getTitle());
		bookModel.setAuthor(bookDetails.getAuthor());

		BookModel updatedBook = bookRep.addBook(bookModel);
		return updatedBook;
	}
	// Find a Book by Id
	@GetMapping("/find/{id}")
	public ResponseEntity<BookModel> getBookById(@PathVariable(value = "id") Long bookId) {

		BookModel bookModel = bookRep.findOneBook(bookId);

		if (bookModel == null) {
			return ResponseEntity.notFound().build();
		} else
			return ResponseEntity.ok().body(bookModel);

	}



	/* Delete a book */
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<BookModel> deleteMember(@PathVariable(value = "id") Long bookId) {

		BookModel bookModel = bookRep.findOneBook(bookId);
		if (bookModel == null) {
			return ResponseEntity.notFound().build();
		} else
			bookRep.delete(bookModel);
		return ResponseEntity.ok().build();
	}
	
	 /**
     * Lists All Books in the database
     * @return List of all the books
     */
	@GetMapping("/all")
	public List<BookModel> getAllBooks() {
		return bookRep.findAllBooks();
	}

}
