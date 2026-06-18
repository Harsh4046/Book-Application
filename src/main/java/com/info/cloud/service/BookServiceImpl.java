package com.info.cloud.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.info.cloud.Entity.Book;
import com.info.cloud.Exception.BookNotFoundException;
import com.info.cloud.dto.BookRequestDto;
import com.info.cloud.dto.BookResponceDto;
import com.info.cloud.repo.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	private final BookRepository repository;
	private static final Logger logger =
	        LoggerFactory.getLogger(BookServiceImpl.class);

	public BookServiceImpl(BookRepository repository) {
		this.repository = repository;
	}

	@Override
	public BookResponceDto saveBook(BookRequestDto dto) {
		 logger.info("Saving book {}", dto.getTitle());

		Book book = new Book();

		book.setTitle(dto.getTitle());
		book.setAuthor(dto.getAuthor());
		book.setPrice(dto.getPrice());
		book.setCategory(dto.getCategory());

		Book savedBook = repository.save(book);
		 logger.info("Book saved successfully with id {}",
	                savedBook.getId());

		return new BookResponceDto(savedBook.getId(), savedBook.getTitle(), savedBook.getAuthor(), savedBook.getPrice(),
				savedBook.getCategory());
	}

	@Override
	public List<BookResponceDto> getAllBooks() {

		return repository.findAll().stream()
				.map(book -> new BookResponceDto(book.getId(), book.getTitle(), book.getAuthor(), book.getPrice(),
						book.getCategory()))
				.toList();
	}

	@Override
	public BookResponceDto getBookById(Long id) {
		logger.info("Fetching book with id {}", id);

		Book book = repository.findById(id)
		          .orElseThrow(
		                  () -> new BookNotFoundException(
		                      "Book not found with id : " + id
		                  )
		              );

		return new BookResponceDto(book.getId(), book.getTitle(), book.getAuthor(), book.getPrice(),
				book.getCategory());
	}

	@Override
	public void deleteBook(Long id) {
	    logger.info("Deleting book with id {}", id);
		repository.findById(id)
        .orElseThrow(
                () -> new BookNotFoundException(
                    "Book not found with id : " + id
                )
            );
	}

	@Override
	public BookResponceDto updateBook(Long id, BookRequestDto dto) {
		logger.info("Updating book with id {}", id);

		Book book = repository.findById(id)
		          .orElseThrow(
		                  () -> new BookNotFoundException(
		                      "Book not found with id : " + id
		                  )
		              );
		

		book.setTitle(dto.getTitle());
		book.setAuthor(dto.getAuthor());
		book.setPrice(dto.getPrice());
		book.setCategory(dto.getCategory());

		Book updated = repository.save(book);

		return new BookResponceDto(updated.getId(), updated.getTitle(), updated.getAuthor(), updated.getPrice(),
				updated.getCategory());
	}

	@Override
	public List<BookResponceDto> findByTitle(String title) {
		  logger.info("Searching books by title {}", title);
		// TODO Auto-generated method stub
		  return repository
	            .findByTitleContainingIgnoreCase(title)
	            .stream()
	            .map(this::convertToDTO)
	            .toList();
	}
	 // Helper Method
    private BookResponceDto convertToDTO(Book book) {

        return new BookResponceDto(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getPrice(),
                book.getCategory()
        );
    }

	@Override
	public List<BookResponceDto> findByCategory(String category) {
		   logger.info("Searching books by category {}", category);
		// TODO Auto-generated method stub
		  return repository
		            .findByCategoryIgnoreCase(category)
		            .stream()
		            .map(this::convertToDTO)
		            .toList();
	}
	@Override
	public Page<BookResponceDto> getAllBooks(
	        int page,
	        int size) {

	    Pageable pageable =
	            (Pageable) PageRequest.of(page, size);

	    Page<Book> books =
	            repository.findAll(pageable);

	    return books.map(this::convertToDTO);
	}
	
	@Override
	public List<BookResponceDto>
	sortBooks(String field) {

	    return repository
	            .findAll(Sort.by(field))
	            .stream()
	            .map(this::convertToDTO)
	            .toList();
	}
}
