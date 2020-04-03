package com.java.dao;

import java.util.List;

import org.hibernate.Session;

import com.java.dto.Address;

public class AddressRepositoryImpl implements AddressRepository{
	@Override
	public int insert(Address a) {
		Session s = DbUtil.openSession();// connection
		s.beginTransaction();
		int id=(int) s.save(a);//save user object, return primary key
		s.getTransaction().commit();
		s.close();
		return id;
	}

	@Override
	public boolean update(Address a) {
		Session s = DbUtil.openSession();// connection
		s.beginTransaction();
		try {
		 s.update(a);//save user object, return primary key
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		s.getTransaction().commit();
		s.close();
		return true;
	}

	@Override
	public boolean delete(int id) {
		Session s = DbUtil.openSession();// connection
		s.beginTransaction();
		try {
		 s.delete(id);//save user object, return primary key
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		s.getTransaction().commit();
		s.close();
		return true;
	}

	@Override
	public Address getById(int id) {
		Session s = DbUtil.openSession();// connection
		s.beginTransaction();
		Address address= s.get(Address.class, id);
		s.close();
		return address;
	}

	@Override
	public List<Address> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}
