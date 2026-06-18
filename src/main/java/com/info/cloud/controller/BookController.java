package com.info.cloud.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.info.cloud.dto.BookRequestDto;
import com.info.cloud.dto.BookResponceDto;
import com.info.cloud.service.BookService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/books")
public class BookController {
	 private final BookService service;

	    public BookController(BookService service) {
	        this.service = service;
	    }
	    @Operation(summary = "Create a new book")
	    @PostMapping
	    public BookResponceDto saveBook(
	           @Valid  @RequestBody BookRequestDto dto) {

	        return service.saveBook(dto);
	    }
	    @Operation(summary = "Get all books")
	    @GetMapping
	    public List<BookResponceDto> getAllBooks() {

	        return service.getAllBooks();
	    }

	    @GetMapping("/{id}")
	    public BookResponceDto getBookById(
	            @PathVariable Long id) {

	        return service.getBookById(id);
	    }

	    @PutMapping("/{id}")
	    public BookResponceDto updateBook(
	            @PathVariable Long id,
	            @RequestBody BookRequestDto dto) {

	        return service.updateBook(id, dto);
	    }

	    @DeleteMapping("/{id}")
	    public String deleteBook(
	            @PathVariable Long id) {

	        service.deleteBook(id);

	        return "Book Deleted Successfully";
	    }
	    @GetMapping("/title/{title}")
	    public List<BookResponceDto>
	    searchByTitle(@PathVariable String title) {

	        return service.findByTitle(title);
	    }

	    @GetMapping("/category/{category}")
	    public List<BookResponceDto>
	    searchByCategory(@PathVariable String category) {

	        return service.findByCategory(category);
	    }
	    @GetMapping("/page")
	    public Page<BookResponceDto> getBooksWithPagination(

	            @RequestParam(defaultValue = "0")
	            int page,

	            @RequestParam(defaultValue = "5")
	            int size) {

	        return service.getAllBooks(page, size);
	    }
	    @GetMapping("/sort")
	    public List<BookResponceDto> sortBooks(

	            @RequestParam String field) {

	        return service.sortBooks(field);
	    }
	   

}
