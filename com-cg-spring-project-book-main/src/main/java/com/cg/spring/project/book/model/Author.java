package com.cg.spring.project.book.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "author")
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "author_id")
	private int authorid;

	@Column(name = "author_name")
	private String authorName;

	@Column(name = "category")
	private String category;
    
	@ManyToMany(mappedBy = "author")
	private List<Book> books = new ArrayList<>();
	public Author() {
		super();
	}

	

	public Author(int authorid, String authorName, String category, List<Book> books) {
		super();
		this.authorid = authorid;
		this.authorName = authorName;
		this.category = category;
		this.books = books;
	}



	
	public int getAuthorid() {
		return authorid;
	}



	public void setAuthorid(int authorid) {
		this.authorid = authorid;
	}



	public List<Book> getBooks() {
		return books;
	}



	public void setBooks(List<Book> books) {
		this.books = books;
	}



	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}



	@Override
	public String toString() {
		return "Author [authorid=" + authorid + ", authorName=" + authorName + ", category=" + category + ", books="
				+ books + "]";
	}



	public String getBookName() {
		// TODO Auto-generated method stub
		return null;
	}



}
