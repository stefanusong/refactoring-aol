package after.models;

public abstract class Book {
	private int id;
	private String title;
	private String description;
	private int totalPages;
	private Author author;
	
	public Book(int id, String title, String description, int totalPages, Author author) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.totalPages = totalPages;
		this.author = author;
	}

	public void getBookDetails() {
		System.out.printf("[%d]\n", id);
		System.out.println("> Title: " + title);
		System.out.println("> Description: " + description);
		System.out.println("> Total Pages: " + totalPages);
		System.out.println("> Author Name: " + getAuthor().getAuthorName());
		System.out.println("> Author Age: " + getAuthor().getAuthorAge());
		System.out.println("> Author Description: " + getAuthor().getAuthorDescription());
	}
	
	public void updateBook(int id, String title, String description, int totalPages, 
						String authorName, int authorAge, String authorDescription) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.totalPages = totalPages;
		this.setAuthor(new Author(authorName, authorAge, authorDescription));
	}

	//getter setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
}
