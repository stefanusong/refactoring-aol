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
		System.out.print(id + " \t");
		System.out.print(title + " \t");
		System.out.print(description + " \t");
		System.out.print(totalPages + " \t");
		System.out.print(getAuthor().getAuthorName()+ " \t");
		System.out.print(getAuthor().getAuthorAge()+ " \t");
		System.out.print(getAuthor().getAuthorDescription()+ " \t");
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
