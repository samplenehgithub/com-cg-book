package com.cg.spring.project.book.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.spring.project.book.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer>
{
	public Book FindBookByName(String name);
	
	
  // @Query("select u from Book u where u.id = : id")
	public Book findBookById(int id);


	
	//public List<Book> findByNameIgnoreCase(String name);


	
}
