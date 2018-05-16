package com.lexicon.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lexicon.models.BookModel;
import com.lexicon.models.Loan;
import com.lexicon.models.Member;


public interface LoanRepository extends JpaRepository<Loan, Long> {

   public List<Loan> findByBook(BookModel book);
	
   public List<Loan> findByMember(Member member);

}
