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
	
	public void updateAuthor(String authorName, int authorAge, String authorDescription) {
		this.authorName = authorName;
		this.authorAge = authorAge;
		this.authorDescription = authorDescription;
	}
	
	public void increaseStockBy(int amount) {
		//check if amount greater than 0
		if(amount >= 0) {
			this.stock += amount;			
		} else {
			System.out.println("Please check inputted amount");
		}
	}
	
	public void decreaseStockBy(int amount) {
		//check if amount greater than 0 and 
		//check if there is enough stock to be decreased by amount
		
		if((stock-amount) >= 0 && amount >= 0) {
			this.stock -= amount;			
		} else {
			System.out.println("Please check inputted amount");
		}
	}
	
	public void getPhysicalBookDetails() {
		System.out.printf("[%d]\n", id);
		System.out.println("> Title: " + title);
		System.out.println("> Description: " + description);
		System.out.println("> Total Pages: " + totalPages);
		System.out.println("> Author Name: " + authorName);
		System.out.println("> Author Age: " + authorAge);
		System.out.println("> Author Description: " + authorDescription);
		System.out.println("> Book Stock: " + stock);
		if (isHardCover == true) {
			System.out.println("> Book Cover: HARD");
		} else {
			System.out.println("> Book Cover: SOFT");
		}
		
		if (isColored == true) {
			System.out.println("> Book Color: Colorful");
		} else {
			System.out.println("> Book Color: Black n White");
		}
		
		System.out.println("> Book Condition: " + condition);
		System.out.println("===========\n");
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
	public boolean getIsHardCover() {
		return isHardCover;
	}
	public void setIsHardCover(boolean isHardCover) {
		this.isHardCover = isHardCover;
	}
	public boolean getIsColored() {
		return isColored;
	}
	public void setIsColored(boolean isColored) {
		this.isColored = isColored;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
}
