package com.lexicon.repositories;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lexicon.exceptions.BookAlreadyAvailableException;
import com.lexicon.models.BookModel;

@Service
public class BookService {

	@Autowired
	BookRepository bookRepository;
	
	
	/**
	 * Save/Add a new book
	 * @param newBook
	 *            
	 * @return a newBook a single Book object added in Repository
	 *      
	 * @throws Book Already Available Exception
	 *             if the book already exists
	 */
	public BookModel addBook(BookModel newBook) {
			/*throws BookAlreadyAvailableException{
		if(bookRepository.existsById(newBook.getId())) 
		{
			throw new BookAlreadyAvailableException();
		}*/
		return bookRepository.save(newBook);
	}

	
	/**
	 * Lists all the books available
	 *            
	 * @return a all the books
	 */
	public List<BookModel> findAllBooks() {
		return bookRepository.findAll();
	}
	
	/*Update a book by id*/
	public void updateBook(BookModel book, long id) {
		book.setbookId(id);
		bookRepository.save(book);
	}
	
	/*Find a book by id*/ //throws book not found exception
	public BookModel findOneBook(Long id) {
		return bookRepository.findById(id).get();
	}
	
	/*Delete a book*/  //throws book not found exception
	/*public void delete(BookModel book) {
		bookRepository.delete(book);
	}*/
	
	public void delete( long id) {
		 BookModel book =bookRepository.getOne(id);
				
		 if(!bookRepository.existsById(id))
				  return;
	
		bookRepository.delete(book);
	    }
}
