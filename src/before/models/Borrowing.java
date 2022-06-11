package before.models;

import java.sql.Date;
import java.time.LocalDate;

public class Borrowing {
	private int id;
	private User user;
	private EBook eBook;
	private PhysicalBook physicalBook;
	private LocalDate startDate;
	private LocalDate endDate;
	
	public Borrowing(int id, User user, EBook eBook, PhysicalBook physicalBook, LocalDate startDate, LocalDate endDate) {
		super();
		this.id = id;
		this.user = user;
		this.eBook = eBook;
		this.physicalBook = physicalBook;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	//Getter setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setStudent(Student student) {
		this.user = student;
	}
	public EBook geteBook() {
		return eBook;
	}
	public void seteBook(EBook eBook) {
		this.eBook = eBook;
	}
	public PhysicalBook getPhysicalBook() {
		return physicalBook;
	}
	public void setPhysicalBook(PhysicalBook physicalBook) {
		this.physicalBook = physicalBook;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
}
