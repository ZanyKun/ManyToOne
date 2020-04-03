package com.java.client;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;

import com.java.dao.AddressRepositoryImpl;
import com.java.dao.DbUtil;
import com.java.dao.UserRepositoryImpl;
import com.java.dto.Address;
import com.java.dto.UserInfo;

//Ctrl Shift O: manage imports
public class Main {

	static UserRepositoryImpl rep = new UserRepositoryImpl();
	static AddressRepositoryImpl arep = new AddressRepositoryImpl();

	public static void main(String[] args) {
		
		Session s = DbUtil.openSession();
		s.beginTransaction();
		Address a1 = new Address(1001, 1234, "Roscoe", "Chicago", "Illinois");
		Address a2 = new Address(1002, 5678, "Convington", "St. Charles", "Illinois");
		
		s.save(a1);
		s.save(a2);
		
		List<String> phoneNums = Arrays.asList("120973", "10749872", "739739123", "17230973"); 
		UserInfo u1 = new UserInfo(1, "kevinN", "watersplash", phoneNums, a1);
		UserInfo u2 = new UserInfo(2, "jediV", "moneyman", phoneNums, a1);
		UserInfo u3 = new UserInfo(3, "marcD", "floridaboi", phoneNums, a2);
		
		s.save(u1);
		s.save(u2);
		s.save(u3);
		
		List<UserInfo> userL1 = Arrays.asList(u1, u2);
		List<UserInfo> userL2 = Arrays.asList(u3);
		
		a1.setUsers(userL1);
		a2.setUsers(userL2);
		s.getTransaction().commit();
		s.close();
	}
}
