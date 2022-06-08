package before.models;

public class EBook {

	private int id;
	private String title;
	private String description;
	private int totalPages;
	private String authorName;
	private int authorAge;
	private String authorDescription;
	private String url;
	private String fileFormat;
	private float fileSize;

	public EBook() {
	}

	public EBook(int id, String title, String description, int totalPages, String authorName, int authorAge,
			String authorDescription, String url, String fileFormat, float fileSize) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.totalPages = totalPages;
		this.authorName = authorName;
		this.authorAge = authorAge;
		this.authorDescription = authorDescription;
		this.url = url;
		this.fileFormat = fileFormat;
		this.fileSize = fileSize;
	}

	public void download() {
		System.out.println("downloading...");
		System.out.println("downloaded");
		System.out.println();
	}
	
	public EBook createEbook(int id, String title, String description, int totalPages, String authorName, int authorAge,
			String authorDescription, String url, String fileFormat, float fileSize) {
		return new EBook(id, title, description, totalPages, authorName, authorAge,
				 authorDescription, url, fileFormat, fileSize);
	}
	
	public void getEBookDetails() {
		System.out.print(id + " \t");
		System.out.print(title + " \t");
		System.out.print(description + " \t");
		System.out.print(totalPages + " \t");
		System.out.print(authorName + " \t");
		System.out.print(authorAge + " \t");
		System.out.print(authorDescription + " \t");
		System.out.print(url + " \t");
		System.out.print(fileFormat + " \t");
		System.out.println(fileSize + " \t");
	}
	
	public void updateEBook(int id, String title, String description, int totalPages, String authorName, int authorAge,
			String authorDescription, String url, String fileFormat, float fileSize) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.totalPages = totalPages;
		this.authorName = authorName;
		this.authorAge = authorAge;
		this.authorDescription = authorDescription;
		this.url = url;
		this.fileFormat = fileFormat;
		this.fileSize = fileSize;
	}
	
	public void updateId(int id) {
		this.id = id;
	}
	
	public void updateTitle(String title) {
		this.title = title;
	}
	
	public void updateDescription(String description) {
		this.description = description;	
	}
	
	public void updateTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	
	public void updateAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	public void updateAuthorAge(int authorAge) {
		this.authorAge = authorAge;
	}
	
	public void updateAuthorDescription(String authorDescription) {
		this.authorDescription = authorDescription;
	}
	
	public void updateUrl(String url) {
		this.url = url;
	}
	
	public void updateFileFormat(String fileFormat) {
		this.fileFormat = fileFormat;
	}
	
	public void updateFileSize(float fileSize) {
		this.fileSize = fileSize;
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

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public int getAuthorAge() {
		return authorAge;
	}

	public void setAuthorAge(int authorAge) {
		this.authorAge = authorAge;
	}

	public String getAuthorDescription() {
		return authorDescription;
	}

	public void setAuthorDescription(String authorDescription) {
		this.authorDescription = authorDescription;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getFileFormat() {
		return fileFormat;
	}

	public void setFileFormat(String fileFormat) {
		this.fileFormat = fileFormat;
	}

	public float getFileSize() {
		return fileSize;
	}

	public void setFileSize(float fileSize) {
		this.fileSize = fileSize;
	}
}
