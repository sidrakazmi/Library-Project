package com.lexicon.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Entity
@Table(name = "books")
public class BookModel implements Serializable {
	
		@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;

	    @NotNull
	    @Column(name="Title")
	    private String title;

	    @NotNull
	    @Column(name="Author")
	    private String author;

			    
	    public BookModel() {}

		public BookModel(Long id, @NotNull String title, @NotNull String author) {
			super();
			this.id = id;
			this.title = title;
			this.author = author;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
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
			return "BookModel [id=" + id + ", title=" + title + ", author=" + author + "]";
		}

}
