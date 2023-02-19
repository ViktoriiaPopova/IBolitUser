package com.ibolit.ibolituser.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user")
public class SimpleUser {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idUser")
	private Integer idUser;
	@Column(name="name", length=50, nullable=false, unique=false)
	private String name;
	@Column(name="surname", length=50, nullable=false, unique=false)
	private String surname;
	@Column(name="country", length=50, nullable=false, unique=false)
	private String country;
	@Column(name="city", length=50, nullable=false, unique=false)
	private String city;
	@Column(name="address", length=50, nullable=false, unique=false)
	private String address;
	@Column(name="email", length=50, nullable=false, unique=false)
	private String email;
	@Column(name="username", length=50, nullable=false, unique=false)
	private String userName;
	@Column(name="password", length=50, nullable=false, unique=false)
	private String password;
	@Column(name="role", nullable=true, unique=false)
	private String role;
	
	public SimpleUser(String name,String surname,String country, String city, String address,String email, String userName, String password,String role) {

		this.name = name;
		this.surname = surname;
		this.country = country;
		this.city = city;
		this.address = address;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.role = role;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "SimpleUser [name =" + name + ", password =" + password + "]";
	}
	 
	}
