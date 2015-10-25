package net.codejava.springmvc.model;

import java.sql.Timestamp;

public class Customer 
{
	int custId;
	String name;
	int age;
	String lastName;
	String gender;
	String phone;
	String email;
	String country;
	String city;
	String industry;
	String experience;
	String education;
	
	public Customer() {
	}

	
	public Customer(int custId, String name, int age, String LastName, String Gender, String Phone, String email, String Country, String City, String Industry, String Experience, String Education) {
		this.custId = custId;
		this.name = name;
		this.age = age;
		this.lastName = LastName;
		this.gender = Gender;
		this.phone = Phone;
		this.email = email;
		this.country = Country;
		this.city = City;
		this.industry = Industry;
		this.experience = Experience;
		this.education = Education;
	}
	
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String Email) {
		email = Email;
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


	public String getIndustry() {
		return industry;
	}


	public void setIndustry(String industry) {
		this.industry = industry;
	}


	public String getExperience() {
		return experience;
	}


	public void setExperience(String experience) {
		this.experience = experience;
	}


	public String getEducation() {
		return education;
	}


	public void setEducation(String education) {
		this.education = education;
	}


	/*@Override
	public String toString() {
		return "Customer [age=" + age + ", custId=" + custId + ", name=" + name
				+ "]";
	}*/
	
	
}
