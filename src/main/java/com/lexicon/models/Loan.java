package com.lexicon.models;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;



@Entity
public class Loan {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	private Member member;
	
	@OneToOne
	private BookModel book;
	
	private Date issueDate;
	private Date returnDate;
	
	private boolean onLoan;
	
	
	public Loan() {
		super();
	}


	public Loan(long id, Member member, BookModel book) {
		super();
		this.id = id;
		this.member = member;
		this.book = book;
		this.issueDate = new Date();
		
		GregorianCalendar gCal = new GregorianCalendar();
		gCal.add(GregorianCalendar.DAY_OF_MONTH, 14);		
		this.returnDate = gCal.getTime();
		
		this.onLoan = false;
	}


	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public Member getMember() {
		return member;
	}


	public void setMember(Member member) {
		this.member = member;
	}


	public BookModel getBook() {
		return book;
	}


	public void setBook(BookModel book) {
		this.book = book;
	}


	public Date getIssueDate() {
		return issueDate;
	}


	public void setIssueDate(Date startingDate) {
		this.issueDate = startingDate;
	}


	public Date getReturnDate() {
		return returnDate;
	}


	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}


	public boolean isOnLoan() {
		return onLoan;
	}


	public void setOnLoan(boolean onLoan) {
		this.onLoan = onLoan;
	}


	public boolean HasNotBeenRuturned() {
		return returnDate == null;
	}


	@Override
	public String toString() {
		return "Loan [id=" + id + ", member=" + member + ", book=" + book + ", issuetDateAndTime=" + issueDate
				+ ", returnDateAndTime=" + returnDate + ", onLoan="
				+ onLoan + "]";
	}

	public void endLoan() {
		returnDate = new Date();
		this.onLoan = false;
	}
	
	
	
	
}
