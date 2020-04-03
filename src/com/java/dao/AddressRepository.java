package com.java.dao;

import java.util.List;

import com.java.dto.Address;

public interface AddressRepository {
		public int insert(Address a);
		public boolean update(Address a);
		public boolean delete(int id);
		public Address getById(int id);
		public List<Address> getAllUsers();
}