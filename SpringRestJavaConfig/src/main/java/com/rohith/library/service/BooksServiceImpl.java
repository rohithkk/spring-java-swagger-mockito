package com.rohith.library.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rohith.library.model.Book;

@Service
public class BooksServiceImpl implements BooksService{
	
	private List<Book> booksInLibrary;
	
	public BooksServiceImpl()
	{
		booksInLibrary = new ArrayList<Book>();
		
		booksInLibrary.add(new Book("To Kill A Mocking Bird", "Harper Lee", "123456"));
		booksInLibrary.add(new Book("Midnight's Children", "Salman Rushdie", "32323424"));
		booksInLibrary.add(new Book("Big Bang: Origin Of Universe", "Simon Singh", "1231434sdfs"));
		
	}
	
	@Override
	public Book getBookByISBN(String isbn) {
		for(Book book : booksInLibrary)
		{
			if (book.getIsbn().equalsIgnoreCase(isbn))
				return book;
			
		}
		
		return null;
	}

	@Override
	public List<Book> getBooksByName(String name) {
		List<Book> books = new ArrayList<Book>();
		
		for(Book book : booksInLibrary)
		{
			if (book.getName().contains(name))
				books.add(book);
			
		}
		return books;
	}

	@Override
	public List<Book> getBooksByAuthor(String author) {
		
		List<Book> books = new ArrayList<Book>();
		
		for(Book book : booksInLibrary)
		{
			if (book.getAuthor().contains(author))
				books.add(book);
			
		}
		return books;
	}

	@Override
	public List<Book> getBooks() {
		return booksInLibrary;
	}

	@Override
	public Book addBook(Book book) {
		booksInLibrary.add(book);
		
		return book;
	}

	@Override
	public void deleteBook(String isbn) {
		
		for(Book book : booksInLibrary)
		{
			if (book.getIsbn().equals(isbn))
				booksInLibrary.remove(book);
		}
	}

	@Override
	public Book updateBook(Book bookToUpdate) {
		for(Book book : booksInLibrary)
		{
			if (book.getIsbn().equals(bookToUpdate.getIsbn()))
			{
				booksInLibrary.remove(book);
				booksInLibrary.add(bookToUpdate);
				return bookToUpdate;
			}
		}
		return null;
	}

}
