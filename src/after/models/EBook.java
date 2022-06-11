package after.models;

public class EBook extends Book{
	private String url;
	private String fileFormat;
	private float fileSize;

	public EBook(int id, String title, String description, int totalPages, Author author, String url, String fileFormat,
			float fileSize) {
		super(id, title, description, totalPages, author);
		this.url = url;
		this.fileFormat = fileFormat;
		this.fileSize = fileSize;
	}

	public void download() {
		System.out.println("downloading...");
		System.out.println("downloaded");
		System.out.println();
	}
	
	public void getBookDetails() {
		super.getBookDetails();
		System.out.println("> URL: " + url);
		System.out.println("> File Format: " + fileFormat);
		System.out.println("> File Size: " + fileSize + "mb");
		System.out.println("===========\n");
	}
	
	public void updateBook(int id, String title, String description, int totalPages, String authorName, int authorAge,
			String authorDescription, String url, String fileFormat, float fileSize) {
		super.updateBook(id, title, description, totalPages, authorName, authorAge, authorDescription);
		this.url = url;
		this.fileFormat = fileFormat;
		this.fileSize = fileSize;
	}

	//getter setter
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
