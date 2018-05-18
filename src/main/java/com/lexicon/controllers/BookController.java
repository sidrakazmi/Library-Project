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
	BookService bookService;
	

    /**
     * Creates a new book and saves it to the database
     * @param newBook is a Member class item to be added
     * @return a new book added as an object
     */
	@PostMapping("/add")
	//@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<BookModel> createBook(@RequestBody BookModel newBook) {
		BookModel createdBook = bookService.addBook(newBook);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(createdBook.getbookId()).toUri();

		return ResponseEntity.created(location).build();
	}

    /**
     * Updates a book and saves it to the database
     * @param bookUpdates is a Book class item to be updated
     * @return updatedBook as an object
     */
	@PutMapping("/update/{id}")
	public BookModel updateBook(@PathVariable(value = "id") Long bookId, @Valid @RequestBody BookModel bookUpdates) {

		BookModel bookModel = bookService.findOneBook(bookId);

		bookModel.setTitle(bookUpdates.getTitle());
		bookModel.setAuthor(bookUpdates.getAuthor());

		BookModel updatedBook = bookService.addBook(bookModel);
		return updatedBook;
	}
	

    /**
     * Finds a book from the database
     * @param bookId is a Book class item to be searched for
     * @return foundBook as a response
     */
	@GetMapping("/find/{id}")
	public ResponseEntity<BookModel> getBookById(@PathVariable(value = "id") Long bookId) {

		BookModel foundBook = bookService.findOneBook(bookId);

		if (foundBook == null) {
			return ResponseEntity.notFound().build();
		} else
			return ResponseEntity.ok().body(foundBook);
	}



	 /**
     * Deletes a book from the database
     * @param bookId is a Book class item to be deleted
     * @return a book deleted
     */
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<BookModel> deleteMember(@PathVariable(value = "id") Long bookId) {

		BookModel bookModel = bookService.findOneBook(bookId);
		if (bookModel == null) {
			return ResponseEntity.notFound().build();
		} else
			bookService.delete(bookModel);
		return ResponseEntity.ok().build();
	}
	
	 /**
     * Lists All Books in the database
     * @return List of all the books
     */
	@GetMapping("/all")
	public List<BookModel> getAllBooks() {
		return bookService.findAllBooks();
	}

}
