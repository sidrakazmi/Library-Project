package com.lexicon.repositories;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

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
	public  Loan addLoan(BookModel book, Member member) {
		
			Loan newLoan=new Loan();
			Date startingDate = new Date();
			newLoan.setBook(book);
	        newLoan.setMember(member);
	        newLoan.setIssueDate(startingDate);
	       
	        GregorianCalendar gCal = new GregorianCalendar();
			gCal.add(GregorianCalendar.DAY_OF_MONTH, 14);		
			newLoan.setReturnDate( gCal.getTime());
			
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
	
	/*Find a loan by Id*/
	public Loan findById(Long id) {
		return loanRepository.getOne(id);			
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
