package com.mastercraft.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mastercraft.entity.User;
import com.mastercraft.repository.UserRepository;

@Repository
public class UserDao {

	@Autowired
	private UserRepository userRepository;

	public User findUserById(int userId) {
		Optional<User> optional = userRepository.findById(userId);
		return optional.isPresent() ? optional.get() : null;
	}

	public User findUserByEmailAndPassword(String email, String password) {
		return userRepository.findByEmailAndPassword(email, password);
	}

}
