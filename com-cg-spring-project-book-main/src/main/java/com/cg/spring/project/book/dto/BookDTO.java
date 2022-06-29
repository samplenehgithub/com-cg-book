package com.cg.spring.project.book.dto;

import com.cg.spring.project.book.model.Author;

public class BookDTO {
	private int bookId;
	private String bookName;
	private double price;
	private Author author;
	private String category;
	private float rating;
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	
	public BookDTO() {
		
	}
	public BookDTO(int bookId, String bookName, double price, Author author, String category, float rating) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.price = price;
		this.author = author;
		this.category = category;
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "BookDto [bookId=" + bookId + ", bookName=" + bookName + ", price=" + price + ", author=" + author
				+ ", category=" + category + ", rating=" + rating + "]";
	}

	

}
