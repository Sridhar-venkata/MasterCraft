package com.mastercraft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mastercraft.dto.ResponseStructure;
import com.mastercraft.entity.Address;
import com.mastercraft.service.AddressService;


@RestController
@RequestMapping("/Address")
public class AddressController {
	
	@Autowired
	public AddressService addressService;
	
	@PostMapping("/save/{userId}")
	public ResponseEntity<ResponseStructure<Address>> saveAddress(int userId,Address address) {
		
		return addressService.saveAddress(userId, address);
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<ResponseStructure<Address>> updateAddress(Address address) {
		
		return addressService.updateAddress(address);
		
	}
	
	@DeleteMapping("/delete/{addressId")
	public ResponseEntity<ResponseStructure<Address>> deleteAddress(int addressId) {
		
		return addressService.deleteAddress(addressId);
		
	}
	
	@GetMapping("findAddressById/{addressId}")
	public ResponseEntity<ResponseStructure<Address>> findAddressById(int addressId) {
		
		return addressService.findAddressById(addressId);
		
	}
	
	@GetMapping("findAddressByUserId/{userId}")
	public ResponseEntity<ResponseStructure<List<Address>>> findAddressByUserId(int userId) {
		
		return addressService.findAddressByUserId(userId);
		
	}
}
