package net.codejava.springmvc.dao;

import java.util.List;

import net.codejava.springmvc.model.User;

public interface UserDAO 
{
	public void insert(User user);
	public User findByCustomerId(String Email);
	public List<User> findCustomers(int ID);
	public List<User> findUserByEmail(String Email);
}
