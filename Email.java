package emailApp;
import java.util.Scanner;

public class Email {

	// Variables
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private String alternateEmail;
	private String companySuffix = "hydra.gov";
	private int defaultPasswordLength = 10;
	private int mailboxCapacity = 500;
	
	// Input object
	Scanner input = new Scanner(System.in);
	
	// Constructor which takes in first and last name
	public Email(String first, String last) {
		this.firstName = first;
		this.lastName = last;
		System.out.println("Email created: " + this.firstName 
				+ " " + this.lastName);
		
		// Asks for the department 
		this.department = setDepartment();
		System.out.println("Department: " + this.department);
		
		// Password generation
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("Your password is: " + this.password);
		
		// Email generation
		this.email = firstName.toLowerCase() + "_" 
		+ this.lastName .toLowerCase() 
		+ "@" 
		+ this.department 
		+ "."
		+ this.companySuffix; 
		System.out.println(this.email);	
	}
	
	// Constructor (overload) which doesn't have parameters
	public Email() {
		setName();
		this.department = setDepartment();
		emailConstructor();
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("Your password is: " + this.password);
		System.out.println(showInfo());
	}
	
	// Sets first and last name
	public void setName() {
		System.out.print("Enter the user's first name: ");
		this.firstName = input.nextLine();
		System.out.print("Enter the user's last name: ");
		this.lastName = input.nextLine();
	}
		
	// Email generation
		public void emailConstructor() {
			this.email = firstName.toLowerCase() + "_" 
				+ this.lastName .toLowerCase() 
				+ "@" 
				+ this.department 
				+ "."
				+ this.companySuffix; 
			System.out.println(this.email);
		}
	
	// Department method
	private String setDepartment() {
		System.out.print("Department codes:"
				+ "\n  1 for Sales"
				+ "\n  2 for Gaming"
				+ "\n  3 for Accounting"
				+ "\n  0 for none"
				+ "\nEnter department code: ");
		int depChoice = input.nextInt();
		switch (depChoice) {
		case 1:	
			return "sales";
		case 2: 
			return "gaming";
		case 3: 
			return "accounting";
		default: 
			return "";
		}
	}
	
	// Password generator
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRS!@#$%";
		char[] password = new char[length];
		for (int i = 0; i < length; i++) {
			int rand = (int)(Math.random() * password.length);
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}
	
	// Sets mailbox capacity
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}
	
	// Sets alternative email
	public void setAlternativeEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}
	
	// Changes new password
	public void changePassword(String pass) {
		this.password = pass;
	}
	
	// Gets mailbox capacity
	public int getMailboxCapacity() {
		return mailboxCapacity;
	}
	
	// Gets alternate email
	public String getAlternateEmail() {
		return alternateEmail;
	}
	
	// Gets password
	public String getPassword() {
		return password;
	}
	
	public String showInfo() {
		return "DISPLAY NAME: " + firstName + " " + lastName 
				+ "\nDEPARTMENT: " + department
				+ "\nCOMPANY EMAIL: " + email 
				+ "\nMAILBOX CAPACITY: " + mailboxCapacity + "MB";
	}
}
