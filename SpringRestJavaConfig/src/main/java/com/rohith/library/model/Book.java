package com.rohith.library.model;

public class Book {

	private Long id;
	private String name;
	private String author;
	private String isbn;
	
	
	public Book(String name, String author, String isbn) {
		super();
		this.name = name;
		this.author = author;
		this.isbn = isbn;
	}
	
	public Book()
	{
		super();
	}

	public String getName() {
		return name;
	}

	public String getAuthor() {
		return author;
	}

	public String getIsbn() {
		return isbn;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}	
	
}
