package com.info.cloud.dto;

public class BookResponceDto {

	private Long id;
	private String title;
	private String author;
	private Double price;
	private String category;

	public BookResponceDto() {
    }

	public BookResponceDto(Long id, String title,
                           String author,
                           Double price,
                           String category) {

        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.category = category;
    }

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public Double getPrice() {
		return price;
	}

	public String getCategory() {
        return category;
    }
}
