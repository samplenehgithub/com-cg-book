package com.cg.spring.project.book.service;

	import java.util.List;

	import java.util.Optional;

	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

import com.cg.spring.project.book.dto.UserDTO;
import com.cg.spring.project.book.exception.UserAlreadyExistsException;
	import com.cg.spring.project.book.exception.UserNotFoundException;
import com.cg.spring.project.book.model.Book;
import com.cg.spring.project.book.model.User;
	import com.cg.spring.project.book.repository.UserRepository;

	@Service
	public abstract class UserServiceImpl implements BookService {

		private final Logger logger = LoggerFactory.getLogger(this.getClass());

		@Autowired
		private UserRepository UserRepository;

		User loggedInUser;

		public List<UserDTO> getAllUsers() {
			List<UserDTO> userList = UserRepository.findAll();
			if (userList.isEmpty()) {
				String exceptionMessage = "Users don't exist in the database.";
				logger.warn(exceptionMessage);
				throw new UserNotFoundException(exceptionMessage);
			} else {
			logger.info("List returned successfully.");
				return userList;
			}
		}

		public User registerUser(User user) {
			logger.info(user.toString());
			Optional<User> userOptional = UserRepository.findById(user.getUsername());
			if (userOptional.isEmpty()) {
				return UserRepository.save(user);
			} else {
				String exceptionMessage = "User with username " + user.getUsername() + " already exists.";
				throw new UserAlreadyExistsException(exceptionMessage);
			}
		}

		@Override
		public User loginUser(User user) {
			logger.info(user.toString());
			Optional<User> userOptional = UserRepository.findById(user.getUsername());
			if (userOptional.isPresent()) {
				if (user.equals(userOptional.get())) {
					logger.info(userOptional.get().toString());
					loggedInUser = user; // successful login
					return user;
				} else {
					String exceptionMessage = "Wrong password!";
					logger.warn(exceptionMessage);
					throw new UserNotFoundException(exceptionMessage);
				}
			} else {
				String exceptionMessage = "Wrong username!";
				logger.warn(exceptionMessage);
				throw new UserNotFoundException(exceptionMessage);
			}
		}

		public String logoutUser(String username) throws Exception {
			if (loggedInUser.getUsername().equals(username)) {

				loggedInUser = null;
				return username;
			} else {
				String exceptionMessage = "User with username " + username + " is not logged in.";
				logger.warn(exceptionMessage);
				throw new Exception(exceptionMessage);
			}
		}

		public User updateUser(User user) {
			Optional<User> userOptional = UserRepository.findById(User.getUserid());
			if (userOptional.isPresent()) {
				logger.info(userOptional.get().toString());
				return UserRepository.save(user);
			} else {
				String exceptionMessage = "User with username " +User.getUsername() + " not found!";
				logger.warn(exceptionMessage);
				throw new UserNotFoundException(exceptionMessage);
			}
		}

		
		
	}

