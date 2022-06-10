package before;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

import before.models.*;

public class Main {
	Scanner sc = new Scanner(System.in);
	Vector<User> users = new Vector<>();
	Vector<EBook> eBooks = new Vector<>();
	Vector<PhysicalBook> physicalBooks = new Vector<>();

	public Main() {
		boolean exit = false;
	
		
		registerLibrarianManually();
		
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
					do {
						System.out.println("Login");
						System.out.println("1. Login as student");
						System.out.println("2. Login as admin");
						System.out.println("3. Cancel");
						System.out.print("> ");
						choice = sc.nextInt();
						
						if(choice == 1 || choice == 2) {
							handleLogin(choice);
						} else {
							System.out.println();
						}
						
					} while(choice != 3);
					break;
				case 2:
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
					String hashedPassword = User.getSecurePassword(password);
					
					int id = users.size() + 1;
					
					Student newMember = new Student(id, new UserInfo(name, gender, username, hashedPassword), faculty, sProgram, entryYear);
					users.add(newMember);
					break;
				case 3:
					exit = true;
					break;
			}
		} while(!exit);
	}

	public static void main(String[] args) {
		new Main();
	}
	
	private void handleLogin(int loginType) {
		int choice;
		boolean noData = false;
		
		sc.nextLine();
		System.out.print("Enter username: ");
		String username = sc.nextLine();
		System.out.print("Enter password: ");
		String password = sc.nextLine();
		
		for (User user : users) {
			if(user.getUserInfo().getUsername().equalsIgnoreCase(username) && isCorrectPassword(password, user.getUserInfo().getPassword())) {
				noData = false;
				switch (loginType) {
				case 1:
					System.out.println(user.getGreetingMessage());
					
					do {
						System.out.println("Student menu");
						System.out.println("1. See all books");
						System.out.println("2. Borrow a book");
						System.out.println("3. See all student currently borrowing");
						System.out.println("4. Return a book");
						System.out.println("5. Logout");
						System.out.print("> ");
						choice = sc.nextInt();
						
						switch (choice) {
						case 1:
							System.out.println("All E-Books");
							System.out.println("===========");
							for (EBook eBook : eBooks) {
								System.out.printf("[%d]", eBook.getId());
								System.out.println("> Title: " + eBook.getTitle());
								System.out.println("> Description: " + eBook.getDescription());
								System.out.println("> Total Pages: " + eBook.getTotalPages());
								System.out.println("> Author Name: " + eBook.getAuthorName());
								System.out.println("> File Format: " + eBook.getFileFormat());
								System.out.println("> File Size: " + eBook.getFileSize());
								System.out.println("===========\n");
							}
							break;
						default:
							break;
						} 
						
					} while(choice != 5);
					break;
				case 2:
					System.out.println(user.getGreetingMessage());
					
					do {
						System.out.println("Admin menu");
						System.out.println("1. See all books");
						System.out.println("2. Add new book");
						System.out.println("3. Update a book");
						System.out.println("4. Delete a book");
						System.out.println("5. See all student currently borrowing");
						System.out.println("6. Logout");
						System.out.print("> ");
						choice = sc.nextInt();
						
						switch (choice) {
						case 1:
							System.out.println("All E-Books");
							System.out.println("===========");
							for (EBook eBook : eBooks) {
								System.out.printf("[%d]\n", eBook.getId());
								System.out.println("> Title: " + eBook.getTitle());
								System.out.println("> Description: " + eBook.getDescription());
								System.out.println("> Total Pages: " + eBook.getTotalPages());
								System.out.println("> Author Name: " + eBook.getAuthorName());
								System.out.println("> Author Age: " + eBook.getAuthorAge());
								System.out.println("> Author Description: " + eBook.getAuthorDescription());
								System.out.println("> URL: " + eBook.getUrl());
								System.out.println("> File Format: " + eBook.getFileFormat());
								System.out.println("> File Size: " + eBook.getFileSize() + "mb");
								System.out.println("===========\n");
							}
							
							System.out.println("\nAll Physical Books");
							System.out.println("===========");
							for (PhysicalBook physicalBook : physicalBooks) {
								System.out.printf("[%d]\n", physicalBook.getId());
								System.out.println("> Title: " + physicalBook.getTitle());
								System.out.println("> Description: " + physicalBook.getDescription());
								System.out.println("> Total Pages: " + physicalBook.getTotalPages());
								System.out.println("> Author Name: " + physicalBook.getAuthorName());
								System.out.println("> Author Age: " + physicalBook.getAuthorAge());
								System.out.println("> Author Description: " + physicalBook.getAuthorDescription());
								System.out.println("> Book Stock: " + physicalBook.getStock());
								
								if (physicalBook.getIsHardCover() == true) {
									System.out.println("> Book Cover: HARD");
								} else {
									System.out.println("> Book Cover: SOFT");
								}
								
								if (physicalBook.getIsColored() == true) {
									System.out.println("> Book Color: Colorful");
								} else {
									System.out.println("> Book Color: Black n White");
								}
								
								System.out.println("> Book Condition: " + physicalBook.getCondition());
								System.out.println("===========\n");
							}
							break;
						case 2:
							do {
								sc.nextLine();
								System.out.println("Choose book category");
								System.out.println("1. E-Book");
								System.out.println("2. Physical Book");
								System.out.println("3. Cancel");
								System.out.print("> ");
								choice = sc.nextInt();
								
								switch (choice) {
								case 1:
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
									
									int ID = eBooks.size() + physicalBooks.size() + 1;
									
									System.out.println("\nBook has been created!\n");
									EBook newEBook = new EBook(ID, title, description, pages, authorName, authorAge, authorDesc, url, fileFormat, fileSize);
									eBooks.add(newEBook);
									
									break;
								case 2:
									sc.nextLine();
									System.out.print("Enter the title: ");
									title = sc.nextLine();
									System.out.print("Enter description: ");
									description = sc.nextLine();
									System.out.print("Enter total pages: ");
									pages = Integer.parseInt(sc.nextLine());
									System.out.print("Enter author name: ");
									authorName = sc.nextLine();
									System.out.print("Enter author age: ");
									authorAge = Integer.parseInt(sc.nextLine());
									System.out.print("Enter author description: ");
									authorDesc = sc.nextLine();
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
									String condition = sc.nextLine();
									
									ID = eBooks.size() + physicalBooks.size() + 1;
									
									System.out.println("\nBook has been created!");
									PhysicalBook newPhysicalBook = new PhysicalBook(ID, title, description, pages, authorName, authorAge, authorDesc, stock, isHardCover, isColored, condition);
									physicalBooks.add(newPhysicalBook);
									break;
								default:
									break;
								}
							} while (choice != 3);
							break;
						case 3:
							System.out.println("All E-Books");
							System.out.println("===========");
							for (EBook eBook : eBooks) {
								System.out.printf("[%d]\n", eBook.getId());
								System.out.println("> Title: " + eBook.getTitle());
								System.out.println("> Description: " + eBook.getDescription());
								System.out.println("> Total Pages: " + eBook.getTotalPages());
								System.out.println("> Author Name: " + eBook.getAuthorName());
								System.out.println("> Author Age: " + eBook.getAuthorAge());
								System.out.println("> Author Description: " + eBook.getAuthorDescription());
								System.out.println("> URL: " + eBook.getUrl());
								System.out.println("> File Format: " + eBook.getFileFormat());
								System.out.println("> File Size: " + eBook.getFileSize() + "mb");
								System.out.println("===========\n");
							}
							
							System.out.println("\nAll Physical Books");
							System.out.println("===========");
							for (PhysicalBook physicalBook : physicalBooks) {
								System.out.printf("[%d]\n", physicalBook.getId());
								System.out.println("> Title: " + physicalBook.getTitle());
								System.out.println("> Description: " + physicalBook.getDescription());
								System.out.println("> Total Pages: " + physicalBook.getTotalPages());
								System.out.println("> Author Name: " + physicalBook.getAuthorName());
								System.out.println("> Author Age: " + physicalBook.getAuthorAge());
								System.out.println("> Author Description: " + physicalBook.getAuthorDescription());
								System.out.println("> Book Stock: " + physicalBook.getStock());
								
								if (physicalBook.getIsHardCover() == true) {
									System.out.println("> Book Cover: HARD");
								} else {
									System.out.println("> Book Cover: SOFT");
								}
								
								if (physicalBook.getIsColored() == true) {
									System.out.println("> Book Color: Colorful");
								} else {
									System.out.println("> Book Color: Black n White");
								}
								
								System.out.println("> Book Condition: " + physicalBook.getCondition());
								System.out.println("===========\n");
							}
							
							sc.nextLine();
							System.out.println("Update");
							System.out.print("Enter the book ID: ");
							int ID = Integer.parseInt(sc.nextLine());
							
							int idUpdate, totalPageUpdate, authAgeUpdate;
							String titleUpdate, descUpdate, authNameUpdate, authDescUpdate;
							
							boolean noEBook = false, noPhysical = false;
							for (EBook eBook : eBooks) {
								if (eBook.getId() == ID) {
									idUpdate = eBooks.indexOf(eBook);
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
									EBook updateEBook = new EBook(ID, titleUpdate, descUpdate, totalPageUpdate, authNameUpdate, authAgeUpdate, authDescUpdate, urlUpdate, fileFormatUpdate, fileSizeUpdate);
									eBooks.set(idUpdate, updateEBook);
									break;
								}
								
								noEBook = true;
							}
							for (PhysicalBook physicalBook : physicalBooks) {
								if (physicalBook.getId() == ID) {
									idUpdate = physicalBooks.indexOf(physicalBook);
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
									PhysicalBook physicalBookUpdate = new PhysicalBook(ID, titleUpdate, descUpdate, totalPageUpdate, authNameUpdate, authAgeUpdate, authDescUpdate, stockUpdate, isHardCoverUpdate, isColoredUpdate, bookConditionUpdate);
									physicalBooks.set(idUpdate, physicalBookUpdate);
									
									break;
								}
								
								noPhysical = true;
							}
							if (noEBook && noPhysical) {
								System.out.println("The ID you've mentioned doesn't exist");
							}
							break;
						case 4:
							System.out.println("Delete");
							break;
						default:
							break;
						} 
						
					} while(choice != 6);
					break;
				default:
					break;
				}
			} else {
				noData = true;
			}
		}
		if (noData) {
			System.out.println("user not found or invalid password");
		}
		
		return;
	}
	
	private boolean isCorrectPassword(String plain, String hashed) {
		return User.verifyPassword(plain, hashed);
	}
	
	private void registerLibrarianManually() {
        String hashedPassword = User.getSecurePassword("password");
        
		Librarian dummyAdmin = new Librarian(1, new UserInfo("Bambang", "male", "bambang", hashedPassword), "General", "08123612487", "Jakarta");
		users.add(dummyAdmin);
	}

}
