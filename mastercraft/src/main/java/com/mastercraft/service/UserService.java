package com.mastercraft.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mastercraft.dao.UserDao;
import com.mastercraft.dto.ResponseStructure;
import com.mastercraft.entity.User;
import com.mastercraft.exception.NoSuchUserFoundException;
import com.mastercraft.exception.UserAlreadyExistException;
import com.mastercraft.util.UserRole;

@Service
public class UserService {

	@Autowired
	private UserDao dao;

	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {

		Optional<User> optionalUser = dao.findAllUsers().stream()
				.filter(u -> u.getEmail().equals(user.getEmail()) || u.getPhoneNumber() == user.getPhoneNumber())
				.findAny();

		if (!optionalUser.isEmpty())
			throw new UserAlreadyExistException("Email or Phone Number already in use.");

		User existinguser = dao.saveOrUpdateUser(user);

		ResponseStructure<User> rs = new ResponseStructure<User>(HttpStatus.CREATED.value(), "Success", existinguser);

		return new ResponseEntity<ResponseStructure<User>>(rs, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<User>> updateUser(User user) {

		final User userInput = user;

		Optional<User> optionalUser = dao.findAllUsers().stream().filter(
				u -> u.getEmail().equals(userInput.getEmail()) || u.getPhoneNumber() == userInput.getPhoneNumber())
				.findAny();

		if (optionalUser.isEmpty())
			throw new NoSuchUserFoundException("User not found.");

		user = dao.saveOrUpdateUser(user);

		ResponseStructure<User> rs = new ResponseStructure<User>(HttpStatus.OK.value(), "Success", user);

		return new ResponseEntity<ResponseStructure<User>>(rs, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<User>> findById(int userId) {
		User user = dao.findUserById(userId);

		if (user == null)
			throw new NoSuchUserFoundException("Invalid user ID");

		ResponseStructure<User> rs = new ResponseStructure<User>(HttpStatus.OK.value(), "Success", user);

		return new ResponseEntity<ResponseStructure<User>>(rs, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Boolean>> deleteUserById(int userId) {

		User user = dao.findUserById(userId);

		if (user == null)
			throw new NoSuchUserFoundException("Invalid user ID");

		dao.deleteUser(user);

		ResponseStructure<Boolean> rs = new ResponseStructure<Boolean>(HttpStatus.OK.value(), "Success", true);

		return new ResponseEntity<ResponseStructure<Boolean>>(rs, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<List<User>>> findAllUsers() {

		List<User> users = dao.findAllUsers();

		if (users == null || users.isEmpty())
			throw new NoSuchUserFoundException("No user found");

		ResponseStructure<List<User>> rs = new ResponseStructure<List<User>>(HttpStatus.OK.value(), "Success", users);

		return new ResponseEntity<ResponseStructure<List<User>>>(rs, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<List<User>>> findByRole(UserRole role) {
		List<User> users = dao.findUserByRole(role);

		if (users == null || users.isEmpty())
			throw new NoSuchUserFoundException("No user found with role : " + role);

		ResponseStructure<List<User>> rs = new ResponseStructure<List<User>>(HttpStatus.OK.value(), "Success", users);

		return new ResponseEntity<ResponseStructure<List<User>>>(rs, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<User>> findUserByPhoneAndPassword(long phone, String password) {
		
		User user = dao.findUserByPhoneNumberAndPassword(phone, password);

		if (user == null)
			throw new NoSuchUserFoundException("Invalid user phone or password");

		ResponseStructure<User> rs = new ResponseStructure<User>(HttpStatus.OK.value(), "Success", user);

		return new ResponseEntity<ResponseStructure<User>>(rs, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<User>> findUserByEmailAndPassword(String email, String password) {
		User user = dao.findUserByEmailAndPassword(email, password);

		if (user == null)
			throw new NoSuchUserFoundException("Invalid user email or password");

		ResponseStructure<User> rs = new ResponseStructure<User>(HttpStatus.OK.value(), "Success", user);

		return new ResponseEntity<ResponseStructure<User>>(rs, HttpStatus.OK);
	}

}