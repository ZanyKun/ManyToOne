package com.java.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DbUtil {
	static SessionFactory sf= null;
	static {
		Configuration cfg= new Configuration();
		cfg.configure("hibernate-properties.xml");//validate ur xml
		sf= cfg.buildSessionFactory();// pool of connections; points to one database. schema update/create happens at this time.
	}
	public static Session openSession() {
		return sf.openSession();
	}
}
