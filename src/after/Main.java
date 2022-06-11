package after;

import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import java.util.Vector;

import after.Main;
import after.helpers.PasswordManager;
import after.models.*;

public class Main {
	Scanner sc = new Scanner(System.in);
	Vector<User> users = new Vector<>();
	Vector<Book> books = new Vector<>();
	Vector<Borrowing> borrowings = new Vector<>();
	
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
		sc.nextLine();
		System.out.print("Enter full name: ");
		String name = sc.nextLine();
		System.out.print("Enter gender [Male|Female]: ");
		String gender = sc.nextLine();
		System.out.print("Enter faculty: ");
		String faculty = sc.nextLine();
		System.out.print("Enter study program: ");
		String sProgram = sc.nextLine();
		System.out.print("Enter your entry year: ");
		int entryYear = Integer.parseInt(sc.nextLine());
		System.out.print("Enter username: ");
		String username = sc.nextLine();
		System.out.print("Enter password: ");
		String password = sc.nextLine();
		String hashedPassword = PasswordManager.getSecurePassword(password);
		
		int id = users.size() + 1;
		
		Student newMember = new Student(id, name, gender, username, hashedPassword, faculty, sProgram, entryYear);
		users.add(newMember);
		
		return;
	}
	
	private void displayAdminMenu(User user) {
		System.out.println(user.getGreetingMessage());
		boolean exit = false;
		
		do {
			System.out.println("Admin menu");
			System.out.println("1. See all books");
			System.out.println("2. Add new book");
			System.out.println("3. Update a book");
			System.out.println("4. Delete a book");
			System.out.println("5. See all student currently borrowing");
			System.out.println("6. Logout");
			System.out.print("> ");
			int choice = sc.nextInt();
			
			switch (choice) {
			case 1:
				viewAllBook();
				break;
			case 2:
				insertBook();
				break;
			case 3:
				updateBook();
				break;
			case 4:
				deleteBook();
				break;
			case 5:
				viewAllBorrowing();
				break;
			case 6:
				exit = true;
				break;
			default:
				break;
			} 
			
		} while(!exit);
	}
	
	private void deleteBook() {
		viewAllBook();
		
		sc.nextLine();
		System.out.println("Delete");
		System.out.print("Enter the book ID: ");
		int ID = Integer.parseInt(sc.nextLine());
		
		int idDelete;
		
		for (Book book : books) {
			if (book.getId() == ID) {
				idDelete = books.indexOf(book);
				
				System.out.println("\nBook has been deleted");
				books.remove(idDelete);
				
				break;
			}
		}
		
		return;
	}
	
	private void updateBook() {
		viewAllBook();
		
		sc.nextLine();
		System.out.println("Update");
		System.out.print("Enter the book ID: ");
		int ID = Integer.parseInt(sc.nextLine());
		
		int idUpdate, totalPageUpdate, authAgeUpdate;
		String titleUpdate, descUpdate, authNameUpdate, authDescUpdate;
		
		for (Book book : books) {
			if (book instanceof EBook && book.getId() == ID) {
				idUpdate = books.indexOf(book);
				System.out.print("Enter title: ");
				titleUpdate = sc.nextLine();
				System.out.print("Enter description: ");
				descUpdate = sc.nextLine();
				System.out.print("Enter total pages: ");
				totalPageUpdate = Integer.parseInt(sc.nextLine());
				System.out.print("Enter author name: ");
				authNameUpdate = sc.nextLine();
				System.out.print("Enter author age: ");
				authAgeUpdate = Integer.parseInt(sc.nextLine());
				System.out.print("Enter author description: ");
				authDescUpdate = sc.nextLine();
				System.out.print("Enter the URL: ");
				String urlUpdate = sc.nextLine();
				System.out.print("Enter file format: ");
				String fileFormatUpdate = sc.nextLine();
				System.out.print("Enter file size: ");
				Float fileSizeUpdate = sc.nextFloat();
				
				System.out.println("\nBook has been updated");
				Book eBookUpdate = new EBook(ID, titleUpdate, descUpdate, totalPageUpdate, new Author(authNameUpdate, authAgeUpdate, authDescUpdate), urlUpdate, fileFormatUpdate, fileSizeUpdate);
				books.set(idUpdate, eBookUpdate);
				
				break;
			} else if (book instanceof PhysicalBook && book.getId() == ID) {
				idUpdate = books.indexOf(book);
				System.out.print("Enter title: ");
				titleUpdate = sc.nextLine();
				System.out.print("Enter description: ");
				descUpdate = sc.nextLine();
				System.out.print("Enter total pages: ");
				totalPageUpdate = Integer.parseInt(sc.nextLine());
				System.out.print("Enter author name: ");
				authNameUpdate = sc.nextLine();
				System.out.print("Enter author age: ");
				authAgeUpdate = Integer.parseInt(sc.nextLine());
				System.out.print("Enter author description: ");
				authDescUpdate = sc.nextLine();
				System.out.print("Enter book stock: ");
				int stockUpdate = Integer.parseInt(sc.nextLine());
				
				char answer;
				boolean isHardCoverUpdate, isColoredUpdate;
				System.out.print("Is this book hard covered? [Y|N]: ");
				answer = sc.next().charAt(0);
				if (answer == 'Y') {
					isHardCoverUpdate = true; 
				} else {
					isHardCoverUpdate = false;
				}
				System.out.print("Is this book colored? [Y|N]: ");
				answer = sc.next().charAt(0);
				if (answer == 'Y') {
					isColoredUpdate = true; 
				} else {
					isColoredUpdate = false;
				}
				
				sc.nextLine();
				System.out.print("Enter book condition: ");
				String bookConditionUpdate = sc.nextLine();
				
				System.out.println("\nBook has been updated");
				PhysicalBook physicalBookUpdate = new PhysicalBook(ID, titleUpdate, descUpdate, totalPageUpdate, new Author(authNameUpdate, authAgeUpdate, authDescUpdate), stockUpdate, isHardCoverUpdate, isColoredUpdate, bookConditionUpdate);
				books.set(idUpdate, physicalBookUpdate);
				
				break;
			}
		}
	}
	
	private void viewAllBook() {
		for (Book book : books) {
			if (book instanceof EBook) {
				System.out.println("All E-Books");
				System.out.println("===========");
				book.getBookDetails();
			} else if (book instanceof PhysicalBook) {
				System.out.println("\nAll Physical Books");
				System.out.println("===========");
				book.getBookDetails();
			}
		}
		
		return;
	}
	
	private void insertBook() {
		sc.nextLine();
		System.out.println("Choose book category");
		System.out.println("1. E-Book");
		System.out.println("2. Physical Book");
		System.out.println("3. Cancel");
		System.out.print("> ");
		int choice = sc.nextInt();
		
		switch (choice) {
		case 1:
			addEBook();
			
			break;
		case 2:
			addPhysicalBook();
			
			break;
		default:
			break;
		}
		
		return;
	}
	
	private void addPhysicalBook() {
		sc.nextLine();
		System.out.print("Enter the title: ");
		String title = sc.nextLine();
		System.out.print("Enter description: ");
		String description = sc.nextLine();
		System.out.print("Enter total pages: ");
		int pages = Integer.parseInt(sc.nextLine());
		System.out.print("Enter author name: ");
		String authorName = sc.nextLine();
		System.out.print("Enter author age: ");
		int authorAge = Integer.parseInt(sc.nextLine());
		System.out.print("Enter author description: ");
		String authorDesc = sc.nextLine();
		System.out.print("Enter stock: ");
		int stock = Integer.parseInt(sc.nextLine());
		
		char answer;
		boolean isHardCover, isColored;
		System.out.print("Is this book hard covered? [Y|N]: ");
		answer = sc.next().charAt(0);
		if (answer == 'Y') {
			isHardCover = true; 
		} else {
			isHardCover = false;
		}
		System.out.print("Is this book colored? [Y|N]: ");
		answer = sc.next().charAt(0);
		if (answer == 'Y') {
			isColored = true; 
		} else {
			isColored = false;
		}
		sc.nextLine();
		System.out.print("Enter book condition: ");
		String condition = sc.next();
		
		int ID = books.size() + 1;
		
		System.out.println("\nBook has been created!");
		PhysicalBook newPhysicalBook = new PhysicalBook(ID, title, description, pages, new Author(authorName, authorAge, authorDesc), stock, isHardCover, isColored, condition);
		books.add(newPhysicalBook);
	}
	
	private void addEBook() {
		sc.nextLine();
		System.out.print("Enter the title: ");
		String title = sc.nextLine();
		System.out.print("Enter description: ");
		String description = sc.nextLine();
		System.out.print("Enter total pages: ");
		int pages = Integer.parseInt(sc.nextLine());
		System.out.print("Enter author name: ");
		String authorName = sc.nextLine();
		System.out.print("Enter author age: ");
		int authorAge = Integer.parseInt(sc.nextLine());
		System.out.print("Enter author description: ");
		String authorDesc = sc.nextLine();
		System.out.print("Enter E-Book url: ");
		String url = sc.nextLine();
		System.out.print("Enter file format: ");
		String fileFormat = sc.nextLine();
		System.out.print("Enter file size [mb]: ");
		float fileSize = sc.nextFloat();
		
		int ID = books.size() + 1;
		
		System.out.println("\nBook has been created!\n");
		EBook newEBook = new EBook(ID, title, description, pages, new Author(authorName, authorAge, authorDesc), url, fileFormat, fileSize);
		books.add(newEBook);
		
		return;
	}
	
	private void displayStudentMenu(User user) {
		System.out.println(user.getGreetingMessage());
		
		boolean exit = false;
		
		do {
			System.out.println("Student menu");
			System.out.println("1. See all books");
			System.out.println("2. Borrow a book");
			System.out.println("3. See all student currently borrowing");
			System.out.println("4. Return a book");
			System.out.println("5. Logout");
			System.out.print("> ");
			int choice = sc.nextInt();
			
			switch (choice) {
			case 1:
				viewAllBook();
				break;
			case 2:
				borrowBook(user);
				break;
			case 3:
				viewAllBorrowing();
				break;
			case 4:
				returnBook(user);
				break;
			case 5:
				exit = true;
				break;
			default:
				break;
			} 
			
		} while(!exit);
	}
	
	private void returnBook(User user) {
		System.out.println("Your returning station");
		
		viewYourBorrowing(user);
		
		sc.nextLine();
		boolean noData = false;
		System.out.print("Enter the borrowing ID: ");
		int ID = Integer.parseInt(sc.nextLine());
		int idBorrowing;
		
		for (Borrowing borrowing : borrowings) {
			if (borrowing.getId() == ID) {
				idBorrowing = borrowings.indexOf(borrowing);
				
				if (borrowing.getBook() instanceof EBook) {
					System.out.println("Book has been returned");
				} else if (borrowing.getBook() instanceof PhysicalBook) {
					PhysicalBook physicalBook = (PhysicalBook)borrowing.getBook();
					
					physicalBook.increaseStockBy(1);
					System.out.println("Current stock: " + physicalBook.getStock());
				}
				
				borrowings.remove(idBorrowing);
				
				noData = false;
				break;
			}
			
			noData = true;
		}
		if (noData) {
			System.out.println("There's no data for this ID");
		}
	}
	
	private void viewYourBorrowing(User user) {
		for (Borrowing borrowing : borrowings) {
			if (borrowing.getUser() == user) {
				System.out.printf("[%d]. BOOK = %s | Student = %s\n", borrowing.getId(), borrowing.getBook().getTitle(), borrowing.getUser().getName());
			}
		}
	}
	
	private void viewAllBorrowing() {
		System.out.println("All borrowing students");
		for (Borrowing borrowing : borrowings) {
			long duration = ChronoUnit.DAYS.between(java.time.LocalDate.now(), borrowing.getDate().getEndDate());
			int howLong = (int)duration;
			
			System.out.printf("[%d]. BOOK = %s | Student = %s (%d days left)\n", borrowing.getId(), borrowing.getBook().getTitle(), borrowing.getUser().getName(), howLong);
		}
		System.out.println();
	}
	
	private void borrowBook(User user) {
		viewAllBook();
		
		sc.nextLine();
		System.out.println("Borrowing");
		System.out.print("Enter the book ID: ");
		int ID = Integer.parseInt(sc.nextLine());
		
		int idBorrowing;
		
		for (Book book : books) {
			if (book instanceof EBook && book.getId() == ID) {
				idBorrowing = borrowings.size() + 1;
				
				EBook eBook = (EBook)book;
				eBook.download();
				
				Borrowing borrowEB = new Borrowing(idBorrowing, user, book, new DateRange(java.time.LocalDate.now(), java.time.LocalDate.now().plusDays(14)));
				borrowings.add(borrowEB);
				break;
			} else if (book instanceof PhysicalBook && book.getId() == ID) {
				idBorrowing = borrowings.size() + 1;
				
				PhysicalBook physicalBook = (PhysicalBook)book;
				physicalBook.decreaseStockBy(1);
				
				Borrowing borrowP = new Borrowing(idBorrowing, user, book, new DateRange(java.time.LocalDate.now(), java.time.LocalDate.now().plusDays(14)));
				borrowings.add(borrowP);
				break;
			}
		}
	}
	
	private void registerLibrarianManually() {
        String hashedPassword = PasswordManager.getSecurePassword("password");
        
		Librarian dummyAdmin = new Librarian(1, "Bambang", "male", "bambang", hashedPassword, "General", "08123612487", "Jakarta");
		users.add(dummyAdmin);
	}

}
