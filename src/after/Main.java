package after;

import java.util.Scanner;
import java.util.Vector;

import after.Main;
import after.helpers.PasswordManager;
import after.models.*;

public class Main {
	Scanner sc = new Scanner(System.in);
	Vector<User> users = new Vector<>();
	
	public Main() {
		registerLibrarianManually();
		displayAuthMenu();
	}

	public static void main(String[] args) {
		new Main();
	}
	
	private void displayAuthMenu() {
		boolean exit = false;
		
		do {
			System.out.println("                 .__   .__ ___.                                  \r\n" + 
					"  ____           |  |  |__|\\_ |__ _______ _____  _______  ___.__.\r\n" + 
					"_/ __ \\   ______ |  |  |  | | __ \\\\_  __ \\\\__  \\ \\_  __ \\<   |  |\r\n" + 
					"\\  ___/  /_____/ |  |__|  | | \\_\\ \\|  | \\/ / __ \\_|  | \\/ \\___  |\r\n" + 
					" \\___  >         |____/|__| |___  /|__|   (____  /|__|    / ____|\r\n" + 
					"     \\/                         \\/             \\/         \\/     \r\n" + 
					"");
			
			System.out.println("1. Login");
			System.out.println("2. Register");
			System.out.println("3. Exit");
			System.out.print("> ");
			
			int choice = sc.nextInt();
			
			switch(choice) {
				case 1:
					displayLoginMenu();
					break;
				case 2:
					displayRegisterMenu();
					break;
				case 3:
					exit = true;
					break;
			}
		} while(!exit);
	}
	
	private void displayLoginMenu() {		
		boolean exit = false;
		
		do {
			System.out.println("Login");
			System.out.println("1. Login as student");
			System.out.println("2. Login as admin");
			System.out.println("3. Cancel");
			System.out.print("> ");
			int choice = sc.nextInt();
			
			if(choice == 3) {
				exit = true;
			} else {
				handleLogin(choice);
			}
			
		} while(!exit);
	}
	
	private void handleLogin(int loginType) {
		sc.nextLine();
		System.out.print("Enter username: ");
		String username = sc.nextLine();
		System.out.print("Enter password: ");
		String password = sc.nextLine();
		
		for (User user : users) {
			if(user.getUsername().equalsIgnoreCase(username) && isCorrectPassword(password, user.getPassword())) {
				switch (loginType) {
				case 1:
					displayStudentMenu(user);
					break;
				case 2:
					displayAdminMenu(user);
					break;
				default:
					break;
				}
			} else {
				System.out.println("user not found or invalid password");
			}
		}
		return;
	}
	
	private boolean isCorrectPassword(String plain, String hashed) {
		return PasswordManager.verifyPassword(plain, hashed);
	}
	
	private void displayRegisterMenu() {
		// ini nanti passwordnya di hash dulu yak kyk gini misalnya:
		String hashedPassword = PasswordManager.getSecurePassword("password");
	}
	
	private void displayAdminMenu(User user) {
		System.out.println(user.getGreetingMessage());
		boolean exit = false;
		
		do {
			System.out.println("Admin menu");
			System.out.println("3. Exit");
			System.out.print("> ");
			int choice = sc.nextInt();
			
			switch (choice) {
			case 3:
				exit = true;
				break;
			default:
				break;
			} 
			
		} while(!exit);
	}
	
	private void displayStudentMenu(User user) {
		System.out.println(user.getGreetingMessage());
		
		boolean exit = false;
		
		do {
			System.out.println("Student menu");
			System.out.println("3. Exit");
			System.out.print("> ");
			int choice = sc.nextInt();
			
			switch (choice) {
			case 3:
				exit = true;
				break;
			default:
				break;
			} 
			
		} while(!exit);
	}
	
	private void registerLibrarianManually() {
        String hashedPassword = PasswordManager.getSecurePassword("password");
        
		Librarian dummyAdmin = new Librarian(1, "Bambang", "male", "bambang", hashedPassword, "General", "08123612487", "Jakarta");
		users.add(dummyAdmin);
	}

}
