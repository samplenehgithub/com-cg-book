package com.cg.spring.project.book.service;

import java.util.List;

import com.cg.spring.project.book.dto.BookDTO;
import com.cg.spring.project.book.model.Book;

public interface BookService {
	public List<BookDTO> getAllBooks();
	public Book getBookById(int bookId);
	public List<Book> getBookByName(String Name);
	public Book addBook(Book book);
	public Book updateBook(Book book);
	public Book deleteBook(int id);

}
