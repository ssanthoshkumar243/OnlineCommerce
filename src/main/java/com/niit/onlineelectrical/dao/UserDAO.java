package com.niit.onlineelectrical.dao;

import java.util.List;

import com.niit.onlineelectrical.model.User;

public interface UserDAO {
	public List<User>list();
	public User get(String id);
	public User validate(String id, String password);
	public boolean save(User user);
	public boolean update (User user);
}
