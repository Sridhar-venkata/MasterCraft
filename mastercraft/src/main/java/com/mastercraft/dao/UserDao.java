package com.mastercraft.dao;



import java.util.Optional;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mastercraft.entity.User;
import com.mastercraft.repository.UserRepository;
import com.mastercraft.util.UserRole;

@Repository
public class UserDao {

	@Autowired
	private UserRepository userRepository;

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public User updateUser(User user) {
		return userRepository.save(user);
	}

	public User findUserById(int userId) {
		Optional<User> optional = userRepository.findById(userId);
		return optional.isPresent() ? optional.get() : null;
	}

	public User findUserByEmailAndPassword(String email, String password) {
		return userRepository.findByEmailAndPassword(email, password);
	}

	public List<User> findUserByRole(UserRole role) {
		return userRepository.findByRole(role);
	}

	public User findUserByPhoneNumberAndPassword(long phoneNumber, String password) {
		return userRepository.findByPhoneNumberAndPassword(phoneNumber, password);
	}

	public boolean deleteUserById(int userId) {		
		Optional<User> optional = userRepository.findById(userId);
		if (optional.isPresent()) {
			userRepository.delete(optional.get());
			return true;
		}
		return false;
	}

}
