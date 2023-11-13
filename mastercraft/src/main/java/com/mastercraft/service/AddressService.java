package com.mastercraft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mastercraft.dao.AddressDao;
import com.mastercraft.dao.UserDao;
import com.mastercraft.dto.ResponseStructure;
import com.mastercraft.entity.Address;
import com.mastercraft.entity.User;
import com.mastercraft.exception.NoSuchAddressFoundException;
import com.mastercraft.exception.NoSuchUserFoundException;
import com.mastercraft.util.UserRole;

@Service
public class AddressService {
	
	@Autowired
	public AddressDao addressDao;
	@Autowired
	public UserDao userDao;
	
	public ResponseEntity<ResponseStructure<Address>> saveAddress(int userId,Address address) {
		
		User existinguser=userDao.findUserById(userId);
		if(existinguser!=null && existinguser.getRole().equals(UserRole.CUSTOMER)) {
			address=addressDao.saveOrUpdateAddress(address);
			
			ResponseStructure<Address> responseStructure=new ResponseStructure<Address>(HttpStatus.CREATED.value(),"success",address);
			
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.CREATED);
			
		}
		else throw new NoSuchUserFoundException("No Such User Found with Id:"+userId);
	}
	
	public ResponseEntity<ResponseStructure<Address>> updateAddress(Address address) {
		
		Address existingAddress=addressDao.saveOrUpdateAddress(address);
		
		if(existingAddress!=null) {
			ResponseStructure<Address> responseStructure=new ResponseStructure<Address>(HttpStatus.OK.value(),"success",address);
			
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.OK);
		}
		else {
			throw new NoSuchAddressFoundException("No Such Address Found with Id:"+address.getAddressId());
		}
		
	}
	
	public ResponseEntity<ResponseStructure<Address>> deleteAddress(int addressId) {
		
		Address address=addressDao.findAddressById(addressId);

		if(address!=null) {
			ResponseStructure<Address> responseStructure=new ResponseStructure<Address>(HttpStatus.NO_CONTENT.value(),"success",address);
			
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.NO_CONTENT);
		}
		else {
			throw new NoSuchAddressFoundException("No Such Address Found with Id:"+addressId);
		}
		
		
	}
	
	public ResponseEntity<ResponseStructure<Address>> findAddressById(int addressId) {
		Address address=addressDao.findAddressById(addressId);

		if(address!=null) {
			ResponseStructure<Address> responseStructure=new ResponseStructure<Address>(HttpStatus.FOUND.value(),"success",address);
			
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.FOUND);
		}
		else {
			throw new NoSuchAddressFoundException("No Such Address Found with Id:"+addressId);
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Address>>> findAddressByUserId(int userId) {
		List<Address> address=addressDao.findAddressByUserId(userId);

		if(address!=null) {
			ResponseStructure<List<Address> > responseStructure=new ResponseStructure<List<Address>>(HttpStatus.FOUND.value(),"success",address);
			
			return new ResponseEntity<ResponseStructure<List<Address>>>(responseStructure,HttpStatus.FOUND);
		}
		else {
			throw new NoSuchAddressFoundException("No Such Address Found with Id:"+userId);
		}
		
	}
}
