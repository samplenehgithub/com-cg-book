package com.cg.spring.project.book.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.spring.project.book.model.Book;
import com.cg.spring.project.book.service.UserService;

@RestController
@RequestMapping("/book")
@CrossOrigin(origins = "*")
//@CrossOrigin(origins = "http://localhost:7777")
public class UserController {

	// Use ResponseEntity to all the methods in controller classes.

	@Autowired
	private UserService userService;

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	// http://localhost:9999/emp/get-all-emps
	@GetMapping("/get-all-book")
	public ResponseEntity<List<Book>> getAllBooks() {
		List<Book> bookList = userService.getAllBooks();
		for (Book bookTemp : bookList)
			LOG.info(bookTemp.toString());
		HttpStatus status = HttpStatus.OK;
		ResponseEntity<List<Book>> response = new ResponseEntity<>(HttpStatus.OK);
		return response;
	}

	// http://localhost:7777/emp/get-book-by-id/{userid}
	@GetMapping("/get-user-by-id/{userid}")
	public ResponseEntity<Book> getById(@PathVariable(name = "userid") int userid) {
		LOG.info(Integer.toString(userid));
		Book book = userService.getUserById(userid);
		HttpStatus status = HttpStatus.OK;
		ResponseEntity<Book> response = new ResponseEntity<>(HttpStatus.OK);
		return response;
	}

	// http://localhost:9999/emp/get-emp-by-name/{firstName}
	@GetMapping("/get-book-by-name/{Name}")
	public ResponseEntity<List<Book>> getBookByName(@PathVariable(name = "Name") String Name) {
		LOG.info(Name);
		HttpStatus status = HttpStatus.OK;
		ResponseEntity<List<Book>> response = new ResponseEntity<>(HttpStatus.OK);
				
		return response;
	}
}
