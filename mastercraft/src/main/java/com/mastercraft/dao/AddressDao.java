package com.mastercraft.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mastercraft.entity.Address;
import com.mastercraft.repository.AddressRepository;

@Repository
public class AddressDao {
	
	@Autowired
	public AddressRepository addressRepository;
	
	public Address saveAddress(Address address) {
		
		return addressRepository.save(address);
		
	}
	
	public Address updateAddress(Address address) {
		
		return addressRepository.save(address);
		
	}
	
	public void deleteAddress(Address address) {
		
		addressRepository.delete(address);
		
	}
	
	public Address findAddressById(int addressId) {
		
		Optional<Address> optional=addressRepository.findById(addressId);
		
		return optional.isPresent()?optional.get():null;
	}
	
	public List<Address> findAddressByUserId(int userId) {
		
		return addressRepository.findByUserId(userId);
		
	}
	
	
}
