package com.cg.spring.project.book.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.spring.project.book.dto.BookDTO;
import com.cg.spring.project.book.model.Book;
import com.cg.spring.project.book.service.BookServiceImpl;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
	public class BookController {

		
		@Autowired
		 BookServiceImpl bookservice;
		
		@GetMapping("/books")
		public ResponseEntity<List<BookDTO>> getBooks(){
			
		   List<BookDTO> list=bookservice.getAllBooks();	
		   if(list.size()<=0) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			return ResponseEntity.of(Optional.of(list)) ;
		}
		
		
		@GetMapping("/book/{id}")
		public ResponseEntity<Book> getBookByid(@PathVariable("id")int id) {
			Book book=bookservice.getBookById(id);
			if(book==null) {
				return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			return ResponseEntity.of(Optional.of(book));
		}
		
		@PostMapping("/books")
		public ResponseEntity<BookDTO> addBook(@RequestBody Book book) {
			Book book1 =bookservice.addBook(book);
			if(book!=null) {
				return ResponseEntity.status(HttpStatus.OK).build();
			}
			System.out.println(book);
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
		}
		
		@DeleteMapping("/books/{id}")
		public ResponseEntity<Book> deleteBook(@PathVariable("id") int id) {
			try {
			   bookservice.deleteBook(id);		
			   return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
				}catch(Exception e) {
					e.printStackTrace();
			return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		}
		@PutMapping("/books/{id}")
		public ResponseEntity<Book> updateBook(@RequestBody Book book,@PathVariable("id") int id) {
			
			Book book1=bookservice.updateBook(book);
			if(book1!=null) {
				return ResponseEntity.status(HttpStatus.OK).body(book);
			}
			return ResponseEntity.status(HttpStatus.NON_AUTHORITATIVE_INFORMATION).build();
		}

}
