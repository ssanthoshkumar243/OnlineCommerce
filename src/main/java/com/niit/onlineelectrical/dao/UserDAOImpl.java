package com.niit.onlineelectrical.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.onlineelectrical.model.User;
@Repository
public class UserDAOImpl implements UserDAO{

	@Autowired
	public SessionFactory sessionFactory;
	
	
	public UserDAOImpl (SessionFactory sessionFactory)
	{
	this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public List<User> list() {
		String hql="from User";
		Query query = sessionFactory.getCurrentSession().createQuery(hql); 
		return query.list();
	}
	

	@Transactional
	public User get(String id) {
		return(User) sessionFactory.getCurrentSession().get(User.class, id);
		
	}
	@Transactional
	public User validate(String id, String password) 
	{
		String hql="from user where id='"+id+"' and password='"+password+"'";
		Query query= getCurrentSession().createQuery(hql);
		query.uniqueResult();
		return null;
	}
	@Transactional
	public boolean save(User user) {
		// TODO Auto-generated method stub
		try{
			sessionFactory.getCurrentSession().save(user);
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		return false;
		}
		return true;
	}
	@Transactional
	public boolean update(User user) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(user);
		return false;
	}

}
