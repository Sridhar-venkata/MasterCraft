package com.mastercraft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mastercraft.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {
	
	@Query("SELECT u.address FROM User u WHERE u.userId=:userId")
	List<Address> findByUserId(int userId);

}
