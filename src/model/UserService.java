package model;

public class UserService {

	private DataStore data;
	
//	Constructor
	public UserService(DataStore data) {
		this.data = data;
	}
	
//	Register
	public void register(String aadhar, String username, String password) {
		
		    boolean hasUpper = false;
      		boolean hasLower = false;
      		boolean hasDigit = false;
      		boolean hasSpecial = false;
      		
      		StringBuilder errorMsg = new StringBuilder();
		
//		Aadhar Validation
      		
		if(data.aadhar.containsKey(aadhar)) {
			System.out.println("User already exist!");
			return;
		}else {
			
//      		Password Validation
      		if(password.length() < 8) {
      			errorMsg.append("• Password must be at least 8 characters long\n");
      		}
      			
      		for(int i = 0; i < password.length(); i++) {
      			char ch = password.charAt(i);
      			
      			if(Character.isUpperCase(ch)) {
      				hasUpper = true;
      			}else if(Character.isLowerCase(ch)) {
      			    hasLower = true;
      			}else if(Character.isDigit(ch)) {
      				hasDigit = true;
      			}else if(!Character.isLetterOrDigit(ch)){
      				hasSpecial = true;
      			}	
      				
      		}
      		
//      		Check each condition and append message
      		if(!hasUpper) {
      			errorMsg.append("• Missing uppercase letter (A-Z)\n");
      		}
      		if(!hasLower) {
      			errorMsg.append("• Missing lowercase letter (a-z)\n");
      		}
      		if(!hasDigit) {
      			errorMsg.append("• Missing digit (0-9)\n");
      		}
      		if(!hasSpecial) {
      			errorMsg.append("• Missing special character (@, #, $, etc.)\n");
      		}
      		
//      	Final decision
      		if(errorMsg.length() == 0) {
      			data.aadhar.put(aadhar, username);
      			data.users.put(username, password);
      			System.out.println("Password is strong!");
      			System.out.println("Registration Successfull!");
      		}else {
      			System.out.println("Password is weak. Issues:");
      			System.out.println(errorMsg.toString());
      		}

		}
			
//		data.users.put(username, password);
		data.votedStatus.put(username, false);
	
}
	
//	Login
	public boolean login(String aadhar, String password) {
		
		if(!data.aadhar.containsKey(aadhar)){
			System.out.println("User not found!");
			return false;
		}
		
		if(!data.aadhar.get(aadhar).equals(password)) {
			System.out.println("Incorrect password!\n or Incorrect User Name!");
			return false;
		}
		
		System.out.println("Login successfull");
		return true;
	}
}
