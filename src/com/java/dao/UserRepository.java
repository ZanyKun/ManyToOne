package com.java.dao;

import java.util.List;

import com.java.dto.UserInfo;

public interface UserRepository {

		public int insert(UserInfo u);
		public boolean update(UserInfo u);
		public boolean delete(int id);
		public UserInfo getById(int id);
		public List<UserInfo> getAllUsers();
}
