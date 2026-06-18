package com.info.cloud.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.info.cloud.Entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
	 List<Book> findByTitleContainingIgnoreCase(String title);

	    List<Book> findByCategoryIgnoreCase(String category);
	

}
