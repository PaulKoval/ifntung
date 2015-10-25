package net.codejava.springmvc.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.codejava.springmvc.model.Company;

public interface CompanyDAO 
{
	public void insert(Company company);
	public void delete(int ID);
	public void deleteManual(String sql);
	//public void update(Company company);
	public void update(String updateSQL);
	public void insertUser(String user);
	public Company findByCompanyId(int custId);
	public List<Company> findCompany(int limit, int offset);
	public int countCompany();
	public Map<String,String> findCurrentCompanyById(int ID);
	public List<Company> searchCompany(String sql);
}
