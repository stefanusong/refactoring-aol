package after.models;

public class Author {
	private String authorName;
	private int authorAge;
	private String authorDescription;
	
	public Author(String authorName, int authorAge, String authorDescription) {
		this.authorName = authorName;
		this.authorAge = authorAge;
		this.authorDescription = authorDescription;
	}
	
	public void updateAuthor(String authorName, int authorAge, String authorDescription) {
		this.authorName = authorName;
		this.authorAge = authorAge;
		this.authorDescription = authorDescription;
	}
	
	//setter getter
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
}
