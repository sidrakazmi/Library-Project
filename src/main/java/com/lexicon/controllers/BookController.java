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

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	BookService bookRep;

	/**
	 * Find All Books
	 */
	@GetMapping("/all")
	public List<BookModel> getAllBooks() {
		return bookRep.findAllBooks();
	}

	// Create a new Book
	@PostMapping("/books/save")
	/*public BookModel saveBook(@Valid @RequestBody BookModel newbook) {
		return bookRep.addBook(newbook);
	}*/
	
	public ResponseEntity<Object> createStudent(@RequestBody BookModel newBook) {
		BookModel savedStudent = bookRep.addBook(newBook);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedStudent.getId()).toUri();

		return ResponseEntity.created(location).build();

	}

	// Find a Book by Id
	@GetMapping("books/{id}")
	public ResponseEntity<BookModel> getBookById(@PathVariable(value = "id") Long bookId) {


		BookModel bookModel = bookRep.findOneBook(bookId);

		if (bookModel == null) {
			return ResponseEntity.notFound().build();
		} else
			return ResponseEntity.ok().body(bookModel);

	}

	// Update a Book
	@PutMapping("books/{id}")
	public BookModel updateBook(@PathVariable(value = "id") Long bookId, @Valid @RequestBody BookModel bookDetails) {

		BookModel bookModel = bookRep.findOneBook(bookId);

		bookModel.setTitle(bookDetails.getTitle());
		bookModel.setAuthor(bookDetails.getAuthor());

		BookModel updatedBook = bookRep.addBook(bookModel);
		return updatedBook;
	}

	/* Delete a book */
	@DeleteMapping("books/{id}")
	public ResponseEntity<BookModel> deleteMember(@PathVariable(value = "id") Long bookId) {

		BookModel bookModel = bookRep.findOneBook(bookId);
		if (bookModel == null) {
			return ResponseEntity.notFound().build();
		} else
			bookRep.delete(bookModel);
		return ResponseEntity.ok().build();
	}

}
