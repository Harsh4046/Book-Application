package com.info.cloud.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class BookRequestDto {
	 @NotBlank(message = "Title cannot be empty")
	 private String title;
	 @NotBlank(message = "Author cannot be empty")
	    private String author;
	 @Positive(message = "Price must be greater than 0")
	    private Double price;
	 @NotBlank(message = "Category cannot be empty")
	    private String category;

	    public BookRequestDto() {
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

	    public Double getPrice() {
	        return price;
	    }

	    public void setPrice(Double price) {
	        this.price = price;
	    }

	    public String getCategory() {
	        return category;
	    }

	    public void setCategory(String category) {
	        this.category = category;
	    }

}
