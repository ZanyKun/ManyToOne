package com.java.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

//Entity class: corresponding to which you should have a table in db
@Entity
@Data
@NoArgsConstructor
@Table(name = "user_info")
public class UserInfo {
	
		@Id //primary key column
		private int id;
		@Column(name = "name")
		private String username;
		private String password;
		
		@ElementCollection
		@OrderColumn
		List<String> phoneNumbers;
		
		@ManyToOne
		Address address;
		
		public UserInfo(int id, String username, String password, List<String> phoneNumbers, Address address) {
			this.id = id;
			this.username = username;
			this.password = password;
			this.phoneNumbers = phoneNumbers;
			this.address = address;
		}
		
		
		/*//Value object
		@Embedded
		@AttributeOverrides({@AttributeOverride(name="hno", column=@Column(name="office_no")),
			@AttributeOverride(name="street", column=@Column(name="office_street")),
			@AttributeOverride(name="city", column=@Column(name="office_city")),
			@AttributeOverride(name="state", column=@Column(name="office_state"))})
		private Address officeAddress; //ono city street
		
		@Embedded
		@AttributeOverrides({@AttributeOverride(name="hno", column=@Column(name="house_no")),
			@AttributeOverride(name="street", column=@Column(name="house_street")),
			@AttributeOverride(name="city", column=@Column(name="house_city")),
			@AttributeOverride(name="state", column=@Column(name="house_state"))})
		private Address houseAddress; //hno hcity hstreet
		public UserInfo(String username, String password, Address officeAddress, Address houseAddress){
			this.username = username;
			this.password = password;
			this.officeAddress = officeAddress;
			this.houseAddress = houseAddress;*/
		}

//Every entity should have primary key: Database normalization: 1st rule
//You should be able to uniquely identify a row in a db