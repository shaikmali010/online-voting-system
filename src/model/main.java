package model;
import java.util.*;

	public class main {

	    public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);

	        DataStore store = new DataStore();
	        UserService userService = new UserService(store);
	        VotingService votingService = new VotingService(store);
	        int choice = 0;
	        int choice1 = 1;

	        while (true) {

	            System.out.println("\n===== ONLINE VOTING SYSTEM =====");
	            System.out.println("1. Register");
	            System.out.println("2. Login & Vote");
	            System.out.println("3. Show Results");
	            System.out.println("4. Exit");
	            System.out.print("Choose option: ");
	          choice = Integer.parseInt(sc.nextLine());
	            
	            switch (choice) {

	                case 1:
	                	
	                	System.out.println("Enter 12 digit Aadhar number: ");
	                    String regAadhar = sc.nextLine();
	                   
	                    if(regAadhar.matches("\\d{12}")) {
	                    	
	                    System.out.print("Enter username: ");
	                    String regUser = sc.nextLine();

	                    System.out.print("Enter password: ");
	                    String regPass = sc.nextLine();
	                   
	                    userService.register(regAadhar, regUser, regPass);
	                    }else {
	                    	System.out.println("Invalid! Must be exactly 12 digits.");
	                    
	                    }
	                    
	                    
	                    
	                    break;

	                case 2:
	                    System.out.print("Enter username: ");
	                    String logUser = sc.nextLine();

	                    System.out.print("Enter password: ");
	                    String logPass = sc.nextLine();

	                    if (userService.login(logUser, logPass)) {

	                        votingService.showCandidates();

	                        System.out.print("Enter candidate name: ");
	                        String candidate = sc.nextLine();

	                        votingService.vote(logUser, candidate);
	                    }
	                    break;

	                case 3:
	                    votingService.showResult();
	                    break;

	                case 4:
	                    System.out.println("Exiting...");
	                    sc.close();
	                    return;

	                   default:
	                    System.out.println("Invalid choice!");
	            }
	        }
	    }
	}

