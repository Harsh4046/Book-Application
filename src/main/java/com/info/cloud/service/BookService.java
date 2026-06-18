package com.info.cloud.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.info.cloud.dto.BookRequestDto;
import com.info.cloud.dto.BookResponceDto;

public interface BookService {
	BookResponceDto saveBook(BookRequestDto dto);

	List<BookResponceDto> getAllBooks();

	BookResponceDto getBookById(Long id);

	void deleteBook(Long id);

	BookResponceDto updateBook(Long id, BookRequestDto dto);

	List<BookResponceDto> findByTitle(String title);

	List<BookResponceDto> findByCategory(String category);

	Page<BookResponceDto> getAllBooks(int page, int size);

	 List<BookResponceDto> sortBooks(String field);

}
