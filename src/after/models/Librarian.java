package after.models;

public class Librarian extends User {
	private String department;
	private String phone;
	private String branchName;
	
	public Librarian(int id, String name, String gender, String username, String password, String department, String phone, String branchName) {
		super(id, name, gender, username, password);
		this.department = department;
		this.phone = phone;
		this.branchName = branchName;
	}
	
	// Getters and Setters
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	
	@Override
	public String getGreetingMessage() {
		String prefix;
		switch(getGender()) {
			case "male":
				prefix = "Mr. ";
			case "female":
				prefix = "Ms. ";
			default:
				prefix = "";
		}
		
		return "Welcome, " + prefix + getName() 
				+ " what do you want to manage today ?"; 
	}
	
}

