package before.models;

public class PhysicalBook {

	private int id;
	private String title;
	private String description;
	private int totalPages;
	private String authorName;
	private int authorAge;
	private String authorDescription;
	private int stock;
	private boolean isHardCover;
	private boolean isColored;
	private String condition;
	
	public PhysicalBook() {
	}

	public PhysicalBook(int id, String title, String description, int totalPages, String authorName, int authorAge,
			String authorDescription, int stock, boolean isHardCover, boolean isColored, String condition) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.totalPages = totalPages;
		this.authorName = authorName;
		this.authorAge = authorAge;
		this.authorDescription = authorDescription;
		this.stock = stock;
		this.isHardCover = isHardCover;
		this.isColored = isColored;
		this.condition = condition;
	}
	
	public void increaseStockBy(int amount) {
		this.stock += amount;
	}
	
	public void decreaseStockBy(int amount) {
		this.stock -= amount;
	}
	
	public PhysicalBook createPhysicalBook(int id, String title, String description, int totalPages, String authorName, int authorAge,
			String authorDescription, int stock, boolean isHardCover, boolean isColored, String condition) {
		return new PhysicalBook(id, title, description, totalPages, authorName, authorAge,
			authorDescription, stock, isHardCover, isColored, condition);
	}
	
	public void getPhysicalBookDetails() {
		System.out.print(id + " \t");
		System.out.print(title + " \t");
		System.out.print(description + " \t");
		System.out.print(totalPages + " \t");
		System.out.print(authorName + " \t");
		System.out.print(authorAge + " \t");
		System.out.print(authorDescription + " \t");
		System.out.print(stock + " \t");
		System.out.print(isHardCover+ " \t");
		System.out.print(isColored + " \t");
		System.out.println(condition + " \t");
	}
	
	public void updatePhysicalBook(int id, String title, String description, int totalPages, String authorName, int authorAge,
			String authorDescription, int stock, boolean isHardCover, boolean isColored, String condition) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.totalPages = totalPages;
		this.authorName = authorName;
		this.authorAge = authorAge;
		this.authorDescription = authorDescription;
		this.stock = stock;
		this.isHardCover = isHardCover;
		this.isColored = isColored;
		this.condition = condition;
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
	
	public void updateIsHardCover(boolean isHardCover) {
		this.isHardCover = isHardCover;		
	}
	
	public void updateIsColored(boolean isColored) {
		this.isColored = isColored;
	}
	
	public void updateCondition(String condition) {
		this.condition = condition;
	}

	
	//setter getter
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

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public boolean isHardCover() {
		return isHardCover;
	}

	public void setHardCover(boolean isHardCover) {
		this.isHardCover = isHardCover;
	}

	public boolean isColored() {
		return isColored;
	}

	public void setColored(boolean isColored) {
		this.isColored = isColored;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}


}
