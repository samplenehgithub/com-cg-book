package com.cg.spring.project.book.service;

import java.util.List;

import com.cg.spring.project.book.dto.UserDTO;
import com.cg.spring.project.book.model.Book;
import com.cg.spring.project.book.model.User;

public interface UserService {
	public List<UserDTO> getAllUsers();
	public User registerUser(User user);
	public User loginUser(User user);
	public String logoutUser(String username);
	public User updateUser(User user);
	public List<Book> getAllBooks();
}
