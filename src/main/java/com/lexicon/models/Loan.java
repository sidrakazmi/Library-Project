package com.lexicon.models;

import java.time.LocalDateTime;
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
	
	private LocalDateTime startDateAndTime;
	private LocalDateTime dueDateAndTime;
	private LocalDateTime returnDateAndTime;
	
	
	public Loan() {
		super();
	}


	public Loan(long id, Member member, BookModel book, LocalDateTime startDateAndTime, LocalDateTime dueDateAndTime,
			LocalDateTime returnDateAndTime) {
		super();
		this.id = id;
		this.member = member;
		this.book = book;
		this.startDateAndTime = startDateAndTime;
		this.dueDateAndTime = dueDateAndTime;
		this.returnDateAndTime = returnDateAndTime;
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


	public LocalDateTime getStartDateAndTime() {
		return startDateAndTime;
	}


	public void setStartDateAndTime(LocalDateTime startDateAndTime) {
		this.startDateAndTime = startDateAndTime;
	}


	public LocalDateTime getDueDateAndTime() {
		return dueDateAndTime;
	}


	public void setDueDateAndTime(LocalDateTime dueDateAndTime) {
		this.dueDateAndTime = dueDateAndTime;
	}


	public LocalDateTime getReturnDateAndTime() {
		return returnDateAndTime;
	}


	public void setReturnDateAndTime(LocalDateTime returnDateAndTime) {
		this.returnDateAndTime = returnDateAndTime;
	}
	

}
