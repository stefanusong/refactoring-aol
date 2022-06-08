package before.models;

public class UserInfo {
	private String name;
	private String gender;
	private String username;
	private String password;
	
	public UserInfo(String name, String gender, String username, String password) {
		this.name = name;
		this.gender = gender;
		this.username = username;
		this.password = password;
	}
	
	// Getters and Setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}

