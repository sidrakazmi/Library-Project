package com.lexicon.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lexicon.models.BookModel;
import com.lexicon.models.Loan;
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
	LoanService loanRep;
	
    /**
     * Creates a new Loan and saves it to the database
     * @param newLoan is a Member class item to be added
     * @return a new loan added as an object
     */
	@PostMapping("/add")
	public ResponseEntity<BookModel> createLoan(@RequestBody Loan newLoan) {
		Loan createdLoan = loanRep.addLoan(newLoan);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(createdLoan.getId()).toUri();

		return ResponseEntity.created(location).build();
	}
	
	 /**
     * Lists all the Loans in the database
     * @return List of all the loans
     */
	@GetMapping("/all")
	public List<Loan> getAllLoans() {
		return loanRep.findAll();
	}

}
