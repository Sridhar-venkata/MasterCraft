package com.mastercraft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mastercraft.dto.ResponseStructure;
import com.mastercraft.entity.User;
import com.mastercraft.service.UserService;
import com.mastercraft.util.UserRole;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/user")
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user){
		return userService.saveUser(user);
	}
	
	@PutMapping("/user")
	public ResponseEntity<ResponseStructure<User>> updateUser(@RequestBody User user){
		return userService.updateUser(user);
	}
	
	@DeleteMapping("/user")
	public ResponseEntity<ResponseStructure<Boolean>> deleteUserById(@RequestParam int userId){
		return userService.deleteUserById(userId);
	}
	
	@GetMapping("/userid/{id}")
	public ResponseEntity<ResponseStructure<User>> findUserById(@PathVariable int userId){
		return userService.findById(userId);
	}
	
	@GetMapping("/userrole/{role}")
	public ResponseEntity<ResponseStructure<List<User>>> findUserByRole(@PathVariable UserRole role){
		return userService.findByRole(role);
	}
	
	@GetMapping("/user")
	public ResponseEntity<ResponseStructure<User>> findUserByEmailAndPassword(@RequestHeader String email,@RequestHeader String password){
		return userService.findUserByEmailAndPassword(email, password);
	}
	
	@GetMapping("/users")
	public ResponseEntity<ResponseStructure<List<User>>> findAllUsers(){
		return userService.findAllUsers();
	}
}
