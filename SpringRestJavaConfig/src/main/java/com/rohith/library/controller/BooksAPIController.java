package com.rohith.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.rohith.library.model.Book;
import com.rohith.library.service.BooksService;

/**
 * 
 * Main Controller class that handles ReST requests for Books API.
 * 
 * @author rohith
 *
 */
@RestController
public class BooksAPIController {

	@Autowired
	BooksService booksService;
	
	@RequestMapping(value="/books", method=RequestMethod.GET, 
			produces={MediaType.APPLICATION_XML_VALUE, 
					MediaType.APPLICATION_JSON_VALUE} )
	public ResponseEntity<List<Book>> getBooks()
	{
		List<Book> books = booksService.getBooks();
		
		if(books == null || books.isEmpty())
			return new ResponseEntity<List<Book>>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
	}
	
	/**
	 * Request handler for finding book by isbn.
	 * 
	 * Observe the return code when book is not found. 
	 * 
	 * When the request is for a specific book (i.e resource) and if it is not found,
	 * we can throw 404 error.
	 * 
	 * @param isbn
	 * @return
	 */
	@RequestMapping(value="/books/{isbn}", method=RequestMethod.GET, 
			produces={MediaType.APPLICATION_XML_VALUE, 
					MediaType.APPLICATION_JSON_VALUE} )
	public ResponseEntity<Book> getBookByISBN(@PathVariable("isbn") String isbn)
	{
		Book book = booksService.getBookByISBN(isbn);
		
		if(book == null)
			return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}
	
	@RequestMapping(value="/books", method=RequestMethod.POST, 
			produces={MediaType.APPLICATION_XML_VALUE, 
					MediaType.APPLICATION_JSON_VALUE} )
	public ResponseEntity<Void> addBookToTheLibrary(@RequestBody Book book, UriComponentsBuilder ucb)
	{
		
		if(book == null ||  StringUtils.isEmpty(book.getIsbn()) || 
				StringUtils.isEmpty(book.getAuthor()) || StringUtils.isEmpty(book.getName()))
		{
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		
		Book addedBook = booksService.addBook(book);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucb.path("/books/{isbn})").buildAndExpand(addedBook.getIsbn()).toUri());
		
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	
}
