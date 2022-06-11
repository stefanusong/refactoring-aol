package after.models;


public class Borrowing {
	private int id;
	private User user;
	private Book book;
	private DateRange date;
	
	public Borrowing(int id, User user, Book book, DateRange date) {
		super();
		this.id = id;
		this.user = user;
		this.book = book;
		this.date = date;
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
	public void setUser(User user) {
		this.user = user;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public DateRange getDate() {
		return date;
	}
	public void setDate(DateRange date) {
		this.date = date;
	}
}
