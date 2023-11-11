package com.mastercraft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mastercraft.entity.User;
import com.mastercraft.util.UserRole;

public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("SELECT u FROM User u WHERE u.email=:email AND u.password=:password")
	User findByEmailAndPassword(String email, String password);
	
	@Query("SELECT u FROM User u WHERE u.role=?1")
	List<User> findByRole(UserRole role);

	@Query("SELECT u FROM User u WHERE u.phoneNumber=:phoneNumber AND u.password=:password")
	User findByPhoneNumberAndPassword(long phoneNumber, String password);

}
