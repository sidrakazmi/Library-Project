package com.lexicon.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lexicon.models.BookModel;
import com.lexicon.models.Loan;
import com.lexicon.models.Member;
import com.lexicon.repositories.LoanService;

/**
 * This class has the logic for acting on web requests.
 * 
 * @author Sidra Kazmi
 *
 */
@RestController
@RequestMapping("/loans")
public class LoanController {
	

	@Autowired
	LoanService loanService;
	
    /**
     * Creates a new Loan and saves it to the database
     * @param newLoan is a Member class item to be added
     * @return a new loan added as an object
     */
	@PostMapping("/add")
	public ResponseEntity<Loan> createLoan(@RequestBody BookModel book,@RequestBody Member member) {
		Loan createdLoan = loanService.addLoan(book, member);
				
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(createdLoan.getId()).toUri();

		return ResponseEntity.created(location).build();
	}

    /**
     * Updates a Loan and saves it to the database
     * @param book 
     * @param member 
     * @param bookDetails is a Loan class item to be updated
     * @return updatedLoan as an object
     */
	@PutMapping("/update/{id}")
	
	public ResponseEntity<Loan> updateLoan(@PathVariable(value = "id") Long loanId, @Valid @RequestBody Loan loanUpdates, BookModel book, Member member) {
         
	Loan loan =  loanService.findById(loanId);
				
		if (loan == null) {
			return ResponseEntity.notFound().build();
		} else
			loan.setIssueDate(loanUpdates.getIssueDate());
		loan.setReturnDate(loanUpdates.getReturnDate());
			
		Loan updatedLoan = loanService.addLoan(book, member);
				return ResponseEntity.ok().body(updatedLoan);	
		}

	/**
     * Finds a Loan from the database by respective member
     * @param member is a Member class item to be searched for
     * @return foundLoan as response
     */
	@GetMapping("/member/{id}")
	public ResponseEntity<Loan> getMemberById(@PathVariable(value = "id") Member member) {

		Loan foundLoan =  (Loan) loanService.findByMember(member);

		if (foundLoan == null) {
			return ResponseEntity.notFound().build();
		} else
			return ResponseEntity.ok().body(foundLoan);
	}
	
	/**
     * Finds a Loan from the database by respective book
     * @param member is a Book class item to be searched for
     * @return foundLoan as response
     */
	@GetMapping("/book/{id}")
	public ResponseEntity<Loan> getBookById(@PathVariable(value = "id") BookModel book) {

		Loan foundLoan =  (Loan) loanService.findByBook(book);

		if (foundLoan == null) {
			return ResponseEntity.notFound().build();
		} else
			return ResponseEntity.ok().body(foundLoan);
	}
	
	 /**
     * Deletes a book on loan from the database
     * @param book is a Book class item to be deleted
     * @return a book deleted
     */
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Loan> deleteLoan(@PathVariable(value = "id") BookModel book) {

		Loan loan = (Loan) loanService.findByBook(book);
				
		if (loan == null) {
			return ResponseEntity.notFound().build();
		} else
			loanService.delete(loan);
		return ResponseEntity.ok().build();
	}

	
	 /**
     * Lists all the Loans in the database
     * @return List of all the loans
     */
	@GetMapping("/all")
	public List<Loan> getAllLoans() {
		return loanService.findAll();
	}

}
