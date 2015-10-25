package net.codejava.springmvc.model;

import java.sql.Timestamp;

public class Industry 
{
	
	int ID;
	String name;
	
	public Industry() {
		
	}

	public Industry(int ID, String Industry) {
		this.ID = ID;
		this.name = Industry;
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

	public void setName(String name) {
		this.name = name;
	}
	
}
