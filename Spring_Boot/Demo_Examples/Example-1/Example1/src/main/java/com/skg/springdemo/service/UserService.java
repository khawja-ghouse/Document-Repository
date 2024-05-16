package com.skg.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skg.springdemo.dao.UserDao;
import com.skg.springdemo.model.User;
import com.skg.springdemo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	private UserDao userDao;

	public UserService(UserDao userDao) {
		this.userDao = userDao;
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User getUserById(Long id) {
		return userRepository.findById(id).orElse(null);
	}

	public User createUser(User user) {
		return userRepository.save(user);
	}

	public User updateUser(Long id, User user) {
		if (userRepository.existsById(id)) {
			user.setUserId(id);
			return userRepository.save(user);
		}
		return null;
	}

	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

}
