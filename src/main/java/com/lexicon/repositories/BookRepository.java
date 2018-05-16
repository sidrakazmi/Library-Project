package com.lexicon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lexicon.models.BookModel;

public interface BookRepository extends JpaRepository<BookModel, Long> {
	
}
