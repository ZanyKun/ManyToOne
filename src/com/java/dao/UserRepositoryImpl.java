package com.java.dao;

import java.util.List;
import org.hibernate.Session;
import com.java.dto.UserInfo;

public class UserRepositoryImpl implements UserRepository {
	@Override
	public int insert(UserInfo u) {
		Session s=DbUtil.openSession();// connection
		s.beginTransaction();
		int id=(int) s.save(u);//save user object, return primary key
		s.getTransaction().commit();
		s.close();
		return id;
	}

	@Override
	public boolean update(UserInfo u) {
		Session s=DbUtil.openSession();// connection
		s.beginTransaction();
		try {
		 s.update(u);//save user object, return primary key
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
		Session s=DbUtil.openSession();// connection
		s.beginTransaction();
		try {
		 s.delete(s.get(UserInfo.class, id));//save user object, return primary key
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
		s.getTransaction().commit();
		s.close();
		return true;
	}

	@Override
	public UserInfo getById(int id) {
		Session s=DbUtil.openSession();// connection
		s.beginTransaction();
		UserInfo user= s.get(UserInfo.class, id);
		s.close();
		return user;
	}

	@Override
	public List<UserInfo> getAllUsers() {
		return null;
	}

}
