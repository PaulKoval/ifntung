package net.codejava.springmvc.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.codejava.springmvc.model.Customer;

public interface CustomerDAO 
{
	public void insert(Map<String, String> HashMap);
	public void delete(int ID);
	public void update(HashMap<String,String> HashMap);
	public List<Customer> findCustomers(int limit, int offset);
	public int countCustomers();
	public Map<String,String> findCurrentCustomerById(int ID);
	public List<Customer> searchCustomers(String sql);
	public Map<Integer, HashMap<String,String>> SQLquery(String sqlQuery);
	public void unjoinCustomer(String sql);
}
