package net.codejava.springmvc;

public class Auth {

	public static void main(){
		
	}
	
	public boolean checkAuth(String Session){
		
		if(Session.equals("Authorized")){
			return true;
		} else {
			return false;
		}
			
	}
	
}
