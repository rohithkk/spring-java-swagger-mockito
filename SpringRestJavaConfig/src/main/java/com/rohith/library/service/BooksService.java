package com.rohith.library.service;

import java.util.List;

import com.rohith.library.model.Book;

public interface BooksService {

	public List<Book> getBooks();
	public Book getBookByISBN(String isbn);
	public List<Book> getBooksByName(String name);
	public List<Book> getBooksByAuthor(String name);
	public Book addBook(Book book);
	public void deleteBook(String isbn);
	public Book updateBook(Book book);
}
