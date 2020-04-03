package com.java.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
	
	@Id
	int houseId;
	int hno;
	String street;
	String city;
	String state;
	
	@OneToMany
	List<UserInfo> users;
	
	public Address(int houseId, int hno, String street, String city, String state) {
		this.houseId = houseId;
		this.hno = hno;
		this.street = street;
		this.city = city;
		this.state = state;
	}
}
