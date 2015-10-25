package net.codejava.springmvc.model;

import java.sql.Timestamp;

public class User 
{
	int ID;
	String Password;
	String Email;
	String Name;
	String Access;
	
	public User() {
		
	}
	
	public User(int ID, String Name, String Password, String Email, String Access) {
		this.ID = ID;
		this.Name = Name;
		this.Password = Password;
		this.Email = Email;
		this.Access = Access;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getAccess() {
		return Access;
	}

	public void setAccess(String access) {
		Access = access;
	}

	
	

	//@Override
	/*public String toString() {
		return "Customer [age=" + age + ", custId=" + custId + ", name=" + name
				+ "]";
	}*/
	
	
}
