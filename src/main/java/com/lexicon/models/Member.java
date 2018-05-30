package com.lexicon.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.lexicon.repositories.LoanService;

@Entity
@Table(name ="Members")
@EntityListeners(AuditingEntityListener.class)
public class Member {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long memId;
	
	@NotBlank
    @Column(name="Name")
	private String name;
	
	@NotBlank
	@Column(name="email")
	private String email;
	
	@OneToMany(mappedBy = "member")
	private List<Loan> Loans = new ArrayList<Loan>();

	public List<Loan> getLoans() {
		return Loans;
	}

	public void setLoans(List<Loan> loans) {
		Loans = loans;
	}

	public long getmemberId() {
		return memId;
	}

	public void setmemberId(long id) {
		this.memId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public final void Return(BookModel book) {
			if (book.isOnLoan()==true) {
			System.out.println("Book has not been returned");
		}
	}
	
/*
	public final Loan FindCurrentLoanFor(BookModel book) {
		 for(Loan tmp:Loans){
	            if(tmp.getBook().getbookId().equals(book.getbookId()))
	            {
	        		return tmp;	
	            }
	        }
		return null;
	}*/


	@Override
	public String toString() {
		return "Member [memId=" + memId + ", name=" + name + ", email=" + email + "]";
	}
	
	
}
