package after.models;

public class PhysicalBook extends Book{

	private int stock;
	private boolean isHardCover;
	private boolean isColored;
	private String condition;
	
	public PhysicalBook(int id, String title, String description, int totalPages, Author author, int stock,
			boolean isHardCover, boolean isColored, String condition) {
		super(id, title, description, totalPages, author);
		this.stock = stock;
		this.isHardCover = isHardCover;
		this.isColored = isColored;
		this.condition = condition;
	}

	public void increaseStockBy(int amount) {
		boolean positiveAmount = amount >= 0;
		
		if(positiveAmount) {
			this.stock += amount;			
		} else {
			System.out.println("Please check inputted amount");
		}
	}
	
	public void decreaseStockBy(int amount) {
		boolean stockNotNegative = (stock-amount) >= 0;
		boolean positiveAmount = amount >= 0;
		
		if(stockNotNegative && positiveAmount) {
			this.stock -= amount;			
		} else {
			System.out.println("Please check inputted amount");
		}
	}
	
	public void getBookDetails() {
		super.getBookDetails();
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
	
	public void updateBook(int id, String title, String description, int totalPages, String authorName, int authorAge,
			String authorDescription, int stock, boolean isHardCover, boolean isColored, String condition) {
		super.updateBook(id, title, description, totalPages, authorName, authorAge, authorDescription);
		this.stock = stock;
		this.isHardCover = isHardCover;
		this.isColored = isColored;
		this.condition = condition;
	}

	
	//setter getter
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
