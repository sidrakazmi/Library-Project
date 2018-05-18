package com.lexicon.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lexicon.exceptions.BookNotFound;
import com.lexicon.exceptions.MemberNotFound;
import com.lexicon.models.BookModel;
import com.lexicon.models.Loan;
import com.lexicon.models.Member;

@Service
public class MemberService {

	@Autowired
	MemberRepository memberRepository;

	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	LoanRepository loanRepository;
	
	/*Save/Add a member*/
	public Member addMember(Member newMember) {
		return memberRepository.save(newMember);
	}
	
	/*Search all members*/
	public List<Member> findAll() {
		return memberRepository.findAll();
	}
	
	/*Find a member by id*/
	public Member findOne(Long id) {
		return memberRepository.getOne(id);
	}
	
	/*Update a member by id*/
	public void updateMember(Member member, long id) {
		member.setmemberId(id);
		memberRepository.save(member);
	}
	
	/*Delete a member*/
	public void delete(Member mem) {
		memberRepository.delete(mem);
	}
	
	/*
	 * fix from the vpp library
	 */
	/*Find loans and its period on a member
	public Loan loanBook(Long memberId, Long bookId, Long daysUntilDue) throws MemberNotFound, BookNotFound {
		if(!memberRepository.findById(memberId).isPresent()) {
			throw new MemberNotFound();
		}
		if(!bookRepository.findById(bookId).isPresent()) {
			throw new BookNotFound();
		}
		
		Member member = memberRepository.findById(memberId).get();
		BookModel book = bookRepository.findById(bookId).get();
		Loan loan = new Loan(bookId, member, book, LocalDateTime.now(), LocalDateTime. returnDate and time(daysUntilDue));
		loanRepository.save(loan);
		return loan;

	}*/


}
