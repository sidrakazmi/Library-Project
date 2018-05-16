package com.lexicon.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lexicon.models.BookModel;
import com.lexicon.models.Loan;
import com.lexicon.models.Member;

@Service
public class LoanService {
	
	@Autowired
	LoanRepository loanRepository;
	
	/*Add a new loan*/  //loan already exists exception
	public Loan saveLoan(Loan newLoan) {
		return loanRepository.save(newLoan);
	}
	
	/*Search all loans*/
	public List<Loan> findAll() {
		return loanRepository.findAll();
	}
	
	/*Find a loan by book*/
	public List<Loan> findByBook(BookModel  book) {
		return loanRepository.findByBook(book);

	}
	
	/*Find a loan by member*/
	public List<Loan> findByMember(Member member) {
		return loanRepository.findByMember(member);
	}


	/*Update a loan*/
	public void updateLoan(Loan loan, long id) {
		loan.setId(id);
		loanRepository.save(loan);
	}
	
	/*Delete a loan*/ //loan not found exception
	public void delete(Loan loan) {
		loanRepository.delete(loan);
	}


}
