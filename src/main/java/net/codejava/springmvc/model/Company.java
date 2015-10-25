package net.codejava.springmvc.model;

import java.sql.Timestamp;

public class Company 
{
	
	int ID;
	String name;
	String industry;
	String country;
	
	public Company() {
		
	}

	public Company(int ID, String Name, String Industry, String Country) {
		this.ID = ID;
		this.name = Name;
		this.industry = Industry;
		this.country = Country;
	}
	
	public int getID() {
		return ID;
	}


	public void setID(int iD) {
		this.ID = iD;
	}


	public String getName() {
		return name;
	}


	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getIndustry() {
		return industry;
	}


	public void setIndustry(String industry) {
		this.industry = industry;
	}

	
	
	
}
