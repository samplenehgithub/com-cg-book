package com.cg.spring.project.book.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.spring.project.book.dto.BookDto;
import com.cg.spring.project.book.exception.BookNotFoundException;
import com.cg.spring.project.book.model.Book;
import com.cg.spring.project.book.repository.BookRepository;
import com.cg.spring.project.book.repository.UserRepository;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	BookRepository bookRepository;

	@Autowired
    UserRepository userRepository;

	@Autowired
	UserService userService;

	private  final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	public List<BookDto> getAllBooks() {
		logger.info("getAllBooks");
		List<Book> bookList = bookRepository.findAll();
		return bookList.stream().map(book -> new BookDto(book.getBookId(),book.getBookName(),book.getPrice(),book.getAuthor(),book.getBookName(),book.getRating()).collect(Collector.toList())));
	}

	public Book getBookById(int bookId) {
		Optional<Book> bookOptional = bookRepository.findById(bookId);
		Book book = null;
		if (bookOptional.isPresent()) {
			book =bookOptional.get();
			logger.info(book.toString());
			return book;
		} else {
			String errorMessage = "Book with id " + bookId + " does not exist.";
			logger.error(errorMessage);
			throw new BookNotFoundException(errorMessage);
		}
	}

	public List<Book> getBookByName(String name) {
		logger.info(name);
		List<Book> bookList  = bookRepository.findByNameIgnoreCase(name);
		if (null != bookList)
			return bookList;
		String errorMessage = "Book with Name " + name + " does not exist.";
		throw new BookNotFoundException(errorMessage);
	}

	public Book addBook(Book book) {
		logger.info(book.toString());
		if(book.getAuthor()!= null)
			
		authorService.getAuthorByBookName(book.getAuthor().getBookName());
	
		return bookRepository.save(book)
	}

	public Book updateBook(Book book) {
		logger.info(book.toString());
		BookServiceImpl bookService = new BookServiceImpl();
		bookService.getBookById(book.getBookId());
		
		return bookRepository.save(book);
	}

	public Book deleteBook(int id) { 
		logger.info(Integer.toString(id));
		Book bookToDelete = this.getBookById(id);
		bookRepository.delete(bookToDelete);
		return bookToDelete;
	}

}

