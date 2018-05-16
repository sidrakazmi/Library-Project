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
	 * @return a ModelAndView containing a single Book object. Or an
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

	
	/*Find all books*/
	public List<BookModel> findAllBooks() {
		return bookRepository.findAll();
	}
	
	/*Update a book by id*/
	public void updateBook(BookModel book, long id) {
		book.setId(id);
		bookRepository.save(book);
	}
	
	/*Find a book by id*/ //throws book not found exception
	public BookModel findOneBook(Long id) {
		return bookRepository.getOne(id);
		//return repository.findById(id).get();
	}
	
	/*Delete a book*/  //throws book not found exception
	public void delete(BookModel book) {
		bookRepository.delete(book);
	}
}
