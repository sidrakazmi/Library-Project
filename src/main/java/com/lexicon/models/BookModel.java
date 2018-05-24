package com.lexicon.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Entity
@Table(name = "book")
public class BookModel implements Serializable {
	
		@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long bookId;

	    @NotNull
	    @Column(name="Title")
	    private String title;

	    @NotNull
	    @Column(name="Author")
	    private String author;

	 
	   private boolean onLoan;
	    
	    public BookModel() {}

		public BookModel(Long id, @NotNull String title, @NotNull String author, boolean onLoan) {
			super();
			this.bookId = id;
			this.title = title;
			this.author = author;
			this.onLoan =onLoan;
		}

		public boolean isOnLoan() {
			return onLoan;
		}

		public void setOnLoan(boolean onLoan) {
			this.onLoan = onLoan;
		}

		public Long getbookId() {
			return bookId;
		}

		public void setbookId(Long id) {
			this.bookId = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

	    @Override
		public String toString() {
			return "BookModel [id=" + bookId + ", title=" + title + ", author=" + author + "]";
		}


	    /*INSERT INTO BOOK (book_id,author,on_loan,title)
VALUES (1,'hello','yes', 'world');
	     * */
}
