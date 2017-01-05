package com.niit.onlineelectrical.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Table
@Component
public class User  {
	@Id
	private String id;
	private String name;
	private String password;
	private String mail;
	private String role;
	private String contact;
	
}
